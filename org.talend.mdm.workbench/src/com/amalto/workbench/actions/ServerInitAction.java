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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.IXObjectModelListener;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSInitData;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * @deprecated
 * 
 * 
 */
public class ServerInitAction extends Action {

    private Log log = LogFactory.getLog(ServerInitAction.class);

    private ServerView view = null;

    public ServerInitAction(ServerView view) {
        super();
        this.view = view;
        setImageDescriptor(ImageCache.getImage("icons/zap.gif"));//$NON-NLS-1$
        setText(Messages.ServerInitAction_Init);
        setToolTipText(Messages.ServerInitAction_ActionTip + IConstants.TALEND + Messages.ServerInitAction_ActionTipA);

    }

    public void run() {
        try {
            super.run();
            boolean confirm = MessageDialog.openConfirm(view.getSite().getShell(), Messages.ServerInitAction_InitMDMServer,
                    Messages.ServerInitAction_ConfirmContent);
            if (!confirm)
                return;
            boolean zap = MessageDialog.openQuestion(view.getSite().getShell(), Messages.ServerInitAction_QuestionTitle,
                    Messages.ServerInitAction_QuestionContent);
            if (zap)
                zap = MessageDialog.openConfirm(view.getSite().getShell(), Messages.ServerInitAction_InitMDMServer,
                        Messages.ServerInitAction_ConfirmContent1);

            FileDialog fd = new FileDialog(view.getSite().getShell(), SWT.OPEN);
            fd.setText(Messages.ServerInitAction_FileDialogTitle);
            String filename = fd.open();
            if (filename == null)
                return;

            BufferedReader in = null;
            in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf-8"));//$NON-NLS-1$
            String xml = "";//$NON-NLS-1$
            String line;
            while ((line = in.readLine()) != null)
                xml += line + "\n";//$NON-NLS-1$

            ISelection selection = view.getViewer().getSelection();
            TreeObject xobject = (TreeObject) ((IStructuredSelection) selection).getFirstElement();
            XtentisPort port = Util.getPort(new URL(xobject.getEndpointAddress()), xobject.getUniverse(), xobject.getUsername(),
                    xobject.getPassword());

            port.initMDM(new WSInitData(zap, xml));
            xobject.getServerRoot().fireEvent(IXObjectModelListener.NEED_REFRESH, null, xobject.getServerRoot());
            MessageDialog.openInformation(view.getSite().getShell(), Messages.ServerInitAction_InitMDMServer, Messages.ServerInitAction_ConfirmContent2);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(view.getSite().getShell(), Messages._Error, Messages.ServerInitAction_ErrorMsg
                    + e.getLocalizedMessage());
        }
    }

    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

}
