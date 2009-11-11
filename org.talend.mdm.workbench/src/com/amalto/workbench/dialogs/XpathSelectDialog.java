package com.amalto.workbench.dialogs;

import java.awt.Panel;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;


import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XPathTreeContentProvider;
import com.amalto.workbench.providers.XSDTreeLabelProvider;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSGetDataModel;
import com.amalto.workbench.webservices.XtentisPort;


public class XpathSelectDialog extends Dialog {
	protected Label schemaLabel = null;
	protected Combo languagesCombo;
	protected TreeViewer domViewer;
	private String title = "Select Xpath";
	protected TreeParent parent;
	protected Combo dataModelCombo ;
	//protected TreeObject xobject;
	protected DrillDownAdapter drillDownAdapter;
	protected IWorkbenchPartSite site ;
	protected Panel panel;
	protected Text xpathText;
	protected Button add;
	protected SelectionListener listener;
	protected static String dataModelName;
	private String xpath="";
	private boolean isMulti=true;
	protected String conceptName;
	private XSDSchema xsdSchema;
	public XpathSelectDialog(Shell parentShell,TreeParent parent,String title,IWorkbenchPartSite site,boolean isMulti,String dataModelName) {
		super(parentShell);
		this.title = title;
		this.parent = parent;
		this.site = site;
		this.isMulti=isMulti;
		if(dataModelName!=null)
		this.dataModelName =dataModelName;//default dataModel
	}

	private  String getXpath(StructuredSelection sel){

		String path ="";
		String totalXpath="";
            TreeItem item;
            TreeItem[] items = domViewer.getTree().getSelection();
            for(int i=0;i<items.length;i++){
            	item = items[i];
            	XSDConcreteComponent component = (XSDConcreteComponent)item.getData();
            	if(!(component instanceof XSDParticle)&&!(component instanceof XSDElementDeclaration))
            		continue;
            	do {
                	 component = (XSDConcreteComponent)item.getData();
                	if (component instanceof XSDParticle) {
                		if (((XSDParticle)component).getTerm() instanceof XSDElementDeclaration)
                			path = "/"+((XSDElementDeclaration)((XSDParticle)component).getTerm()).getName()+path;
                	} else if (component instanceof XSDElementDeclaration) {
                			path=((XSDElementDeclaration)component).getName()+path;
                	}
                	item = item.getParentItem();
                	
                } while (item!=null);
            	if(i==0)
            		totalXpath = path;
            	else
            		totalXpath +="&"+path;
            	path="";
            }//for(i=0
           return totalXpath;     
        }
		
