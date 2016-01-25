// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.ui.dialogs.lock.LockedDirtyObjectDialog;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployToAction extends AbstractDeployAction {

    public DeployToAction() {
        super(Messages.DeployToAction_deployTo);

    }

    @Override
    protected void doRun() {

        List<IRepositoryViewObject> viewObjs = getSelectedRepositoryViewObject();

        SelectServerDefDialog dialog = getSelectServerDefDialog(viewObjs);

        if (dialog.open() == IDialogConstants.OK_ID) {
            // save editors
            LockedDirtyObjectDialog lockDirtyDialog = new LockedDirtyObjectDialog(getShell(),
                    Messages.AbstractDeployAction_promptToSaveEditors, viewObjs);
            if (lockDirtyDialog.needShowDialog() && lockDirtyDialog.open() == IDialogConstants.CANCEL_ID) {
                return;
            }
            lockDirtyDialog.saveDirtyObjects();
            // deploy
            MDMServerDef serverDef = dialog.getSelectedServerDef();

            IStatus status = deploy(serverDef, viewObjs, ICommand.CMD_MODIFY);
            if (status.getSeverity() != IStatus.CANCEL) {
                updateChangedStatus(status);
                if (status.isMultiStatus()) {
                    showDeployStatus(status);
                }
                updateLastServer(status, new NullProgressMonitor());
            }
        }

    }

    private SelectServerDefDialog getSelectServerDefDialog(List<IRepositoryViewObject> viewObjs) {
        SelectServerDefDialog dialog = new SelectServerDefDialog(getShell());

        initializeSelection(viewObjs, dialog);
        return dialog;
    }

    /**
     * set the default selection in SelectServerDefDialog
     * 
     * @param viewObjs current selected view objects
     * @param dialog
     */
    private void initializeSelection(List<IRepositoryViewObject> viewObjs, SelectServerDefDialog dialog) {
        MDMServerDef defServer = null;
        for (IRepositoryViewObject viewObject : viewObjs) {
            MDMServerDef tmpServer = RepositoryResourceUtil.getLastServerDef(viewObject);
            if (defServer == null) {
                defServer = tmpServer;
            } else if (tmpServer != null && !isSameMDMServerDef(defServer, tmpServer)) {
                defServer = null;
                break;
            }
        }

        dialog.create();
        dialog.setSelectServer(defServer);
    }

    private boolean isSameMDMServerDef(MDMServerDef aServerDef, MDMServerDef bServerDef) {
        if (aServerDef == null && bServerDef == null) {
            return true;
        }

        if (aServerDef != null && bServerDef != null) {
            if (aServerDef.getName().equals(bServerDef.getName())
            // && aServerDef.getUrl().equals(bServerDef.getUrl())
            ) {
                return true;
            }
        }

        return false;
    }
}
