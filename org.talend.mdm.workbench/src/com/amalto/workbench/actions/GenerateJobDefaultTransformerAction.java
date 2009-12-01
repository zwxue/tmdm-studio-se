package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;

import com.amalto.workbench.dialogs.WorkflowDefaultTransformerGenerateWizard;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.views.ServerView;

public class GenerateJobDefaultTransformerAction extends Action{

	private ServerView server = null;
	private TreeObject xobject;

				
	public GenerateJobDefaultTransformerAction(ServerView serverView) {
		super();
		this.server = serverView;
			
		setImageDescriptor(ImageCache.getImage(EImage.JOB.getPath()));
		setText("Generate TIS Job default transformer");
		setToolTipText("Generate TIS Job default transformer");
	}
	
	public void run() {
		if (this.server != null) { //called from ServerView
			ISelection selection = server.getViewer().getSelection();
			xobject = (TreeObject)((IStructuredSelection)selection).getFirstElement();
		}
        
        if (xobject.getType()!=TreeObject.JOB) return;
       try{ 
	
    	   WorkflowDefaultTransformerGenerateWizard wizard = new WorkflowDefaultTransformerGenerateWizard(xobject,server);
			wizard.setWindowTitle("Generate TIS Job default transformer");
			WizardDialog dialog = new WizardDialog(server.getSite().getShell(), wizard);
			dialog.open();			
			
       }catch(Exception e){
    	   
       }
	}

}
