// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.widgets.xmleditor.infoholder;

import java.util.ArrayList;
import java.util.List;

import com.amalto.workbench.webservices.TMDMService;
import com.amalto.workbench.webservices.WsGetTransformerV2PKs;
import com.amalto.workbench.webservices.WsTransformerV2PK;

class AllProcessesNamesHolder extends ExternalInfoHolder<String[]> {

    private TMDMService service;

    public AllProcessesNamesHolder(TMDMService service) {
        this.service = service;
    }

    @Override
    public String[] getExternalInfo() {

        if (service == null) {
            return new String[0];
        }

        List<WsTransformerV2PK> transformerPKs = null;
        try {
            transformerPKs = service.getTransformerV2PKs(new WsGetTransformerV2PKs("")).getWsTransformerV2PK();//$NON-NLS-1$
        } catch (Exception e) {
            return new String[0];
        }
        List<String> processes = new ArrayList<String>();
        if (transformerPKs != null) {
            for (WsTransformerV2PK pk : transformerPKs) {
                if (pk.getPk() != null && pk.getPk().length() > 0) {
                    processes.add(pk.getPk());
                }
            }
        }

        return processes.toArray(new String[0]);
    }

    @Override
    public String getId() {
        return INFOID_ALLPROCESSNAMES;
    }

}
