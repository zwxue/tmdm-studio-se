// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
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
import org.talend.mdm.repository.ui.dialogs.ValidationRuleExcpressDialog2;

import com.amalto.workbench.actions.XSDVisibleRuleAction;
import com.amalto.workbench.dialogs.ValidationRuleExcpressDialog;
import com.amalto.workbench.editors.DataModelMainPage;


/**
 * DOC achen  class global comment. Detailled comment
 */
public class XSDVisibleRuleActionR extends XSDVisibleRuleAction {

    /**
     * DOC achen XSDVisibleRuleActionR constructor comment.
     * 
     * @param page
     * @param dataModelName
     */
    public XSDVisibleRuleActionR(DataModelMainPage page, String dataModelName) {
        super(page, dataModelName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.amalto.workbench.actions.XSDVisibleRuleAction#getExpressDialog()
     */
    @Override
    protected ValidationRuleExcpressDialog getExpressDialog() {
        return new ValidationRuleExcpressDialog2(page.getSite().getShell(), getTreeParent(), Messages.XSDVisibleXXR_BuildvalidationExpress,
                struc.getVisibleRule(), conceptName, true, false);
    }
}
