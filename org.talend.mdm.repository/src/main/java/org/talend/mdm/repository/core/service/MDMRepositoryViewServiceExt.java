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
package org.talend.mdm.repository.core.service;

import java.util.List;

import com.amalto.workbench.detailtabs.sections.IMDMRepositoryViewServiceExt;


 
public class MDMRepositoryViewServiceExt implements IMDMRepositoryViewServiceExt {

    public List<String> findAllRoleNames() {
        return RepositoryQueryService.findAllRoleNames();
    }

    public List<String> findAllWorkflowNames() {
        return RepositoryQueryService.findAllWorkflowNames();
    }

    public List<String> findAllDataModelNames() {
        return RepositoryQueryService.findAllDataModelNames();
    }
}
