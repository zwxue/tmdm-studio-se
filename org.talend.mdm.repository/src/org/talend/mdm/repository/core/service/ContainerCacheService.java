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
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ContainerCacheService {

    private static Map<ERepositoryObjectType, Map<String, IRepositoryViewObject>> containerMap = new HashMap<ERepositoryObjectType, Map<String, IRepositoryViewObject>>();

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
            map.put(item.getState().getPath(), viewObj);
        }
    }

    public static void remove(ERepositoryObjectType repObjType, String path) {
        Map<String, IRepositoryViewObject> map = containerMap.get(repObjType);
        if (map != null) {
            for (Iterator<String> il = map.keySet().iterator(); il.hasNext();) {
                if (il.next().startsWith(path)) {
                    il.remove();
                }
            }
        }
    }

    public static IRepositoryViewObject get(ERepositoryObjectType repObjType, String path) {
        Map<String, IRepositoryViewObject> map = containerMap.get(repObjType);
        if (map != null) {
            return map.get(path);
        }
        return null;
    }

    public static IRepositoryViewObject getParent(IRepositoryViewObject obj) {
        ERepositoryObjectType type = obj.getRepositoryObjectType();

        Item item = obj.getProperty().getItem();
        String path = item.getState().getPath();
        if (item instanceof ContainerItem) {
            if (path.length() > 1) {
                int pos = path.lastIndexOf("/"); //$NON-NLS-1$
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
