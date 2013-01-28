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
package org.talend.mdm.repository.core.validate.datamodel.model.impl;

import java.util.Set;

import org.eclipse.xsd.XSDComponent;
import org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext;
import org.talend.mdm.repository.core.validate.datamodel.DataModelValidationMessage;
import org.talend.mdm.repository.core.validate.datamodel.model.IMComponent;
import org.talend.mdm.repository.core.validate.datamodel.validator.visitor.IComponentValidateVisitor;

/**
 * created by HHB on 2013-1-6 Detailled comment
 * 
 */
public class MComponent implements IMComponent {

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

    /* (non-Javadoc)
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMComponent#getName()
     */
    @Override
    public String getName() {
        return this.name;
    }

    /* (non-Javadoc)
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMComponent#getXsdComponent()
     */
    @Override
    public XSDComponent getXsdComponent() {
        return this.xsdComponent;
    }

    /* (non-Javadoc)
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMComponent#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMComponent#setXsdComponent(org.eclipse.xsd.XSDComponent)
     */
    @Override
    public void setXsdComponent(XSDComponent xsdComponent) {
        this.xsdComponent = xsdComponent;
    }

    /* (non-Javadoc)
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMComponent#acceptValidateVisitor(org.talend.mdm.repository.core.validate.datamodel.validator.visitor.IComponentValidateVisitor, org.talend.mdm.repository.core.validate.datamodel.DataModelValidateContext, java.util.Set)
     */
    @Override
    public boolean acceptValidateVisitor(IComponentValidateVisitor visitor, DataModelValidateContext context,
            Set<DataModelValidationMessage> messages) {
        return visitor.visit(context, this, messages);
    }
}
