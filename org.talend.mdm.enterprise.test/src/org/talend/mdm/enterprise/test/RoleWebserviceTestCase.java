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
			for (int i = 0; i < wsRolePKArray.length; i++) {
				System.out.println(wsRolePKArray[i]);
			}
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
			System.out.println(wsRole.getName());
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
			System.out.println(wsBoolean.is_true());
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
			System.out.println(wsRolePK.getPk());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testGetObjectsForRoles() {
		try {
			String[] strings = defaultPort.getObjectsForRoles(null);
			for (int i = 0; i < strings.length; i++) {
				System.out.println(strings[i]);
			}
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
			System.out.println(wsRolePKReturn.getPk());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
