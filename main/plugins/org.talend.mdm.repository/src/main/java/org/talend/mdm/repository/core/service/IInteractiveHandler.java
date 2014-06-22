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
package org.talend.mdm.repository.core.service;

import java.rmi.RemoteException;

import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.mdm.repository.core.command.deploy.AbstractDeployCommand;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;

import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public interface IInteractiveHandler {

    public ERepositoryObjectType getRepositoryObjectType();

    public String getLabel();

    public Object convert(Item item, MDMServerObject serverObj);

    public boolean deploy(AbstractDeployCommand cmd) throws RemoteException, XtentisException;

    public boolean remove(AbstractDeployCommand cmd) throws RemoteException, XtentisException;


    public boolean doDeployWSObject(XtentisPort port, Object wsObj) throws RemoteException, XtentisException;

    public void assertPropertyIsInited(Item item);


}
