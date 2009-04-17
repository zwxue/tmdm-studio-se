package com.amalto.core.plugin.base.linereader.ejb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.ejb.SessionBean;

import org.w3c.dom.Element;

import com.amalto.core.objects.transformers.v2.ejb.TransformerPluginV2CtrlBean;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginContext;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginVariableDescriptor;
import com.amalto.core.objects.transformers.v2.util.TypedContent;
import com.amalto.core.util.Util;
import com.amalto.core.util.XtentisException;



/**
 * @author bgrieder
 * 
 * @ejb.bean name="LineReaderTransformerPlugin"
 *           display-name="Name for LineReaderPlugin"
 *           description="Description for LineReaderPlugin"
 * 		  local-jndi-name = "amalto/local/transformer/plugin/linereader"
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
public class LineReaderTransformerPluginBean extends TransformerPluginV2CtrlBean  implements SessionBean{
  
	public static final String PARAMETERS ="com.amalto.core.plugin.linereader.parameters";
	public static final String LINES_TO_IGNORE =  "com.amalto.core.plugin.linereader.linesToIgnore" ;
	public static final String IGNORE_BLANK_LINE =  "com.amalto.core.plugin.linereader.ignoreBlankLine" ;
	public static final String NUMLINES = "com.amalto.core.plugin.linereader.numLines" ;
	public static final String STOP = "com.amalto.core.plugin.linereader.stop";
	
	private static final long serialVersionUID = 1148709892480L;
	private static final String INPUT_CONTENT = "text_content";
	private static final String OUTPUT_LINE = "line";

    private transient boolean configurationLoaded = false;

	

	public LineReaderTransformerPluginBean() {
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
		return "amalto/local/transformer/plugin/linereader";
	}
	
	
	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getDescription(String twoLetterLanguageCode) throws XtentisException {
		if ("fr".matches(twoLetterLanguageCode.toLowerCase()))
			return "Lit un texte, ligne par ligne";
		return "Reads a text, line by line";
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
		 descriptor.setVariableName(INPUT_CONTENT);
		 descriptor.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text/.*")
						})
				)
		 );
		 HashMap<String, String> descriptions = new HashMap<String, String>();
		 descriptions.put("en", "The text content to read line by line");
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
		 descriptor.setVariableName(OUTPUT_LINE);
		 descriptor.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text/.*")
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
			
			//parse parameters
			Element params = Util.parse(compiledParameters).getDocumentElement();

			//attempt to read lines to ignore
			Integer linesToIgnore=new Integer(0);
			String temp = Util.getFirstTextNode(params, "ignoreFirstLines");
			if (temp!=null) linesToIgnore = new Integer(temp);
			Boolean ignoreBlankLine = Boolean.TRUE;
			temp = Util.getFirstTextNode(params, "ignoreBlankLine");
			if (temp!=null) ignoreBlankLine = Boolean.parseBoolean(temp);
			
			context.put( IGNORE_BLANK_LINE, ignoreBlankLine);
			context.put( PARAMETERS, params);
			context.put( LINES_TO_IGNORE, linesToIgnore);
		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			String err = "Could not init the Line Reader plugin:"+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Category.getInstance(this.getClass()).error("init() "+err);
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
		
			//Element params= (Element)context.get( PARAMETERS);
			TypedContent content = (TypedContent)context.get(INPUT_CONTENT);
			
			//read the charset
			String charset  = Util.extractCharset(content.getContentType());
						
			//Read from the stream and insert the bytes into the TypedContent when processing
			//If no stream is available, attempt to read the bytes
			BufferedReader br = new BufferedReader(new InputStreamReader(content.getContentStream(),charset));

			int linesToIgnore = ((Integer)context.get( LINES_TO_IGNORE)).intValue();
			boolean ignoreBlankLine =( (Boolean)context.get(IGNORE_BLANK_LINE)).booleanValue();
			String line = null;
			int i=0;
			int lines = 0;
			context.put( NUMLINES, lines);
			while (
					(context.get( STOP) == null)
					&& ((line = br.readLine())!=null))
			{
				if (++i>linesToIgnore) {
					if (!(ignoreBlankLine && "".equals(line.trim()))) {
						context.put( NUMLINES, ++lines);
						org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() Processing line "+lines+" - content \n"+line);
						byte[] bytes = line.getBytes("utf-8");
						//reinsert the bytes into the context - for use by subsequent plugins
						context.put(OUTPUT_LINE, new TypedContent(bytes,"text/plain; charset=utf-8"));
						//call the callback content is ready
						context.getPluginCallBack().contentIsReady(context);	
					}
				}
			}//while
			
			//cleanup
			br.close();

			
		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			String err = "Could not execute the Line Reader transformer plugin "+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Category.getInstance(this.getClass()).error("execute() "+err);
			throw new XtentisException(e);
		} 
	}
	

    
	
	
    
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getParametersSchema() throws XtentisException {
		return
		"<xsd:schema" +
		" 		elementFormDefault='unqualified'" +
		"		xmlns:xsd='http://www.w3.org/2001/XMLSchema'" +
		">" +
		"<xsd:element name='parameters'>" +
		"			<xsd:complexType >" +
		"				<xsd:sequence>" +
		"					<xsd:element minOccurs='0' maxOccurs='1' nillable='false' name='contentType' type='xsd:int'/>" +
		"					<xsd:element minOccurs='0' maxOccurs='1' nillable='false' name='charset' type='xsd:int'/>" +		
		"					<xsd:element minOccurs='0' maxOccurs='1' nillable='false' name='ignoreFirstLines' type='xsd:int'/>" +
		"				</xsd:sequence>" +
		"			</xsd:complexType>" +
		"</xsd:element>"+
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
		"The Line Reader plugin reads a text stream line by line. " +
		"Each line is sent after each other for further processing by subsequent plugins\n" +
		"\n" +
		"\n" +
		"Parameters\n" +
		"	ignoreFirstLines [optional]: will ignore the number of lines specified at the beginning of the text"+"\n"+
		"	ignoreBlankLine [optional]: will ignore the blank lines: true or false (default is true)"+"\n"+
		"\n"+
		"\n"+
		"Example" +"\n"+
		"	<parameters>" +"\n"+
		"		<ignoreFirstLines>4</ignoreFirstLines>" +"\n"+
		"	</parameters>"+"\n"+
		"\n"+
		"\n"+
		"Notes for Plugin Developers: " +"\n"+
		"	Context:" +"\n"+
		"		com.amalto.core.plugin.linereader.numlines: the number of lines processed"	;
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
    	    String err = "Unable to deserialize the configuration of the Line Reader Transformer Plugin"
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