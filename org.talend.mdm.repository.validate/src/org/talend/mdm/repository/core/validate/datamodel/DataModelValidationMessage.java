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
package org.talend.mdm.repository.core.validate.datamodel;

import org.eclipse.wst.xml.core.internal.validation.core.ValidationMessage;
import org.w3c.dom.Element;

/**
 * created by HHB on 2013-1-8 Detailled comment
 * 
 */
public class DataModelValidationMessage extends ValidationMessage {

    private String dataModelName;

    private Element domElement;

    private String entityName;

    private String elementType;

    private String path;

    /**
     * the value come from IComponentValidateVisitor's MSG_GROUP_XXX
     */
    private int msgGroup;

    /**
     * Getter for msgGroup.
     * 
     * @return the msgGroup
     */
    public int getMsgGroup() {
        return this.msgGroup;
    }

    /**
     * Sets the msgGroup.
     * 
     * @param msgGroup the msgGroup to set
     */
    public void setMsgGroup(int msgGroup) {
        this.msgGroup = msgGroup;
    }

    /**
     * Getter for path.
     * 
     * @return the path
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Sets the path.
     * 
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * DOC HHB DataModelValidationMessage constructor comment.
     * 
     * @param message
     * @param lineNumber
     * @param columnNumber
     * @param uri
     */
    public DataModelValidationMessage(int severity, String message, int lineNumber, int columnNumber, String key) {
        super(message, lineNumber, columnNumber, null, key, null);
        setSeverity(severity);
    }

    /**
     * Getter for dataModelName.
     * 
     * @return the dataModelName
     */
    public String getDataModelName() {
        return this.dataModelName;
    }

    /**
     * Getter for domElement.
     * 
     * @return the domElement
     */
    public Element getDomElement() {
        return this.domElement;
    }

    /**
     * Getter for entityName.
     * 
     * @return the entityName
     */
    public String getEntityName() {
        return this.entityName;
    }

    /**
     * Getter for modelType.
     * 
     * @return the modelType
     */
    public String getElementType() {
        return this.elementType;
    }

    /**
     * Sets the dataModelName.
     * 
     * @param dataModelName the dataModelName to set
     */
    public void setDataModelName(String dataModelName) {
        this.dataModelName = dataModelName;
    }

    /**
     * Sets the domElement.
     * 
     * @param domElement the domElement to set
     */
    public void setDomElement(Element domElement) {
        this.domElement = domElement;
    }

    /**
     * Sets the entityName.
     * 
     * @param entityName the entityName to set
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    /**
     * Sets the modelType.
     * 
     * @param elementType the modelType to set
     */
    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DataModelValidationMessage)) {
            return false;
        }
        DataModelValidationMessage msg = (DataModelValidationMessage) obj;
        if (dataModelName.equals(msg.getDataModelName()) && lineNumber == msg.getLineNumber()
                && domElement.equals(msg.getDomElement())) {
            if (key == null && msg.getKey() == null) {
                return true;
            }
            if (key != null && msg.getKey() != null && getKey().equals(msg.getKey())) {
                return true;
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = dataModelName.hashCode() * 7 + (key != null ? key.hashCode() * 17 : 17) + lineNumber * 31
                + domElement.hashCode() * 37;
        return hash;
    }

}
