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
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.VerticalRuler;
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
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSDestination;
import com.amalto.workbench.webservices.WSDestinationPK;
import com.amalto.workbench.webservices.WSOutboundAdaptor;
import com.amalto.workbench.webservices.WSOutboundPlugin;
import com.amalto.workbench.webservices.WSOutboundPluginPK;

public class OutboundAdaptorMainPage extends AMainPage implements ITextListener{

	protected Text descriptionText;
	protected List outboundPluginsList;
	protected List allICsList;
	protected Combo dataModelCombo;
	protected Combo sourceCombo;
	protected SourceViewer xsltViewer;
	protected DropTarget windowTarget;
	
	private boolean refreshing = false;
	private boolean comitting = false;
	
    public OutboundAdaptorMainPage(FormEditor editor) {
        super(
        		editor,
        		OutboundAdaptorMainPage.class.getName(),
        		"Outbound Adaptor "+((XObjectEditorInput)editor.getEditorInput()).getName()
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
            Hyperlink sourceLink = toolkit.createHyperlink(charComposite, "Destination",SWT.NULL);
            sourceLink.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );         
            sourceLink.addHyperlinkListener(new IHyperlinkListener() {
            	public void linkEntered(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkExited(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent e) {
					TreeParent serverRoot = OutboundAdaptorMainPage.this.getXObject().getServerRoot();
					TreeObject iaObject = new TreeObject(
							OutboundAdaptorMainPage.this.sourceCombo.getText(),
							serverRoot,
							TreeObject.SOURCE,
							new WSDestinationPK(OutboundAdaptorMainPage.this.sourceCombo.getText()),
							null
					);
					(new EditXObjectAction(iaObject,OutboundAdaptorMainPage.this.getSite().getPage())).run();
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
					TreeParent serverRoot = OutboundAdaptorMainPage.this.getXObject().getServerRoot();
					TreeObject iaObject = new TreeObject(
							OutboundAdaptorMainPage.this.dataModelCombo.getText(),
							serverRoot,
							TreeObject.DATA_MODEL,
							new WSDataModelPK(OutboundAdaptorMainPage.this.dataModelCombo.getText()),
							null
					);
					(new EditXObjectAction(iaObject,OutboundAdaptorMainPage.this.getSite().getPage())).run();
            	};
            });            
            dataModelCombo = new Combo(charComposite,SWT.READ_ONLY |SWT.DROP_DOWN|SWT.SINGLE);
            dataModelCombo.addModifyListener(this);
            
            
            //outboundPlugins
            Group icGroup = new Group(charComposite,SWT.SHADOW_NONE);
            icGroup.setText("Outbound Plugin");
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
            DragSource allDestination = new DragSource(allICsList,DND.DROP_COPY);
            allDestination.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            allDestination.addDragListener(new DCDragSourceListener());
            
            //make the Eclipse window a DropTarget - we need to dispose it
            windowTarget = new DropTarget(this.getPartControl(), DND.DROP_MOVE);
            windowTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            windowTarget.addDropListener(new DCDropTargetListener());

            outboundPluginsList = new List(icGroup,SWT.SINGLE | SWT.V_SCROLL);
            outboundPluginsList.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            DragSource icsDestination = new DragSource(outboundPluginsList,DND.DROP_MOVE);
            icsDestination.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            icsDestination.addDragListener(new DCDragSourceListener());
            DropTarget icsTarget = new DropTarget(outboundPluginsList, DND.DROP_COPY);
            icsTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            icsTarget.addDropListener(new DCDropTargetListener());

            
            //XSLT
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
            

            refreshData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//createCharacteristicsContent


	protected void refreshData() {
		try {
			
			if (this.comitting) return;
			
			this.refreshing = true;
			
			WSOutboundAdaptor wsObject = (WSOutboundAdaptor) (getXObject().getWsObject());    	
	    	
            descriptionText.setText(wsObject.getDescription()==null ? "" : wsObject.getDescription());
	    	
            sourceCombo.removeAll();
            WSDestination[] sources = Util.getAllDestinations(
            		new URL(getXObject().getEndpointAddress()),
            		getXObject().getUsername(),
            		getXObject().getPassword()
            );
            if ((sources == null) || (sources.length == 0)) {
            	MessageDialog.openError(
            			this.getSite().getShell(), 
            			"Error", 
            			"Please create Destinations before editing an Outbound Adaptor");
            	return;
            }
            for (int  i = 0; i < sources.length; i++) {
				sourceCombo.add(sources[i].getName());
				if (sources[i].getName().equals(wsObject.getWsDestinationPK().getPk()))
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
            			"Please create a Data Model before editing an Outbound Adaptor");
            	return;
            }
            for (int  i = 0; i < dataModelPKs.length; i++) {
            	if (dataModelPKs[i].getPk().indexOf("XMLSCHEMA---")==-1) {
            		dataModelCombo.add(dataModelPKs[i].getPk());
            		if (dataModelPKs[i].getPk().equals(wsObject.getWsDataModelPK().getPk()))
            			dataModelCombo.select(dataModelCombo.getItems().length-1);
            	}
			}
            
            outboundPluginsList.removeAll();
            WSOutboundPlugin[] outboundPlugins = Util.getAllOutboundPlugins(
            		new URL(getXObject().getEndpointAddress()),
            		getXObject().getUsername(),
            		getXObject().getPassword()
            );
            if ((outboundPlugins == null) || (outboundPlugins.length == 0)) {
            } else {
            	ArrayList allIcs = new ArrayList();
            	for (int i = 0; i < outboundPlugins.length; i++) {
					allIcs.add(outboundPlugins[i].getName());
				}
            	ArrayList selectedICs = new ArrayList();
            	if (wsObject.getWSOutboundPluginPKs() != null)
            		selectedICs.addAll(Arrays.asList(wsObject.getWSOutboundPluginPKs()));
            	for (Iterator iter = selectedICs.iterator(); iter.hasNext(); ) {
					WSOutboundPluginPK ic = (WSOutboundPluginPK) iter.next();
					if (allIcs.contains(ic.getPk())) {
						outboundPluginsList.add(ic.getPk());
						allIcs.remove(ic.getPk());
					}
				}
            	for (Iterator iter = allIcs.iterator(); iter.hasNext(); ) {
            		String ic = (String) iter.next();
					allICsList.add(ic);
				}
            }
            
            Document doc = new Document(wsObject.getXslt());
            xsltViewer.setDocument(doc);
            
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
			
	    	WSOutboundAdaptor wsObject = (WSOutboundAdaptor) (getXObject().getWsObject());
			wsObject.setDescription(descriptionText.getText());
			wsObject.setWsDataModelPK(new WSDataModelPK(dataModelCombo.getText()));
			wsObject.setWsDestinationPK(new WSDestinationPK(sourceCombo.getText()));
			String[] vals = outboundPluginsList.getItems();
			ArrayList icl = new ArrayList();
			for (int i = 0; i < vals.length; i++) {
				icl.add(new WSOutboundPluginPK(vals[i]));
			}
			wsObject.setWSOutboundPluginPKs((WSOutboundPluginPK[]) icl.toArray(new WSOutboundPluginPK[icl.size()]));
			wsObject.setXslt(xsltViewer.getDocument().get());
			
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
				outboundPluginsList.add(allICsList.getSelection()[0]);
				allICsList.remove(allICsList.getSelectionIndex());
				markDirty();
			}
		} else 	if (e.getSource().equals(outboundPluginsList)) {
			if (outboundPluginsList.getSelectionIndex() != -1) {
				allICsList.add(outboundPluginsList.getSelection()[0]);
				outboundPluginsList.remove(outboundPluginsList.getSelectionIndex());
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
				OutboundAdaptorMainPage.this.markDirty();
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
							OutboundAdaptorMainPage.this.markDirty();
					}
		}
		public void dropAccept(DropTargetEvent event) {}
		
	}

}
