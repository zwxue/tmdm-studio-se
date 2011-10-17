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
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;

import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public interface IInteractiveHandler {

    public ERepositoryObjectType getRepositoryObjectType();

    public String getLabel();

    public Object convert(Item item, MDMServerObject serverObj);

    public boolean deployMDM(MDMServerDef serverDef, XtentisPort port, Item item, MDMServerObject serverObj) throws RemoteException;

    public boolean removeMDM(MDMServerDef serverDef, XtentisPort port, Item item, MDMServerObject serverObj)
            throws RemoteException;

    public IStatus deployOther(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs) throws RemoteException;

    public boolean doDeploy(XtentisPort port, Object wsObj) throws RemoteException;

    public void assertPropertyIsInited(Item item);
}
