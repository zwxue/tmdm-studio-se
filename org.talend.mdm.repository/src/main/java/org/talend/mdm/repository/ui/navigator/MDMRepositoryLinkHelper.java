package org.talend.mdm.repository.ui.navigator;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.ILinkHelper;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.designer.core.ui.editor.ProcessEditorInput;
import org.talend.mdm.repository.ui.actions.OpenObjectAction;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.repository.ui.editors.XObjectEditor2;
import org.talend.mdm.repository.ui.editors.XObjectEditorInput2;
import org.talend.mdm.repository.ui.editors.XSDEditor2;
import org.talend.mdm.repository.ui.editors.XSDEditorInput2;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;


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
        if (input instanceof ProcessEditorInput) {
            IRepositoryViewObject theViewObj = getViewObjForJob(input);
            return new StructuredSelection(theViewObj);
        }
        return StructuredSelection.EMPTY;
    }

    private IRepositoryViewObject getViewObjForJob(IEditorInput input) {
        ProcessEditorInput rInput = (ProcessEditorInput) input;
        String name = rInput.getItem().getProperty().getLabel();
        List<IRepositoryViewObject> vObjs = RepositoryResourceUtil.findAllViewObjects(ERepositoryObjectType.PROCESS);
        IRepositoryViewObject theViewObj = null;
        for (IRepositoryViewObject obj : vObjs) {
            if (obj.getLabel().equals(name)) {
                theViewObj = obj;
            }
        }
        return theViewObj;
    }

    public void activateEditor(IWorkbenchPage aPage, IStructuredSelection selection) {
        initOpenAction();
        openAction.selectionChanged(selection);
        // openAction.run();

        for (IEditorPart editor : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditors()) {
            if (editor instanceof XObjectEditor2) {
                if (selection.getFirstElement() == ((XObjectEditorInput2) editor.getEditorInput()).getViewObject()) {
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(editor);
                }
            }
            if (editor instanceof XSDEditor2) {
                if (selection.getFirstElement() == ((XSDEditorInput2) editor.getEditorInput()).getViewObject()) {
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(editor);
                }
            }
        }
    }
}
