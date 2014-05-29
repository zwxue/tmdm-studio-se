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
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.amalto.workbench.models.KeyValue;

/**
 * created by liusongbo on 2014-5-19
 */
public class MatchData {

    private static final Log log = LogFactory.getLog(MatchData.class);

    private String matchString;

    private MatchGroup[] matchGroup;

    public static final String BLOCK_KEY = "BLOCK_KEY"; //$NON-NLS-1$

    public static final String GID = "GID"; //$NON-NLS-1$

    public static final String GRP_SIZE = "GRP_SIZE"; //$NON-NLS-1$

    public static final String MASTER = "MASTER"; //$NON-NLS-1$

    public static final String CONFIDENCE = "CONFIDENCE"; //$NON-NLS-1$

    public static final String ATTR_SCORE = "ATTR_SCORE"; //$NON-NLS-1$

    private static final String[] mandatoryColumns = new String[] { BLOCK_KEY, GID, GRP_SIZE, MASTER, CONFIDENCE, ATTR_SCORE };

    private final String ID_COLUMN = "ID";;

    public MatchData(String jsonMatchString) {
        this.matchString = jsonMatchString;
        matchGroup = getAllGroups();
    }

    public MatchGroup[] getAllGroups() {
        if (matchGroup == null) {
            List<MatchGroup> groups = new ArrayList<MatchGroup>();
            try {
                JSONObject json = new JSONObject(matchString);
                JSONArray groupsArray = json.getJSONArray("groups"); //$NON-NLS-1$
                for (int i = 0; i < groupsArray.length(); i++) {
                    JSONObject groupObject = groupsArray.getJSONObject(i);
                    MatchGroup group = getGroup(groupObject);
                    group.setGroupName("Group " + (i + 1)); //$NON-NLS-1$
                    groups.add(group);
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            matchGroup = groups.toArray(new MatchGroup[0]);
        }

        return matchGroup;
    }

    public String[] getFieldNames() {
        List<String> fields = new ArrayList<String>();
        for (MatchGroup group : getAllGroups()) {
            for (String field : group.getFieldNames()) {
                if (!fields.contains(field.toUpperCase())) {
                    fields.add(field.toUpperCase());
                }
            }
        }

        for (String field : mandatoryColumns) {
            fields.add(field);
        }

        if (!fields.contains(ID_COLUMN)) {
            fields.add(0, ID_COLUMN);
        }

        return fields.toArray(new String[0]);
    }

    private MatchGroup getGroup(JSONObject groupObject) throws JSONException {
        JSONArray groupArray = groupObject.getJSONArray("group"); //$NON-NLS-1$
        JSONObject resultObject = groupArray.getJSONObject(0);
        JSONObject detailObject = groupArray.getJSONObject(1);

        MatchResult matchResult = getMatchResult(resultObject);
        MatchDetail[] matchDetails = getMatchDetails(detailObject);

        return new MatchGroup(groupObject.toString(2), matchResult, matchDetails);
    }

    private MatchResult getMatchResult(JSONObject resultObject) throws JSONException {
        JSONArray resultArray = resultObject.getJSONArray("result"); //$NON-NLS-1$
        JSONObject jobj = (JSONObject) resultArray.get(0);// id
        String id = jobj.getString("id"); //$NON-NLS-1$

        jobj = (JSONObject) resultArray.get(1);// confidence
        double confidence = jobj.getDouble("confidence"); //$NON-NLS-1$

        jobj = (JSONObject) resultArray.get(2);// related_id
        JSONArray related_ids = jobj.getJSONArray("related_ids"); //$NON-NLS-1$
        String[] rids = new String[related_ids.length()];
        for (int i = 0; i < related_ids.length(); i++) {
            rids[i] = related_ids.getString(i);
        }

        JSONObject valueObject = (JSONObject) resultArray.get(3);
        KeyValue[] values = getValues(valueObject);// /////////////////////////////?

        return new MatchResult(id, confidence, rids, values);
    }

    private KeyValue[] getValues(JSONObject valueObject) throws JSONException {
        JSONArray valuesArray = valueObject.getJSONArray("values"); //$NON-NLS-1$
        KeyValue[] values = new KeyValue[valuesArray.length()];
        for (int i = 0; i < valuesArray.length(); i++) {
            JSONObject valueObj = valuesArray.getJSONObject(i);
            JSONArray valueArray = valueObj.getJSONArray("value"); //$NON-NLS-1$

            JSONObject fieldO = valueArray.getJSONObject(0);
            String field = fieldO.getString("field"); //$NON-NLS-1$

            JSONObject valueO = valueArray.getJSONObject(1);
            String value = valueO.getString("value"); //$NON-NLS-1$
            values[i] = new KeyValue(field, value);
        }

        return values;
    }

    private MatchDetail[] getMatchDetails(JSONObject detailsObject) throws JSONException {
        JSONArray detailsArray = detailsObject.getJSONArray("details"); //$NON-NLS-1$
        MatchDetail[] matchDetails = new MatchDetail[detailsArray.length()];
        for (int i = 0; i < detailsArray.length(); i++) {
            JSONObject detailObject = detailsArray.getJSONObject(i);
            matchDetails[i] = getMatchDetail(detailObject);
        }

        return matchDetails;
    }

    private MatchDetail getMatchDetail(JSONObject detailObject) throws JSONException {
        JSONArray detailArray = detailObject.getJSONArray("detail"); //$NON-NLS-1$
        String id = detailArray.getJSONObject(0).getString("id"); //$NON-NLS-1$

        MatchMatch[] mms = null;
        if (detailArray.length() > 1) {
            mms = new MatchMatch[detailArray.length() - 1];
            for (int i = 1; i < detailArray.length(); i++) {
                JSONObject matchObject = detailArray.getJSONObject(i);
                mms[i - 1] = getMatchMatch(matchObject);
            }
        }


        return new MatchDetail(id, mms);
    }

    private MatchMatch getMatchMatch(JSONObject matchObject) throws JSONException {
        JSONArray matchArray = matchObject.getJSONArray("match"); //$NON-NLS-1$
        boolean is_match = matchArray.getJSONObject(0).getBoolean("is_match"); //$NON-NLS-1$

        JSONObject scoreObject = matchArray.getJSONObject(1);

        MatchScore[] matchScores = getMatchScores(scoreObject);

        return new MatchMatch(is_match, matchScores);
    }

    private MatchScore[] getMatchScores(JSONObject scoreObject) throws JSONException {
        JSONArray scoresArray = scoreObject.getJSONArray("scores"); //$NON-NLS-1$
        int length = scoresArray.length();
        MatchScore[] matchScores = new MatchScore[length];
        for (int i = 0; i < length; i++) {
            JSONArray scoreArray = scoresArray.getJSONObject(i).getJSONArray("score"); //$NON-NLS-1$
            JSONObject scoreObj = scoreArray.getJSONObject(0);
            String pair_id = scoreObj.getString("pair_id"); //$NON-NLS-1$

            scoreObj = scoreArray.getJSONObject(1);
            String field = scoreObj.getString("field"); //$NON-NLS-1$

            scoreObj = scoreArray.getJSONObject(2);
            double value = scoreObj.getDouble("value"); //$NON-NLS-1$

            scoreObj = scoreArray.getJSONObject(3);
            String algorithm = scoreObj.getString("algorithm"); //$NON-NLS-1$

            scoreObj = scoreArray.getJSONObject(4);
            double threshold = scoreObj.getDouble("threshold"); //$NON-NLS-1$

            matchScores[i] = new MatchScore(pair_id, field, algorithm, value, threshold);
        }

        return matchScores;
    }
}
