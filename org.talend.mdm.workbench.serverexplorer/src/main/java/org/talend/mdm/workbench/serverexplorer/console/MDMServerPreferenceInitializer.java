package org.talend.mdm.workbench.serverexplorer.console;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.ui.PlatformUI;


public class MDMServerPreferenceInitializer extends AbstractPreferenceInitializer {

    public static final String REFRESH_FREQ = "_refresh_frequency"; //$NON-NLS-1$

    public static final String DISPLAY_MAX_NUMBER = "_max_number_displayed"; //$NON-NLS-1$

    public MDMServerPreferenceInitializer() {
    }

    @Override
    public void initializeDefaultPreferences() {
        PlatformUI.getPreferenceStore().setDefault(REFRESH_FREQ, 2);
        PlatformUI.getPreferenceStore().setDefault(DISPLAY_MAX_NUMBER, 100);
    }

}
