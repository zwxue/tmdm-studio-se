// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2011 Talend ¨C www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.mdm.repository.core.impl.workflow;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.ui.navigator.CommonViewer;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.impl.RepositoryNodeActionProviderAdapter;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.ui.editors.WorkflowEditorInput;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.repository.utils.RepositoryWorkflowUtil;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class WorkflowActionProvider extends RepositoryNodeActionProviderAdapter {

    AbstractRepositoryAction addAction;

    @Override
    public void initCommonViewer(CommonViewer commonViewer) {
        super.initCommonViewer(commonViewer);

    }

    @Override
    public List<AbstractRepositoryAction> getActions(IRepositoryViewObject viewObj) {
        List<AbstractRepositoryAction> actions = super.getActions(viewObj);
        if (viewObj.getProperty().getItem() instanceof MDMServerObjectItem) {
            // deploy
            // actions.add(deployToAction);
            // addAction(actions, deployToLastServerAction, viewObj);
        }
        return actions;
    }

    @Override
    public IRepositoryViewEditorInput getOpenEditorInput(Item item) {
        return new WorkflowEditorInput(item, getProcFile((MDMServerObjectItem) item));
    }

    private IFile getProcFile(MDMServerObjectItem item) {
        String version = item.getProperty().getVersion();
        MDMServerObject mdmServerObject = item.getMDMServerObject();
        String name = mdmServerObject.getName();
        String fileName = RepositoryWorkflowUtil.getProcFileName(name, version);
        IFolder folder = RepositoryResourceUtil.getFolder(IServerObjectRepositoryType.TYPE_WORKFLOW);
        return folder.getFile(fileName);
    }
}
