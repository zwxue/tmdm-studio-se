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
package org.talend.mdm.repository.ui.actions.view;

import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSViewItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSBooleanE;
import org.talend.mdm.repository.model.mdmserverobject.WSViewE;
import org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.ui.dialogs.ViewInputDialog2;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC class global comment. Detailled comment <br/>
 * 
 */
public class NewViewAction extends AbstractSimpleAddAction {


    public NewViewAction() {
        super();
    }


    @Override
    protected String getDialogTitle() {
        return Messages.NewViewAction_newView;
    }

    private WSViewE newView(String key) {

        WSWhereConditionE condi = MdmserverobjectFactory.eINSTANCE.createWSWhereConditionE();
        WSBooleanE bol = MdmserverobjectFactory.eINSTANCE.createWSBooleanE();
        bol.set_true(false);

        WSViewE view = MdmserverobjectFactory.eINSTANCE.createWSViewE();

        view.setName(key);
        view.setDescription(""); //$NON-NLS-1$
        view.setViewableBusinessElements(new String[] {});
        view.getWhereConditions().add(condi);
        view.setSearchableBusinessElements(new String[] {});
        view.setTransformerPK(null);
        view.setIsTransformerActive(bol);

        return view;
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
        ViewInputDialog2 vid = new ViewInputDialog2(site, getShell(), getDialogTitle(),

        Messages.Common_inputName, "Browse_items_", new IInputValidator() {//$NON-NLS-1$

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
                }, false);
        vid.setBtnShow(true);
        vid.create();
        vid.getShell().setSize(new Point(500, 180));
        vid.setBlockOnOpen(true);
        if (vid.open() == Window.CANCEL)
            return;
        String key = vid.getValue();

        createServerObject(key);
        commonViewer.refresh(selectObj);
        commonViewer.expandToLevel(selectObj, 1);

    }
    protected boolean createServerObject(String key) {

        WSViewItem item = MdmpropertiesFactory.eINSTANCE.createWSViewItem();

        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);
        //
        WSViewE view = newView(key);
        item.setWsView(view);

        if (parentItem != null) {
            item.getState().setPath(parentItem.getState().getPath());
            return RepositoryResourceUtil.createItem(item, key);
        }
        return true;
    }


}
