package com.amalto.workbench.detailtabs.sections.model.annotationinfo.extra;

import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;
import com.amalto.workbench.detailtabs.sections.handlers.LookupFieldsCommitHandler;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.ListContentsAnnotationInfo;

public class LookupFieldsAnnoInfo extends ListContentsAnnotationInfo {

    public LookupFieldsAnnoInfo(XSDComponent sourceComponent, String[] infos) {
        super(sourceComponent, infos);
    }

    public CommitHandler<LookupFieldsAnnoInfo> createCommitHandler() {
        return new LookupFieldsCommitHandler(this);
    }

}
