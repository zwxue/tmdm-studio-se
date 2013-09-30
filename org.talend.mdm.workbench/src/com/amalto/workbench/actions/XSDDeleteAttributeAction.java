// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.xsd.XSDAttributeUse;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDConcreteComponent;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * created by liusongbo on 2013-9-30
 */
public class XSDDeleteAttributeAction extends UndoAction {

    private static Log log = LogFactory.getLog(XSDDeleteAttributeAction.class);

    private XSDAttributeUse attribute;

    public XSDDeleteAttributeAction(DataModelMainPage page) {
        super(page);
        setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
        setText(Messages.XSDDeleteAttributeAction_label);
        setToolTipText(Messages.XSDDeleteAttributeAction_label);
    }

    @Override
    protected IStatus doAction() {
        try {

            XSDAttributeUse attri = attribute;
            if (attri == null) {
                ISelection selection = page.getTreeViewer().getSelection();
                attri = (XSDAttributeUse) ((IStructuredSelection) selection).getFirstElement();
            }

            if (attri.getContainer() == null) {
                return Status.CANCEL_STATUS;
            }

            XSDConcreteComponent container = attri.getContainer();
            if (container instanceof XSDComplexTypeDefinition) {
                XSDComplexTypeDefinition cType = (XSDComplexTypeDefinition) container;
                cType.getAttributeUses().remove(attri);
                cType.getAttributeContents().remove(attri);
                cType.updateElement();
            }

            schema.update();

            attribute = null;
            page.refresh();
            page.markDirtyWithoutCommit();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(page.getSite().getShell(), Messages._Error,
                    Messages.bind(Messages.XSDDeleteElementAction_ErrorMsg, e.getLocalizedMessage()));
            return Status.CANCEL_STATUS;
        }
        return Status.OK_STATUS;
    }

    public void setXSDAttribute(XSDAttributeUse attribute) {
        this.attribute = attribute;
    }
}
