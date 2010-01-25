package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.TreeObjectUtil;
import com.amalto.workbench.views.ServerView;

public class RenameXObjectAction extends Action {
	private ServerView view = null;
	public RenameXObjectAction(ServerView view) {
		super();
		this.view = view;
		setImageDescriptor(ImageCache.getImage(EImage.RENAME.getPath()));
		
		setText("Rename");
		setToolTipText("Rename the selected object");
	}
	@Override
	public void run() {
		ISelection selection = view.getViewer().getSelection();
        TreeObject xobject = (TreeObject)((IStructuredSelection)selection).getFirstElement();	
        try {
			if(TreeObjectUtil.renameTreeOjects(xobject, view))
				TreeObjectUtil.deleteTreeObject(xobject, view);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
