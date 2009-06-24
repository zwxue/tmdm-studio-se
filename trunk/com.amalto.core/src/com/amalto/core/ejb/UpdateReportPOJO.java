package com.amalto.core.ejb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;

public class UpdateReportPOJO {
	
	public final static String SOURCE_GENERICUI="genericUI";

	public final static String SOURCE_ADMINWORKBENCH="adminWorkbench";
	
	public final static String OPERATIONTYPE_CREATE="CREATE";
	
	public final static String OPERATIONTYPE_UPDATEE="UPDATE";
	
	private String source;
	
	private long timeInMillis;
	
	private String operationType;
	
	private String concept;
	
	private String key;
	
	private Map<String,UpdateReportItemPOJO> updateReportItemsMap;

	public UpdateReportPOJO(String concept, String key, String operationType,String source, long timeInMillis) {
		super();
		this.concept = concept;
		this.key = key;
		this.operationType = operationType;
		this.source = source;
		this.timeInMillis = timeInMillis;
	}
	
	
	public UpdateReportPOJO(String concept, String key, String operationType,
			String source, long timeInMillis,Map<String,UpdateReportItemPOJO> updateReportItemsMap) {
		this(concept,key,operationType,source,timeInMillis);
		if(updateReportItemsMap==null){
			updateReportItemsMap=new HashMap<String,UpdateReportItemPOJO>();
		}else{
			this.updateReportItemsMap=updateReportItemsMap;
		}
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public long getTimeInMillis() {
		return timeInMillis;
	}


	public void setTimeInMillis(long timeInMillis) {
		this.timeInMillis = timeInMillis;
	}


	public String getOperationType() {
		return operationType;
	}


	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}


	public String getConcept() {
		return concept;
	}


	public void setConcept(String concept) {
		this.concept = concept;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public Map<String,UpdateReportItemPOJO> getUpdateReportItemsMap() {
		if(updateReportItemsMap==null)return new HashMap<String,UpdateReportItemPOJO>();
		return updateReportItemsMap;
	}


	public void setUpdateReportItemsMap(Map<String,UpdateReportItemPOJO> updateReportItemsMap) {
		this.updateReportItemsMap = updateReportItemsMap;
	}
	
	public String serialize(){
		
		StringBuffer log=new StringBuffer();
		log.append("<Update>\n")
		   .append("<Source>").append(this.source).append("</Source>\n")
		   .append("<TimeInMillis>").append(this.timeInMillis).append("</TimeInMillis>\n")
		   .append("<OperationType>").append(StringEscapeUtils.escapeXml(this.operationType)).append("</OperationType>\n")
		   .append("<Concept>").append(StringEscapeUtils.escapeXml(this.concept)).append("</Concept>\n")
		   .append("<Key>").append(StringEscapeUtils.escapeXml(this.key)).append("</Key>\n");
		   
		
	   if(OPERATIONTYPE_UPDATEE.equals(operationType)){
		   Map<String,UpdateReportItemPOJO> map = this.updateReportItemsMap==null?new HashMap<String,UpdateReportItemPOJO>():this.updateReportItemsMap;
		   for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
			   String key = iterator.next();
			   UpdateReportItemPOJO item = map.get(key);
			   log.append(item.serialize());		            
		   }
		}
		
	   log.append("</Update>");
        
       return log.toString();
    }
	
	public static void main(String[] args) {
		
		Map<String,UpdateReportItemPOJO> itemsMap =new HashMap<String,UpdateReportItemPOJO>();
		UpdateReportItemPOJO updateReportItemPOJO1=new UpdateReportItemPOJO("/root/part1","v0","v1");
		UpdateReportItemPOJO updateReportItemPOJO2=new UpdateReportItemPOJO("/root/part2","v2","v3");
		itemsMap.put("/root/part1",updateReportItemPOJO1);
		itemsMap.put("/root/part2",updateReportItemPOJO2);
		
		UpdateReportPOJO updateReportPOJO=new UpdateReportPOJO("concept1", "a.1", UpdateReportPOJO.OPERATIONTYPE_UPDATEE, UpdateReportPOJO.SOURCE_GENERICUI, System.currentTimeMillis(),itemsMap);
		System.out.println(updateReportPOJO.serialize());
	}

}
