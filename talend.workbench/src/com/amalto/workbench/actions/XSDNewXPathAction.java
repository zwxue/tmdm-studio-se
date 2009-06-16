package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.AmaltoWorbenchPlugin;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.utils.EImage;
import com.amalto.workbench.utils.ImageCache;

public class XSDNewXPathAction extends Action{

	private DataModelMainPage page = null;
	private XSDIdentityConstraintDefinition icd = null;
	
	public XSDNewXPathAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(ImageCache.getImage(EImage.ADD_OBJ.getPath()));
		setText("New Field");
		setToolTipText("Create a new Field");
	}
	
	public void run() {
		try {
			

            int index = 0;
            IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
            if (selection.getFirstElement() instanceof XSDIdentityConstraintDefinition) {
            	icd = (XSDIdentityConstraintDefinition) selection.getFirstElement();
            } else if (selection.getFirstElement() instanceof XSDXPathDefinition) {
            	XSDXPathDefinition xpath = (XSDXPathDefinition)selection.getFirstElement();
            	icd = (XSDIdentityConstraintDefinition)xpath.getContainer();
            	if (xpath.getVariety().equals(XSDXPathVariety.FIELD_LITERAL))
            		index = icd.getFields().indexOf(xpath)+1;
            	else
            		index = 0;
            } else {
            	MessageDialog.openError(this.page.getSite().getShell(),"Error", "huhhh: "+selection.getFirstElement().getClass().getName());
            	return;
            }
            
       		InputDialog id = new InputDialog(
       				page.getSite().getShell(),
       				"New XPath",
       				"Enter a new XPath to the field",
       				null,
       				new IInputValidator() {
       					public String isValid(String newText) {
       						if ((newText==null) || "".equals(newText)) return "The XPath cannot be empty";
       						return null;
       					};
       				}
       		);
            
       		id.setBlockOnOpen(true);
       		int ret = id.open();
       		if (ret == Dialog.CANCEL) return;
       		
       		XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
       		
       		XSDXPathDefinition xpath = factory.createXSDXPathDefinition();
       		xpath.setValue(id.getValue());
       		xpath.setVariety(XSDXPathVariety.FIELD_LITERAL);
       		
       		icd.getFields().add(index,xpath);
       		icd.updateElement();
       		
       		page.getTreeViewer().refresh(true);
       		page.getTreeViewer().setSelection(new StructuredSelection(xpath),true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to create a new Field: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}