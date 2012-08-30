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
package org.talend.mdm.repository.ui.actions.job;

import java.util.ArrayList;
import java.util.List;

import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.designer.core.ui.action.CreateProcess;
import org.talend.mdm.repository.core.bridge.AbstractBridgeRepositoryAction;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.models.FolderRepositoryObject;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class CreateProcessAction extends AbstractBridgeRepositoryAction {

    /**
     * DOC hbhong EditProcessAction constructor comment.
     * 
     * @param cAction
     */
    public CreateProcessAction() {
        super(new CreateProcess());
    }

    @Override
    public String getGroupName() {
        return GROUP_EDIT;
    }

    protected void doRun() {
        List<IRepositoryViewObject> childrenBeforeAdd = getCurrentChildren();
        
        //
        super.doRun();
        refreshCurrentContainer();
        
        //
        List<IRepositoryViewObject> childrenAfterAdd = getCurrentChildren();
        childrenAfterAdd.removeAll(childrenBeforeAdd);
        
        IRepositoryViewObject addedViewObject = childrenAfterAdd.get(0);
        CommandManager.getInstance().pushCommand(ICommand.CMD_ADD, addedViewObject.getId(), addedViewObject.getLabel());
    }

    private List<IRepositoryViewObject> getCurrentChildren() {
        FolderRepositoryObject viewObj = (FolderRepositoryObject) getSelectedObject().get(0);
        List<IRepositoryViewObject> children = new ArrayList<IRepositoryViewObject>(viewObj.getChildren());
        
        return children;
    }

}
