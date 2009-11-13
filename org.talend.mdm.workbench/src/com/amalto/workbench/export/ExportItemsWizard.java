package com.amalto.workbench.export;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

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
import org.exolab.castor.xml.Marshaller;
import org.talend.mdm.commmon.util.workbench.ZipToFile;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSDataCluster;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSGetDataCluster;
import com.amalto.workbench.webservices.WSGetDataModel;
import com.amalto.workbench.webservices.WSGetItem;
import com.amalto.workbench.webservices.WSGetItemPKsByCriteria;
import com.amalto.workbench.webservices.WSGetMenu;
import com.amalto.workbench.webservices.WSGetRole;
import com.amalto.workbench.webservices.WSGetRoutingRule;
import com.amalto.workbench.webservices.WSGetStoredProcedure;
import com.amalto.workbench.webservices.WSGetSynchronizationPlan;
import com.amalto.workbench.webservices.WSGetTransformer;
import com.amalto.workbench.webservices.WSGetUniverse;
import com.amalto.workbench.webservices.WSGetView;
import com.amalto.workbench.webservices.WSItem;
import com.amalto.workbench.webservices.WSItemPKsByCriteriaResponseResults;
import com.amalto.workbench.webservices.WSMenu;
import com.amalto.workbench.webservices.WSMenuPK;
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
import com.amalto.workbench.webservices.WSTransformerV2PK;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.WSView;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.FileSelectWidget;
import com.amalto.workbench.widgets.RepositoryCheckTreeViewer;

public class ExportItemsWizard extends Wizard {
    private IStructuredSelection sel;
	private RepositoryCheckTreeViewer treeViewer;
	private String exportFolder;
	
	private FileSelectWidget folder;
	private Button zipBtn;
	private Button folderBtn;
	private FileSelectWidget  zip;
	private String zipfile;
	
	public ExportItemsWizard(IStructuredSelection sel){
		this.sel=sel;
	}
	@Override
	public boolean performFinish() {
		
		if(zipBtn.getSelection()){
			exportFolder= new File(System.getProperty("user.dir")+"/temp").getAbsolutePath();
			zipfile=zip.getText().getText();
		}
		if(folderBtn.getSelection()){
			exportFolder=folder.getText().getText();
		}
		final TreeObject[] objs=treeViewer.getCheckNodes();
		Job job=new Job("Export Items ..."){
			@Override
			public IStatus run(IProgressMonitor monitor) {	
				try{					
					doexport(objs,monitor);
					return Status.OK_STATUS;
				}catch(Exception e){
					e.printStackTrace();
					return Status.CANCEL_STATUS;
				}finally{
					if(zipfile!=null){						
						try {
							ZipToFile.zipFile(exportFolder, zipfile);
						} catch (Exception e) {
							e.printStackTrace();
						}
						ZipToFile.deleteDirectory(new File(exportFolder));
					}
				}
			}			
		};
		job.setPriority(Job.INTERACTIVE);
		job.schedule();
		return true;
	}
	
