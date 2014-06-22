package com.amalto.workbench.widgets.xmleditor;

public class ExtensibleContentEditorPageDescription {

    private String label;

    private int index;

    private ExtensibleContentEditorPageCreator creator;

    private boolean isDefault;

    public ExtensibleContentEditorPageDescription(String label, int index, ExtensibleContentEditorPageCreator creator, boolean isDefault) {

        this.label = label;
        this.index = index;
        this.creator = creator;
        this.isDefault = isDefault;

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ExtensibleContentEditorPageCreator getCreator() {
        return creator;
    }

    public void setCreator(ExtensibleContentEditorPageCreator creator) {
        this.creator = creator;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

}
