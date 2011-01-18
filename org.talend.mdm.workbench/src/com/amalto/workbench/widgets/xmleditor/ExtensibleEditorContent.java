package com.amalto.workbench.widgets.xmleditor;

public class ExtensibleEditorContent {

    protected String content = "";

    public ExtensibleEditorContent(String content) {

        if (content != null)
            this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {

        if (content == null)
            this.content = "";
        else
            this.content = content;
    }
}
