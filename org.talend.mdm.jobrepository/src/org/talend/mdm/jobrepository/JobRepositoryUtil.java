// ============================================================================
//
// Copyright (C) 2006-2008 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.jobrepository;

import java.util.List;

import org.talend.core.CorePlugin;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.repository.ProjectManager;

/**
 * DOC achen class global comment. Detailled comment
 */
public class JobRepositoryUtil {

    public static List<IRepositoryViewObject> getAllTISRepositoryJobs() throws Exception {

        List<IRepositoryViewObject> jobs = CorePlugin.getDefault().getProxyRepositoryFactory().getAll(
                ProjectManager.getInstance().getCurrentProject(), ERepositoryObjectType.PROCESS);
        return jobs;
    }

}
