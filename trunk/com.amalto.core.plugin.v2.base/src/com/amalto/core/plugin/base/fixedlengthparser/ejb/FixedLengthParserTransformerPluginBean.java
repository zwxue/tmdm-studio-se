package com.amalto.core.plugin.base.fixedlengthparser.ejb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.SessionBean;

import org.apache.commons.lang.StringEscapeUtils;

import com.amalto.core.objects.transformers.v2.ejb.TransformerPluginV2CtrlBean;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginContext;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginVariableDescriptor;
import com.amalto.core.objects.transformers.v2.util.TypedContent;
import com.amalto.core.util.Util;
import com.amalto.core.util.XtentisException;



/**
 * @author bgrieder
 * 
 * @ejb.bean name="FixedLengthParserTransformerPlugin"
 *           display-name="Name for FixedLengthParserPlugin"
 *           description="Description for FixedLengthParserPlugin"
 * 		  local-jndi-name = "amalto/local/transformer/plugin/fixedlengthparser"
 *           type="Stateless"
 *           view-type="local"
 *           local-business-interface="com.amalto.core.objects.transformers.v2.util.TransformerPluginV2LocalInterface"
 * 
 * @ejb.remote-facade
 * 
 * @ejb.permission
 * 	view-type = "remote"
 * 	role-name = "administration"
 * @ejb.permission
 * 	view-type = "local"
 * 	unchecked = "true"
 * 
 * 
 * 
 */
public class FixedLengthParserTransformerPluginBean extends TransformerPluginV2CtrlBean  implements SessionBean{
  
	public static final String PARAMETERS ="com.amalto.core.plugin.fixedlengthparser.parameters";
	
	private static final long serialVersionUID = 1148709892480L;
	
	private final static Pattern templatePattern = Pattern.compile("(.*?<template>)(.*)(</template>.*)",Pattern.DOTALL);
	private final static String INPUT_LINE = "line";
	private final static String OUTPUT_XML = "xml";
	
    private transient boolean configurationLoaded = false;
    

	public FixedLengthParserTransformerPluginBean() {
		super();
		try {
			getConfiguration(null);
		} catch (Exception e) {}
	}


	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getJNDIName() throws XtentisException {
		return "amalto/local/transformer/plugin/fixedlengthparser";
	}
	
	
	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getDescription(String twoLetterLanguageCode) throws XtentisException {
		if ("fr".matches(twoLetterLanguageCode.toLowerCase()))
			return "Découpe une ligne de texte avec des champs de longueur fixe";
		return "Parses a text line with fixed length fields";
	}

	
	
