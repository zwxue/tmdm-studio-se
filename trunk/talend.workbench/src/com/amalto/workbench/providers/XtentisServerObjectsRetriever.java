package com.amalto.workbench.providers;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSComponent;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSGetComponentVersion;
import com.amalto.workbench.webservices.WSGetMenuPKs;
import com.amalto.workbench.webservices.WSGetRolePKs;
import com.amalto.workbench.webservices.WSGetRoutingRulePKs;
import com.amalto.workbench.webservices.WSGetTransformerPKs;
import com.amalto.workbench.webservices.WSGetViewPKs;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSRegexDataClusterPKs;
import com.amalto.workbench.webservices.WSRegexDataModelPKs;
import com.amalto.workbench.webservices.WSRegexStoredProcedure;
import com.amalto.workbench.webservices.WSRolePK;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.WSStoredProcedurePK;
import com.amalto.workbench.webservices.WSTransformerPK;
import com.amalto.workbench.webservices.WSVersion;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.XtentisPort;

public class XtentisServerObjectsRetriever implements IRunnableWithProgress {

	//ServerView view;
	private String endpointaddress;
	private String username;
	private String password;
    private TreeParent serverRoot;
	
	public XtentisServerObjectsRetriever(String endpointaddress, String username, String password) {
		this.endpointaddress = endpointaddress;
		this.username = username;
		this.password = password;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		try {
			
			monitor.beginTask("Loading Xtentis Server Objects", "admin".equals(username)? 12 : 9);
			
			//Access to server and get port
			XtentisPort port = Util.getPort(new URL(endpointaddress),username,password);
			monitor.worked(1);
			
			String displayName=endpointaddress;
			//fetch version info
			try {
				WSVersion version = port.getComponentVersion(new WSGetComponentVersion(WSComponent.DataManager,null));
				displayName += "   (v"+version.getMajor()+"."+version.getMinor()+"."+version.getRevision()+"_"+version.getBuild()+")";	
			} catch (Exception e) {
				/* old server */
			}
			
			
			//System.out.println("PING "+port.ping());
			
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			

			//server
			serverRoot = new TreeParent(
                    displayName,
                    null,
                    TreeObject._SERVER_,
                    endpointaddress,
                    username+":"+(password==null?"":password)
            );       
			
			monitor.subTask("Accessing server....");
			
			//Data Models
			TreeParent models = new TreeParent("Data Models",serverRoot,TreeObject.DATA_MODEL,null,null);			
			//WSDataModel[] xdm = port.getDataModels(new WSRegexDataModels("*")).getWsDataModels();
			WSDataModelPK[] xdmPKs = port.getDataModelPKs(new WSRegexDataModelPKs("")).getWsDataModelPKs();
			if (xdmPKs != null) {
				monitor.subTask("Loading Data Models");
				for (int i = 0; i < xdmPKs.length; i++) {
					String name = xdmPKs[i].getPk();
					if (!name.startsWith("XMLSCHEMA")) {
							TreeObject obj = new TreeObject(
									name,
									serverRoot,
									TreeObject.DATA_MODEL,
									xdmPKs[i],
									null   //no storage to save space
							);
							models.addChild(obj);
					}
				}
			}
			monitor.worked(1);
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			
			//DataClusters
			TreeParent dataClusters = new TreeParent("Data Clusters",serverRoot,TreeObject.DATA_CLUSTER,null,null);
			//WSDataCluster[] xdc = port.getDataClusters(new WSRegexDataClusters("*")).getWsDataClusters();
			WSDataClusterPK[] xdcPKs = port.getDataClusterPKs(new WSRegexDataClusterPKs("")).getWsDataClusterPKs();
			if (xdcPKs != null) {
				monitor.subTask("Loading Data Clusters");
				for (int i = 0; i < xdcPKs.length; i++) {
					String name = xdcPKs[i].getPk();
					if (! (
							"CACHE".equals(name)
							)
						) {	//FIXME: Hardcoded CACHE
						TreeObject obj = new TreeObject(
								name,
								serverRoot,
								TreeObject.DATA_CLUSTER,
								xdcPKs[i],
								null   //no storage to save space
						);
						dataClusters.addChild(obj);
					}
				}
			}
			monitor.worked(1);
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			


			//Views
			TreeParent views = new TreeParent("Views",serverRoot,TreeObject.VIEW,null,null);
			WSViewPK[] viewPKs = port.getViewPKs((new WSGetViewPKs(""))).getWsViewPK();
			if (viewPKs!=null) {
				monitor.subTask("Loading Views");
				for (int i = 0; i < viewPKs.length; i++) {
					String name = viewPKs[i].getPk();
					TreeObject obj = new TreeObject(
							name,
							serverRoot,
							TreeObject.VIEW,
							new WSViewPK(name),
							null   //no storage to save space
					);
					views.addChild(obj);
				}
			}
			monitor.worked(1);
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			

			//Stored Procedures
			TreeParent storedProcedures = new TreeParent("Stored Procedures",serverRoot,TreeObject.STORED_PROCEDURE,null,null);
			WSStoredProcedurePK[] spk = port.getStoredProcedurePKs(new WSRegexStoredProcedure("")).getWsStoredProcedurePK();
			if (spk!=null) {
				monitor.subTask("Loading Stored Procedures");
				for (int i = 0; i < spk.length; i++) {
					String name = spk[i].getPk();
					TreeObject obj = new TreeObject(
							name,
							serverRoot,
							TreeObject.STORED_PROCEDURE,
							new WSStoredProcedurePK(name),
							null   //no storage to save space
					);
					storedProcedures.addChild(obj);
				}
			}
			monitor.worked(1);
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			
//			Roles
			WSRolePK[] rolePKs = null;
			boolean hasRoles = true;
			try {
				rolePKs = port.getRolePKs(new WSGetRolePKs("*")).getWsRolePK();
			} catch (Exception e) {
				System.out.println("NO ROLES");
				// This server does not handle roles (pre 2.13)
				hasRoles = false;
			}
			TreeParent roles = null;
			if (hasRoles) {
				roles = new TreeParent("Roles",serverRoot,TreeObject.ROLE,null,null);
				if (rolePKs!=null) {
					monitor.subTask("Loading Roles");
					for (int i = 0; i < rolePKs.length; i++) {
						String name =rolePKs[i].getPk();
						TreeObject obj = new TreeObject(
								name,
								serverRoot,
								TreeObject.ROLE,
								new WSRolePK(name),
								null   //no storage to save space
						);
						roles.addChild(obj);
					}
				}
				monitor.worked(1);
				if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			}
			

//			Routing Rules
			WSRoutingRulePK[] routingRulePKs = null;
			boolean hasRoutingRules = true;
			try {
				routingRulePKs = port.getRoutingRulePKs(new WSGetRoutingRulePKs("")).getWsRoutingRulePKs();
			} catch (Exception e) {
				System.out.println("NO ROUTING RULES");
				// This server does not handle roles (pre 2.13)
				hasRoutingRules = false;
			}
			TreeParent rules = null;
			if (hasRoutingRules) {
				rules = new TreeParent("Routing Rules",serverRoot,TreeObject.ROUTING_RULE,null,null);
				if (routingRulePKs!=null) {
					monitor.subTask("Loading Routing Rules");
					for (int i = 0; i < routingRulePKs.length; i++) {
						String id =routingRulePKs[i].getPk();
						TreeObject obj = new TreeObject(
								id,
								serverRoot,
								TreeObject.ROUTING_RULE,
								new WSRoutingRulePK(id),
								null   //no storage to save space
						);
						rules.addChild(obj);
					}
				}
				monitor.worked(1);
				if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			}

			
			//Subscription Engine
			TreeObject  engine = new TreeObject(
					"Subscription Engine",
					serverRoot,
					TreeObject.SUBSCRIPTION_ENGINE,
					null,
					null
			);
			monitor.worked(1);
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			
			
//			Transformers
			WSTransformerPK[] transformerPKs = null;
			boolean hasTransformers = true;
			try {
				transformerPKs = port.getTransformerPKs(new WSGetTransformerPKs("")).getWsTransformerPK();
			} catch (Exception e) {
				System.out.println("No Transformers");
				// This server IS old
				hasTransformers = false;
			}
			TreeParent transformers = null;
			if (hasTransformers) {
				transformers = new TreeParent("Transformers",serverRoot,TreeObject.TRANSFORMER,null,null);
				if (transformerPKs!=null) {
					monitor.subTask("Loading Transfomers");
					for (int i = 0; i < transformerPKs.length; i++) {
						String id =transformerPKs[i].getPk();
						TreeObject obj = new TreeObject(
								id,
								serverRoot,
								TreeObject.TRANSFORMER,
								new WSTransformerPK(id),
								null   //no storage to save space
						);
						transformers.addChild(obj);
					}
				}
				monitor.worked(1);
				if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			}
			
//			Menus
			WSMenuPK[] menuPKs = null;
			boolean hasMenus = true;
			try {
				menuPKs = port.getMenuPKs(new WSGetMenuPKs("*")).getWsMenuPK();
			} catch (Exception e) {
				System.out.println("No Menus");
				// This server IS old
				hasMenus = false;
			}
			TreeParent menus = null;
			if (hasMenus) {
				menus = new TreeParent("Menus",serverRoot,TreeObject.MENU,null,null);
				if (menuPKs!=null) {
					monitor.subTask("Loading Menus");
					for (int i = 0; i < menuPKs.length; i++) {
						String id =menuPKs[i].getPk();
						TreeObject obj = new TreeObject(
								id,
								serverRoot,
								TreeObject.MENU,
								new WSMenuPK(id),
								null   //no storage to save space
						);
						menus.addChild(obj);
					}
				}
				monitor.worked(1);
				if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			}
			
			serverRoot.addChild(models);
			serverRoot.addChild(dataClusters);
			serverRoot.addChild(views);
			serverRoot.addChild(storedProcedures);
			serverRoot.addChild(engine);
			if (hasTransformers)serverRoot.addChild(transformers);
			if (hasRoles) serverRoot.addChild(roles);
			if (hasRoutingRules) serverRoot.addChild(rules);
			if (hasMenus) serverRoot.addChild(menus);
			
			monitor.done();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvocationTargetException(new XtentisException("Could not login: "+e.getLocalizedMessage()));
		}		
	}//run

    public TreeParent getServerRoot() {
        return serverRoot;
    }
}
