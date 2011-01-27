package com.amalto.workbench.widgets.xmleditor.infoholder;

import com.amalto.workbench.utils.JobInfo;
import com.amalto.workbench.webservices.WSMDMConfig;
import com.amalto.workbench.webservices.XtentisPort;

public abstract class ExternalInfoHolder<T> {

    public static final String INFOID_ALLPROCESSNAMES = "all process names";

    public static final String INFOID_ALLJOBINFOS = "all job infos";

    public static final String INFOID_MDMSERVERINFO = "mdm server info";

    public static ExternalInfoHolder<String[]> getAllProcessesNamesHolder(XtentisPort port) {
        return new AllProcessesNamesHolder(port);
    }

    public static ExternalInfoHolder<JobInfo[]> getAllJobInfosHolder(XtentisPort port) {
        return new AllJobInfoHolder(port);
    }

    public static ExternalInfoHolder<WSMDMConfig> getAllMDMServerInfoHolder(XtentisPort port) {
        return new MDMServerInfoHolder(port);
    }

    public abstract T getExternalInfo();

    public abstract String getId();
}
