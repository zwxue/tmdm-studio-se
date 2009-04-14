package com.amalto.workbench.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * Global user Information
 * @author aiming
 *
 */
public class GlobalUserInfo {
	UserInfo currentUser;
	//key is userinfo.serverUrl + userinfo.universe
	Map<String, UserInfo> userMaps=new HashMap<String, UserInfo>();
	
	private static GlobalUserInfo instance=null;
	public static GlobalUserInfo getInstance(){
		if(instance==null){
			instance=new GlobalUserInfo();
		}
		return instance;
	}
	
	public void addUser(String key, UserInfo user){
		userMaps.put(key, user);
	}
	
	public void getUser(String key){
		userMaps.get(key);
	}
//	/**
//	 * the real username in db is universe/username
//	 * @param username
//	 * @param universe
//	 * @return
//	 */
//	public static String getRealUsername(String username, String universe){
//		String uname=username;
//		if(universe!=null && universe.trim().length()>0  && !universe.trim().equals(IConstants.HEAD) ){
//			uname=universe.trim()+"/"+username;
//		}
//		return uname;
//	}

}
