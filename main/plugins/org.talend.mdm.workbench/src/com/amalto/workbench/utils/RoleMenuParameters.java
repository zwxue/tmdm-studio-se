// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
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
import java.util.LinkedHashSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.InputSource;

public class RoleMenuParameters {

    private static Log log = LogFactory.getLog(RoleMenuParameters.class);

    private String parentID = "";//$NON-NLS-1$

    private int position = 0;

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public static RoleMenuParameters unmarshalMenuParameters(LinkedHashSet<String> parameters) throws ValidationException,
            MarshalException {
        return (RoleMenuParameters) Unmarshaller.unmarshal(RoleMenuParameters.class, new InputSource(new StringReader(parameters
                .iterator().next())));
    }

    public LinkedHashSet<String> marshalMenuParameters() {
        LinkedHashSet<String> parameters = new LinkedHashSet<String>();
        try {
            StringWriter sw = new StringWriter();
            Marshaller.marshal(this, sw);
            parameters.add(sw.toString());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return parameters;
    }
}
