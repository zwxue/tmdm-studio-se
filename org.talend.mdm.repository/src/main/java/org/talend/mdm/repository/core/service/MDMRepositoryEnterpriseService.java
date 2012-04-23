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
package org.talend.mdm.repository.core.service;

import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.talend.core.model.repository.IRepositoryViewObject;

public class MDMRepositoryEnterpriseService {

    private static Log log = LogFactory.getLog(MDMRepositoryEnterpriseService.class);

    private static final String PLUGIN = "org.talend.mdm.repository"; //$NON-NLS-1$ 

    private static final String EXTENSION_POINT = "repoEnterpriseService"; //$NON-NLS-1$ 

    private static final String PROP_CLASS = "class"; //$NON-NLS-1$ 

    public static IMDMRepositoryEnterpriseServiceExt getRepositoryEnterpriseService() { 
        IExtensionRegistry registry = Platform.getExtensionRegistry();
        IExtensionPoint extensionPoint = registry.getExtensionPoint(PLUGIN, EXTENSION_POINT);
        if (extensionPoint != null && extensionPoint.isValid()) {
            IExtension[] extensions = extensionPoint.getExtensions();
            for (IExtension s : extensions) {
                IConfigurationElement[] elements = s.getConfigurationElements();
                for (IConfigurationElement element : elements) {
                    if (element.getAttribute(PROP_CLASS) != null) {
                        try {
                        	IMDMRepositoryEnterpriseServiceExt repositoryViewService = (IMDMRepositoryEnterpriseServiceExt) element
                                    .createExecutableExtension(PROP_CLASS);
                            return repositoryViewService;
                        } catch (Exception e) {
                            log.error(e.getMessage(), e);
                            return null;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void updateWorkflowContent(String newName, String fileName, InputStream inputStream, IRepositoryViewObject dragParentViewObj){
    	IMDMRepositoryEnterpriseServiceExt service = getRepositoryEnterpriseService();
        if (service != null)
             service.updateWorkflowContent(newName, fileName, inputStream, dragParentViewObj);
      
    }
    

}
