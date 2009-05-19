package com.amalto.workbench.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author aiming
 *
 */
public class LabelText {
	protected Label label;
	protected Text text;
	WidgetFactory factory =new WidgetFactory();
	public LabelText(Composite parent, final String labelName){
       label = factory.createLabel(parent, labelName, SWT.NULL);
       label.setLayoutData(
                new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
        );
        text = factory.createText(parent, "",SWT.BORDER);
        text.setLayoutData(    
                new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
        );		
        text.addFocusListener(new FocusAdapter(){
        	@Override
        	public void focusGained(FocusEvent e) {
        		text.selectAll();
        	}
        });
        text.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseDown(MouseEvent e) {
        		text.selectAll();
        	}
        });
        factory.adapt(parent);
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
	public void setText(Text text) {
		this.text = text;
	}
	
}
