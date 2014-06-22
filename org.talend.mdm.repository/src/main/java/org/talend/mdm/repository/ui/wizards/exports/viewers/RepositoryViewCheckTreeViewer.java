// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.wizards.exports.viewers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.repository.RepositoryViewObject;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryContentProvider;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryLabelProvider;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.widgets.FilteredCheckboxTree;
import com.amalto.workbench.widgets.RepositoryCheckTreeViewer;

/**
 * DOC hywang class global comment. Detailled comment
 */
// HHB: can be remove after successfully test import and export item wizard
@Deprecated
public class RepositoryViewCheckTreeViewer extends RepositoryCheckTreeViewer {

    private MDMRepositoryView repositoryView = MDMRepositoryView.show();

    protected MDMRepositoryContentProvider contentProvider = new MDMRepositoryContentProvider();

    protected CheckboxMDMRepositoryTreeViewer checkboxViewer = null;

    private List<RepositoryViewObject> checkedNodes = null;

    public RepositoryViewCheckTreeViewer(IStructuredSelection selection) {
        super(selection);
    }

    // create a treeviewer with check box is required
    @Override
    protected void createTreeViewer(Composite itemComposite) {
        filteredCheckboxTree = new FilteredCheckboxTree(itemComposite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI) {

            @Override
            protected CheckboxTreeViewer doCreateTreeViewer(Composite parent, int style) {
                checkboxViewer = new CheckboxMDMRepositoryTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
                IRepositoryViewObject[] categoryViewObjects = RepositoryResourceUtil.getCategoryViewObjects();
                checkboxViewer.setContentProvider(contentProvider);
                checkboxViewer.setLabelProvider(new MDMRepositoryLabelProvider());
                checkboxViewer.setInput(categoryViewObjects);
                checkboxViewer.expandToLevel(3);
                checkboxViewer.collapseAll();
                return checkboxViewer;
            }

            @Override
            protected void refreshCompleted() {
                getViewer().expandToLevel(3);
                restoreCheckedElements();
            }

            @Override
            protected boolean isNodeCollectable(TreeItem item) {
                // Object obj = item.getData();
                // if (obj instanceof RepositoryNode) {
                // RepositoryNode node = (RepositoryNode) obj;
                // if (node.getObjectType() == ERepositoryObjectType.METADATA_CONNECTIONS) {
                // return true;
                // }
                // }
                return false;
            }
        };
        if (checkboxViewer != null) {
            checkboxViewer.addFilter(new ViewerFilter() {

                @Override
                public boolean select(Viewer viewer, Object parentElement, Object element) {
                    return true;
                }
            });
        }
    }

    @Override
    protected void setCreatedViewer() {
        if (checkboxViewer != null) {
            viewer = checkboxViewer;
        }
    }

    @Override
    public void refresh() {
        List<RepositoryViewObject> objectsToSelect = null;
        for (Object checkedObjInParentView : checkItems) {
            if (checkedObjInParentView instanceof RepositoryViewObject) {
                String id = ((RepositoryViewObject) checkedObjInParentView).getId();
                RepositoryViewObject objectToSelect = findObject(id, viewer.getTree().getItems());
                if (objectToSelect != null) {
                    if (objectsToSelect != null) {
                        objectsToSelect.add(objectToSelect);
                    } else {
                        objectsToSelect = new ArrayList<RepositoryViewObject>();
                        objectsToSelect.add(objectToSelect);
                    }
                }
            }
        }

        if (objectsToSelect != null && !objectsToSelect.isEmpty()) {
            ((CheckboxTreeViewer) viewer).setCheckedElements(objectsToSelect.toArray());
        }
    }

    @Override
    protected void filterCheckedObjects(Object[] selected, List ret) {
        for (Object obj : selected) {
            if (obj instanceof RepositoryViewObject) {
                ret.add(obj);
            }
        }
    }

    private RepositoryViewObject findObject(String id, org.eclipse.swt.widgets.Item[] treeItems) {
        RepositoryViewObject toReturn = null;
        for (org.eclipse.swt.widgets.Item item : treeItems) {
            Object data = item.getData();
            if (data != null && data instanceof RepositoryViewObject) {
                String idExist = ((RepositoryViewObject) data).getId();
                if (idExist.equals(id)) {
                    return (RepositoryViewObject) data;
                }
            }
            toReturn = findObject(id, getChildren(item));
            if (toReturn != null) {
                return toReturn;
            }
        }
        return null;
    }

    protected Item[] getChildren(Widget o) {
        if (o instanceof TreeItem) {
            return ((TreeItem) o).getItems();
        }
        if (o instanceof Tree) {
            return ((Tree) o).getItems();
        }
        return null;
    }

}
