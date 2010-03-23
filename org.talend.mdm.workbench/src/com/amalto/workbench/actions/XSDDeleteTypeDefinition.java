package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.providers.ISchemaContentProvider;
import com.amalto.workbench.utils.Util;

public class XSDDeleteTypeDefinition extends  UndoAction{
	
	private XSDComplexTypeDefinition xsdCmpexType;
	private XSDSimpleTypeDefinition xsdSimpType;
	

	public XSDDeleteTypeDefinition(DataModelMainPage page) {
		super(page);
		setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
		setText("Delete type definition");
		setToolTipText("Remove a type definition from the XSD Schema context");
		setDescription(getToolTipText());
	}
	public XSDDeleteTypeDefinition(DataModelMainPage page,boolean isMulti) {
		super(page);
		setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
		if(isMulti)
			setText("Delete type definitions");
		else
			setText("Delete type definition");
		setToolTipText("Remove a type definition from the XSD Schema context");
		setDescription(getToolTipText());
	}
	public void run(Object toDel)
	{
		if (!(toDel instanceof XSDComplexTypeDefinition||toDel instanceof XSDSimpleTypeDefinition)) {
			return;
		}
		if(toDel instanceof XSDComplexTypeDefinition)
			xsdCmpexType = (XSDComplexTypeDefinition) toDel;
		else
			xsdSimpType = (XSDSimpleTypeDefinition) toDel;
		run();
	}
	
	public IStatus doAction() {
		IStructuredSelection selection = (IStructuredSelection) page.getTreeViewer().getSelection();
		XSDSchema schema = ((ISchemaContentProvider)page.getTreeViewer().getContentProvider()).getXsdSchema();
		
		ArrayList<Object> objList = new ArrayList<Object>();
		Util.getAllObject(page.getSite(), objList, (IStructuredContentProvider)page.getSchemaContentProvider());
		Util.getAllObject(page.getSite(), objList, (IStructuredContentProvider)page.getTypeContentProvider());
		
		//edit by ymli; fix the bug:0012228. Made the multiple types can be deleted.
		for (Iterator<XSDTypeDefinition> iter = selection.iterator(); iter.hasNext(); ) {
			
			XSDTypeDefinition type = iter.next();
		//if (selection.getFirstElement() instanceof XSDSimpleTypeDefinition) {
			if(type instanceof XSDSimpleTypeDefinition) {
			//XSDSimpleTypeDefinition simpleType = (XSDSimpleTypeDefinition)selection.getFirstElement();
			XSDSimpleTypeDefinition simpleType = (XSDSimpleTypeDefinition)type;
			if(xsdSimpType!=null)
				simpleType = xsdSimpType;
			boolean find = Util.findElementsUsingType(objList,simpleType);
			if(find){
				boolean confirmed = MessageDialog
					.openConfirm(page.getSite().getShell(), "Confirm Delete",
						"The simple-type definition: \"" + simpleType.getName() + "\" is referred to by at least one element. Are you sure you want to proceed?\n" +
						"\nIf you click OK, this will leave one element or more with an invalid simple-type.");
				if (!confirmed) {
					xsdSimpType = null;
					return Status.CANCEL_STATUS;
				}
			}//iif(!list.isEmpty())
			schema.getContents().remove(simpleType);
		}//if (selection.getFirstElement()
		else{

			//XSDComplexTypeDefinition complxType = (XSDComplexTypeDefinition)selection.getFirstElement();
			XSDComplexTypeDefinition complxType = (XSDComplexTypeDefinition)type;
			if (xsdCmpexType != null) {
				complxType = xsdCmpexType;
			}

			boolean find = Util.findElementsUsingType(objList, complxType);
			if (find)
			{
				boolean confirmed = MessageDialog
					.openConfirm(page.getSite().getShell(), "Confirm Delete",
					"The complex-type definition: \"" + complxType.getName() + "\" is referred to by at least one element. Are you sure you want to proceed?\n" +
					"\nIf you click OK, this will leave one element or more with an invalid complex-type.");
				if (!confirmed) {
					xsdCmpexType = null;
					return Status.CANCEL_STATUS;
				}
			}
			schema.getContents().remove(complxType);
		}

		}
		xsdCmpexType = null;
		page.refresh();
		page.markDirty();
		
		return Status.OK_STATUS;
	}
	
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	
    public void setXSDTODel(XSDComplexTypeDefinition elem) {
    	xsdCmpexType = elem;
	}
    public void setXSDTODel(XSDSimpleTypeDefinition xsdSimpType) {
		this.xsdSimpType = xsdSimpType;
	}
    
    public boolean isTypeDefinition(Object[] selectedObjs){
    	boolean typeDefinition = true;
    	boolean isAllComplexType = false;
    	for (Object obj : selectedObjs) {
			if (!(obj instanceof XSDSimpleTypeDefinition) &&  !(obj instanceof XSDComplexTypeDefinition))
				{
				typeDefinition = false;
				break;
				}
			else if(!(obj instanceof XSDComplexTypeDefinition))
				isAllComplexType = true;
				
		}
    	if(selectedObjs.length==1)
    		isAllComplexType = true;
    	return typeDefinition && isAllComplexType;
    }
}
