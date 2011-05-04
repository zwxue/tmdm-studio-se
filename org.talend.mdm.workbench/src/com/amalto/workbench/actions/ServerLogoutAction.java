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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.amalto.workbench.editors.XObjectBrowser;
import com.amalto.workbench.editors.XObjectEditor;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.utils.MDMServerHelper;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSLogout;

public class ServerLogoutAction extends Action {

    private static final Log log = LogFactory.getLog(ServerLogoutAction.class);

    private ServerView view;

    private boolean remove;

    public ServerLogoutAction(ServerView view, boolean remove) {
        this.view = view;
        this.remove = remove;
        if (remove) {
            setText("Logout and Remove");
            setToolTipText("Logout and Remove " + IConstants.TALEND + " Server");
        } else {
            setText("Logout");
            setToolTipText("Logout from the " + IConstants.TALEND + " Server");
        }
        setImageDescriptor(ImageCache.getImage(EImage.LOGOUT.getPath()));
    }

    @Override
    public void run() {
        TreeParent serverRoot = (TreeParent) ((IStructuredSelection) view.getViewer().getSelection()).getFirstElement();

        if (remove
                && !MessageDialog.openConfirm(this.view.getSite().getShell(), "Delete server",
                        "Are you sure you want to delete the server connection '" + serverRoot.getDesc() + "' ?"))
            return;

        final String universe = serverRoot.getUniverse();
        final String username = serverRoot.getUsername();
        final String password = serverRoot.getPassword();
        final String endpointAddress = serverRoot.getEndpointAddress();

        TreeParent root = serverRoot.getParent();

        LocalTreeObjectRepository.getInstance().switchOffListening();
        LocalTreeObjectRepository.getInstance().setLazySaveStrategy(false, (TreeParent) serverRoot);
        // add by ymli; fix the bug:0011948:
        // All the tabs related to an MDM server connection should go away when loging out
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        int length = page.getEditors().length;
        String version = "";//$NON-NLS-1$
        String tabEndpointAddress = "";//$NON-NLS-1$
        String unserName = null;
        int j = 0;
        for (int i = 0; i < length; i++) {
            IEditorPart part = page.getEditors()[i - j];
            if (part instanceof XObjectBrowser) {
                version = ((TreeObject) ((XObjectBrowserInput) part.getEditorInput()).getModel()).getUniverse();
                tabEndpointAddress = ((TreeObject) ((XObjectBrowserInput) part.getEditorInput()).getModel()).getEndpointAddress();
                unserName = ((TreeObject) ((XObjectBrowserInput) part.getEditorInput()).getModel()).getUsername();
            } else if (part instanceof XObjectEditor) {
                version = ((XObjectEditor) part).getInitialXObject().getServerRoot().getUniverse();
                tabEndpointAddress = ((XObjectEditor) part).getInitialXObject().getServerRoot().getEndpointAddress();
                unserName = ((XObjectEditor) part).getInitialXObject().getServerRoot().getUsername();
            }
            if (serverRoot.getUniverse().equals(version) && endpointAddress.equals(tabEndpointAddress)
                    && serverRoot.getUsername().equals(unserName)) {
                page.closeEditor(part, false);
                j++;
            }
        }

        serverRoot.getParent().removeChild(serverRoot);
        view.getViewer().refresh();

        // attempt logout on the server side
        view.getViewer().getControl().getDisplay().syncExec(new Runnable() {

            public void run() {
                try {
                    Util.getPort(new URL(endpointAddress), universe, username, password).logout(new WSLogout());
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        });

        if (remove) {
            MDMServerHelper.deleteServer(serverRoot.getDesc());
        }

    }
}
