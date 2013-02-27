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
package org.talend.mdm.repository.core.validate.datamodel.validator.rule;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.validate.plugin.ValidatePlugin;

/**
 * created by HHB on 2013-1-14 Detailled comment
 * 
 */
public class ValidateRuleRegistry {

    private static Logger log = Logger.getLogger(RepositoryNodeConfigurationManager.class);

    private ValidateRuleRegistry() {
    }

    private static ValidateRuleRegistry instance = new ValidateRuleRegistry();

    /**
     * Getter for instance.
     * 
     * @return the instance
     */
    public static ValidateRuleRegistry getInstance() {
        return instance;
    }

    private static final String EXTENSION_POINT_TEMPLATE = "DataModelValidationRule"; //$NON-NLS-1$

    private static final String PROP_CLASS = "class"; //$NON-NLS-1$

    private static final String PROP_NAME = "name"; //$NON-NLS-1$

    private boolean inited = false;

    private Map<String, List<IComponentValidationRule>> ruleMap = new HashMap<String, List<IComponentValidationRule>>();

    public List<IComponentValidationRule> getRules(String groupName) {
        if (!inited) {
            initRules();
        }

        return ruleMap.get(groupName);
    }

    private void initRules() {
        if (!inited) {
            IExtensionRegistry registry = Platform.getExtensionRegistry();

            //
            IExtensionPoint extensionPoint = registry.getExtensionPoint(ValidatePlugin.PLUGIN_ID, EXTENSION_POINT_TEMPLATE);
            if (extensionPoint != null && extensionPoint.isValid()) {
                IExtension[] extensions = extensionPoint.getExtensions();
                for (IExtension s : extensions) {
                    IConfigurationElement[] elements = s.getConfigurationElements();
                    for (IConfigurationElement element : elements) {
                        String group = element.getAttribute(PROP_NAME);
                        if (group != null) {
                            List<IComponentValidationRule> visitors = ruleMap.get(group);
                            if (visitors == null) {
                                visitors = new LinkedList<IComponentValidationRule>();
                                ruleMap.put(group, visitors);
                            }
                            for (IConfigurationElement visitorElement : element.getChildren()) {
                                if (visitorElement.getAttribute(PROP_CLASS) != null) {
                                    try {
                                        IComponentValidationRule visitor = (IComponentValidationRule) visitorElement
                                                .createExecutableExtension(PROP_CLASS);
                                        visitors.add(visitor);

                                    } catch (CoreException e) {
                                        log.error(e.getMessage(), e);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            inited = true;
        }
    }

}
