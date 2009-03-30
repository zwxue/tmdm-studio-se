package com.amalto.workbench.actions;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.amalto.workbench.editors.XObjectEditor;
import com.amalto.workbench.models.IXObjectModelListener;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.JobStatusType;
import com.amalto.workbench.webservices.WSDataCluster;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDestination;
import com.amalto.workbench.webservices.WSDocument;
import com.amalto.workbench.webservices.WSGetJob;
import com.amalto.workbench.webservices.WSInboundAdaptor;
import com.amalto.workbench.webservices.WSInboundPlugin;
import com.amalto.workbench.webservices.WSJob;
import com.amalto.workbench.webservices.WSJobPK;
import com.amalto.workbench.webservices.WSMenu;
import com.amalto.workbench.webservices.WSOutboundAdaptor;
import com.amalto.workbench.webservices.WSOutboundPlugin;
import com.amalto.workbench.webservices.WSPutDataCluster;
import com.amalto.workbench.webservices.WSPutDataModel;
import com.amalto.workbench.webservices.WSPutDestination;
import com.amalto.workbench.webservices.WSPutDocumentInAFileAsJob;
import com.amalto.workbench.webservices.WSPutInboundAdaptor;
import com.amalto.workbench.webservices.WSPutInboundPlugin;
import com.amalto.workbench.webservices.WSPutJob;
import com.amalto.workbench.webservices.WSPutMenu;
import com.amalto.workbench.webservices.WSPutOutboundAdaptor;
import com.amalto.workbench.webservices.WSPutOutboundPlugin;
import com.amalto.workbench.webservices.WSPutRole;
import com.amalto.workbench.webservices.WSPutRoutingRule;
import com.amalto.workbench.webservices.WSPutSource;
import com.amalto.workbench.webservices.WSPutStoredProcedure;
import com.amalto.workbench.webservices.WSPutTransformer;
import com.amalto.workbench.webservices.WSPutView;
import com.amalto.workbench.webservices.WSRole;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSSource;
import com.amalto.workbench.webservices.WSStoredProcedure;
import com.amalto.workbench.webservices.WSTransformer;
import com.amalto.workbench.webservices.WSView;
import com.amalto.workbench.webservices.XtentisPort;

public class SaveXObjectAction extends Action{

	protected XObjectEditor editor = null;
	//private TreeObject initialXObject = null;
	
	
	public SaveXObjectAction(XObjectEditor editor) {
		super();
		this.editor = editor;
		//this.initialXObject = initialXObject;
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/save_edit.gif"));
	}
	
