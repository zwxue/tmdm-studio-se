package com.amalto.workbench.dialogs;

import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSDeleteDocument;
import com.amalto.workbench.webservices.WSDocument;
import com.amalto.workbench.webservices.WSDocumentPK;
import com.amalto.workbench.webservices.WSGetDocument;
import com.amalto.workbench.webservices.XtentisPort;

public class DocumentsSearchDialog extends Dialog {

	private final static int BUTTON_NEW = 10;
	private final static int BUTTON_PROJECT = 11;
	private final static int BUTTON_DELETE = 12;
	
	protected  ServerView serverView = null;
	
	private WSDocument[] results = null;
	
	protected Text sDocumentText;
	protected ListViewer docsListViewer;

	/**
	 * @param serverView
	 */
	public DocumentsSearchDialog(ServerView serverView) {
		super(serverView.getSite().getShell());
		this.serverView = serverView;
	}

	protected Control createDialogArea(Composite parent) {
		
		try {
			//Should not really be here but well,....
			parent.getShell().setText("Search Documents");
			
			Composite composite = (Composite) super.createDialogArea(parent);
			GridLayout layout = (GridLayout)composite.getLayout();
			layout.numColumns = 2;
			
			Group searchGroup = new Group(composite,SWT.SHADOW_NONE);
			searchGroup.setLayout(new GridLayout(2,true));
			searchGroup.setLayoutData(
					new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
			);
			searchGroup.setText("Search Documents");

			Label documentLabel = new Label(searchGroup, SWT.NONE);
			documentLabel.setLayoutData(
					new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
			);
			documentLabel.setText("Document");
					
			sDocumentText = new Text(searchGroup, SWT.NONE);
			sDocumentText.setLayoutData(
					new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
			);
			sDocumentText.setText("*");
			
			Button searchButton = new Button(searchGroup,SWT.PUSH);
			searchButton.setLayoutData(
					new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
			);
			searchButton.setText("Search");
			searchButton.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {}
				public void widgetSelected(SelectionEvent e) {searchDocuments();}				
			});
			parent.getShell().setDefaultButton(searchButton);
			
			Group resultGroup = new Group(composite,SWT.SHADOW_NONE);
			resultGroup.setLayout(new GridLayout(2,false));
			resultGroup.setLayoutData(
					new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
			);
			((GridData)resultGroup.getLayoutData()).minimumHeight = 200;
			resultGroup.setText("Search Results");
			
			docsListViewer = new ListViewer(resultGroup,SWT.V_SCROLL | SWT.H_SCROLL);
            docsListViewer.getControl().setLayoutData(    
                    new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
            );
			docsListViewer.setContentProvider(new ArrayContentProvider());
			docsListViewer.setLabelProvider(new ILabelProvider() {
				public void addListener(ILabelProviderListener listener) {}
				public void dispose() {}
				public boolean isLabelProperty(Object element, String property) {return false;}
				public void removeListener(ILabelProviderListener listener) {}
				public Image getImage(Object element) {return null;}
				public String getText(Object element) {
					return ((WSDocument)element).getName();
				}			
			})	;
			docsListViewer.setSorter(new ViewerSorter());
			
			docsListViewer.addDoubleClickListener(new IDoubleClickListener() {
				public void doubleClick(DoubleClickEvent event) {
					(new ProjectDocumentAction(DocumentsSearchDialog.this.serverView,DocumentsSearchDialog.this)).run();
				}
			});
			
			hookContextMenu();
			
