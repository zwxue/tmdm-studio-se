package com.amalto.workbench.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import sun.misc.BASE64Encoder;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.models.TreeObject;

public class ResourcesUtil {

    private static Log log = LogFactory.getLog(ResourcesUtil.class);

    // Handle it using an HTTP client connector
    private static final String dmURI = "/pubcomponent/secure/dataModels";//$NON-NLS-1$

    private static final String cmURI = "/pubcomponent/secure/customTypesSets";//$NON-NLS-1$

    private static final String picURI = "/pubcomponent/secure/pictures";//$NON-NLS-1$

    public static void main(String[] args) {

        // init();

        // getXMLString("http://localhost:8080"+picURI);
        // getResourcesNameListFromURI("http://localhost:8080"+cmURI);
        // getResourcesMapFromURI("http://localhost:8080"+cmURI);
        try {
            postResourcesFromFile("demo2", "d:/bud.xsd", "http://localhost:8080" + cmURI);//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public static byte[] getResourceFile(String uri) {

        HttpClient httpClient = new HttpClient();

        GetMethod getMethod = new GetMethod(uri);

        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        try {
            httpClient.setConnectionTimeout(60000);
            httpClient.getState().setAuthenticationPreemptive(true);
            httpClient.getState().setCredentials(null, null,
                    new org.apache.commons.httpclient.UsernamePasswordCredentials("admin", "talend"));//$NON-NLS-1$//$NON-NLS-2$

            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + getMethod.getStatusLine()); //$NON-NLS-1$
            }

            byte[] responseBody = getMethod.getResponseBody();
            return responseBody;
        } catch (HttpException e) {

            // log.error("Please check your provided http address!");
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            getMethod.releaseConnection();
        }
        return null;
    }

    public static InputStream getFile(String uri) {
        HttpClient client = new HttpClient();
        GetMethod get = new GetMethod(uri);
        try {
            client.executeMethod(get);
            return get.getResponseBodyAsStream();
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.error(e.getMessage(), e);
        }
        return null;
    }

    private static String getXMLString(String uri, TreeObject treeObject) throws GeneralSecurityException {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        httpclient = HttpClientUtil.enableSSL(httpclient, uri);
        httpclient.getCredentialsProvider().setCredentials(
                new AuthScope(getEndpointHost(uri), Integer.valueOf(getEndpointPort(uri))),
                new UsernamePasswordCredentials(treeObject.getUsername(), treeObject.getPassword()));

        HttpGet httpget = new HttpGet(uri);

        log.info(Messages.ResourcesUtil_Loginfo + httpget.getRequestLine());

        // Create a response handler
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = "";//$NON-NLS-1$
        try {
            responseBody = httpclient.execute(httpget, responseHandler);
        } catch (ClientProtocolException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        httpclient.getConnectionManager().shutdown();
        return responseBody;

    }

    public static HashMap<String, String> getResourcesMapFromURI(String uri, TreeObject treeObject)
            throws GeneralSecurityException {
        HashMap<String, String> contentMap = new HashMap<String, String>();
        String responseBody = getXMLString(uri, treeObject);
        Document document = parsXMLString(responseBody);
        if (document == null) {
            return contentMap;
        }
        for (Iterator iterator = document.getRootElement().elementIterator("entry"); iterator.hasNext();) {//$NON-NLS-1$
            Element element = (Element) iterator.next();
            Element nameElement = element.element("name");//$NON-NLS-1$
            Element uriElement = element.element("uri");//$NON-NLS-1$
            if (nameElement != null && uriElement != null) {
                contentMap.put(nameElement.getStringValue(), uriElement.getStringValue());
            } else {
                contentMap.put(element.getStringValue(), uri + "/" + element.getStringValue());//$NON-NLS-1$
            }
        }
        return contentMap;
    }

    public static List<String> getResourcesNameListFromURI(String uri, TreeObject treeObject) throws Exception {
        List<String> nameList = new ArrayList<String>();
        String responseBody = getXMLString(uri, treeObject);
        // nameList=getNameList(responseBody);
        Document document = parsXMLString(responseBody);
        if (document == null) {
            return nameList;
        }
        for (Iterator iterator = document.getRootElement().elementIterator("entry"); iterator.hasNext();) {//$NON-NLS-1$
            Element element = (Element) iterator.next();
            Element nameElement = element.element("name");//$NON-NLS-1$

            if (nameElement != null) {
                nameList.add(nameElement.getStringValue());
            } else {
                nameList.add(element.getStringValue());
            }
        }
        return nameList;

    }

    public static void postResourcesFromFile(String typeName, String pathName, String uri) throws Exception {
        File file = new File(pathName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        postResourcesFromContentString(br.readLine(), uri, typeName);
        br.close();
        fr.close();

    }

    // it does not work,there is already a method "uploadImageFile" in Util,
    // developer can use that method to upload a image file.
    /*
     * public static void postPicFromFile(String typeName,String pathName,String uriPre) throws Exception { String
     * content=readFileAsString(pathName); String uri=uriPre+"imageserver/secure/ImageUploadServlet"; // String
     * uri=uriPre+picURI; postResourcesFromContentString(content,uri,typeName); }
     */
    private static String readFileAsString(String fileName) throws Exception {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream in = new BufferedInputStream(fis);
        byte buffer[] = new byte[256];
        StringBuffer picStr = new StringBuffer();
        BASE64Encoder base64 = new BASE64Encoder();
        while (in.read(buffer) >= 0) {
            picStr.append(base64.encode(buffer));
        }
        fis.close();
        fis = null;
        in.close();
        in = null;
        buffer = null;
        return picStr.toString();
    }

    public static void postResourcesFromContentString(String content, String uri, String typeName) throws Exception {
        log.info(content);
        HttpPost httppost = new HttpPost(uri);
        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
        nvps.add(new BasicNameValuePair("domainObjectName", typeName));//$NON-NLS-1$
        nvps.add(new BasicNameValuePair("domainObjectContent", content));//$NON-NLS-1$
        httppost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        postContent(uri, httppost);
    }

    private static void postContent(String uri, HttpPost httppost) throws Exception, IOException {
        DefaultHttpClient httpclient = new DefaultHttpClient();

        httpclient.getCredentialsProvider().setCredentials(
                new AuthScope(getEndpointHost(uri), Integer.valueOf(getEndpointPort(uri))),
                new UsernamePasswordCredentials("admin", "talend"));//$NON-NLS-1$//$NON-NLS-2$

        log.info(Messages.ResourcesUtil_Loginfo + httppost.getRequestLine());
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        try {
            Header[] headers = response.getAllHeaders();
            String responseString = null;
            if (response.getEntity() != null) {
                responseString = EntityUtils.toString(response.getEntity());
            }
        } finally {
            if (entity != null) {
                entity.consumeContent(); // release connection gracefully
            }
        }
        if (entity != null) {
            entity.consumeContent();
        }

        httpclient.getConnectionManager().shutdown();
    }

    private static Document parsXMLString(String responseBody) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(new StringReader(responseBody));
        } catch (DocumentException e) {

            return null;
        }
        return document;

    }

    public static String getEndpointHost(String uri) {

        if (uri != null) {
            int startPos = uri.indexOf("//") + 2;//$NON-NLS-1$
            int endPos = uri.indexOf(":", startPos);//$NON-NLS-1$
            if (endPos != -1 && startPos != -1) {
                return uri.substring(startPos, endPos);
            }
        }

        return uri;
    }

    public static String getEndpointPort(String uri) {

        if (uri != null) {
            String[] splitString = uri.split(":", 3);//$NON-NLS-1$
            if (splitString[splitString.length - 1] != null) {
                return splitString[2].substring(0, splitString[2].indexOf("/"));//$NON-NLS-1$
            }
        }

        return uri;
    }
}
