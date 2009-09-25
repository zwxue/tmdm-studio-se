package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

import com.amalto.workbench.dialogs.VersioningDialog;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.LineItem;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSDropItem;
import com.amalto.workbench.webservices.WSItemPK;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSRolePK;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.WSStoredProcedurePK;
import com.amalto.workbench.webservices.WSSynchronizationPlanPK;
import com.amalto.workbench.webservices.WSTransformerV2PK;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.WSViewPK;

public class VersioningXObjectAction extends Action{

	private Shell shell = null;
	private Viewer viewer = null;
	private TreeObject sampleXObject=null;
	private boolean isItems=false;
	
	/**
	 * @param serverView
	 * 
	 * used for objects
	 */
	public VersioningXObjectAction(ServerView serverView) {

		this(serverView.getSite().getShell(),serverView.getViewer());
		this.isItems=false;
	}
	
	/**
	 * @param shell
	 * @param viewer
	 * @param xObject
	 * 
	 * used for items
	 */
	public VersioningXObjectAction(Shell shell,Viewer viewer,TreeObject xObject) {

		this(shell,viewer);
		this.sampleXObject=xObject;
		this.isItems=true;
	}
	
	protected VersioningXObjectAction(Shell shell,Viewer viewer) {
		super();
		this.shell=shell;
		this.viewer = viewer;
		setImageDescriptor(ImageCache.getImage( "icons/versioning.gif"));
		setText("Versioning");
		setToolTipText("Manages the versioning of this item");
	}
	
