// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.models.ContainerRepositoryObject;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ContainerCacheService {

    /**
     * 
     */
    private static final String DIVIDE = "/"; //$NON-NLS-1$

    private static Map<ERepositoryObjectType, Map<String, IRepositoryViewObject>> containerMap = new HashMap<ERepositoryObjectType, Map<String, IRepositoryViewObject>>();

    private static Map<Property, IRepositoryViewObject> viewObjMap = new HashMap<Property, IRepositoryViewObject>();

    public static void put(IRepositoryViewObject viewObj) {
        Item item = viewObj.getProperty().getItem();
        if (item instanceof ContainerItem) {
            ERepositoryObjectType repObjType = ((ContainerItem) item).getRepObjType();
            Map<String, IRepositoryViewObject> map = containerMap.get(repObjType);
            if (map == null) {
                map = new HashMap<String, IRepositoryViewObject>();
                containerMap.put(repObjType, map);
            }
            //
            String path = correctPath(item.getState().getPath());
            map.put(path, viewObj);
        }
    }

    public static void put(Property prop, IRepositoryViewObject viewObj) {
        if (prop == null || viewObj == null)
            throw new IllegalArgumentException();
        viewObjMap.put(prop, viewObj);
    }

    public static void remove(Property prop) {
        if (prop != null)
            viewObjMap.remove(prop);
    }

    public static void remove(ERepositoryObjectType repObjType, String path) {
        Map<String, IRepositoryViewObject> map = containerMap.get(repObjType);
        if (map != null) {
            for (Iterator<String> il = map.keySet().iterator(); il.hasNext();) {
                String next = il.next();
                if (next.startsWith(path)) {
                    IRepositoryViewObject viewObj = map.get(next);
                    if (viewObj != null && viewObj instanceof ContainerRepositoryObject) {
                        if (viewObj.getChildren() != null)
                            for (IRepositoryViewObject child : viewObj.getChildren()) {
                                remove(child.getProperty());
                            }
                    }
                    il.remove();
                }
            }
        }
    }

    private static String correctPath(String path) {
        if (path != null && path.length() > 0) {
            if (!path.startsWith(DIVIDE)) {
                return DIVIDE + path;
            }
        }
        return path;
    }

    public static IRepositoryViewObject get(ERepositoryObjectType repObjType, String path) {
        Map<String, IRepositoryViewObject> map = containerMap.get(repObjType);
        if (map != null) {
            path = correctPath(path);
            return map.get(path);
        }
        return null;
    }

    public static IRepositoryViewObject get(Property prop) {
        if (prop == null)
            throw new IllegalArgumentException();
        return viewObjMap.get(prop);
    }

    public static IRepositoryViewObject getParent(IRepositoryViewObject obj) {
        ERepositoryObjectType type = obj.getRepositoryObjectType();

        Item item = obj.getProperty().getItem();
        String path = item.getState().getPath();
        if (item instanceof ContainerItem) {
            if (path.length() > 1) {
                int pos = path.lastIndexOf(DIVIDE);
                if (pos >= 0) {
                    path = path.substring(0, pos);
                }
            } else {
                return null;
            }
        }
        return get(type, path);

    }
}
