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
package org.talend.mdm.repository.ui.editors;

import org.eclipse.core.resources.IFile;
import org.talend.core.model.properties.Item;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.Bean2EObjUtil;

import com.amalto.workbench.editors.xsdeditor.XSDEditorInput;
import com.amalto.workbench.models.TreeObject;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class XSDEditorInput2 extends XSDEditorInput implements IRepositoryViewEditorInput {

    private final Item item;

    private TreeObject treeObject;

    /**
     * DOC hbhong XSDEditorInput constructor comment.
     * 
     * @param item
     */
    public XSDEditorInput2(Item item, IFile file) {
        super(file);
        this.item = item;
        MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
        treeObject = Bean2EObjUtil.getInstance().wrapWithTreeObject(serverObject);

    }

    @Override
    public String getEditorId() {
        return XSDEditor2.EDITOR_ID;
    }

    @Override
    public Item getInputItem() {
        return item;
    }

    public TreeObject getTreeObject() {
        return treeObject;
    }
}
