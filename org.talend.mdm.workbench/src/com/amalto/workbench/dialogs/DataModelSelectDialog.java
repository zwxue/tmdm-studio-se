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
package com.amalto.workbench.dialogs;

import java.awt.Panel;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPartSite;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.ServerTreeContentProvider;
import com.amalto.workbench.providers.ServerTreeLabelProvider;

public class DataModelSelectDialog extends org.eclipse.jface.dialogs.Dialog {

    // Modified by hbhong,to fix bug 21784|Add a TreeParent parameter to constructor
    private final TreeParent treeParent;

    private IWorkbenchPartSite site;

    public DataModelSelectDialog(Shell parentShell, IWorkbenchPartSite iWorkbenchPartSite, TreeParent treeParent) {
        super(parentShell);
        this.site = iWorkbenchPartSite;
        this.treeParent = treeParent;
    }
    // The ending| bug:21784
    private static final long serialVersionUID = 1L;

    protected Label schemaLabel = null;

    private String title = Messages.DataModelSelectDialog_Title;

    private String xpath;

    protected Panel panel;

    protected Button add;

    protected SelectionListener listener;

    private ServerTreeContentProvider contentProvider;

    protected TreeViewer domViewer;

    @Override
    protected Control createDialogArea(Composite parent) {
        parent.getShell().setText(Messages.DataModelSelectDialog_SelectDataModel);
        Composite composite = (Composite) super.createDialogArea(parent);
        GridLayout layout = (GridLayout) composite.getLayout();
        layout.makeColumnsEqualWidth = false;
        schemaLabel = new Label(composite, SWT.NONE);
        schemaLabel.setText(title);
        GridData dg = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
        domViewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        domViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
        ((GridData) domViewer.getControl().getLayoutData()).heightHint = 400;
        ((GridData) domViewer.getControl().getLayoutData()).widthHint = 400;
        changeToResource();
        return composite;
    }

    private void changeToResource() {
        TreeParent parent = null;
        // Modified by hbhong,to fix bug 21784
        TreeObject[] children = treeParent.getChildren();
        for (TreeObject element : children) {
            parent = (TreeParent)element;
            if (parent.getType() == TreeObject.DATA_MODEL) {
                break;
            }
        }
        // The ending| bug:21784
        contentProvider = new ServerTreeContentProvider(site, parent);
        setTreeContentProvider(contentProvider);
        domViewer.setLabelProvider(new ServerTreeLabelProvider());
        domViewer.setSorter(new ViewerSorter() {

            @Override
            public int category(Object element) {
                if (element instanceof TreeParent) {
                    TreeParent category = (TreeParent) element;
                    if (category.getType() == TreeObject.CATEGORY_FOLDER) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        domViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent e) {
                StructuredSelection sel = (StructuredSelection) e.getSelection();

                TreeObject selectNode = (TreeObject) sel.getFirstElement();
                if (selectNode != null && selectNode.getType() == TreeObject.DATA_MODEL) {
                    xpath = selectNode.getDisplayName();
                }
                else {
                    xpath = "";//$NON-NLS-1$
                }
                sel.getFirstElement();

                getButton(IDialogConstants.OK_ID).setEnabled(xpath.length() > 0);
            }
        });
        domViewer.setInput(site);

    }

    private void setTreeContentProvider(ServerTreeContentProvider treeContentProvider) {
        if (this.domViewer.getContentProvider() != null) {
            this.domViewer.getContentProvider().dispose();
        }
        domViewer.setContentProvider(treeContentProvider);
    }

    @Override
    protected Control createButtonBar(Composite parent) {
        Control btnBar = super.createButtonBar(parent);
        getButton(IDialogConstants.OK_ID).setText(Messages.DataModelSelectDialog_Ok);
        return btnBar;
    }

    public String getXpath() {
        return xpath;
    }

}
