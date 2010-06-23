// ============================================================================
//
// Copyright (C) 2006-2008 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.jobrepository.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.ui.image.EImage;
import org.talend.commons.ui.image.ImageProvider;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.SpagoBiServer;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.engines.client.ui.wizards.DeployOnMDMExportWizard;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.RepositoryNode.ENodeType;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.views.ServerView;

/**
 * DOC achen class global comment. Detailled comment
 */
public class DeployJobAction extends Action {

    private ServerView view = ServerView.show();

    public DeployJobAction() {
        super();
        setImageDescriptor(ImageProvider.getImageDesc(EImage.EXPORT_ICON));
        setText("Deploy");
        setToolTipText("Deploy the Job to MDM Server");
    }

    public void run() {
        if (this.view == null) { // called from ServerView
            return;
        }

        IStructuredSelection selection = (IStructuredSelection) view.getViewer().getSelection();
        List<Object> ojbs = new ArrayList<Object>();
        TreeParent serverRoot = null;
        RepositoryNode root = new RepositoryNode(null, null, null);
        for (Iterator<TreeObject> iter = selection.iterator(); iter.hasNext();) {
            TreeObject xobject = iter.next();
            if (xobject != null) {
                IRepositoryViewObject vo = (IRepositoryViewObject) xobject.getWsKey();
                RepositoryNode node = new RepositoryNode(vo, root, ENodeType.REPOSITORY_ELEMENT);

                ojbs.add(node);
                serverRoot = xobject.getServerRoot();
            }
        }
        if (ojbs.size() == 0)
            return;
        StructuredSelection sel = new StructuredSelection(ojbs);
        DeployOnMDMExportWizard publishWizard = new DeployOnMDMExportWizard();
        SpagoBiServer mdmServer = PropertiesFactory.eINSTANCE.createSpagoBiServer();
        mdmServer.setHost(serverRoot.getEndpointHost());
        mdmServer.setLogin(serverRoot.getUsername());
        mdmServer.setPassword(serverRoot.getPassword());
        mdmServer.setPort(serverRoot.getEndpointPort());
        IWorkbench workbench = PlatformUI.getWorkbench();
        publishWizard.setMdmServer(mdmServer);
        publishWizard.setWindowTitle("Deploy the Job to MDM Server"); //$NON-NLS-1$
        publishWizard.init(workbench, sel);

        Shell activeShell = Display.getCurrent().getActiveShell();
        WizardDialog dialog = new WizardDialog(activeShell, publishWizard);
        dialog.open();

    }

}
