package com.amalto.workbench.detailtabs.sections;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.TabContents;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.xsdeditor.XSDEditor;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSDataModel;

public abstract class BasePropertySection extends AbstractPropertySection {

    protected TabbedPropertySheetPage tabbedPropertySheetPage;

    protected String parentTabID;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);

        tabbedPropertySheetPage = aTabbedPropertySheetPage;

        parentTabID = tabbedPropertySheetPage.getSelectedTab().getId();

        Composite compTop = getWidgetFactory().createComposite(parent);
        compTop.setLayout(new FillLayout());

        Section section = getWidgetFactory().createSection(compTop, getSectionStyle());
        section.setText(getSectionTitle());
        section.setLayout(new FillLayout());

        if (hasTitleSeperator())
            getWidgetFactory().createCompositeSeparator(section);

        Composite compSectionClient = getWidgetFactory().createComposite(section);
        compSectionClient.setLayout(new FillLayout());

        createControlsInSection(compSectionClient);

        section.setClient(compSectionClient);

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

    protected String getDataModelName() {
        return getDataModel().getName();
    }

    protected WSDataModel getDataModel() {
        return getCurDataModelMainPage().getDataModel();
    }

    protected int getSectionStyle() {
        return Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED;
    }

    protected boolean hasTitleSeperator() {
        return true;
    }

    protected abstract String getSectionTitle();

    protected abstract void createControlsInSection(Composite compSectionClient);
}
