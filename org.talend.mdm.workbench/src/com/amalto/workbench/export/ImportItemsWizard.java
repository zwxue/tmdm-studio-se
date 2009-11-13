package com.amalto.workbench.export;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.progress.UIJob;
import org.exolab.castor.xml.Unmarshaller;
import org.talend.mdm.commmon.util.workbench.ZipToFile;

import com.amalto.workbench.actions.ServerRefreshAction;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSDataCluster;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSItem;
import com.amalto.workbench.webservices.WSMenu;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSPutDataCluster;
import com.amalto.workbench.webservices.WSPutDataModel;
import com.amalto.workbench.webservices.WSPutItem;
import com.amalto.workbench.webservices.WSPutMenu;
import com.amalto.workbench.webservices.WSPutRole;
import com.amalto.workbench.webservices.WSPutRoutingRule;
import com.amalto.workbench.webservices.WSPutStoredProcedure;
import com.amalto.workbench.webservices.WSPutSynchronizationPlan;
import com.amalto.workbench.webservices.WSPutTransformer;
import com.amalto.workbench.webservices.WSPutUniverse;
import com.amalto.workbench.webservices.WSPutView;
import com.amalto.workbench.webservices.WSRole;
import com.amalto.workbench.webservices.WSRolePK;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.WSStoredProcedure;
import com.amalto.workbench.webservices.WSStoredProcedurePK;
import com.amalto.workbench.webservices.WSSynchronizationPlan;
import com.amalto.workbench.webservices.WSSynchronizationPlanPK;
import com.amalto.workbench.webservices.WSTransformer;
import com.amalto.workbench.webservices.WSTransformerPK;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.WSView;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.FileSelectWidget;

public class ImportItemsWizard extends Wizard{
    private IStructuredSelection sel;
//	private RepositoryCheckTreeViewer treeViewer;
	private String importFolder;
	
	private FileSelectWidget folder;
	private Button zipBtn;
	private Button folderBtn;
	private FileSelectWidget  zip;
	private String zipfile;
	private ServerView view;
	private ArrayList<TreeObject> objList =new ArrayList<TreeObject>();
	private TreeParent serverRoot;
	
