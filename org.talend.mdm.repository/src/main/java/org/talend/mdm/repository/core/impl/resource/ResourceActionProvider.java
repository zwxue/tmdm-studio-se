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
package org.talend.mdm.repository.core.impl.resource;

import java.util.List;

import org.eclipse.ui.navigator.CommonViewer;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.impl.RepositoryNodeActionProviderAdapter;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmproperties.WSResourceItem;
import org.talend.mdm.repository.model.mdmserverobject.WSResourceE;
import org.talend.mdm.repository.ui.actions.resource.NewResourceAction;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.ui.editors.ResourceRepositoryFileEditorInput;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class ResourceActionProvider extends RepositoryNodeActionProviderAdapter {

    AbstractRepositoryAction addAction;

    @Override
    public void initCommonViewer(CommonViewer commonViewer) {
        super.initCommonViewer(commonViewer);
        addAction = new NewResourceAction();

        //
        addAction.initCommonViewer(commonViewer);

    }

    @Override
    public List<AbstractRepositoryAction> getActions(IRepositoryViewObject viewObj) {
        try {
            Property property = viewObj.getProperty();
            Item item = property.getItem();
            WSResourceE resource = ((WSResourceItem) item).getResource();
            //

            IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
            Property reload = factory.reload(property);
            IRepositoryViewObject lastVersion = factory.getLastVersion(property.getId());
            Property property2 = lastVersion.getProperty();
            WSResourceItem item2 = (WSResourceItem) property2.getItem();
            WSResourceE resource2 = item2.getResource();
            System.out.println(property == property2);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        //
        List<AbstractRepositoryAction> actions = super.getActions(viewObj);
        if (RepositoryResourceUtil.hasContainerItem(viewObj, FolderType.SYSTEM_FOLDER_LITERAL, FolderType.FOLDER_LITERAL)) {
            actions.add(addAction);

        }
        if (viewObj.getProperty().getItem() instanceof MDMServerObjectItem) {
            // deploy
            actions.add(deployToAction);
            addAction(actions, deployToLastServerAction, viewObj);
        }
        actions.add(deployAllAction);
        return actions;
    }

    @Override
    public IRepositoryViewEditorInput getOpenEditorInput(Item item) {
        return new ResourceRepositoryFileEditorInput(item);
    }

}
