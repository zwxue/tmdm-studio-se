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

        private final MDMServerObjectItem item;

        public MDMServerObjectItem getItem() {
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
        DeployStatus(int severity, String message, Throwable exception, MDMServerObjectItem item) {
            super(severity, RepositoryPlugin.PLUGIN_ID, message, exception);
            this.item = item;
        }

        public static DeployStatus getOKStatus(MDMServerObjectItem item) {
            return new DeployStatus(Status.OK, "", null, item); //$NON-NLS-1$
        }

        public static DeployStatus getErrorStatus(MDMServerObjectItem item, Throwable exception) {
            return new DeployStatus(Status.ERROR, exception.getMessage(), exception, item);
        }

        public static DeployStatus getErrorStatus(MDMServerObjectItem item, String errMsg) {
            return new DeployStatus(Status.ERROR, errMsg, null, item);
        }
    }

    private static Logger log = Logger.getLogger(DeployService.class);

    private static DeployService instance = new DeployService();

    private DeployService() {
    }

    public static DeployService getInstance() {
        return instance;
    }

    public DeployStatus deploy(XtentisPort port, ERepositoryObjectType type, MDMServerObject serverObj, Item item,
            IProgressMonitor monitor) {

        IInteractiveHandler handler = InteractiveService.findHandler(type);
        if (handler != null) {
            monitor.subTask("Deploying " + handler.getLabel() + "...");
            try {
                handler.deploy(port, item, serverObj);
                return DeployStatus.getOKStatus((MDMServerObjectItem) item);
            } catch (RemoteException e) {
                return DeployStatus.getErrorStatus((MDMServerObjectItem) item, e);
            }
        } else {
            log.error("Not found IInteractiveHandler for type:" + type);
            return DeployStatus.getErrorStatus((MDMServerObjectItem) item, "Not support for deploying " + serverObj.getName());
        }

    }

    public IStatus deploy(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs) {
        try {
            XtentisPort port = RepositoryWebServiceAdapter.getXtentisPort(serverDef);
            if (port != null) {
                IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
                DeployProcess runnable = new DeployProcess(port, viewObjs);
                progressService.run(true, true, runnable);
                return runnable.getStatus();
            }
        } catch (XtentisException e) {
            log.error(e.getMessage(), e);
        } catch (InvocationTargetException e) {
            log.error(e.getMessage(), e);
        } catch (InterruptedException e) {

        }
        return Status.CANCEL_STATUS;
    }

    class DeployProcess implements IRunnableWithProgress {

        private final XtentisPort port;

        private final List<IRepositoryViewObject> viewObjs;

        public DeployProcess(XtentisPort port, List<IRepositoryViewObject> viewObjs) {
            this.port = port;
            this.viewObjs = viewObjs;
        }

        MultiStatus mStatus = new MultiStatus(RepositoryPlugin.PLUGIN_ID, Status.OK, "", null); //$NON-NLS-1$

        public MultiStatus getStatus() {
            return this.mStatus;
        }

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            monitor.beginTask("Deploy to MDM Server", viewObjs.size());
            for (IRepositoryViewObject viewObj : viewObjs) {
                if (monitor.isCanceled())
                    return;
                ERepositoryObjectType type = viewObj.getRepositoryObjectType();
                Item item = viewObj.getProperty().getItem();
                if (item instanceof MDMServerObjectItem) {
                    DeployStatus deployStatus = deploy(port, type, ((MDMServerObjectItem) item).getMDMServerObject(), item,
                            monitor);
                    mStatus.add(deployStatus);
                    monitor.worked(1);
                }
            }
            monitor.done();
        }
    };

}
