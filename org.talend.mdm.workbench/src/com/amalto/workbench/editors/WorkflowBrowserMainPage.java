package com.amalto.workbench.editors;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.models.IXObjectModelListener;
import com.amalto.workbench.models.Line;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.widgets.ProcessList;
import com.amalto.workbench.widgets.ProcessWidget;
import com.amalto.workbench.widgets.WidgetFactory;

public class WorkflowBrowserMainPage extends AMainPage implements IXObjectModelListener {
	private Table table;
	private TableViewer viewer;
	private FormToolkit toolkit;
	private Composite processCom;

	private ScrolledComposite ccrollComposite;
	private ProcessList plist;
	public WorkflowBrowserMainPage(FormEditor editor) {
        super(
        		editor,
        		WorkflowBrowserMainPage.class.getName(),
        		((XObjectBrowserInput)editor.getEditorInput()).getName()+""
        );        
        //listen to events
        ((XObjectBrowserInput)editor.getEditorInput()).addListener(this);
    }

	@Override
	protected void createFormContent(IManagedForm managedForm) {

        try {
        	//sets the title
        	managedForm.getForm().setText(this.getTitle());
        	
        	//get the toolkit
        	toolkit = managedForm.getToolkit();
        	
        	//get the body
        	Composite composite = managedForm.getForm().getBody();
        	composite.setLayout(new GridLayout(1,false));
        	
        	Composite creatComposite=toolkit.createComposite(composite);
        	creatComposite.setLayoutData(    
        			new GridData(SWT.FILL,SWT.CENTER,true,false,1,1)
        	);
        	creatComposite.setLayout(new GridLayout(3,false));
        	
        	Label label=toolkit.createLabel(creatComposite, "Instance Name");
        	final Text text=toolkit.createText(creatComposite, ""); 
        	GridData gd11=new GridData(SWT.FILL,SWT.CENTER,false,false,1,1);
        	gd11.widthHint=200;
        	text.setLayoutData(gd11); 
        	Button creatBtn=toolkit.createButton(creatComposite, "Create Instance", SWT.PUSH);
        	creatBtn.addSelectionListener(new SelectionAdapter(){
        		@Override
        		public void widgetSelected(SelectionEvent e) {
        			if(text.getText().length()>0){
	        			ProcessWidget pw=plist.add(text.getText());
	        			
        			}
        		}
        	});
        	Composite separator = toolkit.createCompositeSeparator(composite);
        	separator.setLayoutData(    
        			new GridData(SWT.FILL,SWT.CENTER,true,false,1,1)
        	);
        	((GridData)separator.getLayoutData()).heightHint = 2;     
        	
        	//process instances list
		    ccrollComposite = new ScrolledComposite(composite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);		    		       	
		    ccrollComposite.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,true,false,1,1));        	
        	processCom=toolkit.createComposite(ccrollComposite);
        	processCom.setLayout(new GridLayout(1,false));
        	GridData gd=new GridData(SWT.FILL,SWT.CENTER,true,true,1,1);
        	gd.heightHint=150;
        	processCom.setLayoutData(gd);
        	ccrollComposite.setContent(processCom);
        	ccrollComposite.setExpandHorizontal(true);
        	ccrollComposite.setExpandVertical(true);
        	ccrollComposite.setMinSize(400,4*31);
        	plist=new ProcessList(toolkit, processCom, ccrollComposite);
        	
        	//process Tasks 
        	Label label1=toolkit.createLabel(composite, "Process Tasks:");
        	label1.setLayoutData(    
        			new GridData(SWT.FILL,SWT.CENTER,false,false,1,1)
        	);
        	String[] columns={"Task","Status","Candidates"};
        	createTable(composite,columns);
		
        } catch (Exception e) {
            e.printStackTrace();
        }	
	}//createFormContent
	
	private void createTable(Composite com,String[] columns){
		table =new Table(com,SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER|SWT.FULL_SELECTION);
		
		viewer = new TableViewer(table);
        
        for(String column:columns){
        	TableColumn tableColumn=new TableColumn(table, SWT.CENTER);
        	tableColumn.setText(column);
        	
			tableColumn.setWidth(200);
			tableColumn.pack();			
        }          
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
		GridData gd=new GridData(SWT.FILL,SWT.FILL,true,true,1,1);
        table.setLayoutData( gd );
        gd.heightHint=120;        
        
        //set the content provider
        viewer.setContentProvider(new IStructuredContentProvider() {
        	public void dispose() {}
        	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
        	@SuppressWarnings("unchecked")
			public Object[] getElements(Object inputElement) {
        		ArrayList<Line> lines = (ArrayList<Line>)inputElement;
        		return lines.toArray(new Line[lines.size()]);
        	}
        });
        
        //set the label provider
        viewer.setLabelProvider(new ITableLabelProvider() {

			public Image getColumnImage(Object element, int columnIndex) {
				// TODO Auto-generated method stub
				return null;
			}

			public String getColumnText(Object element, int columnIndex) {
				// TODO Auto-generated method stub
				return null;
			}

			public void addListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}

			public void dispose() {
				// TODO Auto-generated method stub
				
			}

			public boolean isLabelProperty(Object element, String property) {
				// TODO Auto-generated method stub
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}      
        	
        });  
        
        //set input
        viewer.setInput(null);
	}
	@Override
	protected void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createActions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void refreshData() {
		// TODO Auto-generated method stub
		
	}

	public void handleEvent(int type, TreeObject parent, TreeObject child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createCharacteristicsContent(FormToolkit toolkit,
			Composite charSection) {
		// TODO Auto-generated method stub
		
	}

}
