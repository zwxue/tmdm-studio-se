package com.amalto.workbench.widgets.composites.property;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

import com.amalto.workbench.providers.ColumnTextExtractor;
import com.amalto.workbench.providers.CommonTableLabelProvider;
import com.amalto.workbench.providers.ListContentProvider;

public class PropertyComposite extends Composite {

    private TreeViewer tvProperty;

    private PropertyModifier propModifier;

    private List<IPropertySource<?>> propertySources = new ArrayList<IPropertySource<?>>();

    @SuppressWarnings("unchecked")
    public PropertyComposite(Composite parent, int style, String title, String label, String propNameColLabel,
            String propValueColLabel) {
        super(parent, style);
        final GridLayout gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.horizontalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.numColumns = 2;
        setLayout(gridLayout);

        final Label lblTitle = new Label(this, SWT.NONE);
        final GridData gd_lblTitle = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        lblTitle.setLayoutData(gd_lblTitle);
        lblTitle.setText((title == null ? "" : title));
        hideEmptyLabel(lblTitle);

        final Label lblLabel = new Label(this, SWT.NONE);
        lblLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
        lblLabel.setText((label == null ? "" : label));
        hideEmptyLabel(lblLabel);

        tvProperty = new TreeViewer(this, SWT.FULL_SELECTION | SWT.BORDER);
        propModifier = new PropertyModifier(tvProperty);
        tvProperty.setContentProvider(new ListContentProvider());
        tvProperty.setLabelProvider(new CommonTableLabelProvider<IPropertySource<?>>(new ColumnTextExtractor[] {
                new ColumnTextExtractor<IPropertySource<?>>("getPropertyName"),
                new ColumnTextExtractor<IPropertySource<?>>("getPropertyValueLabel") }));
        tvProperty.setSorter(new PropertySourceSorter());
        tvProperty.setCellEditors(new CellEditor[2]);
        tvProperty.setColumnProperties(PropertyModifier.COLPROPS);
        tvProperty.setCellModifier(propModifier);
        tvProperty.setInput(propertySources);

        Tree tree = tvProperty.getTree();
        tree.setLinesVisible(true);
        tree.setHeaderVisible(true);
        tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        final TreeColumn colName = new TreeColumn(tree, SWT.NONE);
        colName.setWidth(150);
        colName.setText((propNameColLabel == null ? "name" : propNameColLabel));

        final TreeColumn colValue = new TreeColumn(tree, SWT.NONE);
        colValue.setWidth(330);
        colValue.setText((propValueColLabel == null ? "value" : propValueColLabel));
    }

    public void setPropertySources(IPropertySource<?>[] propSources) {

        propertySources.clear();

        for (IPropertySource<?> eachPropSource : propSources)
            propertySources.add(eachPropSource);

        tvProperty.refresh();
    }

    public IPropertySource<?>[] getProperySources() {
        return propertySources.toArray(new IPropertySource[0]);
    }

    public void addPropertySource(IPropertySource<?> propSource) {

        if (propSource == null || propertySources.contains(propSource))
            return;

        propertySources.add(propSource);
        tvProperty.refresh();
    }

    public void removePropertySource(IPropertySource<?> propSource) {
        propertySources.remove(propSource);
        tvProperty.refresh();
    }

    public void clearPropertySource() {
        propertySources.clear();
        tvProperty.refresh();
    }

    public TreeViewer getPropertyViewer() {
        return tvProperty;
    }

    private void hideEmptyLabel(Label label) {

        if (!label.getText().trim().equals(""))
            return;

        ((GridData) label.getLayoutData()).exclude = true;
        label.setVisible(false);
    }

    public void setEditable(boolean isEditable) {
        tvProperty.setCellModifier(isEditable ? propModifier : null);
    }
}
