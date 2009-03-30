package com.amalto.workbench.dialogs;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class SimpleTypeInputDialog extends Dialog {

	protected List customTypes=null;
	protected List builtInTypes=null;
	
	protected  Combo typeCombo=null;
	protected Button customButton = null;
	protected Button builtInButton = null;
	
	private SelectionListener caller = null;
	private String title = "";
	
	private String typeName = null;

	/**
	 * @param parentShell
	 */
	public SimpleTypeInputDialog(
			SelectionListener caller, 
			Shell parentShell, 
			String title,
			List customTypes,
			List builtInTypes
			) {
		super(parentShell);
		this.caller = caller;
		this.title = title;
		this.customTypes = customTypes;
		this.builtInTypes = builtInTypes;
	}

	

	protected Control createDialogArea(Composite parent) {
		//Should not really be here but well,....
		parent.getShell().setText(this.title);
		
		final Composite composite = (Composite) super.createDialogArea(parent);
		
		GridLayout layout = (GridLayout)composite.getLayout();
		layout.numColumns = 2;
		//layout.verticalSpacing = 10;

		Group radioGroup = new Group(composite,SWT.SHADOW_NONE);
		radioGroup.setText("Simple Types");
		radioGroup.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,2,1)
		);
		radioGroup.setLayout(new GridLayout(1,false));
		customButton = new Button(radioGroup,SWT.RADIO);
		customButton.setText("Custom");
		customButton.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
		);
		builtInButton = new Button(radioGroup,SWT.RADIO);
		builtInButton.setText("Built In");
		builtInButton.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
		);
		
		Label serverLabel = new Label(composite, SWT.NONE);
		serverLabel.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
		);
		serverLabel.setText("Type");
						
		typeCombo = new Combo(composite,SWT.DROP_DOWN);
		typeCombo.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
		);
		
		customButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
            	typeCombo.removeAll();
            	for (Iterator iter = customTypes.iterator(); iter.hasNext(); ) {
					String name = (String) iter.next();
					typeCombo.add(name);
				}
            	typeCombo.select(0);
            }
        });
		
		builtInButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
            	typeCombo.removeAll();
            	for (Iterator iter = builtInTypes.iterator(); iter.hasNext(); ) {
					String name = (String) iter.next();
					typeCombo.add(name);
				}
            	typeCombo.select(0);
            }
        });

		builtInButton.setSelection(true);
    	for (Iterator iter = builtInTypes.iterator(); iter.hasNext(); ) {
			String name = (String) iter.next();
			typeCombo.add(name);
		}
    	typeCombo.select(0);

		
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
		typeName = typeCombo.getText();
		if ((typeName==null) || ("".equals(typeName))) {
			MessageDialog.openError(
					this.getShell(), 
					"Error", "The Key Name cannot be empty"
			);
			setReturnCode(-1);
			typeCombo.setFocus();
			return;
		}
				
		setReturnCode(OK);
		//no close let Action Handler handle it
	}



	public boolean isBuiltIn() {
		return builtInButton.getSelection();
	}
	public String getTypeName() {
		return typeName;
	}
	

}
