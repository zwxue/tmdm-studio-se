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
package org.talend.mdm.repository.ui.actions.xsd;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.ui.editors.DataModelMainPage2;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;

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

        //
        if(page.getEditorInput() instanceof IRepositoryViewEditorInput) {            
            IRepositoryViewEditorInput editorInput = (IRepositoryViewEditorInput) page.getEditorInput();
            IRepositoryViewObject viewObject = editorInput.getViewObject();
            
            Item item = viewObject.getProperty().getItem();
            MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
            
            DeployService deployService = DeployService.getInstance();
            if (deployService.isAutoDeploy()) {
                deployService.autoDeploy(page.getSite().getShell(), viewObject);
            } else if (serverObject.getLastServerDef() != null) {
                CommandManager.getInstance().pushCommand(ICommand.CMD_MODIFY, viewObject);
            }
        }
    }
}
