// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.providers;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import com.amalto.workbench.availablemodel.AvailableModelUtil;
import com.amalto.workbench.availablemodel.IAvailableModel;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.EXtentisObjects;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.utils.UserInfo;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSComponent;
import com.amalto.workbench.webservices.WSDataCluster;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSGetComponentVersion;
import com.amalto.workbench.webservices.WSGetCurrentUniverse;
import com.amalto.workbench.webservices.WSGetDataCluster;
import com.amalto.workbench.webservices.WSGetDataModel;
import com.amalto.workbench.webservices.WSGetMenu;
import com.amalto.workbench.webservices.WSGetMenuPKs;
import com.amalto.workbench.webservices.WSGetRoutingRule;
import com.amalto.workbench.webservices.WSGetRoutingRulePKs;
import com.amalto.workbench.webservices.WSGetStoredProcedure;
import com.amalto.workbench.webservices.WSGetTransformerV2;
import com.amalto.workbench.webservices.WSGetTransformerV2PKs;
import com.amalto.workbench.webservices.WSGetView;
import com.amalto.workbench.webservices.WSGetViewPKs;
import com.amalto.workbench.webservices.WSMenu;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSPing;
import com.amalto.workbench.webservices.WSRegexDataClusterPKs;
import com.amalto.workbench.webservices.WSRegexDataModelPKs;
import com.amalto.workbench.webservices.WSRegexStoredProcedure;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.WSStoredProcedure;
import com.amalto.workbench.webservices.WSStoredProcedurePK;
import com.amalto.workbench.webservices.WSTransformerV2;
import com.amalto.workbench.webservices.WSTransformerV2PK;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSUniverseXtentisObjectsRevisionIDs;
import com.amalto.workbench.webservices.WSVersion;
import com.amalto.workbench.webservices.WSView;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.XtentisPort;

public class XtentisServerObjectsRetriever implements IRunnableWithProgress {

    private static final Log log = LogFactory.getLog(XtentisServerObjectsRetriever.class);

    private ServerView view;

    private String serverName;

    private String endpointaddress;

    private String username;

    private String password;

    private String universe;

    private TreeParent serverRoot;

    private boolean isExistUniverse = true;

    private boolean retriveWSObject;

    public XtentisServerObjectsRetriever(String serverName, String endpointaddress, String username, String password,
            String universe, ServerView view) {
        this.serverName = serverName;
        this.endpointaddress = endpointaddress;
        this.username = username;
        this.password = password;
        this.universe = universe;
        this.view = view;
    }

    public boolean isExistUniverse() {
        return isExistUniverse;
    }

    public boolean isRetriveWSObject() {
        return retriveWSObject;
    }

    public void setRetriveWSObject(boolean retriveWSObject) {
        this.retriveWSObject = retriveWSObject;
    }

