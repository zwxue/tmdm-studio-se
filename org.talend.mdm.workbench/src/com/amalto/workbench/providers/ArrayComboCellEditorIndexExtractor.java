package com.amalto.workbench.providers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayComboCellEditorIndexExtractor<T> extends ComboCellEditorIndexExtractor<T> {

    private List<Object> allInfos = new ArrayList<Object>();

    public ArrayComboCellEditorIndexExtractor(Object[] allInfos, String inforAccessMethod) {
        super(inforAccessMethod);

        this.allInfos = Arrays.asList(allInfos);
    }

    public ArrayComboCellEditorIndexExtractor(Collection<Object> allInfos, String inforAccessMethod) {
        this(allInfos.toArray(), inforAccessMethod);
    }

    @Override
    protected List<Object> getAllInfos() {
        return allInfos;
    }

}
