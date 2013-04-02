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
package org.talend.mdm.repository.ui.dialogs.deploy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Shell;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.command.deploy.job.BatchDeployJobCommand;
import org.talend.mdm.repository.core.service.DeployService.DeployStatus;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog;

/**
 * created by HHB on 2013-4-1 Detailled comment
 * 
 */
public class DeployStatusDialog extends MultiStatusDialog {

    /**
     * DOC HHB DeployStatusDialog constructor comment.
     * 
     * @param parentShell
     * @param message
     * @param mutliStatus
     */
    public DeployStatusDialog(Shell parentShell, IStatus mutliStatus) {
        super(parentShell, null, mutliStatus);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog#getMessage()
     */
    @Override
    protected String getMessage() {
        int oks = 0, errors = 0, cancels = 0;
        for (IStatus status : multiStatus.getChildren()) {
            int[] summary = getSummary(status);
            oks += summary[0];
            errors += summary[1];
            cancels += summary[2];
        }
        return Messages.bind(Messages.DeployStatusDialog_deploySummary, String.valueOf(oks + errors), String.valueOf(oks),
                String.valueOf(errors), String.valueOf(cancels));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog#getStatusLabel(org.eclipse.core.runtime.IStatus)
     */
    @Override
    public String getStatusLabel(IStatus status) {
        int[] summary = getSummary(status);
        return Messages.bind(Messages.DeployStatusDialog_typeSummaryMessage, status.getMessage(), String.valueOf(summary[0]),
                String.valueOf(summary[1]), String.valueOf(summary[2]));
    }

    /**
     * DOC HHB Comment method "getSummary".
     * 
     * @param status
     * @return int[ok,error,cancel]
     */
    private int[] getSummary(IStatus status) {
        int oks = 0, errors = 0, cancels = 0;
        if (status != null && status.isMultiStatus()) {
            for (IStatus childStatus : status.getChildren()) {
                if (!childStatus.isMultiStatus()) {
                    switch (childStatus.getSeverity()) {
                    case IStatus.OK:
                        oks++;
                        continue;
                    case IStatus.ERROR:
                        errors++;
                        continue;
                    case IStatus.INFO:
                        cancels++;
                        continue;
                    }
                }
            }
        }
        return new int[] { oks, errors, cancels };
    }

    private ERepositoryObjectType getType(IStatus status) {
        ICommand command = ((DeployStatus) status).getCommand();
        IRepositoryViewObject viewObject = null;
        if (command != null) {
            if (command instanceof BatchDeployJobCommand) {
                return ERepositoryObjectType.PROCESS;
            } else {
                viewObject = command.getViewObject();
            }
        }

        if (viewObject == null) {
            return null;
        }
        return viewObject.getRepositoryObjectType();
    }

    private boolean collectTypeStatus(Map<ERepositoryObjectType, List<IStatus>> map, IStatus status) {
        ERepositoryObjectType type = getType(status);
        Assert.isNotNull(type);

        List<IStatus> list = map.get(type);
        if (list == null) {
            list = new ArrayList<IStatus>();
            map.put(type, list);
        }
        // ICommand command = ((DeployStatus) status).getCommand();
        // if (command instanceof BatchDeployJobCommand) {
        // List<ICommand> subCmds = ((BatchDeployJobCommand) command).getSubCmds();
        // for (ICommand cmd : subCmds) {
        //
        // }
        // }
        if (list.isEmpty() || !list.contains(status)) {
            list.add(status);
        }
        return true;
    }

    @Override
    protected IStatus initMultiStatus(IStatus multiStatus) {
        IStatus[] children = multiStatus.getChildren();

        Map<ERepositoryObjectType, List<IStatus>> map = new HashMap<ERepositoryObjectType, List<IStatus>>();
        for (IStatus status : children) {
            if (status.isMultiStatus()) {
                for (IStatus childStatus : status.getChildren()) {
                    if (!collectTypeStatus(map, childStatus)) {
                        break;
                    }
                }
            } else {
                collectTypeStatus(map, status);
            }

        }
        MultiStatus retStatus = new MultiStatus(RepositoryPlugin.PLUGIN_ID, Status.OK, "", null); //$NON-NLS-1$
        for (Entry<ERepositoryObjectType, List<IStatus>> entry : map.entrySet()) {
            ERepositoryObjectType key = entry.getKey();
            MultiStatus submultiStatus = new MultiStatus(RepositoryPlugin.PLUGIN_ID, Status.OK, Messages.bind(
                    Messages.MultiStatusDialog_MultiStatus_Messages, key.getKey()), null);
            for (IStatus status : entry.getValue()) {
                submultiStatus.add(status);
            }
            retStatus.add(submultiStatus);
        }
        map.clear();
        return retStatus;
    }
}
