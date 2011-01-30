package com.amalto.workbench.widgets.xmleditor.infoholder;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.infoextractor.IAllDataModelHolder;
import com.amalto.workbench.utils.ServerTreeNodeAllDataModelHolder;

public class AllDataModelInfoHolderProxy extends ExternalInfoHolder<IAllDataModelHolder> {

    private IAllDataModelHolder dataModelHolder;

    public AllDataModelInfoHolderProxy(TreeObject treeNode) {
        dataModelHolder = new ServerTreeNodeAllDataModelHolder(treeNode);
    }

    @Override
    public IAllDataModelHolder getExternalInfo() {
        return dataModelHolder;
    }

    @Override
    public String getId() {
        return INFOID_ALLDATAMODELHOLDER;
    }

}
