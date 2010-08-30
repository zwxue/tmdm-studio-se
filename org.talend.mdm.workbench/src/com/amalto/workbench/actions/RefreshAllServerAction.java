package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XtentisServerObjectsRetriever;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.views.ServerView;

public class RefreshAllServerAction extends Action {
	private ServerView view;

		
	public RefreshAllServerAction(ServerView view) {
		super();
		this.view = view;
		setImageDescriptor(ImageCache.getImage( EImage.REFRESH.getPath()));
		setText("Refresh");
		setToolTipText("Refresh All the Server");
	}
	
	public void run() {

			doRun();
		
	}
	public void doRun(){
		for( TreeParent serverRoot:view.getServers()) {
			try {
					String server = (String)serverRoot.getWsKey();  //we are at server root
					
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
					serverRoot.synchronizeWith(retriever.getServerRoot());
					ServerView.show().getViewer().refresh();
					LocalTreeObjectRepository.getInstance().setLazySaveStrategy(false, serverRoot);
				
			} catch (Exception e) {
				e.printStackTrace();
				//throw new Exception("Error while refreshing the "+IConstants.TALEND+" Server Objects: "+e.getLocalizedMessage());			
			}
		}
	}

}
