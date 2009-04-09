package com.amalto.workbench.utils;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author aiming
 *
 */
public class WidgetUtils {
	public static void enable(Composite parent,boolean enabled){
		parent.setEnabled(enabled);
		for(Control control:parent.getChildren()){
			if(control instanceof Text || control instanceof CCombo || control instanceof Combo|| control instanceof Button){
				control.setEnabled(enabled);
			}
			if(control instanceof Composite){
				enable((Composite)control, enabled);
			}
		}
		
	}
}
