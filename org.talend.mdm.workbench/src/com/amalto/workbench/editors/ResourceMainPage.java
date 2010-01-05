package com.amalto.workbench.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.ResourcesUtil;
import com.sun.security.auth.Resources;

public class ResourceMainPage extends AMainPageV2 {
//	private static final String LOCAL_MDM_URL = "http://localhost:8080/pubcomponent/secure/dataModels/";
	private String name;
	private Browser browser;
	FormEditor editor;
	private Text text;
	public ResourceMainPage(FormEditor editor) {
        super(
        		editor,
        		ResourceMainPage.class.getName(),
        		((XObjectEditorInput)editor.getEditorInput()).getName());
        this.editor=editor;
	}

	@Override
	protected void createCharacteristicsContent(FormToolkit toolkit,
			Composite charSection) {
//		charSection.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));
		charSection.setLayout(new GridLayout(1,true));
		text=toolkit.createText(charSection, "");
		browser = new Browser(charSection, SWT.NONE);
		browser.setSize(100, 650);
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
		refreshData();
	}


	protected void commit() {

	}


	protected void createActions() {

	}


	protected void refreshData() {
        TreeObject xobject = (TreeObject)((XObjectEditorInput)editor.getEditorInput()).getModel();
        name=xobject.getEndpointIpAddress();
//        name="http://localhost:8080";
        switch(xobject.getType()) {
        case TreeObject.PICTURES_RESOURCE:
        	name += ResourcesUtil.getResourcesMapFromURI(
        			xobject.getEndpointIpAddress() + TreeObject.PICTURES_URI)
        			.get(((XObjectEditorInput) editor.getEditorInput())
        					.getName());
        	break;
        case TreeObject.DATA_MODEL_RESOURCE:
        	name+=TreeObject.DATAMODEL_URI;
        	break;
        case TreeObject.DATA_MODEL_TYPES_RESOURCE:
        	name+=TreeObject.DATAMODELTYPES_URI;
        	break;
        case TreeObject.CUSTOM_TYPES_RESOURCE:
        	name+=TreeObject.CUSTOM_TYPES_URI;
        	break;
        }
        if(xobject.getType()!=TreeObject.PICTURES_RESOURCE)
        	name+=((XObjectEditorInput)editor.getEditorInput()).getName();
		text.setText(name);
		browser.setUrl(name);
	}

}
