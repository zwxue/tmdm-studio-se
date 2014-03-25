// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
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
import java.util.Collections;
import java.util.Iterator;

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
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDParticle;
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.AnnotationOrderedListsDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

/**
 * set the Roles with Write Access when selections is multiple
 * 
 * @author liyanmei
 * 
 */
public class XSDSetAnnotationWrapWriteAction extends UndoAction {

    private static Log log = LogFactory.getLog(XSDSetAnnotationWrapWriteAction.class);

    protected AnnotationOrderedListsDialog dlg = null;

    protected boolean isChanged = false;

    public XSDSetAnnotationWrapWriteAction(DataModelMainPage page) {
        super(page);
        setImageDescriptor(ImageCache.getImage(EImage.SECURITYANNOTATION.getPath()));
        setText(Messages.XSDSetAnnXX_Text);
        setToolTipText(Messages.XSDSetAnnXX_ActionTip);
    }

    public IStatus doAction() {
        try {
            IStructuredSelection selections = (TreeSelection) page.getTreeViewer().getSelection();
            XSDComponent xSDCom = null;
            XSDAnnotationsStructure struc = new XSDAnnotationsStructure(xSDCom);
            if (selections.isEmpty())
                return Status.CANCEL_STATUS;

            dlg = getNewAnnotaionOrderedListsDialog(Collections.EMPTY_LIST);

            dlg.setBlockOnOpen(true);
            int ret = dlg.open();
            if (ret == Window.CANCEL) {
                return Status.CANCEL_STATUS;
            }
            for (Iterator iterator = selections.iterator(); iterator.hasNext();) {
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
                    xSDCom = (XSDComponent) toWri;
                struc = new XSDAnnotationsStructure(xSDCom);
                if (struc.getAnnotation() == null) {
                    throw new RuntimeException(Messages.bind(Messages.XSDSetAnnXX_ExceptionInfo, xSDCom.getClass().getName()));
                }

                struc.setAccessRole(dlg.getXPaths(), dlg.getRecursive(), (IStructuredContentProvider) page.getTreeViewer()
                        .getContentProvider(), "X_Write");//$NON-NLS-1$

                if (struc.hasChanged())
                    isChanged = true;
            }// for(Iterator

            if (isChanged) {
                page.refresh();
                page.getTreeViewer().expandToLevel(xSDCom, 2);
                page.markDirty();
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(page.getSite().getShell(), Messages._Error,
                    Messages.bind(Messages.XSDSetAnnXX_ErrorMsg, e.getLocalizedMessage()));
            return Status.CANCEL_STATUS;
        }
        return Status.OK_STATUS;

    }

    protected AnnotationOrderedListsDialog getNewAnnotaionOrderedListsDialog(Collection<String> values) {
        return new AnnotationOrderedListsDialog(new ArrayList(values), new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                dlg.close();
            }
        }, page.getSite().getShell(), Messages.XSDSetAnnXX_DialogTitle, "Roles", page,//$NON-NLS-1$
                AnnotationOrderedListsDialog.AnnotationWrite_ActionType, null);

    }

    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

    public boolean checkInWriteType(Object[] selects) {
        for (Object obj : selects) {
            if (obj instanceof XSDElementDeclaration || obj instanceof XSDParticle || obj instanceof XSDAnnotation) {
                // || obj instanceof XSDSimpleTypeDefinition) {
                if (Util.IsAImporedElement((XSDConcreteComponent) obj, page.reConfigureXSDSchema(false)))
                    return false;
                continue;
            }

            else
                return false;
        }

        return true;
    }
}
