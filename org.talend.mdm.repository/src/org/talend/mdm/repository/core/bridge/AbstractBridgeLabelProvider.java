// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.bridge;

import org.eclipse.swt.graphics.Image;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.repository.RepositoryViewObject;
import org.talend.core.ui.images.CoreImageProvider;
import org.talend.core.ui.images.OverlayImageProvider;
import org.talend.mdm.repository.core.impl.AbstractLabelProvider;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.repository.model.ERepositoryStatus;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class AbstractBridgeLabelProvider extends AbstractLabelProvider {

    public String getCategoryLabel(ERepositoryObjectType type) {
        return type.toString();
    }


    protected String getServerObjectItemText(Item item) {
        return ""; //$NON-NLS-1$
    }

    public Image getCategoryImage(Item item) {
        if (item instanceof ContainerItem) {
            ERepositoryObjectType repObjType = ((ContainerItem) item).getRepObjType();
            return CoreImageProvider.getImage(repObjType);
        }
        return null;
    }

    public Image getImage(Object element) {
        Image img = super.getImage(element);
        if (img == null && element instanceof IRepositoryViewObject) {
            return getRepositoryImage((IRepositoryViewObject) element);
        }
        return img;
    }

    protected Image getRepositoryImage(IRepositoryViewObject object) {
        // Item item = property.getItem();
        ERepositoryObjectType itemType = object.getRepositoryObjectType();
        Image img = null;
        if (object instanceof RepositoryViewObject && ((RepositoryViewObject) object).getCustomImage() != null) {
            img = ((RepositoryViewObject) object).getCustomImage();
        } else {
            img = CoreImageProvider.getImage(itemType);
        }

        ERepositoryStatus repositoryStatus = object.getRepositoryStatus();

        Image image = OverlayImageProvider.getImageWithStatus(img, repositoryStatus);

        ERepositoryStatus informationStatus = object.getInformationStatus();

        return OverlayImageProvider.getImageWithStatus(image, informationStatus);
    }
}
