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

import org.talend.core.model.properties.Item;
import org.talend.mdm.repository.core.service.IInteractiveHandler;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.Bean2EObjUtil;

import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public abstract class AbstractInteractiveHandler implements IInteractiveHandler {

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.service.IInteractiveHandler#convert(org.talend.core.model.properties.Item,
     * org.talend.mdm.repository.model.mdmserverobject.MDMServerObject)
     */
    public Object convert(Item item, MDMServerObject serverObj) {
        Object wsObj = Bean2EObjUtil.getInstance().convertFromEObj2Bean(serverObj);
        return wsObj;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.service.IInteractiveHandler#deploy(com.amalto.workbench.webservices.XtentisPort,
     * org.talend.core.model.properties.Item, org.talend.mdm.repository.model.mdmserverobject.MDMServerObject)
     */
    public boolean deploy(XtentisPort port, Item item, MDMServerObject serverObj) throws RemoteException {
        Object wsObj = convert(item, serverObj);
        return deploy(port, wsObj);
    }

}
