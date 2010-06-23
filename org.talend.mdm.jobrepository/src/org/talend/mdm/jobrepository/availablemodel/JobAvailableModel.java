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
package org.talend.mdm.jobrepository.availablemodel;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IMenuManager;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ProcessItem;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.jobrepository.JobRepositoryUtil;
import org.talend.mdm.jobrepository.actions.DeployJobAction;
import org.talend.mdm.jobrepository.actions.OpenJobAction;

import com.amalto.workbench.availablemodel.AbstractAvailableModel;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.EXtentisObjects;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC achen class global comment. Detailled comment
 */
public class JobAvailableModel extends AbstractAvailableModel {

    public void addTreeObjects(XtentisPort port, IProgressMonitor monitor, TreeParent serverRoot) {
        monitor.subTask("Loading Jobs");

        TreeParent jobs = serverRoot.findServerFolder(TreeObject.JOB_REGISTRY);
        if (jobs == null)
            jobs = new TreeParent(EXtentisObjects.JobRegistry.getDisplayName(), serverRoot, TreeObject.JOB_REGISTRY, null, null);

        // TIS JOB
        try {
            TreeParent tosJob = new TreeParent("TIS Jobs", serverRoot, TreeObject.CATEGORY_FOLDER, null, null);
            for (IRepositoryViewObject o : JobRepositoryUtil.getAllTISRepositoryJobs()) {
                Item item = o.getProperty().getItem();
                if (item instanceof ProcessItem) {
                    String name = o.getLabel() + "_" + o.getProperty().getVersion();
                    TreeObject obj = new TreeObject(name, serverRoot, TreeObject.TIS_JOB, o, null);
                    obj.setWsObject(new OpenJobAction());
                    tosJob.addChild(obj);
                }
            }
            jobs.addChild(tosJob);
        } catch (Exception e) {
            e.printStackTrace();
        }
        serverRoot.addChild(jobs);
        monitor.worked(1);
    }

    @Override
    public void fillContextMenu(TreeObject xobject, IMenuManager manager) {
        if (xobject.getType() == TreeObject.TIS_JOB) {
            manager.removeAll();
            manager.add(new DeployJobAction());
            manager.add(new OpenJobAction());
        }
    }

}
