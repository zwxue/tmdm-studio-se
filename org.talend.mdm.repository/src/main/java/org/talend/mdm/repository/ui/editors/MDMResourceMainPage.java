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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.forms.editor.FormEditor;
import org.talend.mdm.workbench.enterprice.editors.ResourceMainPage;

public class MDMResourceMainPage extends ResourceMainPage {

    public MDMResourceMainPage(FormEditor editor) {
        super(editor);
    }

    protected void refreshData() {

        IEditorInput editorInput = getEditorInput();
        IFile ifile = null;
        if (editorInput instanceof ResourceRepositoryFileEditorInput) {
            ifile = ((ResourceRepositoryFileEditorInput) editorInput).getReferenceFile();
        }
        String path = ifile.getLocation().makeAbsolute().toFile().getAbsolutePath();
        path = "file:\\\\\\" + path; //$NON-NLS-1$
        text.setText(path);
        browser.setUrl(path);

    }

}
