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
package com.amalto.workbench.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.amalto.workbench.widgets.SchematronExpressBuilder;

public class ValidationRuleExcpressDialog extends Dialog {

    private String title;

    private SchematronExpressBuilder builder;

    String value;

    String express;

    String conceptName;

    private boolean isAbsoluteXPath = false;

    public ValidationRuleExcpressDialog(Shell parentShell, String title, String value, String conceptName) {
        this(parentShell, title, value, conceptName, false);
    }

    public ValidationRuleExcpressDialog(Shell parentShell, String title, String value, String conceptName, boolean isAbsoluteXPath) {
        super(parentShell);
        this.title = title;
        this.value = value;
        this.conceptName = conceptName;
        this.isAbsoluteXPath = isAbsoluteXPath;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        parent.getShell().setText(this.title);
        Composite composite = (Composite) super.createDialogArea(parent);
        builder = new SchematronExpressBuilder(composite, value, conceptName, isAbsoluteXPath);
        return composite;
    }

    @Override
    protected void okPressed() {
        express = builder.getText();
        super.okPressed();
    }

    public String getExpression() {
        return express;
    }

    @Override
    protected boolean isResizable() {
        return false;
    }
}
