package com.amalto.workbench.widgets.xmleditor;

public class ExtensibleEditorContent {

    protected String content = "";//$NON-NLS-1$

    public ExtensibleEditorContent(String content) {

        if (content != null)
            this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {

        if (content == null)
            this.content = "";//$NON-NLS-1$
        else
            this.content = content;
    }
}
