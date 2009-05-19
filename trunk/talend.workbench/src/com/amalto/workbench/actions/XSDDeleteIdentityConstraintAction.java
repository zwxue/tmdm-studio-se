package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;

import com.amalto.workbench.AmaltoWorbenchPlugin;
import com.amalto.workbench.editors.DataModelMainPage;

public class XSDDeleteIdentityConstraintAction extends Action{

	private DataModelMainPage page = null;
	
	public XSDDeleteIdentityConstraintAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AmaltoWorbenchPlugin.getImageDescriptor( "icons/delete_obj.gif"));
		setText("Delete Key");
		setToolTipText("Delete a Key");
	}
	
	public void run() {
		try {
			super.run();
            IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
            XSDIdentityConstraintDefinition constraint = (XSDIdentityConstraintDefinition) selection.getFirstElement();
            
            XSDElementDeclaration decl = (XSDElementDeclaration)constraint.getContainer();
            
            /* REMOVE so that simple elements can be made
            if (	(constraint.getIdentityConstraintCategory().equals(XSDIdentityConstraintCategory.UNIQUE_LITERAL)) &&
            		(decl.getContainer().equals(decl.getSchema()))
            	) {
                MessageDialog.openError(
                		this.page.getSite().getShell(),
                		"Error",
                		"Concepts must have an unique key"
                ); 
                return;            	
            }
            */
            
            //ask for confimation
            if (! MessageDialog.openConfirm(
            		this.page.getSite().getShell(),
            		"Delete Key",
            		"Are you sure you want to delete the Key "+constraint.getName()+" ?"
            )) return;
            
            
            decl.getIdentityConstraintDefinitions().remove(constraint);
            decl.updateElement();
            
       		page.getTreeViewer().refresh(true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to remove Concept: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}