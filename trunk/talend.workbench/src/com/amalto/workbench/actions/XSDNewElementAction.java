package com.amalto.workbench.actions;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.AmaltoWorbenchPlugin;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.XSDTreeContentProvider;

public class XSDNewElementAction extends Action{

	protected DataModelMainPage page = null;
	protected XSDSchema schema = null;
	
	public XSDNewElementAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AmaltoWorbenchPlugin.getImageDescriptor( "icons/add_obj.gif"));
		setText("New Element");
		setToolTipText("Create a new Element");
	}
	
	public void run() {
		try {
			super.run();
            schema = ((XSDTreeContentProvider)page.getTreeViewer().getContentProvider()).getXsdSchema();
            
       		InputDialog id = new InputDialog(
       				page.getSite().getShell(),
       				"New Elementt",
       				"Enter a Name for the New Element",
       				null,
       				new IInputValidator() {
       					public String isValid(String newText) {
       						if ((newText==null) || "".equals(newText)) return "The Element Name cannot be empty";
       						EList list = schema.getElementDeclarations();
       						for (Iterator iter = list.iterator(); iter.hasNext(); ) {
								XSDElementDeclaration decl = (XSDElementDeclaration) iter.next();
								if (decl.getName().equals(newText)) return "This Element/Concept already exists";
							}
       						return null;
       					};
       				}
       		);
            
       		id.setBlockOnOpen(true);
       		int ret = id.open();
       		if (ret == Window.CANCEL) return;
       		
       		XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
       		
       		XSDElementDeclaration decl = factory.createXSDElementDeclaration();
       		decl.setName(id.getValue());
       		decl.setTypeDefinition(schema.resolveSimpleTypeDefinition(schema.getSchemaForSchemaNamespace(), "string"));
       		
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
					"An error occured trying to create a new Element: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}