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

import java.util.Map;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.wizards.process.ConfigRedirectURLPage;
import org.talend.mdm.repository.ui.wizards.process.NewProcessWizard;

import com.amalto.workbench.dialogs.AnnotationLanguageLabelsDialog;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RunnableTypeComposite extends AbstractProcessTypeComposite {

    private Button runnableBun;

    private Button standaloneBun;

    private Text messageText;

    private Composite descContainer;

    /**
     * DOC hbhong BeforeProcessTypeComposite constructor comment.
     * 
     * @param parent
     */
    public RunnableTypeComposite(Composite parent, SelectionListener selectionListener) {
        super(parent, selectionListener);
        setLayout(new GridLayout(2, false));

        runnableBun = new Button(this, SWT.RADIO);
        runnableBun.addSelectionListener(selectionListener);
        runnableBun.setSelection(true);
        runnableBun.setText(Messages.RunnableTypeComposite_createRunnableProcess);

        descContainer = new Composite(this, SWT.NONE);
        descContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        descContainer.setLayout(new GridLayout(3, false));
        Label lblMessage = new Label(descContainer, SWT.NONE);
        lblMessage.setText(Messages.SelectProcessTypePage_descText);

        Button btnNewButton = new Button(descContainer, SWT.NONE);
        btnNewButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                AnnotationLanguageLabelsDialog dialog = new AnnotationLanguageLabelsDialog(null, null, getShell(),
                        Messages.ConfigReturnMessagePage_setMessage);
                if (dialog.open() == IDialogConstants.OK_ID) {
                    StringBuffer output = new StringBuffer();
                    for (Map.Entry<String, String> m : dialog.getDescriptionsMap().entrySet()) {
                        output.append("[").append(m.getKey().toUpperCase()).append(":").append(m.getValue()).append("]");//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$ 
                    }
                    messageText.setText(output.toString());
                }
            }
        });
        btnNewButton.setText(Messages.ConfigReturnMessagePage_selectMessage);

        messageText = new Text(descContainer, SWT.BORDER);
        messageText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                // getWizard().getContainer().updateButtons();
            }
        });
        messageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        standaloneBun = new Button(this, SWT.RADIO);
        standaloneBun.setText(Messages.RunnableTypeComposite_createStandaloneProcess);
        standaloneBun.addSelectionListener(selectionListener);

        runnableBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                descContainer.setVisible(true);
            }
        });
        standaloneBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                descContainer.setVisible(false);
            }
        });
    }

    public int getCurrentProcessType() {
        if (runnableBun.getSelection())
            return NewProcessWizard.RUNNABLE_RUNNABLE;
        if (standaloneBun.getSelection())
            return NewProcessWizard.RUNNABLE_STANDALONE;
        return -1;
    }

    public String getDesc() {
        if (descContainer.isVisible())
            return messageText.getText();
        else
            return null;
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
