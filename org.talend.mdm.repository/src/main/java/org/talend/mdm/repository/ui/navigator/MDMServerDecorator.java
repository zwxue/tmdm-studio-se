package org.talend.mdm.repository.ui.navigator;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

public class MDMServerDecorator implements ILightweightLabelDecorator {

    private static final ImageDescriptor IMG_SERVER = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "icons/run_co.gif"); //$NON-NLS-1$

    public void decorate(Object element, IDecoration decoration) {
        IRepositoryViewObject viewObj = (IRepositoryViewObject) element;
        Item item = RepositoryResourceUtil.getItemFromRepViewObj(viewObj);
        if (isDeleted(viewObj.getRepositoryObjectType(), item)) {
            decorateRecycleBin(item, decoration);
        } else {
            decorateRepositoryObject(item, decoration);
        }

    }

    private boolean isDeleted(ERepositoryObjectType type, Item item) {
        if (item instanceof ContainerItem) {
            return RepositoryResourceUtil.isDeletedFolder(item, type);
        }
        return item.getState().isDeleted();
    }

    private void decorateRepositoryObject(Item item, IDecoration decoration) {
        if (item != null && item instanceof MDMServerObjectItem) {
            MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
            MDMServerDef serverDef = serverObject.getLastServerDef();
            if (serverDef != null) {

                decoration.addOverlay(IMG_SERVER, IDecoration.TOP_RIGHT);
                if (serverObject.isChanged()) {
                    decoration.addSuffix(" " + serverDef.getName() + " (*)"); //$NON-NLS-1$ //$NON-NLS-2$ 
                } else {
                    decoration.addSuffix(" " + serverDef.getName()); //$NON-NLS-1$
                }
            } else {
                if (serverObject.isChanged()) {
                    decoration.addSuffix(" (*)"); //$NON-NLS-1$
                }
            }
        }
    }

    private void decorateRecycleBin(Item item, IDecoration decoration) {
        ItemState state = item.getState();
        String path = state.getPath();

        int index = path.lastIndexOf(IPath.SEPARATOR);
        if (index > 0) {
            path = path.substring(0, index);
        } else if (index == 0) {
            path = "";
        }

        if (path.length() > 0) {
            decoration.addSuffix(" (" + path + ")");
        }
    }

    public void addListener(ILabelProviderListener listener) {
    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
    }
}
