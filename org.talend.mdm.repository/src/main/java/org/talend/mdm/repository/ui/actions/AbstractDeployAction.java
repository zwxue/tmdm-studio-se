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
package org.talend.mdm.repository.ui.actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.jface.resource.ImageDescriptor;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.core.service.DeployService.DeployStatus;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public abstract class AbstractDeployAction extends AbstractRepositoryAction {

    private static Logger log = Logger.getLogger(AbstractDeployAction.class);

    private static final ImageDescriptor DEPLOY_IMG = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "/icons/deploy.png"); //$NON-NLS-1$

    // private static Logger log = Logger.getLogger(AbstractDeployAction.class);
    protected AbstractDeployAction(String text) {
        super(text);
        setImageDescriptor(DEPLOY_IMG);
    }

    protected IStatus deploy(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs) {
        return DeployService.getInstance().deploy(serverDef, viewObjs);
    }

    protected void showDeployStatus(IStatus status) {
        MultiStatusDialog dialog = new MultiStatusDialog(getShell(), status.getChildren().length
                + Messages.AbstractDeployAction_deployMessage, status);
        dialog.open();
    }

    public String getGroupName() {
        return GROUP_DEPLOY;
    }

    protected void updateChangedStatus(IStatus status) {
        if (status.isMultiStatus()) {
            for (IStatus childStatus : status.getChildren()) {
                DeployStatus deployStatus = null;
                if (childStatus instanceof DeployStatus) {
                    deployStatus = (DeployStatus) childStatus;
                } else if (childStatus instanceof MultiStatus) {
                    deployStatus = (DeployStatus) ((MultiStatus) childStatus).getChildren()[0];
                }

                if (deployStatus.isOK()) {
                    CommandManager.getInstance().removeCommandStack(deployStatus.getCommand().getCommandId());
                }

            }
        }
    }

    protected void updateLastServer(IStatus status, MDMServerDef serverDef) {
        if (status.isMultiStatus()) {
            for (IStatus childStatus : status.getChildren()) {
                if (childStatus.isOK()) {
                    DeployStatus deployStatus = null;
                    if (childStatus instanceof DeployStatus) {
                        deployStatus = (DeployStatus) childStatus;
                    } else if (childStatus instanceof MultiStatus) {
                        deployStatus = (DeployStatus) ((MultiStatus) childStatus).getChildren()[0];
                    }
                    Item item = deployStatus.getCommand().getViewObject().getProperty().getItem();

                    if (item instanceof MDMServerObjectItem)
                        saveLastServer((MDMServerObjectItem) item, serverDef);
                }
            }
        }
    }

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    private void saveLastServer(MDMServerObjectItem item, MDMServerDef serverDef) {
        MDMServerObject mdmServerObject = item.getMDMServerObject();
        mdmServerObject.setLastServerDef(serverDef);
        try {
            factory.save(item);
            refreshParent();
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
    }
}
