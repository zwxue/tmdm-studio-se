package com.amalto.workbench.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;

import com.amalto.workbench.actions.XSDChangeBaseTypeAction;
import com.amalto.workbench.actions.XSDChangeToSimpleTypeAction;
import com.amalto.workbench.actions.XSDNewSimpleTypeDefinition;
import com.amalto.workbench.widgets.ElementComposite;

public class SimpleTypeInputDialog extends Dialog implements ModifyListener{

	protected List<String> customTypes=null;
	protected List<String> builtInTypes=null;
	
	private SelectionListener caller = null;
	private XSDSchema xsdSchema = null;
	private String title = "";
	
	private String typeName = null;

	private ElementComposite elemPanel = null;
	private Label infoLabel = null;
	/**
	 * @param parentShell
	 */
	public SimpleTypeInputDialog(
			SelectionListener caller, 
			Shell parentShell,
			XSDSchema schema,
			String title,
			List customTypes,
			List builtInTypes
			) {
		super(parentShell);
		this.caller = caller;
		this.title = title;
		this.customTypes = customTypes;
		this.builtInTypes = builtInTypes;
		xsdSchema = schema;
	}

	

	protected Control createDialogArea(Composite parent) {
		//Should not really be here but well,....
		parent.getShell().setText(this.title);
		
		final Composite composite = (Composite) super.createDialogArea(parent);
		// encapsulate all widgets into the ElementComposite which can be applied to several cases
		elemPanel = new ElementComposite(composite, customTypes, builtInTypes, false);
		elemPanel.getTypeCombo().addModifyListener(this);
		
		infoLabel = new Label(composite, SWT.NONE);
		infoLabel.setLayoutData(
				new GridData(SWT.FILL,SWT.FILL,true,true,2,1));
		
	    return elemPanel.getComposite();
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
		typeName = elemPanel.getText();
//		if ((typeName==null) || ("".equals(typeName))) {
//			MessageDialog.openError(
//					this.getShell(), 
//					"Error", "The Key Name cannot be empty"
//			);
//			setReturnCode(-1);
//			elemPanel.setFocus();
//			return;
//		}
//				
		setReturnCode(OK);
		//no close let Action Handler handle it
	}



	public boolean isBuiltIn() {
		return elemPanel.isBuiltIn();
	}
	public String getTypeName() {
		return typeName;
	}
	
	public void modifyText(ModifyEvent e)
	{
		getButton(IDialogConstants.OK_ID).setEnabled(true);
		infoLabel.setText("");
		
		String type = elemPanel.getText();
		for(XSDTypeDefinition simpType : xsdSchema.getTypeDefinitions())
		{
			String typeToCompare = simpType.getName();
			int delimiter = type.indexOf(" : ");
			if(delimiter != -1)
			{
				type = type.substring(0, delimiter);
			}
			if(typeToCompare.equals(type))
			{
				if(caller instanceof XSDNewSimpleTypeDefinition)
				{
					infoLabel.setText("The same Type name already exists");
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
				else if ((caller instanceof XSDChangeToSimpleTypeAction || caller instanceof XSDChangeBaseTypeAction)
						&& simpType instanceof XSDComplexTypeDefinition)
				{
					infoLabel.setText("The same Type name already exists");
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
				return;
			}
		}
	}
}
