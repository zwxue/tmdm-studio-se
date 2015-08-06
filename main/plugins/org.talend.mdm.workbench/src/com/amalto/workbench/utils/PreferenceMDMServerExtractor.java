// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
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

        sb.append(serverDef.getName());
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
