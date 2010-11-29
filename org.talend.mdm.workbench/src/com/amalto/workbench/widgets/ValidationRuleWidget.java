package com.amalto.workbench.widgets;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.dialogs.ValidationRuleExcpressDialog;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

public class ValidationRuleWidget {
	Composite parent;
	FormToolkit toolkit=WidgetFactory.getWidgetFactory();
	private Composite composite;
	private Button button;
	private Text text;
	ValidationRuleExcpressDialog dlg;
	String conceptName;
	private GridData textGD;
	TableColumn column;
	public ValidationRuleWidget(Composite parent,String conceptName){
		this.parent=parent;
		this.conceptName=conceptName;
		create();
	}
	private void create(){
		composite = toolkit.createComposite(parent,SWT.NO_FOCUS);
		//composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true, 1, 1));
		GridLayout layout=new GridLayout(2, false);
		layout.marginWidth=0;
		layout.marginLeft=0;
		layout.marginTop=0;
		layout.marginHeight=0;
		layout.marginBottom=0;
		composite.setLayout(layout);
		
		text = toolkit.createText(composite, "", SWT.BORDER| SWT.MULTI|SWT.LEFT);		
		textGD=new GridData(SWT.FILL, SWT.FILL, true,true, 1, 1);
		text.setLayoutData(textGD);
		button = toolkit.createButton(composite, "",SWT.PUSH);
		button.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,false, false, 1, 1));
		
		button.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell(composite.getDisplay(),SWT.BORDER);
				dlg=new ValidationRuleExcpressDialog(shell,"Build Validation Rule Expression ", text.getText(),conceptName);
	       		dlg.create();
	       		dlg.getShell().setMaximized(false);
	       		//dlg.getShell().setSize(new Point(640,560));	       		
	       		dlg.setBlockOnOpen(true);
	       		int ret = dlg.open();
	       		if (ret == Window.OK) {
	                text.setText(dlg.getExpression());
	       		}
			}
		});
		button.setImage(ImageCache.getCreatedImage(EImage.DOTS_BUTTON.getPath()));
		button.setToolTipText("Build Validation Rule Expression");					
	}
	
	public Composite getComposite(){
		return composite;
	}
	public Text getTextWidget(){
		return text;
	}
	public String getText(){
		return text.getText();
	}
	public void setText(String txt){
		text.setText(txt);
	}
	public TableColumn getColumn() {
		return column;
	}
	public void setColumn(TableColumn column) {
		this.column = column;
		resetWidth();
	}
	
	public void resetWidth(){
		if(column!=null){
			textGD.widthHint=column.getWidth()-35;
		}
	}
}
