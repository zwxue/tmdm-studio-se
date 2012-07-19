package org.talend.mdm.repository.ui.starting;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class ShowWelcomeEditorAction implements IWorkbenchWindowActionDelegate {

    public void run(IAction action) {
        ShowWelcomeEditor.showWelcomeEditor();
    }

    public void selectionChanged(IAction arg0, ISelection arg1) {
        System.out.println();
    }

    public void dispose() {
    }

    public void init(IWorkbenchWindow arg0) {
    }
}