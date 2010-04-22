/*
 * Created on 27 oct. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.amalto.workbench.editors;

import java.awt.event.TextEvent;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.dialogs.PluginDetailsDialog;
import com.amalto.workbench.dialogs.ResourceSelectDialog;
import com.amalto.workbench.dialogs.XpathSelectDialog;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeObjectTransfer;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.proposal.ContentProposalAdapterExtended;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.EInputTemplate;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.WidgetUtils;
import com.amalto.workbench.utils.XmlUtil;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSGetServicesList;
import com.amalto.workbench.webservices.WSGetTransformerV2PKs;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRuleExpression;
import com.amalto.workbench.webservices.WSServiceGetDocument;
import com.amalto.workbench.webservices.WSServicesList;
import com.amalto.workbench.webservices.WSServicesListItem;
import com.amalto.workbench.webservices.WSString;
import com.amalto.workbench.webservices.WSTransformerV2PK;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;
import com.amalto.workbench.widgets.ConditionWidget;
import com.amalto.workbench.widgets.TisTableViewer;
import com.amalto.workbench.widgets.XpathWidget;

public class RoutingRuleMainPage extends AMainPageV2 {
	
	protected Text descriptionText;
	protected Text objectTypeText; //Concept
	protected Button isSynchronousButton;
	protected Combo serviceNameCombo;
	protected Text serviceParametersText;
	//protected ListViewer routingExpressionsViewer;
	protected XpathWidget xpathWidget;
	protected XpathWidget xpathWidget1;
	protected Button xpathButton;
	protected Combo operatorCombo;
	protected Text rightValueText; 
	protected Button defultParameterBtn;
	protected DropTarget windowTarget;
	
	protected boolean refreshing = false;
	protected boolean comitting = false;
	
	protected	TreeParent treeParent;
	
	private static String ROUTE_SERVICE = "amalto/local/service/";
	private String dataModelName;
	private Text conditionText;
	
    private ComplexTableViewerColumn[] conditionsColumns= new ComplexTableViewerColumn[]{
    		new ComplexTableViewerColumn("XPath", false, "newXPath", "newXPath", "",ComplexTableViewerColumn.XPATH_STYLE,new String[] {},0),
    		new ComplexTableViewerColumn("Operator", false, "", "", "",ComplexTableViewerColumn.COMBO_STYLE,IConstants.ROUTE_CONDITION_OPERATORS,0),
    		new ComplexTableViewerColumn("Value", false, "", ""),
    		new ComplexTableViewerColumn("Condition Id", false, "", "",true)
    };
    private TisTableViewer conditionViewer;
	private Button deactiveButton;
	ContentProposalAdapterExtended adapter;
    
    public String getDataModelName() {
		return dataModelName;
	}

	public void setDataModelName(String dataModelName) {
		this.dataModelName = dataModelName;
	}

	public RoutingRuleMainPage(FormEditor editor) {
        super(
        		editor,
        		RoutingRuleMainPage.class.getName(),
        		"Trigger "+((XObjectEditorInput)editor.getEditorInput()).getName()+
        		Util.getRevision((TreeObject)((XObjectEditorInput)editor.getEditorInput()).getModel())
        );
        //get Version information
        try {

        	 treeParent = this.getXObject().getParent();
      		if(treeParent==null){//if it is a new page,treeParent should be ROUTING_RULE
      			treeParent = this.getXObject().getServerRoot().findServerFolder(TreeObject.ROUTING_RULE);
      			} 
        } catch (Exception e) {/*no versioning support on old cores*/}                   
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
            descriptionText.addModifyListener(new ModifyListener() {
            	public void modifyText(ModifyEvent e) {
            		if (refreshing) return;
            		markDirtyWithoutCommit();
            	}
            }); 
//            Util.createCompDropTarget(descriptionText);
            //objectType

            
            Label objectTypeLabel = toolkit.createLabel(charComposite, "Entity", SWT.NULL);
            objectTypeLabel.setLayoutData(
                    new GridData(SWT.BEGINNING,SWT.CENTER,false,true,1,1)
            );
            Composite typeComposite = toolkit.createComposite(charComposite);
            typeComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            GridLayout layout=new GridLayout(2, false);
            layout.marginLeft=0;
            layout.marginWidth=0;
            typeComposite.setLayout(layout);
            
            objectTypeText =  toolkit.createText(typeComposite, "",SWT.BORDER|SWT.MULTI);
            objectTypeText.setLayoutData(
                    new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING,SWT.CENTER,false,false,1,1)
            );
            ((GridData)objectTypeText.getLayoutData()).widthHint = 300;
