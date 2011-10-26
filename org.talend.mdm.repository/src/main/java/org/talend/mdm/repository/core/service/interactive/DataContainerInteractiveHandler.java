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
import com.amalto.workbench.webservices.WSDataCluster;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDeleteDataCluster;
import com.amalto.workbench.webservices.WSPutDataCluster;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DataContainerInteractiveHandler extends AbstractInteractiveHandler {

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_DATACLUSTER;
    }

    public String getLabel() {

        return Messages.DataContainerInteractiveHandler_title;
    }

    public boolean doDeploy(XtentisPort port, Object wsObj) throws RemoteException {
        if (wsObj != null) {
            WSPutDataCluster wsPutDataCluster = new WSPutDataCluster((WSDataCluster) wsObj);
            port.putDataCluster(wsPutDataCluster);
            return true;
        }
        return false;
    }

    public boolean doDelete(XtentisPort port, TreeObject xobject) throws RemoteException {
        // port.deleteDataCluster(new WSDeleteDataCluster((WSDataClusterPK) xobject.getWsKey()));

        if (xobject != null) {
            if (xobject.getWsKey() instanceof String) {
                WSDataClusterPK pk = new WSDataClusterPK();
                pk.setPk((String) xobject.getWsKey());
                port.deleteDataCluster(new WSDeleteDataCluster(pk));
            } else
                port.deleteDataCluster(new WSDeleteDataCluster((WSDataClusterPK) xobject.getWsKey()));

            return true;
        }
        return false;
    }

}
