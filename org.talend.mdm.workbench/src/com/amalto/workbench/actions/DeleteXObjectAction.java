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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.progress.UIJob;
import org.talend.mdm.commmon.util.webapp.XSystemObjects;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.utils.TreeObjectUtil;
import com.amalto.workbench.views.ServerView;

public class DeleteXObjectAction extends Action {

    private static Log log = LogFactory.getLog(DeleteXObjectAction.class);

    private ServerView view = null;

    public DeleteXObjectAction(ServerView view) {
        super();
        this.view = view;
        setImageDescriptor(ImageCache.getImage(EImage.DELETE_OBJ.getPath()));
        setText(Messages.Delete);
        setToolTipText(Messages.bind(Messages.DeleteXObjectAction_ActionTip, IConstants.TALEND));
    }

    public void run() {
        try {
            super.run();
            IStructuredSelection selection = (IStructuredSelection) view.getViewer().getSelection();
            // add the node here
            IWorkbenchPage page = view.getSite().getWorkbenchWindow().getActivePage();
            final ArrayList<TreeObject> toDelList = new ArrayList<TreeObject>();

            if (selection.isEmpty()) {
                return;
            } else {
                int size = selection.size();
                String s = new String();
                List<IEditorPart> opendViewer = new ArrayList<IEditorPart>();

                if (size > 1)
                    s = Messages.DeleteXObjectAction_Instances;
                else
                    s = Messages.DeleteXObjectAction_Instance;

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

                    if ((!xobject.isXObject() && xobject.getType() != TreeObject.CATEGORY_FOLDER)
                            || (xobject.getType() == TreeObject.CATEGORY_FOLDER && xobject.getDisplayName().equals("System"))) //$NON-NLS-1$
                        continue;
                    else if (xobject.getType() == TreeObject.CATEGORY_FOLDER && !xobject.getDisplayName().equals("System")) { //$NON-NLS-1$
                        TreeParent parent = (TreeParent) xobject;
                        LocalTreeObjectRepository.getInstance().receiveAllOffsprings(parent, toDelList);
                        toDelList.add(xobject);
                    } else if (!XSystemObjects.isExist(xobject.getType(), xobject.getDisplayName())) {
                        toDelList.add(xobject);
                    }// if there are items which are not default, isnotdefault is true
                }

                if (opendViewer.size() > 0) {
                    for (IEditorPart editorpart : opendViewer) {
                        page.closeEditor(editorpart, false);
                    }
                }

                if (toDelList.size() > 0) {
                    if (!MessageDialog.openConfirm(this.view.getSite().getShell(),
                            Messages.bind(Messages.DeleteXObjectAction_ConfirmTitle, IConstants.TALEND),
                            Messages.bind(Messages.DeleteXObjectAction_ConfirmContent, toDelList.size(), s)))
                        return;

                }// if the isnotdefault is true,open this dialog
            }// end of if(selection...)

            UIJob job = new UIJob(Messages.DeleteXObjectAction_JobName) {

                @Override
                public IStatus runInUIThread(IProgressMonitor monitor) {
                    try {
                        deleteTreeObject(toDelList);
                        return Status.OK_STATUS;
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                        return Status.CANCEL_STATUS;
                    }
                }
            };
            job.setPriority(Job.SHORT);
            job.schedule();

            // for
            // view.getViewer().refresh();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(view.getSite().getShell(), Messages._Error,
                    Messages.bind(Messages.DeleteXObjectAction_ErrorMsg, IConstants.TALEND, e.getLocalizedMessage()));
        } finally {
            // refresh view
            // view.forceAllSiteToRefresh();
        }
    }

    private void deleteTreeObject(ArrayList<TreeObject> toDelList) throws Exception {
        for (Iterator<TreeObject> iter = toDelList.iterator(); iter.hasNext();) {
            TreeObject xobject = iter.next();
            TreeObjectUtil.deleteTreeObject(xobject, view);

            if (xobject.getParent() != null)
                xobject.getParent().removeChild(xobject);

        }
    }

    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

}
