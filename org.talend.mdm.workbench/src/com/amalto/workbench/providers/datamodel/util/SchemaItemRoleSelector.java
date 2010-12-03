package com.amalto.workbench.providers.datamodel.util;


public interface SchemaItemRoleSelector {

	public boolean isSatisfiedItem(String role,Object parentElement, Object element);
	
}
