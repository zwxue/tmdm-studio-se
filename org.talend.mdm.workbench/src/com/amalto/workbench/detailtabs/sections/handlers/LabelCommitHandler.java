package com.amalto.workbench.detailtabs.sections.handlers;

import java.util.Map;

import com.amalto.workbench.detailtabs.sections.model.LanguageInfoCollection;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

class LabelCommitHandler extends LanguageInfoCommitHandler {

    public LabelCommitHandler(LanguageInfoCollection submittedLangInfos) {
        super(submittedLangInfos);
    }

    @Override
    protected Map<String, String> getOriginalLang2Info() {
        return getXSDAnnotationStruct().getLabels();
    }

    @Override
    protected void addLangInfo(XSDAnnotationsStructure xsdAnnoStruct, String langCode, String value) {
        xsdAnnoStruct.setLabel(langCode, value);
    }

    @Override
    protected void removeLangInfo(XSDAnnotationsStructure xsdAnnoStruct, String langcode) {
        xsdAnnoStruct.removeLabel(langcode);
    }

    @Override
    protected void updateLangInfo(XSDAnnotationsStructure xsdAnnoStruct, String langCode, String value) {
        xsdAnnoStruct.setLabel(langCode, value);
    }
}
