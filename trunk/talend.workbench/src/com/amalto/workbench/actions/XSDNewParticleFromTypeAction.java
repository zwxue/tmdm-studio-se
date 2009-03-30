package com.amalto.workbench.actions;

import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;

import com.amalto.workbench.AmaltoWorbenchPlugin;
import com.amalto.workbench.dialogs.BusinessElementInputDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.XSDTreeContentProvider;

public class XSDNewParticleFromTypeAction extends Action implements SelectionListener{

	private DataModelMainPage page = null;
	private XSDSchema schema = null;
	private BusinessElementInputDialog dialog = null;
	private XSDModelGroup group = null;
	
	private String  elementName;
	private int minOccurs;
	private int maxOccurs;
	
	public XSDNewParticleFromTypeAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(AmaltoWorbenchPlugin.imageDescriptorFromPlugin("com.amalto.workbench", "icons/add_obj.gif"));
		setText("Add Element");
		setToolTipText("Add a new Business Element at the top of the Business Elements");
	}
	
	public void run() {
		try {
			super.run();
            schema = ((XSDTreeContentProvider)page.getTreeViewer().getContentProvider()).getXsdSchema();
            
            IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
            if (selection.getFirstElement() instanceof XSDComplexTypeDefinition) {
            	XSDComplexTypeDefinition ctd = (XSDComplexTypeDefinition) selection.getFirstElement();
            	if (!(ctd.getContent() instanceof XSDParticle)) return;
            	if (!(((XSDParticle)ctd.getContent()).getTerm() instanceof XSDModelGroup)) return;
            	group = (XSDModelGroup) ((XSDParticle)ctd.getContent()).getTerm();
            } else if (selection.getFirstElement() instanceof XSDParticle) {
            	group = (XSDModelGroup) ((XSDParticle)selection.getFirstElement()).getTerm();
            } else {
            	System.out.println("UNKNOWN SELECTION: "+selection.getFirstElement().getClass().getName()+"  --  "+selection.getFirstElement());
            	return;
            }
  
            dialog = new BusinessElementInputDialog(this,page.getSite().getShell(),"Add a new Business Element");
            dialog.setBlockOnOpen(true);
       		int ret = dialog.open();
       		if (ret == Dialog.CANCEL) return;
       		
       		XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
       		
       		XSDElementDeclaration decl = factory.createXSDElementDeclaration();
       		decl.setName(this.elementName);
       		decl.setTypeDefinition(schema.resolveSimpleTypeDefinition(schema.getSchemaForSchemaNamespace(), "string"));
       		
       		XSDParticle particle = factory.createXSDParticle();
       		particle.setContent(decl);
       		particle.setMinOccurs(this.minOccurs);
       		particle.setMaxOccurs(this.maxOccurs);
       		
       		group.getContents().add(0,particle);
       		group.updateElement();
       		
       		
       		page.getTreeViewer().refresh(true);
       		page.getTreeViewer().setSelection(new StructuredSelection(particle),true);
       		page.markDirty();
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to create a new Business Element: "+e.getLocalizedMessage()
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
		minOccurs = dialog.getMinOccurs();
		maxOccurs = dialog.getMaxOccurs();
		
		//check that this element does not already exist
        //get position of the selected particle in the container		
        for (Iterator iter = group.getContents().iterator(); iter.hasNext(); ) {
			XSDParticle p = (XSDParticle) iter.next();
			if (p.getTerm() instanceof XSDElementDeclaration) {
				XSDElementDeclaration thisDecl = (XSDElementDeclaration) p.getTerm();
				if (thisDecl.getName().equals(elementName)) {
					MessageDialog.openError(
							page.getSite().getShell(),
							"Error", 
							"The Business Element "+elementName+" already exists."
					);
					return;
				}
			}
		}//for
		
		dialog.close();		
	}
	


}