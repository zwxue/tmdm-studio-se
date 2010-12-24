package com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship;

import java.util.Arrays;

import com.amalto.workbench.utils.IConstants;

public class ForeignKeyFilterAnnoInfoDefUnit {

    private String xpath = "";

    private String operator = "";

    private String value = "";

    private String predicate = "";

    public ForeignKeyFilterAnnoInfoDefUnit(String xpath, String operator, String value, String predicate) {

        if (xpath != null)
            this.xpath = xpath;

        if (Arrays.asList(IConstants.VIEW_CONDITION_OPERATORS).contains(operator))
            this.operator = operator;

        if (value != null)
            this.value = value;

        if (Arrays.asList(IConstants.PREDICATES).contains(predicate))
            this.predicate = predicate;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        if (xpath != null)
            this.xpath = xpath;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        if (Arrays.asList(IConstants.VIEW_CONDITION_OPERATORS).contains(operator))
            this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (value != null)
            this.value = value;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        if (Arrays.asList(IConstants.PREDICATES).contains(predicate))
            this.predicate = predicate;
    }

    public String getNormalizeValue() {
        return normalizeValue(value);
    }

    private String normalizeValue(String value) {
        if (value != null && value.trim().length() > 0) {
            value = value.replaceAll("\"", "&quot;");
            value = value.replaceAll("'", "&quot;");
        }
        return value;
    }
}
