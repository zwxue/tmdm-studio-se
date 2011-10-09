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

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.mdm.repository.models.CustomFormElement;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class NewCustomformWizard extends Wizard {

    private CustomFormBaseInfoPage baseInfoPage;

    private int columnCount;

    private String dataModelName;

    private CustomFormDiagramInfoPage diagramInfoPage;

    private String entityName;

    private String formName;

    private String role;

    private final IWorkbenchPartSite site;

    private final IInputValidator validator;

    private List<CustomFormElement> allElements;;

    private CustomFormElement ancestor;

    public CustomFormElement getAncestor() {
        return ancestor;
    }

    public List<CustomFormElement> getAllElements() {
        return this.allElements;
    }

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

    public int getColumnCount() {
        return this.columnCount;
    }

    public String getDataModelName() {
        return this.dataModelName;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public String getFormName() {
        return this.formName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean performFinish() {
        formName = baseInfoPage.getFormName();
        dataModelName = baseInfoPage.getDataModelName();
        entityName = baseInfoPage.getEntityName();
        columnCount = diagramInfoPage.getColumnCount();
        allElements = diagramInfoPage.getAllElements();
        ancestor = diagramInfoPage.getAncestor();
        role = baseInfoPage.getRole();
        return true;
    }

}
