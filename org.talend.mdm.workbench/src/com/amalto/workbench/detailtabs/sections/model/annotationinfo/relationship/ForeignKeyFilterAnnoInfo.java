package com.amalto.workbench.detailtabs.sections.model.annotationinfo.relationship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.eclipse.xsd.XSDComponent;

import com.amalto.workbench.detailtabs.sections.handlers.CommitHandler;
import com.amalto.workbench.detailtabs.sections.handlers.ElementForeignKeyFilterCommitHandler;
import com.amalto.workbench.detailtabs.sections.model.annotationinfo.listinfo.SingleContentAnnotationInfo;

public class ForeignKeyFilterAnnoInfo extends SingleContentAnnotationInfo {

    private static final String CUSTOM_FILTERS_PREFIX = "$CFFP:";

    public ForeignKeyFilterAnnoInfo(XSDComponent sourceComponent, String fkFilter) {
        super(sourceComponent, fkFilter);
    }

    public CommitHandler<ForeignKeyFilterAnnoInfo> createCommitHandler() {
        return new ElementForeignKeyFilterCommitHandler(this);
    }

    public static boolean isCustomFilter(String filterExpression) {
        return filterExpression.startsWith(CUSTOM_FILTERS_PREFIX);
    }

    public static String getCustomFilterInfo(String filterExpression) {

        if (isCustomFilter(filterExpression))
            return filterExpression;

        return "";
    }

    public static ForeignKeyFilterAnnoInfoDefUnit[] getFKFilterCfgInfos(String filterExpression) {

        if (isCustomFilter(filterExpression)) {
            return new ForeignKeyFilterAnnoInfoDefUnit[0];
        }

        List<ForeignKeyFilterAnnoInfoDefUnit> fkFilterInfos = new ArrayList<ForeignKeyFilterAnnoInfoDefUnit>();

        if (filterExpression != null) {
            String[] criterias = filterExpression.split("#");
            for (String cria : criterias) {
                String[] values = cria.split("\\$\\$");
                List<String> list = new ArrayList<String>();
                list.addAll(Arrays.asList(values));
                int num = 4 - list.size();
                for (int i = 0; i < num; i++) {
                    list.add("");
                }

                fkFilterInfos.add(new ForeignKeyFilterAnnoInfoDefUnit(list.get(0), list.get(1), list.get(2).replaceAll("&quot;",
                        "\""), list.get(3)));

            }
        }
        return fkFilterInfos.toArray(new ForeignKeyFilterAnnoInfoDefUnit[0]);

    }

    public static String getFKFilterByRawCustomFilterStr(String inputedFilterStr) {

        if (inputedFilterStr.startsWith(CUSTOM_FILTERS_PREFIX))
            return inputedFilterStr;

        return StringEscapeUtils.escapeXml(CUSTOM_FILTERS_PREFIX + inputedFilterStr);
    }

    public static String getFKFilterByFKFilterCfgInfos(ForeignKeyFilterAnnoInfoDefUnit[] fkFilterCfgInfos) {

        StringBuffer sb = new StringBuffer();
        for (ForeignKeyFilterAnnoInfoDefUnit eachFKFilterInfo : fkFilterCfgInfos) {
            sb.append(eachFKFilterInfo.getXpath() + "$$" + eachFKFilterInfo.getOperator() + "$$"
                    + eachFKFilterInfo.getNormalizeValue() + "$$" + eachFKFilterInfo.getPredicate() + "#");
        }

        return sb.toString();
    }
}
