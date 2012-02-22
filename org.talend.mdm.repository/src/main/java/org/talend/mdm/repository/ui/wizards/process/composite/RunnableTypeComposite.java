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
import org.talend.mdm.repository.ui.wizards.process.ConfigRedirectURLPage;
import org.talend.mdm.repository.ui.wizards.process.NewProcessWizard;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RunnableTypeComposite extends AbstractProcessTypeComposite {

    private Button runnableBun;

    private Button standaloneBun;

    /**
     * DOC hbhong BeforeProcessTypeComposite constructor comment.
     * 
     * @param parent
     */
    public RunnableTypeComposite(Composite parent, SelectionListener selectionListener) {
        super(parent, selectionListener);
        setLayout(new GridLayout(1, false));

        runnableBun = new Button(this, SWT.RADIO);
        runnableBun.addSelectionListener(selectionListener);
        runnableBun.setSelection(true);
        runnableBun.setText(Messages.RunnableTypeComposite_createRunnableProcess);

        standaloneBun = new Button(this, SWT.RADIO);
        standaloneBun.setText(Messages.RunnableTypeComposite_createStandaloneProcess);
        standaloneBun.addSelectionListener(selectionListener);
        // TODO Auto-generated constructor stub
    }

    public int getCurrentProcessType() {
        if (runnableBun.getSelection())
            return NewProcessWizard.RUNNABLE_RUNNABLE;
        if (standaloneBun.getSelection())
            return NewProcessWizard.RUNNABLE_STANDALONE;
        return -1;
    }

    public boolean needShowSelectEntityBun() {
        return true;
    }

    public String getProcessPrefix() {
        switch (getCurrentProcessType()) {
        case NewProcessWizard.RUNNABLE_RUNNABLE:
            return "Runnable_"; //$NON-NLS-1$
        case NewProcessWizard.RUNNABLE_STANDALONE:
            return "Runnable#"; //$NON-NLS-1$
        }
        return ""; //$NON-NLS-1$
    }

    public String getConfigWizardPageId() {
        return ConfigRedirectURLPage.PAGE_ID;
    }

}
