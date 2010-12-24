package com.amalto.workbench.detailtabs.sections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.composites.LanguageInfoComposite;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.langinfo.LanguageInfo;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public abstract class LanguageInfoSection extends XSDComponentSection {

    protected List<LanguageInfo> langInfos = new ArrayList<LanguageInfo>();

    protected LanguageInfoComposite compLabel;

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
    public void refresh() {
        compLabel.setLanguageInfos(langInfos.toArray(new LanguageInfo[0]));
    }

    public LanguageInfo[] getLangInfos() {
        return compLabel.getLanguageInfos();
    }

    protected abstract Map<String, String> getLang2Info(XSDAnnotationsStructure xsdAnnoStruct);

    protected abstract String getSectionTitle();

    @Override
    protected void initUIContents(XSDComponent editedObj) {
        super.initUIContents(editedObj);

        langInfos.clear();

        XSDAnnotationsStructure xsdAnnoStruct = new XSDAnnotationsStructure(curXSDComponent);

        for (Entry<String, String> eachLang2Label : getLang2Info(xsdAnnoStruct).entrySet()) {
            langInfos.add(new LanguageInfo(Util.iso2lang.get(eachLang2Label.getKey()), eachLang2Label.getKey(), eachLang2Label
                    .getValue()));
        }

    }
}
