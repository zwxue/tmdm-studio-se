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

import org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotation;
import org.talend.mdm.repository.core.validate.datamodel.model.IMElement;
import org.talend.mdm.repository.core.validate.datamodel.model.IMRoot;
import org.talend.mdm.repository.core.validate.datamodel.model.IMType;
import org.w3c.dom.Element;

/**
 * created by HHB on 2013-1-6 Detailled comment
 * 
 */
public class MElement extends MComponent implements Cloneable, IMElementWritable {

    protected List<IMElement> children;

    protected IMElementWritable parent;

    protected String path;

    protected IMType type;

    protected IMAnnotation annotation = new MAnnotation();

    protected Integer minOccurs;

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#getMinOccurs()
     */
    @Override
    public Integer getMinOccurs() {
        return this.minOccurs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#setMinOccurs(java.lang.Integer)
     */
    @Override
    public void setMinOccurs(Integer minOccurs) {
        this.minOccurs = minOccurs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#getMaxOccurs()
     */
    @Override
    public Integer getMaxOccurs() {
        return this.maxOccurs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#setMaxOccurs(java.lang.Integer)
     */
    @Override
    public void setMaxOccurs(Integer maxOccurs) {
        this.maxOccurs = maxOccurs;
    }

    protected Integer maxOccurs;

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#getAnnotation()
     */
    @Override
    public IMAnnotation getAnnotation() {
        return this.annotation;
    }

    private static final String SEPERATOR = "/"; //$NON-NLS-1$

    public MElement(String name, Element element) {
        super(name, element);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#getElements()
     */
    @Override
    public List<IMElement> getElements() {
        return this.children;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#getParent()
     */
    @Override
    public IMElement getParent() {
        return this.parent;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#getPath()
     */
    @Override
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

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#getType()
     */
    @Override
    public IMType getType() {
        return this.type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#setChildren(java.util.List)
     */
    @Override
    public void setChildren(List<IMElementWritable> children) {
        this.children = (List) children;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.model.IMElement#setParent(org.talend.mdm.repository.core.validate
     * .datamodel.model.MElement)
     */
    @Override
    public void setParent(IMElementWritable parent) {
        this.parent = parent;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#setPath(java.lang.String)
     */
    @Override
    public void setPath(String path) {
        this.path = path;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.model.IMElement#setType(org.talend.mdm.repository.core.validate
     * .datamodel.model.MType)
     */
    @Override
    public void setType(IMType type) {
        this.type = type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#cloneElement()
     */
    @Override
    public IMElementWritable cloneElement() {
        try {
            IMElementWritable clone = (IMElementWritable) this.clone();

            // cloneChildren(clone);

            return clone;

        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    private List<IMElementWritable> cloneChildren(IMElementWritable clonedParent) {
        if (children == null) {
            return null;
        }
        List<IMElementWritable> cloneChildren = new ArrayList<IMElementWritable>(children.size());
        for (IMElement child : children) {
            IMElementWritable cloneChild = ((IMElementWritable) child).cloneElement();
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
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.model.IMElement#addElement(org.talend.mdm.repository.core.validate
     * .datamodel.model.MElement)
     */
    @Override
    public void addElement(IMElementWritable element) {
        if (children == null) {
            children = new ArrayList<IMElement>();
        }
        children.add(element);
        if (root != null) {
            element.setRoot(root);
        }
    }

    private IMRoot root;

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#getRoot()
     */
    @Override
    public IMRoot getRoot() {
        return this.root;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.mdm.repository.core.validate.datamodel.model.IMElement#setRoot(org.talend.mdm.repository.core.validate
     * .datamodel.model.MRoot)
     */
    @Override
    public void setRoot(IMRoot root) {
        if (this.root == null || this.root != root) {
            this.root = root;
            if (children != null) {
                for (IMElement child : children) {
                    ((IMElementWritable) child).setRoot(root);
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMElement#getEntity()
     */
    @Override
    public IMElement getEntity() {
        IMElement e = this;
        IMElement p = e.getParent();
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
