package com.amalto.workbench.detailtabs.sections.handlers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.amalto.workbench.detailtabs.exception.CommitException;
import com.amalto.workbench.detailtabs.exception.CommitValidationException;
import com.amalto.workbench.detailtabs.sections.model.LanguageInfo;
import com.amalto.workbench.detailtabs.sections.model.LanguageInfoCollection;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

abstract class LanguageInfoCommitHandler extends CommitHandler {

    public LanguageInfoCommitHandler(LanguageInfoCollection submittedLangInfos) {
        super(submittedLangInfos);
    }

    @Override
    protected void validateCommit() throws CommitValidationException {

        for (LanguageInfo eachLanguage : getCommitedObj().getLanguageInfos()) {
            validateEachLanguageInfo(eachLanguage);
        }

    }

    @Override
    protected boolean doSubmit() throws CommitException {

        XSDAnnotationsStructure xsdAnnoStruct = getXSDAnnotationStruct();

        return doSubmit_Removal(xsdAnnoStruct) | doSubmit_Update(xsdAnnoStruct) | doSubmit_Add(xsdAnnoStruct);
    }

    @Override
    public LanguageInfoCollection getCommitedObj() {
        return (LanguageInfoCollection) super.getCommitedObj();
    }

    private void validateEachLanguageInfo(LanguageInfo validatedLanguageInfo) throws CommitValidationException {
        if ("".equals(validatedLanguageInfo.getLabel().trim())) {
            throw new CommitValidationException("The content of " + validatedLanguageInfo.getLanguage() + " can not be empty");
        }

        if (!Util.lang2iso.get(validatedLanguageInfo.getLanguage()).equals(validatedLanguageInfo.getLanguageISOCode())
                || !Util.iso2lang.get(validatedLanguageInfo.getLanguageISOCode()).equals(validatedLanguageInfo.getLanguage())) {
            throw new CommitValidationException("The language and code is not match : " + validatedLanguageInfo.getLanguage()
                    + " <> " + validatedLanguageInfo.getLanguageISOCode());
        }
    }

    protected XSDAnnotationsStructure getXSDAnnotationStruct() {
        return new XSDAnnotationsStructure(getCommitedObj().getSourceXSDComponent());
    }

    private boolean doSubmit_Removal(XSDAnnotationsStructure xsdAnnoStruct) {

        String[] needRemovedLangCodes = getNeedRemovedLangCodes();

        for (String eachNeedRemovedLangCode : needRemovedLangCodes) {
            removeLangInfo(xsdAnnoStruct, eachNeedRemovedLangCode);
        }

        return (needRemovedLangCodes.length > 0);
    }

    private boolean doSubmit_Update(XSDAnnotationsStructure xsdAnnoStruct) {

        LanguageInfo[] needUpdatedLangInfos = getNeedUpdatedLangInfos();

        for (LanguageInfo eachNeedUpdateedLangInfo : needUpdatedLangInfos) {
            updateLangInfo(xsdAnnoStruct, eachNeedUpdateedLangInfo.getLanguageISOCode(), eachNeedUpdateedLangInfo.getLabel());
        }

        return needUpdatedLangInfos.length > 0;
    }

    private boolean doSubmit_Add(XSDAnnotationsStructure xsdAnnoStruct) {

        LanguageInfo[] needAddedLangInfos = getNeedAddedLangInfos();

        for (LanguageInfo eachNeedAddedLangInfo : needAddedLangInfos) {
            addLangInfo(xsdAnnoStruct, eachNeedAddedLangInfo.getLanguageISOCode(), eachNeedAddedLangInfo.getLabel());
        }

        return needAddedLangInfos.length > 0;
    }

    protected String[] getNeedRemovedLangCodes() {

        Set<String> results = new HashSet<String>();

        Map<String, LanguageInfo> curLangCode2LangInfo = getCommitedObj().getLangCode2LangInfo();

        for (Entry<String, String> eachOriginalLangCode2Info : getOriginalLang2Info().entrySet()) {

            if (curLangCode2LangInfo.containsKey(eachOriginalLangCode2Info.getKey()))
                continue;

            results.add(eachOriginalLangCode2Info.getKey());
        }

        return results.toArray(new String[0]);
    }

    protected LanguageInfo[] getNeedUpdatedLangInfos() {

        List<LanguageInfo> results = new ArrayList<LanguageInfo>();

        Map<String, LanguageInfo> curLangCode2LangInfo = getCommitedObj().getLangCode2LangInfo();

        for (Entry<String, String> eachOriginalLangCode2Info : getOriginalLang2Info().entrySet()) {

            if (!curLangCode2LangInfo.containsKey(eachOriginalLangCode2Info.getKey()))
                continue;

            if (curLangCode2LangInfo.get(eachOriginalLangCode2Info.getKey()).getLabel()
                    .equals(eachOriginalLangCode2Info.getValue()))
                continue;

            results.add(curLangCode2LangInfo.get(eachOriginalLangCode2Info.getKey()));
        }

        return results.toArray(new LanguageInfo[0]);
    }

    protected LanguageInfo[] getNeedAddedLangInfos() {

        List<LanguageInfo> results = new ArrayList<LanguageInfo>();

        Map<String, String> originalLangCode2LangInfo = getOriginalLang2Info();

        for (LanguageInfo eachCurLangInfo : getCommitedObj().getLanguageInfos()) {

            if (originalLangCode2LangInfo.containsKey(eachCurLangInfo.getLanguageISOCode()))
                continue;

            results.add(eachCurLangInfo);
        }

        return results.toArray(new LanguageInfo[0]);

    }

    protected abstract Map<String, String> getOriginalLang2Info();

    protected abstract void removeLangInfo(XSDAnnotationsStructure xsdAnnoStruct, String langcode);

    protected abstract void updateLangInfo(XSDAnnotationsStructure xsdAnnoStruct, String langCode, String value);

    protected abstract void addLangInfo(XSDAnnotationsStructure xsdAnnoStruct, String langCode, String value);
}
