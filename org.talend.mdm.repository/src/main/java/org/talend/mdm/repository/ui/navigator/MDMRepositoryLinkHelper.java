package org.talend.mdm.repository.ui.navigator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;
import org.talend.mdm.repository.ui.actions.OpenObjectAction;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;


public class MDMRepositoryLinkHelper implements ILinkHelper {

    OpenObjectAction openAction;

    public MDMRepositoryLinkHelper() {
    }

    private void initOpenAction() {
        if (openAction == null) {
            openAction = new OpenObjectAction();
            MDMRepositoryView repositoryView = MDMRepositoryView.show();
            openAction.initCommonViewer(repositoryView.getCommonViewer());
        }
    }
    public IStructuredSelection findSelection(IEditorInput input) {
        if (input instanceof IRepositoryViewEditorInput) {
            IRepositoryViewEditorInput rInput = (IRepositoryViewEditorInput) input;
            return new StructuredSelection(rInput.getViewObject());
        }
        return StructuredSelection.EMPTY;
    }

    public void activateEditor(IWorkbenchPage aPage, IStructuredSelection selection) {
        initOpenAction();
        openAction.selectionChanged(selection);
        openAction.run();

    }

}
