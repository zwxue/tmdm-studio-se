package com.amalto.workbench.detailtabs.sections.model.simpletype;

public class SimpleTypeStringFacetInfo extends SimpleTypeFacetInfo<String> {

    public SimpleTypeStringFacetInfo(String propName, String propValue) {
        super(propName, propValue);
    }

    @Override
    protected String getValueLabel(String value) {
        return value;
    }

    @Override
    protected String parseLabel(String label) {
        return label;
    }

}
