package com.amalto.workbench.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.amalto.workbench.widgets.ConceptComposite;

public class ComplexTypeInputDialog extends Dialog {
	
	private SelectionListener caller = null;
	
	private String typeName = null;

	private ConceptComposite conceptPanel = null;
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
		// encapsulate all widgets into the ConceptComposite which can be applied to several cases
		conceptPanel = new ConceptComposite(composite, false);
		
	    return conceptPanel.getComposite();
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
		typeName = conceptPanel.getText();
		setReturnCode(OK);
		//no close let Action Handler handle it
	}



	public boolean isSequence() {
		return conceptPanel.isSequence();
	}
	public boolean isChoice() {
		return conceptPanel.isChoice();
	}
	public boolean isAll() {
		return conceptPanel.isAll();
	}
	public String getTypeName() {
		return typeName;
	}
	

}
