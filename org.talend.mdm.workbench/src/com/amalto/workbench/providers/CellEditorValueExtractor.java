package com.amalto.workbench.providers;

public class CellEditorValueExtractor<T> {

    protected String inforAccessMethod;

    public CellEditorValueExtractor(String inforAccessMethod) {
        this.inforAccessMethod = inforAccessMethod;
    }

    public Object getValue(T info) {

        if (info == null)
            return "";

        Object result = getInfoContent(info);

        if (result == null)
            return "";

        return result;
    }

    protected Object getInfoContent(T info) {

        if (inforAccessMethod == null || "".equals(inforAccessMethod.trim()))
            return null;

        try {
            return info.getClass().getMethod(inforAccessMethod).invoke(info);
        } catch (Exception e) {
            return null;
        }
    }
}
