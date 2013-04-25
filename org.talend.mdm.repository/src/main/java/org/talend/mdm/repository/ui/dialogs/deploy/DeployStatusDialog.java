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
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.command.deploy.job.BatchDeployJobCommand;
import org.talend.mdm.repository.core.service.DeployService.DeployCategoryStatus;
import org.talend.mdm.repository.core.service.DeployService.DeployStatus;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog;

/**
 * created by HHB on 2013-4-1 Detailled comment
 * 
 */
public class DeployStatusDialog extends MultiStatusDialog {

    private boolean isContainDataModel;

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
        if (status instanceof DeployCategoryStatus) {
            int[] summary = getSummary(status);
            return Messages.bind(Messages.DeployStatusDialog_typeSummaryMessage, status.getMessage(), String.valueOf(summary[0]),
                    String.valueOf(summary[1]), String.valueOf(summary[2]));
        }
        return status.getMessage();
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
        return new int[] { oks, errors, cancels };
    }

    private ERepositoryObjectType getType(IStatus status) {
        IStatus queryStatus = status;
        if (status.isMultiStatus()) {
            IStatus[] childrenStatus = status.getChildren();
            if (childrenStatus != null && childrenStatus.length > 0) {
                queryStatus = childrenStatus[0];
            }
        }
        if (queryStatus != null && queryStatus instanceof DeployStatus) {
            ICommand command = ((DeployStatus) queryStatus).getCommand();
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
        return null;
    }

    private boolean collectTypeStatus(Map<ERepositoryObjectType, List<IStatus>> map, IStatus status) {
        ERepositoryObjectType type = getType(status);
        Assert.isNotNull(type);

        List<IStatus> list = map.get(type);
        if (list == null) {
            list = new ArrayList<IStatus>();
            map.put(type, list);
        }
        if (type == ERepositoryObjectType.PROCESS && status.isMultiStatus()) {
            for (IStatus childStatus : status.getChildren()) {
                collectTypeStatus(map, childStatus);
            }
            return true;
        }
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
            collectTypeStatus(map, status);
        }
        MultiStatus retStatus = new MultiStatus(RepositoryPlugin.PLUGIN_ID, Status.OK, "", null); //$NON-NLS-1$
        for (Entry<ERepositoryObjectType, List<IStatus>> entry : map.entrySet()) {
            ERepositoryObjectType key = entry.getKey();
            MultiStatus submultiStatus = new DeployCategoryStatus(RepositoryPlugin.PLUGIN_ID, Status.OK, Messages.bind(
                    Messages.MultiStatusDialog_MultiStatus_Messages, key.getLabel()), null);
            for (IStatus status : entry.getValue()) {
                submultiStatus.add(status);
            }
            retStatus.add(submultiStatus);
        }
        isContainDataModel = map.containsKey(IServerObjectRepositoryType.TYPE_DATAMODEL);
        map.clear();
        return retStatus;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog#needShowBottomMessage()
     */
    @Override
    protected boolean needShowBottomMessage() {
        return isContainDataModel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog#getBottomMessage()
     */
    @Override
    protected String getBottomMessage() {
        return Messages.DeployStatusDialog_dataModelWarning;
    }

}
