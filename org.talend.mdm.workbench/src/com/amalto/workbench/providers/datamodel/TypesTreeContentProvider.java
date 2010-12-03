package com.amalto.workbench.providers.datamodel;

import java.util.ArrayList;

import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.models.TreeObject;

public class TypesTreeContentProvider extends SchemaTreeContentProvider{

	public TypesTreeContentProvider(IWorkbenchPartSite site,
			XSDSchema invisibleRoot, TreeObject treeObject) {
		super(site, invisibleRoot, treeObject);
		
	}

	@Override
	protected Object[] findChildren(Object parent) {
		
		if (parent instanceof XSDComplexTypeDefinition) 
			return getXSDComplexTypeDefinitionChildren((XSDComplexTypeDefinition)parent);

		return super.findChildren(parent);
	}

	protected Object[] getXSDComplexTypeDefinitionChildren(XSDComplexTypeDefinition parent) {
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.addAll(parent.getAttributeContents());

		if (parent.getContent() == null) {
			list.add(parent.getBaseTypeDefinition());
			return list.toArray(new Object[list.size()]);
		} else if(parent.getContent() instanceof XSDSimpleTypeDefinition) {	
			list.add(parent.getContent());
			return list.toArray(new Object[list.size()]);
		} else if (parent.getContent() instanceof XSDParticle) {
			return getXSDParticleChildren((XSDParticle) parent.getContent());
		} else {
			list.add(parent.getContent());
			return list.toArray(new Object[list.size()]);
		}
	}
	
	protected Object[] getXSDSchemaChildren() {
		return filterOutDuplicatedElems(xsdSchema.getTypeDefinitions()
				.toArray(new XSDNamedComponent[xsdSchema.getTypeDefinitions().size()]));
	}
	
}
