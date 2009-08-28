package com.amalto.workbench.models;

import java.util.ArrayList;
import java.util.List;

import com.amalto.workbench.widgets.ComplexTableViewerColumn;

/**
 * The instance of complexTableViewer
 * @author aiming
 *
 */
public class Line implements  Cloneable{
	/**
	 * key is the TableColumn name, value is the  column's value
	 */
	public List<KeyValue> keyValues=new ArrayList<KeyValue>();
	public Line(ComplexTableViewerColumn[] keys,String[]values ){
		for(int i=0; i<keys.length && i<values.length; i++){
			keyValues.add(new KeyValue(keys[i].getName(),values[i]));
		}
	}
	public Line( List<KeyValue> keyValues){
		this.keyValues=keyValues;
	}
	

        
    public Line clone()
    {
    	List<KeyValue> copyKeyValues = new ArrayList<KeyValue>();
    	for (KeyValue kv: keyValues)
    	{
    		KeyValue kkvv=new KeyValue(kv.key,kv.value);
    		copyKeyValues.add(kkvv);
    	}
    	return new Line(copyKeyValues);
    }
}
