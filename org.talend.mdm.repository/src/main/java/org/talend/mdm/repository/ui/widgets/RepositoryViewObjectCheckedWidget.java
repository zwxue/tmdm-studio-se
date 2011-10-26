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
package org.talend.mdm.repository.ui.widgets;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.models.ContainerRepositoryObject;
import org.talend.mdm.repository.ui.navigator.CommonMDMRepositoryContentProvider;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryLabelProvider;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryViewObjectCheckedWidget extends Composite {

    private CheckboxTreeViewer treeViewer;

    private final Set<IRepositoryViewObject> changedViewObjs;



    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     */
    public RepositoryViewObjectCheckedWidget(Composite parent, Object input, Set<IRepositoryViewObject> changeds) {
        super(parent, SWT.NONE);
        this.changedViewObjs = changeds;
        //
        setLayout(new FillLayout(SWT.HORIZONTAL));

        treeViewer = new ContainerCheckedTreeViewer(this, SWT.BORDER);

        treeViewer.setLabelProvider(new MDMRepositoryLabelProvider());
        treeViewer.setContentProvider(new CommonMDMRepositoryContentProvider());
        // treeViewer.setContentProvider(new MDMRepositoryContentProvider());
        treeViewer.addFilter(new ViewerFilter() {

            private boolean containVisibleElement(ContainerRepositoryObject parent) {
                for (IRepositoryViewObject viewObj : parent.getChildren()) {
                    if (viewObj instanceof ContainerRepositoryObject) {
                        boolean result = containVisibleElement((ContainerRepositoryObject) viewObj);
                        if (result)
                            return true;
                    } else if (viewObj instanceof IRepositoryViewObject) {
                        boolean result = changedViewObjs.contains(viewObj);
                        if (result)
                            return true;
                    }
                }
                return false;

            }

            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element) {
                if (element instanceof ContainerRepositoryObject) {
                    return containVisibleElement((ContainerRepositoryObject) element);
                } else {
                    return changedViewObjs.contains(element);
                }

            }
        });
        treeViewer.setInput(input);
        selectAll(true);
        treeViewer.expandAll();
    }

    public void selectAll(boolean isAll) {
        treeViewer.setAllChecked(isAll);
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }

    public List<IRepositoryViewObject> getSelectededViewObjs() {
        List<IRepositoryViewObject> selectededViewObjs = new LinkedList<IRepositoryViewObject>();
        for (Object obj : treeViewer.getCheckedElements()) {
            if (obj instanceof ContainerRepositoryObject)
                continue;
            selectededViewObjs.add((IRepositoryViewObject) obj);
        }
        return selectededViewObjs;
    }

    public Tree getTree() {
        return treeViewer.getTree();
    }

    public void addCheckStateListener(ICheckStateListener listener) {
        treeViewer.addCheckStateListener(listener);
    }
}
