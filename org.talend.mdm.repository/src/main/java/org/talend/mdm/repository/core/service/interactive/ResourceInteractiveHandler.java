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
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.WSResourceItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ResourceInteractiveHandler extends AbstractInteractiveHandler {

    Logger log = Logger.getLogger(ResourceInteractiveHandler.class);

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_RESOURCE;
    }

    public String getLabel() {

        return "Resource";
    }

    @Override
    public boolean deployMDM(MDMServerDef serverDef, XtentisPort port, Item item, MDMServerObject serverObj)
            throws RemoteException {
        String uripre = "http://" + serverDef.getHost() + ":" + serverDef.getPort(); //$NON-NLS-1$
        String fileExtension = ((WSResourceItem) item).getResource().getFileExtension();
        IFile referenceFile = RepositoryResourceUtil.findReferenceFile(getRepositoryObjectType(), item, fileExtension);
        String path = referenceFile.getLocation().toOSString();
        try {
            String fileName = Util.uploadImageFile(uripre + "/imageserver/secure/ImageUploadServlet?changeFileName=false", path//$NON-NLS-1$
                    , "admin", "talend", null);
            return true;
        } catch (XtentisException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public Object convert(Item item, MDMServerObject serverObj) {
        // WSDataModel dataModel = (WSDataModel) super.convert(item, serverObj);
        // IFile file = RepositoryResourceUtil.findReferenceFile(getRepositoryObjectType(), item, FILE_EXTENSION);
        // String schema = RepositoryResourceUtil.getTextFileContent(file, ENCODE);
        // dataModel.setXsdSchema(schema);
        // return dataModel;
        return null;
    }

}
