package com.amalto.workbench.models.infoextractor;

import org.eclipse.xsd.XSDSchema;

public interface IAllDataModelHolder {

    public String[] getAllDataModelNames();

    public boolean hasDataModel();

    public XSDSchema getDataModel(String dataModelName);
}
