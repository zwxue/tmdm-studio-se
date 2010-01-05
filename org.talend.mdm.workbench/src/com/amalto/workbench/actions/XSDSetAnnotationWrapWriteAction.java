package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.AnnotationOrderedListsDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XSDAnnotationsStructure;
/**
 * set  the Roles with Write Access when selections is multiple
 * @author liyanmei
 *
 */
public class XSDSetAnnotationWrapWriteAction extends UndoAction {
	protected AnnotationOrderedListsDialog dlg = null;
	protected boolean isChanged = false;
	public XSDSetAnnotationWrapWriteAction(DataModelMainPage page) {
		super(page);
		setImageDescriptor(ImageCache.getImage("icons/annotation.gif"));
		setText("Set the Roles with Write Access");
		setToolTipText("Set the Roles That Have Write Access");
	}

	
	public IStatus doAction() {
		try {
            IStructuredSelection selections = (TreeSelection)page.getTreeViewer().getSelection();
            XSDComponent xSDCom=null;
            XSDAnnotationsStructure struc =new XSDAnnotationsStructure(xSDCom);
            if(selections.isEmpty())
            	return Status.CANCEL_STATUS;
         

			dlg = new AnnotationOrderedListsDialog(new ArrayList(), new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					dlg.close();
				}
			}, page.getSite().getShell(),
					"Set The Roles That Have Write Access", "Roles", page,
					AnnotationOrderedListsDialog.AnnotationWrite_ActionType,
					null);

			dlg.setBlockOnOpen(true);
			int ret = dlg.open();
			if (ret == Window.CANCEL) {
	            return Status.CANCEL_STATUS;
			}
			 for(Iterator iterator = selections.iterator(); iterator.hasNext();){
				 Object toWri = (Object) iterator.next();
					UndoAction wriExecute = null;
					boolean isElem = true;
					 if (toWri instanceof Element) {
							TreePath tPath = ((TreeSelection) toWri).getPaths()[0];
							for (int i = 0; i < tPath.getSegmentCount(); i++) {
								if (tPath.getSegment(i) instanceof XSDAnnotation)
									xSDCom = (XSDAnnotation) (tPath.getSegment(i));
							}
						} else
			            xSDCom = (XSDComponent)toWri;
					 struc =new XSDAnnotationsStructure(xSDCom); 	
			 		  if (struc.getAnnotation() == null) {
							throw new RuntimeException("Unable to edit an annotation for object of type "+ xSDCom.getClass().getName());}

			 
				 struc.setAccessRole(dlg.getXPaths(), dlg.getRecursive(),
					(IStructuredContentProvider) page.getTreeViewer()
							.getContentProvider(), "X_Write");
				 
				 if(struc.hasChanged())
					 isChanged = true;
			 }//for(Iterator

			if (isChanged) {
				page.refresh();
				page.getTreeViewer().expandToLevel(xSDCom,2);
				page.markDirty();
			}

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(page.getSite().getShell(), "Error",
					"An error occured trying to set the Write Access: "
							+ e.getLocalizedMessage());
            return Status.CANCEL_STATUS;
		}
        return Status.OK_STATUS;
	
	}
	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
	
	public boolean checkInWriteType(Object[] selects)
	{
		for (Object obj : selects) {
			if (obj instanceof XSDElementDeclaration
					|| obj instanceof XSDParticle
					|| obj instanceof XSDAnnotation
					|| obj instanceof XSDSimpleTypeDefinition) {
				if(Util.IsAImporedElement((XSDConcreteComponent)obj, page.reConfigureXSDSchema(false)))
						return false;
				continue;
			}
			
			else 
				return false;
		}

		return true;
	}
}

