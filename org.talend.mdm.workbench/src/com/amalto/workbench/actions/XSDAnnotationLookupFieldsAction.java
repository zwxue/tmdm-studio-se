package com.amalto.workbench.actions;

import java.util.ArrayList;

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
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.AnnotationOrderedListsDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDAnnotationLookupFieldsAction extends UndoAction {

	protected AnnotationOrderedListsDialog dlg = null;

	public XSDAnnotationLookupFieldsAction(DataModelMainPage page) {
		super(page);
		setImageDescriptor(ImageCache.getImage( EImage.BROWSE.getPath()));
		setText("Set Lookup Fields");
		setToolTipText("Set Lookup Fields");
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
 		   struc.setXSDSchema(schema);
//			IStructuredSelection selection = (IStructuredSelection) page
//					.getTreeViewer().getSelection();
//			XSDAnnotationsStructure struc = new XSDAnnotationsStructure(
//					(XSDComponent) selection.getFirstElement());
			if (struc.getAnnotation() == null) {
				throw new RuntimeException(
						"Unable to edit an annotation for object of type "
								+ xSDCom.getClass()
										.getName());
			}

			dlg = new AnnotationOrderedListsDialog(new ArrayList(struc
					.getLookupFields().values()), new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					dlg.close();
				}
			}, page.getSite().getShell(),
					"Set Lookup Fields", "Lookup Fields", page,
					AnnotationOrderedListsDialog.AnnotationLookupField_ActionType,
					null);

			dlg.setBlockOnOpen(true);
			int ret = dlg.open();
			if (ret == Window.CANCEL) {
	            return Status.CANCEL_STATUS;
			}

			struc.setAccessRole(dlg.getXPaths(), false,
					(IStructuredContentProvider) page.getTreeViewer()
							.getContentProvider(), "X_Lookup_Field");

			if (struc.hasChanged()) {
				page.refresh();
				page.getTreeViewer().expandToLevel(xSDCom,
						2);
				page.markDirty();
			}

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(page.getSite().getShell(), "Error",
					"An error occured trying to set the Lookup Fields: "
							+ e.getLocalizedMessage());
            return Status.CANCEL_STATUS;
		}
        return Status.OK_STATUS;
	}

	public void runWithEvent(Event event) {
		super.runWithEvent(event);
	}
}
