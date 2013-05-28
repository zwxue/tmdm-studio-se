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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.command.deploy.AbstractDeployCommand;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.core.service.IModelValidationService;
import org.talend.mdm.repository.core.service.IModelValidationService.IModelValidateResult;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.dialogs.deploy.DeployAllDialog;
import org.talend.mdm.repository.ui.dialogs.lock.LockedDirtyObjectDialog;
import org.talend.mdm.repository.utils.EclipseResourceManager;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployAllAction extends AbstractDeployAction {

    private final boolean isDeployAll;

    private static final ImageDescriptor DEPLOY_IMG = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "/icons/server_export.png"); //$NON-NLS-1$

    private List<IRepositoryViewObject> deployViewObject;

    public DeployAllAction(boolean isDeployAll) {
        super(Messages.DeployAllAction_label);
        this.isDeployAll = isDeployAll;
        setImageDescriptor(DEPLOY_IMG);
    }

    @Override
    protected void doRun() {
        if (isDeployAll) {
            runWithType(null);
        } else {
            List<Object> selectedObject = getSelectedObject();
            if (!selectedObject.isEmpty()) {
                Object object = selectedObject.get(0);
                if (object instanceof IRepositoryViewObject) {
                    ERepositoryObjectType type = ((IRepositoryViewObject) object).getRepositoryObjectType();
                    runWithType(type);
                }
            }
        }

    }

    public void runWithType(ERepositoryObjectType type) {

        DeployAllDialog dialog = new DeployAllDialog(getShell(), type);
        if (dialog.open() == IDialogConstants.OK_ID) {
            List<AbstractDeployCommand> selectededCommands = dialog.getSelectedCommands();
            if (selectededCommands.size() >= 0) {
                DeployService deployService = DeployService.getInstance();
                deployViewObject = deployService.getDeployViewObject(selectededCommands);

                // validate object
                IModelValidateResult validateResult = deployService.validateModel(deployViewObject);
                int selectedButton = validateResult.getSelectedButton();
                if (selectedButton == IModelValidationService.BUTTON_CANCEL) {
                    return;
                }
                List<IRepositoryViewObject> validObjects = validateResult.getValidObjects(selectedButton);
                List<IRepositoryViewObject> invalidObjects = validateResult.getInvalidObjects(selectedButton);
                deployService.removeInvalidCommands(invalidObjects, selectededCommands);
                // save editors
                LockedDirtyObjectDialog lockDirtyDialog = new LockedDirtyObjectDialog(getShell(),
                        Messages.AbstractDeployAction_promptToSaveEditors, validObjects);
                if (lockDirtyDialog.needShowDialog() && lockDirtyDialog.open() == IDialogConstants.CANCEL_ID) {
                    return;
                }
                lockDirtyDialog.saveDirtyObjects();

                MDMServerDef serverDef = dialog.getServerDef();

                IStatus status = deployService.runCommands(selectededCommands, serverDef);
                // add canceled object to status
                deployService.generateCancelDeployStatus(status, invalidObjects);
                //
                updateChangedStatus(status);
                if (status.isMultiStatus()) {
                    showDeployStatus(status);
                }
                updateLastServer(status, new NullProgressMonitor());
            }
        }
    }

    @Override
    protected void refreshDeployedViewObjects() {
        if (deployViewObject.size() > 0) {
            for (IRepositoryViewObject viewObj : deployViewObject) {
                IRepositoryViewObject iRepositoryViewObject = ContainerCacheService.get(viewObj.getProperty());
                commonViewer.refresh(iRepositoryViewObject);
            }
        }
    }

    protected void refreshParent(Object object) {
        if (object instanceof IRepositoryViewObject) {
            IRepositoryViewObject parent = ContainerCacheService.getParent((IRepositoryViewObject) object);
            if (parent != null) {
                commonViewer.refresh(parent);
            }
        }
    }
}