	public void run() {
		try {
			super.run();
			IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
			Iterator<TreeObject> selectedIterator=selection.iterator();
			
			//validate
			if(selection.isEmpty()) {
					MessageDialog.openWarning(
							shell, 
							"Warning", 
							"Please select an Object/Item first! "
					);
					return;
			}
			
			//get SampleXObject
			if(!isItems){
				sampleXObject=(TreeObject) selection.getFirstElement();
			}
			
			if(!isItems){
				
				//classified tree objects
				Map<Integer, List<TreeObject>> selectedObjectsMap=new HashMap<Integer, List<TreeObject>>();
				for (;selectedIterator.hasNext();) {
					TreeObject treeObject = (TreeObject) selectedIterator.next();
					Integer treeObjectType = new Integer(treeObject.getType());
					if(selectedObjectsMap.get(treeObjectType)==null){
						List<TreeObject> list=new ArrayList<TreeObject>();
						if(treeObject.isXObject())list.add(treeObject);
						selectedObjectsMap.put(treeObjectType, list);
					}else{
						List<TreeObject> list=selectedObjectsMap.get(treeObjectType);
						if(treeObject.isXObject())list.add(treeObject);
						selectedObjectsMap.put(treeObjectType, list);
					}	
				}
				

				if(selectedObjectsMap.size()>1){
					    //TODO support muti-type
						MessageDialog.openWarning(
								shell, 
								"Warning", 
								"Versioning is not supported for muti-type objects! "
						);
						return;
				}
				
				
				//get type
				String type=null;
				if(sampleXObject!=null)type=determineTypeByTreeObjectType(sampleXObject.getType());
				if (type==null) {
					MessageDialog.openWarning(
							shell, 
							"Versioning Not Supported", 
							"Versioning is not supported for these deprecated objects"
					);
					return;
				}
				
				//get instances
				String[] instances=null;
				
				List<TreeObject> treeObjects=selectedObjectsMap.get(new Integer(sampleXObject.getType()));
				if(treeObjects.size()>0){
					instances=new String[treeObjects.size()];
					for (int i = 0; i < treeObjects.size(); i++) {
						instances[i]=determineInstanceByTreeObjectType(sampleXObject.getType(),treeObjects.get(i));
					}
				}
				  
		        //open dialog
				if(sampleXObject!=null){
					VersioningDialog dialog = new VersioningDialog(
							shell, 
							Util.getPort(sampleXObject),
							type,
							instances
					);
					
					dialog.setBlockOnOpen(true);
					dialog.open();
				}
				
			}else{
				
				//get itemPKs
				WSItemPK[] wsItemPKs=null;
				List<LineItem> lineItems = selection.toList();
				wsItemPKs=new WSItemPK[lineItems.size()];
				for (int i = 0; i < lineItems.size(); i++) {
					LineItem lineItem = lineItems.get(i);
					wsItemPKs[i]=new WSItemPK(
									(WSDataClusterPK)sampleXObject.getWsKey(),
									lineItem.getConcept(),
									lineItem.getIds()
						         );
				}
				
				//open dialog
				if(sampleXObject!=null){
					VersioningDialog dialog = new VersioningDialog(
							shell, 
							Util.getPort(sampleXObject),
							wsItemPKs
					);
					
					dialog.setBlockOnOpen(true);
					dialog.open();
				}
				
			}
			
                   
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					shell,
					"Error", 
					"An error occured trying to version the "+IConstants.TALEND+" object: "+e.getLocalizedMessage()
			);
		}		
	}
	

	private String determineTypeByTreeObjectType(int xobjectType) {
		String type = null;
		switch (xobjectType) {
			/*
			case TreeObject.INBOUND_ADAPTOR :
				type =  "Inbound Adaptor";
				break;
			case TreeObject.INBOUND_PLUGIN:
				type =  "Inbound Plugin";
				break;
			case TreeObject.DESTINATION :
				type =  "Destination";
				break;
			case TreeObject.OUTBOUND_ADAPTOR:
				type =  "Outbound Adaptor";
				break;
			case TreeObject.OUTBOUND_PLUGIN:
				type =  "Outbound Plugin";
				break;
			case TreeObject.DOCUMENT:
				type =  "Document";
				break;
			case TreeObject.ITEM:
				type =  "Item";
			*/
			case TreeObject.VIEW:
				type =  "View";
				break;
			case TreeObject.DATA_MODEL:
				type =  "Data Model";
				break;
			/*
			case TreeObject.SOURCE:
				type =  "Source";
				break;
			*/
			case TreeObject.DATA_CLUSTER:
				type =  "Data Cluster";
				break;
			case TreeObject.SUBSCRIPTION_ENGINE:
				type =  "Routing Orders";
				break;
			case TreeObject.ROLE:
				type =  "Role";
				break;
			case TreeObject.STORED_PROCEDURE:
				type =  "Stored Procedure";	
				break;
			case TreeObject.TRANSFORMER:
				type =  "Transformer V2";
				break;
			case TreeObject.MENU:
				type =  "Menu";
				break;
			case TreeObject.ROUTING_RULE:
				type =  "Routing Rule";	
				break;
			case TreeObject.UNIVERSE:
				type="Universe";
				break;
			case TreeObject.SYNCHRONIZATIONPLAN:
				type="Synchronization Plan";
				break;
		}
		return type;
	}
	
	private String determineInstanceByTreeObjectType(int xobjectType,TreeObject xobject) {
		String instance = null;
		switch (xobjectType) {
			/*
			case TreeObject.INBOUND_ADAPTOR :
				instance = (xobject.isXObject() ? ((WSInboundAdaptorPK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.INBOUND_PLUGIN:
				instance = (xobject.isXObject() ? ((WSInboundPluginPK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.DESTINATION :
				instance = (xobject.isXObject() ? ((WSDestinationPK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.OUTBOUND_ADAPTOR:
				instance = (xobject.isXObject() ? ((WSOutboundAdaptorPK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.OUTBOUND_PLUGIN:
				instance = (xobject.isXObject() ? ((WSOutboundPluginPK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.DOCUMENT:
				instance = (xobject.isXObject() ? ((WSDocumentPK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.ITEM:
				instance = (xobject.isXObject() ? ((WSItemPK)xobject.getWsKey()).getPk() : null);
			*/
			case TreeObject.VIEW:
				instance = (xobject.isXObject() ? ((WSViewPK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.DATA_MODEL:
				instance = (xobject.isXObject() ? ((WSDataModelPK)xobject.getWsKey()).getPk() : null);
				break;
			/*
			case TreeObject.SOURCE:
				instance = (xobject.isXObject() ? ((WSSourcePK)xobject.getWsKey()).getPk() : null);
				break;
			*/
			case TreeObject.DATA_CLUSTER:
				instance = (xobject.isXObject() ? ((WSDataClusterPK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.SUBSCRIPTION_ENGINE:
				instance = null;
				break;
			case TreeObject.ROLE:
				instance = (xobject.isXObject() ? ((WSRolePK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.STORED_PROCEDURE:	
				instance = (xobject.isXObject() ? ((WSStoredProcedurePK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.TRANSFORMER:
				instance = (xobject.isXObject() ? ((WSTransformerV2PK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.MENU:	
				instance = (xobject.isXObject() ? ((WSMenuPK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.ROUTING_RULE:	
				instance = (xobject.isXObject() ? ((WSRoutingRulePK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.UNIVERSE:
				instance = (xobject.isXObject() ? ((WSUniversePK)xobject.getWsKey()).getPk() : null);
				break;
			case TreeObject.SYNCHRONIZATIONPLAN:
				instance = (xobject.isXObject() ? ((WSSynchronizationPlanPK)xobject.getWsKey()).getPk() : null);
				break;
		}
		return instance;
	}
	
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}