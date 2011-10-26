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

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.general.Project;
import org.talend.core.model.properties.FolderType;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
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

    private static List<IRepositoryViewObject> viewObjectsListRemoved = new ArrayList<IRepositoryViewObject>();

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
        int size = getSelectedObject().size();
        if (size > 0) {
            if (!MessageDialog.openConfirm(getShell(), Messages.RemoveFromRepositoryAction_Title, Messages.bind(
                    Messages.RemoveFromRepositoryAction_confirm, size, size > 1 ? Messages.RemoveFromRepositoryAction_instances
                            : Messages.RemoveFromRepositoryAction_instance))) {
                return;
            }

        }
        for (Object obj : getSelectedObject()) {
            if (obj instanceof IRepositoryViewObject) {
                IRepositoryViewObject viewObj = (IRepositoryViewObject) obj;

                Item item = viewObj.getProperty().getItem();
                if (item instanceof MDMServerObjectItem) {
                    MDMServerObject serverObj = ((MDMServerObjectItem) item).getMDMServerObject();
                    if (serverObj.getLastServerDef() != null) {
                        viewObjectsListRemoved.add(viewObj);
                    }
                }

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

            Property property = viewObj.getProperty();
            ContainerCacheService.remove(property);
            factory.deleteObjectLogical(viewObj);
            // factory.deleteObjectPhysical(viewObj);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void removeFolderObject(IRepositoryViewObject viewObj) {
        try {
            ContainerItem containerItem = (ContainerItem) viewObj.getProperty().getItem();
            Project project = ProjectManager.getInstance().getCurrentProject();
            String path = containerItem.getState().getPath();
            ERepositoryObjectType repObjType = containerItem.getRepObjType();

            ContainerCacheService.remove(repObjType, path);

            factory.deleteFolder(project, repObjType, new Path(path), true);
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static List<IRepositoryViewObject> getViewObjectsRemovedList() {
        return viewObjectsListRemoved;
    }

}