	/**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public ArrayList<TransformerPluginVariableDescriptor> getInputVariableDescriptors(String twoLettersLanguageCode) throws XtentisException {
		 ArrayList<TransformerPluginVariableDescriptor> inputDescriptors = new ArrayList<TransformerPluginVariableDescriptor>();
		 
		 //The csv_line descriptor
		 TransformerPluginVariableDescriptor descriptor = new TransformerPluginVariableDescriptor();
		 descriptor.setVariableName(INPUT_LINE);
		 descriptor.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text/plain")
						})
				)
		 );
		 HashMap<String, String> descriptions = new HashMap<String, String>();
		 descriptions.put("en", "The csv line to parse");
		 descriptor.setDescriptions(descriptions);
		 descriptor.setMandatory(true);
		 descriptor.setPossibleValuesRegex(null);
		 inputDescriptors.add(descriptor);
		 
		 return inputDescriptors;
	}


	
	/**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public ArrayList<TransformerPluginVariableDescriptor> getOutputVariableDescriptors(String twoLettersLanguageCode) throws XtentisException {
		ArrayList<TransformerPluginVariableDescriptor> outputDescriptors = new ArrayList<TransformerPluginVariableDescriptor>();
		 
		 //The csv_line descriptor
		 TransformerPluginVariableDescriptor descriptor = new TransformerPluginVariableDescriptor();
		 descriptor.setVariableName(OUTPUT_XML);
		 descriptor.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text/xml")
						})
				)
		 );
		 HashMap<String, String> descriptions = new HashMap<String, String>();
		 descriptions.put("en", "The xmlized csv line");
		 descriptor.setDescriptions(descriptions);
		 descriptor.setMandatory(true);
		 descriptor.setPossibleValuesRegex(null);
		 outputDescriptors.add(descriptor);
		 
		 return outputDescriptors;
	}
	
	
	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public void init(
			TransformerPluginContext context, 
			String compiledParameters
			) throws XtentisException {
		try {
			
			if (!configurationLoaded) loadConfiguration();				
			context.put(PARAMETERS, compiledParameters);

		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			String err = "Could not init the Fixed Length Parser plugin:"+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Category.getInstance(this.getClass()).error("start() "+err);
			throw new XtentisException(e);
		} 
		
	}

	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public void execute(TransformerPluginContext context) throws XtentisException {
		org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() ");
		
		try {			
			String  parameters = (String)context.get(PARAMETERS);
			TypedContent content = (TypedContent)context.get(INPUT_LINE);
			String charset = Util.extractCharset(content.getContentType());

			//read the bytes from Bytes in priority, 
			//If non available, attempt to read from the stream and insert the bytes into the TypedContent
			String record =  new String(content.getContentBytes(),charset);
			if (record == null) {
				String err = "Could not initialize the XPath Plugin: there is no available content to process. ";
				org.apache.log4j.Category.getInstance(this.getClass()).error("init() "+err);
				throw new XtentisException(err);
			}
		
			//extract template
			String template = null;
			Matcher m = templatePattern.matcher(parameters);
			if (m.matches()) {
				template = m.group(2);
			} else {
				throw new XtentisException("Fixed Length Parser: the template cannot be found :\n"+parameters);
			}	
			
			Pattern p = Pattern.compile("[^\\\\]\\{(\\d+,\\d+[,.*?]?)\\}");
			String xml="";
			int lastEnd = 0;
			m = p.matcher(template);
			while (m.find(lastEnd ==0 ? 0 : lastEnd -1)) {
				//parse the specs
				ArrayList<String> specs= new ArrayList<String>(Arrays.asList(m.group(1).split(",")));
				int offset = (new Integer(specs.get(0))).intValue();
				int length = (new Integer(specs.get(1))).intValue();
				//check that we can find data
				if (record.length()<offset+length) {
					String err = 	"Field at position "+offset+"," +length+" is outside of record position. "+
					"Record is: "+record;
					org.apache.log4j.Category.getInstance(this.getClass()).error("start() "+err);
					throw new XtentisException(err);
				}
				//read the data from the input stream			
				String s = record.substring(offset-1,offset+length-1);
				if (specs.contains("trim")) s = s.trim();
				//build the xml
				xml += template.substring(lastEnd, m.start()+1);
				lastEnd= m.end();
				xml+=StringEscapeUtils.escapeXml(s);
			}
			xml+=template.substring(lastEnd);
						
			//Replace the escaped  accolades by normal accolades
			xml = xml.replaceAll("\\\\{", "{");

			org.apache.log4j.Logger.getLogger(this.getClass()).debug("start() XML pushed back by Fixed Length Parser: "+xml);
			byte[] bytes = xml.getBytes("utf-8");
			context.put(OUTPUT_XML, new TypedContent(bytes,"text/xml; charset=utf-8"));
			context.getPluginCallBack().contentIsReady(context);
			
			
		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			String err = "Could not start the Fixed Length Parser transformer plugin"+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Category.getInstance(this.getClass()).error("start() "+err);
			throw new XtentisException(e);
		} 
	}
	
    
    
	/**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public void end(TransformerPluginContext context) throws XtentisException {
    	context.removeAll();
	}

    
    	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getParametersSchema() throws XtentisException {
		return
		"<xsd:schema" +"\n"+
		" 		elementFormDefault='unqualified'" +"\n"+
		"		xmlns:xsd='http://www.w3.org/2001/XMLSchema'" +"\n"+
		">" +"\n"+
		"<xsd:element name='parameters'>" +"\n"+
		"			<xsd:complexType >" +"\n"+
		"				<xsd:sequence>" +"\n"+
		"					<xsd:element minOccurs='1' maxOccurs='1' nillable='false' name='rootElementName' type='xsd:String'/>" +"\n"+
		"					<xsd:element minOccurs='1' maxOccurs='unbounded' nillable='false' name='field' >" +"\n"+
		"						<xsd:complexType >" +"\n"+
		"							<xsd:sequence>" +"\n"+
		"								<xsd:element minOccurs='1' maxOccurs='1' nillable='false' name='xmlName' type='xsd:string'/>" +"\n"+
		"								<xsd:element minOccurs='1' maxOccurs='1' nillable='false' name='length' type='xsd:int'/>" +"\n"+
		"								<xsd:element minOccurs='0' maxOccurs='1' nillable='false' name='trim' type='xsd:boolean'/>" +"\n"+
		"							</xsd:sequence>" +"\n"+
		"						</xsd:complexType>" +"\n"+
		"					</xsd:element>"+"\n"+
		"					<xsd:element minOccurs='0' maxOccurs='1' nillable='false' name='contentType' type='xsd:int'/>" +"\n"+
		"					<xsd:element minOccurs='0' maxOccurs='1' nillable='false' name='charset' type='xsd:int'/>" +"\n"+
		"				</xsd:sequence>" +"\n"+
		"			</xsd:complexType>" +"\n"+
		"</xsd:element>"+"\n"+
		"</xsd:schema>";
	}

	
    
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getDocumentation(String twoLettersLanguageCode) throws XtentisException {
		return
		"The fixed length parser will parse a fixed length fields text and generate a new text with the extracted values" +"\n"+
		"\n"+
		"The plugin will replace the extraction sequences {offset,length) specified in the template with the correspondig character sequences in the orginal text" +"\n"+
		"The first character of the text starts at position 1 (e.g. offset = 1)"+"\n"+
		"To avoid interpretation of an accolade, backslash it: \\{"+"\n"+
		"\n"+
		"\n"+
		"Parameters\n" +
		"	template: the new text containing the extraction sequences"+
		"\n"+
		"\n"+
		"Example - this will generate an xml starting with element MyXml\n" +
		"	<parameters>" +"\n"+
		"		<template>" +"\n"+
		"			<MyXml>" +"\n"+
		"					<Field1>{3,10}</Field1> <!-- characters 3 to 12 included of the input text -->" +"\n"+
		"					<Combo>{15,2}--{17,2}</Combo>" +"\n"+
		"					<NotInterpreted>\\{20,1}</NotInterpreted>" +"\n"+		
		"			</MyXml>" +"\n"+
		"		</template>" +"\n"+
		"	</parameters>" +"\n"+
		"";	
	}


	private String getDefaultConfiguration(){
    	return
    		"<configuration>"+
    		"	<charset>utf-8</charset>"+
			"</configuration>";
    }
    


	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
    public String getConfiguration(String optionalParameters) throws XtentisException{
    	try {
    		String configuration = loadConfiguration();
    		if (configuration == null) {
    			configuration = getDefaultConfiguration();
    		}
    		configurationLoaded = true;
    		return configuration;
        } catch (XtentisException e) {
    		throw (e);
	    } catch (Exception e) {
    	    String err = "Unable to deserialize the configuration of the Fixed Length Parser Transformer Plugin"
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Category.getInstance(this.getClass()).error(err);
    	    throw new XtentisException(err);
	    }	
    }



	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public void putConfiguration(String configuration) throws XtentisException {
		configurationLoaded = false;
		super.putConfiguration(configuration);
	}

	
	/********************************************************************************************
	 * Compilation - decompilation of parameters
	 ********************************************************************************************/
	
	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String compileParameters(String parameters) throws XtentisException {
		return parameters;
	}



    
	
	
	
	
}