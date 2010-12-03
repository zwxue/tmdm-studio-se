package com.amalto.workbench.utils;

import java.util.ArrayList;
import java.util.List;

public class SchemaElementNameFilterDes {

	private boolean enable;
	private String sourceFilterExpression = new String();

	private static final String SEPARATOR = ",";
	
	public SchemaElementNameFilterDes() {
		this(false,"");
	}
	
	public SchemaElementNameFilterDes(boolean enable, String sourceFilterExpression){
		setEnable(enable);
		setSourceFilterExpression(sourceFilterExpression);
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getSourceFilterExpression() {
		return sourceFilterExpression;
	}

	public void setSourceFilterExpression(String sourceFilterExpression) {
		
		if(sourceFilterExpression == null)
			this.sourceFilterExpression = "";
		else if(!sourceFilterExpression.equals(this.sourceFilterExpression))
			this.sourceFilterExpression = sourceFilterExpression;
	}
	
	public String[] getSeparatedFilterExpressions() {
		
		List<String> filterExpressions = new ArrayList<String>();
		
		for(String eachExpression : getSourceFilterExpression().split(SEPARATOR)){
			if(!"".equals(eachExpression.trim()))
				filterExpressions.add(eachExpression);
		}
		
		return filterExpressions.toArray(new String[filterExpressions.size()]);
	}

}
