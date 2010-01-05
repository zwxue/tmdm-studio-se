package com.amalto.workbench.dialogs;


import java.io.File;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSchemaContent;
import org.eclipse.xsd.impl.XSDImportImpl;
import org.eclipse.xsd.impl.XSDIncludeImpl;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSRegexDataModelPKs;
import com.amalto.workbench.webservices.XtentisPort;

public class SelectImportedModulesDialog extends Dialog{
    private String title;
    private TableViewer tableViewer;
    private List<XSDDesc> xsdDescList = new ArrayList<XSDDesc>();
    private List<String> xsdImpList = new ArrayList<String>();
    private List<String> toDelList = new ArrayList<String>();
    
    private Shell shell;
    private TreeObject treeObject;
    private XSDSchema xsdSchema;
    
    private Button delLabelButton;
    
	private static final Image LOCAL= ImageCache.getCreatedImage(EImage.SERVER.getPath());
	private static final Image MDM_WEB= ImageCache.getCreatedImage(EImage.SERVERNOTRUNNING.getPath());
	private static final Image OTHER_WEB = ImageCache.getCreatedImage(EImage.SERVERNAVIGATOR.getPath());
	
	private String LOCAL_MDM_URL = null;
	
	public SelectImportedModulesDialog(Shell parentShell,XSDSchema schema, TreeObject treeObj, String title) {
		super(parentShell);
		this.shell = parentShell;
		this.treeObject = treeObj;
		this.title=title;
		this.xsdSchema = schema;
		
		String endpointIpAddress=treeObject.getEndpointIpAddress();
		if(endpointIpAddress!=null&&endpointIpAddress.length()>0){
			LOCAL_MDM_URL=endpointIpAddress+"/pubcomponent/secure/dataModelsTypes/";
		}
	}
	
