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
package com.amalto.workbench.actions;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.talend.mdm.commmon.util.webapp.XSystemObjects;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.WorkbenchClipboard;
import com.amalto.workbench.views.ServerView;

public class CopyXObjectAction extends Action {

    private static Log log = LogFactory.getLog(CopyXObjectAction.class);

    private ServerView view = null;

    /*
     * public CopyXObjectAction(TreeObject xobject, IWorkbenchPage page) { super(); this.xobject = xobject; this.page =
     * page; setDetails(); }
     */

    public CopyXObjectAction(ServerView view) {
        super();
        this.view = view;
        setDetails();
    }

    private void setDetails() {
        setImageDescriptor(ImageCache.getImage(EImage.COPY.getPath()));
        setText(Messages.CopyXObjectAction__Copy);
        setToolTipText(Messages.bind(Messages.CopyXObjectAction_AtionTip, IConstants.TALEND));
    }

    public void run() {
        try {
            super.run();
            if (this.view == null) {
                MessageDialog.openError(view.getSite().getShell(), Messages.CopyXObjectAction_CopyError,
                        Messages.CopyXObjectAction_ErrorMsg1);
                return;
            }

            WorkbenchClipboard.getWorkbenchClipboard().reset();

            IStructuredSelection selection = (IStructuredSelection) view.getViewer().getSelection();
            for (Iterator<TreeObject> iter = selection.iterator(); iter.hasNext();) {
                TreeObject xobject = iter.next();

                if (!xobject.isXObject())
                    continue;
                if (XSystemObjects.isXSystemObject(xobject.getType(), xobject.getDisplayName()))
                    continue;
                WorkbenchClipboard.getWorkbenchClipboard().add(xobject);

                /*
                 * // Access to server and get port XtentisPort port = Util.getPort(
                 * "http://"+xobject.getServer()+"/talend/TalendPort", xobject.getUsername(), xobject.getPassword() );
                 * 
                 * switch(xobject.getType()) { case TreeObject.SOURCE: WSSource wsSource = port.getSource(new
                 * WSGetSource((WSSourcePK)xobject.getWsKey()) ); xobject.setWsObject(wsSource); break; case
                 * TreeObject.DESTINATION: WSDestination wsDestination = port.getDestination(new
                 * WSGetDestination((WSDestinationPK)xobject.getWsKey()) ); xobject.setWsObject(wsDestination); break;
                 * case TreeObject.DATA_MODEL: WSDataModel wsDataModel = port.getDataModel(new
                 * WSGetDataModel((WSDataModelPK)xobject.getWsKey())); xobject.setWsObject(wsDataModel); break; case
                 * TreeObject.INBOUND_ADAPTOR: WSInboundAdaptor wsInboundAdaptor = port.getInboundAdaptor(new
                 * WSGetInboundAdaptor((WSInboundAdaptorPK)xobject.getWsKey())); xobject.setWsObject(wsInboundAdaptor);
                 * break; case TreeObject.INBOUND_PLUGIN: WSInboundPlugin wsInboundPlugin = port.getInboundPlugin(new
                 * WSGetInboundPlugin((WSInboundPluginPK)xobject.getWsKey()) ); xobject.setWsObject(wsInboundPlugin);
                 * break; case TreeObject.OUTBOUND_ADAPTOR: WSOutboundAdaptor wsOutboundAdaptor =
                 * port.getOutboundAdaptor(new WSGetOutboundAdaptor((WSOutboundAdaptorPK)xobject.getWsKey()));
                 * xobject.setWsObject(wsOutboundAdaptor); break; case TreeObject.OUTBOUND_PLUGIN: WSOutboundPlugin
                 * wsOutboundPlugin = port.getOutboundPlugin(new
                 * WSGetOutboundPlugin((WSOutboundPluginPK)xobject.getWsKey()) ); xobject.setWsObject(wsOutboundPlugin);
                 * break; case TreeObject.VIEW: WSView wsView = port.getView(new
                 * WSGetView((WSViewPK)xobject.getWsKey())); xobject.setWsObject(wsView); break; case
                 * TreeObject.DATA_CLUSTER: WSDataCluster wsDataCluster = port.getDataCluster(new
                 * WSGetDataCluster((WSDataClusterPK)xobject.getWsKey()) ); xobject.setWsObject(wsDataCluster); break;
                 * case TreeObject.STORED_PROCEDURE: WSStoredProcedure wsStoredProcedure = port.getStoredProcedure(new
                 * WSGetStoredProcedure((WSStoredProcedurePK)xobject.getWsKey()) );
                 * xobject.setWsObject(wsStoredProcedure); break; case TreeObject.ROLE: WSRole wsRole = port.getRole(new
                 * WSGetRole((WSRolePK)xobject.getWsKey()) ); xobject.setWsObject(wsRole); break; case
                 * TreeObject.ROUTING_RULE: WSRoutingRule wsRoutingRule = port.getRoutingRule(new
                 * WSGetRoutingRule((WSRoutingRulePK)xobject.getWsKey()) ); xobject.setWsObject(wsRoutingRule); break;
                 * case TreeObject.TRANSFORMER: WSTransformer wsTranformer = port.getTransformer(new
                 * WSGetTransformer((WSTransformerPK)xobject.getWsKey())); xobject.setWsObject(wsTranformer); break;
                 * case TreeObject.MENU: WSMenu wsMenu = port.getMenu(new WSGetMenu((WSMenuPK)xobject.getWsKey()));
                 * xobject.setWsObject(wsMenu); break; default: MessageDialog.openError(view.getSite().getShell(),
                 * "Error", "Unknown "+IConstants.TALEND+" Object Type: "+xobject.getType()); return; }//switch
                 */
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(view.getSite().getShell(), Messages._Error,
                    Messages.bind(Messages.CopyXObjectAction_ErrorMsg2, e.getLocalizedMessage()));
        }
    }

    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

}
