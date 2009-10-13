package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;

import com.amalto.workbench.image.ImageCache;

public class VersioningCompareAction  extends Action{
	
	public VersioningCompareAction() {
		super();
		setImageDescriptor(ImageCache.getImage( "icons/versioning.gif"));
		setText("Compare with Each Other");
		setToolTipText("Compare with two items");
	}
	
	//TODO: to be supported

}
