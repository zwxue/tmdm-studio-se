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
package org.talend.mdm.repository.ui.wizards.imports.viewer;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.service.ConsistencyService;
import org.talend.mdm.repository.core.service.ConsistencyService.CompareResultEnum;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.ui.widgets.AbstractNodeCheckTreeViewer;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.ServerTreeContentProvider;
import com.amalto.workbench.providers.ServerTreeLabelProvider;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSDigest;
import com.amalto.workbench.webservices.WSDigestKey;
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

    private final MDMServerDef serverDef;

    private Map<TreeObject, ConsistencyData> consistencyMap;

    /**
     * DOC hbhong TreeObjectCheckTreeViewer constructor comment.
     * 
     * @param serverDef
     * 
     * @param serverRoot
     */
    public TreeObjectCheckTreeViewer(MDMServerDef serverDef, TreeParent serverRoot) {
        super(serverRoot);
        this.serverDef = serverDef;
    }

    class ConsistencyData {

        private WSDigest localDigestTime;

        public WSDigest getLocalDigestTime() {
            return this.localDigestTime;
        }

        public void setLocalDigestTime(WSDigest localDigestTime) {
            this.localDigestTime = localDigestTime;
        }

        public WSDigest getServerDigestTime() {
            return this.serverDigestTime;
        }

        public void setServerDigestTime(WSDigest serverDigestTime) {
            this.serverDigestTime = serverDigestTime;
        }

        public CompareResultEnum getCompareResult() {
            return this.compareResult;
        }

        public void setCompareResult(CompareResultEnum compareResult) {
            this.compareResult = compareResult;
        }

        private WSDigest serverDigestTime;

        private CompareResultEnum compareResult;

    }

    public void initInput() {
        List<TreeObject> treeObjs = initTreeObjs(serverRoot);
        this.consistencyMap = initConsistencyData(serverDef, treeObjs);
        getViewer().setInput(serverRoot);
    }

    private List<TreeObject> initTreeObjs(TreeObject serverRoot) {
        List<TreeObject> treeObjs = new ArrayList<TreeObject>();
        iterateAllTreeObjs(serverRoot, treeObjs);
        return treeObjs;
    }

    private void iterateAllTreeObjs(TreeObject parent, List<TreeObject> treeObjs) {
        if (parent != null) {
            if (parent instanceof TreeParent) {
                for (TreeObject child : ((TreeParent) parent).getChildren()) {
                    iterateAllTreeObjs(child, treeObjs);
                }
            } else {
                treeObjs.add(parent);
            }
        }
    }

    private static final Color COLOR_LIGHT_RED = EclipseResourceManager.getColor(255, 210, 210);

    class CompareResultColumnProvider extends ColumnLabelProvider {

        @Override
        public Color getBackground(Object element) {
            if (!(element instanceof TreeParent)) {
                ConsistencyData consistencyData = consistencyMap.get(element);
                if (consistencyData != null) {
                    if (consistencyData.getCompareResult() == CompareResultEnum.DIFFERENT) {
                        return COLOR_LIGHT_RED;
                    }
                }
            }
            return null;
        }

        @Override
        public String getText(Object element) {
            if (!(element instanceof TreeParent)) {
                ConsistencyData consistencyData = consistencyMap.get(element);
                if (consistencyData != null) {
                    CompareResultEnum compareResult = consistencyData.getCompareResult();
                    switch (compareResult) {
                    case NOT_EXIST_IN_SERVER:
                        return Messages.ConsistencyConflict_noDataInServer;
                    case NOT_EXIST_IN_LOCAL:
                        return Messages.ConsistencyConflict_notExistInLocal;
                    case SAME:
                        return Messages.ConsistencyConflict_Same;
                    case DIFFERENT:
                        return Messages.ConsistencyConflict_Different;
                    }
                }
            }
            return ""; //$NON-NLS-1$
        }

    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yy/MM/dd HH:mm:ss"); //$NON-NLS-1$

    class TimeStampColumnProvider extends ColumnLabelProvider {

        private final boolean isLocal;

        public TimeStampColumnProvider(boolean isLocal) {
            this.isLocal = isLocal;
        }

        @Override
        public String getText(Object element) {
            if (!(element instanceof TreeParent)) {
                ConsistencyData consistencyData = consistencyMap.get(element);
                WSDigest dt = isLocal ? consistencyData.getLocalDigestTime() : consistencyData.getServerDigestTime();
                if (dt != null) {
                    return DATE_FORMAT.format(new Date(dt.getTimeStamp()));
                }
            }
            return ""; //$NON-NLS-1$
        }

    }

    private Map<TreeObject, ConsistencyData> initConsistencyData(MDMServerDef serverDef, List<TreeObject> treeObjs) {
        Map<TreeObject, ConsistencyData> map = new HashMap<TreeObject, TreeObjectCheckTreeViewer.ConsistencyData>();
        try {
            ConsistencyService consistencyService = ConsistencyService.getInstance();
            Map<TreeObject, WSDigest> serverDigestValues = consistencyService.queryServerDigestValue(serverDef, treeObjs);
            for (TreeObject treeObject : treeObjs) {
                ConsistencyData consistencyData = new ConsistencyData();
                WSDigest serverDigestTime = serverDigestValues.get(treeObject);
                consistencyData.setServerDigestTime(serverDigestTime);
                String objName = treeObject.getDisplayName();
                ERepositoryObjectType viewType = RepositoryQueryService.getRepositoryObjectType(treeObject.getType());
                if (viewType == null) {
                    continue;
                }
                IRepositoryViewObject viewObj = RepositoryResourceUtil.findViewObjectByName(viewType, objName);
                if (viewObj == null) {
                    consistencyData.setCompareResult(CompareResultEnum.NOT_EXIST_IN_LOCAL);
                } else {
                    Item item = viewObj.getProperty().getItem();
                    consistencyService.updateLocalDigestValue(viewObj);
                    String digestValue = consistencyService.getLocalDigestValue(item);
                    long localTimestamp = consistencyService.getLocalTimestamp(item);
                    // key
                    String type = viewObj.getRepositoryObjectType().getKey();
                    String objectName = viewObj.getLabel();
                    WSDigestKey key = new WSDigestKey(type, objectName);
                    consistencyData.setLocalDigestTime(new WSDigest(key, digestValue, localTimestamp));
                    // init compare result;
                    CompareResultEnum result;
                    if (serverDigestTime == null) {
                        result = CompareResultEnum.NOT_EXIST_IN_SERVER;
                    } else {
                        if (serverDigestTime.getDigestValue().equals(digestValue)) {
                            result = CompareResultEnum.SAME;
                        } else {
                            result = CompareResultEnum.DIFFERENT;
                        }
                    }
                    consistencyData.setCompareResult(result);
                }
                map.put(treeObject, consistencyData);
            }
        } catch (RemoteException e) {
            log.error(e.getMessage(), e);
        } catch (XtentisException e) {
            log.error(e.getMessage(), e);
        }
        return map;
    }

    private TreeViewerColumn localTimeColumn;

    private TreeViewerColumn serverTimeColumn;

    @Override
    protected void createTreeViewer(Composite itemComposite) {
        filteredCheckboxTree = new FilteredCheckboxTree(itemComposite, SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI
                | SWT.FULL_SELECTION) {

            ContainerCheckedTreeViewer treeViewer;

            @Override
            protected CheckboxTreeViewer doCreateTreeViewer(Composite parent, int style) {
                treeViewer = new ContainerCheckedTreeViewer(parent, style);
                contentProvider = new TreeObjectContentProvider(serverRoot);
                treeViewer.setContentProvider(contentProvider);

                installColumns();
                treeViewer.setInput(serverRoot);

                return treeViewer;
            }

            private void installColumns() {
                treeViewer.getTree().setHeaderVisible(true);
                //
                TreeViewerColumn nameColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
                nameColumn.getColumn().setWidth(320);
                nameColumn.getColumn().setText(Messages.ConsistencyConflict_name);
                nameColumn.setLabelProvider(new ServerTreeLabelProvider());
                // compare result
                TreeViewerColumn resultColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
                resultColumn.getColumn().setWidth(120);
                resultColumn.getColumn().setText(Messages.ConsistencyConflict_compareResult);
                resultColumn.setLabelProvider(new CompareResultColumnProvider());
                //
                localTimeColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
                localTimeColumn.getColumn().setText(Messages.ConsistencyConflict_localTimestamp);
                localTimeColumn.setLabelProvider(new TimeStampColumnProvider(true));
                //
                serverTimeColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
                serverTimeColumn.getColumn().setText(Messages.ConsistencyConflict_serverTimestamp);
                serverTimeColumn.setLabelProvider(new TimeStampColumnProvider(false));
                //
                showTimeStampColumns(false);
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

    @Override
    protected Composite createSelectionButton(Composite itemComposite) {
        Composite container = super.createSelectionButton(itemComposite);
        Button collapseBtn = new Button(container, SWT.PUSH);
        collapseBtn.setText(Messages.ConsistencyConflict_skipSame);
        collapseBtn.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                skipSameDigestValueObjects();
            }
        });
        return container;
    }

    protected void skipSameDigestValueObjects() {
        for (TreeObject treeObj : consistencyMap.keySet()) {
            ConsistencyData consistencyData = consistencyMap.get(treeObj);
            if (consistencyData != null) {
                if (consistencyData.getCompareResult() == CompareResultEnum.SAME) {
                    filteredCheckboxTree.getViewer().setChecked(treeObj, false);
                }
            }
        }
    }

    public void showTimeStampColumns(boolean selection) {
        int width = selection ? 120 : 0;
        localTimeColumn.getColumn().setWidth(width);
        serverTimeColumn.getColumn().setWidth(width);
        localTimeColumn.getColumn().setResizable(selection);
        serverTimeColumn.getColumn().setResizable(selection);
    }

    @Override
    protected void filterCheckedObjects(Object[] selected, List<Object> ret) {

        for (Object element : selected) {
            ret.add(element);
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
        setServerRoot(root);
        contentProvider.setRoot(root);
    }

    public boolean isOverWrite() {
        return this.isOverWrite;
    }

    public void setOverWrite(boolean isOverWrite) {
        this.isOverWrite = isOverWrite;
    }
}
