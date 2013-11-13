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
package org.talend.mdm.repository.core.datacontent.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.exolab.castor.xml.Marshaller;
import org.talend.mdm.repository.core.datacontent.DataProcessRule;
import org.talend.mdm.repository.core.datacontent.DataProcessRuleFactory;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.utils.IOUtil;
import org.talend.repository.utils.ZipFileUtils;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSGetItem;
import com.amalto.workbench.webservices.WSGetItemPKsByCriteria;
import com.amalto.workbench.webservices.WSItem;
import com.amalto.workbench.webservices.WSItemPKsByCriteriaResponseResults;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * created by HHB on 2012-10-9 Detailled comment
 * 
 */
public class ExportDataContentProcess extends AbstractDataContentProcess {

    private static Logger log = Logger.getLogger(ExportDataContentProcess.class);

    private XtentisPort port;

    private String tempFolderPath;

    private String dName;

    private String outputPath;

    public ExportDataContentProcess(XtentisPort port, String tempFolderPath, String dName, String outputPath) {
        this.port = port;
        this.tempFolderPath = tempFolderPath;
        this.dName = dName;
        this.outputPath = outputPath;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.datacontent.IDataContentProcess#processDatas(org.eclipse.core.runtime.IProgressMonitor
     * )
     */
    public void processDatas(DataProcessRule rule) throws InterruptedException, InvocationTargetException {
        IProgressService progressService = getProcessService();
        ExportProcess process = new ExportProcess(rule);
        progressService.run(true, true, process);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.datacontent.IDataContentProcess#buildRule()
     */
    public DataProcessRule buildRule() throws InvocationTargetException {
        try {
            DataProcessRule rule = DataProcessRuleFactory.createProcessRouterFromRemote(port, dName);
            return rule;
        } catch (RemoteException e) {
            throw new InvocationTargetException(e, Messages.ExportDataContentProcess_CanNotConnectServer);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.datacontent.IDataContentProcess#tuneRule(org.talend.mdm.repository.core.datacontent
     * .DataProcessRule)
     */
    public void tuneRule(final DataProcessRule rule) throws InterruptedException {

        saveRuleFile(rule);
    }

    protected MultiStatus processResult;

    private boolean saveRuleFile(DataProcessRule rule) {
        if (rule != null) {
            File file = new File(tempFolderPath + File.separator + RULE_FILE_NAME);
            try {
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");//$NON-NLS-1$ 
                Marshaller.marshal(rule, writer);
                return true;
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.datacontent.IDataContentProcess#getResult()
     */
    public MultiStatus getResult() {
        processResult = new MultiStatus(RepositoryPlugin.PLUGIN_ID, IStatus.ERROR, Messages.ExportObjectAction_error, null);
        return processResult;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.datacontent.impl.AbstractDataContentProcess#getProcessService()
     */
    @Override
    protected IProgressService getProcessService() {
        return PlatformUI.getWorkbench().getProgressService();
    }

    public class ExportProcess implements IRunnableWithProgress {

        private DataProcessRule rule;

        /**
         * DOC hbhong Comment method "zipFile".
         * 
         * @param tempFolderPath
         * @param fPath
         */
        private void zipFile(String tempFolderPath, String fPath, IProgressMonitor monitor) {
            monitor.subTask(Messages.AbstractDataClusterAction_zipContentFile);
            ZipFileUtils.zip(tempFolderPath, fPath, false);
            monitor.worked(5);
        }

        /**
         * DOC hbhong ExprocessContentProcess constructor comment.
         * 
         * @param port
         * @param tempFolderPath
         * @param dName
         */
        public ExportProcess(DataProcessRule rule) {
            this.rule = rule;

        }

        protected int exportCluster(XtentisPort port, String tempFolderPath, String dName, IProgressMonitor monitor) {

            String encodedID = null;
            WSDataClusterPK pk = new WSDataClusterPK(dName);
            try {
                List<String> items = new ArrayList<String>();
                WSItemPKsByCriteriaResponseResults[] results = port.getItemPKsByCriteria(
                        new WSGetItemPKsByCriteria(pk, null, null, null, (long) -1, (long) -1, 0, MAX_EXPORT_COUNT)).getResults();
                if (results == null) {
                    return -1;
                }
                monitor.beginTask(Messages.ExportDataClusterAction_exportContent, results.length + 10);
                monitor.subTask(Messages.ExportDataClusterAction_exporting);
                int totalSize = 0;
                if (results.length > 0) {
                    totalSize = Integer.parseInt(Util.parse(results[0].getWsItemPK().getConceptName()).getDocumentElement()
                            .getTextContent());
                }
                for (WSItemPKsByCriteriaResponseResults item : results) {
                    if (item.getWsItemPK().getIds() == null) {
                        continue;
                    }
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
                return totalSize;
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
            return -1;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
         */
        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            final int totalSize = exportCluster(port, tempFolderPath, dName, monitor);
            zipFile(tempFolderPath, outputPath, monitor);
            IOUtil.cleanFolder(new File(tempFolderPath));
            monitor.done();
            if (totalSize >= MAX_EXPORT_COUNT) {
                Display.getDefault().asyncExec(new Runnable() {

                    public void run() {
                        MessageDialog.openWarning(Display.getDefault().getActiveShell(), Messages.Common_Warning, Messages.bind(
                                Messages.ExportDataContentProcess_greaterThanMaxExportLimit, totalSize, MAX_EXPORT_COUNT));
                    }
                });

            }
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
                if (fo != null) {
                    try {
                        fo.close();
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }

        }

    }
}
