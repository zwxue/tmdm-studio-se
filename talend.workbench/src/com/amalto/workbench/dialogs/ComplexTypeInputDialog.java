package com.amalto.workbench.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ComplexTypeInputDialog extends Dialog {

	
	protected  Text typeNameText=null;
	protected Button sequenceButton = null;
	protected Button choiceButton = null;
	protected Button allButton = null;
	
	private SelectionListener caller = null;
	
	private String typeName = null;

	/**
	 * @param parentShell
	 */
	public ComplexTypeInputDialog(
			SelectionListener caller, 
			Shell parentShell 
			) {
		super(parentShell);
		this.caller = caller;
	}

	

	protected Control createDialogArea(Composite parent) {
		//Should not really be here but well,....
		parent.getShell().setText("Change To Complex Type");
		
		final Composite composite = (Composite) super.createDialogArea(parent);
		
		GridLayout layout = (GridLayout)composite.getLayout();
		layout.numColumns = 2;
		//layout.verticalSpacing = 10;

		Label typeNameLabel = new Label(composite, SWT.NONE);
		typeNameLabel.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
		);
		typeNameLabel.setText("Enter the name of the complex type. Leave blank for anonymous");

		typeNameText = new Text(composite,SWT.SINGLE);
		typeNameText.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,2,1)
		);
		
		Group radioGroup = new Group(composite,SWT.SHADOW_NONE);
		radioGroup.setText("Sub-Elements Group");
		radioGroup.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,2,1)
		);
		radioGroup.setLayout(new GridLayout(1,false));
		sequenceButton = new Button(radioGroup,SWT.RADIO);
		sequenceButton.setText("Sequence");
		sequenceButton.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
		);
		choiceButton = new Button(radioGroup,SWT.RADIO);
		choiceButton.setText("Choice");
		choiceButton.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
		);
		allButton = new Button(radioGroup,SWT.RADIO);
		allButton.setText("All");
		allButton.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
		);
		
		sequenceButton.setSelection(true);
		
	    return composite;
	}

	
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		getButton(IDialogConstants.OK_ID).addSelectionListener(this.caller);
		/*
	      createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
	                true);
	        createButton(parent, IDialogConstants.CANCEL_ID,
	                IDialogConstants.CANCEL_LABEL, false);
	  */
	}
	
	protected void okPressed() {				
		typeName = typeNameText.getText();
		setReturnCode(OK);
		//no close let Action Handler handle it
	}



	public boolean isSequence() {
		return sequenceButton.getSelection();
	}
	public boolean isChoice() {
		return choiceButton.getSelection();
	}
	public boolean isAll() {
		return allButton.getSelection();
	}
	public String getTypeName() {
		return typeName;
	}
	

}
