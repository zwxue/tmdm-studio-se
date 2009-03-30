package com.amalto.workbench.actions;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDSchema;

import com.amalto.workbench.editors.DataModelMainPage;

public class XSDEditIdentityConstraintAction extends Action{

	protected DataModelMainPage page = null;
	protected XSDIdentityConstraintDefinition constraint;
	
	public XSDEditIdentityConstraintAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/edit_obj.gif"));
		setText("Edit Key");
		setToolTipText("Edit a Key");
	}
	
	public void run() {
		try {
			super.run();
            ISelection selection = page.getTreeViewer().getSelection();
            constraint = (XSDIdentityConstraintDefinition)((IStructuredSelection)selection).getFirstElement();
            String oldName = constraint.getName();
            
            
       		InputDialog id = new InputDialog(
       				page.getSite().getShell(),
       				"Edit Key",
       				"Enter a new Name for the Key",
       				oldName,
       				new IInputValidator() {
       					public String isValid(String newText) {
       						if ((newText==null) || "".equals(newText)) return "The Concept Name cannot be empty";
       						XSDSchema schema = XSDEditIdentityConstraintAction.this.constraint.getSchema();
       						EList list = schema.getIdentityConstraintDefinitions();
       						for (Iterator iter = list.iterator(); iter.hasNext(); ) {
								XSDIdentityConstraintDefinition icd = (XSDIdentityConstraintDefinition) iter.next();
								if (icd.getName().equals(newText)) return "This Key already exists";
							}
       						return null;
       					};
       				}
       		);
            
       		id.setBlockOnOpen(true);
       		int ret = id.open();
       		if (ret == Dialog.CANCEL) return;
       		
       		constraint.setName(id.getValue());
       		constraint.updateElement();
       		       	           		
       		page.getTreeViewer().refresh(true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to edit a Concept: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}