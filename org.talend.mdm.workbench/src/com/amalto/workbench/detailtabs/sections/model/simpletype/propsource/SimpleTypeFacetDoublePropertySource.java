package com.amalto.workbench.detailtabs.sections.model.simpletype.propsource;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.amalto.workbench.detailtabs.sections.model.simpletype.SimpleTypeDoubleFacetInfo;
import com.amalto.workbench.providers.CellEditorValueExtractor;
import com.amalto.workbench.providers.CellEditorValueModifier;
import com.amalto.workbench.widgets.celleditor.NumbericCellEditor;
import com.amalto.workbench.widgets.composites.property.IPropertySource;

public class SimpleTypeFacetDoublePropertySource extends SimpleTypeFacetPropertySource<Double, SimpleTypeDoubleFacetInfo> {

    public SimpleTypeFacetDoublePropertySource(Composite cellEditorParent, String propName, double value) {
        super(cellEditorParent, new SimpleTypeDoubleFacetInfo(propName, value));
    }

    @Override
    public CellEditor getCellEditor() {
        return NumbericCellEditor.createPositiveDoubleCellEditor(cellEditorParent, SWT.BORDER);
    }

    @Override
    public CellEditorValueExtractor<IPropertySource<Double>> getCellEditorValueExtractor() {
        return new CellEditorValueExtractor<IPropertySource<Double>>("getPropertyValueLabel");
    }

    @Override
    public CellEditorValueModifier<IPropertySource<Double>> getCellEditorValueModifier() {
        return new CellEditorValueModifier<IPropertySource<Double>>("setPropertyValueByLabel", "getPropertyValueLabel");
    }

}
