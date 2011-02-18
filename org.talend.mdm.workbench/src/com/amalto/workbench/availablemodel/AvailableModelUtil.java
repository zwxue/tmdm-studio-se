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
package com.amalto.workbench.availablemodel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class AvailableModelUtil {

    public static List<IAvailableModel> getAvailableModels() {
        try {
            IExtensionRegistry registry = Platform.getExtensionRegistry();
            IConfigurationElement[] configurationElements = registry
                    .getConfigurationElementsFor("org.talend.mdm.workbench.AvailableModel"); //$NON-NLS-1$
            List<IAvailableModel> models = new ArrayList<IAvailableModel>();
            for (int i = 0; i < configurationElements.length; i++) {
                IConfigurationElement element = configurationElements[i];

                IAvailableModel modelcalss = (IAvailableModel) element.createExecutableExtension("class");//$NON-NLS-1$

                models.add(modelcalss);
            }

            return models;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<IAvailableModel>();
    }
}
