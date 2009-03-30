/*
 * Created on 27 oct. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.amalto.workbench.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.webservices.WSDestination;

public class DestinationMainPage extends AMainPage {

	private Text nameText;
	private Text descriptionText;
	
	
    public DestinationMainPage(FormEditor editor) {
        super(
        		editor,
        		DestinationMainPage.class.getName(),
        		"Destination "+((XObjectEditorInput)editor.getEditorInput()).getName()
        );        
    }

	protected void createCharacteristicsContent(FormToolkit toolkit, Composite charComposite) {

        try {
        	
        	WSDestination wsDestination = (WSDestination) (getXObject().getWsObject());
          
            Label nameLabel = toolkit.createLabel(charComposite, "Name", SWT.NULL);
            nameLabel.setLayoutData(
                    new GridData(SWT.BEGINNING,SWT.FILL,false,false,1,1)
            );

            //name
            nameText = toolkit.createText(charComposite, "",SWT.BORDER);
            nameText.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            nameText.setText(wsDestination.getName());
            nameText.addModifyListener(this);

            //description
            Label descriptionLabel = toolkit.createLabel(charComposite, "Description", SWT.NULL);
            descriptionLabel.setLayoutData(
            		new GridData(SWT.BEGINNING,SWT.FILL,false,false,1,1)
            );
            
            descriptionText = toolkit.createText(charComposite, "",SWT.BORDER);
            descriptionText.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            descriptionText.setText(wsDestination.getDescription()==null ? "" : wsDestination.getDescription());
            descriptionText.addModifyListener(this);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//createCharacteristicsContent


	protected void refreshData() {
    	WSDestination wsDestination = (WSDestination) (getXObject().getWsObject());    	
    	String s;
    	
    	s = wsDestination.getName()==null ? "" : wsDestination.getName();
    	if (!s.equals(nameText.getText())) nameText.setText(s);
    	
    	s = wsDestination.getDescription()==null ? "" : wsDestination.getDescription();
    	if (!s.equals(descriptionText.getText())) descriptionText.setText(s);
	}
	
	protected void commit() {
    	WSDestination wsDestination = (WSDestination) (getXObject().getWsObject());
		wsDestination.setName(nameText.getText());
		wsDestination.setDescription(descriptionText.getText());
	}

	//no specific actions here
	public void createActions() {
		return;
	}
		
        

}
