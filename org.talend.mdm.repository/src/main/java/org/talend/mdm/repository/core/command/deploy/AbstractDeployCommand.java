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
package org.talend.mdm.repository.core.command.deploy;

import java.rmi.RemoteException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.mdm.repository.core.command.AbstractCommand;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.service.DeployService.DeployStatus;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.plugin.RepositoryPlugin;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public abstract class AbstractDeployCommand extends AbstractCommand {

    protected MDMServerDef serverDef;

    public MDMServerDef getServerDef() {
        return this.serverDef;
    }

    public void setServerDef(MDMServerDef serverDef) {
        this.serverDef = serverDef;
    }

    protected ERepositoryObjectType getViewObjectType() {
        return viewObject.getRepositoryObjectType();
    }

    @Override
    public int getToRunPhase() {
        return ICommand.PHASE_DEPLOY;
    }

    protected IStatus getDetailErrorMsg(String bindMsg, String typeLabel, String objectName, Exception e) {
        String topMsg = Messages.bind(bindMsg, typeLabel, objectName, e.getMessage().split(";")[0]); //$NON-NLS-1$

        Throwable cause = null;
        if (e instanceof RemoteException) {
            cause = ((RemoteException) e).detail;
        } else {
            cause = e.getCause();
        }

        if (cause == null) {
            IStatus status = buildErrorStatus(bindMsg, typeLabel, objectName, e);

            return status;
        }

        MultiStatus mStatus = new MultiStatus(RepositoryPlugin.PLUGIN_ID, Status.ERROR, topMsg, null);
        DeployStatus errorStatus = null;
        while (cause != null) {
            String message = cause.getMessage().split(";")[0]; //$NON-NLS-1$

            errorStatus = DeployStatus.getErrorStatus(this, message);
            mStatus.add(errorStatus);

            if (cause instanceof RemoteException) {
                cause = ((RemoteException) cause).detail;
            } else {
                cause = cause.getCause();
            }
        }

        return mStatus;
    }

    private IStatus buildErrorStatus(String bindMsg, String typeLabel, String objectName, Exception e) {
        IStatus status = null;

        String msg = e.getMessage();
        //
        int indexOf = msg.indexOf(";"); //$NON-NLS-1$
        if (indexOf != -1) {
            String top = msg.substring(0, indexOf);
            int topIndex = top.indexOf(":"); //$NON-NLS-1$
            if (topIndex != -1) {
                top = top.substring(topIndex + 1);
            }
            top = Messages.bind(bindMsg, typeLabel, objectName, top);
            status = new MultiStatus(RepositoryPlugin.PLUGIN_ID, Status.ERROR, top, null);

            msg = msg.substring(indexOf + 1);
            String[] splits = msg.split(":"); //$NON-NLS-1$
            for (int i = 1; i < splits.length; i++) {
                if (splits[i].endsWith("Exception") || splits[i].endsWith("Error")) { //$NON-NLS-1$ //$NON-NLS-2$
                    continue;
                }

                ((MultiStatus) status).add(DeployStatus.getErrorStatus(this, splits[i]));
            }
        } else {
            status = DeployStatus.getErrorStatus(this,
                    Messages.bind(Messages.Deploy_fail_cause_text, typeLabel, objectName, e.getMessage()), e);
        }

        return status;
    }

}

