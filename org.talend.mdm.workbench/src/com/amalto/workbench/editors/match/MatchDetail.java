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
public class MatchDetail {

    private String id;
    
    private MatchMatch[] matchs;

    public MatchDetail(String id, MatchMatch[] matchs) {
        this.id = id;
        this.matchs = matchs;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MatchMatch[] getMatch() {
        return this.matchs;
    }

    public void setMatch(MatchMatch[] matchs) {
        this.matchs = matchs;
    }
}

