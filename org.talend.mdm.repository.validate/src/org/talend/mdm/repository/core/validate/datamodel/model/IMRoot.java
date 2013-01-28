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

import java.util.List;

import org.eclipse.xsd.XSDComponent;

/**
 * created by HHB on 2013-1-28 Detailled comment
 * 
 */
public interface IMRoot extends IElementContainer {

    /**
     * Getter for name.
     * 
     * @return the name
     */
    public abstract String getName();

    /**
     * Sets the name.
     * 
     * @param name the name to set
     */
    public abstract void setName(String name);

    /**
     * Getter for types.
     * 
     * @return the types
     */
    public abstract List<IMType> getTypes();

    public abstract void addType(IMType type);

    public abstract IMType findTypeByXSD(XSDComponent xsdComponent);

    public abstract IElementContainer findContainer(IMElement element);

    public abstract IMElement findElementByPath(String path);

}