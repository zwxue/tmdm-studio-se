// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2012 Talend �C www.talend.com
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
package org.talend.mdm.repository.core.impl.recyclebin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.repository.RepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.impl.AbstractContentProvider;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class RecycleBinContentProvider extends AbstractContentProvider {

    private static final String PREFIX = "MDM"; //$NON-NLS-1$

    private Map<ERepositoryObjectType, Map<String, FolderRepositoryObject>> containerMap = new HashMap<ERepositoryObjectType, Map<String, FolderRepositoryObject>>();

    private static final Pattern pattern = Pattern.compile("(MDM/\\w*+)((/(\\w*))+)"); //$NON-NLS-1$

    private static Logger log = Logger.getLogger(RecycleBinContentProvider.class);

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    private void addToMap(FolderRepositoryObject viewObj, String path) {
        ERepositoryObjectType repObjType = viewObj.getRepositoryObjectType();
        Map<String, FolderRepositoryObject> map = containerMap.get(repObjType);
        if (map == null) {
            map = new HashMap<String, FolderRepositoryObject>();
            containerMap.put(repObjType, map);
        }
        map.put(path, viewObj);
    }

    private void buildAllDeletedFolders(FolderRepositoryObject rootViewObj) {
        List<String> deletedFolderPaths = ProjectManager.getInstance().getCurrentProject().getEmfProject().getDeletedFolders();
        deletedFolderPaths = sortFolderPath(deletedFolderPaths);
        // System.out.println("Deleted Folders:");
        // for (Object obj : deletedFolderPaths) {
        // System.out.println(obj);
        // }
        containerMap.clear();
        rootViewObj.getChildren().clear();

        for (String path : deletedFolderPaths) {
            Matcher matcher = pattern.matcher(path);
            if (matcher.find()) {
                String parentFolder = matcher.group(1);
                String itemPath = matcher.group(2);
                String folderName = matcher.group(4);
                // for (int i = 0; i <= matcher.groupCount(); i++) {
                // System.out.print(i + "=" + matcher.group(i) + "\t");
                // }
                // System.out.println();
                ERepositoryObjectType type = RepositoryResourceUtil.getTypeByPath(parentFolder);
                FolderRepositoryObject parentContainer = getParenContainer(rootViewObj, type, itemPath, true);
                if (type != null && itemPath != null && folderName != null) {
                    FolderRepositoryObject viewObj = RepositoryResourceUtil.createDeletedFolderViewObject(type, itemPath,
                            folderName, parentContainer);
                    addToMap(viewObj, itemPath);
                }
            }
        }
    }

    private void buildAllDeletedObjects(FolderRepositoryObject rootViewObj) {
        for (ERepositoryObjectType type : IServerObjectRepositoryType.ALL_TYPES) {
            try {
                List<IRepositoryViewObject> viewObjs = factory.getAll(type, true);
                for (IRepositoryViewObject viewObj : viewObjs) {
                    Property property = viewObj.getProperty();
                    ItemState state = property.getItem().getState();
                    if (state.isDeleted()) {
                        String path = state.getPath();
                        FolderRepositoryObject container = getParenContainer(rootViewObj, type, path, false);
                        // get from cache
                        IRepositoryViewObject cacheViewObj = ContainerCacheService.get(property);
                        if (cacheViewObj == null) {
                            cacheViewObj = new RepositoryViewObject(property);
                            ContainerCacheService.put(property, cacheViewObj);
                        }
                        container.getChildren().add(cacheViewObj);
                    }
                }
            } catch (PersistenceException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public Object[] getChildren(Object element) {
        IRepositoryViewObject viewObj = (IRepositoryViewObject) element;
        ERepositoryObjectType type = viewObj.getRepositoryObjectType();
        if (viewObj instanceof FolderRepositoryObject) {
            FolderRepositoryObject containerObj = (FolderRepositoryObject) viewObj;
            if (type == IServerObjectRepositoryType.TYPE_RECYCLE_BIN) {
                buildAllDeletedFolders(containerObj);
                buildAllDeletedObjects(containerObj);
            }
            return containerObj.getChildren().toArray();

        }
        return new Object[0];
    }

    private FolderRepositoryObject getParenContainer(FolderRepositoryObject rootItem, ERepositoryObjectType type,
            String currentPath, boolean isFolder) {
        String parentPath = isFolder ? getParentPath(currentPath) : currentPath;
        if (parentPath != null) {
            Map<String, FolderRepositoryObject> map = containerMap.get(type);
            if (map != null) {
                FolderRepositoryObject item = map.get(parentPath);
                if (item != null) {
                    return item;
                }
            }
        }
        return rootItem;
    }

    private String getParentPath(String path) {
        int index = path.lastIndexOf(IPath.SEPARATOR);
        if (index > 0) {
            return path.substring(0, index);
        }
        return null;
    }

    protected List<IRepositoryViewObject> getViewObjFromSystemFolder(Item parentItem) {
        return null;
    }

    public Class<?> getWSObjectClass() {
        return null;
    }

    private List<String> sortFolderPath(List folderPaths) {
        Iterator il = folderPaths.iterator();
        List<String> result = new LinkedList<String>();
        while (il.hasNext()) {
            String path = (String) il.next();
            if (path.startsWith(PREFIX)) {
                result.add(path);
            }
        }
        String[] objs = result.toArray(new String[0]);
        Arrays.sort(objs);
        result.clear();
        for (String obj : objs) {
            result.add(obj);
        }
        return result;
    }

}
