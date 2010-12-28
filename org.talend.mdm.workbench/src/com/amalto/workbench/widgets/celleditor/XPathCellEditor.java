package com.amalto.workbench.widgets.celleditor;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.amalto.workbench.dialogs.datamodel.SelectXPathDialog;
import com.amalto.workbench.models.infoextractor.IAllDataModelHolder;

public class XPathCellEditor extends EditableDialogCellEditor {

    private IAllDataModelHolder allDataModelHolder;

    private String defaultDataModelName;

    public XPathCellEditor(Composite parent, IAllDataModelHolder allDataModelHolder) {
        this(parent, allDataModelHolder, "");
    }

    public XPathCellEditor(Composite parent, IAllDataModelHolder allDataModelHolder, String defaultDataModelName) {
        super(parent);
        this.allDataModelHolder = allDataModelHolder;
        this.defaultDataModelName = defaultDataModelName;
    }

    public IAllDataModelHolder getAllDataModelHolder() {
        return allDataModelHolder;
    }

    public void setAllDataModelHolder(IAllDataModelHolder allDataModelHolder) {

        if (allDataModelHolder == null)
            return;

        this.allDataModelHolder = allDataModelHolder;
    }

    public String getDefaultDataModelName() {
        return defaultDataModelName;
    }

    public void setDefaultDataModelName(String defaultDataModelName) {
        this.defaultDataModelName = defaultDataModelName;
    }

    @Override
    protected Object openDialogBox(Control cellEditorWindow) {

        SelectXPathDialog dialog = new SelectXPathDialog(cellEditorWindow.getShell(), allDataModelHolder, defaultDataModelName);

        if (dialog.open() != Window.OK)
            return null;

        return dialog.getSelectedXPath();
    }

}
