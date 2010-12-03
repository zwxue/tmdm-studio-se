package com.amalto.workbench.providers.datamodel.util;

import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

public class TypeItemLabelCreator extends SchemaItemLabelCreator {

	protected static TypeItemLabelCreator INSTANCE;
	
	public static final String XSDSIMPLETYPEDEF_PREFIX_NOTKNOWN = "***";
	public static final String XSDMODELGROUP_LABEL_NONNAME = "";

	public static final String XSDCOMPLEXTYPEDEF_SEPARATOR = " : ";
	
	private TypeItemLabelCreator(){}
	
	public synchronized static SchemaItemLabelCreator getInstance() {

		if (INSTANCE == null)
			INSTANCE = new TypeItemLabelCreator();

		return INSTANCE;
	}
	
	@Override
	public String getLabelForNotNullElement(Object element) {
		
		if(element instanceof XSDComplexTypeDefinition){
			return getLabelForComplexTypeDef((XSDComplexTypeDefinition)element);
		}
		
		return super.getLabelForNotNullElement(element);
	}
	
	@Override
	protected String getSuffixForXSDSimpleTypeDefinition(
			XSDSimpleTypeDefinition element) {
		
		if(element.getTargetNamespace() == null)
			return "";
		
		return XSDSIMPLETYPEDEF_SEPARATOR + element.getTargetNamespace();
		
	}
	
	protected String getLabelForComplexTypeDef(XSDComplexTypeDefinition element){
		
		StringBuilder label = new StringBuilder(element.getName());
		
		if(element.getTargetNamespace() != null)
			label.append(XSDCOMPLEXTYPEDEF_SEPARATOR + element.getTargetNamespace());
		
		return label.toString();
	}
}
