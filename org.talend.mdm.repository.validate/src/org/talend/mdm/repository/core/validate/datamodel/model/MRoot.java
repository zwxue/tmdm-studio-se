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
public class MRoot implements IElementContainer {

    private String name;

    /**
     * Getter for name.
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    List<MType> types = new ArrayList<MType>();

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

    /**
     * Getter for types.
     * 
     * @return the types
     */
    public List<MType> getTypes() {
        return this.types;
    }

    public void addType(MType type) {
        types.add(type);
        type.setRoot(this);
    }

    @Override
    public void addElement(MElement element) {
        elements.add(element);
        element.setRoot(this);
    }

    public MType findTypeByXSD(XSDComponent xsdComponent) {
        for (MType type : types) {
            if (type.getXsdComponent() == xsdComponent) {
                return type;
            }
        }
        return null;
    }

    public IElementContainer findContainer(MElement element) {
        MType type = element.getType();
        if (type.isComplexType && type.isDeclared()) {
            return type;
        }
        MElement parent = element.getParent();
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
    public MRoot getRoot() {
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
    public void setRoot(MRoot root) {
        // do nothing ,can't change itself

    }

    public MElement findElementByPath(String path) {
        return findElementByPath(path, getElements());
    }

    private MElement findElementByPath(String path, List<MElement> elements) {
        if (path == null) {
            throw new IllegalArgumentException("Parameter Path IS NULL!"); //$NON-NLS-1$
        }
        if (elements == null) {
            return null;
        }
        for (MElement e : elements) {
            String pVar = e.getPath();
            if (path.startsWith(pVar)) {
                if (path.equals(pVar)) {
                    return e;
                } else {
                    MElement found = findElementByPath(path, e.getElements());
                    if (found != null) {
                        return found;
                    }
                }
            }
        }
        return null;
    }
}
