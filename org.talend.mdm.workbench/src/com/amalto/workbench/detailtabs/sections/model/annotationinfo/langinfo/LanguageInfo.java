package com.amalto.workbench.detailtabs.sections.model.annotationinfo.langinfo;

public class LanguageInfo {

    private String language = "";

    private String languageISOCode = "";

    private String label = "";

    public LanguageInfo(String language, String languageISOCode, String label) {
        this.label = label;
        this.languageISOCode = languageISOCode;
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLanguageISOCode() {
        return languageISOCode;
    }

    public void setLanguageISOCode(String languageISOCode) {
        this.languageISOCode = languageISOCode;
    }

}
