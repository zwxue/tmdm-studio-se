// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.dialogs;

import java.rmi.RemoteException;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xsd.XSDSchema;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.core.service.RepositoryWebServiceAdapter;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

import com.amalto.workbench.dialogs.SelectImportedModulesDialog;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC Administrator  class global comment. Detailled comment
 */
public class SelectImportedModulesDialog2 extends SelectImportedModulesDialog {

    MDMServerDef serverDef;
    public SelectImportedModulesDialog2(Shell parentShell, XSDSchema schema, TreeObject treeObj, String title) {
        super(parentShell, schema, treeObj, title);

    }

    @Override
    protected XtentisPort getPort() throws XtentisException {
        SelectServerDefDialog dialog = new SelectServerDefDialog(getShell());
            if (dialog.open() == IDialogConstants.OK_ID) {
                MDMServerDef serverDef = dialog.getSelectedServerDef();
                this.serverDef = serverDef;
                return RepositoryWebServiceAdapter.getXtentisPort(serverDef);
            }
        return null;
    }

    @Override
    protected boolean resolveSchemaList(List<String> schemaList) throws XtentisException, RemoteException {
        List<String> newList = RepositoryQueryService.findAllDataModelNames();
        for (String string : newList) {
            schemaList.add(string);
        }

        return true;
    }

    @Override
    protected String getUrl() {
        return ""; //$NON-NLS-1$
    }

}
