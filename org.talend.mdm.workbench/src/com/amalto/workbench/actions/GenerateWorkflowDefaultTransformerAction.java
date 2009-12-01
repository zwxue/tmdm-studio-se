package com.amalto.workbench.actions;

import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;

import com.amalto.workbench.dialogs.WorkflowDefaultTransformerGenerateWizard;
import com.amalto.workbench.dialogs.NewUserWizard;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.XtentisPort;

public class GenerateWorkflowDefaultTransformerAction extends Action{

	private ServerView server = null;
	private TreeObject xobject;

				
	public GenerateWorkflowDefaultTransformerAction(ServerView serverView) {
		super();
		this.server = serverView;
			
		setImageDescriptor(ImageCache.getImage(EImage.PROCESS.getPath()));
		setText("Generate workflow default transformer");
		setToolTipText("Generate workflow default transformer");
	}
	
	public void run() {
		if (this.server != null) { //called from ServerView
			ISelection selection = server.getViewer().getSelection();
			xobject = (TreeObject)((IStructuredSelection)selection).getFirstElement();
		}
        
        if (xobject.getType()!=TreeObject.WORKFLOW_PROCESS) return;
       try{ 
	
    	   WorkflowDefaultTransformerGenerateWizard wizard = new WorkflowDefaultTransformerGenerateWizard(xobject,server);
			wizard.setWindowTitle("Generate workflow default transformer");
			WizardDialog dialog = new WizardDialog(server.getSite().getShell(), wizard);
			dialog.open();			
			
       }catch(Exception e){
    	   
       }
	}

}
