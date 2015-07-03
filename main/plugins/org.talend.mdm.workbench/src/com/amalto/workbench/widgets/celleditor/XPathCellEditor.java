// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.amalto.workbench.dialogs.datamodel.SelectXPathDialog;
import com.amalto.workbench.models.infoextractor.IAllDataModelHolder;

public class XPathCellEditor extends EditableDialogCellEditor {

    public interface IXPathUpdate {

        public String updateXPath(String xpath);
    }

    private IAllDataModelHolder allDataModelHolder;

    private IXPathUpdate xpathUpdate = null;

    private boolean lock;

    public XPathCellEditor(Composite parent, IAllDataModelHolder allDataModelHolder) {
        super(parent);
        this.allDataModelHolder = allDataModelHolder;
    }

    public XPathCellEditor(Composite parent, IAllDataModelHolder allDataModelHolder, IXPathUpdate xpathUpdate) {
        this(parent, allDataModelHolder);
        this.xpathUpdate = xpathUpdate;
    }

    public IAllDataModelHolder getAllDataModelHolder() {
        return allDataModelHolder;
    }

    public void setAllDataModelHolder(IAllDataModelHolder allDataModelHolder) {

        if (allDataModelHolder == null) {
            return;
        }

        this.allDataModelHolder = allDataModelHolder;
    }

    @Override
    protected Object openDialogBox(Control cellEditorWindow) {

        SelectXPathDialog dialog = new SelectXPathDialog(cellEditorWindow.getShell(), allDataModelHolder,
                allDataModelHolder.getDefaultDataModel(), allDataModelHolder.getDefaultEntity());

        if (dialog.open() != Window.OK) {
            return null;
        }
        dialog.setLock(lock);
        String xpath = dialog.getSelectedXPath();
        if (xpathUpdate != null) {
            return xpathUpdate.updateXPath(xpath);
        }
        return xpath;

    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    @Override
    protected boolean validate() {
        String newValue = txtEdit.getText().trim();
        return validateXpath(newValue);
    }

    public static boolean validateXpath(String value) {
        if (value.length() == 0) {
            return true;
        }
        Pattern pattern = Pattern.compile("\\.|([a-zA-Z]|\\d|\\/)+"); //$NON-NLS-1$
        Matcher matcher = pattern.matcher(value);
        boolean matches = matcher.matches();

        return matches;
    }

    @Override
    protected void restoreValue() {
        updateContents((String) doGetValue());
    }

}
