// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.marker;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;

/**
 * created by HHB on 2013-2-28 Detailled comment
 * 
 */
public class ValidateMarkerUtil implements IValidationMarker {

    private static Map<ERepositoryObjectType, String[]> viewTypeMarkerMap = new HashMap<ERepositoryObjectType, String[]>();
    static {
        initMarkerMap();
    }

    private static void initMarkerMap() {
        // DATA Model
        viewTypeMarkerMap.put(IServerObjectRepositoryType.TYPE_DATAMODEL, new String[] { MARKER_DATA_MODEL, MARKER_XSD_ERR });
    }

    private static String[] allMarkers = null;

    public static String[] getMarkerTypeByViewType(ERepositoryObjectType type) {
        return viewTypeMarkerMap.get(type);
    }

    public static String[] getAllMarkers() {
        if (allMarkers == null) {
            List<String> markers = new LinkedList<String>();
            for (String[] values : viewTypeMarkerMap.values()) {
                for (String marker : values) {
                    markers.add(marker);
                }
            }
            allMarkers = markers.toArray(new String[0]);
        }
        return allMarkers;
    }
}
