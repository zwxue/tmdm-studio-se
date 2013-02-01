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
package org.talend.mdm.repository.core.validate.datamodel.validator.visitor.element;

import org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext;
import org.talend.mdm.repository.core.validate.datamodel.model.IMComponent;
import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.validator.visitor.AbstractComponentValidationRule;

/**
 * created by HHB on 2013-1-14 Detailled comment
 * 
 */
public abstract class AbstractElementValidationRule extends AbstractComponentValidationRule {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.visitor.IComponentValidateVisitor#needValidate(org
     * .talend.mdm.repository.core.validate.datamodel.DataModelValidateContext,
     * org.talend.mdm.repository.core.validate.datamodel.model.MComponent)
     */
    @Override
    public boolean needValidate(DataModelValidateContext context, IMComponent mComponent) {
        if (mComponent != null) {
            return mComponent instanceof IMElement;
        }
        return false;
    }

    protected boolean isEntity(IMComponent component) {
        if (component instanceof IMElement) {
            IMElement entity = ((IMElement) component).getEntity();
            return entity == component;
        }
        return false;
    }

}
