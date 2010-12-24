package com.amalto.workbench.detailtabs.sections.model.annotationinfo.listinfo;

import org.eclipse.xsd.XSDComponent;

public abstract class SingleContentAnnotationInfo extends ListContentsAnnotationInfo {

    public SingleContentAnnotationInfo(XSDComponent sourceComponent, String value) {
        super(sourceComponent, new String[] { value });
    }

    public String getValue() {
        return getInfos()[0];
    }

}
