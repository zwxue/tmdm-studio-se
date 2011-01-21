package com.amalto.workbench.widgets.xmleditor.infoholder;

import com.amalto.workbench.webservices.XtentisPort;

public abstract class ExternalInfoHolder<T> {

    public static final String INFOID_ALLPROCESSNAMES = "all process names";

    public static ExternalInfoHolder<String[]> getAllProcessesNamesHolder(XtentisPort port) {
        return new AllProcessesNamesHolder(port);
    }

    public abstract T getExternalInfo();

    public abstract String getId();
}
