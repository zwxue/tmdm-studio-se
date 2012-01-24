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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;

import com.amalto.workbench.dialogs.LoginDialog;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;

public class ServerLoginAction extends Action implements SelectionListener {

    private static Log log = LogFactory.getLog(ServerLoginAction.class);

    private LoginDialog dialog = null;

    private ServerView view = null;

    public ServerLoginAction(ServerView view) {
        super();
        this.view = view;
        setImageDescriptor(ImageCache.getImage("icons/startserveraction.gif"));//$NON-NLS-1$
        setText("Login");
        setToolTipText("Add MDM Server Location");
    }

    @Override
    public void run() {
        try {
            super.run();
            dialog = new LoginDialog(this, view.getSite().getShell(), IConstants.TALEND + " Login");
            dialog.setBlockOnOpen(true);
            dialog.open();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

    /***************************************
     * Selection Listener on OK Button
     * 
     ***************************************/
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
            MessageDialog.openError(null, "Error", "The version of mdm studio is not compatible with that of server : \n" + cmp);
            return;
        }

        view.addServerTree(name, url, username, password, universe);

    }

    public void widgetDefaultSelected(SelectionEvent e) {
    }

}
