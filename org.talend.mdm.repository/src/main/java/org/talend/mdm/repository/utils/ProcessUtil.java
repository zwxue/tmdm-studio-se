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
package org.talend.mdm.repository.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.bonitasoft.studio.model.process.Connector;
import org.bonitasoft.studio.model.process.Data;
import org.bonitasoft.studio.model.process.DataType;
import org.bonitasoft.studio.model.process.Element;
import org.bonitasoft.studio.model.process.Group;
import org.bonitasoft.studio.model.process.MainProcess;
import org.bonitasoft.studio.model.process.Parameter;
import org.bonitasoft.studio.model.process.Pool;
import org.bonitasoft.studio.model.process.ProcessFactory;
import org.bonitasoft.studio.model.process.StringType;
import org.bonitasoft.studio.model.process.Task;
import org.bonitasoft.studio.model.process.impl.ProcessFactoryImpl;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.talend.core.model.repository.IRepositoryViewObject;

import com.amalto.workbench.models.Line;

public class ProcessUtil {
	private static final String MDM_PATH_NAME = "MDM"; //$NON-NLS-1$ 
	private static final String WORKFLOW_PATH_NAME = "workflow"; //$NON-NLS-1$ 

    public static MainProcess updateMainProcess(MainProcess mainProcess, List<Line> fields, List<Line> roles, String processName) {
        String diagramName = processName;
        String version = "5.3";//$NON-NLS-1$
        ProcessFactory processFactory = new ProcessFactoryImpl();
        mainProcess.setName(diagramName);
        mainProcess.setLabel(diagramName);
        mainProcess.setBonitaVersion(version);

        // update the Pool:
        Pool pool = null;
        for (Element element : mainProcess.getElements()) {
            if (element instanceof Pool) {
                pool = ((Pool) element);
                pool.setName(processName);
                pool.setLabel(processName);
            }
        }
        if (pool == null)
            pool = processFactory.createPool();

        // update the Task:
        Task task = null;
        for (Element element : pool.getElements()) {
            if (element instanceof Task) {
                task = ((Task) element);
                task.setName("Sample");//$NON-NLS-1$
                task.setLabel("Sample");//$NON-NLS-1$
            }
        }
        if (task == null)
            task = processFactory.createTask();

        StringType type = null;
        for (DataType datatype : mainProcess.getDatatypes()) {
            if (datatype instanceof StringType)
                type = (StringType) datatype;
        }

        // create data
        Data data = processFactory.createData();
        data.setName("mdm_host");//$NON-NLS-1$
        data.setLabel("mdm_host");//$NON-NLS-1$
        data.setDataType(type);
        pool.getData().add(data);

        data = processFactory.createData();
        data.setName("mdm_port");//$NON-NLS-1$
        data.setLabel("mdm_port");//$NON-NLS-1$
        data.setDataType(type);
        pool.getData().add(data);

        data = processFactory.createData();
        data.setName("mdm_username");//$NON-NLS-1$
        data.setLabel("mdm_username");//$NON-NLS-1$
        data.setDataType(type);
        pool.getData().add(data);

        data = processFactory.createData();
        data.setName("mdm_password");//$NON-NLS-1$
        data.setLabel("mdm_password");//$NON-NLS-1$
        data.setDataType(type);
        pool.getData().add(data);

        data = processFactory.createData();
        data.setName("mdm_universe");//$NON-NLS-1$
        data.setLabel("mdm_universe");//$NON-NLS-1$
        data.setDataType(type);
        pool.getData().add(data);

        data = processFactory.createData();
        data.setName("mdm_dataCluster");//$NON-NLS-1$
        data.setLabel("mdm_dataCluster");//$NON-NLS-1$
        data.setDataType(type);
        pool.getData().add(data);

        data = processFactory.createData();
        data.setName("mdm_dataModel");//$NON-NLS-1$
        data.setLabel("mdm_dataModel");//$NON-NLS-1$
        data.setDataType(type);
        pool.getData().add(data);


        List<List<String>> updateMap = new ArrayList<List<String>>();
        for (int i = 0; i < fields.size(); i++) {
            String oriFiled = ((Line) fields.get(i)).keyValues.get(0).value;
            String field = oriFiled.replaceAll("/", "_");//$NON-NLS-1$//$NON-NLS-2$

            Data keydata = processFactory.createData();
            keydata.setName(field);
            keydata.setLabel(field);
            keydata.setDataType(type);
            pool.getData().add(keydata);

            Data valuedata = processFactory.createData();
            valuedata.setName(field + "_xpath");//$NON-NLS-1$
            valuedata.setLabel(field + "_xpath");//$NON-NLS-1$
            valuedata.setDataType(type);
            pool.getData().add(valuedata);

            List<String> inner = new ArrayList<String>();
            inner.add("${" + field + "_xpath" + "}");//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
            inner.add("${" + field + "}");//$NON-NLS-1$//$NON-NLS-2$

            updateMap.add(inner);
        }

        // create the connectors:

        Connector connector = processFactory.createConnector();
        connector.setName("MDMUpdater");//$NON-NLS-1$
        connector.setLabel("MDMUpdater");//$NON-NLS-1$
        connector.setConnectorId("TalendMDMConnector");//$NON-NLS-1$
        connector.setEvent("taskOnFinish");//$NON-NLS-1$

        Parameter parameter = processFactory.createParameter();
        parameter.setKey("setHost");//$NON-NLS-1$
        parameter.setValue("${mdm_host}");//$NON-NLS-1$
        connector.getParameters().add(parameter);

        parameter = processFactory.createParameter();
        parameter.setKey("setPort");//$NON-NLS-1$
        parameter.setValue("${mdm_port}");//$NON-NLS-1$
        connector.getParameters().add(parameter);

        parameter = processFactory.createParameter();
        parameter.setKey("setUsername");//$NON-NLS-1$
        parameter.setValue("${mdm_username}");//$NON-NLS-1$
        connector.getParameters().add(parameter);

        parameter = processFactory.createParameter();
        parameter.setKey("setPassword");//$NON-NLS-1$
        parameter.setValue("${mdm_password}");//$NON-NLS-1$
        connector.getParameters().add(parameter);

        parameter = processFactory.createParameter();
        parameter.setKey("setVersion");//$NON-NLS-1$
        parameter.setValue("${mdm_universe}");//$NON-NLS-1$
        connector.getParameters().add(parameter);

        parameter = processFactory.createParameter();
        parameter.setKey("setDatacontainer");//$NON-NLS-1$
        parameter.setValue("${mdm_dataCluster}");//$NON-NLS-1$
        connector.getParameters().add(parameter);

        parameter = processFactory.createParameter();
        parameter.setKey("setDatamodel");//$NON-NLS-1$
        parameter.setValue("${mdm_dataModel}");//$NON-NLS-1$
        connector.getParameters().add(parameter);

        parameter = processFactory.createParameter();
        parameter.setKey("setUpdatemap");//$NON-NLS-1$
        parameter.setValue(updateMap);
        connector.getParameters().add(parameter);
        task.getConnectors().add(connector);

        // add group chosen by the user:
        for (int i = 0; i < roles.size(); i++) {
            String role = ((Line) roles.get(i)).keyValues.get(0).value.replaceAll("/", "_");//$NON-NLS-1$//$NON-NLS-2$
            Group group = processFactory.createGroup();
            group.setName(role);
            group.setLabel(role);
            group.setConnectorId("TalendMDMRoleResolver");//$NON-NLS-1$

            Parameter groupParameter = processFactory.createParameter();
            groupParameter.setKey("setHost");//$NON-NLS-1$
            groupParameter.setValue("${mdm_host}");//$NON-NLS-1$
            group.getParameters().add(groupParameter);

            groupParameter = processFactory.createParameter();
            groupParameter.setKey("setPort");//$NON-NLS-1$
            groupParameter.setValue("${mdm_port}");//$NON-NLS-1$
            group.getParameters().add(groupParameter);

            groupParameter = processFactory.createParameter();
            groupParameter.setKey("setUsername");//$NON-NLS-1$
            groupParameter.setValue("${mdm_username}");//$NON-NLS-1$
            group.getParameters().add(groupParameter);

            groupParameter = processFactory.createParameter();
            groupParameter.setKey("setPassword");//$NON-NLS-1$
            groupParameter.setValue("${mdm_password}");//$NON-NLS-1$
            group.getParameters().add(groupParameter);

            groupParameter = processFactory.createParameter();
            groupParameter.setKey("setVersion");//$NON-NLS-1$
            groupParameter.setValue("${mdm_universe}");//$NON-NLS-1$
            group.getParameters().add(groupParameter);
            mainProcess.getGroups().add(group);
            task.getGroups().add(group);
        }

        return mainProcess;
    }

    public static void updateDiagram(Diagram diagram, String processName) {
        String diagramName = getProcessCompliantName(processName);
        diagram.setName(diagramName);
    }
    
    public static String getWorkspaceWorkflowPath(IRepositoryViewObject viewObj) {
    	 String prjLabel = viewObj.getProjectLabel();
    	 String path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() +File.separator + prjLabel.toUpperCase() + File.separator  
                       + MDM_PATH_NAME + File.separator+  WORKFLOW_PATH_NAME +File.separator; 
    	 return path ; 
    }

    private static String getProcessCompliantName(String processName) {
        return processName + "_1.0.proc";//$NON-NLS-1$
    }
}
