package com.amalto.core.plugin.base.codec.ejb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.ejb.SessionBean;

import org.w3c.dom.Document;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.amalto.core.objects.transformers.v2.ejb.TransformerPluginV2CtrlBean;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginContext;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginVariableDescriptor;
import com.amalto.core.objects.transformers.v2.util.TypedContent;
import com.amalto.core.plugin.base.codec.CompiledParameters;
import com.amalto.core.util.Util;
import com.amalto.core.util.XtentisException;

/**
 *
 * @author Starkey Shu
 *
 * @ejb.bean name="CodecPlugin"
 *           display-name="Name for CodecPlugin"
 *           description="Description for CodecPlugin"
 * 		     local-jndi-name = "amalto/local/transformer/plugin/codec"
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
 */
     

public class CodecPluginBean extends TransformerPluginV2CtrlBean  implements SessionBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7202526741925441441L;
	//parameter
	public static final String PARAMETERS ="com.amalto.core.plugin.base.codec.parameters";
	//various
	private static final String INPUT_TEXT ="law_text";
	private static final String OUTPUT_TEXT ="codec_text";
	
	private static final String METHOD_TYPE_ENCODE ="ENCODE";
	private static final String METHOD_TYPE_DECODE ="DECODE";
	private static final String METHOD_TYPES ="("+METHOD_TYPE_ENCODE+"|"+METHOD_TYPE_DECODE+")";
	private static final String ALGORITHM_TYPE_BASE64 ="BASE64";
	private static final List<String> AVAILABLE_ALGORITHMS =new ArrayList<String>();
	static{
		AVAILABLE_ALGORITHMS.add(ALGORITHM_TYPE_BASE64);
	}
	private static final String wrapRegex ="(true|false)";

	public CodecPluginBean() {
		super();
	}
	
	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public String getJNDIName() throws XtentisException {
		return "amalto/local/transformer/plugin/codec";
	}
	
	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public String getDescription(String twoLettersLanguageCode)
			throws XtentisException {
		String description="";
		if(twoLettersLanguageCode.toLowerCase().equals("en")){
			description="This is a plugin used for encode or decode text";
		}else{
			description="Unsupported language! ";
		}
		return description;
	}

	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public String getDocumentation(String twoLettersLanguageCode)
			throws XtentisException {
		return
		"The Codec plugin can encode or decode your input text. \n" +
		"\n" +
		"\n" +
		"Parameters\n" +
		"	method [mandatory]: specify whether ENCODE or DECODE input text"+"\n"+
		"	algorithm [mandatory]: specify which algorithm will be used"+"\n"+
		"	wrap [optional]: wrap an xml tag of an codec text 'true' or 'false'. Default: 'false'"+"\n"+
		"\n"+
		"\n"+
		"Example" +"\n"+
		"	<parameters>" +"\n"+
		"		<method>ENCODE</method>" +"\n"+
		"		<algorithm>BASE64</algorithm>" +"\n"+
		"	</parameters>"+"\n"+
		"\n"+
		"\n"+
		"Notes for Plugin Developers: " +"\n"+
		"		empty"	;
	}
	
	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public ArrayList<TransformerPluginVariableDescriptor> getInputVariableDescriptors(
			String twoLettersLanguageCode) throws XtentisException {
		 ArrayList<TransformerPluginVariableDescriptor> inputDescriptors = new ArrayList<TransformerPluginVariableDescriptor>();
		
		 TransformerPluginVariableDescriptor descriptor = new TransformerPluginVariableDescriptor();
		 descriptor.setVariableName(INPUT_TEXT);
		 descriptor.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text/.*")
						})
				)
		 );
		 HashMap<String, String> descriptions = new HashMap<String, String>();
		 descriptions.put("en", "The text content to enter");
		 descriptor.setDescriptions(descriptions);
		 descriptor.setMandatory(false);
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
	public ArrayList<TransformerPluginVariableDescriptor> getOutputVariableDescriptors(
			String twoLettersLanguageCode) throws XtentisException {
		 ArrayList<TransformerPluginVariableDescriptor> outputDescriptors = new ArrayList<TransformerPluginVariableDescriptor>();

		 //descriptor
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
		 descriptions.put("en", "The codeced text");
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
	public String getParametersSchema() throws XtentisException {
		// Is this feature in use now?
		return
		"<xsd:schema" +
		" 		elementFormDefault='unqualified'" +
		"		xmlns:xsd='http://www.w3.org/2001/XMLSchema'" +
		">" +
		"<xsd:element name='parameters'>" +
		"			<xsd:complexType >" +
		"				<xsd:sequence>" +
		"					<xsd:element minOccurs='1' maxOccurs='1' nillable='false' name='method' type='xsd:string'/>" +
		"					<xsd:element minOccurs='1' maxOccurs='1' nillable='false' name='algorithm' type='xsd:string'/>" +
		"					<xsd:element minOccurs='0' maxOccurs='1' nillable='false' name='wrap' type='xsd:string'/>" +
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
	public String compileParameters(String parameters) throws XtentisException {
		try {
			
			if(parameters==null||parameters.length()==0)return "";
			CompiledParameters compiled = new CompiledParameters();
			
			Document params=Util.parse(parameters);
			
    		//method - mandatory case
			String method = Util.getFirstTextNode(params, "//method");
			if (method==null) {
				String err = "The method parameter of the Codec Transformer Plugin cannot be empty";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
			}else if(!method.trim().toUpperCase().matches(METHOD_TYPES)){
				String err = "The format of the method parameter of the Codec Transformer Plugin is unavailable";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
			}
    		compiled.setMethod(method);
    		
    		String algorithm = Util.getFirstTextNode(params, "//algorithm");
			if (algorithm==null) {
				String err = "The algorithm parameter of the Codec Transformer Plugin cannot be empty";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
			}else if(!AVAILABLE_ALGORITHMS.contains(algorithm.trim().toUpperCase())){
				String err = "This algorithm can not be supported by Codec Transformer Plugin temporarily";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
			}
    		compiled.setAlgorithm(algorithm);
    		
    		//optional case
    		boolean isWrap=false;
    		String wrap = Util.getFirstTextNode(params, "//wrap");
			if (wrap!=null&&wrap.length()>0) {
				if(!wrap.trim().toLowerCase().matches(wrapRegex)){
					String err = "The format of the wrap parameter of the Codec Transformer Plugin is unavailable";
					org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
					throw new XtentisException(err);
				}
				isWrap=Boolean.parseBoolean(wrap.trim());
			}
    		compiled.setWrap(isWrap);

    		return compiled.serialize();
    		
    	} catch (XtentisException e) {
    		throw(e);
	    } catch (Exception e) {
    	    String err = "Unable to serialize the configuration of the Codec Plugin"
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
	public void init(TransformerPluginContext context, String compiledParameters)
			throws XtentisException {

		try {

			//parse parameters
			CompiledParameters parameters=CompiledParameters.deserialize(compiledParameters);
			
			context.put(PARAMETERS, parameters);
			
		}  catch (Exception e) {
			String err = "Could not init the Codec plugin:"+
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
	public void execute(TransformerPluginContext context)
			throws XtentisException {
		org.apache.log4j.Logger.getLogger(this.getClass()).trace("execute() Codec");
		
		CompiledParameters parameters= (CompiledParameters)context.get(PARAMETERS);
		TypedContent textTC = (TypedContent)context.get(INPUT_TEXT);
		try {

			//attempt to read charset
			String charset = Util.extractCharset(textTC.getContentType());
			String lawText = new String(textTC.getContentBytes(),charset);

			String method=parameters.getMethod();
			String algorithm=parameters.getAlgorithm();
			
			String codecText="";
			//TODO Please add more algorithms
			if(algorithm.equals(ALGORITHM_TYPE_BASE64)){
				if(method.equals(METHOD_TYPE_ENCODE)){
					codecText=(new BASE64Encoder()).encode(lawText.getBytes(charset));
				}else if(method.equals(METHOD_TYPE_DECODE)){
					codecText=new String((new BASE64Decoder()).decodeBuffer(lawText),charset);
				}
			}
			
			if(parameters.isWrap()){
				codecText="<Codec_Output>"+codecText+"</Codec_Output>";
			}
			
			context.put(OUTPUT_TEXT, new TypedContent(codecText.getBytes(),"text/xml; charset=utf-8"));
			//call the callback content is ready
			context.getPluginCallBack().contentIsReady(context);

		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			String err = "Could not execute the codec plugin "+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).error(err,e);
			throw new XtentisException(e);
		}
		
		org.apache.log4j.Logger.getLogger(this.getClass()).trace("execute() codec done");
		
	}


}