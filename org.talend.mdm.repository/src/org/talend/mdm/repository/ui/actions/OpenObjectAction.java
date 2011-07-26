// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2011 Talend ¨C www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.mdm.repository.ui.actions;

import org.apache.log4j.Logger;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IRepositoryNodeActionProvider;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class OpenObjectAction extends AbstractRepositoryAction {

    private static Logger log = Logger.getLogger(OpenObjectAction.class);

    /**
     * DOC hbhong OpenObjectAction constructor comment.
     * 
     * @param text
     */
    public OpenObjectAction() {
        super("Open"); //$NON-NLS-1$
    }

    private IWorkbenchPage page = null;

    @Override
    public void run() {
        for (Object obj : getSelectedObject()) {
            if (obj instanceof IRepositoryViewObject) {
                IRepositoryViewObject viewObject = (IRepositoryViewObject) obj;
                Item item = viewObject.getProperty().getItem();
                if (item instanceof ContainerItem) {
                    commonViewer.expandToLevel(obj, 1);
                } else {
                    IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(item);
                    if (configuration != null) {
                        IRepositoryNodeActionProvider actionProvider = configuration.getActionProvider();
                        if (actionProvider != null) {
                            IRepositoryViewEditorInput editorInput = actionProvider.getOpenEditorInput(item);
                            if (editorInput != null) {
                                if (page == null)
                                    this.page = commonViewer.getCommonNavigator().getSite().getWorkbenchWindow().getActivePage();
                                try {
                                    this.page.openEditor(editorInput, editorInput.getEditorId());
                                } catch (PartInitException e) {
                                    log.error(e.getMessage(), e);
                                }
                            } else {
                                AbstractRepositoryAction openAction = actionProvider.getOpenAction(viewObject);
                                if (openAction != null) {
                                    openAction.selectionChanged(getStructuredSelection());
                                    openAction.run();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public String getGroupName() {
        // this action not be shown in context menu,so Nothing need to do in here
        return null;
    }

}
