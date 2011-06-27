package org.talend.mdm.repository.ui.navigator;

import java.text.Collator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;


public class MDMRepositoryViewerSorter extends ViewerSorter {

    public MDMRepositoryViewerSorter() {
    }

    public MDMRepositoryViewerSorter(Collator collator) {
        super(collator);
    }

    @Override
    public int category(Object element) {
        if(element instanceof IRepositoryViewObject){
            Item item = ((IRepositoryViewObject)element).getProperty().getItem();
            if(item!=null){
                if(item instanceof MDMServerObjectItem){
                    if(item instanceof ContainerItem){
                        return -1;
                    }
                    return 1;
                }
               
            }
        }
        
        return 0;
    }

    

}
