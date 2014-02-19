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
package org.talend.mdm.repository.ui.dialogs.trigger;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.mdm.repository.i18n.Messages;

import com.amalto.workbench.editors.DataClusterDialog;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.MDMServerDef;
import com.amalto.workbench.webservices.WSConceptRevisionMap;
import com.amalto.workbench.webservices.WSConceptRevisionMap.MapEntry;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSGetConceptsInDataClusterWithRevisions;
import com.amalto.workbench.webservices.WSGetCurrentUniverse;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;
import com.amalto.workbench.widgets.ICellEditor;
import com.amalto.workbench.widgets.TisTableViewer;
import com.amalto.workbench.widgets.WidgetFactory;
import com.amalto.workbench.widgets.celleditor.EditableComboBoxCellEditor;

/**
 * created by liusongbo on 2014-2-13
 */
public class StartTriggerDialog extends Dialog {

    private final String col1 = Messages.StartTriggerDialog_entity;

    private final String col2 = Messages.StartTriggerDialog_recordKeys;

    private final String defaultContainer = "UpdateReport"; //$NON-NLS-1$

    private IWorkbenchPartSite site;
    private XtentisPort port;
    private MDMServerDef serverDef;

    private Combo dataContainerCombo;
    private TisTableViewer viewer;
    private EditableComboBoxCellEditor entityCellEditor;

    private String dataContainer;
    private String concept;

    private List<String> dataContainers;

    private Map<String, String> keyvalues;

    public StartTriggerDialog(IWorkbenchPartSite partSite, XtentisPort port, List<String> dataContainers, String concept,
            MDMServerDef serverDef) {
        super(partSite.getShell());
        this.site = partSite;
        this.port = port;
        this.dataContainers = dataContainers;
        this.concept = concept;
        this.serverDef = serverDef;
        keyvalues = new HashMap<String, String>();
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        parent.getShell().setText(Messages.StartTriggerDialog_shellText);
        Composite comp = new Composite(parent, 0);
        Layout layout = new GridLayout();
        comp.setLayout(layout);

        Composite dataContainerComp = new Composite(comp, SWT.NONE);
        GridLayout layout2 = new GridLayout(3, false);
        dataContainerComp.setLayout(layout2);
        GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        layoutData.verticalIndent = 10;
        dataContainerComp.setLayoutData(layoutData);
        Label dataContainerLabel = new Label(dataContainerComp, SWT.NONE);
        dataContainerLabel.setText(Messages.StartTriggerDialog_container);
        dataContainerCombo = new Combo(dataContainerComp, SWT.READ_ONLY);
        dataContainerCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Label label = new Label(comp, 0);
        label.setText(Messages.StartTriggerDialog_labelText);
        GridData layoutData2 = new GridData();
        layoutData2.horizontalIndent = 6;
        label.setLayoutData(layoutData2);
        ComplexTableViewerColumn[] columns = new ComplexTableViewerColumn[] {
                new ComplexTableViewerColumn(col1, true, "", "", "", ComplexTableViewerColumn.TEXT_STYLE, new String[] {}, 0),//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
                new ComplexTableViewerColumn(col2, true, "", "", "", ComplexTableViewerColumn.TEXT_STYLE, new String[] {}, 0) };//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
        columns[0].setColumnWidth(250);
        columns[1].setColumnWidth(200);
        viewer = new TisTableViewer(Arrays.asList(columns), WidgetFactory.getWidgetFactory(), comp);
        viewer.create();
        viewer.getViewer().setColumnProperties(new String[] { col1, col2 });
        entityCellEditor = new EditableComboBoxCellEditor(viewer.getViewer().getTable(),
                new String[] {}, SWT.READ_ONLY);
        SelectRecordCellEditor selectRecordCellEditor = new SelectRecordCellEditor(viewer.getViewer().getTable());
        viewer.getViewer().setCellEditors(new CellEditor[] { entityCellEditor, selectRecordCellEditor });
        viewer.getViewer().setCellModifier(new ICellModifier() {

            public void modify(Object element, String property, Object value) {
                TableItem item = (TableItem) element;
                Line line = (Line) item.getData();
                if (property.equals(col1)) {
                    line.keyValues.get(0).value = String.valueOf(value);
                } else if (property.equals(col2)) {
                    line.keyValues.get(1).value = String.valueOf(value);
                }
                viewer.getViewer().refresh();
            }

            public Object getValue(Object element, String property) {
                Line line = (Line) element;
                if (property.equals(col1)) {
                    return line.keyValues.get(0).value;
                } else if (property.equals(col2)) {
                    return line.keyValues.get(1).value;
                }

                return null;
            }

            public boolean canModify(Object element, String property) {
                Line line = (Line) element;
                if (property.equals(col2)) {
                    String entity = line.keyValues.get(0).value;
                    if (entity == null || entity.isEmpty()) {
                        return false;
                    }
                }
                return true;
            }
        });

        viewer.setHeight(210);
        List<Line> list = new ArrayList<Line>();
        Line line = new Line(columns, new String[] { concept, new StringBuilder().toString() });
        list.add(line);
        viewer.getViewer().setInput(list);

        init();
        addListener();
        return comp;
    }

