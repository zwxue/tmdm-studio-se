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
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.exolab.castor.xml.Marshaller;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

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
        super("Export content from MDM server");
    }

    @Override
    public void run() {
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
                            File tempFolder = getTempFolder();
                            String tempFolderPath = tempFolder.getAbsolutePath();
                            storeIndexFile(tempFolderPath, dName);
                            exportCluster(port, tempFolderPath, dName);
                            zipFile(tempFolderPath, fPath);
                            // cleanTempFolder(tempFolder);
                        } else {
                            MessageDialog.openInformation(getShell(), "Warning", "no such container named \"" + dName
                                    + "\" on selected server");
                        }
                    }
                } catch (XtentisException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    protected List<TreeObject> exportCluster(XtentisPort port, String tempFolderPath, String dName) {

        String encodedID = null;
        List<TreeObject> exports = new ArrayList<TreeObject>();
        WSDataClusterPK pk = new WSDataClusterPK(dName);
        try {
            List<String> items = new ArrayList<String>();
            WSItemPKsByCriteriaResponseResults[] results = port.getItemPKsByCriteria(
                    new WSGetItemPKsByCriteria(pk, null, null, null, (long) -1, (long) -1, 0, Integer.MAX_VALUE)).getResults();
            if (results == null)
                return null;

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
                writeString(tempFolderPath, sw.toString(), pk.getPk() + "/" + encodedID);//$NON-NLS-1$//$NON-NLS-2$
                items.add(TreeObject.DATACONTAINER_COTENTS + "/" + pk.getPk() + "/" + encodedID);//$NON-NLS-1$//$NON-NLS-2$
            }
            TreeObject obj1 = new TreeObject(pk.getPk(), null, TreeObject.DATA_CLUSTER_CONTENTS, null, null);//$NON-NLS-1$
            obj1.setItems(items.toArray(new String[items.size()]));
            exports.add(obj1);
            return exports;
        } catch (Exception e) {
        }
        return null;
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
                }
        }

    }

}
