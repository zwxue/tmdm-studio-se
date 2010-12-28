package com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship;

import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;
import com.amalto.workbench.detailtabs.sections.handlers.ElementForeighKeyCommitHandler;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.SingleContentAnnotationInfo;

public class ForeignKeyAnnoInfo extends SingleContentAnnotationInfo {

    public ForeignKeyAnnoInfo(XSDComponent sourceXSDComponent, String xpath) {
        super(sourceXSDComponent, xpath);
    }

    public CommitHandler<ForeignKeyAnnoInfo> createCommitHandler() {
        return new ElementForeighKeyCommitHandler(this);
    }
}
