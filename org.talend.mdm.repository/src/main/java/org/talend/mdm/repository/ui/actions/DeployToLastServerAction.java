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
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployToLastServerAction extends AbstractDeployAction {

    private static Logger log = Logger.getLogger(DeployToLastServerAction.class);

    public DeployToLastServerAction() {
        super(Messages.DeployToLastServerAction_deployToLastServer);

    }

    @Override
    public void run() {
        List<IRepositoryViewObject> viewObjs = new LinkedList<IRepositoryViewObject>();
        for (Object obj : getSelectedObject()) {
            viewObjs.add((IRepositoryViewObject) obj);
        }
        IRepositoryViewObject viewObj = (IRepositoryViewObject) getSelectedObject().get(0);
        MDMServerObjectItem item = (MDMServerObjectItem) viewObj.getProperty().getItem();
        MDMServerObject mdmServerObject = ((MDMServerObjectItem) item).getMDMServerObject();
        MDMServerDef currentServerDef = mdmServerObject.getLastServerDef();
        //
        IStatus status = deploy(currentServerDef, viewObjs);
        updateChangedStatus(status);
        if (status.isMultiStatus()) {
            showDeployStatus(status);
        }
    }

    @Override
    public boolean isVisible(IRepositoryViewObject viewObj) {
        MDMServerDef firstDef = null;
        for (Object obj : getSelectedObject()) {
            if (obj instanceof IRepositoryViewObject) {
                Item item = ((IRepositoryViewObject) obj).getProperty().getItem();
                if (item instanceof MDMServerObjectItem) {
                    MDMServerObject mdmServerObject = ((MDMServerObjectItem) item).getMDMServerObject();
                    MDMServerDef currentServerDef = mdmServerObject.getLastServerDef();
                    if (currentServerDef == null)
                        return false;
                    if (firstDef == null) {
                        firstDef = currentServerDef;
                    } else {
                        if (!isSameServer(firstDef, currentServerDef)) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSameServer(MDMServerDef s1, MDMServerDef s2) {
        return s1.getHost().equals(s2.getHost()) && s1.getPort().equals(s2.getPort());
    }
}
