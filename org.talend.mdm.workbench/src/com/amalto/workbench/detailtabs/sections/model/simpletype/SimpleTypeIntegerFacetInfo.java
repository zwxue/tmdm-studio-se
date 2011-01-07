package com.amalto.workbench.detailtabs.sections.model.simpletype;

public class SimpleTypeIntegerFacetInfo extends SimpleTypeFacetInfo<Integer> {

    public SimpleTypeIntegerFacetInfo(String propName, Integer propValue) {
        super(propName, propValue);
    }

    @Override
    protected String getValueLabel(Integer value) {
        return value.toString();
    }

    @Override
    protected Integer parseLabel(String label) {

        int result = 0;

        try {
            result = Integer.parseInt(label);
        } catch (Exception e) {
            return this.propValue;
        }

        return result;
    }

}
