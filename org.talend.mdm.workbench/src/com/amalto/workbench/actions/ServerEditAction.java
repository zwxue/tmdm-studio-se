// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
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
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.amalto.workbench.dialogs.LoginDialog;
import com.amalto.workbench.editors.XObjectBrowser;
import com.amalto.workbench.editors.XObjectEditor;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.utils.MDMServerDef;
import com.amalto.workbench.utils.MDMServerHelper;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSLogout;

public class ServerEditAction extends Action  implements SelectionListener{

    private static final Log log = LogFactory.getLog(ServerEditAction.class);

    private ServerView view;

    private LoginDialog dialog;

    private MDMServerDef serverDef;

 

    public ServerEditAction(ServerView view ) {
        this.view = view;
        setText(Messages.ServerEditAction_Edit);
        setToolTipText(Messages.ServerEditAction_EditServerLocation);
        setImageDescriptor(ImageCache.getImage(EImage.EDIT.getPath()));
    }

    @Override
    public void run() {
        TreeParent serverRoot = (TreeParent) ((IStructuredSelection) view.getViewer().getSelection()).getFirstElement();

        final String universe = serverRoot.getUniverse();
        final String username = serverRoot.getUsername();
        final String password = serverRoot.getPassword();
        final String name = serverRoot.getName();
        final String endpointAddress = serverRoot.getEndpointAddress();

        serverDef = MDMServerDef.parse(endpointAddress, username, password, universe, name);
        try {
            dialog = new LoginDialog(this, view.getSite().getShell(), Messages.bind(Messages.ServerEditAction_Login,IConstants.TALEND),serverDef);
            dialog.setBlockOnOpen(true);
            dialog.open();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        
    }

 
    public void widgetDefaultSelected(SelectionEvent arg0) {
    }

 
    public void widgetSelected(SelectionEvent e) {
        int buttonId = ((Integer) e.widget.getData()).intValue();
        if (IDialogConstants.OK_ID != buttonId || !dialog.isOK())
            return;
        String name = dialog.getName();
        String url = dialog.getServer();
        String username = dialog.getUsernameText();
        String password = dialog.getPasswordText();
        String universe = dialog.getUniverse();
        dialog.close();

        String cmp = Util.checkOnVersionCompatibility(url, username, password, universe);
        if (cmp != null) {
            MessageDialog.openError(null, Messages._Error, Messages.bind(Messages.ServerEditAction_ErrorMsg, cmp));
            return;
        }

        view.updateServerTree(serverDef,name, url, username, password, universe);
        serverDef=null;
    }
}
