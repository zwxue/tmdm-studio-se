package com.amalto.core.plugin.base.partialupdate.ejb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.naming.NamingException;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.amalto.core.ejb.ItemPOJO;
import com.amalto.core.ejb.ItemPOJOPK;
import com.amalto.core.objects.datacluster.ejb.DataClusterPOJOPK;
import com.amalto.core.objects.datamodel.ejb.DataModelPOJO;
import com.amalto.core.objects.datamodel.ejb.DataModelPOJOPK;
import com.amalto.core.objects.transformers.v2.ejb.TransformerPluginV2CtrlBean;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginContext;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginVariableDescriptor;
import com.amalto.core.objects.transformers.v2.util.TypedContent;
import com.amalto.core.objects.transformers.v2.util.TypedContent_Use_Default;
import com.amalto.core.plugin.base.partialupdate.CompiledParameters;
import com.amalto.core.util.Util;
import com.amalto.core.util.XSDKey;
import com.amalto.core.util.XtentisException;



/**
 * @author bgrieder
 * 
 * @ejb.bean name="PartialUpdateTransformerPlugin"
 *          display-name="Name for PartialUpdatePlugin"
 *          description="Description for PartialUpdatePlugin"
 *			local-jndi-name = "amalto/local/transformer/plugin/partialupdate"
 *          type="Stateless"
 *          view-type="local"
 *          local-business-interface="com.amalto.core.objects.transformers.v2.util.TransformerPluginV2LocalInterface"
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
public class PartialUpdateTransformerPluginBean extends TransformerPluginV2CtrlBean  implements SessionBean{
  
//	private final static Pattern declarationPattern = Pattern.compile("<\\?.*?\\?>",Pattern.DOTALL);
	
	private static final String PARAMETERS ="com.amalto.core.plugin.partialUpdate.parameters";
	private static final String DATA_CLUSTER_PK ="com.amalto.core.plugin.partialUpdate.dataClusterPOJOPK";
	private static final String DATA_MODEL_POJO_CACHE ="com.amalto.core.plugin.partialUpdate.dataModelPJOCache";
	private static final String DATA_MODEL_XSD_CACHE ="com.amalto.core.plugin.partialUpdate.dataModelXSDCache";
	
	private static final long serialVersionUID = 1L;
	
	private static final String INPUT_XML = "xml_instance";
	private static final String OUTPUT_PK = "item_primary_key";
	private static final String INPUT_PK = "item_primary_key";
	private static final String INPUT_DATA_MODEL = "data_model";
	private static final String INPUT_CLEAR_MODEL_CACHE = "clear_cache";
//	private static final String INPUT_PIVOT = "pivot";
//	private static final String INPUT_KEY_PATH_FROM_PIVOT = "key_xPath";

    private transient boolean configurationLoaded = false;

	

	public PartialUpdateTransformerPluginBean() {
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
		return "amalto/local/transformer/plugin/partialupdate";
	}
	
	
	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getDescription(String twoLetterLanguageCode) throws XtentisException {
		if ("fr".matches(twoLetterLanguageCode.toLowerCase()))
			return "Mis à jour partielle d'un aricle existant";
		return "Partial update of an existing item";
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
		 descriptions1.put("en", "The item instance to partialUpdate");
		 descriptor1.setDescriptions(descriptions1);
		 descriptor1.setMandatory(true);
		 descriptor1.setPossibleValuesRegex(null);
		 inputDescriptors.add(descriptor1);
		 
		 TransformerPluginVariableDescriptor descriptor2 = new TransformerPluginVariableDescriptor();
		 descriptor2.setVariableName(INPUT_PK);
		 descriptor2.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("application/xtentis.itempk")
						})
				)
		 );
		 HashMap<String, String> descriptions2 = new HashMap<String, String>();
		 descriptions2.put("en", "The item instance primary key. Non Mandatory but speeds up partialUpdateion if supplied and avoid having to supply the Data Cluster in The Parameters");
		 descriptor2.setDescriptions(descriptions2);
		 descriptor2.setMandatory(false);
		 descriptor2.setPossibleValuesRegex(null);
		 inputDescriptors.add(descriptor2);

		 TransformerPluginVariableDescriptor descriptor3 = new TransformerPluginVariableDescriptor();
		 descriptor3.setVariableName(INPUT_DATA_MODEL);
		 descriptor3.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text/plain")
						})
				)
		 );
		 HashMap<String, String> descriptions3 = new HashMap<String, String>();
		 descriptions3.put("en", "The Data Model name. Not mandatory. If not specified, the Data Model used will be the one supplied in the parameters");
		 descriptor3.setDescriptions(descriptions3);
		 descriptor3.setMandatory(false);
		 descriptor3.setPossibleValuesRegex(null);
		 inputDescriptors.add(descriptor3);

		 TransformerPluginVariableDescriptor descriptor4 = new TransformerPluginVariableDescriptor();
		 descriptor4.setVariableName(INPUT_CLEAR_MODEL_CACHE);
		 descriptor4.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text/plain")
						})
				)
		 );
		 HashMap<String, String> descriptions4 = new HashMap<String, String>();
		 descriptions4.put("en", "Clears the cache on loops ('true' or 'false'). Make it 'true' if the Data Model may change during its process");
		 descriptor4.setDescriptions(descriptions4);
		 descriptor4.setMandatory(false);
		 descriptor4.setPossibleValuesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("true"),
								 Pattern.compile("false")
						})
				)
		);
		 inputDescriptors.add(descriptor4);

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
		 descriptor.setVariableName(OUTPUT_PK);
		 descriptor.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("application/xtentis.itempk")
						})
				)
		 );
		 HashMap<String, String> descriptions = new HashMap<String, String>();
		 descriptions.put("en", "The partialUpdated item PK");
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
			CompiledParameters parameters = CompiledParameters.deserialize(compiledParameters);
			context.put( PARAMETERS, parameters);
			clearCaches(context);

		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			String err = "Could not init the PartialUpdate plugin:"+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
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
			
			CompiledParameters parameters= (CompiledParameters)context.get( PARAMETERS);
			TypedContent xmlTC = (TypedContent)context.get(INPUT_XML);
			TypedContent inputPKTC = (TypedContent)context.get(INPUT_PK);
			TypedContent dataModelTC = (TypedContent) context.get(INPUT_DATA_MODEL);
			TypedContent clearCacheTC = (TypedContent) context.get(INPUT_CLEAR_MODEL_CACHE);
			
			String charset =  Util.extractCharset(xmlTC.getContentType());
			
			String xml = new String(xmlTC.getContentBytes(),charset);
			
			//org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() input xml \n"+xml);
			
			boolean clearCache =! (
						(clearCacheTC instanceof TypedContent_Use_Default) || 
						"false".equals(new String(clearCacheTC.getContentBytes(),"UTF8"))
						);
			if (clearCache) clearCaches(context);
			
			String dataModelName = null;
			if (dataModelTC instanceof TypedContent_Use_Default) {
				//fetch the DataModel Name from the parameters
				dataModelName = parameters.getDataModel();
				if (dataModelName == null) {
					String err = "Transformer step "+context.getPluginNumber()+" PartialUpdate: the Data Model name must be provided in the parameters when no Data Model name is provided during runtime";
					org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
					throw new XtentisException(err);
				}
			} else {
				dataModelName = new String(dataModelTC.getContentBytes(),"UTF8"); 
			}
				
//			get the Data Model POJO from the cache
			DataModelPOJO dataModelPOJO = getDataModelPOJO(context, dataModelName);
			
			 //Get the item as an Element
			 Element partialUpdateItem= Util.parse(xml).getDocumentElement();
			 
			//Determine the item Key
			ItemPOJOPK pk = null;
			if (! (inputPKTC instanceof TypedContent_Use_Default)) {
				pk = ItemPOJOPK.unmarshal(new String(inputPKTC.getContentBytes(),"UTF8"));
			} else {
				//fetch default Data Cluster in parameters
				DataClusterPOJOPK dataClusterPOJOPK = (DataClusterPOJOPK)context.get(DATA_CLUSTER_PK);
				if (dataClusterPOJOPK == null) {
					if (parameters.getDataCluster() == null) {
						String err = "Transformer step "+context.getPluginNumber()+" PartialUpdate: the Data Cluster must be provided in the parameters when no Item Key is provided during runtime";
						org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
						throw new XtentisException(err);
					}
					dataClusterPOJOPK = new DataClusterPOJOPK(parameters.getDataCluster());
					context.put(DATA_CLUSTER_PK, dataClusterPOJOPK);
				}
				pk = Util.getItemPOJOPK(
						dataClusterPOJOPK, 
						partialUpdateItem, 
						getDataModelXSD(context, dataModelPOJO)
				);
			}
					
			//retrieve the original Item
			ItemPOJO originalItemPOJO = getItemCtrl2Local().existsItem(pk);
			if (originalItemPOJO==null) {
				String err = "The orginal item "+pk.getUniqueID()+" was not found in the cluster";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
			}

			//Parse original Item
			Element originalItem = originalItemPOJO.getProjection();
			
			//Get a list of partialUdateItems
			NodeList partialUpdateElementsList = Util.getNodeList(partialUpdateItem.getOwnerDocument(), parameters.getParentPivotPath()+"/"+parameters.getPivotLeaf());
			if ((partialUpdateElementsList == null) || (partialUpdateElementsList.getLength()==0)) {
				//nothing to do --> return
				org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() No partial Updates found for item "+pk.getUniqueID()+"  -- path: "+parameters.getParentPivotPath()+"/"+parameters.getPivotLeaf());
				//save result to context
				context.put(OUTPUT_PK, new TypedContent(pk.marshal().getBytes("utf-8"),"application/xtentis.itempk"));
				//call the callback content is ready
				context.getPluginCallBack().contentIsReady(context);
				return;
			}

			
			//Loop over original parents
			NodeList originalParentsList = Util.getNodeList(originalItem.getOwnerDocument(),parameters.getParentPivotPath());
			if ((originalParentsList == null) || (originalParentsList.getLength()==0)) {
				String err = "Transformer step "+context.getPluginNumber()+" PartialUpdate: parent of the pivot e.g. '"+parameters.getParentPivotPath()+"' must exist in the original item.";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
			}
			for (int i = 0; i < originalParentsList.getLength(); i++) {
				org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() Processing original parent "+originalParentsList.item(i).getLocalName()+"  "+i);
				//get originalParentItem
				Element originalParent = (Element)originalParentsList.item(i);
				//reverse process the list so that adds happen in the correct order
				org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() Partial Elements List Count "+partialUpdateElementsList.getLength());
				for (int j = partialUpdateElementsList.getLength()-1; j>=0; j--) {
					org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() ---- Processing partial update "+j);
					Element partialUpdateElement = (Element)partialUpdateElementsList.item(j);
					boolean addMe = (parameters.getStartingPosition() != -1);
					
					//overwrite if a priority
					boolean didOverwrite = false;
					if (parameters.isOverwrite() ) {
						if (parameters.getKeyPathFromPivot()==null) {
							//No Keys given - Overwrite all items with a matching local name
							NodeList originalElementsList = Util.getNodeList(originalParent, parameters.getPivotLeaf());
							if (originalElementsList!=null) {
								for (int k = 0; k < originalElementsList.getLength(); k++) {
									org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() -------- overwrite: replacing all item with local name  "+parameters.getPivotLeaf());
									Element originalElement = (Element)originalElementsList.item(k);
									Node importedNode = originalParent.getOwnerDocument().importNode(partialUpdateElement, true);
									originalParent.replaceChild(importedNode, originalElement);
									didOverwrite = true;
								}
							}
						} else {
							//A key XPath was given --> overwrite items with matching key
							String partialupdateElementKey = Util.joinStrings(
									Util.getTextNodes(
											partialUpdateElement,parameters.getKeyPathFromPivot()), 
									"."
							);
							org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() ---- overwrite: looking for key ["+partialupdateElementKey+"] in original elements");
							//see if we can fnd a smilar element on the original item
							NodeList originalElementsList = Util.getNodeList(originalParent, parameters.getPivotLeaf());
							if (originalElementsList!=null) {
								for (int k = 0; k < originalElementsList.getLength(); k++) {
									org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() -------- checking original element "+k);
									Element originalElement = (Element)originalElementsList.item(k);
									String originalElementKey = Util.joinStrings(
											Util.getTextNodes(
													originalElementsList.item(k),parameters.getKeyPathFromPivot()), 
											"."
									);
									org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() -------- key is "+originalElementKey);
									if (partialupdateElementKey.equals(originalElementKey)) {
										//import the partial Update element
										Node importedNode = originalParent.getOwnerDocument().importNode(partialUpdateElement, true);
										originalParent.replaceChild(importedNode, originalElement);
										didOverwrite = true;
										break;
									}
								}
							} else {
								org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() ---- no original elements");
							}
						}
					}//if overwrite
					
					//performs add
					if (addMe && (!didOverwrite)) {
						org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() performing add");
						NodeList originalElementsList = Util.getNodeList(originalParent, parameters.getPivotLeaf());
						int pos = Math.min(parameters.getStartingPosition(), originalElementsList==null ? 0 : originalElementsList.getLength());
						int k =0;
						if (originalElementsList!=null) {
							//loop over originam items and "re-add them" to the end by 'cyling' the elements
							for (k = 0; k < pos; k++) {
								Element originalElement = (Element)originalElementsList.item(k);
								originalParent.appendChild(originalElement);
							}
						}
						//add new element
						org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() ---- Adding at "+pos);
						//import the partial Update element
						Node importedNode = originalParent.getOwnerDocument().importNode(partialUpdateElement, true);
						originalParent.appendChild(importedNode);
							//finish the cycling
						if (originalElementsList!=null) {
							for (k = pos; k< originalElementsList.getLength(); k++) {
								Element originalElement = (Element)originalElementsList.item(k);
								originalParent.appendChild(originalElement);
							}
						}						
					}//end add
					
					
				}//for partial update Items
				
			}
			
			//now write back updates
			originalItemPOJO.setProjection(originalItem);
			pk = getItemCtrl2Local().putItem(
					originalItemPOJO,
					dataModelPOJO
			);
			//update list of projected keys
			//context.getProjectedPKs().add(pk); - FIXME: Class Cast Exception
			
			
			//save result to context
			context.put(OUTPUT_PK, new TypedContent(pk.marshal().getBytes("utf-8"),"application/xtentis.itempk"));
			//call the callback content is ready
			context.getPluginCallBack().contentIsReady(context);
			
		} catch (XtentisException xe) {
			xe.printStackTrace();
			throw (xe);
		} catch (Exception e) {
			e.printStackTrace();
			String err = "Could not execute the PartialUpdate transformer plugin "+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
			throw new XtentisException(e);
		} 
	}
	

	private void clearCaches(TransformerPluginContext context) {
		context.put(DATA_MODEL_POJO_CACHE, new HashMap<String, DataModelPOJO>());
		context.put(DATA_MODEL_XSD_CACHE, new HashMap<String, Document>());
	}
	
	private DataModelPOJO getDataModelPOJO(TransformerPluginContext context, String dataModelName) throws XtentisException, CreateException,NamingException{
		HashMap<String, DataModelPOJO> cache = (HashMap<String, DataModelPOJO>)context.get(DATA_MODEL_POJO_CACHE);
		DataModelPOJO pojo = cache.get(dataModelName);
		if (pojo == null) {
			pojo = Util.getDataModelCtrlLocal().getDataModel(new DataModelPOJOPK(dataModelName));
			cache.put(dataModelName, pojo);
		}
		return pojo;
	}
	
	private Document getDataModelXSD(TransformerPluginContext context, DataModelPOJO dataModelPOJO) throws ParserConfigurationException,SAXException,IOException{
		HashMap<String, Document> cache = (HashMap<String, Document>)context.get(DATA_MODEL_XSD_CACHE);
		Document xsd = cache.get(dataModelPOJO.getName());
		if (xsd == null) {
			xsd = Util.parse(dataModelPOJO.getSchema());
			cache.put(dataModelPOJO.getName(), xsd);
		}
		return xsd;
	}

	
	
	
	
    
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getDocumentation(String twoLettersLanguageCode) throws XtentisException {
		return
		"The PartialUpdate plugin performs partial updates on an item. " +
		"\n" +
		"Parameters\n" +
		"	pivot [mandatory]: the xPath of sub-elements that must be added or updated on the original item"+"\n"+
		"	overwrite [optional]: overwrite an existing item 'true' or 'false'. Default: 'true'. keyXPath must be specified"+"\n"+
		"	keyXPath: if supplied, the key Xpath will be applied to all sub-elements. All those for which the result "+"\n"+
		"		equals that of the same xPath applied to the partial update element will be replaced. " +"\n"+
		"		If not supplied, all elements with a local name matching that of the update element will be replaced "+"\n"+
		"	startingPosition [optional]: the position of the added sub-element in the original item parent childs list. " +"\n"+
		"	    Set to -1 if you want to diable add. Default: add at the the end of the parent's chailds"+"\n"+
		"	dataModel [optional]: the Data Model to use if none is given at runtime"+"\n"+
		"	dataCluster [optional]: the Data Cluster to use if none is given at runtime"+"\n"+	
		"\n"+
		"\n"+
		"Example" +"\n"+
		"	<parameters>" +"\n"+
		"		<pivot>MyRecord/ListOfChildElements/ChildElement</pivot>" +"\n"+
		"		<overwrite>true</overwrite>" +"\n"+
		"		<keyXPath>./ChildElementKey</keyXPath>" +"\n"+
		"		<startingPosition>9999999999</startingPosition>" +"\n"+
		"		<dataCluster>myDataCluster</dataCluster>" +"\n"+
		"		<dataModel>myDataModel</dataModel>" +"\n"+
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
    		configurationLoaded = true;
    		return configuration;
        } catch (XtentisException e) {
    		throw (e);
	    } catch (Exception e) {
    	    String err = "Unable to deserialize the configuration of the PartialUpdate Transformer Plugin"
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
	public String compileParameters(String parameters) throws XtentisException {
    	try {
    		CompiledParameters compiled = new CompiledParameters();
    		Element params = Util.parse(parameters).getDocumentElement();
    		compiled.setDataCluster(Util.getFirstTextNode(params, "dataCluster"));
    		compiled.setDataModel(Util.getFirstTextNode(params, "dataModel"));
    		compiled.setOverwrite(! "false".equals(Util.getFirstTextNode(params, "overwrite")));
    		//parse pivot
    		String pivot = Util.getFirstTextNode(params, "pivot");
    		if (pivot==null) {
        	    String err = "Unable to serialize the configuration of the PartialUpdate Transformer Plugin: the pivot is a mandatory element";
        	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
        	    throw new XtentisException(err);
    		}
    		String[] sl = getParentAndLeafPath(pivot);
    		compiled.setParentPivotPath(sl[0]);
    		compiled.setPivotLeaf(sl[1]);
    		compiled.setKeyPathFromPivot(Util.getFirstTextNode(params, "keyXPath"));
    		String position = Util.getFirstTextNode(params, "startingPosition");
    		if ((position == null) || "".equals(position)) {
    			compiled.setStartingPosition(Integer.MAX_VALUE); //apend to the end by default
    		} else {
    			compiled.setStartingPosition(Integer.parseInt(position));
    		}
    		return compiled.serialize();
	    } catch (Exception e) {
    	    String err = "Unable to serialize the configuration of the PartialUpdate Transformer Plugin"
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
    	    throw new XtentisException(err);
	    }	
	}

	
	//datamodels cach
	protected HashMap<String, XSDKey> keys = new HashMap<String, XSDKey>();
	protected HashMap<String, DataModelPOJO> dataModels = new HashMap<String, DataModelPOJO>();
    
	
    protected ItemPOJOPK getPK(Element newItem, String dataCluster, String dataModel) throws XtentisException{
    	org.apache.log4j.Logger.getLogger(this.getClass()).debug("getPK() ");
    	try {
			//get conceptName
			String conceptName = newItem.getLocalName();
    		
			XSDKey conceptKey = keys.get(dataModel+"/"+conceptName);
			if (conceptKey == null) {	
				//get the DataModel
	    		DataModelPOJO dataModelPOJO = dataModels.get(dataModel);
	    		if (dataModelPOJO == null) {
	    			dataModelPOJO = Util.getDataModelCtrlLocal().getDataModel(new DataModelPOJOPK(dataModel));
	    			dataModels.put(dataModel,dataModelPOJO);
	    		}
		        
	    		//find the key for the business concept --> it will become the element id
	            Document xsd = Util.parse(dataModelPOJO.getSchema());
	            conceptKey = Util.getBusinessConceptKey(
	            		xsd,
						conceptName
				);
	            keys.put(dataModel+"/"+conceptName, conceptKey);
			}
			//get key values
			String[] itemKeyValues = Util.getItemKeyValues(
       			newItem,
   				conceptKey
			);
			
			return new ItemPOJOPK(
					new DataClusterPOJOPK(dataCluster),
					conceptName,
					itemKeyValues
			);
			
		} catch (XtentisException e) {
			throw (e);
	    } catch (Exception e) {
    	    String err = "Unable to get the keys of item using dataModel "+dataModel+": "
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
    	    throw new XtentisException(err);
	    }
	}
    
    
    private String[] getParentAndLeafPath(String pivot) throws XtentisException {
		if (pivot.endsWith(")")) {
			String err = "Invalid pivot '"+pivot+"': pivots must be 'pure' path, with no functions";
			org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
			throw new XtentisException(err);							
		}
    	//Normalize path
		pivot = pivot.startsWith("/") ? pivot.substring(1): pivot; //remove leading slash
		pivot = pivot.endsWith("/") ? pivot.substring(0,pivot.length()-1): pivot; //remove trailing slash
		String[] pivotPaths = pivot.split("\\/");
		if (pivotPaths.length <2) {
			String err = "Invalid pivot '"+pivot+"': partial updates cannot be applied to the root element";
			org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
			throw new XtentisException(err);				
		}
		//build parent pivot
		String parentPivot = ""; 
		for (int i = 0; i < pivotPaths.length-1; i++) {
			parentPivot+="/"+pivotPaths[i];
		}
		//assign pivotElement
		String pivotLeaf = pivotPaths[pivotPaths.length-1];
		org.apache.log4j.Logger.getLogger(this.getClass()).debug("getParentAndLeafPath() "+pivot+" --->  "+parentPivot+"/"+pivotLeaf);
		return new String[]{parentPivot,pivotLeaf};
    }
}
