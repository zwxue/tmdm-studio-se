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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.talend.core.model.properties.Item;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.model.mdmproperties.WSCustomFormItem;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class CustomFormEditorInput extends DiagramEditorInput implements IRepositoryViewEditorInput {

    /**
     * DOC hbhong CustomFormEditorInput constructor comment.
     * 
     * @param diagramUri
     * @param domain
     * @param providerId
     * @param disposeEditingDomain
     */
    public CustomFormEditorInput(URI diagramUri, TransactionalEditingDomain domain, Item item) {
        super(diagramUri, domain, null, true);
        this.item = item;
    }

    private Item item;

    private IFile file;

    public String getEditorId() {
        return "org.talend.mdm.form.editor.MDMCustomFormEditor"; //$NON-NLS-1$
    }

    public Item getInputItem() {
        return item;
    }

    public IFile getReferenceFile() {
        if (file == null) {
            String fileExtension = ((WSCustomFormItem) item).getCustomForm().getFilename();
            file = RepositoryResourceUtil.findReferenceFile(IServerObjectRepositoryType.TYPE_RESOURCE, item, fileExtension);
        }
        return file;
    }

    private boolean readOnly;

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

}
