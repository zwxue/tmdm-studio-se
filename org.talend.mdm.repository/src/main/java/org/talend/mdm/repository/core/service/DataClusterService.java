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
package org.talend.mdm.repository.core.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.XMLException;
import org.talend.mdm.bulkload.client.BulkloadClient;
import org.talend.mdm.bulkload.client.BulkloadOptions;
import org.talend.mdm.bulkload.client.InputStreamMerger;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.utils.IOUtil;
import org.talend.repository.utils.ZipFileUtils;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSBoolean;
import com.amalto.workbench.webservices.WSDataCluster;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSExistsDataCluster;
import com.amalto.workbench.webservices.WSGetItem;
import com.amalto.workbench.webservices.WSGetItemPKsByCriteria;
import com.amalto.workbench.webservices.WSItem;
import com.amalto.workbench.webservices.WSItemPKsByCriteriaResponseResults;
import com.amalto.workbench.webservices.WSPutDataCluster;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DataClusterService {

    public class ExportContentProcess implements IRunnableWithProgress {

        private String dName;

        private String fPath;

        private XtentisPort port;

        private String tempFolderPath;

        /**
         * DOC hbhong ExprocessContentProcess constructor comment.
         * 
         * @param port
         * @param tempFolderPath
         * @param dName
         */
        public ExportContentProcess(XtentisPort port, String tempFolderPath, String dName, String fPath) {
            this.port = port;
            this.tempFolderPath = tempFolderPath;
            this.dName = dName;
            this.fPath = fPath;
        }

        protected void exportCluster(XtentisPort port, String tempFolderPath, String dName, IProgressMonitor monitor) {

            String encodedID = null;
            // List<TreeObject> exports = new ArrayList<TreeObject>();
            WSDataClusterPK pk = new WSDataClusterPK(dName);
            try {
                List<String> items = new ArrayList<String>();
                WSItemPKsByCriteriaResponseResults[] results = port.getItemPKsByCriteria(
                        new WSGetItemPKsByCriteria(pk, null, null, null, (long) -1, (long) -1, 0, Integer.MAX_VALUE))
                        .getResults();
                if (results == null)
                    return;
                monitor.beginTask(Messages.ExportDataClusterAction_exportContent, results.length + 10);
                monitor.subTask(Messages.ExportDataClusterAction_exporting);
                for (WSItemPKsByCriteriaResponseResults item : results) {
                    if (item.getWsItemPK().getIds() == null)
                        continue;
                    WSItem wsitem = port.getItem(new WSGetItem(item.getWsItemPK()));

                    // Marshal
                    StringWriter sw = new StringWriter();
                    Marshaller.marshal(wsitem, sw);

                    String uniqueId = pk.getPk() + "." + wsitem.getConceptName();//$NON-NLS-1$
                    for (String id : wsitem.getIds()) {
                        uniqueId = uniqueId + "." + id;//$NON-NLS-1$
                    }
                    encodedID = URLEncoder.encode(uniqueId, "UTF-8");//$NON-NLS-1$
                    writeString(tempFolderPath, sw.toString(), pk.getPk() + "/" + encodedID);//$NON-NLS-1$ 
                    items.add(TreeObject.DATACONTAINER_COTENTS + "/" + pk.getPk() + "/" + encodedID);//$NON-NLS-1$//$NON-NLS-2$
                    monitor.worked(1);
                }
                //            TreeObject obj1 = new TreeObject(pk.getPk(), null, TreeObject.DATA_CLUSTER_CONTENTS, null, null);//$NON-NLS-1$
                // obj1.setItems(items.toArray(new String[items.size()]));
                // exports.add(obj1);
                // return exports;
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
            // return null;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
         */
        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            exportCluster(port, tempFolderPath, dName, monitor);
            zipFile(tempFolderPath, fPath, monitor);
            IOUtil.cleanFolder(new File(tempFolderPath));
            monitor.done();
        }

        protected void writeString(String exportFolder, String outputStr, String filename) {

            File f = new File(exportFolder + "/" + filename);//$NON-NLS-1$

            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdir();
            }
            FileWriter fo = null;
            try {
                fo = new FileWriter(f);
                //            IOUtils.write(outputStr, fo, "UTF-8");//$NON-NLS-1$
                fo.write(outputStr);
                fo.flush();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            } finally {
                if (fo != null)
                    try {
                        fo.close();
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                    }
            }

        }

    }

    public class ImportContentProcess implements IRunnableWithProgress {

        private String dName;

        private MultiStatus multiStatus;

        private String path;

        private MDMServerDef serverDef;

        /**
         * DOC hbhong ExportContentProcess constructor comment.
         * 
         * @param serverDef
         * @param dName
         * @param path
         */
        public ImportContentProcess(MDMServerDef serverDef, String dName, String path) {
            super();
            this.serverDef = serverDef;
            this.dName = dName;
            this.path = path;
        }

        public MultiStatus getImportStatus() {
            return this.multiStatus;
        }

        protected MultiStatus importClusterContents(MDMServerDef serverDef, String dName, String path, IProgressMonitor monitor) {
            this.serverDef = serverDef;
            this.dName = dName;
            this.path = path;
            String url = "http://" + serverDef.getHost() + ":" + serverDef.getPort() + "/datamanager/loadServlet"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            String userName = serverDef.getUser();
            String password = serverDef.getPasswd();
            Reader reader = null;
            InputStream is = null;
            MultiStatus ms = new MultiStatus(RepositoryPlugin.PLUGIN_ID, IStatus.ERROR,
                    Messages.ImportDataClusterAction_errorTitle, null);
            File[] files = new File(path).listFiles();
            monitor.beginTask(Messages.ImportDataClusterAction_importProcessTitle, files.length + 10);
            for (File file : files) {
                String concept = ""; //$NON-NLS-1$
                try {
                    reader = new InputStreamReader(new FileInputStream(file), "UTF-8");//$NON-NLS-1$ 
                    WSItem wsItem = (WSItem) Unmarshaller.unmarshal(WSItem.class, reader);

                    // store the items to db using bulkloadclient
                    concept = wsItem.getConceptName();
                    BulkloadClient bulkloadClient = new BulkloadClient(url, userName, password, null, dName, concept,
                            wsItem.getDataModelName());
                    bulkloadClient.setOptions(new BulkloadOptions(false, false, 500));
                    InputStreamMerger manager = bulkloadClient.load();
                    String content = wsItem.getContent() + "\n"; //$NON-NLS-1$
                    if (content != null) {
                        is = new ByteArrayInputStream(content.getBytes("utf-8")); //$NON-NLS-1$
                        manager.push(is);
                        // bulkloadClient.load(sb.toString());
                        manager.close();
                    }

                } catch (XMLException e) {
                    log.error(e.getMessage(), e);
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                } catch (Exception e) {
                    String msg = Messages.bind(Messages.ImportDataClusterAction_importErrorMsg, concept, dName,
                            e.getLocalizedMessage());
                    IStatus errStatus = new Status(IStatus.ERROR, RepositoryPlugin.PLUGIN_ID, msg, e);
                    ms.add(errStatus);

                } finally {
                    try {
                        if (reader != null)
                            reader.close();
                    } catch (Exception e) {
                    }
                    try {
                        if (is != null)
                            is.close();
                    } catch (Exception e) {
                    }
                }
                monitor.worked(1);
            }
            monitor.done();
            return ms;
        }

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            this.multiStatus = importClusterContents(serverDef, dName, path, monitor);

        }
    }

    private static final String INDEX_FILE_NAME = "DataCluster.list"; //$NON-NLS-1$

    private static DataClusterService intance = new DataClusterService();

    private static Logger log = Logger.getLogger(DataClusterService.class);

    private static final String PROP_DATA_CLUSTER_NAME = "DataClusterNames"; //$NON-NLS-1$

    public static DataClusterService getIntance() {
        return intance;
    }

    private DataClusterService() {
    }

    public boolean createDataCluster(XtentisPort port, String dName) {
        try {
            WSPutDataCluster wsDataCluster = new WSPutDataCluster(new WSDataCluster(dName, "", "")); //$NON-NLS-1$ //$NON-NLS-2$
            port.putDataCluster(wsDataCluster);
            return true;
        } catch (RemoteException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    private String getIndexFilePath(String folderPath) {
        return folderPath + File.separator + INDEX_FILE_NAME;
    }

    public ImportContentProcess getNewImportContentProcess(MDMServerDef serverDef, String dName, String path) {
        return new ImportContentProcess(serverDef, dName, path);
    }

    public ExportContentProcess getNewExportContentProcess(XtentisPort port, String tempFolderPath, String dName, String fPath) {
        return new ExportContentProcess(port, tempFolderPath, dName, fPath);
    }

    public boolean isExistDataCluster(XtentisPort port, String dName) {
        try {
            WSExistsDataCluster wsExistsDataCluster = new WSExistsDataCluster(new WSDataClusterPK(dName));
            WSBoolean wsBoolean = port.existsDataCluster(wsExistsDataCluster);
            return wsBoolean.is_true();
        } catch (RemoteException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    public String loadIndexFile(String folderPath) {
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

    public void storeIndexFile(String folderPath, String dName) {
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

    public void unZipFile(String fPath, String tempFolderPath) {
        ZipFileUtils.unZip(fPath, tempFolderPath);
    }

    /**
     * DOC hbhong Comment method "zipFile".
     * 
     * @param tempFolderPath
     * @param fPath
     */
    public void zipFile(String tempFolderPath, String fPath, IProgressMonitor monitor) {
        monitor.subTask(Messages.AbstractDataClusterAction_zipContentFile);
        ZipFileUtils.zip(tempFolderPath, fPath, false);
        monitor.worked(5);
    }
}
