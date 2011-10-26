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
import com.amalto.workbench.webservices.WSDeleteRoutingRule;
import com.amalto.workbench.webservices.WSPutRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RoutingRuleInteractiveHandler extends AbstractInteractiveHandler {

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_ROUTINGRULE;
    }

    public String getLabel() {

        return Messages.RoutingRuleInteractiveHandler_label;
    }

    public boolean doDeploy(XtentisPort port, Object wsObj) throws RemoteException {
        if (wsObj != null) {
            port.putRoutingRule(new WSPutRoutingRule((WSRoutingRule) wsObj));
            return true;
        }
        return false;
    }

    public boolean doDelete(XtentisPort port, TreeObject xobject) throws RemoteException {
        // port.deleteRoutingRule(new WSDeleteRoutingRule((WSRoutingRulePK) xobject.getWsKey()));
        if (xobject != null) {
            if (xobject.getWsKey() instanceof String) {
                WSRoutingRulePK pk = new WSRoutingRulePK();
                pk.setPk((String) xobject.getWsKey());
                port.deleteRoutingRule(new WSDeleteRoutingRule(pk));
            } else
                port.deleteRoutingRule(new WSDeleteRoutingRule((WSRoutingRulePK) xobject.getWsKey()));

            return true;
        }
        return false;
    }

}
