/*
 * Created on 22 sept. 2005
 *
 */
package com.amalto.workbench.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSComponent;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSGetComponentVersion;
import com.amalto.workbench.webservices.WSGetViewPKs;
import com.amalto.workbench.webservices.WSRegexDataClusterPKs;
import com.amalto.workbench.webservices.WSRegexDataModelPKs;
import com.amalto.workbench.webservices.WSVersion;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.XtentisPort;
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
	


	
	public static String default_endpoint_address = "http://localhost:8080/xtentis/XtentisPort";
	
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
			Stub stub = (Stub) (new XtentisService_Impl()).getXtentisPort();
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
					"Unable to retrieve all Data Cluster Names"
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
	
	public static String getXML(Class<? extends Object> c, String filename) throws Exception{
	    BufferedReader in = null;
        in = new BufferedReader(
        			new InputStreamReader(
        			        c.getResourceAsStream(filename)
        			)
        );
	
	    String xml="";
        String line;
        while ((line=in.readLine())!=null) xml+=line+"\n";
        return xml;
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
    public static String uploadFileToAppServer(String URL, String localFilename, String username, String password)  throws XtentisException{
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
        
            mppost.addParameter(localFilename,new File(localFilename));
            
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
     * @param schema
     *            to search for elemDecls
     * @param namespace
     *            for the type used
     * @param localName
     *            for the type used
     * @return List of any XSDElementDeclarations found
     */
    public static List<XSDElementDeclaration> findElementsUsingType(XSDSchema schema, String namespace, String localName)   {
    	if (null == localName)  	{
    		throw new IllegalArgumentException("findElementsUsingType called with null localName");
    	}
    	
    	ArrayList<XSDElementDeclaration> elemsUsingType = new ArrayList<XSDElementDeclaration>();
    	
    	// A handy convenience method quickly gets all
    	// elementDeclarations within our schema; note that
    	// whether or not this returns types in included,
    	// imported, or redefined schemas is subject to change
    	List<XSDElementDeclaration> elemDecls = schema.getElementDeclarations();
    	
    	for (Iterator<XSDElementDeclaration> iter = elemDecls.iterator(); iter.hasNext(); /* no-op */)  	{
    		XSDElementDeclaration elem = iter.next();
    		XSDTypeDefinition typedef = null;
    		if (elem.getAnonymousTypeDefinition() != null)	{
    			typedef = elem.getAnonymousTypeDefinition();
    		} else if (elem.getTypeDefinition() != null) {
    			typedef = elem.getTypeDefinition();
    		} else	{
    			// Element is not complete, since it has no type,
    			// thus it's not using our type
    			continue;
    		}
    		
    		// Ask this type and walk the baseTypes from this
    		// typedef seeing if any of them match the requested one
    		if (typedef.hasNameAndTargetNamespace(localName, namespace)
    				|| isTypeDerivedFrom(typedef, namespace, localName))
    		{
    			// We found it, return the element and continue
    			elemsUsingType.add(elem);
    			continue;
    		}
    	}
        return elemsUsingType;
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
    

}
