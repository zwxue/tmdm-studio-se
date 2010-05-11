package org.talend.mdm.enterprise.test;

import java.rmi.RemoteException;

import urn_com_amalto_xtentis_webservice.WSBoolean;
import urn_com_amalto_xtentis_webservice.WSDELMDMJob;
import urn_com_amalto_xtentis_webservice.WSDataClusterPK;
import urn_com_amalto_xtentis_webservice.WSDataModelPK;
import urn_com_amalto_xtentis_webservice.WSItemPK;
import urn_com_amalto_xtentis_webservice.WSMDMJob;
import urn_com_amalto_xtentis_webservice.WSOperatorType;
import urn_com_amalto_xtentis_webservice.WSPUTMDMJob;
import urn_com_amalto_xtentis_webservice.WSPutItemByOperatorType;

public class JOBWebserviceTestCase extends WebserviceTestCase {
	public static final String MDMTISJOB = "MDMTISJOB";
	public static final String JOB = "JOB";

	public void testGetMDMJob() {

		try {
			WSMDMJob[] wsMDMJobArray = defaultPort.getMDMJob(null);
			assertNotNull(wsMDMJobArray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testPutMDMJob() {
		try {
			WSPUTMDMJob wsPUTMDMJob = new WSPUTMDMJob();
			WSMDMJob[] wsMDMJobArray = defaultPort.getMDMJob(null);
			wsPUTMDMJob.setJobName(wsMDMJobArray[0].getJobName() + "2");
			wsPUTMDMJob.setJobVersion(wsMDMJobArray[0].getJobVersion() + "2");
			WSBoolean wsBoolean = defaultPort.putMDMJob(wsPUTMDMJob);
			assertTrue(wsBoolean.is_true());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testPutItemByOperatorType() {
		WSPutItemByOperatorType wsPutItemByOperatorType = new WSPutItemByOperatorType();
		wsPutItemByOperatorType.setOperatortype(WSOperatorType.INSERT);
		WSDataClusterPK wsDataClusterPK = new WSDataClusterPK();
		wsDataClusterPK.setPk("Order");
		wsPutItemByOperatorType.setWsDataClusterPK(wsDataClusterPK);
		wsPutItemByOperatorType.setWsDataModelPK(new WSDataModelPK("Order"));
		// TODO
		String xmlString = super.BUSINESSCONCEPTSCHEMA;
		wsPutItemByOperatorType.setXmlString(xmlString);
		try {
			WSItemPK wsItemPK = defaultPort
					.putItemByOperatorType(wsPutItemByOperatorType);
			assertNotNull(wsItemPK);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testDeleteMDMJob() {
		try {
			WSDELMDMJob wsDELMDMJob = new WSDELMDMJob();
			WSMDMJob[] wsMDMJobArray = defaultPort.getMDMJob(null);
			wsDELMDMJob.setJobName(wsMDMJobArray[0].getJobName());
			wsDELMDMJob.setJobVersion(wsMDMJobArray[0].getJobVersion());
			WSBoolean wsBoolean = defaultPort.deleteMDMJob(wsDELMDMJob);
			assertNotNull(wsBoolean.is_true());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
}
