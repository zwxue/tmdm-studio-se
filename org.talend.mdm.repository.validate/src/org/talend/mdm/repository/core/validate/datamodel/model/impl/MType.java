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

import java.util.ArrayList;
import java.util.List;

import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.model.IMRoot;
import org.w3c.dom.Element;

/**
 * created by HHB on 2013-1-6 Detailled comment
 * 
 */
public class MType extends MComponent implements IMTypeWritable {

    boolean isComplexType;

    boolean declared;

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMType#isDeclared()
     */
    @Override
    public boolean isDeclared() {
        return this.declared;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMType#setDeclared(boolean)
     */
    @Override
    public void setDeclared(boolean declared) {
        this.declared = declared;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMType#isComplexType()
     */
    @Override
    public boolean isComplexType() {
        if (this.isComplexType) {
            return name != null;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMType#isSimpleType()
     */
    @Override
    public boolean isSimpleType() {
        return !this.isComplexType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMType#isAnonymousType()
     */
    @Override
    public boolean isAnonymousType() {
        if (isComplexType) {
            return name == null;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMType#setComplexType(boolean)
     */
    @Override
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
    public MType(String name, Element element, boolean isComplex, boolean declared) {
        super(name, element);
        this.isComplexType = isComplex;
        this.declared = declared;
    }

    List<IMElementWritable> elements = new ArrayList<IMElementWritable>();

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMType#getElements()
     */
    @Override
    public List<IMElement> getElements() {
        return (List) this.elements;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.model.IMType#addElement(org.talend.mdm.repository.core.validate
     * .datamodel.model.IMElement)
     */
    @Override
    public void addElement(IMElementWritable element) {
        elements.add(element);
    }

    private IMRoot root;

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMType#getRoot()
     */
    @Override
    public IMRoot getRoot() {
        return this.root;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.model.IMType#setRoot(org.talend.mdm.repository.core.validate
     * .datamodel.model.MRoot)
     */
    @Override
    public void setRoot(IMRoot root) {
        if (this.root == null || this.root != root) {
            this.root = root;
            if (elements != null) {
                for (IMElementWritable child : elements) {
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
    }

}
