package org.talend.mdm.enterprise.test;

import java.rmi.RemoteException;

import urn_com_amalto_xtentis_webservice.WSBoolean;
import urn_com_amalto_xtentis_webservice.WSDataClusterPK;
import urn_com_amalto_xtentis_webservice.WSDeleteSynchronizationItem;
import urn_com_amalto_xtentis_webservice.WSExistsSynchronizationItem;
import urn_com_amalto_xtentis_webservice.WSGetSynchronizationItem;
import urn_com_amalto_xtentis_webservice.WSGetSynchronizationItemPKs;
import urn_com_amalto_xtentis_webservice.WSItemPK;
import urn_com_amalto_xtentis_webservice.WSProcessInstance;
import urn_com_amalto_xtentis_webservice.WSProcessTaskInstance;
import urn_com_amalto_xtentis_webservice.WSPutSynchronizationItem;
import urn_com_amalto_xtentis_webservice.WSResolveSynchronizationItem;
import urn_com_amalto_xtentis_webservice.WSSynchronizationItem;
import urn_com_amalto_xtentis_webservice.WSSynchronizationItemStatus;
import urn_com_amalto_xtentis_webservice.WSWorkflowDeleteProcessInstancesRequest;
import urn_com_amalto_xtentis_webservice.WSWorkflowDeploy;
import urn_com_amalto_xtentis_webservice.WSWorkflowGetProcessDefinitions;
import urn_com_amalto_xtentis_webservice.WSWorkflowGetProcessInstances;
import urn_com_amalto_xtentis_webservice.WSWorkflowGetTaskList;
import urn_com_amalto_xtentis_webservice.WSWorkflowProcessDefinitionUUID;
import urn_com_amalto_xtentis_webservice.WSWorkflowUnDeploy;

public class SynchronizationItemWebserviceTestCase extends WebserviceTestCase {
	private static final String FILENAME = "c:/MyCustomerProcess_2.4.bar";

