// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2012 Talend �C www.talend.com
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
package org.talend.mdm.repository.core.impl.view;

import java.util.List;

import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.impl.AbstractContentProvider;
import org.talend.mdm.repository.core.migrate.IMigrateObjectPathRule;
import org.talend.mdm.repository.core.migrate.MigrateObjectPathProcess;
import org.talend.mdm.repository.core.migrate.impl.ViewMigrateObjectPathRule;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSView;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class ViewContentProvider extends AbstractContentProvider {

    IMigrateObjectPathRule rule = new ViewMigrateObjectPathRule();

    MigrateObjectPathProcess process = new MigrateObjectPathProcess(rule);

    boolean migrated = false;
    @Override
    protected List<IRepositoryViewObject> getViewObjFromSystemFolder(Item parentItem) {
        // if(parentItem instanceof ContainerItem) {
        // try {
        // Thread.sleep(30000);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // String path = parentItem.getState().getPath();
        // if (path != null && path.length() == 0 && !migrated) {
        // if (rule.getRootFolderItem() == null) {
        // rule.setRootFolderItem(parentItem);
        // }
        // System.out.println(">>>>>>>>>>>>>\n>>>>>>>>>>>>>>>>>>>>>>>>");
        // migrated = true;
        // process.run();
        //
        // }
        // }
        List<IRepositoryViewObject> resultList = RepositoryResourceUtil.findViewObjectsByType(
                IServerObjectRepositoryType.TYPE_VIEW, parentItem, TreeObject.VIEW);

        return resultList;
    }


    public Class<?> getWSObjectClass() {
        return WSView.class;
    }
}
