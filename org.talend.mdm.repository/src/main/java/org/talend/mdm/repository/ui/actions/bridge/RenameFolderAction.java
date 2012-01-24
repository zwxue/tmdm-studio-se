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
package org.talend.mdm.repository.ui.actions.bridge;

import org.talend.mdm.repository.core.bridge.AbstractBridgeRepositoryAction;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RenameFolderAction extends AbstractBridgeRepositoryAction {

    public RenameFolderAction() {
        super(new org.talend.repository.ui.actions.folder.RenameFolderAction());
    }

    public String getGroupName() {
        return GROUP_EDIT;
    }

    protected void doRun() {
        super.doRun();
        refreshParentContainer();
    }
}
