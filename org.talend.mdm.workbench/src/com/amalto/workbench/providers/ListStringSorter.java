package com.amalto.workbench.providers;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class ListStringSorter extends ViewerSorter {

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {

        if (e1 != null && e2 != null)
            return e1.toString().compareTo(e2.toString());

        return super.compare(viewer, e1, e2);
    }

}
