// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
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
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.command.deploy.AbstractDeployCommand;
import org.talend.mdm.repository.core.service.IMatchRuleMapInfoService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.WSDataModelItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.repository.utils.ServiceUtil;

import com.amalto.workbench.utils.EXtentisObjects;
import com.amalto.workbench.utils.TreeObjectUtil;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
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

    @Override
    public boolean doDeployWSObject(XtentisPort port, Object wsObj) throws RemoteException {
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

    @Override
    public boolean doRemove(XtentisPort port, AbstractDeployCommand cmd) throws RemoteException, XtentisException {
        WSDataModelPK pk = new WSDataModelPK();
        String name = cmd.getObjName();
        pk.setPk(name);
        port.deleteDataModel(new WSDeleteDataModel(pk));
        TreeObjectUtil.deleteSpecificationFromAttachedRole(port, name, EXtentisObjects.DataMODEL.getName());
        return true;
    }

    @Override
    public List<IRepositoryViewObject> getAssociatedObjects(IRepositoryViewObject obj) {
        if (Util.IsEnterPrise()) {
            IRepositoryViewObject mapInfoObject = convertToMapInfoObject(obj);
            if (mapInfoObject != null) {
                ArrayList<IRepositoryViewObject> assosicatedObjs = new ArrayList<IRepositoryViewObject>();
                assosicatedObjs.add(mapInfoObject);
                return assosicatedObjs;
            }
        }
        return super.getAssociatedObjects(obj);
    }

    IMatchRuleMapInfoService service = null;

    private IMatchRuleMapInfoService getService() {
        if (service == null) {
            service = ServiceUtil.getService(IMatchRuleMapInfoService.class);
        }
        return service;
    }

    private IRepositoryViewObject convertToMapInfoObject(IRepositoryViewObject viewObj) {

        if (getService() != null && viewObj != null) {
            Item item = viewObj.getProperty().getItem();
            if (item != null) {
                IRepositoryViewObject matchRuleViewObj = getService().generateWSMatchRuleObject(item);
                return matchRuleViewObj;
            }
        }
        return null;
    }
}
