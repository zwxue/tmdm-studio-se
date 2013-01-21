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
public class MElement extends MComponent implements Cloneable, IElementContainer {

    protected List<MElement> children;

    protected MElement parent;

    protected String path;

    protected MType type;

    protected MAnnotation annotation = new MAnnotation();

    protected Integer minOccurs;

    /**
     * Getter for minOccurs.
     * 
     * @return the minOccurs
     */
    public Integer getMinOccurs() {
        return this.minOccurs;
    }

    /**
     * Sets the minOccurs.
     * 
     * @param minOccurs the minOccurs to set
     */
    public void setMinOccurs(Integer minOccurs) {
        this.minOccurs = minOccurs;
    }

    /**
     * Getter for maxOccurs.
     * 
     * @return the maxOccurs
     */
    public Integer getMaxOccurs() {
        return this.maxOccurs;
    }

    /**
     * Sets the maxOccurs.
     * 
     * @param maxOccurs the maxOccurs to set
     */
    public void setMaxOccurs(Integer maxOccurs) {
        this.maxOccurs = maxOccurs;
    }

    protected Integer maxOccurs;

    /**
     * Getter for annotation.
     * 
     * @return the annotation
     */
    public MAnnotation getAnnotation() {
        return this.annotation;
    }

    private static final String SEPERATOR = "/"; //$NON-NLS-1$

    public MElement(String name, XSDComponent xsdComponent) {
        super(name, xsdComponent);
    }

    /**
     * Getter for children.
     * 
     * @return the children
     */
    @Override
    public List<MElement> getElements() {
        return this.children;
    }

    /**
     * Getter for parent.
     * 
     * @return the parent
     */
    public MElement getParent() {
        return this.parent;
    }

    /**
     * Getter for path.
     * 
     * @return the path
     */
    public String getPath() {
        if (path == null) {
            caculatePath();
        }
        return this.path;
    }

    /**
     * DOC HHB Comment method "caculatePath".
     */
    private void caculatePath() {
        if (parent != null) {
            path = parent.getPath() + SEPERATOR + name;
        } else {
            path = name;
        }

    }

    /**
     * Getter for type.
     * 
     * @return the type
     */
    public MType getType() {
        return this.type;
    }

    /**
     * Sets the children.
     * 
     * @param children the children to set
     */
    public void setChildren(List<MElement> children) {
        this.children = children;
    }

    /**
     * Sets the parent.
     * 
     * @param parent the parent to set
     */
    public void setParent(MElement parent) {
        this.parent = parent;
    }

    /**
     * Sets the path.
     * 
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Sets the type.
     * 
     * @param type the type to set
     */
    public void setType(MType type) {
        this.type = type;
    }

    public MElement cloneElement() {
        try {
            MElement clone = (MElement) this.clone();

            // cloneChildren(clone);

            return clone;

        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    private List<MElement> cloneChildren(MElement clonedParent) {
        if (children == null) {
            return null;
        }
        ArrayList<MElement> cloneChildren = new ArrayList<MElement>(children.size());
        for (MElement child : children) {
            MElement cloneChild = child.cloneElement();
            cloneChild.setParent(clonedParent);
        }
        clonedParent.setChildren(cloneChildren);
        return cloneChildren;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.model.IElementContainer#addElement(org.talend.mdm.repository
     * .core.validate.datamodel.model.MElement)
     */
    @Override
    public void addElement(MElement element) {
        if (children == null) {
            children = new ArrayList<MElement>();
        }
        children.add(element);
        if (root != null) {
            element.setRoot(root);
        }
    }

    private MRoot root;

    /**
     * Getter for root.
     * 
     * @return the root
     */
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
            if (children != null) {
                for (MElement child : children) {
                    child.setRoot(root);
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public MElement getEntity() {
        MElement e = this;
        MElement p = e.getParent();
        while (p != null) {
            e = p;
            p = e.getParent();
        }
        return e;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String minmax = (minOccurs != null && maxOccurs != null) ? " [" + minOccurs.toString() + "..." + maxOccurs.toString() //$NON-NLS-1$ //$NON-NLS-2$
                + "]" : ""; //$NON-NLS-1$ //$NON-NLS-2$
        return name + " <" + type.getName() + ">\tPath:" + getPath() + minmax; //$NON-NLS-1$ //$NON-NLS-2$
    }

}
