package com.amalto.workbench.dialogs;

import java.awt.Panel;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.ServerTreeContentProvider;
import com.amalto.workbench.providers.ServerTreeLabelProvider;
import com.amalto.workbench.views.ServerView;

public class DataModelSelectDialog extends org.eclipse.jface.dialogs.Dialog {

	public DataModelSelectDialog(Shell parentShell) {
		super(parentShell);
		
	}
	private static final long serialVersionUID = 1L;
	protected Label schemaLabel = null;
	private String title = "There are too many records in this data-container to determine the \navailable entities automatically. \nPlease pick a data-model to select the entities from.";
	private String xpath;
	protected Panel panel;
	protected Button add;
	protected SelectionListener listener;
	private ServerTreeContentProvider contentProvider;
	protected TreeViewer domViewer;
	
	protected Control createDialogArea (Composite parent) {
		parent.getShell().setText("Select a Data Model");
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = (GridLayout)composite.getLayout();
		layout.makeColumnsEqualWidth=false;
		schemaLabel = new Label(composite, SWT.NONE);
		schemaLabel.setText(title);
		GridData dg= new GridData(SWT.FILL,SWT.FILL,false,true,1,1);
		domViewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL  | SWT.BORDER);
		domViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		((GridData) domViewer.getControl().getLayoutData()).heightHint = 400;
		((GridData) domViewer.getControl().getLayoutData()).widthHint = 400;
		changeToResource();
		return composite;
	}
	private void changeToResource(){
		TreeParent parent = null;
		for(int i = 0; i< ((TreeParent) ServerView.show().getRoot().getChildren()[0]).getChildren().length;i++){
			parent = (TreeParent) ((TreeParent) ServerView.show().getRoot().getChildren()[0]).getChildren()[i];
			if(parent.getType() == TreeObject.DATA_MODEL)
				break;
		}
		contentProvider=new ServerTreeContentProvider(ServerView.show().getSite(),parent);
		setTreeContentProvider(contentProvider);
		domViewer.setLabelProvider(new ServerTreeLabelProvider());
		domViewer.setSorter(new ViewerSorter()
		{
		    public int category(Object element) {
		    	if (element instanceof TreeParent)
		    	{
		    		TreeParent category = (TreeParent)element;
		    		if (category.getType() == TreeObject.CATEGORY_FOLDER)
		    			return -1;
		    	}
		        return 0;
		    }
		}
		);
		
		domViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent e) {
				StructuredSelection sel = (StructuredSelection) e.getSelection();
				
					TreeObject selectNode = (TreeObject) sel.getFirstElement();
					if(selectNode!=null && selectNode.getType() == TreeObject.DATA_MODEL)
						xpath  = selectNode.getDisplayName();
					else
						xpath  = "";
				sel.getFirstElement();
				
				getButton(IDialogConstants.OK_ID).setEnabled(xpath.length()>0);
			}
		});
		domViewer.setInput(ServerView.show().getSite());
		
	}

	private void setTreeContentProvider(ServerTreeContentProvider treeContentProvider) {
		if(this.domViewer.getContentProvider()!=null){
			this.domViewer.getContentProvider().dispose();
		}
		domViewer.setContentProvider(treeContentProvider);
	}
	
	
	protected Control createButtonBar(Composite parent) {
		Control btnBar = super.createButtonBar(parent);
		getButton(IDialogConstants.OK_ID).setText("OK");
		return btnBar;
	}

	public String getXpath() {
		return xpath;
	}
	
}
