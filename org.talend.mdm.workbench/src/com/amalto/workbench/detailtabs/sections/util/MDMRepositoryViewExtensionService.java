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
package com.amalto.workbench.detailtabs.sections.util;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.amalto.workbench.detailtabs.sections.IMDMRepositoryViewServiceExt;

public class MDMRepositoryViewExtensionService {

    private static final String PLUGIN = "org.talend.mdm.workbench"; //$NON-NLS-1$ 

    private static final String EXTENSION_POINT = "repositoryViewService"; //$NON-NLS-1$ 

    private static final String PROP_CLASS = "class"; //$NON-NLS-1$ 

    public static List<String> findAllRoleNames() {
        IExtensionRegistry registry = Platform.getExtensionRegistry();
        IExtensionPoint extensionPoint = registry.getExtensionPoint(PLUGIN, EXTENSION_POINT);
        if (extensionPoint != null && extensionPoint.isValid()) {
            IExtension[] extensions = extensionPoint.getExtensions();
            for (IExtension s : extensions) {
                IConfigurationElement[] elements = s.getConfigurationElements();
                for (IConfigurationElement element : elements) {
                    if (element.getAttribute(PROP_CLASS) != null) {
                        try {
                            IMDMRepositoryViewServiceExt repositoryViewService = (IMDMRepositoryViewServiceExt) element
                                    .createExecutableExtension(PROP_CLASS);
                            return repositoryViewService.findAllRoleNames();
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
}

            }
        }
        return null;
    }

}
