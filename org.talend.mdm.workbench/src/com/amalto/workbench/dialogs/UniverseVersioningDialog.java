package com.amalto.workbench.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.amalto.workbench.widgets.UniverseVersionTreeViewer;

public class UniverseVersioningDialog extends Dialog {
	private IStructuredSelection sel;
	private UniverseVersionTreeViewer treeViewer;
	
	public UniverseVersioningDialog(Shell parentShell,IStructuredSelection selection) {
		
		super(parentShell);
		this.sel=selection;
		// TODO Auto-generated constructor stub
	}
	
	protected Control createDialogArea(Composite parent) {
		
		try {
			//Should not really be here but well,....
			parent.getShell().setText("Universe Versioning");
			Composite composite = (Composite) super.createDialogArea(parent);
			GridLayout layout = (GridLayout)composite.getLayout();
			layout.numColumns=1;
			treeViewer =new UniverseVersionTreeViewer(sel);
			treeViewer.createContents(composite);
			
		    return composite;
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					this.getShell(),
					"Error", 
					"An error occured trying to create the Versioning Dialog: "+e.getLocalizedMessage()
			);
			return null;
		}
	}
	
}
