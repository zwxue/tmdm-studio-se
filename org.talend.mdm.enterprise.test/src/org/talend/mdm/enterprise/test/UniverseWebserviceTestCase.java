package org.talend.mdm.enterprise.test;

import java.rmi.RemoteException;

import urn_com_amalto_xtentis_webservice.WSBoolean;
import urn_com_amalto_xtentis_webservice.WSDeleteUniverse;
import urn_com_amalto_xtentis_webservice.WSExistsUniverse;
import urn_com_amalto_xtentis_webservice.WSGetCurrentUniverse;
import urn_com_amalto_xtentis_webservice.WSGetUniverse;
import urn_com_amalto_xtentis_webservice.WSGetUniverseByRevision;
import urn_com_amalto_xtentis_webservice.WSGetUniverseByRevisionType;
import urn_com_amalto_xtentis_webservice.WSGetUniversePKs;
import urn_com_amalto_xtentis_webservice.WSPutUniverse;
import urn_com_amalto_xtentis_webservice.WSUniverse;
import urn_com_amalto_xtentis_webservice.WSUniversePK;

public class UniverseWebserviceTestCase extends WebserviceTestCase {

	public void testGetCurrentUniverse() {
		WSGetCurrentUniverse wsGetCurrentUniverse = new WSGetCurrentUniverse();
		wsGetCurrentUniverse.setDummy("");
		try {
			WSUniverse wsUniverse = defaultPort
					.getCurrentUniverse(wsGetCurrentUniverse);
			assertNotNull(wsUniverse);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testGetUniversePKs() {
		WSGetUniversePKs regex = new WSGetUniversePKs();
		regex.setRegex(".*");
		try {
			WSUniversePK[] wsUniversePKArray = defaultPort
					.getUniversePKs(regex);
			assertNotNull(wsUniversePKArray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testGetUniverse() {
		try {
			WSGetUniverse wsGetUniverse = new WSGetUniverse();
			WSGetCurrentUniverse wsGetCurrentUniverse = new WSGetCurrentUniverse();
			wsGetCurrentUniverse.setDummy("");
			WSUniverse wsUniverse = defaultPort
					.getCurrentUniverse(wsGetCurrentUniverse);
			WSUniversePK wsUniversePK = new WSUniversePK();
			wsUniversePK.setPk(wsUniverse.getName());
			wsGetUniverse.setWsUniversePK(wsUniversePK);
			WSUniverse wsUniverseResult = defaultPort
					.getUniverse(wsGetUniverse);
			assertNotNull(wsUniverseResult);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testExistsUniverse() {
		try {
			WSExistsUniverse wsExistsUniverse = new WSExistsUniverse();
			WSGetCurrentUniverse wsGetCurrentUniverse = new WSGetCurrentUniverse();
			wsGetCurrentUniverse.setDummy("");
			WSUniverse wsUniverse = defaultPort
					.getCurrentUniverse(wsGetCurrentUniverse);
			WSUniversePK wsUniversePK = new WSUniversePK();
			wsUniversePK.setPk(wsUniverse.getName());
			wsExistsUniverse.setWsUniversePK(wsUniversePK);
			WSBoolean wsBoolean = defaultPort.existsUniverse(wsExistsUniverse);
			assertTrue(wsBoolean.is_true());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testGetUniverseByRevision() {
		WSGetUniverseByRevision wsGetUniverseByRevision = new WSGetUniverseByRevision();
		wsGetUniverseByRevision.setType(WSGetUniverseByRevisionType.ITEM);
		wsGetUniverseByRevision.setNamepattern(".*");
		wsGetUniverseByRevision.setRevision("");
		try {
			WSUniversePK[] wsUniversePKArray = defaultPort
					.getUniverseByRevision(wsGetUniverseByRevision);
			assertNotNull(wsUniversePKArray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testPutUniverse() {
		try {
			WSGetCurrentUniverse wsGetCurrentUniverse = new WSGetCurrentUniverse();
			wsGetCurrentUniverse.setDummy("");
			WSUniverse wsUniverse = defaultPort
					.getCurrentUniverse(wsGetCurrentUniverse);
			
			WSPutUniverse wsPutUniverse=new WSPutUniverse();
			wsUniverse.setName(wsUniverse.getName()+"2");
			wsPutUniverse.setWsUniverse(wsUniverse);
			WSUniversePK wsUniversePKResult = defaultPort.putUniverse(wsPutUniverse);
			assertNotNull(wsUniversePKResult);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testGetObjectsForUniverses() {
		try {
			String[] strings = defaultPort.getObjectsForUniverses(null);
			assertNotNull(strings);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testDeleteUniverse() {
		try {
			WSDeleteUniverse wsUniverseDelete = new WSDeleteUniverse();
			WSGetCurrentUniverse wsGetCurrentUniverse = new WSGetCurrentUniverse();
			wsGetCurrentUniverse.setDummy("");
			WSUniverse wsUniverse = defaultPort
					.getCurrentUniverse(wsGetCurrentUniverse);
			WSUniversePK wsUniversePK = new WSUniversePK();
			wsUniversePK.setPk(wsUniverse.getName()+"2");
			wsUniverseDelete.setWsUniversePK(wsUniversePK);
			WSUniversePK wsUniversePKReturn = defaultPort
					.deleteUniverse(wsUniverseDelete);
			assertNotNull(wsUniversePKReturn);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
}
