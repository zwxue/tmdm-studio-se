package com.amalto.workbench.detailtabs.sections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.composites.CommitBarComposite.CommitBarListener;
import com.amalto.workbench.detailtabs.sections.composites.LanguageInfoComposite;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.langinfo.LanguageInfo;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.langinfo.LanguageInfoCollection;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public abstract class LanguageInfoSection extends BasePropertySection implements CommitBarListener {

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
            initLanguageInfo((XSDComponent) inputedObj);
        }
    }

    @Override
    public void refresh() {
        compLabel.setLanguageInfos(langInfos.toArray(new LanguageInfo[0]));
    }

    public LanguageInfo[] getLangInfos() {
        return compLabel.getLanguageInfos();
    }

    public XSDComponent getXSDComponent() {
        return xsdComponent;
    }

    /**
     * When receives the notification of reset from the command-bar, the section will reset its contents
     */
    public void onReset() {

        initLanguageInfo(xsdComponent);

        refresh();
    }

    /**
     * When receives the notification of submitting from the command-bar, the section will commit its setting
     */
    public void onSubmit() {

        try {
            if (getPreparedLangInfoCollection().createCommitHandler().submit()) {

                initLanguageInfo(getXSDComponent());
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

    protected abstract Map<String, String> getLang2Info(XSDAnnotationsStructure xsdAnnoStruct);

    protected abstract String getSectionTitle();

    protected abstract LanguageInfoCollection getPreparedLangInfoCollection();

    protected void initLanguageInfo(XSDComponent xsdComponent) {

        langInfos.clear();
        this.xsdComponent = xsdComponent;

        if (xsdComponent == null)
            return;

        XSDAnnotationsStructure xsdAnnoStruct = new XSDAnnotationsStructure(xsdComponent);

        for (Entry<String, String> eachLang2Label : getLang2Info(xsdAnnoStruct).entrySet()) {
            langInfos.add(new LanguageInfo(Util.iso2lang.get(eachLang2Label.getKey()), eachLang2Label.getKey(), eachLang2Label
                    .getValue()));
        }

    }
}
