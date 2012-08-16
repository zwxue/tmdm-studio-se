// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.migrate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC HHB class global comment. Detailled comment
 */
public abstract class AbstractMigrateObjectPathRule implements IMigrateObjectPathRule {

    Map<String, String[]> folderRouteCache = new HashMap<String, String[]>();

    private Item item;

    public String[] routeFolderObject(IRepositoryViewObject folderViewObj) {
        if (folderViewObj instanceof FolderRepositoryObject) {
            FolderRepositoryObject folderObj = (FolderRepositoryObject) folderViewObj;
            String path = folderObj.getPath();
            String[] newFolders = folderRouteCache.get(path);
            if (newFolders != null)
                return newFolders;
            Item item = folderViewObj.getProperty().getItem();
            List<IRepositoryViewObject> viewObjects = RepositoryResourceUtil.findViewObjects(getRepositoryObjectType(), item,
                    true, true);
            if (viewObjects != null) {
                if (viewObjects.size() == 0) {
                    newFolders = new String[0];
                    folderRouteCache.put(path, newFolders);
                    return newFolders;
                }
                //
                Set<String> paths = new HashSet<String>();
                for (IRepositoryViewObject childViewObj : viewObjects) {
                    if (childViewObj instanceof FolderRepositoryObject) {
                        String[] folderResult = routeFolderObject(childViewObj);
                        if (folderResult != null) {
                            for (String folderName : folderResult) {
                                paths.add(folderName);
                            }
                        }
                    } else {
                        String objPath = routeObject(childViewObj);
                        if (objPath != null) {
                            paths.add(objPath);
                        }
                    }
                }
                return paths.toArray(new String[0]);

            }
        }
        return null;
    }

    public boolean isToMigrateFolder(IRepositoryViewObject folderViewObj) {
        if (folderViewObj instanceof FolderRepositoryObject) {
            String path = ((FolderRepositoryObject) folderViewObj).getPath();
            if (isNewFolder(path))
                return true;
        }
        return false;
    }

    protected boolean isNewFolder(String path) {
        if (path == null)
            throw new IllegalArgumentException();
        if (getAllNewFolderNames() != null) {
            for (String folderName : getAllNewFolderNames()) {
                if ((IPath.SEPARATOR + folderName).equalsIgnoreCase(path) || folderName.equalsIgnoreCase(path)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Item getRootFolderItem() {
            return item;
    }

    public void setRootFolderItem(Item item) {
        this.item = item;

    }

}
