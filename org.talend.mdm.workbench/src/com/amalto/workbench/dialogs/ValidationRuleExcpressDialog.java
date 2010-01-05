package com.amalto.workbench.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.amalto.workbench.widgets.SchematronExpressBuilder;

public class ValidationRuleExcpressDialog extends Dialog {
	private String title;
	private SchematronExpressBuilder builder;
	String value;
	String express;
	String conceptName;
	public ValidationRuleExcpressDialog(Shell parentShell,String title,String value,String conceptName) {
		super(parentShell);
		this.title=title;
		this.value=value;
		this.conceptName=conceptName;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.getShell().setText(this.title);		
		Composite composite = (Composite) super.createDialogArea(parent);
		builder=new SchematronExpressBuilder(composite,value,conceptName);
		return composite;
	}
	@Override
	protected void okPressed() {
		express=builder.getText();
		super.okPressed();
	}
	
	public String getExpression(){
		return express;
	}
	@Override
	protected boolean isResizable() {
		return false;
	}
}
