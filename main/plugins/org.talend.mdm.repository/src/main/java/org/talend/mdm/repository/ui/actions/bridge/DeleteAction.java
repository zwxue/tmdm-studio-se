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
package org.talend.mdm.repository.ui.actions.bridge;

import java.util.List;

import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.bridge.AbstractBridgeRepositoryAction;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.repository.model.ERepositoryStatus;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeleteAction extends AbstractBridgeRepositoryAction {

    public DeleteAction() {
        super(new org.talend.repository.ui.actions.DeleteAction());
        setText(Messages.RemoveFromRepositoryAction_removeFromRepository);
    }

    @Override
    public String getGroupName() {
        return GROUP_EDIT;
    }

    @Override
    protected void doRun() {
        super.doRun();
        commonViewer.refresh();

        List<Object> selectedObject = getSelectedObject();
        for (Object obj : selectedObject) {
            if (obj instanceof IRepositoryViewObject) {
                IRepositoryViewObject viewObj = (IRepositoryViewObject) obj;
                if (viewObj instanceof FolderRepositoryObject) {
                    removeFolderObject(viewObj);
                } else {
                    removeServerObject(viewObj);
                }
            }
        }
    }

    private void removeFolderObject(IRepositoryViewObject viewObj) {
        for (IRepositoryViewObject childObj : viewObj.getChildren()) {
            if (childObj instanceof FolderRepositoryObject) {
                removeFolderObject(childObj);
            } else {
                removeServerObject(childObj);
            }
        }

    }

    private void removeServerObject(IRepositoryViewObject viewObj) {
        ERepositoryStatus repositoryStatus = viewObj.getRepositoryStatus();
        if (repositoryStatus == ERepositoryStatus.DELETED) {
            CommandManager.getInstance().pushCommand(ICommand.CMD_DELETE, viewObj.getId(), viewObj.getLabel());
        }
    }
}
