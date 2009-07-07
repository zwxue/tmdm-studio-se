package com.amalto.workbench.providers;

import org.eclipse.xsd.XSDSchema;

public interface ISchemaContentProvider {
	public XSDSchema getXsdSchema() ;
	
	
	public void setXsdSchema(String xsd);
	
	public void setXsdSchema(XSDSchema xsdSchema);
}
