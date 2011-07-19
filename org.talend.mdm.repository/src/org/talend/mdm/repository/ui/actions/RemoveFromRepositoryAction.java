// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Path;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.general.Project;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RemoveFromRepositoryAction extends AbstractRepositoryAction {

    static Logger log = Logger.getLogger(RemoveFromRepositoryAction.class);

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    /**
     * DOC hbhong RemoveFromRepositoryAction constructor comment.
     * 
     * @param text
     */
    public RemoveFromRepositoryAction() {
        super(Messages.RemoveFromRepositoryAction_removeFromRepository);
        setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
    }

    @Override
    public String getGroupName() {
        return GROUP_EDIT;
    }

    @Override
    public void run() {
        for (Object obj : getSelectedObject()) {
            if (obj instanceof IRepositoryViewObject) {
                IRepositoryViewObject viewObj = (IRepositoryViewObject) obj;
                // TODO a message confirm to delete
                if (isServerObject(viewObj)) {
                    removeServerObject(viewObj);
                } else if (RepositoryResourceUtil.hasContainerItem(obj, FolderType.FOLDER_LITERAL)) {
                    removeFolderObject(viewObj);
                }

            }
        }
        commonViewer.refresh();
    }

    private boolean isServerObject(IRepositoryViewObject viewObj) {
        return viewObj.getProperty().getItem() instanceof MDMServerObjectItem;
    }

    private void removeServerObject(IRepositoryViewObject viewObj) {
        try {
            factory.deleteObjectPhysical(viewObj);
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
    }

    private void removeFolderObject(IRepositoryViewObject viewObj) {
        try {
            ContainerItem containerItem = (ContainerItem) viewObj.getProperty().getItem();
            Project project = ProjectManager.getInstance().getCurrentProject();
            String path = containerItem.getState().getPath();
            ERepositoryObjectType repObjType = containerItem.getRepObjType();
            factory.deleteFolder(project, repObjType, new Path(path), true);
            ContainerCacheService.remove(repObjType, path);
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
    }
}
