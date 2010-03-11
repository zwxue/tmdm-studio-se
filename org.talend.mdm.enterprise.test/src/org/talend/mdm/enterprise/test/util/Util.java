package org.talend.mdm.enterprise.test.util;

import urn_com_amalto_xtentis_webservice.XtentisBindingStub;
import urn_com_amalto_xtentis_webservice.XtentisPort;
import urn_com_amalto_xtentis_webservice.XtentisServiceLocator;

public class Util {

	public static XtentisPort getPort(String URL, String Universe, String User,
			String PASSWORD) throws Exception {
		System.out.println("Enterprise test:Getting Port... ");
		XtentisServiceLocator xtentisService = new XtentisServiceLocator();
		xtentisService.setXtentisPortEndpointAddress(URL);
		XtentisPort xtentisWS = xtentisService.getXtentisPort();
		XtentisBindingStub stub = (XtentisBindingStub) xtentisWS;
		if (Universe == null || Universe.trim().length() == 0) {
			stub.setUsername(User);
		} else {
			stub.setUsername(Universe + "/" + User);
		}
		stub.setPassword(PASSWORD);

		return stub;
	}

}
