package com.amalto.workbench.providers.datamodel.util;

import com.amalto.workbench.utils.SchemaElementNameFilterDes;

public class SchemaTopElementNameSelectorFactory {

	private static SchemaTopElementNameSelectorFactory INSTANCE;
	
	private SchemaTopElementNameSelectorFactory(){}
	
	public synchronized static SchemaTopElementNameSelectorFactory getInstance() {
		
		if(INSTANCE == null)
			INSTANCE = new SchemaTopElementNameSelectorFactory();
		
		return INSTANCE;
	}
	
	public SchemaTopElementNameSelector createSchemaTopElementNameSelectorOnPattern(
											SchemaItemLabelCreator labelExtractor,
											SchemaElementNameFilterDes nameFitlerDes) {
		
		if(labelExtractor == null 
			|| nameFitlerDes == null 
			|| !nameFitlerDes.isEnable())
			return new SchemaTopElementNameSelectorOnAll();
		
		if(labelExtractor instanceof TypeItemLabelCreator)
			return new TypeTopElementNameSelectorOnPattern(labelExtractor,nameFitlerDes);
		
		return new SchemaTopElementNameSelectorOnPattern(labelExtractor,nameFitlerDes);
	}
}
