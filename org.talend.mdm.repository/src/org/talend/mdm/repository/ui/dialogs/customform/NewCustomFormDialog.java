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
package org.talend.mdm.repository.ui.dialogs.customform;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.dialogs.xpath.XpathSelectDialog2;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class NewCustomFormDialog extends Dialog {

    private Text nameTxt;

    private Text entityText;

    private Label msgLabel;

    private final IWorkbenchPartSite site;

    private final IInputValidator validator;

    private String dataModelName, entityName;

    public String getDataModelName() {
        return this.dataModelName;
    }

    public String getEntityName() {
        return this.entityName;
    }

    private Button okBun;

    private final String title;

    protected String formName;

    /**
     * Create the dialog.
     * 
     * @param parentShell
     */
    public NewCustomFormDialog(Shell parentShell, IWorkbenchPartSite site, String title, IInputValidator validator) {
        super(parentShell);
        this.site = site;
        this.validator = validator;
        this.title = title;
    }

    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        if (title != null) {
            shell.setText(title);
        }
    }

    /**
     * Create contents of the dialog.
     * 
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        container.setLayout(new GridLayout(2, false));

        Label lblNewLabel = new Label(container, SWT.NONE);
        GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblNewLabel.verticalIndent = 10;
        gd_lblNewLabel.horizontalIndent = 10;
        lblNewLabel.setLayoutData(gd_lblNewLabel);
        lblNewLabel.setText(Messages.Common_inputName);
        new Label(container, SWT.NONE);

        nameTxt = new Text(container, SWT.BORDER);
        nameTxt.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                validate();
                formName = nameTxt.getText();
            }
        });
        GridData gd_nameTxt = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_nameTxt.verticalIndent = 5;
        gd_nameTxt.horizontalIndent = 10;
        nameTxt.setLayoutData(gd_nameTxt);
        new Label(container, SWT.NONE);
        new Label(container, SWT.NONE);
        new Label(container, SWT.NONE);

        Label lblSelectAEntity = new Label(container, SWT.NONE);
        GridData gd_lblSelectAEntity = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblSelectAEntity.horizontalIndent = 10;
        lblSelectAEntity.setLayoutData(gd_lblSelectAEntity);
        lblSelectAEntity.setText(Messages.NewCustomFormDialog_selectEntityFromDataModel);
        new Label(container, SWT.NONE);

        entityText = new Text(container, SWT.BORDER | SWT.READ_ONLY);
        entityText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                validate();
            }
        });
        GridData gd_entityText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_entityText.verticalIndent = 5;
        gd_entityText.horizontalIndent = 10;
        entityText.setLayoutData(gd_entityText);

        Button btnNewButton = new Button(container, SWT.NONE);
        btnNewButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                XpathSelectDialog2 dlg = new XpathSelectDialog2(getParentShell(), Messages.NewCustomFormDialog_selectOneEntity, site, false, null);
                dlg.setBlockOnOpen(true);
                dlg.open();

                if (dlg.getReturnCode() == IDialogConstants.OK_ID) {
                    dataModelName = dlg.getDataModelName();
                    entityName = dlg.getEntityName();
                    entityText.setText(dataModelName + "." + entityName); //$NON-NLS-1$
                    dlg.close();
                }
            }
        });
        btnNewButton.setText("..."); //$NON-NLS-1$

        msgLabel = new Label(container, SWT.NONE);
        GridData gd_msgLabel = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
        gd_msgLabel.verticalIndent = 5;
        gd_msgLabel.horizontalIndent = 10;
        msgLabel.setLayoutData(gd_msgLabel);
        new Label(container, SWT.NONE);

        return container;
    }

    public String getFormName() {
        return this.formName;
    }

    /**
     * Create contents of the button bar.
     * 
     * @param parent
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        this.okBun = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
        okBun.setEnabled(false);
    }

    @Override
    protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
            String msg = validate();
            if (msg != null)
                return;
        }
        super.buttonPressed(buttonId);
    }

    private String validate() {
        String msg = validator.isValid(nameTxt.getText());
        if (msg == null) {
            if (entityName == null || dataModelName == null) {
                msg = Messages.NewCustomFormDialog_selectEntity;
            }
        }

        msgLabel.setText((msg != null) ? msg : ""); //$NON-NLS-1$

        okBun.setEnabled(msg == null);
        return msg;
    }

    /**
     * Return the initial size of the dialog.
     */
    @Override
    protected Point getInitialSize() {
        return new Point(450, 262);
    }

}
