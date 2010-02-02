package com.amalto.workbench.service.branding;

public class DefaultBrandingConfiguraton implements IBrandingConfiguration {
	
	private String title="";
	public String getAdditionalTitle() {

		return title;
	}


	public void setAdditionalTitle(String title) {
		this.title=title;
		
	}

}
