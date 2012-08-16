// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.migrate;

import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;


/**
 * DOC HHB  class global comment. Detailled comment
 */
public interface IMigrateObjectPathRule {
    public ERepositoryObjectType getRepositoryObjectType();
    public String[] getAllNewFolderNames();

    public Item getRootFolderItem();

    public void setRootFolderItem(Item item);
    public String routeObject(IRepositoryViewObject viewObj);

    public String[] routeFolderObject(IRepositoryViewObject folderViewObj);

    public boolean isToMigrateFolder(IRepositoryViewObject folderViewObj);
}
