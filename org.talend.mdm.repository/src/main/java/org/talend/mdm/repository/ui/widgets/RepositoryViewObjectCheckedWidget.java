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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.command.deploy.AbstractDeployCommand;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryLabelProvider;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RepositoryViewObjectCheckedWidget extends Composite {

    class ContentProvider implements ITreeContentProvider {

        public void dispose() {
        }

        public Object[] getChildren(Object parentElement) {
            if (parentElement instanceof IRepositoryViewObject[]) {
                return (IRepositoryViewObject[]) parentElement;
            } else if (parentElement instanceof FolderRepositoryObject) {
                FolderRepositoryObject folderRepositoryObject = (FolderRepositoryObject) parentElement;
                Item item = folderRepositoryObject.getProperty().getItem();
                return RepositoryResourceUtil.findViewObjects(folderRepositoryObject.getRepositoryObjectType(), item, true, true)
                        .toArray();
            }
            return new Object[0];
        }

        public Object[] getElements(Object inputElement) {
            return getChildren(inputElement);
        }

        public Object getParent(Object element) {
            return null;
        }

        public boolean hasChildren(Object element) {
            return getChildren(element).length > 0;
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }
    }

    private HashMap<String, AbstractDeployCommand> cmdMap;

    private boolean hasSameServerDef = true;

    private IRepositoryViewObject[] input;

    private MDMServerDef lastServerDef = null;

    private CheckboxTreeViewer treeViewer;

    /**
     * if type==null, return all type
     * 
     * @param parent
     * @param type
     * @param commands
     */
    public RepositoryViewObjectCheckedWidget(Composite parent, ERepositoryObjectType type, List<AbstractDeployCommand> commands) {
        super(parent, SWT.NONE);

        initChangedViewObjects(commands);
        input = initInput(type);
        initWidget();

    }

    public void addCheckStateListener(ICheckStateListener listener) {
        treeViewer.addCheckStateListener(listener);
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }

    public MDMServerDef getSameServerDef() {
        return this.lastServerDef;
    }

    public List<AbstractDeployCommand> getSelectedCommands() {
        List<AbstractDeployCommand> commands = new LinkedList<AbstractDeployCommand>();
        for (Object obj : treeViewer.getCheckedElements()) {
            if (obj instanceof FolderRepositoryObject)
                continue;
            String id = ((IRepositoryViewObject) obj).getId();
            commands.add(cmdMap.get(id));
        }
        return commands;
    }

    public List<IRepositoryViewObject> getSelectededViewObjs() {
        List<IRepositoryViewObject> selectededViewObjs = new LinkedList<IRepositoryViewObject>();
        for (Object obj : treeViewer.getCheckedElements()) {
            if (obj instanceof FolderRepositoryObject)
                continue;
            selectededViewObjs.add((IRepositoryViewObject) obj);
        }
        return selectededViewObjs;
    }

    public Tree getTree() {
        return treeViewer.getTree();
    }

    private void initChangedViewObjects(List<AbstractDeployCommand> commands) {
        if (commands != null) {
            cmdMap = new HashMap<String, AbstractDeployCommand>();
            for (AbstractDeployCommand cmd : commands) {
                cmdMap.put(cmd.getViewObject().getId(), cmd);
            }

        }
    }

    /**
     * DOC hbhong Comment method "initInput".
     * 
     * @param type
     * @return
     */
    private IRepositoryViewObject[] initInput(ERepositoryObjectType type) {
        if (type != null) {
            return RepositoryResourceUtil.getCategoryViewObjects(type);
        } else {
            return RepositoryResourceUtil.getCategoryViewObjects();
        }
    }

    private void initWidget() {
        //
        setLayout(new FillLayout(SWT.HORIZONTAL));

        treeViewer = new ContainerCheckedTreeViewer(this, SWT.BORDER);
        ILabelDecorator labelDecorator = RepositoryPlugin.getDefault().getWorkbench().getDecoratorManager().getLabelDecorator();
        DecoratingLabelProvider labelProvider = new DecoratingLabelProvider(new MDMRepositoryLabelProvider(), labelDecorator);
        treeViewer.setLabelProvider(labelProvider);
        treeViewer.setContentProvider(new ContentProvider());
        treeViewer.addFilter(new ViewerFilter() {

            private boolean containVisibleElement(FolderRepositoryObject parent) {
                Item item = parent.getProperty().getItem();
                List<IRepositoryViewObject> children = RepositoryResourceUtil.findViewObjects(parent.getRepositoryObjectType(),
                        item, true, true);
                for (IRepositoryViewObject viewObj : children) {
                    if (viewObj instanceof FolderRepositoryObject) {
                        boolean result = containVisibleElement((FolderRepositoryObject) viewObj);
                        if (result) {
                            updateServerDef(viewObj);
                            return true;
                        }
                    } else if (viewObj instanceof IRepositoryViewObject) {
                        boolean result = cmdMap.containsKey(viewObj.getId());
                        if (result) {
                            updateServerDef(viewObj);
                            return true;
                        }
                    }
                }
                return false;
            }

            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element) {
                if (element instanceof FolderRepositoryObject) {
                    return containVisibleElement((FolderRepositoryObject) element);
                } else {
                    return cmdMap.containsKey(((IRepositoryViewObject) element).getId());
                }
                // return true;

            }
        });
        treeViewer.setInput(input);
        selectAll(true);
        treeViewer.expandAll();
    }

    public void selectAll(boolean isAll) {
        treeViewer.setAllChecked(isAll);
    }

    private void updateServerDef(IRepositoryViewObject viewObj) {
        if (hasSameServerDef) {
            Item item = viewObj.getProperty().getItem();
            MDMServerDef serverDef = ((MDMServerObjectItem) item).getMDMServerObject().getLastServerDef();
            if (lastServerDef == null) {
                lastServerDef = serverDef;
            } else {
                if (!lastServerDef.equals(serverDef)) {
                    lastServerDef = null;
                    hasSameServerDef = false;
                }
            }
        }
    }
}
