package org.talend.mdm.repository.ui.navigator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.ERepositoryStatus;

public class MDMServerDecorator implements ILightweightLabelDecorator {

    private static final ImageDescriptor IMG_SERVER = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "icons/run_co.gif"); //$NON-NLS-1$

    private static final ImageDescriptor IMG_G_LOCK = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "icons/locked_green_overlay.gif"); //$NON-NLS-1$

    private static final ImageDescriptor IMG_R_LOCK = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "icons/locked_red_overlay.gif"); //$NON-NLS-1$

    // private static final Color COLOR_GOLD = EclipseResourceManager.getColor(149, 125, 71);

    public void decorate(Object element, IDecoration decoration) {

        Item item = RepositoryResourceUtil.getItemFromRepViewObj(element);
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
            //
            decorateLockImage((IRepositoryViewObject) element, decoration);

        }
    }

    private void decorateLockImage(IRepositoryViewObject viewObj, IDecoration decoration) {
        ERepositoryStatus status = viewObj.getRepositoryStatus();
        switch (status) {
        case LOCK_BY_USER:
            decoration.addOverlay(IMG_G_LOCK, IDecoration.BOTTOM_RIGHT);
            break;
        case LOCK_BY_OTHER:
            decoration.addOverlay(IMG_R_LOCK, IDecoration.BOTTOM_RIGHT);
            break;
        default:
            decoration.addOverlay(null, IDecoration.BOTTOM_RIGHT);
            break;
        }

        System.out.println(status);
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
