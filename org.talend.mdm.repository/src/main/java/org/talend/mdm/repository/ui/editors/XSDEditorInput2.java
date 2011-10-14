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
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.core.service.IInteractiveHandler;
import org.talend.mdm.repository.core.service.InteractiveService;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.utils.Bean2EObjUtil;

import com.amalto.workbench.editors.xsdeditor.XSDEditorInput;
import com.amalto.workbench.models.TreeObject;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class XSDEditorInput2 extends XSDEditorInput implements IRepositoryViewEditorInput {


    private TreeObject treeObject;

    private final IRepositoryViewObject viewObject;

    /**
     * DOC hbhong XSDEditorInput constructor comment.
     * 
     * @param item
     */
    public XSDEditorInput2(IRepositoryViewObject viewObject, IFile file) {
        super(file);
        this.viewObject = viewObject;
        Item item = getInputItem();
        MDMServerObject serverObject = ((MDMServerObjectItem) item).getMDMServerObject();
        IInteractiveHandler handler = InteractiveService.findHandler(IServerObjectRepositoryType.TYPE_DATAMODEL);
        Object wsObj = handler.convert(item, serverObject);
        treeObject = Bean2EObjUtil.getInstance().wrapEObjWithTreeObject(serverObject, wsObj);

    }

    public String getEditorId() {
        return XSDEditor2.EDITOR_ID;
    }

    public Item getInputItem() {
        return viewObject.getProperty().getItem();
    }

    public IRepositoryViewObject getViewObject() {
        return viewObject;
    }

    public TreeObject getTreeObject() {
        return treeObject;
    }

    private boolean readOnly;

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }
}
