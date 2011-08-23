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
import org.talend.mdm.repository.core.service.interactive.MenuInteractiveHandler;

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
        registerHandler(new MenuInteractiveHandler());
    }
}
