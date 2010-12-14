package com.amalto.workbench.detailtabs.sections.model;

import org.eclipse.xsd.XSDXPathDefinition;

public class FieldWrapper {

    private XSDXPathDefinition sourceFiled;

    private String xpath = "";

    public FieldWrapper(String xpath) {
        this.xpath = xpath;
    }

    public FieldWrapper(XSDXPathDefinition sourceFiled) {

        if (sourceFiled != null) {
            this.sourceFiled = sourceFiled;
            this.xpath = sourceFiled.getValue();
        }
    }

    public String getXPath() {
        return xpath;
    }

    public void setXPath(String xpath) {

        if (xpath == null || "".equals(xpath.trim()))
            return;

        this.xpath = xpath;
    }

    public XSDXPathDefinition getSourceField() {
        return sourceFiled;
    }

    public boolean isUserCreated() {
        return getSourceField() == null;
    }
}
