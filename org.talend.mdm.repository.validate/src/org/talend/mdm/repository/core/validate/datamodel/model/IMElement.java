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


/**
 * created by HHB on 2013-1-28 Detailled comment
 * 
 */
public interface IMElement extends IElementContainer, IMComponent {

    /**
     * Getter for minOccurs.
     * 
     * @return the minOccurs
     */
    public abstract Integer getMinOccurs();

    /**
     * Getter for maxOccurs.
     * 
     * @return the maxOccurs
     */
    public abstract Integer getMaxOccurs();

    /**
     * Getter for annotation.
     * 
     * @return the annotation
     */
    public abstract IMAnnotation getAnnotation();

    /**
     * Getter for parent.
     * 
     * @return the parent
     */
    public abstract IMElement getParent();

    /**
     * Getter for path.
     * 
     * @return the path
     */
    public abstract String getPath();

    /**
     * Getter for type.
     * 
     * @return the type
     */
    public abstract IMType getType();

    public abstract IMElement getEntity();

}