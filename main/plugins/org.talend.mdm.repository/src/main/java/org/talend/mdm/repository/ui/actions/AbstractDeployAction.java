// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.dialogs.deploy.DeployStatusDialog;
import org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public abstract class AbstractDeployAction extends AbstractRepositoryAction {

    private static final ImageDescriptor DEPLOY_IMG = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "/icons/deploy.png"); //$NON-NLS-1$

    protected AbstractDeployAction(String text) {
        super(text);
        setImageDescriptor(DEPLOY_IMG);
    }

    protected IStatus deploy(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs, int defaultCmdType) {
        if (doCheckServerConnection(serverDef)) {
            return DeployService.getInstance().deploy(serverDef, viewObjs, defaultCmdType);
        } else {
            return Status.CANCEL_STATUS;
        }
    }

    protected boolean doCheckServerConnection(MDMServerDef serverDef) {
        return RepositoryResourceUtil.checkServerConnection(getShell(), serverDef);
    }

    protected void showDeployStatus(IStatus status) {
        int count = 0;
        if (status.isMultiStatus()) {
            for (IStatus child : status.getChildren()) {
                if (child.isMultiStatus()) {
                    count += child.getChildren().length;
                } else {
                    count++;
                }
            }
        }

        MultiStatusDialog dialog = new DeployStatusDialog(getShell(), status);
        dialog.open();

    }

    @Override
    public String getGroupName() {
        return GROUP_DEPLOY;
    }

    protected void updateChangedStatus(IStatus status) {
        DeployService.getInstance().updateChangedStatus(status);
    }

    protected void updateLastServer(IStatus status, IProgressMonitor monitor) {
        DeployService.getInstance().updateLastServer(status, monitor);
        refreshDeployedViewObjects();
    }

    protected void refreshDeployedViewObjects() {
        List<IRepositoryViewObject> viewObjs = getSelectedRepositoryViewObject();
        for (IRepositoryViewObject viewObj : viewObjs) {
            commonViewer.refresh(viewObj);
        }
    }

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    protected List<IRepositoryViewObject> getSelectedRepositoryViewObject() {
        List<IRepositoryViewObject> viewObjs = new LinkedList<IRepositoryViewObject>();
        for (Object obj : getSelectedObject()) {
            if (obj instanceof IRepositoryViewObject) {
                IRepositoryViewObject viewObject = (IRepositoryViewObject) obj;
                viewObjs.add(viewObject);
                viewObjs.addAll(getAssociatedObjects(viewObject));
            }
        }
        return viewObjs;
    }

    protected List<IRepositoryViewObject> getAssociatedObjects(IRepositoryViewObject viewObject) {
        return DeployService.getInstance().getAssociatedObjects(viewObject);
    }

}
