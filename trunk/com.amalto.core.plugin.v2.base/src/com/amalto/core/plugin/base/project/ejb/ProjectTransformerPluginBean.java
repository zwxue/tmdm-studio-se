package com.amalto.core.plugin.base.project.ejb;

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
import com.amalto.core.objects.transformers.v2.util.TypedContent_Do_Not_Process;
import com.amalto.core.objects.transformers.v2.util.TypedContent_Use_Default;
import com.amalto.core.plugin.base.project.CompiledParameters;
import com.amalto.core.util.Util;
import com.amalto.core.util.XtentisException;



/**
 * @author bgrieder
 * 
 * @ejb.bean name="ProjectTransformerPlugin"
 *           display-name="Name for ProjectPlugin"
 *           description="Description for ProjectPlugin"
 * 		  local-jndi-name = "amalto/local/transformer/plugin/project"
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
public class ProjectTransformerPluginBean extends TransformerPluginV2CtrlBean  implements SessionBean{
  
	private final static Pattern declarationPattern = Pattern.compile("<\\?.*?\\?>",Pattern.DOTALL);
	
	private static final String PARAMETERS ="com.amalto.core.plugin.project.parameters";
	private static final String DATA_CLUSTER_PK ="com.amalto.core.plugin.project.dataClusterPOJOPK";
	private static final String DATA_MODEL_POJO_CACHE ="com.amalto.core.plugin.project.dataModelPJOCache";
	private static final String DATA_MODEL_XSD_CACHE ="com.amalto.core.plugin.project.dataModelXSDCache";
	
	private static final long serialVersionUID = 5648768989892480L;
	
	private static final String INPUT_XML = "xml_instance";
	private static final String OUTPUT_PK = "item_primary_key";
	private static final String INPUT_PK = "item_primary_key";
	private static final String INPUT_DATA_MODEL = "data_model";
	private static final String INPUT_CLEAR_MODEL_CACHE = "clear_cache";

    private transient boolean configurationLoaded = false;

	

	public ProjectTransformerPluginBean() {
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
		return "amalto/local/transformer/plugin/project";
	}
	
	
	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getDescription(String twoLetterLanguageCode) throws XtentisException {
		if ("fr".matches(twoLetterLanguageCode.toLowerCase()))
			return "Projette un item vers le Gestionnaire de Données";
		return "Projects and item to the Data Manager";
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
		 descriptions1.put("en", "The item instance to project");
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
		 descriptions2.put("en", "The item instance primary key. Non Mandatory but speeds up projection if supplied and avoid having to supply the Data Cluster in The Parameters");
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
		 descriptions.put("en", "The projected item PK");
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
			String err = "Could not init the Project plugin:"+
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
			
			CompiledParameters parameters= (CompiledParameters)context.get( PARAMETERS);
			TypedContent xmlTC = (TypedContent)context.get(INPUT_XML);
			TypedContent inputPKTC = (TypedContent)context.get(INPUT_PK);
			TypedContent dataModelTC = (TypedContent) context.get(INPUT_DATA_MODEL);
			TypedContent clearCacheTC = (TypedContent) context.get(INPUT_CLEAR_MODEL_CACHE);
			
			String charset =  Util.extractCharset(xmlTC.getContentType());
			
			String xml = new String(xmlTC.getContentBytes(),charset);
			
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
					String err = "Transformer step "+context.getPluginNumber()+" Project: the Data Model name must be provided in the parameters when no Data Model name is provided during runtime";
					org.apache.log4j.Category.getInstance(this.getClass()).error(err);
					throw new XtentisException(err);
				}
			} else {
				dataModelName = new String(dataModelTC.getContentBytes(),"UTF8"); 
			}
				
//			get the Data Model POJO from the cache
			 DataModelPOJO dataModelPOJO = getDataModelPOJO(context, dataModelName);
			
			//Determine tem Key
			ItemPOJOPK pk = null;
			if (! (inputPKTC instanceof TypedContent_Use_Default)) {
				pk = ItemPOJOPK.unmarshal(new String(inputPKTC.getContentBytes(),"UTF8"));
			} else {
				//fetch default Data Cluster in parameters
				DataClusterPOJOPK dataClusterPOJOPK = (DataClusterPOJOPK)context.get(DATA_CLUSTER_PK);
				if (dataClusterPOJOPK == null) {
					if (parameters.getDataCluster() == null) {
						String err = "Transformer step "+context.getPluginNumber()+" Project: the Data Cluster must be provided in the parameters when no Item Key is provided during runtime";
						org.apache.log4j.Category.getInstance(this.getClass()).error(err);
						throw new XtentisException(err);
					}
					dataClusterPOJOPK = new DataClusterPOJOPK(parameters.getDataCluster());
					context.put(DATA_CLUSTER_PK, dataClusterPOJOPK);
				}
				pk = Util.getItemPOJOPK(
						dataClusterPOJOPK, 
						Util.parse(xml).getDocumentElement(), 
						getDataModelXSD(context, dataModelPOJO)
				);
			}
					
			if (!parameters.isOverwrite()) {
				//check if item alredy exists
				ItemPOJO check = getItemCtrl2Local().existsItem(pk);
				if (check!=null) {
					org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() Item "+pk.getUniqueID()+" already exists and overwite is set to false--> skipping");
					context.put(OUTPUT_PK, new TypedContent_Do_Not_Process());
					context.getPluginCallBack().contentIsReady(context);
					return;
				}
			}
			
			//cleanup declaration
			xml = declarationPattern.matcher(xml).replaceAll("");
			
			//create the item
			ItemPOJO newItemPOJO = 	new ItemPOJO(
					pk.getDataClusterPOJOPK(),
					pk.getConceptName(),
					pk.getIds(),
					System.currentTimeMillis(),
					xml
			); 
			
			org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() Projecting "+newItemPOJO.getItemPOJOPK().getUniqueID()+" usign model "+dataModelName+"\n"+xml);
			
			//now perform updates
			getItemCtrl2Local().putItem(
					newItemPOJO,
					dataModelPOJO
			);
			
			//save result to context
			context.put(OUTPUT_PK, new TypedContent(pk.marshal().getBytes("utf-8"),"application/xtentis.itempk"));
			//call the callback content is ready
			context.getPluginCallBack().contentIsReady(context);
			
		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			String err = "Could not execute the Project transformer plugin "+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Category.getInstance(this.getClass()).error("start() "+err);
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
		"The Project plugin projects content to the Data Manager. " +
		"If no Item Primary Key is passed as a variable in the pipeline,\n" +
		"the default Data Model and default Data Cluster to used must be specified in the parameters\n" +
		"\n" +
		"\n" +
		"Parameters\n" +
		"	defaultDataModel [optional]: the Data Model to use if none is given at runtime"+"\n"+
		"	defaultDataCluster [optional]: the Data Cluster to use if none is given at runtime"+"\n"+		
		"	overwrite [optional]: overwrite an existing item 'true' or 'false'. Default: 'true'"+"\n"+		
		"\n"+
		"\n"+
		"Example" +"\n"+
		"	<parameters>" +"\n"+
		"		<defaultDataCluster>myDataCluster</defaultDataCluster>" +"\n"+
		"		<defaultDataModel>myDataModel</defaultDataModel>" +"\n"+
		"		<overwrite>true</overwrite>" +"\n"+		
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
    	    String err = "Unable to deserialize the configuration of the Project Transformer Plugin"
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
    		compiled.setDataCluster(Util.getFirstTextNode(params, "defaultDataCluster"));
    		compiled.setDataModel(Util.getFirstTextNode(params, "defaultDataModel"));
    		compiled.setOverwrite(! "false".equals(Util.getFirstTextNode(params, "overwrite")));
    		return compiled.serialize();
	    } catch (Exception e) {
    	    String err = "Unable to serialize the configuration of the Project Transformer Plugin"
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Category.getInstance(this.getClass()).error(err);
    	    throw new XtentisException(err);
	    }	
	}

}
