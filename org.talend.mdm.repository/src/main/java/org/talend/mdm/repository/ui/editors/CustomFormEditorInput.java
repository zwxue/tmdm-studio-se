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
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class CustomFormEditorInput extends DiagramEditorInput implements IRepositoryViewEditorInput {

    private final IRepositoryViewObject viewObject;

    private static final String fileExtension = "form"; //$NON-NLS-1$

    /**
     * DOC hbhong CustomFormEditorInput constructor comment.
     * 
     * @param diagramUri
     * @param domain
     * @param providerId
     * @param disposeEditingDomain
     */
    public CustomFormEditorInput(URI diagramUri, TransactionalEditingDomain domain, IRepositoryViewObject viewObject) {
        super(diagramUri, domain, null, true);
        this.viewObject = viewObject;
    }

    private IFile file;

    public String getEditorId() {
        return "org.talend.mdm.form.editor.MDMCustomFormEditor"; //$NON-NLS-1$
    }

    public Item getInputItem() {
        return viewObject.getProperty().getItem();
    }

    public IRepositoryViewObject getViewObject() {
        return viewObject;
    }

    public IFile getReferenceFile() {
        if (file == null) {
            Item item = getInputItem();

            file = RepositoryResourceUtil.findReferenceFile(IServerObjectRepositoryType.TYPE_CUSTOM_FORM, item, fileExtension);
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CustomFormEditorInput otherInput = (CustomFormEditorInput) obj;
        IFile refFile = getReferenceFile();
        IFile otherRefFile = otherInput.getReferenceFile();
        // System.out.println(refFile.getLocation());
        // System.out.println(otherRefFile.getLocation() + "\n");
        return refFile.equals(otherRefFile);
    }

}
