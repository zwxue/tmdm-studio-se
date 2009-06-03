package com.amalto.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDSchema;

import com.amalto.workbench.dialogs.SimpleXpathInputDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.XSDTreeContentProvider;
import com.amalto.workbench.utils.ImageCache;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDSetAnnotationForeignKeyAction extends Action{

	protected DataModelMainPage page = null;
	protected XSDSchema schema = null;
	protected SimpleXpathInputDialog sxid = null;
	
	public XSDSetAnnotationForeignKeyAction(DataModelMainPage page) {
		super();
		this.page = page;
		setImageDescriptor(ImageCache.getImage( "icons/annotation.gif"));
		setText("Set the Foreign Key");
		setToolTipText("Set the Foreign Key");
	}
	
	public void run() {
		try {
			super.run();
            schema = ((XSDTreeContentProvider)page.getTreeViewer().getContentProvider()).getXsdSchema();
            IStructuredSelection selection = (IStructuredSelection)page.getTreeViewer().getSelection();
            XSDAnnotationsStructure struc = new XSDAnnotationsStructure((XSDComponent)selection.getFirstElement());
            if (struc.getAnnotation() == null) {
            	throw new RuntimeException("Unable to edit an annotation for object of type "+selection.getFirstElement().getClass().getName());
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
            		}
       		);
            
            sxid.setBlockOnOpen(true);
       		int ret = sxid.open();
       		if (ret == Window.CANCEL) return;
       		
       		
       		struc.setForeignKey("".equals(sxid.getXpath()) ? null : sxid.getXpath());
       		
       		if (struc.hasChanged()) {
       			page.getTreeViewer().refresh(true);
       			page.getTreeViewer().expandToLevel(selection.getFirstElement(), 2);
       			page.markDirty();
       		}
       		
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to set a Foreign Key: "+e.getLocalizedMessage()
			);
		}		
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}