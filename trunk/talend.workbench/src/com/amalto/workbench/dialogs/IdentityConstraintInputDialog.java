package com.amalto.workbench.dialogs;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xsd.XSDIdentityConstraintCategory;

public class IdentityConstraintInputDialog extends Dialog {

	private  Combo typeCombo=null;
	private Combo keyNameCombo=null;

	private String keyName="";
	private XSDIdentityConstraintCategory type;
	private List<String> deElements;
	
	private SelectionListener caller = null;
	private String title = "";
	

	/**
	 * @param parentShell
	 */
	public IdentityConstraintInputDialog(SelectionListener caller, Shell parentShell, String title,List<String> deElements) {
		this(caller,parentShell,title,"",XSDIdentityConstraintCategory.KEY_LITERAL,deElements);
	}

	/**
	 * @param parentShell
	 */
	public IdentityConstraintInputDialog(
			SelectionListener caller, 
			Shell parentShell, 
			String title,
			String keyName,
			XSDIdentityConstraintCategory type,
			List<String> deElements
			) {
		super(parentShell);
		this.caller = caller;
		this.title = title;
		this.keyName = keyName;
		this.type = type;
		this.deElements = deElements;
	}

	

	protected Control createDialogArea(Composite parent) {
		//Should not really be here but well,....
		parent.getShell().setText(this.title);
		
		Composite composite = (Composite) super.createDialogArea(parent);
		
		GridLayout layout = (GridLayout)composite.getLayout();
		layout.numColumns = 2;
		//layout.verticalSpacing = 10;
		
		Label serverLabel = new Label(composite, SWT.NONE);
		serverLabel.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
		);
		serverLabel.setText("Key Name");


		keyNameCombo  = new Combo(composite,SWT.DROP_DOWN | SWT.READ_ONLY);
		keyNameCombo.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
		);
		keyNameCombo.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
		);
//		keyNameCombo.add("key");
//		String[] names = new String[deElements.length];
//		for(int i=0;i<deElements.length;i++){
//			keyNameCombo.add(deElements[i].getName());
//		}
//		
		for(Iterator it = deElements.iterator();it.hasNext();){
			String string = (String)it.next();
			keyNameCombo.add(string);
		}
		Label typeLabel = new Label(composite, SWT.NONE);
		typeLabel.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
		);
		typeLabel.setText("Type");
				
		typeCombo = new Combo(composite,SWT.DROP_DOWN | SWT.READ_ONLY);
		typeCombo.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
		);
		typeCombo.add("Unique Key");
		typeCombo.add("Simple Key");
		typeCombo.select(0);
		//typeList.add("Foreign Key");  -- FIXME: foreign keys not supported now
				
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
//		keyName = keyNameText.getText();
		keyName = keyNameCombo.getText();
		if ((keyName==null) || ("".equals(keyName))) {
			MessageDialog.openError(
					this.getShell(), 
					"Error", "The Key Name cannot be empty"
			);
			setReturnCode(-1);
//			keyNameText.setFocus();
			keyNameCombo.setFocus();
			return;
		}
		
		String selection = (typeCombo.getText()).toUpperCase();
		if (selection.indexOf("UNIQUE")>=0)
			type = XSDIdentityConstraintCategory.UNIQUE_LITERAL;
		else if (selection.indexOf("FOREIGN")>=0)
			type = XSDIdentityConstraintCategory.KEYREF_LITERAL;
		else
			type = XSDIdentityConstraintCategory.KEY_LITERAL;
				
		setReturnCode(OK);
		//no close let Action Handler handle it
	}

	public String getKeyName() {
		return keyName;
	}

	public XSDIdentityConstraintCategory getType() {
		return type;
	}
	

}
