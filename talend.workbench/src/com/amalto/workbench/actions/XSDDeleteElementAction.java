package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.XSDTreeContentProvider;
import com.amalto.workbench.utils.Util;

public class XSDDeleteElementAction extends Action{

	private DataModelMainPage page = null;
	private XSDSchema schema = null;
	
	public XSDDeleteElementAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/delete_obj.gif"));
		setText("Delete Element");
		setToolTipText("Delete an Element");
	}
	
	public void run() {
		try {
			super.run();
            schema = ((XSDTreeContentProvider)page.getTreeViewer().getContentProvider()).getXsdSchema();
            ISelection selection = page.getTreeViewer().getSelection();
            XSDElementDeclaration decl = (XSDElementDeclaration)((IStructuredSelection)selection).getFirstElement();
            
            //ask for confimation
            if (! MessageDialog.openConfirm(
            		this.page.getSite().getShell(),
            		"Delete Element",
            		"Are you sure you want to delete the element "+decl.getAliasName()+" ?"
            )) return;

            //backup current Type Definition
            XSDTypeDefinition current = decl.getTypeDefinition();
            
            //remove declaration
            schema.getContents().remove(decl);
            
            //remove type definition is no more used and type is not built in
       	    if (	(current.getName()!=null) &&  //anonymous type
       	    		(!schema.getSchemaForSchemaNamespace().equals(current.getTargetNamespace()))
       	    	){
       			if (Util.findElementsUsingType(schema,current.getTargetNamespace(), current.getName()).size()==0)
       				schema.getContents().remove(current);
			}
            
            schema.update();
       		
       		page.getTreeViewer().refresh(true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to remove the Element: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}