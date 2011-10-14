// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions.customform;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.WSCustomFormItem;
import org.talend.mdm.repository.model.mdmserverobject.WSCustomFormE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.ui.wizards.customform.NewCustomformWizard;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC achen  class global comment. Detailled comment
 */
public class EditCustomFormAction extends AbstractSimpleAddAction {

    Logger log = Logger.getLogger(EditCustomFormAction.class);

    /**
     * DOC AddProcess constructor comment.
     * 
     * @param text
     */
    public EditCustomFormAction() {
        super();
        setText(Messages.EditAction);
    }

    protected String getDialogTitle() {
        return Messages.EditCustomFormAction_title;
    }

    public void run() {
        parentItem = null;
        WSCustomFormItem cItem=null;
        selectObj = getSelectedObject().get(0);        
        if (selectObj instanceof IRepositoryViewObject) {
            Item pItem = ((IRepositoryViewObject) selectObj).getProperty().getItem();
            cItem=(WSCustomFormItem)pItem;
            cItem.getCustomForm().getDatamodel();
            if (pItem instanceof ContainerItem) {
                parentItem = (ContainerItem) pItem;
            }
        }
        IWorkbenchPartSite site = commonViewer.getCommonNavigator().getSite();
        NewCustomformWizard wizard = new NewCustomformWizard(site, getDialogTitle(),
        
        new IInputValidator() {

            public String isValid(String newText) {
                if (newText == null || newText.trim().length() == 0)
                    return Messages.Common_nameCanNotBeEmpty;
                if (!Pattern.matches("\\w*(#|\\.|\\w*)+\\w+", newText)) {//$NON-NLS-1$
                    return Messages.Common_nameInvalid;
                }
                return null;
            };
        });
        wizard.setDataModelName(cItem.getCustomForm().getDatamodel());
        wizard.setEntityName(cItem.getCustomForm().getEntity());
        wizard.setRole(cItem.getCustomForm().getRole());
        wizard.setFormName(cItem.getCustomForm().getName());
        WizardDialog dlg = new WizardDialog(getShell(), wizard);
        if (dlg.open() == Window.CANCEL)
            return;
        String formName = wizard.getFormName();
        String dataModelName = wizard.getDataModelName();
        String entityName = wizard.getEntityName();
        String role = wizard.getRole();


        // IFolder folder = RepositoryResourceUtil.getFolder(IServerObjectRepositoryType.TYPE_CUSTOM_FORM, parentItem);
        try {
            //            String diagramName = dataModelName + "." + entityName; //$NON-NLS-1$
            // IFile formFile = createFormFile(folder,
            //                    diagramName + "_" + VersionUtils.DEFAULT_VERSION + ".form", diagramName, columnCount, allElements, ancestor); //$NON-NLS-1$ //$NON-NLS-2$
            updateServerObject(cItem, formName, dataModelName, entityName, role);
            commonViewer.refresh(selectObj);
            commonViewer.expandToLevel(selectObj, 1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }


    protected void updateServerObject(WSCustomFormItem item, String formName, String dataModelName, String entityName, String role) {
        WSCustomFormE form = item.getCustomForm();
        //
        form.setDatamodel(dataModelName);
        form.setEntity(entityName);
        form.setRole(role);

        RepositoryResourceUtil.saveItem(item);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction#createServerObject(java.lang.String)
     */
    @Override
    protected boolean createServerObject(String key) {
        return false;
    }
}
