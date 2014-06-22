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
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xsd.XSDElementDeclaration;
import org.talend.core.GlobalServiceRegister;

import com.amalto.workbench.dialogs.AddBrowseItemsWizard;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.service.IValidateService;
import com.amalto.workbench.utils.Util;

public class XSDNewBrowseItemViewAction extends Action {

    private static Log log = LogFactory.getLog(XSDNewBrowseItemViewAction.class);

    protected DataModelMainPage page;

    private List<XSDElementDeclaration> declList = new ArrayList<XSDElementDeclaration>();

    public XSDNewBrowseItemViewAction(DataModelMainPage page) {
        super();

        this.page = page;
        setImageDescriptor(ImageCache.getImage(EImage.ADD_OBJ.getPath()));
        setText(Messages.XSDNewBrowseItemViewAction_Text);
        setToolTipText(Messages.XSDNewBrowseItemViewAction_Text);
    }

    public void run() {
        if (page.isDirty()) {
            boolean save = MessageDialog.openConfirm(page.getSite().getShell(), Messages.SaveResource,
                    Messages.bind(Messages.modifiedChanges, page.getXObject().getDisplayName())); //$NON-NLS-1$
            if (save) {
                pageSave();
            } else
                return;
        }
        IStructuredSelection selection = (IStructuredSelection) page.getTreeViewer().getSelection();
        declList.clear();
        List list = selection.toList();
        for (Object obj : list) {
            if (obj instanceof XSDElementDeclaration) {
                XSDElementDeclaration declaration = (XSDElementDeclaration) obj;
                if (Util.getParent(obj) == obj)
                    declList.add(declaration);
            }
        }
        // check exist
        IValidateService validateService = (IValidateService) GlobalServiceRegister.getDefault().getService(
                IValidateService.class);
        if (validateService != null) {
            for (Iterator<XSDElementDeclaration> il = declList.iterator(); il.hasNext();) {
                String name = AddBrowseItemsWizard.BROWSE_ITEMS + il.next().getName();

                boolean result = validateService.validateAndAlertObjectExistence(TreeObject.VIEW, name);
                if (!result) {
                    il.remove();
                }
            }
        }
        if (!declList.isEmpty()) {
            //
            AddBrowseItemsWizard wizard = getAddBrowseItemsWizard(declList);
            WizardDialog dialog = new WizardDialog(page.getSite().getShell(), wizard);
            dialog.open();
        }
    }

    protected void pageSave() {
        IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().saveEditor(part, false);
    }

    private AddBrowseItemsWizard getAddBrowseItemsWizard(List<XSDElementDeclaration> declList) {
        Object object = page.getAdapter(AddBrowseItemsWizard.class);
        if (object != null) {
            AddBrowseItemsWizard wizard = (AddBrowseItemsWizard) object;
            wizard.setDeclarations(declList);
            return wizard;
        } else {
            return new AddBrowseItemsWizard(page, declList);
        }
    }

    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }
}
