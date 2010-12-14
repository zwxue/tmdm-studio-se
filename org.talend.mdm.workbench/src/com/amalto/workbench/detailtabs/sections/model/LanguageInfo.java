package com.amalto.workbench.detailtabs.sections.model;

public class LanguageInfo {

    private String language = "";

    private String label = "";

    public LanguageInfo(String language, String label) {
        this.label = label;
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

}
