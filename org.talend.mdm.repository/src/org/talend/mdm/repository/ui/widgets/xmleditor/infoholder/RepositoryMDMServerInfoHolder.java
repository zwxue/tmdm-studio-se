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
package org.talend.mdm.repository.ui.widgets.xmleditor.infoholder;

import org.apache.log4j.Logger;

import com.amalto.workbench.webservices.WSMDMConfig;
import com.amalto.workbench.webservices.XtentisPort;

public class RepositoryMDMServerInfoHolder extends RepositoryExternalInfoHolder<WSMDMConfig> {

    static Logger log = Logger.getLogger(RepositoryMDMServerInfoHolder.class);

    public RepositoryMDMServerInfoHolder(XtentisPort port) {
    }

    @Override
    public WSMDMConfig getExternalInfo() {
        // try {
        // return port.getMDMConfiguration();
        // } catch (RemoteException e) {
        // log.error(e.getMessage(), e);
        return null;
        // }
    }

    @Override
    public String getId() {
        return INFOID_MDMSERVERINFO;
    }

}
