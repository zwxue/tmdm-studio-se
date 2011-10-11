// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.widgets.xmleditor.infoholder;

import java.util.List;

import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
class RepositoryProcessesNamesHolder extends RepositoryExternalInfoHolder<String[]> {

    private XtentisPort port;

    public RepositoryProcessesNamesHolder(XtentisPort port) {
        this.port = port;
    }

    @Override
    public String[] getExternalInfo() {

        List<IRepositoryViewObject> viewObjs = RepositoryResourceUtil
                .findAllViewObjects(IServerObjectRepositoryType.TYPE_TRANSFORMERV2);
        String[] names = new String[viewObjs.size()];
        int i = 0;
        for (IRepositoryViewObject viewObj : viewObjs) {
            Property prop = viewObj.getProperty().getItem().getProperty();
            names[i] = prop.getLabel();
            i++;
        }

        return names;
    }

    @Override
    public String getId() {
        return INFOID_ALLPROCESSNAMES;
    }

}
