package com.amalto.workbench.actions;

import java.rmi.RemoteException;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;

import com.amalto.workbench.dialogs.LoginDialog;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSGetUniversePKs;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.XtentisPort;

public class ServerLoginAction extends Action implements SelectionListener{

	private LoginDialog dialog = null;
	private ServerView view = null;
	private WSUniversePK[] universes;
	
	
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
			WSUniversePK[] universePKs = null;
			try {
				XtentisPort port = view.getPort();
				if(port!=null)
					universePKs = port.getUniversePKs(new WSGetUniversePKs("*")).getWsUniversePK();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			universes=universePKs;
			dialog = new LoginDialog(this,view.getSite().getShell(),IConstants.TALEND+" Login",universes);			
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