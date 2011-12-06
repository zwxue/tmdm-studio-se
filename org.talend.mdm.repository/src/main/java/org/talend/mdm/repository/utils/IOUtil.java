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

import java.io.File;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class IOUtil {

    public static File getTempFolder() {
        String usrDir = System.getProperty("java.io.tmpdir");//$NON-NLS-1$

        File tmpFolder = new File(usrDir + File.separator + System.currentTimeMillis());
        if (!tmpFolder.exists()) {
            tmpFolder.mkdirs();
        }

        return tmpFolder;

    }

    public static void cleanFolder(File folder) {
        if (folder != null && folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    cleanFolder(file);
                }
                file.delete();
            }
            folder.delete();
        }

    }
}
