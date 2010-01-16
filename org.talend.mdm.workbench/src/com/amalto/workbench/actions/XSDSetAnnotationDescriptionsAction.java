package com.amalto.workbench.actions;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

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
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComponent;
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.AnnotationLanguageLabelsDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDSetAnnotationDescriptionsAction extends UndoAction{
	
	public XSDSetAnnotationDescriptionsAction(DataModelMainPage page) {
		super(page);
		setImageDescriptor(ImageCache.getImage( EImage.ANNOTATION.getPath()));
		setText("Set the Descriptions");
		setToolTipText("Set the Descriptions of This Element");
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
            		   XSDAnnotationsStructure struc =new XSDAnnotationsStructure(xSDCom);
            if (struc.getAnnotation() == null) {
            	throw new RuntimeException("Unable to set an annotation for object of type "+xSDCom.getClass().getName());
            }
   
            AnnotationLanguageLabelsDialog dlg = new AnnotationLanguageLabelsDialog(
            		struc.getDescriptions(),
					new AnnotationLabelDialogSelectionListener(page),
					page.getEditorSite().getShell(),
					"Set the Descriptions of This Element"
			);
			dlg.setBlockOnOpen(true);
			dlg.open();
            
			if (dlg.getReturnCode() == Window.OK)  {			
				//remove existing annotations with labels
				struc.removeAllDescriptions();
				//add the new ones
				LinkedHashMap<String, String> descriptions = dlg.getDescriptionsMap();
	        	Set<String> isoCodes = descriptions.keySet();
	        	for (Iterator iter = isoCodes.iterator(); iter.hasNext(); ) {
					String isoCode = (String) iter.next();
					struc.setDescription(isoCode, descriptions.get(isoCode));
				}
	        }
			else {
	            return Status.CANCEL_STATUS;
			}
			
			if (struc.hasChanged()) {
				page.markDirty();
				page.refresh();
				page.getTreeViewer().expandToLevel(xSDCom, 2);
			}
       		
       
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(
					page.getSite().getShell(),
					"Error", 
					"An error occured trying to create a new Element: "+e.getLocalizedMessage()
			);
            return Status.CANCEL_STATUS;
		}
		
        return Status.OK_STATUS;
	}
	
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	
	
	
	/**
	 * This class listens to actions on the AnnotationLableDialog
	 * @author bgrieder
	 *
	 */
	class AnnotationLabelDialogSelectionListener implements SelectionListener{
		protected DataModelMainPage dmPage = null;
		
		public AnnotationLabelDialogSelectionListener(DataModelMainPage page) {
			super();
			this.dmPage = page;
		}
		
		public void widgetSelected(SelectionEvent e) {
			AnnotationLanguageLabelsDialog dlg = (AnnotationLanguageLabelsDialog)((Widget)e.getSource()).getData("dialog");
			if (dlg.getReturnCode() == Window.OK)  {
				//No particular check on content
				/*
				if (descriptions.size()==0) {
					MessageDialog.openError(
							viewer.getControl().getShell(),
							"Error", 
							"The Menu Entry must have at least one description"
					);
					return;
				}
				*/
	        }
			dlg.close();

		}
		public void widgetDefaultSelected(SelectionEvent e) {};
	}


}