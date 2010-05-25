package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XtentisServerObjectsRetriever;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.views.ServerView;

public class ServerRefreshAction extends Action {

	protected ServerView view = null;
	protected String server = null;
    protected TreeParent serverRoot = null;
    protected TreeParent forcedRoot = null;
    protected TreeParent newRoot = null;
	
	
	
	public ServerRefreshAction(ServerView view, TreeParent forcedRoot) {
		this(view);
		this.forcedRoot = forcedRoot;
	}
		
	public ServerRefreshAction(ServerView view) {
		super();
		this.view = view;
		setImageDescriptor(ImageCache.getImage( EImage.REFRESH.getPath()));
		setText("Refresh");
		setToolTipText("Refresh the "+IConstants.TALEND+" Server Object(s)");
	}
	
	public void run() {
		try {
			if (forcedRoot == null)
				//get it dynamically
				serverRoot = (TreeParent)((IStructuredSelection)view.getViewer().getSelection()).getFirstElement();
			else
				serverRoot = forcedRoot;
			if(serverRoot==null) return;
			server = (String)serverRoot.getWsKey();  //we are at server root
			
            XtentisServerObjectsRetriever retriever = new XtentisServerObjectsRetriever(
                	server,
                	serverRoot.getUsername(),
                	serverRoot.getPassword(),
                	serverRoot.getUser().getUniverse(),
                	view
                );
			
			new ProgressMonitorDialog(view.getSite().getShell()).run(
					true, 
					true, 
					retriever
			);
			ServerRefreshAction.this.serverRoot.synchronizeWith(retriever.getServerRoot());
			ServerView.show().getViewer().refresh();
			LocalTreeObjectRepository.getInstance().setLazySaveStrategy(false, serverRoot);
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(view.getSite().getShell(), "Error", "Error while refreshing the "+IConstants.TALEND+" Server Objects: "+e.getLocalizedMessage());
		}
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	

}