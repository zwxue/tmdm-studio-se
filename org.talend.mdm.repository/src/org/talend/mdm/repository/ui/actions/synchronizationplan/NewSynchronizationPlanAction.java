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
package org.talend.mdm.repository.ui.actions.synchronizationplan;

import java.util.ArrayList;
import java.util.List;

import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSSynchronizationPlanItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanE;
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC class global comment. Detailled comment <br/>
 * 
 */
public class NewSynchronizationPlanAction extends AbstractSimpleAddAction {

    private String[] OBJECT_NAMES = { "Background Job", "Data Cluster", "Data Model", "Item", "Menu", "Role", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
            "Routing Engine V2", "Routing Order V2 Active", "Routing Order V2 Completed", "Routing Order V2 Failed", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            "Routing Rule", "Service", "Stored Procedure", "Synchronization Conflict", "Transformer Plugin V2", "Transformer V2", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
            "Universe", "View" }; //$NON-NLS-1$ //$NON-NLS-2$

    public NewSynchronizationPlanAction() {
        super();
    }

    @Override
    protected String getDialogTitle() {
        return Messages.NewSynchronizationPlanAction_newSynchronizationPlan;
    }

    private WSSynchronizationPlanE newSynchronizationPlan(String key) {

        List<WSSynchronizationPlanXtentisObjectsSynchronizationsE> objectsId = new ArrayList<WSSynchronizationPlanXtentisObjectsSynchronizationsE>();

        for (String name : OBJECT_NAMES) {
            WSSynchronizationPlanXtentisObjectsSynchronizationsE objectXc = MdmserverobjectFactory.eINSTANCE
                    .createWSSynchronizationPlanXtentisObjectsSynchronizationsE();
            objectXc.setXtentisObjectName(name);
            objectsId.add(objectXc);
        }

        WSSynchronizationPlanE synchronizationplan = MdmserverobjectFactory.eINSTANCE.createWSSynchronizationPlanE();

        synchronizationplan.setName(key);
        synchronizationplan.setDescription(""); //$NON-NLS-1$
        synchronizationplan.setRemoteSystemName(""); //$NON-NLS-1$
        synchronizationplan.setRemoteSystemURL(""); //$NON-NLS-1$
        synchronizationplan.setRemoteSystemUsername(""); //$NON-NLS-1$
        synchronizationplan.setRemoteSystemPassword(""); //$NON-NLS-1$
        synchronizationplan.setTisURL(""); //$NON-NLS-1$
        synchronizationplan.setTisUsername(""); //$NON-NLS-1$
        synchronizationplan.setTisPassword(""); //$NON-NLS-1$
        synchronizationplan.setTisParameters(""); //$NON-NLS-1$
        synchronizationplan.getXtentisObjectsSynchronizations().addAll(objectsId);

        return synchronizationplan;

    }

    protected boolean createServerObject(String key) {

        WSSynchronizationPlanItem item = MdmpropertiesFactory.eINSTANCE.createWSSynchronizationPlanItem();

        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);

        WSSynchronizationPlanE synchronizationplan = newSynchronizationPlan(key);
        item.setWsSynchronizationPlan(synchronizationplan);

        if (parentItem != null) {
            item.getState().setPath(parentItem.getState().getPath());
            return RepositoryResourceUtil.createItem(item, key);
        }
        return true;
    }

}