	public void run() {
		try {

			TreeObject xobject = (TreeObject)((XObjectEditorInput)editor.getEditorInput()).getModel();
			Object newWsObject = xobject.getWsObject();
			
            if (!xobject.isXObject()) return;
                                    
//          Access to server and get port
			XtentisPort port = Util.getPort(
					new URL(xobject.getEndpointAddress()),
					xobject.getUsername(),
					xobject.getPassword()
			);
              
            switch(xobject.getType()) {
            
	           	case TreeObject.SOURCE:
	           		//FIXME: check if initialXObject still in Sync with server Object - optimistic locking
	           		port.putSource(new WSPutSource((WSSource)newWsObject));
	           		break;
	           	case TreeObject.DESTINATION:
	           		port.putDestination(new WSPutDestination((WSDestination)newWsObject));
	           		break;
	           	case TreeObject.INBOUND_ADAPTOR:
	           		port.putInboundAdaptor(new WSPutInboundAdaptor((WSInboundAdaptor)newWsObject));
	           		break;
	           	case TreeObject.INBOUND_PLUGIN:
	           		port.putInboundPlugin(new WSPutInboundPlugin((WSInboundPlugin)newWsObject));
	           		break;
	           	case TreeObject.OUTBOUND_ADAPTOR:
	           		port.putOutboundAdaptor(new WSPutOutboundAdaptor((WSOutboundAdaptor)newWsObject));
	           		break;
	           	case TreeObject.OUTBOUND_PLUGIN:
	           		port.putOutboundPlugin(new WSPutOutboundPlugin((WSOutboundPlugin)newWsObject));
	           		break;
	           	case TreeObject.DATA_MODEL:
	           		port.putDataModel(new WSPutDataModel((WSDataModel)newWsObject));
	           		break;
	           	case TreeObject.DOCUMENT:
	           		projectData();
	           		break;
	          	case TreeObject.VIEW:
	           		port.putView(new WSPutView((WSView)newWsObject));
	           		break;           		
	          	case TreeObject.DATA_CLUSTER:
	           		port.putDataCluster(new WSPutDataCluster((WSDataCluster)newWsObject));
	           		break;                      		
	          	case TreeObject.STORED_PROCEDURE:
	           		port.putStoredProcedure(new WSPutStoredProcedure((WSStoredProcedure)newWsObject));
	           		break;   
	          	case TreeObject.ROLE:
	           		port.putRole(new WSPutRole((WSRole)newWsObject));
	           		break;   
	          	case TreeObject.ROUTING_RULE:
	           		port.putRoutingRule(new WSPutRoutingRule((WSRoutingRule)newWsObject));
	           		break;   
	          	case TreeObject.TRANSFORMER:
	           		port.putTransformer(new WSPutTransformer((WSTransformer)newWsObject));
	           		break;   	 
	          	case TreeObject.MENU:
	           		port.putMenu(new WSPutMenu((WSMenu)newWsObject));
	           		break;   	 	           		
	          	default:
	           		MessageDialog.openError(this.editor.getSite().getShell(), "Error", "Unknown Xtentis Object Type: "+xobject.getType());
	           		return;
            }//switch
            
            //notify listeners that the data has been persisted
            if (xobject.getParent() == null) {
            	//add the item to the tree
            	if (xobject.getType() != TreeObject.DOCUMENT) {
            		TreeParent folder = xobject.findServerFolder(xobject.getType());
            		folder.addChild(xobject);
            	}
            	xobject.fireEvent(IXObjectModelListener.SAVE, xobject.getParent(), xobject);
                //new object notify the server root that it needs a refresh (actually not needed for this but a good time to do it)
                xobject.getServerRoot().fireEvent(IXObjectModelListener.NEED_REFRESH, null, xobject.getServerRoot());
            } else {
                //existing object saved
                xobject.fireEvent(IXObjectModelListener.SAVE, xobject.getParent(), xobject);
            }

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					this.editor.getSite().getShell(),
					"Error Occured on Saving", 
					"An error occured trying to save the Xtentis object instance: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	

	/***************************************
	 * Uploading of the document and save
	 * 
	 ***************************************/
	
	private void projectData() {
		
		try {
			TreeObject xobject = (TreeObject)((XObjectEditorInput)editor.getEditorInput()).getModel();
			new ProgressMonitorDialog(this.editor.getSite().getWorkbenchWindow().getShell()).run(
					true,  //fork 
					true, 	//cancelable
					new PutDocumentRunnable(
							this,
							xobject.getEndpointAddress(),
							xobject.getUsername(),
							xobject.getPassword(),
							(String)xobject.getAdditionalInfo()[0],
							(String)xobject.getAdditionalInfo()[1],
							(WSDocument)xobject.getWsObject()
					)
			);
			
		} catch (InterruptedException ie){
			MessageDialog.openError(
					null,
					"Error", 
					"A request for cancelation has been sent to the server but is is likely that the process will continue for a while."
			);
			return;
		} catch (InvocationTargetException ite) {
			ite.printStackTrace();
			MessageDialog.openError(
					null,
					"Error Projecting a Document", 
					"An exception occured projecting the document"+ite.getCause().getLocalizedMessage()
			);
		}

	}
	
	
	class PutDocumentRunnable implements IRunnableWithProgress{
		
		protected SaveXObjectAction parent;
		private String endpointaddress;
		private String username;
		private String password;
		private String localFilename;
		private String encoding;
		private WSDocument document;
		
		protected WSJob job = null;
		
		public PutDocumentRunnable(SaveXObjectAction parent, String endpointaddress, String username, String password, String localFileName, String encoding, WSDocument document) {
			this.parent = parent;
			this.endpointaddress = endpointaddress;
			this.username = username;
			this.password = password;
			this.localFilename = localFileName;
			this.encoding = encoding;
			this.document = document;
		}
	
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			try {
				
				monitor.beginTask("Projecting document ", 4);
	
				monitor.subTask("Uploading File: "+localFilename);		
				String uploadURL = "http://"+endpointaddress+"/datamanager/uploadFile";
				String remoteFile = Util.uploadFileToAppServer(uploadURL, localFilename,username,password);
				monitor.worked(1);
								
				if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
				
				monitor.subTask("Accessing web Services on "+endpointaddress);
				XtentisPort port = Util.getPort(
						new URL(endpointaddress),
						username,
						password
				);
				monitor.worked(1);
				if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
				
				//Project it on the model
				monitor.subTask("Projecting document "+document.getName());

				WSJobPK jobpk = port.putDocumentInAFileAsJob(
						new WSPutDocumentInAFileAsJob(
								document,
								false, //isDelete
								remoteFile,
								encoding
						)
				);

				monitor.worked(1);
				if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
				
				do {
					
					Thread.sleep(15000);
					
					if (monitor.isCanceled()) {
						port.putJob(
								new WSPutJob(
										new WSJob(
												jobpk.getPk(),
												"Loading of document "+document.getName(),
												JobStatusType.CANCEL_REQUESTED,
												"The job was canceled by the user",
												1,
												null
										)
								)
						);
						throw new InterruptedException("User Cancel");
					}
					
					job  =  port.getJob(new WSGetJob(jobpk.getPk()));	
					monitor.subTask(job.getMessage());

				} while (
							job.getStatus().equals(JobStatusType.RUNNING) 
							|| job.getStatus().equals(JobStatusType.SCHEDULED)
							);

				if (job.getStatus().equals(JobStatusType.STOPPED)) throw new XtentisException("The job was stopped : "+job.getMessage());
				
				monitor.worked(1);			
				monitor.done();
				
				parent.editor.getEditorSite().getShell().getDisplay().syncExec (new Runnable () {
					public void run () {
							MessageDialog.openInformation(
									parent.editor.getEditorSite().getShell(),
									"Process Document", 
									"Document Loaded Successfully\nCompletion message: "+job.getMessage()
							);
					}
				});
				
			} catch (InterruptedException ie) {
				throw (ie);
			} catch (Exception e) {
				e.printStackTrace();
				throw new InvocationTargetException(new XtentisException("Could not Project Document: "+e.getLocalizedMessage()));
			}		
		}//run
		
	}//PutDocumentRunnable


}