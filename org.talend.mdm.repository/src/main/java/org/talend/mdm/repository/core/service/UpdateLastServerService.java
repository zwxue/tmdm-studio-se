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
package org.talend.mdm.repository.core.service;

import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.command.CommandManager;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.core.service.DeployService.DeployStatus;
import org.talend.mdm.repository.model.mdmmetadata.MdmmetadataFactory;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.service.IUpdateLastServerService;
import com.amalto.workbench.utils.MDMServerDef;


/**
 * created by talend2 on 2012-11-20
 * Detailled comment
 *
 */
public class UpdateLastServerService implements IUpdateLastServerService {

    /* (non-Javadoc)
     * @see com.amalto.workbench.service.IUpdateLastServer#updateLastServerDefInfo(com.amalto.workbench.utils.MDMServerDef, java.lang.Object)
     */
    public void updateLastServerDefInfo(MDMServerDef ser, String repositoryViewObjName, int repositoryViewObjType) {
        if (ser == null || repositoryViewObjName == null)
            return;

        ERepositoryObjectType repositoryObjectType = RepositoryQueryService.getRepositoryObjectType(repositoryViewObjType);
        IRepositoryViewObject workflowViewObject = RepositoryResourceUtil.findViewObjectByName(repositoryObjectType,
                repositoryViewObjName);

        CommandManager cmdManager = CommandManager.getInstance();
        DeployService deployService = DeployService.getInstance();
        ICommand deployCmd = cmdManager.getNewCommand(ICommand.CMD_MODIFY);
        deployCmd.init(workflowViewObject);
        MultiStatus mStatus = new MultiStatus("PLUGIN_ID", Status.OK, "", null); //$NON-NLS-1$ //$NON-NLS-2$

        DeployStatus deployStatus = DeployStatus.getOKStatus(deployCmd, ""); //$NON-NLS-1$
        mStatus.add(deployStatus);
        cmdManager.removeCommandStack(deployCmd, ICommand.PHASE_DEPLOY);
        org.talend.mdm.repository.model.mdmmetadata.MDMServerDef emfMDMServerDef = transferToEMFMDMServer(ser);
        deployService.pushRestoreCommand(cmdManager, deployCmd, emfMDMServerDef);
        deployService.updateLastServer(mStatus, new NullProgressMonitor());

    }

    private org.talend.mdm.repository.model.mdmmetadata.MDMServerDef transferToEMFMDMServer(MDMServerDef serverDef) {
        org.talend.mdm.repository.model.mdmmetadata.MDMServerDef mdmServerDef = MdmmetadataFactory.eINSTANCE.createMDMServerDef();
        mdmServerDef.setName(serverDef.getName());
        mdmServerDef.setHost(serverDef.getHost());
        mdmServerDef.setUniverse(serverDef.getUniverse());
        mdmServerDef.setPort(serverDef.getPort());
        mdmServerDef.setUser(serverDef.getUser());
        mdmServerDef.setPasswd(serverDef.getPasswd());

        return mdmServerDef;
    }

}
