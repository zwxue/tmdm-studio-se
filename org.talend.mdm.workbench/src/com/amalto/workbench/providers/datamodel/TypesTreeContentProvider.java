// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.providers.datamodel;

import java.util.ArrayList;

import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;

import com.amalto.workbench.utils.Util;

public class TypesTreeContentProvider extends SchemaTreeContentProvider {

    public TypesTreeContentProvider(IWorkbenchPartSite site, XSDSchema invisibleRoot) {
        super(site, invisibleRoot);

    }

    @Override
    protected Object[] findChildren(Object parent) {

        if (parent instanceof XSDComplexTypeDefinition)
            return getXSDComplexTypeDefinitionChildren((XSDComplexTypeDefinition) parent);

        return super.findChildren(parent);
    }

    protected Object[] getXSDComplexTypeDefinitionChildren(XSDComplexTypeDefinition parent) {

        ArrayList<Object> list = new ArrayList<Object>();
        list.addAll(parent.getAttributeContents());

        if (parent.getContent() == null) {
            list.add(parent.getBaseTypeDefinition());
            return list.toArray(new Object[list.size()]);
        } else if (parent.getContent() instanceof XSDSimpleTypeDefinition) {
            list.add(parent.getContent());
            return list.toArray(new Object[list.size()]);
        } else if (parent.getContent() instanceof XSDParticle) {
            return getXSDParticleChildren((XSDParticle) parent.getContent());
        } else {
            list.add(parent.getContent());
            return list.toArray(new Object[list.size()]);
        }
    }

    @Override
    protected Object[] getXSDSchemaChildren(XSDSchema schema) {
        return Util.filterOutDuplicatedElems(schema.getTypeDefinitions().toArray(
                new XSDNamedComponent[schema.getTypeDefinitions().size()]));
    }

}
