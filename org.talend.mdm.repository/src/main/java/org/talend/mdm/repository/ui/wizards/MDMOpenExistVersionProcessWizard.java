// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.wizards;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.utils.VersionUtils;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.designer.core.ui.wizards.OpenExistVersionProcessWizard;
import org.talend.mdm.repository.core.IRepositoryNodeActionProvider;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.service.IMDMSVNProviderService;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.model.ERepositoryStatus;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.RepositoryNode;

/**
 * DOC achen class global comment. Detailled comment
 */
public class MDMOpenExistVersionProcessWizard extends OpenExistVersionProcessWizard {

    static Logger log = Logger.getLogger(MDMOpenExistVersionProcessWizard.class);

    IRepositoryViewObject viewObject;

    /**
     * DOC achen MDMOpenExistVersionProcessWizard constructor comment.
     * 
     * @param processObject
     */
    public MDMOpenExistVersionProcessWizard(IRepositoryViewObject processObject) {
        super(processObject);

        ERepositoryStatus status = processObject.getRepositoryStatus();
        if (status.equals(ERepositoryStatus.LOCK_BY_USER) && RepositoryResourceUtil.isOpenedItemInEditor(processObject)) {
            alreadyEditedByUser = true;
        }
        this.viewObject = processObject;
    }

    @Override
    public void addPages() {
        mainPage = new MDMOpenExistVersionProcessPage(alreadyEditedByUser, viewObject);
        addPage(mainPage);
        setWindowTitle(Messages.MDMOpenExistVersionProcessWizard_NewObject);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.designer.core.ui.wizards.OpenExistVersionProcessWizard#openAnotherVersion(org.talend.repository.model
     * .RepositoryNode, boolean)
     */
    @Override
    protected void openAnotherVersion(final RepositoryNode node, boolean readonly) {
        Display.getCurrent().asyncExec(new Runnable() {

            public void run() {
                IRepositoryViewObject viewObject = node.getObject();
                Item item = viewObject.getProperty().getItem();
                boolean latestVersion = isLatestVersion(viewObject);
                IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(item);
                if (configuration != null) {
                    IRepositoryNodeActionProvider actionProvider = configuration.getActionProvider();
                    if (actionProvider != null) {
                        IRepositoryViewEditorInput editorInput = actionProvider.getOpenEditorInput(viewObject);
                        editorInput.setReadOnly(latestVersion);
                        if (editorInput != null) {

                            IWorkbenchPage page = MDMRepositoryView.show().getCommonViewer().getCommonNavigator().getSite()
                                    .getWorkbenchWindow().getActivePage();
                            try {
                                updateEditorInputVersionInfo(editorInput, viewObject);
                                page.openEditor(editorInput, editorInput.getEditorId(), !latestVersion);
                                setViewObj(viewObject);
                            } catch (PartInitException e) {
                                log.error(e.getMessage(), e);
                            }
                        }
                    }
                }
            }

            private boolean isLatestVersion(final IRepositoryViewObject viewObj) {
                String selectedVersion = viewObj.getProperty().getVersion();
                int compare = VersionUtils.compareTo(selectedVersion, getOriginVersion());
                return compare >= 0;
            }
        });
    }

    private void updateEditorInputVersionInfo(IRepositoryViewEditorInput editorInput, IRepositoryViewObject viewObject) {
        String version = viewObject.getVersion();
        try {
            IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
            if (!factory.isLocalConnectionProvider()) {
                IMDMSVNProviderService service = (IMDMSVNProviderService) GlobalServiceRegister.getDefault().getService(
                        IMDMSVNProviderService.class);
                if (service != null) {
                    if (service.isProjectInSvnMode()) {
                        String revisionNumStr = service.getCurrentSVNRevision(viewObject);
                        if (revisionNumStr != null) {
                            revisionNumStr = ".r" + revisionNumStr; //$NON-NLS-1$
                            version += revisionNumStr;
                        }
                    }
                }

            }
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }

        editorInput.setVersion(version);
    }

    public IRepositoryViewObject getViewObj() {
        return this.viewObject;
    }

    private void setViewObj(IRepositoryViewObject viewObj) {
        this.viewObject = viewObj;
    }

    @Override
    protected boolean refreshNewJob() {
        IFolder folder = RepositoryResourceUtil.getFolder(getViewObj());
        if (folder != null && folder.exists()) {
            try {
                for (IResource r : folder.members()) {
                    if (r instanceof IFile) {
                        if (r.getFileExtension().equalsIgnoreCase("bak")) {//$NON-NLS-1$
                            IFile file = (IFile) r;
                            if (file.exists()) {
                                file.delete(true, null);
                            }
                        }
                    }
                }
            } catch (CoreException e) {
                log.error(e.getMessage(), e);
            }
        }
        return super.refreshNewJob();
    }
}
