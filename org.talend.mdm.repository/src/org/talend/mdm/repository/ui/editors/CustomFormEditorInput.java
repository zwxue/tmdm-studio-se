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
package org.talend.mdm.repository.ui.editors;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPersistableElement;
import org.talend.core.model.properties.Item;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.model.mdmproperties.CustomFormItem;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;


/**
 * DOC hbhong  class global comment. Detailled comment
 */
public class CustomFormEditorInput implements IRepositoryViewEditorInput {

    private Item item;

    private IFile file;

    public boolean exists() {
        // TODO Auto-generated method stub
        return false;
    }

    public ImageDescriptor getImageDescriptor() {
        // TODO Auto-generated method stub
        return null;
    }


    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }


    public IPersistableElement getPersistable() {
        // TODO Auto-generated method stub
        return null;
    }


    public String getToolTipText() {
        // TODO Auto-generated method stub
        return null;
    }


    public Object getAdapter(Class adapter) {
        // TODO Auto-generated method stub
        return null;
    }


    public String getEditorId() {
        // TODO Auto-generated method stub
        return null;
    }


    public Item getInputItem() {
        return item;
    }

    public IFile getReferenceFile() {
        if (file == null) {
            String fileExtension = ((CustomFormItem) item).getCustomForm().getFilename();
            file = RepositoryResourceUtil.findReferenceFile(IServerObjectRepositoryType.TYPE_RESOURCE, item, fileExtension);
        }
        return file;
    }

}
