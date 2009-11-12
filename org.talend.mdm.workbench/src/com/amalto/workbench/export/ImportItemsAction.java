package com.amalto.workbench.export;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPage;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.views.ServerView;

public class ImportItemsAction extends Action{
	private ServerView view = null;
	private TreeObject xobject = null;
	private IWorkbenchPage page = null;
	private String filename;
	private String server;
	
	
	public ImportItemsAction(TreeObject xobject, IWorkbenchPage page) {
		super();
		this.xobject = xobject;
		this.page = page;
		setDetails();
	}
	
	public ImportItemsAction(ServerView view) {
		super();
		this.view = view;
		setDetails();
	}
	
	private void setDetails() {
		setImageDescriptor(ImageCache.getImage( EImage.IMPORT.getPath()));
		setText("Import");
		setToolTipText("Import Items");		
	}
	
	public void run() {
//		try {
			super.run();
			ISelection selection=null;
			if (this.view != null) { //called from ServerView
				selection = view.getViewer().getSelection();
				xobject = (TreeObject)((IStructuredSelection)selection).getFirstElement();
			}	  
			
			
			ImportItemsWizard wizard=new ImportItemsWizard((IStructuredSelection)selection,view);
			WizardDialog dialog = new WizardDialog(view.getSite().getShell(),
					wizard);
			dialog.create();
			dialog.getShell().setText("Import Objects");
			dialog.open(); 
            //if (!xobject.isXObject()) return;

			/*FileDialog fileDialog = new FileDialog (view.getSite().getShell(), SWT.OPEN);				
			//fileDialog.setFilterNames(new String[]{"__contents__.xml"});
			fileDialog.setText("Please select file to import");
			fileDialog.setFilterExtensions(new String[]{"__contents__.xml"});
			filename=fileDialog.open();
			if(filename!=null && new File(filename).exists()){
				String url=xobject.getServerRoot().getEndpointAddress();
				server=null;
				try {
					 server= new URL(url).getHost();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
				
				Job job=new Job("Import data cluster ..."){
					@Override
					public IStatus run(IProgressMonitor monitor) {	
						try{
							//import datacluster data
							File f=new File(filename);
							//Means folder name can not be changed?
							String dataCluster=f.getParentFile().getName();

							monitor.beginTask("Import data cluster " + dataCluster +" ..." ,IProgressMonitor.UNKNOWN);
							Util.importDataCluster(xobject, filename,server,monitor);
							
							//create datacluster
							//Does cluster name need URL encode?
							if(!"db".equalsIgnoreCase(dataCluster)){
								
								if (!dataCluster.startsWith("amaltoOBJECTS")) {
									
									monitor.subTask("Creating data cluster " + dataCluster +" ..." );
									WSDataCluster dc = new WSDataCluster(
											(String)dataCluster,
											"",
											""												//vocabulary
									);
									Util.getPort(xobject).putDataCluster(new WSPutDataCluster(dc));
								}
							}
							monitor.done();							
							return Status.OK_STATUS;
						}catch(Exception e){
							e.printStackTrace();
							return Status.CANCEL_STATUS;
						}finally{
							monitor.subTask("Refreshing server ..." );
							new UIJob("Refreshing server"){

								@Override
								public IStatus runInUIThread(
										IProgressMonitor monitor) {
									new ServerRefreshAction(view,xobject.getServerRoot()).run();
									return Status.OK_STATUS;
								}
								
							}.schedule();
							
						}
					}			
				};
				job.setPriority(Job.INTERACTIVE);
				job.schedule();				
			}
		}catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					view.getSite().getShell(),
					"Error", 
					"An error occured trying to Import Data Cluster: "+e.getLocalizedMessage()
			);
		}finally{
		}		*/
	}
}
