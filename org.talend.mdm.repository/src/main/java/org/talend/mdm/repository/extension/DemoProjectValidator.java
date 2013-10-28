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
package org.talend.mdm.repository.extension;

import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IConfigurationElement;
import org.talend.core.PluginChecker;
import org.talend.core.runtime.repository.demo.IDemoProjectValidator;

/**
 * created by glzhou on 2013-10-28 Detailled comment This class will validate if the CE demo project should be available
 * in the import demo project dialog.
 * 
 */
public class DemoProjectValidator implements IDemoProjectValidator {

    private static Logger log = Logger.getLogger(DemoProjectValidator.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.core.runtime.repository.demo.IDemoProjectValidator#validate(org.eclipse.core.runtime.IConfigurationElement
     * )
     */
    public boolean validate(IConfigurationElement element) {
        String id = element.getAttribute("id"); //$NON-NLS-1$        
        if (StringUtils.isEmpty(id)) {
            log.error("Missing id attributes"); //$NON-NLS-1$
            return false;
        }
        if (id.equals("org.talend.demo.project.mdmce") && !PluginChecker.isPluginLoaded("org.talend.rcp.branding.tombundle")) { //CE //$NON-NLS-1$
            return false;
        }
        return true;
    }

}
