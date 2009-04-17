package com.amalto.workbench.widgets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.amalto.workbench.editors.AMainPageV2;
import com.amalto.workbench.models.KeyValue;
import com.amalto.workbench.models.Line;

/**
 * This table viewer has:
 * 1.input Texts, add button
 * 2.normal tableviewer with up/down/delete button
 * 
 * @author aiming
 *
 */
public class ComplexTableViewer {
	protected List<ComplexTableViewerColumn> columns;
	protected Composite parent;
	protected FormToolkit toolkit;
	
	protected Composite mainComposite;
	protected Button addButton;
	protected TableViewer viewer;
	protected Button downButton;
	protected Button upButton;
	protected Button deleteButton;
	
	//mainPage can be null
	protected AMainPageV2 mainPage;
	
	public AMainPageV2 getMainPage() {
		return mainPage;
	}
	public void setMainPage(AMainPageV2 mainPage) {
		this.mainPage = mainPage;
	}

	
	public Button getAddButton() {
		return addButton;
	}
	public TableViewer getViewer() {
		return viewer;
	}
	public Button getDownButton() {
		return downButton;
	}
	public Button getUpButton() {
		return upButton;
	}
	public Button getDeleteButton() {
		return deleteButton;
	}

	public List<ComplexTableViewerColumn> getColumns() {
    	return columns;
    }
	
	
	public ComplexTableViewer(List<ComplexTableViewerColumn> columns, FormToolkit toolkit,Composite parent){
		this.columns=columns;
		this.parent=parent;
		this.toolkit=toolkit;
	}
	protected String[] getTextValues(){
		List<String> values=new ArrayList<String>();
		for(ComplexTableViewerColumn column:columns){
			String text = "";
			if (column.isCombo()) {
				text = ((CCombo)column.getControl()).getText();
			} else {
				text = ((Text)column.getControl()).getText();
			}
			values.add(text);
		}
		return values.toArray(new String[values.size()]);
	}
	
	protected void markDirty(){
		if(mainPage!=null){
			mainPage.markDirty();
		}
	}
	protected void createLabels(){
		int i=0;
		for(ComplexTableViewerColumn column:columns){
	        Label label = toolkit.createLabel(mainComposite, column.getName(), SWT.NULL);
	        if(i==columns.size()-1){
		        label.setLayoutData(
		                new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
		        );			
	        }else{
		        label.setLayoutData(
		                new GridData(SWT.FILL,SWT.FILL,true,true,1,1)
		        );
	        }
	        i++;
		}
	}
	
