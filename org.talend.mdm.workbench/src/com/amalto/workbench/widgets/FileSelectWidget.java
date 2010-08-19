package com.amalto.workbench.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

public class FileSelectWidget {
	FormToolkit factory=new WidgetFactory();
	
	Composite parent;

	private Text text;
	
	String[] fileExtents;
	String label;
	String filename;
	boolean isFile;
	private Button button;
	public FileSelectWidget(Composite parent,String label, String[] fileExtents,String filename,boolean isFile){
		this.label=label;
		this.filename=filename;
		this.fileExtents=fileExtents;
//		this.parent=factory.createComposite(parent,0);
		this.parent=parent;
		if(parent.getLayout() == null)
		{
			GridLayout layout=new GridLayout();
			layout.numColumns=3;
			this.parent.setLayout(layout);
		}

		this.isFile=isFile;
		create();
	}
	
	public Text getText() {
		return text;
	}

	private void create(){
		GridData gd=new GridData(SWT.LEFT,SWT.TOP,false,true,1,1);
		if(label.length()>0){
		Label label=factory.createLabel(parent, this.label);
		label.setText(this.label);
		label.setLayoutData(gd);
		}
		text=factory.createText(parent, "",SWT.SINGLE|SWT.BORDER);
		gd=new GridData(SWT.FILL,SWT.FILL,true,false,1,1);
/*		if(label.length()>0){
			gd=new GridData(SWT.FILL,SWT.FILL,true,true,1,1);
		}else{
			gd=new GridData(SWT.FILL,SWT.FILL,true,true,2,1);
		}*/
		text.setLayoutData(gd);
		text.setText(filename);		
		button=new Button(parent, SWT.PUSH);
		button.setText("");
		button.setImage(ImageCache.getCreatedImage(EImage.DOTS_BUTTON.getPath()));
		gd=new GridData(SWT.RIGHT,SWT.TOP,false,false,1,1);
		button.setLayoutData(gd);
		button.setToolTipText("Browse...");
		
		button.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void widgetSelected(SelectionEvent e) {
				if(isFile){
					FileDialog fileDialog = new FileDialog (parent.getShell(), SWT.OPEN);				
					fileDialog.setFilterExtensions (fileExtents);		
					fileDialog.setFileName(filename);
					String name=fileDialog.open();
					if(name!=null){
						text.setText(name);					
					}
				}else{
					DirectoryDialog d=new DirectoryDialog(parent.getShell());
					String name=d.open();
					if(name!=null)
						text.setText(name);
				}
			}			
		});
	}
	
	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public void setEnabled(boolean flag){
		text.setEnabled(flag);
		button.setEnabled(flag);
	}
	public void setFilename(String filename) {
		text.setText(filename);
	}
	
	public Composite getCmp(){
		return this.parent;
	}
}
