package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDSchema;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.XSDTreeContentProvider;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDSetAnnotationDocumentationAction extends Action{

	protected DataModelMainPage page = null;
	protected XSDSchema schema = null;
	
	
	public XSDSetAnnotationDocumentationAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/annotation.gif"));
		setText("Set the Documentation");
		setToolTipText("Set the Documentation for this element");
	}
	
	public void run() {
		try {
			super.run();
            schema = ((XSDTreeContentProvider)page.getTreeViewer().getContentProvider()).getXsdSchema();
            IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
            XSDAnnotationsStructure struc = new XSDAnnotationsStructure((XSDComponent)selection.getFirstElement());
            if (struc.getAnnotation() == null) {
            	throw new RuntimeException("Unable to edit an annotation for object of type "+selection.getFirstElement().getClass().getName());
            }
            
       		InputDialog id = new InputDialog(
       				page.getSite().getShell(),
       				"Set the Documentation",
       				"Enter a text for the documentation - Leave BLANK to delete the Documentation",
       				struc.getDocumentation(),
       				new IInputValidator() {
       					public String isValid(String newText) {
       						return null;
       					};
       				}
       		);
            
       		id.setBlockOnOpen(true);
       		int ret = id.open();
       		if (ret == Window.CANCEL) return;
       		
       		struc.setDocumentation("".equals(id.getValue()) ? null : id.getValue());
       		
       		if (struc.hasChanged()) {
       			page.getTreeViewer().refresh(true);
       			page.getTreeViewer().expandToLevel(selection.getFirstElement(), 2);
       			page.markDirty();
       		}
       		
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to set the Documentation: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}