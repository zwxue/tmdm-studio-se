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
import org.talend.mdm.repository.core.validate.datamodel.model.MComponent;
import org.talend.mdm.repository.core.validate.datamodel.model.MElement;
import org.talend.mdm.repository.core.validate.datamodel.validator.visitor.AbstractComponentVisitor;

/**
 * created by HHB on 2013-1-14 Detailled comment
 * 
 */
public abstract class AbstractElementVisitor extends AbstractComponentVisitor {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.visitor.IComponentValidateVisitor#needValidate(org
     * .talend.mdm.repository.core.validate.datamodel.DataModelValidateContext,
     * org.talend.mdm.repository.core.validate.datamodel.model.MComponent)
     */
    @Override
    public boolean needValidate(DataModelValidateContext context, MComponent mComponent) {
        if (mComponent != null) {
            return mComponent instanceof MElement;
        }
        return false;
    }

    protected boolean isEntity(MComponent component) {
        if (component instanceof MElement) {
            MElement entity = ((MElement) component).getEntity();
            return entity == component;
        }
        return false;
    }

}
