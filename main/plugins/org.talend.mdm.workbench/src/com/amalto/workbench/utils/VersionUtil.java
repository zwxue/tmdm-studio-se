// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.utils;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WsDataClusterPK;
import com.amalto.workbench.webservices.WsDataModelPK;
import com.amalto.workbench.webservices.WsMenuPK;
import com.amalto.workbench.webservices.WsRolePK;
import com.amalto.workbench.webservices.WsRoutingRulePK;
import com.amalto.workbench.webservices.WsStoredProcedurePK;
import com.amalto.workbench.webservices.WsTransformerV2PK;
import com.amalto.workbench.webservices.WsViewPK;

/**
 * 
 * @author hshu
 * 
 */
public class VersionUtil {

    public static String determineTypeByTreeObjectType(int xobjectType) {
        String type = null;
        switch (xobjectType) {
        case TreeObject._SERVER_:
            type = "Root";//$NON-NLS-1$
            break;
        /*
         * case TreeObject.INBOUND_ADAPTOR : type = "Inbound Adaptor"; break; case TreeObject.INBOUND_PLUGIN: type =
         * "Inbound Plugin"; break; case TreeObject.DESTINATION : type = "Destination"; break; case
         * TreeObject.OUTBOUND_ADAPTOR: type = "Outbound Adaptor"; break; case TreeObject.OUTBOUND_PLUGIN: type =
         * "Outbound Plugin"; break; case TreeObject.DOCUMENT: type = "Document"; break; case TreeObject.ITEM: type =
         * "Item";
         */
        case TreeObject.VIEW:
            type = "View";//$NON-NLS-1$
            break;
        case TreeObject.DATA_MODEL:
            type = "Data Model";//$NON-NLS-1$
            break;
        /*
         * case TreeObject.SOURCE: type = "Source"; break;
         */
        case TreeObject.DATA_CLUSTER:
            type = "Data Cluster";//$NON-NLS-1$
            break;
        case TreeObject.ROLE:
            type = "Role";//$NON-NLS-1$
            break;
        case TreeObject.STORED_PROCEDURE:
            type = "Stored Procedure";//$NON-NLS-1$
            break;
        case TreeObject.TRANSFORMER:
            type = "Transformer V2";//$NON-NLS-1$
            break;
        case TreeObject.MENU:
            type = "Menu";//$NON-NLS-1$
            break;
        case TreeObject.ROUTING_RULE:
            type = "Routing Rule";//$NON-NLS-1$
            break;
        case TreeObject.UNIVERSE:
            type = "Universe";//$NON-NLS-1$
            break;
        case TreeObject.SYNCHRONIZATIONPLAN:
            type = "Synchronization Plan";//$NON-NLS-1$
            break;
        }
        return type;
    }

    public static String determineInstanceByTreeObjectType(int xobjectType, TreeObject xobject) {
        String instance = null;
        switch (xobjectType) {
        /*
         * case TreeObject.INBOUND_ADAPTOR : instance = (xobject.isXObject() ?
         * ((WSInboundAdaptorPK)xobject.getWsKey()).getPk() : null); break; case TreeObject.INBOUND_PLUGIN: instance =
         * (xobject.isXObject() ? ((WSInboundPluginPK)xobject.getWsKey()).getPk() : null); break; case
         * TreeObject.DESTINATION : instance = (xobject.isXObject() ? ((WSDestinationPK)xobject.getWsKey()).getPk() :
         * null); break; case TreeObject.OUTBOUND_ADAPTOR: instance = (xobject.isXObject() ?
         * ((WSOutboundAdaptorPK)xobject.getWsKey()).getPk() : null); break; case TreeObject.OUTBOUND_PLUGIN: instance =
         * (xobject.isXObject() ? ((WSOutboundPluginPK)xobject.getWsKey()).getPk() : null); break; case
         * TreeObject.DOCUMENT: instance = (xobject.isXObject() ? ((WSDocumentPK)xobject.getWsKey()).getPk() : null);
         * break; case TreeObject.ITEM: instance = (xobject.isXObject() ? ((WSItemPK)xobject.getWsKey()).getPk() :
         * null);
         */
        case TreeObject.VIEW:
            instance = (xobject.isXObject() ? ((WsViewPK) xobject.getWsKey()).getPk() : null);
            break;
        case TreeObject.DATA_MODEL:
            instance = (xobject.isXObject() ? ((WsDataModelPK) xobject.getWsKey()).getPk() : null);
            break;
        /*
         * case TreeObject.SOURCE: instance = (xobject.isXObject() ? ((WSSourcePK)xobject.getWsKey()).getPk() : null);
         * break;
         */
        case TreeObject.DATA_CLUSTER:
            instance = (xobject.isXObject() ? ((WsDataClusterPK) xobject.getWsKey()).getPk() : null);
            break;
        case TreeObject.SUBSCRIPTION_ENGINE:
            instance = null;
            break;
        case TreeObject.ROLE:
            instance = (xobject.isXObject() ? ((WsRolePK) xobject.getWsKey()).getPk() : null);
            break;
        case TreeObject.STORED_PROCEDURE:
            instance = (xobject.isXObject() ? ((WsStoredProcedurePK) xobject.getWsKey()).getPk() : null);
            break;
        case TreeObject.TRANSFORMER:
            instance = (xobject.isXObject() ? ((WsTransformerV2PK) xobject.getWsKey()).getPk() : null);
            break;
        case TreeObject.MENU:
            instance = (xobject.isXObject() ? ((WsMenuPK) xobject.getWsKey()).getPk() : null);
            break;
        case TreeObject.ROUTING_RULE:
            instance = (xobject.isXObject() ? ((WsRoutingRulePK) xobject.getWsKey()).getPk() : null);
            break;
        case TreeObject.UNIVERSE:
            // *** TMDM-8080, temp omitted start ***//
            // instance = (xobject.isXObject() ? ((WSUniversePK) xobject.getWsKey()).getPk() : null);
            // *** TMDM-8080, temp omitted end ***//
            break;
        case TreeObject.SYNCHRONIZATIONPLAN:
            // *** TMDM-8080, temp omitted start ***//
            // instance = (xobject.isXObject() ? ((WSSynchronizationPlanPK) xobject.getWsKey()).getPk() : null);
            // *** TMDM-8080, temp omitted end ***//
            break;
        }
        return instance;
    }
}
