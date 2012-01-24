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
package org.talend.mdm.repository.core.command.deploy;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.service.DeployService.DeployStatus;
import org.talend.mdm.repository.core.service.IInteractiveHandler;
import org.talend.mdm.repository.core.service.InteractiveService;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeleteCommand extends AbstractDeployCommand {

    public DeleteCommand() {
    }

    @Override
    public int getCommandType() {
        return ICommand.CMD_DELETE;
    }

    @Override
    public IStatus execute(Object receiver, IProgressMonitor monitor) {
        IInteractiveHandler handler = InteractiveService.findHandler(getViewObjectType());
        String objectName = getObjLastName();
        if (handler != null) {
            String typeLabel = handler.getLabel();
            monitor.subTask("Deleting " + typeLabel + "...");
            try {
                handler.remove(this);
                return DeployStatus.getOKStatus(this, typeLabel + " \"" + objectName + "\"" + " was deleted successfully");

            } catch (Exception e) {
                return DeployStatus.getErrorStatus(null,
                        "Fail to delete " + typeLabel + " \"" + objectName + "\",Cause is:" + e.getMessage(), e);
            }
        } else {
            return DeployStatus.getErrorStatus(null, "Not support for deploying \"" + objectName + "\"");
        }
    }

}
