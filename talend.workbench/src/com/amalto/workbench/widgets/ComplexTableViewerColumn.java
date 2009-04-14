package com.amalto.workbench.widgets;

public class ComplexTableViewerColumn {

	String name;
	boolean isNillable = false;
	String nillValue = "";
	String nillDisplay = "";
	public String getName() {
    	return name;
    }
	
	public ComplexTableViewerColumn(String name) {
	    this.name = name;
    }
	
	public ComplexTableViewerColumn(String name, boolean isNillable, String nillValue, String nillDisplay) {
	    super();
	    this.name = name;
	    this.isNillable = isNillable;
	    this.nillValue = nillValue;
	    this.nillDisplay = nillDisplay;
    }

	public void setName(String name) {
    	this.name = name;
    }
	public boolean isNillable() {
    	return isNillable;
    }
	public void setNillable(boolean isNillable) {
    	this.isNillable = isNillable;
    }
	public String getNillValue() {
    	return nillValue;
    }
	public void setNillValue(String nillValue) {
    	this.nillValue = nillValue;
    }
	public String getNillDisplay() {
    	return nillDisplay;
    }
	public void setNillDisplay(String nillDisplay) {
    	this.nillDisplay = nillDisplay;
    }
	
	
	
}
