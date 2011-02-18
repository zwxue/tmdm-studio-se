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
package com.amalto.workbench.actions;

import java.net.URL;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;

public class DeleteJobAction extends AbstractAction {

    private static Log log = LogFactory.getLog(DeleteJobAction.class);

    public DeleteJobAction() {
        super();
        setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
        setText("Delete");
        setToolTipText("Delete");
    }

    public void run() {
        if (this.server == null) { // called from ServerView
            return;
        }
        closePage();

        IStructuredSelection selection = (IStructuredSelection) server.getViewer().getSelection();
        for (Iterator<TreeObject> iter = selection.iterator(); iter.hasNext();) {
            TreeObject xobject = iter.next();
            try {
                deleteJob(xobject);
            } catch (Exception e) {
                log.error(e.getStackTrace());
            }
        }

    }

    private void deleteJob(TreeObject xobject) throws Exception {
        if (xobject.getType() != TreeObject.JOB)
            return;

        String filename = xobject.getDisplayName();// TODO
        String endpointaddress = xobject.getEndpointAddress();
        // String filename= xobject.getDisplayName();//TODO
        String uploadURL = new URL(endpointaddress).getProtocol() + "://" + new URL(endpointaddress).getHost() + ":" //$NON-NLS-1$ //$NON-NLS-2$
                + new URL(endpointaddress).getPort() + "/datamanager/uploadFile?deletefile=" + filename; //$NON-NLS-1$
        Util.uploadFileToAppServer(uploadURL, filename, "admin", "talend");//$NON-NLS-1$ //$NON-NLS-2$
        xobject.getParent().removeChild(xobject);
    }

}
