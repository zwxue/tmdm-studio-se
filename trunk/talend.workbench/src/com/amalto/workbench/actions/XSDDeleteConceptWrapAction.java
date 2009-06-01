package com.amalto.workbench.actions;

import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;

import com.amalto.workbench.AmaltoWorbenchPlugin;
import com.amalto.workbench.editors.DataModelMainPage;

public class XSDDeleteConceptWrapAction extends Action{

	private DataModelMainPage page = null;
	private XSDDeleteConceptAction deleteConceptAction = null;
	
	public XSDDeleteConceptWrapAction(DataModelMainPage page,XSDDeleteConceptAction deleteConceptAction) {
		super();
		this.deleteConceptAction = deleteConceptAction;
		this.page = page;
		setImageDescriptor(AmaltoWorbenchPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/delete_obj.gif"));
		setText("Delete Concepts");
		setToolTipText("Delete Business Concepts");
	}
	
	public void run() {
		try {
			super.run();
			IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
			if(selection.isEmpty()){
				return;
			}else{
				String conceptLabel = selection.size() > 1 ? (" these "+selection.size()+" concepts ?") : " the selected concept ?";
				if (!MessageDialog.openConfirm(page.getSite().getShell(), "Delete Model", "Are you sure you want to delete" + conceptLabel))
					return;
			}
			
			for (Iterator iterator = selection.iterator(); iterator.hasNext();) {
				Object toDel = (Object) iterator.next();
				deleteConceptAction.run(toDel);
			}
       
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