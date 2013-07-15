package com.amalto.workbench.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.amalto.workbench.MDMWorbenchPlugin;

public class WorkbenchProferenceInitializer extends AbstractPreferenceInitializer {

    public WorkbenchProferenceInitializer() {
    }

    @Override
    public void initializeDefaultPreferences() {
        IPreferenceStore store = MDMWorbenchPlugin.getDefault().getPreferenceStore();
        initMdmPreference(store);

    }

    public static void initMdmPreference(IPreferenceStore store) {
        store.setDefault(PreferenceConstants.SSL_Algorithm, SSLPreperences.SSL_ALGORITHMS[0]);
        store.setDefault(PreferenceConstants.VERIFY_TYPE, SSLPreperences.VERIFY_MODES.keySet().iterator().next());
        store.setDefault(PreferenceConstants.KEYSTORE_TYPE, SSLPreperences.KEYSTORE_TYPES[0]);
    }

}
