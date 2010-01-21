package com.amalto.workbench.providers;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import com.amalto.workbench.availablemodel.AvailableModelUtil;
import com.amalto.workbench.availablemodel.IAvailableModel;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.EXtentisObjects;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.ResourcesUtil;
import com.amalto.workbench.utils.UserInfo;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSGetCurrentUniverse;
import com.amalto.workbench.webservices.WSGetMenuPKs;
import com.amalto.workbench.webservices.WSGetRolePKs;
import com.amalto.workbench.webservices.WSGetRoutingRulePKs;
import com.amalto.workbench.webservices.WSGetSynchronizationPlanPKs;
import com.amalto.workbench.webservices.WSGetTransformerV2PKs;
import com.amalto.workbench.webservices.WSGetUniversePKs;
import com.amalto.workbench.webservices.WSGetViewPKs;
import com.amalto.workbench.webservices.WSMDMJob;
import com.amalto.workbench.webservices.WSMDMNULL;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSPing;
import com.amalto.workbench.webservices.WSRegexDataClusterPKs;
import com.amalto.workbench.webservices.WSRegexDataModelPKs;
import com.amalto.workbench.webservices.WSRegexStoredProcedure;
import com.amalto.workbench.webservices.WSRolePK;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.WSStoredProcedurePK;
import com.amalto.workbench.webservices.WSSynchronizationPlanPK;
import com.amalto.workbench.webservices.WSTransformerV2PK;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.WSUniverseXtentisObjectsRevisionIDs;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.XtentisPort;

public class XtentisServerObjectsRetriever implements IRunnableWithProgress {

	//ServerView view;
	private String endpointaddress;
	private String username;
	private String password;
	private String universe;
    private TreeParent serverRoot;
	
    private boolean isExistUniverse=true;
	public XtentisServerObjectsRetriever(String endpointaddress, String username, String password, String universe) {
		this.endpointaddress = endpointaddress;
		this.username = username;
		this.password = password;
		this.universe=universe;
	}
	
	public boolean isExistUniverse() {
		return isExistUniverse;
	}

