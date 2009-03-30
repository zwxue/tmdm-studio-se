package com.amalto.workbench.actions;

import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSDataCluster;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSDestination;
import com.amalto.workbench.webservices.WSDestinationPK;
import com.amalto.workbench.webservices.WSExistsDataCluster;
import com.amalto.workbench.webservices.WSExistsDataModel;
import com.amalto.workbench.webservices.WSExistsMenu;
import com.amalto.workbench.webservices.WSExistsRole;
import com.amalto.workbench.webservices.WSExistsRoutingRule;
import com.amalto.workbench.webservices.WSExistsStoredProcedure;
import com.amalto.workbench.webservices.WSExistsTransformer;
import com.amalto.workbench.webservices.WSExistsView;
import com.amalto.workbench.webservices.WSGetDestination;
import com.amalto.workbench.webservices.WSGetInboundAdaptor;
import com.amalto.workbench.webservices.WSGetOutboundAdaptor;
import com.amalto.workbench.webservices.WSGetSource;
import com.amalto.workbench.webservices.WSInboundAdaptor;
import com.amalto.workbench.webservices.WSInboundAdaptorPK;
import com.amalto.workbench.webservices.WSMenu;
import com.amalto.workbench.webservices.WSMenuEntry;
import com.amalto.workbench.webservices.WSMenuMenuEntriesDescriptions;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSOutboundAdaptor;
import com.amalto.workbench.webservices.WSOutboundAdaptorPK;
import com.amalto.workbench.webservices.WSPutDataModel;
import com.amalto.workbench.webservices.WSRole;
import com.amalto.workbench.webservices.WSRolePK;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRuleExpression;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.WSSource;
import com.amalto.workbench.webservices.WSSourcePK;
import com.amalto.workbench.webservices.WSStoredProcedure;
import com.amalto.workbench.webservices.WSStoredProcedurePK;
import com.amalto.workbench.webservices.WSTransformer;
import com.amalto.workbench.webservices.WSTransformerPK;
import com.amalto.workbench.webservices.WSView;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.WSWhereCondition;
import com.amalto.workbench.webservices.XtentisPort;

public class NewXObjectAction extends Action{

	private ServerView view = null;
	
	
	public NewXObjectAction(ServerView view) {
		super();
		this.view = view;
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/add_obj.gif"));
		setText("New");
		setToolTipText("Create a new instance of an Xtentis Object");
	}
	
