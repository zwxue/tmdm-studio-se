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

import org.talend.mdm.repository.core.validate.datamodel.model.IElementContainer;
import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.model.IMRoot;
import org.talend.mdm.repository.core.validate.datamodel.model.IMType;
import org.w3c.dom.Element;

/**
 * created by HHB on 2013-1-6 Detailled comment
 * 
 */
public class MRoot implements IMRootWritable {

    private String name;

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMRoot#getName()
     */
    @Override
    public String getName() {
        return this.name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMRoot#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    List<IMType> types = new ArrayList<IMType>();

    List<IMElement> elements = new ArrayList<IMElement>();

    /**
     * Getter for elements.
     * 
     * @return the elements
     */
    @Override
    public List<IMElement> getElements() {
        return this.elements;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMRoot#getTypes()
     */
    @Override
    public List<IMType> getTypes() {
        return this.types;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.model.IMRoot#addType(org.talend.mdm.repository.core.validate
     * .datamodel.model.MType)
     */
    @Override
    public void addType(IMTypeWritable type) {
        types.add(type);
        type.setRoot(this);
    }

    @Override
    public void addElement(IMElementWritable element) {
        elements.add(element);
        element.setRoot(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMRoot#findTypeByW3CElement(org.w3c.dom.Element)
     */
    @Override
    public IMType findTypeByW3CElement(Element element) {
        for (IMType type : types) {
            if (type.getW3CElement() == element) {
                return type;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.model.IMRoot#findContainer(org.talend.mdm.repository.core.validate
     * .datamodel.model.IMElement)
     */
    @Override
    public IElementContainer findContainer(IMElement element) {
        IMType type = element.getType();
        if (type.isComplexType() && type.isDeclared()) {
            return type;
        }
        IMElement parent = element.getParent();
        if (parent == null) {
            return element;
        }
        return findContainer(parent);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IElementContainer#getRoot()
     */
    @Override
    public IMRoot getRoot() {
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.model.IElementContainer#setRoot(org.talend.mdm.repository.core
     * .validate.datamodel.model.MRoot)
     */
    @Override
    public void setRoot(IMRoot root) {
        // do nothing ,can't change itself

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMRoot#findElementByPath(java.lang.String)
     */
    @Override
    public IMElement findElementByPath(String path) {
        return findElementByPath(path, getElements());
    }

    private IMElement findElementByPath(String path, List<IMElement> elements) {
        if (path == null) {
            throw new IllegalArgumentException("Parameter Path IS NULL!"); //$NON-NLS-1$
        }
        if (elements == null) {
            return null;
        }
        for (IMElement e : elements) {
            String pVar = e.getPath();
            if (path.startsWith(pVar)) {
                if (path.equals(pVar)) {
                    return e;
                } else {
                    IMElement found = findElementByPath(path, e.getElements());
                    if (found != null) {
                        return found;
                    }
                }
            }
        }
        return null;
    }

    boolean xsdError = false;

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMRoot#hasXSDError()
     */
    @Override
    public boolean hasXSDError() {
        return xsdError;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.impl.IMRootWritable#setXSDError(boolean)
     */
    @Override
    public void setXSDError(boolean hasError) {
        xsdError = hasError;
    }

}
