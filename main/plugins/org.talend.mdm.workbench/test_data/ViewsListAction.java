// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.actions;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.amalto.workbench.dialogs.ViewsListDialog;

public class ViewsListAction extends AServerViewAction{
	
	public ViewsListAction() {
		super();
		setImageDescriptor(ImageCache.getImage( "icons/search.gif"));
		setText("Browse Views...");
		setToolTipText("Select a views from the ist and browse");
	}
	
	public void run() {
		try {
			super.run();
			ViewsListDialog dialog = new ViewsListDialog(getServerView());
			dialog.setBlockOnOpen(false);
			dialog.open();

		} catch (Exception e) {
		    log.error(e.getMessage(), e);
			MessageDialog.openError(
					getServerView().getSite().getShell(),
					"Error", 
					"An error occured trying to open the Views List Dialog: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}