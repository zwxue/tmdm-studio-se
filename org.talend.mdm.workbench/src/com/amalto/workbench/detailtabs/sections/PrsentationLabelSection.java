package com.amalto.workbench.detailtabs.sections;

import java.util.Map;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.langinfo.LanguageInfoCollection;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class PrsentationLabelSection extends LanguageInfoSection {

    @Override
    protected Map<String, String> getLang2Info(XSDAnnotationsStructure xsdAnnoStruct) {
        return xsdAnnoStruct.getLabels();
    }

    @Override
    protected String getSectionTitle() {
        return "Labels";
    }

    @Override
    protected ISubmittable getSubmittedObj() {
        return LanguageInfoCollection.createLabelInfoCollection(getEditedObj(), getLangInfos());
    }
}
