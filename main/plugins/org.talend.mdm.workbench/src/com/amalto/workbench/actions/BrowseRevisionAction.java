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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.amalto.workbench.dialogs.ErrorExceptionDialog;
import com.amalto.workbench.editors.XObjectRevisionBrowser;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.views.ServerView;

public class BrowseRevisionAction extends Action {

    private static Log log = LogFactory.getLog(BrowseRevisionAction.class);

    private ServerView server = null;

    public BrowseRevisionAction(ServerView serverView) {
        super();
        this.server = serverView;
        setImageDescriptor(ImageCache.getImage(EImage.BROWSE.getPath()));
        setText("Browse Revision");
        setToolTipText("Browse revision");
    }

    public void run() {
        try {
            super.run();

            ISelection selection = this.server.getViewer().getSelection();
            TreeObject xobject = (TreeObject) ((IStructuredSelection) selection).getFirstElement();
            // String name=xobject.getDisplayName().replaceAll("\\[.*\\]", "");
            server.getSite().getWorkbenchWindow().getActivePage()
                    .openEditor(new XObjectBrowserInput(xobject, xobject.getDisplayName()), XObjectRevisionBrowser.ID);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            ErrorExceptionDialog.openError(server.getSite().getShell(), "Error",
                    "An error occured trying to open the view browser: " + e.getLocalizedMessage());
        }
    }
}
