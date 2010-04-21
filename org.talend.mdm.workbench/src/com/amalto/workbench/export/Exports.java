package com.amalto.workbench.export;

import com.amalto.workbench.models.TreeObject;

public class Exports {
	private TreeObject[] items;
	private String[] schemas;
	
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
