package com.amalto.workbench.export;

import com.amalto.workbench.models.TreeObject;

public class Exports {
	private TreeObject[] items;
	private String[] schemas;
	private String autoIncrement;
	
	public String getAutoIncrement() {
		return autoIncrement;
	}

	public void setAutoIncrement(String autoIncrement) {
		this.autoIncrement = autoIncrement;
	}

	public TreeObject[] getItems() {
		return items;
	}

	public void setItems(TreeObject[] items) {
		this.items = items;
	}
	
	public String[] getSchemas(){
		return schemas;
	}
	
	public void setSchemas(String[] schemas){
		this.schemas = schemas;
	}
}
