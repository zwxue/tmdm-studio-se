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
import org.talend.mdm.repository.ui.actions.xsd.XSDSetAnnotationSchematronActionR;
import org.talend.mdm.workbench.enterprice.actions.XSDDeleteAnnotationSchematronAction;
import org.talend.mdm.workbench.enterprice.actions.XSDDeleteValidationRulesAction;
import org.w3c.dom.Element;

import com.amalto.workbench.availablemodel.AbstractAvailableModel;
import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.ISchemaContentProvider;
import com.amalto.workbench.utils.Util;

public class SchematronAvailableModelR extends AbstractAvailableModel {

    public void fillContextMenu(Object obj, IMenuManager manager, DataModelMainPage page, String dataModelName) {
        // delete schematron annotation
        if (obj instanceof Element) {
            Element e = (Element) obj;
            if ("X_Schematron".equals(e.getAttribute("source"))) {//$NON-NLS-1$//$NON-NLS-2$
                manager.add(new XSDDeleteAnnotationSchematronAction(page, dataModelName));
            }
        }

        if (obj instanceof XSDElementDeclaration) {
            if (!Util.IsAImporedElement((XSDElementDeclaration) obj, ((ISchemaContentProvider) page.getTreeViewer()
                    .getContentProvider()).getXsdSchema())) {
                if (manager.find(XSDSetAnnotationSchematronActionR.ActionID) == null)
                    manager.add(new XSDSetAnnotationSchematronActionR(page, dataModelName));
                if (manager.find(XSDDeleteValidationRulesAction.ActionID) == null)
                    manager.add(new XSDDeleteValidationRulesAction(page));
            }
        }

    }

    public void doubleClickOnElement(int type, DataModelMainPage page, String dataModelName) {
        switch (type) {
        case 109:
            new XSDSetAnnotationSchematronActionR(page, dataModelName).run();
            break;
        }
    }
}
