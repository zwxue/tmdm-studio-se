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
package org.talend.mdm.repository.ui.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.command.deploy.AbstractDeployCommand;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
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
            if (obj instanceof FolderRepositoryObject) {
                continue;
            }
            String id = ((IRepositoryViewObject) obj).getId();
            commands.add(cmdMap.get(id));
        }
        return commands;
    }

    public List<IRepositoryViewObject> getSelectededViewObjs() {
        List<IRepositoryViewObject> selectededViewObjs = new LinkedList<IRepositoryViewObject>();
        for (Object obj : treeViewer.getCheckedElements()) {
            if (obj instanceof FolderRepositoryObject) {
                continue;
            }
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
                if (cmd.getViewObject() != null) {
                    cmdMap.put(cmd.getViewObject().getId(), cmd);
                }
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
            IRepositoryViewObject[] elements = RepositoryResourceUtil.getCategoryViewObjects(type);
            List<IRepositoryViewObject> objs = new ArrayList<IRepositoryViewObject>();
            objs.addAll(Arrays.asList(elements));
            // missing transformer2, routingrule
            if (type.getKey().equals(IServerObjectRepositoryType.TYPE_TRANSFORMERV2.getKey())
                    || type.getKey().equals(IServerObjectRepositoryType.TYPE_ROUTINGRULE.getKey())) {
                IRepositoryNodeConfiguration typeConf = RepositoryNodeConfigurationManager.getConfiguration(type);
                addCategoryViewObject(objs, typeConf);
            }
            if (type.getKey().equals(IServerObjectRepositoryType.TYPE_EVENTMANAGER.getKey())) {
                IRepositoryNodeConfiguration processConf = RepositoryNodeConfigurationManager
                        .getConfiguration(IServerObjectRepositoryType.TYPE_TRANSFORMERV2);
                IRepositoryNodeConfiguration triggerConf = RepositoryNodeConfigurationManager
                        .getConfiguration(IServerObjectRepositoryType.TYPE_ROUTINGRULE);
                addCategoryViewObject(objs, processConf);
                addCategoryViewObject(objs, triggerConf);
            }
            return objs.toArray(new IRepositoryViewObject[0]);
        } else {
            IRepositoryViewObject[] elements = RepositoryResourceUtil.getCategoryViewObjects();

            IRepositoryNodeConfiguration processConf = RepositoryNodeConfigurationManager
                    .getConfiguration(IServerObjectRepositoryType.TYPE_TRANSFORMERV2);
            IRepositoryNodeConfiguration triggerConf = RepositoryNodeConfigurationManager
                    .getConfiguration(IServerObjectRepositoryType.TYPE_ROUTINGRULE);
            List<IRepositoryViewObject> objs = new ArrayList<IRepositoryViewObject>();
            addCategoryViewObject(objs, processConf);
            addCategoryViewObject(objs, triggerConf);

            objs.addAll(Arrays.asList(elements));
            return objs.toArray(new IRepositoryViewObject[0]);
        }
    }

    private void addCategoryViewObject(List<IRepositoryViewObject> result, IRepositoryNodeConfiguration conf) {
        if (conf != null) {
            IRepositoryViewObject categoryViewObject = RepositoryResourceUtil.getCategoryViewObject(conf);
            if (categoryViewObject != null) {
                result.add(categoryViewObject);
            }
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

        treeViewer.getTree().addListener(SWT.PaintItem, new Listener() {

            public void handleEvent(Event event) {
                TreeItem item = (TreeItem) event.item;
                Object data = item.getData();
                if (data != null && lockedViewObjs.contains(data)) {
                    String text = item.getText(event.index);
                    Point point = event.gc.textExtent(text);
                    int y = event.y + point.y / 2 + 2;
                    int x = event.x + 20;
                    event.gc.drawLine(x, y, x + point.x, y);
                    event.gc.drawText(Messages.RepositoryViewObjectCheckedWidget_lock, x + point.x + 2, event.y + 2);
                }
            }

        });

        treeViewer.addCheckStateListener(new ICheckStateListener() {

            private void checkSubElement(IRepositoryViewObject viewObj) {
                if (viewObj instanceof FolderRepositoryObject) {
                    Item item = viewObj.getProperty().getItem();
                    List<IRepositoryViewObject> children = RepositoryResourceUtil.findViewObjects(
                            viewObj.getRepositoryObjectType(), item, true, true);
                    if (children != null) {
                        for (IRepositoryViewObject child : children) {
                            checkSubElement(child);
                        }
                    }
                } else {
                    if (lockedViewObjs.contains(viewObj)) {
                        treeViewer.setChecked(viewObj, false);
                    }
                }
            }

            public void checkStateChanged(CheckStateChangedEvent event) {
                Object element = event.getElement();
                if (element instanceof IRepositoryViewObject) {
                    checkSubElement((IRepositoryViewObject) element);
                }
            }
        });

        treeViewer.addFilter(new ViewerFilter() {

            private boolean containVisibleElement(FolderRepositoryObject parent) {
                Item item = parent.getProperty().getItem();
                List<IRepositoryViewObject> children = RepositoryResourceUtil.findViewObjects(parent.getRepositoryObjectType(),
                        item, true, true);
                boolean result = false;
                for (IRepositoryViewObject viewObj : children) {

                    if (viewObj instanceof FolderRepositoryObject) {
                        boolean r = containVisibleElement((FolderRepositoryObject) viewObj);
                        if (r) {
                            result = true;
                        }
                    } else if (viewObj instanceof IRepositoryViewObject) {
                        boolean r = cmdMap.containsKey(viewObj.getId());

                        if (isVisibleViewObj(viewObj)) {
                            updateServerDef(viewObj);
                            // updateLockedObject(viewObj);
                            result = true;
                        }
                    }
                }
                return result;
            }

            private boolean isVisibleViewObj(IRepositoryViewObject viewObj) {
                AbstractDeployCommand cmd = cmdMap.get(viewObj.getId());
                if (cmd != null) {
                    ERepositoryObjectType type = viewObj.getRepositoryObjectType();
                    if (type == ERepositoryObjectType.PROCESS) {
                        int commandType = cmd.getCommandType();
                        return commandType == ICommand.CMD_MODIFY || commandType == ICommand.CMD_DELETE;
                    } else {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element) {
                if (element instanceof FolderRepositoryObject) {
                    return containVisibleElement((FolderRepositoryObject) element);
                } else {
                    IRepositoryViewObject viewObj = (IRepositoryViewObject) element;
                    return isVisibleViewObj(viewObj);
                }

            }
        });
        treeViewer.setInput(input);
        selectAll(true);
        treeViewer.expandAll();
    }

    public void selectAll(boolean isAll) {

        for (IRepositoryViewObject viewObj : input) {
            treeViewer.setSubtreeChecked(viewObj, isAll);
        }
        for (IRepositoryViewObject lockObj : lockedViewObjs) {
            treeViewer.setChecked(lockObj, false);
        }

    }

    private void updateServerDef(IRepositoryViewObject viewObj) {
        if (hasSameServerDef) {
            Item item = viewObj.getProperty().getItem();
            if (item == null || item instanceof ContainerItem) {
                return;
            }
            MDMServerDef serverDef = RepositoryResourceUtil.getLastServerDef(item);
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

    private Set<IRepositoryViewObject> lockedViewObjs = new HashSet<IRepositoryViewObject>();

    private void updateLockedObject(IRepositoryViewObject viewObject) {
        if (viewObject instanceof FolderRepositoryObject) {
            return;
        }
        if (RepositoryResourceUtil.isLockedViewObject(viewObject)) {
            lockedViewObjs.add(viewObject);
        }
    }
}
