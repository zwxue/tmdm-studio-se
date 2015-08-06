// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.export;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPage;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.views.ServerView;

public class ExportItemsAction extends Action {

    private static Log log = LogFactory.getLog(ExportItemsAction.class);

    private ServerView view = null;

    private TreeObject xobject = null;

    private IWorkbenchPage page = null;

    public ExportItemsAction(TreeObject xobject, IWorkbenchPage page) {
        super();
        this.xobject = xobject;
        this.page = page;
        setDetails();
    }

    public ExportItemsAction(ServerView view) {
        super();
        this.view = view;
        setDetails();
    }

    private void setDetails() {
        setImageDescriptor(ImageCache.getImage(EImage.EXPORT.getPath()));
        setText(Messages.ExportItemsAction_Text);
        setToolTipText(Messages.ExportItemsAction_ActionTip);
    }

    public void run() {
        try {
            super.run();
            ISelection selection = null;
            if (this.view != null) { // called from ServerView
                selection = view.getViewer().getSelection();
                xobject = (TreeObject) ((IStructuredSelection) selection).getFirstElement();
            }

            ExportItemsWizard wizard = new ExportItemsWizard((IStructuredSelection) selection);
            WizardDialog dialog = new WizardDialog(view.getSite().getShell(), wizard);
            dialog.create();
            dialog.getShell().setText(Messages.ExportItemsAction_ActionTip);
            dialog.open();
            // DataClusterExportDialog dialog=new DataClusterExportDialog(view.getSite().getShell(),xobject);
            // dialog.create();
            // //dialog.getShell().setSize(new Point(500,200));
            // dialog.open();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(view.getSite().getShell(), Messages._Error,
                    Messages.bind(Messages.ExportItemsAction_ErrorMsg, e.getLocalizedMessage()));
        }
    }
}
