package talend.core.transformer.plugin.v2.tiscall.ejb;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.ejb.SessionBean;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.w3c.dom.Element;

import talend.core.transformer.plugin.v2.tiscall.CompiledParameters;
import talend.core.transformer.plugin.v2.tiscall.webservices.Args;
import talend.core.transformer.plugin.v2.tiscall.webservices.WSxml;
import talend.core.transformer.plugin.v2.tiscall.webservices.WSxmlService;

import com.amalto.core.objects.synchronization.ejb.local.SynchronizationPlanCtrlLocal;
import com.amalto.core.objects.transformers.v2.ejb.TransformerPluginV2CtrlBean;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginContext;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginVariableDescriptor;
import com.amalto.core.objects.transformers.v2.util.TypedContent;
import com.amalto.core.util.Util;
import com.amalto.core.util.XtentisException;



/**
 * @author Bruno Grieder
 * 
 * @ejb.bean 	name="TISCallTransformerPlugin"
 *           	display-name="Name for TISCallPlugin"
 *           	description="Description for TISCallPlugin"
 * 		  		local-jndi-name = "amalto/local/transformer/plugin/tisCall"
 *           	type="Stateless"
 *           	view-type="local"
 *           	local-business-interface="com.amalto.core.objects.transformers.v2.util.TransformerPluginV2LocalInterface"
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
public class TISCallTransformerPluginBean extends TransformerPluginV2CtrlBean  implements SessionBean{
  
	private static final String PARAMETERS = "com.amalto.core.plugin.TISCall.parameters"; 
	
	private static final String INPUT_TEXT = "text";

	private static final String OUTPUT_TEXT = "result";
	
	private static final long serialVersionUID = 1L;
	
    private transient boolean configurationLoaded = false;
    


	public TISCallTransformerPluginBean() {
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
		return "amalto/local/transformer/plugin/tisCall";
	}
	
	
	
    /**
     * @throws XtentisException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getDescription(String twoLetterLanguageCode) throws XtentisException {
		if ("fr".matches(twoLetterLanguageCode.toLowerCase()))
			return "Execute un call de TIS un texte et retourne le résultat";
		return "Executes a Call to TIS on a text and returns the result";
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
		 descriptor1.setVariableName(INPUT_TEXT);
		 descriptor1.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text.*")
						})
				)
		 );
		 HashMap<String, String> descriptions1 = new HashMap<String, String>();
		 descriptions1.put("en", "The text to run the TISCall on");
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
								 Pattern.compile("text/xml")
						})
				)
		 );
		 HashMap<String, String> descriptions = new HashMap<String, String>();
		 descriptions.put("en", "The result of the TIS call");
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
			
			CompiledParameters parameters = CompiledParameters.deserialize(compiledParameters);
			context.put(PARAMETERS, parameters);
			
		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			String err = "Could not init the TISCall plugin:"+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).error(err,e);
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
		
		CompiledParameters parameters= (CompiledParameters)context.get(PARAMETERS);
		TypedContent textTC = (TypedContent)context.get(INPUT_TEXT);
		
		try {
					
			//attempt to read charset and rebuild the input text string
			String charset = Util.extractCharset(textTC.getContentType());
			String text = new String(textTC.getContentBytes(),charset);

			org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() TIS CALL to '"+parameters.getUrl()+"' input \n"+text);

	        
	        URL wsdlURL = SynchronizationPlanCtrlLocal.class.getResource("/META-INF/wsdl/tis.wsdl");
			
			WSxmlService service = new WSxmlService(wsdlURL, new QName("http://talend.org", "WSxmlService"));
			WSxml port = service.getWSxml();
			
			BindingProvider bp = (BindingProvider)port;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, parameters.getUrl());
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, parameters.getUsername());
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, parameters.getPassword());
			
			Args args = new Args();
			args.getItem().add(text);
			String result = port.runJob(args).getItem().get(0).getItem().get(0);
			
			org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() TIS CALL  result \n"+text);
			//save result to context
			context.put(OUTPUT_TEXT, new TypedContent(
				result.getBytes("utf-8"),
				parameters.getContentType())
			);

			//call the callback content is ready
			context.getPluginCallBack().contentIsReady(context);				
			
		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			String err = "Could not execute the tisCall transformer plugin "+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).error(err,e);
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
		"The TIS Call plugin executes a Web Service call to TIS on a text\n" +
		"\n" +
		"\n" +
		"Parameters\n" +
		"	url [mandatory]: the webservice port URL to the TIS Server"+"\n"+
		"	username [optional]: the username to use for the call"+"\n"+
		"	password [optional]: the password to  use for the call" +"\n"+
		"	contentType [optional]: the contentType of the returned data. Defaults to 'text/xml'" +"\n"+
		"\n"+
		"\n"+
		"Example" +"\n"+
		"	<configuration>" +"\n"+
		"		<url>http://server:port/TISService/TISPort</url>" +"\n"+
		"		<username>john</username>" +"\n"+
		"		<password>doe</password>" +"\n"+
		"	</configuration>"+"\n"+
		"\n"+
		"\n";
	}


	private String getDefaultConfiguration(){
    	return
		"<configuration>"+
		"	<url>http://server:port/TISService/TISPort</url>"+
		"	<username></username>"+
		"	<password></password>"+
		"	<contentType>text/xml</contentType>"+
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
    	    String err = "Unable to deserialize the configuration of the TISCall Transformer Plugin"
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err,e);
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
	public String compileParameters(String parameters) throws XtentisException {
    	try {
    		CompiledParameters compiled = new CompiledParameters();
    		Element params = Util.parse(parameters).getDocumentElement();
    		
    		//TISCall - mandatory
    		String url = Util.getFirstTextNode(params, "url");
    		if (url==null) {
    			String err = "The url parameter of the TIS Call Transformer Plugin cannot be empty";
    			org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
    			throw new XtentisException(err);
    		}
    		compiled.setUrl(url);
    		
    		//content Type - defaults to "text/plain; charset=utf-8"
    		String contentType = Util.getFirstTextNode(params, "contentType");
    		if (contentType == null) contentType = "text/xml; charset=utf-8";
    		compiled.setContentType(contentType);

    		//username - defaults to null
    		String username = Util.getFirstTextNode(params, "username");
    		compiled.setUsername(username);

    		//password - defaults to null
    		String password = Util.getFirstTextNode(params, "password");
    		compiled.setPassword(password);

    		return compiled.serialize();
    	} catch (XtentisException e) {
    		throw(e);
	    } catch (Exception e) {
    	    String err = "Unable to serialize the configuration of the TISCall Transformer Plugin"
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err,e);
    	    throw new XtentisException(err);
	    }	
	}




    
}