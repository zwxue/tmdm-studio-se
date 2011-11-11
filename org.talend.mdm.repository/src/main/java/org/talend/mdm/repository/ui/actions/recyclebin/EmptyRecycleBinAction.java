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
package org.talend.mdm.repository.ui.actions.recyclebin;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.general.Project;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.mdm.repository.plugin.RepositoryPlugin;
import org.talend.mdm.repository.utils.EclipseResourceManager;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class EmptyRecycleBinAction extends AbstractRepositoryAction {

    static Logger log = Logger.getLogger(EmptyRecycleBinAction.class);

    private static final ImageDescriptor EMPTY_IMG = EclipseResourceManager.getImageDescriptor(RepositoryPlugin.PLUGIN_ID,
            "icons/recycle_bin_empty.png"); //$NON-NLS-1$;

    /**
     * DOC hbhong EmptyRecycleBinAction constructor comment.
     * 
     * @param text
     */
    public EmptyRecycleBinAction() {
        super(Messages.EmptyRecycleBinAction_title);
        setImageDescriptor(EMPTY_IMG);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.core.AbstractRepositoryAction#getGroupName()
     */
    @Override
    public String getGroupName() {
        return GROUP_EDIT;
    }

    @Override
    public void run() {
        Object selObj = getSelectedObject().get(0);
        FolderRepositoryObject conRepObj = (FolderRepositoryObject) selObj;
        List<IRepositoryViewObject> children = conRepObj.getChildren();
        int size = children.size();

        if (size > 0) {
            if (!(MessageDialog.openQuestion(getShell(), Messages.EmptyRecycleBinAction_title,
                    Messages.EmptyRecycleBinAction_confirmEmpty))) {
                return;
            }
            try {
                for (IRepositoryViewObject childViewObj : children) {
                    deleteElement(childViewObj);
                }
            } catch (PersistenceException e) {
                log.error(e.getMessage(), e);
            }
            refreshRepositoryRoot(IServerObjectRepositoryType.TYPE_RECYCLE_BIN);
        }
    }

    IProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();

    private void deleteElement(IRepositoryViewObject viewObj) throws PersistenceException {
        Project currentProject = ProjectManager.getInstance().getCurrentProject();
        if (viewObj instanceof FolderRepositoryObject) {
            // delete child
            for (IRepositoryViewObject childViewObj : ((FolderRepositoryObject) viewObj).getChildren()) {
                deleteElement(childViewObj);
            }
            Item item = viewObj.getProperty().getItem();
            IPath folderPath = new Path(item.getState().getPath());

            factory.deleteFolder(currentProject, viewObj.getRepositoryObjectType(), folderPath, true);
        } else {

            factory.deleteObjectPhysical(currentProject, viewObj, null, true);
        }
    }

    @Override
    public boolean isVisible(IRepositoryViewObject viewObj) {
        Object selObj = getSelectedObject().get(0);
        FolderRepositoryObject conRepObj = (FolderRepositoryObject) selObj;
        return !conRepObj.getChildren().isEmpty();
    }

}
