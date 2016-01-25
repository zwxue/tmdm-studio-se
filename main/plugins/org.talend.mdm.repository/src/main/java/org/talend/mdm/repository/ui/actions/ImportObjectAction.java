// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.ui.wizards.imports.MDMImportRepositoryItemsWizard;

import com.amalto.workbench.export.ExportItemsAction;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC hywang class global comment. Detailled comment
 */
public class ImportObjectAction extends AbstractRepositoryAction {

    private static Log log = LogFactory.getLog(ExportItemsAction.class);

    private MDMRepositoryView view = null;

    public ImportObjectAction() {
        super(Messages.ImportObjectAction_label);
        setImageDescriptor(ImageCache.getImage(EImage.IMPORT.getPath()));
    }

    protected void doRun() {

        try {
            ISelection selection = null;
            // if (this.view != null) { // called from ServerView
            view = MDMRepositoryView.show();
            selection = view.getCommonViewer().getSelection();
            // }
            MDMImportRepositoryItemsWizard wizard = new MDMImportRepositoryItemsWizard((IStructuredSelection) selection);
            WizardDialog dialog = new WizardDialog(view.getSite().getShell(), wizard);
            dialog.create();
            dialog.getShell().setText(Messages.ImportObjectAction_importRepositoryItem);
            dialog.open();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(view.getSite().getShell(), Messages.ImportObjectAction_error,
                    Messages.ImportObjectAction_hasError + e.getLocalizedMessage());
        }
    }

    @Override
    public String getGroupName() {
        return GROUP_EXPORT;
    }

}
