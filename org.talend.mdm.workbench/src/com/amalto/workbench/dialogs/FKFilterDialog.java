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
package com.amalto.workbench.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.FKFilterParser;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;
import com.amalto.workbench.widgets.ICellEditor;
import com.amalto.workbench.widgets.TisTableViewer;
import com.amalto.workbench.widgets.WidgetFactory;

public class FKFilterDialog extends Dialog {

    String title;

    private TisTableViewer viewer;

    DataModelMainPage page;

    String filter;

    private ComplexTableViewerColumn[] columns;

    String conceptName;

    Text customFiltersText;

    protected String dataModelName;

    public FKFilterDialog(Shell parentShell, String title, String filter, DataModelMainPage page, String conceptName) {
        super(parentShell);
        this.filter = filter;
        this.page = page;
        this.title = title;
        this.conceptName = conceptName;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        parent.getShell().setText(this.title);
        Composite composite = (Composite) super.createDialogArea(parent);
        composite.setLayout(new GridLayout(2, false));

        columns = new ComplexTableViewerColumn[] {
                new ComplexTableViewerColumn("XPath", false, "newXPath", "newXPath", "", ComplexTableViewerColumn.XPATH_STYLE,//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
                        new String[] {}, 0),
                new ComplexTableViewerColumn("Operator", false, "", "", "", ComplexTableViewerColumn.COMBO_STYLE,//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
                        IConstants.VIEW_CONDITION_OPERATORS, 0),
                new ComplexTableViewerColumn("Value", false, "", "", "", ComplexTableViewerColumn.XPATH_STYLE, new String[] {}, 0),//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
                new ComplexTableViewerColumn("Predicate", true, "", "", "", ComplexTableViewerColumn.COMBO_STYLE,//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
                        IConstants.PREDICATES, 0), };
        columns[0].setColumnWidth(200);
        columns[1].setColumnWidth(140);
        columns[2].setColumnWidth(200);
        columns[3].setColumnWidth(140);
        viewer = getNewTisTableViewer(Arrays.asList(columns), WidgetFactory.getWidgetFactory(), composite);
        viewer.setXpath(true);
        viewer.setDatamodelName(dataModelName);
        // viewer.setMainPage(page);//TODO
        // viewer.setConceptName(conceptName);
        // viewer.setContext(true);

        // Modified by hbhong,to fix bug 21784
        TreeParent treeParent = (TreeParent) page.getAdapter(TreeParent.class);
        viewer.setTreeParent(treeParent);
        // The ending| bug:21784
        viewer.create();
        viewer.setHeight(140);
        viewer.setWidth(680);
        viewer.getMainComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 3));

        // the text box of the custom filters
        Group customFiltersGroup = new Group(composite, SWT.NONE);
        customFiltersGroup.setVisible(true);
        customFiltersGroup.setText(Messages.FKFilterDialog_CustomFilters);
        customFiltersGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
        customFiltersGroup.setLayout(new GridLayout(1, false));

        customFiltersText = new Text(customFiltersGroup, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
        customFiltersText.setEditable(true);
        GridData customFiltersTextGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
        customFiltersTextGridData.heightHint = 50;
        customFiltersText.setLayoutData(customFiltersTextGridData);

        parent.getShell().addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                XpathSelectDialog.setContext(null);
            }
        });

        // init data
        parseRules();

        return composite;
    }

    protected TisTableViewer getNewTisTableViewer(List<ComplexTableViewerColumn> columns, FormToolkit toolkit, Composite parent) {
        return new TisTableViewer(columns, toolkit, parent);
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

    private void parseRules() {
        List<Line> lines = new ArrayList<Line>();

        String[] keyNames = getKeyNames();
        String parsedFilter = FKFilterParser.parseFilter(filter, lines, keyNames);

        if (!parsedFilter.isEmpty()) {
            filter = parsedFilter;
            customFiltersText.setText(filter.substring(6));
        }
        viewer.getViewer().setInput(lines);
    }

    private String[] getKeyNames() {
        String[] keyNames = new String[columns.length];
        for (int i = 0; i < columns.length; i++) {
            keyNames[i] = columns[i].getName();
        }

        return keyNames;
    }

    @Override
    protected void okPressed() {

        TableItem[] items = viewer.getViewer().getTable().getItems();
        if (items.length > 0 && customFiltersText.getText() != null && customFiltersText.getText().trim().length() > 0) {
            if (!MessageDialog.openConfirm(null, Messages.Confirm,
                    Messages.FKFilterDialog_ConfirmContent))
                return;
        }

        XpathSelectDialog.setContext(null);
        deactiveAllCellEditors();
        resetFilter();
        super.okPressed();
    }

    private void deactiveAllCellEditors() {
        CellEditor[] editors = viewer.getViewer().getCellEditors();
        for (CellEditor editor : editors) {
            if (editor instanceof ICellEditor) {
                ((ICellEditor) editor).deactive();
            }
        }
    }

    @Override
    protected void cancelPressed() {
        super.cancelPressed();
        XpathSelectDialog.setContext(null);
    }

    private String resetFilter() {
        if (customFiltersText.getText() != null && customFiltersText.getText().trim().length() > 0) {
            filter = FKFilterParser.getDeParseredCustomFilter(customFiltersText.getText().trim());
            return filter;
        }

        List<Line> lines = new ArrayList<Line>();
        TableItem[] items = viewer.getViewer().getTable().getItems();
        if (items.length > 0) {
            for (TableItem item : items) {
                Line line = (Line) item.getData();
                lines.add(line);
            }
        }
        filter = FKFilterParser.getDeParseredFilter(lines);

        return filter;
    }

    public String getFilter() {
        return filter;
    }

    public void setDataModel(String dataModelName) {
        this.dataModelName = dataModelName;
    }

}
