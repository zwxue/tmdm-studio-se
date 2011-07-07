package org.talend.mdm.repository.ui.navigator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.talend.core.model.properties.Item;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

public class MDMServerDecorator implements ILightweightLabelDecorator {

    private static final ImageDescriptor IMG_SERVER = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "icons/run_co.gif"); //$NON-NLS-1$

    // private static final Color COLOR_GOLD = EclipseResourceManager.getColor(149, 125, 71);

    public void decorate(Object element, IDecoration decoration) {

        Item item = RepositoryResourceUtil.getItemFromRepViewObj(element);
        if (item != null && item instanceof MDMServerObjectItem) {
            MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
            MDMServerDef serverDef = serverObject.getLastServerDef();
            if (serverDef != null) {
                String host = serverDef.getHost();

                decoration.addOverlay(IMG_SERVER, IDecoration.TOP_RIGHT);
                decoration.addSuffix(" " + host); //$NON-NLS-1$
            }
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
