// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
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
import org.eclipse.ui.PlatformUI;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.mdm.repository.ui.dialogs.lock.LockedObjectDialog;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployToLastServerAction extends AbstractDeployAction {

    private static Logger log = Logger.getLogger(DeployToLastServerAction.class);

    public DeployToLastServerAction() {
        super(Messages.DeployToLastServerAction_deployToLastServer);

    }

    protected void doRun() {

        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().saveAllEditors(true);

        List<IRepositoryViewObject> viewObjs = getSelectedRepositoryViewObject();
        LockedObjectDialog dialog = new LockedObjectDialog(getShell(), Messages.DeployAction_lockedObjectMessage, viewObjs);
        if (dialog.needShowDialog() && dialog.open() == IDialogConstants.CANCEL_ID) {
            return;
        }
        IRepositoryViewObject viewObj = viewObjs.get(0);
        MDMServerDef currentServerDef = RepositoryResourceUtil.getLastServerDef(viewObj);
        //
        IStatus status = deploy(currentServerDef, viewObjs, ICommand.CMD_MODIFY);
        updateChangedStatus(status);
        if (status.isMultiStatus()) {
            showDeployStatus(status);
        }

        for (IRepositoryViewObject viewObject : viewObjs) {
            commonViewer.refresh(viewObject);
        }

    }

    @Override
    public boolean isVisible(IRepositoryViewObject viewObj) {
        MDMServerDef firstDef = null;
        for (Object obj : getSelectedObject()) {
            if (obj instanceof IRepositoryViewObject) {
                if (obj instanceof FolderRepositoryObject)
                    return false;
                MDMServerDef currentServerDef = RepositoryResourceUtil.getLastServerDef((IRepositoryViewObject) obj);
                if (currentServerDef == null)
                    return false;
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
