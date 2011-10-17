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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.service.RemoveService;
import org.talend.mdm.repository.core.service.RemoveService.RemoveStatus;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC achen  class global comment. Detailled comment
 */
public class AbstractRemoveAction extends AbstractRepositoryAction {

    // private static Logger log = Logger.getLogger(AbstractDeployAction.class);
    protected AbstractRemoveAction(String text) {
        super(text);
        setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
    }

    protected IStatus remove(MDMServerDef serverDef, List<IRepositoryViewObject> viewObjs) {
        return RemoveService.getInstance().remove(serverDef, viewObjs);
    }

    public String getGroupName() {
        return GROUP_EDIT;
    }

    protected void updateChangedStatus(IStatus status) {
        if (status.isMultiStatus()) {
            for (IStatus childStatus : status.getChildren()) {
                RemoveService.RemoveStatus removeStatus = (RemoveStatus) childStatus;
                if (removeStatus.isOK()) {
                    if (removeStatus.getItem() instanceof MDMServerObjectItem) {
                        MDMServerObjectItem item = (MDMServerObjectItem) removeStatus.getItem();
                        MDMServerObject mdmServerObject = item.getMDMServerObject();
                        mdmServerObject.setChanged(false);
                    }
                }
            }
        }
    }

}
