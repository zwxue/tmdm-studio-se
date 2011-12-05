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
package org.talend.mdm.repository.ui.actions.xsd;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.talend.mdm.repository.ui.editors.DataModelMainPage2;

import com.amalto.workbench.actions.XSDNewBrowseItemViewAction;
import com.amalto.workbench.editors.DataModelMainPage;

public class XSDNewBrowseItemViewActionR extends XSDNewBrowseItemViewAction {

    public XSDNewBrowseItemViewActionR(DataModelMainPage page) {
        super(page);
    }

    protected void pageSave() {
        if (page instanceof DataModelMainPage2)
            ((DataModelMainPage2) page).setGenView(true);
        page.SaveWithForce(new NullProgressMonitor());

    }
}
