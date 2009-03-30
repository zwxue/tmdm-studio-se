package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTypeDefinition;

import com.amalto.workbench.AmaltoWorbenchPlugin;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;

public class XSDDeleteParticleAction extends Action{

	private DataModelMainPage page = null;
	
	public XSDDeleteParticleAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AmaltoWorbenchPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/delete_obj.gif"));
		setText("Delete Element");
		setToolTipText("Delete a Business Elementt");
	}
	
	public void run() {
		try {
			super.run();
            IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
            XSDParticle particle = (XSDParticle) selection.getFirstElement();
            XSDTerm term = particle.getTerm();
            
            XSDElementDeclaration decl = null;
            if (term instanceof  XSDElementDeclaration) {
            	decl = (XSDElementDeclaration)particle.getTerm();		            
	            //ask for confimation
	            if (! MessageDialog.openConfirm(
	            		this.page.getSite().getShell(),
	            		"Delete Business Element",
	            		"Are you sure you want to delete the Business Element "+decl.getAliasName()+" ?"
	            )) return;
            } else {
	            if (! MessageDialog.openConfirm(
	            		this.page.getSite().getShell(),
	            		"Delete Group",
	            		"Are you sure you want to delete the nested Group ?"
	            )) return;            	
            }
		   

            if (!(particle.getContainer() instanceof XSDModelGroup))
            	throw new XtentisException("Unknown container "+particle.getContainer().getClass().getName());

            XSDModelGroup group = (XSDModelGroup)particle.getContainer(); 
            group.getContents().remove(particle);

            
            if (term instanceof  XSDElementDeclaration) {
	            //remove type definition is no more used and type is not built in
	            XSDTypeDefinition typeDef = decl.getTypeDefinition();
	       	    if (	(typeDef.getName()!=null) &&  //anonymous type
	       	    		(!typeDef.getSchema().getSchemaForSchemaNamespace().equals(typeDef.getTargetNamespace()))
	       	    	){
	       			if (Util.findElementsUsingType(group.getSchema(),typeDef.getTargetNamespace(), typeDef.getName()).size()==0)
	       				group.getSchema().getContents().remove(typeDef);
				}
            }
            
            group.updateElement();
            
       		page.getTreeViewer().refresh(true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to remove Concept: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}