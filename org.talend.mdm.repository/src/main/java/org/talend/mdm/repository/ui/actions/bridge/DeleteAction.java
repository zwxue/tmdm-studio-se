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
package org.talend.mdm.repository.ui.actions.bridge;

import org.talend.mdm.repository.core.bridge.AbstractBridgeRepositoryAction;
import org.talend.mdm.repository.i18n.Messages;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeleteAction extends AbstractBridgeRepositoryAction {

    public DeleteAction() {
        super(new org.talend.repository.ui.actions.DeleteAction());
        setText(Messages.RemoveFromRepositoryAction_removeFromRepository);
    }

    public String getGroupName() {
        return GROUP_EDIT;
    }

    protected void doRun() {
        super.doRun();
        refreshParentContainer();
    }

}
