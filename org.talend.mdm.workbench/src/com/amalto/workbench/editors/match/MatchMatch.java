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
public class MatchMatch {

    private boolean is_match;

    private MatchScore[] scores;

    public MatchMatch(boolean is_match, MatchScore[] scores) {
        this.is_match = is_match;
        this.scores = scores;
    }

    public boolean isIs_match() {
        return this.is_match;
    }

    public void setIs_match(boolean is_match) {
        this.is_match = is_match;
    }

    public MatchScore[] getScores() {
        return this.scores;
    }

    public void setScores(MatchScore[] scores) {
        this.scores = scores;
    }
}
