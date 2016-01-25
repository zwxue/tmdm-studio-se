// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
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

import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.mdm.repository.core.service.interactive.CustomFormInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.DataContainerInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.DataModelInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.JobInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.MenuInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.ResourceInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.RoleInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.RoutingRuleInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.ServiceConfigurationInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.StoredProcedureInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.SynchronizationPlanInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.TransformerInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.VersionInteractiveHandler;
import org.talend.mdm.repository.core.service.interactive.ViewInteractiveHandler;

import com.amalto.workbench.models.TreeObject;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class InteractiveService {

    private static List<IInteractiveHandler> handlers = new LinkedList<IInteractiveHandler>();

    public static void registerHandler(IInteractiveHandler handler) {
        handlers.add(handler);
    }

    public static IInteractiveHandler findHandler(ERepositoryObjectType type) {
        if (type != null) {
            if (handlers.isEmpty() || handlers.size() == 2) {
                initHandler();
            }
            for (IInteractiveHandler handler : handlers) {
                if (handler.getRepositoryObjectType().equals(type)) {
                    return handler;
                }
            }
        }
        return null;
    }

    public static IInteractiveHandler findHandlerForTreeObject(TreeObject treeObject) {

        switch (treeObject.getType()) {
        case TreeObject.DATA_MODEL:
            return new DataModelInteractiveHandler();
        case TreeObject.DATA_CLUSTER:
            return new DataContainerInteractiveHandler();
        case TreeObject.MENU:
            return new MenuInteractiveHandler();
        case TreeObject.RESOURCES:
            return new ResourceInteractiveHandler();
        case TreeObject.ROUTING_RULE:
            return new RoutingRuleInteractiveHandler();
        case TreeObject.ROLE:
            return new RoleInteractiveHandler();
        case TreeObject.SERVICE_CONFIGURATION:
            return new ServiceConfigurationInteractiveHandler();
        case TreeObject.STORED_PROCEDURE:
            return new StoredProcedureInteractiveHandler();
        case TreeObject.TRANSFORMER:
            return new TransformerInteractiveHandler();
        case TreeObject.UNIVERSE:
            return new VersionInteractiveHandler();
        case TreeObject.VIEW:
            return new ViewInteractiveHandler();
        case TreeObject.SYNCHRONIZATIONPLAN:
            return new SynchronizationPlanInteractiveHandler();
        default:
            return null;
        }

    }

    public static void initHandler() {
        registerHandler(new CustomFormInteractiveHandler());
        registerHandler(new DataContainerInteractiveHandler());
        registerHandler(new DataModelInteractiveHandler());
        registerHandler(new MenuInteractiveHandler());
        registerHandler(new JobInteractiveHandler());
        registerHandler(new ResourceInteractiveHandler());
        registerHandler(new RoutingRuleInteractiveHandler());
        registerHandler(new RoleInteractiveHandler());
        registerHandler(new ServiceConfigurationInteractiveHandler());
        registerHandler(new StoredProcedureInteractiveHandler());
        registerHandler(new TransformerInteractiveHandler());
        registerHandler(new VersionInteractiveHandler());
        registerHandler(new ViewInteractiveHandler());
        registerHandler(new SynchronizationPlanInteractiveHandler());
    }
}
