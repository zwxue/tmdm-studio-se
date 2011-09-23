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
            if (handlers.isEmpty())
                initHandler();
            for (IInteractiveHandler handler : handlers) {
                if (handler.getRepositoryObjectType().equals(type))
                    return handler;
            }
        }
        return null;
    }

    private static void initHandler() {
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
