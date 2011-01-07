package com.amalto.workbench.detailtabs.sections.model.simpletype.propsource;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.amalto.workbench.detailtabs.sections.model.simpletype.SimpleTypeStringFacetInfo;
import com.amalto.workbench.providers.ArrayComboCellEditorIndexExtractor;
import com.amalto.workbench.providers.ArrayComboCellEditorValueModifier;
import com.amalto.workbench.providers.CellEditorValueExtractor;
import com.amalto.workbench.providers.CellEditorValueModifier;
import com.amalto.workbench.widgets.composites.property.IPropertySource;

public class SimpleTypeFacetArrayStrPropertySource extends SimpleTypeFacetPropertySource<String, SimpleTypeStringFacetInfo> {

    private String[] candidates = new String[0];

    public SimpleTypeFacetArrayStrPropertySource(Composite cellEditorParent, String propName, String value, String[] candidates) {
        super(cellEditorParent, new SimpleTypeStringFacetInfo(propName, value));

        this.candidates = candidates;
    }

    @Override
    public CellEditor getCellEditor() {
        return new ComboBoxCellEditor(cellEditorParent, candidates, SWT.READ_ONLY);
    }

    @Override
    public CellEditorValueExtractor<IPropertySource<String>> getCellEditorValueExtractor() {
        return new ArrayComboCellEditorIndexExtractor<IPropertySource<String>>(candidates, "getPropertyValueLabel");
    }

    @Override
    public CellEditorValueModifier<IPropertySource<String>> getCellEditorValueModifier() {
        return new ArrayComboCellEditorValueModifier<IPropertySource<String>>(candidates, "setPropertyValueByLabel",
                "getPropertyValueLabel");
    }
}
