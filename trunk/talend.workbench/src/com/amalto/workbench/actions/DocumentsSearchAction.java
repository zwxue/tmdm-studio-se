package com.amalto.workbench.actions;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.amalto.workbench.dialogs.DocumentsSearchDialog;

public class DocumentsSearchAction extends AServerViewAction{
	
	public DocumentsSearchAction() {
		super();
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/search.gif"));
		setText("Search Documents....");
		setToolTipText("Search documents.");
	}
	
	public void run() {
		try {
			super.run();
			DocumentsSearchDialog dialog = new DocumentsSearchDialog(getServerView());
			dialog.setBlockOnOpen(false);
			dialog.open();

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					getServerView().getSite().getShell(),
					"Error", 
					"An error occured trying to open the search documents Dialog: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}