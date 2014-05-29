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
package com.amalto.workbench.editors.match;

import com.amalto.workbench.models.KeyValue;


/**
 * created by talend2 on 2014-5-19
 * Detailled comment
 *
 */
public class MatchResult {

    private String id;

    private double confidence;

    private String[] related_ids;

    private KeyValue[] values;

    public MatchResult(String id, double confidence, String[] related_ids, KeyValue[] values) {
        this.id = id;
        this.confidence = confidence;
        this.related_ids = related_ids;
        this.values = values;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getConfidence() {
        return this.confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String[] getRelated_ids() {
        return this.related_ids;
    }

    public void setRelated_ids(String[] related_ids) {
        this.related_ids = related_ids;
    }

    public KeyValue[] getValues() {
        return this.values;
    }

    public void setValues(KeyValue[] values) {
        this.values = values;
    }
}
