package com.amalto.workbench.widgets.xmleditor;

public class ExtensibleContentEditorPageSaveException extends Exception {

    private static final long serialVersionUID = -6298820321342916306L;

    public ExtensibleContentEditorPageSaveException(String msg) {
        super(msg);
    }

    public ExtensibleContentEditorPageSaveException(String msg, Exception e) {
        super(msg, e);
    }
}
