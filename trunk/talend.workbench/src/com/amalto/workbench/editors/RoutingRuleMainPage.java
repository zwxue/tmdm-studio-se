/*
 * Created on 27 oct. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.amalto.workbench.editors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.dialogs.PluginDetailsDialog;
import com.amalto.workbench.dialogs.XpathSelectDialog;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.EImage;
import com.amalto.workbench.utils.ImageCache;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.Version;
import com.amalto.workbench.webservices.WSGetServicesList;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRuleExpression;
import com.amalto.workbench.webservices.WSRoutingRuleOperator;
import com.amalto.workbench.webservices.WSServiceGetDocument;
import com.amalto.workbench.webservices.WSServicesList;
import com.amalto.workbench.webservices.WSServicesListItem;
import com.amalto.workbench.webservices.WSString;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.XpathWidget;

public class RoutingRuleMainPage extends AMainPageV2 {
	
	protected Text descriptionText;
	protected Text objectTypeText; //Concept
	protected Button isSynchronousButton;
	protected Combo serviceNameCombo;
	protected Text serviceParametersText;
	protected ListViewer routingExpressionsViewer;
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
	protected boolean version_greater_than_2_17_0 = false;
	
	private static String ROUTE_SERVICE = "amalto/local/service/";
	private String dataModelName;
	private Text conditionText;
	
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
        		"RoutingRule "+((XObjectEditorInput)editor.getEditorInput()).getName()
        );
        //get Version information
        try {
        	Version ver = Util.getVersion(getXObject());
        	version_greater_than_2_17_0 = (
        			(ver.getMajor()>2) ||
        			((ver.getMajor()==2)&&(ver.getMinor()>=17))
        	);
        	
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
                    new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
            );
            descriptionText = toolkit.createText(charComposite, "",SWT.BORDER|SWT.SINGLE);
            descriptionText.setLayoutData(    
                    new GridData(SWT.FILL,SWT.FILL,true,false,1,1)
            );
            descriptionText.addModifyListener(new ModifyListener() {
            	public void modifyText(ModifyEvent e) {
            		if (refreshing) return;
            		markDirty();
            	}
            }); 
            
            //objectType
            Composite typeComposite = toolkit.createComposite(charComposite);
            typeComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
            );
            typeComposite.setLayout(new GridLayout(3,false));
            
            Label objectTypeLabel = toolkit.createLabel(typeComposite, "Concept         ", SWT.NULL);
            objectTypeLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
            );
            objectTypeText =  toolkit.createText(typeComposite, "",SWT.BORDER|SWT.SINGLE);
            objectTypeText.setLayoutData(
                    new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING,SWT.CENTER,false,false,1,1)
            );
            ((GridData)objectTypeText.getLayoutData()).widthHint = 300;
//            objectTypeText.setLocation(descriptionText.getLocation().x,descriptionText.getLocation().y+10);
            objectTypeText.addModifyListener(new ModifyListener() {
            	public void modifyText(ModifyEvent e) {
            		if (refreshing) return;
            		markDirty();
            	}
            });
            xpathButton = toolkit.createButton(typeComposite,"...", SWT.PUSH);
            xpathButton.setToolTipText("select a concept");
            xpathButton.addSelectionListener(new SelectionListener(){

				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					XpathSelectDialog xpathDialog;
					xpathDialog = new XpathSelectDialog(getSite().getShell(),treeParent,"Select Concept",getSite(),false,dataModelName);
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
                    new GridData(SWT.FILL,SWT.FILL,false,true,2,1)
            );
            isSynchronousButton.addMouseListener(new MouseListener() {
            	public void mouseUp(MouseEvent e) {
             		//mark for need to save
            		markDirty();
            	}
            	public void mouseDoubleClick(MouseEvent e) {}
            	public void mouseDown(MouseEvent e) {}
            });
            
            //Service Name
            Label serviceNameLabel = toolkit.createLabel(charComposite,  "Service JNDI Name", SWT.NULL);
            serviceNameLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
            );
            
            Composite subPanel = toolkit.createComposite(charComposite);
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
            		markDirty();
            	}
            }); 
            if (version_greater_than_2_17_0) {
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
            }

            //default parameters button 
            defultParameterBtn = toolkit.createButton(subPanel, "Help", SWT.PUSH);
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
        					null
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
            /*
            serviceNameText = toolkit.createText(charComposite, "",SWT.BORDER|SWT.SINGLE);
            serviceNameText.setLayoutData(    
                    new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING,SWT.FILL,false,false,1,1)
            );
            ((GridData)serviceNameText.getLayoutData()).widthHint = 300;
            serviceNameText.addModifyListener(new ModifyListener() {
            	public void modifyText(ModifyEvent e) {
            		if (refreshing) return;
            		markDirty();
            	}
            });
            */ 
            
            //Service Parameters
            Label serviceParametersLabel = toolkit.createLabel(charComposite,  "Service Parameters", SWT.NULL);
            serviceParametersLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,false,true,2,1)
            );
            serviceParametersText = toolkit.createText(charComposite, "",SWT.BORDER|SWT.MULTI|SWT.V_SCROLL);
            serviceParametersText.setLayoutData(    
                    new GridData(SWT.FILL,SWT.FILL,true,false,2,1)
            );
            ((GridData)serviceParametersText.getLayoutData()).widthHint = 200;
            ((GridData)serviceParametersText.getLayoutData()).heightHint = 80;
            serviceParametersText.addModifyListener(new ModifyListener() {
            	public void modifyText(ModifyEvent e) {
            		if (refreshing) return;
            		markDirty();
            	}
            }); 

            
            //Routing Expressions            
            Composite routingExpressionsGroup = this.getNewSectionComposite("Routing Rule xPath Expressions");
            routingExpressionsGroup.setLayout(new GridLayout(1,true));
            
            //Object Combo and is Admin Button
            Composite routingExpressionsComposite = toolkit.createComposite(routingExpressionsGroup, SWT.NULL);
            routingExpressionsComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            routingExpressionsComposite.setLayout(new GridLayout(4,false));
            
            //header line
            Label blankLabel = toolkit.createLabel(routingExpressionsComposite,  "", SWT.NULL);
            blankLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            Label xPathLabel = toolkit.createLabel(routingExpressionsComposite,  "       xPath(*)", SWT.NULL);
            xPathLabel.setForeground(new Color(null, 255,0,0));
            xPathLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            Label operatorLabel = toolkit.createLabel(routingExpressionsComposite,  "Operator", SWT.NULL);
            operatorLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            Label rightValueLabel = toolkit.createLabel(routingExpressionsComposite,  "Value(*)", SWT.NULL);
            rightValueLabel.setForeground(new Color(null, 255,0,0));
            rightValueLabel.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
            );
            
            //second line
            
            //add button
            Button addButton = toolkit.createButton(routingExpressionsComposite,"Add",SWT.PUSH | SWT.TRAIL);
            addButton.setLayoutData(
                    new GridData(SWT.LEFT,SWT.FILL,false,true,1,1)
            );
            addButton.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
            	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
            		addRoutingRuleExpression();
            		dataModelName=xpathWidget.getDataModelName();
            	};
            });
            //xPathWidget
            xpathWidget = new XpathWidget("...",treeParent, toolkit, routingExpressionsComposite,(AMainPageV2)RoutingRuleMainPage.this,true,false,dataModelName);
            //operator
            operatorCombo = new Combo(routingExpressionsComposite,SWT.READ_ONLY |SWT.DROP_DOWN|SWT.SINGLE);
            operatorCombo.setLayoutData(
                    new GridData(SWT.FILL,SWT.CENTER,false,true,1,1)
            );
            operatorCombo.add("Contains");
            operatorCombo.add("Matches");
            operatorCombo.add("Starts With");
            operatorCombo.add("=");
            operatorCombo.add("!=");
            operatorCombo.add(">");
            operatorCombo.add(">=");
            operatorCombo.add("<");
            operatorCombo.add("<=");
            operatorCombo.add("Is Null");
            operatorCombo.add("Is Not Null");
            operatorCombo.select(0);
            operatorCombo.addSelectionListener(new SelectionListener() {
            	public void widgetDefaultSelected(SelectionEvent e) {}
            	public void widgetSelected(SelectionEvent e) {
            	}
            });
            
            rightValueText = toolkit.createText(routingExpressionsComposite, "",SWT.BORDER|SWT.SINGLE);
            rightValueText.setLayoutData(    
                    new GridData(SWT.FILL,SWT.CENTER,true,true,1,1)
            );
            rightValueText.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					if ((e.stateMask==0) && (e.character == SWT.CR)){
	            		addRoutingRuleExpression();
					}
				}
            });
            
            
            routingExpressionsViewer = new ListViewer(routingExpressionsComposite,SWT.BORDER | SWT.MULTI);
            routingExpressionsViewer.getControl().setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,5,1)
            );
            ((GridData)routingExpressionsViewer.getControl().getLayoutData()).minimumHeight = 100;
            routingExpressionsViewer.setContentProvider(new IStructuredContentProvider() {
				public void dispose() {}
				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
				public Object[] getElements(Object inputElement) {
					return 
						((WSRoutingRule) inputElement).getWsRoutingRuleExpressions() == null ? 
								new WSRoutingRuleExpression[0] :
								((WSRoutingRule) inputElement).getWsRoutingRuleExpressions();
				}
            });
            routingExpressionsViewer.setLabelProvider(new ILabelProvider() {
				public Image getImage(Object element) {return null;}
				public String getText(Object element) {
					WSRoutingRuleExpression rre = (WSRoutingRuleExpression) element;
					String text = rre.getXpath()+" ";
					if (rre.getWsOperator().equals(WSRoutingRuleOperator.CONTAINS)) text+="Contains";
					else if (rre.getWsOperator().equals(WSRoutingRuleOperator.MATCHES)) text+="Matches";
					else if (rre.getWsOperator().equals(WSRoutingRuleOperator.STARTSWITH)) text+="Starts With";
					else if (rre.getWsOperator().equals(WSRoutingRuleOperator.EQUALS)) text+="=";
					else if (rre.getWsOperator().equals(WSRoutingRuleOperator.GREATER_THAN)) text+=">";
					else if (rre.getWsOperator().equals(WSRoutingRuleOperator.GREATER_THAN_OR_EQUAL)) text+=">=";
					else if (rre.getWsOperator().equals(WSRoutingRuleOperator.LOWER_THAN)) text+="<";
					else if (rre.getWsOperator().equals(WSRoutingRuleOperator.LOWER_THAN_OR_EQUAL)) text+="<=";
					else if (rre.getWsOperator().equals(WSRoutingRuleOperator.NOT_EQUALS)) text+="!=";
					else if (rre.getWsOperator().equals(WSRoutingRuleOperator.IS_NULL)) text+="Is Null";
					else if (rre.getWsOperator().equals(WSRoutingRuleOperator.IS_NOT_NULL)) text+="Is Not Null";
					text+=" ";
					text+="\"" + rre.getValue() + "\"";
					return text;
				}
				public void addListener(ILabelProviderListener listener) {}
				public void dispose() {}
				public boolean isLabelProperty(Object element, String property) {return false;}
				public void removeListener(ILabelProviderListener listener) {}
            });
            routingExpressionsViewer.addDoubleClickListener(new IDoubleClickListener(){

				public void doubleClick(DoubleClickEvent event) {
					int index=routingExpressionsViewer.getList().getSelectionIndex();
					if(index!=-1){
						String condition=conditionText.getText()+" C"+index;
						conditionText.setText(condition);
						conditionText.setFocus();
						markDirty();
					}
				}            	
            });
            //+ x button
            Composite xComposite = toolkit.createComposite(routingExpressionsGroup, SWT.NULL);
            xComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            xComposite.setLayout(new GridLayout(2,false));
            Button btnAdd=toolkit.createButton(xComposite, "", SWT.PUSH);
            btnAdd.setLayoutData(
                    new GridData(SWT.LEFT,SWT.FILL,false,true,1,1)
            );
            btnAdd.setImage(ImageCache.getCreatedImage(EImage.ADD_OBJ.getPath()));
            btnAdd.setToolTipText("Add the selected item to condition");
            btnAdd.addSelectionListener(new SelectionListener(){

				public void widgetDefaultSelected(SelectionEvent e) {					
					
				}

				public void widgetSelected(SelectionEvent e) {
					int index=routingExpressionsViewer.getList().getSelectionIndex();
					if(index!=-1){
						String condition=conditionText.getText()+" C"+index;
						conditionText.setText(condition);
						conditionText.forceFocus();
						markDirty();
					}
				}            	
            });
            
            Button minusButton=toolkit.createButton(xComposite, "", SWT.PUSH);
            minusButton.setLayoutData(
                    new GridData(SWT.LEFT,SWT.FILL,false,true,1,1)
            );
            minusButton.setImage(ImageCache.getCreatedImage(EImage.DELETE_OBJ.getPath()));
            minusButton.setToolTipText("Remove the selected item from list");
            minusButton.addSelectionListener(new SelectionListener(){

				public void widgetDefaultSelected(SelectionEvent e) {					
					
				}

				public void widgetSelected(SelectionEvent e) {
					int index=routingExpressionsViewer.getList().getSelectionIndex();
					if(index!=-1){
						routingExpressionsViewer.getList().remove(index);
						markDirty();
					}
				}            	
            });
            //and or not condition
            Group conditionComposite = new Group(routingExpressionsGroup,SWT.NONE);
            conditionComposite.setBackground(routingExpressionsGroup.getBackground());
            conditionComposite.setText("Conditions:");
            conditionComposite.setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
            );
            conditionComposite.setLayout(new GridLayout(3,false));
            
            conditionText= toolkit.createText(conditionComposite, "",SWT.BORDER|SWT.WRAP|SWT.V_SCROLL);
            conditionText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,2,3));
            conditionText.addModifyListener(new ModifyListener(){

				public void modifyText(ModifyEvent e) {
					// TODO Auto-generated method stub
					if(!refreshing)
					markDirty();
				}
            	
            });
            Composite conditionBtnComposite = toolkit.createComposite(conditionComposite, SWT.NULL);
            conditionBtnComposite.setLayoutData(
                    new GridData(SWT.RIGHT,SWT.FILL,false,true,1,1)
            );
            conditionBtnComposite.setLayout(new GridLayout(5,false));
            ButtonListenr listener=new ButtonListenr();
            Button btnLeft=toolkit.createButton(conditionBtnComposite, "(", SWT.PUSH);
            btnLeft.setLayoutData(new GridData(SWT.RIGHT,SWT.FILL,false,true,1,1));
            btnLeft.setData("(");
            btnLeft.addSelectionListener(listener);
            
            Button btnRight=toolkit.createButton(conditionBtnComposite, ")", SWT.PUSH);
            btnRight.setLayoutData(new GridData(SWT.RIGHT,SWT.FILL,false,true,1,1));
            btnRight.setData(")");
            btnRight.addSelectionListener(listener);
            
            Button btnAnd=toolkit.createButton(conditionBtnComposite, "And", SWT.PUSH);
            btnAnd.setLayoutData(new GridData(SWT.RIGHT,SWT.FILL,false,true,1,1));
            btnAnd.setData("&&");
            btnAnd.addSelectionListener(listener);
            
            Button btnOr=toolkit.createButton(conditionBtnComposite, "Or", SWT.PUSH);
            btnOr.setData("||");
            btnOr.setLayoutData(new GridData(SWT.RIGHT,SWT.FILL,false,true,1,1));  
            btnOr.addSelectionListener(listener);
            
            Button btnNot=toolkit.createButton(conditionBtnComposite, "Not", SWT.PUSH);
            btnNot.setData("!");
            btnNot.setLayoutData(new GridData(SWT.RIGHT,SWT.FILL,false,true,1,1));    
            btnNot.addSelectionListener(listener);
           /* DragSource wcSource = new DragSource(routingExpressionsViewer.getControl(),DND.DROP_MOVE);
            wcSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            wcSource.addDragListener(new WCDragSourceListener());*/
            wrap.Wrap(this, routingExpressionsViewer);
            
                        
            //make the Page window a DropTarget - we need to dispose it
            windowTarget = new DropTarget(this.getPartControl(), DND.DROP_MOVE);
            windowTarget.setTransfer(new Transfer[]{TextTransfer.getInstance()});
            windowTarget.addDropListener(new DCDropTargetListener());
            
                        
            refreshData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//createCharacteristicsContent

    public void update(Observable o, Object arg)
    {
    	if (arg != null && arg == routingExpressionsViewer)
    	{
    		deleteItems(arg);
    	}
    }
    
    private void deleteItems(Object view)
    {
		WSRoutingRule wsObject = (WSRoutingRule) (RoutingRuleMainPage.this.getXObject().getWsObject());
		IStructuredSelection selection = (IStructuredSelection)routingExpressionsViewer.getSelection();
		java.util.List list = Arrays.asList(selection.toArray());
        if (list.size() == 0)return;
		ArrayList<WSRoutingRuleExpression> rreList = new ArrayList<WSRoutingRuleExpression>(Arrays.asList(wsObject.getWsRoutingRuleExpressions()));

		rreList.removeAll(list);
		wsObject.setWsRoutingRuleExpressions(rreList.toArray(new WSRoutingRuleExpression[rreList.size()]));
		routingExpressionsViewer.setInput(wsObject);
		markDirty();
		
    }
    
	protected void refreshData() {
		try {
			
			if (this.comitting) return;
			
			this.refreshing = true;
			
			WSRoutingRule wsRoutingRule = (WSRoutingRule) (getXObject().getWsObject());    				
			descriptionText.setText(wsRoutingRule.getDescription());
			isSynchronousButton.setSelection(wsRoutingRule.isSynchronous());
			//serviceNameText.setText(wsRoutingRule.getServiceJNDI().replaceFirst("amalto/local/service/", ""));
			serviceNameCombo.setText(wsRoutingRule.getServiceJNDI().replaceFirst("amalto/local/service/", ""));
			serviceParametersText.setText(wsRoutingRule.getParameters()==null? "" : wsRoutingRule.getParameters());
			objectTypeText.setText(wsRoutingRule.getConcept());
			//xpathWidget1.setText(wsRoutingRule.getConcept());
			routingExpressionsViewer.setInput(wsRoutingRule);
			if(wsRoutingRule.getCondition()!=null)
			conditionText.setText(wsRoutingRule.getCondition());
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
			
			WSRoutingRule ws = (WSRoutingRule) (getXObject().getWsObject());
			ws.setDescription(descriptionText.getText());
			ws.setConcept(objectTypeText.getText());
			//ws.setConcept(xpathWidget1.getText());
			//ws.setServiceJNDI(serviceNameText.getText().contains("/") ? serviceNameText.getText() : "amalto/local/service/"+serviceNameText.getText());
//			if(serviceNameCombo.getText()==null||serviceNameCombo.getText().length()==0){
//				MessageDialog.openError(this.getSite().getShell(), "Error Service JNDI Name", "Service JNDI Name cannot be null");
//			}
			ws.setServiceJNDI(serviceNameCombo.getText().contains("/") ? serviceNameCombo.getText() : "amalto/local/service/"+serviceNameCombo.getText());
			ws.setParameters("".equals(serviceParametersText.getText())? null : serviceParametersText.getText());
			ws.setSynchronous(isSynchronousButton.getSelection());
			//WsRoutingRuleExpressions refreshed by viewer
			ws.setCondition(conditionText.getText());
			this.comitting = false;
			
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(), "Error comtiting the page", "Error comitting the page: "+e.getLocalizedMessage());
		}    	
	}
	
	
	
	protected void addRoutingRuleExpression() {
		if (xpathWidget.getText().trim().equals("")
				|| rightValueText.getText().equals("")) {
			return;
		}
  		markDirty();
		
//		if(!"".equals(this.xpathWidget.getText())&&!this.xpathWidget.getText().equals(null))
//			rre.setXpath(this.xpathWidget.getText());
		WSRoutingRule wsObject = (WSRoutingRule)RoutingRuleMainPage.this.getXObject().getWsObject();
		ArrayList<WSRoutingRuleExpression> wcList = new ArrayList<WSRoutingRuleExpression>(Arrays.asList(wsObject.getWsRoutingRuleExpressions()));
		String[] items = this.xpathWidget.getText().split("\\&");
		
			for(int i = 0;i<items.length;i++){
				WSRoutingRuleExpression rre = new WSRoutingRuleExpression();
				rre.setXpath(items[i]);
				this.xpathWidget.setText("");

				WSRoutingRuleOperator operator=null;
				if (RoutingRuleMainPage.this.operatorCombo.getText().equals("Contains")) operator = WSRoutingRuleOperator.CONTAINS;
				else if (RoutingRuleMainPage.this.operatorCombo.getText().equals("Matches")) operator = WSRoutingRuleOperator.MATCHES;
				else if (RoutingRuleMainPage.this.operatorCombo.getText().equals("=")) operator = WSRoutingRuleOperator.EQUALS;
				else if (RoutingRuleMainPage.this.operatorCombo.getText().equals(">")) operator = WSRoutingRuleOperator.GREATER_THAN;
				else if (RoutingRuleMainPage.this.operatorCombo.getText().equals(">=")) operator = WSRoutingRuleOperator.GREATER_THAN_OR_EQUAL;
				else if (RoutingRuleMainPage.this.operatorCombo.getText().equals("<")) operator = WSRoutingRuleOperator.LOWER_THAN;
				else if (RoutingRuleMainPage.this.operatorCombo.getText().equals("<=")) operator = WSRoutingRuleOperator.LOWER_THAN_OR_EQUAL;
				else if (RoutingRuleMainPage.this.operatorCombo.getText().equals("!=")) operator = WSRoutingRuleOperator.NOT_EQUALS;
				else if (RoutingRuleMainPage.this.operatorCombo.getText().equals("Starts With")) operator = WSRoutingRuleOperator.STARTSWITH;
				else if (RoutingRuleMainPage.this.operatorCombo.getText().equals("Is Null")) operator = WSRoutingRuleOperator.IS_NULL;
				else if (RoutingRuleMainPage.this.operatorCombo.getText().equals("Is Not Null")) operator = WSRoutingRuleOperator.IS_NOT_NULL;
				rre.setWsOperator(operator);
				if (
						(	operator.equals(WSRoutingRuleOperator.IS_NULL) || 
							operator.equals(WSRoutingRuleOperator.IS_NOT_NULL)
						)
				) 
					rre.setValue("");
				else
					rre.setValue(rightValueText.getText());
				
				if(wcList.size()==0){
					wcList.add(rre);
				}
				else{
					boolean exist = false;
					WSRoutingRuleExpression wsrre;
					for(Iterator it = wcList.iterator();it.hasNext();){
						wsrre = (WSRoutingRuleExpression)it.next();
						if(equals(wsrre, rre))
							exist = true;
					}//for(Iterator
					if(!exist)
					wcList.add(rre);
				}//else{
				
			}//for
			wsObject.setWsRoutingRuleExpressions(wcList.toArray(new WSRoutingRuleExpression[wcList.size()]));
			//RoutingRuleMainPage.this.routingExpressionsViewer.refresh();
			routingExpressionsViewer.setInput(wsObject);
			this.rightValueText.setText("");
	}//addRoutingRuleExpression

		
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
	



	/****************************************************************************
	 *   DND
	 ****************************************************************************/
	
	class DCDragSourceListener implements DragSourceListener {
		private int selected;

		public void dragFinished(DragSourceEvent event) {
			Control control = ((DragSource)event.widget).getControl();
			if ((control instanceof List) && ((event.detail & DND.DROP_MOVE) == DND.DROP_MOVE)) {
				((List)control).remove(selected);
				RoutingRuleMainPage.this.markDirty();
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
							RoutingRuleMainPage.this.markDirty();
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
			WSRoutingRule wsObject = (WSRoutingRule) (RoutingRuleMainPage.this.getXObject().getWsObject());
			IStructuredSelection selection = (IStructuredSelection)RoutingRuleMainPage.this.routingExpressionsViewer.getSelection();
			if (selection.getFirstElement()!=null) {
				WSRoutingRuleExpression wc = (WSRoutingRuleExpression) selection.getFirstElement();
				ArrayList<WSRoutingRuleExpression> wcList = new ArrayList<WSRoutingRuleExpression>(Arrays.asList(wsObject.getWsRoutingRuleExpressions()));
				wcList.remove(wc);
				wsObject.setWsRoutingRuleExpressions(wcList.toArray(new WSRoutingRuleExpression[wcList.size()]));
				RoutingRuleMainPage.this.routingExpressionsViewer.refresh();
				RoutingRuleMainPage.this.markDirty();
			}
		}

		public void dragSetData(DragSourceEvent event) {
			IStructuredSelection selection = (IStructuredSelection)RoutingRuleMainPage.this.routingExpressionsViewer.getSelection();
			if (selection.getFirstElement()!=null) {
					event.data =  selection.getFirstElement();
			}
		}

		public void dragStart(DragSourceEvent event) {
			IStructuredSelection selection = (IStructuredSelection)RoutingRuleMainPage.this.routingExpressionsViewer.getSelection();
			event.doit = (selection.getFirstElement()!=null);
		}


	}
	  public boolean equals(WSRoutingRuleExpression obj1,WSRoutingRuleExpression obj2) {
		if (	obj1.getValue().equals(obj2.getValue())
				&& obj1.getXpath().equals(obj2.getXpath())
				&& obj1.getWsOperator().getValue().equals(obj2.getWsOperator().getValue()))
			return true;
		else
			return false;
	}
	
//		public void doSave(IProgressMonitor monitor) throws Exception{
//			if(serviceNameCombo.getText()==null||serviceNameCombo.getText().length()==0){
//				MessageDialog.openError(this.getSite().getShell(), "Error Service JNDI Name", "Service JNDI Name cannot be null");
//					throw new Exception( "Service JNDI Name cannot be null");
//			}
//		}
	  
	@Override
	public boolean beforeDoSave() {
		if(serviceNameCombo.getText()==null||serviceNameCombo.getText().length()==0){
			MessageDialog.openError(this.getSite().getShell(), "Error saving", "Service JNDI Name cannot be null");
			return false;
		}
		else
			return true;
	}	
	class ButtonListenr implements SelectionListener{

		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void widgetSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			if(e.widget instanceof Button){
				Button btn=(Button)e.widget;
				String condition=conditionText.getText()+" "+btn.getText();
				conditionText.setText(condition);
				conditionText.setFocus();
				markDirty();
			}
		}		
	}
}