    public synchronized void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        try {
            if (password == null || password.length() == 0) {
                throw new Exception(Messages.XtentisServerObjectsRetriever_0);
            }
            monitor.beginTask(Messages.bind(Messages.XtentisServerObjectsRetriever_1, IConstants.TALEND), Messages.XtentisServerObjectsRetriever_3.equals(username) ? 12 : 9);
            // server
            serverRoot = new TreeParent(serverName, null, TreeObject._SERVER_, endpointaddress, ("".equals(universe) ? ""//$NON-NLS-1$//$NON-NLS-2$
                    : universe + "/") + username + ":" + (password == null ? "" : password));//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$

            // init load category
            monitor.subTask(Messages.XtentisServerObjectsRetriever_4);
            LocalTreeObjectRepository.getInstance().startUp(view, endpointaddress, username, password);
            LocalTreeObjectRepository.getInstance().switchOnListening();
            LocalTreeObjectRepository.getInstance().setLazySaveStrategy(true, serverRoot);
            monitor.worked(1);
            // Access to server and get port
            XtentisPort port = Util.getPort(new URL(endpointaddress), universe, username, password);
            port.ping(new WSPing(Messages.XtentisServerObjectsRetriever_5));// viewer user can't use studio

            monitor.worked(1);

            // fetch version info
            try {
                WSVersion version = port.getComponentVersion(new WSGetComponentVersion(WSComponent.DataManager, null));
                String versionStr = version.getMajor() + "." + version.getMinor() + "." + version.getRevision() + "_" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        + version.getBuild();
                log.info("Server version = " + versionStr); //$NON-NLS-1$
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            if (monitor.isCanceled())
                throw new InterruptedException(Messages.XtentisServerObjectsRetriever_6);

            monitor.subTask(Messages.XtentisServerObjectsRetriever_7);
            UserInfo user = new UserInfo();
            user.setUsername(username);
            user.setPassword(password);
            user.setServerUrl(endpointaddress);
            user.setUniverse(universe);

            serverRoot.setUser(user);

            // String uriPre=serverRoot.getEndpointIpAddress();

            // Data Models
            TreeParent models = new TreeParent(EXtentisObjects.DataMODEL.getDisplayName(), serverRoot, TreeObject.DATA_MODEL,
                    null, null);
            WSDataModelPK[] xdmPKs = null;
            try {
                xdmPKs = port.getDataModelPKs(new WSRegexDataModelPKs("")).getWsDataModelPKs(); //$NON-NLS-1$
            } catch (Exception e) {

                log.error(e.getMessage(), e);
            }
            if (xdmPKs != null) {
                monitor.subTask(Messages.XtentisServerObjectsRetriever_8);
                for (int i = 0; i < xdmPKs.length; i++) {
                    String name = xdmPKs[i].getPk();
                    if (!name.startsWith("XMLSCHEMA")) {//$NON-NLS-1$
                        WSDataModel wsobj = null;
                        if (retriveWSObject)
                            wsobj = port.getDataModel(new WSGetDataModel(xdmPKs[i]));
                        TreeObject obj = new TreeObject(name, serverRoot, TreeObject.DATA_MODEL, xdmPKs[i], wsobj);
                        models.addChild(obj);
                    }
                }
            }
            monitor.worked(1);
            if (monitor.isCanceled())
                throw new InterruptedException(Messages.XtentisServerObjectsRetriever_9);

            // DataClusters
            TreeParent dataClusters = new TreeParent(EXtentisObjects.DataCluster.getDisplayName(), serverRoot,
                    TreeObject.DATA_CLUSTER, null, null);
            WSDataClusterPK[] xdcPKs = null;
            try {
                xdcPKs = port.getDataClusterPKs(new WSRegexDataClusterPKs("")).getWsDataClusterPKs();//$NON-NLS-1$
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
            if (xdcPKs != null) {
                monitor.subTask(Messages.XtentisServerObjectsRetriever_10);
                for (int i = 0; i < xdcPKs.length; i++) {
                    String name = xdcPKs[i].getPk();
                    if (!("CACHE".equals(name))) { // FIXME: Hardcoded CACHE//$NON-NLS-1$
                        WSDataCluster wsObject = null;
                        try {
                            if (retriveWSObject)
                                wsObject = port.getDataCluster(new WSGetDataCluster(xdcPKs[i]));
                            TreeObject obj = new TreeObject(name, serverRoot, TreeObject.DATA_CLUSTER, xdcPKs[i], wsObject);
                            dataClusters.addChild(obj);
                        } catch (Exception e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                }
            }
            monitor.worked(1);
            if (monitor.isCanceled())
                throw new InterruptedException(Messages.XtentisServerObjectsRetriever_11);
            // event management
            TreeParent eventManagement = new TreeParent(EXtentisObjects.EventManagement.getDisplayName(), serverRoot,
                    TreeObject.EVENT_MANAGEMENT, null, null);

            // subscript engine
            TreeObject engine = new TreeObject(EXtentisObjects.SubscriptionEngine.getDisplayName(), serverRoot,
                    TreeObject.SUBSCRIPTION_ENGINE, null, null);
            eventManagement.addChild(engine);

            // transformer
            WSTransformerV2PK[] transformerPKs = null;
            try {
                transformerPKs = port.getTransformerV2PKs(new WSGetTransformerV2PKs("")).getWsTransformerV2PK();//$NON-NLS-1$
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
            TreeParent transformers = null;
            transformers = new TreeParent(EXtentisObjects.Transformer.getDisplayName(), serverRoot, TreeObject.TRANSFORMER, null,
                    null);
            eventManagement.addChild(transformers);
            if (transformerPKs != null) {
                monitor.subTask(Messages.XtentisServerObjectsRetriever_12);
                for (int i = 0; i < transformerPKs.length; i++) {
                    String id = transformerPKs[i].getPk();
                    WSTransformerV2 wsobject = null;
                    if (retriveWSObject)
                        wsobject = port.getTransformerV2(new WSGetTransformerV2(transformerPKs[i]));
                    TreeObject obj = new TreeObject(id, serverRoot, TreeObject.TRANSFORMER, new WSTransformerV2PK(id), wsobject);
                    transformers.addChild(obj);
                }
            }
            monitor.worked(1);

            // routing rule
            WSRoutingRulePK[] routingRulePKs = null;
            try {
                routingRulePKs = port.getRoutingRulePKs(new WSGetRoutingRulePKs("")).getWsRoutingRulePKs();//$NON-NLS-1$
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
            TreeParent rules = null;
            rules = new TreeParent(EXtentisObjects.RoutingRule.getDisplayName(), serverRoot, TreeObject.ROUTING_RULE, null, null);
            eventManagement.addChild(rules);
            if (routingRulePKs != null) {
                monitor.subTask(Messages.XtentisServerObjectsRetriever_13);
                for (int i = 0; i < routingRulePKs.length; i++) {
                    String id = routingRulePKs[i].getPk();
                    WSRoutingRule wsobject = null;
                    if (retriveWSObject)
                        wsobject = port.getRoutingRule(new WSGetRoutingRule(routingRulePKs[i]));
                    TreeObject obj = new TreeObject(id, serverRoot, TreeObject.ROUTING_RULE, new WSRoutingRulePK(id), wsobject);
                    rules.addChild(obj);
                }
            }
            monitor.worked(1);

            // add event management to serverRoot
            serverRoot.addChild(eventManagement);

            // Views
            TreeParent views = new TreeParent(EXtentisObjects.View.getDisplayName(), serverRoot, TreeObject.VIEW, null, null);
            WSViewPK[] viewPKs = null;
            try {
                viewPKs = port.getViewPKs((new WSGetViewPKs(""))).getWsViewPK();//$NON-NLS-1$
            } catch (Exception e) {
                log.error(e.getMessage(), e);

            }
            if (viewPKs != null) {
                monitor.subTask(Messages.XtentisServerObjectsRetriever_14);
                for (int i = 0; i < viewPKs.length; i++) {
                    String name = viewPKs[i].getPk();
                    WSView wsobject = null;
                    if (retriveWSObject)
                        wsobject = port.getView(new WSGetView(viewPKs[i]));
                    TreeObject obj = new TreeObject(name, serverRoot, TreeObject.VIEW, new WSViewPK(name), wsobject);
                    views.addChild(obj);
                }
            }
            monitor.worked(1);
            if (monitor.isCanceled())
                throw new InterruptedException(Messages.XtentisServerObjectsRetriever_15);

            // Stored Procedures
            TreeParent storedProcedures = new TreeParent(EXtentisObjects.StoredProcedure.getDisplayName(), serverRoot,
                    TreeObject.STORED_PROCEDURE, null, null);
            WSStoredProcedurePK[] spk = null;
            try {
                spk = port.getStoredProcedurePKs(new WSRegexStoredProcedure("")).getWsStoredProcedurePK();//$NON-NLS-1$
            } catch (Exception e) {

                log.error(e.getMessage(), e);
            }
            if (spk != null) {
                monitor.subTask(Messages.XtentisServerObjectsRetriever_16);
                for (int i = 0; i < spk.length; i++) {
                    String name = spk[i].getPk();
                    WSStoredProcedure wsobject = null;
                    if (retriveWSObject)
                        wsobject = port.getStoredProcedure(new WSGetStoredProcedure(spk[i]));
                    TreeObject obj = new TreeObject(name, serverRoot, TreeObject.STORED_PROCEDURE, new WSStoredProcedurePK(name),
                            wsobject);
                    storedProcedures.addChild(obj);
                }
            }
            monitor.worked(1);
            if (monitor.isCanceled())
                throw new InterruptedException(Messages.XtentisServerObjectsRetriever_17);

            // Service Configuration
            TreeObject serviceConfiguration = new TreeObject(EXtentisObjects.ServiceConfiguration.getDisplayName(), serverRoot,
                    TreeObject.SERVICE_CONFIGURATION, null, null);
            // serviceConfiguration.setXObject(false);
            monitor.worked(1);
            if (monitor.isCanceled())
                throw new InterruptedException(Messages.XtentisServerObjectsRetriever_18);

            // Menus
            WSMenuPK[] menuPKs = null;
            boolean hasMenus = true;
            try {
                menuPKs = port.getMenuPKs(new WSGetMenuPKs("*")).getWsMenuPK();//$NON-NLS-1$
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                // This server IS old
                hasMenus = false;
            }
            TreeParent menus = null;
            if (hasMenus) {
                menus = new TreeParent(EXtentisObjects.Menu.getDisplayName(), serverRoot, TreeObject.MENU, null, null);
                if (menuPKs != null) {
                    monitor.subTask(Messages.XtentisServerObjectsRetriever_19);
                    for (int i = 0; i < menuPKs.length; i++) {
                        String id = menuPKs[i].getPk();
                        WSMenu wsobject = null;
                        try {
                            if (retriveWSObject)
                                wsobject = port.getMenu(new WSGetMenu(menuPKs[i]));
                            TreeObject obj = new TreeObject(id, serverRoot, TreeObject.MENU, new WSMenuPK(id), wsobject);
                            menus.addChild(obj);
                        } catch (Exception e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                }
                monitor.worked(1);

                if (monitor.isCanceled())
                    throw new InterruptedException(Messages.XtentisServerObjectsRetriever_20);
            }
            // move Job from EE to CE.

            monitor.worked(1);

            serverRoot.addChild(models);
            serverRoot.addChild(dataClusters);

            serverRoot.addChild(views);
            serverRoot.addChild(storedProcedures);

            serverRoot.addChild(serviceConfiguration);

            // serverRoot.addChild(workflow);
            // serverRoot.addChild(resources);

            if (hasMenus)
                serverRoot.addChild(menus);

            // available models
            List<IAvailableModel> availablemodels = AvailableModelUtil.getAvailableModels();
            for (IAvailableModel model : availablemodels) {
                model.addTreeObjects(port, monitor, serverRoot);
            }

            WSUniverse wUuniverse = port.getCurrentUniverse(new WSGetCurrentUniverse());
            addRevision(wUuniverse);

            monitor.done();
        } catch (Exception e) {
            if (monitor.isCanceled())
                throw new InterruptedException(Messages.XtentisServerObjectsRetriever_21);

            log.error(e.getMessage(), e);
            throw new InvocationTargetException(new XtentisException(e.getLocalizedMessage()));
        }
    }// run

    /**
     * add revisionID to each treeobject
     * 
     * @param universe
     */
    private void addRevision(WSUniverse universe) {
        if (universe == null)
            return;
        if (Util.IsEnterPrise()) {
            WSUniverseXtentisObjectsRevisionIDs[] ids = universe.getXtentisObjectsRevisionIDs();
            for (TreeObject node : serverRoot.getChildren()) {
                if (node.getType() == TreeObject.EVENT_MANAGEMENT) {
                    resetDisplayName((TreeParent) node, ids);
                    continue;
                }
                EXtentisObjects object = EXtentisObjects.getXtentisObjexts().get(String.valueOf(node.getType()));
                if (object == null || !object.isRevision()) {
                    continue;
                }
                boolean isSet = false;
                for (WSUniverseXtentisObjectsRevisionIDs id : ids) {
                    if (id.getXtentisObjectName().equals(object.getName())) {
                        if (id.getRevisionID() != null && id.getRevisionID().length() > 0) {
                            node.setDisplayName(node.getDisplayName() + " ["//$NON-NLS-1$
                                    + id.getRevisionID().replaceAll("\\[", "").replaceAll("\\]", "").trim() + "]");//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$
                        } else {
                            node.setDisplayName(node.getDisplayName() + " [" + IConstants.HEAD + "]");//$NON-NLS-1$//$NON-NLS-2$
                        }
                        isSet = true;
                        break;
                    }
                }
                if (!isSet) {
                    node.setDisplayName(node.getDisplayName() + " [" + IConstants.HEAD + "]");//$NON-NLS-1$//$NON-NLS-2$
                }
            }
            String name = serverRoot.getDisplayName() + " ["//$NON-NLS-1$
                    + universe.getName().replaceAll("\\[", "").replaceAll("\\]", "").trim() + "]" + " " + username;//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
            serverRoot.setDisplayName(name);
        } else {
            String name = serverRoot.getDisplayName() + " " + username;//$NON-NLS-1$
            serverRoot.setDisplayName(name);
        }
    }

    public TreeParent getServerRoot() {
        return serverRoot;
    }

    private void resetDisplayName(TreeParent parent, WSUniverseXtentisObjectsRevisionIDs[] ids) {
        for (TreeObject node : parent.getChildren()) {
            EXtentisObjects object = EXtentisObjects.getXtentisObjexts().get(String.valueOf(node.getType()));
            if (object == null || !object.isRevision()) {
                continue;
            }
            boolean isSet = false;
            for (WSUniverseXtentisObjectsRevisionIDs id : ids) {
                if (id.getXtentisObjectName().equals(object.getName())) {
                    if (id.getRevisionID() != null && id.getRevisionID().length() > 0) {
                        node.setDisplayName(node.getDisplayName() + " ["//$NON-NLS-1$
                                + id.getRevisionID().replaceAll("\\[", "").replaceAll("\\]", "").trim() + "]");//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$
                    } else {
                        node.setDisplayName(node.getDisplayName() + " [" + IConstants.HEAD + "]");//$NON-NLS-1$//$NON-NLS-2$
                    }
                    isSet = true;
                    break;
                }
            }
            if (!isSet) {
                node.setDisplayName(node.getDisplayName() + " [" + IConstants.HEAD + "]");//$NON-NLS-1$//$NON-NLS-2$
            }
        }
    }
}
