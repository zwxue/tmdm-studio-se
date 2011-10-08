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
package org.talend.mdm.repository.ui.actions.universe;

import java.util.ArrayList;
import java.util.List;

import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSUniverseItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSUniverseE;
import org.talend.mdm.repository.model.mdmserverobject.WSUniverseXtentisObjectsRevisionIDsE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC class global comment. Detailled comment <br/>
 * 
 */
public class NewUniverseAction extends AbstractSimpleAddAction {


    public NewUniverseAction() {
        super();
    }


    @Override
    protected String getDialogTitle() {
        return Messages.NewVersionAction_newVersion;
    }

    private WSUniverseE newWSUniverse(String key) {


        List<WSUniverseXtentisObjectsRevisionIDsE> objectsId = new ArrayList<WSUniverseXtentisObjectsRevisionIDsE>();

        List<String> objects = new ArrayList<String>();
        objects.add("Data Model"); //$NON-NLS-1$
        objects.add("Menu");//$NON-NLS-1$
        objects.add("Role");//$NON-NLS-1$
        objects.add("Routing Rule");//$NON-NLS-1$
        objects.add("Stored Procedure");//$NON-NLS-1$
        objects.add("Synchronization Plan");//$NON-NLS-1$
        objects.add("Transformer V2");//$NON-NLS-1$
        objects.add("View"); //$NON-NLS-1$

        for (String name : objects) {
            WSUniverseXtentisObjectsRevisionIDsE objectIdE = MdmserverobjectFactory.eINSTANCE
                .createWSUniverseXtentisObjectsRevisionIDsE();
            objectIdE.setRevisionID(""); //$NON-NLS-1$
            objectIdE.setXtentisObjectName(name);
            objectsId.add(objectIdE);
        }

        WSUniverseE universe = MdmserverobjectFactory.eINSTANCE.createWSUniverseE();
        universe.setName(key);
        universe.setDescription(""); //$NON-NLS-1$
        universe.getXtentisObjectsRevisionIDs().addAll(objectsId);
        universe.setDefaultItemsRevisionID(""); //$NON-NLS-1$
        
        return universe;

    }

    protected boolean createServerObject(String key) {

        WSUniverseItem item = MdmpropertiesFactory.eINSTANCE.createWSUniverseItem();

        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);

        WSUniverseE universe = newWSUniverse(key);
        universe.setCreated(true);

        item.setWsUniverse(universe);

        if (parentItem != null) {
            item.getState().setPath(parentItem.getState().getPath());
            return RepositoryResourceUtil.createItem(item, key);
        }
        return true;
    }


}