	protected void createTexts(){
		
		for (Iterator<ComplexTableViewerColumn> iterator = columns.iterator(); iterator.hasNext(); ) {
			ComplexTableViewerColumn column = iterator.next();
			if (column.isCombo()) {
				CCombo combo = new CCombo(mainComposite,SWT.BORDER|SWT.READ_ONLY);
				combo.setLayoutData(new GridData(SWT.NONE,SWT.TOP,false,false,1,1));
				combo.setItems(column.getComboValues());
				if(column.getDefaultValue() ==null ||column.getDefaultValue().length()==0){
					combo.select(0);
				}else{
					combo.setText(column.getDefaultValue());
				}
				column.setControl(combo);
			} else {
				int style=SWT.BORDER;
				if (column.getTextLines()>1) {
					style = SWT.BORDER|SWT.MULTI|SWT.V_SCROLL|SWT.H_SCROLL;
				}
				final Text text = toolkit.createText(mainComposite, column.getDefaultValue(), style);
				GridData gdata = new GridData(SWT.FILL,SWT.FILL,true,true,1,1);
				if (column.getTextLines()>1)
					gdata.heightHint = text.getLineHeight()*column.getTextLines();
				text.setLayoutData(gdata);
				column.setControl(text);
		        text.addFocusListener(new FocusAdapter(){
		        	@Override
		        	public void focusGained(FocusEvent e) {
		        		text.selectAll();
		        	}
		        });
			}
		}


        addButton = toolkit.createButton(mainComposite,"Add",SWT.PUSH | SWT.CENTER);
        addButton.setLayoutData(
                new GridData(SWT.FILL,SWT.BOTTOM,false,false,1,1)
        );
        addButton.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        		String uniqueVal="";
           		//Make sure texts are not nill (empty) where not authorized
        		for (Iterator<ComplexTableViewerColumn> iterator = columns.iterator(); iterator.hasNext(); ) {
        			ComplexTableViewerColumn column = iterator.next();
        			String text = "";
        			if (column.isCombo()) {
        				text = ((CCombo)column.getControl()).getText();
        			} else {
        				text = ((Text)column.getControl()).getText();
        			}
        			if(text.length()==0) {
        				if (column.isNillable()) {
        					text = column.getNillValue();
        					if (column.isCombo()) {
                				((CCombo)column.getControl()).setText(text);
                			} else {
                				((Text)column.getControl()).setText(text);
                			}
        				} else {
        					MessageDialog.openError(
        						ComplexTableViewer.this.getViewer().getControl().getShell(), 
        						"Input Error",
        						"The Column '"+column.getName()+"' cannot be empty"       						
        					);
        					return;
        				}
        			}
        			uniqueVal+="."+text;
        		}
        		
        		//check uniqueness by concatenating all the values
        		List<Line> list=(List<Line>)getViewer().getInput();
        		for(Line line: list){
        			String thisLineVal = "";
        			for(KeyValue keyvalue:line.keyValues){
        				thisLineVal+="."+keyvalue.value;
        			}
        			if(thisLineVal.equals(uniqueVal)){
        				MessageDialog.openInformation(null, "Warning", "This line already Exists!");
        				return;
        			}
        		}
        		
        		//Update the model
        		Line line =new Line(columns.toArray(new ComplexTableViewerColumn[columns.size()]),getTextValues());
        		list.add(line);
        		//update the instances viewer
        		viewer.refresh();
        		markDirty();
         	};
        });		
	}
	
	protected void add() {
   		
	}
	
	protected void createViewer(){
        Table table =new Table(mainComposite,SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER|SWT.FULL_SELECTION);
        viewer = new TableViewer(table);
        table.setLayoutData(    
                new GridData(SWT.FILL,SWT.FILL,true,true,columns.size(),1)
        );
        ((GridData)viewer.getControl().getLayoutData()).heightHint=60;
        
        //table.setLayoutData(new GridData(GridData.FILL_BOTH));
        for(ComplexTableViewerColumn column:columns){
        	TableColumn tableColumn=new TableColumn(table, SWT.CENTER);
        	tableColumn.setText(column.getName());
        	tableColumn.setWidth(200);
        	tableColumn.pack();
        }  
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
       // Up Down Delete button group
        Composite stepUpDownComposite = toolkit.createComposite(mainComposite,SWT.NONE);
        stepUpDownComposite.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
        );
        stepUpDownComposite.setLayout(new GridLayout(1,false));
        
        upButton = toolkit.createButton(stepUpDownComposite,"Up",SWT.PUSH | SWT.CENTER);
        upButton.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,false,false,1,1)
        );
        upButton.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        		int index =viewer.getTable().getSelectionIndex();
        		if(index >=0 && index < viewer.getTable().getItemCount() ){
        			//commit as we go
        			if(mainPage!=null){
        				mainPage.setComitting(true);
        			}
        			List<Line> items=(List<Line>)viewer.getInput();
        			Line line= items.get(index);
        			items.remove(index);
        			items.add(index-1,line);
        			
        			viewer.refresh();
        			
        			if(mainPage!=null){
        				mainPage.setComitting(false);
        			}
	            	markDirty();       		
        		}
        	};
        });
        downButton = toolkit.createButton(stepUpDownComposite,"Down",SWT.PUSH | SWT.CENTER);
        downButton.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,false,false,1,1)
        );
        downButton.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        		int index =viewer.getTable().getSelectionIndex();
        		if(index >=0 && index < viewer.getTable().getItemCount() ){
        			//commit as we go
        			if(mainPage!=null){
        				mainPage.setComitting(true);
        			}
        			List<Line> items=(List<Line>)viewer.getInput();
        			Line line= items.get(index);
        			items.remove(index);
        			items.add(index+1,line);
        			//viewer.setInput(items);
        			viewer.refresh();
        			//TODO
        			if(mainPage!=null){
        				mainPage.setComitting(false);
        			}
	            	markDirty();       		
        		}
        	};
        });
        deleteButton = toolkit.createButton(stepUpDownComposite,"Delete",SWT.PUSH | SWT.CENTER);
        deleteButton.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,false,false,1,1)
        );
        deleteButton.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        		int index =viewer.getTable().getSelectionIndex();
        		if(index >=0 && index < viewer.getTable().getItemCount() ){
        			List<Line> items=(List<Line>)viewer.getInput();
        			items.remove(index);
        			viewer.refresh();
        			markDirty();
        		}
        	};
        });
       

        // Create the cell editors --> We actually discard those later: not natural for an user
        CellEditor[] editors = new CellEditor[columns.size()];	        
        for(int i=0; i< columns.size(); i++){
	        editors[i] = new TextCellEditor(table);		        
        }
        viewer.setCellEditors(editors);
        
        //set the content provider
        viewer.setContentProvider(new IStructuredContentProvider() {
        	public void dispose() {}
        	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
        	public Object[] getElements(Object inputElement) {
        		ArrayList<Line> lines = (ArrayList<Line>)inputElement;
        		return lines.toArray(new Line[lines.size()]);
        	}
        });
        
        //set the label provider
        viewer.setLabelProvider(new ITableLabelProvider() {
        	public boolean isLabelProperty(Object element, String property) {return false;}
        	public void dispose() {}
        	public void addListener(ILabelProviderListener listener) {}
        	public void removeListener(ILabelProviderListener listener) {}
        	public String getColumnText(Object element, int columnIndex) {
        		Line line = (Line) element;
        		if(columnIndex>=0 && columnIndex<columns.size()){
        			for(KeyValue keyvalue:line.keyValues){
        				if(keyvalue.key.equals(columns.get(columnIndex).getName())){
        					String val = keyvalue.value; 
        					if (columns.get(columnIndex).isNillable()) {
        						if (columns.get(columnIndex).getNillValue().equals(val))
        							val = columns.get(columnIndex).getNillDisplay();
        					}
        					return val;
        				}
        			}
        		}
        		return "";
        	}
        	public Image getColumnImage(Object element, int columnIndex) {return null;}
        });

        // Set the column properties
        ArrayList<String> columnNames = new ArrayList<String>();
        for (ComplexTableViewerColumn column : columns) {
			columnNames.add(column.getName());
		}
        viewer.setColumnProperties(columnNames.toArray(new String[columnNames.size()]));
        
        //set the Cell Modifier
        viewer.setCellModifier(new ICellModifier() {
        	public boolean canModify(Object element, String property) {
        		//if (INSTANCE_ACCESS.equals(property)) return true; Deactivated
        		return false;
        	}
        	public void modify(Object element, String property, Object value) {

        	}
        	public Object getValue(Object element, String property) {
        		Line line = (Line) element;
        		for(KeyValue keyvalue:line.keyValues){
        			if(property.equals(keyvalue.key)){
        				return keyvalue.value;
        			}
        		}
        		return null;
        	}
        });

        viewer.addSelectionChangedListener(new ISelectionChangedListener(){

			public void selectionChanged(SelectionChangedEvent event) {
				// TODO Auto-generated method stub
    			Line line = (Line)((IStructuredSelection)event.getSelection()).getFirstElement();
    			
    			for(int columnIndex=0; columnIndex<columns.size(); columnIndex++){
    				if(line==null){
    					Control control=columns.get(columnIndex).getControl();
    					if(control instanceof Text){
    						((Text)control).setText("");
    					}
    					if(control instanceof CCombo){
    						((CCombo)control).select(0);
    					}
    					if(control instanceof Combo){
    						((CCombo)control).select(0);
    					}  					
    				}else{
		       			for(KeyValue keyvalue:line.keyValues){
		    				if(keyvalue.key.equals(columns.get(columnIndex).getName())){
		    					String val = keyvalue.value; 
		    					Control control=columns.get(columnIndex).getControl();
		    					if(control instanceof Text){
		    						((Text)control).setText(val);
		    					}
		    					if(control instanceof CCombo){
		    						((CCombo)control).setText(val);
		    					}
		    					if(control instanceof Combo){
		    						((CCombo)control).setText(val);
		    					}
		    				}
		    			}
    				}
    			}
			}
        	
        });
        
        
        //display for Delete Key events to delete an instance
        viewer.getTable().addKeyListener(new KeyListener() {
        	public void keyPressed(KeyEvent e) {}
        	public void keyReleased(KeyEvent e) {
        		if ((e.stateMask==0) && (e.character == SWT.DEL) && (viewer.getSelection()!=null)) {
        			Line line = (Line)((IStructuredSelection)viewer.getSelection()).getFirstElement();
        			//update the underlying role and refresh the table
        			//update the underlying model
        			List<Line> items=(List<Line>)viewer.getInput();
        			items.remove(line);
        			//refresh
        			viewer.refresh();
        			//mark for update
        			markDirty();
        		}
        	}
        });		
	}
	public void create(){
		mainComposite= toolkit.createComposite(parent);
		mainComposite.setLayoutData(
                new GridData(SWT.FILL,SWT.RIGHT,true,true,1,1)
        );		
		mainComposite.setLayout(new GridLayout(columns.size()+1,false));
        
        createLabels();
        createTexts();
        createViewer();        
	}
	
}

