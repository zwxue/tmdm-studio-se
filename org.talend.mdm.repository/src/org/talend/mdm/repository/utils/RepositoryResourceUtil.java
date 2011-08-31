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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
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
import org.talend.core.model.properties.FolderItem;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.repository.RepositoryViewObject;
import org.talend.core.repository.model.ResourceModelUtils;
import org.talend.core.repository.utils.XmiResourceManager;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryNodeResourceProvider;
import org.talend.mdm.repository.core.bridge.MDMRepositoryNode;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.core.service.IInteractiveHandler;
import org.talend.mdm.repository.core.service.InteractiveService;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.models.ContainerRepositoryObject;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.IRepositoryNode.ENodeType;
import org.talend.repository.model.IRepositoryNode.EProperties;
import org.talend.repository.model.RepositoryNode;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class RepositoryResourceUtil {

    static Logger log = Logger.getLogger(RepositoryResourceUtil.class);

    static XmiResourceManager resourceManager = new XmiResourceManager();

    private static final String DIVIDE = "/"; //$NON-NLS-1$

    public static boolean createItem(Item item, String propLabel) {
        return createItem(item, propLabel, VersionUtils.DEFAULT_VERSION);
    }

    public static void saveItem(Item item) {
        IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(item);
        if (configuration != null) {
            IRepositoryNodeResourceProvider resourceProvider = configuration.getResourceProvider();
            if (resourceProvider.needSaveReferenceFile()) {
                resourceProvider.handleReferenceFile(item);
            }
        } else {
            // save
            IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
            try {
                factory.save(item);
            } catch (PersistenceException e) {
                log.error(e);
            }
        }
    }

    public static boolean createItem(Item item, String propLabel, String version) {

        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        RepositoryContext context = factory.getRepositoryContext();

        Property prop = PropertiesFactory.eINSTANCE.createProperty();
        item.setProperty(prop);
        try {
            String nextId = factory.getNextId();
            Property property = item.getProperty();
            property.setId(nextId);
            property.setVersion(version);
            property.setAuthor(context.getUser());
            property.setLabel(propLabel);
            //
            factory.create(item, new Path(item.getState().getPath()));
            //
            IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(item);
            if (configuration != null) {
                IRepositoryNodeResourceProvider resourceProvider = configuration.getResourceProvider();
                if (resourceProvider.needSaveReferenceFile()) {
                    resourceProvider.handleReferenceFile(item);
                }
            }
            return true;
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    public static IFolder getFolder(IRepositoryViewObject viewObj) {
        try {
            Item pItem = viewObj.getProperty().getItem();
            Project project = ProjectManager.getInstance().getCurrentProject();
            IProject fsProject = ResourceModelUtils.getProject(project);
            ItemState state = pItem.getState();

            String path = ERepositoryObjectType.getFolderName(viewObj.getRepositoryObjectType());
            if (!path.isEmpty()) {
                path += state.getPath();
            }

            return fsProject.getFolder(path);
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static String getTextFileContent(IFile file, String encode) {
        InputStream inputStream = null;

        ByteArrayOutputStream os = null;
        try {
            os = new ByteArrayOutputStream();
            inputStream = file.getContents();
            byte[] ba = new byte[inputStream.available()];
            inputStream.read(ba);
            os.write(ba);
            return os.toString(encode);

        } catch (CoreException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                }
            }
        }
        return null;
    }

    public static IFile findReferenceFile(ERepositoryObjectType type, Item item, String fileExtension) {
        IFolder folder = RepositoryResourceUtil.getFolder(type);
        String path = item.getState().getPath();
        if (path != null && path.length() > 0) {
            folder = folder.getFolder(path);
        }
        Property property = item.getProperty();
        String fileName = property.getLabel() + "_" + property.getVersion() + "." + (fileExtension != null ? fileExtension : ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        IFile file = folder.getFile(fileName);
        return file;
    }

    public static IFolder getFolder(ERepositoryObjectType type) {
        IFolder objectFolder = null;
        try {
            Project currentProject = ProjectManager.getInstance().getCurrentProject();
            IProject fsProject = ResourceModelUtils.getProject(currentProject);
            if (fsProject == null) {
                return null;
            }

            objectFolder = ResourceUtils.getFolder(fsProject, ERepositoryObjectType.getFolderName(type), true);
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }

        return objectFolder;
    }

    private static boolean isSystemFolder(Item pItem, String folderName) {
        if (pItem instanceof ContainerItem) {
            return ((ContainerItem) pItem).getType().equals(FolderType.SYSTEM_FOLDER_LITERAL)
                    && folderName.equalsIgnoreCase("system"); //$NON-NLS-1$
        }
        return false;
    }

    public static IRepositoryViewObject createFolderViewObject(ERepositoryObjectType type, String folderName, Item pItem,
            boolean isSystem) {
        Property prop = PropertiesFactory.eINSTANCE.createProperty();
        prop.setId(EcoreUtil.generateUUID());
        //

        ContainerItem item = MdmpropertiesFactory.eINSTANCE.createContainerItem();
        isSystem = isSystemFolder(pItem, folderName);
        item.setType(isSystem ? FolderType.STABLE_SYSTEM_FOLDER_LITERAL : FolderType.FOLDER_LITERAL);

        item.setLabel(folderName);
        item.setRepObjType(type);
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        itemState.setDeleted(false);

        item.setState(itemState);

        //
        prop.setItem(item);
        prop.setLabel(folderName);
        try {
            //

            if (!isSystem) {
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

            } else {
                itemState.setPath(folderName);
            }
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        ContainerRepositoryObject containerRepositoryObject = new ContainerRepositoryObject(prop);
        //
        ContainerCacheService.put(containerRepositoryObject);
        //
        return containerRepositoryObject;
    }

    public static IRepositoryViewObject[] getCategoryViewObjects() {
        List<IRepositoryNodeConfiguration> configurations = RepositoryNodeConfigurationManager.getConfigurations();
        List<IRepositoryViewObject> results = new LinkedList<IRepositoryViewObject>();
        for (IRepositoryNodeConfiguration conf : configurations) {
            if (conf.getContentProvider().isShownInRoot()) {
                IRepositoryViewObject categoryViewObject = getCategoryViewObject(conf);
                results.add(categoryViewObject);
            }
        }
        return results.toArray(new IRepositoryViewObject[0]);
    }

    public static IRepositoryViewObject getCategoryViewObject(IRepositoryNodeConfiguration conf) {
        Property prop = PropertiesFactory.eINSTANCE.createProperty();
        prop.setId(EcoreUtil.generateUUID());
        //
        ContainerItem item = MdmpropertiesFactory.eINSTANCE.createContainerItem();
        item.setType(FolderType.SYSTEM_FOLDER_LITERAL);

        item.setRepObjType(conf.getResourceProvider().getRepositoryObjectType(item));
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        itemState.setDeleted(false);
        itemState.setPath(""); //$NON-NLS-1$
        item.setState(itemState);
        item.setLabel(conf.getLabelProvider().getCategoryLabel(item.getRepObjType()));
        //
        prop.setItem(item);
        //
        ContainerRepositoryObject containerObject = new ContainerRepositoryObject(prop);
        ContainerCacheService.put(containerObject);
        return containerObject;
    }

    public static List<IRepositoryViewObject> findAllViewObjects(ERepositoryObjectType type) {
        return findAllViewObjects(type, true);
    }

    public static List<MDMServerObject> findAllServerObjects(ERepositoryObjectType type) {
        List<IRepositoryViewObject> viewObjects = RepositoryResourceUtil.findAllViewObjects(type);
        List<MDMServerObject> serverObjects = new LinkedList<MDMServerObject>();
        if (viewObjects != null) {
            for (IRepositoryViewObject viewObj : viewObjects) {
                Item item = viewObj.getProperty().getItem();
                if (item instanceof MDMServerObjectItem) {
                    serverObjects.add(((MDMServerObjectItem) item).getMDMServerObject());
                }
            }
        }
        return serverObjects;
    }

    public static void removeViewObjectPhysically(ERepositoryObjectType type, String name, String version, String path) {
        if (type == null || name == null)
            throw new IllegalArgumentException();
        if (version == null)
            version = VersionUtils.DEFAULT_VERSION;
        if (path == null)
            path = ""; //$NON-NLS-1$
        try {
            IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
            for (IRepositoryViewObject viewObj : factory.getAll(type)) {
                Property property = viewObj.getProperty();
                String itemPath = property.getItem().getState().getPath();
                if (itemPath.equals(path) && property.getLabel().equals(name) && property.getVersion().equals(version)) {
                    factory.deleteObjectPhysical(viewObj, version);
                    return;
                }
            }
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static List<IRepositoryViewObject> findAllViewObjects(ERepositoryObjectType type, boolean useRepositoryViewObject) {
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        try {
            List<IRepositoryViewObject> allObjs = factory.getAll(type);
            List<IRepositoryViewObject> viewObjects = new LinkedList<IRepositoryViewObject>();
            for (IRepositoryViewObject viewObj : allObjs) {
                Item item = viewObj.getProperty().getItem();
                ItemState state = item.getState();
                if (!state.isDeleted()) {
                    IInteractiveHandler handler = InteractiveService.findHandler(viewObj.getRepositoryObjectType());
                    handler.assertPropertyIsInited(item);
                    if (useRepositoryViewObject) {
                        viewObjects.add(new RepositoryViewObject(viewObj.getProperty()));
                    } else {
                        viewObjects.add(viewObj);
                    }
                }
            }
            return viewObjects;
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static boolean isExistByName(ERepositoryObjectType type, String name) {
        List<IRepositoryViewObject> viewObjects = findAllViewObjects(type);
        if (viewObjects != null) {
            for (IRepositoryViewObject viewObj : viewObjects) {
                if (viewObj.getProperty().getLabel().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<IRepositoryViewObject> findViewObjects(ERepositoryObjectType type, Item parentItem) {
        return findViewObjects(type, parentItem, false);
    }

    public static List<IRepositoryViewObject> findViewObjects(ERepositoryObjectType type, Item parentItem,
            boolean useRepositoryViewObject) {
        try {
            Project project = ProjectManager.getInstance().getCurrentProject();
            IProject fsProject = ResourceModelUtils.getProject(project);

            String path = ERepositoryObjectType.getFolderName(type);
            if (!path.isEmpty()) {
                if (!path.endsWith(DIVIDE))
                    path += DIVIDE;
                path += parentItem.getState().getPath();
                IFolder folder = fsProject.getFolder(new Path(path));
                return findViewObjects(type, parentItem, folder, useRepositoryViewObject);
            }
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        return Collections.EMPTY_LIST;

    }

    public static List<IRepositoryViewObject> findViewObjects(ERepositoryObjectType type, Item parentItem, IFolder folder,
            boolean useRepositoryViewObject) {
        List<IRepositoryViewObject> viewObjects = new LinkedList<IRepositoryViewObject>();
        try {
            for (IResource res : folder.members()) {
                if (res instanceof IFolder) {
                    IRepositoryViewObject folderObject = createFolderViewObject(type, res.getName(), parentItem, false);
                    if (!isDeletedFolder((IFolder) res)) {
                        viewObjects.add(folderObject);
                    }
                }
                // else if (res instanceof IFile) {
                // if (resourceManager.isPropertyFile((IFile) res)) {
                // Property property = resourceManager.loadProperty(res);
                // viewObjects.add(new RepositoryObject(property));
                // }
                // }
            }
            List<IRepositoryViewObject> children = findViewObjectsInFolder(type, parentItem, useRepositoryViewObject);
            viewObjects.addAll(children);

        } catch (CoreException e) {
            log.error(e.getMessage(), e);
        }
        // ((ContainerRepositoryObject) parentItem.getParent()).getChildren().addAll(viewObjects);
        return viewObjects;
    }

    private static boolean isDeletedFolder(IFolder folder) {
        String path = folder.getProjectRelativePath().toString();
        return isDeletedFolder(path);
    }

    private static boolean isDeletedFolder(String folderPath) {
        if (folderPath == null)
            throw new IllegalArgumentException();
        List deletedFolders = ProjectManager.getInstance().getCurrentProject().getEmfProject().getDeletedFolders();
        return deletedFolders.contains(folderPath);
    }

    public static List<IRepositoryViewObject> findViewObjectsInFolder(ERepositoryObjectType type, Item parentItem,
            boolean useRepositoryViewObject) {
        // because the IProxyRepositoryFactory doesn't expose the getSerializableFromFolder method ,so only through the
        // following to get object
        List<IRepositoryViewObject> viewObjects = new LinkedList<IRepositoryViewObject>();
        String parentPath = parentItem.getState().getPath();
        String parentPath2 = parentPath;
        if (parentPath.length() > 1) {
            if (parentPath.startsWith(DIVIDE)) {
                parentPath2 = parentPath.substring(1);
            } else {
                parentPath2 = DIVIDE + parentPath;
            }
        }
        IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
        try {

            List<IRepositoryViewObject> allObjs = factory.getAll(type);
            for (IRepositoryViewObject viewObj : allObjs) {
                Property property = viewObj.getProperty();

                ItemState state = property.getItem().getState();
                if ((!state.isDeleted())
                        && (state.getPath().equalsIgnoreCase(parentPath) || state.getPath().equalsIgnoreCase(parentPath2))) {
                    if (useRepositoryViewObject) {
                        viewObjects.add(new RepositoryViewObject(property));
                    } else {
                        viewObjects.add(viewObj);
                    }
                }
            }
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
        return viewObjects;

    }

    public static IRepositoryViewObject findViewObjectByName(ContainerItem parentItem, String objName, boolean caseSensitive) {
        List<IRepositoryViewObject> viewObjects = findViewObjectsInFolder(parentItem.getRepObjType(), parentItem, false);
        for (IRepositoryViewObject viewObj : viewObjects) {
            boolean result = caseSensitive ? viewObj.getLabel().equalsIgnoreCase(objName) : viewObj.getLabel().equals(objName);
            if (result) {
                return viewObj;
            }
        }
        return null;
    }

    public static List<IRepositoryViewObject> findViewObjectsByType(ERepositoryObjectType type, Item parentItem, int systemType) {
        return findViewObjectsByType(type, parentItem, systemType, true);
    }

    public static List<IRepositoryViewObject> findViewObjectsByType(ERepositoryObjectType type, Item parentItem, int systemType,
            boolean useRepositoryViewObject) {
        try {
            Project project = ProjectManager.getInstance().getCurrentProject();
            IProject fsProject = ResourceModelUtils.getProject(project);
            IFolder stableFolder = fsProject.getFolder(((ContainerItem) parentItem).getRepObjType().getFolder());
            List<IRepositoryViewObject> viewObjects = findViewObjects(type, parentItem, stableFolder, useRepositoryViewObject);
            // if (hasSystemFolder) {
            //                IRepositoryViewObject sysFolderViewOj = createFolderViewObject(type, "System", null, true); //$NON-NLS-1$
            // for (Iterator<IRepositoryViewObject> il = viewObjects.iterator(); il.hasNext();) {
            // IRepositoryViewObject viewObject = il.next();
            // String key = viewObject.getProperty().getLabel();
            // if (XSystemObjects.isXSystemObject(systemType, key)) {
            // sysFolderViewOj.getChildren().add(viewObject);
            // ((MDMServerObjectItem) viewObject.getProperty().getItem()).getMDMServerObject().setSystem(true);
            // il.remove();
            // }
            // }
            // viewObjects.add(0, sysFolderViewOj);
            // }
            return viewObjects;
        } catch (PersistenceException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public static Item getItemFromRepViewObj(Object element) {
        if (element instanceof IRepositoryViewObject) {
            Item item = ((IRepositoryViewObject) element).getProperty().getItem();
            return item;
        }
        return null;
    }

    public static boolean hasContainerItem(Object obj, FolderType... fTypes) {

        if (obj instanceof ContainerRepositoryObject) {
            if (fTypes == null)
                return true;
            FolderType type = ((FolderItem) ((ContainerRepositoryObject) obj).getProperty().getItem()).getType();
            for (FolderType fType : fTypes) {
                if (type == fType)
                    return true;
            }
        }
        return false;
    }

    public static RepositoryNode convertToNode(IRepositoryViewObject viewObj) {
        Item item = viewObj.getProperty().getItem();
        ENodeType type = ENodeType.REPOSITORY_ELEMENT;

        if (item instanceof ContainerItem) {
            FolderType folderType = ((ContainerItem) item).getType();
            switch (folderType.getValue()) {
            case FolderType.SYSTEM_FOLDER:
                type = ENodeType.SYSTEM_FOLDER;
                break;
            case FolderType.STABLE_SYSTEM_FOLDER:
                type = ENodeType.STABLE_SYSTEM_FOLDER;
                break;
            case FolderType.FOLDER:
                type = ENodeType.SIMPLE_FOLDER;
                break;
            default:
                break;
            }

        }
        ERepositoryObjectType repObjType = viewObj.getRepositoryObjectType();
        RepositoryNode node = new MDMRepositoryNode(viewObj, null, type);

        node.setProperties(EProperties.LABEL, repObjType);
        node.setProperties(EProperties.CONTENT_TYPE, repObjType);
        return node;
    }
}
