// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.wizards.imports;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;
import org.eclipse.ui.internal.wizards.datatransfer.TarFile;
import org.talend.commons.utils.io.FilesUtils;
import org.talend.mdm.commmon.util.workbench.ZipToFile;
import org.talend.mdm.repository.utils.IOUtil;


/**
 * created by liusognbo on Mar 10, 2015
 */
public class MDMImportItemUtil {

    private static Logger log = Logger.getLogger(MDMImportItemUtil.class);

    private static Map<String, String> replaceStringMap = new HashMap<String, String>();

    private static String[] migrateFileExtensions = new String[] { "properties", "item" }; //$NON-NLS-1$ //$NON-NLS-2$

    static {
        replaceStringMap.put("mdmserverobject:Ws", "mdmserverobject:WS");//$NON-NLS-1$ //$NON-NLS-2$
        replaceStringMap.put("mdmproperties:Ws", "mdmproperties:WS");//$NON-NLS-1$ //$NON-NLS-2$
    }

    public static File buildUpdatedFile(Object fileorDirectory) {
        File tempFile = null;
        try {
            if (fileorDirectory instanceof File) {
                String targetFolder = IOUtil.getTempFolder().getAbsolutePath();
                FilesUtils.copyDirectory((File) fileorDirectory, new File(targetFolder));

                tempFile = new File(new File(targetFolder), ((File) fileorDirectory).getName());
                updateFile(tempFile);
            } else if (fileorDirectory instanceof ZipFile) {
                tempFile = updateZipFile((ZipFile) fileorDirectory);
            } else if (fileorDirectory instanceof TarFile) {
                tempFile = updateTarFile((TarFile) fileorDirectory);
            }

            return tempFile;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    private static File updateZipFile(ZipFile zfile) {
        String targetFolder = IOUtil.getTempFolder().getAbsolutePath();
        try {
            ZipToFile.unZipFile(zfile.getName(), targetFolder);

            File file = new File(targetFolder);
            updateFile(file);
            return file.listFiles()[0];
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    @SuppressWarnings("restriction")
    private static File updateTarFile(TarFile tarFile) {

        String targetFolder = IOUtil.getTempFolder().getAbsolutePath();
        try {
            IOUtil.extractTarFile(tarFile.getName(), targetFolder);
            File file = new File(targetFolder);
            updateFile(file);

            return file.listFiles()[0];
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    public static void updateFile(final File dir) {
        if (dir.isDirectory() && needUpdate(dir)) {
            FilesUtils.migrateFolder(dir, migrateFileExtensions, replaceStringMap, log);
        }
    }

    private static boolean needUpdate(final File dir) {
        FilenameFilter filter = new FilenameFilter() {

            public boolean accept(File fdir, String name) {
                for (String suffix : migrateFileExtensions) {
                    if (name.endsWith(suffix)) {
                        return true;
                    }
                }

                return false;
            }
        };

        List<File> allFiles = FilesUtils.getAllFilesFromFolder(dir, filter);
        if(allFiles.size() > 0) {
            File file = allFiles.get(0);
            List<String> contentLines = null;
            try {
                contentLines = FilesUtils.getContentLines(file.getAbsolutePath());
            } catch (IOException e) {//
            }
            
            if (contentLines != null) {
                for (String content : contentLines) {
                    if (content.contains("mdmserverobject:WS") || content.contains("mdmproperties:WS")) { //$NON-NLS-1$ //$NON-NLS-2$
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
