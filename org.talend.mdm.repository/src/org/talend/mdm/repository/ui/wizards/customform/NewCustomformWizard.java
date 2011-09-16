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

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class NewCustomformWizard extends Wizard {

    private final IWorkbenchPartSite site;

    private final IInputValidator validator;

    private CustomFormBaseInfoPage baseInfoPage;

    private CustomFormDiagramInfoPage diagramInfoPage;

    private String formName;

    public String getFormName() {
        return this.formName;
    }

    public String getDataModelName() {
        return this.dataModelName;
    }

    public String getEntityName() {
        return this.entityName;
    }

    private String dataModelName;

    private String entityName;

    public NewCustomformWizard(IWorkbenchPartSite site, String title, IInputValidator validator) {
        this.site = site;
        this.validator = validator;
        setWindowTitle(title);
    }

    @Override
    public void addPages() {
        baseInfoPage = new CustomFormBaseInfoPage(site, validator);
        diagramInfoPage = new CustomFormDiagramInfoPage();
        addPage(baseInfoPage);
        addPage(diagramInfoPage);

    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() == baseInfoPage) {
            return false;
        }
        return super.canFinish();
    }

    @Override
    public boolean performFinish() {
        formName = baseInfoPage.getFormName();
        dataModelName = baseInfoPage.getDataModelName();
        entityName = baseInfoPage.getEntityName();

        return false;
    }

}
