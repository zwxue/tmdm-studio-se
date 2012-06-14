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
package org.talend.mdm.repository.core.impl.datamodel;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.navigator.CommonViewer;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.impl.RepositoryNodeActionProviderAdapter;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.ui.actions.datamodel.NewDataModelAction;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.ui.editors.XSDEditorInput2;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class DataModelActionProvider extends RepositoryNodeActionProviderAdapter {

    static Logger log = Logger.getLogger(DataModelActionProvider.class);

    AbstractRepositoryAction addAction;

    @Override
    public void initCommonViewer(CommonViewer commonViewer) {
        super.initCommonViewer(commonViewer);
        addAction = new NewDataModelAction();

        //
        addAction.initCommonViewer(commonViewer);

    }

    @Override
    public List<AbstractRepositoryAction> getActions(IRepositoryViewObject viewObj) {
        List<AbstractRepositoryAction> actions = super.getActions(viewObj);
        if (RepositoryResourceUtil.hasContainerItem(viewObj, FolderType.SYSTEM_FOLDER_LITERAL, FolderType.FOLDER_LITERAL)) {
            actions.add(addAction);
        }
        if (viewObj.getProperty().getItem() instanceof MDMServerObjectItem) {
            addAction(actions, renameAction, viewObj);
            // deploy
            actions.add(deployToAction);
            //actions.add(deployAnotherToAction);
            addAction(actions, deployToLastServerAction, viewObj);
        }
        actions.add(deployAllAction);
        return actions;
    }

    @Override
    public IRepositoryViewEditorInput getOpenEditorInput(IRepositoryViewObject viewObj) {
        // MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
        try {
            Item item = viewObj.getProperty().getItem();
            // IFile file = createFile((WSDataModelE) serverObject);
            IFile file = RepositoryResourceUtil.findReferenceFile(IServerObjectRepositoryType.TYPE_DATAMODEL, item, "xsd"); //$NON-NLS-1$
            return new XSDEditorInput2(viewObj, file);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    // private IFile createFile(WSDataModelE dataModel) throws Exception {
    //        String filename = dataModel.getName() + ".xsd";//$NON-NLS-1$
    // String content = dataModel.getXsdSchema();
    //
    // Project currentProject = ProjectManager.getInstance().getCurrentProject();
    // IProject fsProject = ResourceModelUtils.getProject(currentProject);
    // if (fsProject == null) {
    // return null;
    // }
    // IFolder objectFolder = null;
    // try {
    // objectFolder = ResourceUtils.getFolder(fsProject,
    // ERepositoryObjectType.getFolderName(IServerObjectRepositoryType.TYPE_DATAMODEL), true);
    // } catch (ResourceNotFoundException e) {
    // log.error(e.getMessage(), e);
    // }
    //
    // if (!objectFolder.exists()) {
    // objectFolder.create(true, true, null);
    // }
    // IFile file = objectFolder.getFile(filename);
    //
    // if (!file.exists())
    //            file.create(new ByteArrayInputStream(content.getBytes("utf-8")), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$
    // else
    //            file.setContents(new ByteArrayInputStream(content.getBytes("utf-8")), IFile.FORCE, new NullProgressMonitor());//$NON-NLS-1$
    //
    // return file;
    // }
}
