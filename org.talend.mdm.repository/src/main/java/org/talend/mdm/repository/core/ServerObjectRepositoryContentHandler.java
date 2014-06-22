package org.talend.mdm.repository.core;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.image.IImage;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryContentHandler;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.repository.utils.XmiResourceManager;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.repository.model.RepositoryNode;

public class ServerObjectRepositoryContentHandler implements IRepositoryContentHandler, IServerObjectRepositoryType {

    private XmiResourceManager xmiResourceManager = ProxyRepositoryFactory.getInstance().getRepositoryFactoryFromProvider()
            .getResourceManager();

    public ServerObjectRepositoryContentHandler() {
    }

    public ERepositoryObjectType getRepositoryObjectType(Item item) {
        // add quick fix to avoid one problem of palette
        if (item.eClass().getName().equals("CamelProcessItem")) {
            return null;
        }

        IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(item);
        if (configuration != null) {
            return configuration.getResourceProvider().getRepositoryObjectType(item);
        }
        return null;
    }

    public Resource create(IProject project, Item item, int classifierID, IPath path) throws PersistenceException {
        IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(item);
        if (configuration != null) {
            Resource resource = configuration.getResourceProvider().create(project, item, classifierID, path);
            return resource;
        }
        return null;
    }

    public Resource save(Item item) throws PersistenceException {
        IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(item);
        if (configuration != null) {
            return configuration.getResourceProvider().save(item);
        } else if (item instanceof MDMServerObjectItem) {
            return xmiResourceManager.getItemResource(item);
        }
        return null;
    }

    public IImage getIcon(ERepositoryObjectType type) {
        if (type == TYPE_MENU)
            return ServerObjectImage.MENU_ICON;
        if (type == TYPE_ROLE)
            return ServerObjectImage.ROLE_ICON;
        if (type == TYPE_DATACLUSTER)
            return ServerObjectImage.DATACLUSTER_ICON;
        if (type == TYPE_DATAMODEL)
            return ServerObjectImage.DATAMODEL_ICON;
        if (type == TYPE_EVENTMANAGER)
            return ServerObjectImage.EVENTMANAGER_ICON;
        if (type == TYPE_JOBMODEL)
            return ServerObjectImage.JOBMODEL_ICON;
        if (type == TYPE_RESOURCE)
            return ServerObjectImage.RESOURCE_ICON;
        if (type == TYPE_ROUTINGRULE)
            return ServerObjectImage.ROUTINGRULE_ICON;
        if (type == TYPE_SERVICECONFIGURATION)
            return ServerObjectImage.SERVICECONFIGURATION_ICON;
        if (type == TYPE_STOREPROCEDURE)
            return ServerObjectImage.STOREPROCEDURE_ICON;
        if (type == TYPE_SYNCHRONIZATIONPLAN)
            return ServerObjectImage.SYNCHRONIZATIONPLAN_ICON;
        if (type == TYPE_TRANSFORMERV2)
            return ServerObjectImage.TRANSFORMERV2_ICON;
        if (type == TYPE_UNIVERSE)
            return ServerObjectImage.UNIVERSE_ICON;
        if (type == TYPE_VIEW)
            return ServerObjectImage.VIEW_ICON;
        if (type == TYPE_WORKFLOW)
            return ServerObjectImage.WORKFLOW_ICON;
        if (type == TYPE_CUSTOM_FORM)
            return ServerObjectImage.CUSTOMFORM_ICON;

        return null;
    }

    public Item createNewItem(ERepositoryObjectType type) {
        IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(type);
        if (configuration != null) {
            return configuration.getResourceProvider().createNewItem(type);
        }
        return null;
    }

    public boolean isProcess(Item item) {
        return false;
    }

    public boolean isRepObjType(ERepositoryObjectType type) {
        IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(type);
        return configuration != null;

    }

    public ERepositoryObjectType getProcessType() {
        return null;
    }

    public ERepositoryObjectType getCodeType() {
        return null;
    }

    public void addNode(ERepositoryObjectType type, RepositoryNode recBinNode, IRepositoryViewObject repositoryObject,
            RepositoryNode node) {
        // TODO Auto-generated method stub

    }

    public void addContents(Collection<EObject> collection, Resource resource) {
        // TODO Auto-generated method stub
    }

    public IImage getIcon(Item item) {
        // TODO Auto-generated method stub
        return null;
    }

}
