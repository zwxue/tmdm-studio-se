package com.amalto.workbench.detailtabs.sections.util;

import com.amalto.workbench.detailtabs.sections.BasePropertySection;

public class FixDMNameBasePropertySectionDataModelExtractor extends BasePropertySectionDataModelExtractor {

    public FixDMNameBasePropertySectionDataModelExtractor(BasePropertySection propSection) {
        this(propSection, "");
    }

    public FixDMNameBasePropertySectionDataModelExtractor(BasePropertySection propSection, String defaultDataModel) {
        super(propSection, defaultDataModel);
    }

    @Override
    public String[] getAllDataModelNames() {

        if (defaultDataModel == null || "".equals(defaultDataModel.trim()))
            return new String[0];

        return new String[] { defaultDataModel };
    }
}
