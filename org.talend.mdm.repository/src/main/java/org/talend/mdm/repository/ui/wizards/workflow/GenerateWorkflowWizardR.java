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
package org.talend.mdm.repository.ui.wizards.workflow;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.ow2.bonita.facade.def.element.BusinessArchive;
import org.ow2.bonita.facade.uuid.ProcessDefinitionUUID;
import org.ow2.bonita.util.BusinessArchiveFactory;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.ui.actions.workflow.NewWorkflowAction;
import org.talend.mdm.repository.ui.widgets.TisTableViewerR;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.mdm.repository.utils.RepositoryWorkflowUtil;
import org.talend.mdm.workbench.enterprice.dialog.GenerateWorkflowWizard;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.widgets.ComplexTableViewerColumn;
import com.amalto.workbench.widgets.TisTableViewer;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class GenerateWorkflowWizardR extends GenerateWorkflowWizard {

    static Logger log = Logger.getLogger(GenerateWorkflowWizardR.class);

    /**
     * DOC hbhong GenerateWorkflowWizardR constructor comment.
     * 
     * @param launchPage
     * @param declaration
     */
    public GenerateWorkflowWizardR(DataModelMainPage launchPage) {
        super(launchPage, null);
    }

    @Override
    protected List<String> getAllRoleNames() {
        return RepositoryQueryService.findAllRoleNames();
    }

    @Override
    protected TisTableViewer getXpathTableViewer(List<ComplexTableViewerColumn> columns, FormToolkit toolkit, Composite parent) {
        TisTableViewerR tisTableViewer = new TisTableViewerR(columns, toolkit, parent);
        tisTableViewer.setSite(page.getSite());
        return tisTableViewer;
    }

    @Override
    protected void handleWorkflow(String barPath, String variableStr, boolean ifFirst) {
        try {
            File barFile = new File(barPath);
            BusinessArchive archive = BusinessArchiveFactory.getBusinessArchive(barFile);

            ProcessDefinitionUUID uuid = archive.getProcessUUID();

            String procFileName = RepositoryWorkflowUtil.getProcFileName(uuid.getProcessName(), uuid.getProcessVersion());
            IFolder folder = RepositoryResourceUtil.getFolder(IServerObjectRepositoryType.TYPE_WORKFLOW);
            IFile procFile = folder.getFile(procFileName);
            Set<String> barResources = archive.getResources().keySet();
            byte[] bytes = new byte[0];
            for (String barResource : barResources) {
                if (barResource.endsWith(".proc")) { //$NON-NLS-1$
                    bytes = archive.getResources().get(barResource);
                    break;
                }
            }
            if (bytes != null) {
                RepositoryResourceUtil.removeViewObjectPhysically(IServerObjectRepositoryType.TYPE_WORKFLOW,
                        uuid.getProcessName(), uuid.getProcessVersion(), null);
                procFile.create(new ByteArrayInputStream(bytes), IResource.NONE, null);
                NewWorkflowAction createAction = new NewWorkflowAction(uuid.getProcessName(), procFile, uuid.getProcessVersion());
                createAction.run();
            }

            //

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (CoreException e) {
            log.error(e.getMessage(), e);
        }

    }

}
