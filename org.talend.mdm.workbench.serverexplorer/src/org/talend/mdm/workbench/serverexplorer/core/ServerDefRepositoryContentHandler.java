package org.talend.mdm.workbench.serverexplorer.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.image.IImage;
import org.talend.core.model.properties.ByteArray;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryContentHandler;
import org.talend.core.repository.utils.XmiResourceManager;
import org.talend.mdm.repository.model.mdmproperties.MDMServerDefItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;

public class ServerDefRepositoryContentHandler implements IRepositoryContentHandler {

    private XmiResourceManager xmiResourceManager = new XmiResourceManager();

    public ServerDefRepositoryContentHandler() {
    }

    @Override
    public ERepositoryObjectType createResource(Item item) {
        if (item instanceof MDMServerDefItem) {
            return ServerDefService.REPOSITORY_TYPE_SERVER_DEF;
        }
        return null;
    }

    @Override
    public Resource create(IProject project, Item item, int classifierID, IPath path) throws PersistenceException {

        if (item instanceof MDMServerDefItem) {
            Resource itemResource = xmiResourceManager.createItemResource(project, item, path,
                    ServerDefService.REPOSITORY_TYPE_SERVER_DEF, false);
            itemResource.getContents().add(((MDMServerDefItem) item).getServerDef());
            return itemResource;
        }
        return null;
    }

    @Override
    public Resource save(Item item) throws PersistenceException {
        if (item instanceof MDMServerDefItem) {
            Resource resource = xmiResourceManager.getItemResource(item);

            resource.getContents().clear();
            resource.getContents().add(((MDMServerDefItem) item).getServerDef());
            return resource;
        }
        return null;
    }

    @Override
    public IImage getIcon(ERepositoryObjectType type) {
        if (type == ServerDefService.REPOSITORY_TYPE_SERVER_DEF)
            return ServerDefImage.BEAN_ICON;
        return null;
    }

    @Override
    public Item createNewItem(ERepositoryObjectType type) {
        if (type == ServerDefService.REPOSITORY_TYPE_SERVER_DEF) {
            return MdmpropertiesFactory.eINSTANCE.createMDMServerDefItem();
        }
        return null;
    }

    @Override
    public boolean isProcess(Item item) {
        return false;
    }

    @Override
    public boolean isRepObjType(ERepositoryObjectType type) {
        return type == ServerDefService.REPOSITORY_TYPE_SERVER_DEF;
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
