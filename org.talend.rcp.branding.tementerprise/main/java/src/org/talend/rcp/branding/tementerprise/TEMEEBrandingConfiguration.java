// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.rcp.branding.tementerprise;

import org.talend.core.ui.branding.DefaultBrandingConfiguration;
import org.talend.rcp.branding.tementerprise.i18n.Messages;

/**
 * hcheng class global comment. Detailled comment
 */
public class TEMEEBrandingConfiguration extends DefaultBrandingConfiguration {

    @Override
    public String getTISProductNameForWelcome() {
        return Messages.getString("productshortname");
    }
}
