package com.amalto.workbench.widgets.xmleditor.infoholder;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.amalto.workbench.webservices.WSWorkflowGetProcessDefinitions;
import com.amalto.workbench.webservices.WSWorkflowProcessDefinitionUUID;
import com.amalto.workbench.webservices.WSWorkflowProcessDefinitionUUIDArray;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.xmleditor.util.WorkflowInfo;

public class AllWorkflowInfoHolder extends ExternalInfoHolder<WorkflowInfo[]> {

    private XtentisPort port;

    public AllWorkflowInfoHolder(XtentisPort port) {
        this.port = port;
    }

    @Override
    public WorkflowInfo[] getExternalInfo() {

        List<WorkflowInfo> results = new ArrayList<WorkflowInfo>();

        WSWorkflowProcessDefinitionUUIDArray array;
        try {
            array = port.workflowGetProcessDefinitions(new WSWorkflowGetProcessDefinitions(".*"));
        } catch (RemoteException e) {
            return new WorkflowInfo[0];
        }

        if (array == null || array.getWsWorkflowProcessDefinitions() == null)
            return new WorkflowInfo[0];

        for (WSWorkflowProcessDefinitionUUID id : array.getWsWorkflowProcessDefinitions())
            results.add(new WorkflowInfo(id.getProcessName(), id.getProcessVersion()));

        return results.toArray(new WorkflowInfo[0]);
    }

    @Override
    public String getId() {
        return INFOID_ALLWORKFLOWINFOS;
    }

}
