package com.amalto.workbench.widgets.xmleditor.infoholder;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.infoextractor.IAllDataModelHolder;
import com.amalto.workbench.utils.JobInfo;
import com.amalto.workbench.webservices.WSMDMConfig;
import com.amalto.workbench.webservices.WSTransformerV2;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.xmleditor.util.WorkflowInfo;

public abstract class ExternalInfoHolder<T> {

    public static final String INFOID_ALLPROCESSNAMES = "all process names";

    public static final String INFOID_ALLJOBINFOS = "all job infos";

    public static final String INFOID_MDMSERVERINFO = "mdm server info";

    public static final String INFOID_ALLWORKFLOWINFOS = "all work flow infos";

    public static final String INFOID_ALLDATAMODELHOLDER = "all data model holder";

    public static final String INFOID_ALLCALLJOBVARIABLES = "all calljob vars";

    public static ExternalInfoHolder<String[]> getAllProcessesNamesHolder(XtentisPort port) {
        return new AllProcessesNamesHolder(port);
    }

    public static ExternalInfoHolder<JobInfo[]> getAllJobInfosHolder(XtentisPort port) {
        return new AllJobInfoHolder(port);
    }

    public static ExternalInfoHolder<WSMDMConfig> getAllMDMServerInfoHolder(XtentisPort port) {
        return new MDMServerInfoHolder(port);
    }

    public static ExternalInfoHolder<IAllDataModelHolder> getAllDataModelInfoHolderProxy(TreeObject treeNode) {
        return new AllDataModelInfoHolderProxy(treeNode);
    }

    public static ExternalInfoHolder<WorkflowInfo[]> getAllWorkflowInfoHolder(XtentisPort port) {
        return new AllWorkflowInfoHolder(port);
    }

    public static ExternalInfoHolder<String[]> getProcessAllCallJobVarsCandidatesHolder(WSTransformerV2 service) {
        return new ProcessAllCallJobVariableCandidatesHolder(service);
    }

    public static ExternalInfoHolder<String[]> getTriggerAllCallJobVarsCandidatesHolder() {
        return new TriggerAllCallJobVariableCandidatesHolder();
    }

    public abstract T getExternalInfo();

    public abstract String getId();
}
