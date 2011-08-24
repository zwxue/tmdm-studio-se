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
package org.talend.mdm.repository.ui.actions;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.ui.dialogs.message.MutliStatusDialog;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public abstract class AbstractDeployAction extends AbstractRepositoryAction {

    // private static Logger log = Logger.getLogger(AbstractDeployAction.class);
    protected AbstractDeployAction(String text) {
        super(text);
    }

    protected IStatus deploy(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs) {
        return DeployService.getInstance().deploy(serverDef, viewObjs);
    }

    protected void showDeployStatus(IStatus status) {
        MutliStatusDialog dialog = new MutliStatusDialog(getShell(), status.getChildren().length
                + " server objects are deployed, following is the detail:", status);
        dialog.open();
    }

    public String getGroupName() {
        return GROUP_DEPLOY;
    }

}
