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

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.talend.mdm.repository.core.AbstractRepositoryAction;
import org.talend.mdm.repository.core.IRepositoryViewGlobalActionHandler;
import org.talend.mdm.repository.i18n.Messages;

import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class CopyAction extends AbstractRepositoryAction {

    /**
     * DOC hbhong CreateFolderAction constructor comment.
     * 
     * @param text
     */
    public CopyAction() {
        super(Messages.CopyAction_copy);
        setImageDescriptor(ImageCache.getImage(EImage.COPY.getPath()));
        this.setId(IRepositoryViewGlobalActionHandler.COPY);
        this.setActionDefinitionId(IRepositoryViewGlobalActionHandler.COPY);
    }

    public String getGroupName() {
        return GROUP_COMMON;
    }

    public void run() {

        IStructuredSelection selection = (IStructuredSelection) getStructuredSelection();
        LocalSelectionTransfer.getTransfer().setSelection(selection);
    }

}
