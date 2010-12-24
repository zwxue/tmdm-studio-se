package com.amalto.workbench.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Item;

public abstract class CommonTableCellModifier<T> implements ICellModifier {

    protected Map<String, CellEditorValueExtractor<T>> prop2ValueIndexExtractor = new HashMap<String, CellEditorValueExtractor<T>>();

    protected Map<String, CellEditorValueModifier<T>> prop2ValueModifier = new HashMap<String, CellEditorValueModifier<T>>();

    public boolean canModify(Object element, String property) {
        return false;
    }

    @SuppressWarnings("unchecked")
    public Object getValue(Object element, String property) {

        if (element == null || !prop2ValueIndexExtractor.containsKey(property))
            return null;
        try {
            return prop2ValueIndexExtractor.get(property).getValue((T) element);
        } catch (Exception e) {
            return null;
        }
    }

    public void modify(Object element, String property, Object value) {

        if (!doModify(element, property, value))
            return;

        if (getViewer() != null)
            getViewer().refresh();
    }

    private boolean doModify(Object element, String property, Object value) {

        if (element == null || !prop2ValueModifier.containsKey(property))
            return false;

        try {
            prop2ValueModifier.get(property).modify(getWorkflowAccessInfoFromSelection(element), value);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    private T getWorkflowAccessInfoFromSelection(Object selection) {

        if (!(selection instanceof Item))
            return null;

        try {
            return (T) ((Item) selection).getData();
        } catch (Exception e) {
            return null;
        }
    }

    protected abstract Viewer getViewer();
}
