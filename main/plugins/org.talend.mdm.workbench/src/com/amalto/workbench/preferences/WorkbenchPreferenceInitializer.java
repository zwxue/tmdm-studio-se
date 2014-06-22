package com.amalto.workbench.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.amalto.workbench.MDMWorbenchPlugin;

public class WorkbenchPreferenceInitializer extends AbstractPreferenceInitializer {

    public WorkbenchPreferenceInitializer() {
    }

    @Override
    public void initializeDefaultPreferences() {
        IPreferenceStore store = MDMWorbenchPlugin.getDefault().getPreferenceStore();
        initMdmPreference(store);

    }

    public static void initMdmPreference(IPreferenceStore store) {
        store.setDefault(PreferenceConstants.SSL_Algorithm, SSLPreferences.getDefaultAlgorithmType());
        store.setDefault(PreferenceConstants.VERIFY_HOSTNAME, false);
        store.setDefault(PreferenceConstants.KEYSTORE_FILE, ""); //$NON-NLS-1$
        store.setDefault(PreferenceConstants.KEYSTORE_PASSWORD, ""); //$NON-NLS-1$
        store.setDefault(PreferenceConstants.KEYSTORE_TYPE, SSLPreferences.getDefaultKeystoreType());
        store.setDefault(PreferenceConstants.TRUSTSTORE_FILE, ""); //$NON-NLS-1$
        store.setDefault(PreferenceConstants.TRUSTSTORE_PASSWORD, ""); //$NON-NLS-1$
        store.setDefault(PreferenceConstants.TRUSTSTORE_TYPE, SSLPreferences.getDefaultKeystoreType());

    }

}
