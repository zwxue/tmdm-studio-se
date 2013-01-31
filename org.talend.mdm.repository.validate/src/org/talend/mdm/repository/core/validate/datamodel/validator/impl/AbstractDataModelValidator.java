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

import org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext;
import org.talend.mdm.repository.core.validate.datamodel.validator.IDataModelValidator;
import org.talend.mdm.repository.core.validate.datamodel.validator.ModelValidationMessage;

/**
 * created by HHB on 2013-1-8 Detailled comment
 * 
 */
public abstract class AbstractDataModelValidator implements IDataModelValidator {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.IDataModelValidator#multiValidate(org.talend.mdm.
     * repository.core.validate.datamodel.DataModelValidateContext)
     */
    @Override
    public List<ModelValidationMessage> validate(DataModelValidateContext context) {
        return null;
    }

}
