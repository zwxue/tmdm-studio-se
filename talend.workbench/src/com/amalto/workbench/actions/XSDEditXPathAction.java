package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.AmaltoWorbenchPlugin;
import com.amalto.workbench.editors.DataModelMainPage;

public class XSDEditXPathAction extends Action{

	private DataModelMainPage page = null;
	private XSDIdentityConstraintDefinition icd = null;
	
	public XSDEditXPathAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AmaltoWorbenchPlugin.getImageDescriptor( "icons/edit_obj.gif"));
		setText("Edit Selector/Field");
		setToolTipText("Edit a Selector/Field");
	}
	
	public void run() {
		try {
			super.run();
            
            IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
            XSDXPathDefinition xpath = (XSDXPathDefinition)selection.getFirstElement();
            icd = (XSDIdentityConstraintDefinition) xpath.getContainer();
                        
       		InputDialog id = new InputDialog(
       				page.getSite().getShell(),
       				"Edit XPath",
       				"Enter a new XPath for the "+((xpath.getVariety().equals(XSDXPathVariety.FIELD_LITERAL))?"field":"selector"),
       				xpath.getValue(),
       				new IInputValidator() {
       					public String isValid(String newText) {
       						if ((newText==null) || "".equals(newText)) return "The XPath cannot be empty";
       						return null;
       					};
       				}
       		);
            
       		id.setBlockOnOpen(true);
       		int ret = id.open();
       		if (ret == Window.CANCEL) return;
       		
       		XSDXPathDefinition newXpath = XSDSchemaBuildingTools.getXSDFactory().createXSDXPathDefinition();
       		newXpath.setValue(id.getValue());
       		if (xpath.getVariety().equals(XSDXPathVariety.FIELD_LITERAL)) {
       			int index = icd.getFields().indexOf(xpath);
       			newXpath.setVariety(XSDXPathVariety.FIELD_LITERAL);
       			icd.getFields().set(index, newXpath);
       		} else {
       			newXpath.setVariety(XSDXPathVariety.SELECTOR_LITERAL);
       			icd.setSelector(newXpath);
       		}

       		icd.updateElement();
       		page.getTreeViewer().refresh(true);
       		page.getTreeViewer().setSelection(new StructuredSelection(newXpath),true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to edit a Field/Selector: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}