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
package org.talend.mdm.repository.core.impl.jobmodel;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.editor.RepositoryEditorInput;
import org.talend.repository.model.RepositoryNode;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class JobResourceListener implements IResourceChangeListener {

    private static final String PROCESS_DIR = "process"; //$NON-NLS-1$

    static Logger log = Logger.getLogger(JobResourceListener.class);

    IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {

        public boolean visit(IResourceDelta delta) {
            if ((delta.getKind() & IResourceDelta.CHANGED) != 0) {
                IResource resource = delta.getResource();
                IPath path = resource.getProjectRelativePath();
                String segment = path.segment(0);
                if (segment != null) {
                    if (!segment.equals(PROCESS_DIR))
                        return false;
                    if (resource.getType() == IResource.FILE) {
                        if ("screenshot".equalsIgnoreCase(resource.getFileExtension()) && resource.exists()) {//$NON-NLS-1$
                            String name = resource.getName();
                            int index = name.lastIndexOf("_"); //$NON-NLS-1$
                            if (index > 0) {
                                name = name.substring(0, index);

                                IRepositoryViewObject viewObject = RepositoryResourceUtil.findViewObjectByName(
                                        ERepositoryObjectType.PROCESS, name);
                                MDMServerDef serverDef = RepositoryResourceUtil.getLastServerDef(viewObject);
                                if (viewObject != null && serverDef != null && isOpenInEditor(viewObject)) {
                                    CommandManager.getInstance().pushCommand(ICommand.CMD_MODIFY, viewObject);
                                    MDMRepositoryView.show().getCommonViewer().refresh(viewObject);
                                }
                            }

                        }
                        return false;
                    }
                }
            }

            return true;
        }
    };

    private boolean isOpenInEditor(IRepositoryViewObject vObj) {
        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IEditorReference[] editorReferences = activePage.getEditorReferences();
        for (IEditorReference ref : editorReferences) {
            if (ref != null) {
                try {
                    IEditorInput editorInput = ref.getEditorInput();
                    if (editorInput instanceof RepositoryEditorInput) {
                        RepositoryNode repositoryNode = ((RepositoryEditorInput) editorInput).getRepositoryNode();
                        if (repositoryNode != null) {
                            return repositoryNode.getObject().equals(vObj);
                        }
                    }
                } catch (PartInitException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return false;
    }

    public void resourceChanged(IResourceChangeEvent event) {
        if (!ProxyRepositoryFactory.getInstance().isFullLogonFinished())
            return;
        IResourceDelta delta = event.getDelta();
        try {
            delta.accept(visitor);
        } catch (CoreException e) {
            log.error(e.getMessage(), e);
        }
    }

}
