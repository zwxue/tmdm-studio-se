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
package org.talend.mdm.repository.core.impl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.navigator.CommonViewer;
import org.talend.core.model.properties.FolderItem;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IRepositoryNodeActionProvider;
import org.talend.mdm.repository.core.IRepositoryViewGlobalActionHandler;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.ui.actions.CreateFolderAction;
import org.talend.mdm.repository.ui.actions.DeployToAction;
import org.talend.mdm.repository.ui.actions.DeployToLastServerAction;
import org.talend.mdm.repository.ui.actions.DuplicateAction;
import org.talend.mdm.repository.ui.actions.ExportObjectAction;
import org.talend.mdm.repository.ui.actions.ImportObjectAction;
import org.talend.mdm.repository.ui.actions.ImportServerObjectAction;
import org.talend.mdm.repository.ui.actions.RemoveFromRepositoryAction;
import org.talend.mdm.repository.ui.actions.RenameObjectAction;
import org.talend.mdm.repository.ui.actions.UpdateServerDefAction;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.ui.editors.XObjectEditorInput2;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class RepositoryNodeActionProviderAdapter implements IRepositoryNodeActionProvider {

    static AbstractRepositoryAction exportObjectAction;

    static AbstractRepositoryAction importObjectAction;

    static AbstractRepositoryAction createFolderAction;

    static AbstractRepositoryAction removeFromRepositoryAction;

    static AbstractRepositoryAction duplicateAction;

    static AbstractRepositoryAction updateServerAction;

    static AbstractRepositoryAction deployToAction;

    static AbstractRepositoryAction deployToLastServerAction;

    protected static AbstractRepositoryAction renameAction;

    protected AbstractRepositoryAction refreshAction;

    protected AbstractRepositoryAction copyAction;

    protected AbstractRepositoryAction importServerObjectAction;

    protected AbstractRepositoryAction pasteAction;

    protected IRepositoryViewGlobalActionHandler globalActionHandler;

    private IStructuredSelection selection;

    public void initCommonViewer(CommonViewer commonViewer) {
        importObjectAction = new ImportObjectAction();
        exportObjectAction = new ExportObjectAction();
        createFolderAction = new CreateFolderAction();
        removeFromRepositoryAction = new RemoveFromRepositoryAction();
        renameAction = new RenameObjectAction();
        duplicateAction = new DuplicateAction();
        updateServerAction = new UpdateServerDefAction();
        deployToAction = new DeployToAction();
        deployToLastServerAction = new DeployToLastServerAction();
        importServerObjectAction = new ImportServerObjectAction();
        //
        exportObjectAction.initCommonViewer(commonViewer);
        createFolderAction.initCommonViewer(commonViewer);
        removeFromRepositoryAction.initCommonViewer(commonViewer);
        renameAction.initCommonViewer(commonViewer);
        duplicateAction.initCommonViewer(commonViewer);
        refreshAction = globalActionHandler.getGlobalAction(IRepositoryViewGlobalActionHandler.REFRESH);
        copyAction = globalActionHandler.getGlobalAction(IRepositoryViewGlobalActionHandler.COPY);

        pasteAction = globalActionHandler.getGlobalAction(IRepositoryViewGlobalActionHandler.PASTE);
        updateServerAction.initCommonViewer(commonViewer);
        importServerObjectAction.initCommonViewer(commonViewer);
        deployToAction.initCommonViewer(commonViewer);
        deployToLastServerAction.initCommonViewer(commonViewer);
    }

    public List<AbstractRepositoryAction> getActions(IRepositoryViewObject viewObj) {
        List<AbstractRepositoryAction> actions = new LinkedList<AbstractRepositoryAction>();
        //
        Item item = viewObj.getProperty().getItem();
        if (item instanceof MDMItem) {
            if (item instanceof ContainerItem) {
                FolderType type = ((FolderItem) item).getType();
                switch (type.getValue()) {
                case FolderType.SYSTEM_FOLDER:
                    actions.add(createFolderAction);
                    addAction(actions, pasteAction, viewObj);
                    break;
                case FolderType.STABLE_SYSTEM_FOLDER:

                    break;

                case FolderType.FOLDER:
                    actions.add(createFolderAction);
                    actions.add(removeFromRepositoryAction);
                    addAction(actions, pasteAction, viewObj);
                    break;
                }

            } else if (item instanceof MDMServerObjectItem) {
                actions.add(removeFromRepositoryAction);
                actions.add(updateServerAction);

                addAction(actions, copyAction, viewObj);
                addAction(actions, pasteAction, viewObj);
                actions.add(duplicateAction);
                // deploy
                actions.add(deployToAction);
                addAction(actions, deployToLastServerAction, viewObj);
            }
        }

        //
        // actions.add(exportAction);
        actions.add(refreshAction);
        actions.add(importServerObjectAction);
        actions.add(exportObjectAction);
        actions.add(importObjectAction);
        return actions;
    }

    private void addAction(List<AbstractRepositoryAction> actions, AbstractRepositoryAction action, IRepositoryViewObject viewObj) {
        action.selectionChanged(selection);
        if (action.isVisible(viewObj)) {
            actions.add(action);
        }
    }

    /**
     * The child class can override this method, current implement is adapt to most of MDMServerobject
     */
    public IRepositoryViewEditorInput getOpenEditorInput(Item item) {
        return new XObjectEditorInput2(item);
    }

    public AbstractRepositoryAction getOpenAction(IRepositoryViewObject viewObj) {
        return null;
    }

    public void setRepositoryViewGlobalActionHandler(IRepositoryViewGlobalActionHandler handler) {
        this.globalActionHandler = handler;
    }

    public void updateSelection(IStructuredSelection selection) {
        this.selection = selection;
    }

}
