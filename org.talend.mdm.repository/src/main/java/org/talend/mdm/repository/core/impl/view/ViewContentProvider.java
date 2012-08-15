// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2012 Talend 锟紺 www.talend.com
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
package org.talend.mdm.repository.core.impl.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.impl.AbstractContentProvider;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSViewItem;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSView;

/**
 * DOC hbhong class global comment. Detailled comment <br/>
 * 
 */
public class ViewContentProvider extends AbstractContentProvider {

    private List<IRepositoryViewObject> result;
    private Map<IRepositoryViewObject, IRepositoryViewObject> folderMapWebSearch = new HashMap<IRepositoryViewObject, IRepositoryViewObject>();
    
    @Override
    protected List<IRepositoryViewObject> getViewObjFromFolder(ContainerItem containerItem) {
        List<IRepositoryViewObject> viewObjects = RepositoryResourceUtil.findViewObjects(containerItem.getRepObjType(), containerItem);
        List<IRepositoryViewObject> childrenOfFolder = getChildrenOfFolder(containerItem, viewObjects);
        return childrenOfFolder;
    }
    
    @Override
    protected List<IRepositoryViewObject> getViewObjFromSystemFolder(Item parentItem) {
        if(parentItem instanceof ContainerItem) {
            if (result == null) {
                result = new LinkedList<IRepositoryViewObject>();
                IRepositoryNodeConfiguration webfilterConf = RepositoryNodeConfigurationManager
                        .getConfiguration(IServerObjectRepositoryType.TYPE_VIEW);
                IRepositoryNodeConfiguration searchfilterConf = RepositoryNodeConfigurationManager
                        .getConfiguration(IServerObjectRepositoryType.TYPE_VIEW);
                
                //
                addCategoryViewObject(result, webfilterConf, Messages.ViewContentProvider_WebFilter, IViewNodeConstDef.TYPE_WEBFILTER);
                addCategoryViewObject(result, searchfilterConf, Messages.ViewContentProvider_SearchFilter, IViewNodeConstDef.TYPE_SEARCHFILTER);
                addToMap(result.get(0), result.get(1));
                
                return result;
            }
            
            ContainerItem containerItem = (ContainerItem) parentItem;
            
            if(isViewRootNode(containerItem))
                return result;
            
           
            //webfilter下的使用原item,searchfilter下的使用复制的item
            List<IRepositoryViewObject> viewObjects = RepositoryResourceUtil.findViewObjectsByType(IServerObjectRepositoryType.TYPE_VIEW, parentItem, TreeObject.VIEW);
            List<IRepositoryViewObject> resultList = getChildrenOfFolder(containerItem, viewObjects);
            
            return resultList;
        }
        
        return null;
    }


    private List<IRepositoryViewObject> getChildrenOfFolder(ContainerItem containerItem,
            List<IRepositoryViewObject> viewObjects) {
        List<IRepositoryViewObject> resultList = new ArrayList<IRepositoryViewObject>();
        if(isWebFilterNode(containerItem)) {
            for(IRepositoryViewObject viewObj:viewObjects) {
                if(viewObj.getProperty().getItem() instanceof ContainerItem) {
                    ContainerItem cItem = (ContainerItem) viewObj.getProperty().getItem();
                    cItem.setData(IViewNodeConstDef.TYPE_WEBFILTER);
                    resultList.add(viewObj);
                } else {
                    WSViewItem viewItem = (WSViewItem) viewObj.getProperty().getItem();
                    String name = viewItem.getWsView().getName();
                    if(name.startsWith(IViewNodeConstDef.ViewPrefix))
                        resultList.add(viewObj);
                }
            }
        } else {//
            for(IRepositoryViewObject viewObj:viewObjects) {
                if(viewObj.getProperty().getItem() instanceof ContainerItem) {
                    ContainerItem cItem = (ContainerItem) viewObj.getProperty().getItem();
                    IRepositoryViewObject clonedCategoryObject = cloneContainerItem(cItem, IViewNodeConstDef.TYPE_SEARCHFILTER);
                    resultList.add(clonedCategoryObject);
                    
//                    addToMap(viewObj, clonedCategoryObject);
                } else {
                    WSViewItem viewItem = (WSViewItem) viewObj.getProperty().getItem();
                    String name = viewItem.getWsView().getName();
                    if(!name.startsWith(IViewNodeConstDef.ViewPrefix))
                        resultList.add(viewObj);
                }
            }
        }
        
        return resultList;
    }
    
    private void addCategoryViewObject(List<IRepositoryViewObject> result, IRepositoryNodeConfiguration conf, String label, Object itemData) {
        if (conf != null) {
            IRepositoryViewObject categoryViewObject = RepositoryResourceUtil.getCategoryViewObject(conf);
            ContainerItem containerItem = (ContainerItem) categoryViewObject.getProperty().getItem();
            containerItem.setLabel(label);
            containerItem.setData(itemData);
            categoryViewObject.getProperty().setLabel(label);
            if (categoryViewObject != null) {
                result.add(categoryViewObject);
            }
        }
    }

    public Class<?> getWSObjectClass() {
        return WSView.class;
    }
    
    private boolean isViewRootNode(ContainerItem containerItem) {
        if(containerItem.getData() == null && containerItem.getState().getPath().isEmpty())
            return true;
        return false;
    }
    
    private boolean isWebFilterNode(ContainerItem containerItem) {
        Object value = containerItem.getData();
        if(IViewNodeConstDef.TYPE_WEBFILTER.equalsIgnoreCase((String)value))
            return true;
        
        return false;
    }
    
    private void addToMap(IRepositoryViewObject aObject, IRepositoryViewObject bObject) {
        folderMapWebSearch.put(aObject, bObject);
        folderMapWebSearch.put(bObject, aObject);
    }
    
    public IRepositoryViewObject getMappedViewObject(IRepositoryViewObject reViewObject) {
        return folderMapWebSearch.get(reViewObject);
    }
    
    public Map<IRepositoryViewObject, IRepositoryViewObject> getFolderMap() {
        return folderMapWebSearch;
    }
    
    private IRepositoryViewObject cloneContainerItem(ContainerItem containerItem, Object data) {
        Property prop = PropertiesFactory.eINSTANCE.createProperty();
        prop.setId(EcoreUtil.generateUUID());
        //
        ContainerItem item = MdmpropertiesFactory.eINSTANCE.createContainerItem();
        item.setType(containerItem.getType());

        item.setRepObjType(containerItem.getRepObjType());
        ItemState itemState = PropertiesFactory.eINSTANCE.createItemState();
        itemState.setDeleted(containerItem.getState().isDeleted());
        itemState.setPath(containerItem.getState().getPath());
        item.setState(itemState);
        item.setLabel(containerItem.getLabel());
        item.setData(data);
        //
        prop.setItem(item);
        //
        FolderRepositoryObject containerObject = new FolderRepositoryObject(prop);
        ContainerCacheService.putContainer(containerObject);
        
        return containerObject;
    }
}
