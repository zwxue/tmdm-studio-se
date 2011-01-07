package com.amalto.workbench.widgets.composites.property;

import org.eclipse.jface.viewers.CellEditor;

import com.amalto.workbench.providers.CellEditorValueExtractor;
import com.amalto.workbench.providers.CellEditorValueModifier;

public interface IPropertySource<T> {

    public String getPropertyName();

    public String getPropertyValueLabel();

    public void setPropertyValueByLabel(String label);

    public T getPropertyValue();

    public CellEditor getCellEditor();

    public CellEditorValueExtractor<IPropertySource<T>> getCellEditorValueExtractor();

    public CellEditorValueModifier<IPropertySource<T>> getCellEditorValueModifier();
}
