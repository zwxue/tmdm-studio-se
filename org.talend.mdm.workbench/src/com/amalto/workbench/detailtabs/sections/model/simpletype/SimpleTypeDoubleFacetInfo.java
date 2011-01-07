package com.amalto.workbench.detailtabs.sections.model.simpletype;

public class SimpleTypeDoubleFacetInfo extends SimpleTypeFacetInfo<Double> {

    public SimpleTypeDoubleFacetInfo(String propName, Double propValue) {
        super(propName, propValue);
    }

    @Override
    protected String getValueLabel(Double value) {
        return value.toString();
    }

    @Override
    protected Double parseLabel(String label) {

        double result = 0;

        try {
            result = Double.parseDouble(label);
        } catch (Exception e) {
            return this.propValue;
        }

        return result;
    }

}
