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
