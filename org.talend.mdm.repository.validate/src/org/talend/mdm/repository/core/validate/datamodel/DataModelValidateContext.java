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

import org.talend.mdm.repository.core.validate.datamodel.model.IMRoot;

/**
 * created by HHB on 2013-1-8 Detailled comment
 * 
 */
public class DataModelValidateContext {

    private Object schemaObj;

    /**
     * DOC HHB DataModelValidateContext constructor comment.
     * 
     * @param schema
     * @param modelRoot
     * @param document
     */
    public DataModelValidateContext(Object schemaObj, IMRoot modelRoot, Object document) {
        super();
        this.schemaObj = schemaObj;
        this.modelRoot = modelRoot;

    }

    /**
     * Getter for schema.
     * 
     * @return the schema
     */
    public Object getSchemaObject() {
        return this.schemaObj;
    }

    /**
     * Getter for modelRoot.
     * 
     * @return the modelRoot
     */
    public IMRoot getModelRoot() {
        return this.modelRoot;
    }

    private IMRoot modelRoot;

}
