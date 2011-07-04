// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
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

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class UpdateServerDefAction extends AbstractRepositoryAction {

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    static Logger log = Logger.getLogger(RemoveFromRepositoryAction.class);

    public UpdateServerDefAction() {
        super("Update Last Server");
    }

    public String getGroupName() {
        return GROUP_SERVER;
    }

    @Override
    public void run() {
        SelectServerDefDialog dlg = new SelectServerDefDialog(getShell());
        if (dlg.open() == IDialogConstants.OK_ID) {
            MDMServerDef def = dlg.getSelectedServerDef();
            for (Object obj : getSelectedObject()) {
                Item item = ((IRepositoryViewObject) obj).getProperty().getItem();
                if (item instanceof MDMServerObjectItem) {
                    ((MDMServerObjectItem) item).getMDMServerObject().setLastServerDef(def);
                    try {
                        factory.save(item, false);
                    } catch (PersistenceException e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
            commonViewer.refresh();
        }
    }

}
