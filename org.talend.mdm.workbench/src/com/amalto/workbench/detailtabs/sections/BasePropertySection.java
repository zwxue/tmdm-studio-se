package com.amalto.workbench.detailtabs.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.TabContents;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.xsdeditor.XSDEditor;
import com.amalto.workbench.models.TreeObject;

public abstract class BasePropertySection extends AbstractPropertySection {

    protected TabbedPropertySheetPage tabbedPropertySheetPage;

    protected String parentTabID;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);

        tabbedPropertySheetPage = aTabbedPropertySheetPage;

        parentTabID = tabbedPropertySheetPage.getSelectedTab().getId();
    }

    public TabbedPropertySheetPage getTabbedPropertySheetPage() {
        return tabbedPropertySheetPage;
    }

    public TabContents getCurrentTabContents() {
        return tabbedPropertySheetPage.getCurrentTab();
    }

    public ISection[] getCurrentTabSections() {
        return getCurrentTabContents().getSections();
    }

    public ITabDescriptor getSelectedTabDescriptor() {
        return tabbedPropertySheetPage.getSelectedTab();
    }

    public String getSelectedTabID() {
        return getSelectedTabDescriptor().getId();
    }

    public String getParentTabID() {
        return parentTabID;
    }

    protected DataModelMainPage getCurDataModelMainPage() {
        return (DataModelMainPage) ((XSDEditor) getPart()).getAdapter(DataModelMainPage.class);
    }

    public TreeObject getTreeObject() {
        return getCurDataModelMainPage().getXObject();
    }
}
