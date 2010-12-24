package com.amalto.workbench.detailtabs.sections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
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
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);

        Composite compTop = getWidgetFactory().createFlatFormComposite(parent);
        compTop.setLayout(new GridLayout());

        compNameConfig = new NameConfigComposite(compTop, SWT.NONE);
        GridData gdCompName = new GridData(SWT.FILL, SWT.CENTER, true, false);
        compNameConfig.setLayoutData(gdCompName);

        Group gpKeyConfig = new Group(compTop, SWT.NONE);
        gpKeyConfig.setText("Key Definition");
        gpKeyConfig.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
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
}
