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

import org.talend.mdm.repository.core.AbstractRepositoryAction;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;


/**
 * DOC hbhong  class global comment. Detailled comment
 */
public class RemoveFromRepositoryAction extends AbstractRepositoryAction {


    /**
     * DOC hbhong RemoveFromRepositoryAction constructor comment.
     * 
     * @param text
     */
    protected RemoveFromRepositoryAction() {
        super("Remove from Repository");
        setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
    }

    @Override
    public String getGroupName() {
        return GROUP_EDIT;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
    }

}
