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

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;

import com.amalto.workbench.actions.EditXObjectAction;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSInboundAdaptor;
import com.amalto.workbench.webservices.WSInboundPlugin;
import com.amalto.workbench.webservices.WSInboundPluginPK;
import com.amalto.workbench.webservices.WSSource;
import com.amalto.workbench.webservices.WSSourcePK;

public class InboundAdaptorMainPage extends AMainPage implements ITextListener{

	protected Text descriptionText;
	protected List inboundPluginsList;
	protected List allICsList;
	protected Combo dataModelCombo;
	protected Combo sourceCombo;
	//protected SourceViewer xsltViewer;
	protected DropTarget windowTarget;
	
	private boolean refreshing = false;
	private boolean comitting = false;
	
    public InboundAdaptorMainPage(FormEditor editor) {
        super(
        		editor,
        		InboundAdaptorMainPage.class.getName(),
        		"Main"
        );        
    }

	protected void createCharacteristicsContent(FormToolkit toolkit, Composite charComposite) {

        try {
        	                     
            //description
            Label descriptionLabel = toolkit.createLabel(charComposite, "Description", SWT.NULL);
            descriptionLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            descriptionText = toolkit.createText(charComposite, "",SWT.BORDER|SWT.MULTI);
            descriptionText.setLayoutData(    
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            descriptionText.addModifyListener(this);
            
            //source
            Hyperlink sourceLink = toolkit.createHyperlink(charComposite, "Source",SWT.NULL);
            sourceLink.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );         
            sourceLink.addHyperlinkListener(new IHyperlinkListener() {
            	public void linkEntered(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkExited(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent e) {
					TreeParent serverRoot = InboundAdaptorMainPage.this.getXObject().getServerRoot();
					TreeObject iaObject = new TreeObject(
							InboundAdaptorMainPage.this.sourceCombo.getText(),
							serverRoot,
							TreeObject.SOURCE,
							new WSSourcePK(InboundAdaptorMainPage.this.sourceCombo.getText()),
							null
					);
					(new EditXObjectAction(iaObject,InboundAdaptorMainPage.this.getSite().getPage())).run();
            	};
            });
            sourceCombo = new Combo(charComposite,SWT.READ_ONLY |SWT.DROP_DOWN|SWT.SINGLE);
            sourceCombo.addModifyListener(this);
            
            
            //dataModel
            Hyperlink dataModelLink = toolkit.createHyperlink(charComposite, "Data Model",SWT.NULL);
            dataModelLink.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );         
            dataModelLink.addHyperlinkListener(new IHyperlinkListener() {
            	public void linkEntered(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkExited(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent e) {
					TreeParent serverRoot = InboundAdaptorMainPage.this.getXObject().getServerRoot();
					TreeObject iaObject = new TreeObject(
							InboundAdaptorMainPage.this.dataModelCombo.getText(),
							serverRoot,
							TreeObject.DATA_MODEL,
							new WSDataModelPK(InboundAdaptorMainPage.this.dataModelCombo.getText()),
							null
					);
					(new EditXObjectAction(iaObject,InboundAdaptorMainPage.this.getSite().getPage())).run();
            	};
            });            
            dataModelCombo = new Combo(charComposite,SWT.READ_ONLY |SWT.DROP_DOWN|SWT.SINGLE);
            dataModelCombo.addModifyListener(this);
            
            
            //inboundPlugins
            Group icGroup = new Group(charComposite,SWT.SHADOW_NONE);
            icGroup.setText("Inbound Plugin");
            icGroup.setLayout(new GridLayout(2,true));
            icGroup.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
            );
            
            Label allICsLabel = toolkit.createLabel(icGroup, "Available", SWT.NULL);
            allICsLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );            
            Label selectedICsLabel = toolkit.createLabel(icGroup, "Selected", SWT.NULL);
            selectedICsLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            allICsList = new List(icGroup,SWT.SINGLE | SWT.V_SCROLL);
            allICsList.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            ((GridData)allICsList.getLayoutData()).heightHint = 100;
            DragSource allSource = new DragSource(allICsList,DND.DROP_COPY);
            allSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            allSource.addDragListener(new DCDragSourceListener());
            
            //make the Eclipse window a DropTarget - we need to dispose it
            windowTarget = new DropTarget(this.getPartControl(), DND.DROP_MOVE);
            windowTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            windowTarget.addDropListener(new DCDropTargetListener());

            inboundPluginsList = new List(icGroup,SWT.SINGLE | SWT.V_SCROLL);
            inboundPluginsList.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            DragSource icsSource = new DragSource(inboundPluginsList,DND.DROP_MOVE);
            icsSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            icsSource.addDragListener(new DCDragSourceListener());
            DropTarget icsTarget = new DropTarget(inboundPluginsList, DND.DROP_COPY);
            icsTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            icsTarget.addDropListener(new DCDropTargetListener());

            
            //XSLT
            Hyperlink XSLTLink = toolkit.createHyperlink(charComposite, "Display XSLT",SWT.NULL);
            XSLTLink.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,2,1)
            );         
            XSLTLink.addHyperlinkListener(new IHyperlinkListener() {
            	public void linkEntered(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkExited(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent e) {
					InboundAdaptorMainPage.this.getEditor().setActivePage(InboundAdaptorXSLTEditorPage.class.getName());
				}
            });
            

            //Updates
            Hyperlink updatesLink = toolkit.createHyperlink(charComposite, "Display Partial Updates",SWT.NULL);
            updatesLink.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,2,1)
            );         
            updatesLink.addHyperlinkListener(new IHyperlinkListener() {
            	public void linkEntered(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkExited(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent e) {
					InboundAdaptorMainPage.this.getEditor().setActivePage(InboundAdaptorUpdatesPage.class.getName());
				}
            });

            
            
            /*
            Group xsltGroup = new Group(charComposite,SWT.SHADOW_NONE);
            xsltGroup.setText("XSLT");
            xsltGroup.setLayout(new GridLayout(1,true));
            xsltGroup.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
            );
            ((GridData)xsltGroup.getLayoutData()).minimumHeight = 500;
            xsltViewer = new SourceViewer(xsltGroup, new VerticalRuler(10), SWT.V_SCROLL);
            xsltViewer.getControl().setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            xsltViewer.addTextListener(this);
            */

            refreshData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//createCharacteristicsContent


	protected void refreshData() {
		try {
			
			if (this.comitting) return;
			
			this.refreshing = true;
			
			WSInboundAdaptor wsObject = (WSInboundAdaptor) (getXObject().getWsObject());    	
	    	
            descriptionText.setText(wsObject.getDescription()==null ? "" : wsObject.getDescription());
	    	
            sourceCombo.removeAll();
            WSSource[] sources = Util.getAllSources(
            		new URL(getXObject().getEndpointAddress()),
            		getXObject().getUsername(),
            		getXObject().getPassword()
            );
            if ((sources == null) || (sources.length == 0)) {
            	MessageDialog.openError(
            			this.getSite().getShell(), 
            			"Error", 
            			"Please create Sources before editing an Inbound Adaptor");
            	return;
            }
            for (int  i = 0; i < sources.length; i++) {
				sourceCombo.add(sources[i].getName());
				if (sources[i].getName().equals(wsObject.getWsSourcePK().getPk()))
					sourceCombo.select(i);
			}
	    	
            dataModelCombo.removeAll();
            
//            WSDataModel[] dataModels = Util.getAllDataModels(
            WSDataModelPK[] dataModelPKs = Util.getAllDataModelPKs(          		
            		new URL(getXObject().getEndpointAddress()),
            		getXObject().getUsername(),
            		getXObject().getPassword()
            );
            if ((dataModelPKs == null) || (dataModelPKs.length == 1)) { //XMLSCHEMA---
            	MessageDialog.openError(
            			this.getSite().getShell(), 
            			"Error", 
            			"Please create a Data Model before editing an Inbound Adaptor");
            	return;
            }
            for (int  i = 0; i < dataModelPKs.length; i++) {
            	if (dataModelPKs[i].getPk().indexOf("XMLSCHEMA---")==-1) {
            		dataModelCombo.add(dataModelPKs[i].getPk());
            		if (dataModelPKs[i].getPk().equals(wsObject.getWsDataModelPK().getPk()))
            			dataModelCombo.select(dataModelCombo.getItems().length-1);
            	}
			}
            
            inboundPluginsList.removeAll();
            WSInboundPlugin[] inboundPlugins = Util.getAllInboundPlugins(
            		new URL(getXObject().getEndpointAddress()),
            		getXObject().getUsername(),
            		getXObject().getPassword()
            );
            if ((inboundPlugins == null) || (inboundPlugins.length == 0)) {
            } else {
            	ArrayList allIcs = new ArrayList();
            	for (int i = 0; i < inboundPlugins.length; i++) {
					allIcs.add(inboundPlugins[i].getName());
				}
            	ArrayList selectedICs = new ArrayList();
            	if (wsObject.getWSInboundPluginPKs() != null)
            		selectedICs.addAll(Arrays.asList(wsObject.getWSInboundPluginPKs()));
            	for (Iterator iter = selectedICs.iterator(); iter.hasNext(); ) {
					WSInboundPluginPK ic = (WSInboundPluginPK) iter.next();
					if (allIcs.contains(ic.getPk())) {
						inboundPluginsList.add(ic.getPk());
						allIcs.remove(ic.getPk());
					}
				}
            	for (Iterator iter = allIcs.iterator(); iter.hasNext(); ) {
            		String ic = (String) iter.next();
					allICsList.add(ic);
				}
            }
            
            /*
            Document doc = new Document(wsObject.getXslt());
            xsltViewer.setDocument(doc);
            */
            
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
			
	    	WSInboundAdaptor wsObject = (WSInboundAdaptor) (getXObject().getWsObject());
			wsObject.setDescription(descriptionText.getText());
			wsObject.setWsDataModelPK(new WSDataModelPK(dataModelCombo.getText()));
			wsObject.setWsSourcePK(new WSSourcePK(sourceCombo.getText()));
			String[] vals = inboundPluginsList.getItems();
			ArrayList icl = new ArrayList();
			for (int i = 0; i < vals.length; i++) {
				icl.add(new WSInboundPluginPK(vals[i]));
			}
			wsObject.setWSInboundPluginPKs((WSInboundPluginPK[]) icl.toArray(new WSInboundPluginPK[icl.size()]));
			//wsObject.setXslt(xsltViewer.getDocument().get());
			
			this.comitting = false;
			
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error comtiting the page", "Error comitting the page: "+e.getLocalizedMessage());
		}    	
	}
		
	protected void createActions() {
	}

	public void mouseDoubleClick(MouseEvent e) {
		if (e.getSource().equals(allICsList)) {
			if (allICsList.getSelectionIndex() != -1) {
				inboundPluginsList.add(allICsList.getSelection()[0]);
				allICsList.remove(allICsList.getSelectionIndex());
				markDirty();
			}
		} else 	if (e.getSource().equals(inboundPluginsList)) {
			if (inboundPluginsList.getSelectionIndex() != -1) {
				allICsList.add(inboundPluginsList.getSelection()[0]);
				inboundPluginsList.remove(inboundPluginsList.getSelectionIndex());
				markDirty();
			}
		} 
	}


	public void textChanged(TextEvent event) {
		if (this.refreshing) return;
		markDirty();
	}
	
	//description text listener
	public void modifyText(ModifyEvent e) {
		if (this.refreshing) return;
		super.modifyText(e);
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

	/****************************************************************************
	 *   DND
	 ****************************************************************************/
	
	class DCDragSourceListener implements DragSourceListener {
		private int selected;

		public void dragFinished(DragSourceEvent event) {
			Control control = ((DragSource)event.widget).getControl();
			if ((control instanceof List) && ((event.detail & DND.DROP_MOVE) == DND.DROP_MOVE)) {
				((List)control).remove(selected);
				InboundAdaptorMainPage.this.markDirty();
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
							InboundAdaptorMainPage.this.markDirty();
					}
		}
		public void dropAccept(DropTargetEvent event) {}
		
	}



}
