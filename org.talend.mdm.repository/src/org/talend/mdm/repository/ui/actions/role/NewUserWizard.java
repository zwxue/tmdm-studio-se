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
package org.talend.mdm.repository.ui.actions.role;

import java.util.regex.Pattern;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewUserWizard extends Wizard {


    private EditUserNamePage page1;

    private SelectRolePage page2;

    private ISelection selection;

    private boolean isFinish = false;

    private String userName;

    private boolean isadmin;


    public NewUserWizard() {
        super();
    }

    @Override
    public boolean performFinish() {
        userName = page1.getUserName();
        isadmin = page2.isAdmin;

        return true;
    }

    public void addPages() {
        page1 = new EditUserNamePage(selection);
        addPage(page1);
        page2 = new SelectRolePage(selection);
        addPage(page2);
    }

    class EditUserNamePage extends WizardPage {

        String userName = "";//$NON-NLS-1$

        private Label tipLabel = null;

        // private Label warningLabel = null;
        public EditUserNamePage(ISelection selection) {
            super("RoleName");
            setTitle("Role Name");
            setDescription("Please enter a name for the new Role");
            setPageComplete(true);

        }

        public void createControl(Composite parent) {
            Composite composite = new Composite(parent, SWT.NULL);
            composite.setLayout(new GridLayout(1, false));
            tipLabel = new Label(composite, SWT.NONE);
            tipLabel.setText("Enter a name for the Role:");
            GridData gd = new GridData(GridData.FILL_HORIZONTAL);
            gd.widthHint = 150;
            final Text nameText = new Text(composite, SWT.BORDER);
            nameText.setLayoutData(gd);
            nameText.addModifyListener(new ModifyListener() {

                public void modifyText(ModifyEvent e) {
                    userName = nameText.getText();
                }
            });

            setControl(composite);
        }

        public String getUserName() {
            return userName;
        }
    }

    class SelectRolePage extends WizardPage {

        boolean isAdmin = true;

        public boolean isAdmin() {
            return isAdmin;
        }

        private Label tipLabel = null;

        private Button adminButton = null;

        private Button userButton = null;

        public SelectRolePage(ISelection selection) {
            super("RoleType");
            setTitle("Role Type");
            setDescription("Please Select a type for the new Role");
            setPageComplete(true);
        }

        public void createControl(Composite parent) {

            Composite composite = new Composite(parent, SWT.NULL);
            composite.setLayout(new GridLayout(1, false));

            Group radioGroup = new Group(composite, SWT.SHADOW_NONE);
            radioGroup.setText("Type of Role");
            radioGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
            radioGroup.setLayout(new GridLayout(2, false));
            adminButton = new Button(radioGroup, SWT.RADIO);
            adminButton.setText("Administrator");

            userButton = new Button(radioGroup, SWT.RADIO);
            userButton.setText("Normal User");
            adminButton.addSelectionListener(new SelectionListener() {

                public void widgetDefaultSelected(SelectionEvent e) {
                    

                }

                public void widgetSelected(SelectionEvent e) {
                    isFinish = true;
                    setPageComplete(true);
                    tipLabel.setVisible(true);
                    tipLabel.setText("Administrator can operate all of the Data Container, Menu, View, Role, Trigger and \nData Model etc. He/she can setup normal user's access right.");
                    isAdmin = true;

                }

            });

            userButton.addSelectionListener(new SelectionListener() {

                public void widgetDefaultSelected(SelectionEvent e) {
                    

                }

                public void widgetSelected(SelectionEvent e) {
                    isFinish = true;
                    setPageComplete(true);
                    tipLabel.setText("Normal user can operate part of the Data Container, Menu, View, Role, Trigger and \nData Model etc.");
                    isAdmin = false;

                }

            });

            tipLabel = new Label(composite, SWT.NONE);
            GridData gd = new GridData(GridData.FILL_HORIZONTAL);
            gd.widthHint = 150;
            gd.heightHint = 50;
            tipLabel.setLayoutData(gd);
            setControl(composite);

        }
    }

    public String isValid(String newText) {
        if ((newText == null) || "".equals(newText))//$NON-NLS-1$
            return "The Name cannot be empty";

        if (!Pattern.matches("\\w*(#|\\w*)+\\w+", newText)) {//$NON-NLS-1$
            return "The name cannot contains invalid character!";
        }
        if (exist(newText))
            return "The Role " + newText + " already exist";
        return null;
    }

    public boolean canFinish() {
        return isFinish;
    }

    public boolean exist(String userName) {

        return false;
    }


    public String getUserName() {
        return this.userName;
    }


    public boolean isAdmin() {
        return this.isadmin;
    }
}
