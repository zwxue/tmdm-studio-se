// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2011 Talend �C www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.mdm.repository.core.impl;

import java.util.List;

import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IRepositoryNodeContentProvider;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.models.ContainerRepositoryObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public abstract class AbstractContentProvider implements IRepositoryNodeContentProvider {

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.IRepositoryNodeContentProvider#getChildren(java.lang.Object)
     */

    public Object[] getChildren(Object element) {
        Item item = RepositoryResourceUtil.getItemFromRepViewObj(element);
        if (item != null && item instanceof ContainerItem) {
            ContainerItem containerItem = (ContainerItem) item;
            if (containerItem.getType() == FolderType.STABLE_SYSTEM_FOLDER_LITERAL) {
                List<IRepositoryViewObject> viewObjects = getViewObjFromStableSystemFolder(containerItem);
                if (viewObjects != null) {
                    ((ContainerRepositoryObject) element).getChildren().addAll(viewObjects);
                    return viewObjects.toArray();
                }
            }
            if (containerItem.getType() == FolderType.FOLDER_LITERAL) {
                List<IRepositoryViewObject> children = RepositoryResourceUtil.findViewObjects(containerItem.getRepObjType(),
                        containerItem);
                if (children != null) {
                    ((ContainerRepositoryObject) element).getChildren().addAll(children);
                    return children.toArray();
                }
            }
            if (containerItem.getType() == FolderType.SYSTEM_FOLDER_LITERAL) {
                List<IRepositoryViewObject> children = ((ContainerRepositoryObject) element).getChildren();
                if (children != null) {
                    return children.toArray();
                }
            }
        }
        return new Object[0];
    }

    protected abstract List<IRepositoryViewObject> getViewObjFromStableSystemFolder(Item parentItem);

    public boolean isShownInRoot() {
        return true;
    }

}
