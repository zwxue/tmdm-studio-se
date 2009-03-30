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

import org.eclipse.core.runtime.IProgressMonitor;
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
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;

import com.amalto.workbench.actions.EditXObjectAction;
import com.amalto.workbench.actions.SaveXObjectAction;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDocument;
import com.amalto.workbench.webservices.WSInboundAdaptor;
import com.amalto.workbench.webservices.WSInboundAdaptorPK;

public class DocumentMainPage extends AMainPage implements ITextListener{

	protected Text descriptionText;
	protected Combo inboundAdaptorCombo;
//	protected Button cacheButton;
//	protected Combo cacheCombo;
	protected List allDCsList;
	protected List addDCsList;
	protected List updateDCsList;
	protected List removeDCsList;
	protected DropTarget windowTarget;
	protected SourceViewer xsltViewer;
	protected Label fileLabel;
	protected String filePath=null;
	protected Combo encodingCombo;
	protected Button reprocessDataButton;
	protected Button processNewDataButton;
	
	private boolean refreshing = false;
	private boolean comitting = false;
	
    public DocumentMainPage(FormEditor editor) {
        super(
        		editor,
        		DocumentMainPage.class.getName(),
        		"Document "+((XObjectEditorInput)editor.getEditorInput()).getName()
        );        
    }

	protected void createCharacteristicsContent(FormToolkit toolkit, Composite charComposite) {

        try {
        	WSDocument wsObject = (WSDocument) (getXObject().getWsObject());
        	                     
            //description
            Label descriptionLabel = toolkit.createLabel(charComposite, "Description", SWT.NULL);
            descriptionLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            descriptionText = toolkit.createText(charComposite, "",SWT.BORDER | SWT.MULTI | SWT.WRAP);
            descriptionText.setLayoutData(    
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            descriptionText.addModifyListener(this);
            
            //inboundadaptor
            Hyperlink ialink = toolkit.createHyperlink(charComposite, "Inbound Adaptor",SWT.WRAP);
            ialink.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );         
            ialink.addHyperlinkListener(new IHyperlinkListener() {
            	public void linkEntered(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkExited(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent e) {
					if (!"".equals(DocumentMainPage.this.inboundAdaptorCombo.getText())) {
						TreeParent serverRoot = DocumentMainPage.this.getXObject().getServerRoot();
						TreeObject iaObject = new TreeObject(
								DocumentMainPage.this.inboundAdaptorCombo.getText(),
								serverRoot,
								TreeObject.INBOUND_ADAPTOR,
								new WSInboundAdaptorPK(DocumentMainPage.this.inboundAdaptorCombo.getText()),
								null
						);
						(new EditXObjectAction(iaObject,DocumentMainPage.this.getSite().getPage())).run();
					}
            	};
            });
            inboundAdaptorCombo = new Combo(charComposite,SWT.READ_ONLY |SWT.DROP_DOWN|SWT.SINGLE);
            inboundAdaptorCombo.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            inboundAdaptorCombo.addModifyListener(this);
            
            //cache
            /*
            cacheButton = new Button(charComposite,SWT.TOGGLE | SWT.TRAIL);
            cacheButton.setLayoutData(
                    new GridData(SWT.CENTER,SWT.FILL,false,true,1,1)
            );
            cacheButton.setText("Keep In cache");
            cacheButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		markDirty();
            		if (DocumentMainPage.this.cacheButton.getSelection() && (cacheCombo.getItemCount()>0)) {
            			DocumentMainPage.this.cacheCombo.setVisible(true);
            			return;
            		}
           			DocumentMainPage.this.cacheCombo.setVisible(false);
            	};
            });
            cacheCombo = new Combo(charComposite,SWT.READ_ONLY |SWT.DROP_DOWN|SWT.SINGLE);
            cacheCombo.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            cacheCombo.addModifyListener(this);
            */
            
            //DataClusters
            Composite dcGroup = this.getNewSectionComposite("Data Clusters");
            dcGroup.setLayout(new GridLayout(3,true));
            
            Label allDCsLabel = toolkit.createLabel(dcGroup, "Available", SWT.NULL);
            allDCsLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,3,1)
            );   
            allDCsList = new List(dcGroup,SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
            allDCsList.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,3,1)
            );
            ((GridData)allDCsList.getLayoutData()).heightHint = 66;
            allDCsList.addMouseListener(new MouseListener() {
            	public void mouseDoubleClick(MouseEvent e) {
            		if (DocumentMainPage.this.allDCsList.getItemCount()==0) return;
            		String item = DocumentMainPage.this.allDCsList.getSelection()[0];
            		if (!Arrays.asList(DocumentMainPage.this.addDCsList.getItems()).contains(item)) {
            			DocumentMainPage.this.addDCsList.add(item);
            			DocumentMainPage.this.markDirty();
            		}
            		if (!Arrays.asList(DocumentMainPage.this.updateDCsList.getItems()).contains(item)) {
            			DocumentMainPage.this.updateDCsList.add(item);
            			DocumentMainPage.this.markDirty();
            		}
            		if (!Arrays.asList(DocumentMainPage.this.removeDCsList.getItems()).contains(item)) {
            			DocumentMainPage.this.removeDCsList.add(item);
            			DocumentMainPage.this.markDirty();
    				}
            	}
            	public void mouseDown(MouseEvent e) {};
            	public void mouseUp(MouseEvent e) {};
            });
            DragSource allSource = new DragSource(allDCsList,DND.DROP_COPY);
            allSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            allSource.addDragListener(new DCDragSourceListener());
            
