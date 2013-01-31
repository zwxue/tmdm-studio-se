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

import java.util.List;

import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.model.IMType;

/**
 * created by HHB on 2013-1-29 Detailled comment
 * 
 */
public interface IMElementWritable extends IMElement, IElementContainerWritable, IMComponentWritable {

    /**
     * Sets the minOccurs.
     * 
     * @param minOccurs the minOccurs to set
     */
    public abstract void setMinOccurs(Integer minOccurs);

    /**
     * Sets the maxOccurs.
     * 
     * @param maxOccurs the maxOccurs to set
     */
    public abstract void setMaxOccurs(Integer maxOccurs);

    /**
     * Sets the children.
     * 
     * @param children the children to set
     */
    public abstract void setChildren(List<IMElementWritable> children);

    /**
     * Sets the parent.
     * 
     * @param parent the parent to set
     */
    public abstract void setParent(IMElementWritable parent);

    /**
     * Sets the path.
     * 
     * @param path the path to set
     */
    public abstract void setPath(String path);

    /**
     * Sets the type.
     * 
     * @param type the type to set
     */
    public abstract void setType(IMType type);

    public abstract IMElementWritable cloneElement();
}
