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
package org.talend.mdm.repository.ui.editors;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.forms.editor.FormEditor;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.workbench.enterprice.editors.SynchronizationMainPage;

import com.amalto.workbench.webservices.WSPing;
import com.amalto.workbench.webservices.WSSynchronizationPlan;
import com.amalto.workbench.webservices.WSSynchronizationPlanAction;
import com.amalto.workbench.webservices.WSSynchronizationPlanActionCode;
import com.amalto.workbench.webservices.WSSynchronizationPlanPK;
import com.amalto.workbench.webservices.WSSynchronizationPlanStatus;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;

/**
 * DOC jsxie class global comment. Detailled comment
 */
public class MDMSynchronizationMainPage extends SynchronizationMainPage {

    private XtentisPort port;

    public MDMSynchronizationMainPage(FormEditor editor) {
        super(editor);
        // TODO Auto-generated constructor stub
    }

    private static Log log = LogFactory.getLog(MDMSynchronizationMainPage.class);

    protected void doStartFullAction() {
        // Start it
        WSSynchronizationPlan ws = (WSSynchronizationPlan) (getXObject().getWsObject());
        try {
            port = getPort();
            if (port == null)
                return;
            port.synchronizationPlanAction(new WSSynchronizationPlanAction(new WSSynchronizationPlanPK(ws.getName()),
                    WSSynchronizationPlanActionCode.START_FULL));
        } catch (RemoteException ex) {
            log.error(ex.getMessage(), ex);
            MessageDialog.openError(MDMSynchronizationMainPage.this.getSite().getShell(),
                    "Error Starting the Full Synchronization", ex.getLocalizedMessage());
        }
    }

    protected void doStartDiffAction() {
        WSSynchronizationPlan ws = (WSSynchronizationPlan) (getXObject().getWsObject());
        try {
            port = getPort();
            if (port == null)
                return;
            port.synchronizationPlanAction(
                    new WSSynchronizationPlanAction(new WSSynchronizationPlanPK(ws.getName()),
                    WSSynchronizationPlanActionCode.START_DIFFERENTIAL));
        } catch (RemoteException ex) {
            log.error(ex.getMessage(), ex);
            MessageDialog.openError(MDMSynchronizationMainPage.this.getSite().getShell(),
                    "Error Starting the Differential Synchronization", ex.getLocalizedMessage());
        }
    }

    protected void doStopAction() {
        WSSynchronizationPlan ws = (WSSynchronizationPlan) (getXObject().getWsObject());
        try {
            if (port == null)
                port = getPort();
            if (port == null)
                return;
            port.synchronizationPlanAction(new WSSynchronizationPlanAction(new WSSynchronizationPlanPK(ws.getName()),
                    WSSynchronizationPlanActionCode.STOP));
        } catch (RemoteException ex) {
            log.error(ex.getMessage(), ex);
            MessageDialog.openError(MDMSynchronizationMainPage.this.getSite().getShell(), "Error Resetting the Synchronization",
                    ex.getLocalizedMessage());
        }

    }

    protected WSSynchronizationPlanStatus doRefreshStatus() {
        // check server status( maybe waste some time, but more safety )
        try {
            if (port == null)
                port = getPort();
            if (port == null)
                return null;

            port.ping(new WSPing("check"));
        } catch (RemoteException e1) {
            log.error(e1.getMessage(), e1);
            stopRefreshTimer();
            startFullButton.setEnabled(false);
            startDifferentialButton.setEnabled(false);
            stopButton.setEnabled(false);
            resetButton.setEnabled(true);
        }


        WSSynchronizationPlan ws = (WSSynchronizationPlan) (getXObject().getWsObject());
        WSSynchronizationPlanStatus wsStatus = null;
        try {

            if (port == null)
                port = getPort();
            if (port == null)
                return null;
            wsStatus = port.synchronizationPlanAction(
                    new WSSynchronizationPlanAction(new WSSynchronizationPlanPK(ws.getName()),
                    WSSynchronizationPlanActionCode.STATUS));
        } catch (RemoteException e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(this.getSite().getShell(), "Error refreshing the page",
                    "The status of the Plan cannot be fetched: " + e.getLocalizedMessage());

        }

        return wsStatus;

    }

    protected void doResetAction() {

        WSSynchronizationPlan ws = (WSSynchronizationPlan) (getXObject().getWsObject());
        try {
            if (port == null)
                port = getPort();
            if (port == null)
                return;
            port.synchronizationPlanAction(new WSSynchronizationPlanAction(new WSSynchronizationPlanPK(ws.getName()),
                    WSSynchronizationPlanActionCode.RESET));
        } catch (RemoteException ex) {
            log.error(ex.getMessage(), ex);
            MessageDialog.openError(MDMSynchronizationMainPage.this.getSite().getShell(), "Error Resetting the Synchronization",
                    ex.getLocalizedMessage());
        }
    }

    protected String[] getItemsAlgorithmsStrings() {

        return RepositoryWebServiceAdapter.getItemsAlgorithmsStringsForSynchronization();

    }

    // override for blank
    protected void setForRevisionsForItems(String selectedConcept, ComplexTableViewerColumn complexTableViewerRevisionIdColumn) {

    }

    // override for blank
    protected void setConceptsForItems(String clusterName, ComplexTableViewerColumn complexTableViewerModelConceptColumn) {

    }

    protected String[] getObjectsAlgorithmStrings() {

        return RepositoryWebServiceAdapter.getObjectsAlgorithmsStringsForSynchronization();
    }

    protected String[] getXtentisObjects() {

        return RepositoryWebServiceAdapter.getXtentisObjectsForSynchronizationPlans();

    }

    // override for return new empty HashMap

    protected Map<String, String> getObjectsRevisionMap() {
        return new HashMap<String, String>();

    }

    protected List<String> getDataClustersStrings() {
        return RepositoryQueryService.findAllDataContainerNames();

    }

    @Override
    protected XtentisPort getPort() {
        return RepositoryWebServiceAdapter.getXtentisPort(getSite().getShell());
    }

    protected void refreshData() {
        super.doRefreshData();
        refreshing = false;
    }

}
