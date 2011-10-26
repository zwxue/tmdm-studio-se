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

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.WSDataModelItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSDeleteDataModel;
import com.amalto.workbench.webservices.WSPutDataModel;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DataModelInteractiveHandler extends AbstractInteractiveHandler {

    /**
     * 
     */
    private static final String ENCODE = "UTF-8"; //$NON-NLS-1$

    /**
     * 
     */
    private static final String FILE_EXTENSION = "xsd"; //$NON-NLS-1$
    Logger log = Logger.getLogger(DataModelInteractiveHandler.class);

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_DATAMODEL;
    }

    public String getLabel() {

        return Messages.DataModelInteractiveHandler_label;
    }

    public boolean doDeploy(XtentisPort port, Object wsObj) throws RemoteException {
        if (wsObj != null) {
            port.putDataModel(new WSPutDataModel((WSDataModel) wsObj));
            return true;
        }
        return false;
    }

    @Override
    public Object convert(Item item, MDMServerObject serverObj) {
        WSDataModel dataModel = (WSDataModel) super.convert(item, serverObj);
        IFile file = RepositoryResourceUtil.findReferenceFile(getRepositoryObjectType(), item, FILE_EXTENSION);
        String schema = RepositoryResourceUtil.getTextFileContent(file, ENCODE);
        dataModel.setXsdSchema(schema);
        return dataModel;
    }

    @Override
    public void assertPropertyIsInited(Item item) {
        IFile file = RepositoryResourceUtil.findReferenceFile(getRepositoryObjectType(), item, FILE_EXTENSION);
        String schema = RepositoryResourceUtil.getTextFileContent(file, ENCODE);
        ((WSDataModelItem) item).getWsDataModel().setXsdSchema(schema);
    }

    public boolean doDelete(XtentisPort port, TreeObject xobject) throws RemoteException {
        if (xobject != null) {
            // port.deleteDataModel(new WSDeleteDataModel((WSDataModelPK) wsObj.getWsKey()));
            if (xobject.getWsKey() instanceof String) {
                WSDataModelPK pk = new WSDataModelPK();
                pk.setPk((String) xobject.getWsKey());
                port.deleteDataModel(new WSDeleteDataModel(pk));
            } else
                port.deleteDataModel(new WSDeleteDataModel((WSDataModelPK) xobject.getWsKey()));

            return true;
        }
        return false;
    }

}
