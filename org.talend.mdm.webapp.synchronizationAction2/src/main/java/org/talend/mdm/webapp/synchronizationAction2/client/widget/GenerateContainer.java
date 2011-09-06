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
package org.talend.mdm.webapp.synchronizationAction2.client.widget;

import com.extjs.gxt.ui.client.widget.ContentPanel;

public class GenerateContainer {

    private static ContentPanel instance;

    public static void generateContentPanel() {
        instance = new SynchronizationActionPanel() {
        };
        instance.setId("synchronizationAction2"); //$NON-NLS-1$
    }

    public static ContentPanel getContentPanel() {
        return instance;
    }
}
