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
package com.amalto.workbench.widgets.celleditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.amalto.workbench.dialogs.ValidationRuleExcpressDialog;


public class ValidationRuleExpressionCellEditor extends EditableDialogCellEditor {

    private String conceptName;

    public ValidationRuleExpressionCellEditor(Composite parent, String conceptName) {
        super(parent);

        this.conceptName = conceptName;
    }

    @Override
    protected Object openDialogBox(Control cellEditorWindow) {

        ValidationRuleExcpressDialog dialog = new ValidationRuleExcpressDialog(cellEditorWindow.getShell(),
                "Build Validation Rule Expression ", getValue() == null ? "" : getValue().toString(), conceptName);

        if (dialog.open() != Window.OK)
            return null;

        return dialog.getExpression();
    }

}
