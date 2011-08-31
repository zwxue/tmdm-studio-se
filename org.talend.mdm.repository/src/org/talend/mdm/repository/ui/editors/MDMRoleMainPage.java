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
package org.talend.mdm.repository.ui.editors;

import java.util.List;

import org.eclipse.ui.forms.editor.FormEditor;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.workbench.enterprice.editors.RoleMainPage;

import com.amalto.workbench.utils.XtentisException;

public class MDMRoleMainPage extends RoleMainPage {

    public MDMRoleMainPage(FormEditor editor) {
        super(editor);
    }

    protected String[] getTheObjects() {
        String[] objects = RepositoryWebServiceAdapter.getTheObjectsForRole();
        return objects;
    }

    public void feedInstanceNameCombo() throws Exception {

        try {

            if ("Data Model".equals(objectTypesCombo.getText())) {//$NON-NLS-1$ 
                List<String> list = RepositoryQueryService.findAllDataModelNames();
                String[] objects = new String[list.size()];
                sortAndInstanceNameCombo(list.toArray(objects));

            } else if ("Data Cluster".equals(objectTypesCombo.getText())) {//$NON-NLS-1$

                List<String> list = RepositoryQueryService.findAllDataContainerNames();
                String[] objects = new String[list.size()];
                sortAndInstanceNameCombo(list.toArray(objects));

            } else if ("Role".equals(objectTypesCombo.getText())) {//$NON-NLS-1$
                List<String> list = RepositoryQueryService.findAllRoleNames();
                String[] objects = new String[list.size()];
                sortAndInstanceNameCombo(list.toArray(objects));

            } else if ("Menu".equals(objectTypesCombo.getText())) {//$NON-NLS-1$
                List<String> list = RepositoryQueryService.findAllMenuNames();
                String[] objects = new String[list.size()];
                sortAndInstanceNameCombo(list.toArray(objects));

            } else if ("Routing Rule".equals(objectTypesCombo.getText())) {//$NON-NLS-1$
                List<String> list = RepositoryQueryService.findAllRoutingRuleNames();
                String[] objects = new String[list.size()];
                sortAndInstanceNameCombo(list.toArray(objects));

            } else if ("Stored Procedure".equals(objectTypesCombo.getText())) {//$NON-NLS-1$
                List<String> list = RepositoryQueryService.findAllStoredProcedureNames();
                String[] objects = new String[list.size()];
                sortAndInstanceNameCombo(list.toArray(objects));

            } else if ("View".equals(objectTypesCombo.getText())) {//$NON-NLS-1$
                List<String> list = RepositoryQueryService.findAllViewNames();
                String[] objects = new String[list.size()];
                sortAndInstanceNameCombo(list.toArray(objects));

                // change the String to match the real name of the object Transformer.
            } else if ("Transformer V2".equals(objectTypesCombo.getText())) {//$NON-NLS-1$


                List<String> list = RepositoryQueryService.findAllTransformerV2Names();
                String[] objects = new String[list.size()];
                sortAndInstanceNameCombo(list.toArray(objects));

            } else if ("Universe".equals(objectTypesCombo.getText())) {//$NON-NLS-1$

                List<String> list = RepositoryQueryService.findAllUniverseNames();
                String[] objects = new String[list.size()];
                sortAndInstanceNameCombo(list.toArray(objects));

            }

        }
        catch (Exception e) {
            throw new XtentisException("Unable to find the instances of object " + objectTypesCombo.getText() + ": "
                    + e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
