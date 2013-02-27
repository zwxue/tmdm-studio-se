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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext;
import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.validator.ModelValidationMessage;
import org.talend.mdm.repository.core.validate.datamodel.validator.rule.IComponentValidationRule;

/**
 * created by HHB on 2013-1-8 Detailled comment
 * 
 */
public abstract class ElementValidator extends AbstractDataModelValidator {

    protected List<IComponentValidationRule> rules;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.IDataModelValidator#multiValidate(org.talend.mdm.
     * repository.core.validate.datamodel.DataModelValidateContext)
     */
    @Override
    public List<ModelValidationMessage> validate(DataModelValidateContext context) {
        List<ModelValidationMessage> messages = new LinkedList<ModelValidationMessage>();
        validateEntities(context, messages);
        return messages;
    }

    private void validateEntities(DataModelValidateContext context, List<ModelValidationMessage> messages) {
        Set<ModelValidationMessage> tempMsgs = new HashSet<ModelValidationMessage>();
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
    private void validateElement(DataModelValidateContext context, IMElement element, Set<ModelValidationMessage> messages) {
        for (IComponentValidationRule visitor : getValidationRules()) {
            validateElement(context, visitor, element, messages);
        }
    }

    private void validateElement(DataModelValidateContext context, IComponentValidationRule visitor, IMElement element,
            Set<ModelValidationMessage> messages) {
        if (visitor.needValidate(context, element)) {

            boolean result = visitor.check(context, element, messages);
            if (result && element.getElements() != null) {
                for (IMElement child : element.getElements()) {
                    validateElement(context, visitor, child, messages);
                }
            }
        }
    }

}
