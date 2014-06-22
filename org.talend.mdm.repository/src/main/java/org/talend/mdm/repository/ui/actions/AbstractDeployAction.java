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
package org.talend.mdm.repository.ui.actions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.dialogs.message.MultiStatusDialog;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public abstract class AbstractDeployAction extends AbstractRepositoryAction {

    private static final ImageDescriptor DEPLOY_IMG = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "/icons/deploy.png"); //$NON-NLS-1$

    protected AbstractDeployAction(String text) {
        super(text);
        setImageDescriptor(DEPLOY_IMG);
    }

    protected IStatus deploy(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs, int defaultCmdType) {
        return DeployService.getInstance().deploy(serverDef, viewObjs, defaultCmdType);
    }

    protected void showDeployStatus(IStatus status) {
        String prompt;
        int count = 0;
        if (status.isMultiStatus()) {
            for (IStatus child : status.getChildren()) {
                if (child.isMultiStatus()) {
                    count += child.getChildren().length;
                } else {
                    count++;
                }
            }
        }
        if (status.getSeverity() < IStatus.ERROR) {
            prompt = Messages.bind(Messages.AbstractDeployAction_deployMessage, count);
        } else {
            prompt = Messages.bind(Messages.AbstractDeployAction_deployFailure, count);

        }
        MultiStatusDialog dialog = new MultiStatusDialog(getShell(), prompt, status);
        dialog.open();

    }

    public String getGroupName() {
        return GROUP_DEPLOY;
    }

    protected void updateChangedStatus(IStatus status) {
        DeployService.getInstance().updateChangedStatus(status);
    }

    protected void updateLastServer(IStatus status, IProgressMonitor monitor) {
        DeployService.getInstance().updateLastServer(status, monitor);
        refreshDeployedViewObjects();
    }

    protected void refreshDeployedViewObjects() {
        List<IRepositoryViewObject> viewObjs = getSelectedRepositoryViewObject();
        for (IRepositoryViewObject viewObj : viewObjs) {
            commonViewer.refresh(viewObj);
        }
    }

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    protected List<IRepositoryViewObject> getSelectedRepositoryViewObject() {
        List<IRepositoryViewObject> viewObjs = new LinkedList<IRepositoryViewObject>();
        for (Object obj : getSelectedObject()) {
            if (obj instanceof IRepositoryViewObject)
                viewObjs.add((IRepositoryViewObject) obj);
        }
        reorderRepositoryViewObjects(viewObjs);
        return viewObjs;
    }

    protected void reorderRepositoryViewObjects(List<IRepositoryViewObject> viewObjs) {
        List<IRepositoryViewObject> dataModelObjs = new LinkedList<IRepositoryViewObject>();
        for (Iterator<IRepositoryViewObject> il = viewObjs.iterator(); il.hasNext();) {
            IRepositoryViewObject viewObj = il.next();
            if (viewObj.getRepositoryObjectType() == IServerObjectRepositoryType.TYPE_DATAMODEL) {
                dataModelObjs.add(viewObj);
                il.remove();
            }
        }
        if (!dataModelObjs.isEmpty()) {
            viewObjs.addAll(0, dataModelObjs);
        }
    }

    protected void doSaveEditorsThing() {
        List<IRepositoryViewObject> viewObjs = getSelectedRepositoryViewObject();
        
        boolean isEditing = false;
        
        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        try {
            for (IEditorReference editorReference : activePage.getEditorReferences()) {
                IRepositoryViewObject viewObject = ((IRepositoryViewEditorInput) editorReference.getEditorInput()).getViewObject();
                if (viewObjs.contains(viewObject))
                {
                    isEditing = true;
                    break;
                }
            }
            
            if (isEditing) {
                activePage.saveAllEditors(true);
            }
        } catch (PartInitException e1) {
            e1.printStackTrace();
        }
    }

}
