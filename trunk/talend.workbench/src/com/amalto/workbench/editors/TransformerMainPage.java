/*
 * Created on 27 oct. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.amalto.workbench.editors;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.AbstractFormPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.actions.ProcessFileThruTransformerAction;
import com.amalto.workbench.dialogs.PluginDetailsDialog;
import com.amalto.workbench.dialogs.ProcessFileDialog;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.Version;
import com.amalto.workbench.webservices.WSGetTransformerPluginDetails;
import com.amalto.workbench.webservices.WSGetTransformerPluginsList;
import com.amalto.workbench.webservices.WSTransformer;
import com.amalto.workbench.webservices.WSTransformerPluginDetails;
import com.amalto.workbench.webservices.WSTransformerPluginSpec;
import com.amalto.workbench.webservices.WSTransformerPluginsList;
import com.amalto.workbench.webservices.WSTransformerPluginsListItem;
import com.amalto.workbench.webservices.XtentisPort;

public class TransformerMainPage extends AMainPageV2 {

	public final static String DEFAULT_VAR = "_DEFAULT_";
	public final static String DEFAULT_DISPLAY = "{}";
	
	protected Text descriptionText;
	
	protected Text inputText;
	protected Text stepText;
	protected Text outputText;
	protected List stepsList;
	
	protected Label stepLabel;
	protected Text jndiText;
	protected Combo pluginsCombo;
	protected Label pluginDescription;
	protected TextViewer parametersTextViewer;
	protected ProcessFileDialog processFileDialog;

	protected DropTarget windowTarget;	
	
	protected AbstractFormPart topPart;
	
	protected boolean refreshing = false;
	protected boolean comitting = false;
	
	protected String filePath;
	
	protected int currentPlugin = -1; 
	
	protected boolean version_greater_2_16_0 = false;
	protected boolean version_greater_2_17_0 =false;
	
	protected TreeMap<String, String> pluginDescriptions = new TreeMap<String, String>();
		
    public TransformerMainPage(FormEditor editor) {
        super(
        		editor,
        		TransformerMainPage.class.getName(),
        		"Transformer "+((XObjectEditorInput)editor.getEditorInput()).getName()
        );
        //get Version information
        try {
        	Version ver = Util.getVersion(getXObject());
        	version_greater_2_16_0 = (
        			(ver.getMajor()>2) ||
        			((ver.getMajor()==2)&&(ver.getMinor()>=16))
        	);
        	version_greater_2_17_0 = (
        			(ver.getMajor()>2) ||
        			((ver.getMajor()==2)&&(ver.getMinor()>=17))
        	);
        } catch (Exception e) {/*no versioning support on old cores*/}
    }

    @Override
	protected void createCharacteristicsContent(FormToolkit toolkit, Composite topComposite) {
    	try {
    		
            //Description and File Process
            Composite descriptionComposite = toolkit.createComposite(topComposite,SWT.NONE);
            descriptionComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            descriptionComposite.setLayout(
            	new GridLayout(
            		version_greater_2_16_0 ? 3 : 2,
            		false
            	));
    		
            //description
            Label descriptionLabel = toolkit.createLabel(descriptionComposite, "Description", SWT.NULL);
            descriptionLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
            );
            descriptionText = toolkit.createText(descriptionComposite, "",SWT.BORDER|SWT.MULTI);
            descriptionText.setLayoutData(    
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            ((GridData)descriptionText.getLayoutData()).minimumHeight = 30;
            descriptionText.addModifyListener(new ModifyListener() {
            	public void modifyText(ModifyEvent e) {
            		if (refreshing) return;
            		//commit as we go
            		TransformerMainPage.this.comitting= true;
            		((WSTransformer)getXObject().getWsObject()).setDescription(descriptionText.getText());
            		TransformerMainPage.this.comitting= false;
            		markDirty();
            	}
            });
            
            if (version_greater_2_16_0) {
	            //File Process
	            Button processButton = toolkit.createButton(descriptionComposite,"Process a File...",SWT.PUSH | SWT.TRAIL);
	            processButton.setLayoutData(
	                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
	            );
	            processButton.addSelectionListener(new SelectionListener() {
	            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
	            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
	            		try {
	            			//check if we have a step to perfom
	            			WSTransformerPluginSpec[] steps = ((WSTransformer)getXObject().getWsObject()).getPluginSpecs();
	            			if ((steps==null) || (steps.length == 0)) {
	            				MessageDialog.openError(TransformerMainPage.this.getSite().getShell(), "Unable to process a file", "The transformer must have at least one step!");
	            				return;
	            			}
	            			//perform save
	            			if (TransformerMainPage.this.getEditor().isDirty()) {
	            				if (MessageDialog.openConfirm(TransformerMainPage.this.getSite().getShell(), "Executing the Transformer", "The Transformer was changed and will be executed using the saved version.\nSave the transformer before executing it?"))
	            					TransformerMainPage.this.getEditor().doSave(new NullProgressMonitor());
	            			}
	            			//Open form Dialog
	    					FileDialog fd = new FileDialog(TransformerMainPage.this.getSite().getShell(),SWT.OPEN);
	    					fd.setText("Select document to upload");
	    					/*
	    					fd.setFilterExtensions(new String[] {"*.*"});
	    					fd.setFilterExtensions(new String[] {"All Files"});
	    					*/
	    					fd.setFilterExtensions(new String[] {"*.*","*.txt","*.xml"});
	    					if (filePath != null) 
	    						fd.setFilterPath(filePath+"/xxxyyyyzzzz");
	    					else
	    						fd.setFilterPath(System.getProperty("user.home")+"/xxxxxyyyyzzzz");
	    					fd.open();
	    					if ("".equals(fd.getFileName())) return;
	    					filePath = fd.getFilterPath();
	    					String filename =  fd.getFilterPath()+System.getProperty("file.separator")+fd.getFileName();
	    					processFileDialog = new ProcessFileDialog(
    							getXObject(),
    							filename,
    							TransformerMainPage.this.getSite().getShell(),
    							"Process using Transformer "+((WSTransformer)getXObject().getWsObject()).getName(),
    							new SelectionListener() {
    								public void 
    								widgetDefaultSelected(SelectionEvent e) {}
    								public void widgetSelected(SelectionEvent e) {
    									LinkedHashMap<String,String> variablesMap = processFileDialog.getVariablesMap();
    									String filename = processFileDialog.getFilename();
    									String encoding = processFileDialog.getEncoding();
    									String mimeType = processFileDialog.getMimeType();
    									processFileDialog.close();
    									if (processFileDialog.getReturnCode() == Window.OK) {
    										(new ProcessFileThruTransformerAction(
    												(XObjectEditor)TransformerMainPage.this.getEditor(),
    												variablesMap,
    												filename,
    												mimeType,
    												encoding
    										)).run();
    										
    									}
    								}
    							}
	    					);
	    					processFileDialog.setBlockOnOpen(true);
	    					processFileDialog.open();	    					
	            		} catch (Exception ex) {
	            			ex.printStackTrace();
	            		}
	            	};
	            });
            }            
            
            //make the Page window a DropTarget - we need to dispose it
            windowTarget = new DropTarget(this.getPartControl(), DND.DROP_MOVE);
            windowTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            windowTarget.addDropListener(new DCDropTargetListener());
            
            //Sequence
            Composite sequenceGroup = this.getNewSectionComposite("Steps Sequence");
            sequenceGroup.setLayout(new GridLayout(1,false));

            Composite sequenceComposite = toolkit.createComposite(sequenceGroup,SWT.NONE);
            sequenceComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            sequenceComposite.setLayout(new GridLayout(6,false));
            
            //Labels line of sequence
            Label l1 = toolkit.createLabel(sequenceComposite, "Input Variable", SWT.NULL);
            l1.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,true,1,1));
            Label l2 = toolkit.createLabel(sequenceComposite, "", SWT.NULL);
            l2.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,true,1,1));
            Label l3 = toolkit.createLabel(sequenceComposite, "Step Description", SWT.NULL);
            l3.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,true,1,1));
            Label l4 = toolkit.createLabel(sequenceComposite, "", SWT.NULL);
            l4.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,true,1,1));
            Label l5 = toolkit.createLabel(sequenceComposite, "Output Variable", SWT.NULL);
            l5.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,true,1,1));
            Label l6 = toolkit.createLabel(sequenceComposite, "", SWT.NULL);
            l6.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,true,1,1));
            
            //inputs line
            inputText = toolkit.createText(sequenceComposite, "",SWT.BORDER|SWT.SINGLE);
            inputText.setLayoutData(    
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            Label l7 = toolkit.createLabel(sequenceComposite, "---->", SWT.NULL);
            l7.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,true,1,1));           
            stepText = toolkit.createText(sequenceComposite, "",SWT.BORDER|SWT.SINGLE);
            stepText.setLayoutData(    
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            stepText.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					/*
					if ((e.stateMask==0) && (e.character == SWT.CR)) {
		           		TransformerMainPage.this.stepsList.add(
		           				TransformerMainPage.this.inputText.getText()+
		           				"---->["+
		           				TransformerMainPage.this.stepText.getText()+
		           				"]---->"+
		           				TransformerMainPage.this.outputText.getText()
		           		);
	            		//commit as we go
	            		TransformerMainPage.this.comitting= true;
	            		WSTransformer wsTransformer = (WSTransformer)getXObject().getWsObject(); 
	            		ArrayList<WSTransformerPluginSpec> list = new ArrayList<WSTransformerPluginSpec>(
	            				Arrays.asList(wsTransformer.getPluginSpecs())
	            		);
	            		list.add(new WSTransformerPluginSpec("",stepText.getText(),inputText.getText(),outputText.getText(),""));
	            		wsTransformer.setPluginSpecs(list.toArray(new WSTransformerPluginSpec[list.size()]));
	            		TransformerMainPage.this.comitting= false;
	            		markDirty();
					}
					*/
				}
            });
            Label l8 = toolkit.createLabel(sequenceComposite, "---->", SWT.NULL);
            l8.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,true,1,1));  
            outputText = toolkit.createText(sequenceComposite, "",SWT.BORDER|SWT.SINGLE);
            outputText.setLayoutData(    
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
         
            Button addStepButton = toolkit.createButton(sequenceComposite,"Add",SWT.PUSH | SWT.TRAIL);
            addStepButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            addStepButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		//commit as we go
            		try {
		            		TransformerMainPage.this.comitting= true;
		            		String input = TransformerMainPage.this.inputText.getText().trim();
		            		if ("".equals(input)) input = TransformerMainPage.DEFAULT_DISPLAY;
		            		String output = TransformerMainPage.this.outputText.getText().trim();
		            		if ("".equals(output)) output = TransformerMainPage.DEFAULT_DISPLAY;
			           		TransformerMainPage.this.stepsList.add(
			           				input+
			           				"---->["+
			           				TransformerMainPage.this.stepText.getText()+
			           				"]---->"+
			           				output
			           		);
		            		WSTransformer wsTransformer = (WSTransformer)getXObject().getWsObject();
		            		ArrayList<WSTransformerPluginSpec> list = new ArrayList<WSTransformerPluginSpec>();
		            		if (wsTransformer.getPluginSpecs() != null) { 
			            		list = new ArrayList<WSTransformerPluginSpec>(
			            				Arrays.asList(wsTransformer.getPluginSpecs())
			            		);
		            		}
		            		list.add(new WSTransformerPluginSpec(
		            				"",
		            				TransformerMainPage.this.stepText.getText(),
		            				TransformerMainPage.DEFAULT_DISPLAY.equals(input) ? null : input,
		            				TransformerMainPage.DEFAULT_DISPLAY.equals(output) ? null : output,
		            				""
		            		));
		            		wsTransformer.setPluginSpecs(list.toArray(new WSTransformerPluginSpec[list.size()]));
		            		TransformerMainPage.this.comitting= false;
		            		int index = TransformerMainPage.this.stepsList.getItemCount()-1;
		        			TransformerMainPage.this.stepsList.select(index);
		        			refreshStep(index);
		        			TransformerMainPage.this.stepsList.forceFocus();
		            		markDirty();
            		} catch (Exception ex) {
            			ex.printStackTrace();
            		}
            	};
            });
            
            stepsList = new List(sequenceComposite,SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
            stepsList.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,5,1)
            );
            ((GridData)stepsList.getLayoutData()).heightHint = 100;
            DragSource stepsSource = new DragSource(stepsList,DND.DROP_MOVE);
            stepsSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            stepsSource.addDragListener(new DCDragSourceListener());
            
            stepsList.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(SelectionEvent e) {widgetSelected(e);}
            	public void widgetSelected(SelectionEvent e) {
            		int index = stepsList.getSelectionIndex();
            		currentPlugin = index;
            		if (index>=0) {
            			refreshStep(index);
            		}
            	}
            });
            stepsList.addMouseListener(new MouseListener() {
            	public void mouseDoubleClick(MouseEvent e) {
            		int index = stepsList.getSelectionIndex();
            		currentPlugin = index;
            		removeStep(index);
            	}
            	public void mouseUp(MouseEvent e) {}
            	public void mouseDown(MouseEvent e) {
            		/*
            		int index = stepsList.getSelectionIndex();
            		currentPlugin = index;
            		if (index>=0) {
            			refreshStep(index);
            		}
            		*/
            	}
            });

            
            stepsList.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					if ((e.stateMask==0) && (e.character == SWT.DEL) && (TransformerMainPage.this.stepsList.getSelectionIndex()>=0)) {
						int index = TransformerMainPage.this.stepsList.getSelectionIndex();
						removeStep(index);
					}
				}
            });

            
            Composite stepUpDownComposite = toolkit.createComposite(sequenceComposite,SWT.NONE);
            stepUpDownComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            stepUpDownComposite.setLayout(new GridLayout(1,false));
            
            Button stepUpButton = toolkit.createButton(stepUpDownComposite,"Up",SWT.PUSH | SWT.CENTER);
            stepUpButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            stepUpButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		int index =TransformerMainPage.this.stepsList.getSelectionIndex();
            		if (index>0) {
						//commit as we go
						TransformerMainPage.this.comitting= true;
            			String val = TransformerMainPage.this.stepsList.getItem(index);
            			TransformerMainPage.this.stepsList.remove(index);
            			TransformerMainPage.this.stepsList.add(val, index-1);
            			TransformerMainPage.this.stepsList.select(index-1);
            			TransformerMainPage.this.stepsList.forceFocus();
	            		WSTransformer wsTransformer = (WSTransformer)getXObject().getWsObject(); 
	            		ArrayList<WSTransformerPluginSpec> list = new ArrayList<WSTransformerPluginSpec>(
	            				Arrays.asList(wsTransformer.getPluginSpecs())
	            		);
	            		WSTransformerPluginSpec spec = list.get(index);
	            		list.remove(index);
	            		list.add(index-1, spec);
	            		wsTransformer.setPluginSpecs(list.toArray(new WSTransformerPluginSpec[list.size()]));
	            		TransformerMainPage.this.comitting= false;
	            		markDirty();
            		}
            	};
            });
            Button stepDownButton = toolkit.createButton(stepUpDownComposite,"Down",SWT.PUSH | SWT.CENTER);
            stepDownButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            stepDownButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		int index =TransformerMainPage.this.stepsList.getSelectionIndex();
            		if ((index>=0) && (index < TransformerMainPage.this.stepsList.getItemCount()-1)) {
						//commit as we go
						TransformerMainPage.this.comitting= true;
            			String val = TransformerMainPage.this.stepsList.getItem(index);
            			TransformerMainPage.this.stepsList.remove(index);
            			TransformerMainPage.this.stepsList.add(val, index+1);
            			TransformerMainPage.this.stepsList.select(index+1);
            			TransformerMainPage.this.stepsList.forceFocus();
	            		WSTransformer wsTransformer = (WSTransformer)getXObject().getWsObject(); 
	            		ArrayList<WSTransformerPluginSpec> list = new ArrayList<WSTransformerPluginSpec>(
	            				Arrays.asList(wsTransformer.getPluginSpecs())
	            		);
	            		WSTransformerPluginSpec spec = list.get(index);
	            		list.remove(index);
	            		list.add(index+1, spec);
	            		wsTransformer.setPluginSpecs(list.toArray(new WSTransformerPluginSpec[list.size()]));
	            		TransformerMainPage.this.comitting= false;
	            		markDirty();
            		}
            	};
            });
            Button deleteStepButton = toolkit.createButton(stepUpDownComposite,"Delete",SWT.PUSH | SWT.CENTER);
            deleteStepButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            deleteStepButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		int index =TransformerMainPage.this.stepsList.getSelectionIndex();
            		if ((index>=0) && (index < TransformerMainPage.this.stepsList.getItemCount())) {
                		removeStep(index);
            		}
            	};
            });
    
            //Plugin Specifications
            //Sequence
            Composite specsGroup = this.getNewSectionComposite("Step Specification");
            sequenceGroup.setLayout(new GridLayout(4,false));
            
            Composite specsComposite = toolkit.createComposite(specsGroup,SWT.NONE);
            specsComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            specsComposite.setLayout(new GridLayout(4,false));

            stepLabel = toolkit.createLabel(specsComposite, "", SWT.NULL);
            stepLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,false,true,4,1)
            );
            FontData fd = stepLabel.getFont().getFontData()[0];
            fd.setStyle(SWT.BOLD);
            stepLabel.setFont(new Font(Display.getDefault(),fd));

            if (version_greater_2_17_0) {
	            Label jndiLabel = toolkit.createLabel(specsComposite, "Plugin name", SWT.NULL);
	            jndiLabel.setLayoutData(
	                    new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
	            );
	            pluginsCombo = new Combo(specsComposite, SWT.DROP_DOWN);
	            pluginsCombo.addModifyListener(new ModifyListener() {
	            	public void modifyText(ModifyEvent e) {
	            		if (TransformerMainPage.this.refreshing) return;
	            		String jndi = pluginsCombo.getText();
	            		//update the description
	            		String description = pluginDescriptions.get(jndi);
	            		pluginDescription.setText(description == null ? "" : description);
	            		if (stepsList.getSelectionIndex()==-1) return;
	            		//commit as we go
	            		TransformerMainPage.this.comitting= true;	            		
	            		if (! jndi.contains("/")) jndi="amalto/local/transformer/plugin/"+jndi;
	            		((WSTransformer)getXObject().getWsObject())
	            				.getPluginSpecs()[stepsList.getSelectionIndex()]
	            			                  	.setPluginJNDI(jndi);
	            		TransformerMainPage.this.comitting= false;
	            		markDirty();
	            	}	            	
	            });
	            //feed the combo once
	            WSTransformerPluginsList list = Util.getPort(getXObject()).getTransformerPluginsList(new WSGetTransformerPluginsList("EN"));
	            WSTransformerPluginsListItem[] items = list.getItem();
	            if (items!=null) {
	            	for (int i = 0; i < items.length; i++) {
						pluginDescriptions.put(items[i].getJndiName(), items[i].getDescription());
					}
	            	//get the sorted list and feed the combo
	            	Set<String> jndis = pluginDescriptions.keySet();
	            	for (Iterator<String> iterator = jndis.iterator(); iterator.hasNext(); ) {
						String jndi = iterator.next();
						pluginsCombo.add(jndi);	
					}
	            }
            } else { //version < 2.17.0
	            Label jndiLabel = toolkit.createLabel(specsComposite, "JNDI id", SWT.NULL);
	            jndiLabel.setLayoutData(
	                    new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
	            );	            
	            jndiText = toolkit.createText(specsComposite, "",SWT.BORDER|SWT.SINGLE);
	            jndiText.setLayoutData(    
	                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
	            );
	            jndiText.addModifyListener(new ModifyListener() {
	            	public void modifyText(ModifyEvent e) {
	            		if (refreshing) return;
	            		if (stepsList.getSelectionIndex()==-1) return;
	            		//commit as we go
	            		TransformerMainPage.this.comitting= true;
	            		String jndi =jndiText.getText();
	            		if (! jndi.contains("/")) jndi="amalto/local/transformer/plugin/"+jndi;
	            		((WSTransformer)getXObject().getWsObject())
	            				.getPluginSpecs()[stepsList.getSelectionIndex()]
	            			                  	.setPluginJNDI(jndi);
	            		TransformerMainPage.this.comitting= false;
	            		markDirty();
	            	}
	            }); 
            }

            pluginDescription = toolkit.createLabel(specsComposite, "", SWT.NULL);
            pluginDescription.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,true,true,1,1)
            );
            ((GridData)pluginDescription.getLayoutData()).minimumWidth = 250;
            
            /*
            Button checkButton = toolkit.createButton(specsComposite,"Check",SWT.PUSH | SWT.CENTER);
            checkButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            checkButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		try {
	        			XtentisPort port = Util.getPort(
	        					"http://"+getXObject().getServer()+"/xtentis/XtentisPort",
	        					getXObject().getUsername(),
	        					getXObject().getPassword()
	        			);
	        			port.getTransformerPluginDetails(new WSGetTransformerPluginDetails(
	        					jndiText.getText().contains("/") ? jndiText.getText() : "amalto/local/transformer/plugin/"+jndiText.getText(), 
	        					"en"
	        			));
            		} catch (Exception ex) {
            			MessageDialog.openError(getSite().getShell(), "Check "+jndiText.getText(), "The plugin \""+jndiText.getText()+"\" did NOT respond correctly");
            			return;
            		}
            		MessageDialog.openInformation(getSite().getShell(), "Check "+jndiText.getText(), "The plugin \""+jndiText.getText()+"\" responded correctly");
            	}
            });
            */
            
            Button detailsButton = toolkit.createButton(specsComposite,"Help",SWT.PUSH | SWT.CENTER);
            detailsButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            detailsButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		try {
            			String jndi;
	            		if (version_greater_2_17_0) {
	            			jndi = pluginsCombo.getText();
	            		} else {
	            			jndi =jndiText.getText();
	            		}
	        			XtentisPort port = Util.getPort(
	        					new URL(getXObject().getEndpointAddress()),
	        					getXObject().getUsername(),
	        					getXObject().getPassword()
	        			);
	        			WSTransformerPluginDetails details =port.getTransformerPluginDetails(
	        					new WSGetTransformerPluginDetails(
	        							jndi.contains("/") ? jndi : "amalto/local/transformer/plugin/"+jndi,
	        							"en"
	        					)
	        			);
	        			final PluginDetailsDialog dialog = new PluginDetailsDialog(
	        					getSite().getShell(),
	        					details.getDescription(),
	        					details.getDocumentation(),
	        					details.getParametersSchema()
	        			);
	        			dialog.addListener(new Listener() {
	        				public void handleEvent(Event event) {dialog.close();}
	        			});
	        			
	        			dialog.setBlockOnOpen(true);
	        			dialog.open();
	        			
            		} catch (Exception ex) {
            			String jndi;
	            		if (version_greater_2_17_0) {
	            			jndi = pluginsCombo.getText();
	            		} else {
	            			jndi =jndiText.getText();
	            		}
            			MessageDialog.openError(getSite().getShell(), "Check "+jndiText.getText(), "The plugin \""+jndi+"\" did NOT respond correctly");
            			return;
            		}      		
            	}
            });
            
            //parameters
