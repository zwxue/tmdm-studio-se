package com.amalto.workbench.providers;

import java.util.List;

public abstract class ComboCellEditorIndexExtractor<T> extends CellEditorValueExtractor<T> {

    protected ComboCellEditorIndexExtractor(String inforAccessMethod) {
        super(inforAccessMethod);
    }

    public Object getValue(T info) {

        if (info == null)
            return -1;

        return getAllInfos().indexOf(getInfoContent(info));
    }

    protected abstract List<Object> getAllInfos();
}
