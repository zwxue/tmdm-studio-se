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
package org.talend.mdm.repository.ui.actions.recyclebin;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.i18n.Messages;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class RemovePhysicallyFromRepositoryAction extends AbstractRemoveCommandStackAction {



    /**
     * DOC hbhong RemoveFromRepositoryAction constructor comment.
     * 
     * @param text
     */
    public RemovePhysicallyFromRepositoryAction() {
        super(Messages.RemovePhysicallyFromRepositoryAction_title);
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
        List<IRepositoryViewObject> viewObjs = new ArrayList<IRepositoryViewObject>();
        for (Object obj : getSelectedObject()) {
            if (obj instanceof IRepositoryViewObject) {
                IRepositoryViewObject viewObj = (IRepositoryViewObject) obj;

                viewObjs.add(viewObj);
            }
        }
        removeViewObjects(viewObjs);

    }


}
