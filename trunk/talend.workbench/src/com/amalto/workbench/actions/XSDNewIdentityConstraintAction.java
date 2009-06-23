package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDComplexTypeContent;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;
import org.eclipse.xsd.impl.XSDParticleImpl;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.workbench.dialogs.IdentityConstraintInputDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.XSDTreeContentProvider;
import com.amalto.workbench.utils.ImageCache;
import com.amalto.workbench.utils.Util;
import com.sun.xml.xsom.impl.parser.DelayedRef.ModelGroup;

public class XSDNewIdentityConstraintAction extends Action implements SelectionListener{

	private DataModelMainPage page = null;
	private XSDSchema schema = null;
	private IdentityConstraintInputDialog dialog = null;	
	private String  keyName;
	private String fieldName;
	private XSDIdentityConstraintCategory type;
	private XSDElementDeclaration decl=null;
	
	public XSDNewIdentityConstraintAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(ImageCache.getImage( "icons/add_obj.gif"));
		setText("Add Key");
		setToolTipText("Add a new Key");
	}
	

	//	FIXME: Can we have Unique Keys for sub-elements?

	
	public void run() {
		try {
			
            schema = ((XSDTreeContentProvider)page.getTreeViewer().getContentProvider()).getXsdSchema();
            int index = -1;
//            EList list = schema.getIdentityConstraintDefinitions();
         
//            schema.getElement();
            IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
            List<String> childNames=new ArrayList<String>();
            if (selection.getFirstElement() instanceof XSDElementDeclaration){
            	decl = (XSDElementDeclaration) selection.getFirstElement();
            	childNames = Util.getChildElementNames(decl.getElement());
            }
            	
            else if (selection.getFirstElement() instanceof XSDIdentityConstraintDefinition) {
            	XSDIdentityConstraintDefinition selIcd = (XSDIdentityConstraintDefinition) selection.getFirstElement();
            	decl = (XSDElementDeclaration)(selIcd.getContainer());
            	
//            	get position of the selected Identity Constraint in the container (Element Declaration)
            	int i=0;
                for (Iterator iter = decl.getIdentityConstraintDefinitions().iterator(); iter.hasNext(); ) {
    				XSDIdentityConstraintDefinition ic = (XSDIdentityConstraintDefinition) iter.next();
    				if (ic.equals(selIcd)) {
    					index = i;
    					break;
    				}
    				i++;
    			} 
                childNames = Util.getChildElementNames(decl.getElement());
            } else if (selection.getFirstElement() instanceof XSDParticle) {
            	XSDParticle selParticle = (XSDParticle) selection.getFirstElement();
                if (! (selParticle.getTerm() instanceof XSDElementDeclaration)) return;
                decl = (XSDElementDeclaration) selParticle.getTerm();
//                childNames.add(decl.getName());
                
            } else {
            	MessageDialog.openError(this.page.getSite().getShell(),"Error", "huhhh: "+selection.getFirstElement().getClass().getName());
            	return;
            }           
            dialog = new IdentityConstraintInputDialog(this,page.getSite().getShell(),"Add a new Key",childNames,decl.getName());
            dialog.setBlockOnOpen(true);
       		int ret = dialog.open();
       		if (ret == Window.CANCEL) return;
       		
       		XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
       		
       		XSDIdentityConstraintDefinition icd = factory.createXSDIdentityConstraintDefinition();
       		icd.setName(keyName);
       		icd.setIdentityConstraintCategory(type);
       		XSDXPathDefinition selector = factory.createXSDXPathDefinition();
       		selector.setVariety(XSDXPathVariety.SELECTOR_LITERAL);
       		selector.setValue(".");
       		icd.setSelector(selector);
       		XSDXPathDefinition field = factory.createXSDXPathDefinition();
       		field.setVariety(XSDXPathVariety.FIELD_LITERAL);
   			field.setValue(".");
   			//if complex content set name of first field
   			if(fieldName==null || fieldName.trim().length()==0){
	   			if (decl.getTypeDefinition() instanceof XSDComplexTypeDefinition) {
		   			XSDComplexTypeContent ctc = ((XSDComplexTypeDefinition)decl.getTypeDefinition()).getContent();
		   			if (ctc instanceof XSDParticle) {
		   				if (((XSDParticle)ctc).getTerm() instanceof XSDModelGroup) {
		   					XSDModelGroup mg = (XSDModelGroup) ((XSDParticle)ctc).getTerm();
		   					if (mg.getContents().size()>0) 
		   						if (((XSDParticle)mg.getContents().get(0)).getTerm() instanceof XSDElementDeclaration)
		   							field.setValue(((XSDElementDeclaration)(((XSDParticle)mg.getContents().get(0)).getTerm())).getName());
		   				}
		   			}
	   			}
   			}else{
   				field.setValue(fieldName);
   			}
       		icd.getFields().add(field);
 
       		decl.getIdentityConstraintDefinitions().add(index+1, icd);
       		decl.updateElement();
                   		
       		page.getTreeViewer().refresh(true);
       		page.getTreeViewer().setSelection(new StructuredSelection(icd),true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to create a new Key: "+e.getLocalizedMessage()
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

		keyName = dialog.getKeyName();
		fieldName=dialog.getFieldName();
		type = dialog.getType();
		
		//check if key does not already exist
		EList list = schema.getIdentityConstraintDefinitions();
		for (Iterator iter = list.iterator(); iter.hasNext(); ) {
			XSDIdentityConstraintDefinition icd = (XSDIdentityConstraintDefinition) iter.next();
			if (
					(type.equals(XSDIdentityConstraintCategory.UNIQUE_LITERAL)) && 
					(icd.getIdentityConstraintCategory().equals(XSDIdentityConstraintCategory.UNIQUE_LITERAL)) &&
					(icd.getContainer().equals(decl.getContainer()))
				){
				MessageDialog.openError(
						page.getSite().getShell(),
						"Error", 
						"The Business Element already has an unique key"
				);
				return;				
			}			
			if (icd.getName().equals(keyName)) {
				MessageDialog.openError(
						page.getSite().getShell(),
						"Error", 
						"The Key "+keyName+" already exist"
				);
				return;
			}
		}
		
		dialog.close();		
	}
	


}