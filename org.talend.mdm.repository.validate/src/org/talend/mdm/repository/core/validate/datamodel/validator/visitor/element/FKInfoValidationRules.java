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

import java.util.Set;

import org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext;
import org.talend.mdm.repository.core.validate.datamodel.model.IElementContainer;
import org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotation;
import org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotationUnit;
import org.talend.mdm.repository.core.validate.datamodel.model.IMComponent;
import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.validator.ModelValidationMessage;
import org.talend.mdm.repository.core.validate.i18n.Messages;

/**
 * created by HHB on 2013-1-14 Detailled comment
 * 
 */
public class FKInfoValidationRules extends AbstractElementValidationRule {

    private static final String MK_NOT_EXIST = "FK_NOT_EXIST"; //$NON-NLS-1$

    private static final String MK_NOT_TYPE_STRING = "FK_NOT_TYPE_STRING"; //$NON-NLS-1$

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.visitor.IComponentValidateVisitor#getMessageKeys()
     */
    @Override
    public String[] getMessageKeys() {
        return new String[] { MK_NOT_EXIST, MK_NOT_TYPE_STRING };
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.visitor.AbstractComponentVisitor#getMsgGroup(java
     * .lang.String)
     */
    @Override
    protected int getMsgGroup(IElementContainer container, IMElement element, String msgKey) {
        return getContainerGroup(container);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.visitor.IComponentValidateVisitor#visit(org.talend
     * .mdm.repository.core.validate.datamodel.DataModelValidateContext,
     * org.talend.mdm.repository.core.validate.datamodel.model.MComponent, java.util.List)
     */
    @Override
    public boolean check(DataModelValidateContext context, IMComponent mComponent, Set<ModelValidationMessage> messages) {
        IMElement element = (IMElement) mComponent;
        if (!isEntity(mComponent)) {
            IMAnnotation annotation = element.getAnnotation();
            IMAnnotationUnit fk = annotation.getForeignKey();
            if (fk != null) {
                String path = fk.getValue();
                IMElement elementByPath = element.getRoot().findElementByPath(path);
                if (elementByPath == null) {
                    ModelValidationMessage msg = newMessage(context, SEV_ERROR,
                            Messages.bind(Messages.FKInfoElementVisitor_MK_NOT_EXIST, path), MK_NOT_EXIST, element,
                            fk.getElement());
                    messages.add(msg);
                } else {
                    String typeName = element.getType().getName();
                    if (typeName == null || !typeName.equals("string")) { //$NON-NLS-1$
                        ModelValidationMessage msg = newMessage(context, SEV_ERROR,
                                Messages.bind(Messages.FKInfoElementVisitor_MK_NOT_TYPE_STRING, element.getName()),
                                MK_NOT_TYPE_STRING, element, element.getW3CElement());
                        messages.add(msg);
                    }
                }
            }
        }
        //

        return true;
    }
}
