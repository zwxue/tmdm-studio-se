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
package com.amalto.workbench.widgets.xmleditor.infoholder;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.infoextractor.IAllDataModelHolder;
import com.amalto.workbench.utils.JobInfo;
import com.amalto.workbench.webservices.WSMDMConfig;
import com.amalto.workbench.webservices.WSTransformerV2;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.xmleditor.util.WorkflowInfo;

public abstract class ExternalInfoHolder<T> {

    public static final String INFOID_ALLPROCESSNAMES = "all process names";//$NON-NLS-1$

    public static final String INFOID_ALLJOBINFOS = "all job infos";//$NON-NLS-1$

    public static final String INFOID_MDMSERVERINFO = "mdm server info";//$NON-NLS-1$

    public static final String INFOID_ALLWORKFLOWINFOS = "all work flow infos";//$NON-NLS-1$

    public static final String INFOID_ALLDATAMODELHOLDER = "all data model holder";//$NON-NLS-1$

    public static final String INFOID_ALLCALLJOBVARIABLES = "all calljob vars";//$NON-NLS-1$

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
