// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
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

import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.command.deploy.AbstractDeployCommand;
import org.talend.mdm.repository.i18n.Messages;

import com.amalto.workbench.utils.EXtentisObjects;
import com.amalto.workbench.utils.TreeObjectUtil;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.TMDMService;
import com.amalto.workbench.webservices.WsDeleteStoredProcedure;
import com.amalto.workbench.webservices.WsPutStoredProcedure;
import com.amalto.workbench.webservices.WsStoredProcedure;
import com.amalto.workbench.webservices.WsStoredProcedurePK;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class StoredProcedureInteractiveHandler extends AbstractInteractiveHandler {

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_STOREPROCEDURE;
    }

    public String getLabel() {

        return Messages.StoredProcedureInteractiveHandler_label;
    }

    @Override
    public boolean doDeployWSObject(TMDMService service, Object wsObj) {
        if (wsObj != null) {
            service.putStoredProcedure(new WsPutStoredProcedure((WsStoredProcedure) wsObj));
            return true;
        }
        return false;
    }

    @Override
    public boolean doRemove(TMDMService service, AbstractDeployCommand cmd) throws XtentisException {
        WsStoredProcedurePK pk = new WsStoredProcedurePK();
        String name = cmd.getObjName();
        pk.setPk(name);
        service.deleteStoredProcedure(new WsDeleteStoredProcedure(pk));
        TreeObjectUtil.deleteSpecificationFromAttachedRole(service, name, EXtentisObjects.StoredProcedure.getName());
        return true;
    }

}
