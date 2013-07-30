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
package com.amalto.workbench.webservices;

/**
 * created by HHB on 2013-7-18 Detailled comment
 * 
 */
public class WSDigestValueKey {

    protected String objectName;

    protected String type;

    public WSDigestValueKey(String type, String objectName) {
        super();
        this.type = type;
        this.objectName = objectName;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public String getType() {
        return this.type;
    }
}
