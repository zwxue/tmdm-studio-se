// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.dialogs.consistency;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryNodeLabelProvider;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.service.ConsistencyService;
import org.talend.mdm.repository.core.service.ConsistencyService.CompareResultEnum;
import org.talend.mdm.repository.core.service.ConsistencyService.ConsistencyCheckResult;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.webservices.WSDigest;

/**
 * created by HHB on 2013-7-18 Detailled comment
 * 
 */
public class ConsistencyConflictDialog extends Dialog {

    private static final String[] OPERATIONS = new String[] { Messages.ConsistencyConflict_overwrite,
            Messages.ConsistencyConflict_skip };

    private static final Color COLOR_LIGHT_RED = EclipseResourceManager.getColor(255, 210, 210);

    private class ViewerLabelProvider implements ITableLabelProvider, IColorProvider {

        public void addListener(ILabelProviderListener listener) {
        }

        public void dispose() {
        }

        public boolean isLabelProperty(Object element, String property) {
            return false;
        }

        public void removeListener(ILabelProviderListener listener) {
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.IColorProvider#getForeground(java.lang.Object)
         */
        public Color getForeground(Object element) {
            return null;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.IColorProvider#getBackground(java.lang.Object)
         */
        public Color getBackground(Object element) {
            IRepositoryViewObject viewObj = (IRepositoryViewObject) element;
            if (getCompareResult(viewObj) == CompareResultEnum.DIFFERENT && !isSkipObj(viewObj)) {
                return COLOR_LIGHT_RED;
            }
            return null;
        }

        public Image getColumnImage(Object element, int columnIndex) {
            if (element instanceof IRepositoryViewObject) {
                switch (columnIndex) {
                case 0:
                    IRepositoryNodeLabelProvider labelProvider = getLabelProvider((IRepositoryViewObject) element);
                    if (labelProvider != null) {
                        return labelProvider.getImage(element);
                    }

                }

            }
            return null;
        }

        public String getColumnText(Object element, int columnIndex) {
            IRepositoryViewObject viewObj = (IRepositoryViewObject) element;
            if (element instanceof FolderRepositoryObject) {
                if (columnIndex == 0) {
                    return getViewObjName(viewObj);
                }
            } else {
                switch (columnIndex) {
                // name
                case 0:
                    return getViewObjName(viewObj);
                    // compare result:
                case 1:
                    CompareResultEnum compareResult = getCompareResult(viewObj);
                    switch (compareResult) {
                    case NOT_EXIST_IN_SERVER:
                        return Messages.ConsistencyConflictDialog_notExist;
                    case SAME:
                        return Messages.ConsistencyConflict_Same;
                    case DIFFERENT:
                        return Messages.ConsistencyConflict_Different;
                    }
                    break;
                // operation
                case 2:
                    return getOperationLabel(viewObj);

                    // local timestamp
                case 3:
                    Item item = viewObj.getProperty().getItem();
                    long localTimestamp = ConsistencyService.getInstance().getLocalTimestamp(item);
                    if (localTimestamp > 0) {
                        return df.format(new Date(localTimestamp));
                    }
                    break;
                // remote timestamp
                case 4:
                    WSDigest dt = viewObjMap.get(viewObj);
                    if (dt != null) {
                        return df.format(new Date(dt.getTimeStamp()));
                    }
                    break;
                }
            }
            return ""; //$NON-NLS-1$
        }

        private SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm:ss"); //$NON-NLS-1$

    }

    private IRepositoryNodeLabelProvider getLabelProvider(IRepositoryViewObject viewObj) {
        IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(viewObj);
        if (configuration != null) {
            return configuration.getLabelProvider();
        }
        return null;
    }

    private String getViewObjName(IRepositoryViewObject viewObj) {
        IRepositoryNodeLabelProvider labelProvider = getLabelProvider(viewObj);
        if (labelProvider != null) {
            return labelProvider.getText(viewObj);
        }
        return ""; //$NON-NLS-1$
    }

    private String getOperationLabel(IRepositoryViewObject viewObj) {
        if (getCompareResult(viewObj) == CompareResultEnum.NOT_EXIST_IN_SERVER) {
            return Messages.ConsistencyConflictDialog_Deploy;
        }
        if (!isSkipObj(viewObj)) {
            return OPERATIONS[0];
        } else {
            return OPERATIONS[1];
        }
    }

    private Map<IRepositoryViewObject, CompareResultEnum> compareResultMap = new HashMap<IRepositoryViewObject, CompareResultEnum>();

    private CompareResultEnum getCompareResult(IRepositoryViewObject viewObj) {
        CompareResultEnum result = compareResultMap.get(viewObj);
        if (result == null) {
            WSDigest dt = viewObjMap.get(viewObj);
            if (dt == null) {
                result = CompareResultEnum.NOT_EXIST_IN_SERVER;
            } else {
                Item item = viewObj.getProperty().getItem();
                String localDigestValue = ConsistencyService.getInstance().getLocalDigestValue(item);
                String serverDigestValue = dt.getDigestValue();
                if (localDigestValue.equals(serverDigestValue)) {
                    result = CompareResultEnum.SAME;
                } else {
                    result = CompareResultEnum.DIFFERENT;
                }
            }
            compareResultMap.put(viewObj, result);
        }
        return result;
    }

    private class TreeContentProvider implements ITreeContentProvider {

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

        public void dispose() {
        }

        public Object[] getElements(Object inputElement) {
            return getChildren(inputElement);
        }

        public Object[] getChildren(Object parentElement) {
            if (parentElement instanceof Collection) {
                return ((Collection) parentElement).toArray();
            }
            if (parentElement instanceof FolderRepositoryObject) {
                ERepositoryObjectType type = ((IRepositoryViewObject) parentElement).getRepositoryObjectType();
                return getViewObjectsByType(type);
            }
            return new Object[0];
        }

        public Object getParent(Object element) {
            return null;
        }

        public boolean hasChildren(Object element) {
            return getChildren(element).length > 0;
        }

        private Object[] getViewObjectsByType(ERepositoryObjectType type) {
            List<IRepositoryViewObject> viewObjs = new ArrayList<IRepositoryViewObject>();
            for (IRepositoryViewObject viewObj : viewObjMap.keySet()) {
                if (viewObj.getRepositoryObjectType() == type) {
                    viewObjs.add(viewObj);
                }
            }
            return viewObjs.toArray();
        }
    }

    private TreeViewer treeViewer;

    private final Map<IRepositoryViewObject, WSDigest> viewObjMap;

    private final int conflictCount;

    private ViewObjectComparator treeComparator;

    /**
     * Create the dialog.
     * 
     * @param parentShell
     * @param conflictCount
     */
    public ConsistencyConflictDialog(Shell parentShell, int conflictCount, Map<IRepositoryViewObject, WSDigest> viewObjMap) {
        super(parentShell);
        this.conflictCount = conflictCount;
        this.viewObjMap = viewObjMap;
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }

    /**
     * Create contents of the dialog.
     * 
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        GridLayout gridLayout = (GridLayout) container.getLayout();
        gridLayout.numColumns = 2;

        Label lblNewLabel = new Label(container, SWT.WRAP);
        GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_lblNewLabel.heightHint = 40;
        lblNewLabel.setLayoutData(gd_lblNewLabel);

        lblNewLabel.setText(Messages.bind(Messages.ConsistencyConflictDialog_dialogMessage, conflictCount));
        new Label(container, SWT.NONE);

        treeViewer = new TreeViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
        Tree tree = treeViewer.getTree();

        tree.setHeaderVisible(true);
        tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

        tc0 = new TreeColumn(tree, SWT.NONE);
        tc0.setWidth(160);
        tc0.setText(Messages.ConsistencyConflict_name);

        tc1 = new TreeColumn(tree, SWT.NONE);
        tc1.setWidth(120);
        tc1.setText(Messages.ConsistencyConflict_compareResult);

        tc2 = new TreeColumn(tree, SWT.NONE);
        tc2.setWidth(80);
        tc2.setText(Messages.ConsistencyConflictDialog_Operation);

        tc3 = new TreeColumn(tree, SWT.NONE);
        tc3.setText(Messages.ConsistencyConflict_localTimestamp);

        tc4 = new TreeColumn(tree, SWT.NONE);
        tc4.setText(Messages.ConsistencyConflict_serverTimestamp);

        treeViewer.setLabelProvider(new ViewerLabelProvider());
        treeViewer.setContentProvider(new TreeContentProvider());

        Composite composite = new Composite(container, SWT.NONE);
        composite.setLayout(new GridLayout(1, false));
        composite.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));

        Button overwriteBun = new Button(composite, SWT.NONE);
        overwriteBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                overwriteAll();
            }
        });
        overwriteBun.setText(Messages.ConsistencyConflictDialog_ovewriteAll);

        Button ignoreBun = new Button(composite, SWT.NONE);
        ignoreBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                skipObjects(CompareResultEnum.SAME);
            }
        });
        ignoreBun.setText(Messages.ConsistencyConflict_skipSame);

        Button skipDiffBun = new Button(composite, SWT.NONE);
        skipDiffBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                skipObjects(CompareResultEnum.DIFFERENT);
            }
        });
        skipDiffBun.setText(Messages.ConsistencyConflictDialog_btnNewButton_text);

        final Button showConflictBun = new Button(container, SWT.CHECK);
        showConflictBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showConflictObjects(showConflictBun.getSelection());
            }
        });
        showConflictBun.setText(Messages.ConsistencyConflictDialog_onlyShowConflictObjs);
        new Label(container, SWT.NONE);

        final Button showTimestampBun = new Button(container, SWT.CHECK);
        showTimestampBun.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showTimeStampColumns(showTimestampBun.getSelection());
            }
        });
        showTimestampBun.setText(Messages.ConsistencyConflict_showTimeStampColumn);
        new Label(container, SWT.NONE);

        //
        installCellEditor();
        //
        configSorter();
        //
        initInput();
        //
        showTimeStampColumns(false);
        return container;
    }

    private void configSorter() {
        this.treeComparator = new ViewObjectComparator();
        treeViewer.setComparator(treeComparator);
        hookTreeSorter(0, tc0);
        hookTreeSorter(1, tc1);
        hookTreeSorter(2, tc2);

    }

    private void hookTreeSorter(final int index, final TreeColumn column) {
        SelectionAdapter selectionAdapter = new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                treeComparator.setColumn(index);
                int dir = treeComparator.getDirection();
                treeViewer.getTree().setSortDirection(dir);
                treeViewer.getTree().setSortColumn(column);
                treeViewer.refresh();
            }
        };
        column.addSelectionListener(selectionAdapter);

    }

    public class ViewObjectComparator extends ViewerComparator {

        private int propertyIndex;

        private static final int DESCENDING = 1;

        private int direction = DESCENDING;

        public ViewObjectComparator() {
            this.propertyIndex = 0;
            direction = DESCENDING;
        }

        public int getDirection() {
            return direction == 1 ? SWT.DOWN : SWT.UP;
        }

        @Override
        public int category(Object element) {

            if (element instanceof FolderRepositoryObject) {
                return 0;
            } else {
                return 1;
            }
        }

        public void setColumn(int column) {
            if (column == this.propertyIndex) {
                // Same column as last sort; toggle the direction
                direction = 1 - direction;
            } else {
                // New column; do an ascending sort
                this.propertyIndex = column;
                direction = DESCENDING;
            }
        }

        @Override
        public int compare(Viewer viewer, Object e1, Object e2) {

            int rc = 0;

            if (e1 instanceof IRepositoryViewObject && e2 instanceof IRepositoryViewObject) {
                IRepositoryViewObject i1 = (IRepositoryViewObject) e1;
                IRepositoryViewObject i2 = (IRepositoryViewObject) e2;
                switch (propertyIndex) {
                case 0:
                    if (i1 instanceof FolderRepositoryObject) {
                        rc = 0;
                        break;
                    }

                    String name1 = getViewObjName(i1);
                    String name2 = getViewObjName(i2);

                    rc = name1.compareTo(name2);
                    break;
                case 1:
                    CompareResultEnum result1 = getCompareResult(i1);
                    CompareResultEnum result2 = getCompareResult(i2);

                    rc = result1.compareTo(result2);
                    break;
                case 2:

                    String o1 = getOperationLabel(i1);
                    String o2 = getOperationLabel(i2);

                    rc = o1.compareTo(o2);
                    break;

                }

            }

            // If descending order, flip the direction
            if (direction == DESCENDING) {
                rc = -rc;
            }
            return rc;
        }

    }

    ViewerFilter differentObjFilter = new ViewerFilter() {

        @Override
        public boolean select(Viewer viewer, Object parentElement, Object element) {
            if (element instanceof FolderRepositoryObject) {
                return true;
            }
            return getCompareResult((IRepositoryViewObject) element) == CompareResultEnum.DIFFERENT;
        }

    };

    protected void showConflictObjects(boolean selection) {
        if (selection) {
            treeViewer.addFilter(differentObjFilter);
        } else {
            treeViewer.removeFilter(differentObjFilter);
        }
        treeViewer.expandAll();
    }

    protected void showTimeStampColumns(boolean selection) {
        int width = selection ? 120 : 0;
        tc3.setWidth(width);
        tc4.setWidth(width);
        tc3.setResizable(selection);
        tc4.setResizable(selection);
    }

    private void installCellEditor() {
        treeViewer.setColumnProperties(new String[] { "0", "1", "2", "3", "4" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
        treeViewer.setCellModifier(new ICellModifier() {

            public void modify(Object element, String property, Object value) {
                if (property.equals("2")) { //$NON-NLS-1$
                    int index = (Integer) value;
                    IRepositoryViewObject viewObj = (IRepositoryViewObject) ((TreeItem) element).getData();
                    if (index == 0) {
                        moveToDeployObjs(viewObj);
                    } else if (index == 1) {
                        moveToSkipObjs(viewObj);
                    }
                    treeViewer.refresh(viewObj);
                }

            }

            public Object getValue(Object element, String property) {
                IRepositoryViewObject viewObj = (IRepositoryViewObject) element;
                if (isSkipObj(viewObj)) {
                    return 1;
                }
                return 0;
            }

            public boolean canModify(Object element, String property) {
                if (property.equals("2") && !(element instanceof FolderRepositoryObject)) { //$NON-NLS-1$
                    IRepositoryViewObject viewObj = (IRepositoryViewObject) element;
                    return getCompareResult(viewObj) != CompareResultEnum.NOT_EXIST_IN_SERVER;

                }
                return false;
            }
        });
        CellEditor[] cellEditors = new CellEditor[5];
        cellEditors[2] = new ComboBoxCellEditor(treeViewer.getTree(), OPERATIONS, SWT.READ_ONLY);
        treeViewer.setCellEditors(cellEditors);
    }

    private List<IRepositoryViewObject> toDeployObjs = new LinkedList<IRepositoryViewObject>();

    private List<IRepositoryViewObject> toSkipObjs = new LinkedList<IRepositoryViewObject>();

    private ConsistencyCheckResult result;

    private TreeColumn tc3;

    private TreeColumn tc4;

    private TreeColumn tc1;

    private TreeColumn tc2;

    private TreeColumn tc0;

    private void initOperations() {
        for (IRepositoryViewObject viewObj : viewObjMap.keySet()) {
            if (getCompareResult(viewObj) == CompareResultEnum.SAME) {
                toSkipObjs.add(viewObj);
            } else {
                toDeployObjs.add(viewObj);
            }
        }
    }

    private boolean isSkipObj(IRepositoryViewObject viewObj) {
        return toSkipObjs.contains(viewObj);
    }

    private void moveToSkipObjs(IRepositoryViewObject viewObj) {
        toSkipObjs.add(viewObj);
        toDeployObjs.remove(viewObj);
    }

    private void moveToDeployObjs(IRepositoryViewObject viewObj) {
        toSkipObjs.remove(viewObj);
        toDeployObjs.add(viewObj);
    }

    protected void skipObjects(CompareResultEnum skipEnum) {
        for (Iterator<IRepositoryViewObject> il = toDeployObjs.iterator(); il.hasNext();) {
            IRepositoryViewObject viewObj = il.next();
            CompareResultEnum compareResult = getCompareResult(viewObj);
            if (compareResult == skipEnum) {
                toSkipObjs.add(viewObj);
                il.remove();
            }
        }
        treeViewer.refresh();
    }

    protected void overwriteAll() {
        toDeployObjs.addAll(toSkipObjs);
        toSkipObjs.clear();
        treeViewer.refresh();
    }

    private void initInput() {
        initOperations();
        List<IRepositoryViewObject> containers = findRootContainers();
        treeViewer.setInput(containers);
        treeViewer.expandAll();
    }

    private List<IRepositoryViewObject> findRootContainers() {
        Set<ERepositoryObjectType> types = new HashSet<ERepositoryObjectType>();
        for (IRepositoryViewObject viewObj : viewObjMap.keySet()) {
            types.add(viewObj.getRepositoryObjectType());
        }
        List<IRepositoryViewObject> containers = new LinkedList<IRepositoryViewObject>();
        for (IRepositoryViewObject container : RepositoryResourceUtil.getCategoryViewObjects()) {
            if (container.getRepositoryObjectType() == IServerObjectRepositoryType.TYPE_EVENTMANAGER) {
                for (IRepositoryViewObject subContainer : ((FolderRepositoryObject) container).getChildren()) {
                    if (types.contains(subContainer.getRepositoryObjectType())) {
                        containers.add(subContainer);
                    }
                }
            } else if (types.contains(container.getRepositoryObjectType())) {
                containers.add(container);
            }
        }
        Collections.sort(containers, new Comparator() {

            public int compare(Object o1, Object o2) {
                String name1 = ((IRepositoryViewObject) o1).getRepositoryObjectType().getLabel();
                String name2 = ((IRepositoryViewObject) o2).getRepositoryObjectType().getLabel();
                return name1.compareTo(name2);
            }

        });
        return containers;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    @Override
    protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
            this.result = new ConsistencyService.ConsistencyCheckResult(toDeployObjs, toSkipObjs);
        } else if (buttonId == IDialogConstants.CANCEL_ID) {
            this.result = new ConsistencyService.ConsistencyCheckResult();
        }
        super.buttonPressed(buttonId);

    }

    /**
     * Getter for result.
     * 
     * @return the result
     */
    public ConsistencyCheckResult getResult() {
        return this.result;
    }

    /**
     * Return the initial size of the dialog.
     */

    @Override
    protected Point getInitialSize() {
        return new Point(724, 420);
    }
}
