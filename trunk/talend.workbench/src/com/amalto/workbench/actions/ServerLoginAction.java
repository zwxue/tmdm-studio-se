package com.amalto.workbench.actions;

import java.lang.reflect.InvocationTargetException;
import java.net.Authenticator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.amalto.workbench.dialogs.LoginDialog;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XtentisServerObjectsRetriever;
import com.amalto.workbench.views.ServerView;

public class ServerLoginAction extends Action implements SelectionListener{

	private LoginDialog dialog = null;
	private ServerView view = null;
	
	
	public ServerLoginAction(ServerView view) {
		super();
		this.view = view;
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/startserveraction.gif"));
		setText("Login");
		setToolTipText("Login to an Xtentis Server");

	}
	
	public void run() {
		try {
			super.run();
			dialog = new LoginDialog(this,view.getSite().getShell(),"Xtentis Login");
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
		
		//Remove authenticator dialog
		Authenticator.setDefault(null);
		
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
            if(!retriever.isExistUniverse()){
            	//MessageDialog.openError(view.getViewer().getControl().getShell(), "Wrong universe", "Can't find the universe,please try again!");
            	return;
            }
            TreeParent serverRoot = retriever.getServerRoot();
            TreeParent invisibleRoot = view.getTreeContentProvider().getInvisibleRoot();
            TreeObject[] serverRoots = invisibleRoot.getChildren();
            
            boolean found = false;
            for (int i = 0; i < serverRoots.length; i++) {
                if (serverRoots[i].getWsKey().equals(serverRoot.getWsKey())) {
                    //server & universe already exists --> synchronize
                	if(serverRoots[i].getUser().getUniverse().equalsIgnoreCase(serverRoot.getUser().getUniverse())){
	                    found = true;
	                    ((TreeParent)serverRoots[i]).synchronizeWith(serverRoot);
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
			MessageDialog.openError(
					dialog.getShell(),
					"Error", 
					"Could not start login process "+ite.getCause().getLocalizedMessage()
			);
		}
        
	}
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	

}