// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
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

import org.apache.log4j.Logger;
import org.eclipse.xsd.XSDSchema;
import org.talend.mdm.repository.model.mdmserverobject.WSDataModelE;

import com.amalto.workbench.detailtabs.sections.IMDMRepositoryViewServiceExt;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.Util;


 
public class MDMRepositoryViewServiceExt implements IMDMRepositoryViewServiceExt {

    private static Logger log = Logger.getLogger(MDMRepositoryViewServiceExt.class);

    public List<String> findAllRoleNames() {
        return RepositoryQueryService.findAllRoleNames();
    }

    public List<String> findAllWorkflowNames() {
        return RepositoryQueryService.findAllWorkflowNames();
    }

    public List<String> findAllDataModelNames() {
        return RepositoryQueryService.findAllDataModelNames();
    }

    public XSDSchema getDataModelXsd(TreeParent pObject, String filter, String dataModelName) {

        WSDataModelE wsDataModel = RepositoryQueryService.findDataModelByName(dataModelName);
        XSDSchema xsd = null;
        if (wsDataModel != null) {
            try {

                String schema = wsDataModel.getXsdSchema();
                xsd = Util.createXsdSchema(schema, pObject);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return xsd;
    }

}
