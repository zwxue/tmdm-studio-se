package com.amalto.workbench.providers.datamodel.util;

class SchemaItemRoleSelectorOnAll implements SchemaItemRoleSelector {

	@Override
	public boolean isSatisfiedItem(String role, Object parentElement, Object element) {
		return true;
	}

}
