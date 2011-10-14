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
package org.talend.mdm.repository.ui.dialogs.workflow;

import java.util.Collection;
import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.workbench.enterprice.dialog.WorkflowAccessDialog;

import com.amalto.workbench.editors.DataModelMainPage;


/**
 * DOC hbhong  class global comment. Detailled comment
 */
public class WorkflowAccessDialogR extends WorkflowAccessDialog {

    /**
     * DOC hbhong WorkflowAccessDialogR constructor comment.
     * 
     * @param parentShell
     * @param title
     * @param pattern
     * @param page
     * @param conceptName
     */
    public WorkflowAccessDialogR(Shell parentShell, String title, Collection<String> pattern, DataModelMainPage page,
            String conceptName) {
        super(parentShell, title, pattern, page, conceptName);
    }

    @Override
    protected List<String> getAllRolesStr() {
        return RepositoryQueryService.findAllRoleNames();
    }

    @Override
    protected List<String> getAllWorkflowProcessesStr() {
        return RepositoryQueryService.findAllWorkflowNames();
    }

}
