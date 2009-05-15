package com.amalto.workbench.dialogs;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
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
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

public class AnnotationOrderedListsDialog extends Dialog {
	
	
	protected Text labelText;
	protected TableViewer viewer;
	
	protected ArrayList<String> xPaths = new ArrayList<String>();
	private SelectionListener caller = null;
	private String title = "";
	private String columnName = "";
	
	

	/**
	 * @param parentShell
	 */
	public AnnotationOrderedListsDialog(ArrayList<String> xPaths, SelectionListener caller, Shell parentShell, String title, String columnName) {
		super(parentShell);
		setShellStyle(this.getShellStyle() | SWT.RESIZE);
		this.xPaths = xPaths;
		this.caller = caller;
		this.title = title;			
		this.columnName = columnName;
	}


	protected Control createDialogArea(Composite parent) {
						
		//Should not really be here but well,....
		parent.getShell().setText(this.title);
		
		Composite composite = (Composite) super.createDialogArea(parent);
		
		GridLayout layout = (GridLayout)composite.getLayout();
		layout.numColumns = 3;
		//layout.verticalSpacing = 10;
        
        labelText = new Text(composite, SWT.BORDER|SWT.SINGLE);
        labelText.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
        );
        ((GridData)labelText.getLayoutData()).minimumWidth = 300;
        labelText.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				if ((e.stateMask==0) && (e.character == SWT.CR)){
					xPaths.add(labelText.getText());
	        		viewer.refresh();
				}
			}
        });
        
        Button addLabelButton = new Button(composite,SWT.PUSH | SWT.CENTER);
        addLabelButton.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
        );
        addLabelButton.setText("Set");
        addLabelButton.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				xPaths.add(labelText.getText());
        		viewer.refresh();
        	};
        });
		
        final String COLUMN = columnName;
        
        viewer = new TableViewer(composite,SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER|SWT.FULL_SELECTION);
        viewer.getControl().setLayoutData(    
                new GridData(SWT.FILL,SWT.FILL,true,true,2,1)
        );
        ((GridData)viewer.getControl().getLayoutData()).heightHint=100;
        // Set up the underlying table
        Table table = viewer.getTable();
        //table.setLayoutData(new GridData(GridData.FILL_BOTH));

        new TableColumn(table, SWT.CENTER).setText(COLUMN);
        table.getColumn(0).setWidth(400);
        for (int i = 1, n = table.getColumnCount(); i < n; i++) {
          table.getColumn(i).pack();
        }
        
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        // Create the cell editors --> We actually discard those later: not natural for an user
        CellEditor[] editors = new CellEditor[2];
        editors[0] = new TextCellEditor(table);
        viewer.setCellEditors(editors);
        
        //set the content provider
        viewer.setContentProvider(new IStructuredContentProvider() {
        	public void dispose() {}
        	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
        	public Object[] getElements(Object inputElement) {
//        		System.out.println("getElements() ");
        		ArrayList<String> xPaths = (ArrayList<String>)inputElement; 
        		ArrayList<DescriptionLine> lines = new ArrayList<DescriptionLine>();
        		for (Iterator iter = xPaths.iterator(); iter.hasNext(); ) {
					String xPath = ((String) iter.next());
					DescriptionLine line = new DescriptionLine(xPath);
					lines.add(line);
				}
        		//we return an instance line made of a Sring and a boolean
        		return lines.toArray(new DescriptionLine[lines.size()]);
        	}
        });
        
        //set the label provider
        viewer.setLabelProvider(new ITableLabelProvider() {
        	public boolean isLabelProperty(Object element, String property) {return false;}
        	public void dispose() {}
        	public void addListener(ILabelProviderListener listener) {}
        	public void removeListener(ILabelProviderListener listener) {}
        	public String getColumnText(Object element, int columnIndex) {
//        		System.out.println("getColumnText() "+columnIndex);
        		DescriptionLine line = (DescriptionLine) element;
        		switch (columnIndex) {
        		    case 0:
        		      return line.getLabel();
    		    }
        		return "";
        	}
        	public Image getColumnImage(Object element, int columnIndex) {return null;}
        });

        // Set the column properties
        viewer.setColumnProperties(new String[]{COLUMN});
        
        //set the Cell Modifier
        viewer.setCellModifier(new ICellModifier() {
        	public boolean canModify(Object element, String property) {
        		//if (INSTANCE_ACCESS.equals(property)) return true; Deactivated
        		return false;
        	}
        	public void modify(Object element, String property, Object value) {
//        		System.out.println("modify() "+element.getClass().getName()+": "+property+": "+value);
        		//DescriptionLine line = (DescriptionLine)((IStructuredSelection)instancesViewer.getSelection()).getFirstElement();
        		//deactivated: editing in places is not natural for users 
        	}
        	public Object getValue(Object element, String property) {
//        		System.out.println("getValue() "+property);
        		DescriptionLine line = (DescriptionLine) element;
        		if (COLUMN.equals(property)) {
        			return line.getLabel();
        		}
        		return null;
        	}
        });
        
        //Listen for changes in the selection of the viewer to display additional parameters
        viewer.addSelectionChangedListener(new ISelectionChangedListener() {
        	public void selectionChanged(SelectionChangedEvent event) {}
        });
        
        //display for Delete Key events to delete an instance
        viewer.getTable().addKeyListener(new KeyListener() {
        	public void keyPressed(KeyEvent e) {}
        	public void keyReleased(KeyEvent e) {
//        		System.out.println("Table keyReleased() ");
        		if ((e.stateMask==0) && (e.character == SWT.DEL) && (viewer.getSelection()!=null)) {
        			DescriptionLine line = (DescriptionLine)((IStructuredSelection)viewer.getSelection()).getFirstElement();
        			ArrayList<String> xPaths = (ArrayList<String>)viewer.getInput(); 
        			xPaths.remove(line.getLabel());
        			viewer.refresh();
        		}
        	}
        });
       
		viewer.setInput(xPaths);
        viewer.refresh();
        
        
        Composite rightButtonsComposite = new Composite(composite,SWT.NULL);
        rightButtonsComposite.setLayout(new GridLayout(1,true));
        rightButtonsComposite.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
        );
        
        Button upButton = new Button(rightButtonsComposite,SWT.PUSH | SWT.CENTER);
        upButton.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
        );
        upButton.setText("Up");
        upButton.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
    			DescriptionLine line = (DescriptionLine)((IStructuredSelection)viewer.getSelection()).getFirstElement();
    			if (line == null) return;
    			int i = 0;
    			for (Iterator iter = xPaths.iterator(); iter.hasNext(); ) {
					String xPath = (String) iter.next();
					if (xPath.equals(line.getLabel())) {
						if (i>0) {
							xPaths.remove(i);
							xPaths.add(i-1,xPath);
							viewer.refresh();
							viewer.getTable().setSelection(i-1);
							viewer.getTable().showSelection();
						}
						return;
					}
					i++;
				}
        	};
        });
        Button downButton = new Button(rightButtonsComposite,SWT.PUSH | SWT.CENTER);
        downButton.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
        );
        downButton.setText("Down");
        downButton.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
    			DescriptionLine line = (DescriptionLine)((IStructuredSelection)viewer.getSelection()).getFirstElement();
    			if (line==null) return;
    			int i = 0;
    			for (Iterator iter = xPaths.iterator(); iter.hasNext(); ) {
					String xPath = (String) iter.next();
					if (xPath.equals(line.getLabel())) {
						if (i<xPaths.size()-1) {
							xPaths.remove(i);
							xPaths.add(i+1,xPath);
							viewer.refresh();
							viewer.getTable().setSelection(i+1);
							viewer.getTable().showSelection();
						}
						return;
					}
					i++;
				}
        	};
        });
        Button delButton = new Button(rightButtonsComposite,SWT.PUSH | SWT.CENTER);
        delButton.setLayoutData(
                new GridData(SWT.FILL,SWT.FILL,false,true,1,1)
        );
        delButton.setText("Delete");
        delButton.addSelectionListener(new SelectionListener() {
        	public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {};
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
    			DescriptionLine line = (DescriptionLine)((IStructuredSelection)viewer.getSelection()).getFirstElement();
    			if (line!=null) {
	    			ArrayList<String> xPaths = (ArrayList<String>)viewer.getInput(); 
	    			xPaths.remove(line.getLabel());
	    			viewer.refresh();
    			}
        	};
        });

		labelText.setFocus();
		
	    return composite;
	}

	
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		getButton(IDialogConstants.OK_ID).addSelectionListener(this.caller);
		getButton(IDialogConstants.CANCEL_ID).addSelectionListener(this.caller);
	}
	
	@Override
	protected void okPressed() {
		setReturnCode(OK);
		getButton(IDialogConstants.OK_ID).setData("dialog",AnnotationOrderedListsDialog.this);
		//no close let Action Handler handle it
	}
	 @Override
	protected void cancelPressed() {
		setReturnCode(CANCEL);
		getButton(IDialogConstants.CANCEL_ID).setData("dialog",AnnotationOrderedListsDialog.this);
		//no close let Action Handler handle it
	}
	 

	/**************************************************************************************************
	 * Public getters read by caller
	 ***************************************************************************************************/

	/*
	public TableViewer getDescriptionsTableViewer() {
		return descriptionsViewer;
	}
	*/
	
	public ArrayList<String> getXPaths() {
		return xPaths;
	}
	
	
	/**************************************************************************************************
	 * A table viewer line
	 ***************************************************************************************************/
	class DescriptionLine {
		private String label;
		public DescriptionLine(String label) {
			super();
			this.label = label;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
	}
	
	
	
}
