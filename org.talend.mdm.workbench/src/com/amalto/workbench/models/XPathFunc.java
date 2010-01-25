package com.amalto.workbench.models;

import java.util.ArrayList;
import java.util.List;

public class XPathFunc {
	String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	List<KeyValue> funcs=new ArrayList<KeyValue>();

	public List<KeyValue> getFuncs() {
		return funcs;
	}

	public void setFuncs(List<KeyValue> funcs) {
		this.funcs = funcs;
	}
	
}
