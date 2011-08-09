package org.talend.mdm.webapp.synchronizationAction2.client.widget;

import com.extjs.gxt.ui.client.widget.ContentPanel;


public class GenerateContainer {

    private static ContentPanel instance;

    public static void generateContentPanel() {
        instance = new SynchronizationActionPanel() {
        };
        instance.setId("synchronizationAction2"); //$NON-NLS-1$
    }

    public static ContentPanel getContentPanel() {
        return instance;
    }
}
