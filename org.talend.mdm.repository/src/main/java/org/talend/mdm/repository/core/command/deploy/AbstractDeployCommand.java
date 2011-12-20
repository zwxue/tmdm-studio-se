// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
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

import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.mdm.repository.core.command.AbstractCommand;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;

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

    public int getToRunPhase() {
        return ICommand.PHASE_DEPLOY;
    }

}
