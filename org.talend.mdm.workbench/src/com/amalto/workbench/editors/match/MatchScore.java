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



/**
 * created by liusongbo on 2014-5-19
 */
public class MatchScore {

    private String pair_id;

    private String field;

    private String algorithm;

    private double value;

    private double threshold;

    public MatchScore(String pair_id, String field, String algorithm, double value, double threshold) {
        this.pair_id = pair_id;
        this.field = field;
        this.algorithm = algorithm;
        this.value = value;
        this.threshold = threshold;
    }

    public String getPair_id() {
        return this.pair_id;
    }

    public void setPair_id(String pair_id) {
        this.pair_id = pair_id;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getThreshold() {
        return this.threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
}
