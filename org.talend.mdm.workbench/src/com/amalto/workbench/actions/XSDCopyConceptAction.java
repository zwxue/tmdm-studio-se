package com.amalto.workbench.actions;

import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDParticle;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.WorkbenchClipboard;

public class XSDCopyConceptAction extends Action {
	private DataModelMainPage page;
	private  String displayName = "Copy Entity";
	public XSDCopyConceptAction(DataModelMainPage page,String title) {
		super();
		//if(multi)
		displayName = title;
		this.page = page;
		setImageDescriptor(ImageCache.getImage(EImage.COPY.getPath()));
		setText(displayName);
		setToolTipText(displayName);
	}

	//public IStatus doAction() {
	public void run() {
		try {
			WorkbenchClipboard.getWorkbenchClipboard().conceptsReset();
			WorkbenchClipboard.getWorkbenchClipboard().particlesReset();
			IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
			if(selection.getFirstElement() instanceof XSDElementDeclaration){
				for (Iterator<XSDElementDeclaration> iter = selection.iterator(); iter.hasNext(); ) {
					XSDElementDeclaration concept = iter.next();
				
					if (concept instanceof XSDElementDeclaration) 
						WorkbenchClipboard.getWorkbenchClipboard().add(concept);
				}
			}
			else if(selection.getFirstElement() instanceof XSDParticle){
				for (Iterator<XSDParticle> iter = selection.iterator(); iter.hasNext(); ) {
					XSDParticle particle = iter.next();
					
					if (particle instanceof XSDParticle) 
						WorkbenchClipboard.getWorkbenchClipboard().add(particle);
				}
			}
				
		}catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to copy Entity: "+e.getLocalizedMessage()
			);

		}
		//return true;
	}

}
