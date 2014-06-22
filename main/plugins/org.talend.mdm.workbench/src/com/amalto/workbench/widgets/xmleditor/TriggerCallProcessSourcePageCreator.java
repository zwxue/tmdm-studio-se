package com.amalto.workbench.widgets.xmleditor;

import org.eclipse.swt.widgets.Composite;

import com.amalto.workbench.widgets.xmleditor.ExtensibleContentEditorPage;
import com.amalto.workbench.widgets.xmleditor.ExtensibleContentEditorPageCreator;

public class TriggerCallProcessSourcePageCreator extends ExtensibleContentEditorPageCreator {

    @Override
    public ExtensibleContentEditorPage createXMLEditorPage(Composite parent, int style) {
        return new TriggerCallProcessSourcePage(parent, style);
    }

}
