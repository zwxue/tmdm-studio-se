package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.views.ServerView;

public class BrowseViewAction extends Action{

	private ServerView server = null;

				
	public BrowseViewAction(ServerView serverView) {
		super();
		this.server = serverView;
			
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/edit.gif"));
		setText("Browse");
		setToolTipText("Browse Content");
	}
	
	public void run() {
		try {
			super.run();
			
	        ISelection selection = this.server.getViewer().getSelection();
	        TreeObject xobject = (TreeObject)((IStructuredSelection)selection).getFirstElement();
			
       		server.getSite().getWorkbenchWindow().getActivePage().openEditor(
                    new XObjectBrowserInput(xobject,xobject.getDisplayName()),
                    "com.amalto.workbench.editors.XObjectBrowser"
           	);
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					server.getSite().getShell(),
					"Error", 
					"An error occured trying to open the view browser: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	
}//Class EditDocumentAction

