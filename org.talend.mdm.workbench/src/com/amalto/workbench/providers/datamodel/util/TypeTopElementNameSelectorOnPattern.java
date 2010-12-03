package com.amalto.workbench.providers.datamodel.util;

import org.eclipse.xsd.XSDTypeDefinition;

import com.amalto.workbench.utils.SchemaElementNameFilterDes;

class TypeTopElementNameSelectorOnPattern extends SchemaTopElementNameSelectorOnPattern {

	protected TypeTopElementNameSelectorOnPattern(SchemaItemLabelCreator labelExtractor,
												  SchemaElementNameFilterDes nameFitlerDes) {
		super(labelExtractor, nameFitlerDes);
	}

	@Override
	protected boolean isTopElement(Object element) {
		return (element instanceof XSDTypeDefinition);
	}
}
