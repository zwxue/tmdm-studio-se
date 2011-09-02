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
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanItemsSynchronizationsE;
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsE;
import org.talend.mdm.repository.model.mdmserverobject.WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC class global comment. Detailled comment <br/>
 * 
 */
public class NewSynchronizationPlanAction extends AbstractSimpleAddAction {


    public NewSynchronizationPlanAction() {
        super();
    }


    @Override
    protected String getDialogTitle() {
        return Messages.NewSynchronizationPlanAction_newSynchronizationPlan;
    }

    private WSSynchronizationPlanE newSynchronizationPlan(String key) {


        List<WSSynchronizationPlanXtentisObjectsSynchronizationsE> objectsId = new ArrayList<WSSynchronizationPlanXtentisObjectsSynchronizationsE>();

        List<String> objects = new ArrayList<String>();
        objects.add("Background Job"); //$NON-NLS-1$
        objects.add("Data Cluster");//$NON-NLS-1$
        objects.add("Data Model");//$NON-NLS-1$
        objects.add("Item");//$NON-NLS-1$
        objects.add("Menu");//$NON-NLS-1$
        objects.add("Role");//$NON-NLS-1$
        objects.add("Routing Engine V2");//$NON-NLS-1$
        objects.add("Routing Order V2 Active"); //$NON-NLS-1$
        objects.add("Routing Order V2 Completed");//$NON-NLS-1$
        objects.add("Routing Order V2 Failed");//$NON-NLS-1$
        objects.add("Routing Rule");//$NON-NLS-1$

        objects.add("Service");//$NON-NLS-1$
        objects.add("Stored Procedure");//$NON-NLS-1$
        objects.add("Synchronization Conflict");//$NON-NLS-1$
        objects.add("Transformer Plugin V2");//$NON-NLS-1$
        objects.add("Transformer V2");//$NON-NLS-1$
        objects.add("Universe");//$NON-NLS-1$
        objects.add("View");//$NON-NLS-1$

        for (String name : objects) {
            WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE objectIdE = MdmserverobjectFactory.eINSTANCE
                    .createWSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizationsE();
            WSSynchronizationPlanXtentisObjectsSynchronizationsE objectXc = MdmserverobjectFactory.eINSTANCE
                    .createWSSynchronizationPlanXtentisObjectsSynchronizationsE();
            objectXc.getSynchronizations().add(objectIdE);
            objectXc.setXtentisObjectName(name);

            objectsId.add(objectXc);
        }

        WSSynchronizationPlanItemsSynchronizationsE itemRId = MdmserverobjectFactory.eINSTANCE
                .createWSSynchronizationPlanItemsSynchronizationsE();

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
        synchronizationplan.getItemsSynchronizations().add(itemRId);



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
