package com.amalto.workbench.detailtabs.sections;

import org.eclipse.xsd.XSDComponent;


public abstract class XSDComponentSection extends CommitBarListenerSection<XSDComponent> {

    protected XSDComponent curXSDComponent;

    @Override
    protected XSDComponent getEditedObj() {
        return curXSDComponent;
    }

    @Override
    protected void initUIContents(XSDComponent editedObj) {
        curXSDComponent = editedObj;
    }
}
