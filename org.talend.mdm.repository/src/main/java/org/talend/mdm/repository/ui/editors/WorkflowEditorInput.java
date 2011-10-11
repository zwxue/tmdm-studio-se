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
import org.eclipse.ui.part.FileEditorInput;
import org.talend.core.model.properties.Item;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class WorkflowEditorInput extends FileEditorInput implements IRepositoryViewEditorInput {

    private Item item;

    private IFile procFile;

    public static String EDITOR_ID = "org.bonitasoft.studio.model.process.diagram.part.ProcessDiagramEditorID"; //$NON-NLS-1$

    /**
     * DOC hbhong WorkflowEditorInput constructor comment.
     * 
     * @param file
     */
    public WorkflowEditorInput(Item item, IFile file) {
        super(file);
        this.item = item;
    }


  
    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput#getEditorId()
     */
    public String getEditorId() {
        return EDITOR_ID;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput#getInputItem()
     */
    public Item getInputItem() {
        return item;
    }

    private boolean readOnly;

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

}
