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
package org.talend.mdm.repository.ui.dialogs.message;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.utils.EclipseResourceManager;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class MutliStatusDialog extends Dialog {

    private static final Image IMG_OK = EclipseResourceManager.getImage(RepositoryPlugin.PLUGIN_ID, "/icons/check.png"); //$NON-NLS-1$

    private static final Image IMG_ERR = EclipseResourceManager.getImage(RepositoryPlugin.PLUGIN_ID, "/icons/fatalerror_obj.gif"); //$NON-NLS-1$

    private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {

        public Image getColumnImage(Object element, int columnIndex) {
            if (element instanceof IStatus) {
                if (((IStatus) element).isOK()) {
                    return IMG_OK;
                } else {
                    return IMG_ERR;
                }
            }
            return null;
        }

        public String getColumnText(Object element, int columnIndex) {
            if (element instanceof IStatus) {
                return ((IStatus) element).getMessage();
            }
            return ""; //$NON-NLS-1$
        }
    }

    private final String message;

    private final IStatus mutliStatus;

    private Table table;

    private Label msgLabel;

    private TableViewer tableViewer;

    /**
     * Create the dialog.
     * 
     * @param parentShell
     */
    public MutliStatusDialog(Shell parentShell, String message, IStatus mutliStatus) {
        super(parentShell);
        //
        this.message = message;
        this.mutliStatus = mutliStatus;
        //
        this.setShellStyle(getShellStyle() | SWT.RESIZE);
    }

    /**
     * Create contents of the dialog.
     * 
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        container.setLayout(new GridLayout(1, false));

        msgLabel = new Label(container, SWT.WRAP);
        GridData gd_msgLabel = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_msgLabel.horizontalIndent = 10;
        gd_msgLabel.verticalIndent = 10;
        gd_msgLabel.heightHint = 40;
        msgLabel.setLayoutData(gd_msgLabel);

        tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
        table = tableViewer.getTable();
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        tableViewer.setLabelProvider(new TableLabelProvider());
        tableViewer.setContentProvider(new ArrayContentProvider());
        //
        initInput();
        return container;
    }

    /**
     * DOC hbhong Comment method "initInput".
     */
    private void initInput() {
        if (message != null)
            msgLabel.setText(message);
        //
        if (mutliStatus != null && mutliStatus.isMultiStatus()) {
            tableViewer.setInput(mutliStatus.getChildren());
        }

    }

    /**
     * Create contents of the button bar.
     * 
     * @param parent
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }

    /**
     * Return the initial size of the dialog.
     */
    @Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }

}
