// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.utils;

import java.io.StringReader;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

public class RoleWhereCondition {

    private static Log log = LogFactory.getLog(RoleWhereCondition.class);

    String leftPath;

    String operator;

    String rightValueOrPath;

    String predicate;

    public String getLeftPath() {
        return leftPath;
    }

    public void setLeftPath(String leftPath) {
        this.leftPath = leftPath;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public String getRightValueOrPath() {
        return rightValueOrPath;
    }

    public void setRightValueOrPath(String righValueOrPath) {
        this.rightValueOrPath = righValueOrPath;
    }

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        try {
            Marshaller.marshal(this, sw);
        } catch (Exception e) {
            log.info("toString() ERROR MARSHALLING WhereCondition");
            log.error(e.getMessage(), e);
        }
        return sw.toString();
    }

    public static RoleWhereCondition parse(String marshalledWC) {
        RoleWhereCondition rwc = null;
        try {
            rwc = (RoleWhereCondition) Unmarshaller.unmarshal(RoleWhereCondition.class, new StringReader(marshalledWC));
        } catch (Exception e) {
            log.info("toString() ERROR UNMARSHALLING WhereCondition");
            log.error(e.getMessage(), e);
        }
        return rwc;
    }
}
