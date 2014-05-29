// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.editors.actions;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.WebServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Shell;

import com.amalto.workbench.MDMWorbenchPlugin;
import com.amalto.workbench.editors.IDataClusterConstants;
import com.amalto.workbench.editors.dialogs.EditRecordDialog;
import com.amalto.workbench.editors.dialogs.MatchResultDialog;
import com.amalto.workbench.editors.match.MatchData;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.HttpClientUtil;
import com.amalto.workbench.utils.LineItem;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSGetDataModel;
import com.amalto.workbench.webservices.WSGetItem;
import com.amalto.workbench.webservices.WSItem;
import com.amalto.workbench.webservices.WSItemPK;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * created by liusongbo on 2014-5-14
 */
public class SimulateMatchAction extends Action {

    private static final Log log = LogFactory.getLog(SimulateMatchAction.class);
    private Shell shell;

    private ImageDescriptor imageDescriptor = MDMWorbenchPlugin.getImageDescriptor("icons/save.png"); //$NON-NLS-1$

    private TableViewer tableViewer;

    private Retriever retriever;

    private TreeObject xObject;

    private boolean isMaster;

    private Map<String, String> id2Records = new HashMap<String, String>();

    public SimulateMatchAction(Shell shell, TableViewer viewer, TreeObject xObject, boolean isMaster) {
        this.shell = shell;
        this.tableViewer = viewer;
        this.xObject = xObject;
        this.isMaster = isMaster;
        setImageDescriptor(imageDescriptor);
        String text = Messages.SimulateMatchAction_matchSimulation;
        setText(text);
        setToolTipText(text);
    }

    @Override
    public void run() {
        IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
        List<LineItem> selectedRecords = selection.toList();

        String errorMsg = validateSelection(selectedRecords);
        if (errorMsg != null) {
            MessageDialog.openError(shell, Messages._Error, errorMsg);
            return;
        }

        String entity = selectedRecords.get(0).getConcept().trim();
        String mergedRecords = getMergedRecords(selectedRecords);

        String records = editMatchRecords(entity, mergedRecords);
        if (records != null) {
            String matchResult = simulateMatchMerge(entity, records);
            showResultsDialog(matchResult);
        }
    }

    private String validateSelection(List<LineItem> selectedRecords) {
        if (selectedRecords.size() < 2) {
            return Messages.SimulateMatchAction_requireAtLeastTwoRecords;
        }

        String concept = selectedRecords.get(0).getConcept();
        for (int i = 1; i < selectedRecords.size(); i++) {
            if (!concept.equals(selectedRecords.get(i).getConcept())) {
                return Messages.SimulateMatchAction_notBelongToSameEntity;
            }
        }

        return null;
    }

    public String editMatchRecords(String entity, String combinedRecords) {
        EditRecordDialog dialog = new EditRecordDialog(shell, getRetriever().retrieveSchema(), entity);
        dialog.setRecords(combinedRecords);

        String wholeRecords = null;
        if (dialog.open() == Dialog.OK) {
            id2Records = dialog.getId2Records();

            StringBuilder builder = new StringBuilder();
            for(String record:id2Records.values()) {
                builder.append(record + "\n"); //$NON-NLS-1$
            }
            wholeRecords = builder.toString();
        }

        return wholeRecords;
    }

    private String getMergedRecords(List<LineItem> selectedRecords) {
        StringBuilder records = new StringBuilder();
        for (LineItem item : selectedRecords) {
            String retrievedRecord = getRetriever().retrieveRecord(item);
            if (retrievedRecord != null) {
                records.append(retrievedRecord.trim() + "\n"); //$NON-NLS-1$
            }
        }

        return records.toString();
    }

    private Retriever getRetriever() {
        if (retriever == null) {
            try {
                final XtentisPort port = Util.getPort(xObject);
                WSDataClusterPK clusterPk = (WSDataClusterPK) xObject.getWsKey();
                retriever = new Retriever(port, clusterPk, isMaster);
            } catch (XtentisException e) {
                log.error(e.getMessage(), e);
                MessageDialog.openError(shell, Messages._Error,
                        Messages.bind(Messages.SimulateMatchAction_errorToGetRecordContent, e.getLocalizedMessage()));
            }
        }

        return retriever;
    }

    private String simulateMatchMerge(String entityName, String records) {
        String modelName = ((WSDataClusterPK) xObject.getWsKey()).getPk();

        String endpointAddress = xObject.getEndpointAddress();
        URI uri = URI.create(endpointAddress);
        String scheme = uri.getScheme();
        String protocol = scheme + "://"; //$NON-NLS-1$
        String host = xObject.getEndpointHost();
        int port = Integer.parseInt(xObject.getEndpointPort());
        String username = xObject.getUsername();
        String password = xObject.getPassword();
        try {
            String result = HttpClientUtil.invokeMatchSimulation(protocol, host, port, username, password, modelName, entityName,
                    records);
            return result;
        } catch (XtentisException e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(shell, Messages._Error,
                    Messages.bind(Messages.SimulateMatchAction_errorToMatchRecords, e.getLocalizedMessage()));
        }

        return null;
    }

    private void showResultsDialog(String matchResult) {
        if (matchResult != null) {
            MatchResultDialog dialog = new MatchResultDialog(shell);
            dialog.setInput(new MatchData(matchResult), id2Records);

            dialog.open();
        }
    }

    public static class Retriever {

        XtentisPort port;

        WSDataClusterPK clusterPk;

        private boolean isMaster;

        public Retriever(XtentisPort port, WSDataClusterPK clusterPk, boolean isMaster) {
            this.port = port;
            this.clusterPk = clusterPk;
            this.isMaster = isMaster;
        }

        public String retrieveSchema() {
            try {
                WSDataModel dataModel = port.getDataModel(new WSGetDataModel(new WSDataModelPK(clusterPk.getPk())));
                String xsdSchema = dataModel.getXsdSchema();
                return xsdSchema;
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            return null;
        }

        public String retrieveRecord(LineItem lineItem) {
            try {
                WSDataClusterPK clusterPk_inner = clusterPk;
                if (!isMaster) {
                    clusterPk_inner = new WSDataClusterPK(clusterPk.getPk() + IDataClusterConstants.PK_ADDITION);
                }
                final WSItem wsItem = port.getItem(new WSGetItem(new WSItemPK(clusterPk_inner, lineItem
                        .getConcept().trim(), Arrays.asList(lineItem.getIds()))));
                String recordContent = Util.formatXsdSource(wsItem.getContent(), true);
                return recordContent;
            } catch (WebServiceException e) {
                log.error(e.getMessage(), e);
            }
            return null;
        }
    }
}
