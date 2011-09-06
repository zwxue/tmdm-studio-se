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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.models.ContainerRepositoryObject;
import org.talend.mdm.repository.ui.dialogs.deploy.DeployAllDialog;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployAllAction extends AbstractDeployAction {

    public DeployAllAction() {
        super(Messages.DeployAllAction_label);

    }

    @Override
    public void run() {

        Set<IRepositoryViewObject> allChangedObjects = findAllChangedObjects();
        DeployAllDialog dialog = new DeployAllDialog(getShell(), commonViewer.getInput(), allChangedObjects);
        if (dialog.open() == IDialogConstants.OK_ID) {
            List<IRepositoryViewObject> selectededViewObjs = dialog.getSelectededViewObjs();
            if (selectededViewObjs.size() > 0) {
                IStatus status = deploy(null, selectededViewObjs);
                updateChangedStatus(status);
                if (status.isMultiStatus()) {
                    showDeployStatus(status);
                }
            }
        }
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
                    if (item instanceof MDMServerObjectItem) {
                        MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
                        if (serverObject.getLastServerDef() != null && serverObject.isChanged()) {
                            viewObjs.add(child);
                        }
                    }
                }

            }
        }
    }

}
