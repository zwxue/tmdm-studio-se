// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.views.ServerView;

/**
 * 
 * @author achen
 * 
 */
public class AbstractAction extends Action {

    protected ServerView server = ServerView.show();

    protected void closePage() {
        IStructuredSelection selection = (IStructuredSelection) server.getViewer().getSelection();
        // add the node here
        IWorkbenchPage page = server.getSite().getWorkbenchWindow().getActivePage();

        if (selection.isEmpty()) {
            return;
        } else {
            List<IEditorPart> opendViewer = new ArrayList<IEditorPart>();

            for (Iterator<TreeObject> iter = selection.iterator(); iter.hasNext();) {
                TreeObject xobject = iter.next();
                IEditorInput xobjectBrowserViewinput = new XObjectBrowserInput(xobject, xobject.getDisplayName());
                IEditorInput xobjectEditorinput = new XObjectEditorInput(xobject, xobject.getDisplayName());

                if (page.findEditor(xobjectBrowserViewinput) != null) {
                    opendViewer.add(page.findEditor(xobjectBrowserViewinput));
                }
                if (page.findEditor(xobjectEditorinput) != null) {
                    opendViewer.add(page.findEditor(xobjectEditorinput));
                }
            }

            if (opendViewer.size() > 0) {
                for (IEditorPart editorpart : opendViewer) {
                    page.closeEditor(editorpart, false);
                }
            }
        }
    }
}
