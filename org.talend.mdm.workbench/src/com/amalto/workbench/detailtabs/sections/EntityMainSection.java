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
package com.amalto.workbench.detailtabs.sections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.xsd.XSDElementDeclaration;

import com.amalto.workbench.detailtabs.sections.composites.CommitBarComposite;
import com.amalto.workbench.detailtabs.sections.composites.EntityKeyConfigComposite;
import com.amalto.workbench.detailtabs.sections.composites.NameConfigComposite;
import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.entity.EntityWrapper;

public class EntityMainSection extends CommitBarListenerSection<XSDElementDeclaration> {

    public static final int SPACE_BEGINING = 10;

    public static final int HSPACE_CONTROL = 5;

    public static final int VSPACE_CONTROL = 10;

    private EntityWrapper entityWrapper;

    private NameConfigComposite compNameConfig;

    private EntityKeyConfigComposite compKeyConfig;

    private CommitBarComposite compCommitBar;

    @Override
    public boolean shouldUseExtraSpace() {
        return true;
    }

    @Override
    public void refresh() {

        compKeyConfig.setXSDElement(null);
        compNameConfig.setTarget(null);

        if (entityWrapper != null) {
            compNameConfig.setTarget(entityWrapper);
            compKeyConfig.setXSDElement(entityWrapper);
        }

    }

    public void dispose() {

        if (compCommitBar != null)
            compCommitBar.removeCommitListener(this);

        super.dispose();
    }

    @Override
    protected XSDElementDeclaration getEditedObj() {
        return entityWrapper.getSourceEntity();
    }

    @Override
    protected void initUIContents(XSDElementDeclaration editedObj) {
        entityWrapper = new EntityWrapper((XSDElementDeclaration) editedObj);
    }

    @Override
    protected ISubmittable getSubmittedObj() {
        return entityWrapper;
    }

    @Override
    protected void registToGolbalCommitBarListenerReg() {
    }

    @Override
    protected void createControlsInSection(Composite compSectionClient) {

        Composite compTop = getWidgetFactory().createFlatFormComposite(compSectionClient);
        compTop.setLayout(new GridLayout());

        compNameConfig = new NameConfigComposite(compTop, SWT.NONE);
        GridData gdCompName = new GridData(SWT.FILL, SWT.CENTER, true, false);
        compNameConfig.setLayoutData(gdCompName);

        Group gpKeyConfig = new Group(compTop, SWT.NONE);
        gpKeyConfig.setText("Key Definition");
        gpKeyConfig.setBackground(compSectionClient.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        GridData gdGroupKeyConfig = new GridData(SWT.FILL, SWT.FILL, true, true);
        gpKeyConfig.setLayoutData(gdGroupKeyConfig);
        gpKeyConfig.setLayout(new FillLayout());
        compKeyConfig = new EntityKeyConfigComposite(gpKeyConfig, SWT.NONE);

        compCommitBar = new CommitBarComposite(compTop, SWT.NONE);
        GridData gdCompCommitBar = new GridData(SWT.BEGINNING, SWT.TOP, false, false);
        compCommitBar.setLayoutData(gdCompCommitBar);
        compCommitBar.addCommitListener(this);

    }

    @Override
    protected String getSectionTitle() {
        return "";
    }

    @Override
    protected int getSectionStyle() {
        return Section.NO_TITLE | Section.EXPANDED;
    }

    @Override
    protected boolean hasTitleSeperator() {
        return false;
    }
}
