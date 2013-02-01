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

import org.w3c.dom.Element;

/**
 * created by HHB on 2013-1-28 Detailled comment
 * 
 */
public interface IMComponent {

    /**
     * Getter for name.
     * 
     * @return the name
     */
    public abstract String getName();

    public abstract Element getW3CElement();

    // public abstract boolean acceptValidateVisitor(IComponentValidateVisitor visitor, DataModelValidateContext
    // context,
    // Set<ModelValidationMessage> messages);

}