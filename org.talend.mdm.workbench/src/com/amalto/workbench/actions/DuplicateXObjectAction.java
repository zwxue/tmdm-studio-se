package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.views.ServerView;

public class DuplicateXObjectAction extends Action {

	
	private ServerView view;

	public DuplicateXObjectAction(ServerView view) {
		super();
		this.view = view;
		setDetails();
	}
	@Override
	public void run() {
		super.run();
		new CopyXObjectAction(view).run();
		new PasteXObjectAction(view).run();
	}
	
	private void setDetails() {
		setImageDescriptor(ImageCache.getImage(EImage.DUPLICATE.getPath()));
		setText("Duplicate");
		setToolTipText("Duplicate this instance of the "+IConstants.TALEND+" Object");		
	}
}
