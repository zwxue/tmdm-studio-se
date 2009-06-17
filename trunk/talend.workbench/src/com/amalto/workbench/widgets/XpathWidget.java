package com.amalto.workbench.widgets;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.dialogs.XpathSelectDialog;
import com.amalto.workbench.editors.AMainPageV2;
import com.amalto.workbench.models.TreeParent;

public class XpathWidget implements  SelectionListener{
	
	private Composite xpathAntionHolder;
	private Button annotationButton;
	private Text descriptionText;
	private String descriptionValue;
	private AMainPageV2 accommodation;
    private String dlgTitle;
    protected TreeParent treeParent;
    protected XpathSelectDialog xpathSelectDialog;
    private boolean isButtonLeft;

	public XpathWidget(String buttonName,TreeParent treeParent,
			FormToolkit toolkit, Composite parent, AMainPageV2 dialog,boolean isButtonLeft) {
		this.treeParent = treeParent;
		xpathAntionHolder = toolkit.createComposite(parent);
		xpathAntionHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true, 1, 1));
		xpathAntionHolder.setLayout(new GridLayout(2, false));
		this.isButtonLeft = isButtonLeft;

		dlgTitle = "Select Xpath ...";
		accommodation = dialog;
		ModifyListener listenr=new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (descriptionValue != null
						&& !descriptionValue.equals(descriptionText.getText())) {
					accommodation.markDirty();
				}
				descriptionValue = descriptionText.getText();
			}
		};
		if(isButtonLeft){
			annotationButton = toolkit.createButton(xpathAntionHolder, buttonName,SWT.PUSH);
			annotationButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,false, false, 1, 1));
			annotationButton.addSelectionListener(this);
			descriptionText = toolkit.createText(xpathAntionHolder, "", SWT.BORDER| SWT.MULTI|SWT.LEFT);
			descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true, 1, 1));
			descriptionText.addModifyListener(listenr);

		}
		else{
			descriptionText = toolkit.createText(xpathAntionHolder, "", SWT.BORDER| SWT.MULTI|SWT.LEFT);
			descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true, 1, 1));
			descriptionText.addModifyListener(listenr);			
			annotationButton = toolkit.createButton(xpathAntionHolder, buttonName,SWT.PUSH);
			annotationButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,false, false, 1, 1));
			annotationButton.addSelectionListener(this);
		}
		annotationButton.setToolTipText("Select one xpath");
	}
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		XpathSelectDialog dlg = new XpathSelectDialog(
				accommodation.getSite().getShell(),
				treeParent,dlgTitle,
				accommodation.getSite(),
				true
				
		);
        dlg.setBlockOnOpen(true);
		dlg.open();
		
		if (dlg.getReturnCode() == Window.OK)  {
			descriptionText.setText(dlg.getXpath());
			dlg.close();
		}
	}
	public Composite getComposite()
	{
		return xpathAntionHolder;
	}
	public String getText(){
		return descriptionText.getText();
	}
	public void setText(String text){
		descriptionText.setText(text);
	}	
}
