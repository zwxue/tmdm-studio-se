package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;

import com.amalto.workbench.AmaltoWorbenchPlugin;
import com.amalto.workbench.editors.DataModelMainPage;

public class XSDDeleteXPathAction extends Action{

	private DataModelMainPage page = null;
	
	public XSDDeleteXPathAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AmaltoWorbenchPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/delete_obj.gif"));
		setText("Delete Field");
		setToolTipText("Delete a Field");
	}
	
	public void run() {
		try {
			super.run();
            ISelection selection = page.getTreeViewer().getSelection();
            XSDXPathDefinition xpath = (XSDXPathDefinition)((IStructuredSelection)selection).getFirstElement();
            XSDIdentityConstraintDefinition icd = (XSDIdentityConstraintDefinition) xpath.getContainer();
            
            if (xpath.getVariety().equals(XSDXPathVariety.SELECTOR_LITERAL)) {
    			MessageDialog.openError(
    					page.getSite().getShell(),
    					"Error", 
    					"The Selector cannot be deleted"
    			);
    			return;
            }
            
            if (icd.getFields().size()==1) {
    			MessageDialog.openError(
    					page.getSite().getShell(),
    					"Error", 
    					"The Key must contain at least one field"
    			);
    			return;            	
            }
            
            //ask for confimation
            if (! MessageDialog.openConfirm(
            		this.page.getSite().getShell(),
            		"Delete Field",
            		"Are you sure you want to delete the field "+xpath.getValue()+" ?"
            )) return;

            icd.getFields().remove(xpath);
            icd.updateElement();
            
       		page.getTreeViewer().refresh(true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to remove a Field: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}