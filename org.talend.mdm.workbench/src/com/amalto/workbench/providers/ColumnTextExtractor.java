package com.amalto.workbench.providers;

public class ColumnTextExtractor<T> {

    private String accessMethodName;

    public ColumnTextExtractor(String methodName) {
        this.accessMethodName = methodName;
    }

    public String getAccessMethodName() {
        return accessMethodName;
    }

    public void setAccessMethodName(String accessMethodName) {

        if (accessMethodName == null || "".equals(accessMethodName.trim()))
            return;

        this.accessMethodName = accessMethodName;
    }

    public String getColText(T annoInfo) {

        if (annoInfo == null)
            return "";

        try {
            return annoInfo.getClass().getMethod(accessMethodName).invoke(annoInfo).toString();
        } catch (Exception e) {
            return "";
        }
    }
}
