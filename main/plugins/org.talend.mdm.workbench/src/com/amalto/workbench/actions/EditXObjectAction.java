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
package com.amalto.workbench.actions;

import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.amalto.workbench.editors.xsdeditor.XSDEditorUtil;
import com.amalto.workbench.exadapter.ExAdapterManager;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.TMDMService;
import com.amalto.workbench.webservices.WsDataCluster;
import com.amalto.workbench.webservices.WsDataClusterPK;
import com.amalto.workbench.webservices.WsDataModel;
import com.amalto.workbench.webservices.WsDataModelPK;
import com.amalto.workbench.webservices.WsGetDataCluster;
import com.amalto.workbench.webservices.WsGetDataModel;
import com.amalto.workbench.webservices.WsGetMenu;
import com.amalto.workbench.webservices.WsGetRoutingRule;
import com.amalto.workbench.webservices.WsGetStoredProcedure;
import com.amalto.workbench.webservices.WsGetTransformerV2;
import com.amalto.workbench.webservices.WsGetView;
import com.amalto.workbench.webservices.WsMenu;
import com.amalto.workbench.webservices.WsMenuPK;
import com.amalto.workbench.webservices.WsRoutingRule;
import com.amalto.workbench.webservices.WsRoutingRulePK;
import com.amalto.workbench.webservices.WsStoredProcedure;
import com.amalto.workbench.webservices.WsStoredProcedurePK;
import com.amalto.workbench.webservices.WsTransformerV2;
import com.amalto.workbench.webservices.WsTransformerV2PK;
import com.amalto.workbench.webservices.WsView;
import com.amalto.workbench.webservices.WsViewPK;

public class EditXObjectAction extends Action {

    private static Log log = LogFactory.getLog(EditXObjectAction.class);

    private TreeObject xobject = null;

    private IWorkbenchPage page = null;

    private IEditXObjectActionExAdapter exAdapter;

    public EditXObjectAction(TreeObject xobject, IWorkbenchPage page) {
        super();
        this.xobject = xobject;
        this.page = page;
        setDetails();
        this.exAdapter = ExAdapterManager.getAdapter(this, IEditXObjectActionExAdapter.class);
    }

    private void setDetails() {
        setImageDescriptor(ImageCache.getImage("icons/edit.gif"));//$NON-NLS-1$
        setText(Messages.EditXObjectAction_Edit);
        setToolTipText(Messages.bind(Messages.EditXObjectAction_ActionTip, IConstants.TALEND));
    }

    @Override
    public void run() {
        try {
            super.run();

            if (xobject == null || !xobject.isXObject()) {
                return;
            }

            // Access to server and get port
            TMDMService service = Util.getMDMService(new URL(xobject.getEndpointAddress()), xobject.getUniverse(),
                    xobject.getUsername(),
                    xobject.getPassword());

            switch (xobject.getType()) {
            case TreeObject.DATA_MODEL:
                WsDataModel wsDataModel = service.getDataModel(new WsGetDataModel((WsDataModelPK) xobject.getWsKey()));
                xobject.setWsObject(wsDataModel);
                XSDEditorUtil.openDataModel(xobject, false);
                return;
            case TreeObject.VIEW:
                WsView wsView = service.getView(new WsGetView((WsViewPK) xobject.getWsKey()));
                xobject.setWsObject(wsView);
                break;
            case TreeObject.DATA_CLUSTER:
                WsDataCluster wsDataCluster = service.getDataCluster(new WsGetDataCluster((WsDataClusterPK) xobject.getWsKey()));
                xobject.setWsObject(wsDataCluster);
                break;
            case TreeObject.STORED_PROCEDURE:
                WsStoredProcedure wsStoredProcedure = service.getStoredProcedure(new WsGetStoredProcedure(
                        (WsStoredProcedurePK) xobject.getWsKey()));
                xobject.setWsObject(wsStoredProcedure);
                break;

            case TreeObject.ROUTING_RULE:
                WsRoutingRule wsRoutingRule = service.getRoutingRule(new WsGetRoutingRule((WsRoutingRulePK) xobject.getWsKey()));
                xobject.setWsObject(wsRoutingRule);
                break;
            case TreeObject.TRANSFORMER:
                WsTransformerV2 wsTranformer = service.getTransformerV2(new WsGetTransformerV2((WsTransformerV2PK) xobject
                        .getWsKey()));
                xobject.setWsObject(wsTranformer);
                break;
            case TreeObject.MENU:
                WsMenu wsMenu = service.getMenu(new WsGetMenu((WsMenuPK) xobject.getWsKey()));
                xobject.setWsObject(wsMenu);
                break;
            case TreeObject.SERVICE_CONFIGURATION:
                break;
            case TreeObject.JOB_REGISTRY:
                // System.out.println("JOB_REGISTRY "+ xobject.getDisplayName());
                break;
            case TreeObject.JOB:

                // System.out.println("JOB "+ xobject.getDisplayName()+" "+xobject.getWsKey());
                xobject.setWsObject(xobject.getDisplayName());
                break;

            case TreeObject.ROLE:
            case TreeObject.UNIVERSE:
            case TreeObject.SYNCHRONIZATIONPLAN:
                if (exAdapter != null) {
                    exAdapter.run(service, xobject);
                }
                break;

            case TreeObject.RESOURCES:
            case TreeObject.CUSTOM_TYPE:
            case TreeObject.DATA_MODEL_RESOURCE:
            case TreeObject.DATA_MODEL_TYPES_RESOURCE:
            case TreeObject.CUSTOM_TYPES_RESOURCE:
            case TreeObject.PICTURES_RESOURCE:
                break;
            default:
                MessageDialog.openError(getShell(), Messages._Error,
                        Messages.bind(Messages.EditXObjectAction_ErrorMsg1, IConstants.TALEND, xobject.getType()));
                return;
            }// switch

            if (page == null) {
                this.page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            }

            this.page.openEditor(new XObjectEditorInput(xobject, xobject.getDisplayName()),
                    "com.amalto.workbench.editors.XObjectEditor"); //$NON-NLS-1$

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            if (!Util.handleConnectionException(getShell(), e, Messages.EditXObjectAction_ErrorMsg2)) {
                MessageDialog.openError(getShell(), Messages._Error,
                        Messages.bind(Messages.EditXObjectAction_ErrorMsg2, e.getLocalizedMessage()));
            }
        }
    }

    private Shell getShell() {
        return Display.getDefault().getActiveShell();
    }

    @Override
    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

}
