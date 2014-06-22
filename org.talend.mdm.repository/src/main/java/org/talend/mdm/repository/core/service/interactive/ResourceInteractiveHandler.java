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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.command.deploy.AbstractDeployCommand;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.WSResourceItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSResourceE;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.utils.HttpClientUtil;
import com.amalto.workbench.utils.XtentisException;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ResourceInteractiveHandler extends AbstractInteractiveHandler {

    Logger log = Logger.getLogger(ResourceInteractiveHandler.class);

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_RESOURCE;
    }

    public String getLabel() {

        return Messages._Resource;
    }

    @Override
    public boolean deploy(AbstractDeployCommand cmd) throws RemoteException, XtentisException {
        return processImage(cmd, false);
    }

    @Override
    public Object convert(Item item, MDMServerObject serverObj) {
        return null;
    }

    @Override
    public boolean remove(AbstractDeployCommand cmd) throws RemoteException, XtentisException {
        return processImage(cmd, true);
    }

    private boolean processImage(AbstractDeployCommand cmd, boolean deleteFile) throws XtentisException {
        IRepositoryViewObject viewObj = cmd.getViewObject();
        MDMServerDef serverDef = cmd.getServerDef();
        String uripre = serverDef.getProtocol() + serverDef.getHost() + ":" + serverDef.getPort(); //$NON-NLS-1$ 
        Item item = viewObj.getProperty().getItem();
        WSResourceE rs = ((WSResourceItem) item).getResource();
        String fileExtension = rs.getFileExtension();
        String imageCatalog = rs.getImageCatalog();
        String name = rs.getUniqueName();
        IFile referenceFile = RepositoryResourceUtil.findReferenceFile(getRepositoryObjectType(), item, fileExtension);
        String path = referenceFile.getLocation().toOSString();
        String url = "/imageserver/secure/ImageUploadServlet";//$NON-NLS-1$
        if (deleteFile) {
            if (imageCatalog != null) {
                String encodedName = name;
                try {
                    encodedName = URLEncoder.encode(name, "utf-8"); //$NON-NLS-1$
                } catch (UnsupportedEncodingException e) {
                    log.error(e.getMessage(), e);
                }

                String uri = "upload/" + imageCatalog + '/' + encodedName;//$NON-NLS-1$
                url = "/imageserver/secure/ImageDeleteServlet?uri=" + uri;//$NON-NLS-1$
            } else {
                return false;
            }
        }
        String imageUri = HttpClientUtil.uploadImageFile(uripre + url, path, name, imageCatalog, serverDef.getUser(),
                serverDef.getPasswd(), null);
        if (imageUri != null && imageUri.length() > 0) {
            String[] strs = imageUri.split("/");//$NON-NLS-1$
            if (strs.length == 3) {// the second one is imagecatalog
                rs.setImageCatalog(strs[1]);
            }
        }
        return true;
    }
}
