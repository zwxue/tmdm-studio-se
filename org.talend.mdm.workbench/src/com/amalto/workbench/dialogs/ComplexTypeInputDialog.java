package com.amalto.workbench.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;

import com.amalto.workbench.actions.XSDChangeToComplexTypeAction;
import com.amalto.workbench.actions.XSDNewComplexTypeDefinition;
import com.amalto.workbench.widgets.ConceptComposite;

public class ComplexTypeInputDialog extends Dialog implements ModifyListener{
	
	private SelectionListener caller = null;
	
	private String typeName = null;

	private ConceptComposite conceptPanel = null;
	
	List<XSDComplexTypeDefinition> types;
    
	private XSDSchema xsdSchema;
	
	private boolean isXSDModelGroup=false;
	/**
	 * @param parentShell
	 * @param isXSDModelGroup 
	 */
	public ComplexTypeInputDialog(
			SelectionListener caller, 
			Shell parentShell ,
			XSDSchema schema,
			List<XSDComplexTypeDefinition> types, boolean isXSDModelGroup
			) {
		super(parentShell);
		this.caller = caller;
		this.types=types;
		this.isXSDModelGroup=isXSDModelGroup;
		xsdSchema = schema;
	}

	

	protected Control createDialogArea(Composite parent) {
		//Should not really be here but well,....
		final Composite composite = (Composite) super.createDialogArea(parent);
		
		// encapsulate all widgets into the ConceptComposite which can be applied to several cases
		if (caller instanceof XSDNewComplexTypeDefinition) {
			parent.getShell().setText("Create a Complex Type");
			conceptPanel = new ConceptComposite(composite, false,types, true);
		} else {
			if(isXSDModelGroup)
				parent.getShell().setText("Change Sub-Element Group");
			else
				parent.getShell().setText("Change To Complex Type");
			conceptPanel = new ConceptComposite(composite, false,types, false);
		}
		conceptPanel.getTypeCombo().addModifyListener(this);
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


	public void modifyText(ModifyEvent e)
	{
		getButton(IDialogConstants.OK_ID).setEnabled(true);
		conceptPanel.setMessage("");
		
		String type = conceptPanel.getText();
		for(XSDTypeDefinition specType : xsdSchema.getTypeDefinitions())
		{
			String typeToCompare = specType.getName();
			int delimiter = type.indexOf(" : ");
			if(delimiter != -1)
			{
				type = type.substring(0, delimiter);
			}
			if(typeToCompare.equals(type))
			{
				if(caller instanceof XSDNewComplexTypeDefinition)
				{
					conceptPanel.setMessage("The same Type name already exists");
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
				else if (caller instanceof XSDChangeToComplexTypeAction
						&& specType instanceof XSDSimpleTypeDefinition)
				{
					conceptPanel.setMessage("The same Type name already exists");
					getButton(IDialogConstants.OK_ID).setEnabled(false);	
				}
				break;
			}
		}
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
