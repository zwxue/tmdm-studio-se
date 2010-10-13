/*
 * Created on 22 sept. 2005
 *
 */
package com.amalto.workbench.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.rpc.Stub;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.methods.MultipartPostMethod;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComplexTypeContent;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDImport;
import org.eclipse.xsd.XSDInclude;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSchemaContent;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.impl.XSDImportImpl;
import org.eclipse.xsd.impl.XSDIncludeImpl;
import org.eclipse.xsd.impl.XSDModelGroupImpl;
import org.eclipse.xsd.impl.XSDParticleImpl;
import org.eclipse.xsd.impl.XSDSchemaImpl;
import org.eclipse.xsd.util.XSDConstants;
import org.eclipse.xsd.util.XSDSchemaLocator;
import org.osgi.framework.Bundle;
import org.talend.mdm.commmon.util.core.ICoreConstants;
import org.talend.mdm.commmon.util.workbench.Version;
import org.talend.mdm.commmon.util.workbench.ZipToFile;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import sun.misc.BASE64Encoder;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeObjectTransfer;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.webservices.WSComponent;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSGetComponentVersion;
import com.amalto.workbench.webservices.WSGetDataModel;
import com.amalto.workbench.webservices.WSGetUniverse;
import com.amalto.workbench.webservices.WSGetUniversePKs;
import com.amalto.workbench.webservices.WSGetViewPKs;
import com.amalto.workbench.webservices.WSRegexDataClusterPKs;
import com.amalto.workbench.webservices.WSRegexDataModelPKs;
import com.amalto.workbench.webservices.WSRoutingRuleExpression;
import com.amalto.workbench.webservices.WSRoutingRuleOperator;
import com.amalto.workbench.webservices.WSStringPredicate;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.WSUniverseXtentisObjectsRevisionIDs;
import com.amalto.workbench.webservices.WSVersion;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.WSWhereCondition;
import com.amalto.workbench.webservices.WSWhereOperator;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.webservices.XtentisService;
import com.amalto.workbench.webservices.XtentisService_Impl;
import com.sun.org.apache.xpath.internal.XPathAPI;
import com.sun.org.apache.xpath.internal.objects.XObject;


/**
 * @author bgrieder
 */
public class Util {
	
	
	
	public static LinkedHashMap<String,String> iso2lang = new LinkedHashMap<String, String>();
	
	static {
		iso2lang.put("en","English");
		iso2lang.put("fr","French");
		iso2lang.put("es","Spanish");
		iso2lang.put("ab","Abkhazian");
		iso2lang.put("aa","Afar");
		iso2lang.put("af","Afrikaans");
		iso2lang.put("sq","Albanian");
		iso2lang.put("am","Amharic");
		iso2lang.put("ar","Arabic");
		iso2lang.put("hy","Armenian");
		iso2lang.put("as","Assamese");
		iso2lang.put("ay","Aymara");
		iso2lang.put("az","Azerbaijani");
		iso2lang.put("ba","Bashkir");
		iso2lang.put("eu","Basque");
		iso2lang.put("bn","Bengali (Bangla)");
		iso2lang.put("dz","Bhutani");
		iso2lang.put("bh","Bihari");
		iso2lang.put("bi","Bislama");
		iso2lang.put("br","Breton");
		iso2lang.put("bg","Bulgarian");
		iso2lang.put("my","Burmese");
		iso2lang.put("be","Byelorussian");
		iso2lang.put("km","Cambodian");
		iso2lang.put("ca","Catalan");
		iso2lang.put("zh","Chinese");
		iso2lang.put("co","Corsican");
		iso2lang.put("hr","Croatian");
		iso2lang.put("cs","Czech");
		iso2lang.put("da","Danish");
		iso2lang.put("nl","Dutch");
		iso2lang.put("eo","Esperanto");
		iso2lang.put("et","Estonian");
		iso2lang.put("fo","Faeroese");
		iso2lang.put("fa","Farsi");
		iso2lang.put("fj","Fiji");
		iso2lang.put("fi","Finnish");
		iso2lang.put("fy","Frisian");
		iso2lang.put("gl","Galician");
		iso2lang.put("ka","Georgian");
		iso2lang.put("de","German");
		iso2lang.put("el","Greek");
		iso2lang.put("kl","Greenlandic");
		iso2lang.put("gn","Guarani");
		iso2lang.put("gu","Gujarati");
		iso2lang.put("ha","Hausa");
		iso2lang.put("iw, he","Hebrew");
		iso2lang.put("hi","Hindi");
		iso2lang.put("hu","Hungarian");
		iso2lang.put("is","Icelandic");
		iso2lang.put("in, id","Indonesian");
		iso2lang.put("ia","Interlingua");
		iso2lang.put("ie","Interlingue");
		iso2lang.put("iu","Inuktitut");
		iso2lang.put("ik","Inupiak");
		iso2lang.put("ga","Irish");
		iso2lang.put("it","Italian");
		iso2lang.put("ja","Japanese");
		iso2lang.put("ji","Yiddish");
		iso2lang.put("jw","Javanese");
		iso2lang.put("kn","Kannada");
		iso2lang.put("ks","Kashmiri");
		iso2lang.put("kk","Kazakh");
		iso2lang.put("rw","Kinyarwanda");
		iso2lang.put("ky","Kirghiz");
		iso2lang.put("rn","Kirundi");
		iso2lang.put("ko","Korean");
		iso2lang.put("ku","Kurdish");
		iso2lang.put("lo","Laothian");
		iso2lang.put("la","Latin");
		iso2lang.put("lv","Latvian (Lettish)");
		iso2lang.put("ln","Lingala");
		iso2lang.put("lt","Lithuanian");
		iso2lang.put("mk","Macedonian");
		iso2lang.put("mg","Malagasy");
		iso2lang.put("ms","Malay");
		iso2lang.put("ml","Malayalam");
		iso2lang.put("mt","Maltese");
		iso2lang.put("gv","Manx Gaelic");
		iso2lang.put("mi","Maori");
		iso2lang.put("mr","Marathi");
		iso2lang.put("mo","Moldavian");
		iso2lang.put("mn","Mongolian");
		iso2lang.put("na","Nauru");
		iso2lang.put("ne","Nepali");
		iso2lang.put("no","Norwegian");
		iso2lang.put("oc","Occitan");
		iso2lang.put("or","Oriya");
		iso2lang.put("om","Oromo (Afan)");
		iso2lang.put("ps","Pashto (Pushto)");
		iso2lang.put("pl","Polish");
		iso2lang.put("pt","Portuguese");
		iso2lang.put("pa","Punjabi");
		iso2lang.put("qu","Quechua");
		iso2lang.put("rm","Rhaeto-Romance");
		iso2lang.put("ro","Romanian");
		iso2lang.put("ru","Russian");
		iso2lang.put("sm","Samoan");
		iso2lang.put("sg","Sangro");
		iso2lang.put("sa","Sanskrit");
		iso2lang.put("gd","Scots Gaelic");
		iso2lang.put("sr","Serbian");
		iso2lang.put("sh","Serbo-Croatian");
		iso2lang.put("st","Sesotho");
		iso2lang.put("tn","Setswana");
		iso2lang.put("sn","Shona");
		iso2lang.put("sd","Sindhi");
		iso2lang.put("si","Singhalese");
		iso2lang.put("ss","Siswati");
		iso2lang.put("sk","Slovak");
		iso2lang.put("sl","Slovenian");
		iso2lang.put("so","Somali");
		iso2lang.put("su","Sundanese");
		iso2lang.put("sw","Swahili");
		iso2lang.put("sv","Swedish");
		iso2lang.put("tl","Tagalog");
		iso2lang.put("tg","Tajik");
		iso2lang.put("ta","Tamil");
		iso2lang.put("tt","Tatar");
		iso2lang.put("te","Telugu");
		iso2lang.put("th","Thai");
		iso2lang.put("bo","Tibetan");
		iso2lang.put("ti","Tigrinya");
		iso2lang.put("to","Tonga");
		iso2lang.put("ts","Tsonga");
		iso2lang.put("tr","Turkish");
		iso2lang.put("tk","Turkmen");
		iso2lang.put("tw","Twi");
		iso2lang.put("ug","Uighur");
		iso2lang.put("uk","Ukrainian");
		iso2lang.put("ur","Urdu");
		iso2lang.put("uz","Uzbek");
		iso2lang.put("vi","Vietnamese");
		iso2lang.put("vo","Volapük");
		iso2lang.put("cy","Welsh");
		iso2lang.put("wo","Wolof");
		iso2lang.put("xh","Xhosa");
		iso2lang.put("yi","Yiddish");
		iso2lang.put("yo","Yoruba");
		iso2lang.put("zu","Zulu");
	}
	
	public static LinkedHashMap<String,String> lang2iso = new LinkedHashMap<String, String>();
	static {
		Set<String> isos = iso2lang.keySet();
		for (Iterator<String> iter = isos.iterator(); iter.hasNext(); ) {
			String iso = iter.next();
			String language = iso2lang.get(iso);
			lang2iso.put(language, iso);
			/*
			String existingISO = lang2iso.get(language);
			if (existingISO!=null) {
				lang2iso.put(language, existingISO+", "+iso);	
			} else {
				lang2iso.put(language, iso);
			}
			*/
		}
	}
	


	
	public static String default_endpoint_address = "http://localhost:8080/talend/TalendPort";
	
	/*********************************************************************
	 *      WEB SERVICES
	 *********************************************************************/

	public static XtentisPort getPort(TreeObject xobject) throws XtentisException{
		try {
			if(xobject==null)return null;
			return getPort(
					new URL(xobject.getEndpointAddress()),
					xobject.getUniverse(),
					xobject.getUsername(),
					xobject.getPassword()
			);
		} catch (MalformedURLException e) {
			throw new XtentisException("Invalid endpoint address: "+xobject.getEndpointAddress());
		}
	}
	
