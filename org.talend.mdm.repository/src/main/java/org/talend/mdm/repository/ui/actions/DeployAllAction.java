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
package org.talend.mdm.repository.ui.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.core.service.DeployService.DeployStatus;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.mdm.repository.ui.dialogs.deploy.DeployAllDialog;
import org.talend.mdm.repository.utils.Bean2EObjUtil;
import org.talend.repository.model.IProxyRepositoryFactory;

import com.amalto.workbench.models.TreeObject;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployAllAction extends AbstractDeployAction {

    public static boolean IS_DEPLOYALL_FLAG = false;

    private static Logger log = Logger.getLogger(DeployAllAction.class);

    private boolean isButton = false;

    List<String> defNames = new ArrayList<String>();

    public DeployAllAction() {
        super(Messages.DeployAllAction_label);

    }

    public DeployAllAction(boolean isButn) {
        super(Messages.DeployAllAction_label);
        this.isButton = isButn;

    }
    @Override
    public void run() {

        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().saveAllEditors(true);

        Set<IRepositoryViewObject> allChangedObjects = findAllChangedObjects();
        String name = getSameServerName();
        allChangedObjects.addAll(RemoveFromRepositoryAction.getViewObjectsRemovedList());

        DeployAllDialog dialog = new DeployAllDialog(getShell(), commonViewer.getInput(), allChangedObjects, name);
        List<IRepositoryViewObject> selectededViewObjs = new ArrayList<IRepositoryViewObject>();
        int retCode = dialog.open();
        IS_DEPLOYALL_FLAG = false;
        IRepositoryViewObject[] theInput = (IRepositoryViewObject[]) commonViewer.getInput();
        backDeleteObjectsTreeView(theInput);
        if (retCode == IDialogConstants.OK_ID) {
            selectededViewObjs = dialog.getSelectededViewObjs();
            for (IRepositoryViewObject viewObj : selectededViewObjs) {
                Item item = viewObj.getProperty().getItem();
                MDMServerObject serverObj = ((MDMServerObjectItem) item).getMDMServerObject();
                serverObj.getLastServerDef();
            }
            MDMServerDef def = dialog.getTheServerDef();
            List<IRepositoryViewObject> viewObjectsRemoved = new ArrayList<IRepositoryViewObject>();
            for (IRepositoryViewObject viewObj : selectededViewObjs) {
                if (RemoveFromRepositoryAction.getViewObjectsRemovedList().contains(viewObj)) {
                    viewObjectsRemoved.add(viewObj);
                }
            }
            for (IRepositoryViewObject viewObj : viewObjectsRemoved) {
                selectededViewObjs.remove(viewObj);
            }
            if (selectededViewObjs.size() >= 0) {
                // IStatus status = deploy(null, selectededViewObjs);
                IStatus status = updateServer(def, selectededViewObjs, viewObjectsRemoved);
                updateChangedStatus(status);
                if (status.isMultiStatus()) {
                    showDeployStatus(status);
                }
                if (status.isMultiStatus()) {
                    for (IStatus childStatus : status.getChildren()) {
                        DeployService.DeployStatus deployStatus = (DeployStatus) childStatus;
                        if (deployStatus.isOK()) {
                            if (deployStatus.getItem() instanceof MDMServerObjectItem)
                                saveLastServer((MDMServerObjectItem) deployStatus.getItem(), def, selectededViewObjs);
                        }
                    }
                }
                // updateChangedStatus(status);
                // if (status.isMultiStatus()) {
                // showDeployStatus(status);
                // }
            }
        }
        defNames.clear();
        Object input = commonViewer.getInput();
        for (IRepositoryViewObject viewObj : (IRepositoryViewObject[]) input) {
            commonViewer.refresh(viewObj);
        }
    }

    private void backDeleteObjectsTreeView(IRepositoryViewObject[] theInput) {

        for (IRepositoryViewObject viewObj : RemoveFromRepositoryAction.getViewObjectsRemovedList()) {
            Item item = viewObj.getProperty().getItem();
            MDMServerObject serverObj = ((MDMServerObjectItem) item).getMDMServerObject();
            TreeObject treeObj = Bean2EObjUtil.getInstance().wrapEObjWithTreeObject(serverObj);
            viewObj.getRepositoryObjectType();
            switch (treeObj.getType()) {
            case TreeObject.DATA_MODEL:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_DATAMODEL).getChildren().remove(viewObj);
                break;
            case TreeObject.DATA_CLUSTER:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_DATACLUSTER).getChildren().remove(viewObj);
                break;
            case TreeObject.MENU:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_MENU).getChildren().remove(viewObj);
                break;
            case TreeObject.ROUTING_RULE:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_EVENTMANAGER).getChildren().get(1).getChildren()
                        .remove(viewObj);
                break;
            case TreeObject.ROLE:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_ROLE).getChildren().remove(viewObj);
                break;
            case TreeObject.SERVICE_CONFIGURATION:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_SERVICECONFIGURATION).getChildren()
                        .remove(viewObj);
                break;
            case TreeObject.STORED_PROCEDURE:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_STOREPROCEDURE).getChildren().remove(viewObj);
                break;
            case TreeObject.TRANSFORMER:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_EVENTMANAGER).getChildren().get(0).getChildren()
                        .remove(viewObj);
                break;
            case TreeObject.UNIVERSE:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_UNIVERSE).getChildren().remove(viewObj);
                break;
            case TreeObject.VIEW:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_VIEW).getChildren().remove(viewObj);
                break;
            case TreeObject.SYNCHRONIZATIONPLAN:
                getViewObjectByType(theInput, IServerObjectRepositoryType.TYPE_SYNCHRONIZATIONPLAN).getChildren().remove(viewObj);
                break;
            default:
                ;
            }
        }
    }

    public IRepositoryViewObject getViewObjectByType(IRepositoryViewObject[] theInput, ERepositoryObjectType type) {
        for (IRepositoryViewObject viewObj : theInput) {

            if (viewObj.getRepositoryObjectType().equals(type)) {
                return viewObj;
            }

        }
        return null;
    }

    private String getSameServerName() {
        String theName = ""; //$NON-NLS-1$
        for (String name : defNames) {
            if (theName.equals("")) { //$NON-NLS-1$
                theName = name;
            } else {
                if (!name.endsWith(theName))
                    return null;
            }
        }
        return theName;
    }

    private Set<IRepositoryViewObject> findAllChangedObjects() {

        Set<IRepositoryViewObject> changed = new HashSet<IRepositoryViewObject>();
        Object input = commonViewer.getInput();
        for (IRepositoryViewObject viewObj : (IRepositoryViewObject[]) input) {
            findFromContainer(viewObj, changed);
        }
        return changed;

    }

    private void findFromContainer(IRepositoryViewObject viewObj, Set<IRepositoryViewObject> viewObjs) {

        if (viewObj instanceof FolderRepositoryObject) {
            List<Object> selectedObjectCon = getSelectedObject();
            boolean existCon = false;
            for (Object obj : selectedObjectCon) {
            if (obj instanceof IRepositoryViewObject) {
                IRepositoryViewObject vobject = (IRepositoryViewObject) obj;
            if (viewObj == vobject) {
                        existCon = true;
                }
            }
            }
            if (existCon) {
                if (viewObj instanceof FolderRepositoryObject) {
                    for (IRepositoryViewObject vobject : ((FolderRepositoryObject) viewObj).getChildren()) {
                                Item itm = vobject.getProperty().getItem();
                                if (itm instanceof MDMServerObjectItem) {
                                    MDMServerObject serverObject = ((MDMServerObjectItem) itm).getMDMServerObject();
                                    if (serverObject.getLastServerDef() == null || serverObject.isChanged()
                                            || serverObject.isCreated()) {
                                        if (serverObject.getLastServerDef() != null) {
                                            defNames.add(serverObject.getLastServerDef().getName());
                                        }
                                viewObjs.add(vobject);
                                    }
                                }
                            }
                }
            }
            
            for (IRepositoryViewObject child : ((FolderRepositoryObject) viewObj).getChildren()) {
                if (child instanceof FolderRepositoryObject) {
                    findFromContainer(child, viewObjs);
                } else {
                    Item item = child.getProperty().getItem();

                    if (!isButton) {
                    List<Object> selectedObject = getSelectedObject();
                    boolean exist = false;
                    for (Object obj : selectedObject) {
                        if (obj instanceof IRepositoryViewObject) {
                            IRepositoryViewObject vobject = (IRepositoryViewObject) obj;
                            if (child == vobject) {
                                exist = true;
                            }
                        }
                    }
                    if (!exist)
                        continue;
                    }
                    if (item instanceof MDMServerObjectItem) {
                        MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
                        if (serverObject.getLastServerDef()==null || serverObject.isChanged() || serverObject.isCreated()) {
                            if (serverObject.getLastServerDef() != null) {
                                defNames.add(serverObject.getLastServerDef().getName());
                            }
                            viewObjs.add(child);
                        }
                    }
                }
            }
        }

        IS_DEPLOYALL_FLAG = true;
    }
        

    IProxyRepositoryFactory factory = CoreRuntimePlugin.getInstance().getProxyRepositoryFactory();

    private void saveLastServer(MDMServerObjectItem item, MDMServerDef serverDef, List<IRepositoryViewObject> selectededViewObjs) {
        MDMServerObject mdmServerObject = item.getMDMServerObject();
        mdmServerObject.setChanged(false);
        mdmServerObject.setCreated(false);

        mdmServerObject.setLastServerDef(serverDef);
        try {
            factory.save(item);
            for (IRepositoryViewObject obj : selectededViewObjs) {
                refreshParent(obj);
            }
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
    }

    protected void refreshParent(Object object) {
        if (object instanceof IRepositoryViewObject) {
            IRepositoryViewObject parent = ContainerCacheService.getParent((IRepositoryViewObject) object);
            if (parent != null) {
                commonViewer.refresh(parent);
            }
        }
    }
}
