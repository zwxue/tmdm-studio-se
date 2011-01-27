package com.amalto.workbench.widgets.xmleditor.infoholder;

import java.rmi.RemoteException;

import com.amalto.workbench.webservices.WSMDMConfig;
import com.amalto.workbench.webservices.XtentisPort;

public class MDMServerInfoHolder extends ExternalInfoHolder<WSMDMConfig> {

    private XtentisPort port;

    public MDMServerInfoHolder(XtentisPort port) {
        this.port = port;
    }

    @Override
    public WSMDMConfig getExternalInfo() {
        try {
            return port.getMDMConfiguration();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getId() {
        return INFOID_MDMSERVERINFO;
    }

}
