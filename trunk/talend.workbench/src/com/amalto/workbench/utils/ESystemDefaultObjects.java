package com.amalto.workbench.utils;

import java.util.HashMap;
import java.util.Map;

import com.amalto.workbench.models.TreeObject;

public enum ESystemDefaultObjects {
	//Data Clusters
	DC_JCAADAPTERS(TreeObject.DATA_CLUSTER, "amaltoOBJECTSjcaadapters"),
	DC_BUG_TRACKING(TreeObject.DATA_CLUSTER,"Bug Tracking"),
	DC_CONF(TreeObject.DATA_CLUSTER,"CONF"),
	DC_MDMCONF(TreeObject.DATA_CLUSTER,"MDMCONF"),
	DC_PROVISIONING(TreeObject.DATA_CLUSTER,"PROVISIONING"),
	DC_UPDATE_PREPORT(TreeObject.DATA_CLUSTER,"UpdateReport"),
	DC_XTENTIS_COMMON_CONF(TreeObject.DATA_CLUSTER,"Xtentis Common Conf"),
	DC_XTENTIS_COMMON_REPORTING(TreeObject.DATA_CLUSTER,"Xtentis Common Reporting"),
	
	
	//Data Models
	DM_BUG_TRACKING(TreeObject.DATA_MODEL,"Bug Tracking"),
	DM_CONF(TreeObject.DATA_MODEL,"CONF"),
	DM_PROVISIONING(TreeObject.DATA_MODEL,"PROVISIONING"),
	DM_REPORTING(TreeObject.DATA_MODEL,"REPORTING"),
	DM_UPDATEREPORT(TreeObject.DATA_MODEL,"UpdateReport"),
	DM_XTENTIS_COMMON_CONF(TreeObject.DATA_MODEL,"Xtentis Common Conf"),
	DM_XTENTIS_COMMON_REPORTING(TreeObject.DATA_MODEL,"Xtentis Common Reporting"),
	
	//Menus
	
	M_BROWSE_ITEMS(TreeObject.MENU,"Browse items"),
	M_BROWSE_VIEWS(TreeObject.MENU,"Browse views"),
	M_MANAGER_USERS(TreeObject.MENU,"manager users"),
	M_REPORTING(TreeObject.MENU,"Reporting"),
	M_SYNCHRONIZATIONACTION(TreeObject.MENU,"SynchronizationAction"),
	M_SYNCHRONIZATIONPLAN(TreeObject.MENU,"SynchronizationPlan"),
	
	
	//roles
	R_BOLLORE_CONTRIBUTOR(TreeObject.ROLE,"BOLLORE_Contributor"),
	
	//Views
	
	V_MDM_REPORTING_VIEW(TreeObject.VIEW,"MDM Reporting View"),
	V_XTENTIS_MDM_REPORTING(TreeObject.VIEW,"Xtentis MDM Reporting"),
	V_XTENTIS_PORTAL_ROLE_VIEW(TreeObject.VIEW,"XTENTIS PORTAL ROLE VIEW");
	
	
	ESystemDefaultObjects(int type, String name){
		this.name=name;
		this.type=type;
	}
	ESystemDefaultObjects(){};
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	private String name;
		
	private int type;
	
	//key is the type
	/**
	 * get all the elements
	 * @author liyanmei
	 * @return map
	 */
	public static Map<String ,ESystemDefaultObjects> getAllSystemDefaultObjexts(){
		
		Map<String,ESystemDefaultObjects> map=new HashMap<String, ESystemDefaultObjects>();
		for(int i=0; i<values().length; i++){
			map.put(values()[i].getType()+String.valueOf(values()[i].getName()), values()[i]);
		}
		return map;
	}
	
	/**
	 * get the "type" elements
	 * @author liyanmei
	 * @param type
	 * @return map
	 */
public static Map<String ,ESystemDefaultObjects> getSystemDefaultObjectsByType(int type){
		
		Map<String,ESystemDefaultObjects> map=new HashMap<String, ESystemDefaultObjects>();
		for(int i=0; i<values().length; i++){
			if(type==values()[i].getType())
				map.put(String.valueOf(values()[i].getName()), values()[i]);
		}
		return map;
	}
/**
 * chenk if the element is exist
 * @author liyanmei
 * @param type
 * @param name
 * @return boolean
 */
public static boolean isExist(int type,String name){
	boolean is = false;
	for(int i=0; i<values().length; i++){
		if(type==values()[i].getType()&& name.equals(values()[i].name)){
			is=true;
			break;
		}
	}
	return is;
}
}
