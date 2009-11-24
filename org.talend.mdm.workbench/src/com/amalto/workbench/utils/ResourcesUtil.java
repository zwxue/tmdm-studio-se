package com.amalto.workbench.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class ResourcesUtil {
	
	// Handle it using an HTTP client connector
	private static final String dmURI="/pubcomponent/secure/customTypesSets";
	private static final String picURI="/pubcomponent/secure/pictures";

    
	   

    public static void main(String[] args) throws Exception {

//init();
    
//    	    	getXMLString("http://localhost:8080"+picURI);
    	getResourcesNameListFromURI("http://localhost:8080"+picURI);
//    	getResourcesMapFromURI("http://localhost:8080"+picURI);
    }
    
    

    
    
private static String getXMLString(String uri) {
    DefaultHttpClient httpclient = new DefaultHttpClient();

    httpclient.getCredentialsProvider().setCredentials(
            new AuthScope("localhost", 8080), 
            new UsernamePasswordCredentials("admin", "talend"));
    
    HttpGet httpget = new HttpGet(uri);
    
    System.out.println("executing request" + httpget.getRequestLine());
//    HttpResponse response = httpclient.execute(httpget);
//    HttpEntity entity = response.getEntity();

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
    System.out.println(responseBody);
    
    System.out.println("----------------------------------------");
    httpclient.getConnectionManager().shutdown();      
    return responseBody;

}





    public static HashMap<String,String> getResourcesMapFromURI(String uri) {
    	HashMap<String, String> contentMap=new HashMap<String, String>();
    	String responseBody=getXMLString(uri);
    	Document document=parsXMLString(responseBody);
        List<Node> nodes = XmlUtil.queryList(document, "/list/entry");
        for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
  		Node node = (Node) iterator.next();
  		contentMap.put(node.selectSingleNode("name").getStringValue(),node.selectSingleNode("uri").getStringValue());
  		System.out.println(node.selectSingleNode("name").getStringValue());
  		System.out.println(node.selectSingleNode("uri").getStringValue());
  	}
		return contentMap;   	
    }






	public static List<String> getResourcesNameListFromURI(String uri)  throws Exception{
    	List<String> nameList=new ArrayList<String>();
    	String responseBody=getXMLString(uri);
//    	nameList=getNameList(responseBody);
    	Document document=parsXMLString(responseBody);
        List<Node> nodes = XmlUtil.queryList(document, "/list/entry/name");
        for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
  		Node node = (Node) iterator.next();
  		nameList.add(node.getStringValue());
  		System.out.println(node.getStringValue());
  	}
    	return nameList; 
    	
    }
/*
    private static List<String> getNameList(String responseBody) {
    	List<String> nameList=new ArrayList<String>();
    	Document document=parsXMLString(responseBody);
       List<Node> nodes = XmlUtil.queryList(document, "/list/entry/name");
      for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
		Node node = (Node) iterator.next();
		nameList.add(node.getStringValue());
		System.out.println(node.getStringValue());
	}
		return nameList;   
		
	}*/

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


	public String getEndpointHost(String uri) {
		
		
		if(uri!=null){
			int startPos=uri.indexOf("://");
			int endPos=uri.indexOf(":",startPos);
			if(endPos!=-1&&startPos!=-1)
				return uri.substring(startPos, endPos);
		}
		
		return uri;
	}	
	
	public String getEndpointPort(String uri) {
		
		
		if(uri!=null){
			String[] splitString=uri.split(":",2);
			if(splitString[2]!=null)
				return splitString[2].substring(0, splitString[2].indexOf("/"));
		}
		
		return uri;
	}		
}
