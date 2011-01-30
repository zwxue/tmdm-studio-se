package com.amalto.workbench.utils;

import org.eclipse.xsd.XSDSchema;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.infoextractor.IAllDataModelHolder;

public class ServerTreeNodeAllDataModelHolder implements IAllDataModelHolder {

    private TreeObject treeNode;

    public ServerTreeNodeAllDataModelHolder(TreeObject treeNode) {
        this.treeNode = treeNode;
    }

    public String[] getAllDataModelNames() {
        return Util.getChildren(treeNode.getServerRoot(), TreeObject.DATA_MODEL).toArray(new String[0]);
    }

    public boolean hasDataModel() {
        return getAllDataModelNames().length > 0;
    }

    public XSDSchema getDataModel(String dataModelName) {
        return Util.getXSDSchema(treeNode, dataModelName);
    }

}
