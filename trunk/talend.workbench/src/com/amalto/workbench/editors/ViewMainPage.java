/*
 * Created on 27 oct. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.amalto.workbench.editors;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.webservices.WSStringPredicate;
import com.amalto.workbench.webservices.WSView;
import com.amalto.workbench.webservices.WSWhereCondition;
import com.amalto.workbench.webservices.WSWhereOperator;
import com.amalto.workbench.widgets.DescAnnotationComposite;
import com.amalto.workbench.widgets.XpathWidget;

public class ViewMainPage extends AMainPageV2 implements ITextListener{
    
	protected Text viewableBEText;
	protected List viewableBEsList;
	protected Text searchableBEText;
	protected List searchableBEsList;
//	protected Text leftText;
	protected Combo operatorCombo;
	protected Text rightText;
	protected Combo predicateCombo;
	protected ListViewer wcListViewer;
	protected Button wcButton;
    protected TreeParent treeParent;
	protected DescAnnotationComposite desAntionComposite ;
	protected DropTarget windowTarget;
	
	protected XpathWidget xpathWidget0;
	protected XpathWidget xpathWidget1;
	protected XpathWidget xpathWidget2;
	private boolean refreshing = false;
	private boolean comitting = false;
	
    public ViewMainPage(FormEditor editor) {
        super(
        		editor,
        		ViewMainPage.class.getName(),
        		"View "+((XObjectEditorInput)editor.getEditorInput()).getName()
        );     
       this.treeParent = this.getXObject().getParent();
    }
   
	protected void createCharacteristicsContent(FormToolkit toolkit, Composite charComposite) {
		
        try {
        	desAntionComposite = new DescAnnotationComposite("Description" ," ...", toolkit, charComposite, (AMainPageV2)this);
            //make the Page window a DropTarget - we need to dispose it
            windowTarget = new DropTarget(this.getPartControl(), DND.DROP_MOVE);
            windowTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            windowTarget.addDropListener(new DCDropTargetListener());
            
            /****
            /viewable Business Elements
            ****/
            Composite vbeGroup = this.getNewSectionComposite("Viewable Business Elements");
            vbeGroup.setLayout(new GridLayout(2,false));
            
            Composite vbeComposite = toolkit.createComposite(vbeGroup,SWT.NONE);
            vbeComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            vbeComposite.setLayout(new GridLayout(2,false));

           
            /**
             * add by lym
             */
