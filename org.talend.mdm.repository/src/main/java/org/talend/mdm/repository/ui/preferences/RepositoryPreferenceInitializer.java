package org.talend.mdm.repository.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.talend.mdm.repository.core.service.ConsistencyService;
import org.talend.mdm.repository.plugin.RepositoryPlugin;

public class RepositoryPreferenceInitializer extends AbstractPreferenceInitializer implements PreferenceConstants {

    public RepositoryPreferenceInitializer() {
    }

    @Override
    public void initializeDefaultPreferences() {
        IPreferenceStore store = RepositoryPlugin.getDefault().getPreferenceStore();
        initConsistencyConflictPreference(store);

    }

    void initConsistencyConflictPreference(IPreferenceStore store) {
        store.setDefault(PreferenceConstants.P_WARN_USER_HAS_CONFLICT, true);
        store.setDefault(PreferenceConstants.P_CONFLICT_STRATEGY, ConsistencyService.CONFLICT_STRATEGY_DEFAULT);
    }

}
