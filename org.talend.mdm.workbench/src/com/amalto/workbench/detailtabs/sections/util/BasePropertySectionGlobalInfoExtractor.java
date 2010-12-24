package com.amalto.workbench.detailtabs.sections.util;

import com.amalto.workbench.detailtabs.sections.BasePropertySection;
import com.amalto.workbench.utils.Util;

public abstract class BasePropertySectionGlobalInfoExtractor {

    protected BasePropertySection propSection;

    protected int typeCode;

    public BasePropertySectionGlobalInfoExtractor(BasePropertySection propSection, int typeCode) {
        this.propSection = propSection;
        this.typeCode = typeCode;
    }

    public String[] getGlobalInfos() {

        if (propSection.getTreeObject() == null)
            return new String[0];

        return Util.getChildren(propSection.getTreeObject().getServerRoot(), typeCode).toArray(new String[0]);
    }

    public boolean hasGlobalInfo() {
        return getGlobalInfos().length > 0;
    }

}
