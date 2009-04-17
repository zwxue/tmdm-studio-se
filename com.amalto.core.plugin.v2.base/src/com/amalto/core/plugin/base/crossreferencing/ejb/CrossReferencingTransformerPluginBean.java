package com.amalto.core.plugin.base.crossreferencing.ejb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.naming.NamingException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.core.ejb.local.ItemCtrl2Local;
import com.amalto.core.objects.datacluster.ejb.DataClusterPOJOPK;
import com.amalto.core.objects.transformers.v2.ejb.TransformerPluginV2CtrlBean;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginContext;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginVariableDescriptor;
import com.amalto.core.objects.transformers.v2.util.TypedContent;
import com.amalto.core.plugin.base.crossreferencing.CompiledParameters;
import com.amalto.core.util.Util;
import com.amalto.core.util.XtentisException;
import com.amalto.xmlserver.interfaces.WhereAnd;
import com.amalto.xmlserver.interfaces.WhereCondition;

/**
 * @author bgrieder
 * 
 * @ejb.bean name="CrossReferencingTransformerPluginBean" 
 *           display-name="Name for CrossReferencingTransformerPluginBean"
 *           description="Description for CrossReferencingTransformerPluginBean"
 * 		  local-jndi-name = "amalto/local/transformer/plugin/crossreferencing"
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
public class CrossReferencingTransformerPluginBean extends TransformerPluginV2CtrlBean implements SessionBean {
	private static final long serialVersionUID = 62487085713480L;

    private transient boolean configurationLoaded = false;

    private static final String PARAMETERS = "com.amalto.core.plugin.crossreferencing.parameters";
	
    
	private static final String INPUT_XML = "xml";
	private static final String OUTPUT_TEXT = "text";
    
	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getJNDIName() throws XtentisException {	
		return "amalto/local/transformer/plugin/crossreferencing";
	}
	
	

    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getDescription(String twoLetterLanguageCode) throws XtentisException {
		if ("fr".matches(twoLetterLanguageCode.toLowerCase()))
			return "Transforme un XML en utilisant des règles de transcodifications";
		return "Transform an XML using crossreferencing rules";
	}

	
	
	/**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public ArrayList<TransformerPluginVariableDescriptor> getInputVariableDescriptors(String twoLettersLanguageCode) throws XtentisException {
		 ArrayList<TransformerPluginVariableDescriptor> inputDescriptors = new ArrayList<TransformerPluginVariableDescriptor>();
		 
		 //The document descriptor
		 TransformerPluginVariableDescriptor descriptor1 = new TransformerPluginVariableDescriptor();
		 descriptor1.setVariableName(INPUT_XML);
		 descriptor1.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text/xml")
						})
				)
		 );
		 HashMap<String, String> descriptions1 = new HashMap<String, String>();
		 descriptions1.put("en", "The item instance to transform");
		 descriptions1.put("fr", "Le document à transformer");
		 descriptor1.setDescriptions(descriptions1);
		 descriptor1.setMandatory(true);
		 descriptor1.setPossibleValuesRegex(null);
		 inputDescriptors.add(descriptor1);
	
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
		 descriptor.setVariableName(OUTPUT_TEXT);
		 descriptor.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text/.*")
						})
				)
		 );
		 HashMap<String, String> descriptions = new HashMap<String, String>();
		 descriptions.put("en", "The result of the xml transformation");
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
			org.apache.log4j.Logger.getLogger(this.getClass()).debug("init() ");
			
			if (!configurationLoaded) loadConfiguration();
			//fetech the parameters
			CompiledParameters parameters = CompiledParameters.deserialize(compiledParameters);
			

			//Insert all this in the context
			context.put( PARAMETERS, parameters);
		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			e.printStackTrace();
			String err = "Could not init the CrossReferencing Plugin: "+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).error("init() "+err);
			throw new XtentisException(err);
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
			//fetch data and parameters from context
			CompiledParameters parameters= (CompiledParameters)context.get( PARAMETERS);
			TypedContent xmlTC = (TypedContent)context.get(INPUT_XML);

			
			//get the charset
			String charset = Util.extractCharset(xmlTC.getContentType());

			//get the xml String 
			String xml = new String(xmlTC.getContentBytes(),charset);
			
			//TODO: make xref work for non XML
			String result="";
			
			
			try {
				Document xmlDoc = Util.parse(xml);
				Document xmlParameters = Util.parse(parameters.getParameters());
				
				NodeList rules = Util.getNodeList(xmlParameters.getDocumentElement(), "//CrossRef");
				
				for (int i =0; i< rules.getLength(); i++) {
	    			processMappings(xmlDoc, rules.item(i));					
				}
				
				result = Util.nodeToString(xmlDoc,false);
			} catch (Exception e) {
				throw new XtentisException("CrossReferencing plugin: "+e.getMessage());
			}

    		
        	//calback		
			if (org.apache.log4j.Logger.getLogger(this.getClass()).isDebugEnabled())
				org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() OUTPUT AFTER CROSSREF\n"+result);

        	
			//Call Back
			org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() Inserting CrossReferencing Result in "+OUTPUT_TEXT);
			byte[] bytes = result.getBytes("utf-8");
			context.put(
					OUTPUT_TEXT, 
					new TypedContent(
							bytes,
							"text/xml; charset=utf-8"
					)
			);
			
			context.getPluginCallBack().contentIsReady(context);
			
		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			e.printStackTrace();
			String err = "Could not start the CrossReferencing plugin: "+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).error("execute() "+err);
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
     * Process the mappings after xsl transformation
     * @param xrefElement
     */
    private void processMappings(Document xmlDoc, Node crossRef) throws XtentisException{
    	String xrefName = "";
    	try {
    		xrefName = Util.getFirstTextNode(crossRef,"./xrefName");
    		
    		String xrefcluster = Util.getFirstTextNode(crossRef,"./xrefCluster");
			
			String xrefRootElement = Util.getFirstTextNode(crossRef,"./xrefRootElement");
			
			NodeList xrefInMappings =  Util.getNodeList(crossRef,"./xrefIn/mapping");
			
			Vector<String> xrefElements = new Vector<String>();
			Vector<String> xrefPaths = new Vector<String>();
			
			for (int i =0; i < xrefInMappings.getLength(); i++) {
				Node mappingNode = xrefInMappings.item(i);
				
				String tmpXrefElement = Util.getFirstTextNode(mappingNode, "xrefElement");
				String tmpXrefPath = Util.getFirstTextNode(mappingNode, "xrefPath");
				xrefElements.add(tmpXrefElement);
				xrefPaths.add(tmpXrefPath);
			}
			
			String xrefOutElement =  Util.getFirstTextNode(crossRef,"./xrefOut/mapping/xrefElement");			
			
			String xrefOutPath =  Util.getFirstTextNode(crossRef,"./xrefOut/mapping/xrefPath");
			
			String xrefIgnoreS = Util.getFirstTextNode(crossRef,"./xrefIgnore");
			
			boolean xrefIgnore = false;
			if (xrefIgnoreS!=null && (xrefIgnoreS.equals("true") || xrefIgnoreS.equals("1")))
				xrefIgnore = true;
			
			String xrefDefault = Util.getFirstTextNode(crossRef,"./xrefDefault");
			
			
			NodeList rootNodes = null;
			if (xrefRootElement == null || "".equals(xrefRootElement))
				xrefRootElement = ".";
				
			rootNodes = Util.getNodeList(xmlDoc, xrefRootElement);

			for (int j=0; j < rootNodes.getLength(); j++) {

				
				HashMap<String,String> itemvals = new HashMap<String,String>();
				
				for (int k =0; k < xrefElements.size(); k++) {
					String xrefPath = xrefPaths.get(k); //Path dans la table de transco
					String xrefElement = xrefElements.get(k);//Path dans le doc
					String itemval = "";
					
					if (xrefElement.startsWith("["))  //hardcoded value
						itemval = xrefElement.substring(1, xrefElement.length()-1);
					else {
						//Check that the element to xref is unique in the source document
						NodeList xrefInNodes = Util.getNodeList(rootNodes.item(j), xrefElement);
						if (xrefInNodes.getLength()  > 1)
							throw new XtentisException("Ambiguous mapping with path "+xrefElement+" - returns "+xrefInNodes.getLength()+" elements.");
								
						if (xrefInNodes.getLength()  == 0) {
							org.apache.log4j.Logger.getLogger(this.getClass()).debug("processMappings() xrefInNodes.getLength() = "+xrefInNodes.getLength());
							break;
						}
							
						//Check that the XPath points to an Attribute or text node only, not a branch 
						Node resNode = xrefInNodes.item(0);
						if (resNode.getNodeType() == Node.ATTRIBUTE_NODE || resNode.getNodeType() == Node.TEXT_NODE)
							itemval = xrefInNodes.item(0).getNodeValue();
						else if (resNode.getNodeType() == Node.ELEMENT_NODE) {
							Node child = resNode.getFirstChild();
							if (child!=null && child.getNodeType() == Node.TEXT_NODE)
								itemval = child.getNodeValue();
							else if (child!=null)
								throw new XtentisException("Invalid xrefIn path "+xrefElement+" - xref path should correspond to attributes or text nodes only.");
							else
								itemval = "";
						} else
							throw new XtentisException("Invalid xrefIn path "+xrefElement+" - xref path should correspond to attributes or text nodes only.");
					}
					itemvals.put(xrefPath,itemval);
				}
					
				if (itemvals.size() == 0)
					break;
				
				//perform cross-ref
				String valeur = getCrossReferencedValue(itemvals, xrefcluster, xrefOutPath, xrefIgnore, xrefDefault);
				
				//check that the element to put the result into is unique
				NodeList xrefOutNodes = Util.getNodeList(rootNodes.item(j), xrefOutElement);
				if (xrefOutNodes.getLength()  > 1)
					throw new XtentisException("Ambigus mapping with path "+xrefOutPath+" - returns "+xrefOutNodes.getLength()+" elements.");
				
				if (xrefOutNodes.getLength()  == 0) {
					org.apache.log4j.Logger.getLogger(this.getClass()).debug("processMappings() xrefOutNodes.getLength() = "+xrefOutNodes.getLength());
					break;
				}
				
				Node xrefOutNode = xrefOutNodes.item(0);
				
				//check that the lement to put the value into is an attribute or a text node
				if (xrefOutNode.getNodeType() == Node.ATTRIBUTE_NODE || xrefOutNode.getNodeType() == Node.TEXT_NODE)
					xrefOutNode.setNodeValue(valeur);
				else if (xrefOutNode.getNodeType() == Node.ELEMENT_NODE) {
					Node child = xrefOutNode.getFirstChild();
					if (child!=null && child.getNodeType() == Node.TEXT_NODE)
						child.setNodeValue(valeur);
					else if (child!=null)
						throw new XtentisException("Invalid xrefOut path "+xrefOutElement+" - xref path should correspond to attributes or text nodes only.");
					else {
						xrefOutNode.appendChild(xmlDoc.createTextNode(valeur));
					}
				} else
					throw new XtentisException("Invalid xrefOut path "+xrefOutElement+" - xref path should correspond to attributes or text nodes only.");
					
			}
			

	    } catch (XtentisException e) {
	    	e.printStackTrace();
	    	throw(e);
    	} catch (Exception e) {
    		e.printStackTrace();
            //clean-up the wrapper
    	    String err = "Unable to process the mappings for the element \""+xrefName+"\""
    	    		+((e.getClass().equals(XtentisException.class))? "" : ": "+e.getClass().getName())
    	    		+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
    	    throw new XtentisException(err);
	    }
    }

    
    

    private String getCrossReferencedValue(HashMap<String,String> itemvals, String xrefcluster, String xrefOutPath, boolean xrefIgnore, String xrefDefault)  throws XtentisException{
    	org.apache.log4j.Logger.getLogger(this.getClass()).debug("getCrossReferencedValue() xrefcluster = "+ xrefcluster+" xrefOutPath = "+xrefOutPath+" xrefIgnore = "+xrefIgnore+" xrefDefault = "+xrefDefault);
		
    	WhereAnd wAnd = new WhereAnd();

        Collection<Map.Entry<String,String>> c = itemvals.entrySet();
        int h=0;
		for (Iterator<Map.Entry<String,String>> iter = c.iterator(); iter.hasNext(); ) {
			h++;
			Map.Entry<String,String> entry = iter.next();
			wAnd.add(new WhereCondition(
					entry.getKey(),
					WhereCondition.EQUALS,
					entry.getValue(),
					WhereCondition.PRE_NONE,
					false
			));
		}
		
		//Retrieve the Item Controller
		ItemCtrl2Local itemCtrl = null;
		try {
			itemCtrl = Util.getItemCtrl2Local();
		} catch (NamingException e) {
			String err = "Unable to get the cross referenced value for xrefcluster = "+ xrefcluster+" xrefOutPath = "+xrefOutPath+". Unable to find the Items controller: "+e.getMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).error(err,e);
			throw new XtentisException(err);
		} catch (CreateException e) {
			String err = "Unable to get the cross referenced value for xrefcluster = "+ xrefcluster+" xrefOutPath = "+xrefOutPath+". Unable to create the Items controller: "+e.getMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).error(err,e);
			throw new XtentisException(err);
		}
		
		ArrayList<String> resList = 
			itemCtrl.xPathsSearch(
				new DataClusterPOJOPK(xrefcluster), 
				null, 
				new ArrayList<String>(Arrays.asList(new String[]{xrefOutPath})), 
				wAnd, 
				-1, 	//spell
				0,		//start 
				1		//limit
		);
		
		String val = "";
		
        if ((resList==null)||(resList.size()==0)) {
        	if (xrefIgnore) {
        		if (xrefDefault!=null)
        			val = xrefDefault;
        		else
        			val = "";
        	} else {
	        	String ks = "";
		        c = itemvals.entrySet();
				for (Iterator<Map.Entry<String,String>> iter = c.iterator(); iter.hasNext(); ) {
					Map.Entry<String,String> entry = iter.next();
					ks+=" "+entry.getKey()+"=\""+entry.getValue()+"\"";
				}
	        	throw new XtentisException("Foreign keys values not found for: "+ks);
        	}
        } else {
        	//read result
           	Pattern p = Pattern.compile("<.*>(.*?)</.*>",Pattern.DOTALL);
			Matcher m = p.matcher(resList.iterator().next());
			if (m.matches())
				val = m.group(1);
			else
				throw new XtentisException("Result values were not understood for crossref element");
        }
        
        org.apache.log4j.Logger.getLogger(this.getClass()).debug("getCrossReferencedValue() xrefcluster = "+ xrefcluster+" xrefOutPath = "+xrefOutPath+" xrefIgnore = "+xrefIgnore+" xrefDefault = "+xrefDefault+" returns val = "+val);
		
        
        return val;
    }

    	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getParametersSchema() throws XtentisException {
		return null;

	}

	
    
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getDocumentation(String twoLettersLanguageCode) throws XtentisException {
		return
		"The CrossReferencing plugin transform xml content using cross referencing tables. " +
		"\n" +
		"\n" +
		"Parameters\n" +
		"	An xml file describing all cross referencing parameters"+"\n"+		
		"\n"+
		"\n"+
		"Example" +"\n"+
		"	<parameters>" +"\n"+
		"		<CrossRef>" +"\n"+
		"			<xrefName>myCrossRefName</xrefName>" +"\n"+
		"			<xrefCluster>b2box CROSSREFERENCING</xrefCluster>" +"\n" +
		"			<xrefRootElement>//PurchaseOrderLineItem</xrefRootElement>" +"\n" +
		"			<xrefIn>\n" +
		"				<mapping>\n" +
		"					<xrefElement>Quantity/Value/@UOM</xrefElement>\n" +
		"					<xrefPath>UnitOfMeasure/cXMLUnit</xrefPath>\n" +
		"				</mapping>\n" +
		"			</xrefIn>" +"\n" +
		"			<xrefOut>\n" +
		"				<mapping>\n" +
		"					<xrefElement>Quantity/Value/@UOM</xrefElement>\n" +
		"					<xrefPath>UnitOfMeasure/XBITSUnit</xrefPath>\n" +
		"				</mapping>\n" +
		"			</xrefIn>" +"\n" +
		"		</CrossRef>\n"+		
		"	</parameters>"+"\n"+
		"\n";
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
//    		Document d = Util.parse(configuration);
    		configurationLoaded = true;
    		return configuration;
        } catch (XtentisException e) {
    		throw (e);
	    } catch (Exception e) {
    	    String err = "Unable to deserialize the configuration of the CrossReferencing Transformer Plugin"
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
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
    	try {
    		
    		CompiledParameters compiled = new CompiledParameters();
    		
			
			setCompilationErrors("");

			compiled.setParameters(parameters);
			
    		return compiled.serialize();
    		
//    	} catch (XtentisException e) {
//    		throw(e);
	    } catch (Exception e) {
    	    String err = "Unable to serialize the parameters of the CrossReferencing Transformer Plugin"
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
    	    throw new XtentisException(err);
	    }	
	}


	private String compilationErrors = "";
	public String getCompilationErrors() {
		return compilationErrors;
	}
	public void setCompilationErrors(String compilationError) {
		this.compilationErrors = compilationError;
	}
	protected synchronized void add2CompilationErrors(String err) {
		compilationErrors+="\n"+err;
	}

}
