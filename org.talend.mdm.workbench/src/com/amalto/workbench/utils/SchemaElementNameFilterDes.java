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

import java.util.ArrayList;
import java.util.List;

public class SchemaElementNameFilterDes {

    private boolean enable;

    private String sourceFilterExpression = new String();

    private static final String SEPARATOR = ",";

    public SchemaElementNameFilterDes() {
        this(false, "");
    }

    public SchemaElementNameFilterDes(boolean enable, String sourceFilterExpression) {
        setEnable(enable);
        setSourceFilterExpression(sourceFilterExpression);
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getSourceFilterExpression() {
        return sourceFilterExpression;
    }

    public void setSourceFilterExpression(String sourceFilterExpression) {

        if (sourceFilterExpression == null)
            this.sourceFilterExpression = "";
        else if (!sourceFilterExpression.equals(this.sourceFilterExpression))
            this.sourceFilterExpression = sourceFilterExpression;
    }

    public String[] getSeparatedFilterExpressions() {

        List<String> filterExpressions = new ArrayList<String>();

        for (String eachExpression : getSourceFilterExpression().split(SEPARATOR)) {
            if (!"".equals(eachExpression.trim()))
                filterExpressions.add(eachExpression);
        }

        return filterExpressions.toArray(new String[filterExpressions.size()]);
    }

}
