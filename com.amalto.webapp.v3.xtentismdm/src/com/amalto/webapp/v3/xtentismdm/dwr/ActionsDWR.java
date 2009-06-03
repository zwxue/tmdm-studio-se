package com.amalto.webapp.v3.xtentismdm.dwr;

import java.util.HashMap;
import java.util.Map;

import com.amalto.webapp.core.bean.Configuration;
import com.amalto.webapp.core.dwr.CommonDWR;
import com.amalto.webapp.core.util.Util;
import com.amalto.webapp.util.webservices.WSDataClusterPK;
import com.amalto.webapp.util.webservices.WSDataModelPK;
import com.amalto.webapp.util.webservices.WSRegexDataClusterPKs;
import com.amalto.webapp.util.webservices.WSRegexDataModelPKs;

public class ActionsDWR {

	
	public static Map<String, String> getClusters(String value){
		try {
			Map<String, String> map = new HashMap<String, String>();
			WSDataClusterPK[] wsDataClustersPK = Util.getPort().getDataClusterPKs(
					new WSRegexDataClusterPKs("*")
					).getWsDataClusterPKs();
			CommonDWR.filterSystemClustersPK(wsDataClustersPK, map);
			return  map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Map<String, String> getModels(String value){
		try {
			Map<String, String> map = new HashMap<String, String>();
			WSDataModelPK[] wsDataModelsPK = Util.getPort().getDataModelPKs(
					new WSRegexDataModelPKs("*")
					).getWsDataModelPKs();
			CommonDWR.filterSystemDataModelsPK(wsDataModelsPK, map);
			return  map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getCluster(){
		try {
			Configuration config = Configuration.getInstance();
			return config.getCluster();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public String getModel(){
		try {
			Configuration config = Configuration.getInstance();
			return config.getModel();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public String setClusterAndModel(String cluster, String model){
		try {
			Configuration.initialize(cluster,model);
			return "Done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cluster+" "+model);
		return "ERROR";
	}
}
