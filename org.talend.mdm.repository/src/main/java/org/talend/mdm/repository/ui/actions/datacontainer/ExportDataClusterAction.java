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
package org.talend.mdm.repository.ui.actions.datacontainer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.exolab.castor.xml.Marshaller;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.utils.IOUtil;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSGetItem;
import com.amalto.workbench.webservices.WSGetItemPKsByCriteria;
import com.amalto.workbench.webservices.WSItem;
import com.amalto.workbench.webservices.WSItemPKsByCriteriaResponseResults;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ExportDataClusterAction extends AbstractDataClusterAction {

    private static Logger log = Logger.getLogger(ExportDataClusterAction.class);

    /**
     * DOC hbhong ExportDataClusterAction constructor comment.
     * 
     * @param text
     */
    public ExportDataClusterAction() {
        super(Messages.ExportDataClusterAction_title);
        setImageDescriptor(ImageCache.getImage(EImage.EXPORT.getPath()));
    }

    protected void doRun() {
        List<Object> selectedObject = getSelectedObject();
        if (!selectedObject.isEmpty()) {
            IRepositoryViewObject viewObj = (IRepositoryViewObject) selectedObject.get(0);
            SelectServerDefDialog dialog = new SelectServerDefDialog(getShell());
            if (dialog.open() == IDialogConstants.OK_ID) {
                MDMServerDef serverDef = dialog.getSelectedServerDef();

                MDMServerObjectItem item = (MDMServerObjectItem) viewObj.getProperty().getItem();
                String dName = item.getMDMServerObject().getName();

                try {
                    FileDialog fd = new FileDialog(getShell(), SWT.SAVE);
                    fd.setFilterExtensions(new String[] { "*.zip" }); //$NON-NLS-1$
                    String fPath = fd.open();
                    if (fPath != null) {
                        XtentisPort port = RepositoryWebServiceAdapter.getXtentisPort(serverDef);
                        if (isExistDataCluster(port, dName)) {
                            File tempFolder = IOUtil.getTempFolder();
                            String tempFolderPath = tempFolder.getAbsolutePath();
                            storeIndexFile(tempFolderPath, dName);
                            ExportContentProcess process = new ExportContentProcess(port, tempFolderPath, dName, fPath);
                            try {
                                IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
                                progressService.run(true, true, process);
                                // show success info
                                MessageDialog.openInformation(getShell(), Messages.ExportDataClusterAction_exportContent,
                                        Messages.bind(Messages.ExportDataClusterAction_successExport, dName));
                            } catch (InvocationTargetException e) {
                                log.error(e.getMessage(), e);
                            } catch (InterruptedException e) {
                            }

                        } else {
                            MessageDialog.openInformation(getShell(), Messages.Common_Warning,
                                    Messages.bind(Messages.ExportDataClusterAction_noContainerFound, dName));
                        }
                    }
                } catch (XtentisException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    class ExportContentProcess implements IRunnableWithProgress {

        private XtentisPort port;

        private String tempFolderPath;

        private String dName;

        private String fPath;

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

}
