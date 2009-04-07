package com.amalto.workbench.utils;

public class UnserInfo {
	private String username;
	private String password;
	private String serverUrl;
	private String universe;
	private static UnserInfo instance=null;
	public static UnserInfo getInstance(){
		if(instance==null){
			instance=new UnserInfo();
		}
		return instance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getUniverse() {
		return universe;
	}
	public void setUniverse(String universe) {
		this.universe = universe;
	}
	
}
