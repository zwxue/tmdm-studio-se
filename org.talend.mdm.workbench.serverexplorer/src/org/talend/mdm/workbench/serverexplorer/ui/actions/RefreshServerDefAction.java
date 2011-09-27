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
package org.talend.mdm.workbench.serverexplorer.ui.actions;

import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.talend.core.model.repository.IRepositoryObject;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataFactory;
import org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem;
import org.talend.mdm.workbench.serverexplorer.core.ServerDefService;
import org.talend.mdm.workbench.serverexplorer.ui.views.ServerExplorer;

import com.amalto.workbench.utils.MDMServerDef;
import com.amalto.workbench.utils.MDMServerHelper;

public class RefreshServerDefAction implements IViewActionDelegate {

    private ServerExplorer serverExplorer;

    public void run(IAction action) {
        if (serverExplorer != null) {
            addServerDef();
            serverExplorer.refreshServerDefs();
        }
    }

    private void addServerDef() {
        List<MDMServerDef> servers = MDMServerHelper.getServers();
        List<IRepositoryViewObject> viewObjects = ServerDefService.getAllServerDefViewObjects();
        for (MDMServerDef server : servers) {
            boolean exist = false;
            for (IRepositoryViewObject object : viewObjects) {

                if (object instanceof IRepositoryObject) {
                    MDMServerDefItem mdmItem = getMDMItem((IRepositoryViewObject) object);
                    if (mdmItem != null) {
                        org.talend.mdm.repository.model.mdmmetadata.MDMServerDef serverDef = mdmItem.getServerDef();
                        if (server.getName().equals(serverDef.getName())) {
                            exist = true;
                        }
                    }
                }
            }
            if (!exist) {
                org.talend.mdm.repository.model.mdmmetadata.MDMServerDef serverDef = MdmmetadataFactory.eINSTANCE
                        .createMDMServerDef();
                serverDef.setName(server.getName());
                serverDef.setUrl(server.getUrl());
                serverDef.setUser(server.getUser());
                serverDef.setUniverse(server.getUniverse());
                serverDef.setPasswd(server.getPasswd());
                boolean saved = ServerDefService.createServerDef(serverDef);

                if (!saved) {
                    MessageDialog.openError(null, "Error", "Unable to create server definition in server explorer view");
                }
            }
        }
    }

    public void selectionChanged(IAction action, ISelection selection) {
    }

    public void init(IViewPart view) {

        if (view instanceof ServerExplorer) {
            serverExplorer = (ServerExplorer) view;
        }
    }

    private MDMServerDefItem getMDMItem(IRepositoryViewObject viewObject) {
        if (viewObject != null) {
            return (MDMServerDefItem) (viewObject.getProperty().getItem());
        }
        return null;
    }

}
