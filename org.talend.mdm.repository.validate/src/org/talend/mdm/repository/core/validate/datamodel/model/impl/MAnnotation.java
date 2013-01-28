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
import java.util.LinkedList;
import java.util.List;

import org.talend.mdm.repository.core.validate.datamodel.model.IAnnotationConst;
import org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotation;
import org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotationUnit;
import org.w3c.dom.Element;

/**
 * created by HHB on 2013-1-7 Detailled comment
 * 
 */
public class MAnnotation implements IAnnotationConst, IMAnnotation {

    public class AnnotationUnit implements IMAnnotationUnit {

        String attribute;

        /**
         * DOC HHB AnnotationUnit constructor comment.
         * 
         * @param attribute
         * @param value
         * @param element
         */
        public AnnotationUnit(String attribute, String value, Element element) {
            this.attribute = attribute;
            this.value = value;
            this.element = element;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotationUnit#getAttribute()
         */
        @Override
        public String getAttribute() {
            return this.attribute;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotationUnit#getValue()
         */
        @Override
        public String getValue() {
            return this.value;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotationUnit#getElement()
         */
        @Override
        public Element getElement() {
            return this.element;
        }

        String value;

        Element element;

    }

    private List<AnnotationUnit> annotations;

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotation#addAnnotation(java.lang.String,
     * java.lang.String, org.w3c.dom.Element)
     */
    @Override
    public void addAnnotation(String attribute, String value, Element element) {
        if (annotations == null) {
            annotations = new ArrayList<AnnotationUnit>();
        }
        annotations.add(new AnnotationUnit(attribute, value, element));
    }

    private IMAnnotationUnit getAnnotation(String attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException();
        }
        if (annotations != null) {
            for (IMAnnotationUnit unit : annotations) {
                if (attribute.equals(unit.getAttribute())) {
                    return unit;
                }
            }
        }
        return null;
    }

    private List<IMAnnotationUnit> getAnnotations(String attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException();
        }
        List<IMAnnotationUnit> units = new LinkedList<IMAnnotationUnit>();
        if (annotations != null) {
            for (AnnotationUnit unit : annotations) {
                if (attribute.equals(unit.getAttribute())) {
                    units.add(unit);
                }
            }
        }
        return units;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotation#getPrimaryKeyInfo()
     */
    @Override
    public List<IMAnnotationUnit> getPrimaryKeyInfo() {
        return getAnnotations(PRIMARY_KEY_INFO);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.validate.datamodel.model.IMAnnotation#getForeignKey()
     */
    @Override
    public IMAnnotationUnit getForeignKey() {
        return getAnnotation(FOREIGN_KEY);
    }
}