            //make the Eclipse window a DropTarget - we need to dispose it
            windowTarget = new DropTarget(this.getPartControl(), DND.DROP_MOVE);
            windowTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            windowTarget.addDropListener(new DCDropTargetListener());
            
            Label addDCsLabel = toolkit.createLabel(dcGroup, "Auto Add", SWT.NULL);
            addDCsLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );   
            Label updateDCsLabel = toolkit.createLabel(dcGroup, "Auto Update", SWT.NULL);
            updateDCsLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );   
            Label removeDCsLabel = toolkit.createLabel(dcGroup, "Auto Remove", SWT.NULL);
            removeDCsLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );               
            addDCsList = new List(dcGroup,SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
            addDCsList.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            addDCsList.addMouseListener(new MouseListener() {
            	public void mouseDoubleClick(MouseEvent e) {
            		if (DocumentMainPage.this.addDCsList.getItemCount()==0) return;
            		DocumentMainPage.this.addDCsList.remove(DocumentMainPage.this.addDCsList.getSelectionIndex());
           			DocumentMainPage.this.markDirty();
            	}
            	public void mouseDown(MouseEvent e) {};
            	public void mouseUp(MouseEvent e) {};
            });   
            ((GridData)addDCsList.getLayoutData()).heightHint = 66;
            DragSource addSource = new DragSource(addDCsList,DND.DROP_MOVE);
            addSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            addSource.addDragListener(new DCDragSourceListener());
            DropTarget addTarget = new DropTarget(addDCsList, DND.DROP_COPY);
            addTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            addTarget.addDropListener(new DCDropTargetListener());

            updateDCsList = new List(dcGroup,SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
            updateDCsList.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            updateDCsList.addMouseListener(new MouseListener() {
            	public void mouseDoubleClick(MouseEvent e) {
            		if (DocumentMainPage.this.updateDCsList.getItemCount()==0) return;
            		DocumentMainPage.this.updateDCsList.remove(DocumentMainPage.this.updateDCsList.getSelectionIndex());
           			DocumentMainPage.this.markDirty();
            	}
            	public void mouseDown(MouseEvent e) {};
            	public void mouseUp(MouseEvent e) {};
            }); 
            DragSource updateSource = new DragSource(updateDCsList,DND.DROP_MOVE);
            updateSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            updateSource.addDragListener(new DCDragSourceListener());
            DropTarget updateTarget = new DropTarget(updateDCsList, DND.DROP_COPY);
            updateTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            updateTarget.addDropListener(new DCDropTargetListener());

            removeDCsList = new List(dcGroup,SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
            removeDCsList.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            removeDCsList.addMouseListener(new MouseListener() {
            	public void mouseDoubleClick(MouseEvent e) {
            		if (DocumentMainPage.this.removeDCsList.getItemCount()==0) return;
            		DocumentMainPage.this.removeDCsList.remove(DocumentMainPage.this.removeDCsList.getSelectionIndex());
           			DocumentMainPage.this.markDirty();
            	}
            	public void mouseDown(MouseEvent e) {};
            	public void mouseUp(MouseEvent e) {};
            }); 
            DragSource removeSource = new DragSource(removeDCsList,DND.DROP_MOVE);
            removeSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            removeSource.addDragListener(new DCDragSourceListener());
            DropTarget removeTarget = new DropTarget(removeDCsList, DND.DROP_COPY);
            removeTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            removeTarget.addDropListener(new DCDropTargetListener());
                       
            //Extractor XSLT
            Composite xsltComposite = this.getNewSectionComposite("Extractor XSLT");
            xsltViewer = new SourceViewer(xsltComposite, new VerticalRuler(10), SWT.V_SCROLL);
            xsltViewer.getControl().setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            xsltViewer.addTextListener(this);
            
            //Upload section            
            Composite uploadComposite = this.getNewSectionComposite("Upload and Project");
                        
            Hyperlink uplink = toolkit.createHyperlink(uploadComposite, "File :",SWT.WRAP);
            uplink.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );         
            uplink.addHyperlinkListener(new IHyperlinkListener() {
            	public void linkEntered(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkExited(org.eclipse.ui.forms.events.HyperlinkEvent e) {}
				public void linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent e) {
					FileDialog fd = new FileDialog(DocumentMainPage.this.getSite().getShell(),SWT.OPEN);
					fd.setText("Select document to upload");
					/*
					fd.setFilterExtensions(new String[] {"*.*"});
					fd.setFilterExtensions(new String[] {"All Files"});
					*/
					if (DocumentMainPage.this.filePath != null) 
						fd.setFilterPath(DocumentMainPage.this.filePath);
					else
						fd.setFilterPath(System.getProperty("user.home"));
					fd.open();
					String filename = fd.getFileName();
					if ("".equals(filename)) return;
					DocumentMainPage.this.filePath = fd.getFilterPath();
					DocumentMainPage.this.encodingCombo.setVisible(true);
					DocumentMainPage.this.fileLabel.setText(
							fd.getFilterPath()+
							System.getProperty("file.separator")+
							filename
					);
//					DocumentMainPage.this.markDirty();
            	};
            });
            
            fileLabel = toolkit.createLabel(uploadComposite, "", SWT.WRAP);
            fileLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );   
            
            Label encodingLabel = toolkit.createLabel(uploadComposite, "Encoding", SWT.NULL);
            encodingLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,false,1,1)
            );   
            encodingCombo = new Combo(uploadComposite,SWT.DROP_DOWN);
            encodingCombo.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,false,1,1)
            );   
            encodingCombo.add("UTF-8");
            encodingCombo.add("ISO-8859-15");
            encodingCombo.add("ISO-8859-2");
            encodingCombo.add("ISO-8859-1");
            encodingCombo.add("UCS4");
            encodingCombo.select(0);
            encodingCombo.setVisible(false);
            encodingCombo.addModifyListener(this);
            
            processNewDataButton = toolkit.createButton(uploadComposite, "Process File", SWT.PUSH);
            processNewDataButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,false,1,1)
            );
            processNewDataButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(SelectionEvent e) {}
            	public void widgetSelected(SelectionEvent e) {
            		boolean doIt = MessageDialog.openConfirm(
            				DocumentMainPage.this.getSite().getShell(), 
            				"Project New Data" , 
            				"Are you sure you want process the data in "+DocumentMainPage.this.fileLabel.getText()+"?"
            		);
            		if (doIt) {
            			//No dirty flag --> Force commit
            			commit();
            			(new SaveXObjectAction((XObjectEditor)DocumentMainPage.this.getEditor())).run();
//            			DocumentMainPage.this.getManagedForm().dirtyStateChanged();
            			DocumentMainPage.this.getManagedForm().refresh();
            		}
            	}
            });
            Label blankLabel = toolkit.createLabel(uploadComposite, " ", SWT.NULL);
            blankLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,false,1,1)
            ); 
 
            
            if (wsObject.isKeepInCache()) {
            	reprocessDataButton = toolkit.createButton(uploadComposite, "Reprocess Cache", SWT.PUSH);
                reprocessDataButton.setLayoutData(
                        new GridData(SWT.FILL,SWT.FILL,false,false,1,1)
                );                     	
	            reprocessDataButton.addSelectionListener(new SelectionListener() {
	            	public void widgetDefaultSelected(SelectionEvent e) {}
	            	public void widgetSelected(SelectionEvent e) {
	            		//FIXME: activate re-processing of cache
	            		MessageDialog.openWarning(
	            				DocumentMainPage.this.getSite().getShell(),
	            				"Sorry", 
	            				"This function is de-activated in this version!"
	            		);
	            		/*
	            		boolean doIt = MessageDialog.openConfirm(
	            				DocumentMainPage.this.getSite().getShell(), 
	            				"Re Project Data" , 
	            				"Are you sure you want to reprocess the data in cache?"
	            		);
	            		*/
	            	}
	            });
            }
            
            refreshData();

        } catch (Exception e) {
        	e.printStackTrace();
        	MessageDialog.openError(
        			this.getSite().getShell(), 
        			"Error", 
        			"Could not open the Main Page of the Document Editor: "+e.getLocalizedMessage());
            this.getEditor().close(false);
        }

    }//createCharacteristicsContent


	protected void refreshData() {
		try {
			
			if (this.comitting) return;
			
			this.refreshing = true;
			
			WSDocument wsObject = (WSDocument) (getXObject().getWsObject());    	
	    	
            descriptionText.setText(wsObject.getDescription()==null ? "" : wsObject.getDescription());
	    	
            inboundAdaptorCombo.removeAll();
            WSInboundAdaptor[] ias = Util.getAllInboundAdaptors(
            		new URL(getXObject().getEndpointAddress()),
            		getXObject().getUsername(),
            		getXObject().getPassword(),
            		"*"
            );
            if ((ias == null) || (ias.length == 0)) {
            	MessageDialog.openError(
            			this.getSite().getShell(), 
            			"Error", 
            			"Please create Inbound Adaptors before trying to publish a document");
            	this.getEditor().close(false);
            	return;
            }
            for (int  i = 0; i < ias.length; i++) {
				inboundAdaptorCombo.add(ias[i].getName());
				if ((wsObject.getWsInboundAdaptorPK()!=null) && (ias[i].getName().equals(wsObject.getWsInboundAdaptorPK().getPk())))
					inboundAdaptorCombo.select(i);
			}
	    	
            /*
            cacheButton.setSelection(wsObject.isKeepInCache());
            
            cacheCombo.removeAll();
            WSDataCluster[] dcs = Util.getAllDataClusters(
            		getXObject().getServer(),
            		getXObject().getUsername(),
            		getXObject().getPassword()
            );
            if ((dcs == null) || (dcs.length == 0)) {
            	MessageDialog.openError(
            			this.getSite().getShell(), 
            			"Error", 
            			"Please create Data Clusters before trying to project a document");
            	this.getEditor().close(false);
            	return;
            }
            for (int  i = 0; i < dcs.length; i++) {
            	if (dcs[i].getWsDataClusterType().equals(WSDataClusterType.CACHE)) {
            		cacheCombo.add(dcs[i].getName());
            		if ((wsObject.getWsCacheDataClusterPK()!=null) && (dcs[i].getName().equals(wsObject.getWsCacheDataClusterPK().getPk())))
            			cacheCombo.select(cacheCombo.getItemCount()-1);
            	}
			}//for
            cacheCombo.setVisible(wsObject.isKeepInCache());
            */

            WSDataClusterPK[] dcPKs = Util.getAllDataClusterPKs(
            		new URL(getXObject().getEndpointAddress()),
            		getXObject().getUsername(),
            		getXObject().getPassword()
            );
            allDCsList.removeAll();
            for (int  i = 0; i < dcPKs.length; i++) {
            	if (!dcPKs[i].getPk().equals("CACHE")) {  //FIXME: hardcoded CACHE
            		allDCsList.add(dcPKs[i].getPk());
            	}
			}//for
            if (allDCsList.getItemCount()==0) {
            	MessageDialog.openError(
            			this.getSite().getShell(), 
            			"Error", 
            			"Please create a Data Cluster before trying to project a document");
            	this.getEditor().close(false);
            	return;
            }
            if (allDCsList.getItemCount()>0) allDCsList.select(0);
 
            addDCsList.removeAll();
            if (wsObject.getWsAutoAddDataClusterPKs() != null) {
	            for (int  i = 0; i < wsObject.getWsAutoAddDataClusterPKs().length; i++) {
	           		addDCsList.add(wsObject.getWsAutoAddDataClusterPKs()[i].getPk());
				}//for
	            if (addDCsList.getItemCount()>0) addDCsList.select(0);
            }
            
            updateDCsList.removeAll();
            if (wsObject.getWsAutoUpdateDataClusterPKs() != null) {
	            for (int  i = 0; i < wsObject.getWsAutoUpdateDataClusterPKs().length; i++) {
	           		updateDCsList.add(wsObject.getWsAutoUpdateDataClusterPKs()[i].getPk());
				}//for
	            if (updateDCsList.getItemCount()>0) updateDCsList.select(0);
            }
            
            removeDCsList.removeAll();
            if (wsObject.getWsAutoRemoveDataClusterPKs() != null) {
	            for (int  i = 0; i < wsObject.getWsAutoRemoveDataClusterPKs().length; i++) {
	           		removeDCsList.add(wsObject.getWsAutoRemoveDataClusterPKs()[i].getPk());
				}//for
	            if (removeDCsList.getItemCount()>0) removeDCsList.select(0);
            }
            String xslt = wsObject.getXslt();
            if (xslt==null) {
		       	xslt = 
	    			"<?xml version='1.0' encoding='UTF-8'?>\n"+
	    			"<xs:stylesheet xmlns:xs='http://www.w3.org/1999/XSL/Transform' version='1.0'>\n"+
	    			"    <xs:output method='xml' indent='yes' omit-xml-declaration='yes' standalone='yes'/>\n"+
	    			"   <xs:template match='/'><xs:copy-of select='./*'/></xs:template>\n"+    
	    			"</xs:stylesheet>";
            }
            Document doc = new Document(xslt);
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
			
			if ((reprocessDataButton != null) && this.isDirty()) reprocessDataButton.setEnabled(false);
			
	    	WSDocument wsObject = (WSDocument) (getXObject().getWsObject());
			wsObject.setDescription(descriptionText.getText());
			wsObject.setWsInboundAdaptorPK(new WSInboundAdaptorPK(inboundAdaptorCombo.getText()));
			/*
			wsObject.setKeepInCache(cacheButton.getSelection());
			wsObject.setWsCacheDataClusterPK(
					"".equals(cacheCombo.getText())?
					null:
					new WSDataClusterPK(cacheCombo.getText())
			);
			*/
			wsObject.setKeepInCache(false);
			wsObject.setWsCacheDataClusterPK(null);
			
			ArrayList dcl;
			String[] vals;
			dcl= new ArrayList();
			vals = addDCsList.getItems();
			for (int i = 0; i < vals.length; i++) {
				dcl.add(new WSDataClusterPK(vals[i]));
			}
			wsObject.setWsAutoAddDataClusterPKs((WSDataClusterPK[])dcl.toArray(new WSDataClusterPK[dcl.size()]));
			dcl= new ArrayList();
			vals = updateDCsList.getItems();
			for (int i = 0; i < vals.length; i++) {
				dcl.add(new WSDataClusterPK(vals[i]));
			}
			wsObject.setWsAutoUpdateDataClusterPKs((WSDataClusterPK[])dcl.toArray(new WSDataClusterPK[dcl.size()]));
			dcl= new ArrayList();
			vals = removeDCsList.getItems();
			for (int i = 0; i < vals.length; i++) {
				dcl.add(new WSDataClusterPK(vals[i]));
			}
			wsObject.setWsAutoRemoveDataClusterPKs((WSDataClusterPK[])dcl.toArray(new WSDataClusterPK[dcl.size()]));
			
			getXObject().setAdditionalInfo(new String[] {
					fileLabel.getText(),
					encodingCombo.getText()
			});
			
			wsObject.setXslt(xsltViewer.getDocument().get());
			
			this.comitting = false;
			
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error comtiting the page", "Error comitting the page: "+e.getLocalizedMessage());
		}    	
	}
		
	protected void createActions() {
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
	

	public void doSave(IProgressMonitor monitor) {
		super.doSave(monitor);
		
		if ("".equals(fileLabel.getText())) {
			MessageDialog.openError(
					this.getSite().getShell(), 
					"Error Projecting a  Document", 
					"Please select a file to upload and project first"
			);
			this.markDirty();
			monitor.setCanceled(true);
			return;
		}

		//force commit to get fileName
		commit();
		
		boolean doIt = MessageDialog.openConfirm(
				DocumentMainPage.this.getSite().getShell(), 
				"Project New Data" , 
				"Are you sure you want process the data in "+DocumentMainPage.this.fileLabel.getText()+"?"
		);
		if (!doIt) { 
//			this.markDirty();
			monitor.setCanceled(true);
		}
		
	}
	
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
				DocumentMainPage.this.markDirty();
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
							DocumentMainPage.this.markDirty();
					}
		}
		public void dropAccept(DropTargetEvent event) {}
		
	}



	

}
