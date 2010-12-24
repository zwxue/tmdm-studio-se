package com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship;

import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;
import com.amalto.workbench.detailtabs.sections.handlers.ElementForeignKeyInfosCommitHandler;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.listinfo.ListContentsAnnotationInfo;

public class ForeignKeyInfosAnnoInfo extends ListContentsAnnotationInfo {

    private boolean isResolveAutoInWeb;

    public ForeignKeyInfosAnnoInfo(XSDComponent sourceComponent, String[] infos, boolean isResolveAutoInWeb) {
        super(sourceComponent, infos);

        this.isResolveAutoInWeb = isResolveAutoInWeb;
    }

    public CommitHandler<ForeignKeyInfosAnnoInfo> createCommitHandler() {
        return new ElementForeignKeyInfosCommitHandler(this);
    }

    public boolean isResolveAutoInWeb() {
        return isResolveAutoInWeb;
    }
}
