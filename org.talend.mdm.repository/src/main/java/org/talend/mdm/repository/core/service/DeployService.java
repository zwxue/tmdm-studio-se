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
package org.talend.mdm.repository.core.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.progress.IProgressService;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.CompoundCommand;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.command.common.PushCmdCommand;
import org.talend.mdm.repository.core.command.common.UpdateLastServerCommand;
import org.talend.mdm.repository.core.command.deploy.AbstractDeployCommand;
import org.talend.mdm.repository.core.command.deploy.DeployCompoundCommand;
import org.talend.mdm.repository.core.command.deploy.job.BatchDeployJobCommand;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog;
import org.talend.mdm.repository.ui.preferences.PreferenceConstants;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployService {

    private static Logger log = Logger.getLogger(DeployService.class);

    public static class DeployStatus extends Status {

        ICommand command;

        public ICommand getCommand() {
            return this.command;
        }

        /**
         * DOC hbhong DeployStatus constructor comment.
         *
         * @param severity
         * @param pluginId
         * @param message
         * @param exception
         */
        DeployStatus(int severity, String message, Throwable exception, ICommand command) {
            super(severity, RepositoryPlugin.PLUGIN_ID, message, exception);
            this.command = command;
        }

        public static DeployStatus getOKStatus(ICommand command, String msg) {
            return new DeployStatus(Status.OK, msg, null, command);
        }

        public static DeployStatus getInfoStatus(ICommand command, String msg) {
            return new DeployStatus(Status.INFO, msg, null, command);
        }

        public static DeployStatus getErrorStatus(ICommand command, Throwable exception) {
            return new DeployStatus(Status.ERROR, exception.getMessage(), exception, command);
        }

        public static DeployStatus getErrorStatus(ICommand command, String errMsg) {
            return new DeployStatus(Status.ERROR, errMsg, null, command);
        }

        public static DeployStatus getErrorStatus(ICommand command, String errMsg, Throwable exception) {
            return new DeployStatus(Status.ERROR, errMsg, exception, command);
        }

    }

    private static DeployService instance = new DeployService();

    private DeployService() {
    }

    public static DeployService getInstance() {
        return instance;
    }

    class DeployProcess implements IRunnableWithProgress {

        private List<ICommand> commands;

        MultiStatus mStatus = new MultiStatus(RepositoryPlugin.PLUGIN_ID, Status.OK, "", null); //$NON-NLS-1$

        public MultiStatus getStatus() {
            return this.mStatus;
        }

        public DeployProcess(List<ICommand> commands) {
            this.commands = commands;
        }

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            if (commands != null) {
                monitor.beginTask(Messages.DeployService_processTitle, commands.size());
                for (ICommand cmd : commands) {
                    if (cmd.getToRunPhase() == ICommand.PHASE_DEPLOY) {
                        IStatus status = cmd.execute(null, monitor);
                        mStatus.add(status);
                    }
                    monitor.worked(1);
                }
                monitor.done();
            }
        }

    }

    public IStatus deploy(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs, int defaultCmdType, boolean removeLocked) {
        if (removeLocked) {
            removeLockedViewObj(viewObjs);
        }
        CommandManager manager = CommandManager.getInstance();
        List<AbstractDeployCommand> commands = manager.getDeployCommands(viewObjs, defaultCmdType);
        return runCommands(commands, serverDef);
    }

    public IStatus deployAnotherVersion(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs) {
        CommandManager manager = CommandManager.getInstance();
        List<AbstractDeployCommand> commands = manager.getDeployCommandsWithoutHistory(viewObjs);
        return runCommands(commands, serverDef);
    }

    public IStatus deploy(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs, int defaultCmdType) {
        return deploy(serverDef, viewObjs, defaultCmdType, false);
    }

    private void removeLockedViewObj(List<IRepositoryViewObject> viewObjs) {
        if (viewObjs != null) {
            for (java.util.Iterator<IRepositoryViewObject> il = viewObjs.iterator(); il.hasNext();) {
                if (RepositoryResourceUtil.isLockedAndEdited(il.next())) {
                    il.remove();
                }
            }
        }
    }

    public boolean isAutoDeploy() {
        return PlatformUI.getPreferenceStore().getBoolean(PreferenceConstants.P_AUTO_DEPLOY);
    }

    public void autoDeploy(Shell shell, IRepositoryViewObject viewObj) {
        if (shell == null || viewObj == null) {
            throw new IllegalArgumentException();
        }
        MDMServerDef serverDef = RepositoryResourceUtil.getLastServerDef(viewObj);
        if (serverDef != null) {

            List<IRepositoryViewObject> viewObjs = new ArrayList<IRepositoryViewObject>();
            viewObjs.add(viewObj);

            IStatus status = deploy(serverDef, viewObjs, ICommand.CMD_MODIFY, false);
            updateAutoStatus(status);
            if (status.isMultiStatus()) {
                showDeployStatus(shell, status);
            }
        } else {
            boolean warnUser = PlatformUI.getPreferenceStore().getBoolean(PreferenceConstants.P_WARN_USER_AUTO_DEPLOY);
            if (warnUser) {
                MessageDialog.openWarning(shell, Messages.Warning_text, Messages.NeverDeploy_text);
            }
        }
    }

    protected void updateAutoStatus(IStatus status) {
        if (status.isMultiStatus()) {
            for (IStatus childStatus : status.getChildren()) {
                DeployStatus deployStatus = null;
                if (childStatus instanceof DeployStatus) {
                    deployStatus = (DeployStatus) childStatus;
                } else if (childStatus instanceof MultiStatus) {
                    deployStatus = (DeployStatus) ((MultiStatus) childStatus).getChildren()[0];
                }

                ICommand command = deployStatus.getCommand();
                CommandManager manager = CommandManager.getInstance();
                manager.removeCommandStack(command, ICommand.PHASE_DEPLOY);

            }
        }
    }

    private void showDeployStatus(Shell shell, IStatus status) {
        String prompt;

        if (status.getSeverity() < IStatus.ERROR) {
            prompt = Messages.bind(Messages.AbstractDeployAction_deployMessage, status.getChildren().length);
        } else {
            prompt = Messages.bind(Messages.AbstractDeployAction_deployFailure, status.getChildren().length);

        }
        MultiStatusDialog dialog = new MultiStatusDialog(shell, prompt, status);
        dialog.open();
    }

    public IStatus runCommands(List<AbstractDeployCommand> commands, MDMServerDef serverDef) {
        CommandManager manager = CommandManager.getInstance();
        List<ICommand> compundCommands = manager.convertToDeployCompundCommands(commands, serverDef);
        manager.arrangeForJobCommands(compundCommands);
        //
        try {
            IProgressService progressService = null;
            if (Workbench.getInstance() != null) {
                progressService = PlatformUI.getWorkbench().getProgressService();
            } else {
                progressService = ConsoleProgressService.getInstance();
            }
            DeployProcess runnable = new DeployProcess(compundCommands);
            progressService.run(true, true, runnable);
            return runnable.getStatus();
        } catch (InvocationTargetException e) {
            log.error(e.getMessage(), e);
        } catch (InterruptedException e) {

        }
        return Status.CANCEL_STATUS;
    }

    private void pushRestoreCommand(CommandManager manager, List<ICommand> subCmds, MDMServerDef serverDef) {
        if (subCmds != null && subCmds.size() > 0) {
            for (ICommand command : subCmds) {
                pushRestoreCommand(manager, command, serverDef);
            }
        }
    }

    public void updateLastServer(IStatus status, IProgressMonitor monitor) {
        CommandManager manager = CommandManager.getInstance();
        Map<String, List<ICommand>> commandMap = manager.getAllCommandsByPhase(ICommand.PHASE_AFTER_DEPLOY);
        Set<String> ids = getValidUpdateIds(status);
        for (String id : commandMap.keySet()) {
            boolean canRun = false;
            if (ids == null) {
                canRun = true;
            } else {
                canRun = ids.contains(id);
            }
            if (canRun) {
                List<ICommand> cmds = commandMap.get(id);
                for (ICommand cmd : cmds) {
                    cmd.execute(null, monitor);
                }
                manager.removeCommandStack(id, ICommand.PHASE_AFTER_DEPLOY);
            }
        }
    }

    private Set<String> getValidUpdateIds(IStatus status) {
        if (status == null || !(status.isMultiStatus())) {
            return null;
        }
        Set<String> ids = new HashSet<String>();
        for (IStatus childStatus : status.getChildren()) {
            DeployStatus deployStatus = null;

            if (childStatus instanceof DeployStatus) {
                deployStatus = (DeployStatus) childStatus;
            } else if (childStatus instanceof MultiStatus) {
                if (((MultiStatus) childStatus).getChildren().length > 0) {
                    deployStatus = (DeployStatus) ((MultiStatus) childStatus).getChildren()[0];
                }
            }
            if (deployStatus != null && deployStatus.isOK()) {
                ICommand command = deployStatus.getCommand();
                if (command instanceof BatchDeployJobCommand) {
                    BatchDeployJobCommand deployJobCommand = (BatchDeployJobCommand) command;
                    for (ICommand subCmd : deployJobCommand.getSubCmds()) {
                        ids.add(subCmd.getCommandId());
                    }
                } else {
                    ids.add(command.getCommandId());
                }
            }
        }
        return ids;
    }

    public void updateChangedStatus(IStatus status) {
        updateChangedStatus(status, true);
    }

    public void updateChangedStatus(IStatus status, boolean isUpdateServer) {
        if (status.isMultiStatus()) {
            for (IStatus childStatus : status.getChildren()) {
                List<DeployStatus> deployStatuses = new ArrayList<DeployStatus>();
                if (childStatus instanceof DeployStatus) {
                    deployStatuses.add((DeployStatus) childStatus);
                } else if (childStatus instanceof MultiStatus) {
                    IStatus[] childrenStatus = ((MultiStatus) childStatus).getChildren();
                    if (childrenStatus.length > 0) {
                        for (IStatus cstatus : childrenStatus) {
                            if (cstatus instanceof DeployStatus) {
                                deployStatuses.add((DeployStatus) cstatus);
                            }
                        }
                    }
                }

                updateForStatus(isUpdateServer, deployStatuses);
            }
        }
    }

    private void updateForStatus(boolean isUpdateServer, List<DeployStatus> deployStatuses) {
        if (deployStatuses == null || deployStatuses.size() == 0) {
            return;
        }

        for (DeployStatus deployStatus : deployStatuses) {
            if (deployStatus != null && deployStatus.isOK()) {
                ICommand command = deployStatus.getCommand();
                CommandManager manager = CommandManager.getInstance();
                manager.removeCommandStack(command, ICommand.PHASE_DEPLOY);
                if (isUpdateServer) {
                    MDMServerDef serverDef = null;
                    if (command instanceof AbstractDeployCommand) {
                        serverDef = ((AbstractDeployCommand) command).getServerDef();
                    } else if (command instanceof DeployCompoundCommand) {
                        serverDef = ((DeployCompoundCommand) command).getServerDef();
                    }
                    if (command instanceof BatchDeployJobCommand) {
                        BatchDeployJobCommand deployJobCommand = (BatchDeployJobCommand) command;
                        pushRestoreCommand(manager, deployJobCommand.getSubCmds(), serverDef);
                        pushRestoreCommand(manager, deployJobCommand.getSubDeleteCmds(), serverDef);
                    } else {
                        // updateserver
                        pushRestoreCommand(manager, command, serverDef);
                    }
                }
            }
        }
    }

    public void pushRestoreCommand(CommandManager manager, ICommand command, MDMServerDef serverDef) {
        // updateserver
        if (command.getCommandType() != ICommand.CMD_DELETE) {
            Item item = command.getViewObject().getProperty().getItem();
            UpdateLastServerCommand updateLastServerCommand = new UpdateLastServerCommand(item, serverDef);
            updateLastServerCommand.setToRunPhase(ICommand.PHASE_AFTER_DEPLOY);
            updateLastServerCommand.init(command.getCommandId(), command.getObjLastName());
            manager.pushCommand(updateLastServerCommand);
        }
        //
        if (command.getCommandType() == ICommand.CMD_DELETE && !(command instanceof CompoundCommand)) {

            UpdateLastServerCommand emptyLastServerCommand = new UpdateLastServerCommand();
            PushCmdCommand pushCmd = new PushCmdCommand();
            pushCmd.setPushCmdType(ICommand.CMD_ADD);
            pushRestoreCommand(manager, command, emptyLastServerCommand);
            pushRestoreCommand(manager, command, pushCmd);
        }
    }

    private void pushRestoreCommand(CommandManager manager, ICommand command, ICommand cmd) {
        cmd.init(command.getCommandId(), command.getObjLastName());
        cmd.setToRunPhase(ICommand.PHASE_RESTORE);
        manager.pushCommand(cmd);
    }
}
