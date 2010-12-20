package com.amalto.workbench.detailtabs.sections.model.annotationinfo.simpleinfo;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.model.annotationinfo.AnnotaionInfo;

public abstract class SimpleAnnotationInfo extends AnnotaionInfo {

    private List<String> infos = new ArrayList<String>();

    public SimpleAnnotationInfo(XSDComponent sourceComponent, String[] infos) {
        super(sourceComponent);

        for (String eachInfo : infos) {
            this.infos.add(eachInfo);
        }
    }

    public String[] getInfos() {
        return infos.toArray(new String[0]);
    }

}