		    return composite;
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					this.getShell(),
					"Error", 
					"An error occured trying to create Document Search window: "+e.getLocalizedMessage()
			);
			return null;
		}
		
	}

	
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, BUTTON_PROJECT, "Project",false);
		createButton(parent, BUTTON_DELETE, "Delete",false);
		createButton(parent, BUTTON_NEW, "New",false);
	}



	protected void buttonPressed(int buttonId) {
		switch (buttonId) {
		case BUTTON_PROJECT:
			(new ProjectDocumentAction(serverView,this)).run();
			break;
		case BUTTON_NEW:
			(new NewDocumentAction(serverView,this)).run();
			break;
		case BUTTON_DELETE:
			(new DeleteDocumentAction(serverView,this)).run();
			break;
			
		}
	}
	
	
	/***********************************************
	 * Search Documents
	 *
	 ***********************************************/
	
	public void searchDocuments() {
		try {
			ISelection selection =serverView.getViewer().getSelection();
	        TreeObject xo = (TreeObject)((IStructuredSelection)selection).getFirstElement();
			DocumentsSearchDialog.this.results = Util.getAllDocuments(
					new URL(xo.getEndpointAddress()),
					xo.getUsername(),
					xo.getPassword(),
					sDocumentText.getText().replaceAll("\\*",".*")
			);
			docsListViewer.setInput(DocumentsSearchDialog.this.results);
		} catch (Exception exx) {
			exx.printStackTrace();
			MessageDialog.openError(
					DocumentsSearchDialog.this.getShell(),
					"Error", 
					"Unable to retrieve the documents list: "+exx.getLocalizedMessage()
			);
		}
	}
	
	public StructuredViewer getDocsListViewer() {
		return docsListViewer;
	}
		
	
	
	
	/**************************
	 * 
	 * ListViewer  CONTEXT MENU
	 */
	
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				DocumentsSearchDialog.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(docsListViewer.getControl());
		docsListViewer.getControl().setMenu(menu);
		//getSite().registerContextMenu(menuMgr, viewer);
	}
	protected void fillContextMenu(IMenuManager manager) {
        if (!docsListViewer.getSelection().isEmpty()) {
        	manager.add(new ProjectDocumentAction(serverView,this));
        	manager.add(new DeleteDocumentAction(serverView,this));
        }
        manager.add(new NewDocumentAction(serverView,this));
	}
	
	
	
	
	
	 class ProjectDocumentAction extends Action{

			private ServerView view = null;
			private DocumentsSearchDialog searchDialog = null;
			
			private TreeParent serverRoot = null;
			private WSDocument doc = null;
						
			public ProjectDocumentAction(ServerView view, DocumentsSearchDialog searchDialog) {
				super();
				this.view = view;
				this.searchDialog = searchDialog;
			
	            ISelection selection = view.getViewer().getSelection();
	            TreeObject xo = (TreeObject)((IStructuredSelection)selection).getFirstElement();
				this.serverRoot = xo.getServerRoot();
				
	            selection = searchDialog.getDocsListViewer().getSelection();
	            this.doc  = (WSDocument)((IStructuredSelection)selection).getFirstElement();
				
				setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/edit.gif"));
				setText("Project");
				setToolTipText("Project the Document");
			}
			
			public void run() {
				try {
					super.run();
		            
		            TreeObject xobject = new TreeObject(
		            		doc.getName(),
		            		serverRoot, 
		            		TreeObject.DOCUMENT, 
		            		new WSDocumentPK(doc.getName()),
		            		doc
		            );
		            
		            searchDialog.close();
		            
		       		view.getSite().getWorkbenchWindow().getActivePage().openEditor(
		                    new XObjectEditorInput(xobject,xobject.getDisplayName()),
		                    "com.amalto.workbench.editors.XObjectEditor"
		           	);
		       
				} catch (Exception e) {
					e.printStackTrace();
					MessageDialog.openError(
							searchDialog.getShell(),
							"Error", 
							"An error occured trying to open the document editor: "+e.getLocalizedMessage()
					);
				}		
			}
			public void runWithEvent(Event event) {
				super.runWithEvent(event);
			}
			
		}//Class EditDocumentAction
	 
	 
	 
	 
	 class DeleteDocumentAction extends Action{

			private ServerView view = null;
			private DocumentsSearchDialog searchDialog = null; 
			
			private TreeObject xobject = null;
			private WSDocument doc = null;
			
			public DeleteDocumentAction(ServerView view, DocumentsSearchDialog searchDialog) {
				super();
				this.view = view;
				this.searchDialog = searchDialog;
				
	            ISelection selection = view.getViewer().getSelection();
	            this.xobject = (TreeObject)((IStructuredSelection)selection).getFirstElement();
				
	            selection = searchDialog.getDocsListViewer().getSelection();
	            this.doc  = (WSDocument)((IStructuredSelection)selection).getFirstElement();
		            
				setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/delete_obj.gif"));
				setText("Delete");
				setToolTipText("Delete this Document");
			}
			
			public void run() {
				try {
					super.run();
	            
		            //ask for confimation
		            if (! MessageDialog.openConfirm(
		            		searchDialog.getShell(),
		            		"Delete Document",
		            		"Are you sure you want to delete "+doc.getName()+" ?"
		            )) return;
		                        
//		          	Access to server and get port
					XtentisPort port = Util.getPort(
							new URL(xobject.getEndpointAddress()),
							xobject.getUsername(),
							xobject.getPassword()
					);
	           		port.deleteDocument(new WSDeleteDocument(new WSDocumentPK(doc.getName())));
		            
	           		//refresh with the new list
	           		searchDialog.searchDocuments();		                   
				} catch (Exception e) {
					e.printStackTrace();
					MessageDialog.openError(
							view.getSite().getShell(),
							"Error", 
							"An error occured trying to delete the Xtentis object: "+e.getLocalizedMessage()
					);
				}		
			}
			public void runWithEvent(Event event) {
				super.runWithEvent(event);
			}
	 }// Class DeleteDocumentAction
	 
	 
	 
	 
	 class NewDocumentAction extends Action{

			private ServerView view = null;
			private DocumentsSearchDialog searchDialog = null;
			
			private TreeObject xobject = null;
						
			public NewDocumentAction(ServerView view, DocumentsSearchDialog searchDialog) {
				super();
				this.view = view;
				this.searchDialog = searchDialog;
				
	            ISelection selection = view.getViewer().getSelection();
	            xobject = (TreeObject)((IStructuredSelection)selection).getFirstElement();
					            
				setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/add_obj.gif"));
				setText("New");
				setToolTipText("Create a new instance of an Xtentis Object");
			}
			
			public void run() {
				try {
					super.run();
					
					WSDocument clone = null;
		            ISelection selection = docsListViewer.getSelection();
		            if (selection != null)
		            	clone = (WSDocument) ((IStructuredSelection)selection).getFirstElement();
	           		InputDialog id = new InputDialog(
	           				searchDialog.getShell(),
	           				"New Xtentis Object Instance",
	           				"Enter a Name for the New Instance",
	           				clone==null? null :  "CopyOf"+clone.getName(),
	           				new IInputValidator() {
	           					public String isValid(String newText) {
	           						if ((newText==null) || "".equals(newText)) return "The Name cannot be empty";
	           						return null;
	           					};
	           				}
	           		);
	           		id.setBlockOnOpen(true);
	           		if (id.open() == Window.CANCEL) return;
	           		String key  = id.getValue();

	           		//Access to server and get port
					XtentisPort port = Util.getPort(
							new URL(xobject.getEndpointAddress()),
							xobject.getUsername(),
							xobject.getPassword()
					);
		              
					//check if already exists
	           		try {
	           			port.getDocument(new WSGetDocument(new WSDocumentPK(key)));
	           			MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Document "+key+" already exists");
	           			return;
	           		} catch (Exception e) {}
	           		
	           		//add
	           		WSDocument newDoc = new WSDocument();
	           		newDoc.setName(key);
	           		if (clone !=null) {
	           			newDoc.setDescription("[COPY] "+clone.getDescription());
	           			newDoc.setKeepInCache(clone.isKeepInCache());
	           			newDoc.setWsInboundAdaptorPK(clone.getWsInboundAdaptorPK());
	           			newDoc.setWsAutoAddDataClusterPKs(clone.getWsAutoAddDataClusterPKs());
	           			newDoc.setWsAutoUpdateDataClusterPKs(clone.getWsAutoUpdateDataClusterPKs());
	           			newDoc.setWsAutoRemoveDataClusterPKs(clone.getWsAutoRemoveDataClusterPKs());
	           			newDoc.setWsCacheDataClusterPK(clone.getWsCacheDataClusterPK());
	           		} else {
	           			newDoc.setKeepInCache(false);
	           		}
	           		
	           		//we cannot put the document here      		
		            TreeObject newXobject = new TreeObject(
		            		newDoc.getName(),
		            		xobject.getServerRoot(), 
		            		TreeObject.DOCUMENT, 
		            		new WSDocumentPK(newDoc.getName()),
		            		newDoc
		            );
		            
		            searchDialog.close();

		            view.getSite().getWorkbenchWindow().getActivePage().openEditor(
		                    new XObjectEditorInput(newXobject,newXobject.getDisplayName()),
		                    "com.amalto.workbench.editors.XObjectEditor"
		           	);
		       
				} catch (Exception e) {
					e.printStackTrace();
					MessageDialog.openError(
							searchDialog.getShell(),
							"Error", 
							"An error occured trying to create a new Document: "+e.getLocalizedMessage()
					);
				}		
			}
			public void runWithEvent(Event event) {
				super.runWithEvent(event);
			}
			


		}

}
