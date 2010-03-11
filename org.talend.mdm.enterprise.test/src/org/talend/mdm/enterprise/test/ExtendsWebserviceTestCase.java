package org.talend.mdm.enterprise.test;

import java.rmi.RemoteException;

import urn_com_amalto_xtentis_webservice.WSLicense;
import urn_com_amalto_xtentis_webservice.WSLicensePK;
import urn_com_amalto_xtentis_webservice.WSPutLicense;

public class ExtendsWebserviceTestCase extends WebserviceTestCase {

	public void testPutLicense() {
		WSPutLicense putLicense = new WSPutLicense();
		WSLicense wsLicense = new WSLicense();
		wsLicense.setCustomerCompany("TALEND");
		wsLicense.setLicense("7iRAJBDb49CfCXEiMRcFS7XySBNwtkjIdfG4sPZbGfP6mWwCd0zNmlmIkczz5C6LQ1hPjXwvi01HGMavPlljSvJp3WDQl075ujdt4sNsMhA=");
		putLicense.setWsLicense(wsLicense);
		try {
			WSLicensePK wsLicensePK = defaultPort.putLicense(putLicense);
			System.out.println(wsLicensePK.getPk());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetLicense() {
		try {
			System.out.println(defaultPort.getLicense().getLicense());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
