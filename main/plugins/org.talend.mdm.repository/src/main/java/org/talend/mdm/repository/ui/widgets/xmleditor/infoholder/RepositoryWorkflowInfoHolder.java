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
package org.talend.mdm.repository.ui.widgets.xmleditor.infoholder;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.widgets.xmleditor.util.WorkflowInfo;

public class RepositoryWorkflowInfoHolder extends RepositoryExternalInfoHolder<WorkflowInfo[]> {

    static Logger log = Logger.getLogger(RepositoryWorkflowInfoHolder.class);

    public RepositoryWorkflowInfoHolder() {
    }

    @Override
    public WorkflowInfo[] getExternalInfo() {

        List<WorkflowInfo> results = new LinkedList<WorkflowInfo>();
        List<IRepositoryViewObject> viewObjs = RepositoryResourceUtil
                .findAllViewObjects(IServerObjectRepositoryType.TYPE_WORKFLOW);

        for (IRepositoryViewObject viewObj : viewObjs) {
            Property prop = viewObj.getProperty();
            WorkflowInfo workflowInfo = new WorkflowInfo(prop.getLabel(), prop.getVersion());
            results.add(workflowInfo);
        }

        return results.toArray(new WorkflowInfo[0]);

    }

    @Override
    public String getId() {
        return INFOID_ALLWORKFLOWINFOS;
    }

}
