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
package org.talend.mdm.repository.core.validate.datamodel.validator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext;
import org.talend.mdm.repository.core.validate.datamodel.DataModelValidationMessage;
import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.validator.visitor.IComponentValidateVisitor;
import org.talend.mdm.repository.core.validate.datamodel.validator.visitor.ValidateVistorRegistry;

/**
 * created by HHB on 2013-1-8 Detailled comment
 * 
 */
public class ElementValidator extends AbstractDataModelValidator {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.IDataModelValidator#multiValidate(org.talend.mdm.
     * repository.core.validate.datamodel.DataModelValidateContext)
     */
    @Override
    public List<DataModelValidationMessage> validate(DataModelValidateContext context) {
        List<DataModelValidationMessage> messages = new LinkedList<DataModelValidationMessage>();
        validateEntities(context, messages);
        return messages;
    }

    private void validateEntities(DataModelValidateContext context, List<DataModelValidationMessage> messages) {
        Set<DataModelValidationMessage> tempMsgs = new HashSet<DataModelValidationMessage>();
        for (IMElement entity : context.getModelRoot().getElements()) {
            validateElement(context, entity, tempMsgs);
        }
        messages.addAll(tempMsgs);
    }

    /**
     * DOC HHB Comment method "validateElement".
     * 
     * @param entity
     */
    private void validateElement(DataModelValidateContext context, IMElement element, Set<DataModelValidationMessage> messages) {
        List<IComponentValidateVisitor> visitors = ValidateVistorRegistry.getInstance().getVisitors();
        for (IComponentValidateVisitor visitor : visitors) {
            validateElement(context, visitor, element, messages);
        }
    }

    private void validateElement(DataModelValidateContext context, IComponentValidateVisitor visitor, IMElement element,
            Set<DataModelValidationMessage> messages) {
        if (visitor.needValidate(context, element)) {
            boolean result = element.acceptValidateVisitor(visitor, context, messages);
            if (result && element.getElements() != null) {
                for (IMElement child : element.getElements()) {
                    validateElement(context, visitor, child, messages);
                }
            }
        }
    }
}
