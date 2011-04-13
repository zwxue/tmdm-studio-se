// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;

/**
 * @deprecated
 * @author achen
 *
 */
public class PreferenceMDMServerExtractor {

    private static final String PREFERENCENODE = "instance"; //$NON-NLS-1$

    private static final String ENGINE_DESCRIPTION_DELIMITER = "#o#"; //$NON-NLS-1$

    private static final String SPAGOBISERVER_DELIMITER = ";"; //$NON-NLS-1$

    private static final String PLUGIN_QUALIFIER = "org.talend.mdm.engines.client"; //$NON-NLS-1$

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

    public MDMServerDef[] getMDMServerDefinitions() {

        Map<String, MDMServerDef> results = new HashMap<String, MDMServerDef>();

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

    public void updateMDMServerDefinitionsBy(String url, String username, String password, String description) {

        MDMServerDef serverDef = MDMServerDef.parse(url, username, password, description);

        if (serverDef == null)
            return;

        updateMDMServerDefinitionsBy(serverDef);
    }

    public void updateMDMServerDefinitionsBy(MDMServerDef serverDef) {

        if (serverDef == null)
            return;

        List<MDMServerDef> servers = new ArrayList<MDMServerDef>();

        for (MDMServerDef eachCurrentMDMServerDef : getMDMServerDefinitions()) {

            if (eachCurrentMDMServerDef.getHost().equals(serverDef.getHost())
                    && eachCurrentMDMServerDef.getPort().equals(serverDef.getPort())
                    && eachCurrentMDMServerDef.getUser().equals(serverDef.getUser())
                    && eachCurrentMDMServerDef.getPasswd().equals(serverDef.getPasswd())) {
                servers.add(serverDef);
            } else {
                servers.add(eachCurrentMDMServerDef);
            }
        }

        if (!servers.contains(serverDef))
            servers.add(serverDef);

        // String propName = PREF_KEY_SERVERS;
        // if (Platform.getPreferencesService().getString(PLUGIN_QUALIFIER, PREF_KEY_SERVERS, null, null) == null) {
        // // when this plug-in is used in a 3.2.1
        // propName = PREF_KEY_SERVERS_OLD;
        // }

        Platform.getPreferencesService().getRootNode().node(PREFERENCENODE).node(PLUGIN_QUALIFIER)
                .put(PREF_KEY_SERVERS, toMDMServerPreferenceString(servers.toArray(new MDMServerDef[0])));

    }

    private String toMDMServerPreferenceString(MDMServerDef[] serverDef) {

        StringBuilder sb = new StringBuilder();

        for (MDMServerDef eachServerDef : serverDef) {

            sb.append(toMDMServerPreferenceString(eachServerDef));
            sb.append(SPAGOBISERVER_DELIMITER);
        }

        String result = sb.toString();
        return result.substring(0, result.length() - SPAGOBISERVER_DELIMITER.length());
    }

    private String toMDMServerPreferenceString(MDMServerDef serverDef) {

        StringBuilder sb = new StringBuilder();

        sb.append(serverDef.getDesc());
        sb.append(ENGINE_DESCRIPTION_DELIMITER);

        sb.append(serverDef.getHost());
        sb.append(ENGINE_DESCRIPTION_DELIMITER);

        sb.append(serverDef.getPort());
        sb.append(ENGINE_DESCRIPTION_DELIMITER);

        sb.append(serverDef.getUser());
        sb.append(ENGINE_DESCRIPTION_DELIMITER);

        sb.append(serverDef.getPasswd());

        return sb.toString();
    }
}
