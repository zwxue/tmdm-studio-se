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

import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.dialogs.xsd.ValidationRuleDialogR;
import org.talend.mdm.workbench.enterprice.actions.XSDSetAnnotationSchematronAction;

import com.amalto.workbench.dialogs.ValidationRuleDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class XSDSetAnnotationSchematronActionR extends XSDSetAnnotationSchematronAction {

    /**
     * DOC hbhong XSDSetAnnotationSchematronActionR constructor comment.
     * 
     * @param page
     * @param dataModelName
     */
    public XSDSetAnnotationSchematronActionR(DataModelMainPage page, String dataModelName) {
        super(page, dataModelName);
    }

    protected ValidationRuleDialog getNewValidationRuleDialog(String textContext, String conceptName,
            XSDAnnotationsStructure struc) {
        return new ValidationRuleDialogR(page.getSite().getShell(), Messages.XSDSetAnnotationSchematronActionR_title, textContext, page, conceptName,
                struc);
    }

}
