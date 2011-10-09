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
package org.talend.mdm.repository.ui.wizards.customform;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.dialogs.xpath.XpathSelectDialog2;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class CustomFormBaseInfoPage extends WizardPage {

    public static final String PAGE_ID = "org.talend.mdm.repository.ui.wizards.customform.CustomFormBaseInfoPage"; //$NON-NLS-1$

    private Text entityText;

    private Text nameTxt;

    private CCombo roleCombo;

    private final IWorkbenchPartSite site;

    public String getFormName() {
        return this.formName;
    }

    public String getDataModelName() {
        return this.dataModelName;
    }

    public String getEntityName() {
        return this.entityName;
    }

    private String formName;

    private String dataModelName;

    private String entityName;

    private final IInputValidator validator;

    /**
     * Create the wizard.
     */
    public CustomFormBaseInfoPage(IWorkbenchPartSite site, IInputValidator validator) {
        super(PAGE_ID);
        this.site = site;
        this.validator = validator;
        setTitle(Messages.CustomFormBaseInfoPage_title);
        setDescription(Messages.CustomFormBaseInfoPage_inputName);
    }

    public String getRole() {
        return roleCombo.getText();
    }

    /**
     * Create contents of the wizard.
     * 
     * @param parent
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
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

        // associate role
        Label lblRoleEntity = new Label(container, SWT.NONE);
        GridData gd_lblRoleEntity = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblRoleEntity.horizontalIndent = 10;
        lblRoleEntity.setLayoutData(gd_lblRoleEntity);
        lblRoleEntity.setText(Messages.NewCustomFormDialog_AssociateRole);
        new Label(container, SWT.NONE);

        roleCombo = new CCombo(container, SWT.BORDER | SWT.READ_ONLY);

        GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd.verticalIndent = 5;
        gd.horizontalIndent = 10;
        roleCombo.setLayoutData(gd);
        new Label(container, SWT.NONE);
        // TODO get all the roles from the repository view
        List<String> roles = RepositoryQueryService.findAllRoleNames();
        roles.add(0, ""); //$NON-NLS-1$
        roleCombo.setItems(roles.toArray(new String[0]));

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
        GridData gd_entityText1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_entityText1.verticalIndent = 5;
        gd_entityText1.horizontalIndent = 10;
        entityText.setLayoutData(gd_entityText1);

        Button btnNewButton1 = new Button(container, SWT.NONE);
        btnNewButton1.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                XpathSelectDialog2 dlg = new XpathSelectDialog2(getShell(), Messages.NewCustomFormDialog_selectOneEntity, site,
                        false, null);
                dlg.setBlockOnOpen(true);
                dlg.open();

                if (dlg.getReturnCode() == IDialogConstants.OK_ID) {
                    dataModelName = dlg.getDataModelName();
                    entityName = dlg.getEntityName();
                    entityText.setText(dataModelName + "." + entityName); //$NON-NLS-1$
                    dlg.close();
                    updateModel();
                }
            }
        });
        btnNewButton1.setText("..."); //$NON-NLS-1$
        validate();
    }

    private void updateModel() {
        CustomFormDiagramInfoPage page = (CustomFormDiagramInfoPage) getWizard().getPage(CustomFormDiagramInfoPage.PAGE_ID);
        page.updateDataModel(dataModelName, entityName);
    }

    private String validate() {
        String msg = validator.isValid(nameTxt.getText());
        if (msg == null) {
            if (entityName == null || dataModelName == null) {
                msg = Messages.NewCustomFormDialog_selectEntity;
            }
        }
        setErrorMessage(msg);
        setPageComplete(msg == null);
        return msg;
    }

}
