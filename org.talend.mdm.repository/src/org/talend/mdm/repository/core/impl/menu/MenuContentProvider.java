// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2011 Talend ¨C www.talend.com
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
package org.talend.mdm.repository.core.impl.menu;

import java.util.List;

import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IRepositoryNodeContentProvider;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.ContainerType;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.models.TreeObject;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class MenuContentProvider implements IRepositoryNodeContentProvider {

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.IRepositoryNodeContentProvider#getChildren(java.lang.Object)
     */
    @Override
    public Object[] getChildren(Object element) {
        Item item = getItem(element);
        if (item != null && item instanceof ContainerItem) {
            ContainerItem containerItem = (ContainerItem) item;
            if (containerItem.getType() == ContainerType.CATEGORY) {
                List<IRepositoryViewObject> viewObjects = RepositoryResourceUtil.findAllViewObjects(
                        IServerObjectRepositoryType.TYPE_MENU, TreeObject.MENU);
                if (viewObjects != null) {
                    return viewObjects.toArray();
                }
            }
            if (containerItem.getType() != ContainerType.CATEGORY) {
                List<IRepositoryViewObject> children = ((IRepositoryViewObject) element).getChildren();
                if (children != null) {
                    return children.toArray();
                }
            }
        }
        return null;
    }

    protected Item getItem(Object element) {
        if (element instanceof IRepositoryViewObject) {
            Item item = ((IRepositoryViewObject) element).getProperty().getItem();
            return item;
        }
        return null;
    }
}
