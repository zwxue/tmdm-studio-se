package com.amalto.workbench.detailtabs.sections.model.simpletype;


public abstract class SimpleTypeFacetInfo<T> {

    protected String propName = "";

    protected T propValue;

    protected SimpleTypeFacetInfo(String propName, T propValue) {
        this.propName = propName;
        this.propValue = propValue;
    }

    public String getPropertyName() {
        return propName;
    }

    public String getPropertyValueLabel() {
        return getValueLabel(propValue);
    }

    public T getPropertyValue() {
        return propValue;
    }

    public void setPropertyValue(T value) {

        if (value == null)
            return;

        propValue = value;
    }

    public void setPropretyValueByLabel(String label) {

        T parsedValue = parseLabel(label);

        if (parsedValue == null)
            return;

        propValue = parsedValue;

    }

    protected abstract String getValueLabel(T value);

    protected abstract T parseLabel(String label);

}
