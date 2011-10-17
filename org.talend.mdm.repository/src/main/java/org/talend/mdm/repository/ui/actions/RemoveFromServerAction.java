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
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.service.RemoveService;
import org.talend.mdm.repository.core.service.RemoveService.RemoveStatus;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC achen  class global comment. Detailled comment
 */
public class RemoveFromServerAction extends AbstractRemoveAction {

    private static Logger log = Logger.getLogger(DeployToAction.class);

    public RemoveFromServerAction() {
        super(Messages.RemoveFromServerAction_removeFromServer);

    }

    @Override
    public void run() {
        SelectServerDefDialog dialog = new SelectServerDefDialog(getShell());
        dialog.create();
        List<Object> list = getSelectedObject();
        if (list.size() > 0) {
            IRepositoryViewObject viewObj = (IRepositoryViewObject) list.get(0);
            Item item = viewObj.getProperty().getItem();
            MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
            dialog.setSelectServer(serverObject.getLastServerDef());
        }
        if (dialog.open() == IDialogConstants.OK_ID) {
            MDMServerDef serverDef = dialog.getSelectedServerDef();
            List<IRepositoryViewObject> viewObjs = new LinkedList<IRepositoryViewObject>();
            for (Object obj : getSelectedObject()) {
                viewObjs.add((IRepositoryViewObject) obj);
            }
            //
            IStatus status = remove(serverDef, viewObjs);
            if (status.isMultiStatus()) {
                for (IStatus childStatus : status.getChildren()) {
                    RemoveService.RemoveStatus removeStatus = (RemoveStatus) childStatus;
                    if (removeStatus.isOK()) {
                        if (removeStatus.getItem() instanceof MDMServerObjectItem)
                            removeLastServer((MDMServerObjectItem) removeStatus.getItem(), serverDef);
                    }
                }
                showRemoveStatus(status);
            }

        }

    }

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    private void removeLastServer(MDMServerObjectItem item, MDMServerDef serverDef) {
        MDMServerObject mdmServerObject = item.getMDMServerObject();
        mdmServerObject.setChanged(false);
        mdmServerObject.setCreated(false);
        mdmServerObject.setLastServerDef(null);
        try {
            factory.save(item);
            refreshParent();
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
    }
}
