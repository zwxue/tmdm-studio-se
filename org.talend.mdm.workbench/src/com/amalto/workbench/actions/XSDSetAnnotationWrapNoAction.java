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
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComponent;
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.AnnotationOrderedListsDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.providers.XSDTreeContentProvider;
import com.amalto.workbench.utils.XSDAnnotationsStructure;
/**
 * set the Roles with Hidden Accesses when selections is multiple
 * @author liyanmei
 */
public class XSDSetAnnotationWrapNoAction extends UndoAction {
	protected AnnotationOrderedListsDialog dlg = null;
	protected String dataModelName;
	protected boolean isChanged = false;

	public XSDSetAnnotationWrapNoAction(DataModelMainPage page,String dataModelName) {
		super(page);
		setImageDescriptor(ImageCache.getImage( EImage.SECURITYANNOTATION.getPath()));
		setText("Set the Roles with No Access");
		setToolTipText("Set the Roles That Cannot See This Filed");
		this.dataModelName = dataModelName;
	}

	public IStatus doAction() {
		try {

			schema = ((XSDTreeContentProvider) page.getTreeViewer().getContentProvider()).getXsdSchema();
			IStructuredSelection selections = (TreeSelection) page.getTreeViewer().getSelection();
			XSDComponent xSDCom = null;
			XSDAnnotationsStructure struc = new XSDAnnotationsStructure(xSDCom);
			dlg = new AnnotationOrderedListsDialog(new ArrayList(), new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					dlg.close();
				}
			}, page.getSite().getShell(),
					"Set The Roles That Cannot Access This Field", "Roles",
					page,
					AnnotationOrderedListsDialog.AnnotationHidden_ActionType,
					dataModelName);

			dlg.setBlockOnOpen(true);
			int ret = dlg.open();
			if (ret == Window.CANCEL) {
				return Status.CANCEL_STATUS;
			}

			for (Iterator iterator = selections.iterator(); iterator.hasNext();) {
				Object toHid = (Object) iterator.next();
				if (toHid instanceof Element) {
					TreePath tPath = ((TreeSelection) selections).getPaths()[0];
					for (int i = 0; i < tPath.getSegmentCount(); i++) {
						if (tPath.getSegment(i) instanceof XSDAnnotation)
							xSDCom = (XSDAnnotation) (tPath.getSegment(i));
					}
				} else
					xSDCom = (XSDComponent) toHid;
				struc = new XSDAnnotationsStructure(xSDCom);
				if (struc.getAnnotation() == null) {
					throw new RuntimeException(
							"Unable to edit an annotation for object of type "
									+ xSDCom.getClass().getName());
				}

				struc.setAccessRole(dlg.getXPaths(), dlg.getRecursive(),
						(IStructuredContentProvider) page.getTreeViewer()
								.getContentProvider(), "X_Hide");

				if (struc.hasChanged())
					isChanged = true;
			}

			if (isChanged) {
				page.refresh();
				page.getTreeViewer().expandToLevel(xSDCom, 2);
				page.markDirty();
			}

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(page.getSite().getShell(), "Error",
					"An error occured trying to set the No Access: "
							+ e.getLocalizedMessage());
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

}
