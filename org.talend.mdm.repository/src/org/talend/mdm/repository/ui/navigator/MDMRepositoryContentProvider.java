package org.talend.mdm.repository.ui.navigator;

import java.util.Collection;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryNodeContentProvider;
import org.talend.mdm.repository.core.IRepositoryNodeLabelProvider;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;

public class MDMRepositoryContentProvider implements ITreeContentProvider {

    @Override
    public Object[] getChildren(Object element) {
        if (element instanceof Collection) {
            return ((Collection) element).toArray();
        }
        if (element instanceof Object[]) {
            return (Object[]) element;
        }
        IRepositoryNodeContentProvider contentProvider = getContentProvider(element);
        if (contentProvider != null) {
            Object[] children = contentProvider.getChildren(element);
           if(children!=null){
               return children;
           }
        }
        return new Object[0];
    }

    @Override
    public Object[] getElements(Object element) {
        return getChildren(element);
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object getParent(Object element) {
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        return getChildren(element).length > 0;
    }

    private IRepositoryNodeContentProvider getContentProvider(Object element) {
        if (element instanceof IRepositoryViewObject) {
            Item item = ((IRepositoryViewObject) element).getProperty().getItem();
            IRepositoryNodeConfiguration conf = RepositoryNodeConfigurationManager.getConfiguration(item);
            if (conf != null) {
                return conf.getContentProvider();
            }
        }
        return null;
    }
}
