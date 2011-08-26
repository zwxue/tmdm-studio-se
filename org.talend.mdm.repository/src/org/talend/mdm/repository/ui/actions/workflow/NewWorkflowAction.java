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
package org.talend.mdm.repository.ui.actions.workflow;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSWorkflowItem;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectFactory;
import org.talend.mdm.repository.model.mdmserverobject.WSWorkflowE;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddAction;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC class global comment. Detailled comment <br/>
 * 
 */
public class NewWorkflowAction extends AbstractSimpleAddAction {

    static Logger log = Logger.getLogger(NewWorkflowAction.class);

    private final IFile procFile;

    private final String workflowName;

    private final String version;

    public NewWorkflowAction(String workflowName, IFile procFile, String version) {
        super();
        this.workflowName = workflowName;
        this.procFile = procFile;
        this.version = version;
    }

    @Override
    protected String getDialogTitle() {
        return "";
    }

    private WSWorkflowE newWorkflow(String key) {
        WSWorkflowE workflow = MdmserverobjectFactory.eINSTANCE.createWSWorkflowE();
        workflow.setName(key);
        workflow.setDescription(""); //$NON-NLS-1$

        return workflow;
    }

    @Override
    public void run() {
        createServerObject(null);
    }

    protected boolean createServerObject(String key) {

        WSWorkflowItem item = MdmpropertiesFactory.eINSTANCE.createWSWorkflowItem();

        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        item.setState(itemState);
        //
        WSWorkflowE workflow = newWorkflow(workflowName);
        item.setWsWorkflow(workflow);

        item.getState().setPath(""); //$NON-NLS-1$
        // linkProcFile(item);

        boolean result = RepositoryResourceUtil.createItem(item, workflowName, version);
        if (result) {
            // linkProcFile(item);
            // IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();
            // try {
            // factory.save(item);
            // } catch (PersistenceException e) {
            // log.error(e.getMessage(), e);
            // return false;
            // }
            refreshRepositoryRoot(IServerObjectRepositoryType.TYPE_WORKFLOW);
        }
        return result;
    }

    // private void linkProcFile(Item item) {
    // try {
    // ReferenceFileItem procFileItem = PropertiesFactory.eINSTANCE.createReferenceFileItem();
    // ByteArray byteArray = PropertiesFactory.eINSTANCE.createByteArray();
    // byteArray.setInnerContentFromFile(procFile);
    // procFileItem.setContent(byteArray);
    //            procFileItem.setExtension("proc"); //$NON-NLS-1$
    // item.getReferenceResources().add(procFileItem);
    // } catch (IOException e) {
    // log.error(e.getMessage(), e);
    // } catch (CoreException e) {
    // log.error(e.getMessage(), e);
    // }
    //
    // }

}
