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
package org.talend.mdm.repository.ui.dialogs.deploy;

import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.widgets.RepositoryViewObjectCheckedWidget;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployAllDialog extends Dialog {

    private final Set<IRepositoryViewObject> changedViewObjs;

    private final Object input;

    /**
     * Create the dialog.
     * 
     * @param parentShell
     */
    public DeployAllDialog(Shell parentShell, Object input, Set<IRepositoryViewObject> changedViewObjs) {
        super(parentShell);
        this.input = input;
        this.changedViewObjs = changedViewObjs;
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }

    /**
     * Create contents of the dialog.
     * 
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        GridLayout gridLayout = (GridLayout) container.getLayout();
        gridLayout.numColumns = 2;

        Label lblNewLabel = new Label(container, SWT.NONE);
        lblNewLabel.setText(Messages.DeployAllDialog_label);
        new Label(container, SWT.NONE);
        treeViewer = new RepositoryViewObjectCheckedWidget(container, input, changedViewObjs);
        //
        treeViewer.addCheckStateListener(new ICheckStateListener() {

            public void checkStateChanged(CheckStateChangedEvent event) {
                // enableOkBun();
            }

        });
        treeViewer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));

        Button selAllButton = new Button(container, SWT.NONE);
        selAllButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                treeViewer.selectAll(true);
            }
        });
        selAllButton.setText(Messages.DeployAllDialog_selectAll);

        Button deselAllBun = new Button(container, SWT.NONE);
        deselAllBun.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
        deselAllBun.setText(Messages.DeployAllDialog_deselectAll);
        deselAllBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                treeViewer.selectAll(false);
            }
        });

        return container;
    }

    /**
     * Create contents of the button bar.
     * 
     * @param parent
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        okBun = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    /**
     * Return the initial size of the dialog.
     */
    @Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }

    List<IRepositoryViewObject> selectededViewObjs;

    private RepositoryViewObjectCheckedWidget treeViewer;

    private Button okBun;

    public List<IRepositoryViewObject> getSelectededViewObjs() {
        return this.selectededViewObjs;
    }

    @Override
    protected void okPressed() {
        selectededViewObjs = treeViewer.getSelectededViewObjs();
        super.okPressed();
    }

    private void enableOkBun() {
        okBun.setEnabled(treeViewer.getSelectededViewObjs().size() > 0);
    }
}
