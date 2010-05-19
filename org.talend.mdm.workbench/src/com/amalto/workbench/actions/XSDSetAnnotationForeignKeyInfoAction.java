package com.amalto.workbench.actions;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
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

import com.amalto.workbench.dialogs.AnnotationOrderedListsDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDSetAnnotationForeignKeyInfoAction extends UndoAction{

	protected AnnotationOrderedListsDialog dlg = null;
	protected String dataModelName;
	
	public XSDSetAnnotationForeignKeyInfoAction(DataModelMainPage page,String dataModelName) {
		super(page);
		setImageDescriptor(ImageCache.getImage( EImage.KEYINFO.getPath()));
		setText("Set the Foreign Key Infos");
		setToolTipText("Set the Foreign Key Infos");
		this.dataModelName = dataModelName;
	}
	
	public IStatus doAction() {
		try {
					//add by ymli. fix the bug:0010293
			if(page.isDirty()){
				boolean save = MessageDialog.openConfirm(page.getSite().getShell(), "Save Resource", "'"+page.getXObject().getDisplayName()+"' has been modified. Save changes?");
				if(save)
					page.doSave(new NullProgressMonitor());
				else
					return Status.CANCEL_STATUS;
			}
			
	
			
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
            	throw new RuntimeException("Unable to edit an annotation for object of type "+xSDCom.getClass().getName());
            }
            
            dlg = new AnnotationOrderedListsDialog(
            		new ArrayList(struc.getForeignKeyInfos().values()),
            		new SelectionListener() {
            			public void widgetDefaultSelected(SelectionEvent e) {}
            			public void widgetSelected(SelectionEvent e) {
            				dlg.close();
            			}
            		},
       				page.getSite().getShell(),
       				"Set the Foreign Key Infos",
       				"xPaths",
       				page,
       				AnnotationOrderedListsDialog.AnnotationForeignKeyInfo_ActionType,
       				dataModelName
       				
       		);
            dlg.setRetrieveFKinfos(struc.getRetrieveFKinfos());
       		dlg.setBlockOnOpen(true);
       		int ret = dlg.open();
       		if (ret == Window.CANCEL) {
                return Status.CANCEL_STATUS;
       		}

       		struc.setForeignKeyInfos(dlg.getXPaths());
       		struc.setRetrieveFKinfos(dlg.isRetrieveFKinfos());
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
					"An error occured trying to set a Forign Key: "+e.getLocalizedMessage()
			);
            return Status.CANCEL_STATUS;
		}
        return Status.OK_STATUS;
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	


}