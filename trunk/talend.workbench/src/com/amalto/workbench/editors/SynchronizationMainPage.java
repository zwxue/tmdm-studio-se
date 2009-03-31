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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.exolab.castor.xml.Marshaller;

import com.amalto.workbench.models.Line;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.FontUtils;
import com.amalto.workbench.webservices.WSGetAlgorithmsForSynchronizationPlans;
import com.amalto.workbench.webservices.WSGetObjectsForSynchronizationPlans;
import com.amalto.workbench.widgets.ComplexTableViewer;
import com.amalto.workbench.widgets.LabelText;

public class SynchronizationMainPage extends AMainPageV2{


	protected DropTarget windowTarget;

	protected TableViewer instancesViewer;

	protected FormToolkit toolkit;
	
	private String[] xtentisObjectColumns=new String[]{"Instance Pattern","Source Revision ID","Target Revision ID","Algorithm"};
	private String[] itemsColumns=new String[]{"Concept Pattern","IDs Pattern","Source Revision ID","Target Revision ID","Algorithm"};
		
	protected SyncronizationPlan syncPlan;
	public SynchronizationMainPage(FormEditor editor) {
        super(
        		editor,
        		SynchronizationMainPage.class.getName(),
        		"Synchronization "+((XObjectEditorInput)editor.getEditorInput()).getName()
        );        
	}

	@Override
	protected void createCharacteristicsContent(FormToolkit toolkit,
			Composite charComposite) {
	try {
		if(syncPlan==null)syncPlan=new SyncronizationPlan();
		this.toolkit=toolkit;
        //basic setting
		final LabelText urlText =new LabelText(toolkit,charComposite,"URL");        
		urlText.getText().addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		if (refreshing) return;
        		syncPlan.url=urlText.getText().getText();
        		markDirty();
        	}
        });
  
		final LabelText usernameText =new LabelText(toolkit,charComposite,"Username");        
		usernameText.getText().addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		if (refreshing) return;
        		syncPlan.username=usernameText.getText().getText();
        		markDirty();
        	}
        });
		final LabelText passwordText =new LabelText(toolkit,charComposite,"Password");        
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
        Composite objecstGroup = this.getNewSectionComposite("Xtentis Objects Synchronization");
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
        }
        //Items Section          
        Composite itemsGroup = this.getNewSectionComposite("Items Synchronization");
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
			
//			WSUniverse wsUniverse = (WSUniverse) (getXObject().getWsObject());    	
//			
//			universe = new Universe("");
//			universe.setName(wsUniverse.getName());
//			universe.setDescription(wsUniverse.getDescription()==null ? "" : wsUniverse.getDescription());
//			universe.setDefaultReversionID(wsUniverse.getDefaultItemsRevisionID());
//			universe.getSystemObjectsList().clear();
//			for(WSUniverseXtentisObjectsRevisionIDs xtentisObjects: wsUniverse.getXtentisObjectsRevisionIDs()){
//				universe.getSystemObjectsList().add(new KeyValue(xtentisObjects.getXtentisObjectName(),xtentisObjects.getRevisionID()));
//			}
//			
//			for(WSUniverseItemsRevisionIDs item:wsUniverse.getItemsRevisionIDs()){
//				universe.getItemsList().add(new Line(columns,new String[]{item.getConceptPattern(),item.getRevisionID()}));
//			}
//			
//			XtentisPort port = Util.getPort(getXObject());
//            String[] objects = port.getObjectsForRoles(null).getStrings();
//            Arrays.sort(objects);
//	    	
//			//Now fill in the values on the page
//            descriptionText.setText(universe.getDescription()==null ? "" : universe.getDescription());
//            //nameText.setText(universe.getName()==null?"":universe.getName())  ;
//            for(KeyValue line: universe.getSystemObjectsList()){
//            	LabelText labelText=basicLabelTexts.get(line.key);
//            	if(labelText!=null){
//            		labelText.getText().setText(line.value);
//            	}
//            }
//            instancesViewer.setInput(universe.getItemsList());
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
			
//			WSUniverse ws = (WSUniverse) (getXObject().getWsObject());    	
//			ws.setName(universe.getName());
//			ws.setDescription(universe.getDescription());
//			List<WSUniverseXtentisObjectsRevisionIDs> xtentisObjectsRevisionIDs=new ArrayList<WSUniverseXtentisObjectsRevisionIDs>();
//			for(KeyValue line: universe.getSystemObjectsList()){
//				xtentisObjectsRevisionIDs.add(new WSUniverseXtentisObjectsRevisionIDs(line.key,line.value));
//			}
//			ws.setXtentisObjectsRevisionIDs(xtentisObjectsRevisionIDs.toArray(new WSUniverseXtentisObjectsRevisionIDs[xtentisObjectsRevisionIDs.size()] ));
//			List<WSUniverseItemsRevisionIDs> itemIds=new ArrayList<WSUniverseItemsRevisionIDs>();
//			for(Line line: universe.getItemsList()){				
//				itemIds.add(new WSUniverseItemsRevisionIDs(line.keyValues.get(0).value,line.keyValues.get(1).value));
//			}
//			ws.setItemsRevisionIDs(itemIds.toArray(new WSUniverseItemsRevisionIDs[itemIds.size()]));
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
		protected String url=null;
	    protected String username=null;
	    protected String password;
	    protected Map<String,List<Line>> xtentisObjectsList=new HashMap<String,List<Line>>();
	    protected List<Line> itemsList=new ArrayList<Line>();
	    
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
