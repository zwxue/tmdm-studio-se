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
package com.amalto.workbench.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSRefreshCache;
import com.amalto.workbench.webservices.WSString;

public class ServerRefreshCacheAction extends Action {

    private static Log log = LogFactory.getLog(ServerRefreshAction.class);

    protected ServerView view = null;

    protected String server = null;

    protected TreeParent serverRoot = null;

    protected TreeParent forcedRoot = null;

    protected TreeParent newRoot = null;

    public ServerRefreshCacheAction(ServerView view, TreeParent forcedRoot) {
        this(view);
        this.forcedRoot = forcedRoot;
    }

    public ServerRefreshCacheAction(ServerView view) {
        super();
        this.view = view;
        setImageDescriptor(ImageCache.getImage(EImage.REFRESH.getPath()));
        setText(Messages.ServerRefreshCacheAction_Text);
        setToolTipText(Messages.ServerRefreshCacheAction_ActionTip);
    }

    public void run() {
        try {
            doRun();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
			if (!Util.handleConnectionException(view.getSite().getShell(), e,null)) {
				MessageDialog.openError(view.getSite().getShell(),
						Messages._Error, Messages.bind(Messages.ServerRefreshCacheAction_ErrorMsg,e.getLocalizedMessage()));
			}
        }
    }

    public void doRun() throws Exception {
        try {
            if (forcedRoot == null)
                // get it dynamically
                serverRoot = (TreeParent) ((IStructuredSelection) view.getViewer().getSelection()).getFirstElement();
            else
                serverRoot = forcedRoot;
            if (serverRoot == null)
                return;
            WSString ret=Util.getPort(serverRoot).refreshCache(new WSRefreshCache("ALL"));//$NON-NLS-1$
            MessageDialog.openInformation(null, Messages.ServerRefreshCacheAction_InformationTitle, ret.getValue());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new Exception(Messages.bind(Messages.ServerRefreshCacheAction_ExceptionInfo, e.getLocalizedMessage()));
        }
    }
}
