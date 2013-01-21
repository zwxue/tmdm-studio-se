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
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Element;

/**
 * created by HHB on 2013-1-7 Detailled comment
 * 
 */
public class MAnnotation implements IAnnotationConst {

    public class AnnotationUnit {

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

        /**
         * Getter for attribute.
         * 
         * @return the attribute
         */
        public String getAttribute() {
            return this.attribute;
        }

        /**
         * Getter for value.
         * 
         * @return the value
         */
        public String getValue() {
            return this.value;
        }

        /**
         * Getter for element.
         * 
         * @return the element
         */
        public Element getElement() {
            return this.element;
        }

        String value;

        Element element;

    }

    private List<AnnotationUnit> annotations;

    public void addAnnotation(String attribute, String value, Element element) {
        if (annotations == null) {
            annotations = new ArrayList<AnnotationUnit>();
        }
        annotations.add(new AnnotationUnit(attribute, value, element));
    }

    private AnnotationUnit getAnnotation(String attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException();
        }
        if (annotations != null) {
            for (AnnotationUnit unit : annotations) {
                if (attribute.equals(unit.getAttribute())) {
                    return unit;
                }
            }
        }
        return null;
    }

    private List<AnnotationUnit> getAnnotations(String attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException();
        }
        List<AnnotationUnit> units = new LinkedList<AnnotationUnit>();
        if (annotations != null) {
            for (AnnotationUnit unit : annotations) {
                if (attribute.equals(unit.getAttribute())) {
                    units.add(unit);
                }
            }
        }
        return units;
    }

    public List<AnnotationUnit> getPrimaryKeyInfo() {
        return getAnnotations(PRIMARY_KEY_INFO);
    }

    public AnnotationUnit getForeignKey() {
        return getAnnotation(FOREIGN_KEY);
    }
}
