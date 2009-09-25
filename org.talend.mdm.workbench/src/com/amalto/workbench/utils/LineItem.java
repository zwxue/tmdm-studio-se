package com.amalto.workbench.utils;

/***************************************************************
 * A Line Item Bean
 * @author bgrieder
 *
 ***************************************************************/
public class LineItem {

	private long time;
	private String concept;
	private String[] ids;

	public LineItem(long time, String concept, String[] ids) {
		super();
		this.time = time;
		this.concept = concept;
		this.ids = ids;
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
