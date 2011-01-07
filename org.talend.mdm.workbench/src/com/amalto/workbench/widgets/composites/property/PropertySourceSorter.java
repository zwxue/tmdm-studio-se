package com.amalto.workbench.widgets.composites.property;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class PropertySourceSorter extends ViewerSorter {

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {

        if (e1 instanceof IPropertySource && e2 instanceof IPropertySource) {
            return ((IPropertySource<?>) e1).getPropertyName().compareTo(((IPropertySource<?>) e2).getPropertyName());
        }

        return super.compare(viewer, e1, e2);
    }

}
