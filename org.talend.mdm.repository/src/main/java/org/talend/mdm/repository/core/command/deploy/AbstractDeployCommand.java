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
        String topMsg = Messages.bind(bindMsg, typeLabel, objectName, e.getMessage());

        MultiStatus mStatus = new MultiStatus(RepositoryPlugin.PLUGIN_ID, Status.ERROR, topMsg, null);

        DeployStatus errorStatus = null;
        Throwable dup = e.getCause();
        while (dup != null) {
            errorStatus = DeployStatus.getErrorStatus(this, dup.getMessage());
            mStatus.add(errorStatus);

            dup = dup.getCause();
        }

        return mStatus;
    }
}
