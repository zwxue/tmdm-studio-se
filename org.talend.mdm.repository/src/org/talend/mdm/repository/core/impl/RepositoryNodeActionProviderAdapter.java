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
package org.talend.mdm.repository.core.impl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.ui.navigator.CommonViewer;
import org.talend.core.model.properties.FolderItem;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IRepositoryNodeActionProvider;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.ui.actions.CreateFolderAction;
import org.talend.mdm.repository.ui.actions.ExportObjectAction;
import org.talend.mdm.repository.ui.actions.RemoveFromRepositoryAction;
import org.talend.mdm.repository.ui.actions.RenameObjectAction;
import org.talend.mdm.repository.ui.actions.UpdateServerDefAction;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class RepositoryNodeActionProviderAdapter implements IRepositoryNodeActionProvider {

    static AbstractRepositoryAction exportAction;

    static AbstractRepositoryAction createFolderAction;

    static AbstractRepositoryAction removeFromRepositoryAction;

    protected static AbstractRepositoryAction renameAction;
    // TODO just a demo,remove it in future
    static AbstractRepositoryAction updateServerDefAction;

    public void initCommonViewer(CommonViewer commonViewer) {
        exportAction = new ExportObjectAction();
        createFolderAction = new CreateFolderAction();
        removeFromRepositoryAction = new RemoveFromRepositoryAction();
        updateServerDefAction = new UpdateServerDefAction();
        renameAction = new RenameObjectAction();
        //
        exportAction.initCommonViewer(commonViewer);
        createFolderAction.initCommonViewer(commonViewer);
        removeFromRepositoryAction.initCommonViewer(commonViewer);
        updateServerDefAction.initCommonViewer(commonViewer);
        renameAction.initCommonViewer(commonViewer);
    }

    @Override
    public List<AbstractRepositoryAction> getActions(IRepositoryViewObject viewObj) {
        List<AbstractRepositoryAction> actions = new LinkedList<AbstractRepositoryAction>();
        //
        Item item = viewObj.getProperty().getItem();
        if (item instanceof MDMItem) {
            if (item instanceof ContainerItem) {
                FolderType type = ((FolderItem) item).getType();
                switch (type.getValue()) {
                case FolderType.STABLE_SYSTEM_FOLDER:
                    actions.add(createFolderAction);
                    actions.add(removeFromRepositoryAction);
                    break;
                case FolderType.SYSTEM_FOLDER:

                    break;

                case FolderType.FOLDER:
                    actions.add(createFolderAction);
                    actions.add(removeFromRepositoryAction);
                    break;
                }

            } else if (item instanceof MDMServerObjectItem) {
                actions.add(removeFromRepositoryAction);
                // TODO just a demo,remove it in future
                actions.add(updateServerDefAction);
            }
        }

        //
        actions.add(exportAction);

        return actions;
    }

}
