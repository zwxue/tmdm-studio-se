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
package com.amalto.workbench.detailtabs.sections.model.simpletype;

import java.util.ArrayList;
import java.util.List;

public class SimpleTypeStringListFacetInfo extends SimpleTypeFacetInfo<String[]> {

    private String delimiter = " ; ";

    public SimpleTypeStringListFacetInfo(String propName, String[] propValue, String delimiter) {
        super(propName, propValue);

        this.delimiter = delimiter;
    }

    @Override
    protected String getValueLabel(String[] values) {

        String result = "";

        for (String eachValue : values) {
            result += (eachValue + delimiter);
        }

        if (result.length() < 1)
            return "";

        return result.substring(0, result.length() - delimiter.length());
    }

    @Override
    protected String[] parseLabel(String label) {

        if (label == null || "".equals(label.trim()))
            return new String[0];

        String[] infos = label.split(delimiter);

        if (infos.length == 0)
            return new String[] { label };

        List<String> results = new ArrayList<String>();
        for (String eachInfo : infos) {

            if ("".equals(eachInfo.trim()))
                continue;

            results.add(eachInfo);
        }

        return results.toArray(new String[0]);

    }

    public String getDelimiter() {
        return delimiter;
    }
}
