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
package org.talend.mdm.repository.core.service.interactive;

import java.rmi.RemoteException;

import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.i18n.Messages;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSDeleteMenu;
import com.amalto.workbench.webservices.WSMenu;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSPutMenu;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class MenuInteractiveHandler extends AbstractInteractiveHandler {

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_MENU;
    }

    public String getLabel() {

        return Messages.MenuInteractiveHandler_label;
    }

    public boolean doDeploy(XtentisPort port, Object wsObj) throws RemoteException {
        if (wsObj != null) {
            port.putMenu(new WSPutMenu((WSMenu) wsObj));
            return true;
        }
        return false;
    }

    public boolean doDelete(XtentisPort port, TreeObject xobject) throws RemoteException {
        // port.deleteMenu(new WSDeleteMenu((WSMenuPK) xobject.getWsKey()));

        if (xobject != null) {
            if (xobject.getWsKey() instanceof String) {
                WSMenuPK pk = new WSMenuPK();
                pk.setPk((String) xobject.getWsKey());
                port.deleteMenu(new WSDeleteMenu(pk));
            } else
                port.deleteMenu(new WSDeleteMenu((WSMenuPK) xobject.getWsKey()));

            return true;
        }
        return false;
    }

}
