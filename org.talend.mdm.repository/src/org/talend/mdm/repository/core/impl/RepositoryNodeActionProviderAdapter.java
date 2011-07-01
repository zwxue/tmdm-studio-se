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
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IRepositoryNodeActionProvider;
import org.talend.mdm.repository.models.ContainerRepositoryObject;
import org.talend.mdm.repository.ui.actions.CreateFolderAction;
import org.talend.mdm.repository.ui.actions.ExportObjectAction;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class RepositoryNodeActionProviderAdapter implements IRepositoryNodeActionProvider {

    AbstractRepositoryAction exportAction;

    AbstractRepositoryAction createFolderAction;
    public void initCommonViewer(CommonViewer commonViewer) {
        exportAction = new ExportObjectAction();
        createFolderAction = new CreateFolderAction();
        //
        exportAction.initCommonViewer(commonViewer);
        createFolderAction.initCommonViewer(commonViewer);
    }

    @Override
    public List<AbstractRepositoryAction> getActions(IRepositoryViewObject viewObj) {
        List<AbstractRepositoryAction> actions = new LinkedList<AbstractRepositoryAction>();
        //
        if (viewObj instanceof ContainerRepositoryObject) {
            FolderType type = ((FolderItem) viewObj.getProperty().getItem()).getType();
            if (type.getValue() != FolderType.SYSTEM_FOLDER) {
                actions.add(createFolderAction);
            }
        }
        //
        actions.add(exportAction);
        return actions;
    }

}
