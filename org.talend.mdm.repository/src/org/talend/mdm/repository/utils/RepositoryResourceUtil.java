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

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.utils.VersionUtils;
import org.talend.commons.utils.workbench.resources.ResourceUtils;
import org.talend.core.context.RepositoryContext;
import org.talend.core.model.general.Project;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.repository.RepositoryObject;
import org.talend.core.repository.model.ResourceModelUtils;
import org.talend.core.repository.utils.XmiResourceManager;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.commmon.util.webapp.XSystemObjects;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.models.ContainerRepositoryObject;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class RepositoryResourceUtil {

    static Logger log = Logger.getLogger(RepositoryResourceUtil.class);

    static XmiResourceManager resourceManager = new XmiResourceManager();

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

    public static IRepositoryViewObject createFolderViewObject(ERepositoryObjectType type, String folderName, Item pItem,
            boolean isSystem) {
        Property prop = PropertiesFactory.eINSTANCE.createProperty();
        prop.setId(EcoreUtil.generateUUID());
        //

        ContainerItem item = MdmpropertiesFactory.eINSTANCE.createContainerItem();
        item.setType(isSystem ? FolderType.SYSTEM_FOLDER_LITERAL : FolderType.FOLDER_LITERAL);

        item.setLabel(folderName);
        item.setRepObjType(type);
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        itemState.setDeleted(false);

        item.setState(itemState);

        //
        prop.setItem(item);
        //
        if (!isSystem) {
            try {
                Project project = ProjectManager.getInstance().getCurrentProject();
                IProject fsProject = ResourceModelUtils.getProject(project);
                ItemState state = pItem.getState();
                itemState.setPath(state.getPath() + IPath.SEPARATOR + folderName);
                String path = ERepositoryObjectType.getFolderName(type);
                if (!path.isEmpty()) {
                    path += itemState.getPath();
                }

                IFolder folder = fsProject.getFolder(path);
                if (!folder.exists()) {

                    ResourceUtils.createFolder(folder);

                }
            } catch (PersistenceException e) {
                log.error(e.getMessage(), e);
            }

        }
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
        Property prop = PropertiesFactory.eINSTANCE.createProperty();
        prop.setId(EcoreUtil.generateUUID());
        //
        ContainerItem item = MdmpropertiesFactory.eINSTANCE.createContainerItem();
        item.setType(FolderType.STABLE_SYSTEM_FOLDER_LITERAL);
        item.setLabel(conf.getLabelProvider().getCategoryLabel());
        item.setRepObjType(conf.getResourceProvider().getRepositoryObjectType(item));
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        itemState.setDeleted(false);
        itemState.setPath("");
        item.setState(itemState);
        //
        prop.setItem(item);
        //
        return new ContainerRepositoryObject(prop);
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

    public static List<IRepositoryViewObject> findViewObjects(ERepositoryObjectType type, Item parentItem) {
        try {
            Project project = ProjectManager.getInstance().getCurrentProject();
            IProject fsProject = ResourceModelUtils.getProject(project);

            String path = ERepositoryObjectType.getFolderName(type);
            if (!path.isEmpty()) {
                path += parentItem.getState().getPath();
                IFolder folder = fsProject.getFolder(new Path(path));
                return findViewObjects(type, parentItem, folder);
            }
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        return Collections.EMPTY_LIST;

    }

    public static List<IRepositoryViewObject> findViewObjects(ERepositoryObjectType type, Item parentItem, IFolder folder) {
        List<IRepositoryViewObject> viewObjects = new LinkedList<IRepositoryViewObject>();
        try {
            for (IResource res : folder.members()) {
                if (res instanceof IFolder) {
                    IRepositoryViewObject folderObject = createFolderViewObject(type, res.getName(), parentItem, false);
                    viewObjects.add(folderObject);
                } else if (res instanceof IFile) {
                    if (resourceManager.isPropertyFile((IFile) res)) {
                        Property property = resourceManager.loadProperty(res);
                        viewObjects.add(new RepositoryObject(property));
                    }
                }
            }
        } catch (CoreException e) {
            log.error(e.getMessage(), e);
        }
        // ((ContainerRepositoryObject) parentItem.getParent()).getChildren().addAll(viewObjects);
        return viewObjects;
    }

    public static List<IRepositoryViewObject> findViewObjectsByType(ERepositoryObjectType type, Item parentItem, int systemType) {
        try {
            Project project = ProjectManager.getInstance().getCurrentProject();
            IProject fsProject = ResourceModelUtils.getProject(project);
            IFolder stableFolder = fsProject.getFolder(((ContainerItem) parentItem).getRepObjType().getFolder());
            List<IRepositoryViewObject> viewObjects = findViewObjects(type, parentItem, stableFolder);
            IRepositoryViewObject sysFolderViewOj = createFolderViewObject(type, "system", null, true); //$NON-NLS-1$
            for (Iterator<IRepositoryViewObject> il = viewObjects.iterator(); il.hasNext();) {
                IRepositoryViewObject viewObject = il.next();
                String key = viewObject.getProperty().getLabel();
                if (XSystemObjects.isXSystemObject(systemType, key)) {
                    sysFolderViewOj.getChildren().add(viewObject);
                    ((MDMServerObjectItem) viewObject.getProperty().getItem()).getMDMServerObject().setSystem(true);
                    il.remove();
                }
            }
            viewObjects.add(0, sysFolderViewOj);
            return viewObjects;
        } catch (PersistenceException e) {
            return Collections.EMPTY_LIST;
        }
    }
}
