package com.amalto.workbench.utils;

public class JobInfo {
	String jobname;
	String jobversion;
	String suffix;
	public JobInfo(String jobname,String jobversion, String suffix){
		this.jobname=jobname;
		this.jobversion=jobversion;
		this.suffix=suffix;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getJobversion() {
		return jobversion;
	}
	public void setJobversion(String jobversion) {
		this.jobversion = jobversion;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
}
