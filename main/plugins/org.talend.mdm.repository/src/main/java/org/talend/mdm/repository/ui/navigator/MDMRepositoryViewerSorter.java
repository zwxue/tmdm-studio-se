package org.talend.mdm.repository.ui.navigator;

import java.text.Collator;

import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.ViewerSorter;
import org.talend.core.model.properties.FolderItem;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;

public class MDMRepositoryViewerSorter extends ViewerSorter {

    static Logger log = Logger.getLogger(MDMRepositoryViewerSorter.class);

    public MDMRepositoryViewerSorter() {
    }

    public MDMRepositoryViewerSorter(Collator collator) {
        super(collator);
    }

    @Override
    public int category(Object element) {
        if (element instanceof IRepositoryViewObject) {
            IRepositoryViewObject viewObject = (IRepositoryViewObject) element;
            ERepositoryObjectType repositoryObjectType = viewObject.getRepositoryObjectType();
            if (repositoryObjectType == null)
                return 0;
            if (repositoryObjectType == IServerObjectRepositoryType.TYPE_RECYCLE_BIN) {
                return 2;
            }
            try {
                Item item = viewObject.getProperty().getItem();
                if (item != null) {
                    if (item instanceof MDMServerObjectItem) {
                        return 1;
                    }
                    if (item instanceof ContainerItem) {
                        int typeValue = ((FolderItem) item).getType().getValue();
                        return (typeValue == FolderType.STABLE_SYSTEM_FOLDER) ? -2 : -1;
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }

        return 0;
    }
}
