// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComponent;
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.AnnotationOrderedListsDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDSetAnnotationWriteAction extends UndoAction {

    private static Log log = LogFactory.getLog(XSDSetAnnotationWriteAction.class);

    protected AnnotationOrderedListsDialog dlg = null;

    public XSDSetAnnotationWriteAction(DataModelMainPage page) {
        super(page);
        setImageDescriptor(ImageCache.getImage(EImage.SECURITYANNOTATION.getPath()));
        setText("Set the Roles with Write Access");
        setToolTipText("Set the Roles That Have Write Access");
    }

    public IStatus doAction() {
        try {
            IStructuredSelection selection = (TreeSelection) page.getTreeViewer().getSelection();
            XSDComponent xSDCom = null;
            if (selection.getFirstElement() instanceof Element) {
                TreePath tPath = ((TreeSelection) selection).getPaths()[0];
                for (int i = 0; i < tPath.getSegmentCount(); i++) {
                    if (tPath.getSegment(i) instanceof XSDAnnotation)
                        xSDCom = (XSDAnnotation) (tPath.getSegment(i));
                }
            } else
                xSDCom = (XSDComponent) selection.getFirstElement();
            XSDAnnotationsStructure struc = new XSDAnnotationsStructure(xSDCom);
            struc.setXSDSchema(schema);
            // IStructuredSelection selection = (IStructuredSelection) page
            // .getTreeViewer().getSelection();
            // XSDAnnotationsStructure struc = new XSDAnnotationsStructure(
            // (XSDComponent) selection.getFirstElement());
            if (struc.getAnnotation() == null) {
                throw new RuntimeException("Unable to edit an annotation for object of type " + xSDCom.getClass().getName());
            }

            dlg = getNewAnnotaionOrderedListsDialog(struc.getWriteAccesses().values());

            dlg.setBlockOnOpen(true);
            int ret = dlg.open();
            if (ret == Window.CANCEL) {
                return Status.CANCEL_STATUS;
            }

            struc.setAccessRole(dlg.getXPaths(), dlg.getRecursive(), (IStructuredContentProvider) page.getTreeViewer()
                    .getContentProvider(), "X_Write");//$NON-NLS-1$

            if (struc.hasChanged()) {
                page.refresh();
                page.getTreeViewer().expandToLevel(xSDCom, 2);
                page.markDirty();
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(page.getSite().getShell(), "Error",
                    "An error occured trying to set the Write Access: " + e.getLocalizedMessage());
            return Status.CANCEL_STATUS;
        }
        return Status.OK_STATUS;
    }

    protected AnnotationOrderedListsDialog getNewAnnotaionOrderedListsDialog(Collection<String> values) {
        return new AnnotationOrderedListsDialog(new ArrayList(values), new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                dlg.close();
            }
        }, page.getSite().getShell(), "Set The Roles That Have Write Access", "Roles", page,//$NON-NLS-2$
                AnnotationOrderedListsDialog.AnnotationWrite_ActionType, null);
    }

    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

}
