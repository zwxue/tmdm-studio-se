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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amalto.workbench.models.KeyValue;
import com.amalto.workbench.models.Line;


/**
 * created by liusongbo on 2014-5-19
 */
public class MatchGroup {

    private String groupId;

    private String groupName;

    private MatchResult matchResult;

    private MatchDetail[] matchDetails;

    private String groupContent;

    public MatchGroup(String groupContent, MatchResult result, MatchDetail[] detail) {
        this.groupContent = groupContent;
        this.matchResult = result;
        this.matchDetails = detail;
    }

    public MatchGroup(String groupId, String groupName, MatchResult result, MatchDetail[] detail) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.matchResult = result;
        this.matchDetails = detail;
    }

    public String getMasterId() {
        String masterId = matchResult.getId();// master id, group id
        return masterId;
    }

    public String[] getRelatedIds() {
        String[] related_ids = matchResult.getRelated_ids();// contains master id

        return related_ids;
    }

    public KeyValue[] getGroupValues() {
        KeyValue[] values = matchResult.getValues(); // group value

        return values;
    }

    public double getConfidence() {
        return matchResult.getConfidence();
    }

    public Map<String, Line> getAttributeScores() {
        String perfactMatchScore = "1.0"; //$NON-NLS-1$
        String masterId = getMasterId();
        String[] relatedIds = getRelatedIds();
        String[] fieldNames = getFieldNames();

        List<KeyValue> keyvalues = new ArrayList<KeyValue>(fieldNames.length);

        Map<String, Line> attr_scores = new HashMap<String, Line>();
        if (relatedIds.length == 1) {
            for (String fieldName : fieldNames) {
                keyvalues.add(new KeyValue(fieldName, perfactMatchScore));
            }

            attr_scores.put(masterId, new Line(keyvalues));
        } else {
            List<String> matchRecordIds = new ArrayList<String>(Arrays.asList(relatedIds));
            for (MatchDetail detail : getMatchDetails()) {
                keyvalues = new ArrayList<KeyValue>(fieldNames.length);
                if (matchRecordIds.contains(detail.getId())) {
                    if (masterId.equals(detail.getId())) {
                        for (String fieldName : fieldNames) {
                            keyvalues.add(new KeyValue(fieldName, perfactMatchScore));
                        }
                    } else {
                        MatchScore[] scores = detail.getMatch()[0].getScores();
                        for (MatchScore score : scores) {
                            keyvalues.add(new KeyValue(score.getField(), "" + score.getValue())); //$NON-NLS-1$
                        }
                    }
                }

                attr_scores.put(detail.getId(), new Line(keyvalues));
            }
        }

        return attr_scores;
    }

    public String[] getFieldNames() {
        KeyValue[] values = matchResult.getValues();
        String[] fields = new String[values.length];
        int i = 0;
        for (KeyValue keyValue : values) {
            fields[i++] = keyValue.key;
        }

        return fields;
    }

    public String getContent() {
        return groupContent;
    }

    public String getGroupId() {
        if (this.groupId == null) {
            return getMasterId();
        }
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }

    public MatchResult getMatchResult() {
        return this.matchResult;
    }

    public void setMatchDetails(MatchDetail[] matchDetail) {
        this.matchDetails = matchDetail;
    }

    public MatchDetail[] getMatchDetails() {
        return this.matchDetails;
    }
}
