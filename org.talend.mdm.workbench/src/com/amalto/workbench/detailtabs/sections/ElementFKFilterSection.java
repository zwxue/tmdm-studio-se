package com.amalto.workbench.detailtabs.sections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.composites.ForeignKeyFilterComposite;
import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship.ForeignKeyFilterAnnoInfo;
import com.amalto.workbench.detailtabs.sections.util.BasePropertySectionDataModelExtractor;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class ElementFKFilterSection extends XSDComponentSection {

    private BasePropertySectionDataModelExtractor dataModelHolder;

    private ForeignKeyFilterComposite compFKFilter;

    private String filterExpression = "";

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);

        Composite compTop = getWidgetFactory().createComposite(parent);
        compTop.setLayout(new FillLayout());

        Section section = getWidgetFactory().createSection(compTop, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        section.setText("Foreign Key Filter");
        section.setLayout(new FillLayout());
        getWidgetFactory().createCompositeSeparator(section);

        Composite compSectionClient = getWidgetFactory().createComposite(section);
        compSectionClient.setLayout(new FillLayout());

        dataModelHolder = new BasePropertySectionDataModelExtractor(this);
        compFKFilter = new ForeignKeyFilterComposite(compSectionClient, SWT.NONE, dataModelHolder);

        section.setClient(compSectionClient);
    }

    @Override
    public void refresh() {
        compFKFilter.setFilter(filterExpression);
    }

    @Override
    protected void initUIContents(XSDComponent editedObj) {
        super.initUIContents(editedObj);

        filterExpression = new XSDAnnotationsStructure(curXSDComponent).getFKFilter();
        if (filterExpression == null)
            filterExpression = "";

        dataModelHolder.setDefaultDataModel(getDataModelName());
    }

    @Override
    protected ISubmittable getSubmittedObj() {
        return new ForeignKeyFilterAnnoInfo(curXSDComponent, compFKFilter.getFilterExpression());
    }

}
