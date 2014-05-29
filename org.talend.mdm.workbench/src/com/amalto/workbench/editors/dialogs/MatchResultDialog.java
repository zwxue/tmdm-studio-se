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
package com.amalto.workbench.editors.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.workbench.MDMWorbenchPlugin;
import com.amalto.workbench.editors.match.MatchData;
import com.amalto.workbench.editors.match.MatchGroup;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.models.KeyValue;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.utils.Util;


/**
 * created by liusongbo on 2014-5-20
 * 
 */
public class MatchResultDialog extends Dialog {

    private static final Log log = LogFactory.getLog(MatchResultDialog.class);

    private int defaultColumnWidth = 80;

    private List<String> matchFieldNames;

    private Map<String, String> id2Records;

    private final String GROUP_COLUMN = Messages.MatchResultDialog_groupColumn;

    private final String DETAILS_COLUMN = Messages.MatchResultDialog_detailsColumn;

    private MatchData matchData;

    public MatchResultDialog(Shell parentShell) {
        super(parentShell);
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setSize(900, 450);
        newShell.setText(Messages.MatchResultDialog_matchResult);
    }

    @Override
    protected void initializeBounds() {
        super.initializeBounds();
        Point location = getInitialLocation(getShell().getSize());
        getShell().setLocation(location.x, location.y);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite mainComp = (Composite) super.createDialogArea(parent);
        createViewer(mainComp);
        return mainComp;
    }

