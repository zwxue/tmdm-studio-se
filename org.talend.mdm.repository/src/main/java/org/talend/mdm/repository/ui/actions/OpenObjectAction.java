// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2012 Talend �C www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.mdm.repository.ui.actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IRepositoryNodeActionProvider;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryViewGlobalActionHandler;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.service.IMDMSVNProviderService;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.models.WSRootRepositoryObject;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;
import org.talend.repository.model.ERepositoryStatus;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.EXtentisObjects;
import com.amalto.workbench.utils.UserInfo;
import com.amalto.workbench.webservices.WSDataClusterPK;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class OpenObjectAction extends AbstractRepositoryAction {

    private static Logger log = Logger.getLogger(OpenObjectAction.class);

    private List<Object> selObjects;

    public void setSelObjects(List<Object> selObjects) {
        this.selObjects = selObjects;
    }

    /**
     * DOC hbhong OpenObjectAction constructor comment.
     * 
     * @param text
     */
    public OpenObjectAction() {
        super(Messages.OpenObjectAction_open);
        setId(IRepositoryViewGlobalActionHandler.OPEN);
        setActionDefinitionId(IRepositoryViewGlobalActionHandler.OPEN);
    }

    private IWorkbenchPage page = null;

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    @Override
    protected boolean isLocked() {

        List<Object> selectedObject = getSelectedObject();
        if (!selectedObject.isEmpty()) {
            Object object = selectedObject.get(0);

            if (object instanceof IRepositoryViewObject) {
                IRepositoryViewObject viewObj = (IRepositoryViewObject) object;
                ERepositoryStatus status = factory.getStatus(viewObj);
                if (status == ERepositoryStatus.LOCK_BY_USER || status == ERepositoryStatus.LOCK_BY_OTHER)
                    return !status.isEditable();

            }
        }

        return false;

    }

    private void updateEditorInputVersionInfo(IRepositoryViewEditorInput editorInput, IRepositoryViewObject viewObject) {
        String version = viewObject.getVersion();
        try {
            if (!factory.isLocalConnectionProvider()) {
                IMDMSVNProviderService service = (IMDMSVNProviderService) GlobalServiceRegister.getDefault().getService(
                        IMDMSVNProviderService.class);
                if (service != null) {
                    if (service.isProjectInSvnMode()) {
                        String revisionNumStr = service.getCurrentSVNRevision(viewObject);
                        if (revisionNumStr != null) {
                            revisionNumStr = ".r" + revisionNumStr; //$NON-NLS-1$
                            version += revisionNumStr;
                        }
                    }
                }

            }
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }

        editorInput.setVersion(version);
    }

    protected void doRun() {
        List<Object> sels = getSelectedObject();
        if (selObjects != null) {
            sels = selObjects;
        }
        if (sels.isEmpty())
            return;
        Object obj = sels.get(0);
        if (obj instanceof IRepositoryViewObject) {
            if (obj instanceof WSRootRepositoryObject)
                return;
            IRepositoryViewObject viewObject = (IRepositoryViewObject) obj;

            Item item = viewObject.getProperty().getItem();
            if (item instanceof ContainerItem) {
                if (viewObject.getRepositoryObjectType().equals(IServerObjectRepositoryType.TYPE_SERVICECONFIGURATION)) {// service
                                                                                                                         // configuration
                    MDMServerDef serverDef = openServerDialog(null);
                    openServiceConfig(serverDef);
                } else {
                    getCommonViewer().expandToLevel(obj, 1);
                }
            } else {
                openItem(viewObject);
            }
        }

    }

    private void openServiceConfig(MDMServerDef serverDef) {
        TreeParent serverRoot = getServerRoot(serverDef);
        TreeObject xobject = new TreeObject(EXtentisObjects.ServiceConfiguration.getDisplayName(), serverRoot,
                TreeObject.SERVICE_CONFIGURATION, null, null);
        try {
            if (page == null)
                this.page = getCommonViewer().getCommonNavigator().getSite().getWorkbenchWindow().getActivePage();
            page.openEditor(new XObjectEditorInput(xobject, xobject.getDisplayName()),
                    "com.amalto.workbench.editors.XObjectEditor"); //$NON-NLS-1$
        } catch (PartInitException e) {
            log.error(e.getMessage(), e);
        }
    }

    private void openItem(IRepositoryViewObject viewObject) {
        Item item = viewObject.getProperty().getItem();
        IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(item);
        if (configuration != null) {
            IRepositoryNodeActionProvider actionProvider = configuration.getActionProvider();
            if (actionProvider != null) {
                IRepositoryViewEditorInput editorInput = actionProvider.getOpenEditorInput(viewObject);
                if (editorInput != null) {
                    if (page == null)
                        this.page = getCommonViewer().getCommonNavigator().getSite().getWorkbenchWindow().getActivePage();
                    // do extra action
                    MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
                    boolean selected = doSelectServer(serverObject, editorInput);
                    if (!selected)
                        return;
                    try { // svn lock
                        ERepositoryStatus status = factory.getStatus(item);
                        if (factory.isEditableAndLockIfPossible(item)) {
                            getCommonViewer().refresh(viewObject);
                        }
                        //
                        editorInput.setReadOnly(status == ERepositoryStatus.LOCK_BY_OTHER
                                || status == ERepositoryStatus.READ_ONLY);

                        if (!editorInput.isReadOnly()) {
                            editorInput.setReadOnly(item.getState().isDeleted());
                        }
                        updateEditorInputVersionInfo(editorInput, viewObject);
                        this.page.openEditor(editorInput, editorInput.getEditorId());
                    } catch (PartInitException e) {
                        log.error(e.getMessage(), e);
                    }
                } else {
                    AbstractRepositoryAction openAction = actionProvider.getOpenAction(viewObject);
                    if (openAction != null) {
                        openAction.selectionChanged(getStructuredSelection());
                        openAction.run();
                    }
                }
            }
        }
    }

    @Override
    protected boolean needValidateLockedObject() {
        return true;
    }

    public String getGroupName() {
        // this action not be shown in context menu,so Nothing need to do in here
        return null;
    }

    public TreeParent getServerRoot(MDMServerDef serverDef) {
        String serverName = serverDef.getHost();
        String universe = serverDef.getUniverse();
        String username = serverDef.getUser();
        String password = serverDef.getPasswd();
        String endpointaddress = serverDef.getUrl();
        TreeParent serverRoot = new TreeParent(serverName, null, TreeObject._SERVER_, endpointaddress, ("".equals(universe) ? ""//$NON-NLS-1$//$NON-NLS-2$
                : universe + "/") + username + ":" + (password == null ? "" : password));//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
        UserInfo user = new UserInfo();
        user.setUsername(username);
        user.setPassword(password);
        user.setServerUrl(endpointaddress);
        user.setUniverse(universe);

        serverRoot.setUser(user);
        return serverRoot;
    }

    public boolean doSelectServer(MDMServerObject serverObject, IRepositoryViewEditorInput editorInput) {
        if (serverObject.getType() == TreeObject.DATA_CLUSTER) {// Data Cluster
            MDMServerDef serverDef = openServerDialog(serverObject.getLastServerDef());
            if (serverDef != null) {
                serverDef = serverDef.getDecryptedServerDef();
                XObjectBrowserInput input = (XObjectBrowserInput) editorInput;
                TreeObject xobject = (TreeObject) input.getModel();

                TreeParent serverRoot = getServerRoot(serverDef);
                xobject.setWsKey(new WSDataClusterPK(xobject.getWsKey().toString()));
                xobject.setServerRoot(serverRoot);
                return true;
            }
            return false;
        }
        return true;
    }

    public MDMServerDef openServerDialog(MDMServerDef serverObject) {
        SelectServerDefDialog dlg = new SelectServerDefDialog(getShell());
        dlg.create();
        dlg.setSelectServer(serverObject);
        if (dlg.open() == IDialogConstants.OK_ID) {
            MDMServerDef serverDef = dlg.getSelectedServerDef();
            return serverDef;
        }
        return null;
    }

}
