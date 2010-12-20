package com.amalto.workbench.detailtabs.sections.model.annotationinfo.langinfo;

import java.util.Collection;

import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;
import com.amalto.workbench.detailtabs.sections.handlers.DescriptionCommitHandler;

class DescriptionInfoCollection extends LanguageInfoCollection {

    public DescriptionInfoCollection(XSDComponent sourceXSDComponent, Collection<LanguageInfo> initLanguageInfos) {
        super(sourceXSDComponent, initLanguageInfos);
    }

    public DescriptionInfoCollection(XSDComponent sourceXSDComponent, LanguageInfo[] initLanguageInfos) {
        super(sourceXSDComponent, initLanguageInfos);
    }

    @Override
    public boolean isDescriptionInfo() {
        return true;
    }

    public CommitHandler createCommitHandler() {
        return new DescriptionCommitHandler(this);
    }
}
