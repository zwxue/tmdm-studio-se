// ============================================================================
//
// Copyright (C) 2006-2017 Talend Inc. - www.talend.com
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.internal.wizards.datatransfer.TarEntry;
import org.eclipse.ui.internal.wizards.datatransfer.TarException;
import org.eclipse.ui.internal.wizards.datatransfer.TarFile;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class IOUtil {

    /**
     * 
     */
    private static final String TEMP_Folder_NAME = "temp"; //$NON-NLS-1$

    public static File getTempFolder() {
        String usrDir = System.getProperty("java.io.tmpdir");//$NON-NLS-1$

        File tmpFolder = new File(usrDir + File.separator + System.currentTimeMillis());
        if (!tmpFolder.exists()) {
            tmpFolder.mkdirs();
        }

        return tmpFolder;

    }

    public static File getWorkspaceTempFolder() {
        String usrDir = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
        File tempFolder = new File(usrDir + File.separator + TEMP_Folder_NAME + File.separator + System.currentTimeMillis());
        if (!tempFolder.exists()) {
            tempFolder.mkdirs();
        }
        return tempFolder;

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

    public static boolean isExist(String path) {
        assert (path != null);
        return new File(path).exists();
    }

    /**
     * Determine whether the file with the given filename is in .tar.gz or .tar format.
     * 
     * @param fileName file to test
     * @return true if the file is in tar format
     */
    public static boolean isTarFile(String fileName) {
        if (fileName.length() == 0) {
            return false;
        }

        TarFile tarFile = null;
        try {
            tarFile = new TarFile(fileName);
        } catch (TarException tarException) {
            return false;
        } catch (IOException ioException) {
            return false;
        } finally {
            if (tarFile != null) {
                try {
                    tarFile.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }

        return true;
    }

    public static void extractTarFile(String tarFileName, String targetFolder) throws Exception {
        Exception exception = null;
        byte[] buf = new byte[8192];
        TarFile tarFile = null;
        try {
            tarFile = new TarFile(tarFileName);
            Enumeration<TarEntry> enumeration = tarFile.entries();
            while (enumeration.hasMoreElements()) {
                TarEntry entry = enumeration.nextElement();

                File file = new File(targetFolder, entry.getName());

                if (entry.getFileType() == TarEntry.DIRECTORY) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                } else {

                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }

                    InputStream zin = tarFile.getInputStream(entry);
                    OutputStream fout = new FileOutputStream(file);
                    // check if parent folder exists
                    File dir = file.getParentFile();
                    if (dir.isDirectory() && !dir.exists()) {
                        dir.mkdirs();
                    }

                    try {
                        while (true) {
                            int bytesRead = zin.read(buf);
                            if (bytesRead == -1) { // end of file
                                break;
                            }
                            fout.write(buf, 0, bytesRead);

                        }
                        fout.flush();
                    } catch (Exception e) {
                        exception = e;
                        // stop looping
                        return;
                    } finally {
                        zin.close();
                        fout.close();
                    }
                }
            }
        } catch (Exception e) {
            exception = e;
        } finally {
            try {
                tarFile.close();
            } catch (IOException e) {
            }

            if (exception != null) {
                // notify caller with exception
                throw exception;
            }
        }
    }

    /**
     * Determine whether the file with the given filename is in .zip or .jar format.
     * 
     * @param fileName file to test
     * @return true if the file is in tar format
     */
    public static boolean isZipFile(String fileName) {
        if (fileName.length() == 0) {
            return false;
        }

        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(fileName);
        } catch (IOException ioException) {
            return false;
        } finally {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }

        return true;
    }
}
