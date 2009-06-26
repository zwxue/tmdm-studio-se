package com.amalto.workbench.actions;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTypeDefinition;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.XSDTreeContentProvider;
import com.amalto.workbench.utils.EImage;
import com.amalto.workbench.utils.ImageCache;
import com.amalto.workbench.utils.Util;

public class XSDDeleteElementAction extends UndoAction{

	//private DataModelMainPage page = null;
	private XSDSchema schema = null;
	private XSDElementDeclaration xsdElem = null;
	
	public XSDDeleteElementAction(DataModelMainPage page) {
		super(page);
		//this.page = page;
		setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
		setText("Delete Element");
		setToolTipText("Delete an Element");
	}
	/**
	 * Author: Fiu 
	 * this function is meant to support deletion on key press
	 * which can pass a specific object to be deleted
	 * @param toDel
	 */
	public void run(Object toDel)
	{
		if (!(toDel instanceof XSDElementDeclaration)) {
			return;
		}
		xsdElem = (XSDElementDeclaration) toDel;
		
		super.run();
	}
	
	public void doAction() {
		try {
			
            schema = ((XSDTreeContentProvider)page.getTreeViewer().getContentProvider()).getXsdSchema();
            // xsdElem is to support the multiple delete action on key press,
			// which each delete action on element must be explicit passed a xsdElem to
			// delete
            XSDElementDeclaration decl = xsdElem;
            if (decl == null){
                ISelection selection = page.getTreeViewer().getSelection();
                decl = (XSDElementDeclaration)((IStructuredSelection)selection).getFirstElement();
            }

            ArrayList<Object> objList = new ArrayList<Object>();
    		IStructuredContentProvider provider = (IStructuredContentProvider) page
			.getTreeViewer().getContentProvider();
    		Object[] all = Util.getAllObject(page.getSite(), objList, provider);
            Util.deleteReference(decl, all);

            //backup current Type Definition
            XSDTypeDefinition current = decl.getTypeDefinition();
            
            //remove declaration
            schema.getContents().remove(decl);
            
            //remove type definition is no more used and type is not built in
//       	    if (current != null && (current.getName()!=null) &&  //anonymous type
//       	    		(!schema.getSchemaForSchemaNamespace().equals(current.getTargetNamespace()))
//       	    	){
//       			if (Util.findElementsUsingType(schema,current.getTargetNamespace(), current.getName()).size()==0)
//       				schema.getContents().remove(current);
//			}

            schema.update();
            
            xsdElem = null;
       		page.getTreeViewer().refresh(true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to remove the Element: "+e.getLocalizedMessage()
			);
		}		
	}
	@Override
	protected IStatus undo() {
		if(xsdElem !=null ){
			schema.getContents().add(xsdElem);
			schema.update();
		}
		return super.undo();
	}

	
    public void setXSDTODel(XSDElementDeclaration elem) {
		xsdElem = elem;
	}
}