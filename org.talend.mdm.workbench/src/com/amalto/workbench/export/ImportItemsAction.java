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
package com.amalto.workbench.export;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPage;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.views.ServerView;

public class ImportItemsAction extends Action {

    private ServerView view = null;

    private TreeObject xobject = null;

    private IWorkbenchPage page = null;

    private String filename;

    private String server;

    public ImportItemsAction(TreeObject xobject, IWorkbenchPage page) {
        super();
        this.xobject = xobject;
        this.page = page;
        setDetails();
    }

    public ImportItemsAction(ServerView view) {
        super();
        this.view = view;
        setDetails();
    }

    private void setDetails() {
        setImageDescriptor(ImageCache.getImage(EImage.IMPORT.getPath()));
        setText(Messages.ImportItemsAction_Import);
        setToolTipText(Messages.ImportItemsAction_ImportItems);
    }

    public void run() {

        super.run();
        ISelection selection = null;
        if (this.view != null) { // called from ServerView
            selection = view.getViewer().getSelection();
            xobject = (TreeObject) ((IStructuredSelection) selection).getFirstElement();
        }

        ImportItemsWizard wizard = new ImportItemsWizard((IStructuredSelection) selection, view);
        WizardDialog dialog = new WizardDialog(view.getSite().getShell(), wizard);
        dialog.create();
        dialog.getShell().setSize(600, 550);
        dialog.getShell().layout(true);
        dialog.getShell().setText(Messages.ImportItemsAction_ImportObjects);
        dialog.open();

    }
}