    private void init() {
        dataContainerCombo.setItems(dataContainers.toArray(new String[0]));
        if (dataContainers.contains(defaultContainer)) {
            dataContainerCombo.setText(defaultContainer);
        }
        dataContainer = defaultContainer;
        entityCellEditor.setItems(getEntities(dataContainer));
        viewer.getViewer().setInput(new ArrayList<Line>());
    }

    private void addListener() {
        dataContainerCombo.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                dataContainer = dataContainerCombo.getText();
                String[] items = getEntities(dataContainer);
                entityCellEditor.setItems(items);
                viewer.getViewer().setInput(new ArrayList<Line>());
            }
        });
    }

    private String[] getEntities(String container) {
        List<String> concepts = new ArrayList<String>();

        WSUniverse currentUniverse = port.getCurrentUniverse(new WSGetCurrentUniverse());
        String currentUniverseName = "";//$NON-NLS-1$
        if (currentUniverse != null) {
            currentUniverseName = currentUniverse.getName();
        }
        if (currentUniverseName != null && currentUniverseName.equals("[HEAD]")) { //$NON-NLS-1$
            currentUniverseName = "";//$NON-NLS-1$
        }

        String clusterName = container;
        try {
            clusterName = URLEncoder.encode(container, "utf-8"); //$NON-NLS-1$
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        WSConceptRevisionMap conceptsRevisionMap = port
                .getConceptsInDataClusterWithRevisions(new WSGetConceptsInDataClusterWithRevisions(new WSDataClusterPK(
                        clusterName), new WSUniversePK(currentUniverseName)));

        if (conceptsRevisionMap != null) {
            List<MapEntry> wsConceptRevisionMapMapEntries = conceptsRevisionMap.getMapEntry();

            for (MapEntry entry : wsConceptRevisionMapMapEntries) {
                String concept = entry.getConcept();
                concepts.add(concept);
            }

        }
        return concepts.toArray(new String[0]);
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        parent.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        super.createButtonsForButtonBar(parent);
    }

    @Override
    protected void okPressed() {
        Map<String, String> keyvaluepairs = getValues();
        if (isValid(keyvaluepairs)) {
            keyvalues.putAll(keyvaluepairs);
            super.okPressed();
        }
    }

    private boolean isValid(Map<String, String> keyvaluepairs) {
        if (keyvaluepairs.size() == 0) {
            MessageDialog.openError(getShell(), Messages._Error, Messages.StartTriggerDialog_NoEmpty);
            return false;
        }

        List<Line> input = (List<Line>) viewer.getViewer().getInput();
        if (input.size() != keyvaluepairs.size()) {
            MessageDialog.openError(getShell(), Messages._Error, Messages.StartTriggerDialog_NoDuplication);
            return false;
        }

        return true;
    }

    private Map<String, String> getValues() {
        List<Line> input = (List<Line>) viewer.getViewer().getInput();
        Map<String, String> map = new HashMap<String, String>();
        for (Line line : input) {
            String key = line.keyValues.get(0).value;
            String value = line.keyValues.get(1).value;
            map.put(key, value);
        }

        return map;
    }

    public String getDataCluster() {
        return dataContainer;
    }

    public Map<String, String> getConceptRecords() {
        return keyvalues;
    }

    class SelectRecordCellEditor extends CellEditor implements ICellEditor, SelectionListener {

        private Text text;

        private Button selectValueBtn;

        private Composite editorComp;

        public SelectRecordCellEditor(Composite parent) {
            super(parent);
        }

        @Override
        protected Control createControl(Composite parent) {
            editorComp = new Composite(parent, SWT.NONE);
            editorComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
            GridLayout layout = new GridLayout(2, false);
            layout.marginWidth = 0;
            layout.marginLeft = 0;
            layout.marginTop = 0;
            layout.marginHeight = 0;
            layout.marginBottom = 0;
            editorComp.setLayout(layout);

            text = new Text(editorComp, SWT.NONE);
            text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
            selectValueBtn = new Button(editorComp, SWT.PUSH);
            selectValueBtn.setText("..."); //$NON-NLS-1$

            addListener(parent);
            return editorComp;
        }

        private void addListener(Composite parent) {
            selectValueBtn.addSelectionListener(this);
            parent.addMouseListener(new MouseListener() {

                public void mouseDoubleClick(MouseEvent e) {
                }

                public void mouseDown(MouseEvent e) {
                }

                public void mouseUp(MouseEvent e) {
                    if (!isMouseInControl(e)) {
                        deactive();
                    }
                }
            });
            text.addKeyListener(new KeyListener() {

                public void keyPressed(KeyEvent e) {
                }

                public void keyReleased(KeyEvent e) {
                    if (e.character == SWT.CR) {
                        deactive();
                    }
                }
            });
        }

        @Override
        protected Object doGetValue() {
            return text.getText();
        }

        @Override
        protected void doSetFocus() {
            text.setFocus();
        }

        @Override
        protected void doSetValue(Object value) {
            text.setText(value.toString().trim());
        }

        public void widgetSelected(SelectionEvent e) {
            DataClusterDialog dialog = new DataClusterDialog(getShell(), new TreeObject(), site);
            if (dialog.open() == Dialog.OK) {
                MDMServerDef usedServerDef = dialog.getServerDef();
                String usedDataContainer = dialog.getDataContainer();
                String usedConcept = dialog.getConcept();

                if (!isSameServer(serverDef, usedServerDef)) {
                    MessageDialog.openError(getShell(), Messages._Error, Messages.StartTriggerDialog_NoSameServer);
                    return;
                }
                if (!dataContainer.equals(usedDataContainer)) {
                    MessageDialog.openError(getShell(), Messages._Error, Messages.StartTriggerDialog_NoSameContainer);
                    return;
                }

                IStructuredSelection selection = (IStructuredSelection) viewer.getViewer().getSelection();
                Line line = (Line) selection.getFirstElement();
                String entity = line.keyValues.get(0).value;
                if (!usedConcept.equals(entity)) {
                    MessageDialog.openError(getShell(), Messages._Error, Messages.StartTriggerDialog_NoSameConcept);
                    return;
                }
                String[] recordIds = dialog.getRecordIds();
                StringBuilder keys = new StringBuilder(recordIds[0]);
                for (int i = 1; i < recordIds.length; i++) {
                    keys.append("." + recordIds[i]);
                }
                text.setText(keys.toString());
            }
        }

        private boolean isSameServer(MDMServerDef aServerDef, MDMServerDef bServerDef) {
            if (aServerDef == null && bServerDef == null) {
                return true;
            }

            if (aServerDef != null && bServerDef != null) {
                if (aServerDef.getName().equals(bServerDef.getName())) {
                    return true;
                }
            }
            return false;
        }

        public void widgetDefaultSelected(SelectionEvent e) {
        }

        boolean isMouseInControl(MouseEvent e) {
            if (e.widget instanceof Table) {
                if (editorComp.getBounds().contains(e.x, e.y)) {
                    return true;
                }
            }
            return false;
        }

        public void deactive() {
            if (isActivated()) {
                super.focusLost();
            }
        }
    }
}