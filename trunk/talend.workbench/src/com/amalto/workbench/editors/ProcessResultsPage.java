/*
 * Created on 27 oct. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.amalto.workbench.editors;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.webservices.WSExtractedContent;

public class ProcessResultsPage extends AMainPageV2 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	protected Combo variablesCombo;
	protected SourceViewer variablesViewer;
	protected TreeMap<String, WSExtractedContent> variablesMap;
	
	private boolean refreshing = false;
	private boolean comitting = false;
	
    public ProcessResultsPage(FormEditor editor, TreeMap<String, WSExtractedContent> map) {
        super(
        		editor,
        		ProcessResultsPage.class.getName()+"-"+sdf.format(new Date(System.currentTimeMillis())),
        		"Results "+sdf.format(new Date(System.currentTimeMillis()))
        );
    	variablesMap = map;
    }


	@Override
	protected void createCharacteristicsContent(FormToolkit toolkit, Composite charSection) {
		try {
			
			((GridLayout)charSection.getLayout()).numColumns = 3;
			
			Label variableLabel = toolkit.createLabel(charSection,"Pipeline Variables");
            variableLabel.setLayoutData(
            		new GridData(SWT.LEFT,SWT.CENTER,true,true,1,1)
            );

			variablesCombo = new Combo(charSection, SWT.DROP_DOWN | SWT.READ_ONLY);
            variablesCombo.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,true,true,1,1)
            );
            variablesCombo.addModifyListener(new ModifyListener() {
            	public void modifyText(ModifyEvent e) {
            		ProcessResultsPage.this.variablesViewer.setDocument(new Document(getText(variablesCombo.getText())));
            	}
            });
            /*
            variablesCombo.addKeyListener(
            		new KeyListener() {
            			public void keyPressed(KeyEvent e) {}
            			public void keyReleased(KeyEvent e) {
        					if ((e.stateMask==0) && (e.character == SWT.CR)) {
        						ProcessResultsPage.this.variablesViewer.setDocument(new Document(getText(variablesCombo.getText())));
        					}
            			}//keyReleased
            		}//keyListener
            );
            */
            
            Button closeButton = new Button(charSection,SWT.PUSH);
            closeButton.setText("Close");
            closeButton.addListener(SWT.Selection, new Listener() {
                public void handleEvent(Event event) {
                	ProcessResultsPage.this.getEditor().removePage(ProcessResultsPage.this.getIndex());
            	};
            });    

			
	        variablesViewer = new SourceViewer(
	        		charSection , 
	        		new VerticalRuler(10), SWT.V_SCROLL | SWT.H_SCROLL
	        );
            variablesViewer.getControl().setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,true,true,3,1)
            );
            ((GridData)variablesViewer.getControl().getLayoutData()).minimumHeight = 500;

            variablesCombo.setFocus();
            
	        refreshData();

		} catch (Exception e) {
            e.printStackTrace();
        }

	}


	protected void refreshData() {
		try {
			
			if (this.comitting) return;
            
            if (! this.equals(getEditor().getActivePageInstance())) return;
			
			this.refreshing = true;
            Set< String> outputs = variablesMap.keySet();
            for (Iterator iter = outputs.iterator(); iter.hasNext(); ) {
				String output = (String) iter.next();
				variablesCombo.add(output);
			}
            variablesCombo.select(0);
			
            variablesViewer.setDocument(new Document(getText(variablesCombo.getText())));
            
            this.refreshing = false;
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error refreshing the page", "Error refreshing the page: "+e.getLocalizedMessage());
		}    	
	}
	
	protected void commit() {
		try {
			
			if (this.refreshing) return;
			
			this.comitting = true;
			//Nothing to commit
			this.comitting = false;
			
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error comitting the page", "Error comitting the page: "+e.getLocalizedMessage());
		}    	
	}
		
	protected void createActions() {
	}


	public void textChanged(TextEvent event) {
		if (this.refreshing) return;
		markDirty();
        commitChanges();
	}

	/*
	private void hookContextMenu(TreeViewer viewer) {
	}

	private void fillContextMenu(IMenuManager manager) {
	}
	*/
	
	public void dispose() {
		super.dispose();
	}
	

	private static Pattern p=Pattern.compile(".*charset\\s*=[\"|']?(.+)[\"|']([\\s|;].*)?");
	protected String getText(String output) {
		String contentType = variablesMap.get(output).getContentType();
		if (contentType.startsWith("text")) {
			//extract charset
			String charset="UTF8";
			Matcher m = p.matcher(contentType);
			if (m.matches()) {
				charset = m.group(1).trim().toUpperCase();
			}
			if ("UTF-8".equals(charset)) charset = "UTF8";
			try {
				return
					new String(
							variablesMap.get(variablesCombo.getText()).getWsByteArray().getBytes(),
							charset
					);
			} catch (Exception ex){
				StringWriter sw = new StringWriter();
				ex.printStackTrace(new PrintWriter(sw));
				return "ERROR - displaying the output\n"+sw.toString();
			}
		}
		return "ERROR - The content with type '"+contentType+"' cannot be displayed";
	}
}
