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
package org.talend.mdm.repository.ui.editors;

import java.net.URL;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.ui.dialogs.xpath.XpathSelectDialog2;
import org.talend.mdm.repository.ui.widgets.TisTableViewerR;
import org.talend.mdm.repository.ui.widgets.xmleditor.infoholder.RepositoryExternalInfoHolder;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

import com.amalto.workbench.dialogs.XpathSelectDialog;
import com.amalto.workbench.editors.DataClusterDialog;
import com.amalto.workbench.editors.RoutingRuleMainPage;
import com.amalto.workbench.editors.XObjectEditor;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.service.ILegendServerDefService;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSItemPK;
import com.amalto.workbench.webservices.WSRouteItemV2;
import com.amalto.workbench.webservices.WSServiceGetDocument;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.TisTableViewer;
import com.amalto.workbench.widgets.xmleditor.infoholder.ExternalInfoHolder;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RoutingRuleMainPage2 extends RoutingRuleMainPage {

    private static Log log = LogFactory.getLog(RoutingRuleMainPage2.class);
    /**
     * DOC hbhong RoutingRuleMainPage2 constructor comment.
     *
     * @param editor
     */
    public RoutingRuleMainPage2(FormEditor editor) {
        super(editor);
    }

    @Override
    protected void initServiceNameCombo() throws XtentisException {
        for (String name : RepositoryWebServiceAdapter.getServiceNames()) {
            serviceNameCombo.add(name);
        }
    }

    @Override
    protected void initExternalInfoHolder() {

        ExternalInfoHolder<?> allProcessNamesHolder = RepositoryExternalInfoHolder.getAllProcessesNamesHolder(null);
        ExternalInfoHolder<?> allJobInfosHolder = RepositoryExternalInfoHolder.getAllJobInfosHolder(null);
        ExternalInfoHolder<?> allVarCandidatesHolder = ExternalInfoHolder.getTriggerAllCallJobVarsCandidatesHolder();
        ExternalInfoHolder<?> mdmServerInfoHolder = RepositoryExternalInfoHolder.getAllMDMServerInfoHolder2(null);
        ExternalInfoHolder<?> workflowInfoHolder = RepositoryExternalInfoHolder.getAllWorkflowInfoHolder(null);
        ExternalInfoHolder<?> allDataModelHolderProxy = RepositoryExternalInfoHolder.getAllDataModelInfoHolderProxy(null);

        initExternalInfoHolderForEachType("callprocess", new ExternalInfoHolder<?>[] { allProcessNamesHolder });//$NON-NLS-1$
        initExternalInfoHolderForEachType("smtp", new ExternalInfoHolder<?>[] { allProcessNamesHolder });//$NON-NLS-1$
        initExternalInfoHolderForEachType("callJob", new ExternalInfoHolder<?>[] { allJobInfosHolder, mdmServerInfoHolder,//$NON-NLS-1$
                allVarCandidatesHolder });
        initExternalInfoHolderForEachType("workflow", new ExternalInfoHolder<?>[] { workflowInfoHolder, //$NON-NLS-1$
                allDataModelHolderProxy });

        initExternalInfoHolderForEachType("workflowcontext", new ExternalInfoHolder<?>[] { workflowInfoHolder, //$NON-NLS-1$
                allDataModelHolderProxy });

        //

    }

    @Override
    protected TisTableViewer getNewTisTableViewer(FormToolkit toolkit, Composite routingExpressionsGroup) {
        return new TisTableViewerR(Arrays.asList(conditionsColumns), toolkit, routingExpressionsGroup);
    }

    @Override
    protected void createCharacteristicsContent(FormToolkit toolkit, Composite charComposite) {
        addToolbar();
        super.createCharacteristicsContent(toolkit, charComposite);
    }

    private void addToolbar() {
        FormEditor editor = getEditor();
        if (editor instanceof XObjectEditor) {
            XObjectEditor xobjectEditor = (XObjectEditor) editor;
            xobjectEditor.getToolBar().addActions(new RunTriggerTestAction());
        }
    }

    @Override
    protected XpathSelectDialog getNewXpathDlg() {
        return new XpathSelectDialog2(getSite().getShell(), Messages.RoutingRuleMainPage2_selectEntity, getSite(), false,
                dataModelName);
    }

    @Override
    protected WSServiceGetDocument getServiceDocument(String jndiName) {
        return RepositoryWebServiceAdapter.getServiceDocument(jndiName);
    }

    class RunTriggerTestAction extends Action {

        public RunTriggerTestAction() {
            setImageDescriptor(ImageCache.getImage(EImage.RUN_EXC.getPath()));
            setText("");//$NON-NLS-1$
            setToolTipText(Messages.RoutingRuleMainPage2_run);
            setId("starttrigger"); //$NON-NLS-1$
        }

        @Override
        public void run() {
            try {
                com.amalto.workbench.utils.MDMServerDef serverDef = getServerDef();
                if (serverDef == null) {
                    return;
                }

                boolean canConnect = checkConnection(serverDef.getUrl(), serverDef.getUser(), serverDef.getPasswd(),
                        serverDef.getUniverse());
                if (!canConnect) {
                    MessageDialog.openError(getSite().getShell(), Messages.RoutingRuleMainPage2_CheckConnection,
                            Messages.RoutingRuleMainPage2_UnableToConnect);
                    return;
                }

                XtentisPort port = Util.getPort(new URL(serverDef.getUrl()), serverDef.getUniverse(), serverDef.getUser(),
                        serverDef.getPasswd());

                DataClusterDialog dialog = new DataClusterDialog(getSite().getShell(), new TreeObject(), getSite());
                dialog.setDefaultServerDef(serverDef);
                if (dialog.open() == IDialogConstants.OK_ID) {
                    String dataCluster = dialog.getDataContainer();
                    String concept = dialog.getConcept();
                    String[] recordIds = dialog.getRecordIds();
                    if (recordIds == null || recordIds.length == 0) {
                        MessageDialog.openError(getSite().getShell(), Messages._Error,
                                Messages.RoutingRuleMainPage2_NoRecordSelected);
                        return;
                    }
                    port.routeItemV2(new WSRouteItemV2(new WSItemPK(new WSDataClusterPK(dataCluster), concept, Arrays
                            .asList(recordIds))));

                    MessageDialog.openInformation(getSite().getShell(), Messages.RoutingRuleMainPage2_Success, Messages.RoutingRuleMainPage2_ExecuteTriggerSuccess);
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                MessageDialog.openError(getSite().getShell(), Messages._Error, Messages.RoutingRuleMainPage2_ErrorTestTrigger);
            }
        }

        private com.amalto.workbench.utils.MDMServerDef getServerDef() {
            XObjectEditorInput2 editorInput = (XObjectEditorInput2) getEditorInput();
            IRepositoryViewObject viewObject = editorInput.getViewObject();
            MDMServerObjectItem item = (MDMServerObjectItem) viewObject.getProperty().getItem();
            MDMServerObject mdmServerObject = item.getMDMServerObject();
            MDMServerDef lastServerDef = mdmServerObject.getLastServerDef();
            lastServerDef = openServerDialog(lastServerDef);
            if (lastServerDef == null) {
                return null;
            }

            return transform(lastServerDef);
        }

        public MDMServerDef openServerDialog(MDMServerDef serverObject) {
            SelectServerDefDialog dlg = new SelectServerDefDialog(getSite().getShell());
            dlg.create();
            dlg.setSelectServer(serverObject);
            if (dlg.open() == IDialogConstants.OK_ID) {
                MDMServerDef serverDef = dlg.getSelectedServerDef();

                return serverDef;
            }
            return null;
        }

        private com.amalto.workbench.utils.MDMServerDef transform(MDMServerDef serverDef) {
            com.amalto.workbench.utils.MDMServerDef mdmServerDef = new com.amalto.workbench.utils.MDMServerDef();
            mdmServerDef.setProtocol(serverDef.getProtocol());
            mdmServerDef.setHost(serverDef.getHost());
            mdmServerDef.setPort(serverDef.getPort());
            mdmServerDef.setName(serverDef.getName());
            mdmServerDef.setPasswd(serverDef.getPasswd());
            mdmServerDef.setPath(serverDef.getPath());
            mdmServerDef.setUniverse(serverDef.getUniverse());
            mdmServerDef.setUser(serverDef.getUser());

            return mdmServerDef;
        }

        private boolean checkConnection(String endpointaddress, String username, String password, String universe) {
            ILegendServerDefService serverDefService = (ILegendServerDefService) GlobalServiceRegister.getDefault().getService(
                    ILegendServerDefService.class);
            return serverDefService.checkServerDefConnection(endpointaddress, username, password, universe);
        }
    }

}
