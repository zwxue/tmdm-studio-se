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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComponent;
import org.w3c.dom.Element;

import com.amalto.workbench.dialogs.SimpleXpathInputDialog;
import com.amalto.workbench.dialogs.ValidationRuleExcpressDialog;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XSDAnnotationsStructure;

public class XSDVisibleRuleAction extends UndoAction {

    private static Log log = LogFactory.getLog(XSDVisibleRuleAction.class);

    protected SimpleXpathInputDialog sxid = null;

    protected String dataModelName;

    protected boolean isDelete = false;

    protected XSDAnnotationsStructure struc;

    protected String conceptName;

    public XSDVisibleRuleAction(DataModelMainPage page, String dataModelName) {
        super(page);
        setImageDescriptor(ImageCache.getImage(EImage.ROUTINE.getPath()));
        setText(Messages.SetVisibleRule);
        setToolTipText(Messages.SetVisibleRule);
        this.dataModelName = dataModelName;
    }

    public XSDVisibleRuleAction(DataModelMainPage page, String dataModelName, boolean isDelete) {
        super(page);
        setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
        setText(Messages.DeleteVisibleRule);
        setToolTipText(Messages.DeleteVisibleRule);
        this.dataModelName = dataModelName;
        this.isDelete = isDelete;
    }

    public IStatus doAction() {
        try {

            // add by ymli. fix the bug:0010293
            if (page.isDirty()) {
                // MessageDialog.openWarning(page.getSite().getShell(), "Worning", "Please save the Data Model first!");
                boolean save = MessageDialog.openConfirm(page.getSite().getShell(), Messages.SaveResource, Messages.bind(Messages.modifiedChanges, page.getXObject().getDisplayName()));
                if (save) {
                    IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().saveEditor(part, false);
                }
                else
                    return Status.CANCEL_STATUS;
            }
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
            conceptName = Util.getConceptName(xSDCom);
            struc = null;
            if (xSDCom != null)
                struc = new XSDAnnotationsStructure(xSDCom);
            if (struc == null || struc.getAnnotation() == null) {
                throw new RuntimeException(Messages.bind(Messages.UnableEditType, xSDCom.getClass().getName()));
            }
            // Modified by hbhong,to fix bug 21784|Add a TreeParent parameter to constructor
            if (!isDelete) {
                ValidationRuleExcpressDialog dlg = getExpressDialog();
            // The ending| bug:21784
            dlg.create();
            dlg.getShell().setMaximized(false);
            // dlg.getShell().setSize(new Point(640,560));
            dlg.setBlockOnOpen(true);
            int ret = dlg.open();
            if (ret == Window.OK) {
                struc.setVisibleRule(dlg.getExpression());
            }
            } else {
                struc.setVisibleRule(""); //$NON-NLS-1$
            }

            if (struc.hasChanged()) {
                page.refresh();
                page.getTreeViewer().expandToLevel(xSDCom, 2);
                page.markDirty();
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(page.getSite().getShell(), Messages._Error,
                    Messages.bind(Messages.ErrorSetVisibleRule, e.getLocalizedMessage()));
            return Status.CANCEL_STATUS;
        }
        return Status.OK_STATUS;
    }

    protected ValidationRuleExcpressDialog getExpressDialog() {
        return new ValidationRuleExcpressDialog(page.getSite().getShell(), getTreeParent(),
                Messages.XSDVisibleRuleAction_buildValidationRule, struc.getVisibleRule(), conceptName, true, false);
    }
}
