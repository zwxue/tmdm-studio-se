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
package org.talend.mdm.repository.utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Path;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.context.RepositoryContext;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.repository.RepositoryObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.commmon.util.webapp.XSystemObjects;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.ContainerType;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.models.ContainerRepositoryObject;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class RepositoryResourceUtil {

    static Logger log = Logger.getLogger(RepositoryResourceUtil.class);

    public static boolean createItem(Item item, String propLabel) {
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        RepositoryContext context = factory.getRepositoryContext();

        Property prop = PropertiesFactory.eINSTANCE.createProperty();
        item.setProperty(prop);
        try {
            String nextId = factory.getNextId();
            Property property = item.getProperty();
            property.setId(nextId);
            property.setVersion(VersionUtils.DEFAULT_VERSION);
            property.setAuthor(context.getUser());
            property.setLabel(propLabel);
            //
            factory.create(item, new Path("")); //$NON-NLS-1$
            return true;
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    public static IRepositoryViewObject createFolderViewObject(ERepositoryObjectType type, String folderName, boolean isSystem) {
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
        return new ContainerRepositoryObject(prop);
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

    public static List<IRepositoryViewObject> findAllViewObjects(ERepositoryObjectType type) {
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        try {
            return factory.getAll(type);

        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static List<IRepositoryViewObject> findAllViewObjects(ERepositoryObjectType type, int systemType) {
        List<IRepositoryViewObject> viewObjects = findAllViewObjects(type);
        List<IRepositoryViewObject> systemChildren = new LinkedList<IRepositoryViewObject>();
        IRepositoryViewObject folderViewOj = createFolderViewObject(type, "system", true); //$NON-NLS-1$
        for (Iterator<IRepositoryViewObject> il = viewObjects.iterator(); il.hasNext();) {
            IRepositoryViewObject viewObject = il.next();
            String key = viewObject.getProperty().getLabel();
            if (XSystemObjects.isXSystemObject(systemType, key)) {
                folderViewOj.getChildren().add(viewObject);
                il.remove();
            }
        }
        viewObjects.add(0, folderViewOj);
        return viewObjects;
    }
}
