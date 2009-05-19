package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDParticle;

import com.amalto.workbench.AmaltoWorbenchPlugin;
import com.amalto.workbench.dialogs.BusinessElementInputDialog;
import com.amalto.workbench.editors.DataModelMainPage;

public class XSDEditParticleAction extends Action implements SelectionListener{

	private DataModelMainPage page = null;
	private BusinessElementInputDialog dialog = null;
	
	private String  elementName;
	private String  refName;
	private int minOccurs;
	private int maxOccurs;
	
	public XSDEditParticleAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AmaltoWorbenchPlugin.getImageDescriptor( "icons/edit_obj.gif"));
		setText("Edit Element");
		setToolTipText("Edit the Business Element Name and Cardinality.");
	}
	
	public void run() {
		try {
			super.run();
            
            IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
            XSDParticle selParticle = (XSDParticle) selection.getFirstElement();
            
            if (!(selParticle.getTerm() instanceof XSDElementDeclaration)) return;

			XSDElementDeclaration decl = (XSDElementDeclaration) selParticle.getContent();

			XSDElementDeclaration ref = null;
			if (decl.isElementDeclarationReference()) {
				//it is a ref
				ref = decl.getResolvedElementDeclaration();
			}
			  
			EList eDecls = decl.getSchema().getElementDeclarations();
			
			ArrayList<String> elementDeclarations = new ArrayList<String>();
			for (Iterator iter = eDecls.iterator(); iter.hasNext(); ) {
				XSDElementDeclaration d = (XSDElementDeclaration) iter.next();
				elementDeclarations.add(d.getQName());
			}
			elementDeclarations.add("");
			
            dialog = new BusinessElementInputDialog(
            		this,
            		page.getSite().getShell(),
            		"Edit Business Element",
            		decl.getName(),
            		ref==null ? null : ref.getQName(),
        			elementDeclarations,
            		selParticle.getMinOccurs(),
            		selParticle.getMaxOccurs()
            );
            dialog.setBlockOnOpen(true);
       		int ret = dialog.open();
       		if (ret == Window.CANCEL) return;

       		//find reference
       		XSDElementDeclaration newRef = null;
       		if (! "".equals(refName.trim())) {
    			for (Iterator iter = eDecls.iterator(); iter.hasNext(); ) {
    				XSDElementDeclaration d = (XSDElementDeclaration) iter.next();
    				if (d.getQName().equals(refName)) {
    					newRef = d;
    					break;
    				}
    			}
				if (newRef==null) {
					MessageDialog.openError(
							this.page.getSite().getShell(), 
							"Error", "The Referenced Element "+refName+" cannot be found"
					);
					return;
				}
       		}//ref
       		
       		decl.setName("".equals(this.elementName) ? null : this.elementName);
       		
       		if (newRef!=null) {
       			decl.setResolvedElementDeclaration(newRef);
       			decl.updateElement();
       		} else if (ref!=null) {
       			//no more element declarations --> we create a new Declaration
       			//FIXME: dereferecning and element is buggy
       			XSDElementDeclaration newD = (XSDElementDeclaration)ref.cloneConcreteComponent(true, true);
       			newD.updateElement();
       			selParticle.setContent(newD);
       		}
       		
       		selParticle.setMinOccurs(this.minOccurs);
       		selParticle.setMaxOccurs(this.maxOccurs);
       		selParticle.updateElement();
       		
       		page.getTreeViewer().refresh(true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to Edit a Business Elementt: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}

	/********************************
	 * Listener to input dialog
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	public void widgetSelected(SelectionEvent e) {
		if (dialog.getReturnCode() ==  -1) return; //there was a validation error
		elementName = dialog.getElementName();
		refName = dialog.getRefName();
		minOccurs = dialog.getMinOccurs();
		maxOccurs = dialog.getMaxOccurs();
		dialog.close();		
	}
	


}