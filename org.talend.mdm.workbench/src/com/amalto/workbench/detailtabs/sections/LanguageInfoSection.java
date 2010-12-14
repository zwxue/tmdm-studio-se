package com.amalto.workbench.detailtabs.sections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.composites.LanguageInfoComposite;
import com.amalto.workbench.detailtabs.sections.model.LanguageInfo;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public abstract class LanguageInfoSection extends AbstractPropertySection {

    protected List<LanguageInfo> langInfos = new ArrayList<LanguageInfo>();

    protected LanguageInfoComposite compLabel;

    protected XSDComponent xsdComponent;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);

        Composite compTop = getWidgetFactory().createComposite(parent);
        compTop.setLayout(new FillLayout());

        Section section = getWidgetFactory().createSection(compTop, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        section.setText(getSectionTitle());
        section.setLayout(new FillLayout());
        getWidgetFactory().createCompositeSeparator(section);

        Composite compSectionClient = getWidgetFactory().createComposite(section);
        compSectionClient.setLayout(new FillLayout());

        compLabel = new LanguageInfoComposite(compSectionClient, SWT.NONE);

        section.setClient(compSectionClient);
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);

        langInfos.clear();
        xsdComponent = null;

        Object inputedObj = ((IStructuredSelection) selection).getFirstElement();
        if (inputedObj instanceof XSDComponent) {

            xsdComponent = (XSDComponent) inputedObj;

            XSDAnnotationsStructure xsdAnnoStruct = new XSDAnnotationsStructure(xsdComponent);

            for (Entry<String, String> eachLang2Label : getLang2Info(xsdAnnoStruct).entrySet()) {
                langInfos.add(new LanguageInfo(eachLang2Label.getKey(), eachLang2Label.getValue()));
            }
        }
    }

    @Override
    public void refresh() {
        compLabel.setLanguageInfos(langInfos.toArray(new LanguageInfo[0]));
    }

    @Override
    public boolean shouldUseExtraSpace() {
        return true;
    }

    public LanguageInfo[] getLangInfos() {
        return compLabel.getLanguageInfos();
    }

    public XSDComponent getXSDComponent() {
        return xsdComponent;
    }

    protected abstract Map<String, String> getLang2Info(XSDAnnotationsStructure xsdAnnoStruct);

    protected abstract String getSectionTitle();
}
