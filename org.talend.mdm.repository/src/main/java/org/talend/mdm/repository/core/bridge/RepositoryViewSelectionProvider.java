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
package org.talend.mdm.repository.core.bridge;

import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.RepositoryNode;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryViewSelectionProvider implements ISelectionProvider {

    private final AbstractRepositoryAction action;

    public RepositoryViewSelectionProvider(AbstractRepositoryAction action) {
        this.action = action;
    }


    public void addSelectionChangedListener(ISelectionChangedListener listener) {

    }


    public ISelection getSelection() {
        List<Object> selectedObjects = action.getSelectedObject();
        if (!selectedObjects.isEmpty()) {
            Object object = selectedObjects.get(0);
            if (object instanceof IRepositoryViewObject) {
                IRepositoryViewObject viewObj = (IRepositoryViewObject) object;
                RepositoryNode node = RepositoryResourceUtil.convertToNode(viewObj);
                // IRepositoryViewObject parentViewObj = ContainerCacheService.getParent(viewObj);
                // if (parentViewObj != null) {
                // RepositoryNode parentNode = RepositoryResourceUtil.convertToNode(parentViewObj);
                // node.setParent(parentNode);
                // }
                return new StructuredSelection(node);
            }
        }
        return new StructuredSelection();
    }


    public void removeSelectionChangedListener(ISelectionChangedListener listener) {

    }

    public void setSelection(ISelection selection) {

    }

}
