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
import com.amalto.workbench.webservices.WSDataClusterPKArray;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSDataModelPKArray;
import com.amalto.workbench.webservices.WSGetDataCluster;
import com.amalto.workbench.webservices.WSGetDataModel;
import com.amalto.workbench.webservices.WSGetItem;
import com.amalto.workbench.webservices.WSGetItemPKsByCriteria;
import com.amalto.workbench.webservices.WSGetMenu;
import com.amalto.workbench.webservices.WSGetMenuPKs;
import com.amalto.workbench.webservices.WSGetRole;
import com.amalto.workbench.webservices.WSGetRolePKs;
import com.amalto.workbench.webservices.WSGetRoutingRule;
import com.amalto.workbench.webservices.WSGetRoutingRulePKs;
import com.amalto.workbench.webservices.WSGetStoredProcedure;
import com.amalto.workbench.webservices.WSGetSynchronizationPlan;
import com.amalto.workbench.webservices.WSGetSynchronizationPlanPKs;
import com.amalto.workbench.webservices.WSGetTransformer;
import com.amalto.workbench.webservices.WSGetTransformerPKs;
import com.amalto.workbench.webservices.WSGetUniverse;
import com.amalto.workbench.webservices.WSGetUniversePKs;
import com.amalto.workbench.webservices.WSGetView;
import com.amalto.workbench.webservices.WSGetViewPKs;
import com.amalto.workbench.webservices.WSItem;
import com.amalto.workbench.webservices.WSItemPKsByCriteriaResponseResults;
import com.amalto.workbench.webservices.WSMenu;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSMenuPKArray;
import com.amalto.workbench.webservices.WSRegexDataClusterPKs;
import com.amalto.workbench.webservices.WSRegexDataModelPKs;
import com.amalto.workbench.webservices.WSRegexStoredProcedure;
import com.amalto.workbench.webservices.WSRole;
import com.amalto.workbench.webservices.WSRolePK;
import com.amalto.workbench.webservices.WSRolePKArray;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.WSRoutingRulePKArray;
import com.amalto.workbench.webservices.WSStoredProcedure;
import com.amalto.workbench.webservices.WSStoredProcedurePK;
import com.amalto.workbench.webservices.WSStoredProcedurePKArray;
import com.amalto.workbench.webservices.WSSynchronizationPlan;
import com.amalto.workbench.webservices.WSSynchronizationPlanPK;
import com.amalto.workbench.webservices.WSSynchronizationPlanPKArray;
import com.amalto.workbench.webservices.WSTransformer;
import com.amalto.workbench.webservices.WSTransformerPK;
import com.amalto.workbench.webservices.WSTransformerPKArray;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.WSUniversePKArray;
import com.amalto.workbench.webservices.WSView;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.WSViewPKArray;
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
							// TODO Auto-generated catch block
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
	
	public void doexport(TreeObject[] objs,IProgressMonitor monitor) throws Exception{
		
		if(objs.length==0) return;
		monitor.beginTask("Export items...", IProgressMonitor.UNKNOWN);
		List<ExportItem> exports=new ArrayList<ExportItem>();
		XtentisPort port= Util.getPort(objs[0]);
		for(TreeObject obj: objs){
			if(obj.getType() == TreeObject.DATA_CLUSTER){
				monitor.subTask("Export Data Cluster...");
				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.DATACLUSTER_);
				exportItem.setType(TreeObject.DATA_CLUSTER);
				List<String> items=new ArrayList<String>();
				//dataclusters
				WSDataClusterPKArray array=port.getDataClusterPKs(new WSRegexDataClusterPKs(""));
				for(WSDataClusterPK pk:array.getWsDataClusterPKs()){					
					WSDataCluster cluster=port.getDataCluster(new WSGetDataCluster(pk));
		        	//Marshal
		    		StringWriter sw = new StringWriter();
		    		Marshaller.marshal(cluster, sw);
		    		writeString(sw.toString(), TreeObject.DATACLUSTER_+"/"+cluster.getName());
		    		items.add(TreeObject.DATACLUSTER_+"/"+cluster.getName());
				}
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
				//datacluster contents
				for(WSDataClusterPK pk:array.getWsDataClusterPKs()){
					monitor.subTask("Export Data Cluster "+ pk.getPk()+" ...");
					ExportItem exportItem1=new ExportItem();
					exportItem1.setName(TreeObject.DATACLUSTER_);
					exportItem1.setType(TreeObject.DATA_CLUSTER);
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
		            	StringWriter sw = new StringWriter();
		            	Marshaller.marshal(wsitem, sw);

		            	String uniqueId=pk.getPk()+"."+wsitem.getConceptName()+".";
		            	for(String id: wsitem.getIds()){
		            		uniqueId=uniqueId+"."+id;
		            	}		            	
		            	writeString(sw.toString(), TreeObject.DATACLUSTER_COTENTS+"/"+pk.getPk()+"/"+uniqueId);
		            	items1.add(TreeObject.DATACLUSTER_+"/"+pk.getPk()+"/"+uniqueId);
		            }
					exportItem1.setItems(items1.toArray(new String[items1.size()]));
					exports.add(exportItem1);
					monitor.worked(1);
				}
			}
			if(obj.getType() == TreeObject.DATA_MODEL){
				monitor.subTask("Export Data Model...");
				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.DATAMODEL_);
				exportItem.setType(TreeObject.DATA_MODEL);
				List<String> items=new ArrayList<String>();
				//datamodels
				WSDataModelPKArray array=port.getDataModelPKs(new WSRegexDataModelPKs(""));
				for(WSDataModelPK pk:array.getWsDataModelPKs()){					
					WSDataModel Model=port.getDataModel(new WSGetDataModel(pk));
		        	//Marshal
		    		StringWriter sw = new StringWriter();
		    		Marshaller.marshal(Model, sw);
		    		writeString(sw.toString(), TreeObject.DATAMODEL_+"/"+Model.getName());
		    		items.add(TreeObject.DATAMODEL_+"/"+Model.getName());
				}
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
			}
			if(obj.getType() == TreeObject.MENU){
				monitor.subTask("Export Menu...");
				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.MENU_);
				exportItem.setType(TreeObject.MENU);
				List<String> items=new ArrayList<String>();
				//menu
				WSMenuPKArray array=port.getMenuPKs(new WSGetMenuPKs(""));
				for(WSMenuPK pk:array.getWsMenuPK()){					
					WSMenu Model=port.getMenu(new WSGetMenu(pk));
		        	//Marshal
		    		StringWriter sw = new StringWriter();
		    		Marshaller.marshal(Model, sw);
		    		writeString(sw.toString(), TreeObject.MENU_+"/"+Model.getName());
		    		items.add(TreeObject.MENU_+"/"+Model.getName());
				}
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
			}	
			if(obj.getType() == TreeObject.ROLE){
				monitor.subTask("Export Role...");
				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.ROLE_);
				exportItem.setType(TreeObject.ROLE);
				List<String> items=new ArrayList<String>();
				//menu
				WSRolePKArray array=port.getRolePKs(new WSGetRolePKs(""));
				for(WSRolePK pk:array.getWsRolePK()){					
					WSRole role=port.getRole(new WSGetRole(pk));
		        	//Marshal
		    		StringWriter sw = new StringWriter();
		    		Marshaller.marshal(role, sw);
		    		writeString(sw.toString(), TreeObject.ROLE_+"/"+role.getName());
		    		items.add(TreeObject.ROLE_+"/"+role.getName());
				}
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
			}	
			if(obj.getType() == TreeObject.ROUTING_RULE){
				monitor.subTask("Export Routing Rule...");
				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.ROUTINGRULE_);
				exportItem.setType(TreeObject.ROUTING_RULE);
				List<String> items=new ArrayList<String>();
				//menu
				WSRoutingRulePKArray array=port.getRoutingRulePKs(new WSGetRoutingRulePKs(""));
				for(WSRoutingRulePK pk:array.getWsRoutingRulePKs()){					
					WSRoutingRule RoutingRule=port.getRoutingRule(new WSGetRoutingRule(pk));
		        	//Marshal
		    		StringWriter sw = new StringWriter();
		    		Marshaller.marshal(RoutingRule, sw);
		    		writeString(sw.toString(), TreeObject.ROUTINGRULE_+"/"+RoutingRule.getName());
		    		items.add(TreeObject.ROUTINGRULE_+"/"+RoutingRule.getName());
				}
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
			}	
			if(obj.getType() == TreeObject.STORED_PROCEDURE){
				monitor.subTask("Export Stored Procedure...");
				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.STOREDPROCEDURE_);
				exportItem.setType(TreeObject.STORED_PROCEDURE);
				List<String> items=new ArrayList<String>();
				//menu
				WSStoredProcedurePKArray array=port.getStoredProcedurePKs(new WSRegexStoredProcedure(""));
				for(WSStoredProcedurePK pk:array.getWsStoredProcedurePK()){					
					WSStoredProcedure StoredProcedure=port.getStoredProcedure(new WSGetStoredProcedure(pk));
		        	//Marshal
		    		StringWriter sw = new StringWriter();
		    		Marshaller.marshal(StoredProcedure, sw);
		    		writeString(sw.toString(), TreeObject.STOREDPROCEDURE_+"/"+StoredProcedure.getName());
		    		items.add(TreeObject.STOREDPROCEDURE_+"/"+StoredProcedure.getName());
				}
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
			}
			if(obj.getType() == TreeObject.SYNCHRONIZATIONPLAN){
				monitor.subTask("Export Synchronization Plan...");
				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.SYNCHRONIZATIONPLAN_);
				exportItem.setType(TreeObject.SYNCHRONIZATIONPLAN);
				List<String> items=new ArrayList<String>();
				//menu
				WSSynchronizationPlanPKArray array=port.getSynchronizationPlanPKs(new WSGetSynchronizationPlanPKs(""));
				for(WSSynchronizationPlanPK pk:array.getWsSynchronizationPlanPK()){					
					WSSynchronizationPlan SynchronizationPlan=port.getSynchronizationPlan(new WSGetSynchronizationPlan(pk));
		        	//Marshal
		    		StringWriter sw = new StringWriter();
		    		Marshaller.marshal(SynchronizationPlan, sw);
		    		writeString(sw.toString(), TreeObject.SYNCHRONIZATIONPLAN_+"/"+SynchronizationPlan.getName());
		    		items.add(TreeObject.SYNCHRONIZATIONPLAN_+"/"+SynchronizationPlan.getName());
				}
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
			}
			if(obj.getType() == TreeObject.TRANSFORMER){
				monitor.subTask("Export Transformer...");
				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.TRANSFORMER_);
				exportItem.setType(TreeObject.TRANSFORMER);
				List<String> items=new ArrayList<String>();
				//menu
				WSTransformerPKArray array=port.getTransformerPKs(new WSGetTransformerPKs(""));
				for(WSTransformerPK pk:array.getWsTransformerPK()){					
					WSTransformer Transformer=port.getTransformer(new WSGetTransformer(pk));
		        	//Marshal
		    		StringWriter sw = new StringWriter();
		    		Marshaller.marshal(Transformer, sw);
		    		writeString(sw.toString(), TreeObject.TRANSFORMER_+"/"+Transformer.getName());
		    		items.add(TreeObject.TRANSFORMER_+"/"+Transformer.getName());
				}
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
			}
			if(obj.getType() == TreeObject.UNIVERSE){
				monitor.subTask("Export Universe...");
				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.UNIVERSE_);
				exportItem.setType(TreeObject.UNIVERSE);
				List<String> items=new ArrayList<String>();
				//menu
				WSUniversePKArray array=port.getUniversePKs(new WSGetUniversePKs(""));
				for(WSUniversePK pk:array.getWsUniversePK()){					
					WSUniverse Universe=port.getUniverse(new WSGetUniverse(pk));
		        	//Marshal
		    		StringWriter sw = new StringWriter();
		    		Marshaller.marshal(Universe, sw);
		    		writeString(sw.toString(), TreeObject.UNIVERSE_+"/"+Universe.getName());
		    		items.add(TreeObject.UNIVERSE_+"/"+Universe.getName());
				}
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
			}	
			if(obj.getType() == TreeObject.VIEW){
				monitor.subTask("Export View...");
				ExportItem exportItem=new ExportItem();
				exportItem.setName(TreeObject.VIEW_);
				exportItem.setType(TreeObject.VIEW);
				List<String> items=new ArrayList<String>();
				//menu
				WSViewPKArray array=port.getViewPKs(new WSGetViewPKs(""));
				for(WSViewPK pk:array.getWsViewPK()){					
					WSView View=port.getView(new WSGetView(pk));
		        	//Marshal
		    		StringWriter sw = new StringWriter();
		    		Marshaller.marshal(View, sw);
		    		writeString(sw.toString(), TreeObject.VIEW_+"/"+View.getName());
		    		items.add(TreeObject.VIEW_+"/"+View.getName());
				}
				exportItem.setItems(items.toArray(new String[items.size()]));
				exports.add(exportItem);
				monitor.worked(1);
			}			
		}
		// store the content xml
		StringWriter sw = new StringWriter();
		Marshaller.marshal(exports, sw);
		writeString(sw.toString(), "exportitems.xml");
		monitor.done();
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
