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
package org.talend.mdm.repository.ui.wizards.imports.viewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;
import org.talend.mdm.repository.ui.widgets.AbstractNodeCheckTreeViewer;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.ServerTreeContentProvider;
import com.amalto.workbench.providers.ServerTreeLabelProvider;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.widgets.FilteredCheckboxTree;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class TreeObjectCheckTreeViewer extends AbstractNodeCheckTreeViewer {

    class TreeObjectContentProvider extends ServerTreeContentProvider {

        /**
         * DOC hbhong TreeObjectContentProvider constructor comment.
         * 
         * @param site
         * @param invisibleRoot
         */
        public TreeObjectContentProvider(TreeParent invisibleRoot) {
            super(null, invisibleRoot);
        }

        @Override
        public Object[] getElements(Object parent) {

            return getChildren(parent);
        }

    }

    private ServerTreeContentProvider contentProvider;

    Collection<TreeObject> repositoryNodes = new ArrayList<TreeObject>();

    private boolean isOverWrite = true;

    /**
     * DOC hbhong TreeObjectCheckTreeViewer constructor comment.
     * 
     * @param serverRoot
     */
    public TreeObjectCheckTreeViewer(TreeParent serverRoot) {
        super(serverRoot);
    }

    protected void createTreeViewer(Composite itemComposite) {
        filteredCheckboxTree = new FilteredCheckboxTree(itemComposite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI) {

            ContainerCheckedTreeViewer treeViewer;

            @Override
            protected CheckboxTreeViewer doCreateTreeViewer(Composite parent, int style) {
                treeViewer = new ContainerCheckedTreeViewer(parent);
                contentProvider = new TreeObjectContentProvider(serverRoot);
                treeViewer.setContentProvider(contentProvider);
                treeViewer.setLabelProvider(new ServerTreeLabelProvider());
                treeViewer.setInput(serverRoot);
                return treeViewer;
            }

            @Override
            protected boolean isNodeCollectable(TreeItem item) {
                return false;
            }

            @Override
            protected void refreshCompleted() {
                treeViewer.expandToLevel(3);
                restoreCheckedElements();
            }
        };
        filteredCheckboxTree.getViewer().addFilter(new ViewerFilter() {

            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element) {
                TreeObject node = (TreeObject) element;
                return filterRepositoryNode(node, isOverWrite);
            }
        });
    }

    protected void filterCheckedObjects(Object[] selected, List<Object> ret) {

        for (int i = 0; i < selected.length; i++) {
            ret.add(selected[i]);
        }
    }

    @Override
    public void refresh() {
        if (serverRoot != null) {
            repositoryNodes.addAll(Util.getChildrenObj(serverRoot));

            ((CheckboxTreeViewer) viewer).setCheckedElements(repositoryNodes.toArray());
        }
    }

    public void setRoot(TreeParent root) {
        contentProvider.setRoot(root);
    }

    public boolean isOverWrite() {
        return this.isOverWrite;
    }

    public void setOverWrite(boolean isOverWrite) {
        this.isOverWrite = isOverWrite;
    }
}
