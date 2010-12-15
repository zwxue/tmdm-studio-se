package com.amalto.workbench.detailtabs.sections;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xsd.XSDElementDeclaration;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.composites.CommitBarComposite;
import com.amalto.workbench.detailtabs.sections.composites.CommitBarComposite.CommitBarListener;
import com.amalto.workbench.detailtabs.sections.composites.EntityKeyConfigComposite;
import com.amalto.workbench.detailtabs.sections.composites.NameConfigComposite;
import com.amalto.workbench.detailtabs.sections.handlers.CommitHandlerFactory;
import com.amalto.workbench.detailtabs.sections.model.EntityWrapper;

public class EntityMainSection extends BasePropertySection implements CommitBarListener {

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
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);

        entityWrapper = null;

        Object inputedObj = ((IStructuredSelection) selection).getFirstElement();
        if (inputedObj instanceof XSDElementDeclaration) {
            entityWrapper = new EntityWrapper((XSDElementDeclaration) inputedObj);
        }

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

    public void onReset() {

        entityWrapper = new EntityWrapper(entityWrapper.getSourceEntity());
        refresh();
    }

    public void onSubmit() {

        try {
            if (CommitHandlerFactory.getInstance().creatCommitHandler(entityWrapper).submit()) {
                entityWrapper = new EntityWrapper(entityWrapper.getSourceEntity());
                refresh();

                getCurDataModelMainPage().refresh();
                getCurDataModelMainPage().markDirty();
            }
        } catch (CommitException e) {
            MessageDialog.openError(getPart().getSite().getShell(), "Commit Error", e.getMessage());
        } catch (CommitValidationException e) {
            MessageDialog.openError(getPart().getSite().getShell(), "Commit Validation Error", e.getMessage());
            return;
        }
    }

    public void dispose() {

        compCommitBar.removeCommitListener(this);

        super.dispose();
    }
}
