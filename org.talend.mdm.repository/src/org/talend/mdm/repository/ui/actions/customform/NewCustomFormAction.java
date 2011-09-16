// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2011 Talend ¨C www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.mdm.repository.ui.actions.customform;

import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.CustomFormItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmserverobject.CustomForm;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.ui.wizards.customform.NewCustomformWizard;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class NewCustomFormAction extends AbstractSimpleAddAction {

    /**
     * DOC AddProcess constructor comment.
     * 
     * @param text
     */
    public NewCustomFormAction() {
        super();
    }

    protected String getDialogTitle() {
        return "New Custom Form";
    }

    public void run() {
        parentItem = null;
        selectObj = getSelectedObject().get(0);
        if (selectObj instanceof IRepositoryViewObject) {
            Item pItem = ((IRepositoryViewObject) selectObj).getProperty().getItem();
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
                if (RepositoryResourceUtil.isExistByName(parentItem.getRepObjType(), newText.trim())) {
                    return Messages.Common_nameIsUsed;
                }
                return null;
            };
        });
        WizardDialog dlg = new WizardDialog(getShell(), wizard);
        if (dlg.open() == Window.CANCEL)
            return;
        String formName = wizard.getFormName();
        String dataModelName = wizard.getDataModelName();
        String entityName = wizard.getEntityName();
        // TODO wait aiming 1.create file 2.create object
        createServerObject(null);
        commonViewer.refresh(selectObj);
        commonViewer.expandToLevel(selectObj, 1);

    }

    private CustomForm newCustomForm(String key) {

        return null;
    }

    protected boolean createServerObject(String key) {

        CustomFormItem item = MdmpropertiesFactory.eINSTANCE.createCustomFormItem();
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);
        //
        CustomForm form = newCustomForm(key);
        item.setCustomForm(form);

        if (parentItem != null) {
            item.getState().setPath(parentItem.getState().getPath());
            return RepositoryResourceUtil.createItem(item, key);
        }
        return false;
    }

}