	public void testPutSynchronizationItem() {
		try {
			WSPutSynchronizationItem wsPutSynchronizationItem = new WSPutSynchronizationItem();
			WSSynchronizationItem wsSynchronizationItem=new WSSynchronizationItem();
			wsSynchronizationItem.setLastRunPlan("");
			wsSynchronizationItem.setLocalRevisionID("");
			wsSynchronizationItem.setRemoteInstances(null);
			wsSynchronizationItem.setResolvedProjection("");
			wsSynchronizationItem.setStatus(WSSynchronizationItemStatus.EXECUTED);
			WSItemPK wsItemPK=new WSItemPK();
			wsItemPK.setConceptName("Country");
			wsItemPK.setWsDataClusterPK(new WSDataClusterPK("Order"));
			String[] ids={"001","002"};
			wsItemPK.setIds(ids);
			wsSynchronizationItem.setWsItemPK(wsItemPK);
			wsPutSynchronizationItem.setWsSynchronizationItem(wsSynchronizationItem);
			String[] wsSynchronizationItemPK = defaultPort
					.putSynchronizationItem(wsPutSynchronizationItem);
			assertNotNull(wsSynchronizationItemPK);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public void testGetSynchronizationItemPKs() {
		WSGetSynchronizationItemPKs regex = new WSGetSynchronizationItemPKs(
				".*");
		try {
			String[][] wsSynchronizationItemPKArray = defaultPort
					.getSynchronizationItemPKs(regex);
			assertNotNull(wsSynchronizationItemPKArray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testGetSynchronizationItem() {
		try {
			WSGetSynchronizationItem wsGetSynchronizationItem = new WSGetSynchronizationItem();
			WSGetSynchronizationItemPKs regex = new WSGetSynchronizationItemPKs(
					".*");
			String[][] wsSynchronizationItemPKArray = defaultPort
					.getSynchronizationItemPKs(regex);
			wsGetSynchronizationItem
					.setWsSynchronizationItemPK(wsSynchronizationItemPKArray[0]);
			WSSynchronizationItem wsSynchronizationItem = defaultPort
					.getSynchronizationItem(wsGetSynchronizationItem);
			assertNotNull(wsSynchronizationItem);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testExistsSynchronizationItem() {
		try {
			WSExistsSynchronizationItem wsExistsSynchronizationItem = new WSExistsSynchronizationItem();
			WSGetSynchronizationItemPKs regex = new WSGetSynchronizationItemPKs(
					".*");
			String[][] wsSynchronizationItemPKArray = defaultPort
					.getSynchronizationItemPKs(regex);

			wsExistsSynchronizationItem
					.setWsSynchronizationItemPK(wsSynchronizationItemPKArray[0]);
			WSBoolean wsBoolean = defaultPort
					.existsSynchronizationItem(wsExistsSynchronizationItem);
			assertTrue(wsBoolean.is_true());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testResolveSynchronizationItem() {
		try {
			WSResolveSynchronizationItem wsResolveSynchronizationItem = new WSResolveSynchronizationItem();
			WSGetSynchronizationItemPKs regex = new WSGetSynchronizationItemPKs(
					".*");
			String[][] wsSynchronizationItemPKArray = defaultPort
					.getSynchronizationItemPKs(regex);
			wsResolveSynchronizationItem
					.setWsSynchronizationItemPK(wsSynchronizationItemPKArray[0]);
			WSSynchronizationItem wsSynchronizationItem = defaultPort
					.resolveSynchronizationItem(wsResolveSynchronizationItem);
			assertNotNull(wsSynchronizationItem);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testWorkflowGetProcessDefinitions() {
		WSWorkflowGetProcessDefinitions wsWorkflowGetProcessDefinitions = new WSWorkflowGetProcessDefinitions();
		wsWorkflowGetProcessDefinitions.setRegex(".*");
		try {
			WSWorkflowProcessDefinitionUUID[] wsWorkflowProcessDefinitionUUIDArray = defaultPort
					.workflowGetProcessDefinitions(wsWorkflowGetProcessDefinitions);
			assertNotNull(wsWorkflowProcessDefinitionUUIDArray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testWorkflowDeploy() {
		WSWorkflowDeploy wsWorkflowDeploy = new WSWorkflowDeploy();
		// TODO

		wsWorkflowDeploy.setFilename(FILENAME);
		try {
			WSWorkflowProcessDefinitionUUID wsWorkflowProcessDefinitionUUID = defaultPort
					.workflowDeploy(wsWorkflowDeploy);
			assertNotNull(wsWorkflowProcessDefinitionUUID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testWorkflowGetProcessInstances() {
		try {
			WSWorkflowGetProcessInstances instance = new WSWorkflowGetProcessInstances();
			WSWorkflowDeploy wsWorkflowDeploy = new WSWorkflowDeploy();
			// TODO
			String filename = SynchronizationItemWebserviceTestCase.FILENAME;
			wsWorkflowDeploy.setFilename(filename);
			WSWorkflowProcessDefinitionUUID wsWorkflowProcessDefinitionUUID = defaultPort
					.workflowDeploy(wsWorkflowDeploy);

			instance.setUuid(wsWorkflowProcessDefinitionUUID);
			WSProcessInstance[] wsProcessInstanceArray = defaultPort
					.workflowGetProcessInstances(instance);
			assertNotNull(wsProcessInstanceArray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	

	public void testWorkflowGetTaskList() {
		WSWorkflowGetTaskList tasklist = new WSWorkflowGetTaskList();
		// TODO
		tasklist.setProcessinstanceuuid("MyCustomerProcess_2.4");
		try {
			WSProcessTaskInstance[] wsProcessTaskInstanceArray = defaultPort
					.workflowGetTaskList(tasklist);
			assertNotNull(wsProcessTaskInstanceArray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}


	public void testWorkflowDeleteProcessInstances() {
		try {
			WSWorkflowDeleteProcessInstancesRequest deleteWolkflowRequest = new WSWorkflowDeleteProcessInstancesRequest();
			WSWorkflowGetTaskList tasklist = new WSWorkflowGetTaskList();
			// TODO
			tasklist.setProcessinstanceuuid("MyCustomerProcess_2.4");

			WSProcessTaskInstance[] wsProcessTaskInstanceArray = defaultPort
					.workflowGetTaskList(tasklist);
			deleteWolkflowRequest.setProcessName(wsProcessTaskInstanceArray[0]
					.getName());
			WSBoolean wsBoolean = defaultPort
					.workflowDeleteProcessInstances(deleteWolkflowRequest);
			assertTrue(wsBoolean.is_true());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
	public void testDeleteSynchronizationItem() {
		try {
			WSDeleteSynchronizationItem wsSynchronizationItemDelete = new WSDeleteSynchronizationItem();
			WSGetSynchronizationItemPKs regex = new WSGetSynchronizationItemPKs(
					".*");
			String[][] wsSynchronizationItemPKArray = defaultPort
					.getSynchronizationItemPKs(regex);
			wsSynchronizationItemDelete
					.setWsSynchronizationItemPK(wsSynchronizationItemPKArray[0]);
			String[] wsSynchronizationItemPK = defaultPort
					.deleteSynchronizationItem(wsSynchronizationItemDelete);
			System.out.println(wsSynchronizationItemPK);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
	public void testWorkflowUnDeploy() {
		try {
			WSWorkflowDeploy wsWorkflowDeploy = new WSWorkflowDeploy();
			// TODO
			String filename = SynchronizationItemWebserviceTestCase.FILENAME;
			wsWorkflowDeploy.setFilename(filename);

			WSWorkflowProcessDefinitionUUID wsWorkflowProcessDefinitionUUID = defaultPort
					.workflowDeploy(wsWorkflowDeploy);
			WSWorkflowUnDeploy undeploy = new WSWorkflowUnDeploy();
			undeploy.setUuid(wsWorkflowProcessDefinitionUUID);
			WSBoolean wsBoolean = defaultPort.workflowUnDeploy(undeploy);
			assertTrue(wsBoolean.is_true());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
	
}
