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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xsd.XSDComponent;

/**
 * created by HHB on 2013-1-6 Detailled comment
 * 
 */
public class MType extends MComponent implements IElementContainer {

    boolean isComplexType;

    boolean declared;

    /**
     * Getter for declared.
     * 
     * @return the declared
     */
    public boolean isDeclared() {
        return this.declared;
    }

    /**
     * Sets the declared.
     * 
     * @param declared the declared to set
     */
    public void setDeclared(boolean declared) {
        this.declared = declared;
    }

    /**
     * Getter for isComplexType.
     * 
     * @return the isComplexType
     */
    public boolean isComplexType() {
        if (this.isComplexType) {
            return name != null;
        }
        return false;
    }

    public boolean isSimpleType() {
        return !this.isComplexType;
    }

    public boolean isAnonymousType() {
        if (isComplexType) {
            return name == null;
        }
        return false;
    }

    /**
     * Sets the isComplexType.
     * 
     * @param isComplexType the isComplexType to set
     */
    public void setComplexType(boolean isComplexType) {
        this.isComplexType = isComplexType;
    }

    /**
     * DOC HHB MType constructor comment.
     * 
     * @param name
     * @param xsdComponent
     * @param isComplex
     * @param declared
     */
    public MType(String name, XSDComponent xsdComponent, boolean isComplex, boolean declared) {
        super(name, xsdComponent);
        this.isComplexType = isComplex;
        this.declared = declared;
    }

    List<MElement> elements = new ArrayList<MElement>();

    /**
     * Getter for elements.
     * 
     * @return the elements
     */
    @Override
    public List<MElement> getElements() {
        return this.elements;
    }

    @Override
    public void addElement(MElement element) {
        elements.add(element);
    }

    private MRoot root;

    @Override
    public MRoot getRoot() {
        return this.root;
    }

    /**
     * Sets the root.
     * 
     * @param root the root to set
     */
    @Override
    public void setRoot(MRoot root) {
        if (this.root == null || this.root != root) {
            this.root = root;
            if (elements != null) {
                for (MElement child : elements) {
                    child.setRoot(root);
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String type = "S"; //$NON-NLS-1$
        if (isComplexType()) {
            type = "C"; //$NON-NLS-1$
        } else if (isAnonymousType()) {
            type = "A"; //$NON-NLS-1$
        }
        String declaredStr = declared ? " [*]" : ""; //$NON-NLS-1$ //$NON-NLS-2$
        return name + declaredStr + " Type:" + type; //$NON-NLS-1$
        // return super.toString();
    }

}
