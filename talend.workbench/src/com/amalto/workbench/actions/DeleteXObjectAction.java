package com.amalto.workbench.actions;

import java.net.URL;
import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSDeleteDataCluster;
import com.amalto.workbench.webservices.WSDeleteDataModel;
import com.amalto.workbench.webservices.WSDeleteMenu;
import com.amalto.workbench.webservices.WSDeleteRole;
import com.amalto.workbench.webservices.WSDeleteRoutingRule;
import com.amalto.workbench.webservices.WSDeleteStoredProcedure;
import com.amalto.workbench.webservices.WSDeleteSynchronizationPlan;
import com.amalto.workbench.webservices.WSDeleteTransformerV2;
import com.amalto.workbench.webservices.WSDeleteUniverse;
import com.amalto.workbench.webservices.WSDeleteView;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSRolePK;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.WSStoredProcedurePK;
import com.amalto.workbench.webservices.WSSynchronizationPlanPK;
import com.amalto.workbench.webservices.WSTransformerV2PK;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.XtentisPort;

public class DeleteXObjectAction extends Action{

	private ServerView view = null;
	
	
	public DeleteXObjectAction(ServerView view) {
		super();
		this.view = view;
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/delete_obj.gif"));
		setText("Delete");
		setToolTipText("Delete this instance of the "+IConstants.TALEND+" Object");
	}
	
	public void run() {
		try {
			super.run();
			IStructuredSelection selection = (IStructuredSelection)view.getViewer().getSelection();
			for (Iterator<TreeObject> iter = selection.iterator(); iter.hasNext(); ) {
				TreeObject xobject = iter.next();
	            
	            if (!xobject.isXObject()) return;
	            
	            //ask for confimation
	            if (! MessageDialog.openConfirm(
	            		this.view.getSite().getShell(),
	            		"Delete "+IConstants.TALEND+" Object Instance",
	            		"Are you sure you want to delete "+xobject.getDisplayName()+" ?"
	            )) return;
	                        
	//          Access to server and get port
				XtentisPort port = Util.getPort(
						new URL(xobject.getEndpointAddress()),
						xobject.getUniverse(),
						xobject.getUsername(),
						xobject.getPassword()
				);
	              
	            switch(xobject.getType()) {
	            
		           	case TreeObject.DATA_MODEL:
		           		port.deleteDataModel(new WSDeleteDataModel((WSDataModelPK)xobject.getWsKey()));
		           		break;
		          	case TreeObject.VIEW:
		           		port.deleteView(new WSDeleteView((WSViewPK)xobject.getWsKey()));
		           		break;           		
		          	case TreeObject.DATA_CLUSTER:
		           		port.deleteDataCluster(new WSDeleteDataCluster((WSDataClusterPK)xobject.getWsKey()));
		           		break;      
		          	case TreeObject.STORED_PROCEDURE:
		           		port.deleteStoredProcedure(new WSDeleteStoredProcedure((WSStoredProcedurePK)xobject.getWsKey()));
		           		break;  
		          	case TreeObject.ROLE:
		           		port.deleteRole(new WSDeleteRole((WSRolePK)xobject.getWsKey()));
		           		break;  
		          	case TreeObject.ROUTING_RULE:
		           		port.deleteRoutingRule(new WSDeleteRoutingRule((WSRoutingRulePK)xobject.getWsKey()));
		           		break;  
		          	case TreeObject.TRANSFORMER:
		           		port.deleteTransformerV2(new WSDeleteTransformerV2((WSTransformerV2PK)xobject.getWsKey()));
		           		break;
		          	case TreeObject.MENU:
		           		port.deleteMenu(new WSDeleteMenu((WSMenuPK)xobject.getWsKey()));
		           		break;  	 
		          	case TreeObject.UNIVERSE:
		           		port.deleteUniverse(new WSDeleteUniverse((WSUniversePK)xobject.getWsKey()));
		           		break;  
		          	case TreeObject.SYNCHRONIZATIONPLAN:
		           		port.deleteSynchronizationPlan(new WSDeleteSynchronizationPlan((WSSynchronizationPlanPK)xobject.getWsKey()));
		           		break; 
		          	default:
		           		MessageDialog.openError(view.getSite().getShell(), "Error", "Unknown "+IConstants.TALEND+" Object Type: "+xobject.getType());
		           		return;
	            }//switch
	            
	       		xobject.getParent().removeChild(xobject);
	       		view.getViewer().refresh();
			}//for
       		//view.getSite().getWorkbenchWindow().get
                   
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					view.getSite().getShell(),
					"Error", 
					"An error occured trying to delete the "+IConstants.TALEND+" object: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}