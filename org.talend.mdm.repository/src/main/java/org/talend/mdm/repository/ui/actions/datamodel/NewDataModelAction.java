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
package org.talend.mdm.repository.ui.actions.datamodel;

import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSDataModelItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSDataModelE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class NewDataModelAction extends AbstractSimpleAddAction {

    /**
     * DOC hbhong NewDataModelAction constructor comment.
     * 
     * @param text
     */
    public NewDataModelAction() {
        super();
    }

    @Override
    protected String getDialogTitle() {
        return Messages.NewDataModelAction_newDataModel;
    }

    private WSDataModelE newBlankDataModel(String key) {

        WSDataModelE dataModel = MdmserverobjectFactory.eINSTANCE.createWSDataModelE();
        dataModel.setName(key);
        //
        String defaultXSD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"//$NON-NLS-1$//$NON-NLS-2$
                + "<xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"/>"; //$NON-NLS-1$

        dataModel.setXsdSchema(defaultXSD);
        //
        return dataModel;
    }

    protected boolean createServerObject(String key) {

        WSDataModelItem item = MdmpropertiesFactory.eINSTANCE.createWSDataModelItem();
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);
        //
        WSDataModelE dataModel = newBlankDataModel(key);
        item.setWsDataModel(dataModel);

        if (parentItem != null) {
            item.getState().setPath(parentItem.getState().getPath());
            return RepositoryResourceUtil.createItem(item, key);
        }
        return false;
    }

}
