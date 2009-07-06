package com.amalto.workbench.widgets;

import org.eclipse.swt.widgets.Control;

public class ComplexTableViewerColumn {

	String name;
	boolean isNillable = false;
	String nillValue = "";
	String nillDisplay = "";
	private String defaultValue = "";
	private boolean isCombo = false;
	private String[] comboValues = new String[0];
	private int textLines = 1;
	private int columnWidth = 0;
	//The actual control
	private Control control;
	
	//Extra fields
	private boolean isComboEditable = false;
	private boolean forceTextCellEditor = false;
	
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
	
	

	public ComplexTableViewerColumn(String name, boolean isNillable, String nillValue, String nillDisplay, String defaultValue, boolean isCombo, String[] comboValues, int textLines) {
	    super();
	    this.name = name;
	    this.isNillable = isNillable;
	    this.nillValue = nillValue;
	    this.nillDisplay = nillDisplay;
	    this.defaultValue = defaultValue;
	    this.isCombo = isCombo;
	    this.comboValues = comboValues;
	    this.textLines = textLines;
    }
	
	public ComplexTableViewerColumn(String name, boolean isNillable, String nillValue, String nillDisplay, String defaultValue, boolean isCombo, String[] comboValues, int textLines,boolean isComboEditable,boolean forceTextCellEditor) {
	    super();
	    this.name = name;
	    this.isNillable = isNillable;
	    this.nillValue = nillValue;
	    this.nillDisplay = nillDisplay;
	    this.defaultValue = defaultValue;
	    this.isCombo = isCombo;
	    this.comboValues = comboValues;
	    this.textLines = textLines;
	    this.isComboEditable= isComboEditable;
	    this.forceTextCellEditor=forceTextCellEditor;
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

	public String getDefaultValue() {
    	return defaultValue;
    }

	public void setDefaultValue(String defaultValue) {
    	this.defaultValue = defaultValue;
    }

	public boolean isCombo() {
    	return isCombo;
    }

	public void setCombo(boolean isCombo) {
    	this.isCombo = isCombo;
    }

	public String[] getComboValues() {
    	return comboValues;
    }

	public void setComboValues(String[] comboValues) {
    	this.comboValues = comboValues;
    }

	public int getTextLines() {
    	return textLines;
    }

	public void setTextLines(int textLines) {
    	this.textLines = textLines;
    }

	public Control getControl() {
    	return control;
    }

	public void setControl(Control control) {
    	this.control = control;
    }
	
	
	public boolean isComboEditable() {
		return isComboEditable;
	}

	public void setComboEditable(boolean isComboEditable) {
		this.isComboEditable = isComboEditable;
	}

	public void setColumnWidth(int width)
	{
		columnWidth = width;
	}
	
	public int getColumnWidth()
	{
		return columnWidth;
	}
	
	public boolean isForceTextCellEditor() {
		return forceTextCellEditor;
	}

	public void setForceTextCellEditor(boolean forceTextCellEditor) {
		this.forceTextCellEditor = forceTextCellEditor;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ComplexTableViewerColumn){
			ComplexTableViewerColumn compareObj=(ComplexTableViewerColumn)obj;
			String compareName=compareObj.getName()==null?"":compareObj.getName();
			String currentName=name==null?"":name;
			return compareName.equals(currentName);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		String currentName=name==null?"":name;
		return currentName.hashCode();
	}
	
	
}
