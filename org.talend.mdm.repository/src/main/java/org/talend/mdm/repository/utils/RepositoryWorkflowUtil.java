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
package org.talend.mdm.repository.utils;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryWorkflowUtil {

    private static final String PROCESS_EXTENSION = ".proc"; //$NON-NLS-1$

    private static final String BAR_EXTENSION = ".bar"; //$NON-NLS-1$

    public static String getProcFileName(String workflowname, String version) {
        if (version != null)
            return workflowname + "_" + version + PROCESS_EXTENSION; //$NON-NLS-1$
        else
            return workflowname + PROCESS_EXTENSION;
    }

    public static String getBarFileName(String workflowname, String version) {
        if (version != null)
            return workflowname + "_" + version + BAR_EXTENSION; //$NON-NLS-1$
        else
            return workflowname + BAR_EXTENSION;
    }
}
