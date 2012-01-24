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
package org.talend.mdm.repository.ui.wizards.exports.viewers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryContentProvider;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryLabelProvider;
import org.talend.mdm.repository.ui.widgets.AbstractNodeCheckTreeViewer;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.widgets.FilteredCheckboxTree;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ExportRepositoryObjectCheckTreeViewer extends AbstractNodeCheckTreeViewer {

    /**
     * DOC hbhong RepositoryObjectCheckTreeViewer constructor comment.
     * 
     * @param selection
     */
    IRepositoryViewObject[] categoryViewObjects;

    public ExportRepositoryObjectCheckTreeViewer(IStructuredSelection selection) {
        super(selection);
    }

    protected void createTreeViewer(Composite itemComposite) {
        filteredCheckboxTree = new FilteredCheckboxTree(itemComposite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI) {

            ContainerCheckedTreeViewer treeViewer;

            @Override
            protected CheckboxTreeViewer doCreateTreeViewer(Composite parent, int style) {
                categoryViewObjects = RepositoryResourceUtil.getCategoryViewObjects();
                IRepositoryViewObject[] viewObjs = getSortedViewObjects(categoryViewObjects);

                treeViewer = new ContainerCheckedTreeViewer(parent);
                treeViewer.setLabelProvider(new MDMRepositoryLabelProvider());
                treeViewer.setContentProvider(new MDMRepositoryContentProvider());
                treeViewer.setInput(viewObjs);
                return treeViewer;
            }


            @Override
            protected void refreshCompleted() {
                treeViewer.expandToLevel(3);
                restoreCheckedElements();
            }

            @Override
            protected boolean isNodeCollectable(TreeItem item) {
                return false;
            }
        };

    }

    private IRepositoryViewObject[] getSortedViewObjects(IRepositoryViewObject[] categoryViewObjects) {
        List<IRepositoryViewObject> sortedViewObjs = new ArrayList<IRepositoryViewObject>();
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_CUSTOM_FORM));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_DATACLUSTER));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_DATAMODEL));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_EVENTMANAGER));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_MENU));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_RESOURCE));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_ROLE));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_SERVICECONFIGURATION));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_STOREPROCEDURE));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_SYNCHRONIZATIONPLAN));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_UNIVERSE));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_VIEW));
        sortedViewObjs.add(getViewObjectByType(IServerObjectRepositoryType.TYPE_WORKFLOW));
        sortedViewObjs.add(categoryViewObjects[5]);
        return (IRepositoryViewObject[]) sortedViewObjs.toArray(new IRepositoryViewObject[0]);
    }

    public IRepositoryViewObject getViewObjectByType(ERepositoryObjectType type) {
        if (categoryViewObjects == null || type == null)
            return null;
        for (IRepositoryViewObject viewObj : categoryViewObjects) {
            if (viewObj.getRepositoryObjectType().equals(type)) {
                return viewObj;
            }
        }
        return null;
    }

    @Override
    protected void filterCheckedObjects(Object[] selected, List<Object> ret) {
        for (Object obj : selected) {
            ret.add(obj);
        }
    }

}
