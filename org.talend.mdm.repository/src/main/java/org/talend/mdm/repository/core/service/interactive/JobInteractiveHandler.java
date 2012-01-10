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
package org.talend.mdm.repository.core.service.interactive;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.SpagoBiServer;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.engines.client.ui.wizards.DeployOnMDMExportWizard;
import org.talend.mdm.repository.core.command.deploy.AbstractDeployCommand;
import org.talend.mdm.repository.core.command.deploy.job.BatchDeployJobCommand;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.RepositoryNode;

import com.amalto.workbench.utils.XtentisException;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class JobInteractiveHandler extends AbstractInteractiveHandler {

    public ERepositoryObjectType getRepositoryObjectType() {
        return ERepositoryObjectType.PROCESS;
    }

    public String getLabel() {

        return Messages.JobInteractiveHandler_label;
    }



    @Override
    public boolean deploy(AbstractDeployCommand cmd) throws RemoteException, XtentisException {
        result = false;
        if (cmd instanceof BatchDeployJobCommand) {
            BatchDeployJobCommand deployJobCommand = (BatchDeployJobCommand) cmd;
            List<IRepositoryViewObject> viewObjects = deployJobCommand.getViewObjects();
            if (viewObjects.isEmpty()) {
                return true;
            }
            IStructuredSelection selection = getSelection(viewObjects);
            //
            final DeployOnMDMExportWizard publishWizard = new DeployOnMDMExportWizard();
            SpagoBiServer server = getServer(deployJobCommand.getServerDef());
            publishWizard.setMdmServer(server);

            IWorkbench workbench = RepositoryPlugin.getDefault().getWorkbench();
            publishWizard.setWindowTitle(Messages.JobInteractiveHandler_wizardTitle);
            publishWizard.init(workbench, selection);
            final Display display = Display.getDefault();

            display.syncExec(new Runnable() {

                public void run() {
                    Shell activeShell = display.getActiveShell();
                    WizardDialog dialog = new WizardDialog(activeShell, publishWizard);
                    setResult(dialog.open() == IDialogConstants.OK_ID);
                }
            });
        }
        return result;
    }

    private boolean result = false;

    public void setResult(boolean result) {
        this.result = result;
    }

    private IStructuredSelection getSelection(List<IRepositoryViewObject> viewObjs) {
        List<RepositoryNode> nodes = new LinkedList<RepositoryNode>();
        for (IRepositoryViewObject viewObj : viewObjs) {
            RepositoryNode node = RepositoryResourceUtil.convertToNode(viewObj);
            nodes.add(node);
        }
        return new StructuredSelection(nodes);

    }


    private SpagoBiServer getServer(MDMServerDef serverDef) {
        SpagoBiServer spagoBiServer = PropertiesFactory.eINSTANCE.createSpagoBiServer();
        spagoBiServer.setShortDescription(serverDef.getName());
        spagoBiServer.setHost(serverDef.getHost());
        spagoBiServer.setPort(serverDef.getPort());
        spagoBiServer.setLogin(serverDef.getUser());
        spagoBiServer.setPassword(serverDef.getPasswd());
        return spagoBiServer;
    }
}
