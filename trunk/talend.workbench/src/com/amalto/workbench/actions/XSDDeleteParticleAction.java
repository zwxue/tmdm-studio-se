package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
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
	private XSDParticle xsdPartle = null;
	
	public XSDDeleteParticleAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AmaltoWorbenchPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/delete_obj.gif"));
		setText("Delete Element");
		setToolTipText("Delete a Business Elementt");
	}
	
	public void run(Object toDel)
	{
		if (!(toDel instanceof XSDParticle)) {
			return;
		}
		xsdPartle = (XSDParticle) toDel;
		run();
	}
	
	public void run() {
		try {
			super.run();
            // xsdPartle is to support the multiple delete action on key press,
			// which each delete action on particle must be explicit passed a xsd particle to
			// delete
            XSDParticle particle = (XSDParticle)xsdPartle ;
            if (particle == null){
                ISelection selection = page.getTreeViewer().getSelection();
                particle = (XSDParticle)((IStructuredSelection)selection).getFirstElement();
            }
            XSDTerm term = particle.getTerm();
            
            XSDElementDeclaration decl = null;
            if (term instanceof  XSDElementDeclaration) {
            	decl = (XSDElementDeclaration)particle.getTerm();		            
            } 
		   
            if (particle.getContainer() == null) {
				return;
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
            xsdPartle = null;
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
	

    public void setXSDTODel(XSDParticle elem) {
    	xsdPartle = elem;
	}
}