// ============================================================================
//
// Copyright (C) 2006-2009 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.rcp.branding.tdqenterprise;

import org.eclipse.jface.preference.IPreferenceNode;
import org.talend.core.ui.branding.IActionBarHelper;
import org.talend.datacleansing.core.ui.intro.ActionBarBuildHelper;

/**
 *hcheng class global comment. Detailled comment
 */
public class TDQEEActionBarHelper extends ActionBarBuildHelper implements IActionBarHelper {

    @Override
    public void postWindowOpen() {
        super.postWindowOpen();

        IPreferenceNode toHide = null;
        IPreferenceNode parentNode = null;
        for (IPreferenceNode node : window.getWorkbench().getPreferenceManager().getRootSubNodes()) {
            if (node.getId().equals("org.talend.dataprofiler.core.ui.pref.DataProfilerPreferencePage")) {
                for (IPreferenceNode subNode : node.getSubNodes()) {
                    if (subNode.getId().equals("org.talend.dataprofiler.core.ui.pref.I18nPreferencePage")) {
                        toHide = subNode;
                        parentNode = node;
                        break;
                    }
                }
                if (toHide != null) {
                    break;
                }
            }
        }

        if (toHide != null && parentNode != null) {
            // window.getWorkbench().getPreferenceManager().remove(toHide);
            parentNode.remove(toHide);
        }
    }

}
