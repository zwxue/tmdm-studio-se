package com.amalto.workbench.detailtabs.sections.util;

import org.eclipse.xsd.XSDSchema;

import com.amalto.workbench.detailtabs.sections.BasePropertySection;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.infoextractor.IAllDataModelHolder;
import com.amalto.workbench.utils.Util;

public class BasePropertySectionDataModelExtractor extends BasePropertySectionGlobalInfoExtractor implements IAllDataModelHolder {

    protected String defaultDataModel = "";

    public BasePropertySectionDataModelExtractor(BasePropertySection propSection) {
        this(propSection, "");
    }

    public BasePropertySectionDataModelExtractor(BasePropertySection propSection, String defaultDataModel) {
        super(propSection, TreeObject.DATA_MODEL);

        this.defaultDataModel = defaultDataModel;
    }

    public String[] getAllDataModelNames() {
        return getGlobalInfos();
    }

    public boolean hasDataModel() {
        return getAllDataModelNames().length > 0;
    }

    public XSDSchema getDataModel(String dataModelName) {
        return Util.getXSDSchema(propSection.getTreeObject(), dataModelName);
    }

    public String getDefaultDataModel() {
        return defaultDataModel;
    }

    public void setDefaultDataModel(String defaultDataModel) {
        this.defaultDataModel = defaultDataModel;
    }
}
