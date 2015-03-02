// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2015 Talend �C www.talend.com
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
package org.talend.mdm.repository.ui.actions.menu;

import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WsMenuItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WsMenuE;
import org.talend.mdm.repository.model.mdmserverobject.WsMenuEntryE;
import org.talend.mdm.repository.model.mdmserverobject.WsMenuMenuEntriesDescriptionsE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class NewMenuAction extends AbstractSimpleAddAction {

    /**
     * DOC hbhong AddMenu constructor comment.
     * 
     * @param text
     */
    public NewMenuAction() {
        super();
    }

    @Override
    protected String getDialogTitle() {
        return Messages.NewMenuAction_newMenu;
    }

    private WsMenuE newBlankMenu(String key) {

        WsMenuMenuEntriesDescriptionsE descriptions = MdmserverobjectFactory.eINSTANCE.createWsMenuMenuEntriesDescriptionsE();
        descriptions.setLabel(key);
        descriptions.setLanguage("en"); //$NON-NLS-1$
        //

        WsMenuEntryE entry = MdmserverobjectFactory.eINSTANCE.createWsMenuEntryE();
        entry.getDescriptions().add(descriptions);
        entry.setId(key);
        //
        WsMenuE menu = MdmserverobjectFactory.eINSTANCE.createWsMenuE();
        menu.setName(key);
        menu.getMenuEntries().add(entry);
        //
        return menu;
    }

    @Override
    protected Item createServerObject(String key) {

        WsMenuItem item = MdmpropertiesFactory.eINSTANCE.createWsMenuItem();
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);
        //
        WsMenuE menu = newBlankMenu(key);
        item.setWsMenu(menu);

        if (parentItem != null) {
            item.getState().setPath(parentItem.getState().getPath());
            RepositoryResourceUtil.createItem(item, key);
        }
        return item;
    }

}