//           if this view is a new one,the treeParent should be null,so the treeParent should be get this way
            if(this.treeParent==null){
            	TreeObject tb = (TreeObject)((XObjectEditorInput)this.getEditorInput()).getModel();
                if (tb.getParent() == null) {
                	if (tb.getType() != TreeObject.DOCUMENT) {
                		treeParent = tb.findServerFolder(tb.getType());
                	}
                }
            }
                        
            xpathWidget0 = new XpathWidget("...",treeParent, toolkit, vbeComposite, (AMainPageV2)this,false);
            
            Button addVBEButton = toolkit.createButton(vbeComposite,"Add",SWT.PUSH | SWT.CENTER);
            addVBEButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            addVBEButton.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(
						org.eclipse.swt.events.SelectionEvent e) {
				};

				public void widgetSelected(
						org.eclipse.swt.events.SelectionEvent e) {
					if (!"".equals(ViewMainPage.this.xpathWidget0.getText()))
						ViewMainPage.this.viewableBEsList.add(ViewMainPage.this.xpathWidget0.getText());
					ViewMainPage.this.xpathWidget0.setText("");
					ViewMainPage.this.viewableBEsList.select(ViewMainPage.this.viewableBEsList.getItemCount() - 1);
					ViewMainPage.this.viewableBEsList.forceFocus();
					markDirty();

				};
			});
            
            viewableBEsList = new List(vbeComposite,SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
            viewableBEsList.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            ((GridData)viewableBEsList.getLayoutData()).heightHint = 100;
            
            /*DragSource vbeSource = new DragSource(viewableBEsList,DND.DROP_MOVE);
            vbeSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            vbeSource.addDragListener(new DCDragSourceListener());*/
            
            viewableBEsList.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					if ((e.stateMask==0) && (e.character == SWT.DEL) && (ViewMainPage.this.viewableBEsList.getSelectionIndex()>=0)) {
						ViewMainPage.this.viewableBEsList.remove(ViewMainPage.this.viewableBEsList.getSelectionIndex());
	            		markDirty();
					}
				}
            });
            viewableBEsList.addMouseListener(new MouseListener(){
            	public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
            		int index = ViewMainPage.this.viewableBEsList.getSelectionIndex();
            		ViewMainPage.this.xpathWidget0.setText(ViewMainPage.this.viewableBEsList.getItem(index));
					ViewMainPage.this.viewableBEsList.remove(index);
            		markDirty();
            	}
            	public void mouseDown(MouseEvent e) {}
            	public void mouseUp(MouseEvent e) {}
            });
            
            Composite vbeUpDownComposite = toolkit.createComposite(vbeComposite,SWT.NONE);
            vbeUpDownComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            vbeUpDownComposite.setLayout(new GridLayout(1,false));
            
            Button upVBEButton = toolkit.createButton(vbeUpDownComposite,"Up",SWT.PUSH | SWT.CENTER);
            upVBEButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            upVBEButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		int index =ViewMainPage.this.viewableBEsList.getSelectionIndex();
            		if (index>0) {
            			String val = ViewMainPage.this.viewableBEsList.getItem(index);
            			ViewMainPage.this.viewableBEsList.remove(index);
            			ViewMainPage.this.viewableBEsList.add(val, index-1);
            			ViewMainPage.this.viewableBEsList.select(index-1);
            			ViewMainPage.this.viewableBEsList.forceFocus();
                		markDirty();
            		}
            	};
            });
            Button downVBEButton = toolkit.createButton(vbeUpDownComposite,"Down",SWT.PUSH | SWT.CENTER);
            downVBEButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            downVBEButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		int index =ViewMainPage.this.viewableBEsList.getSelectionIndex();
            		if ((index>=0) && (index < ViewMainPage.this.viewableBEsList.getItemCount()-1)) {
            			String val = ViewMainPage.this.viewableBEsList.getItem(index);
            			ViewMainPage.this.viewableBEsList.remove(index);
            			ViewMainPage.this.viewableBEsList.add(val, index+1);
            			ViewMainPage.this.viewableBEsList.select(index+1);
            			ViewMainPage.this.viewableBEsList.forceFocus();
                		markDirty();
            		}
            	};
            });

            
            //Searchable Business Elements
            
            Composite sbeGroup = this.getNewSectionComposite("Searchable Business Elements");
            sbeGroup.setLayout(new GridLayout(1,true));
            
            Composite sbeComposite = toolkit.createComposite(sbeGroup, SWT.BORDER);
            sbeComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            sbeComposite.setLayout(new GridLayout(2,false));
            Label searchableLabel = toolkit.createLabel(sbeComposite, "Searchable", SWT.NULL);
            searchableLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
            );
            Button addSBEButton = toolkit.createButton(sbeComposite,"Add",SWT.PUSH | SWT.TRAIL);
            
            xpathWidget1 = new XpathWidget("...",treeParent, toolkit, sbeComposite, (AMainPageV2)this,true);
            addSBEButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            addSBEButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            	if(!"".equals(ViewMainPage.this.xpathWidget1.getText()))
            		 ViewMainPage.this.searchableBEsList.add(ViewMainPage.this.xpathWidget1.getText());
            	ViewMainPage.this.xpathWidget1.setText("");
            		markDirty();
            	};
            });
            searchableBEsList = new List(sbeComposite,SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
            searchableBEsList.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
            );
            ((GridData)searchableBEsList.getLayoutData()).heightHint = 100;
            
            /*DragSource sbeSource = new DragSource(searchableBEsList,DND.DROP_MOVE);
            sbeSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            sbeSource.addDragListener(new DCDragSourceListener());*/
            
            searchableBEsList.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					if ((e.stateMask==0) && (e.character == SWT.DEL) && (ViewMainPage.this.searchableBEsList.getSelectionIndex()>=0)) {
						ViewMainPage.this.searchableBEsList.remove(ViewMainPage.this.searchableBEsList.getSelectionIndex());
	            		markDirty();
					}
				}
            });
            
            //Where Conditions
            Composite wcGroup = this.getNewSectionComposite("Where Conditions");
            wcGroup.setLayout(new GridLayout(5,false));
            
            wcButton = toolkit.createButton(wcGroup,"Add",SWT.PUSH | SWT.TRAIL);
            wcButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            wcButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		addWhereCondition();
            	};
            });
            
            xpathWidget2 = new XpathWidget("...",treeParent, toolkit, wcGroup, (AMainPageV2)this,true);
            
            operatorCombo = new Combo(wcGroup,SWT.READ_ONLY |SWT.DROP_DOWN|SWT.SINGLE);
            operatorCombo.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
            );
            operatorCombo.add("Contains");
            operatorCombo.add("Contains Text Of");
            operatorCombo.add("Starts With");
            operatorCombo.add("Strict Contains");
            operatorCombo.add("=");
            operatorCombo.add("!=");
            operatorCombo.add(">");
            operatorCombo.add(">=");
            operatorCombo.add("<");
            operatorCombo.add("<=");
            operatorCombo.select(0);
            operatorCombo.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(SelectionEvent e) {}
            	public void widgetSelected(SelectionEvent e) {
            		if ("Contains".equals(ViewMainPage.this.operatorCombo.getText())) {
            			ViewMainPage.this.predicateCombo.setEnabled(true);
            		} else {
            			ViewMainPage.this.predicateCombo.select(0);
            			ViewMainPage.this.predicateCombo.setEnabled(false);
            		}
            	}
            });
            
            rightText = toolkit.createText(wcGroup, "",SWT.BORDER|SWT.SINGLE);
            rightText.setLayoutData(    
                    new GridData(SWT.FILL,SWT.CENTER,true,true,1,1)
            );
            
            rightText.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					if ((e.stateMask==0) && (e.character == SWT.CR)){
	            		addWhereCondition();
					}
				}
            });
            predicateCombo = new Combo(wcGroup,SWT.READ_ONLY |SWT.DROP_DOWN|SWT.SINGLE);
            predicateCombo.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
            );
            predicateCombo.add("");
            predicateCombo.add("Or");
            predicateCombo.add("And");
            predicateCombo.add("Strict And");
            predicateCombo.add("Exactly");
            predicateCombo.add("Not");
            
            wcListViewer = new ListViewer(wcGroup,SWT.BORDER);
            wcListViewer.getControl().setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,5,1)
            );
            ((GridData)wcListViewer.getControl().getLayoutData()).minimumHeight = 100;
            wcListViewer.setContentProvider(new IStructuredContentProvider() {
				public void dispose() {}
				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
				public Object[] getElements(Object inputElement) {
					return 
						((WSView) inputElement).getWhereConditions() == null ? 
								new WSWhereCondition[0] : 
								((WSView) inputElement).getWhereConditions();
				}
            });
            wcListViewer.setLabelProvider(new ILabelProvider() {
				public Image getImage(Object element) {return null;}
				public String getText(Object element) {
					WSWhereCondition wc = (WSWhereCondition) element;
					String text = wc.getLeftPath()+" ";
					if (wc.getOperator().equals(WSWhereOperator.CONTAINS)) text+="Contains";
					else if (wc.getOperator().equals(WSWhereOperator.EQUALS)) text+="=";
					else if (wc.getOperator().equals(WSWhereOperator.GREATER_THAN)) text+=">";
					else if (wc.getOperator().equals(WSWhereOperator.GREATER_THAN_OR_EQUAL)) text+=">=";
					else if (wc.getOperator().equals(WSWhereOperator.JOIN)) text+="Contains Text Of";
					else if (wc.getOperator().equals(WSWhereOperator.LOWER_THAN)) text+="<";
					else if (wc.getOperator().equals(WSWhereOperator.LOWER_THAN_OR_EQUAL)) text+="<=";
					else if (wc.getOperator().equals(WSWhereOperator.NOT_EQUALS)) text+="!=";
					else if (wc.getOperator().equals(WSWhereOperator.STARTSWITH)) text+="Starts With";
					else if (wc.getOperator().equals(WSWhereOperator.STRICTCONTAINS)) text+="Strict Contains";
					text+=" ";
					if (!wc.getOperator().equals(WSWhereOperator.JOIN)) text+="\"";
					text+=wc.getRightValueOrPath();
					if (!wc.getOperator().equals(WSWhereOperator.JOIN)) text+="\"";
					text+=" ";
					if (wc.getStringPredicate().equals(WSStringPredicate.AND)) text+="[and]";
					else if (wc.getStringPredicate().equals(WSStringPredicate.EXACTLY)) text+="[exactly]";
					else if (wc.getStringPredicate().equals(WSStringPredicate.NONE)) text+="";
					else if (wc.getStringPredicate().equals(WSStringPredicate.NOT)) text+="[not]";
					else if (wc.getStringPredicate().equals(WSStringPredicate.OR)) text+="[or]";
					else if (wc.getStringPredicate().equals(WSStringPredicate.STRICTAND)) text+="[strict and]";
					return text;
				}
				public void addListener(ILabelProviderListener listener) {}
				public void dispose() {}
				public boolean isLabelProperty(Object element, String property) {return false;}
				public void removeListener(ILabelProviderListener listener) {}
            });
            
            /*DragSource wcSource = new DragSource(wcListViewer.getControl(),DND.DROP_MOVE);
            wcSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            wcSource.addDragListener(new WCDragSourceListener());*/
            
            wcListViewer.getControl().addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					if ((e.stateMask==0) && (e.character == SWT.DEL)) {
						WSView wsObject = (WSView) (ViewMainPage.this.getXObject().getWsObject());
						IStructuredSelection selection = (IStructuredSelection)ViewMainPage.this.wcListViewer.getSelection();
						if (selection.getFirstElement()!=null) {
							WSWhereCondition wc = (WSWhereCondition) selection.getFirstElement();
							ArrayList<WSWhereCondition> wcList = new ArrayList<WSWhereCondition>(Arrays.asList(wsObject.getWhereConditions()));
							wcList.remove(wc);
							wsObject.setWhereConditions(wcList.toArray(new WSWhereCondition[wcList.size()]));
							ViewMainPage.this.wcListViewer.refresh();
							ViewMainPage.this.markDirty();
						}
					}
				}
            });
            
            refreshData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//createCharacteristicsContent


	protected void refreshData() {
		try {
			
			if (this.comitting) return;
			
			this.refreshing = true;
			
			WSView wsObject = (WSView) (getXObject().getWsObject());    	
			desAntionComposite.setText(wsObject.getDescription()==null ? "" : wsObject.getDescription());
//            descriptionText.setText(wsObject.getDescription()==null ? "" : wsObject.getDescription());
	    	
            viewableBEsList.removeAll();
            String[] vbes = wsObject.getViewableBusinessElements();
            if (vbes != null)  {
            	for (int i = 0; i < vbes.length; i++) {
					viewableBEsList.add(vbes[i]);
				}
            }

            searchableBEsList.removeAll();
            String[] sbes = wsObject.getSearchableBusinessElements();
            if (sbes != null)  {
            	for (int i = 0; i < sbes.length; i++) {
					searchableBEsList.add(sbes[i]);
				}
            }

            wcListViewer.setInput(wsObject);
            wcListViewer.refresh();
            
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
			
	    	WSView wsObject = (WSView) (getXObject().getWsObject());
			wsObject.setDescription(desAntionComposite.getText());
			wsObject.setViewableBusinessElements(viewableBEsList.getItems());
			wsObject.setSearchableBusinessElements(searchableBEsList.getItems());
			//wsObject.setWhereConditions() //automatically refreshed by the viewer
			
			this.comitting = false;
			
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error comtiting the page", "Error comitting the page: "+e.getLocalizedMessage());
		}    	
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
	
	protected void addWhereCondition() {
		if (xpathWidget2.getText().trim().equals("")
				|| rightText.getText().equals("")) {
			return;
		}
  		markDirty();
		WSWhereCondition wc = new WSWhereCondition();
//		wc.setLeftPath(ViewMainPage.this.leftText.getText());
		if(!"".equals(ViewMainPage.this.xpathWidget2.getText()))
				wc.setLeftPath(ViewMainPage.this.xpathWidget2.getText());
		ViewMainPage.this.xpathWidget2.setText("");
		WSWhereOperator operator=null;
		if (ViewMainPage.this.operatorCombo.getText().equals("Contains")) operator = WSWhereOperator.CONTAINS;
		else if (ViewMainPage.this.operatorCombo.getText().equals("Contains Text Of")) operator = WSWhereOperator.JOIN;
		else if (ViewMainPage.this.operatorCombo.getText().equals("=")) operator = WSWhereOperator.EQUALS;
		else if (ViewMainPage.this.operatorCombo.getText().equals(">")) operator = WSWhereOperator.GREATER_THAN;
		else if (ViewMainPage.this.operatorCombo.getText().equals(">=")) operator = WSWhereOperator.GREATER_THAN_OR_EQUAL;
		else if (ViewMainPage.this.operatorCombo.getText().equals("<")) operator = WSWhereOperator.LOWER_THAN;
		else if (ViewMainPage.this.operatorCombo.getText().equals("<=")) operator = WSWhereOperator.LOWER_THAN_OR_EQUAL;
		else if (ViewMainPage.this.operatorCombo.getText().equals("!=")) operator = WSWhereOperator.NOT_EQUALS;
		else if (ViewMainPage.this.operatorCombo.getText().equals("Starts With")) operator = WSWhereOperator.STARTSWITH;
		else if (ViewMainPage.this.operatorCombo.getText().equals("Strict Contains")) operator = WSWhereOperator.STRICTCONTAINS;
		wc.setOperator(operator);
		wc.setRightValueOrPath(ViewMainPage.this.rightText.getText());
		WSStringPredicate predicate = null;
		if (ViewMainPage.this.predicateCombo.getText().equals("")) predicate = WSStringPredicate.NONE;
		else if (ViewMainPage.this.predicateCombo.getText().equals("Or")) predicate = WSStringPredicate.OR;
		if (ViewMainPage.this.predicateCombo.getText().equals("And")) predicate = WSStringPredicate.AND;
		if (ViewMainPage.this.predicateCombo.getText().equals("Strict And")) predicate = WSStringPredicate.STRICTAND;
		if (ViewMainPage.this.predicateCombo.getText().equals("Exactly")) predicate = WSStringPredicate.EXACTLY;
		if (ViewMainPage.this.predicateCombo.getText().equals("Not")) predicate = WSStringPredicate.NOT;
		wc.setStringPredicate(predicate);
		WSView wsObject = (WSView)ViewMainPage.this.getXObject().getWsObject();
		ArrayList<WSWhereCondition> wcList = new ArrayList<WSWhereCondition>(Arrays.asList(wsObject.getWhereConditions()));
		wcList.add(wc);
		wsObject.setWhereConditions(wcList.toArray(new WSWhereCondition[wcList.size()]));
		ViewMainPage.this.wcListViewer.refresh();
		rightText.setText("");
	}
	
	//description text listener
	public void modifyText(ModifyEvent e) {
		if (this.refreshing) return;
		super.modifyText(e);
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
				ViewMainPage.this.markDirty();
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
							ViewMainPage.this.markDirty();
					}
		}
		public void dropAccept(DropTargetEvent event) {}
		
	}
	
	/**
	 * Where Condition Drag
	 *
	 */	
	class WCDragSourceListener implements DragSourceListener {

		public void dragFinished(DragSourceEvent event) {
			WSView wsObject = (WSView) (ViewMainPage.this.getXObject().getWsObject());
			IStructuredSelection selection = (IStructuredSelection)ViewMainPage.this.wcListViewer.getSelection();
			if (selection.getFirstElement()!=null) {
				WSWhereCondition wc = (WSWhereCondition) selection.getFirstElement();
				ArrayList<WSWhereCondition> wcList = new ArrayList<WSWhereCondition>(Arrays.asList(wsObject.getWhereConditions()));
				wcList.remove(wc);
				wsObject.setWhereConditions(wcList.toArray(new WSWhereCondition[wcList.size()]));
				ViewMainPage.this.wcListViewer.refresh();
				ViewMainPage.this.markDirty();
			}
		}

		public void dragSetData(DragSourceEvent event) {
			IStructuredSelection selection = (IStructuredSelection)ViewMainPage.this.wcListViewer.getSelection();
			if (selection.getFirstElement()!=null) {
					event.data =  selection.getFirstElement();
			}
		}

		public void dragStart(DragSourceEvent event) {
			IStructuredSelection selection = (IStructuredSelection)ViewMainPage.this.wcListViewer.getSelection();
			event.doit = (selection.getFirstElement()!=null);
		}

	}
}
