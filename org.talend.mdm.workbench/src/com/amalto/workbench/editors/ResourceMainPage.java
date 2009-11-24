package com.amalto.workbench.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectEditorInput;

public class ResourceMainPage extends AMainPageV2 {
//	private static final String LOCAL_MDM_URL = "http://localhost:8080/pubcomponent/secure/dataModels/";
	private String name;
	public ResourceMainPage(FormEditor editor) {
        super(
        		editor,
        		ResourceMainPage.class.getName(),
        		((XObjectEditorInput)editor.getEditorInput()).getName());
        TreeObject xobject = (TreeObject)((XObjectEditorInput)editor.getEditorInput()).getModel();
        name=xobject.getEndpointIpAddress();
//        name="http://localhost:8080";
        switch(xobject.getType()) {
        case TreeObject.DATA_MODEL_RESOURCE:
        	name+=TreeObject.DATAMODEL_URI;
        	break;
        case TreeObject.DATA_MODEL_TYPES_RESOURCE:
        	name+=TreeObject.DATAMODELTYPES_URI;
        	break;
        case TreeObject.CUSTOM_TYPES_RESOURCE:
        	name+=TreeObject.CUSTOM_TYPES_URI;
        	break;
        case TreeObject.PICTURES_RESOURCE:
        	name+=TreeObject.PICTURES_URI;
        	break;
        }
        name+=((XObjectEditorInput)editor.getEditorInput()).getName();
	}

	@Override
	protected void createCharacteristicsContent(FormToolkit toolkit,
			Composite charSection) {
//		charSection.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));
		charSection.setLayout(new GridLayout(1,true));
		final Text text=toolkit.createText(charSection, "");
		final Browser browser = new Browser(charSection, SWT.NONE);
		browser.setSize(100, 650);
		text.setText(name);
		browser.setUrl(name);
		text.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,true,1,1));
 		browser.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));
		text.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				
			}

			public void keyReleased(KeyEvent e) {
				if(e.keyCode==13){
					browser.setUrl(text.getText());
				}				
			}
 			
 		});
	}

	@Override
	protected void commit() {

	}

	@Override
	protected void createActions() {

	}

	@Override
	protected void refreshData() {

	}

}
