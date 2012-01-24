// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.talend.commons.ui.runtime.image.EImage;
import org.talend.commons.ui.runtime.image.ImageProvider;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.designer.core.debug.JobLaunchShortcutManager;
import org.talend.repository.model.IRepositoryNode.ENodeType;
import org.talend.repository.model.RepositoryNode;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.views.ServerView;

/**
 * DOC fliu class global comment. Detailled comment
 */
public class RunTisJobAction extends Action {

    private ServerView view = ServerView.show();

    public RunTisJobAction() {
        super();
        setImageDescriptor(ImageProvider.getImageDesc(EImage.JOB_ICON));
        setText("Run");
        setToolTipText("Run tis job");
    }

    public void run() {
        if (this.view == null) { // called from ServerView
            return;
        }

        IStructuredSelection selection = (IStructuredSelection) view.getViewer().getSelection();
        TreeObject obj = (TreeObject) selection.getFirstElement();
        if (obj.getType() != TreeObject.TIS_JOB)
            return;

        List<Object> ojbs = new ArrayList<Object>();
        RepositoryNode root = new RepositoryNode(null, null, null);
        for (Iterator<TreeObject> iter = selection.iterator(); iter.hasNext();) {
            TreeObject xobject = iter.next();
            if (xobject != null) {
                IRepositoryViewObject vo = (IRepositoryViewObject) xobject.getWsKey();
                RepositoryNode resnode = new RepositoryNode(vo, root, ENodeType.REPOSITORY_ELEMENT);
                ojbs.add(resnode);
            }
        }
        if (ojbs.size() == 0)
            return;
        StructuredSelection sel = new StructuredSelection(ojbs);
        JobLaunchShortcutManager.run(sel);

    }
}
