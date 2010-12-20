package com.amalto.workbench.detailtabs.sections.providers;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import com.amalto.workbench.detailtabs.sections.model.annotationinfo.langinfo.LanguageInfo;

public class LanguageInfoSorter extends ViewerSorter {

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {

        if (e1 instanceof LanguageInfo && e2 instanceof LanguageInfo) {
            return ((LanguageInfo) e1).getLanguage().compareTo(((LanguageInfo) e2).getLanguage());
        }

        return super.compare(viewer, e1, e2);
    }

}
