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
package org.talend.mdm.repository.utils;

import org.eclipse.ui.PlatformUI;

/**
 * created by HHB on 2013-3-6 Detailled comment
 * 
 */
public class UIUtil {

    private static Boolean workInUI = null;

    public static boolean isWorkInUI() {
        if (workInUI == null) {
            try {
                workInUI = PlatformUI.getWorkbench() != null;
            } catch (Exception e) {
                workInUI = false;
            }
        }
        return workInUI;
    }
}
