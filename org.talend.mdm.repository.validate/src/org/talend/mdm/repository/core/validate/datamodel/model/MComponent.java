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
package org.talend.mdm.repository.core.validate.datamodel.model;

import java.util.Set;

import org.eclipse.xsd.XSDComponent;
import org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext;
import org.talend.mdm.repository.core.validate.datamodel.DataModelValidationMessage;
import org.talend.mdm.repository.core.validate.datamodel.validator.visitor.IComponentValidateVisitor;

/**
 * created by HHB on 2013-1-6 Detailled comment
 * 
 */
public class MComponent {

    protected String name;

    /**
     * DOC HHB MComponent constructor comment.
     * 
     * @param name
     */
    public MComponent(String name) {
        this.name = name;
    }

    protected XSDComponent xsdComponent;

    /**
     * DOC HHB MComponent constructor comment.
     * 
     * @param name
     * @param xsdComponent
     */
    public MComponent(String name, XSDComponent xsdComponent) {
        this.name = name;
        this.xsdComponent = xsdComponent;
    }

    public MComponent() {
    }

    /**
     * Getter for name.
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for xsdComponent.
     * 
     * @return the xsdComponent
     */
    public XSDComponent getXsdComponent() {
        return this.xsdComponent;
    }

    /**
     * Sets the name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the xsdComponent.
     * 
     * @param xsdComponent the xsdComponent to set
     */
    public void setXsdComponent(XSDComponent xsdComponent) {
        this.xsdComponent = xsdComponent;
    }

    public boolean acceptValidateVisitor(IComponentValidateVisitor visitor, DataModelValidateContext context,
            Set<DataModelValidationMessage> messages) {
        return visitor.visit(context, this, messages);
    }
}
