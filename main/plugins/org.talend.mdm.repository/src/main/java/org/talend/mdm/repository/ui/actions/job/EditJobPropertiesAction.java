// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
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

import org.talend.mdm.repository.core.bridge.AbstractBridgeRepositoryAction;
import org.talend.repository.ui.actions.EditPropertiesAction;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class EditJobPropertiesAction extends AbstractBridgeRepositoryAction {

    /**
     * DOC hbhong EditJobPropertiesAction constructor comment.
     * 
     * @param cAction
     */
    public EditJobPropertiesAction() {
        super(new EditPropertiesAction());

    }

    @Override
    protected void doRun() {
        super.doRun();
        refreshCurrentObject();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.AbstractRepositoryAction#getGroupName()
     */
    @Override
    public String getGroupName() {
        return GROUP_EDIT;
    }

}
