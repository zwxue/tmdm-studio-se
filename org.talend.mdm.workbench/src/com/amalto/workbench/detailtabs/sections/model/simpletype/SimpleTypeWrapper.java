// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.detailtabs.sections.model.simpletype;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;
import com.amalto.workbench.detailtabs.sections.handlers.SimpleTypeWrapperCommitHandler;
import com.amalto.workbench.detailtabs.sections.model.ISubmittable;

public class SimpleTypeWrapper implements ISubmittable {

    private Map<String, Object> facetName2Value = new HashMap<String, Object>();

    private String newTypeName;

    private String newBaseTypeName;

    private XSDSimpleTypeDefinition newBaseType;

    private XSDSimpleTypeDefinition xsdSimpleType;

    public SimpleTypeWrapper(XSDSimpleTypeDefinition xsdSimpleType, String newTypeName, XSDSimpleTypeDefinition newBaseType,
            String newBaseTypeName, Map<String, Object> facetName2Value) {
        this.xsdSimpleType = xsdSimpleType;
        this.facetName2Value = facetName2Value;
        this.newTypeName = newTypeName;
        this.newBaseType = newBaseType;
        this.newBaseTypeName = newBaseTypeName;
    }

    public XSDSimpleTypeDefinition getXSDSimpleType() {
        return xsdSimpleType;
    }

    public String getOldTypeName() {
        return xsdSimpleType.getName();
    }

    public Object getFacetValue(String facetName) {
        return facetName2Value.get(facetName);
    }

    public String[] getFacetNames() {
        return facetName2Value.keySet().toArray(new String[0]);
    }

    public String getNewTypeName() {
        return newTypeName;
    }

    public String getNewBaseTypeName() {
        return newBaseTypeName;
    }

    public XSDSimpleTypeDefinition getNewBaseType() {
        return newBaseType;
    }

    public CommitHandler<SimpleTypeWrapper> createCommitHandler() {
        return new SimpleTypeWrapperCommitHandler(this);
    }

    public XSDSchema getSchema() {
        return xsdSimpleType.getSchema();
    }

    public boolean isBaseTypeExists() {
        return newBaseTypeName.equals(newBaseType.getName());
    }
}