//            Label parametersLabel = toolkit.createLabel(specsComposite, "Parameters", SWT.NULL);
//            parametersLabel.setLayoutData(
//                    new GridData(SWT.LEFT,SWT.CENTER,false,true,2,1)
//            );
            
            Group parametersGroup = new Group(specsComposite,SWT.SHADOW_NONE);
            parametersGroup.setText("Parameters");
            parametersGroup.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,4,1)
            );
            ((GridData)parametersGroup.getLayoutData()).minimumHeight = 500;
            parametersGroup.setLayout(new GridLayout(1,true));
            
            parametersTextViewer = new SourceViewer(parametersGroup, new VerticalRuler(10), SWT.V_SCROLL);
            parametersTextViewer.getControl().setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            parametersTextViewer.addTextListener(new ITextListener() {
            	public void textChanged(TextEvent event) {
            		if (refreshing) return;
            		if (TransformerMainPage.this.stepsList.getSelectionIndex()==-1) return;
            		//commit as we go
            		TransformerMainPage.this.comitting= true;
            		((WSTransformer)getXObject().getWsObject()).getPluginSpecs()[stepsList.getSelectionIndex()].setParameters(parametersTextViewer.getDocument().get());
            		TransformerMainPage.this.comitting= false;
            		markDirty();            		
            	};
            });

            refreshData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//createCharacteristicsContent

    
    
    protected void refreshStep(int index) {
    	if (index < 0) return;
		TransformerMainPage.this.refreshing = true;
		WSTransformer transformer = (WSTransformer) getXObject().getWsObject();
		stepLabel.setText(transformer.getPluginSpecs()[index].getDescription());
		if (version_greater_2_17_0) {
			String jndi = transformer.getPluginSpecs()[index].getPluginJNDI().replaceAll("amalto/local/transformer/plugin/", "");
			pluginsCombo.setText(jndi);
			pluginDescription.setText(pluginDescriptions.get(jndi)== null ? "" : pluginDescriptions.get(jndi));
		}else {
			jndiText.setText(transformer.getPluginSpecs()[index].getPluginJNDI().replaceAll("amalto/local/transformer/plugin/", ""));
		}
		parametersTextViewer.setDocument(
				new Document(
						transformer.getPluginSpecs()[index].getParameters()
				)
		);
		TransformerMainPage.this.refreshing = false;
    }
    
    
    protected void removeStep(int index) {
		WSTransformer transformer = (WSTransformer) getXObject().getWsObject();
		String input = transformer.getPluginSpecs()[index].getInput();
		inputText.setText(input== null ? "" : input);
		stepText.setText(transformer.getPluginSpecs()[index].getDescription());
		String output = transformer.getPluginSpecs()[index].getOutput();
		outputText.setText(output== null ? "" : output);
		//clean up boxes at the bottom
		if (version_greater_2_17_0) {
			pluginsCombo.setText("");
			pluginsCombo.select(-1);
		}else {
			jndiText.setText("");
		}
		parametersTextViewer.setDocument(
				new Document("")
		);

		TransformerMainPage.this.comitting= true;
		TransformerMainPage.this.stepsList.remove(index);
		TransformerMainPage.this.stepsList.select(index-1);
		refreshStep(stepsList.getSelectionIndex());
		TransformerMainPage.this.stepsList.forceFocus();
		
		//commit as we go
		WSTransformer wsTransformer = (WSTransformer)getXObject().getWsObject(); 
		ArrayList<WSTransformerPluginSpec> list = new ArrayList<WSTransformerPluginSpec>(
				Arrays.asList(wsTransformer.getPluginSpecs())
		);
		list.remove(index);
		currentPlugin = -1;
		wsTransformer.setPluginSpecs(list.toArray(new WSTransformerPluginSpec[list.size()]));
		TransformerMainPage.this.comitting= false;
		markDirty();
    }
    

	protected void refreshData() {
		try {
//			System.out.println("refreshData() ");
			if (this.comitting) return;
			
			this.refreshing = true;
			
			WSTransformer wsTransformer = (WSTransformer) (getXObject().getWsObject());    	
			
			descriptionText.setText(wsTransformer.getDescription() == null ? "" : wsTransformer.getDescription());
			
			stepsList.removeAll();
			WSTransformerPluginSpec[] specs =  wsTransformer.getPluginSpecs();
			if (specs != null) {
				for (int i = 0; i < specs.length; i++) {
					stepsList.add(
							((specs[i].getInput()==null) || ("".equals(specs[i].getInput())) ? "()" : specs[i].getInput())+
	           				"---->["+
	           				specs[i].getDescription()+
	           				"]---->"+
	           				((specs[i].getOutput()==null) || ("".equals(specs[i].getOutput())) ? "()" : specs[i].getOutput())							
					);	
				}
			}
			
//			if (currentPlugin>=0) stepsList.select(currentPlugin);
			stepsList.select(currentPlugin);
			
			refreshStep(stepsList.getSelectionIndex());

            this.refreshing = false;

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error refreshing the page", "Error refreshing the page: "+e.getLocalizedMessage());
		}    	
	}
	
	protected void commit() { 
		//changes are committed as we go
	}
		
	
	
	protected void createActions() {
	}


	public void textChanged(TextEvent event) {
		markDirty();
	}

	/*
	private void hookContextMenu(TreeViewer viewer) {
	}

	private void fillContextMenu(IMenuManager manager) {
	}
	*/
	
	public void dispose() {
		super.dispose();
		windowTarget.dispose();
	}
	@Override
	public void doSave(IProgressMonitor monitor) {
		super.doSave(monitor);
		stepsList.setSelection(currentPlugin);
	}
	



	
	/****************************************************************************
	 *   DND
	 ****************************************************************************/
	
	class DCDragSourceListener implements DragSourceListener {
		private int selected;

		public void dragFinished(DragSourceEvent event) {
			Control control = ((DragSource)event.widget).getControl();
			if ((control instanceof List) && ((event.detail & DND.DROP_MOVE) == DND.DROP_MOVE)) {
				((List)control).remove(selected);
				TransformerMainPage.this.markDirty();
			}
		}

		public void dragSetData(DragSourceEvent event) {
			Control control = ((DragSource)event.widget).getControl();
			if ((control instanceof List))
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					this.selected = ((List)control).getSelectionIndex();
					event.data =  ((List)control).getSelection()[0];
				}
		}

		public void dragStart(DragSourceEvent event) {
			Control control = ((DragSource)event.widget).getControl();
			if ((control instanceof List))
				event.doit = (((List)control).getItemCount()>0);
		}
	}
	
	class DCDropTargetListener implements DropTargetListener {

		public void dragEnter(DropTargetEvent event) {
			//priority to copy
			if ((event.operations & DND.DROP_COPY) == DND.DROP_COPY)
				event.detail = DND.DROP_COPY;
			else if ((event.operations & DND.DROP_MOVE) == DND.DROP_MOVE)
				event.detail = DND.DROP_MOVE;
			else	
				event.detail = DND.DROP_NONE;
		}
		public void dragLeave(DropTargetEvent event) {}
		public void dragOperationChanged(DropTargetEvent event) {}
		public void dragOver(DropTargetEvent event) {}
		public void drop(DropTargetEvent event) {
			Control control = ((DropTarget)event.widget).getControl();
			if ((control instanceof List) && ((event.operations & DND.DROP_COPY) == DND.DROP_COPY))
				if (TextTransfer.getInstance().isSupportedType(event.currentDataType)) 
					if (!Arrays.asList(((List)control).getItems()).contains(event.data)) {
							((List)control).add((String)event.data);
							TransformerMainPage.this.markDirty();
					}
		}
		public void dropAccept(DropTargetEvent event) {}
		
	}

}
