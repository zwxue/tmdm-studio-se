package com.amalto.workbench.editors;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.exolab.castor.xml.Marshaller;

import com.amalto.workbench.models.KeyValue;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.FontUtils;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSGetAlgorithmsForSynchronizationPlans;
import com.amalto.workbench.webservices.WSGetObjectsForSynchronizationPlans;
import com.amalto.workbench.webservices.WSSynchronizationPlan;
import com.amalto.workbench.webservices.WSSynchronizationPlanItemsSynchronizations;
import com.amalto.workbench.webservices.WSSynchronizationPlanXtentisObjectsSynchronizations;
import com.amalto.workbench.webservices.WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations;
import com.amalto.workbench.webservices.WSUniverseItemsRevisionIDs;
import com.amalto.workbench.webservices.WSUniverseXtentisObjectsRevisionIDs;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.ComplexTableViewer;
import com.amalto.workbench.widgets.LabelText;

public class SynchronizationMainPage extends AMainPageV2{

	protected DropTarget windowTarget;

	protected TableViewer instancesViewer;

	protected FormToolkit toolkit;
	
	private String[] xtentisObjectColumns=new String[]{"Instance Pattern","Source Revision ID","Target Revision ID","Algorithm"};
	private String[] itemsColumns=new String[]{"Concept Pattern","IDs Pattern","Source Revision ID","Target Revision ID","Algorithm"};
		
	protected SyncronizationPlan syncPlan;

	private LabelText passwordText;

	private LabelText usernameText;

	private LabelText urlText;

	private LabelText descriptionText;
	
	private Map<String,ComplexTableViewer> xtentisViewers=new HashMap<String, ComplexTableViewer>();
	public SynchronizationMainPage(FormEditor editor) {
        super(
        		editor,
        		SynchronizationMainPage.class.getName(),
        		"SynchronizationPlan "+((XObjectEditorInput)editor.getEditorInput()).getName()
        );        
	}

