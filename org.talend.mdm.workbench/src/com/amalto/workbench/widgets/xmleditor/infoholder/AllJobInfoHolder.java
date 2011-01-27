package com.amalto.workbench.widgets.xmleditor.infoholder;

import java.util.ArrayList;
import java.util.List;

import com.amalto.workbench.utils.JobInfo;
import com.amalto.workbench.webservices.WSMDMJob;
import com.amalto.workbench.webservices.WSMDMNULL;
import com.amalto.workbench.webservices.XtentisPort;

public class AllJobInfoHolder extends ExternalInfoHolder<JobInfo[]> {

    private XtentisPort port;

    public AllJobInfoHolder(XtentisPort port) {
        this.port = port;
    }

    @Override
    public JobInfo[] getExternalInfo() {

        List<JobInfo> results = new ArrayList<JobInfo>();

        try {
            WSMDMJob[] jobPKs = port.getMDMJob(new WSMDMNULL()).getWsMDMJob();
            if (jobPKs == null)
                return new JobInfo[0];

            for (WSMDMJob eacJobPK : jobPKs)
                results.add(new JobInfo(eacJobPK.getJobName(), eacJobPK.getJobVersion(), eacJobPK.getSuffix()));

        } catch (Exception e) {
            e.printStackTrace();
            return new JobInfo[0];
        }

        return results.toArray(new JobInfo[0]);
    }

    @Override
    public String getId() {
        return INFOID_ALLJOBINFOS;
    }

}
