package com.amalto.workbench.actions;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComponent;
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.SimpleXpathInputDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDSetAnnotationForeignKeyAction extends UndoAction{

	protected SimpleXpathInputDialog sxid = null;
	protected String dataModelName;
	
	public XSDSetAnnotationForeignKeyAction(DataModelMainPage page,String dataModelName) {
		super(page);
		setImageDescriptor(ImageCache.getImage( EImage.PRIMARYKEY.getPath()));
		setText("Set the Foreign Key");
		setToolTipText("Set the Foreign Key");
		this.dataModelName = dataModelName;
	}
	
	public IStatus doAction() {
		try {
            IStructuredSelection selection = (TreeSelection)page.getTreeViewer().getSelection();
            XSDComponent xSDCom=null;
            if (selection.getFirstElement() instanceof Element) {
				TreePath tPath = ((TreeSelection) selection).getPaths()[0];
				for (int i = 0; i < tPath.getSegmentCount(); i++) {
					if (tPath.getSegment(i) instanceof XSDAnnotation)
						xSDCom = (XSDAnnotation) (tPath.getSegment(i));
				}
			} else
            xSDCom = (XSDComponent)selection.getFirstElement();
            XSDAnnotationsStructure struc=null;
			if(xSDCom!=null)
            		    struc =new XSDAnnotationsStructure(xSDCom);
            if (struc==null||struc.getAnnotation() == null) {
            	throw new RuntimeException("Unable to edit an annotation for object of type "+xSDCom.getClass().getName());
            }
            
       		
            sxid = new SimpleXpathInputDialog(
       				page,
       				"Set the Foreign Key",
       				"Enter an xPath for the Foreign Key - Leave BLANK to delete the Foreign Key",
       				struc.getForeignKey(),
       				new SelectionListener() {
            			public void widgetDefaultSelected(SelectionEvent e) {}
            			public void widgetSelected(SelectionEvent e) {
            				sxid.close();
            			}
            		}, dataModelName
       				
       		);
            
            sxid.setBlockOnOpen(true);
       		int ret = sxid.open();
       		if (ret == Window.CANCEL){
                return Status.CANCEL_STATUS;
       		}
       		
       		
       		struc.setForeignKey("".equals(sxid.getXpath()) ? null : sxid.getXpath().replaceAll("'|\"", ""));
       		
       		if (struc.hasChanged()) {
       			page.refresh();
       			page.getTreeViewer().expandToLevel(xSDCom, 2);
       			page.markDirty();
       		}
       		
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to set a Foreign Key: "+e.getLocalizedMessage()
			);
            return Status.CANCEL_STATUS;
		}
        return Status.OK_STATUS;
	}
	
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}