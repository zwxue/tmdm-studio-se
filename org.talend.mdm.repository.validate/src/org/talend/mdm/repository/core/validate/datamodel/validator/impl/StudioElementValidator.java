// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.validate.datamodel.validator.impl;

import java.util.List;

import org.talend.mdm.repository.core.validate.datamodel.validator.rule.IComponentValidationRule;
import org.talend.mdm.repository.core.validate.datamodel.validator.rule.ValidateRuleRegistry;

/**
 * created by HHB on 2013-1-29 Detailled comment
 * 
 */
public class StudioElementValidator extends ElementValidator {

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.validator.IDataModelValidator#getVisitors()
     */
    @Override
    public List<IComponentValidationRule> getValidationRules() {
        if (rules == null) {
            rules = ValidateRuleRegistry.getInstance().getRules("Element"); //$NON-NLS-1$
        }
        return rules;
    }
}
