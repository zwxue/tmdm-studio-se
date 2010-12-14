package com.amalto.workbench.detailtabs.sections.providers;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.amalto.workbench.detailtabs.sections.model.LanguageInfo;

public class LanguageInfoLabelProvider implements ITableLabelProvider {

    private static final int COLINDEX_LANG = 0;

    public void addListener(ILabelProviderListener listener) {
    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
    }

    public Image getColumnImage(Object element, int columnIndex) {
        return null;
    }

    public String getColumnText(Object element, int columnIndex) {

        if (element instanceof LanguageInfo) {
            return getColumnTextByIndex((LanguageInfo) element, columnIndex);
        }

        return "";
    }

    private String getColumnTextByIndex(LanguageInfo element, int columnIndex) {

        if (columnIndex == COLINDEX_LANG)
            return element.getLanguage();

        return element.getLabel();
    }

}
