package com.amalto.workbench.providers.datamodel.util;

import org.eclipse.xsd.XSDAnnotation;

class SchemaItemRoleSelectorOnReadonly extends
		SchemaItemRoleSelectorOnNotAll {

	@Override
	protected boolean isRoleValid(String role, XSDAnnotation annotation) {
		return (annotation == null);
	}

}
