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
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.dialogs.XpathSelectDialog;
import com.amalto.workbench.editors.AMainPageV2;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
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

    private boolean readOnly=false;
    private Composite parent;
    private IWorkbenchPartSite site;
    private String dataModelName;

    boolean isMulti=true;
    
    private String conceptName;
    
    
	public String getConceptName() {
		return conceptName;
	}

	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
		if(dlg!=null)dlg.setConceptName(conceptName);
	}

	public String getDataModelName() {
		return dataModelName;
	}

	public void setDataModelName(String dataModelName) {
		this.dataModelName = dataModelName;
	}
	public XpathWidget(Composite parent,AMainPageV2 page, boolean isMulti){		
		this("",page.getXObject().getParent(),null,parent,page,false,false,"");
		this.isMulti=isMulti;
	}
	public XpathWidget(String buttonName,TreeParent treeParent,
			FormToolkit toolkit, Composite parent, AMainPageV2 dialog,boolean isButtonLeft,boolean readOnly, String dataModelName) {

		this.parent = parent;
		this.treeParent = treeParent;
		if(toolkit==null)
			toolkit = new FormToolkit(parent.getDisplay());
		
		xpathAntionHolder = toolkit.createComposite(parent,SWT.NO_FOCUS);
		xpathAntionHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true, 1, 1));
		GridLayout layout=new GridLayout(2, false);
		layout.marginWidth=0;
		layout.marginLeft=0;
		layout.marginTop=0;
		layout.marginHeight=0;
		layout.marginBottom=0;
		xpathAntionHolder.setLayout(layout);


		dlgTitle = "Select Xpath";
		accommodation = dialog;
		ModifyListener listenr=new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (descriptionValue != null
						&& !descriptionValue.equals(descriptionText.getText())) {
					//accommodation.markDirty();
					accommodation.markDirtyWithoutCommit();
				}
				descriptionValue = descriptionText.getText();
			}
		};
		if(isButtonLeft){
			annotationButton = toolkit.createButton(xpathAntionHolder, "",SWT.PUSH);
			annotationButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,false, false, 1, 1));
			annotationButton.addSelectionListener(this);			
			if(readOnly){
				descriptionText = toolkit.createText(xpathAntionHolder, "", SWT.BORDER| SWT.MULTI|SWT.LEFT|SWT.READ_ONLY);
			}else{
				descriptionText = toolkit.createText(xpathAntionHolder, "", SWT.BORDER| SWT.MULTI|SWT.LEFT);
			}
			descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true, 1, 1));
			descriptionText.addModifyListener(listenr);
			

		}
		else{
			if(readOnly){
				descriptionText = toolkit.createText(xpathAntionHolder, "", SWT.BORDER| SWT.MULTI|SWT.LEFT|SWT.READ_ONLY);
			}else{
				descriptionText = toolkit.createText(xpathAntionHolder, "", SWT.BORDER| SWT.MULTI|SWT.LEFT);
			}
			descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true, 1, 1));
			descriptionText.addModifyListener(listenr);			
			annotationButton = toolkit.createButton(xpathAntionHolder, buttonName,SWT.PUSH);
			annotationButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,false, false, 1, 1));
			annotationButton.addSelectionListener(this);
		}
		annotationButton.setImage(ImageCache.getCreatedImage(EImage.DOTS_BUTTON.getPath()));
		annotationButton.setToolTipText("Select Xpath");

	}
	
	
	XpathSelectDialog dlg;
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		if(accommodation!=null){
			if(dlg==null){
				dlg = new XpathSelectDialog(
						accommodation.getSite().getShell(),
						treeParent,dlgTitle,
						accommodation.getSite(),
						isMulti,
						dataModelName
						
				);
				dlg.setConceptName(conceptName);
			}
		}
		else{
			if(dlg==null){
				dlg = new XpathSelectDialog(
						parent.getShell(),
						treeParent,dlgTitle,
						site,
						false,
						dataModelName
				);
				dlg.setConceptName(conceptName);
			}
		}
	
        dlg.setBlockOnOpen(true);
		dlg.open();
		
		if (dlg.getReturnCode() == Window.OK)  {
			descriptionText.setText(dlg.getXpath());
			dataModelName = dlg.getDataModelName();
			dlg.close();
			setOutFocus();
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

	public boolean isReadOnly() {
		return readOnly;
	}
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	public Text getTextWidget(){
		return descriptionText;
	}

	public void setOutFocus(){
		descriptionText.setFocus();
		descriptionText.setText(descriptionText.getText().trim());
		int start = descriptionText.getText().length();
		//int end = descriptionText.getSelection().y;
		descriptionText.setSelection(start);
		
	}
	
}
