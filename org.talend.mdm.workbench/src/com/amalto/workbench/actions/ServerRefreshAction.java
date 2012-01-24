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

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.talend.mdm.commmon.util.core.CommonUtil;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XtentisServerObjectsRetriever;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.views.ServerView;

public class ServerRefreshAction extends Action {

    private static Log log = LogFactory.getLog(ServerRefreshAction.class);

    protected ServerView view = null;

    protected String server = null;

    protected TreeParent serverRoot = null;

    protected TreeParent forcedRoot = null;

    protected TreeParent newRoot = null;

    public ServerRefreshAction(ServerView view, TreeParent forcedRoot) {
        this(view);
        this.forcedRoot = forcedRoot;
    }

    public ServerRefreshAction(ServerView view) {
        super();
        this.view = view;
        setImageDescriptor(ImageCache.getImage(EImage.REFRESH.getPath()));
        setText("Refresh");
        setToolTipText("Refresh the " + IConstants.TALEND + " Server Object(s)");
    }

    @Override
    public void run() {
        try {
            doRun();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(view.getSite().getShell(), "Error", "Error while refreshing the " + IConstants.TALEND
                    + " Server Objects: " + e.getLocalizedMessage());
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
            server = (String) serverRoot.getWsKey(); // we are at server root

            XtentisServerObjectsRetriever retriever = new XtentisServerObjectsRetriever(serverRoot.getName(), server,
                    serverRoot.getUsername(), serverRoot.getPassword(), serverRoot.getUser().getUniverse(), view);

            new ProgressMonitorDialog(view.getSite().getShell()).run(true, true, retriever);
            ServerRefreshAction.this.serverRoot.synchronizeWith(retriever.getServerRoot());
            ServerView.show().getViewer().refresh();
            LocalTreeObjectRepository.getInstance().setLazySaveStrategy(false, serverRoot);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            String msg;
            if (e instanceof InvocationTargetException)
                msg = CommonUtil.getErrMsgFromException(e.getCause());
            else
                msg = e.getLocalizedMessage();
            throw new Exception("Error while refreshing the " + IConstants.TALEND + " Server Objects: " + msg);
        }
    }

    @Override
    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

}