	public static XtentisPort getPort(String universe, String username, String password) throws XtentisException{
		try {
			return getPort(new URL(default_endpoint_address), universe, username, password);
		} catch (MalformedURLException e) {
			String err = "The default URL '"+default_endpoint_address+"' is invalid!";
			throw new XtentisException(err);
		}
	}
	
//	public static XtentisPort getPort(String endpointAddress, String username, String password) throws XtentisException{
    public static XtentisPort getPort(URL url, String universe, String username, String password) throws XtentisException{		

		try {

			//deactivate Certificate validation on all https connections by creating a non validating ssl socket factory
			SSLContext context = SSLContext.getInstance("TLS");
			X509TrustManager mgr = new X509TrustManager() {
				public void checkClientTrusted(	X509Certificate[] chain,String authType) throws CertificateException {	}
				public void checkServerTrusted(X509Certificate[] chain,	String authType) throws CertificateException {}
				public X509Certificate[] getAcceptedIssuers() {return null;}
			};
			context.init(null, new TrustManager[]{mgr}, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
			
			//prepare the Web Services Stub
            XtentisService service;
            Bundle bundle = Platform.getBundle(ENTERPRISE_ID);
            if (bundle != null) {
                Class<?> cls = bundle.loadClass("org.talend.mdm.workbench.enterprice.webservices.XtentisServiceImpl"); //$NON-NLS-1$
                service = (XtentisService)cls.newInstance();
            } else
                service = new XtentisService_Impl();
            
			Stub stub = (Stub) service.getXtentisPort();
			stub._setProperty(Stub.ENDPOINT_ADDRESS_PROPERTY, url.toString());
			if (username!=null) {
				if (universe != null)
					stub._setProperty(Stub.USERNAME_PROPERTY, universe+"/"+username);
				else
					stub._setProperty(Stub.USERNAME_PROPERTY, username);
				
			}
			if (password!=null)
	          stub._setProperty(Stub.PASSWORD_PROPERTY, password);
            
			return (XtentisPort)stub;
		} catch (Exception e) {
			e.printStackTrace();
			throw new XtentisException(
					"Unable to access endpoint at: "+url
					+": "+e.getLocalizedMessage());
		}
	}
	
	

	
	/*
	public static WSDataModel[] getAllDataModels(URL url, String username, String password) throws XtentisException{
		try {
			XtentisPort port = Util.getPort(url,username,password);
			return port.getDataModels(new WSRegexDataModels("*")).getWsDataModels();
		} catch (Exception e) {
			e.printStackTrace();
			throw new XtentisException(
					"Unable to retrieve all Data Models"
					+": "+e.getLocalizedMessage());
		}
	}
	*/
	
	public static WSDataModelPK[] getAllDataModelPKs(URL url, String universe, String username, String password) throws XtentisException{
		try {
			XtentisPort port = Util.getPort(url,universe,username,password);
			return port.getDataModelPKs(new WSRegexDataModelPKs("*")).getWsDataModelPKs();
		} catch (Exception e) {
			e.printStackTrace();
			throw new XtentisException(
					"Unable to retrieve all Data Model Names"
					+": "+e.getLocalizedMessage());
		}
	}
	
	
	
	public static WSDataClusterPK[] getAllDataClusterPKs(URL url, String universe, String username, String password) throws XtentisException{
		try {
			XtentisPort port = Util.getPort(url,universe,username,password);
			return port.getDataClusterPKs(new WSRegexDataClusterPKs("*")).getWsDataClusterPKs();
		} catch (Exception e) {
			e.printStackTrace();
			throw new XtentisException(
					"Unable to retrieve all Data Container Names"
					+": "+e.getLocalizedMessage());
		}
	}
	
	

	
	public static WSViewPK[] getAllViewPKs(URL url, String universe, String username, String password, String regex) throws XtentisException{
		try {
			if ((regex==null) || ("".equals(regex))) regex = "*";
			XtentisPort port = Util.getPort(url,universe,username,password);
			return port.getViewPKs(new WSGetViewPKs(regex)).getWsViewPK();
		} catch (Exception e) {
			e.printStackTrace();
			throw new XtentisException(
					"Unable to retrieve all the Outbound Adaptors"
					+": "+e.getLocalizedMessage());
		}
	}


	
	/*********************************************************************
	 *      LOCAL FILE UTILS
	 *********************************************************************/
	
	public static String getXML(String filename)throws Exception {

		InputStream in = null;
		try {
			in=new FileInputStream(filename);
			return IOUtils.toString(in);
		}finally {
			if(in!=null) in.close();
		}
    }    
	
	public static String getPackageFilePath(Class<? extends Object> c, String filename) {
		return c.getResource(filename).getPath();
	}

	
	/*********************************************************************
	 *     NODE UTILS
	 *********************************************************************/
	
	/**
	 * Join an array of strings into a single string using a separator
	 * @param strings
	 * @param separator
	 * @return a single string or null
	 */
	public static String joinStrings(String[] strings, String separator) {
		if (strings == null) return null;
		String res = "";
		for (int i = 0; i < strings.length; i++) {
			res+= (i>0) ? separator : "";
			res+=strings[i];
		}
		return res;
	}
	
	/**
	 * Returns the first part - eg. the concept - from the path
	 * @param path
	 * @return the concept Name
	 */
    public static String getConceptFromPath(String path) {
    	Pattern p = Pattern.compile("(.*?)[\\[|/].*");
    	if (!path.endsWith("/")) path+="/";
    	Matcher m = p.matcher(path);
    	if (m.matches()) 
    		return m.group(1);
   		return null;
    }

	/**
	 * Generates an xml string from a node 
	 * (not pretty formatted)
	 * @param n the node
	 * @return the xml string
	 * @throws Exception
	 */
	public static String nodeToString(Node n) throws Exception{
       	StringWriter sw = new StringWriter();
       	Transformer transformer = TransformerFactory.newInstance().newTransformer();
       	transformer.setOutputProperty("omit-xml-declaration","yes");
       	transformer.setOutputProperty("indent","yes");
       	transformer.transform(
				new DOMSource(n),
				new StreamResult(sw)
				);
		return sw.toString();
	}

	/**
	 * Get a nodelist from an xPath
	 * @throws Exception
	 */
	public static NodeList getNodeList(Document d, String xPath) throws Exception{
		return getNodeList(d.getDocumentElement(),xPath,null,null);
	}
	/**
	 * Get a nodelist from an xPath
	 * @throws Exception
	 */
	public static NodeList getNodeList(Node contextNode, String xPath) throws Exception{
		return getNodeList(contextNode,xPath,null,null);
	}
	
	/**
	 * Get a nodelist from an xPath
	 * @throws Exception
	 */
	public static NodeList getNodeList(Node contextNode, String xPath, String namespace, String prefix) throws Exception{
	    XObject xo = XPathAPI.eval(
    		contextNode,
			xPath,
			(namespace == null) ? contextNode : Util.getRootElement("nsholder",namespace,prefix)
	    );
	    if (xo.getType() != XObject.CLASS_NODESET) return null;
	    return xo.nodelist();
	}
	
    /**
	 * Returns a namespaced root element of a document
	 * Useful to create a namespace holder element
	 * @param namespace
	 * @return the root Element
	 */
	public static Element getRootElement(String elementName, String namespace, String prefix) throws Exception{
	 	Element rootNS=null;
    	try {
	    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        factory.setNamespaceAware(true);   
	        DocumentBuilder builder = factory.newDocumentBuilder();
	    	DOMImplementation impl = builder.getDOMImplementation();
	    	Document namespaceHolder = impl.createDocument(namespace,(prefix==null?"":prefix+":")+elementName, null);    
	    	rootNS = namespaceHolder.getDocumentElement();
	    	rootNS.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:"+prefix, namespace);
    	} catch (Exception e) {
    	    String err="Error creating a namespace holder document: "+e.getLocalizedMessage();
    	    throw new Exception(err);    
    	}
    	return rootNS;
	}

    public static Document parse(String xmlString) throws Exception{
    	return parse(xmlString,null);
    }
    	
    public static Document parse(String xmlString, String schema) throws Exception{

		//parse
		Document d=null;
		SAXErrorHandler seh = new SAXErrorHandler();

		try {
			
	   		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			documentBuilderFactory.setValidating((schema!=null));
			documentBuilderFactory.setAttribute(
					"http://java.sun.com/xml/jaxp/properties/schemaLanguage",
					"http://www.w3.org/2001/XMLSchema");
			if (schema != null) {
				documentBuilderFactory.setAttribute(
					"http://java.sun.com/xml/jaxp/properties/schemaSource",
					new InputSource(new StringReader(schema))
					);
			}
			
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			documentBuilder.setErrorHandler(seh);
			if(xmlString==null||xmlString.length()==0||xmlString.matches("\\s+"))return d;
			d = documentBuilder.parse(new InputSource(new StringReader(xmlString)));
			
			if (schema != null) {
				String errors = seh.getErrors();
				if (!errors.equals("")) {
					String err = "Document  did not parse against schema: \n" + errors+"\n"+xmlString;
					throw new Exception(err);
				}
			}
			return d;
		} catch (Exception e) {
			e.printStackTrace();
			String err = "Unable to parse the document"
					+": " + e.getClass().getName() + ": "
					+ e.getLocalizedMessage()+
					"\n "+xmlString;
			throw new Exception(err);
		}
    }
    

    public static String[] getTextNodes(Node contextNode, String xPath) throws XtentisException{
    	return getTextNodes(contextNode,xPath,contextNode);
    }
    
    public static String[] getTextNodes(Node contextNode, String xPath,Node namespaceNode) throws XtentisException{
        String[] results=null;;
        
        //test for hard-coded values
        if (xPath.startsWith("\"") && xPath.endsWith("\""))
            return new String[] { xPath.substring(1, xPath.length()-1)};
            
        //test for incomplete path (elements missing /text())
        if (!xPath.matches(".*@[^/\\]]+"))  //attribute
        	if (! xPath.endsWith(")")) //function
        		xPath+="/text()";
               
        try {
	        XObject xo = XPathAPI.eval(contextNode, xPath,namespaceNode);
	        if (xo.getType() == XObject.CLASS_NODESET) {
	            NodeList l = xo.nodelist();
	            int len = l.getLength();
	            results = new String[len];
	            for (int i = 0; i < len; i++) {
	                Node n = l.item(i);
	                results[i] = n.getNodeValue();
	            }
	        } else {
	            results = new String[]{xo.toString()};
	        }
		} catch (Exception e) {
			String err = "Unable to get the text node(s) of "+xPath
					+": " + e.getClass().getName() + ": "
					+ e.getLocalizedMessage();
			throw new XtentisException(err);
		}
		return results;

    }    
    
    
    public static String getFirstTextNode(Node contextNode, String xPath,Node namespaceNode) throws XtentisException{
    	String[] res = getTextNodes(contextNode,xPath,namespaceNode);
    	if (res.length == 0) 
    		return null;
    	return res[0]; 
    }

    public static String getFirstTextNode(Node contextNode, String xPath) throws XtentisException{
    	return getFirstTextNode(contextNode,xPath,contextNode);
    }

 	/*********************************************************************
	 *      FILE UPLOAD
	 *      
	 *      Multi-Part Form Post
	 *********************************************************************/
    public static String uploadFileToAppServer(String URL,String localFilename, String username, String password)  throws XtentisException{
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        /*
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire.header", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire.content", "debug");
        */
        
        HttpClient client = new HttpClient();
        MultipartPostMethod mppost = new MultipartPostMethod(URL);
        String response = null;
        String fileName = localFilename;
        try {
        	  
            client.setConnectionTimeout(60000);
            client.getState().setAuthenticationPreemptive(true);
            client.getState().setCredentials(null,null, new UsernamePasswordCredentials(username,password));
           //if delete a job, mppost will not addParameter, otherwise there is an exception.
			if (URL.indexOf("deletefile") == -1) {
				if (URL.indexOf("deployjob") != -1) {
					fileName = URL.substring(URL.indexOf("=") + 1);
				}
				mppost.addParameter(fileName, new File(localFilename));
			}
                //mppost.addParameter(info.getJobname()+"_"+info.getJobversion()+".war",new File(localFilename));
            
            client.executeMethod(mppost);
            if (mppost.getStatusCode() != HttpStatus.SC_OK) {
            	throw new XtentisException("Server sent error: "+mppost.getStatusCode()+": "+mppost.getStatusText()); 
            }
            response = mppost.getResponseBodyAsString();
            mppost.releaseConnection();
            return response;
        } catch (Exception e) {
            mppost.releaseConnection();        	
        	e.printStackTrace();
        	throw new XtentisException(e.getClass().getName()+": "+e.getLocalizedMessage());
        }
    }
    
    
    public static String uploadImageFile(String URL,String localFilename, String username, String password)  throws XtentisException{
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        /*
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire.header", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire.content", "debug");
        */
        
        HttpClient client = new HttpClient();
        MultipartPostMethod mppost = new MultipartPostMethod(URL);
        String response = null;
        try {
        	  
            client.setConnectionTimeout(60000);
            client.getState().setAuthenticationPreemptive(true);
            client.getState().setCredentials(null,null, new UsernamePasswordCredentials(username,password));
            if(!"".equalsIgnoreCase(localFilename))
				mppost.addParameter("imageFile", new File(localFilename));
            
            client.executeMethod(mppost);
            if (mppost.getStatusCode() != HttpStatus.SC_OK) {
            	throw new XtentisException("Server sent error: "+mppost.getStatusCode()+": "+mppost.getStatusText()); 
            }
            response = mppost.getResponseBodyAsString();
            mppost.releaseConnection();
            if(response.contains("upload"))
            	return response.substring(response.indexOf("upload"), response.indexOf("}")-1);
            else 
            	return "";
        } catch (Exception e) {
            mppost.releaseConnection();        	
        	e.printStackTrace();
        	throw new XtentisException(e.getClass().getName()+": "+e.getLocalizedMessage());
        }
    }
	/*********************************************************************
	 *     XSD Utils
	 *********************************************************************/
    
    
    public static boolean isTypeDerivedFrom(XSDTypeDefinition typedef, String namespace, String localName)   {
    	// Walk the baseTypes from this typedef seeing if any
    	// of them match the requested one
    	XSDTypeDefinition baseType = typedef.getBaseType();
    	
    	// As this convenience method if our parameters match
    	if (baseType.hasNameAndTargetNamespace(localName, namespace)) {
    		return true;
    	}
    	
    	// If not, check to see if we've run up to the top
    	// Performance note: this is horribly inefficient,
    	// re-calling this same method every time; but it
    	// serves as a good example
    	XSDTypeDefinition rootType = typedef.getRootType();
    	if (rootType == baseType) 	{
    		// If we've hit the root, we aren't derived from it
    		return false;
    	}  	else   	{
    		// Otherwise continue to traverse upwards
    		return isTypeDerivedFrom(baseType, namespace, localName);
    	}
    }
    
    /**
     * Find elementDeclarations that use any types derived from a named type.
     * 
     * <p>
     * This shows one way to query the schema for elementDeclarations and then
     * how to find specific kinds of typeDefinitions.
     * </p>
     * 
     * @param objList
     *            collection set to search for elemDecls
     * @param localName
     *            for the type used
     * @return Boolean  indicate any XSDElementDeclarations is found or not
     */
    public static boolean findElementsUsingType(ArrayList<Object> objList, XSDTypeDefinition localTypedef)   {
   	// A handy convenience method quickly gets all
    	// elementDeclarations within our schema; note that
    	// whether or not this returns types in included,
    	// imported, or redefined schemas is subject to change
    	
    	for (Iterator<Object> iter = objList.iterator(); iter.hasNext(); /* no-op */)  	{
    		Object obj = iter.next();
    		if(obj==localTypedef) continue;
    		if (obj instanceof XSDElementDeclaration || obj instanceof XSDTypeDefinition)
    		{
    			XSDTypeDefinition typedef = null;
    			if (obj instanceof XSDElementDeclaration)
    			{
        			XSDElementDeclaration elem = (XSDElementDeclaration)obj;
    	    		if (elem.getAnonymousTypeDefinition() != null)	{
    	    			typedef = elem.getAnonymousTypeDefinition();
    	    		} else if (elem.getTypeDefinition() != null) {
    	    			typedef = elem.getTypeDefinition();
    	    		} else	{
    	    			// Element is not complete, since it has no type,
    	    			// thus it's not using our type
    	    			continue;
    	    		}
    			}
    			else {
					typedef = (XSDTypeDefinition) obj;
				}

	    		if (typedef instanceof XSDComplexTypeDefinition)
	    		{
	    			XSDComplexTypeDefinition type = (XSDComplexTypeDefinition)typedef;
	    			if(localTypedef.getName().equals(type.getName()) && (localTypedef instanceof XSDComplexTypeDefinition)) {
	    				return true;
	    			}
					if (type.getContent() instanceof XSDParticle) {
						XSDParticle particle = (XSDParticle) type.getContent();
						if (particle.getTerm() instanceof XSDModelGroup) {
							XSDModelGroup group = (XSDModelGroup) particle.getTerm();
							EList<XSDParticle> elist = group.getContents();
							for (XSDParticle pt : elist) {
								if(pt.getContent() instanceof XSDElementDeclaration)
								{
									XSDTypeDefinition typeDef = ((XSDElementDeclaration) pt.getContent()).getTypeDefinition();
									if (typeDef != null && typeDef.getName() != null)
									{
										if ((localTypedef.getName().equals(typeDef.getName()))) {
											  return true;
											}
									}
								}
							}
						}
					}
	    		}
	    		else if (typedef instanceof XSDSimpleTypeDefinition)
	    		{
	    			XSDSimpleTypeDefinition type = (XSDSimpleTypeDefinition)typedef;
	    			XSDSimpleTypeDefinition baseType = type.getBaseTypeDefinition();
	    			if (baseType != null && baseType.getName().equals(localTypedef.getName()))return true;
	    		}
    		}
    	}
    	
        return false;
    }
 
    public static List<String> getAllCustomSimpleDataType(XSDSchema schema)
    {
		ArrayList customTypes = new ArrayList();
		for (Iterator iter =  schema.getTypeDefinitions().iterator(); iter.hasNext(); ) {
			XSDTypeDefinition type = (XSDTypeDefinition) iter.next();
			if (type instanceof XSDSimpleTypeDefinition)
				customTypes.add(type.getName());
		}
		return customTypes;
    }
    
    public static List<String> getAllSchemaSimpleDataType(XSDSchema schema)
    {
    	List<String> builtInTypes = new ArrayList<String>();
		for (Iterator<XSDTypeDefinition> iter =  schema.getSchemaForSchema().getTypeDefinitions().iterator(); iter.hasNext(); ) {
			XSDTypeDefinition type = (XSDTypeDefinition) iter.next();
			if (type instanceof XSDSimpleTypeDefinition)
				builtInTypes.add(type.getName());
		}
		return builtInTypes;
    }
    
    public static Object findElementUsingName(XSDSchema schema, String name) {
		EList<XSDElementDeclaration> elems = schema.getElementDeclarations();
		for (XSDElementDeclaration elem : elems) {
			if (elem.getName().equals(name))
				return elem;
		}
		return null;
	}
    
    public static List<Object> getKeyInfo(Object key)
    {
    	if (!((key instanceof XSDElementDeclaration))) {
			return null;
		}
    	
    	return getTopParent(key);
 
        
    }
    

    public static void getForeignKeyofParcle(Set<String> list, XSDAnnotation annotation) {
			if (annotation != null) {
				
				List<Element> annotList =  annotation.getApplicationInformation();
				for (int k = 0; k < annotList.size(); k++) {
					if ("appinfo".equals(annotList.get(k).getLocalName())) {
						Node source = annotList.get(k).getAttributes().getNamedItem("source");
						if (source == null)continue;
						String appinfoSource = annotList.get(k).getAttributes().getNamedItem("source").getNodeValue();
						if ("X_ForeignKey".equals(appinfoSource)){
							String path = annotList.get(k).getFirstChild().getNodeValue();
					    		list.add(getConceptFromPath(path));
					    		
						}
							
					}

				}
			}
	}
    
    /**
     * set the list with  foreign concept name of in the element
     * @author ymli
     * @param list
     * @param element
     */
    public static void getforeignKeyOfElement(Set<String> list, XSDElementDeclaration element) {
		if (element.getAnnotation() != null) {
			getForeignKeyofParcle(list, element.getAnnotation());
		}
		if (element.getTypeDefinition() instanceof XSDComplexTypeDefinition) {
			XSDComplexTypeContent fromcomplexType = ((XSDComplexTypeDefinition) element.getTypeDefinition()).getContent();
			if (fromcomplexType instanceof XSDParticle) {

				XSDParticle particle = (XSDParticle) fromcomplexType;

				if (((XSDParticle) particle).getTerm() instanceof XSDModelGroup) {

					XSDModelGroup modelGroup = ((XSDModelGroup) particle.getTerm());
					EList fromlist = modelGroup.getContents();

					for (XSDParticle el : (XSDParticle[]) fromlist.toArray(new XSDParticle[fromlist.size()])) {
						XSDTerm term = el.getTerm();
						if (term instanceof XSDElementDeclaration) {
							XSDAnnotation annotation = ((XSDElementDeclaration) term).getAnnotation();
							
							if(annotation!=null){
								getForeignKeyofParcle(list,annotation);
							}
							getforeignKeyOfElement(list, (XSDElementDeclaration) term) ;
						}
					}
				}
			}
		}

	}
    /**
     * set the list with all the foreign concepty name in the parent 
     * @author ymli
     * @param list
     * @param parent
     * @throws Exception
     */
    public static void getForeingKeyInDataModel(Set<String> list,TreeParent parent) throws Exception{
    	TreeObject[] children = parent.getChildren();
    	WSDataModel wsDataModel = null;
    	XtentisPort port = null;
		try {
			port = Util.getPort(parent);
		} catch (XtentisException e) {
			e.printStackTrace();
		}
    	for(TreeObject object:children){
    		if(object instanceof TreeParent){
    			getForeingKeyInDataModel(list, (TreeParent)object);
    			continue;
    		}
    	wsDataModel =port.getDataModel(new WSGetDataModel(
				new WSDataModelPK(object.getDisplayName())));
    	XSDSchema xsdSchema = Util.getXSDSchema(wsDataModel.getXsdSchema());
		String schema = Util.nodeToString(xsdSchema.getDocument());
		XSDSchema xsd= Util.createXsdSchema(schema, object);
		getForeingKeyInSchema(list,xsd);
    }
    }
    /**
     * set the list with foreign concept names in the schema
     * @author ymli
     * @param list
     * @param schema
     * @return
     */
    public static Set<String> getForeingKeyInSchema(Set<String> list,XSDSchema schema){
    	EList<XSDSchemaContent> contents = schema.getContents();
    	for(XSDSchemaContent content : contents){
    		if(content instanceof XSDElementDeclaration)
    			getforeignKeyOfElement(list, (XSDElementDeclaration)content);
    	}
    	
    	return list;
    }
    /**
     * the all the typeDefinition in the schema
     * @author ymli
     * @param schema
     * @return
     */
    public static HashMap<String, XSDTypeDefinition> getTypeDefinition(XSDSchema schema){
    	HashMap<String, XSDTypeDefinition> map = new HashMap<String, XSDTypeDefinition>();
    	for(XSDSchemaContent content : schema.getContents()){
    		if(content instanceof XSDTypeDefinition){
    			map.put(((XSDTypeDefinition) content).getName(), (XSDTypeDefinition) content);
    		}
    	}
    	return map;
    }
    
    
    public static Object getParent(Object son)
    {
    	if (!((son instanceof XSDElementDeclaration) || (son instanceof XSDParticle))) {
			return null;
		}

		XSDElementDeclaration elem = null;
		if (son instanceof XSDParticle) {
			elem = (XSDElementDeclaration) ((XSDParticle) son).getContent();
		} else if (son instanceof XSDElementDeclaration) {
			elem = (XSDElementDeclaration) son;
		}

		EList<XSDSchemaContent> parentList = elem.getSchema().getContents();
		ArrayList<Object> list = new ArrayList<Object>();
		for (XSDSchemaContent top : parentList) {
			list.clear();
			if (!(top instanceof XSDElementDeclaration)&& !(top instanceof XSDComplexTypeDefinition)) {
				continue;
			}
			if(top instanceof XSDElementDeclaration ){
				XSDElementDeclaration decl = (XSDElementDeclaration) top;
			if (decl == son) return decl;
			if (decl.getTypeDefinition() instanceof XSDComplexTypeDefinition) {
				XSDComplexTypeDefinition type = (XSDComplexTypeDefinition) decl.getTypeDefinition();
				if (type.getContent() instanceof XSDParticle) {
					XSDParticle particle = (XSDParticle) type.getContent();
					if (particle.getTerm() instanceof XSDModelGroup) {
						XSDModelGroup group = (XSDModelGroup) particle.getTerm();
						EList<XSDParticle> elist = group.getContents();
						for (XSDParticle pt : elist) {
							if(pt.getContent() instanceof XSDElementDeclaration)
							if (((XSDElementDeclaration) pt.getContent()) == elem) {
								return decl;
							}
							ArrayList<String> complexTypes = new ArrayList<String>();
							XSDElementDeclaration spec = findOutSpecialSonElement((XSDElementDeclaration) pt.getContent(), elem, complexTypes);
							if(spec != null)
								return spec;
					}
				}
			}
		}
			}
			else{
				XSDComplexTypeDefinition type = (XSDComplexTypeDefinition)top;
				if(type.getContent() instanceof XSDParticle){
					XSDParticle particle = (XSDParticle) type.getContent();
					if (particle.getTerm() instanceof XSDModelGroup) {
						XSDModelGroup group = (XSDModelGroup) particle.getTerm();
						EList<XSDParticle> elist = group.getContents();
						for (XSDParticle pt : elist) {
							if(pt.getContent() instanceof XSDElementDeclaration)
							if (((XSDElementDeclaration) pt.getContent()) == elem) {
								return top;
							}
							if(pt.getContent() instanceof XSDElementDeclaration)
							{
								ArrayList<String> complexTypes = new ArrayList<String>();
								XSDElementDeclaration spec = findOutSpecialSonElement((XSDElementDeclaration) pt.getContent(), elem, complexTypes);
								if(spec != null)
									return spec;
							}
						}
					}
				}
			}
      }
	 return null;
    }
    public static List<Object> getTopParent(Object son)
    {
    	if (!((son instanceof XSDElementDeclaration) || (son instanceof XSDParticle))) {
    		return null;
    	}
    	
    	XSDElementDeclaration elem = null;
//    	if (son instanceof XSDParticle) {
//    		elem = (XSDElementDeclaration) ((XSDParticle) son).getContent();
//    	} else if (son instanceof XSDElementDeclaration) {
//    		elem = (XSDElementDeclaration) son;
//    	}
    	elem = (XSDElementDeclaration) son;
    	
    	EList<XSDSchemaContent> parentList = elem.getSchema().getContents();
    	ArrayList<Object> list = new ArrayList<Object>();
    	for (XSDSchemaContent top : parentList) {
    		list.clear();
    		if (!(top instanceof XSDElementDeclaration)) {
    			continue;
    		}
    		if(top instanceof XSDElementDeclaration ){
    			XSDElementDeclaration decl = (XSDElementDeclaration) top;
//    			if (decl == son) return list;
    			if (decl.getTypeDefinition() instanceof XSDComplexTypeDefinition) {

    				String	primaryKey=getTopElement(decl,elem,(XSDComplexTypeDefinition)decl.getTypeDefinition());
    				if(!primaryKey.equalsIgnoreCase("")){
    		        	EList<XSDIdentityConstraintDefinition> idtylist = decl.getIdentityConstraintDefinitions();
    		        	for (XSDIdentityConstraintDefinition idty : idtylist)
    		        	{
    		        		EList<XSDXPathDefinition> fields = idty.getFields();
    		        		for (XSDXPathDefinition path: fields)
    		        		{
    		        			if ((path.getValue()).equals(primaryKey))
    		        			{
    		        				list.add(idty);
    		        				list.add(path);
    		        				return list;
    		        			}
    		        			System.out.println(path.getValue()+"----"+primaryKey);
    		        		}
    		        	}
//    					return list;
    				}
    				}
    		}
    	}
    	return null;
    }
    
    private static String getTopElement(XSDElementDeclaration parent,
			XSDElementDeclaration son, XSDComplexTypeDefinition type) {

		if (type.getContent() instanceof XSDParticle) {
			XSDParticle particle = (XSDParticle) type.getContent();
			if (particle.getTerm() instanceof XSDModelGroup) {
				XSDModelGroup group = (XSDModelGroup) particle.getTerm();
				EList<XSDParticle> elist = group.getContents();
				for (XSDParticle pt : elist) {
					if (pt.getContent() instanceof XSDElementDeclaration) {
						XSDElementDeclaration ele = (XSDElementDeclaration) pt
								.getContent();
						if (ele == son)
							return ele.getName();
/*						ArrayList<String> complexTypes = new ArrayList<String>();
						XSDElementDeclaration spec = findOutSpecialSonElement(
								(XSDElementDeclaration) pt.getContent(), son,
								complexTypes);
						if (spec != null)
							return spec.getName();*/
						if (ele.getTypeDefinition() instanceof XSDComplexTypeDefinition)
							return ele.getName()+"/"+ getTopElement(ele, son,
									(XSDComplexTypeDefinition) ele
											.getTypeDefinition());
					}
				}
			}
		}
		return "";
		
	}

	private static XSDElementDeclaration findOutSpecialSonElement(XSDElementDeclaration parent, XSDElementDeclaration son, ArrayList<String> complexTypes)
    {	
    	ArrayList<XSDElementDeclaration> particleElemList = findOutAllSonElements((XSDElementDeclaration)parent, complexTypes);
    	XSDElementDeclaration specialParent = null;
		for (XSDElementDeclaration e: particleElemList)
		{
			if(e == son)
			{
				specialParent = parent;
			}
		}
		
		if(specialParent == null)
		{
			for (XSDElementDeclaration e: particleElemList)
			{
				specialParent = findOutSpecialSonElement(e, son, complexTypes);
				if(specialParent != null)
					break;
			}
		}
		
		return specialParent;
    }
    
    private static ArrayList<XSDElementDeclaration> findOutAllSonElements(XSDElementDeclaration decl, ArrayList<String> complexTypes)
    {
    	ArrayList<XSDElementDeclaration> holder = new ArrayList<XSDElementDeclaration>();
    	if(decl.getTypeDefinition() instanceof XSDComplexTypeDefinition)
    	{
			XSDComplexTypeDefinition type = (XSDComplexTypeDefinition) decl.getTypeDefinition();
			String typeDesc = type.getTargetNamespace() + " : " + type.getName();
			if(complexTypes.indexOf(typeDesc) != -1)
				return holder;
			if(type.getContent() instanceof XSDParticle)
			{
				XSDParticle particle = (XSDParticle) type.getContent();
				if (particle.getTerm() instanceof XSDModelGroup) {
					XSDModelGroup group = (XSDModelGroup) particle
							.getTerm();
					EList<XSDParticle> elist = group.getContents();
					boolean addComplexType = false;
					for (XSDParticle pt : elist) {
						if(pt.getContent() instanceof XSDElementDeclaration)
						{
							XSDElementDeclaration elem = (XSDElementDeclaration)pt.getContent();
							if(!addComplexType)
							{
								complexTypes.add(typeDesc);
								addComplexType = true;
							}
							if(StringUtils.equals(elem.getName(), decl.getName()))
							{
								if(ObjectUtils.equals(elem.getType(), decl.getType()))
								{
									if(StringUtils.equals(elem.getTargetNamespace(), decl.getTargetNamespace()))
									{
										continue;
									}
								}
							}
							holder.add(elem);
						}
					}
				}
			}
    	}
    	
    	return holder;
    }
    
	public static boolean checkConcept(XSDElementDeclaration decl) {
		boolean isConcept = false;
		EList l = decl.getIdentityConstraintDefinitions();
		for (Iterator iter = l.iterator(); iter.hasNext();) {
			XSDIdentityConstraintDefinition icd = (XSDIdentityConstraintDefinition) iter
					.next();
			if (icd.getIdentityConstraintCategory().equals(
					XSDIdentityConstraintCategory.UNIQUE_LITERAL)) {
				isConcept = true;
				break;
			}
		}
		return isConcept;
	}
	
    public static Object[] getAllObject(Object elem, List<Object> objList, IStructuredContentProvider provider) {
		Object[] elems = provider.getElements(elem);
		for (Object obj : elems) {
			if(obj == null)continue;
			if(obj instanceof XSDModelGroup||obj instanceof XSDElementDeclaration
							|| obj instanceof XSDParticle || obj instanceof XSDTypeDefinition ) {
				if (!objList.contains(obj)) {
					objList.add(obj);
					
					getAllObject(obj, objList, provider);
				}
			} 
		}

		return objList.toArray();
		
	}
    
    public static void updateComplexType(Object elem, Object newType,  IStructuredContentProvider provider)
    {
    	if (!(newType instanceof XSDComplexTypeDefinition)){
    		return;
    	}
        ArrayList<Object> objList = new ArrayList<Object>();
    	Object[] allNodes = getAllObject(elem, objList, provider);
    	for (Object node : allNodes)
    	{
    		if (node instanceof XSDElementDeclaration)
    		{
				XSDElementDeclaration xsdElem = (XSDElementDeclaration) node;
				if (xsdElem.getTypeDefinition() == newType) {
					xsdElem.setTypeDefinition((XSDComplexTypeDefinition) newType);
				}
    		}
    		else if (node instanceof XSDParticle) {
					XSDParticle particle = (XSDParticle) node;
					if (particle.getTerm() instanceof XSDModelGroup) {
						XSDModelGroup group = (XSDModelGroup) particle
								.getTerm();
						EList<XSDParticle> elist = group.getContents();
						for (XSDParticle pt : elist) {
							if(pt.getContent() instanceof XSDElementDeclaration)
							if (((XSDElementDeclaration) pt.getContent()).getTypeDefinition() == newType) {
								((XSDElementDeclaration) pt.getContent()).setTypeDefinition((XSDComplexTypeDefinition)newType);
							}

						}
					}
					else if (particle.getTerm() instanceof XSDElementDeclaration)
					{
						XSDElementDeclaration xsdElem = (XSDElementDeclaration) particle.getTerm();
						if (xsdElem.getTypeDefinition() == newType) {
						xsdElem
								.setTypeDefinition((XSDComplexTypeDefinition) newType);
					      }
					}
				}
    	}
    	
    }
    
    public static void updateReference(Object decl, Object[] objs, String newValue) {
		if (!(decl instanceof XSDElementDeclaration)) {
			return;
		}

		for (Object obj : objs) {
			if (obj instanceof XSDParticle) {
				XSDTerm term = ((XSDParticle) obj).getTerm();

				if (term instanceof XSDElementDeclaration) {
					XSDElementDeclaration xsdElem = (XSDElementDeclaration) term;
					if (xsdElem == decl) {
						((XSDParticle) obj)
								.setTerm((XSDElementDeclaration) decl);
						((XSDParticle) obj).updateElement();
					}
				}
				if (!(((XSDParticle) obj).getContent() instanceof XSDElementDeclaration)) continue;
				XSDElementDeclaration elem = (XSDElementDeclaration) ((XSDParticle) obj).getContent();
				if (elem.isElementDeclarationReference())
				{
					if (elem.getResolvedElementDeclaration() == decl)
					{
						elem.setResolvedElementDeclaration((XSDElementDeclaration)decl);
					}
				}
			}
		}
		
	}
    
    public static  void deleteReference(Object decl, Object[] objs) {
		for (Object obj : objs) {
			if (obj instanceof XSDParticle) {
				XSDTerm term = ((XSDParticle) obj).getTerm();

				if (term instanceof XSDElementDeclaration) {
					XSDElementDeclaration xsdElem = (XSDElementDeclaration) term;
					if (xsdElem == decl) {
			       	    	XSDModelGroup group = (XSDModelGroup)((XSDParticle)obj).getContainer();
			       	    	if (group != null)
			       	    		group.getContents().remove(obj);
					}
				}
			}
		}
		
	}
    
    public static XSDElementDeclaration findReference(String refName,
			XSDSchema schema) {
		EList eDecls = schema.getElementDeclarations();
        if(refName.indexOf(" : ") != -1)
        {
        	refName = refName.substring(0, refName.indexOf(" : "));
        }
		for (Iterator iter = eDecls.iterator(); iter.hasNext();) {
			XSDElementDeclaration d = (XSDElementDeclaration) iter.next();
			if (d.getQName().equals(refName)) {
				return d;
			}
		}

		return null;
	}
    
    private static Clipboard clipboard = null;
    /**
     * Clipboard support
     * @return the Clipboard
     */
    public static Clipboard getClipboard() {
		if (clipboard == null) {
			clipboard = new Clipboard(Display.getCurrent());
		}
		return clipboard;
	}
    
    
    public static Version getVersion(TreeObject xobject) throws XtentisException{
    	try {
    		WSVersion version  = getPort(xobject).getComponentVersion(new WSGetComponentVersion(WSComponent.DataManager,null));
    		return new Version(version.getMajor(),version.getMinor(),version.getRevision(),version.getBuild());
    	} catch (XtentisException e) {
    		throw(e);
    	} catch (Exception e) {
    		throw new XtentisException("Unable to get core version "+e.getClass().getName()+" : "+e.getMessage());
    	}
    }
    
    /**
     * @deprecated using getChildren(TreeParent xObject,int objectType)
     * @param xObject
     * @param objectType
     * @return
     */
    public static List<String> getCachedXObjectsNameSet(TreeObject xObject,int objectType) {
		List<String> xObjectsNameSet=new ArrayList<String>();
		if(xObject!=null){
			
			TreeParent treeNode = xObject.findServerFolder(objectType);
			TreeObject[] xObjectsSet = treeNode.getChildren();
			for (int i = 0; i < xObjectsSet.length; i++) {
				xObject = xObjectsSet[i];
				String xObjectName = xObject.getDisplayName();
				xObjectsNameSet.add(xObjectName);
			}
			
		}
		return xObjectsNameSet;
	}
	public static List<String> getChildren(TreeParent xObject,int objectType){
		List<String> objs=new ArrayList<String>();
		for( TreeObject obj:xObject.getChildren()){
			if(obj instanceof TreeParent){
				TreeParent parent=(TreeParent)obj;
				objs.addAll(getChildren(parent, objectType));
			}else{
				if(obj.getType() == objectType)
				objs.add(obj.getDisplayName());
			}
		}
		return objs;
	}
	
	public static List<String> getDataModel(TreeObject obj,String datamodel,String conceptName) {
		List<String> systemDataModelValues=Util.getChildren(obj.getServerRoot(), TreeObject.DATA_MODEL);
		
		//filter the datamodel according to conceptName
		List<String> avaiList=new ArrayList<String>();
		avaiList.addAll(systemDataModelValues);
		if(datamodel!=null) {
			avaiList.clear();
			avaiList.add(datamodel);
		}
		else if(conceptName!=null && !conceptName.contains("*")){
			for(String data: systemDataModelValues){
				try {
					WSDataModel dm=Util.getPort(obj).getDataModel(new WSGetDataModel(new WSDataModelPK(data)));
					if(dm!=null){
						//XSDSchema xsdSchema = Util.getXSDSchema(dm.getXsdSchema());
						String schema =dm.getXsdSchema();						
						Pattern p=Pattern.compile("<xsd:element(.*?)name=\""+conceptName +"\"");
						if(!p.matcher(schema).find()){
							avaiList.remove(data);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}
		}
		if(avaiList.size()==0)
			avaiList.addAll(systemDataModelValues);
		return avaiList;
	}
	public static List<TreeObject> getChildrenObj(TreeParent xObject){
		List<TreeObject> objs=new ArrayList<TreeObject>();
		if(xObject.getChildren()!=null)
		for( TreeObject obj:xObject.getChildren()){
			if(obj instanceof TreeParent){
				TreeParent parent=(TreeParent)obj;
				if(parent!=null)
				objs.addAll(getChildrenObj(parent));
			}else{
				if(obj.isXObject())
				objs.add(obj);
			}
		}
		return objs;
	}   
    public static List<String> getChildElementNames(String parentxpath,XSDElementDeclaration decl) throws Exception{
    	List<String> childNames=new ArrayList<String>();

    	XSDTypeDefinition type = decl.getTypeDefinition();
    	if(type instanceof XSDComplexTypeDefinition)
    	{
    		XSDComplexTypeDefinition cmpType = (XSDComplexTypeDefinition)type;
    		if (cmpType.getContent() instanceof XSDParticle)
    		{
    			XSDParticleImpl particle = (XSDParticleImpl)cmpType.getContent();
    			if(particle.getTerm() instanceof XSDModelGroup)
    			{
    				XSDModelGroup group = (XSDModelGroup)particle.getTerm();
    				EList<XSDParticle> particles = group.getParticles();
    				for (XSDParticle part: particles)
    				{
    					if(part.getTerm() instanceof XSDElementDeclaration)
    					{    						
    						XSDElementDeclaration el = (XSDElementDeclaration)part.getTerm();
    						if(el.getTypeDefinition() instanceof XSDSimpleTypeDefinition) {
    							String child=parentxpath.length()==0?el.getName():parentxpath+"/"+el.getName();    							
    							childNames.add(child);
    						}else {
    							String parent=parentxpath.length()==0?el.getName():parentxpath+"/"+el.getName();
    							childNames.addAll(getChildElementNames(parent,el));
    						}
    					}
    				}
    			}
    		}
    	}
    	return childNames;
    }
    
    public static IStatus changeElementTypeToSequence(XSDElementDeclaration decl, int maxOccurs)
    {
    	if(maxOccurs < -1)
    	{
    		MessageDialog.openError(null, "error", "max occurance value should be greater than -1");
    		return Status.CANCEL_STATUS;
    	}
    	if(Util.getParent(decl) instanceof XSDElementDeclaration){
		XSDElementDeclaration parent = (XSDElementDeclaration)Util.getParent(decl);
		XSDComplexTypeDefinition compx = (XSDComplexTypeDefinition)parent.getTypeDefinition();
		XSDParticleImpl partCnt = (XSDParticleImpl)compx.getContent();
		XSDModelGroupImpl mdlGrp = (XSDModelGroupImpl)partCnt.getTerm();
		
   		if((maxOccurs > 1 || maxOccurs == -1) && mdlGrp.getCompositor() != XSDCompositor.SEQUENCE_LITERAL)
   		{
   			// change the parent element to xsd:sequence
			if (!MessageDialog.openConfirm(null,
					"Change to sequence type", "The complex type will be changed to sequence in response to the maxOccurs value change")) {
				return Status.CANCEL_STATUS;
			}

			mdlGrp.setCompositor(XSDCompositor.SEQUENCE_LITERAL);
			partCnt.getElement().getAttributeNode("maxOccurs").setNodeValue("unbounded");
			partCnt.setMinOccurs(0);
   			parent.updateElement();
   		}
   		
    	}
    	//add by ymli; fix the bug:0012278;
    	else{
    		if(Util.getParent(decl) instanceof XSDComplexTypeDefinition){
    			XSDComplexTypeDefinition compx = (XSDComplexTypeDefinition)Util.getParent(decl);
    			XSDParticleImpl partCnt = (XSDParticleImpl)compx.getContent();
    			XSDModelGroupImpl mdlGrp = (XSDModelGroupImpl)partCnt.getTerm();
    			if((maxOccurs > 1 || maxOccurs == -1) && mdlGrp.getCompositor() != XSDCompositor.SEQUENCE_LITERAL)
    	   		{
    	   			// change the parent element to xsd:sequence
    				if (!MessageDialog.openConfirm(null,
    						"Change to sequence type", "The complex type will be changed to sequence in response to the maxOccurs value change")) {
    					return Status.CANCEL_STATUS;
    				}

    				mdlGrp.setCompositor(XSDCompositor.SEQUENCE_LITERAL);
    				partCnt.getElement().getAttributeNode("maxOccurs").setNodeValue("unbounded");
    				partCnt.setMinOccurs(0);
    				compx.updateElement();
    	   		}
    		}
    	}
    	return Status.OK_STATUS;
    }
    public static boolean IsAImporedElement(XSDConcreteComponent component, XSDSchema schema)
    {
    	if(component == null) return true;
    	String componentName=getComponentName(component);
    	if(componentName==null) return true;
    	try {
			String xsd=nodeToString(schema.getDocument().getDocumentElement());
			if(xsd.indexOf(componentName)!=-1) { 
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	List<String> buffer = new ArrayList<String>();
//    	buffer = retrieveXSDComponentPath(component, schema, buffer);
//    	String path = "";
//        for (int i = buffer.size() -1; i >= 0; i--)
//        {
//        	if(path.lastIndexOf(buffer.get(i)) == -1)
//        	  path += buffer.get(i);
//        }
//
//    	try {
//			NodeList l = Util.getNodeList(schema.getDocument(), path);
//			if(l.getLength() > 0)
//				return false;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
		return true;
    }
    public static boolean IsAImporedElement(XSDConcreteComponent component, String schema)
    {
    	if(component == null) return true;
    	String componentName=getComponentName(component);
    	try {
			String xsd=schema;
			if(xsd.indexOf(componentName)!=-1) { 
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
    }
    private static String getComponentName(Object component) {
    	if(component instanceof XSDElementDeclaration)
    	{
    		XSDElementDeclaration decl = (XSDElementDeclaration)component;
    		return  "name=\""+decl.getName()+"\"";
    		
    	}
    	else if(component instanceof XSDParticle)
    	{
    		XSDParticle particle = (XSDParticle)component;
    		XSDTerm term = (XSDTerm)particle.getTerm();    	
            if (term instanceof XSDElementDeclaration && !(((XSDElementDeclaration)term).getContainer() instanceof XSDParticle))
            {            	
            	return "name=\""+((XSDElementDeclaration)term).getName()+"\"";                
            }
            
    	}
    	else if(component instanceof XSDComplexTypeDefinition)
    	{
    		XSDComplexTypeDefinition type = (XSDComplexTypeDefinition)component;
    		return type.getName();
    		
    	}
    	else if(component instanceof XSDSimpleTypeDefinition)
    	{

    		return "name=\""+((XSDSimpleTypeDefinition)component).getName()+"\"";
    		
    	}
    	
    	else if(component instanceof XSDIdentityConstraintDefinition)
    	{
    		XSDIdentityConstraintDefinition identify = (XSDIdentityConstraintDefinition)component;
    		XSDConcreteComponent c = identify.getContainer();
    		return "name=\""+identify.getName()+"\"";
    	}
    	else if(component instanceof XSDXPathDefinition)
    	{
    		XSDXPathDefinition path = (XSDXPathDefinition)component;
    		return "xpath=\""+path.getValue()+"\"";
    	}
    	return null;
    }
    public static List<String> retrieveXSDComponentPath(Object component, XSDSchema schema, List<String> buffer)
    {
    	String name = null;
    	String elemType = "element";
    	if(component instanceof XSDElementDeclaration)
    	{
    		XSDElementDeclaration decl = (XSDElementDeclaration)component;
    		name = decl.getName();
    		buffer.add("//xsd:element[@name='" + name +  "']");
    		if(decl.getContainer() instanceof XSDSchemaImpl)
    			return buffer;
    		else return retrieveXSDComponentPath(decl.getContainer(), schema, buffer);
    	}
    	else if(component instanceof XSDParticle)
    	{
    		XSDParticle particle = (XSDParticle)component;
    		XSDTerm term = (XSDTerm)particle.getTerm();
            if (term instanceof XSDElementDeclaration && !(((XSDElementDeclaration)term).getContainer() instanceof XSDParticle))
            {
            	String prefix = null;
            	String ns = ((XSDElementDeclaration)term).getTargetNamespace();
            	Iterator<Map.Entry<String, String>> iter = schema.getQNamePrefixToNamespaceMap().entrySet().iterator();
            	while(iter.hasNext() && ns != null)
            	{
            		Map.Entry<String, String> entry = (Map.Entry<String, String>)iter.next();
            		if(entry.getValue().equals(ns))
            			prefix = entry.getKey();
            	}
            	name = ((XSDElementDeclaration)term).getName();
                buffer.add("//xsd:element[@name='" + name +  "' or @ref='" + (prefix != null ? (prefix + ":" + name) : name) + "']");
            	return  retrieveXSDComponentPath(particle.getContainer(), schema, buffer);
            }
            else
            {
            	retrieveXSDComponentPath(particle.getContainer(), schema, buffer);
            }
    	}
    	else if(component instanceof XSDComplexTypeDefinition)
    	{
    		XSDComplexTypeDefinition type = (XSDComplexTypeDefinition)component;
    		name = type.getName();
    		buffer.add("//xsd:complexType" + (name != null? "[@name='" + name +  "']" : ""));
    		if(type.getContainer() instanceof XSDSchemaImpl)
    			return buffer;
    		return retrieveXSDComponentPath(type.getContainer(), schema, buffer);
    	}
    	else if(component instanceof XSDSimpleTypeDefinition)
    	{
//    		TreePath tPath=((TreeSelection)selection).getPaths()[0];
//    		Object elem = tPath.getSegment(0);
//    		return retrieveXSDComponentPath(elem, schema, buffer, selection);
    		String typeName = ((XSDSimpleTypeDefinition)component).getName();
    		buffer.add("//xsd:simpleType[@name='" + typeName +  "']");
    		return buffer;
    	}
    	else if(component instanceof XSDModelGroup)
    	{
    		XSDModelGroup group = (XSDModelGroup)component;
    		String literal = group.getCompositor().getLiteral();
    		buffer.add("//xsd:" + literal);
    		return retrieveXSDComponentPath(group.getContainer(), schema, buffer); 
    	}
    	else if(component instanceof XSDIdentityConstraintDefinition)
    	{
    		XSDIdentityConstraintDefinition identify = (XSDIdentityConstraintDefinition)component;
    		XSDConcreteComponent c = identify.getContainer();
    		buffer.add("//xsd:unique[@name='" + identify.getName() + "']");
    		return  retrieveXSDComponentPath(c, schema, buffer);
    	}
    	else if(component instanceof XSDXPathDefinition)
    	{
    		XSDXPathDefinition path = (XSDXPathDefinition)component;
    		buffer.add("//xsd:field[@xpath='" + path.getValue() + "']");
    		return retrieveXSDComponentPath(path.getContainer(), schema, buffer);
    	}
    	else if(component instanceof XSDAnnotation)
    	{
    		XSDAnnotation annon = (XSDAnnotation)component;
    		buffer.add("//xsd:annotation");
    		return retrieveXSDComponentPath(annon.getContainer(), schema, buffer);
    	}
    	else
    		return buffer;
    	
    	return buffer;
    }
    
    public static String getResponseFromURL(String url, TreeObject treeObj) throws Exception
    {
    	InputStreamReader doc=null;
    	try {
        BASE64Encoder encoder = new BASE64Encoder();
        StringBuffer buffer = new StringBuffer();
        String credentials = encoder.encode(new String(treeObj.getServerRoot().getUsername() + ":" + treeObj.getServerRoot().getPassword()).getBytes());
        
		URL urlCn = new URL(url);
		URLConnection conn = urlCn.openConnection();
		conn.setAllowUserInteraction(true);
		conn.setDoOutput(true);
		conn.setDoInput(true);
        conn.setRequestProperty("Authorization", "Basic " + credentials);
        conn.setRequestProperty("Expect", "100-continue"); 

         doc = 
            new InputStreamReader(conn.getInputStream());
        BufferedReader reader = new BufferedReader(doc);
        String line = reader.readLine();
        while(line != null)
        {
        	buffer.append(line);
        	line = reader.readLine();
        }
	            
	    return buffer.toString();
    	}finally {
    		if(doc!=null)doc.close();
    	}
    }
    
    public static XSDSchema createXsdSchema(String xsd, TreeObject treeObj) throws Exception{
    	    List<XSDImport> imports = new ArrayList<XSDImport>();
    	    List<Exception> exceptons = new ArrayList<Exception>();
    	    Map<String,Integer> schemaMonitor = new HashMap<String, Integer>();
    	    //no import or include using old getXsdschema()
//    		if (Util.getNodeList(doc.getDocumentElement(),"//xsd:import").getLength() ==0
//			|| Util.getNodeList(doc.getDocumentElement(),
//					"//xsd:include").getLength() ==0)
//            {
//             return Util.getXSDSchema(xsd);
//            }
    	    // replace  the old roles with the new role scheme
    	    String xsdCpy = new String(xsd);
            for (Map.Entry<String, String> pair : ICoreConstants.rolesConvert.oldRoleToNewRoleMap.entrySet())
            {
            	xsdCpy = xsdCpy.replaceAll(pair.getKey().toString(), pair.getValue().toString());
            }
    	    XSDSchema xsdSchema = Util.getXSDSchema(xsdCpy, imports, treeObj, false, exceptons, schemaMonitor);
    	    if(exceptons.size() > 0)
    	    {
    	    	throw exceptons.get(0);
    	    }
    	    else if(schemaMonitor.containsValue(new Integer(-1)))
    	    {
    	    	throw new Exception("The xsd schemas imported or included slump into endless reference circulation");
    	    }
    	    
    	    Map<String, String> nsMap = xsdSchema.getQNamePrefixToNamespaceMap();
    	    int imp = 0;
    	    for (XSDImport xsdImport: imports)
    	    {
    	    	String ns = xsdImport.getNamespace();
    	    	if (ns.equals(""))continue;
    	    	int last = ns.lastIndexOf("/");
    	    	if(!nsMap.containsValue(ns))
    	    	{
    	    		if(ns.equals("http://www.w3.org/XML/1998/namespace"))
    	    		{
    	    			nsMap.put("xml", ns);
    	    		}
    	    		else
    	    		{
    	    			nsMap.put(ns.substring(last+1).replaceAll("[\\W]", ""), ns);
    	    		}
    	    	}
    	    	   
    	    	boolean exist = false;
    	    	for (XSDSchemaContent cnt: xsdSchema.getContents())
    	    	{
    	    		if (cnt instanceof XSDImportImpl)
    	    		{
    	    			XSDImportImpl cntImpl = (XSDImportImpl)cnt;
    	    			if(cntImpl.getNamespace().equals(xsdImport.getNamespace()))
    	    			{
    	    				exist = true;
    	    				break;
    	    			}
    	    		}
    	    	}
    	    	if (!exist)
    	    	{
        	    	xsdSchema.getContents().add(imp++,xsdImport);
    	    	}
    	    }
		    xsdSchema.updateElement();
		    
		return xsdSchema;
    }
    
    private static void importSchema(XSDSchema xsdSchema, List<XSDImport> imports, Map<String, Integer> schemaMonitor)
    {
	    EList<XSDSchemaContent> list = xsdSchema.getContents();
	    for (XSDSchemaContent schemaCnt : list) {
			if (schemaCnt instanceof XSDImport) {
				XSDImportImpl xsdImpl = (XSDImportImpl) schemaCnt;
				if (xsdImpl.getNamespace() == null || xsdImpl.getNamespace().trim().equals(""))
				{
					URI fileURI = URI.createFileURI(xsdImpl.getSchemaLocation());
					xsdImpl.setNamespace(fileURI.toFileString().replaceAll("[\\W]", ""));
				}
				if(xsdImpl.getSchemaLocation() == null)
					continue;
				((XSDImportImpl) schemaCnt).importSchema();
				imports.add(((XSDImportImpl) schemaCnt));
			}
			else if(schemaCnt instanceof XSDInclude)
			{
				XSDIncludeImpl xsdInclude = (XSDIncludeImpl)schemaCnt;
				((XSDSchemaImpl)xsdSchema).included(xsdInclude);
			}
		}
    }
    
    private static XSDSchema getXSDSchema(String rawData,
			final List<XSDImport> imports, final TreeObject treeObj,
			boolean uri, final List<Exception> exceptions,
			final Map<String, Integer> schemaMonitor) throws Exception
    {	
    	FileInputStream fin=null;
    	try {
    	final String xsdFileName = System.getProperty("user.dir")+"/.xsdModel.xml";
    	URI fileURI = URI.createFileURI(xsdFileName);
	    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		documentBuilderFactory.setValidating(false);
		DocumentBuilder documentBuilder;
		XSDSchema schema = null;
		InputSource source = null;
		Document document = null;
		
		documentBuilder = documentBuilderFactory.newDocumentBuilder();
		if(rawData == null) return XSDSchemaImpl.getSchemaForSchema("http://www.w3.org/2001/XMLSchema");
		if(rawData.endsWith(".xsd") && rawData.indexOf(File.separator) > 0)
		{
			File rawFile = new File(rawData);
			if(!rawFile.exists())
			{
				throw new IllegalArgumentException(rawData);
			}
		}
		if(rawData.equals("http://www.w3.org/2001/03/xml.xsd"))
		{
			URL url = new java.net.URI("http://www.w3.org/2001/03/xml.xsd").toURL();
	        uri = false;
	        rawData = IOUtils.toString(url.openConnection().getInputStream());
	        rawData = rawData.replaceAll("<!DOCTYPE(.*?)>", "");
		}
			
		if (uri) {
			File file = new File(rawData);
			if (file.exists()) {
				fin=new FileInputStream(file);
			   source = new InputSource(fin);
			}
			else
				source = new InputSource(new StringReader(Util.getResponseFromURL(rawData, treeObj)));
		} else {
			source = new InputSource(new StringReader(rawData));
		}

		document = documentBuilder.parse(source);
		schema = XSDSchemaImpl.createSchema(document
				.getDocumentElement());
		
	    ResourceSet resourceSet = new ResourceSetImpl();
	    Resource resource = resourceSet.createResource(fileURI);
	    resourceSet.getAdapterFactories().add
	    (
		    new AdapterFactoryImpl()
		    {
		       class SchemaLocator extends AdapterImpl implements XSDSchemaLocator
		       {
		         public XSDSchema locateSchema(XSDSchema xsdSchema, String namespaceURI,  String rawSchemaLocationURI, String resolvedSchemaLocation)
		         {
		        	XSDSchema schema;
		        	Integer rawCnt = schemaMonitor.get(rawSchemaLocationURI);
		        	if (rawCnt == null) {
						rawCnt = 0;
					}
		        	else
		        		rawCnt++;
		        	schemaMonitor.put(rawSchemaLocationURI, rawCnt);
		        	if(rawCnt >= 50)
		        	{
		        		schemaMonitor.put(rawSchemaLocationURI, -1);
		        		return null;
		        	}

					try {
						schema = Util.getXSDSchema(rawSchemaLocationURI, imports, treeObj, true, exceptions, schemaMonitor);
					} catch (Exception e) {
						exceptions.add(e);
						return XSDSchemaImpl.getSchemaForSchema(namespaceURI);
					}
		        	 schema.setTargetNamespace(namespaceURI) ;
				     schema.setElement(schema.getDocument().getDocumentElement());
		        	 return schema;
		         }

		         public boolean isAdatperForType(Object type)
		         {
		           return type == XSDSchemaLocator.class;
		         }
		       }

		       protected SchemaLocator schemaLocator = new SchemaLocator();

		       public boolean isFactoryForType(Object type)
		       {
		         return type == XSDSchemaLocator.class;
		       }

		       public Adapter adaptNew(Notifier target, Object type)
		       {
		         return schemaLocator;
		       }
		    }
	   );
	   schema.setSchemaLocation(fileURI.toString());
	    //set the schema for schema QName prefix to "xsd"
	   schema.setSchemaForSchemaQNamePrefix("xsd");
	   // catch up the NPE to make sure data model can still run in case of unknown conflict
	   try
	   {
	      resource.getContents().add(schema);
	   }
	   catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	    //Add the root schema to the resource that was created above
	    Iterator<Integer> iter = schemaMonitor.values().iterator();
        while(iter.hasNext())
        {
        	Integer it = (Integer)iter.next();
        	if(it.intValue() == -1)
        		return schema;
        }
	    importSchema(schema, imports, schemaMonitor);
	    schema.setElement(document.getDocumentElement());
       return schema; 
    	}finally {
    		if(fin!=null)fin.close();
    	}
    }
    
    public static List<XSDComplexTypeDefinition> getComplexTypes(XSDSchema xsd){
    	    EList<XSDTypeDefinition> contents = xsd.getTypeDefinitions();
   			List<XSDComplexTypeDefinition> complexs=new ArrayList<XSDComplexTypeDefinition>();
   			for(XSDTypeDefinition type: contents){
   				if(type instanceof XSDComplexTypeDefinition){
   					boolean exist = false;
   					for(XSDComplexTypeDefinition xsdEl: complexs)
   					{
   						if (xsdEl.getName().equals(type.getName())
   								&& xsdEl.getTargetNamespace() != null
   								&& type.getTargetNamespace() != null
   								&& xsdEl.getTargetNamespace().equals(
   										type.getTargetNamespace()))
   						{
   							exist = true;
   							break;
   						}
   						else if(xsdEl.getTargetNamespace() == null && type.getTargetNamespace() == null && xsdEl.getName().equals(type.getName()))
   						{
   							exist = true;
   							break;
   						}
   					}
   					if (!exist && (type.getTargetNamespace() != null && !type
							.getTargetNamespace().equals(
									XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001))
					|| type.getTargetNamespace() == null)
   					{
   	   					complexs.add((XSDComplexTypeDefinition)type);
   					}		
   				}
   			}
   			
   			return complexs;
    }
     
    public static String getTmpFolder() {
        String tmp = System.getProperty("user.dir") + "/exist"; //$NON-NLS-1$ //$NON-NLS-2$
        tmp = tmp.replace('\\', '/');
        return tmp;
    }
    
    /**
     * Deletes the temporary files.
     */
    public static void deleteTempFiles() {
        String tmpFold = getTmpFolder();
        File file = new File(tmpFold);
        if (!file.exists() && !file.isDirectory()) {
            return;
        }
        ZipToFile.deleteDirectory(file);
    }
    
    public static String getRealPath(String bundleID, String entry)throws Exception
	 {
		URL urlentry;
		String strEntry;
		
	    Bundle bundle = Platform.getBundle(bundleID);
	
	    // get path URL
	    urlentry = bundle.getEntry(entry);
	
	    strEntry = FileLocator.toFileURL(urlentry).getPath();
		
		return strEntry;
	}
    public static void copyFile(String source, String dest) {
    	 byte[] buf = new byte[1024];
        OutputStream os=null;
        InputStream is=null;
		try {
			os = new BufferedOutputStream(new FileOutputStream(dest));
			is = new BufferedInputStream(new FileInputStream(source));
			int readLen = 0;
			while ((readLen = is.read(buf, 0, 1024)) != -1) {
				os.write(buf, 0, readLen);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        if(is!=null)try{is.close();}catch(Exception e) {};
	        if(os!=null)try{os.close();}catch(Exception e) {};    	
		}
    }
    //key is the objectname, value is revisionids
    public static Map<String, List<String>> getUniverseMap(XtentisPort port){
    	Map<String, List<String>> map=new HashMap<String, List<String>>();
		WSUniversePK[] universePKs = null;
		//boolean hasUniverses = true;
		try {
			universePKs = port.getUniversePKs(new WSGetUniversePKs("*")).getWsUniversePK();
			for(WSUniversePK pk: universePKs){
				WSUniverse universe=port.getUniverse(new WSGetUniverse(pk));
				for(WSUniverseXtentisObjectsRevisionIDs id:universe.getXtentisObjectsRevisionIDs()){
					if(map.get(id.getXtentisObjectName())==null){
						map.put(id.getXtentisObjectName(), new ArrayList<String>());
					}
					if(!map.get(id.getXtentisObjectName()).contains(id.getRevisionID()))
						map.get(id.getXtentisObjectName()).add(id.getRevisionID());					
				}
			}
		} catch (Exception e) {
			System.out.println("No Universes");
		}
    	return map;
    }
    //key is the universename, value is revisionids
    public static Map<String, List<String>> getUniverseMap2(XtentisPort port){
    	Map<String, List<String>> map=new HashMap<String, List<String>>();
		WSUniversePK[] universePKs = null;
		//boolean hasUniverses = true;
		try {
			universePKs = port.getUniversePKs(new WSGetUniversePKs("*")).getWsUniversePK();
			for(WSUniversePK pk: universePKs){
				WSUniverse universe=port.getUniverse(new WSGetUniverse(pk));
				for(WSUniverseXtentisObjectsRevisionIDs id:universe.getXtentisObjectsRevisionIDs()){
					String name=universe.getName();
					if(map.get(name)==null){
						map.put(name, new ArrayList<String>());
					}
					map.get(name).add(id.getRevisionID());					
				}
			}
		} catch (Exception e) {
			System.out.println("No Universes");
		}
    	return map;
    }  
    
    public static List<String> getUniverseBYRevisionID(XtentisPort port,String revisionID,String objectName1){
    	List<String> list = new ArrayList<String>();
    	String objectName =objectName1;
		WSUniversePK[] universePKs = null;
		objectName=EXtentisObjects.getXtentisObjectName(objectName1);
		if(objectName!=null) {
		try {
			universePKs = port.getUniversePKs(new WSGetUniversePKs("*")).getWsUniversePK();
			for(WSUniversePK pk: universePKs){
				WSUniverse universe=port.getUniverse(new WSGetUniverse(pk));
				for(WSUniverseXtentisObjectsRevisionIDs id:universe.getXtentisObjectsRevisionIDs()){
					if(id.getXtentisObjectName().equals(objectName)&&id.getRevisionID().equals(revisionID))
						list.add(universe.getName());	
						
				}
			}
		} catch (Exception e) {
			System.out.println("No Universes");
		}
		}
    	return list;
    }
    public static List<WSUniverse> getWSUniverseBYRevisionID(XtentisPort port,String revisionID,String objectName1){
    	List<WSUniverse> list = new ArrayList<WSUniverse>();
    	String objectName =objectName1;
		WSUniversePK[] universePKs = null;
		if(objectName1.equals("Transformer"))
			objectName ="Transformer V2";
		try {
			universePKs = port.getUniversePKs(new WSGetUniversePKs("*")).getWsUniversePK();
			for(WSUniversePK pk: universePKs){
				WSUniverse universe=port.getUniverse(new WSGetUniverse(pk));
				for(WSUniverseXtentisObjectsRevisionIDs id:universe.getXtentisObjectsRevisionIDs()){
					if(id.getXtentisObjectName().equals(objectName)&&id.getRevisionID().equals(revisionID))
						list.add(universe);	
				}
			}
		} catch (Exception e) {
			System.out.println("No Universes");
		}
    	return list;
    }
    
    public static boolean hasUniverse(TreeObject xobject){
    	if(xobject.isXObject()) return false;
        switch(xobject.getType()) {
	    	case TreeObject.DATA_MODEL:
	       	case TreeObject.VIEW:	           	  
	       	case TreeObject.MENU:
	       	case TreeObject.ROLE:
	       	case TreeObject.ROUTING_RULE:
	       	case TreeObject.SYNCHRONIZATIONPLAN:
	       	case TreeObject.STORED_PROCEDURE:
	       	case TreeObject.TRANSFORMER:
	       		return true;
	       	default:
	       		return false;
        }
    }
    
    public static boolean hasTags(TreeObject xobject){
    	if(xobject.isXObject()) return true;
        switch(xobject.getType()) {
            case TreeObject.DATA_CLUSTER: //is necessary
	    	case TreeObject.DATA_MODEL:
	       	case TreeObject.VIEW:	           	  
	       	case TreeObject.MENU:
	       	case TreeObject.ROLE:
	       	case TreeObject.ROUTING_RULE:
	       	case TreeObject.SYNCHRONIZATIONPLAN:
	       	case TreeObject.STORED_PROCEDURE:
	       	case TreeObject.TRANSFORMER:
	       	case TreeObject.UNIVERSE: //is necessary
	       		return true;
	       	default:
	       		return false;
        }
    }
    
    public static String[] convertWhereCondition(WSWhereCondition wc){
    	List<String> list=new ArrayList<String>();
    	list.add(wc.getLeftPath());
    	String operator ="";
		if (wc.getOperator().equals(WSWhereOperator.CONTAINS)) operator="Contains";
		else if (wc.getOperator().equals(WSWhereOperator.EQUALS)) operator="=";
		else if (wc.getOperator().equals(WSWhereOperator.GREATER_THAN)) operator=">";
		else if (wc.getOperator().equals(WSWhereOperator.GREATER_THAN_OR_EQUAL)) operator=">=";
		else if (wc.getOperator().equals(WSWhereOperator.CONTAINS_TEXT_OF)) operator="Contains Text Of";
		else if (wc.getOperator().equals(WSWhereOperator.JOIN)) operator="Join With";
		else if (wc.getOperator().equals(WSWhereOperator.LOWER_THAN)) operator="<";
		else if (wc.getOperator().equals(WSWhereOperator.LOWER_THAN_OR_EQUAL)) operator="<=";
		else if (wc.getOperator().equals(WSWhereOperator.NOT_EQUALS)) operator="!=";
		else if (wc.getOperator().equals(WSWhereOperator.STARTSWITH)) operator="Starts With";
		else if (wc.getOperator().equals(WSWhereOperator.STRICTCONTAINS)) operator="Strict Contains";
		list.add(operator);
		list.add(wc.getRightValueOrPath());
		
		String predicate="";
		if (wc.getStringPredicate().equals(WSStringPredicate.AND)) predicate="And";
		else if (wc.getStringPredicate().equals(WSStringPredicate.EXACTLY)) predicate="Exactly";
		else if (wc.getStringPredicate().equals(WSStringPredicate.NONE)) predicate="";
		else if (wc.getStringPredicate().equals(WSStringPredicate.NOT)) predicate="Not";
		else if (wc.getStringPredicate().equals(WSStringPredicate.OR)) predicate="Or";
		else if (wc.getStringPredicate().equals(WSStringPredicate.STRICTAND)) predicate="Strict And";
		list.add(predicate);		
    	return list.toArray(new String[list.size()]);
    }
    public static String[] convertRoleWhereCondition(RoleWhereCondition rc){
    	List<String> list=new ArrayList<String>();
    	list.add(rc.getLeftPath());
    	list.add(rc.getOperator());
		list.add(rc.getRightValueOrPath());
		list.add(rc.getPredicate());		
    	return list.toArray(new String[list.size()]);
    }
    public static String[] convertRouteCondition(WSRoutingRuleExpression wc){
    	List<String> list=new ArrayList<String>();
    	list.add(wc.getXpath());
    	String operator ="";
		if (wc.getWsOperator().equals(WSRoutingRuleOperator.CONTAINS)) operator="Contains";
		else if (wc.getWsOperator().equals(WSRoutingRuleOperator.EQUALS)) operator="=";
		else if (wc.getWsOperator().equals(WSRoutingRuleOperator.GREATER_THAN)) operator=">";
		else if (wc.getWsOperator().equals(WSRoutingRuleOperator.GREATER_THAN_OR_EQUAL)) operator=">=";
		else if (wc.getWsOperator().equals(WSRoutingRuleOperator.MATCHES)) operator="Matches";
		else if (wc.getWsOperator().equals(WSRoutingRuleOperator.LOWER_THAN)) operator="<";
		else if (wc.getWsOperator().equals(WSRoutingRuleOperator.LOWER_THAN_OR_EQUAL)) operator="<=";
		else if (wc.getWsOperator().equals(WSRoutingRuleOperator.NOT_EQUALS)) operator="!=";
		else if (wc.getWsOperator().equals(WSRoutingRuleOperator.STARTSWITH)) operator="Starts With";
		else if (wc.getWsOperator().equals(WSRoutingRuleOperator.IS_NULL)) operator="Is Null";
		else if (wc.getWsOperator().equals(WSRoutingRuleOperator.IS_NOT_NULL)) operator="Is Not Null";
		list.add(operator);
		list.add(wc.getValue());
		list.add(wc.getName()==null?"":wc.getName());	
    	return list.toArray(new String[list.size()]);
    }
    public static WSRoutingRuleExpression convertLineRoute(String[] values){
    	WSRoutingRuleExpression wc=new WSRoutingRuleExpression();

		wc.setXpath(values[0]);

		WSRoutingRuleOperator operator = null;
		if (values[1].equals("Contains"))
			operator = WSRoutingRuleOperator.CONTAINS;
		else if (values[1].equals(
				"Matches"))
			operator = WSRoutingRuleOperator.MATCHES;
		else if (values[1].equals("="))
			operator = WSRoutingRuleOperator.EQUALS;
		else if (values[1].equals(">"))
			operator = WSRoutingRuleOperator.GREATER_THAN;
		else if (values[1].equals(">="))
			operator = WSRoutingRuleOperator.GREATER_THAN_OR_EQUAL;
		else if (values[1].equals("<"))
			operator = WSRoutingRuleOperator.LOWER_THAN;
		else if (values[1].equals("<="))
			operator = WSRoutingRuleOperator.LOWER_THAN_OR_EQUAL;
		else if (values[1].equals("!="))
			operator = WSRoutingRuleOperator.NOT_EQUALS;
		else if (values[1].equals(
				"Starts With"))
			operator = WSRoutingRuleOperator.STARTSWITH;
		else if (values[1].equals(
				"Is Null"))
			operator = WSRoutingRuleOperator.IS_NULL;
		else if (values[1].equals("Is Not Null"))
			operator = WSRoutingRuleOperator.IS_NOT_NULL;
		wc.setWsOperator(operator);
		wc.setValue(values[2]);
		wc.setName(values[3]);
    	return wc;
    }
    public static WSWhereCondition convertLine(String[] values){
    	WSWhereCondition wc=new WSWhereCondition();

		wc.setLeftPath(values[0]);

		WSWhereOperator operator = null;
		if (values[1].equals("Contains"))
			operator = WSWhereOperator.CONTAINS;
		else if (values[1].equals(
				"Contains Text Of"))
			operator = WSWhereOperator.CONTAINS_TEXT_OF;
		else if(values[1].equals("Join With")){
			operator = WSWhereOperator.JOIN;
		}
		else if (values[1].equals("="))
			operator = WSWhereOperator.EQUALS;
		else if (values[1].equals(">"))
			operator = WSWhereOperator.GREATER_THAN;
		else if (values[1].equals(">="))
			operator = WSWhereOperator.GREATER_THAN_OR_EQUAL;
		else if (values[1].equals("<"))
			operator = WSWhereOperator.LOWER_THAN;
		else if (values[1].equals("<="))
			operator = WSWhereOperator.LOWER_THAN_OR_EQUAL;
		else if (values[1].equals("!="))
			operator = WSWhereOperator.NOT_EQUALS;
		else if (values[1].equals(
				"Starts With"))
			operator = WSWhereOperator.STARTSWITH;
		else if (values[1].equals(
				"Strict Contains"))
			operator = WSWhereOperator.STRICTCONTAINS;
		wc.setOperator(operator);
		wc.setRightValueOrPath(values[2]);
		WSStringPredicate predicate = null;
		if (values[3].equals(""))
			predicate = WSStringPredicate.NONE;
		else if (values[3].equals("Or"))
			predicate = WSStringPredicate.OR;
		if (values[3].equals("And"))
			predicate = WSStringPredicate.AND;
		if (values[3].equals("Strict And"))
			predicate = WSStringPredicate.STRICTAND;
		if (values[3].equals("Exactly"))
			predicate = WSStringPredicate.EXACTLY;
		if (values[3].equals("Not"))
			predicate = WSStringPredicate.NOT;
		wc.setStringPredicate(predicate);

    	return wc;
    }
    
    public static String getRevision(TreeObject xobject){
        String revision="";
        if(xobject.getType()!=TreeObject.DATA_CLUSTER&&xobject.getType()!=TreeObject.UNIVERSE){
        	TreeParent parent= xobject.findServerFolder(xobject.getType());
        	
        	if(parent !=null){
        		Pattern p=Pattern.compile("\\[.*\\]");
        		Matcher m=p.matcher(parent.getDisplayName());
        		while(m.find()){
        			revision=m.group();
        			break;
        		}
        	}
        }
        return revision;
    }

	public static RoleWhereCondition convertLineToRC(String[] values) {
		RoleWhereCondition rc=new RoleWhereCondition();
		if(values.length==4){
			rc.setLeftPath(values[0]);
			rc.setOperator(values[1]);
			rc.setRightValueOrPath(values[2]);
			rc.setPredicate(values[3]);
		}
		return rc;
	}
	
	private static Pattern pLoad = Pattern.compile(".*?(<c>.*?</t>).*?(<p>(.*)</p>|<p/>).*",Pattern.DOTALL);
	
	public static String getItemContent(String xmlstring){
        Matcher m = null;
        m = pLoad.matcher(xmlstring);
        if (m.matches()) {        	
        	if(m.group(2)==null||m.group(2).equals("<p/>")){
        		return "";
        	}else{
        		return m.group(3);
        	}
        }
        return null;
	}
	public static ArrayList<Object> getComplexTypeDefinitionChildren(XSDComplexTypeDefinition complexTypeDefinition) {
//		System.out.println("getComplexTypeDefinitionChildren "+complexTypeDefinition+": "+complexTypeDefinition.getContent());
		
//		System.out.println(
//				"getComplexTypeDefinitionChildren BASE TYPE "+
//				complexTypeDefinition.getBaseTypeDefinition().getName()+" : "+
//				complexTypeDefinition.getDerivationMethod().getName()
//		);
		
		XSDComplexTypeContent xsdComplexTypeContent = complexTypeDefinition.getContent();
		ArrayList<Object> list = new ArrayList<Object>();
		
		//Now determine whether ref. If ref look at the base Type definition
		if  (xsdComplexTypeContent == null) {
			XSDTypeDefinition typeDefinition = complexTypeDefinition.getBaseTypeDefinition();
			//if a simple type return the simple type
			if (typeDefinition instanceof XSDSimpleTypeDefinition) {
				list.add(typeDefinition);
				return list;
			} else {
			}
			//it is a complex Type
			xsdComplexTypeContent = ((XSDComplexTypeDefinition)typeDefinition).getContent();
		}

		//check if we are extending a complex Definition	
		if ("extension".equals(complexTypeDefinition.getDerivationMethod().getName())) {
			if (complexTypeDefinition.getBaseTypeDefinition() instanceof XSDComplexTypeDefinition) {
				list.addAll(getComplexTypeDefinitionChildren((XSDComplexTypeDefinition)complexTypeDefinition.getBaseTypeDefinition()));
			}
		}
		
		//Attributes
		if (complexTypeDefinition.getAttributeContents()!=null)
			list.addAll(complexTypeDefinition.getAttributeContents());
		
		//Annotations
		if (complexTypeDefinition.getAnnotations()!=null)
			list.addAll(complexTypeDefinition.getAnnotations());
			
		//now check what we have in the content
			
		//simple type return the simple type
		if (xsdComplexTypeContent instanceof XSDSimpleTypeDefinition) {
			list.add(xsdComplexTypeContent);
			return list;
		}
		
		//xsd Particle: we have a model group
		if (xsdComplexTypeContent instanceof XSDParticle) { 
//				System.out.println("Model Group?: "+((XSDParticle)xsdComplexTypeContent).getTerm());
				if (((XSDParticle)xsdComplexTypeContent).getTerm() instanceof XSDModelGroup) {
					//return the model group
					list.add(((XSDParticle)xsdComplexTypeContent).getTerm());
					return list;
				} else {  //wild card or element declaration '?)
					list.add(((XSDParticle)xsdComplexTypeContent).getTerm());
					return list;						
				}
		}
		
		//what else could it be ?
		list.add(xsdComplexTypeContent);
		return list;
	}	
	
	public static List<String> getConcepts(XSDSchema schema){
		EList xsdElementDeclarations = schema.getElementDeclarations();
		List<String> list=new ArrayList<String>();
		for(XSDElementDeclaration el: (XSDElementDeclaration[])xsdElementDeclarations.toArray(new XSDElementDeclaration[xsdElementDeclarations.size()] )){
			if(!el.getIdentityConstraintDefinitions().isEmpty()){
				list.add(el.getName());
			}
		}
		return list;
	}

	/**
	 * Returns and XSDSchema Object from an xsd
	 * 
	 * @param schema
	 * @return
	 * @throws Exception
	 */
	public static XSDSchema getXSDSchema(String schema) throws Exception {
	    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		documentBuilderFactory.setValidating(false);
		StringReader reader=new StringReader(schema);
		InputSource source = new InputSource(new StringReader(schema));
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(source);
		XSDSchema xsdSchema=null;

		xsdSchema = XSDSchemaImpl.createSchema(document
					.getDocumentElement());
		reader.close();		
		return xsdSchema;
	}
	private static String ENTERPRISE_ID="org.talend.mdm.workbench.enterprise";
	public static boolean IsEnterPrise(){
		return Platform.getBundle(ENTERPRISE_ID)!=null;
	}
	public static String getNewLabelString(String oldString) {
		String newLabel=null;
		newLabel=EXtentisObjects.getXtentisObjectDisplayName(oldString);
		if("Routing Engine V2".equals(oldString)) {
			newLabel=EXtentisObjects.SubscriptionEngine.getDisplayName();
		}
		if(newLabel==null)
			return oldString;
		else
			return newLabel;
	}
	public static Image getMenuImage(String menuName){
		String menu= EImage.MENU.getPath();
		if(menuName.startsWith("Browse"))
			menu=EImage.BROWSE_MENU.getPath();
		else if(menuName.equalsIgnoreCase("Cross Referencing"))
			menu=EImage.CROSSREF.getPath();
		else if(menuName.equalsIgnoreCase("Hierarchical View"))
			menu=EImage.HIER_VIEW.getPath();
		else if(menuName.equalsIgnoreCase("ItemsTrash"))
			menu=EImage.TRASH.getPath();
		else if(menuName.equalsIgnoreCase("logging"))
			menu=EImage.MENU.getPath();
		else if(menuName.equalsIgnoreCase("Manage users"))
			menu=EImage.MANAGE_USERS.getPath();
		else if(menuName.equalsIgnoreCase("Reporting"))
			menu=EImage.REPORTING.getPath();
		else if(menuName.equalsIgnoreCase("Service Schedule"))
			menu=EImage.MENU.getPath();
		else if(menuName.equalsIgnoreCase("SynchronizationAction"))
			menu=EImage.SYNCHRONIZE.getPath();
		else if(menuName.equalsIgnoreCase("SynchronizationItem"))
			menu=EImage.SYNCHRO_ITEM.getPath();
		else if(menuName.equalsIgnoreCase("Universe Manager"))
			menu=EImage.UNIVERSE.getPath();
		else if(menuName.equalsIgnoreCase("UpdateReport"))
			menu=EImage.UPDATEREPORT.getPath();
		else if(menuName.equalsIgnoreCase("WorkflowTasks"))
			menu=EImage.WORKFLOWTASKS.getPath();
		return	ImageCache.getImage(menu).createImage();
	}
	public static String formatXsdSource(String xsdSource) {
		try {
			SAXReader reader = new SAXReader();
			org.dom4j.Document document = reader.read(new StringReader(xsdSource));
			StringWriter writer = new StringWriter();
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			XMLWriter xmlwriter = new XMLWriter(writer, format);
			xmlwriter.write(document);
			String str= writer.toString();
			writer.close();
			xmlwriter.close();
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xsdSource;

	}	
//add this method for the text drop action of all the texts available.	
	public static void createCompDropTarget(final Text text) {
		DropTarget dropTarget = new DropTarget(text,  DND.DROP_MOVE|DND.DROP_LINK);
		dropTarget.setTransfer(new TreeObjectTransfer[] { TreeObjectTransfer.getInstance() });
		dropTarget.addDropListener(new DropTargetAdapter() {

			public void dragEnter(DropTargetEvent event) {
			}
			public void dragLeave(DropTargetEvent event) {
			}
			public void dragOver(DropTargetEvent event) {
				event.feedback |= DND.FEEDBACK_EXPAND | DND.FEEDBACK_SCROLL;
			}
			
			public void drop(DropTargetEvent event) {
				if (event.data instanceof TreeObject[])
					text.setText(text.getText()+((TreeObject[])event.data)[0].getDisplayName());	
			}
		});
		
	}
	
	
	public static boolean checkInCOpyTypeParticle(Object[] selectedObjs){
		for (Object obj : selectedObjs) {
			if (obj instanceof XSDParticle)
				continue;
			else 
				return false;
		}

		return true;
	}
	
	public static boolean checkInCopyTypeElement(Object[] selectedObjs){
		/*if(selectedObjs.length>1)
			displayName = "Copy Entities";*/
		for (Object obj : selectedObjs) {
			if (obj instanceof XSDElementDeclaration)
				continue;
			else 
				return false;
		}

		return true;
	}
	
	public static boolean checkInCopy(Object[] selectedObjs){
		return checkInCopyTypeElement(selectedObjs)||checkInCOpyTypeParticle(selectedObjs);
	}
	
    public static String checkOnVersionCompatibility(String url,String username, String password, String universe)
    {
    	IProduct product = Platform.getProduct();
    	String versionComp = "";
        try {
        	URL resourceURL = product.getDefiningBundle().getResource("/about.mappings");
        	PropertyResourceBundle bundle = new PropertyResourceBundle(resourceURL.openStream());
        	String studioVersion = bundle.getString("1").trim();
        	Pattern vsnPtn = Pattern.compile("^(\\d+)\\.(\\d+)(\\.)*(\\d*)$");
        	Matcher match = vsnPtn.matcher(studioVersion);
        	if(!match.find())
        	{
        		return null;
        	}
        	versionComp = "MDM studio & MDM server is not compatible. The MDM studio is " + studioVersion + " ";
        	
        	int major =  Integer.parseInt(match.group(1));
        	int minor = Integer.parseInt(match.group(2));
        	int rev = match.group(4) != null && !match.group(4).equals("") ? Integer.parseInt(match.group(4)) : 0;
			XtentisPort port = Util.getPort(new URL(url),universe, username, password);
			WSVersion wsVersion = port.getComponentVersion(new WSGetComponentVersion(WSComponent.DataManager,null));
			versionComp += " while the MDM server is " + wsVersion.getMajor() + "." + wsVersion.getMinor() + "." + wsVersion.getRevision();
			if(major != wsVersion.getMajor() || minor != wsVersion.getMinor())return versionComp;
			if(rev == 0)
			{
				// major version compare
				if(wsVersion.getRevision() != 0)
					return versionComp;
			}
		} catch (Exception e) {

		}
    	return null;
    }
    public static byte[] getBytesFromFile(File f){
        if (f == null)  {
            return null;
        }
        try  {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e)  {
        }
        return null;
    }
}
