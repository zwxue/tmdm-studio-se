package com.amalto.workbench.detailtabs.sections.model.annotationinfo;

import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.model.ISubmittable;

public abstract class AnnotaionInfo implements ISubmittable {

    private XSDComponent sourceXSDComponent;

    public AnnotaionInfo(XSDComponent sourceXSDComponent) {

        this.sourceXSDComponent = sourceXSDComponent;
    }

    public XSDComponent getSourceXSDComponent() {
        return sourceXSDComponent;
    }
}
