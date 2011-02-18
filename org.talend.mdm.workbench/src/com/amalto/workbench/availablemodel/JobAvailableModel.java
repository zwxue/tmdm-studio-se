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
package com.amalto.workbench.availablemodel;

import org.eclipse.core.runtime.IProgressMonitor;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.utils.EXtentisObjects;
import com.amalto.workbench.webservices.WSMDMJob;
import com.amalto.workbench.webservices.WSMDMNULL;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC achen class global comment. Detailled comment
 */
public class JobAvailableModel extends AbstractAvailableModel {

    public void addTreeObjects(XtentisPort port, IProgressMonitor monitor, TreeParent serverRoot) {
        monitor.subTask("Loading Jobs");
        // MDM Job

        TreeParent jobs = serverRoot.findServerFolder(TreeObject.JOB_REGISTRY);
        if (jobs == null)
            jobs = new TreeParent(EXtentisObjects.JobRegistry.getDisplayName(), serverRoot, TreeObject.JOB_REGISTRY, null, null);
        TreeParent deployedJob = new TreeParent("Deployed Jobs", serverRoot, TreeObject.BUILT_IN_CATEGORY_FOLDER, null, null);
        try {
            WSMDMJob[] jobPKs = port.getMDMJob(new WSMDMNULL()).getWsMDMJob();
            if (jobPKs != null) {
                for (int i = 0; i < jobPKs.length; i++) {
                    String name = jobPKs[i].getJobName() + "_" + jobPKs[i].getJobVersion() + jobPKs[i].getSuffix();
                    TreeObject obj = new TreeObject(name, serverRoot, TreeObject.JOB, name, null);
                    deployedJob.addChild(obj);
                }
            }
        } catch (Exception e) {
        }

        jobs.addChild(deployedJob);
        serverRoot.addChild(jobs);
        monitor.worked(1);
    }

}
