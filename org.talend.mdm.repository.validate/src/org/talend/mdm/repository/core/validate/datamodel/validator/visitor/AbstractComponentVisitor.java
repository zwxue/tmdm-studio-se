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
package org.talend.mdm.repository.core.validate.datamodel.validator.visitor;

import org.eclipse.xsd.util.XSDParser;
import org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext;
import org.talend.mdm.repository.core.validate.datamodel.DataModelValidationMessage;
import org.talend.mdm.repository.core.validate.datamodel.model.IElementContainer;
import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.model.IMType;
import org.w3c.dom.Element;

/**
 * created by HHB on 2013-1-14 Detailled comment
 * 
 */
public abstract class AbstractComponentVisitor implements IComponentValidateVisitor {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.validator.visitor.IComponentValidateVisitor#getMsgGroup(java
     * .lang.String)
     */
    @Override
    public int getMsgGroup(IElementContainer container, IMElement element, String msgKey) {
        return MSG_GROUP_UNKNOW;
    }

    protected DataModelValidationMessage newMessage(int severity, String message, int line, int column, String key,
            String modelName, String entityName, String elementType, String path, Element domElement, int messageGroup) {
        DataModelValidationMessage msg = new DataModelValidationMessage(severity, message, line, column, key);
        msg.setDataModelName(modelName);
        msg.setEntityName(entityName);
        msg.setDomElement(domElement);
        msg.setPath(path);

        msg.setMsgGroup(messageGroup);
        msg.setElementType(elementType);
        return msg;
    }

    protected DataModelValidationMessage newMessage(DataModelValidateContext context, int severity, String message, String key,
            IMElement mElement, Element domElement) {
        int startLine = XSDParser.getStartLine(domElement);
        int startColumn = XSDParser.getStartColumn(domElement);
        IElementContainer container = mElement.getRoot().findContainer(mElement);
        String path = getPathToContainer(container, mElement);
        return newMessage(severity, message, startLine, startColumn, key, mElement.getRoot().getName(), mElement.getEntity()
                .getName(), getContainerName(container), path, domElement, getMsgGroup(container, mElement, key));
    }

    private String getContainerName(IElementContainer container) {

        if (container instanceof IMType) {
            IMType type = (IMType) container;
            if (type.isComplexType()) {
                return type.getName();
            }
            if (type.isAnonymousType()) {
                return "<Anonymous>"; //$NON-NLS-1$
            }
        } else if (container instanceof IMElement) {
            return ((IMElement) container).getName();
        }
        return null;
    }

    protected int getContainerGroup(IElementContainer container) {

        if (container instanceof IMElement) {
            return MSG_GROUP_ENTITY;
        }
        if (container instanceof IMType) {
            return MSG_GROUP_TYPE;
        }

        return MSG_GROUP_UNKNOW;
    }

    protected String getPathToContainer(IElementContainer container, IMElement element) {
        if (container instanceof IMElement) {
            return element.getPath();
        }
        if (container instanceof IMType) {
            IMType type = (IMType) container;
            IMElement parent;
            IMElement temp = element;
            parent = temp.getParent();
            while (parent != null && parent.getType() != type) {
                temp = parent;
                parent = temp.getParent();
            }
            if (parent != null) {
                String parentPath = parent.getPath();
                String elementPath = element.getPath();
                if (elementPath.startsWith(parentPath)) {
                    String typePath = parent.getType().getName() + elementPath.substring(parentPath.length());
                    return typePath;
                }
            }

        }

        return element.getPath();

    }
}
