package com.amalto.workbench.detailtabs.sections.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class StringLabelProvider implements ILabelProvider {

    public void addListener(ILabelProviderListener listener) {

    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {

    }

    public Image getImage(Object element) {
        return null;
    }

    public String getText(Object element) {

        if (element == null)
            return "";

        return element.toString();
    }

}
