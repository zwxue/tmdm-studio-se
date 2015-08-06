// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ProcessItem;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.repository.RepositoryViewObject;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.documentation.ERepositoryActionName;
import org.talend.repository.editor.RepositoryEditorInput;
import org.talend.repository.model.RepositoryNode;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class JobResourceListener implements PropertyChangeListener {

    static Logger log = Logger.getLogger(JobResourceListener.class);

    public JobResourceListener() {

    }

    private boolean isWorkInUI() {
        try {
            return PlatformUI.getWorkbench() != null;
        } catch (Exception e) {
            return false;
        }
    }

    private static final String JOB_EDITOR_ID = "org.talend.designer.core.ui.MultiPageTalendEditor"; //$NON-NLS-1$

    private boolean isOpenInEditor(IRepositoryViewObject vObj) {
        if (!ProxyRepositoryFactory.getInstance().isFullLogonFinished()) {
            return false;
        }
        if (PlatformUI.getWorkbench() == null || PlatformUI.getWorkbench().getActiveWorkbenchWindow() == null
                || PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() == null) {
            return false;
        }
        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IEditorReference[] editorReferences = activePage.getEditorReferences();
        for (IEditorReference ref : editorReferences) {
            String editorId = ref.getId();
            if (ref != null && JOB_EDITOR_ID.equals(editorId)) {
                try {
                    IEditorInput editorInput = ref.getEditorInput();
                    if (editorInput instanceof RepositoryEditorInput) {
                        RepositoryNode repositoryNode = ((RepositoryEditorInput) editorInput).getRepositoryNode();
                        if (repositoryNode != null && repositoryNode.getObject().equals(vObj)) {
                            return true;
                        }
                    }
                } catch (PartInitException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
     */
    public void propertyChange(PropertyChangeEvent event) {
        if (!isWorkInUI() || !ProxyRepositoryFactory.getInstance().isFullLogonFinished()) {
            return;
        }
        boolean jobSaved = false;
        boolean jobCreated = false;

        // only monitor the jobs
        if (!(event.getNewValue() instanceof ProcessItem)) {
            return;
        }

        String propertyName = event.getPropertyName();
        if (propertyName.equals(ERepositoryActionName.SAVE.getName())) {
            jobSaved = true;
        }

        if (propertyName.equals(ERepositoryActionName.CREATE.getName())
                || propertyName.equals(ERepositoryActionName.IMPORT.getName())) {
            jobCreated = true;
        }
        if (!jobSaved && !jobCreated) {
            // if the operation is not job saved or created, just don't do anything.
            return;
        }

        final Item item = (Item) event.getNewValue();

        if (jobCreated) {
            CommandManager.getInstance().pushCommand(ICommand.CMD_ADD, item.getProperty().getId(),
                    item.getProperty().getDisplayName());

            removeLastServerInfo(item);
        }

        if (jobSaved) {
            // create a new object but without GUI info since it won't be used here certainly
            IRepositoryViewObject viewObject = new RepositoryViewObject(item.getProperty(), true);
            MDMServerDef serverDef = RepositoryResourceUtil.getLastServerDef(viewObject);
            if (viewObject != null && serverDef != null && isOpenInEditor(viewObject)) {
                CommandManager.getInstance().pushCommand(ICommand.CMD_MODIFY, viewObject);
                IRepositoryViewObject cacheViewObject = ContainerCacheService.get(item.getProperty());
                if (cacheViewObject != null) {
                    viewObject = cacheViewObject;
                }
                MDMRepositoryView.show().getCommonViewer().refresh(viewObject);
            }
        }
    }

    private void removeLastServerInfo(final Item item) {
        Property property = item.getProperty();
        EMap additionalProperties = property.getAdditionalProperties();
        if (additionalProperties != null) {
            RepositoryResourceUtil.setLastServerDef(item, null);
            ProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();
            try {
                factory.save(item, true);
            } catch (PersistenceException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

}
