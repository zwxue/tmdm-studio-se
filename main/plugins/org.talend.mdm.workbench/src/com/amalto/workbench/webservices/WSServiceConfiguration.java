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
package com.amalto.workbench.webservices;

/**
 * DOC jsxie class global comment. Detailled comment
 */
public class WSServiceConfiguration {

    protected java.lang.String name;

    protected java.lang.String description;

    protected com.amalto.workbench.webservices.WSServicePutConfiguration[] servicePutConfigurations;

    public WSServiceConfiguration() {
    }

    public WSServiceConfiguration(java.lang.String name, java.lang.String description,
            com.amalto.workbench.webservices.WSServicePutConfiguration[] putConfigurations) {
        this.name = name;
        this.description = description;
        this.servicePutConfigurations = putConfigurations;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public com.amalto.workbench.webservices.WSServicePutConfiguration[] getServicePutConfigurations() {
        return servicePutConfigurations;
    }

    public void setServicePutConfigurations(com.amalto.workbench.webservices.WSServicePutConfiguration[] putConfigurations) {
        this.servicePutConfigurations = putConfigurations;
    }

}
