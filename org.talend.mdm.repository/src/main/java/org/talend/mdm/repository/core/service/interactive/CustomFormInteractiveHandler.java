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

import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.command.deploy.AbstractDeployCommand;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmproperties.WSCustomFormItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSCustomForm;
import com.amalto.workbench.webservices.WSCustomFormPK;
import com.amalto.workbench.webservices.WSDeleteCustomForm;
import com.amalto.workbench.webservices.WSPutCustomForm;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class CustomFormInteractiveHandler extends AbstractInteractiveHandler {

    /**
     * 
     */
    private static final String ENCODE = "UTF-8"; //$NON-NLS-1$

    /**
     * 
     */
    private static final String FILE_EXTENSION = "form"; //$NON-NLS-1$

    Logger log = Logger.getLogger(CustomFormInteractiveHandler.class);

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_CUSTOM_FORM;
    }

    public String getLabel() {

        return Messages._CustomeLayout;
    }

    public boolean doDeployWSObject(XtentisPort port, Object wsObj) throws RemoteException {
        if (wsObj != null) {
            port.putCustomForm(new WSPutCustomForm((WSCustomForm) wsObj));
            return true;
        }
        return false;
    }




    public boolean doRemove(XtentisPort port, AbstractDeployCommand cmd) throws RemoteException, XtentisException {
        IRepositoryViewObject viewObj = cmd.getViewObject();
        Item item = viewObj.getProperty().getItem();
        MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
        Object wsObj = convert(item, serverObject);
        if (wsObj != null) {
            WSCustomForm wsForm = (WSCustomForm) wsObj;
            port.deleteCustomForm(new WSDeleteCustomForm(new WSCustomFormPK(wsForm.getDatamodel(), wsForm.getEntity(), cmd
                    .getObjName())));
            return true;
        }
        return false;
    }

    @Override
    public Object convert(Item item, MDMServerObject serverObj) {
        WSCustomForm customForm = (WSCustomForm) super.convert(item, serverObj);
        IFile file = RepositoryResourceUtil.findReferenceFile(getRepositoryObjectType(), item, FILE_EXTENSION);
        String diagramContent = RepositoryResourceUtil.getTextFileContent(file, ENCODE);
        customForm.setXml(diagramContent);
        return customForm;
    }

    @Override
    public void assertPropertyIsInited(Item item) {
        IFile file = RepositoryResourceUtil.findReferenceFile(getRepositoryObjectType(), item, FILE_EXTENSION);
        String diagramContent = RepositoryResourceUtil.getTextFileContent(file, ENCODE);
        ((WSCustomFormItem) item).getCustomForm().setXml(diagramContent);
    }

}
