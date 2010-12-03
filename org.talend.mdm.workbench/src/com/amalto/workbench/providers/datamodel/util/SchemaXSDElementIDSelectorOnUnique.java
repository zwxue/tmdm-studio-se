package com.amalto.workbench.providers.datamodel.util;

import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;

class SchemaXSDElementIDSelectorOnUnique implements
		SchemaXSDElementIDSelector {

	@Override
	public boolean isSatisfiedElement(Object parentElement, Object element) {
		
		if(element instanceof XSDElementDeclaration)
			return isUniqueXSDElementDeclaration((XSDElementDeclaration)element);
		
		return true;
	}

	private boolean isUniqueXSDElementDeclaration(XSDElementDeclaration element) {

		for (XSDIdentityConstraintDefinition eachIDDef : element
				.getIdentityConstraintDefinitions()) {
			if (eachIDDef.getIdentityConstraintCategory().equals(
					XSDIdentityConstraintCategory.UNIQUE_LITERAL))
				return true;
		}

		return false;
	}
}
