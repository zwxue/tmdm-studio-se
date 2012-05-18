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
package org.talend.mdm.repository.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.talend.commons.exception.PersistenceException;
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
 * DOC achen  class global comment. Detailled comment
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
        if ( status.equals(ERepositoryStatus.LOCK_BY_USER)
                && RepositoryResourceUtil.isOpenedItemInEditor(processObject)) {        	
        	alreadyEditedByUser = true;        
        }
        this.viewObject = processObject;
    }

    @Override
    public void addPages() {
        mainPage = new MDMOpenExistVersionProcessPage(alreadyEditedByUser, viewObject);
        addPage(mainPage);
        setWindowTitle(Messages.MDMOpenExistVersionProcessWizard_NewObject); //$NON-NLS-1$
    }
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.designer.core.ui.wizards.OpenExistVersionProcessWizard#openAnotherVersion(org.talend.repository.model
     * .RepositoryNode, boolean)
     */
    @Override
    protected void openAnotherVersion(RepositoryNode node, boolean readonly) {

        IRepositoryViewObject viewObject = node.getObject();
        Item item = viewObject.getProperty().getItem();
        IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(item);
        if (configuration != null) {
            IRepositoryNodeActionProvider actionProvider = configuration.getActionProvider();
            if (actionProvider != null) {
                IRepositoryViewEditorInput editorInput = actionProvider.getOpenEditorInput(viewObject);
                editorInput.setReadOnly(readonly);
                if (editorInput != null) {

                    IWorkbenchPage page = MDMRepositoryView.show().getCommonViewer().getCommonNavigator().getSite()
                            .getWorkbenchWindow().getActivePage();
                    try {
                        updateEditorInputVersionInfo(editorInput, viewObject);
                        page.openEditor(editorInput, editorInput.getEditorId(), readonly);
                        this.viewObject=viewObject;
                    } catch (PartInitException e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
        }
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
    public IRepositoryViewObject getViewObj(){
        return this.viewObject;
    }

    @Override
    protected boolean refreshNewJob() {
        IFolder folder = RepositoryResourceUtil.getFolder(getViewObj());
        if (folder != null && folder.exists()) {
            try {
                final List<String> paths = new ArrayList<String>();
                folder.accept(new IResourceVisitor() {

                    public boolean visit(IResource e) throws CoreException {
                        if (e.getLocation().toOSString().endsWith(".bak")) {//$NON-NLS-1$
                            paths.add(e.getName());
                        }
                        return true;
                    }
                });
                // delete all .bak files
                for (String path : paths) {
                    folder.getFile(path).delete(true, null);
                }
            } catch (CoreException e) {
                log.error(e.getMessage(), e);
            }
        }
        return super.refreshNewJob();
    }
}
