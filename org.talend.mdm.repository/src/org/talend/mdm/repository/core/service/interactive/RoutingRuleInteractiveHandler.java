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

import com.amalto.workbench.webservices.WSPutRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RoutingRuleInteractiveHandler extends AbstractInteractiveHandler {

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_ROUTINGRULE;
    }

    public String getLabel() {

        return "Trigger";
    }

    public boolean doDeploy(XtentisPort port, Object wsObj) throws RemoteException {
        if (wsObj != null) {
            port.putRoutingRule(new WSPutRoutingRule((WSRoutingRule) wsObj));
            return true;
        }
        return false;
    }

}