	public ImportItemsWizard(IStructuredSelection sel,ServerView view){
		this.sel=sel;
		this.view=view;
	}
	@Override
	public boolean performFinish() {
		if(zipBtn.getSelection()){
			zipfile=zip.getText().getText();
			importFolder=  System.getProperty("user.dir")+"/temp";
			try {
				ZipToFile.unZipFile(zipfile, importFolder);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(folderBtn.getSelection()){
			importFolder=folder.getText().getText();
		}
		
		serverRoot = ((TreeObject)sel.getFirstElement()).getServerRoot();
		Job job=new Job("Import Objects ..."){
			@Override
			public IStatus run(IProgressMonitor monitor) {	
				try{			
					
					FileReader reader= new FileReader(importFolder+"/exportitems.xml");
					doImport(reader,monitor);
					return Status.OK_STATUS;
				}catch(Exception e){
					e.printStackTrace();
					return Status.CANCEL_STATUS;
				}finally{
					new UIJob("Refreshing server"){

						@Override
						public IStatus runInUIThread(
								IProgressMonitor monitor) {
							new ServerRefreshAction(view,serverRoot).run();
							return Status.OK_STATUS;
						}
						
					}.schedule();
					if(zipfile!=null){
						ZipToFile.deleteDirectory(new File(importFolder));
					}
				}
			}			
		};
		job.setPriority(Job.INTERACTIVE);
		job.schedule();

		return true;
	}
	
	public void doImport(FileReader reader,IProgressMonitor monitor){
		Exports exports;
		try {
			exports = (Exports)Unmarshaller.unmarshal(
					Exports.class,reader);
		
		monitor.beginTask("Import Objects...", IProgressMonitor.UNKNOWN);
		TreeObject ojb=null;
		XtentisPort port= Util.getPort((TreeObject)sel.getFirstElement());
		
	
		for(ExportItem item: exports.getItems()){
			String[] subItems;
			switch(item.getType()){
			
			case 	TreeObject.DATA_CLUSTER:
				//datacluster
				monitor.subTask("Import Data Cluster...");
				subItems=item.getItems();
				for (String subItem : subItems) {
					reader=new FileReader(importFolder+"/"+subItem);
					WSDataCluster model=(WSDataCluster)Unmarshaller.unmarshal(WSDataCluster.class,reader);
					ojb=new TreeObject(subItem,serverRoot,item.getType(), new WSDataClusterPK(subItem),"");
					objList.add(ojb);
					port.putDataCluster(new WSPutDataCluster(model));
				}
				break;
				//dataclusters contents			
			case 	TreeObject.DATA_CLUSTER_CONTENTS:
				
				subItems=item.getItems();
				for (String subItem : subItems) {
					reader=new FileReader(importFolder+"/"+subItem);
					
					
					WSItem wsItem = (WSItem) Unmarshaller.unmarshal(
							WSItem.class, reader);
					if(wsItem.getDataModelName()==null){
//						port.synchronizationPutItemXML(new WSSynchronizationPutItemXML(null,wsItem.getContent()));
					}else{
						port.putItem(new WSPutItem(wsItem.getWsDataClusterPK(),wsItem.getContent(),new WSDataModelPK(wsItem.getDataModelName()),true));						
					}
					
					ojb=new TreeObject(subItem,serverRoot,item.getType(), new WSDataClusterPK(subItem),"");
					objList.add(ojb);
				}

					break;
			case 	 TreeObject.DATA_MODEL:
				monitor.subTask("Import Data Model...");
				subItems=item.getItems();
				for (String subItem : subItems) {
					reader=new FileReader(importFolder+"/"+subItem);
					WSDataModel model=(WSDataModel)Unmarshaller.unmarshal(WSDataModel.class,reader);
					ojb=new TreeObject(subItem,serverRoot,item.getType(), new WSDataModelPK(subItem),"");
					objList.add(ojb);
					port.putDataModel(new WSPutDataModel(model));
				}
				monitor.worked(1);
				break;
			case 	 TreeObject.MENU:
				monitor.subTask("Import Menu...");
				subItems=item.getItems();
				for (String subItem : subItems) {
					reader=new FileReader(importFolder+"/"+subItem);
					WSMenu memu=(WSMenu)Unmarshaller.unmarshal(WSMenu.class,reader);
					ojb=new TreeObject(subItem,serverRoot,item.getType(), new WSMenuPK(subItem),"");
					objList.add(ojb);
					port.putMenu(new WSPutMenu(memu));
				}
				monitor.worked(1);
				break;	
			case 	TreeObject.ROLE:
				monitor.subTask("Import Role...");
				subItems=item.getItems();
				for (String subItem : subItems) {
					reader=new FileReader(importFolder+"/"+subItem);
					WSRole role=(WSRole)Unmarshaller.unmarshal(WSRole.class,reader);
					ojb=new TreeObject(subItem,serverRoot,item.getType(), new WSRolePK(subItem),"");
					objList.add(ojb);
					port.putRole(new WSPutRole(role));
				}
				monitor.worked(1);
				break;	
			case 	TreeObject.ROUTING_RULE:
				monitor.subTask("Import Routing Rule...");
				subItems=item.getItems();
				for (String subItem : subItems) {
					reader=new FileReader(importFolder+"/"+subItem);
					WSRoutingRule routingRule=(WSRoutingRule)Unmarshaller.unmarshal(WSRoutingRule.class,reader);
					ojb=new TreeObject(subItem,serverRoot,item.getType(), new WSRoutingRulePK(subItem),"");
					objList.add(ojb);
					port.putRoutingRule(new WSPutRoutingRule(routingRule));
				}

				monitor.worked(1);
				break;	
			case 	TreeObject.STORED_PROCEDURE:
				monitor.subTask("Import Stored Procedure...");
				subItems=item.getItems();
				for (String subItem : subItems) {
					reader=new FileReader(importFolder+"/"+subItem);
					WSStoredProcedure model=(WSStoredProcedure)Unmarshaller.unmarshal(WSStoredProcedure.class,reader);
					ojb=new TreeObject(subItem,serverRoot,item.getType(), new WSStoredProcedurePK(subItem),"");
					objList.add(ojb);
					port.putStoredProcedure(new WSPutStoredProcedure(model));
				}

				monitor.worked(1);
				break;
			case   TreeObject.SYNCHRONIZATIONPLAN:
				monitor.subTask("Import Synchronization Plan...");
				subItems=item.getItems();
				for (String subItem : subItems) {
					reader=new FileReader(importFolder+"/"+subItem);
					WSSynchronizationPlan model=(WSSynchronizationPlan)Unmarshaller.unmarshal(WSSynchronizationPlan.class,reader);
					ojb=new TreeObject(subItem,serverRoot,item.getType(), new WSSynchronizationPlanPK(subItem),"");
					objList.add(ojb);
					port.putSynchronizationPlan(new WSPutSynchronizationPlan(model));
				}

				monitor.worked(1);
				break;
			case	TreeObject.TRANSFORMER:
				monitor.subTask("Import Transformer...");
				subItems=item.getItems();
				for (String subItem : subItems) {
					reader=new FileReader(importFolder+"/"+subItem);
					WSTransformer model=(WSTransformer)Unmarshaller.unmarshal(WSTransformer.class,reader);
					ojb=new TreeObject(subItem,serverRoot,item.getType(), new WSTransformerPK(subItem),"");
					objList.add(ojb);
					port.putTransformer(new WSPutTransformer(model));
				}

				monitor.worked(1);
				break;
			case  TreeObject.UNIVERSE:
				monitor.subTask("Import Universe...");
				subItems=item.getItems();
				for (String subItem : subItems) {
					reader=new FileReader(importFolder+"/"+subItem);
					WSUniverse model=(WSUniverse)Unmarshaller.unmarshal(WSUniverse.class,reader);
					ojb=new TreeObject(subItem,serverRoot,item.getType(), new WSUniversePK(subItem),"");
					objList.add(ojb);
					port.putUniverse(new WSPutUniverse(model));
				}

				monitor.worked(1);
				break;
			case TreeObject.VIEW:
				monitor.subTask("Import View...");
				subItems=item.getItems();
				for (String subItem : subItems) {
					reader=new FileReader(importFolder+"/"+subItem);
					WSView model=(WSView)Unmarshaller.unmarshal(WSView.class,reader);
					ojb=new TreeObject(subItem,serverRoot,item.getType(), new WSViewPK(subItem),"");
					objList.add(ojb);
					port.putView(new WSPutView(model));
				}

				monitor.worked(1);
				break;
			}
		}
		monitor.done();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void addPages() {
		addPage(new SelectItemsPage());
	}
	class PageListener implements Listener{
		SelectItemsPage page;
		PageListener(SelectItemsPage page){
			this.page=page;
		}
		public void handleEvent(Event event) {
			page.checkCompleted();
		}		
	};	
	public void checkCompleted(){
		
	}
	class SelectItemsPage extends WizardPage{


		protected SelectItemsPage() {
			super("SelectFileOrFolderPage");
		    setTitle("Select folder or file to import");

		    // Page isn't complete until an e-mail address has been added
		    setPageComplete(false);

		}
		public void checkCompleted(){
			if(folderBtn.getSelection() && folder.getText().getText().length()>0 && new File(folder.getText().getText()).exists()){
				setPageComplete(true);
			}	
			if(zipBtn.getSelection() && zip.getText().getText().length()>0 && new File(zip.getText().getText()).getParentFile().exists()){
				setPageComplete(true);
			}
			
		}
		public void createControl(Composite parent) {
			  Composite composite = new Composite(parent, SWT.BORDER);
			  composite.setLayout(new GridLayout(2,false));
			  folderBtn=new Button(composite,SWT.RADIO);
			  folderBtn.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
						false, 1, 1));
			  folderBtn.setText("Select root directory:");
			  folder=new FileSelectWidget(composite,"",new String[]{"*.*"}, "",false);
			  folder.getCmp().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
						false, 1, 1));			  
			  
			  folderBtn.addSelectionListener(new SelectionListener(){

				public void widgetDefaultSelected(SelectionEvent e) {
					
				}

				public void widgetSelected(SelectionEvent e) {					
					folder.setEnabled(folderBtn.getSelection());
					checkCompleted();
				}				  
			  });

			  zipBtn=new Button(composite,SWT.RADIO);
			  zipBtn.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
						false, 1, 1));			  
			  zipBtn.setText("Select archive file:");
			  zip=new FileSelectWidget(composite,"",new String[]{"*.zip"}, "",true);
			  zip.getCmp().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
						false, 1, 1));			  
			  zipBtn.addSelectionListener(new SelectionListener(){

					public void widgetDefaultSelected(SelectionEvent e) {
						
					}

					public void widgetSelected(SelectionEvent e) {					
						zip.setEnabled(zipBtn.getSelection());
						checkCompleted();
					}					  
				  });	
			  zip.getText().addListener(SWT.Modify, new PageListener(this));
			  zip.getButton().addListener(SWT.Selection, new PageListener(this));
			  folder.getText().addListener(SWT.Modify, new PageListener(this));
			  folder.getButton().addListener(SWT.Selection, new PageListener(this));
			  //create viewer
//			  treeViewer =new RepositoryCheckTreeViewer(sel);
//			  Composite itemcom=treeViewer.createItemList(composite);
//			  itemcom.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
//						false, 2,5));
//			  treeViewer.setItemText("Select items to import:");
			  
			  folder.setEnabled(folderBtn.getSelection());
			  zip.setEnabled(zipBtn.getSelection());
			  setControl(composite);
		}
		protected void refreshTree() {
			
		}
		
	}

}
