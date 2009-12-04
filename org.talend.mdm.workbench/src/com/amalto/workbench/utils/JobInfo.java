package com.amalto.workbench.utils;

public class JobInfo {
	String jobname;
	String jobversion;
	public JobInfo(String jobname,String jobversion){
		this.jobname=jobname;
		this.jobversion=jobversion;
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
	
}
