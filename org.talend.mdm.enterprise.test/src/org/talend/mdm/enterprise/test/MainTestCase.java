package org.talend.mdm.enterprise.test;

import junit.framework.TestSuite;
import talend.mdm.test.MDMTestCase;

public class MainTestCase extends MDMTestCase {

	public static void main(String[] args) {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(JOBWebserviceTestCase.class);
		testSuite.addTestSuite(RoleWebserviceTestCase.class);
		testSuite.addTestSuite(SynchronizationItemWebserviceTestCase.class);
		testSuite.addTestSuite(SynchronizationPlanWebserviceTestCase.class);
		testSuite.addTestSuite(UniverseWebserviceTestCase.class);
		testSuite.addTestSuite(VersioningWebserviceTestCase.class);
		testSuite.addTestSuite(ExtendsWebserviceTestCase.class);
		junit.textui.TestRunner.run(testSuite);
	}

}
