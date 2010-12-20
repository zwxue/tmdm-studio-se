package com.amalto.workbench.detailtabs.sections.model.annotationinfo.langinfo;

import java.util.Collection;

import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;
import com.amalto.workbench.detailtabs.sections.handlers.LabelCommitHandler;

class LableInfoCollection extends LanguageInfoCollection {

    public LableInfoCollection(XSDComponent sourceXSDComponent, Collection<LanguageInfo> initLanguageInfos) {
        super(sourceXSDComponent, initLanguageInfos);
    }

    public LableInfoCollection(XSDComponent sourceXSDComponent, LanguageInfo[] initLanguageInfos) {
        super(sourceXSDComponent, initLanguageInfos);
    }

    @Override
    public boolean isLabelInfo() {
        return true;
    }

    public CommitHandler createCommitHandler() {
        return new LabelCommitHandler(this);
    }
}
