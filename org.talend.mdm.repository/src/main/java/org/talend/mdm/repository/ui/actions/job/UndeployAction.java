// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions.job;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.bridge.AbstractBridgeRepositoryAction;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.CommandStack;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.dialogs.deploy.DeployStatusDialog;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

/**
 * created by changguopiao on 2013-7-18 Detailled comment
 * 
 */
public class UndeployAction extends AbstractBridgeRepositoryAction {

    private static final ImageDescriptor DEPLOY_IMG = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "/icons/undeploy.png"); //$NON-NLS-1$

    /**
     * DOC changguopiao UnloadAndDeleteAction constructor comment.
     * 
     * @param text
     */
    public UndeployAction() {
        super(Messages.UndeployAction);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#getImageDescriptor()
     */
    @Override
    public ImageDescriptor getImageDescriptor() {
        return DEPLOY_IMG;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.AbstractRepositoryAction#getGroupName()
     */
    @Override
    public String getGroupName() {
        return GROUP_DEPLOY;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.bridge.AbstractBridgeRepositoryAction#doRun()
     */
    @Override
    protected void doRun() {
        DeployService deployService = DeployService.getInstance();
        CommandManager cmanager = CommandManager.getInstance();
        List<IRepositoryViewObject> viewObjs = getSelectedRepositoryViewObject();

        SelectServerDefDialog dialog = getServerDefDialog(viewObjs);

        if (dialog.open() == IDialogConstants.OK_ID) {
            for (IRepositoryViewObject obj : viewObjs) {
                cmanager.pushCommand(ICommand.CMD_NOP, obj);
            }
            IStatus status = deployService.deploy(dialog.getSelectedServerDef(), viewObjs, ICommand.CMD_DELETE);
            IProgressMonitor monitor = new NullProgressMonitor();
            deployService.updateChangedStatus(status);
            if (status.isMultiStatus()) {
                new DeployStatusDialog(getShell(), status).open();
            }
            deployService.updateLastServer(status, monitor);
            for (IRepositoryViewObject viewObj : viewObjs) {
                String id = viewObj.getId();
                CommandStack stack = cmanager.findCommandStack(id);
                if (stack != null) {
                    List<ICommand> commands = stack.getCommands(ICommand.PHASE_RESTORE);
                    for (ICommand cmd : commands) {
                        cmd.updateViewObject(viewObj);
                        cmd.execute(null, monitor);
                    }
                    cmanager.removeCommandStack(id, ICommand.PHASE_RESTORE);
                }
            }
            refreshDeployedViewObjects(viewObjs);
        } else {
            return;
        }

    }

    private List<IRepositoryViewObject> getSelectedRepositoryViewObject() {
        List<IRepositoryViewObject> viewObjs = new LinkedList<IRepositoryViewObject>();
        for (Object obj : getSelectedObject()) {
            if (obj instanceof IRepositoryViewObject) {
                viewObjs.add((IRepositoryViewObject) obj);
            }
        }
        return viewObjs;
    }

    private void refreshDeployedViewObjects(List<IRepositoryViewObject> viewObjs) {
        for (IRepositoryViewObject viewObj : viewObjs) {
            commonViewer.refresh(viewObj);
        }
    }

    private SelectServerDefDialog getServerDefDialog(List<IRepositoryViewObject> viewObjs) {
        SelectServerDefDialog dialog = new SelectServerDefDialog(getShell());
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
        return dialog;
    }

    private boolean isSameMDMServerDef(MDMServerDef aServerDef, MDMServerDef bServerDef) {
        if (aServerDef == null && bServerDef == null) {
            return true;
        }

        if (aServerDef != null && bServerDef != null) {
            if (aServerDef.getName().equals(bServerDef.getName())) {
                return true;
            }
        }

        return false;
    }
}
