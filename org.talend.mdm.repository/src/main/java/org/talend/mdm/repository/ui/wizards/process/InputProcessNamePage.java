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
package org.talend.mdm.repository.ui.wizards.process;

import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.dialogs.xpath.XpathSelectDialog2;
import org.talend.mdm.repository.ui.wizards.process.composite.AbstractProcessTypeComposite;
import org.talend.mdm.repository.ui.wizards.process.composite.BeforeProcessTypeComposite;
import org.talend.mdm.repository.ui.wizards.process.composite.OtherTypeComposite;
import org.talend.mdm.repository.ui.wizards.process.composite.RunnableTypeComposite;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class InputProcessNamePage extends WizardPage {

    public static final String PAGE_ID = "org.talend.mdm.repository.ui.wizards.process.InputProcessNamePage"; //$NON-NLS-1$

    private final IWorkbenchPartSite site;

    private String processName;

    public String getProcessName() {
        return this.processName;
    }

    
    public int getProcessType() {
        return this.processType;
    }

    private int processType;

    /**
     * Create the wizard.
     */
    public InputProcessNamePage(IWorkbenchPartSite site) {
        super(PAGE_ID);
        this.site = site;
        setTitle(Messages.NewProcessWizard_title);
        setDescription(Messages.InputProcessNamePage_description);
    }

    protected SelectionListener selectionListener = new SelectionAdapter() {

        public void widgetSelected(SelectionEvent e) {
            updateProcessNameLabel();
            getWizard().getContainer().updateButtons();
        }
    };

    private IProcessTypeComposite curProcessTypeComposite;

    IProcessTypeComposite beforeProcessComposite;

    IProcessTypeComposite runnableProcessComposite;

    IProcessTypeComposite otherProcessComposite;

    private Text nameText;

    private Label processNameLabel;

    private Button selectEntityBun;

    private Label inputLabel;



    private Composite typeComposite;

    private Composite container;

    /**
     * Create contents of the wizard.
     * 
     * @param parent
     */
    public void createControl(Composite parent) {
        container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new GridLayout(1, false));
        typeComposite = new Composite(container, SWT.NONE);
        typeComposite.setLayout(new GridLayout(1, false));
        typeComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        curProcessTypeComposite = (AbstractProcessTypeComposite) getProcessTypeComposite(NewProcessWizard.BEFORE_TYPE);
        ((Composite) curProcessTypeComposite).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        // name
        Group grpEnterProcessName = new Group(container, SWT.NONE);
        grpEnterProcessName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        grpEnterProcessName.setText(Messages.InputProcessNamePage_enterName);
        grpEnterProcessName.setLayout(new GridLayout(3, false));

        inputLabel = new Label(grpEnterProcessName, SWT.NONE);
        inputLabel.setText(Messages.InputProcessNamePage_inputName);

        nameText = new Text(grpEnterProcessName, SWT.BORDER);
        nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        nameText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                updateProcessNameLabel();
                getWizard().getContainer().updateButtons();

            }
        });

        selectEntityBun = new Button(grpEnterProcessName, SWT.NONE);
        selectEntityBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                XpathSelectDialog2 dlg = new XpathSelectDialog2(getShell(), Messages.InputProcessNamePage_selectEntity, site, false, null);
                dlg.setBlockOnOpen(true);
                dlg.open();

                if (dlg.getReturnCode() == IDialogConstants.OK_ID) {
                    nameText.setText(dlg.getEntityName());
                    dlg.close();
                }
            }
        });
        selectEntityBun.setText(Messages.InputProcessNamePage_select);

        Label lblNewLabel = new Label(grpEnterProcessName, SWT.NONE);
        lblNewLabel.setText(Messages.InputProcessNamePage_processName);

        processNameLabel = new Label(grpEnterProcessName, SWT.NONE);
        processNameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        new Label(grpEnterProcessName, SWT.NONE);
    }

    private IProcessTypeComposite getProcessTypeComposite(int processType) {
        if (typeComposite == null)
            return null;
        switch (processType) {
        case NewProcessWizard.BEFORE_TYPE:
            if (beforeProcessComposite == null) {
                beforeProcessComposite = new BeforeProcessTypeComposite(typeComposite, selectionListener);
            }
            return beforeProcessComposite;
        case NewProcessWizard.RUNNABLE_TYPE:
            if (runnableProcessComposite == null) {
                runnableProcessComposite = new RunnableTypeComposite(typeComposite, selectionListener);
            }
            return runnableProcessComposite;

        case NewProcessWizard.OTHER_TYPE:
            if (otherProcessComposite == null) {
                otherProcessComposite = new OtherTypeComposite();
            }
            return otherProcessComposite;

        }

        return null;
    }

    public void updateProcessTypeComposite(int type) {
        IProcessTypeComposite newComposite = getProcessTypeComposite(type);
        if (newComposite != null && newComposite != curProcessTypeComposite) {
            if (curProcessTypeComposite instanceof Composite) {
                GridData gridData = (GridData) ((Composite) curProcessTypeComposite).getLayoutData();
                gridData.exclude = true;
                ((Composite) curProcessTypeComposite).setVisible(false);
            }
            if (newComposite instanceof Composite) {
                GridData gridData = (GridData) ((Composite) newComposite).getLayoutData();
                if (gridData == null) {
                    gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
                    ((Composite) newComposite).setLayoutData(gridData);
                }
                gridData.exclude = false;
                ((Composite) newComposite).setVisible(true);
            }

            curProcessTypeComposite = newComposite;
            typeComposite.layout();
            container.layout();
        }
        updateProcessNameLabel();

    }

    private boolean validateProcessName() {
        if (processNameLabel == null)
            return false;
        String name = processNameLabel.getText().trim();
        String errorMsg = null;
        boolean result = false;
        if (nameText.getText().trim().length() == 0) {
            errorMsg = Messages.Common_nameCanNotBeEmpty;
        } else if (!Pattern.matches("\\w*(#|\\.|\\w*)+\\w+", name)) {//$NON-NLS-1$
            errorMsg = Messages.Common_nameInvalid;
        } else if (RepositoryResourceUtil.isExistByName(IServerObjectRepositoryType.TYPE_TRANSFORMERV2, name)) {
            errorMsg = Messages.Common_nameIsUsed;
        }
        if (errorMsg != null) {
            setErrorMessage(errorMsg);
            result = false;
        } else {
            setErrorMessage(null);
            processName = name;
            processType = curProcessTypeComposite.getCurrentProcessType();
            result = true;
        }
        return result;
    }

    private void updateProcessNameLabel() {
        if (curProcessTypeComposite == null || selectEntityBun == null)
            return;
        String prefix = curProcessTypeComposite.getProcessPrefix();
        prefix += nameText.getText();
        processNameLabel.setText(prefix);
        // update button
        selectEntityBun.setVisible(curProcessTypeComposite.needShowSelectEntityBun());
    }

    @Override
    public IWizardPage getNextPage() {
        if (curProcessTypeComposite != null) {
            String pageId = curProcessTypeComposite.getConfigWizardPageId();
            if (pageId != null) {
                return getWizard().getPage(pageId);
            }
        }
        return null;
    }

    @Override
    public boolean isPageComplete() {
        return validateProcessName();
    }

}
