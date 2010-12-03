package com.amalto.workbench.providers.datamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDAttributeGroupDefinition;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDWildcard;
import org.eclipse.xsd.util.XSDConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.ISchemaContentProvider;
import com.amalto.workbench.utils.DataModelFilter;
import com.amalto.workbench.utils.Util;

public class SchemaTreeContentProvider implements ITreeContentProvider,
		ISchemaContentProvider {

	protected XSDSchema xsdSchema;
	protected IWorkbenchPartSite site = null;
	protected TreeObject treeObj;
	
	public SchemaTreeContentProvider(IWorkbenchPartSite site,
									 XSDSchema invisibleRoot, 
									 TreeObject treeObject) {
		this.site = site;
		this.xsdSchema = invisibleRoot;
	}

	@Override
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {}

	@Override
	public void dispose() {}

	@Override
	public Object[] getElements(Object parent) {
		if (parent.equals(site)) {
			return getChildren(xsdSchema);
		}
		return getChildren(parent);
	}

	@Override
	public Object getParent(Object child) {
		return null;
	}

	@Override
	public void setFilter(DataModelFilter filter) {}

	@Override
	public Object[] getChildren(Object parent) {

		if (parent == null) {
			System.out.println("NULL PARENT");
			return new Object[0];
		}
			
		return findChildren(parent);
	}

	protected Object[] findChildren(Object parent) {
		
		if (parent instanceof XSDSchema)
			return getXSDSchemaChildren();

		if (parent instanceof XSDAttributeGroupDefinition)
			return getXSDAttributeGroupDefinitionChildren((XSDAttributeGroupDefinition)parent);

		if (parent instanceof XSDParticle)
			return getXSDParticleChildren((XSDParticle) parent);

		if (parent instanceof XSDModelGroup)
			return getXSDModelGroupChildren((XSDModelGroup)parent);

		if (parent instanceof XSDSimpleTypeDefinition)
			return getXSDSimpleTypeDefinitionChildren((XSDSimpleTypeDefinition) parent);

		if (parent instanceof XSDElementDeclaration)
			return getXSDElementDeclarationChildren((XSDElementDeclaration)parent);

		if (parent instanceof XSDIdentityConstraintDefinition)
			return getXSDIdentityConstraintDefinitionChildren((XSDIdentityConstraintDefinition)parent);

		if (parent instanceof XSDAnnotation) 
			return getXSDAnnotationChildren((XSDAnnotation)parent);
		
		// appinfos
		if (parent instanceof Element)
			return new Object[0];
		
		return new Object[0];
	}
	
	protected Object[] filterOutDuplicatedElems(XSDNamedComponent[] checkedElements) {
		List<XSDNamedComponent> list = new ArrayList<XSDNamedComponent>();
		for (XSDNamedComponent el :  checkedElements) {
			boolean exist = false;
			for (XSDNamedComponent xsdEl : list) {
				if (xsdEl.getName().equals(el.getName())
						&& xsdEl.getTargetNamespace() != null
						&& el.getTargetNamespace() != null
						&& xsdEl.getTargetNamespace().equals(el.getTargetNamespace())) {
					exist = true;
					break;
				} else if (xsdEl.getName().equals(el.getName())
						&& xsdEl.getTargetNamespace() == null
						&& el.getTargetNamespace() == null) {
					exist = true;
					break;
				}
			}
			if (!exist
					&& (el.getTargetNamespace() != null && !el
							.getTargetNamespace().equals(
									XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001))
					|| el.getTargetNamespace() == null) {
				list.add(el);
			}
		}

		return list.toArray(new Object[] {});
	}

	@Override
	public boolean hasChildren(Object parent) {
		return getChildren(parent).length > 0;
	}

	@Override
	public XSDSchema getXsdSchema() {
		return xsdSchema;
	}

	@Override
	public void setXsdSchema(String xsd) {
		try {
			xsdSchema = Util.createXsdSchema(xsd, treeObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setXsdSchema(XSDSchema xsdSchema) {
		this.xsdSchema = xsdSchema;
	}

	public String getXSDSchemaAsString() throws Exception {
		Document document = xsdSchema.getDocument();
		String schema = Util.nodeToString(document);

		// FIXES a bug in the XSD library that puts nillable attributes in
		// elements which are ref
		// That is illegal according to W3C §3.3.3 / 2.2 (and Xerces)
		Pattern p = Pattern
				.compile("(<([a-z]+:)?element.*?)nillable=['|\"].*?['|\"](.*?ref=.*?>)");
		schema = p.matcher(schema).replaceAll("$1 $3");

		return schema;
	}
	
	protected Object[] getXSDSchemaChildren() {
		return filterOutDuplicatedElems(xsdSchema.getElementDeclarations()
				.toArray(new XSDNamedComponent[xsdSchema.getElementDeclarations().size()]));
	}
	
	protected Object[] getXSDAttributeGroupDefinitionChildren(XSDAttributeGroupDefinition parent){
		XSDAttributeGroupDefinition attributeGroupDefinition = parent;
		if (attributeGroupDefinition.getContents().size() == 0) 
			attributeGroupDefinition = attributeGroupDefinition.getResolvedAttributeGroupDefinition();
		return attributeGroupDefinition.getContents().toArray(
				new Object[attributeGroupDefinition.getContents().size()]);
	}
	
	protected Object[] getXSDParticleChildren(XSDParticle particle) {

		if (particle.getTerm() instanceof XSDElementDeclaration)
			return getXSDParticleChildrenAsXSDElementDeclaration((XSDElementDeclaration)particle.getTerm());

		if (particle.getTerm() instanceof XSDModelGroup) {
			// a ModelGroup skip it and get children directtly
			EList<XSDParticle> list = ((XSDModelGroup) particle.getTerm()).getContents();
			return list.toArray(new XSDParticle[list.size()]);
		}

		if (particle.getTerm() instanceof XSDWildcard) {}

		return new Object[] {};

	}
	
	private Object[] getXSDParticleChildrenAsXSDElementDeclaration(XSDElementDeclaration particleTerm) {
	
		ArrayList<Object> list = new ArrayList<Object>();
		
		if (particleTerm.getTypeDefinition() == null)
			return new Object[0]; // elements with not type declaration

		if (particleTerm.getTypeDefinition() instanceof XSDComplexTypeDefinition)
			list.addAll(Util.getComplexTypeDefinitionChildren((XSDComplexTypeDefinition)particleTerm.getTypeDefinition()));
		else
			list.add(particleTerm.getTypeDefinition());
		
		list.addAll(particleTerm.getIdentityConstraintDefinitions());
		
		addEleDeclarationAnn2List(list,particleTerm);
		
		return list.toArray(new Object[list.size()]);
	}

	protected Object[] getXSDModelGroupChildren(XSDModelGroup parent) {
		return parent.getContents().toArray(new Object[parent.getContents().size()]);
	}

	protected Object[] getXSDSimpleTypeDefinitionChildren(XSDSimpleTypeDefinition parent) {
		
		switch(parent.getVariety()){
			case ATOMIC_LITERAL:
				return getXSDSimpleTypeDefinitionChildren_ATOMIC(parent);
			case LIST_LITERAL:
				return getXSDSimpleTypeDefinitionChildren_LIST(parent);
			case UNION_LITERAL:
				return getXSDSimpleTypeDefinitionChildren_UNION(parent);
			default:
				return new Object[0];
		}
	}
	
	private Object[] getXSDSimpleTypeDefinitionChildren_UNION(XSDSimpleTypeDefinition parent) {
		return parent.getMemberTypeDefinitions().toArray(new XSDSimpleTypeDefinition[parent.getMemberTypeDefinitions().size()]);
	}
	
	private Object[] getXSDSimpleTypeDefinitionChildren_LIST(XSDSimpleTypeDefinition parent) {
		// FIXME: How do we indicate it is a LIST?
		return new XSDSimpleTypeDefinition[] { parent.getBaseTypeDefinition() };
	}
	
	private Object[] getXSDSimpleTypeDefinitionChildren_ATOMIC(XSDSimpleTypeDefinition parent) {
		ArrayList<Object> list = new ArrayList<Object>();
		// add Base Type if not a pre-defined type
		if (parent != null && 
			parent.getSchema() != null && 
			parent.getSchema().getSchemaForSchema() != null) {
			if (!parent.getSchema().getSchemaForSchema().getTypeDefinitions().contains(parent))
				list.add(parent.getBaseTypeDefinition());
		}
			
		list.addAll(parent.getFacetContents());
		return list.toArray(new Object[list.size()]);
	}

	protected Object[] getXSDElementDeclarationChildren(XSDElementDeclaration parent){
		// abstract elements do not have children
		if (parent.isAbstract())
			return new Object[0];

		ArrayList<Object> list = new ArrayList<Object>();

		// handle extensions and restrictions directly
		if (parent.getTypeDefinition() instanceof XSDComplexTypeDefinition)
			list.addAll(Util.getComplexTypeDefinitionChildren((XSDComplexTypeDefinition) parent.getTypeDefinition()));
		else
			list.add(parent.getTypeDefinition());
		
		// the keys
		list.addAll(parent.getIdentityConstraintDefinitions());
		
		// the annotations
		addEleDeclarationAnn2List(list,parent);
		
		return list.toArray(new Object[list.size()]);
	}
	
	protected Object[] getXSDIdentityConstraintDefinitionChildren(XSDIdentityConstraintDefinition parent){
		
		ArrayList<Object> list = new ArrayList<Object>();
		
		list.add(parent.getSelector());
		list.addAll(parent.getFields());

		return list.toArray(new Object[list.size()]);
		
	}
	
	protected Object[] getXSDAnnotationChildren(XSDAnnotation parent){
		
		ArrayList<Object> list = new ArrayList<Object>();
		
		list.addAll(parent.getUserInformation());
		list.addAll(parent.getApplicationInformation());
		
		return list.toArray(new Object[list.size()]);
		
	}
	
	private void addEleDeclarationAnn2List(List<Object> list, XSDElementDeclaration element) {
		if(element.getAnnotation() != null)
			list.add(element.getAnnotation());
	}
}
