package com.amalto.workbench.actions;

import java.net.URL;
import java.util.Iterator;

import org.eclipse.jface.viewers.IStructuredSelection;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;


public class DeleteJobAction extends AbstractAction{

				
	public DeleteJobAction() {
		super();
		setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
		setText("Delete");
		setToolTipText("Delete");
	}
    
	public void run() {
		if (this.server == null) { //called from ServerView
			return;
		}
        closePage();
        
		IStructuredSelection selection = (IStructuredSelection)server.getViewer().getSelection();
		for(Iterator<TreeObject> iter = selection.iterator(); iter.hasNext();) 
		{ 
			TreeObject xobject = iter.next();
			try {
				deleteJob(xobject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}
	
	private void deleteJob(TreeObject xobject) throws Exception
	{
		if (xobject.getType()!=TreeObject.JOB) return;
		
		String filename= xobject.getDisplayName();//TODO
		String endpointaddress=xobject.getEndpointAddress();
		//String filename= xobject.getDisplayName();//TODO
		String uploadURL = new URL(endpointaddress).getProtocol()+"://"+new URL(endpointaddress).getHost()+":"+new URL(endpointaddress).getPort()+"/datamanager/uploadFile?deletefile="+filename;		
		Util.uploadFileToAppServer(uploadURL, filename,"admin","talend");
		xobject.getParent().removeChild(xobject);
	}

}
