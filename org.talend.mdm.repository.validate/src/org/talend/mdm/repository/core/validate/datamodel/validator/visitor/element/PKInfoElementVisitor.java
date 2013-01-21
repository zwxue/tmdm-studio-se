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
import org.talend.mdm.repository.core.validate.datamodel.DataModelValidationMessage;
import org.talend.mdm.repository.core.validate.datamodel.model.IElementContainer;
import org.talend.mdm.repository.core.validate.datamodel.model.MAnnotation;
import org.talend.mdm.repository.core.validate.datamodel.model.MAnnotation.AnnotationUnit;
import org.talend.mdm.repository.core.validate.datamodel.model.MComponent;
import org.talend.mdm.repository.core.validate.datamodel.model.MElement;
import org.talend.mdm.repository.core.validate.datamodel.model.MType;
import org.talend.mdm.repository.core.validate.i18n.Messages;

/**
 * created by HHB on 2013-1-14 Detailled comment
 * 
 */
public class PKInfoElementVisitor extends AbstractElementVisitor {

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

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.visitor.IComponentValidateVisitor#getMsgGroup(java
     * .lang.String)
     */
    @Override
    public int getMsgGroup(IElementContainer container, MElement element, String msgKey) {
        // if (MK_NOT_EXIST.equals(msgKey) || MK_NOT_IN_SAME_ENTITY.equals(msgKey)) {
        // return MSG_GROUP_ENTITY;
        // }
        // if (MK_FIELD_NOT_DISPLAY_TYPE.equals(msgKey) || MK_FIELD_NOT_LIST.equals(msgKey)) {
        // return getParentGroup(element);
        // }
        //
        // return super.getMsgGroup(element, msgKey);
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
    public boolean visit(DataModelValidateContext context, MComponent mComponent, Set<DataModelValidationMessage> messages) {
        MElement element = (MElement) mComponent;
        if (isEntity(mComponent)) {
            MAnnotation annotation = element.getAnnotation();
            List<AnnotationUnit> infos = annotation.getPrimaryKeyInfo();
            if (infos != null) {
                for (AnnotationUnit info : infos) {
                    String path = info.getValue();
                    MElement elementByPath = element.getRoot().findElementByPath(path);
                    MElement entity = element.getEntity();
                    if (elementByPath == null) {
                        DataModelValidationMessage msg = newMessage(context, SEV_ERROR,
                                Messages.bind(Messages.PKInfoElementVisitor_MK_NOT_EXIST, path), MK_NOT_EXIST, element,
                                info.getElement());
                        messages.add(msg);
                    } else {
                        MElement foundEntity = elementByPath.getEntity();

                        if (foundEntity != entity) {
                            DataModelValidationMessage msg = newMessage(context, SEV_ERROR,
                                    Messages.bind(Messages.PKInfoElementVisitor_MK_NOT_IN_SAME_ENTITY, path),
                                    MK_NOT_IN_SAME_ENTITY, element, info.getElement());
                            messages.add(msg);
                        } else {
                            MType type = elementByPath.getType();
                            if (!type.isSimpleType()) {
                                DataModelValidationMessage msg = newMessage(context, SEV_WARNING, Messages.bind(
                                        Messages.PKInfoElementVisitor_MK_FIELD_NOT_DISPLAY_TYPE, path, elementByPath.getName()),
                                        MK_FIELD_NOT_DISPLAY_TYPE, elementByPath, info.getElement());
                                messages.add(msg);
                            }
                            if (elementByPath.getMaxOccurs() != null && elementByPath.getMaxOccurs() > 1) {
                                DataModelValidationMessage msg = newMessage(
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
