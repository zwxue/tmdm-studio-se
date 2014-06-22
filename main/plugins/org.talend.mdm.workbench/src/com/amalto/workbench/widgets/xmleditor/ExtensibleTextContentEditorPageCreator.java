package com.amalto.workbench.widgets.xmleditor;

import org.eclipse.swt.widgets.Composite;

public class ExtensibleTextContentEditorPageCreator extends ExtensibleContentEditorPageCreator {

    @Override
    public ExtensibleContentEditorPage createXMLEditorPage(Composite parent, int style) {
        return new ExtensibleTextContentEditorPage(parent, style);
    }

}
