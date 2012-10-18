// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * created by liusongbo on 2012-10-17
 *
 */
public class UserExceptionStackFilter {

    private static final Log log = LogFactory.getLog(UserExceptionStackFilter.class);

    private static final String SUFFIX = ";"; //$NON-NLS-1$

    private static final String SEP = ":"; //$NON-NLS-1$

    private static final String EXCEPTION_SEP = "Exception:";//$NON-NLS-1$

    private static final String CAUSEBY_SEP = "\\[Caused by\\]:"; //$NON-NLS-1$

    private static final String NEST_SEP = "nested exception"; //$NON-NLS-1$


    public static String[] filterExceptionMsg(String msg) {
        if (msg == null || msg.trim().isEmpty()) {
            return new String[0];
        }

        List<String> msgs = new ArrayList<String>();

        try {
            String[] splits = split(msg, CAUSEBY_SEP);

            // add parent exception message
            int index = splits[0].indexOf(SEP);
            int lastIndex = splits[0].lastIndexOf(SEP);
            String mainMsg = splits[0].substring(0, index).trim();
            mainMsg += splits[0].substring(lastIndex).trim();
            if (mainMsg.endsWith(SUFFIX)) {
                mainMsg = mainMsg.substring(0, mainMsg.length() - 1);
            }
            msgs.add(mainMsg);

            // add children exception message
            if (splits.length > 1) {
                String s = null;
                for (int i = 1; i < splits.length; i++) {
                    s = splits[i].trim();
                    int subIndex = s.indexOf(NEST_SEP);
                    if (subIndex != -1) {
                        s = s.substring(0, subIndex);
                    }

                    int lastSubIndex = s.lastIndexOf(EXCEPTION_SEP);
                    if (lastSubIndex != -1) {
                        s = s.substring(lastSubIndex + EXCEPTION_SEP.length()).trim();
                    }

                    s = s.trim();
                    if (s.endsWith(SUFFIX)) {
                        s = s.substring(0, s.length() - 1);
                    }

                    msgs.add(s);
                }
            }

            removeDupMsg(msgs);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            msgs.clear();
            msgs.add(msg);
        }

        return msgs.toArray(new String[0]);
    }

    private static String[] split(String msg, String delimiter) {
        return msg.split(delimiter);
    }

    /**
     * remove adjacent duplicated messages
     */
    private static void removeDupMsg(List<String> msgs) {
        if (msgs != null) {
            List<Integer> removeIndex = new ArrayList<Integer>();

            for (int i = 1, j = 2; i < msgs.size() && j < msgs.size();) {
                if (msgs.get(i).equals(msgs.get(j))) {
                    removeIndex.add(0, j);
                    j++;
                    continue;
                }

                i = j;
                j++;
            }

            for (Integer i : removeIndex) {
                msgs.remove(i.intValue());
            }
        }
    }
}