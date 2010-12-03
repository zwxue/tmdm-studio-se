package com.amalto.workbench.providers.datamodel.util;

public class SchemaXSDElementIDSelectorFactory {

	private static SchemaXSDElementIDSelectorFactory INSTANCE;
	
	private SchemaXSDElementIDSelectorFactory() {}
	
	public synchronized static SchemaXSDElementIDSelectorFactory getInstance(){
	
		if(INSTANCE == null)
			INSTANCE = new SchemaXSDElementIDSelectorFactory();
		
		return INSTANCE;
	}
	
	
	public SchemaXSDElementIDSelector createSchemaXSDElementSelectorOnAll(){
		return new SchemaXSDElementIDSelectorOnAll();
	}
	
	public SchemaXSDElementIDSelector createSchemaXSDElementSelectorOnUnique() {
		return new SchemaXSDElementIDSelectorOnUnique();
	}
	
	public SchemaXSDElementIDSelector createSchemaXSDElementSelector(boolean isFiltUnique) {
		
		if(isFiltUnique)
			return createSchemaXSDElementSelectorOnUnique();
		
		return createSchemaXSDElementSelectorOnAll();
	}
}
