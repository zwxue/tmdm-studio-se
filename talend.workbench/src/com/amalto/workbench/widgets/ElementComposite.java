package com.amalto.workbench.widgets;

import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

/**
 * this class is meant to encapsulate all widgets rendering element
 * it can output composite to populate element form
 * @author Developer
 *
 */
public class ElementComposite {
	private  Combo typeCombo=null;
	private Button customButton = null;
	private Button builtInButton = null;
	private Label serverLabel = null;
	
	private Composite container = null;
	
	public  ElementComposite(Composite parent,
			final List customTypes, final List builtInTypes, boolean encloseTextField) {
		GridLayout layout = (GridLayout)parent.getLayout();
		layout.numColumns = 2;
		//layout.verticalSpacing = 10;

		Group radioGroup = new Group(parent,SWT.SHADOW_NONE);
		radioGroup.setText(encloseTextField ? "" : "Simple Types");
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
		
		if (encloseTextField) {
			Composite cr = new Composite(radioGroup, SWT.NONE);
			cr.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
					true, 2, 1));
			cr.setLayout(new GridLayout(2,false));
			serverLabel = new Label(cr, SWT.NONE);
			serverLabel.setLayoutData(
					new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
			);
			serverLabel.setText("Type");
							
			typeCombo = new Combo(cr, SWT.DROP_DOWN);
			typeCombo.setLayoutData(
					new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
			);
		}
		else
		{
			serverLabel = new Label(parent, SWT.NONE);
			serverLabel.setLayoutData(
					new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
			);
			serverLabel.setText("Type");
							
			typeCombo = new Combo(parent, SWT.DROP_DOWN);
			typeCombo.setLayoutData(
					new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
			);
		}

		

		builtInButton.setSelection(true);

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
		
    	for (Iterator iter = builtInTypes.iterator(); iter.hasNext(); ) {
			String name = (String) iter.next();
			typeCombo.add(name);
		}
    	typeCombo.select(0);
    	
    	container = parent;
	}
	
	public void addModifyListener(ModifyListener listener)
	{
		typeCombo.addModifyListener(listener);
	}
	
	public boolean isBuiltIn() {
		return builtInButton.getSelection();
	}
	
	public String getText()
	{
		return typeCombo.getText();
	}
	
	public void setFocus()
	{
		typeCombo.setFocus();
	}
	
	public Composite getComposite()
	{
		return container;
	}
	
	public void setSelectAllWidgets(boolean selected)
	{
		customButton.setEnabled(selected);
		builtInButton.setEnabled(selected);
		typeCombo.setEnabled(selected);
		serverLabel.setEnabled(selected);
	}
}
