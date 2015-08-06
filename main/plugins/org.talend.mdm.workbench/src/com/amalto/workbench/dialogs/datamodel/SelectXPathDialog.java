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
package com.amalto.workbench.dialogs.datamodel;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.models.infoextractor.IAllDataModelHolder;
import com.amalto.workbench.widgets.composites.SelectXPathComposite;

public class SelectXPathDialog extends Dialog {

    private SelectXPathComposite selectXPathComposite;

    private IAllDataModelHolder allDataModelHolder;

    private String defaultSelectedDataModel;

    private String conceptName;

    private String selectedXPath = "";//$NON-NLS-1$

    public SelectXPathDialog(Shell parentShell, IAllDataModelHolder allDataModelHolder) {
        this(parentShell, allDataModelHolder, null, null);
    }

    public SelectXPathDialog(Shell parentShell, IAllDataModelHolder allDataModelHolder, String defaultSelectedDataModel) {
        this(parentShell, allDataModelHolder, defaultSelectedDataModel, null);
    }

    public SelectXPathDialog(Shell parentShell, IAllDataModelHolder allDataModelHolder, String defaultSelectedDataModel,
            String conceptName) {
        super(parentShell);

        this.allDataModelHolder = allDataModelHolder;
        this.defaultSelectedDataModel = defaultSelectedDataModel;
        this.conceptName = conceptName;
    }

    @Override
    protected Control createDialogArea(Composite parent) {

        getShell().setText(Messages.SelectXPathDialog_SetXPath);

        Composite container = (Composite) super.createDialogArea(parent);

        selectXPathComposite = new SelectXPathComposite(container, SWT.NONE, allDataModelHolder, defaultSelectedDataModel,
                conceptName);
        selectXPathComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        return container;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    @Override
    protected Point getInitialSize() {
        return new Point(500, 575);
    }

    protected int getShellStyle() {
        return super.getShellStyle() | SWT.MIN | SWT.MAX | SWT.RESIZE;
    }

    public String getSelectedXPath() {
        return selectedXPath.replaceAll("'|\"", "");//$NON-NLS-1$//$NON-NLS-2$
    }

    @Override
    protected void okPressed() {
        selectedXPath = selectXPathComposite.getSelectedXPath();
        super.okPressed();
    }

}
