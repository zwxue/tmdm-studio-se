package com.amalto.workbench.providers.datamodel.util;

import org.eclipse.xsd.XSDAnnotation;

import com.amalto.workbench.utils.XSDAnnotationsStructure;

class SchemaItemRoleSelectorOnWrite extends
		SchemaItemRoleSelectorOnNotAll {

	@Override
	protected boolean isRoleValid(String role, XSDAnnotation annotation) {
		if (annotation != null) {
			XSDAnnotationsStructure annotion = new XSDAnnotationsStructure(annotation);
			return annotion.getWriteAccesses().values().contains(role);
		}

		return false;
	}

}
