package com.amalto.workbench.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.progress.UIJob;
import org.talend.mdm.commmon.util.webapp.XSystemObjects;
import org.talend.mdm.commmon.util.workbench.ZipToFile;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.utils.TreeObjectUtil;
import com.amalto.workbench.views.ServerView;

public class DeleteXObjectAction extends Action{

	private ServerView view = null;
	
	
	public DeleteXObjectAction(ServerView view) {
		super();
		this.view = view;
		setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
		setText("Delete");
		setToolTipText("Delete this instance of the "+IConstants.TALEND+" Object");
	}
	
	public void run() {
		try {
			super.run();
			IStructuredSelection selection = (IStructuredSelection)view.getViewer().getSelection();
			//add the node here
			IWorkbenchPage page = view.getSite().getWorkbenchWindow().getActivePage();
			final ArrayList<TreeObject> toDelList = new ArrayList<TreeObject>();
			
			if(selection.isEmpty()){
				return;
			}
			else{
				int size = selection.size();
				String s = new String();
				List<IEditorPart> opendViewer = new ArrayList<IEditorPart>();
				
				if(size>1)
					s="Instances";
				else
					s="Instance";
				
				for(Iterator<TreeObject> iter = selection.iterator(); iter.hasNext();) {
					TreeObject xobject = iter.next();
					IEditorInput xobjectBrowserViewinput = new XObjectBrowserInput(xobject, xobject.getDisplayName()); 
					IEditorInput xobjectEditorinput = new XObjectEditorInput(xobject, xobject.getDisplayName());

					if(page.findEditor(xobjectBrowserViewinput) != null) {					  
					   opendViewer.add(page.findEditor(xobjectBrowserViewinput));
					}
					if(page.findEditor(xobjectEditorinput) != null) {					  
						   opendViewer.add(page.findEditor(xobjectEditorinput));
					}
					
	            if ((!xobject.isXObject() && xobject.getType() != TreeObject.CATEGORY_FOLDER)
						|| (xobject.getType() == TreeObject.CATEGORY_FOLDER
						&& xobject.getDisplayName().equals("System")))
					continue;
	            else if (xobject.getType() == TreeObject.CATEGORY_FOLDER && !xobject.getDisplayName().equals("System"))
	            {
	            	TreeParent parent = (TreeParent)xobject;
	            	LocalTreeObjectRepository.getInstance().receiveAllOffsprings(parent, toDelList);
	            	toDelList.add(xobject);
	            }
	            else if(!XSystemObjects.isExist(xobject.getType(), xobject.getDisplayName())){
	            	toDelList.add(xobject);
	            }//if there are items which are not default, isnotdefault is true
				}
				
				if(opendViewer.size()>0) {
				   for(IEditorPart editorpart:opendViewer ) {
						page.closeEditor(editorpart, false);
				   }
				}
				
				if(toDelList.size() > 0){
					if (! MessageDialog.openConfirm(
		            		this.view.getSite().getShell(),
		            		"Delete "+IConstants.TALEND+" Object Instance",
		            		"Are you sure you want to delete the "+ toDelList.size() + " " +s +"?"
		            )) return;
					
				}//if the isnotdefault is true,open this dialog
			}//end of if(selection...)

			UIJob job=new UIJob("delete Objects ..."){
				@Override
				public IStatus runInUIThread(IProgressMonitor monitor) {	
					try{			
						 deleteTreeObject(toDelList);
						return Status.OK_STATUS;
					}catch(Exception e){
						e.printStackTrace();
						return Status.CANCEL_STATUS;
					}
				}			
			};
			job.setPriority(Job.SHORT);
			job.schedule();
			
             //for
			 //view.getViewer().refresh();
			                   
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					view.getSite().getShell(),
					"Error", 
					"An error occured trying to delete the "+IConstants.TALEND+" object: "+e.getLocalizedMessage()
			);
		}finally {
			//refresh view
			//view.forceAllSiteToRefresh();
		}		
	}
	
	
	private void deleteTreeObject(ArrayList<TreeObject> toDelList) throws Exception
	{
		for (Iterator<TreeObject> iter = toDelList.iterator(); iter.hasNext(); ) {
			TreeObject xobject = iter.next();
			TreeObjectUtil.deleteTreeObject(xobject, view);       

            if (xobject.getParent() != null)
       		  xobject.getParent().removeChild(xobject);
           
		}
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}