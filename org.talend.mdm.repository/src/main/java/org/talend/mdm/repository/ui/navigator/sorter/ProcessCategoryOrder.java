package org.talend.mdm.repository.ui.navigator.sorter;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.talend.core.model.properties.FolderItem;
import org.talend.core.model.properties.Item;
import org.talend.mdm.repository.core.impl.transformerV2.ITransformerV2NodeConsDef;

public class ProcessCategoryOrder implements ISortOrder {

    private static List<String> folders = Arrays.asList(IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_BEFORESAVE,
            IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_BEFOREDEL, IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_ENTITYACTION,
            IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_WELCOMEACTION, IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_SMARTVIEW,
            IPath.SEPARATOR + ITransformerV2NodeConsDef.PATH_OTHER);

    public int getOrder(Item item) {
        
        if(item instanceof FolderItem) {
            String path0 = item.getState().getPath();
            if(!path0.isEmpty() && path0.lastIndexOf("/") == 0)
                return folders.indexOf(path0);
        }
        
        return -1;
    }
}
