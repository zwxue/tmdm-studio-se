package com.amalto.workbench.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.ObjectRetriever;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.views.ServerView;
import com.sun.org.apache.xpath.internal.objects.XObject;

public class RefreshXObjectAction extends Action {
	protected ServerView view = null;
	protected XObject xobject = null;
	protected TreeParent serverObject = null;
    private TreeObject selection;
	public RefreshXObjectAction(ServerView view, TreeObject selection) {
		super();
		this.view = view;
		this.selection=selection;
		setImageDescriptor(ImageCache.getImage( EImage.REFRESH.getPath()));
		setText("Refresh");
		setToolTipText("Refresh the "+IConstants.TALEND+" Server Object(s)");
	}
	public void run() {
		try {
//		 TreeParent xobject = (TreeParent) ((IStructuredSelection) view.getViewer().getSelection()).getFirstElement();
		TreeParent xobject = (TreeParent)selection;
		serverObject = xobject.getServerRoot();

		if (xobject == null)
			return;
		String server = (String) xobject.getServerRoot().getWsKey(); 
		ObjectRetriever retriever = new ObjectRetriever(
				(TreeParent)xobject,
				server, 
				serverObject.getUsername(), 
				serverObject.getPassword(),
				serverObject.getUser().getUniverse()
				);
	/*	LocalTreeObjectRepository.getInstance().startUp(
				view, server,
				serverObject.getUser().getUsername(),
				serverObject.getUser().getPassword()
				);
		LocalTreeObjectRepository.getInstance().switchOnListening();
		LocalTreeObjectRepository.getInstance().setLazySaveStrategy(true,xobject);*/

		
		retriever.run(new NullProgressMonitor());
		

		//RefreshXObjectAction.this.xobject.synchronizeWith();
		//ServerView.show().getViewer().refresh(xobject);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
}
