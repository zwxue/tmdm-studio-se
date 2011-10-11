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
package org.talend.mdm.repository.ui.dialogs.xsd;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.talend.mdm.repository.ui.widgets.TisTableViewerR;

import com.amalto.workbench.dialogs.ValidationRuleDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.utils.XSDAnnotationsStructure;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;
import com.amalto.workbench.widgets.TisTableViewer;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ValidationRuleDialogR extends ValidationRuleDialog {

    /**
     * DOC hbhong ValidationRuleDialogR constructor comment.
     * 
     * @param parentShell
     * @param title
     * @param pattern
     * @param page
     * @param conceptName
     * @param struc
     */
    public ValidationRuleDialogR(Shell parentShell, String title, String pattern, DataModelMainPage page, String conceptName,
            XSDAnnotationsStructure struc) {
        super(parentShell, title, pattern, page, conceptName, struc);
    }

    /**
     * DOC hbhong ValidationRuleDialogR constructor comment.
     * 
     * @param parentShell
     * @param title
     * @param pattern
     * @param page
     * @param conceptName
     */
    public ValidationRuleDialogR(Shell parentShell, String title, String pattern, DataModelMainPage page, String conceptName) {
        super(parentShell, title, pattern, page, conceptName);
    }

    @Override
    protected TisTableViewer getNewTisTableViewer(List<ComplexTableViewerColumn> columns, FormToolkit toolkit, Composite parent) {
        return new TisTableViewerR(columns, toolkit, parent);
    }

}
