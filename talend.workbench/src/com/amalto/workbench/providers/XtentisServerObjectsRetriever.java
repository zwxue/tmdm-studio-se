package com.amalto.workbench.providers;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import com.amalto.workbench.actions.DocumentsSearchAction;
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
import com.amalto.workbench.webservices.WSInboundAdaptor;
import com.amalto.workbench.webservices.WSInboundAdaptorPK;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSOutboundAdaptor;
import com.amalto.workbench.webservices.WSOutboundAdaptorPK;
import com.amalto.workbench.webservices.WSRegexDataClusterPKs;
import com.amalto.workbench.webservices.WSRegexDataModelPKs;
import com.amalto.workbench.webservices.WSRegexInboundAdaptors;
import com.amalto.workbench.webservices.WSRegexOutboundAdaptors;
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
	
			/*
			//Sources
			TreeParent sources = new TreeParent("Sources",serverRoot,TreeObject.SOURCE,null,null);
			WSSource[] xs = port.getSources(new WSRegexSources("*")).getWsSources();
			if (xs != null) {
				monitor.subTask("Loading Sources");
				for (int i = 0; i < xs.length; i++) {
					String name = xs[i].getName();
					TreeObject obj = new TreeObject(
							name,
							serverRoot,
							TreeObject.SOURCE,
							new WSSourcePK(name),
							null   //no storage to save space
					);
					sources.addChild(obj);
				}
			}
			monitor.worked(1);
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			*/

			/*
			//Destinations
			TreeParent destinations = new TreeParent("Destinations",serverRoot,TreeObject.DESTINATION,null,null);
			WSDestination[] xd = port.getDestinations(new WSRegexDestinations("*")).getWsDestinations();
			if (xd != null) {
				monitor.subTask("Loading Destinations");
				for (int i = 0; i < xd.length; i++) {
					String name = xd[i].getName();
					TreeObject obj = new TreeObject(
							name,
							serverRoot,
							TreeObject.DESTINATION,
							new WSDestinationPK(name),
							null   //no storage to save space
					);
					destinations.addChild(obj);
				}
			}
			monitor.worked(1);
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			 */
			
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
			
			//Inbound Adaptors //deprecated
			TreeParent inboundAdaptors=null;
			if ("admin".equals(username)) {
				inboundAdaptors = new TreeParent("Inbound Adaptors",serverRoot,TreeObject.INBOUND_ADAPTOR,null,null);
				WSInboundAdaptor[] xia = port.getInboundAdaptors(new WSRegexInboundAdaptors("")).getWsInboundAdaptors();
				if (xia!=null) {
					monitor.subTask("Loading Inbound Adaptors");
					for (int i = 0; i < xia.length; i++) {
						String name = xia[i].getName();
						TreeObject obj = new TreeObject(
								name,
								serverRoot,
								TreeObject.INBOUND_ADAPTOR,
								new WSInboundAdaptorPK(name),
								null   //no storage to save space
						);
						inboundAdaptors.addChild(obj);
					}
				}
				monitor.worked(1);
				if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			}	
				/*
			//Inbound Plugins
			TreeParent inboundPlugins = new TreeParent("Inbound Plugins",serverRoot,TreeObject.INBOUND_PLUGIN,null,null);
			WSInboundPlugin[] xic = port.getInboundPlugins(new WSRegexInboundPlugins("*")).getWsInboundPlugins();
			if (xic!=null) {
				monitor.subTask("Loading Inbound Plugins");
				for (int i = 0; i < xic.length; i++) {
					String name = xic[i].getName();
					TreeObject obj = new TreeObject(
							name,
							serverRoot,
							TreeObject.INBOUND_PLUGIN,
							new WSInboundPluginPK(name),
							null   //no storage to save space
					);
					inboundPlugins.addChild(obj);
				}
			}
			monitor.worked(1);
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			*/
			
			//Outbound Adaptors - deprecated
			TreeParent outboundAdaptors=null;
			if ("admin".equals(username)) {
				outboundAdaptors = new TreeParent("Outbound Adaptors",serverRoot,TreeObject.OUTBOUND_ADAPTOR,null,null);
				WSOutboundAdaptor[] xoa = port.getOutboundAdaptors(new WSRegexOutboundAdaptors("")).getWsOutboundAdaptors();
				if (xoa!=null) {
					monitor.subTask("Loading Outbound Adaptors");
					for (int i = 0; i < xoa.length; i++) {
						String name = xoa[i].getName();
						TreeObject obj = new TreeObject(
								name,
								serverRoot,
								TreeObject.OUTBOUND_ADAPTOR,
								new WSOutboundAdaptorPK(name),
								null   //no storage to save space
						);
						outboundAdaptors.addChild(obj);
					}
				}
				monitor.worked(1);
				if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			}
			
			/*
			//Outbound Plugins
			TreeParent outboundPlugins = new TreeParent("Outbound Plugins",serverRoot,TreeObject.OUTBOUND_PLUGIN,null,null);
			WSOutboundPlugin[] xoc = port.getOutboundPlugins(new WSRegexOutboundPlugins("*")).getWsOutboundPlugins();
			if (xoc!=null) {
				monitor.subTask("Loading Outbound Plugins");
				for (int i = 0; i < xoc.length; i++) {
					String name = xoc[i].getName();
					TreeObject obj = new TreeObject(
							name,
							serverRoot,
							TreeObject.OUTBOUND_PLUGIN,
							new WSOutboundPluginPK(name),
							null   //no storage to save space
					);
					outboundPlugins.addChild(obj);
				}
			}
			monitor.worked(1);
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			*/

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
			
			
			//Documents - deprecated
			TreeParent documents=null;
			if ("admin".equals(username)) {
				monitor.subTask("Loading Documents");
				documents = new TreeParent(
	                    "Documents",
	                    serverRoot,
	                    TreeObject.DOCUMENT,
	                    null,
	                    null
	             );
				//Documents are special - we show actions
				TreeObject searchDocuments = new TreeObject(
						"Search documents...",
						serverRoot,
						TreeObject._ACTION_,
						DocumentsSearchAction.class,
						null
				);
				documents.addChild(searchDocuments);
				monitor.worked(1);
				if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			}
			
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
//			serverRoot.addChild(sources);
			if ("admin".equals(username)) serverRoot.addChild(documents);
			if ("admin".equals(username)) serverRoot.addChild(inboundAdaptors);
//			serverRoot.addChild(inboundPlugins);
			serverRoot.addChild(views);
			if ("admin".equals(username)) serverRoot.addChild(outboundAdaptors);
//			serverRoot.addChild(outboundPlugins);
//			serverRoot.addChild(destinations);
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
