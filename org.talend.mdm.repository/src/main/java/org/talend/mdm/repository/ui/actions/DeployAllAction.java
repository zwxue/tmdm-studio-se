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
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.service.DeployService;
import org.talend.mdm.repository.core.service.DeployService.DeployStatus;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.models.ContainerRepositoryObject;
import org.talend.mdm.repository.ui.dialogs.deploy.DeployAllDialog;
import org.talend.repository.model.IProxyRepositoryFactory;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployAllAction extends AbstractDeployAction {

    public static boolean IS_DEPLOYALL_FLAG = false;

    private static Logger log = Logger.getLogger(DeployAllAction.class);

    public DeployAllAction() {
        super(Messages.DeployAllAction_label);

    }

    List<String> defNames = new ArrayList<String>();

    @Override
    public void run() {


        Set<IRepositoryViewObject> allChangedObjects = findAllChangedObjects();
        String name = getSameServerName();


        DeployAllDialog dialog = new DeployAllDialog(getShell(), commonViewer.getInput(), allChangedObjects, name);

        int retCode = dialog.open();
        IS_DEPLOYALL_FLAG = false;

        if (retCode == IDialogConstants.OK_ID) {

            List<IRepositoryViewObject> selectededViewObjs = dialog.getSelectededViewObjs();
            MDMServerDef def = dialog.getTheServerDef();
            if (selectededViewObjs.size() > 0) {
                // IStatus status = deploy(null, selectededViewObjs);
                IStatus status = deploy(def, selectededViewObjs);

                if (status.isMultiStatus()) {
                    for (IStatus childStatus : status.getChildren()) {
                        DeployService.DeployStatus deployStatus = (DeployStatus) childStatus;
                        if (deployStatus.isOK()) {
                            if (deployStatus.getItem() instanceof MDMServerObjectItem)
                                saveLastServer((MDMServerObjectItem) deployStatus.getItem(), def);
                        }
                    }
                }

                updateChangedStatus(status);
                if (status.isMultiStatus()) {
                    showDeployStatus(status);
                }
            }
        }
        defNames.clear();
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

        if (viewObj instanceof ContainerRepositoryObject) {
            for (IRepositoryViewObject child : ((ContainerRepositoryObject) viewObj).getChildren()) {
                if (child instanceof ContainerRepositoryObject) {
                    findFromContainer(child, viewObjs);
                } else {
                    Item item = child.getProperty().getItem();

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


                    if (item instanceof MDMServerObjectItem) {
                        MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();

                        if (serverObject.isChanged() || serverObject.isCreated()) {

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
    private void saveLastServer(MDMServerObjectItem item, MDMServerDef serverDef) {
        MDMServerObject mdmServerObject = item.getMDMServerObject();
        mdmServerObject.setChanged(false);
        mdmServerObject.setCreated(false);

        mdmServerObject.setLastServerDef(serverDef);
        try {
            factory.save(item);
            refreshParent();
        } catch (PersistenceException e) {
            log.error(e.getMessage(), e);
        }
    }

}
