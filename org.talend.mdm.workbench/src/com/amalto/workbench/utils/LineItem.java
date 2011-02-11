package com.amalto.workbench.utils;

/***************************************************************
 * A Line Item Bean
 * 
 * @author bgrieder
 * 
 ***************************************************************/
public class LineItem {

    private long time;

    private String concept;

    private String[] ids;

    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public LineItem(long time, String concept, String[] ids, String taskId) {
        super();
        this.time = time;
        this.concept = concept;
        this.ids = ids;
        this.taskId = taskId;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

}