	public synchronized void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		try {
			monitor.beginTask("Loading "+IConstants.TALEND+" Server Objects", "admin".equals(username)? 12 : 9);
			//Access to server and get port
			XtentisPort port = Util.getPort(new URL(endpointaddress), universe, username, password);
			port.ping(new WSPing("Hello MDM!"));
			monitor.worked(1);
			
			
			String displayName=endpointaddress;
			//fetch version info
//			try {
//				WSVersion version = port.getComponentVersion(new WSGetComponentVersion(WSComponent.DataManager,null));				
//				displayName += " (v"+version.getMajor()+"."+version.getMinor()+"."+version.getRevision()+"_"+version.getBuild()+")";	
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			WSUniverse wUuniverse=null;
			wUuniverse=port.getCurrentUniverse(new WSGetCurrentUniverse());
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");		
		
			//server
			serverRoot = new TreeParent(
                    displayName,
                    null,
                    TreeObject._SERVER_,
                    endpointaddress,
                    ("".equals(universe)? "" : universe+"/")+username+":"+(password==null?"":password)
            );       
			
			monitor.subTask("Accessing server....");
			UserInfo user=new UserInfo();
			user.setUsername(username);
			user.setPassword(password);
			user.setServerUrl(endpointaddress);
			user.setUniverse(universe);
			user.setWsUuniverse(wUuniverse);

			serverRoot.setUser(user);
			
//			String uriPre=serverRoot.getEndpointIpAddress();
			
			//available models
			List<IAvailableModel> availablemodels=AvailableModelUtil.getAvailableModels();
			for(IAvailableModel model: availablemodels){
				model.addTreeObjects(port,monitor, serverRoot);
			}
			//Data Models
			TreeParent models = new TreeParent(EXtentisObjects.DataMODEL.getDisplayName(),serverRoot,TreeObject.DATA_MODEL,null,null);						
			WSDataModelPK[] xdmPKs = null;
			try{
				xdmPKs=port.getDataModelPKs(new WSRegexDataModelPKs("")).getWsDataModelPKs();
			}catch(Exception e){e.printStackTrace();}
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
			
			/*//Resources
				//add data models
			TreeParent resources = null;
			try{
				resources=new TreeParent(EXtentisObjects.Resources.getDisplayName(),serverRoot,TreeObject.RESOURCES,null,null);			
			if (xdmPKs != null) {
					TreeParent datamodelResources =	new TreeParent(
									EXtentisObjects.DataMODELRESOURCE.getDisplayName(),
									serverRoot,
									TreeObject.DATA_MODEL_RESOURCE,
									null,
									null   //no storage to save space
							 );
							 resources.addChild(datamodelResources);
				monitor.subTask("Loading Resources for Data Models");
				for (int i = 0; i < xdmPKs.length; i++) {
					String name = xdmPKs[i].getPk();
					if (!name.startsWith("XMLSCHEMA")) {
							TreeObject obj = new TreeObject(
									name,
									serverRoot,
									TreeObject.DATA_MODEL_RESOURCE,
									xdmPKs[i],
									null   //no storage to save space
							);
							datamodelResources.addChild(obj);
					}
				}
			}
				//add datamodeltypes
			if (xdmPKs != null) {
					TreeParent datamodelTypesResources =	new TreeParent(
									EXtentisObjects.DataMODELTYPESRESOURCE.getDisplayName(),
									serverRoot,
									TreeObject.DATA_MODEL_TYPES_RESOURCE,
									null,
									null   //no storage to save space
							 );
							 resources.addChild(datamodelTypesResources);
				monitor.subTask("Loading Resources for Data Model Types");
				for (int i = 0; i < xdmPKs.length; i++) {
					String name = xdmPKs[i].getPk();
					if (!name.startsWith("XMLSCHEMA")) {
							TreeObject obj = new TreeObject(
									name,
									serverRoot,
									TreeObject.DATA_MODEL_TYPES_RESOURCE,
									xdmPKs[i],
									null   //no storage to save space
							);
							datamodelTypesResources.addChild(obj);
					}
				}
			}
			
			//add custom types
				TreeParent customTypesResources =	new TreeParent(
						EXtentisObjects.CUSTOMTYPESRESOURCE.getDisplayName(),
						serverRoot,
						TreeObject.CUSTOM_TYPES_RESOURCE,
						null,
						null   //no storage to save space
				);
				resources.addChild(customTypesResources);
				monitor.subTask("Loading Resources for Custom Types");
				List<String> cusNameList=ResourcesUtil.getResourcesNameListFromURI(uriPre+TreeObject.CUSTOM_TYPES_URI);
//				List<String> cusNameList=new ArrayList<String>();
				for (int i = 0; i < cusNameList.size(); i++) {
					String name = cusNameList.get(i);
					if (!name.startsWith("XMLSCHEMA")) {
						TreeObject obj = new TreeObject(
								name,
								serverRoot,
								TreeObject.CUSTOM_TYPES_RESOURCE,
								null,
								null   //no storage to save space
						);
						customTypesResources.addChild(obj);
					}
				}
			//add pictures
					TreeParent picturesResources =	new TreeParent(
									EXtentisObjects.PICTURESRESOURCE.getDisplayName(),
									serverRoot,
									TreeObject.PICTURES_RESOURCE,
									null,
									null   //no storage to save space
							 );
							 resources.addChild(picturesResources);
				monitor.subTask("Loading Resources for Pictures");
				List<String> picNameList=ResourcesUtil.getResourcesNameListFromURI(uriPre+TreeObject.PICTURES_URI);

				for (int i = 0; i < picNameList.size(); i++) {
					String name = picNameList.get(i);
							TreeObject obj = new TreeObject(
									name,
									serverRoot,
									TreeObject.PICTURES_RESOURCE,
									null,
									null   //no storage to save space
							);
							picturesResources.addChild(obj);
				}
			
			monitor.worked(1);
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			}catch(Exception e){e.printStackTrace();}*/
			//DataClusters
			TreeParent dataClusters = new TreeParent(EXtentisObjects.DataCluster.getDisplayName(),serverRoot,TreeObject.DATA_CLUSTER,null,null);			
			WSDataClusterPK[] xdcPKs = null;
			try{
				xdcPKs=port.getDataClusterPKs(new WSRegexDataClusterPKs("")).getWsDataClusterPKs();			
			}catch(Exception e){e.printStackTrace();}
			if (xdcPKs != null) {
				monitor.subTask("Loading Data Containers");
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
			//routing rule
			WSRoutingRulePK[] routingRulePKs = null;
			boolean hasRoutingRules = true;
			try {
				routingRulePKs = port.getRoutingRulePKs(new WSGetRoutingRulePKs("")).getWsRoutingRulePKs();
			} catch (Exception e) {
				System.out.println("NO ROUTING RULES");
				hasRoutingRules = false;
			}
			TreeParent rules = null;
			if (hasRoutingRules) {
				rules = new TreeParent(EXtentisObjects.RoutingRule.getDisplayName(),serverRoot,TreeObject.ROUTING_RULE,null,null);
				if (routingRulePKs!=null) {
					monitor.subTask("Loading Triggers");
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
				serverRoot.addChild(rules);
				monitor.worked(1);
			}
			//subscript engine
			TreeObject  engine = new TreeObject(
					EXtentisObjects.SubscriptionEngine.getDisplayName(),
					serverRoot,
					TreeObject.SUBSCRIPTION_ENGINE,
					null,
					null
			);
			serverRoot.addChild(engine);
			
			//transformer
			WSTransformerV2PK[] transformerPKs = null;
			boolean hasTransformers = true;
			try {
				
				transformerPKs = port.getTransformerV2PKs(new WSGetTransformerV2PKs("")).getWsTransformerV2PK();
			} catch (Exception e) {
				System.out.println("No Transformers");
				// This server IS old
				hasTransformers = false;
			}
			TreeParent transformers = null;
			if (hasTransformers) {
				transformers = new TreeParent(EXtentisObjects.Transformer.getDisplayName(),serverRoot,TreeObject.TRANSFORMER,null,null);
				if (transformerPKs!=null) {
					monitor.subTask("Loading Transfomers");
					for (int i = 0; i < transformerPKs.length; i++) {
						String id =transformerPKs[i].getPk();
						TreeObject obj = new TreeObject(
								id,
								serverRoot,
								TreeObject.TRANSFORMER,
								new WSTransformerV2PK(id),
								null   //no storage to save space
						);
						transformers.addChild(obj);
					}
				}
				serverRoot.addChild(transformers);
				monitor.worked(1);
			}
			//Views
			TreeParent views = new TreeParent(EXtentisObjects.View.getDisplayName(),serverRoot,TreeObject.VIEW,null,null);
			WSViewPK[] viewPKs = null;
			try{
				viewPKs=port.getViewPKs((new WSGetViewPKs(""))).getWsViewPK();
			}catch(Exception e){e.printStackTrace();}
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
			TreeParent storedProcedures = new TreeParent(EXtentisObjects.StoredProcedure.getDisplayName(),serverRoot,TreeObject.STORED_PROCEDURE,null,null);
			WSStoredProcedurePK[] spk = null;
			try{
				spk=port.getStoredProcedurePKs(new WSRegexStoredProcedure("")).getWsStoredProcedurePK();
			}catch(Exception e){e.printStackTrace();}
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
			
			//Service Configuration
			TreeObject serviceConfiguration=new TreeObject(
					EXtentisObjects.ServiceConfiguration.getDisplayName(),
					serverRoot,
					TreeObject.SERVICE_CONFIGURATION,
					null,
					null);
			//serviceConfiguration.setXObject(false);
			monitor.worked(1);
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			
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
				menus = new TreeParent(EXtentisObjects.Menu.getDisplayName(),serverRoot,TreeObject.MENU,null,null);
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
						
			serverRoot.addChild(serviceConfiguration);
			//serverRoot.addChild(workflow);
//			serverRoot.addChild(resources);

			if (hasMenus) serverRoot.addChild(menus);
			
			addRevision(wUuniverse);
			
			monitor.done();			
		} catch (Exception e) {
			if (monitor.isCanceled()) throw new InterruptedException("User Cancel");
			e.printStackTrace();
			throw new InvocationTargetException(new XtentisException(e.getLocalizedMessage()));
		}		
	}//run
	
	/**
	 * add revisionID to each treeobject
	 * @param universe
	 */
	private void addRevision(WSUniverse universe){
		if(universe==null) return;
		if(Util.IsEnterPrise()) {
			WSUniverseXtentisObjectsRevisionIDs[] ids=universe.getXtentisObjectsRevisionIDs();
			for(TreeObject node: serverRoot.getChildren()){
				EXtentisObjects object=EXtentisObjects.getXtentisObjexts().get(String.valueOf(node.getType()));
				if(object==null || !object.isRevision()){
					continue;
				}
				boolean isSet=false;
				for(WSUniverseXtentisObjectsRevisionIDs id: ids){					
					if(id.getXtentisObjectName().equals(object.getName())){
						if(id.getRevisionID()!=null && id.getRevisionID().length()>0){
							node.setDisplayName(node.getDisplayName() + " ["+id.getRevisionID().replaceAll("\\[", "").replaceAll("\\]", "").trim() +"]");
						}else{
							node.setDisplayName(node.getDisplayName() + " ["+IConstants.HEAD+"]");
						}
						isSet=true;
						break;
					}
				}
				if(!isSet){
					node.setDisplayName(node.getDisplayName() + " ["+IConstants.HEAD+"]");
				}
			}	
			String name = serverRoot.getDisplayName()+" ["+universe.getName().replaceAll("\\[", "").replaceAll("\\]", "").trim()+"]" +" " +username;
			serverRoot.setDisplayName(name);		
		}else {
			String name = serverRoot.getDisplayName()+" " +username;
			serverRoot.setDisplayName(name);					
		}
	}
    public TreeParent getServerRoot() {
        return serverRoot;
    }
}
