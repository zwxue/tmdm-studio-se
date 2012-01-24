// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions.datacontainer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.repository.utils.ZipFileUtils;

import com.amalto.workbench.webservices.WSBoolean;
import com.amalto.workbench.webservices.WSDataCluster;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSExistsDataCluster;
import com.amalto.workbench.webservices.WSPutDataCluster;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public abstract class AbstractDataClusterAction extends AbstractRepositoryAction {

    protected static Logger log = Logger.getLogger(AbstractDataClusterAction.class);

    private static final String INDEX_FILE_NAME = "DataCluster.list"; //$NON-NLS-1$

    private static final String PROP_DATA_CLUSTER_NAME = "DataClusterNames"; //$NON-NLS-1$

    protected void storeIndexFile(String folderPath, String dName) {
        Properties prop = new Properties();
        prop.setProperty(PROP_DATA_CLUSTER_NAME, dName);
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(getIndexFilePath(folderPath));
            prop.store(fo, ""); //$NON-NLS-1$
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }

    }

    protected String loadIndexFile(String folderPath) {
        Properties prop = new Properties();
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(getIndexFilePath(folderPath));
            prop.load(fi);
            return prop.getProperty(PROP_DATA_CLUSTER_NAME);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        } finally {
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    private String getIndexFilePath(String folderPath) {
        return folderPath + File.separator + INDEX_FILE_NAME;
    }

    /**
     * DOC hbhong AbstractDataClusterAction constructor comment.
     * 
     * @param text
     */
    protected AbstractDataClusterAction(String text) {
        super(text);
    }



    /**
     * DOC hbhong Comment method "zipFile".
     * 
     * @param tempFolderPath
     * @param fPath
     */
    protected void zipFile(String tempFolderPath, String fPath, IProgressMonitor monitor) {
        monitor.subTask(Messages.AbstractDataClusterAction_zipContentFile);
        ZipFileUtils.zip(tempFolderPath, fPath, false);
        monitor.worked(5);
    }

    protected void unZipFile(String fPath, String tempFolderPath) {
        ZipFileUtils.unZip(fPath, tempFolderPath);
    }

    public String getGroupName() {
        return GROUP_EXPORT;
    }

    protected boolean isExistDataCluster(XtentisPort port, String dName) {
        try {
            WSExistsDataCluster wsExistsDataCluster = new WSExistsDataCluster(new WSDataClusterPK(dName));
            WSBoolean wsBoolean = port.existsDataCluster(wsExistsDataCluster);
            return wsBoolean.is_true();
        } catch (RemoteException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    protected boolean createDataCluster(XtentisPort port, String dName) {
        try {
            WSPutDataCluster wsDataCluster = new WSPutDataCluster(new WSDataCluster(dName, "", "")); //$NON-NLS-1$ //$NON-NLS-2$
            port.putDataCluster(wsDataCluster);
            return true;
        } catch (RemoteException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }



}
