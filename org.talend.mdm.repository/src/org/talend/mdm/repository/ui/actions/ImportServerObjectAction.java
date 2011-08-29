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
package org.talend.mdm.repository.ui.actions;

import org.eclipse.jface.wizard.WizardDialog;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.wizards.imports.ImportServerObjectWizard;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC achen  class global comment. Detailled comment
 */
public class ImportServerObjectAction extends AbstractRepositoryAction {

    /**
     * DOC achen ImportServerObjectAction constructor comment.
     * 
     * @param text
     */
    public ImportServerObjectAction() {
        super(Messages.ImportServerObject);
        setImageDescriptor(ImageCache.getImage(EImage.IMPORT.getPath()));
    }

    public String getGroupName() {
        return GROUP_EXPORT;
    }

    public void run() {

        ImportServerObjectWizard wizard = new ImportServerObjectWizard(commonViewer);

        WizardDialog dialog = new WizardDialog(getShell(), wizard);
        dialog.create();
        dialog.getShell().setSize(600, 650);
        dialog.getShell().layout(true);
        dialog.getShell().setText(Messages.ImportServerObjectAction_importServerObject);
        dialog.open();
    }

}
