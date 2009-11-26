/**
 * 
 */
package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;

import com.amalto.workbench.dialogs.UploadCustomTypeDialog;
import com.amalto.workbench.export.ImportItemsWizard;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.views.ServerView;

/**
 * @author Administrator
 *
 */
public class UploadCustomTypeAction extends Action {
private ServerView view=null;

public UploadCustomTypeAction(ServerView view) {
	super();
	this.view = view;
	setImageDescriptor(ImageCache.getImage(EImage.SEARCH.getPath()));
	setText("Upload");
	setToolTipText("Upload Custom Type");
}
	@Override
		public void run() {

		super.run();
		ISelection selection = view.getViewer().getSelection();
		TreeObject xobject = (TreeObject)((IStructuredSelection)selection).getFirstElement();	
		
		UploadCustomTypeDialog dialog=new UploadCustomTypeDialog(xobject.getServerRoot(), view.getSite().getShell(),xobject.getEndpointIpAddress());
		dialog.setBlockOnOpen(true);
		dialog.open();
}
}
