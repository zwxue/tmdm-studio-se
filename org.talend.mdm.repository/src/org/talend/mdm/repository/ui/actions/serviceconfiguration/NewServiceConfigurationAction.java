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
package org.talend.mdm.repository.ui.actions.serviceconfiguration;

import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSServiceConfigurationItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSServiceConfigurationE;
import org.talend.mdm.repository.model.mdmserverobject.WSServicePutConfigurationE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC jsxie class global comment. Detailled comment <br/>
 * 
 */
public class NewServiceConfigurationAction extends AbstractSimpleAddAction {


    public NewServiceConfigurationAction() {
        super();
    }


    @Override
    protected String getDialogTitle() {
        return Messages.NewServiceConfigurationAction_newServiceConfiguration;
    }

    private WSServiceConfigurationE newServiceConfiguration(String key) {

        WSServicePutConfigurationE putConfig1 = MdmserverobjectFactory.eINSTANCE.createWSServicePutConfigurationE();
        putConfig1.setJndiName("smtp"); //$NON-NLS-1$

        WSServicePutConfigurationE putConfig2 = MdmserverobjectFactory.eINSTANCE.createWSServicePutConfigurationE();
        putConfig2.setJndiName("svn"); //$NON-NLS-1$

        WSServicePutConfigurationE putConfig3 = MdmserverobjectFactory.eINSTANCE.createWSServicePutConfigurationE();
        putConfig3.setJndiName("workflow"); //$NON-NLS-1$

        
        WSServiceConfigurationE serConfig = MdmserverobjectFactory.eINSTANCE.createWSServiceConfigurationE();
        serConfig.setName(key);

        serConfig.getServicePutConfigurations().add(putConfig1);
        serConfig.getServicePutConfigurations().add(putConfig2);
        serConfig.getServicePutConfigurations().add(putConfig3);

        return serConfig;
    }

    protected boolean createServerObject(String key) {

        WSServiceConfigurationItem item = MdmpropertiesFactory.eINSTANCE.createWSServiceConfigurationItem();
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);
        //
        WSServiceConfigurationE serConfig = newServiceConfiguration(key);
        item.setWsServiceConfiguration(serConfig);

        if (parentItem != null) {
            item.getState().setPath(parentItem.getState().getPath());
            return RepositoryResourceUtil.createItem(item, key);
        }
        return false;
    }


}