	protected Control createDialogArea(Composite parent) {
		parent.getShell().setText(this.title);
		
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = (GridLayout)composite.getLayout();
		layout.numColumns = 2;
		
		Label label= new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 2, 1));
		label.setText("Viewer with imported xsd schema modules:");
		
		tableViewer= new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		GridData data= new GridData(GridData.FILL, GridData.FILL, true, true, 1, 1);
		tableViewer.getControl().setLayoutData(data);
		((GridData)tableViewer.getControl().getLayoutData()).heightHint=250;
		((GridData)tableViewer.getControl().getLayoutData()).widthHint=300;
		
		XSDSchemaLabelProvider labelProvider= new XSDSchemaLabelProvider();
		XSDSchemaContentProvider contentProvider= new XSDSchemaContentProvider();
		tableViewer.setContentProvider(contentProvider);
		tableViewer.setLabelProvider(labelProvider);
		tableViewer.setInput(new Object());
		tableViewer.setSorter(new ViewerSorter() {
			public int category(Object element) {
				if (element instanceof XSDDesc) {
					return ((XSDDesc)element).getType();
				}
				return -1;
			}

			public int compare(Viewer theViewer, Object e1, Object e2) {
				int cat1 = category(e1);
				int cat2 = category(e2);
				return cat1 - cat2;
			}
		});
		
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener(){
            public void selectionChanged(SelectionChangedEvent event)
            {
            	IStructuredSelection selection = (IStructuredSelection)event.getSelection();
            	delLabelButton.setEnabled(!selection.isEmpty());
            }
        }
        );
		
		Composite compositeBtn = new Composite(composite, SWT.FILL);
		compositeBtn.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false,
				false, 1, 1));
		compositeBtn.setLayout(new GridLayout(1,false));
		
		Button addXSDFromLocal = new Button(compositeBtn,SWT.PUSH | SWT.FILL);
		addXSDFromLocal.setLayoutData(
                new GridData(SWT.FILL,SWT.NONE,false,false,1,1)
        );
		addXSDFromLocal.setText("Add xsd from local");
		addXSDFromLocal.setToolTipText("Add xsd schema from local");
		addXSDFromLocal.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
    			FileDialog fd = new FileDialog(shell.getShell(),SWT.SAVE);
    			fd.setFilterExtensions(new String[]{"*.xsd"});
    			fd.setText("import XSD Schema");
    			String filename = fd.open();

    			if (filename == null) return;
    			File file = new File(filename);
    			try {
					System.out.println(file.toURL());
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			XSDDesc xsdDesc = buildUp(filename, LOCAL, 0);
    			include(xsdDesc);
    			getButton(IDialogConstants.OK_ID).setEnabled(true);
    			tableViewer.refresh();
        	}
		});
		
		Button addXSDFromWebSite = new Button(compositeBtn,SWT.PUSH | SWT.FILL);
		addXSDFromWebSite.setLayoutData(
                new GridData(SWT.FILL,SWT.NONE,false,false,1,1)
        );
		addXSDFromWebSite.setText("Add Types from Data Models");
		addXSDFromWebSite.setToolTipText("Add xsd schema from the data model types");
		addXSDFromWebSite.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        		MDMXSDSchemaEntryDialog dlg = new MDMXSDSchemaEntryDialog(shell.getShell(), "Select XSD Schema from MDM Web Site");
        		dlg.setBlockOnOpen(true);
        		dlg.open();
        		if (dlg.getReturnCode() == Window.OK)  {
        			List<String> urls = dlg.getMDMDataModelUrls();
        			for(String url: urls)
        			{
            			XSDDesc xsdDesc = buildUp(LOCAL_MDM_URL + url + "/types", MDM_WEB, 1);
            			include(xsdDesc);
        			}
        			getButton(IDialogConstants.OK_ID).setEnabled(true);
        			tableViewer.refresh();
        		}
        	}
		});
		
		Button addXSDFromInputDlg = new Button(compositeBtn,SWT.PUSH | SWT.FILL);
		addXSDFromInputDlg.setLayoutData(
                new GridData(SWT.FILL,SWT.NONE,false,false,1,1)
        );
		addXSDFromInputDlg.setText("Add xsd from Other site");
		addXSDFromInputDlg.setToolTipText("Add xsd schema from the URL of other site");
		addXSDFromInputDlg.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
           		InputDialog id = new InputDialog(
           				shell.getShell(),
           				"Add xsd from Other site",
           				"Enter a text for the URL of XSD Schema resource",
           				"",
           				new IInputValidator() {
           					public String isValid(String newText) {
           						if ((newText==null) || "".equals(newText)) return "The name cannot be empty";
           						return null;
           					};
           				}
           		);
                
           		id.setBlockOnOpen(true);
           		int ret = id.open();
           		if (ret == Window.CANCEL) {
                    return ;
           		}
    			XSDDesc xsdDesc = buildUp(id.getValue(), OTHER_WEB, 2);
    			include(xsdDesc);
    			getButton(IDialogConstants.OK_ID).setEnabled(true);
    			tableViewer.refresh();
        	}
		});
		
        delLabelButton = new Button(compositeBtn,SWT.PUSH);
        delLabelButton.setLayoutData(
                new GridData(SWT.FILL,SWT.NONE,false,false,1,1)
        );
        delLabelButton.setText("Delete xsd modules");
        delLabelButton.setToolTipText("Delete");
        delLabelButton.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
    			IStructuredSelection selection = (IStructuredSelection)tableViewer.getSelection();
    			for (Iterator<XSDDesc> iter = selection.iterator(); iter.hasNext(); ) {
    				XSDDesc desc = (XSDDesc)iter.next();
    				xsdDescList.remove(desc);
    				toDelList.add(desc.getURL());
    			}
    			getButton(IDialogConstants.OK_ID).setEnabled(true);
    			tableViewer.refresh();
        	};
        });
        
        countImportListInSchema();
        
        tableViewer.setInput(xsdDescList);
		return composite;
	}
	
	private void countImportListInSchema()
	{
		xsdDescList.clear();
		try
		{
	    	for (XSDSchemaContent cnt: xsdSchema.getContents())
	    	{
	    		String schemaLocation = "";
	    		if (cnt instanceof XSDImportImpl)
	    		{
	    			XSDImportImpl imp = (XSDImportImpl)cnt;
	    			schemaLocation = imp.getSchemaLocation();
	    		}
	    		else if(cnt instanceof XSDIncludeImpl)
	    		{
	    			XSDIncludeImpl incu = (XSDIncludeImpl)cnt;
	    			schemaLocation = incu.getSchemaLocation();
	    		}
	    		else
	    			continue;
	    		Pattern httpUrl = Pattern.compile("(http|https|ftp):(\\//|\\\\)(.*):(.*)");
	    		Matcher match = httpUrl.matcher(schemaLocation);
	    		if(match.matches())
	    		{
	    			InetAddress addr = InetAddress.getLocalHost();
	    			String ip = match.group(3);
	    			boolean local = ip.equals(addr.getHostAddress())
							|| ip.equals("localhost") || ip.equals("127.0.0.1");
	    			Image img = local ? MDM_WEB : OTHER_WEB;
	    			int type = local ? 1 : 2;
	    			XSDDesc xsdDesc = buildUp(schemaLocation, img, type);
	    			xsdDescList.add(xsdDesc);
	    		}
	    		else if(!schemaLocation.equals(""))
	    		{
	    			XSDDesc xsdDesc = buildUp(schemaLocation, LOCAL, 0);
	    			xsdDescList.add(xsdDesc);
	    		}
	    	}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private void include(XSDDesc xsdDesc)
	{
		for (XSDDesc xc: xsdDescList)
		{
			if(xc.getURL().equals(xsdDesc.getURL()))
				return ;
		}
		
		xsdDescList.add(xsdDesc);
	}
	
	private XSDDesc buildUp(String url, Image image, int type)
	{
		return new XSDDesc(url, image, type);
	}
	
	protected Control createButtonBar(Composite parent) {
		Control control = super.createButtonBar(parent);
		getButton(IDialogConstants.OK_ID).setEnabled(false);
		delLabelButton.setEnabled(false);
		return control;
	}
	
	public List<String> getImportedXSDList()
	{
		for(XSDDesc des: xsdDescList)
		{
			xsdImpList.add(des.getURL());
		}
		return xsdImpList;
	}
	
	public List<String> getToDelXSDList()
	{
		for(String xsd: xsdImpList)
		{
			if(toDelList.contains(xsd))
			{
				toDelList.remove(xsd);
			}
		}
		return toDelList;
	}
	
	private static class XSDSchemaLabelProvider extends StyledCellLabelProvider {

		public XSDSchemaLabelProvider() {
		}
		
		public void update(ViewerCell cell) {
			Object element= cell.getElement();
			
			if (element instanceof XSDDesc) {
				XSDDesc xsdDesc= (XSDDesc) element;
				
				cell.setText(xsdDesc.getURL());
				cell.setImage(xsdDesc.getImage());

			} else {
				cell.setText("Unknown element"); //$NON-NLS-1$
			}

			super.update(cell);
		}
		
		protected void measure(Event event, Object element) {
			super.measure(event, element);
		}
	}

	private  class XSDSchemaContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object element) {
			
			return xsdDescList.toArray(new XSDDesc[]{});
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	
	private class XSDDesc implements Serializable{
	  private String _url;
	  private Image _image;
	  private int _type;
	  
	  public XSDDesc()
	  {
	  }
	  
	  public XSDDesc(String url,Image image, int type)
	  {
		  _url = url;
		  _image = image;
		  _type = type;
	  }
	  
	  
	  public String getURL()
	  {
		  return _url;
	  }
	  
	  public Image getImage()
	  {
		  return _image;
	  }
	  
	  public int getType()
	  {
		  return _type;
	  }
	}

	private class MDMXSDSchemaEntryDialog extends Dialog
	{
		private String title;
		private ListViewer wcListViewer; 
		private List<String> urls = new ArrayList<String>();
		private List<String> importedUrls = new ArrayList<String>();
		
		public MDMXSDSchemaEntryDialog(Shell parentShell,String title) {
			super(parentShell);
			this.title=title;
		}
		
		protected Control createDialogArea(Composite parent) {
			parent.getShell().setText(this.title);
			
			Composite composite = (Composite) super.createDialogArea(parent);
			GridLayout layout = (GridLayout)composite.getLayout();
			layout.numColumns = 1;
			
            wcListViewer = new ListViewer(composite,SWT.BORDER | SWT.MULTI);
            wcListViewer.getControl().setLayoutData(
                    new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
            );
            ((GridData)wcListViewer.getControl().getLayoutData()).minimumHeight = 200;

            wcListViewer.setContentProvider(new IStructuredContentProvider() {
				public void dispose() {}
				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
				public Object[] getElements(Object inputElement) {
					return ((ArrayList)inputElement).toArray(new String[]{});
				}
            });
            
            wcListViewer.addSelectionChangedListener(new ISelectionChangedListener(){
                public void selectionChanged(SelectionChangedEvent event)
                {
                	importedUrls.clear();
                	IStructuredSelection selection = (IStructuredSelection)event.getSelection();
                	Iterator iter = selection.iterator();
                	while(iter.hasNext())
                	{
                		String url = (String)iter.next();
                		importedUrls.add(url);
                	}
                	getButton(IDialogConstants.OK_ID).setEnabled(!selection.isEmpty());
                }
            }
            );
            wcListViewer.setLabelProvider(new ILabelProvider() {
				public void addListener(ILabelProviderListener listener) {}
				public void dispose() {}
				public boolean isLabelProperty(Object element, String property) {return false;}
				public void removeListener(ILabelProviderListener listener) {}
				public Image getImage(Object element) {return null;}
				public String getText(Object element) {
					return element.toString();
				}			
			})	;
            
            wcListViewer.setSorter(new ViewerSorter());
            wcListViewer.setInput(urls);
            retrieveDataModels();
            
            return composite;
		}
		
		@Override
		protected void okPressed() {
			setReturnCode(OK);
			getButton(IDialogConstants.OK_ID).setData("dialog",MDMXSDSchemaEntryDialog.this);
			//no close let Action Handler handle it
			super.okPressed();
		}
		 @Override
		protected void cancelPressed() {
			setReturnCode(CANCEL);
			getButton(IDialogConstants.CANCEL_ID).setData("dialog",MDMXSDSchemaEntryDialog.this);
			//no close let Action Handler handle it
			super.cancelPressed();
		}
		 
		protected Control createButtonBar(Composite parent) {
			Control control = super.createButtonBar(parent);
			getButton(IDialogConstants.OK_ID).setEnabled(false);
			
			return control;
		}
		
		public List<String> getMDMDataModelUrls()
		{
			return importedUrls;
		}
		
		private void retrieveDataModels()
		{
            try {
            	XtentisPort port = Util.getPort(treeObject);
    			WSDataModelPK[] xdmPKs = port.getDataModelPKs(new WSRegexDataModelPKs("")).getWsDataModelPKs();
    			if (xdmPKs != null) {
    				for (int i = 0; i < xdmPKs.length; i++) {
    					String name = xdmPKs[i].getPk();
    					if (!name.startsWith("XMLSCHEMA")) {
    						urls.add(name);
    					}
    				}
    			wcListViewer.refresh();
    			}
			} catch (Exception e) {
				e.printStackTrace();
				urls.clear();
			}
		}
	}
}
