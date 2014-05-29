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
package com.amalto.workbench.editors.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


/**
 * created by liusongbo on 2014-5-20
 */
public class MatchDetailContentDialog extends Dialog {

    private String content;

    protected MatchDetailContentDialog(Shell parentShell) {
        super(parentShell);
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setSize(600, 550);
        newShell.setText("Match Detail");
    }

    @Override
    protected void initializeBounds() {
        super.initializeBounds();
        Point location = getInitialLocation(getShell().getSize());
        getShell().setLocation(location.x, location.y);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite mainComp = (Composite) super.createDialogArea(parent);
        Text text = new Text(mainComp, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        text.setEditable(false);
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        text.setText(content);

        return mainComp;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }

    public void setInput(String matchResult) {
        this.content = matchResult;
    }
}
