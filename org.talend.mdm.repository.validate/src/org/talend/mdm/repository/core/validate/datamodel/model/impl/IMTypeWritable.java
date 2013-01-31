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

import org.talend.mdm.repository.core.validate.datamodel.model.IMType;

/**
 * created by HHB on 2013-1-29 Detailled comment
 * 
 */
public interface IMTypeWritable extends IMType, IElementContainerWritable, IMComponentWritable {

    /**
     * Sets the declared.
     * 
     * @param declared the declared to set
     */
    public abstract void setDeclared(boolean declared);

    /**
     * Sets the isComplexType.
     * 
     * @param isComplexType the isComplexType to set
     */
    public abstract void setComplexType(boolean isComplexType);
}
