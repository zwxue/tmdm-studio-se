// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2011 Talend �C www.talend.com
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
package org.talend.mdm.repository.core.impl.customform;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.ui.editor.DiagramEditorFactory;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
import org.eclipse.ui.navigator.CommonViewer;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.impl.RepositoryNodeActionProviderAdapter;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.ui.actions.RemoveFromServerAction;
import org.talend.mdm.repository.ui.actions.customform.EditCustomFormAction;
import org.talend.mdm.repository.ui.actions.customform.NewCustomFormAction;
import org.talend.mdm.repository.ui.editors.CustomFormEditorInput;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class CustomFormActionProvider extends RepositoryNodeActionProviderAdapter {

    AbstractRepositoryAction addAction;

    AbstractRepositoryAction editAction;

    AbstractRepositoryAction removeFromServerAction;
    @Override
    public void initCommonViewer(CommonViewer commonViewer) {
        super.initCommonViewer(commonViewer);
        addAction = new NewCustomFormAction();
        //
        addAction.initCommonViewer(commonViewer);

        editAction = new EditCustomFormAction();
        //
        editAction.initCommonViewer(commonViewer);

        removeFromServerAction = new RemoveFromServerAction();

        removeFromServerAction.initCommonViewer(commonViewer);
    }

    @Override
    public List<AbstractRepositoryAction> getActions(IRepositoryViewObject viewObj) {
        List<AbstractRepositoryAction> actions = super.getActions(viewObj);
        if (RepositoryResourceUtil.hasContainerItem(viewObj, FolderType.SYSTEM_FOLDER_LITERAL, FolderType.FOLDER_LITERAL)) {
            actions.add(addAction);

        }
        if (viewObj.getProperty().getItem() instanceof MDMServerObjectItem) {
            // remove
            actions.add(removeFromServerAction);
            // edit
            actions.add(editAction);
            // deploy
            actions.add(deployToAction);
            addAction(actions, deployToLastServerAction, viewObj);
        }
        actions.add(deployAllAction);
        return actions;
    }

    // @Override
    public IRepositoryViewEditorInput getOpenEditorInput(IRepositoryViewObject viewObj) {
        Item item = viewObj.getProperty().getItem();
        final IFile file = getReferenceFile(item);
        final TransactionalEditingDomain domain = DiagramEditorFactory.createResourceSetAndEditingDomain();
        URI diagramFileUri = GraphitiUiInternal.getEmfService().getFileURI(file, domain.getResourceSet());
        if (diagramFileUri != null) {
            // the file's first base node has to be a diagram
            URI diagramUri = GraphitiUiInternal.getEmfService().mapDiagramFileUriToDiagramUri(diagramFileUri);
            return new CustomFormEditorInput(diagramUri, domain, viewObj);
        }
        return null;
    }

    public IFile getReferenceFile(Item item) {
        IFile file;

        file = RepositoryResourceUtil.findReferenceFile(IServerObjectRepositoryType.TYPE_CUSTOM_FORM, item, "form"); //$NON-NLS-1$

        return file;
    }
}
