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
package org.talend.mdm.repository.ui.wizards.imports.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.talend.core.model.properties.Item;
import org.talend.mdm.repository.ui.wizards.imports.IMDMImportRepositoryItemsWizardExAdapter;
import org.talend.repository.items.importexport.handlers.model.ImportItem;
import org.talend.repository.items.importexport.manager.ResourcesManager;

import com.amalto.workbench.exadapter.ExAdapterManager;

/**
 * created by HHB on 2015-5-4 Detailled comment
 *
 */
public class DataModelImportHandler extends CommonMdmImportHandler {

    private IMDMImportRepositoryItemsWizardExAdapter exAdapter;

    public DataModelImportHandler() {
        this.exAdapter = ExAdapterManager.getAdapter(this, IMDMImportRepositoryItemsWizardExAdapter.class);
    }

    @Override
    public void afterImportingItems(IProgressMonitor monitor, ResourcesManager resManager, ImportItem selectedImportItem) {
        if (exAdapter != null) {
            Item item = selectedImportItem.getItem();
            exAdapter.handleDataModelItem(item);
        }
        super.afterImportingItems(monitor, resManager, selectedImportItem);
    }

}
