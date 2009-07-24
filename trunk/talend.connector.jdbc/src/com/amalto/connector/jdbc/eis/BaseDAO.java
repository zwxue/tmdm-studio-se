package com.amalto.connector.jdbc.eis;

import java.util.Properties;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.connector.jca.XtentisConnectorException;
import com.amalto.connector.mail.Util;

public class BaseDAO extends SqlAgent{
	
	private static Logger logger = Logger.getLogger(BaseDAO.class);
	
	//TODO add select function
	private static final String OPERATIONTYPE_SELECT = "SELECT";
	
	private static final String OPERATIONTYPE_INSERT = "INSERT";
	
	private static final String OPERATIONTYPE_UPDATE = "UPDATE";
	
	private static final String OPERATIONTYPE_DELETE = "DELETE"; 
	
	public BaseDAO(String driverClassName, String url) {
		super(driverClassName,url);
	}
	
	public BaseDAO(String driverClassName,Properties properties, String url) {
		super(driverClassName,properties,url);
	}
	
	
	public BaseDAO(String driverClassName,String url, String username,String password) {
		super(driverClassName,url,username,password);
	}
	
	public void update(String todoXml) throws XtentisConnectorException {
		if(todoXml==null||todoXml.length()==0)return;
		Document actionDoc = Util.parse(todoXml);
        String operationType = Util.getFirstTextNode(actionDoc, "//operation"); 
		//parse operation type
		if(operationType==null||operationType.length()==0)throw new XtentisConnectorException("Parse update action failed! ");
		if(operationType.equals("INSERT")){
			String content = Util.getFirstTextNode(actionDoc, "//part/content"); 
			doInsert(content);
		}else if(operationType.equals("UPDATE")){
			
		}else if(operationType.equals("DELETE")){
			
		}

	}
	
	private void doInsert(String insertXmlContent) throws XtentisConnectorException {
		if(insertXmlContent==null||insertXmlContent.length()==0)return;
		String actionContent=StringEscapeUtils.unescapeXml(insertXmlContent);
		//build xml 2 sql And parse mapping rule
		
		Document actionContentDoc=Util.parse(actionContent);
		NodeList conceptList=Util.getNodeList(actionContentDoc, "//*[@mapping-table]");
		for (int i = 0; i < conceptList.getLength(); i++) {
			
			String insertSql=" insert into ";
			String fields=" (";
			String values=" values (";
			
			Node concept=conceptList.item(i);
			String tableName=Util.getFirstTextNode(concept, "./@mapping-table");
			insertSql+=tableName;
			NodeList elementList=Util.getNodeList(concept, "./*[@mapping-field]");
			for (int j = 0; j < elementList.getLength(); j++) {
				Node elem=elementList.item(j);
				String fieldName=Util.getFirstTextNode(elem, "./@mapping-field");
				String insertValue=elem.getTextContent();
				
				//insertValue.replaceAll("\"", "\\\"");
				
				if(j<elementList.getLength()-1){
					fields+=fieldName+",";
					values+=insertValue+",";
				}else{
					fields+=fieldName;
					values+=insertValue;
				}
				
			}
			fields+=") ";
			values+=") ";
			insertSql=insertSql+fields+values;
			logger.debug(insertSql);
            //do insert
			super.exeUpdateCommand(insertSql);
		}

	}



}
