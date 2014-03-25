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
import org.eclipse.jface.dialogs.ProgressMonitorDialog;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XtentisServerObjectsRetriever;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.views.ServerView;

public class RefreshAllServerAction extends Action {

    private static Log log = LogFactory.getLog(RefreshAllServerAction.class);

    private ServerView view;

    public RefreshAllServerAction(ServerView view) {
        super();
        this.view = view;
        setImageDescriptor(ImageCache.getImage(EImage.REFRESH.getPath()));
        setText(Messages.RefreshAllServerAction_Text);
        setToolTipText(Messages.RefreshAllServerAction_ActionTip);
    }

    @Override
    public void run() {
        doRun();
    }

    public void doRun() {
        for (TreeParent serverRoot : view.getServers()) {
            try {
                String server = (String) serverRoot.getWsKey(); // we are at server root

                XtentisServerObjectsRetriever retriever = new XtentisServerObjectsRetriever(serverRoot.getName(), server,
                        serverRoot.getUsername(), serverRoot.getPassword(), serverRoot.getUser().getUniverse(), view);

                new ProgressMonitorDialog(view.getSite().getShell()).run(true, true, retriever);
                serverRoot.synchronizeWith(retriever.getServerRoot());
                ServerView.show().getViewer().refresh();
                LocalTreeObjectRepository.getInstance().setLazySaveStrategy(false, serverRoot);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

}
