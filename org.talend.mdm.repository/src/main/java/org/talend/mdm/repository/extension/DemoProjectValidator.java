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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.packageadmin.PackageAdmin;
import org.talend.core.runtime.repository.demo.IDemoProjectValidator;

import com.amalto.workbench.utils.Util;

/**
 * created by glzhou on 2013-10-28 Detailled comment This class will validate should the CE demo project be available in
 * the import demo project dialog.
 * 
 */
public class DemoProjectValidator implements IDemoProjectValidator {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.core.runtime.repository.demo.IDemoProjectValidator#validate(org.eclipse.core.runtime.IConfigurationElement
     * )
     */
    public boolean validate(IConfigurationElement element) {
        // if we are currently using EE version, CE demo project is not valid.
        return !isEnterprise();
    }

    private boolean isEnterprise() {
        boolean isEnterprise = false;
        BundleContext context = null;
        if (Platform.getProduct() != null) {
            final Bundle definingBundle = Platform.getProduct().getDefiningBundle();
            if (definingBundle != null) {
                context = definingBundle.getBundleContext();
            }
        }
        if (context != null) {
            ServiceReference sref = context.getServiceReference(PackageAdmin.class.getName());
            PackageAdmin admin = (PackageAdmin) context.getService(sref);
            Bundle[] bundles = admin.getBundles(Util.ENTERPRISE_ID, null);
            isEnterprise = bundles != null && bundles.length > 0;
        }
        return isEnterprise;
    }
}