	protected Control createDialogArea (Composite parent) {
		parent.getShell().setText(this.title);
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = (GridLayout)composite.getLayout();
		layout.makeColumnsEqualWidth=false;
		layout.numColumns = 2;
		Label datamoelsLabel = new Label(composite, SWT.NONE);
		GridData dg= new GridData(SWT.FILL,SWT.FILL,false,true,1,1);
		datamoelsLabel.setLayoutData(dg);
		datamoelsLabel.setText("Data Models:");
		dg= new GridData(SWT.FILL,SWT.FILL,true,true,1,1);
		dg.widthHint=400;
		dataModelCombo = new Combo(composite,SWT.READ_ONLY |SWT.DROP_DOWN|SWT.SINGLE);
		dataModelCombo.setLayoutData(dg);
		if(this.parent==null){
			this.parent=(TreeParent)ServerView.show().getRoot().getChildren()[0];
		}
		final TreeParent tree = this.parent.findServerFolder(TreeObject.DATA_MODEL);
		

		List<String> systemDataModelValues=Util.getChildren(this.parent.getServerRoot(), TreeObject.DATA_MODEL);
		
		//filter the datamodel according to conceptName
		List<String> avaiList=new ArrayList<String>();
		avaiList.addAll(systemDataModelValues);
		if(conceptName!=null && !conceptName.contains("*")){
			for(String datamodel: systemDataModelValues){
				try {
					WSDataModel dm=Util.getPort(this.parent).getDataModel(new WSGetDataModel(new WSDataModelPK(datamodel)));
					if(dm!=null){
						XSDSchema xsdSchema = Util.getXSDSchema(dm.getXsdSchema());
						String schema = Util.nodeToString(xsdSchema.getDocument());
						XSDSchema xsd= Util.createXsdSchema(schema, this.parent);
						if(!Util.getConcepts(xsd).contains(conceptName)){
							avaiList.remove(datamodel);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}
		}
		dataModelCombo.setItems(avaiList.toArray(new String[avaiList.size()]));
		dataModelCombo.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(
					org.eclipse.swt.events.SelectionEvent e) {}

			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				changeDomTree(tree);
			}
		});
		schemaLabel = new Label(composite, SWT.NONE);
		schemaLabel.setText("Xpath: ");
		schemaLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true,1, 1));
		((GridData) schemaLabel.getLayoutData()).widthHint = 10;
		xpathText = new Text(composite, SWT.BORDER);
		xpathText.setEditable(false);
		xpathText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,1));
		if (isMulti) {
			domViewer = new TreeViewer(composite, SWT.H_SCROLL | SWT.MULTI
					| SWT.V_SCROLL | SWT.BORDER);
		} else {
			domViewer = new TreeViewer(composite, SWT.H_SCROLL | SWT.V_SCROLL
					| SWT.BORDER);
		}
		int index = avaiList.indexOf(dataModelName);
		if (index < 0)
			dataModelCombo.select(0);
		else
			dataModelCombo.select(index);

		changeDomTree(tree);

		domViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		((GridData) domViewer.getControl().getLayoutData()).heightHint = 400;
		((GridData) domViewer.getControl().getLayoutData()).widthHint = 400;
		return composite;
	}
	
	private void changeDomTree(final TreeParent pObject) {
		String modelDisplay = dataModelCombo.getText();
		if(modelDisplay.length()==0) return;
		this.dataModelName = modelDisplay;
        //this.selectedDataModelName = modelDisplay;
		//xobject = pObject.findObject(TreeObject.DATA_MODEL, modelDisplay);
		XtentisPort port = null;
		try {
			port = Util.getPort(pObject);
		} catch (XtentisException e3) {
			e3.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		WSDataModel wsDataModel = null;
		try {
			wsDataModel = port.getDataModel(new WSGetDataModel(
					new WSDataModelPK(dataModelName)));
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
		try {
			XSDSchema xsdSchema = Util.getXSDSchema(wsDataModel.getXsdSchema());
			String schema = Util.nodeToString(xsdSchema.getDocument());
			XSDSchema xsd= Util.createXsdSchema(schema, pObject);
			provideViwerContent(xsd);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}// changeDomTree(
	

	
	
	  protected void provideViwerContent(XSDSchema xsdSchema) {
		 this.xsdSchema=xsdSchema;
		drillDownAdapter = new DrillDownAdapter(domViewer);
		domViewer.setLabelProvider(new XSDTreeLabelProvider());
		XPathTreeContentProvider  provider=new XPathTreeContentProvider(this.site,
				xsdSchema, parent);
		provider.setConceptName(this.conceptName);
		domViewer.setContentProvider(provider);

		domViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent e) {
				StructuredSelection sel = (StructuredSelection) e
						.getSelection();
				xpath = getXpath(sel);
				xpathText.setText(xpath);
				getButton(IDialogConstants.OK_ID).setEnabled(xpath.length()>0);
			}
		});
		domViewer.getControl().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, false, true));
		domViewer.setSorter(new ViewerSorter() {
			public int category(Object element) {
				// we want facets before Base TypeDefinitions in
				// SimpleTypeDefinition
				if (element instanceof XSDFacet)
					return 100;
				// unique keys after element declarations and before other keys
				if (element instanceof XSDIdentityConstraintDefinition) {
					XSDIdentityConstraintDefinition icd = (XSDIdentityConstraintDefinition) element;
					if (icd.getIdentityConstraintCategory().equals(
							XSDIdentityConstraintCategory.UNIQUE_LITERAL))
						return 300;
					else if (icd.getIdentityConstraintCategory().equals(
							XSDIdentityConstraintCategory.KEY_LITERAL))
						return 301;
					else
						return 302;
				}
				return 200;
			}

			public int compare(Viewer theViewer, Object e1, Object e2) {
				int cat1 = category(e1);
				int cat2 = category(e2);
				return cat1 - cat2;
			}
		});
		domViewer.setInput(site);
	}

	protected Control createButtonBar(Composite parent) {
		Control btnBar = super.createButtonBar(parent);
		getButton(IDialogConstants.OK_ID).setText("Add");
		return btnBar;
	}

	public String getXpath() {
		return xpath;
	}

	public static String getDataModelName() {
		return dataModelName;
	}

	public String getConceptName() {
		return conceptName;
	}

	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}

}
