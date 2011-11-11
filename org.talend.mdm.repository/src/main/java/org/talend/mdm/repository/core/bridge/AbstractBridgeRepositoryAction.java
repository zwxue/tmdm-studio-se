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
package org.talend.mdm.repository.core.bridge;

import org.eclipse.jface.viewers.ISelectionProvider;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.repository.ui.actions.AContextualAction;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public abstract class AbstractBridgeRepositoryAction extends AbstractRepositoryAction {

    private AContextualAction contextAction;

    public void setContextAction(AContextualAction contextAction) {
        this.contextAction = contextAction;
        contextAction.setSpecialSelection(selectionProvider);
        setText(contextAction.getText());
        setImageDescriptor(contextAction.getImageDescriptor());
    }

    private ISelectionProvider selectionProvider;

    public AbstractBridgeRepositoryAction(String name) {
        super(name);
        selectionProvider = new RepositoryViewSelectionProvider(this);
    }

    public AbstractBridgeRepositoryAction(AContextualAction cAction) {
        super(cAction.getText());
        setImageDescriptor(cAction.getImageDescriptor());
        selectionProvider = new RepositoryViewSelectionProvider(this);
        this.contextAction = cAction;
        this.contextAction.setSpecialSelection(selectionProvider);

    }

    @Override
    public void run() {
        contextAction.run();
        //        String name = "User action : " + getText(); //$NON-NLS-1$
        // RepositoryWorkUnit<Object> repositoryWorkUnit = new RepositoryWorkUnit<Object>(name, this) {
        //
        // @Override
        // protected void run() throws LoginException, PersistenceException {
        // boolean exist = false;
        // // if (node != null && node.getObject() != null) {
        // // Property property = node.getObject().getProperty();
        // // // only avoid NPE if item has been deleted in svn
        // // if (property != null) {
        // // exist = true;
        // // contextAction.doRun();
        // // }
        // // // if (!exist) {
        // // // refreshRelatedItem(getOldItem());
        // // // }
        // // } else {
        // contextAction.doRun();
        // // }
        // }
        // };
        // boolean avoidUnloadResources = false;
        // repositoryWorkUnit.setAvoidUnloadResources(avoidUnloadResources);
        // CoreRuntimePlugin.getInstance().getProxyRepositoryFactory().executeRepositoryWorkUnit(repositoryWorkUnit);
    }

    protected void refreshParentContainer() {
        Object object = getSelectedObject().get(0);
        if (object instanceof IRepositoryViewObject) {
            IRepositoryViewObject parent = ContainerCacheService.getParent((IRepositoryViewObject) object);
            if (parent != null && parent instanceof FolderRepositoryObject) {
                commonViewer.refresh(parent);
                commonViewer.expandToLevel(parent, 1);
            }
        }
    }

    protected void refreshCurrentContainer() {
        Object object = getSelectedObject().get(0);
        if (object instanceof FolderRepositoryObject) {
            commonViewer.refresh(object);
            commonViewer.expandToLevel(object, 1);

        }
    }
}
