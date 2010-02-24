package com.amalto.workbench.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Authenticator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.talend.mdm.commmon.util.core.CommonUtil;

import com.amalto.workbench.dialogs.ErrorExceptionDialog;
import com.amalto.workbench.dialogs.LoginDialog;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XtentisServerObjectsRetriever;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;

public class ServerLoginAction extends Action implements SelectionListener{

	private LoginDialog dialog = null;
	private ServerView view = null;
	
	
	public ServerLoginAction(ServerView view) {
		super();
		this.view = view;
		setImageDescriptor(ImageCache.getImage( "icons/startserveraction.gif"));
		setText("Login");
		setToolTipText("Login to an "+IConstants.TALEND+" Server");

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
		String server = dialog.getServer();
		String username = dialog.getUsernameText();
		String password = dialog.getPasswordText();
		String universe=dialog.getUniverse();
		dialog.close();
		
		Properties properties = new Properties();
		String f = System.getProperty("user.dir")+"/.mdmworkbench.conf";
		Collection<String> endpoints;
		Collection<String> universes;
		String endpointsString=server;
		String universeString = universe;
		
		//Remove authenticator dialog
		Authenticator.setDefault(null);
        LocalTreeObjectRepository.getInstance().startUp(view, server, username, password);
        LocalTreeObjectRepository.getInstance().switchOnListening();
        LocalTreeObjectRepository.getInstance().setLazySaveStrategy(true, null);
        
		try {
            XtentisServerObjectsRetriever retriever = new XtentisServerObjectsRetriever(
            	server,
            	username,
            	password,
            	universe
            );
			new ProgressMonitorDialog(view.getSite().getShell()).run(
					true, 
					true, 
					retriever
			);
			
			
			try {//add the memory of universe and server
				//check if the file is exist of not,if not,create
				File  dirFile = new File(f);
		        boolean bFile   = dirFile.exists();
		        if(!bFile)
		        	if(dirFile.createNewFile())
		        		properties.load(new FileInputStream(f));
		        	else return;
		        	
				int index = 0;
				endpoints = Arrays.asList(new String[]{Util.default_endpoint_address});
				if (properties.getProperty("endpoints")!=null)	 
					endpoints = Arrays.asList(properties.getProperty("endpoints").split(","));
				if (properties.getProperty("universes")!=null)	 
					universes=Arrays.asList(properties.getProperty("universes").split(","));
				for (Iterator<String> iter = endpoints.iterator(); iter.hasNext();) {
					String endpoint = iter.next();
					if (!endpoint.equals(server))
						endpointsString += "," + endpoint;
					if (++index == 10)
						break;
				}
				properties.setProperty("endpoints", endpointsString);
				index = 0;
				universes = Arrays.asList(new String[]{""});
				for (Iterator<String> iter = universes.iterator(); iter.hasNext(); ) {
					universe = iter.next();
					if (! universe.equals(server)) universeString+=","+universe;
					if (++index == 5) break;
				}
				properties.setProperty("universes", universeString);
				
				properties.store(new FileOutputStream(f), null);
			} catch (Exception e1) {
			}
			
			
			
			
            if(!retriever.isExistUniverse()){
            	//MessageDialog.openError(view.getViewer().getControl().getShell(), "Wrong universe", "Can't find the Version,please try again!");
            	return;
            }
            TreeParent serverRoot = retriever.getServerRoot();
            TreeParent invisibleRoot = view.getTreeContentProvider().getInvisibleRoot();
            TreeObject[] serverRoots = invisibleRoot.getChildren();
            
            boolean found = false;
            for (int i = 0; i < serverRoots.length; i++) {
            	//aiming add root displayName as unique ID of each server
            	if(serverRoots[i].getDisplayName().equals(serverRoot.getDisplayName())){
	                if (serverRoots[i].getWsKey().equals(serverRoot.getWsKey())) {
	                    //server & universe already exists --> synchronize
	                	if(serverRoots[i].getUser().getUniverse().equalsIgnoreCase(serverRoot.getUser().getUniverse())){
		                    found = true;
		                    ((TreeParent)serverRoots[i]).synchronizeWith(serverRoot);
	                	}
	                }
            	}
            }
            if (!found) 
            	invisibleRoot.addChild(serverRoot);
           
            view.getViewer().refresh();
            view.getViewer().expandToLevel(serverRoot,1);
		} catch (InterruptedException ie){
			return;
		} catch (InvocationTargetException ite) {
			ite.printStackTrace();
			ErrorExceptionDialog.openError(
					dialog.getShell(),
					"Error", 
					CommonUtil.getErrMsgFromException(ite.getCause())
			);
		}
        
	}
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	

}