//            objectTypeText.setLocation(descriptionText.getLocation().x,descriptionText.getLocation().y+10);
            objectTypeText.addModifyListener(new ModifyListener() {
            	public void modifyText(ModifyEvent e) {
            		if (refreshing) return;
            		markDirtyWithoutCommit();
            	}
            });
            xpathButton = toolkit.createButton(typeComposite,"", SWT.PUSH);
            xpathButton.setImage(ImageCache.getCreatedImage(EImage.DOTS_BUTTON.getPath()));
            xpathButton.setToolTipText("Select an Entity");
            xpathButton.addSelectionListener(new SelectionListener(){

				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					XpathSelectDialog xpathDialog;
					xpathDialog = new XpathSelectDialog(getSite().getShell(),treeParent,"Select Entity",getSite(),false,dataModelName);
					xpathDialog.setBlockOnOpen(true);
					xpathDialog.open();
					if (xpathDialog.getReturnCode() == Window.OK)  {
						String xpath = xpathDialog.getXpath();
						int index = xpathDialog.getXpath().indexOf("/");
						if(index>0){
							xpath = xpathDialog.getXpath().substring(0, index);
						}
						objectTypeText.setText(xpath);
					}
				}
            	
            });
            // xpathWidget1 = new XpathWidget("...",treeParent, toolkit, charComposite,(AMainPageV2)RoutingRuleMainPage.this,false,false,dataModelName);
            
            //issynchronous Button
            isSynchronousButton = toolkit.createButton(charComposite, "Execute Synchronously", SWT.CHECK);
            isSynchronousButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            isSynchronousButton.addMouseListener(new MouseListener() {
            	public void mouseUp(MouseEvent e) {
             		//mark for need to save
            		markDirtyWithoutCommit();
            	}
            	public void mouseDoubleClick(MouseEvent e) {}
            	public void mouseDown(MouseEvent e) {}
            });       
            deactiveButton = toolkit.createButton(charComposite, "Deactive", SWT.CHECK);
            deactiveButton.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            deactiveButton.addMouseListener(new MouseListener() {
            	public void mouseUp(MouseEvent e) {
             		//mark for need to save
            		markDirtyWithoutCommit();
            	}
            	public void mouseDoubleClick(MouseEvent e) {}
            	public void mouseDown(MouseEvent e) {}
            });  
            //Routing Expressions            
            Composite serviceGroup = this.getNewSectionComposite("Service");
            serviceGroup.setLayout(new GridLayout(2,false));            
            //Service Name
            Label serviceNameLabel = toolkit.createLabel(serviceGroup,  "Service JNDI Name", SWT.NULL);
            serviceNameLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
            );
            
            Composite subPanel = toolkit.createComposite(serviceGroup);
            subPanel.setLayoutData( new GridData(SWT.LEFT,SWT.CENTER,false,true,1,1));
            subPanel.setLayout(new GridLayout(2,false));
            serviceNameCombo = new Combo(subPanel, SWT.DROP_DOWN|SWT.SINGLE|SWT.READ_ONLY);
            serviceNameCombo.setLayoutData(
                    new GridData(SWT.LEFT,SWT.CENTER,false,true,1,1)
            );
            ((GridData)serviceNameCombo.getLayoutData()).widthHint = 300;
            serviceNameCombo.addModifyListener(new ModifyListener() {
            	public void modifyText(ModifyEvent e) {
            		if (refreshing) return;
            		String serviceName = serviceNameCombo.getText();
            		String helpPara="";
            		if(!"".equals(serviceName)&&!serviceName.equals(null))
            			if(EInputTemplate.getXtentisObjexts().get(serviceName)!=null)
            				helpPara = EInputTemplate.getXtentisObjexts().get(serviceName).getContent();
            		else
            			helpPara = "";
            		serviceParametersText.setText(XmlUtil.formatXmlSource(helpPara));
            		markDirtyWithoutCommit();
            		initParamterProposal(serviceNameCombo.getText());
            	}
            }); 
           
	            WSServicesList list = Util.getPort(getXObject()).getServicesList(new WSGetServicesList(""));
	            WSServicesListItem[] items = list.getItem();
	            if (items!=null) {
    	            String[] sortedList = new String[items.length];
    	            for (int i = 0; i < items.length; i++) {
    	            	sortedList[i]=items[i].getJndiName();
    	            }
    	            Arrays.sort(sortedList);
	            	for (int i = 0; i < sortedList.length; i++) {
						serviceNameCombo.add(sortedList[i]);
					}
	            	//serviceNameCombo.add("");
	            }
            

            //default parameters button 
            defultParameterBtn = toolkit.createButton(subPanel, "", SWT.PUSH);
            defultParameterBtn.setImage(ImageCache.getCreatedImage(EImage.HELP_CONTENTS.getPath()));
            defultParameterBtn.setToolTipText("Help...");
            defultParameterBtn.setLayoutData( new GridData(SWT.FILL,SWT.FILL,false,true,1,1));
            defultParameterBtn.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		if(serviceNameCombo.getText().trim().length()==0) return;
            		String doc = "";
            		String desc="";
            		//WSRoutingRule wsObject = (WSRoutingRule) (getXObject().getWsObject());
            		try {
						XtentisPort port=Util.getPort(getXObject());
						WSServiceGetDocument document= port.getServiceDocument(new WSString(serviceNameCombo.getText().trim()));
						doc=document.getDocument();
						desc=document.getDescription();
					} catch (Exception e1) {
						doc = "N/A";
					}
					finally
					{
						showUpDialog(desc,doc);
					}
            	};
            	
            	private void showUpDialog(String desc,String doc)
            	{
        			final PluginDetailsDialog dialog = new PluginDetailsDialog(
        					getSite().getShell(),
        					desc,
        					doc,
        					null,
        					"Documentation"
        			);
        			dialog.addListener(new Listener() {
        				public void handleEvent(Event event) {dialog.close();}
        			});
        			dialog.create();
        			dialog.getShell().setText(serviceNameCombo.getText()+" Service Details");
        			dialog.setBlockOnOpen(true);
        			dialog.open();
            	}
            });
            
            //Service Parameters
            Label serviceParametersLabel = toolkit.createLabel(serviceGroup,  "Service Parameters", SWT.NULL);
            serviceParametersLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,false,true,2,1)
            );
            serviceParametersText = toolkit.createText(serviceGroup, "",SWT.BORDER|SWT.MULTI|SWT.V_SCROLL|SWT.WRAP);
            serviceParametersText.setLayoutData(    
                    new GridData(SWT.FILL,SWT.FILL,true,false,2,1)
            );
            ((GridData)serviceParametersText.getLayoutData()).widthHint = 200;
            ((GridData)serviceParametersText.getLayoutData()).heightHint = 120;
          	
            serviceParametersText.addModifyListener(new ModifyListener() {
            	public void modifyText(ModifyEvent e) {
            		if (refreshing) return;
            		markDirtyWithoutCommit();
            	}
            }); 
            //add by ymli.fix the bug:0011830. We can reuse the same ctrl+space in trigger configs.
			serviceParametersText.addKeyListener(new KeyListener() {

				public void keyReleased(KeyEvent event) {

					// System.out.println("SWT.CTRL:"+SWT.CTRL);
					int start = serviceParametersText.getSelection().x;
					int end = serviceParametersText.getSelection().y;
					if (event.stateMask == SWT.CTRL && event.keyCode == 17) {
						// if(event.keyCode == SWT.F2){
						ResourceSelectDialog dialog = new ResourceSelectDialog(
								getSite().getShell(),
								treeParent.getParent(),
								"Select a resource node", 
								ServerView.show().getSite());
						dialog.setBlockOnOpen(true);
						dialog.open();
						if (dialog.getReturnCode() == Window.OK ) {
							String xpath = dialog.getXpath();
							String textHead = serviceParametersText.getText(0,start - 1);
							String textEnd = serviceParametersText.getText(end,serviceParametersText.getText().length());
							serviceParametersText.setText(textHead + xpath+ textEnd);
							serviceParametersText.setSelection(start, start+ xpath.length());
							markDirtyWithoutCommit();
						}
					}
				}

				public void keyPressed(KeyEvent e) {
				}
			});			
            //Routing Expressions            
            Composite routingExpressionsGroup = this.getNewSectionComposite("Trigger xPath Expressions");
            routingExpressionsGroup.setLayout(new GridLayout(1,true));
            
           
            conditionsColumns[0].setColumnWidth(200);
            conditionsColumns[1].setColumnWidth(150);
            conditionsColumns[2].setColumnWidth(120);
            conditionsColumns[3].setColumnWidth(120);
            conditionViewer=new TisTableViewer(Arrays.asList(conditionsColumns),toolkit,routingExpressionsGroup);
            conditionViewer.setXpath(true);
            conditionViewer.setMainPage(this);
            conditionViewer.setAddMulti(true);
            conditionViewer.create();
            conditionViewer.setHeight(110);
            
            //and or not condition
            ConditionWidget conditionWidget=new ConditionWidget(routingExpressionsGroup,toolkit,this);
            conditionText=conditionWidget.getConditionText();
            conditionText.addModifyListener(new ModifyListener(){

    			public void modifyText(ModifyEvent e) {
    				// TODO Auto-generated method stub
    				if(!refreshing)
    				markDirtyWithoutCommit();
    			}
            	
            });

            wrap.Wrap(this, conditionViewer);
                        
            //make the Page window a DropTarget - we need to dispose it
            windowTarget = new DropTarget(this.getPartControl(), DND.DROP_MOVE);
            windowTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            windowTarget.addDropListener(new DCDropTargetListener());            
            refreshData();
            conditionText.addFocusListener(new FocusListener() {
				
				public void focusLost(FocusEvent e) {					
					//adapter.resetPosition();
				}
				
				public void focusGained(FocusEvent e) {					
					initConditionProposal();
				}
			});
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//createCharacteristicsContent
	private void initConditionProposal() {
		//add content proposal to conditions
		java.util.List<Line> lines=(java.util.List<Line> )conditionViewer.getViewer().getInput();
		java.util.List<String> proposals=new ArrayList<String>();
		for(Line line: lines) {
			String value= line.keyValues.get(3).value;
			if(value!=null && value.trim().length()>0)
				proposals.add(value);
		}
		adapter=WidgetUtils.addContentProposal(conditionText, (String[])proposals.toArray(new String[proposals.size()]), new char[] {' ','('});
        adapter.setPopupSize(new Point(120,100));
		
	}
	private void initParamterProposal(String jndi) {
		if("callprocess".equals(jndi)) {
			//add content proposal to paramter
			WSTransformerV2PK[] transformerPKs = null;
			try {				
				transformerPKs = Util.getPort(getXObject()).getTransformerV2PKs(new WSGetTransformerV2PKs("")).getWsTransformerV2PK();
			} catch (Exception e) {
				System.out.println("No Transformers");
			}
			java.util.List<String> proposals=new ArrayList<String>();
			if(transformerPKs!=null)
			for(WSTransformerV2PK pk: transformerPKs) {
					if(pk.getPk()!=null && pk.getPk().length()>0)
					proposals.add(pk.getPk());
			}
			ContentProposalAdapterExtended adapter=WidgetUtils.addContentProposal(serviceParametersText, (String[])proposals.toArray(new String[proposals.size()]), new char[] {' ','='});
	        adapter.setPopupSize(new Point(120,100));
		}		
	}
	protected void refreshData() {
		try {
			
			if (this.comitting) return;
			
			this.refreshing = true;
			
			WSRoutingRule wsRoutingRule = (WSRoutingRule) (getXObject().getWsObject());    				
			descriptionText.setText(wsRoutingRule.getDescription());
			isSynchronousButton.setSelection(wsRoutingRule.isSynchronous());
			if(wsRoutingRule.getDeactive()!=null)
			deactiveButton.setSelection(wsRoutingRule.getDeactive());
			//serviceNameText.setText(wsRoutingRule.getServiceJNDI().replaceFirst("amalto/local/service/", ""));
			serviceNameCombo.setText(wsRoutingRule.getServiceJNDI().replaceFirst("amalto/local/service/", ""));
			serviceParametersText.setText(wsRoutingRule.getParameters()==null? "" : wsRoutingRule.getParameters());
			objectTypeText.setText(wsRoutingRule.getConcept());
			//xpathWidget1.setText(wsRoutingRule.getConcept());
			
            java.util.List<Line> lines=new ArrayList<Line>();
            
            for(WSRoutingRuleExpression wc:wsRoutingRule.getWsRoutingRuleExpressions()){
				Line line=new Line(
						conditionsColumns,
						Util.convertRouteCondition(wc)
					);
				lines.add(line);
            }
            conditionViewer.getViewer().setInput(lines);

			if(wsRoutingRule.getCondition()!=null)
			conditionText.setText(wsRoutingRule.getCondition());
			this.refreshing = false;
            if(objectTypeText.getText().length()>0 && !objectTypeText.getText().equals("*")){           	
            	conditionViewer.setConceptName(objectTypeText.getText());
            }
			initParamterProposal(serviceNameCombo.getText());
			//initConditionProposal();
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error refreshing the page", "Error refreshing the page: "+e.getLocalizedMessage());
		}    	
	}
	
	protected void commit() {
		try {
			
			if (this.refreshing) return;
			
			this.comitting = true;
			
			WSRoutingRule ws = (WSRoutingRule) (getXObject().getWsObject());
			ws.setDescription(descriptionText.getText());
			ws.setConcept(objectTypeText.getText());

			ws.setServiceJNDI(serviceNameCombo.getText().contains("/") ? serviceNameCombo.getText() : "amalto/local/service/"+serviceNameCombo.getText());
			ws.setParameters("".equals(serviceParametersText.getText())? null : serviceParametersText.getText());
			ws.setSynchronous(isSynchronousButton.getSelection());
			ws.setDeactive(deactiveButton.getSelection());
			java.util.List<Line> lines=(java.util.List<Line>)conditionViewer.getViewer().getInput();
			java.util.List<WSRoutingRuleExpression> wclist=new ArrayList<WSRoutingRuleExpression>();
			for(Line item: lines){
				String[] values=new String[]{item.keyValues.get(0).value,
						item.keyValues.get(1).value,
						item.keyValues.get(2).value,
						item.keyValues.get(3).value};
				WSRoutingRuleExpression wc =Util.convertLineRoute(values);
				wclist.add(wc);
			}
			ws.setWsRoutingRuleExpressions(wclist.toArray(new WSRoutingRuleExpression[wclist.size()]));
			
			//WsRoutingRuleExpressions refreshed by viewer
			ws.setCondition(conditionText.getText());
			this.comitting = false;
			//refresh serverview
			ServerView view= ServerView.show();
			view.getViewer().refresh();
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error comtiting the page", "Error comitting the page: "+e.getLocalizedMessage());
		}    	
	}

	public void textChanged(TextEvent event) {
		markDirtyWithoutCommit();
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
				RoutingRuleMainPage.this.markDirtyWithoutCommit();
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
							RoutingRuleMainPage.this.markDirtyWithoutCommit();
					}
		}
		public void dropAccept(DropTargetEvent event) {}
		
	}
	
	private void createCompDropTarget() {
		DropTarget dropTarget = new DropTarget(serviceParametersText,  DND.DROP_MOVE|DND.DROP_LINK);
//		dropTarget.setTransfer(new ByteArrayTransfer[] { });
		dropTarget.setTransfer(new TreeObjectTransfer[] { TreeObjectTransfer.getInstance() });
		dropTarget.addDropListener(new DropTargetAdapter() {

			public void dragEnter(DropTargetEvent event) {
			}
			public void dragLeave(DropTargetEvent event) {
			}
			public void dragOver(DropTargetEvent event) {
				event.feedback |= DND.FEEDBACK_EXPAND | DND.FEEDBACK_SCROLL;
			}
			
			public void drop(DropTargetEvent event) {
				if (event.data instanceof TreeObject[])
					if(((TreeObject[])event.data)[0].getType()==TreeObject.TRANSFORMER)
						serviceParametersText.setText(serviceParametersText.getText().replace("?","")+ ((TreeObject[])event.data)[0].getDisplayName());	
					else
						serviceParametersText.setText(serviceParametersText.getText()+((TreeObject[])event.data)[0].getDisplayName());	
			}
		});
		
	}
	  
	@Override
	public boolean beforeDoSave() {
		if(serviceNameCombo.getText()==null||serviceNameCombo.getText().length()==0){
			MessageDialog.openError(this.getSite().getShell(), "Error saving", "Service JNDI Name cannot be null");
			return false;
		}
		else
			return true;
	}

	@Override
	protected void createActions() {
		// TODO Auto-generated method stub
		
	}	

}
