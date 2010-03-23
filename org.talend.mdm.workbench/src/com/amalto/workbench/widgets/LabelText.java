package com.amalto.workbench.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.utils.Util;

/**
 * 
 * @author aiming
 *
 */
public class LabelText {
	protected Label label;
	protected Text text;
	//WidgetFactory factory =new WidgetFactory();
	public LabelText(FormToolkit toolkit,Composite parent, final String labelName){
       label = toolkit.createLabel(parent, labelName, SWT.NULL);
       label.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
        );
        text = toolkit.createText(parent, "",SWT.BORDER|SWT.MULTI);
        text.setLayoutData(    
                new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
        );		
        //text.addFocusListener(factory.focusListener);
//        Util.createCompDropTarget(text);
	}
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public Text getText() {
		return text;
	}
	public void setText(String text) {
		this.text.setText(text);
	}
	
}
