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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;

import com.amalto.workbench.editors.XObjectBrowser;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.views.ServerView;

public class BrowseViewAction extends Action {

    private static Log log = LogFactory.getLog(BrowseViewAction.class);

    private ServerView server = null;

    private TreeObject selObj;

    public BrowseViewAction(ServerView serverView) {
        super();
        this.server = serverView;

        setImageDescriptor(ImageCache.getImage(EImage.BROWSE.getPath()));
        setText("Test");
        setToolTipText("Browse Content");
    }

    public void setObject(TreeObject obj) {
        this.selObj = obj;
    }

    public void run() {
        try {
            super.run();
            TreeObject xobject = null;
            if (selObj == null) {
                ISelection selection = this.server.getViewer().getSelection();
                xobject = (TreeObject) ((IStructuredSelection) selection).getFirstElement();
            } else {
                xobject = selObj;
            }

            server.getSite().getWorkbenchWindow().getActivePage()
                    .openEditor(new XObjectBrowserInput(xobject, xobject.getDisplayName()), XObjectBrowser.ID);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(server.getSite().getShell(), "Error", "An error occured trying to open the view browser: "
                    + e.getLocalizedMessage());
        }
    }

    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

}// Class EditDocumentAction

