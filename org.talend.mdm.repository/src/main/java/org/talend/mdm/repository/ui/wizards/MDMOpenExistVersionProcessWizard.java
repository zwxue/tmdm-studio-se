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

import org.apache.log4j.Logger;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.designer.core.ui.wizards.OpenExistVersionProcessWizard;
import org.talend.mdm.repository.core.IRepositoryNodeActionProvider;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;
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
                if (editorInput != null) {

                    IWorkbenchPage page = MDMRepositoryView.show().getCommonViewer().getCommonNavigator().getSite()
                            .getWorkbenchWindow().getActivePage();
                    try {
                        page.openEditor(editorInput, editorInput.getEditorId(), readonly);
                    } catch (PartInitException e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
        }
    }
}
