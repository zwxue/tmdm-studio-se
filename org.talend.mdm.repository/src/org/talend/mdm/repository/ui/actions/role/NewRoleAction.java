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
package org.talend.mdm.repository.ui.actions.role;

import org.eclipse.jface.wizard.WizardDialog;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSRoleItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSRoleE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;



/**
 * DOC class global comment. Detailled comment <br/>
 * 
 */
public class NewRoleAction extends AbstractSimpleAddAction {

    boolean isAdmin;
    public NewRoleAction() {
        super();
    }


    @Override
    protected String getDialogTitle() {
        // return Messages.NewVersionAction_newVersion;
        return ""; //$NON-NLS-1$
    }

    private WSRoleE newRole(String key) {
        WSRoleE role = MdmserverobjectFactory.eINSTANCE.createWSRoleE();
        role.setName(key);
        if (isAdmin) {
            role.setDescription("[EN:Administrator]");
        } else {
            role.setDescription("[EN:Normal User]");
        }



        return role;

    }

    @Override
    public void run() {
        parentItem = null;
        selectObj = getSelectedObject().get(0);
        if (selectObj instanceof IRepositoryViewObject) {
            Item pItem = ((IRepositoryViewObject) selectObj).getProperty().getItem();
            if (pItem instanceof ContainerItem) {
                parentItem = (ContainerItem) pItem;
            }
        }

        NewUserWizard wizard = new NewUserWizard();
        wizard.setWindowTitle("New Role");
        WizardDialog dialog = new WizardDialog(getShell(), wizard);
        dialog.open();
        String key = wizard.getUserName();
        isAdmin = wizard.isAdmin();

        createServerObject(key);
        commonViewer.refresh(selectObj);
        commonViewer.expandToLevel(selectObj, 1);
        

    }

    protected boolean createServerObject(String key) {

        WSRoleItem item = MdmpropertiesFactory.eINSTANCE.createWSRoleItem();

        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);

        WSRoleE role = newRole(key);
        item.setWsRole(role);

        if (parentItem != null) {
            item.getState().setPath(parentItem.getState().getPath());
            return RepositoryResourceUtil.createItem(item, key);
        }
        return true;
    }


}
