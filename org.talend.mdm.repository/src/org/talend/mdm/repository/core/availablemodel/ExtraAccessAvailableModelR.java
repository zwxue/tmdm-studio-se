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
package org.talend.mdm.repository.core.availablemodel;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.xsd.XSDElementDeclaration;
import org.talend.mdm.repository.ui.actions.xsd.XSDCreateAccessActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDLogicalDeleteAccessActionR;
import org.talend.mdm.repository.ui.actions.xsd.XSDPhysicalDeleteAccessActionR;
import org.w3c.dom.Element;

import com.amalto.workbench.availablemodel.AbstractAvailableModel;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.ISchemaContentProvider;
import com.amalto.workbench.utils.Util;

public class ExtraAccessAvailableModelR extends AbstractAvailableModel {

    public void fillContextMenu(Object obj, IMenuManager manager, DataModelMainPage page, String dataModelName) {

        if (obj instanceof Element) {
            Element e = (Element) obj;
            if ("X_Create".equals(e.getAttribute("source"))) {//$NON-NLS-1$//$NON-NLS-2$
                manager.add(new XSDCreateAccessActionR(page, dataModelName));
            }
            if ("X_LogicalDelete".equals(e.getAttribute("source"))) {//$NON-NLS-1$//$NON-NLS-2$
                manager.add(new XSDLogicalDeleteAccessActionR(page, dataModelName));
            }
            if ("X_PhysicalDelete".equals(e.getAttribute("source"))) {//$NON-NLS-1$//$NON-NLS-2$
                manager.add(new XSDPhysicalDeleteAccessActionR(page, dataModelName));
            }
        }

        if (obj instanceof XSDElementDeclaration) {
            if (!Util.IsAImporedElement((XSDElementDeclaration) obj, ((ISchemaContentProvider) page.getTreeViewer()
                    .getContentProvider()).getXsdSchema())) {
                if (manager.find(XSDCreateAccessActionR.ActionID) == null)
                    manager.add(new XSDCreateAccessActionR(page, dataModelName));
                if (manager.find(XSDLogicalDeleteAccessActionR.ActionID) == null)
                    manager.add(new XSDLogicalDeleteAccessActionR(page, dataModelName));
                if (manager.find(XSDPhysicalDeleteAccessActionR.ActionID) == null)
                    manager.add(new XSDPhysicalDeleteAccessActionR(page, dataModelName));
            }
        }

    }

    public void doubleClickOnElement(int type, DataModelMainPage page, String dataModelName) {
        switch (type) {
        case 118:
            new XSDCreateAccessActionR(page, dataModelName).run();
            break;
        case 119:
            new XSDPhysicalDeleteAccessActionR(page, dataModelName).run();
            break;
        case 120:
            new XSDLogicalDeleteAccessActionR(page, dataModelName).run();
            break;
        }
    }

}
