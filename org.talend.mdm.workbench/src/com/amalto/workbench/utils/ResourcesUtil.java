package com.amalto.workbench.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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

public class ResourcesUtil {
	
	// Handle it using an HTTP client connector
	private static final String dmURI="/pubcomponent/secure/dataModels";
	private static final String cmURI="/pubcomponent/secure/customTypesSets";
	private static final String picURI="/pubcomponent/secure/pictures";

    
	   

    public static void main(String[] args) {

//init();
        
//    	getXMLString("http://localhost:8080"+picURI);
//getResourcesNameListFromURI("http://localhost:8080"+cmURI);
//getResourcesMapFromURI("http://localhost:8080"+cmURI);
try {
	postResourcesFromFile("demo2","d:/bud.xsd","http://localhost:8080"+cmURI);
} catch (Exception e) {
	e.printStackTrace();
}
    }
    
    

    
    
private static String getXMLString(String uri) {
    DefaultHttpClient httpclient = new DefaultHttpClient();

    httpclient.getCredentialsProvider().setCredentials(
            new AuthScope(getEndpointHost(uri),Integer.valueOf(getEndpointPort(uri))), 
            new UsernamePasswordCredentials("admin", "talend"));
    
    HttpGet httpget = new HttpGet(uri);
    
    System.out.println("executing request" + httpget.getRequestLine());

    // Create a response handler
    ResponseHandler<String> responseHandler = new BasicResponseHandler();
    String responseBody ="";
	try {
		responseBody = httpclient.execute(httpget, responseHandler);
	} catch (ClientProtocolException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
    httpclient.getConnectionManager().shutdown();      
    return responseBody;

}





    public static HashMap<String,String> getResourcesMapFromURI(String uri) {
    	HashMap<String, String> contentMap=new HashMap<String, String>();
    	String responseBody=getXMLString(uri);
    	Document document=parsXMLString(responseBody);
    	for (Iterator iterator = document.getRootElement().elementIterator("entry"); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			Element nameElement=element.element("name");
			Element uriElement=element.element("uri");
			if(nameElement!=null&&uriElement!=null){
				contentMap.put(nameElement.getStringValue(),uriElement.getStringValue());
			}
			else{
				contentMap.put(element.getStringValue(),uri+"/"+element.getStringValue());
			}
		}
		return contentMap;   	
    }






	public static List<String> getResourcesNameListFromURI(String uri)  throws Exception{
    	List<String> nameList=new ArrayList<String>();
    	String responseBody=getXMLString(uri);
//    	nameList=getNameList(responseBody);
    	Document document=parsXMLString(responseBody);
    	for (Iterator iterator = document.getRootElement().elementIterator("entry"); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			Element nameElement=element.element("name");
			if(nameElement!=null){
				nameList.add(nameElement.getStringValue());
			}
			else{
				nameList.add(element.getStringValue());
			}
		}
    	return nameList; 
    	
    }
	public static void postResourcesFromFile(String typeName,String pathName,String uri) throws Exception  {
		File file=new File(pathName);
		FileReader fr=new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		postResourcesFromContentString(br.readLine(),uri,typeName);
		br.close();
		fr.close();
		
	}
	public static void postPicFromFile(String typeName,String pathName,String uriPre) throws Exception  {
		String content=readFileAsString(pathName);
		String uri=uriPre+"/imageserver/secure/ImageUploadServlet";
//		String uri=uriPre+picURI;
		postResourcesFromContentString(content,uri,typeName);
	}
	 private static String readFileAsString(String fileName) throws Exception {  
		             FileInputStream fis = new FileInputStream(fileName);  
		             BufferedInputStream in = new BufferedInputStream(fis);  
		             byte buffer[] = new byte[256];  
		             StringBuffer picStr=new StringBuffer();  
		             BASE64Encoder base64=new BASE64Encoder();  
		             while (in.read(buffer)>= 0){  
		                 picStr.append(base64.encode(buffer));  
		             }  
		             fis.close();  
		             fis=null;  
		             in.close();  
		             in=null;  
		             buffer=null;  
		             return picStr.toString();  
		         }  
	public static void postResourcesFromContentString(String content,String uri,String typeName)  throws Exception{
		System.out.println(content);
		HttpPost httppost = new HttpPost(uri);
		List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
		nvps.add(new BasicNameValuePair("domainObjectName", typeName));
		nvps.add(new BasicNameValuePair("domainObjectContent", content));
		httppost.setEntity(new UrlEncodedFormEntity( nvps, HTTP.UTF_8));
		postContent(uri,httppost);
	}
	
	private static void postContent(String uri, HttpPost httppost) throws Exception, IOException {
	    DefaultHttpClient httpclient = new DefaultHttpClient();

	    httpclient.getCredentialsProvider().setCredentials(
	            new AuthScope(getEndpointHost(uri),Integer.valueOf(getEndpointPort(uri))), 
	            new UsernamePasswordCredentials("admin", "talend"));
	    
	    System.out.println("executing request" + httppost.getRequestLine());
	    HttpResponse response = httpclient.execute(httppost);
	    HttpEntity entity = response.getEntity();

	        try{
	            Header[] headers = response.getAllHeaders();                    
	            String responseString = null;
	            if (response.getEntity() != null) {
	            responseString = EntityUtils.toString(response.getEntity());      
	            }
	        } finally {
	            if (entity != null)                          
	            entity.consumeContent();                                                   // release connection gracefully
	        }
	        if (entity != null) {
	        entity.consumeContent();
	        }
	    
	    httpclient.getConnectionManager().shutdown();      
	}





	private static Document parsXMLString(String responseBody) {
        SAXReader saxReader = new SAXReader();   
        Document document = null;   
        try  
        {   
            document = saxReader.read(new StringReader(responseBody));   
        } catch (DocumentException e)   
        {   
            e.printStackTrace();   
            return null;   
        }
		return document;
		
	}


	public static String getEndpointHost(String uri) {
		
		
		if(uri!=null){
			int startPos=uri.indexOf("//")+2;
			int endPos=uri.indexOf(":",startPos);
			if(endPos!=-1&&startPos!=-1)
				return uri.substring(startPos, endPos);
		}
		
		return uri;
	}	
	
	public static String getEndpointPort(String uri) {
		
		
		if(uri!=null){
			String[] splitString=uri.split(":",3);
			if(splitString[splitString.length-1]!=null)
				return splitString[2].substring(0, splitString[2].indexOf("/"));
		}
		
		return uri;
	}		
}