	public void run() {
		try {
			super.run();
            ISelection selection = view.getViewer().getSelection();
            TreeObject xobject = (TreeObject)((IStructuredSelection)selection).getFirstElement();
            TreeParent xfolder = (xobject.isXObject()) ? xobject.getParent() : (TreeParent) xobject;
            
            //get New Key
       		Object key  = null;
            switch(xfolder.getType()) {
	           	case TreeObject.SOURCE:
	           	case TreeObject.DESTINATION:
	           	case TreeObject.DATA_MODEL:
	           	case TreeObject.INBOUND_ADAPTOR:         		
	           	case TreeObject.INBOUND_PLUGIN:
	           	case TreeObject.OUTBOUND_ADAPTOR:         		
	           	case TreeObject.OUTBOUND_PLUGIN:
	           	case TreeObject.VIEW:
	           	case TreeObject.DATA_CLUSTER:
	           	case TreeObject.STORED_PROCEDURE:
	           	case TreeObject.ROLE:
	           	case TreeObject.ROUTING_RULE:
	           	case TreeObject.TRANSFORMER:
	           	case TreeObject.MENU:
	           		InputDialog id = new InputDialog(
	           				view.getSite().getShell(),
	           				"New Xtentis Object Instance",
	           				"Enter a Name for the New Instance",
	           				null,
	           				new IInputValidator() {
	           					public String isValid(String newText) {
	           						if ((newText==null) || "".equals(newText)) return "The Name cannot be empty";
	           						return null;
	           					};
	           				}
	           		);
	           		id.setBlockOnOpen(true);
	           		if (id.open() == Window.CANCEL) return;
	           		key  = id.getValue();
	           		break;
	           	default:
	           		//server or not supported
	           		return;
	        }//switch
            
//          Access to server and get port
			XtentisPort port = Util.getPort(
					new URL(xobject.getEndpointAddress()),
					xobject.getUsername(),
					xobject.getPassword()
			);
              
			//create a new bare Instance
			TreeObject newInstance = null;
            switch(xobject.getType()) {
	           	case TreeObject.SOURCE: {
	           		//check if already exists
	           		try {
	           			port.getSource(new WSGetSource(new WSSourcePK((String)key)));
	           			MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Source "+(String)key+" already exists");
	           			return;
	           		} catch (Exception e) {}
	           		//add
	           		WSSource wsSource = new WSSource((String)key,"");
	           		//port.putSource(new WSPutSource(wsSource));
	           		newInstance = new TreeObject(
	    							(String)key,
	    							xfolder.getServerRoot(),
	    							TreeObject.SOURCE,
	    							new WSSourcePK((String)key),
	    							wsSource
	    			);           		
	           		break; }
	           	case TreeObject.DESTINATION: {
	           		//check if already exists
	           		try {
	           			port.getDestination(new WSGetDestination(new WSDestinationPK((String)key)));
	           			MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Destination "+(String)key+" already exists");
	           			return;
	           		} catch (Exception e) {}
	           		//add
	           		WSDestination wsDestination = new WSDestination((String)key,"");
	           		//port.putDestination(new WSPutDestination(wsDestination));
	           		newInstance = new TreeObject(
	    							(String)key,
	    							xfolder.getServerRoot(),
	    							TreeObject.DESTINATION,
	    							new WSDestinationPK((String)key),
	    							wsDestination
	    			);           		
	           		break; }
	           	case TreeObject.DATA_MODEL: {
	           		//check if already exists
           			if (port.existsDataModel(new WSExistsDataModel(new WSDataModelPK((String)key))).is_true()) {;
           				MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Data Model "+(String)key+" already exists");
           				return;
           			}
	           		//add
	           		WSDataModel wsDataModel = new WSDataModel(
	           				(String)key,
	           				"",
	           				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
	           				"<xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"/>"
	           		);
	           		port.putDataModel(new WSPutDataModel(wsDataModel));
	           		newInstance = new TreeObject(
	    							(String)key,
	    							xfolder.getServerRoot(),
	    							TreeObject.DATA_MODEL,
	    							new WSDataModelPK((String)key),
	    							wsDataModel
	    			);           		
	           		break; }
	           	case TreeObject.INBOUND_ADAPTOR: {
	           		//check if already exists
	           		try {
	           			port.getInboundAdaptor(new WSGetInboundAdaptor(new WSInboundAdaptorPK((String)key)));
	           			MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Inbound Adaptor "+(String)key+" already exists");
	           			return;
	           		} catch (Exception e) {}
	           		//add
	                WSDataModelPK[] dataModelPKs = Util.getAllDataModelPKs(
	                		new URL(xobject.getEndpointAddress()),
	                		xobject.getUsername(),
	                		xobject.getPassword()
	                );
	                String firstDataModel = null;
	                for (int i = 0; i < dataModelPKs.length; i++) {
						if (dataModelPKs[i].getPk().indexOf("XMLSCHEMA---")==-1) {
							firstDataModel = dataModelPKs[i].getPk();
							break;
						}
					}
	                if (firstDataModel == null) {
	                	MessageDialog.openError(
	                			view.getSite().getShell(), 
	                			"Error", 
	                			"Please create a Data Model before editing an Inbound Adaptor");
	                	return;
	                }
	                WSSource[] sources = Util.getAllSources(
	                		new URL(xobject.getEndpointAddress()),
	                		xobject.getUsername(),
	                		xobject.getPassword()
	                );
	                if ((sources == null) || (sources.length == 0)) {
	                	MessageDialog.openError(
	                			view.getSite().getShell(), 
	                			"Error", 
	                			"Please create Sources before editing an Inbound Adaptor");
	                	return;
	                }
	           		WSInboundAdaptor ia = new WSInboundAdaptor(
	           				(String)key,
	           				"",
	           				new WSDataModelPK(firstDataModel),
	           				new WSSourcePK(sources[0].getName()),
	           				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
	           				"<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n"+
	           			    "	<xsl:template match=\"/\"><xsl:copy-of select=\".\"/></xsl:template>\n"+
	           			    "</xsl:stylesheet>",
	           			    null,
	           			    null,
	           			    null
	           		);
	           		//port.putInboundAdaptor(new WSPutInboundAdaptor(ia));
	           		newInstance = new TreeObject(
	    							(String)key,
	    							xfolder.getServerRoot(),
	    							TreeObject.INBOUND_ADAPTOR,
	    							new WSInboundAdaptorPK((String)key),
	    							ia
	    			);           		
	           		break; }
	           	
	           	case TreeObject.OUTBOUND_ADAPTOR: {
	           		//check if already exists
	           		try {
	           			port.getOutboundAdaptor(new WSGetOutboundAdaptor(new WSOutboundAdaptorPK((String)key)));
	           			MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Outbound Adaptor "+(String)key+" already exists");
	           			return;
	           		} catch (Exception e) {}
	           		//add
	                WSDataModelPK[] dataModelPKs = Util.getAllDataModelPKs(
	                		new URL(xobject.getEndpointAddress()),
	                		xobject.getUsername(),
	                		xobject.getPassword()
	                );
	                String firstDataModel = null;
	                for (int i = 0; i < dataModelPKs.length; i++) {
						if (dataModelPKs[i].getPk().indexOf("XMLSCHEMA---")==-1) {
							firstDataModel = dataModelPKs[i].getPk();
							break;
						}
					}
	                if (firstDataModel == null) {
	                	MessageDialog.openError(
	                			view.getSite().getShell(), 
	                			"Error", 
	                			"Please create a Data Model before editing an Outbound Adaptor");
	                	return;
	                }
	                WSDestination[] destinations = Util.getAllDestinations(
	                		new URL(xobject.getEndpointAddress()),
	                		xobject.getUsername(),
	                		xobject.getPassword()
	                );
	                if ((destinations == null) || (destinations.length == 0)) {
	                	MessageDialog.openError(
	                			view.getSite().getShell(), 
	                			"Error", 
	                			"Please create Destinations before editing an Outbound Adaptor");
	                	return;
	                }
	           		WSOutboundAdaptor ia = new WSOutboundAdaptor(
	           				(String)key,
	           				"",
	           				new WSDataModelPK(firstDataModel),
	           				new WSDestinationPK(destinations[0].getName()),
	           				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
	           				"<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n"+
	           			    "	<xsl:template match=\"/\"><xsl:copy-of select=\".\"/></xsl:template>\n"+
	           			    "</xsl:stylesheet>",
	           			    null,
	           			    null
	           		);
	           		//port.putOutboundAdaptor(new WSPutOutboundAdaptor(ia));
	           		newInstance = new TreeObject(
	    							(String)key,
	    							xfolder.getServerRoot(),
	    							TreeObject.OUTBOUND_ADAPTOR,
	    							new WSOutboundAdaptorPK((String)key),
	    							ia
	    			);           		
	           		break; }	          
	           	
	           	case TreeObject.VIEW: {
	           		//check if already exists
	           		if(port.existsView(new WSExistsView(new WSViewPK((String)key))).is_true()) {
	           				MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","View "+(String)key+" already exists");
	           				return;
	           		}
	           		//add
	                WSDataModelPK[] dataModelPKs = Util.getAllDataModelPKs(
	                		new URL(xobject.getEndpointAddress()),
	                		xobject.getUsername(),
	                		xobject.getPassword()
	                );
	                String firstDataModel = null;
	                for (int i = 0; i < dataModelPKs.length; i++) {
						if (dataModelPKs[i].getPk().indexOf("XMLSCHEMA--")==-1) {
							firstDataModel = dataModelPKs[i].getPk();
							break;
						}
					}
	                if (firstDataModel == null) {
	                	MessageDialog.openError(
	                			view.getSite().getShell(), 
	                			"Error", 
	                			"Please create a Data Model before editing a View");
	                	return;
	                }
	                WSDataClusterPK[] dataClusterPKs = Util.getAllDataClusterPKs(
	                		new URL(xobject.getEndpointAddress()),
	                		xobject.getUsername(),
	                		xobject.getPassword()
	                );
	                String firstItemCluster = null;
	                for (int i = 0; i < dataClusterPKs.length; i++) {
						if (!dataClusterPKs[i].getPk().equals("CACHE")) {  //FIXME: hardcoded CACHE
							firstItemCluster = dataClusterPKs[i].getPk();
							break;
						}
					}
	                if (firstItemCluster == null) {
	                	MessageDialog.openError(
	                			view.getSite().getShell(), 
	                			"Error", 
	                			"Please create a Data Cluster for Items before editing a View");
	                	return;
	                }
	           		WSView wsview = new WSView(
	           				(String)key,
	           				"",
	           				new String[] {},
	           				new WSWhereCondition[0],
	           				new String[] {}
	           		);
	           		//port.putView(new WSPutView(view));
	           		newInstance = new TreeObject(
	    							(String)key,
	    							xfolder.getServerRoot(),
	    							TreeObject.VIEW,
	    							new WSViewPK((String)key),
	    							wsview
	    			);           		
	           		break;	}
	           	
                case TreeObject.DATA_CLUSTER: {
                    //check if already exists
                    if (port.existsDataCluster(new WSExistsDataCluster(new WSDataClusterPK((String)key))).is_true()) {
                        MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Data Cluster "+(String)key+" already exists");
                        return;
                    }
                    //add
                    WSDataCluster dc = new WSDataCluster(
                            (String)key,
                            "",
                            ""												//vocabulary
                    );
                    newInstance = new TreeObject(
                                    (String)key,
                                    xfolder.getServerRoot(),
                                    TreeObject.DATA_CLUSTER,
                                    new WSDataClusterPK((String)key),
                                    dc
                    );                  
                    break;  }        
                
                case TreeObject.STORED_PROCEDURE: {
                    //check if already exists
                    if (port.existsStoredProcedure(new WSExistsStoredProcedure(new WSStoredProcedurePK((String)key))).is_true()) {
                        MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Stored Procedure "+(String)key+" already exists");
                        return;
                    }
                    //add
                    WSStoredProcedure storedProcedure = new WSStoredProcedure(
                    		(String)key,
                    		"",
                    		""
                    );
                    newInstance = new TreeObject(
                                    (String)key,
                                    xfolder.getServerRoot(),
                                    TreeObject.STORED_PROCEDURE,
                                    new WSStoredProcedurePK((String)key),
                                    storedProcedure
                    );                  
                    break;  }    

                case TreeObject.ROLE: {
                    //check if already exists
                    if (port.existsRole(new WSExistsRole(new WSRolePK((String)key))).is_true()) {
                        MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Role "+(String)key+" already exists");
                        return;
                    }
                    //add
                    WSRole role = new WSRole(
                    		(String)key,
                    		"",
                    		null
                    );
                    newInstance = new TreeObject(
                                    (String)key,
                                    xfolder.getServerRoot(),
                                    TreeObject.ROLE,
                                    new WSRolePK((String)key),
                                    role
                    );                  
                    break;  }    

                case TreeObject.ROUTING_RULE: {
                    //check if already exists
                    if (port.existsRoutingRule(new WSExistsRoutingRule(new WSRoutingRulePK((String)key))).is_true()){
                        MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Routing Rule "+(String)key+" already exists");
                        return;
                    }
                    //add
                    WSRoutingRule routingRule = new WSRoutingRule(
                    		(String)key,
                    		"",
                    		false,
                    		"*",
                    		"",
                    		"",
                    		new WSRoutingRuleExpression[0]
                    		
                    );
                    newInstance = new TreeObject(
                                    (String)key,
                                    xfolder.getServerRoot(),
                                    TreeObject.ROUTING_RULE,
                                    new WSRoutingRulePK((String)key),
                                    routingRule
                    );                  
                    break;  }    

                case TreeObject.TRANSFORMER: {
                    //check if already exists
                    if (port.existsTransformer(new WSExistsTransformer(new WSTransformerPK((String)key))).is_true()){
                        MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Transformer "+(String)key+" already exists");
                        return;
                    }
                    //add
                    WSTransformer transformer = new WSTransformer(
                    		(String)key,
                    		"",
                    		null
                    );
                    newInstance = new TreeObject(
                                    (String)key,
                                    xfolder.getServerRoot(),
                                    TreeObject.TRANSFORMER,
                                    new WSTransformerPK((String)key),
                                    transformer
                    );                  
                    break;  }                    

                case TreeObject.MENU: {
                    //check if already exists
                    if(port.existsMenu(new WSExistsMenu(new WSMenuPK((String)key))).is_true()){
                        MessageDialog.openError(this.view.getSite().getShell(),"Error Creating Instance","Menu "+(String)key+" already exists");
                        return;
                    }
                    //add
                    WSMenu menu = new WSMenu(
                    		(String)key,
                    		"",
                    		new WSMenuEntry[]{
                    			new WSMenuEntry(
                    				(String)key,
                    				new WSMenuMenuEntriesDescriptions[]{
                    					new WSMenuMenuEntriesDescriptions("en",(String)key)
                    				},
                    				null,
                    				null,
                    				null
                    			)
                    		}
                    );
                    newInstance = new TreeObject(
                                    (String)key,
                                    xfolder.getServerRoot(),
                                    TreeObject.MENU,
                                    new WSMenuPK((String)key),
                                    menu
                    );                  
                    break;  }      
                
	           	default:
	           		//server
	           		return;
            }//switch

            //xfolder.addChild(newInstance);
            view.getSite().getWorkbenchWindow().getActivePage().openEditor(
                    new XObjectEditorInput(newInstance,newInstance.getDisplayName()),
                    "com.amalto.workbench.editors.XObjectEditor"
           	);
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					view.getSite().getShell(),
					"Error", 
					"An error occured trying to create a new Xtentis Object Instance: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}