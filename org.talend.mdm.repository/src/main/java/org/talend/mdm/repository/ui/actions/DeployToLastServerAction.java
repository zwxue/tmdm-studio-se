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
package org.talend.mdm.repository.ui.actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.mdm.repository.ui.dialogs.lock.LockedDirtyObjectDialog;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.exadapter.ExAdapterManager;
import com.amalto.workbench.service.MissingJarService;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployToLastServerAction extends AbstractDeployAction {

    IDeployActionExAdapter<DeployToAction> exAdapter;

    private static Logger log = Logger.getLogger(DeployToLastServerAction.class);

    public DeployToLastServerAction() {
        super(Messages.DeployToLastServerAction_deployToLastServer);
        exAdapter = ExAdapterManager.getAdapter(this, IDeployActionExAdapter.class);
    }

    @Override
    protected void doRun() {
        boolean checkMissingJar = MissingJarService.getInstance().checkMissingJar(true);
        if (!checkMissingJar) {
            return;
        }
        List<IRepositoryViewObject> viewObjs = getSelectedRepositoryViewObject();
        if (exAdapter != null) {
            viewObjs = exAdapter.showDependencyConfigDialog(viewObjs);
            if (viewObjs == null) {
                return;
            }
            // TO add match rule object
            viewObjs = getSelectedRepositoryViewObject(viewObjs);
            filterMatchRuleObjs(viewObjs);
        }
        LockedDirtyObjectDialog lockDirtyDialog = new LockedDirtyObjectDialog(getShell(),
                Messages.AbstractDeployAction_promptToSaveEditors, viewObjs);
        if (lockDirtyDialog.needShowDialog() && lockDirtyDialog.open() == IDialogConstants.CANCEL_ID) {
            return;
        }
        lockDirtyDialog.saveDirtyObjects();
        //
        MDMServerDef currentServerDef = getLastServer(viewObjs);
        // check last server
        if (!currentServerDef.isEnabled()) {
            MessageDialog.openWarning(Display.getDefault().getActiveShell(), null,
                    Messages.DeployService_CanNotDeployToDisabledServer);
            return;
        }
        // deploy
        IStatus status = deploy(currentServerDef, viewObjs, ICommand.CMD_MODIFY);
        if (status.getSeverity() != IStatus.CANCEL) {
            if (status.isMultiStatus()) {
                showDeployStatus(status);
            }
            DeployService.getInstance().updateChangedStatus(status, false);
            for (IRepositoryViewObject viewObject : viewObjs) {
                commonViewer.refresh(viewObject);
            }
        }
    }

    private MDMServerDef getLastServer(List<IRepositoryViewObject> viewObjs) {
        for (IRepositoryViewObject viewObj : viewObjs) {
            MDMServerDef serverDef = RepositoryResourceUtil.getLastServerDef(viewObj);
            if (serverDef != null) {
                return serverDef;
            }
        }
        return null;
    }

    @Override
    public boolean isVisible(IRepositoryViewObject viewObj) {
        MDMServerDef firstDef = null;
        for (Object obj : getSelectedObject()) {
            if (obj instanceof IRepositoryViewObject) {
                if (obj instanceof FolderRepositoryObject) {
                    return false;
                }
                MDMServerDef currentServerDef = RepositoryResourceUtil.getLastServerDef((IRepositoryViewObject) obj);
                if (currentServerDef == null) {
                    return false;
                }
                if (firstDef == null) {
                    firstDef = currentServerDef;
                } else {
                    if (!isSameServer(firstDef, currentServerDef)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isSameServer(MDMServerDef s1, MDMServerDef s2) {
        return s1.getHost().equals(s2.getHost()) && s1.getPort().equals(s2.getPort());
    }
}
