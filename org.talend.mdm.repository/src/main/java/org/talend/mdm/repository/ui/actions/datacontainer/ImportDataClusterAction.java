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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.XMLException;
import org.talend.mdm.bulkload.client.BulkloadClient;
import org.talend.mdm.bulkload.client.BulkloadOptions;
import org.talend.mdm.bulkload.client.InputStreamMerger;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog;
import org.talend.mdm.repository.utils.IOUtil;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSItem;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ImportDataClusterAction extends AbstractDataClusterAction {

    private static Logger log = Logger.getLogger(ImportDataClusterAction.class);

    /**
     * DOC hbhong ImportDataClusterAction constructor comment.
     * 
     * @param text
     */
    public ImportDataClusterAction() {
        super(Messages.ImportDataClusterAction_title);
        setImageDescriptor(ImageCache.getImage(EImage.IMPORT.getPath()));
    }

    protected void doRun() {
        FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
        fd.setFilterExtensions(new String[] { "*.zip" }); //$NON-NLS-1$
        String fPath = fd.open();
        if (fPath != null) {
            File tempFolder = IOUtil.getTempFolder();
            String tempFolderPath = tempFolder.getAbsolutePath();
            unZipFile(fPath, tempFolderPath);
            String dName = loadIndexFile(tempFolderPath);
            if (dName == null) {
                MessageDialog.openError(getShell(), Messages.Common_Error, Messages.ImportDataClusterAction_errorFormat);
                return;
            }
            tempFolderPath += File.separator + dName;
            //
            SelectServerDefDialog dialog = new SelectServerDefDialog(getShell());
            if (dialog.open() == IDialogConstants.OK_ID) {
                MDMServerDef serverDef = dialog.getSelectedServerDef();
                try {

                    XtentisPort port = RepositoryWebServiceAdapter.getXtentisPort(serverDef);

                    if (!isExistDataCluster(port, dName)) {
                        if (MessageDialog.openQuestion(getShell(), Messages.ImportDataClusterAction_createDataClusterTitle,
                                Messages.bind(Messages.ImportDataClusterAction_createConfirm, dName))) {
                            createDataCluster(port, dName);
                        } else {
                            return;
                        }
                    }

                    ImportContentProcess process = new ImportContentProcess(serverDef, dName, tempFolderPath);
                    try {
                        IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
                        progressService.run(true, true, process);

                    } catch (InvocationTargetException e) {
                        log.error(e.getMessage(), e);
                    } catch (InterruptedException e) {
                    }
                    MultiStatus multiStatus = process.getImportStatus();
                    if (multiStatus != null && multiStatus.getChildren().length > 0) {
                        MultiStatusDialog statusDialog = new MultiStatusDialog(getShell(), multiStatus.getMessage(), multiStatus);
                        statusDialog.open();
                    } else {
                        // show success info
                        MessageDialog.openInformation(getShell(), Messages.ImportDataClusterAction_importTitle,
                                Messages.bind(Messages.ImportDataClusterAction_successImport, dName));
                    }
                } catch (XtentisException e) {
                    log.error(e.getMessage(), e);
                } finally {
                    IOUtil.cleanFolder(tempFolder);
                }

            }
        }
    }

    class ImportContentProcess implements IRunnableWithProgress {

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

        private String dName;

        private String path;

        private MultiStatus multiStatus;

        public MultiStatus getImportStatus() {
            return this.multiStatus;
        }

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            this.multiStatus = importClusterContents(serverDef, dName, path, monitor);

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
    }
}
