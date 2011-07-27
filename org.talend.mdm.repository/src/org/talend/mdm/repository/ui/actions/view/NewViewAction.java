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

import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSViewItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSBooleanE;
import org.talend.mdm.repository.model.mdmserverobject.WSViewE;
import org.talend.mdm.repository.model.mdmserverobject.WSWhereConditionE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
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
