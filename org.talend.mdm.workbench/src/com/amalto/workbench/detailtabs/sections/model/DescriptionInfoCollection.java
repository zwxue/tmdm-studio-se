package com.amalto.workbench.detailtabs.sections.model;

import java.util.Collection;

import org.eclipse.xsd.XSDComponent;

public class DescriptionInfoCollection extends LanguageInfoCollection {

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

}
