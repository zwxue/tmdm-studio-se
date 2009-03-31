package com.amalto.workbench.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The instance of complexTableViewer
 * @author aiming
 *
 */
public class Line{
	/**
	 * key is the TableColumn name, value is the caressing column's value
	 */
	public List<KeyValue> keyValues=new ArrayList<KeyValue>();
	public Line(String[] keys,String[]values ){
		for(int i=0; i<keys.length && i<values.length; i++){
			keyValues.add(new KeyValue(keys[i],values[i]));
		}
	}
	public Line( List<KeyValue> keyValues){
		this.keyValues=keyValues;
	}
}
