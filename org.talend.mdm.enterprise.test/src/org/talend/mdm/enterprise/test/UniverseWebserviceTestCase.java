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
			System.out.println(wsUniverse);
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
			for (int i = 0; i < wsUniversePKArray.length; i++) {
				System.out.println(wsUniversePKArray[i].getPk());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testGetUniverse() {
		try {
			WSGetUniverse wsGetUniverse = new WSGetUniverse();
			WSGetUniversePKs regex = new WSGetUniversePKs();
			regex.setRegex(".*");
			WSUniversePK[] wsUniversePKArray = defaultPort
					.getUniversePKs(regex);
			wsGetUniverse.setWsUniversePK(wsUniversePKArray[0]);
			WSUniverse wsUniverse = defaultPort.getUniverse(wsGetUniverse);
			System.out.println(wsUniverse.getName());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testExistsUniverse() {
		try {
			WSExistsUniverse wsExistsUniverse = new WSExistsUniverse();
			WSGetUniversePKs regex = new WSGetUniversePKs();
			regex.setRegex(".*");
			WSUniversePK[] wsUniversePKArray = defaultPort
					.getUniversePKs(regex);
			wsExistsUniverse.setWsUniversePK(wsUniversePKArray[0]);
			WSBoolean wsBoolean = defaultPort.existsUniverse(wsExistsUniverse);
			System.out.println(wsBoolean.is_true());
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
			for (int i = 0; i < wsUniversePKArray.length; i++) {
				System.out.println(wsUniversePKArray[i]);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testPutUniverse() {
		try {
			WSGetUniverse wsGetUniverse = new WSGetUniverse();
			WSGetUniversePKs regex = new WSGetUniversePKs();
			regex.setRegex(".*");
			WSUniversePK[] wsUniversePKArray = defaultPort
					.getUniversePKs(regex);
			wsGetUniverse.setWsUniversePK(wsUniversePKArray[0]);
			WSUniverse wsUniverse = defaultPort.getUniverse(wsGetUniverse);
			wsUniverse.setName(wsUniverse.getName() + "_new");
			WSPutUniverse wsPutUniverse = new WSPutUniverse();
			wsPutUniverse.setWsUniverse(wsUniverse);
			WSUniversePK wsUniversePK = defaultPort.putUniverse(wsPutUniverse);
			System.out.println(wsUniversePK.getPk());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testGetObjectsForUniverses() {
		try {
			String[] strings = defaultPort.getObjectsForUniverses(null);
			for (int i = 0; i < strings.length; i++) {
				System.out.println(strings[i]);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testDeleteUniverse() {
		try {
			WSDeleteUniverse wsUniverseDelete = new WSDeleteUniverse();
			WSGetUniversePKs regex = new WSGetUniversePKs();
			regex.setRegex(".*");
			WSUniversePK[] wsUniversePKArray = defaultPort
					.getUniversePKs(regex);
			wsUniverseDelete.setWsUniversePK(wsUniversePKArray[0]);
			WSUniversePK wsUniversePK = defaultPort
					.deleteUniverse(wsUniverseDelete);
			System.out.println(wsUniversePK.getPk());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
}
