// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.service;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.plugin.RepositoryPlugin;

import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployService {

    public static class DeployStatus extends Status {

        private final Item item;

        public Item getItem() {
            return this.item;
        }

        /**
         * DOC hbhong DeployStatus constructor comment.
         * 
         * @param severity
         * @param pluginId
         * @param message
         * @param exception
         */
        DeployStatus(int severity, String message, Throwable exception, Item item) {
            super(severity, RepositoryPlugin.PLUGIN_ID, message, exception);
            this.item = item;
        }

        public static DeployStatus getOKStatus(Item item, String msg) {
            return new DeployStatus(Status.OK, msg, null, item);
        }

        public static DeployStatus getInfoStatus(Item item, String msg) {
            return new DeployStatus(Status.INFO, msg, null, item);
        }

        public static DeployStatus getErrorStatus(Item item, Throwable exception) {
            return new DeployStatus(Status.ERROR, exception.getMessage(), exception, item);
        }

        public static DeployStatus getErrorStatus(Item item, String errMsg) {
            return new DeployStatus(Status.ERROR, errMsg, null, item);
        }

        public static DeployStatus getErrorStatus(Item item, String errMsg, Throwable exception) {
            return new DeployStatus(Status.ERROR, errMsg, exception, item);
        }

    }

    private static Logger log = Logger.getLogger(DeployService.class);

    private static DeployService instance = new DeployService();

    private DeployService() {
    }

    public static DeployService getInstance() {
        return instance;
    }

    private DeployStatus deployMDM(MDMServerDef serverDef, XtentisPort port, ERepositoryObjectType type,
            MDMServerObject serverObj, Item item, IProgressMonitor monitor) {
        XtentisPort deployPort = port;
        MDMServerDef lastServerDef = serverDef;
        IInteractiveHandler handler = InteractiveService.findHandler(type);
        if (handler != null) {
            String typeLabel = handler.getLabel();
            monitor.subTask("Deploying " + typeLabel + "...");
            try {
                if (port == null) {
                    lastServerDef = ((MDMServerObjectItem) item).getMDMServerObject().getLastServerDef();
                    deployPort = RepositoryWebServiceAdapter.getXtentisPort(lastServerDef);
                }

                if (handler.deployMDM(lastServerDef, deployPort, item, serverObj))
                    return DeployStatus.getOKStatus(item, "Success to deploy " + typeLabel + " \"" + serverObj.getName() + "\"");
                else
                    return DeployStatus.getInfoStatus(item, "Skip to deploy " + typeLabel + " \"" + serverObj.getName() + "\"");
            } catch (RemoteException e) {
                return DeployStatus.getErrorStatus(item, "Fail to deploy " + typeLabel + " \"" + serverObj.getName()
                        + "\",Cause is:" + e.getMessage(), e);
            } catch (XtentisException e) {
                return DeployStatus.getErrorStatus(item, "Fail to deploy " + typeLabel + " \"" + serverObj.getName()
                        + "\",Cause is:" + e.getMessage(), e);
            }
        } else {
            log.error("Not found IInteractiveHandler for type:" + type);
            return DeployStatus.getErrorStatus(item, "Not support for deploying \"" + serverObj.getName() + "\"");
        }

    }

    private IStatus deployJob(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs, IProgressMonitor monitor) {

        IInteractiveHandler handler = InteractiveService.findHandler(ERepositoryObjectType.PROCESS);
        if (handler != null) {
            String typeLabel = handler.getLabel();
            monitor.subTask("Deploying " + typeLabel + "...");
            try {
                return handler.deployOther(serverDef, viewObjs);
            } catch (RemoteException e) {
                return DeployStatus.getErrorStatus(null, "Fail to deploy \"" + typeLabel + "\",Cause is:" + e.getMessage(), e);
            }
        } else {
            log.error("Not found IInteractiveHandler for type:Job");
            return DeployStatus.getErrorStatus(null, "Not support for deploying \"Job\"");
        }

    }

    public IStatus deploy(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs) {
        try {
            IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
            DeployProcess runnable = new DeployProcess(serverDef, viewObjs);
            progressService.run(true, true, runnable);
            return runnable.getStatus();
        } catch (InvocationTargetException e) {
            log.error(e.getMessage(), e);
        } catch (InterruptedException e) {

        }
        return Status.CANCEL_STATUS;
    }

    class DeployProcess implements IRunnableWithProgress {

        private final List<IRepositoryViewObject> viewObjs;

        private final MDMServerDef serverDef;

        public DeployProcess(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs) {
            this.serverDef = serverDef;

            this.viewObjs = viewObjs;
        }

        MultiStatus mStatus = new MultiStatus(RepositoryPlugin.PLUGIN_ID, Status.OK, "", null); //$NON-NLS-1$

        public MultiStatus getStatus() {
            return this.mStatus;
        }

        private void runMDMDeployProcess(List<IRepositoryViewObject> viewObjs, IProgressMonitor monitor) {

            try {
                XtentisPort port = RepositoryWebServiceAdapter.getXtentisPort(serverDef);
                for (IRepositoryViewObject viewObj : viewObjs) {
                    if (monitor.isCanceled())
                        return;
                    ERepositoryObjectType type = viewObj.getRepositoryObjectType();
                    Item item = viewObj.getProperty().getItem();
                    DeployStatus deployStatus = deployMDM(serverDef, port, type,
                            ((MDMServerObjectItem) item).getMDMServerObject(), item, monitor);
                    mStatus.add(deployStatus);
                    monitor.worked(1);
                }
            } catch (XtentisException e) {
                log.error(e.getMessage(), e);
            }
        }

        private void runOtherDeployProcess(List<IRepositoryViewObject> viewObjs, IProgressMonitor monitor) {
            if (monitor.isCanceled())
                return;
            if (viewObjs == null || viewObjs.isEmpty())
                return;
            IStatus deployStatus = deployJob(serverDef, viewObjs, monitor);
            if (deployStatus != null) {
                if (deployStatus.isMultiStatus()) {
                    mStatus.addAll(deployStatus);
                } else {
                    mStatus.add(deployStatus);
                }
            }
            monitor.worked(viewObjs.size());
        }

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            monitor.beginTask("Deploy to MDM Server", viewObjs.size());
            // distribute
            List<IRepositoryViewObject> mdmViewObjs = new LinkedList<IRepositoryViewObject>();
            List<IRepositoryViewObject> otherViewObjs = new LinkedList<IRepositoryViewObject>();
            for (IRepositoryViewObject viewObj : viewObjs) {
                Item item = viewObj.getProperty().getItem();
                if (item instanceof MDMServerObjectItem) {
                    mdmViewObjs.add(viewObj);
                } else {
                    // only job
                    otherViewObjs.add(viewObj);
                }
            }

            // MDM deploy
            runMDMDeployProcess(mdmViewObjs, monitor);
            // other deploy
            runOtherDeployProcess(otherViewObjs, monitor);

            monitor.done();
        }
    };

}
