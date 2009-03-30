package com.amalto.workbench.actions;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.AmaltoWorbenchPlugin;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.XSDTreeContentProvider;

public class XSDNewConceptAction extends Action{

	protected DataModelMainPage page = null;
	protected XSDSchema schema = null;
	
	public XSDNewConceptAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AmaltoWorbenchPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/add_obj.gif"));
		setText("New Concept");
		setToolTipText("Create a new Business Concept");
	}
	
	public void run() {
		try {
			super.run();
            schema = ((XSDTreeContentProvider)page.getTreeViewer().getContentProvider()).getXsdSchema();
            
       		InputDialog id = new InputDialog(
       				page.getSite().getShell(),
       				"New Concept",
       				"Enter a Name for the New Concept",
       				null,
       				new IInputValidator() {
       					public String isValid(String newText) {
       						if ((newText==null) || "".equals(newText)) return "The Concept Name cannot be empty";
       						EList list = schema.getElementDeclarations();
       						for (Iterator iter = list.iterator(); iter.hasNext(); ) {
								XSDElementDeclaration decl = (XSDElementDeclaration) iter.next();
								if (decl.getName().equals(newText)) return "This Concept already exists";
							}
       						return null;
       					};
       				}
       		);
            
       		id.setBlockOnOpen(true);
       		int ret = id.open();
       		if (ret == Dialog.CANCEL) return;
       		
       		XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
       		
       		XSDElementDeclaration decl = factory.createXSDElementDeclaration();
       		decl.setName(id.getValue());
       		decl.setTypeDefinition(schema.resolveSimpleTypeDefinition(schema.getSchemaForSchemaNamespace(), "string"));
       		
       		XSDIdentityConstraintDefinition uniqueKey = factory.createXSDIdentityConstraintDefinition();
       		uniqueKey.setIdentityConstraintCategory(XSDIdentityConstraintCategory.UNIQUE_LITERAL);
       		uniqueKey.setName(id.getValue());
       		XSDXPathDefinition selector = factory.createXSDXPathDefinition();
       		selector.setVariety(XSDXPathVariety.SELECTOR_LITERAL);
       		selector.setValue(".");
       		uniqueKey.setSelector(selector);
       		XSDXPathDefinition field = factory.createXSDXPathDefinition();
       		field.setVariety(XSDXPathVariety.FIELD_LITERAL);
       		field.setValue(".");
       		uniqueKey.getFields().add(field);
       		decl.getIdentityConstraintDefinitions().add(uniqueKey);
       		
       		schema.getContents().add(decl);
       		//schema.getElementDeclarations().add(decl);
       		decl.updateElement();
       		
       		page.getTreeViewer().refresh(true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to create a new Concept: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}