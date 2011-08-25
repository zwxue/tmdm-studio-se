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

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.core.service.DeployService.DeployStatus;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployToAction extends AbstractDeployAction {

    private static Logger log = Logger.getLogger(DeployToAction.class);

    public DeployToAction() {
        super("Deploy To...");

    }

    @Override
    public void run() {
        SelectServerDefDialog dialog = new SelectServerDefDialog(getShell());
        if (dialog.open() == IDialogConstants.OK_ID) {
            MDMServerDef serverDef = dialog.getSelectedServerDef();
            List<IRepositoryViewObject> viewObjs = new LinkedList<IRepositoryViewObject>();
            for (Object obj : getSelectedObject()) {
                viewObjs.add((IRepositoryViewObject) obj);
            }
            //
            IStatus status = deploy(serverDef, viewObjs);
            if (status.isMultiStatus()) {
                for (IStatus childStatus : status.getChildren()) {
                    DeployService.DeployStatus deployStatus = (DeployStatus) childStatus;
                    if (deployStatus.isOK()) {
                        if (deployStatus.getItem() instanceof MDMServerObjectItem)
                            saveLastServer((MDMServerObjectItem) deployStatus.getItem(), serverDef);
                    }
                }
                showDeployStatus(status);
            }

        }

    }

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    private void saveLastServer(MDMServerObjectItem item, MDMServerDef serverDef) {
        item.getMDMServerObject().setLastServerDef(serverDef);
        try {
            factory.save(item);
            refreshParent();
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
    }
}
