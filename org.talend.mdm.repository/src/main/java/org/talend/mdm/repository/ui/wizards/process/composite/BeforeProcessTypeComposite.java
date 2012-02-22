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
package org.talend.mdm.repository.ui.wizards.process.composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.wizards.process.ConfigReturnMessagePage;
import org.talend.mdm.repository.ui.wizards.process.NewProcessWizard;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class BeforeProcessTypeComposite extends AbstractProcessTypeComposite {

    private Button beforeSaveBun;

    private Button beforeDeleteBun;

    /**
     * DOC hbhong BeforeProcessTypeComposite constructor comment.
     * 
     * @param parent
     */
    public BeforeProcessTypeComposite(Composite parent, SelectionListener selectionListener) {
        super(parent, selectionListener);
        setLayout(new GridLayout(1, false));

        beforeSaveBun = new Button(this, SWT.RADIO);
        beforeSaveBun.addSelectionListener(selectionListener);
        beforeSaveBun.setSelection(true);
        beforeSaveBun.setText(Messages.BeforeProcessTypeComposite_createBeforeSavingProcess);

        beforeDeleteBun = new Button(this, SWT.RADIO);
        beforeDeleteBun.setText(Messages.BeforeProcessTypeComposite_createBeforeDeletingProcess);
        beforeDeleteBun.addSelectionListener(selectionListener);
    }

    public int getCurrentProcessType() {
        if (beforeSaveBun.getSelection())
            return NewProcessWizard.BEFORE_SAVING;
        if (beforeDeleteBun.getSelection())
            return NewProcessWizard.BEFORE_DELETING;
        return -1;
    }

    public boolean needShowSelectEntityBun() {
        return true;
    }

    public String getProcessPrefix() {
        switch (getCurrentProcessType()) {
        case NewProcessWizard.BEFORE_SAVING:
            return "beforeSaving_"; //$NON-NLS-1$
        case NewProcessWizard.BEFORE_DELETING:
            return "beforeDeleting_"; //$NON-NLS-1$
        }
        return ""; //$NON-NLS-1$
    }

    public String getConfigWizardPageId() {
        return ConfigReturnMessagePage.PAGE_ID;
    }

}
