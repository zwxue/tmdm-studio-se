package org.talend.mdm.enterprise.test;

import java.rmi.RemoteException;

import urn_com_amalto_xtentis_webservice.WSBoolean;
import urn_com_amalto_xtentis_webservice.WSDeleteRole;
import urn_com_amalto_xtentis_webservice.WSExistsRole;
import urn_com_amalto_xtentis_webservice.WSGetRole;
import urn_com_amalto_xtentis_webservice.WSGetRolePKs;
import urn_com_amalto_xtentis_webservice.WSPutRole;
import urn_com_amalto_xtentis_webservice.WSRole;
import urn_com_amalto_xtentis_webservice.WSRolePK;

public class RoleWebserviceTestCase extends WebserviceTestCase {

	public void testGetRolePKs() {
		WSGetRolePKs regex = new WSGetRolePKs();
		regex.setRegex(".*");
		try {
			WSRolePK[] wsRolePKArray = defaultPort.getRolePKs(regex);
			assertNotNull(wsRolePKArray);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testGetRole() {
		try {
			WSGetRolePKs regex = new WSGetRolePKs();
			regex.setRegex(".*");
			WSRolePK[] wsRolePKArray = defaultPort.getRolePKs(regex);

			WSGetRole wsGetRole = new WSGetRole();
			wsGetRole.setWsRolePK(wsRolePKArray[0]);
			WSRole wsRole = defaultPort.getRole(wsGetRole);
			assertNotNull(wsRole);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testExistsRole() {
		try {
			WSExistsRole wsExistsRole = new WSExistsRole();
			WSGetRolePKs regex = new WSGetRolePKs();
			regex.setRegex(".*");
			WSRolePK[] wsRolePKArray = defaultPort.getRolePKs(regex);

			wsExistsRole.setWsRolePK(wsRolePKArray[0]);
			WSBoolean wsBoolean = defaultPort.existsRole(wsExistsRole);
			assertTrue(wsBoolean.is_true());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testPutRole() {
		try {
			WSPutRole wsPutRole = new WSPutRole();
			WSGetRolePKs regex = new WSGetRolePKs();
			regex.setRegex(".*");
			WSRolePK[] wsRolePKArray = defaultPort.getRolePKs(regex);

			WSGetRole wsGetRole = new WSGetRole();
			wsGetRole.setWsRolePK(wsRolePKArray[0]);
			WSRole wsRole = defaultPort.getRole(wsGetRole);
			wsRole.setName(wsRole.getName() + "_new");
			wsPutRole.setWsRole(wsRole);
			WSRolePK wsRolePK = defaultPort.putRole(wsPutRole);
			assertNotNull(wsRolePK);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testGetObjectsForRoles() {
		try {
			String[] strings = defaultPort.getObjectsForRoles(null);
			assertNotNull(strings);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testDeleteRole() {

		try {
			WSPutRole wsPutRole = new WSPutRole();
			WSGetRolePKs regex = new WSGetRolePKs();
			regex.setRegex(".*");
			WSRolePK[] wsRolePKArray = defaultPort.getRolePKs(regex);

			WSGetRole wsGetRole = new WSGetRole();
			wsGetRole.setWsRolePK(wsRolePKArray[0]);
			WSRole wsRole = defaultPort.getRole(wsGetRole);
			wsRole.setName(wsRole.getName() + "_new2");
			wsPutRole.setWsRole(wsRole);
			WSRolePK wsRolePK = defaultPort.putRole(wsPutRole);
			WSDeleteRole wsRoleDelete = new WSDeleteRole();
			wsRoleDelete.setWsRolePK(wsRolePK);
			WSRolePK wsRolePKReturn = defaultPort.deleteRole(wsRoleDelete);
			assertNotNull(wsRolePKReturn);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