	public void doexport(TreeObject[] objs,IProgressMonitor monitor) {
		
		if(objs.length==0) return;
		monitor.beginTask("Export items...", IProgressMonitor.UNKNOWN);
		Exports eps=new Exports();
		List<ExportItem> exports=new ArrayList<ExportItem>();
		XtentisPort port;
		try {
			port = Util.getPort(objs[0]);
		for(TreeObject obj: objs){
			
			ExportItem exportItem=new ExportItem();
			StringWriter sw;
			ArrayList<String> items;
			switch(obj.getType()){
//			if(obj.getType() == TreeObject.DATA_CLUSTER){
			case TreeObject.DATA_CLUSTER:
				monitor.subTask("Export Data Cluster...");
				
				exportItem.setType(TreeObject.DATA_CLUSTER);
				items=new ArrayList<String>();
				//dataclusters
//				WSDataClusterPKArray array=port.getDataClusterPKs(new WSRegexDataClusterPKs(""));
//				for(WSDataClusterPK pk:array.getWsDataClusterPKs()){					
				WSDataClusterPK pk =(WSDataClusterPK)obj.getWsKey();
				exportItem.setName(pk.getPk());
					WSDataCluster cluster=port.getDataCluster(new WSGetDataCluster(pk));
		        	//Marshal
		    		 sw = new StringWriter();
		    		Marshaller.marshal(cluster, sw);
		    		writeString(sw.toString(), TreeObject.DATACLUSTER_+"/"+cluster.getName());
		    		items.add(TreeObject.DATACLUSTER_+"/"+cluster.getName());
//				}
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
				//datacluster contents
//				for(WSDataClusterPK pk:array.getWsDataClusterPKs()){
					monitor.subTask("Export Data Cluster "+ pk.getPk()+" ...");
					ExportItem exportItem1=new ExportItem();
					exportItem1.setName(pk.getPk());
					exportItem1.setType(TreeObject.DATA_CLUSTER_CONTENTS);
					List<String> items1=new ArrayList<String>();
		            WSItemPKsByCriteriaResponseResults[] results =
			            port.getItemPKsByCriteria(new WSGetItemPKsByCriteria(
			            		pk,
			            		null,
			            		null,
			            		null,
			            		(long)-1,
			            		(long)-1,
			            		0,
			            		Integer.MAX_VALUE
			            	)
			            ).getResults();
		            if(results==null) continue;
		            for(WSItemPKsByCriteriaResponseResults item: results ){
		            	WSItem wsitem=port.getItem(new WSGetItem(item.getWsItemPK()));
		            	
		            	//Marshal
		            	StringWriter sw1 = new StringWriter();
		            	Marshaller.marshal(wsitem, sw1);

		            	String uniqueId=pk.getPk()+"."+wsitem.getConceptName()+".";
		            	for(String id: wsitem.getIds()){
		            		uniqueId=uniqueId+"."+id;
		            	}		            	
		            	writeString(sw1.toString(), TreeObject.DATACLUSTER_COTENTS+"/"+pk.getPk()+"/"+uniqueId);
		            	items1.add(TreeObject.DATACLUSTER_COTENTS+"/"+pk.getPk()+"/"+uniqueId);
		            }
					exportItem1.setItems(items1.toArray(new String[items1.size()]));
					exports.add(exportItem1);
					monitor.worked(1);
					break;
//			}
			case TreeObject.DATA_MODEL:
				monitor.subTask("Export Data Model...");
//				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.DATAMODEL_);
				exportItem.setType(TreeObject.DATA_MODEL);
				 items=new ArrayList<String>();
				//datamodels
					
				WSDataModel model=port.getDataModel(new WSGetDataModel((WSDataModelPK)obj.getWsKey()));
	        	 sw = new StringWriter();
	    		Marshaller.marshal(model, sw);
	    		writeString(sw.toString(), TreeObject.DATAMODEL_+"/"+model.getName());
	    		items.add(TreeObject.DATAMODEL_+"/"+model.getName());
				
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
				break;
			case  	TreeObject.MENU:
				monitor.subTask("Export Menu...");
//				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.MENU_);
				exportItem.setType(TreeObject.MENU);
				items=new ArrayList<String>();
				//menu
					WSMenu menu=port.getMenu(new WSGetMenu((WSMenuPK)obj.getWsKey()));
		        	//Marshal
		    		sw = new StringWriter();
		    		Marshaller.marshal(menu, sw);
		    		writeString(sw.toString(), TreeObject.MENU_+"/"+menu.getName());
		    		items.add(TreeObject.MENU_+"/"+menu.getName());

		    	exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
				break;
			case 	TreeObject.ROLE:
				monitor.subTask("Export Role...");
//				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.ROLE_);
				exportItem.setType(TreeObject.ROLE);
				 items=new ArrayList<String>();
		
				//role
					WSRole role=port.getRole(new WSGetRole((WSRolePK)obj.getWsKey()));
		        	//Marshal
		    		sw = new StringWriter();
		    		Marshaller.marshal(role, sw);
		    		writeString(sw.toString(), TreeObject.ROLE_+"/"+role.getName());
		    		items.add(TreeObject.ROLE_+"/"+role.getName());
			
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
				break;
			case	TreeObject.ROUTING_RULE:
				monitor.subTask("Export Routing Rule...");
//				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.ROUTINGRULE_);
				exportItem.setType(TreeObject.ROUTING_RULE);
				items=new ArrayList<String>();
				//routing rule
					WSRoutingRule RoutingRule=port.getRoutingRule(new WSGetRoutingRule((WSRoutingRulePK)obj.getWsKey()));
		        	//Marshal
		    		sw = new StringWriter();
		    		Marshaller.marshal(RoutingRule, sw);
		    		writeString(sw.toString(), TreeObject.ROUTINGRULE_+"/"+RoutingRule.getName());
		    		items.add(TreeObject.ROUTINGRULE_+"/"+RoutingRule.getName());
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
				break;
			case	TreeObject.STORED_PROCEDURE:
				monitor.subTask("Export Stored Procedure...");
				exportItem=new ExportItem();
				exportItem.setName(TreeObject.STOREDPROCEDURE_);
				exportItem.setType(TreeObject.STORED_PROCEDURE);
				items=new ArrayList<String>();
				//stored procedure
					WSStoredProcedure StoredProcedure=port.getStoredProcedure(new WSGetStoredProcedure((WSStoredProcedurePK)obj.getWsKey()));
		        	//Marshal
					sw = new StringWriter();
		    		Marshaller.marshal(StoredProcedure, sw);
		    		writeString(sw.toString(), TreeObject.STOREDPROCEDURE_+"/"+StoredProcedure.getName());
		    		items.add(TreeObject.STOREDPROCEDURE_+"/"+StoredProcedure.getName());

		    	exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
				break;
			case TreeObject.SYNCHRONIZATIONPLAN:
				monitor.subTask("Export Synchronization Plan...");
				exportItem=new ExportItem();
				exportItem.setName(TreeObject.SYNCHRONIZATIONPLAN_);
				exportItem.setType(TreeObject.SYNCHRONIZATIONPLAN);
				items=new ArrayList<String>();
				//Synchronizationplan
					WSSynchronizationPlan SynchronizationPlan=port.getSynchronizationPlan(new WSGetSynchronizationPlan((WSSynchronizationPlanPK)obj.getWsKey()));
		        	//Marshal
		    		sw = new StringWriter();
		    		Marshaller.marshal(SynchronizationPlan, sw);
		    		writeString(sw.toString(), TreeObject.SYNCHRONIZATIONPLAN_+"/"+SynchronizationPlan.getName());
		    		items.add(TreeObject.SYNCHRONIZATIONPLAN_+"/"+SynchronizationPlan.getName());
				
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
				break;
			case TreeObject.TRANSFORMER:
				monitor.subTask("Export Transformer...");
				exportItem=new ExportItem();
				exportItem.setName(TreeObject.TRANSFORMER_);
				exportItem.setType(TreeObject.TRANSFORMER);
				items=new ArrayList<String>();
				//transformer
				//TODO:check the pk
				WSTransformer transformer=port.getTransformer(new WSGetTransformer(new WSTransformerPK(((WSTransformerV2PK)obj.getWsKey()).getPk())));
		        	//Marshal
		    		sw = new StringWriter();
		    		Marshaller.marshal(transformer, sw);
		    		writeString(sw.toString(), TreeObject.TRANSFORMER_+"/"+transformer.getName());
		    		items.add(TreeObject.TRANSFORMER_+"/"+transformer.getName());
				
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
				break;
			case TreeObject.UNIVERSE:
				monitor.subTask("Export Universe...");
				exportItem=new ExportItem();
				exportItem.setName(TreeObject.UNIVERSE_);
				exportItem.setType(TreeObject.UNIVERSE);
				items=new ArrayList<String>();
				//universe
					WSUniverse universe=port.getUniverse(new WSGetUniverse((WSUniversePK)obj.getWsKey()));
		        	//Marshal
		    		sw = new StringWriter();
		    		Marshaller.marshal(universe, sw);
		    		writeString(sw.toString(), TreeObject.UNIVERSE_+"/"+universe.getName());
		    		items.add(TreeObject.UNIVERSE_+"/"+universe.getName());
				
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
				break;
			case TreeObject.VIEW:
				monitor.subTask("Export View...");
				exportItem=new ExportItem();
				exportItem.setName(TreeObject.VIEW_);
				exportItem.setType(TreeObject.VIEW);
				items=new ArrayList<String>();
				//view
					WSView View=port.getView(new WSGetView((WSViewPK)obj.getWsKey()));
		        	//Marshal
		    		sw = new StringWriter();
		    		Marshaller.marshal(View, sw);
		    		writeString(sw.toString(), TreeObject.VIEW_+"/"+View.getName());
		    		items.add(TreeObject.VIEW_+"/"+View.getName());
				
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
			}
		}
		// store the content xml
		eps.setItems(exports.toArray(new ExportItem[exports.size()]));
		StringWriter sw = new StringWriter();
		Marshaller.marshal(eps, sw);
		writeString(sw.toString(), "exportitems.xml");
		monitor.done();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private  void writeString(String outputStr,String filename)throws Exception{
		File f=new File(exportFolder+"/"+filename);
		if(!f.getParentFile().getParentFile().exists()){
			f.getParentFile().getParentFile().mkdir();
		}		
		if(!f.getParentFile().exists()){
			f.getParentFile().mkdir();
		}
		FileWriter fo=new FileWriter(exportFolder+"/"+filename);
		fo.write(outputStr);
		fo.flush();
		fo.close();
	}
	
	@Override
	public void addPages() {
		// TODO Auto-generated method stub
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
			super("SelectItemsPage");
		    setTitle("Select items to export");
		    //setDescription("Please select items to export");

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
			  treeViewer =new RepositoryCheckTreeViewer(sel);
			  Composite itemcom=treeViewer.createItemList(composite);
			  itemcom.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
						false, 2,5));
			  treeViewer.setItemText("Select items to export:");
			  
			  folder.setEnabled(folderBtn.getSelection());
			  zip.setEnabled(zipBtn.getSelection());
			  setControl(composite);
		}
		
	}

}
