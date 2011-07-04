// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.workbench.serverexplorer.ui.providers;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class ServerSorter extends ViewerSorter {

    public int compare(Viewer viewer, Object e1, Object e2) {
        MDMServerDefItem mdmItem1 = getMDMItem((IRepositoryViewObject) e1);
        MDMServerDefItem mdmItem2 = getMDMItem((IRepositoryViewObject) e2);
        if (mdmItem1 != null && mdmItem2 != null) {
            MDMServerDef serverDef1 = mdmItem1.getServerDef();
            MDMServerDef serverDef2 = mdmItem2.getServerDef();
            return serverDef1.getName().toLowerCase().compareTo(serverDef2.getName().toLowerCase());
        }
        return 0;
    }

    private MDMServerDefItem getMDMItem(IRepositoryViewObject viewObject) {
        if (viewObject != null) {
            return (MDMServerDefItem) (viewObject.getProperty().getItem());
        }
        return null;
    }
}
