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

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.log4j.Logger;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.WSDataModelE;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.models.TreeObject;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryQueryService {

    private static Logger log = Logger.getLogger(RepositoryQueryService.class);

    private static BidiMap typeMap = null;

    public static List<String> findAllDataModelNames() {
        return findAllServerObjectNames(IServerObjectRepositoryType.TYPE_DATAMODEL);
    }

    public static WSDataModelE findDataModelByName(String name) {
        return (WSDataModelE) findServerObjectByName(IServerObjectRepositoryType.TYPE_DATAMODEL, name);
    }

    /**
     * this method is compatible with Util.getDataModel, but for Repository view
     * 
     * @param obj
     * @param datamodel
     * @param conceptName
     * @return
     */
    public static List<String> getDataModel(String datamodel, String conceptName) {
        List<String> systemDataModelValues = findAllDataModelNames();

        // filter the datamodel according to conceptName
        List<String> avaiList = new LinkedList<String>();
        avaiList.addAll(systemDataModelValues);
        if (datamodel != null) {
            avaiList.clear();
            avaiList.add(datamodel);
        } else if (conceptName != null && !conceptName.contains("*")) {//$NON-NLS-1$
            for (String data : systemDataModelValues) {
                try {
                    WSDataModelE dm = findDataModelByName(data);
                    if (dm != null) {
                        String schema = dm.getXsdSchema();
                        Pattern p = Pattern.compile("<xsd:element(.*?)name=\"" + conceptName + "\"");//$NON-NLS-1$//$NON-NLS-2$
                        if (!p.matcher(schema).find()) {
                            avaiList.remove(data);
                        }
                    }
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        if (avaiList.size() == 0)
            avaiList.addAll(systemDataModelValues);
        return avaiList;
    }

    private static List<String> findAllServerObjectNames(ERepositoryObjectType type) {
        List<IRepositoryViewObject> viewObjects = RepositoryResourceUtil.findAllViewObjects(type);
        List<String> names = new LinkedList<String>();
        if (viewObjects != null) {
            for (IRepositoryViewObject viewObj : viewObjects) {
                Item item = viewObj.getProperty().getItem();
                if (item instanceof MDMServerObjectItem) {
                    names.add(((MDMServerObjectItem) item).getMDMServerObject().getName());
                }
                // names[i]=viewObj.getLabel();
            }
        }
        return names;
    }

    private static MDMServerObject findServerObjectByName(ERepositoryObjectType type, String name) {
        List<IRepositoryViewObject> viewObjects = RepositoryResourceUtil.findAllViewObjects(type);
        if (viewObjects != null) {
            for (IRepositoryViewObject viewObj : viewObjects) {
                Item item = viewObj.getProperty().getItem();
                if (item instanceof MDMServerObjectItem) {
                    MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
                    if (serverObject.getName().equals(name)) {
                        return serverObject;
                    }
                }
            }
        }
        return null;
    }

    private static void initTypeMap() {
        if (typeMap == null) {
            typeMap = new DualHashBidiMap();
            typeMap.put(TreeObject.DATA_MODEL, IServerObjectRepositoryType.TYPE_DATAMODEL);
        }
    }

    public static ERepositoryObjectType getRepositoryObjectType(int wsType) {
        initTypeMap();
        return (ERepositoryObjectType) typeMap.get(wsType);
    }

    public static int getWSType(ERepositoryObjectType type) {
        initTypeMap();
        return (Integer) typeMap.getKey(type);
    }
}
