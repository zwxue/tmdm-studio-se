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
package org.talend.mdm.repository.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.repository.RepositoryObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.ContainerType;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class ProjectViewObjectFactory {

    private static Logger log = Logger.getLogger(ProjectViewObjectFactory.class);

    public static IRepositoryViewObject getFolderViewObject(ERepositoryObjectType type, String folderName, boolean isSystem) {
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        Property prop = PropertiesFactory.eINSTANCE.createProperty();
        prop.setId(factory.getNextId());
        //
        ContainerItem item = MdmpropertiesFactory.eINSTANCE.createContainerItem();
        item.setType(isSystem ? ContainerType.SYSTEM_FOLDER : ContainerType.FOLDER);

        item.setLabel(folderName);
        item.setRepObjType(type);
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        itemState.setDeleted(false);
        item.setState(itemState);
        //
        prop.setItem(item);
        //
        return new RepositoryObject(prop);
    }

    public static IRepositoryViewObject[] getCategoryViewObjects() {
        List<IRepositoryNodeConfiguration> configurations = RepositoryNodeConfigurationManager.getConfigurations();
        IRepositoryViewObject[] results = new IRepositoryViewObject[configurations.size()];
        int i = 0;
        for (IRepositoryNodeConfiguration conf : configurations) {

            IRepositoryViewObject categoryViewObject = getCategoryViewObject(conf);
            results[i] = categoryViewObject;
            i++;
        }
        return results;
    }

    private static IRepositoryViewObject getCategoryViewObject(IRepositoryNodeConfiguration conf) {
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        Property prop = PropertiesFactory.eINSTANCE.createProperty();
        prop.setId(factory.getNextId());
        //
        ContainerItem item = MdmpropertiesFactory.eINSTANCE.createContainerItem();
        item.setType(ContainerType.CATEGORY);
        item.setLabel(conf.getLabelProvider().getCategoryLabel());
        item.setRepObjType(conf.getResourceProvider().getRepositoryObjectType(item));
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        itemState.setDeleted(false);
        item.setState(itemState);
        //
        prop.setItem(item);
        //
        return new RepositoryObject(prop);
    }

}
