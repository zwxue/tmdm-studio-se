package com.amalto.workbench.detailtabs.sections.model;

import java.util.Collection;

import org.eclipse.xsd.XSDComponent;

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
}
