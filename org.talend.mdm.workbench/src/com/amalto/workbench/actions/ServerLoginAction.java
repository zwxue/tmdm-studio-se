package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
	private List<WSUniversePK> universes=new ArrayList<WSUniversePK>(); ;
	
	
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
				universes=new ArrayList<WSUniversePK>();
				WSUniversePK[] universePKs = null;
				List<XtentisPort> ports = view.getPorts();
				if(ports!=null){
					for (Iterator iterator = ports.iterator(); iterator
							.hasNext();) {
						XtentisPort port = (XtentisPort) iterator.next();
						universePKs = port.getUniversePKs(new WSGetUniversePKs("*")).getWsUniversePK();
						
						if(universePKs!=null&&universePKs.length>0)
							CollectionUtils.addAll(universes, universePKs);
					}
					}
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