	@Override
	protected void createCharacteristicsContent(FormToolkit toolkit,
			Composite charComposite) {
	try {
		if(syncPlan==null)syncPlan=new SyncronizationPlan();
		this.toolkit=toolkit;
        //basic setting
		descriptionText =new LabelText(toolkit,charComposite,"Description");        
		descriptionText.getText().addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		if (refreshing) return;
        		syncPlan.description=descriptionText.getText().getText();
        		markDirty();
        	}
        });
		urlText =new LabelText(toolkit,charComposite,"Server URL");        
		urlText.getText().addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		if (refreshing) return;
        		syncPlan.url=urlText.getText().getText();
        		markDirty();
        	}
        });
  
		usernameText =new LabelText(toolkit,charComposite,"Username");        
		usernameText.getText().addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		if (refreshing) return;
        		syncPlan.username=usernameText.getText().getText();
        		markDirty();
        	}
        });
		passwordText =new LabelText(toolkit,charComposite,"Password");        
		passwordText.getText().addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		if (refreshing) return;
        		syncPlan.password=passwordText.getText().getText();
        		markDirty();
        	}
        });		
		
        //make the Page window a DropTarget - we need to dispose it
        windowTarget = new DropTarget(this.getPartControl(), DND.DROP_MOVE);
        windowTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
        windowTarget.addDropListener(new DCDropTargetListener());
        
        //Xtentis Objects  Section
        Composite objecstGroup = this.getNewSectionComposite("Xtentis Objects SynchronizationPlan");
        objecstGroup.setLayout(new GridLayout(1,true));
        
        Composite objectsComposite = toolkit.createComposite(objecstGroup, SWT.BORDER);
        objectsComposite.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
        );
        objectsComposite.setLayout(new GridLayout(1,false));
        String[] alogrithomStrings= getPort().getAlgorithmsForSynchronizationPlans(new WSGetAlgorithmsForSynchronizationPlans(new String[]{".*"})).getStrings();
        String[] xtentisObjcts=getPort().getObjectsForSynchronizationPlans(new WSGetObjectsForSynchronizationPlans(new String[]{".*"})).getStrings();//IConstants.XTENTISOBJECTS;
        for(String object: xtentisObjcts){
            Composite composite =toolkit.createComposite(objectsComposite,SWT.BORDER);
            composite.setLayoutData(
                    new GridData(SWT.FILL,SWT.RIGHT,true,true,1,1)
            );       	
            composite.setLayout(new GridLayout(2,false));
            
            Label label = toolkit.createLabel(composite, object, SWT.NULL);
            GridData data =new GridData(SWT.FILL,SWT.RIGHT,false,true,1,1);
            data.widthHint=120;
            label.setLayoutData(data);
            label.setFont(FontUtils.getBoldFont(label.getFont()));
            
            ComplexTableViewer objectViewer=new ComplexTableViewer(Arrays.asList(xtentisObjectColumns),toolkit,composite);
            objectViewer.setMainPage(this);
            objectViewer.setLastCombo(true);
            objectViewer.setComboStrings(alogrithomStrings);
            objectViewer.create();
            List<Line> objList=syncPlan.getXtentisObjectsList().get(object);
            if(objList==null){
            	objList=new ArrayList<Line>();
            	syncPlan.getXtentisObjectsList().put(object, objList);
            }
            objectViewer.getViewer().setInput(objList);
            ((GridData)objectViewer.getViewer().getTable().getLayoutData()).heightHint=60;
            
            xtentisViewers.put(object, objectViewer);
        }
        //Items Section          
        Composite itemsGroup = this.getNewSectionComposite("Items SynchronizationPlan");
        itemsGroup.setLayout(new GridLayout(1,true));
        Composite itemsComposite = toolkit.createComposite(itemsGroup, SWT.BORDER);
        itemsComposite.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
        );       
        itemsComposite.setLayout(new GridLayout(1,true));
        
        ComplexTableViewer itemsViewer=new ComplexTableViewer(Arrays.asList(itemsColumns),toolkit,itemsComposite);
        itemsViewer.setMainPage(this);
        itemsViewer.setLastCombo(true);
        itemsViewer.setComboStrings(alogrithomStrings);
        itemsViewer.create();
        instancesViewer=itemsViewer.getViewer();
        instancesViewer.setInput(syncPlan.getItemsList());
                              
        refreshData();

    } catch (Exception e) {
        e.printStackTrace();
    }
		
	}

	@Override
	protected void createActions() {
		// TODO Auto-generated method stub
		
	}

	protected void refreshData() {
		try {

			if (this.comitting) return;
			
			this.refreshing = true;
			
			WSSynchronizationPlan ws = (WSSynchronizationPlan) (getXObject().getWsObject());    	
			
			syncPlan = new SyncronizationPlan();	
			//basic
			syncPlan.setDescription(ws.getDescription()==null ? "" : ws.getDescription());
			syncPlan.setUrl(ws.getRemoteSystemURL());
			syncPlan.setUsername(ws.getRemoteSystemUsername());
			syncPlan.setPassword(ws.getRemoteSystemPassword());
			
			//xtentisObjects
			Map<String, List<Line>> xtentisMap=new HashMap<String, List<Line>>();
			for(WSSynchronizationPlanXtentisObjectsSynchronizations xtentisSync:ws.getXtentisObjectsSynchronizations()){				
				List<Line> lines=new ArrayList<Line>();
				for(WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations objSync:xtentisSync.getSynchronizations()){
					Line line=new Line(xtentisObjectColumns,new String[]{objSync.getInstancePattern(),objSync.getSourceRevisionID(),objSync.getTargetRevisionID(),objSync.getAlgorithm()});
					lines.add(line);
				}
				xtentisMap.put(xtentisSync.getXtentisObjectName(), lines);
				//refresh the xtentisobject tableviewer
				ComplexTableViewer viewer=xtentisViewers.get(xtentisSync.getXtentisObjectName());
				if(viewer!=null){
					viewer.getViewer().setInput(lines);
				}
			}
			syncPlan.setXtentisObjectsList(xtentisMap);
			//Items
			List<Line> lines=new ArrayList<Line>();
			for(WSSynchronizationPlanItemsSynchronizations itemSync:ws.getItemsSynchronizations()){
				Line line=new Line(itemsColumns,new String[]{itemSync.getConceptPattern(),itemSync.getIdsPattern(),itemSync.getSourceRevisionID(),itemSync.getTargetRevisionID(),itemSync.getAlgorithm()});
				lines.add(line);
			}
	    	syncPlan.setItemsList(lines);
	    	
			//Now fill in the values on the page
            descriptionText.getText().setText(syncPlan.getDescription()==null ? "" : syncPlan.getDescription());
            urlText.getText().setText(syncPlan.getUrl()==null?"":syncPlan.getUrl());
            usernameText.getText().setText(syncPlan.getUsername()==null?"":syncPlan.getUsername());
            passwordText.getText().setText(syncPlan.getPassword()==null?"":syncPlan.getPassword());
            //refresh the item tableviewer
            instancesViewer.setInput(syncPlan.getItemsList());
            this.refreshing = false;

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error refreshing the page", "Error refreshing the page: "+e.getLocalizedMessage());
		}    	
	}
	
	protected void commit() {
		try {
			if (this.refreshing) return;
			
			this.comitting = true;
			//basic
			WSSynchronizationPlan ws = (WSSynchronizationPlan) (getXObject().getWsObject());    	
			ws.setDescription(syncPlan.getDescription());
			ws.setRemoteSystemURL(syncPlan.getUrl());
			ws.setRemoteSystemUsername(syncPlan.getUsername());
			ws.setRemoteSystemPassword(syncPlan.getPassword());
			//xtentisobjects
			Map<String, List<Line>> xtentisobjects =syncPlan.getXtentisObjectsList();
			WSSynchronizationPlanXtentisObjectsSynchronizations[] xtentisObjSyncs=new WSSynchronizationPlanXtentisObjectsSynchronizations[xtentisobjects.size()];
			int j=0;
			for(Map.Entry<String, List<Line>> entry: xtentisobjects.entrySet()){
				WSSynchronizationPlanXtentisObjectsSynchronizations obj=new WSSynchronizationPlanXtentisObjectsSynchronizations();
				obj.setXtentisObjectName(entry.getKey());
				
				WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations[] syncs=new WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations[entry.getValue().size()];				
				int i=0; 
				for(Line line: entry.getValue()){
					syncs[i]=new WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations();
					syncs[i].setInstancePattern(line.keyValues.get(0).value);
					syncs[i].setSourceRevisionID(line.keyValues.get(1).value);
					syncs[i].setTargetRevisionID(line.keyValues.get(2).value);
					syncs[i].setAlgorithm(line.keyValues.get(3).value);
					i++;
				}
				obj.setSynchronizations(syncs);
				xtentisObjSyncs[j]=obj;
				j++;
			}
			ws.setXtentisObjectsSynchronizations(xtentisObjSyncs);
			//items
			List<Line> items=syncPlan.getItemsList();
			WSSynchronizationPlanItemsSynchronizations[] itemSyncs=new WSSynchronizationPlanItemsSynchronizations[items.size()];
			for(int i=0; i<items.size(); i++){
				Line line=items.get(i);
				itemSyncs[i]=new WSSynchronizationPlanItemsSynchronizations();
				itemSyncs[i].setConceptPattern(line.keyValues.get(0).value);
				itemSyncs[i].setIdsPattern(line.keyValues.get(1).value);
				itemSyncs[i].setSourceRevisionID(line.keyValues.get(2).value);
				itemSyncs[i].setTargetRevisionID(line.keyValues.get(3).value);
				itemSyncs[i].setAlgorithm(line.keyValues.get(4).value);				
			}
			ws.setItemsSynchronizations(itemSyncs);
			
			this.comitting = false;
			
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error comtiting the page", "Error comitting the page: "+e.getLocalizedMessage());
		}    	
	}

	/****************************************************************************
	 *   Comptroler Model
	 ****************************************************************************/
	public class SyncronizationPlan {
		protected String description=null;
		protected String url=null;
	    protected String username=null;
	    protected String password;
	    protected Map<String,List<Line>> xtentisObjectsList=new HashMap<String,List<Line>>();
	    protected List<Line> itemsList=new ArrayList<Line>();
	    
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}


		public Map<String, List<Line>> getXtentisObjectsList() {
			return xtentisObjectsList;
		}

		public void setXtentisObjectsList(Map<String, List<Line>> xtentisObjectsList) {
			this.xtentisObjectsList = xtentisObjectsList;
		}

		public List<Line> getItemsList() {
			return itemsList;
		}

		public void setItemsList(List<Line> itemsList) {
			this.itemsList = itemsList;
		}

		@Override
		public String toString() {
			StringWriter sw = new StringWriter();
			try {
				Marshaller.marshal(this, sw);
			} catch (Exception e) {
				System.out.println("ERROR marshalling Role");
				e.printStackTrace();
			}
			return sw.toString();
		}
	
	}//class SyncronizationPlan
	

}
