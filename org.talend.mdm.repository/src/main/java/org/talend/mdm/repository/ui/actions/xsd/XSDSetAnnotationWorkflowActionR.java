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
package org.talend.mdm.repository.ui.actions.xsd;

import java.util.Collection;

import org.talend.mdm.repository.ui.dialogs.workflow.WorkflowAccessDialogR;
import org.talend.mdm.workbench.enterprice.actions.XSDSetAnnotationWorkflowAction;
import org.talend.mdm.workbench.enterprice.dialog.WorkflowAccessDialog;

import com.amalto.workbench.editors.DataModelMainPage;


/**
 * DOC hbhong  class global comment. Detailled comment
 */
public class XSDSetAnnotationWorkflowActionR extends XSDSetAnnotationWorkflowAction {

    /**
     * DOC hbhong XSDSetAnnotationWorkflowActionR constructor comment.
     * 
     * @param page
     * @param dataModelName
     */
    public XSDSetAnnotationWorkflowActionR(DataModelMainPage page, String dataModelName) {
        super(page, dataModelName);
    }

    protected WorkflowAccessDialog getNewWorkflowAccessDlg(Collection<String> values, String conceptName) {
        return new WorkflowAccessDialogR(page.getSite().getShell(), getText(), values, page, conceptName);
    }
}
