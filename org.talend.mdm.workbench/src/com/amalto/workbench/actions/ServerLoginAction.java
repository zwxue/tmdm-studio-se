package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;

import com.amalto.workbench.dialogs.LoginDialog;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.views.ServerView;

public class ServerLoginAction extends Action implements SelectionListener{

	private LoginDialog dialog = null;
	private ServerView view = null;
	
	
	public ServerLoginAction(ServerView view) {
		super();
		this.view = view;
		setImageDescriptor(ImageCache.getImage( "icons/startserveraction.gif"));
		setText("Login");
//		setToolTipText("Login to an "+IConstants.TALEND+" Server");
		setToolTipText("Add MDM Server Location");

	}
	
	public void run() {
		try {
			super.run();
			dialog = new LoginDialog(this,view.getSite().getShell(),IConstants.TALEND+" Login");			
			dialog.setBlockOnOpen(true);		
			dialog.open();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	

	/***************************************
	 * Selection Listener on OK Button
	 * 
	 ***************************************/
	public void widgetSelected(SelectionEvent e) {
		int buttonId = ((Integer) e.widget.getData()).intValue();
        if (IDialogConstants.OK_ID != buttonId) return;
		String url = dialog.getServer();
		String username = dialog.getUsernameText();
		String password = dialog.getPasswordText();
		String universe=dialog.getUniverse();
		dialog.close();
		view.initServerTree(url, username, password, universe);
        
	}


	public void widgetDefaultSelected(SelectionEvent e) {
	}

	

}