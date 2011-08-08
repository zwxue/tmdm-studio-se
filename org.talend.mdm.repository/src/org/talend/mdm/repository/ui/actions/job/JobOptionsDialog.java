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
package org.talend.mdm.repository.ui.actions.job;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class JobOptionsDialog extends Dialog {

    private String title;

    private boolean isExchange = true;

    private boolean isWar = true;

    private Button btnExchange;

    private Button btnItem;

    private Button btnWar;

    private Button btnZip;

    private boolean isTrigger = false;

    public JobOptionsDialog(Shell parentShell, String dialogTitle) {
        super(parentShell);
        this.title = dialogTitle;
    }

    public JobOptionsDialog(Shell parentShell, String dialogTitle, boolean isTrigger) {
        super(parentShell);
        this.title = dialogTitle;
        this.isTrigger = isTrigger;
    }

    protected Control createDialogArea(Composite parent) {
        // Should not really be here but well,....
        parent.getShell().setText(this.title);

        Composite composite = (Composite) super.createDialogArea(parent);
        composite.setLayout(new FillLayout(SWT.VERTICAL));

        if (!isTrigger) {
        Group group1 = new Group(composite, SWT.NONE);
        group1.setLayout(new FillLayout(SWT.VERTICAL));
        group1.setText("isExchange"); //$NON-NLS-1$

        btnExchange = new Button(group1, SWT.RADIO);
        btnExchange.setSelection(true);
        btnExchange.setText("Send a complete \"exchange\" document");

        btnItem = new Button(group1, SWT.RADIO);
        btnItem.setText("Only send an \"item\" document (backward compatibility)");

        }

        Group group2 = new Group(composite, SWT.NONE);
        group2.setLayout(new FillLayout(SWT.VERTICAL));
        group2.setText("suffix");//$NON-NLS-1$

        btnWar = new Button(group2, SWT.RADIO);
        btnWar.setSelection(true);
        btnWar.setText("war");//$NON-NLS-1$

        btnZip = new Button(group2, SWT.RADIO);
        btnZip.setText("zip");//$NON-NLS-1$

        return composite;
    }

    protected void buttonPressed(int buttonId) {

        if (btnExchange != null)
        isExchange = btnExchange.getSelection();
        isWar = btnWar.getSelection();

        super.buttonPressed(buttonId);
    }

    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        if (title != null) {
            shell.setText(title);
        }
    }

    protected void createButtonsForButtonBar(Composite parent) {
        // create OK and Cancel buttons by default
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);

    }

    public boolean isExchange() {
        return isExchange;
    }

    public boolean isWar() {
        return isWar;
    }

    public void setExchange(boolean isExchange) {
        this.isExchange = isExchange;
    }

}
