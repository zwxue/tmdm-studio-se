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

import com.amalto.workbench.webservices.WSPutTransformerV2;
import com.amalto.workbench.webservices.WSTransformerV2;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class TransformerInteractiveHandler extends AbstractInteractiveHandler {

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_TRANSFORMERV2;
    }

    public String getLabel() {

        return "Process";
    }

    public boolean deploy(XtentisPort port, Object wsObj) throws RemoteException {
        if (wsObj != null) {
            port.putTransformerV2(new WSPutTransformerV2((WSTransformerV2) wsObj));
            return true;
        }
        return false;
    }

}
