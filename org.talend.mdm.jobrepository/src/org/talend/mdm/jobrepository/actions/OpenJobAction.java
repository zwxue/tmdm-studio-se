// ============================================================================
//
// Copyright (C) 2006-2008 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.jobrepository.actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.CommonsPlugin;
import org.talend.commons.ui.image.EImage;
import org.talend.commons.ui.image.ImageProvider;
import org.talend.core.model.process.IProcess2;
import org.talend.core.model.properties.ProcessItem;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.designer.core.model.utils.emf.talendfile.NodeType;
import org.talend.designer.core.ui.MultiPageTalendEditor;
import org.talend.designer.core.ui.editor.ProcessEditorInput;
import org.talend.repository.editor.JobEditorInput;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.IRepositoryNode.ENodeType;
import org.talend.repository.ui.views.RepositoryView;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.views.ServerView;

/**
 * DOC achen class global comment. Detailled comment
 */
public class OpenJobAction extends Action {

    private ServerView view = null;

    public OpenJobAction() {
        super();
        setImageDescriptor(ImageProvider.getImageDesc(EImage.EDIT_ICON));
        setText("Open");
        setToolTipText("Open the job");
    }

    public void run() {
        view = ServerView.show();
        if (this.view == null) { // called from ServerView
            return;
        }
        try {
            IStructuredSelection selection = (IStructuredSelection) view.getViewer().getSelection();
            TreeObject obj = (TreeObject) selection.getFirstElement();
            if (obj.getType() != TreeObject.TIS_JOB)
                return;
            IRepositoryViewObject node = (IRepositoryViewObject) obj.getWsKey();
            ProcessItem processItem = (ProcessItem) node.getProperty().getItem();
            final ProcessEditorInput fileEditorInput = new ProcessEditorInput(processItem, true, true);
            checkUnLoadedNodeForProcess(fileEditorInput);
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

            IEditorPart editorPart = page.findEditor(fileEditorInput);

            if (editorPart == null) {
                fileEditorInput.setView(RepositoryView.show());
                RepositoryNode node1 = new RepositoryNode(node, null, ENodeType.REPOSITORY_ELEMENT);
                fileEditorInput.setRepositoryNode(node1);
                editorPart = page.openEditor(fileEditorInput, MultiPageTalendEditor.ID, true);

            } else {
                ((MultiPageTalendEditor) editorPart).setReadOnly(fileEditorInput.setForceReadOnly(false));
                page.activate(editorPart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkUnLoadedNodeForProcess(JobEditorInput fileEditorInput) {
        if (fileEditorInput == null || fileEditorInput.getLoadedProcess() == null) {
            return;
        }
        IProcess2 loadedProcess = fileEditorInput.getLoadedProcess();
        List<NodeType> unloadedNode = loadedProcess.getUnloadedNode();
        if (unloadedNode != null && !unloadedNode.isEmpty()) {

            String message = "Some Component are not loaded:\n";
            for (int i = 0; i < unloadedNode.size(); i++) {
                message = message + unloadedNode.get(i).getComponentName() + "\n";
            }
            if (!CommonsPlugin.isHeadless() && PlatformUI.isWorkbenchRunning()) {
                Display display = Display.getCurrent();
                if (display == null) {
                    display = Display.getDefault();
                }
                if (display != null) {
                    final Display tmpDis = display;
                    final String tmpMess = message;
                    display.syncExec(new Runnable() {

                        public void run() {
                            Shell shell = null;
                            final IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                            if (activeWorkbenchWindow != null) {
                                shell = activeWorkbenchWindow.getShell();
                            } else {
                                if (tmpDis != null) {
                                    shell = tmpDis.getActiveShell();
                                } else {
                                    shell = new Shell();
                                }
                            }
                            MessageDialog.openWarning(shell, "Warning", tmpMess);
                        }
                    });
                }
            }
        }
    }

}