    private void createViewer(Composite mainComp) {
        TreeViewer tv = new TreeViewer(mainComp, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
        final Tree tree = tv.getTree();
        tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        tree.setHeaderVisible(true);
        tree.setLinesVisible(true);

        createColumns(tv);

        tv.setColumnProperties(matchFieldNames.toArray(new String[0]));
        tv.setContentProvider(new MatchContentProvider());
        tv.setLabelProvider(new MatchLabelProvider(matchFieldNames));
        tv.setInput(getInput());
        tv.expandAll();
    }

    private void createColumns(TreeViewer tv) {
        TreeViewerColumn lastColumn = null;
        for (int j = 0; j < matchFieldNames.size(); j++) {
            lastColumn = createTreeColumn(tv, matchFieldNames.get(j), defaultColumnWidth);
        }

        lastColumn.setEditingSupport(new MatchEditingSupport(tv));// last column
    }

    private TreeViewerColumn createTreeColumn(TreeViewer tv, String text, int width) {
        TreeViewerColumn column = new TreeViewerColumn(tv, SWT.NONE);
        int width_in = width;
        if (width_in < 0) {
            width_in = defaultColumnWidth;
        }
        column.getColumn().setWidth(width_in);
        column.getColumn().setText(text);
        column.getColumn().setResizable(true);
        column.getColumn().setMoveable(true);

        return column;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }

    public void setInput(MatchData matchData, Map<String, String> id2Records) {
        this.matchData = matchData;
        this.id2Records = id2Records;
        this.matchFieldNames = new ArrayList<String>(Arrays.asList(matchData.getFieldNames()));
        matchFieldNames.add(0, GROUP_COLUMN);
        matchFieldNames.add(DETAILS_COLUMN);
    }

    private MatchData getInput() {
        return this.matchData;
    }

    // ---- inner classes begin ---- //
    private class MatchContentProvider implements ITreeContentProvider {

        public Object[] getElements(Object inputElement) {
            return getChildren(inputElement);
        }

        public Object[] getChildren(Object parentElement) {
            Object[] children = new Object[0];
            if (parentElement instanceof MatchData) {
                MatchData md = (MatchData) parentElement;
                children = md.getAllGroups();
            } else if (parentElement instanceof MatchGroup) {
                MatchGroup group = (MatchGroup) parentElement;

                String masterId = group.getMasterId();
                String[] relatedIds = group.getRelatedIds();
                String groupId = group.getGroupId();
                Map<String, Line> scores = group.getAttributeScores();

                List<Line> lines = new ArrayList<Line>(relatedIds.length);
                for (int i = 0; i < relatedIds.length; i++) {
                    Line line = scores.get(relatedIds[i]);
                    StringBuilder attr_scores = new StringBuilder();
                    for (KeyValue keyValue : line.keyValues) {
                        attr_scores.append(keyValue.key + ":" + keyValue.value + ", "); //$NON-NLS-1$ //$NON-NLS-2$
                    }
                    if (attr_scores.length() > 2) {
                        attr_scores.delete(attr_scores.length() - 2, attr_scores.length());
                    }

                    lines.add(createLine(groupId, "", relatedIds[i], attr_scores.toString(), masterId.equals(relatedIds[i]))); //$NON-NLS-1$
                }

                children = lines.toArray();
            }
            //
            return children;
        }

        private Line createLine(String groupId, String groupSize, String id, String score, boolean isMaster) {
            String record = id2Records.get(id);// TODO here for composite id, the match result only used one of them
            Line line = createLine(groupId, groupSize, id, record, score, isMaster);
            return line;
        }

        private Line createLine(String groupId, String groupSize, String id, String record, String score, boolean isMaster) {
            List<KeyValue> keyvalues = new ArrayList<KeyValue>();

            keyvalues.add(new KeyValue("Id", id)); //$NON-NLS-1$
            for (String field : matchFieldNames) {
                if (!field.equalsIgnoreCase("id")) { //$NON-NLS-1$
                    if (field.equals(MatchData.BLOCK_KEY)) {
                        keyvalues.add(new KeyValue(MatchData.BLOCK_KEY, "")); //$NON-NLS-1$
                    } else if (field.equals(MatchData.GID)) {
                        keyvalues.add(new KeyValue(MatchData.GID, groupId));
                    } else if (field.equals(MatchData.GRP_SIZE)) {
                        keyvalues.add(new KeyValue(MatchData.GRP_SIZE, groupSize));
                    } else if (field.equals(MatchData.MASTER)) {
                        keyvalues.add(new KeyValue(MatchData.MASTER, new Boolean(isMaster).toString()));
                    } else if (field.equals(MatchData.ATTR_SCORE)) {
                        keyvalues.add(new KeyValue(MatchData.ATTR_SCORE, score));
                    } else {
                        keyvalues.add(getKeyValue(record, field));
                    }
                }
            }

            return new Line(keyvalues);
        }

        private KeyValue getKeyValue(String record, String field) {
            KeyValue keyvalue = new KeyValue(field, ""); //$NON-NLS-1$
            try {
                Document doc = Util.parse(record);

                NodeList nodeLists = doc.getElementsByTagName(field.toLowerCase());
                Node item = nodeLists.item(0);
                if (item != null) {
                    keyvalue.value = item.getTextContent();
                }
            } catch (DOMException e) {
                log.error(e.getMessage(), e);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            return keyvalue;
        }

        public boolean hasChildren(Object element) {
            Object[] children = getChildren(element);
            return children.length > 0;
        }

        // //////
        public void dispose() {
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

        public Object getParent(Object element) {
            return null;
        }
    }

    private class MatchLabelProvider extends BaseLabelProvider implements ITableLabelProvider, ITableColorProvider {

        private Image masterImage;

        private Color groupColor;

        private Color masterRecordColor = new Color(Display.getCurrent(), 255, 215, 0);;

        private List<String> columnProperties;


        public MatchLabelProvider(List<String> columnProperties) {
            this.columnProperties = columnProperties;
            masterImage = MDMWorbenchPlugin.getImageDescriptor("icons/star_match_master.png").createImage(); //$NON-NLS-1$
        }

        public String getColumnText(Object element, int columnIndex) {
            String column = columnProperties.get(columnIndex);
            if (element instanceof MatchGroup) {
                MatchGroup group = (MatchGroup) element;
                if (column.equalsIgnoreCase(GROUP_COLUMN)) {
                    return group.getGroupName();
                }

                if (column.equals(MatchData.GID)) {
                    return group.getGroupId();
                }

                if (column.equals(MatchData.GRP_SIZE)) {
                    return "" + group.getRelatedIds().length; //$NON-NLS-1$
                }

                if (column.equals(MatchData.CONFIDENCE)) {
                    return "" + group.getConfidence(); //$NON-NLS-1$
                }

                KeyValue[] values = group.getMatchResult().getValues();
                List<KeyValue> keyValues = new ArrayList<KeyValue>(Arrays.asList(values));
                keyValues.add(new KeyValue("id", group.getMasterId())); //$NON-NLS-1$
                Line line = new Line(keyValues);
                if (line.containsKey(column.toLowerCase())) {// get fields' match result
                    return line.getValue(column.toLowerCase());
                }

            } else if (element instanceof Line) {
                Line fieldValues = (Line) element;
                List<KeyValue> keyValues = fieldValues.keyValues;
                for (KeyValue keyValue : keyValues) {
                    if (keyValue.key.equalsIgnoreCase(column)) {
                        return keyValue.value;
                    }
                }
            }

            return ""; //$NON-NLS-1$
        }

        public Image getColumnImage(Object element, int columnIndex) {
            String column = columnProperties.get(columnIndex);
            if (element instanceof Line) {
                if (column.equalsIgnoreCase("id") && isMasterLine(element)) { //$NON-NLS-1$
                    return masterImage;
                }
            }
            
            return null;
        }

        public Color getForeground(Object element, int columnIndex) {
            return null;
        }

        public Color getBackground(Object element, int columnIndex) {
            if (isMasterLine(element)) {
                return masterRecordColor;
            }
            
            if (isGroupLine(element)) {
                return groupColor;
            }

            return null;
        }

        private boolean isGroupLine(Object element) {
            return element instanceof MatchGroup;
        }

        private boolean isMasterLine(Object element) {
            if (element instanceof Line) {
                Line line = (Line) element;
                String isMaster = line.getValue(MatchData.MASTER);
                Boolean master = Boolean.valueOf(isMaster);
                return master.booleanValue();
            }

            return false;
        }
    }

    private class MatchEditingSupport extends EditingSupport {

        private MatchDetailContentCellEditor groupDetailEditor;
        public MatchEditingSupport(TreeViewer viewer) {
            super(viewer);
            groupDetailEditor = new MatchDetailContentCellEditor(viewer.getTree());
        }

        @Override
        protected CellEditor getCellEditor(Object element) {
            return groupDetailEditor;
        }

        @Override
        protected boolean canEdit(Object element) {
            if (element instanceof MatchGroup) {
                MatchGroup group = (MatchGroup) element;
                groupDetailEditor.setContent(group.getContent());
                return true;
            }

            return false;
        }

        @Override
        protected Object getValue(Object element) {
            return null;
        }

        @Override
        protected void setValue(Object element, Object value) {
        }
    }

    private class MatchDetailContentCellEditor extends CellEditor {

        private Button detailBtn;

        private String content;

        public MatchDetailContentCellEditor(Tree tree) {
            super(tree);
        }

        @Override
        protected Control createControl(final Composite parent) {
            detailBtn = new Button(parent, SWT.PUSH);
            detailBtn.setText(" . . . "); //$NON-NLS-1$
            detailBtn.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    MatchDetailContentDialog dialog = new MatchDetailContentDialog(parent.getShell());
                    dialog.setInput(content);
                    dialog.open();
                }
            });
            return detailBtn;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        protected void doSetFocus() {
            if (detailBtn != null) {
                detailBtn.setFocus();
            }
        }

        @Override
        protected Object doGetValue() {
            return null;
        }

        @Override
        protected void doSetValue(Object value) {
        }
    }
    // ---- inner classes end ---- //
}
