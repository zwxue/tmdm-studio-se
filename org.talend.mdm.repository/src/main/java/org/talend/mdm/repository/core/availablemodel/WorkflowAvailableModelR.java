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
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDParticle;
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationWorkflowActionR;
import org.talend.mdm.workbench.enterprice.actions.GenerateWorkflowViewAction;
import org.talend.mdm.workbench.enterprice.availablemodel.WorkflowAvailableModel;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.ISchemaContentProvider;
import com.amalto.workbench.utils.Util;

/**
 * DOC hbhong  class global comment. Detailled comment
 */
public class WorkflowAvailableModelR extends WorkflowAvailableModel {

    public void fillContextMenu(Object obj, IMenuManager manager, DataModelMainPage page, String dataModelName) {
        if (obj instanceof XSDElementDeclaration || obj instanceof XSDParticle) {
            if (manager.find("workflowAccessAction") == null) {//$NON-NLS-1$
                if (!Util.IsAImporedElement((XSDConcreteComponent) obj, ((ISchemaContentProvider) page.getTreeViewer()
                        .getContentProvider()).getXsdSchema())) {
                    manager.add(new XSDSetAnnotationWorkflowActionR(page, dataModelName));
                }
                if (obj instanceof XSDElementDeclaration) {
                    if (!Util.IsAImporedElement((XSDConcreteComponent) obj, ((ISchemaContentProvider) page.getTreeViewer()
                            .getContentProvider()).getXsdSchema()))
                        manager.add(new GenerateWorkflowViewAction(page));
                }
            }
        }
    }

    public void doubleClickOnElement(int type, DataModelMainPage page, String dataModelName) {
        switch (type) {
        case 111:
            new XSDSetAnnotationWorkflowActionR(page, dataModelName).run();
            break;
        }
    }
}
