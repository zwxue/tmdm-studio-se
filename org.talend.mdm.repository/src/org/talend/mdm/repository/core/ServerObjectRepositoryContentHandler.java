package org.talend.mdm.repository.core;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.image.IImage;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryContentHandler;
import org.talend.core.repository.utils.XmiResourceManager;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSMenuItem;
import org.talend.mdm.repository.model.mdmproperties.WSRoleItem;

public class ServerObjectRepositoryContentHandler implements IRepositoryContentHandler, IServerObjectRepositoryType {

    private static Logger log = Logger.getLogger(ServerObjectRepositoryContentHandler.class);

    private XmiResourceManager xmiResourceManager = new XmiResourceManager();

    public ServerObjectRepositoryContentHandler() {
    }

    @Override
    public ERepositoryObjectType getRepositoryObjectType(Item item) {
//        if(item instanceof CategoryItem){
//            return TYPE_CATEGORY;
//        }
        if (item instanceof WSMenuItem) {
            return TYPE_MENU;
        }
        if (item instanceof WSRoleItem) {
            return TYPE_ROLE;
        }
        return null;
    }

    @Override
    public Resource create(IProject project, Item item, int classifierID, IPath path) throws PersistenceException {

        if (item instanceof MDMServerObjectItem) {
            ERepositoryObjectType repositoryType = getRepositoryObjectType(item);
            if (repositoryType != null) {
                Resource itemResource = xmiResourceManager.createItemResource(project, item, path, repositoryType, false);

                EList<EObject> contents = itemResource.getContents();
                if (item instanceof WSMenuItem) {
                    contents.add(((WSMenuItem) item).getWsMenu());
                }

                return itemResource;
            }
        }
        return null;
    }

    @Override
    public Resource save(Item item) throws PersistenceException {
        if (item instanceof MDMServerObjectItem) {
            return xmiResourceManager.getItemResource(item);
        }
        return null;
    }

    @Override
    public IImage getIcon(ERepositoryObjectType type) {
        if (type == TYPE_MENU)
            return ServerObjectImage.MENU_ICON;
        if (type == TYPE_ROLE)
            return ServerObjectImage.ROLE_ICON;
        return null;
    }

    @Override
    public Item createNewItem(ERepositoryObjectType type) {
        if (type == TYPE_MENU) {
            return MdmpropertiesFactory.eINSTANCE.createWSMenuItem();
        }
        if (type == TYPE_ROLE) {
            return MdmpropertiesFactory.eINSTANCE.createWSRoleItem();
        }
        return null;
    }

    @Override
    public boolean isProcess(Item item) {
        return false;
    }

    @Override
    public boolean isRepObjType(ERepositoryObjectType type) {
        return type == TYPE_MENU || type == TYPE_ROLE;
    }

    @Override
    public ERepositoryObjectType getProcessType() {
        return null;
    }

    @Override
    public ERepositoryObjectType getCodeType() {
        return null;
    }

}
