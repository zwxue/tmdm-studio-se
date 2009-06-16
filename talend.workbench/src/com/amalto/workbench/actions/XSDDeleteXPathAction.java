package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.utils.EImage;
import com.amalto.workbench.utils.ImageCache;

public class XSDDeleteXPathAction extends Action{

	private DataModelMainPage page = null;
	private XSDXPathDefinition xsdPath = null;
	
	public XSDDeleteXPathAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
		setText("Delete Field");
		setToolTipText("Delete a Field");
	}
	
	public void run(Object toDel) {
		if (!(toDel instanceof XSDXPathDefinition)) {
			return;
		}
		xsdPath = (XSDXPathDefinition) toDel;
		run();
	}
	
	public void run() {
		try {
			
            // xsdPath is to support the multiple delete action on key press,
			// which each delete action on xpath must be explicit passed a xsd path to
			// delete
            XSDXPathDefinition xpath = xsdPath;
            if (xpath == null) {
				ISelection selection = page.getTreeViewer().getSelection();
				xpath = (XSDXPathDefinition) ((IStructuredSelection) selection)
						.getFirstElement();
			}
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
           
            icd.getFields().remove(xpath);
            icd.updateElement();
            xsdPath = null;
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
	
    public void setXSDTODel(XSDXPathDefinition elem) {
    	xsdPath = elem;
	}

}