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

import java.util.List;
import java.util.Set;

import org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext;
import org.talend.mdm.repository.core.validate.datamodel.model.IElementContainer;
import org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotation;
import org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotationUnit;
import org.talend.mdm.repository.core.validate.datamodel.model.IMComponent;
import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.model.IMType;
import org.talend.mdm.repository.core.validate.datamodel.validator.ModelValidationMessage;
import org.talend.mdm.repository.core.validate.i18n.Messages;

/**
 * created by HHB on 2013-1-14 Detailled comment
 * 
 */
public class PKInfoValidationRules extends AbstractElementValidationRule {

    private static final String MK_NOT_EXIST = "PK_INFO_NOT_EXIST"; //$NON-NLS-1$

    private static final String MK_NOT_IN_SAME_ENTITY = "PK_INFO_NOT_IN_SAME_ENTITY"; //$NON-NLS-1$

    private static final String MK_FIELD_NOT_DISPLAY_TYPE = "FIELD_NOT_DISPLAY_TYPE"; //$NON-NLS-1$

    private static final String MK_FIELD_NOT_LIST = "FIELD_NOT_LIST"; //$NON-NLS-1$

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.visitor.IComponentValidateVisitor#getMessageKeys()
     */
    @Override
    public String[] getMessageKeys() {
        return new String[] { MK_NOT_EXIST, MK_NOT_IN_SAME_ENTITY, MK_FIELD_NOT_DISPLAY_TYPE, MK_FIELD_NOT_LIST };
    }

    @Override
    protected int getMsgGroup(IElementContainer container, IMElement element, String msgKey) {
        return MSG_GROUP_ENTITY;
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
        if (isEntity(mComponent)) {
            IMAnnotation annotation = element.getAnnotation();
            List<IMAnnotationUnit> infos = annotation.getPrimaryKeyInfo();
            if (infos != null) {
                for (IMAnnotationUnit info : infos) {
                    String path = info.getValue();
                    IMElement elementByPath = element.getRoot().findElementByPath(path);
                    IMElement entity = element.getEntity();
                    if (elementByPath == null) {
                        ModelValidationMessage msg = newMessage(context, SEV_ERROR,
                                Messages.bind(Messages.PKInfoElementVisitor_MK_NOT_EXIST, path), MK_NOT_EXIST, element,
                                info.getElement());
                        messages.add(msg);
                    } else {
                        IMElement foundEntity = elementByPath.getEntity();

                        if (foundEntity != entity) {
                            ModelValidationMessage msg = newMessage(context, SEV_ERROR,
                                    Messages.bind(Messages.PKInfoElementVisitor_MK_NOT_IN_SAME_ENTITY, path),
                                    MK_NOT_IN_SAME_ENTITY, element, info.getElement());
                            messages.add(msg);
                        } else {
                            IMType type = elementByPath.getType();
                            if (!type.isSimpleType()) {
                                ModelValidationMessage msg = newMessage(context, SEV_WARNING, Messages.bind(
                                        Messages.PKInfoElementVisitor_MK_FIELD_NOT_DISPLAY_TYPE, path, elementByPath.getName()),
                                        MK_FIELD_NOT_DISPLAY_TYPE, elementByPath, info.getElement());
                                messages.add(msg);
                            }
                            Integer maxOccurs = elementByPath.getMaxOccurs();
                            Integer minOccurs = elementByPath.getMinOccurs();
                            if (maxOccurs != null && minOccurs != null && (maxOccurs > 1 || (minOccurs != 0 || minOccurs != 1))) {
                                ModelValidationMessage msg = newMessage(
                                        context,
                                        SEV_WARNING,
                                        Messages.bind(Messages.PKInfoElementVisitor_MK_FIELD_NOT_LIST, path,
                                                elementByPath.getName()), MK_FIELD_NOT_LIST, elementByPath, info.getElement());
                                messages.add(msg);
                            }

                        }
                    }
                }
            }
        }
        //

        return false;
    }

}
