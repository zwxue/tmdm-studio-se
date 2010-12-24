package com.amalto.workbench.detailtabs.sections;

import java.util.Map;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.langinfo.LanguageInfoCollection;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class PresentationDescriptionSection extends LanguageInfoSection {

    @Override
    protected Map<String, String> getLang2Info(XSDAnnotationsStructure xsdAnnoStruct) {
        return xsdAnnoStruct.getDescriptions();
    }

    @Override
    protected String getSectionTitle() {
        return "Descriptions";
    }

    @Override
    protected ISubmittable getSubmittedObj() {
        return LanguageInfoCollection.createDescriptionInfoCollection(getEditedObj(), getLangInfos());
    }
}
