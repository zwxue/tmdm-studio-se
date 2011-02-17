package com.amalto.workbench.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;

public class PreferenceMDMServerExtractor {

    private static final String ENGINE_DESCRIPTION_DELIMITER = "#o#"; //$NON-NLS-1$

    private static final String SPAGOBISERVER_DELIMITER = ";"; //$NON-NLS-1$

    private static final String PLUGIN_QUALIFIER = "org.talend.mdm.engines.client"; //$NON-NLS-1$

    private static final String PREF_KEY_ENABLED = "MDMPreferencePage.spagoBiCheckButton"; //$NON-NLS-1$

    private static final String PREF_KEY_ENABLED_OLD = "SpagoBiPreferencePage.spagoBiCheckButton"; //$NON-NLS-1$

    private static final String PREF_KEY_SERVERS_OLD = "org.talend.repository.properties.spagobiserver"; //$NON-NLS-1$

    private static final String PREF_KEY_SERVERS = "org.talend.repository.properties.mdmserver"; //$NON-NLS-1$

    private static final int SERVERDEF_INDEX_DES = 0;

    private static final int SERVERDEF_INDEX_HOST = 1;

    private static final int SERVERDEF_INDEX_PORT = 2;

    private static final int SERVERDEF_INDEX_USER = 3;

    private static final int SERVERDEF_INDEX_PASSWORD = 4;

    private static PreferenceMDMServerExtractor INSTANCE;

    private PreferenceMDMServerExtractor() {
    }

    public static PreferenceMDMServerExtractor getInstence() {

        if (INSTANCE == null)
            INSTANCE = new PreferenceMDMServerExtractor();

        return INSTANCE;
    }

    public MDMServerDef[] getMDMServerDefiniions() {

        Map<String, MDMServerDef> results = new HashMap<String, MDMServerDef>();

        String enabled = Platform.getPreferencesService().getString(PLUGIN_QUALIFIER, PREF_KEY_ENABLED, null, null);
        if (enabled == null) {
            // when this plug-in is used in a 3.2.1
            enabled = Platform.getPreferencesService().getString(PLUGIN_QUALIFIER, PREF_KEY_ENABLED_OLD, null, null);
        }
        if (enabled == null || !Boolean.valueOf(enabled)) {
            return results.values().toArray(new MDMServerDef[0]);
        }

        String mdmServerString = Platform.getPreferencesService().getString(PLUGIN_QUALIFIER, PREF_KEY_SERVERS, null, null);
        if (mdmServerString == null) {
            // when this plug-in is used in a 3.2.1
            mdmServerString = Platform.getPreferencesService().getString(PLUGIN_QUALIFIER, PREF_KEY_SERVERS_OLD, null, null);
        }

        if (mdmServerString != null) {
            String[] servers = mdmServerString.split(SPAGOBISERVER_DELIMITER);
            for (String server : servers) {
                String[] splits = server.split(ENGINE_DESCRIPTION_DELIMITER);
                MDMServerDef serv = null;

                if (splits.length < 5)
                    continue;

                serv = new MDMServerDef(splits[SERVERDEF_INDEX_DES], splits[SERVERDEF_INDEX_HOST], splits[SERVERDEF_INDEX_PORT],
                        splits[SERVERDEF_INDEX_USER], splits[SERVERDEF_INDEX_PASSWORD]);

                results.put(serv.getUrl(), serv);
            }
        }

        return results.values().toArray(new MDMServerDef[0]);
    }
}
