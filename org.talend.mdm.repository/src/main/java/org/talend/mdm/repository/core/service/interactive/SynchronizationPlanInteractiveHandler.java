// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
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
import org.talend.mdm.repository.core.command.deploy.AbstractDeployCommand;
import org.talend.mdm.repository.i18n.Messages;

import com.amalto.workbench.utils.EXtentisObjects;
import com.amalto.workbench.utils.TreeObjectUtil;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSDeleteSynchronizationPlan;
import com.amalto.workbench.webservices.WSPutSynchronizationPlan;
import com.amalto.workbench.webservices.WSSynchronizationPlan;
import com.amalto.workbench.webservices.WSSynchronizationPlanPK;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class SynchronizationPlanInteractiveHandler extends AbstractInteractiveHandler {

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_SYNCHRONIZATIONPLAN;
    }

    public String getLabel() {

        return Messages.SynchronizationPlanInteractiveHandler_label;
    }

    public boolean doDeployWSObject(XtentisPort port, Object wsObj) throws RemoteException {
        if (wsObj != null) {
            port.putSynchronizationPlan(new WSPutSynchronizationPlan((WSSynchronizationPlan) wsObj));
            return true;
        }
        return false;
    }

    public boolean doRemove(XtentisPort port, AbstractDeployCommand cmd) throws RemoteException, XtentisException {
        WSSynchronizationPlanPK pk = new WSSynchronizationPlanPK();
        String name = cmd.getObjName();
        pk.setPk(name);
        port.deleteSynchronizationPlan(new WSDeleteSynchronizationPlan(pk));
        TreeObjectUtil.deleteSpecificationFromAttachedRole(port, name, EXtentisObjects.SynchronizationPlan.getName());
        return true;
    }
}
