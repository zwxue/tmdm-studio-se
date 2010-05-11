package org.talend.mdm.enterprise.test;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;

import urn_com_amalto_xtentis_webservice.WSBackgroundJobPK;
import urn_com_amalto_xtentis_webservice.WSBoolean;
import urn_com_amalto_xtentis_webservice.WSDataClusterPK;
import urn_com_amalto_xtentis_webservice.WSGetVersioningSystemConfiguration;
import urn_com_amalto_xtentis_webservice.WSItemPK;
import urn_com_amalto_xtentis_webservice.WSLinkedHashMapTypedContentEntry;
import urn_com_amalto_xtentis_webservice.WSPutVersioningSystemConfiguration;
import urn_com_amalto_xtentis_webservice.WSString;
import urn_com_amalto_xtentis_webservice.WSVersioningCommitItems;
import urn_com_amalto_xtentis_webservice.WSVersioningGetInfo;
import urn_com_amalto_xtentis_webservice.WSVersioningGetItemContent;
import urn_com_amalto_xtentis_webservice.WSVersioningGetItemHistory;
import urn_com_amalto_xtentis_webservice.WSVersioningGetItemsVersions;
import urn_com_amalto_xtentis_webservice.WSVersioningGetObjectsVersions;
import urn_com_amalto_xtentis_webservice.WSVersioningGetUniverseVersions;
import urn_com_amalto_xtentis_webservice.WSVersioningInfo;
import urn_com_amalto_xtentis_webservice.WSVersioningItemHistory;
import urn_com_amalto_xtentis_webservice.WSVersioningItemsVersionsItems;
import urn_com_amalto_xtentis_webservice.WSVersioningObjectsVersionsObjects;
import urn_com_amalto_xtentis_webservice.WSVersioningRestoreItemByRevision;
import urn_com_amalto_xtentis_webservice.WSVersioningRestoreItems;
import urn_com_amalto_xtentis_webservice.WSVersioningRestoreObjects;
import urn_com_amalto_xtentis_webservice.WSVersioningRestoreUniverse;
import urn_com_amalto_xtentis_webservice.WSVersioningSystemConfiguration;
import urn_com_amalto_xtentis_webservice.WSVersioningTagItems;
import urn_com_amalto_xtentis_webservice.WSVersioningTagObjects;
import urn_com_amalto_xtentis_webservice.WSVersioningTagUniverse;
import urn_com_amalto_xtentis_webservice.WSVersioningUniverseVersionsTagStructure;

public class VersioningWebserviceTestCase extends WebserviceTestCase {

	public void testVersioningCommitItems() {
		WSVersioningCommitItems wsVersioningCommitItems = new WSVersioningCommitItems();
		wsVersioningCommitItems.setComment("comment");
		wsVersioningCommitItems.setVersioningSystemName(null);
		WSItemPK[] wsItemPKs = new WSItemPK[1];
		WSItemPK wsItemPK = new WSItemPK();
		wsItemPK.setConceptName("Customer");
		WSDataClusterPK wsDataClusterPK = new WSDataClusterPK();
		wsDataClusterPK.setPk("Order");
		wsItemPK.setWsDataClusterPK(wsDataClusterPK);
		String[] ids = { "" };
		wsItemPK.setIds(ids);
		wsItemPKs[0] = wsItemPK;
		wsVersioningCommitItems.setWsItemPKs(wsItemPKs);
		try {
			WSBackgroundJobPK wsBackgroundJobPK = defaultPort
					.versioningCommitItems(wsVersioningCommitItems);
			assertNotNull(wsBackgroundJobPK);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningRestoreItemByRevision() {
		WSVersioningRestoreItemByRevision wsVersioningRestoreItemByRevision = new WSVersioningRestoreItemByRevision();
		wsVersioningRestoreItemByRevision.setRevision("r1");
		wsVersioningRestoreItemByRevision.setVersioningSystemName(null);

		WSItemPK wsItemPK = new WSItemPK();
		wsItemPK.setConceptName("Customer");
		WSDataClusterPK wsDataClusterPK = new WSDataClusterPK();
		wsDataClusterPK.setPk("Order");
		wsItemPK.setWsDataClusterPK(wsDataClusterPK);
		String[] ids = { "" };
		wsItemPK.setIds(ids);
		wsVersioningRestoreItemByRevision.setWsItemPK(wsItemPK);
		try {
			WSBoolean wsBoolean = defaultPort
					.versioningRestoreItemByRevision(wsVersioningRestoreItemByRevision);
			assertTrue(wsBoolean.is_true());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningGetItemHistory() {
		WSVersioningGetItemHistory wsVersioningGetItemHistory = new WSVersioningGetItemHistory();
		wsVersioningGetItemHistory.setVersioningSystemName(null);

		WSItemPK wsItemPK = new WSItemPK();
		wsItemPK.setConceptName("Customer");
		WSDataClusterPK wsDataClusterPK = new WSDataClusterPK();
		wsDataClusterPK.setPk("Order");
		wsItemPK.setWsDataClusterPK(wsDataClusterPK);
		String[] ids = { "" };
		wsItemPK.setIds(ids);
		wsVersioningGetItemHistory.setWsItemPK(wsItemPK);
		try {
			WSVersioningItemHistory wsVersioningItemHistory = defaultPort
					.versioningGetItemHistory(wsVersioningGetItemHistory);
			assertNotNull(wsVersioningItemHistory);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningGetItemsVersions() {
		WSVersioningGetItemsVersions wsVersioningGetItemsVersions = new WSVersioningGetItemsVersions();
		wsVersioningGetItemsVersions.setVersioningSystemName(null);
		WSItemPK[] wsItemPKs = new WSItemPK[1];
		WSItemPK wsItemPK = new WSItemPK();
		wsItemPK.setConceptName("Customer");
		WSDataClusterPK wsDataClusterPK = new WSDataClusterPK();
		wsDataClusterPK.setPk("Order");
		wsItemPK.setWsDataClusterPK(wsDataClusterPK);
		String[] ids = { "" };
		wsItemPK.setIds(ids);
		wsItemPKs[0] = wsItemPK;

		wsVersioningGetItemsVersions.setWsItemPKs(wsItemPKs);
		try {
			WSVersioningItemsVersionsItems[] wsVersioningItemsVersions = defaultPort
					.versioningGetItemsVersions(wsVersioningGetItemsVersions);
			assertNotNull(wsVersioningItemsVersions);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningGetItemContent() {
		WSVersioningGetItemContent wsVersioningGetItemContent = new WSVersioningGetItemContent();
		wsVersioningGetItemContent.setRevision("r1");
		wsVersioningGetItemContent.setVersioningSystemName(null);
		WSItemPK wsItemPK = new WSItemPK();
		wsItemPK.setConceptName("Customer");
		WSDataClusterPK wsDataClusterPK = new WSDataClusterPK();
		wsDataClusterPK.setPk("Order");
		wsItemPK.setWsDataClusterPK(wsDataClusterPK);
		String[] ids = { "" };
		wsItemPK.setIds(ids);
		wsVersioningGetItemContent.setWsItemPK(wsItemPK);
		try {
			WSString wsString = defaultPort
					.versioningGetItemContent(wsVersioningGetItemContent);
			assertNotNull(wsString);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningGetObjectsVersions() {
		WSVersioningGetObjectsVersions wsVersioningGetObjectsVersions = new WSVersioningGetObjectsVersions();
		wsVersioningGetObjectsVersions.setType("Data Model");
		wsVersioningGetObjectsVersions.setNames(null);
		try {
			WSVersioningObjectsVersionsObjects[] wsersioningObjectsVersionsObjects = defaultPort
					.versioningGetObjectsVersions(wsVersioningGetObjectsVersions);
			assertNotNull(wsersioningObjectsVersionsObjects);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningGetUniverseVersions() {
		WSVersioningGetUniverseVersions wsVersioningGetUniverseVersions = new WSVersioningGetUniverseVersions();
		wsVersioningGetUniverseVersions.setVersioningSystemName(null);
		try {
			WSVersioningUniverseVersionsTagStructure[] wsVersioningUniverseVersionsTagStructures = defaultPort
					.versioningGetUniverseVersions(wsVersioningGetUniverseVersions);
			assertNotNull(wsVersioningUniverseVersionsTagStructures);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningRestoreItems() {
		WSVersioningRestoreItems wsVersioningRestoreItems = new WSVersioningRestoreItems();
		wsVersioningRestoreItems.setComment("comment");
		wsVersioningRestoreItems.setTag("tag");
		wsVersioningRestoreItems.setVersioningSystemName(null);
		WSItemPK[] wsItemPKs = new WSItemPK[1];
		WSItemPK wsItemPK = new WSItemPK();
		wsItemPK.setConceptName("Customer");
		WSDataClusterPK wsDataClusterPK = new WSDataClusterPK();
		wsDataClusterPK.setPk("Order");
		wsItemPK.setWsDataClusterPK(wsDataClusterPK);
		String[] ids = { "" };
		wsItemPK.setIds(ids);
		wsItemPKs[0] = wsItemPK;

		wsVersioningRestoreItems.setWsItemPKs(wsItemPKs);
		try {
			WSBackgroundJobPK wsBackgroundJobPK = defaultPort
					.versioningRestoreItems(wsVersioningRestoreItems);
			assertNotNull(wsBackgroundJobPK);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningRestoreObjects() {
		WSVersioningRestoreObjects wsVersioningRestoreObjects = new WSVersioningRestoreObjects();
		wsVersioningRestoreObjects.setVersioningSystemName(null);
		wsVersioningRestoreObjects.setType("Data Model");
		wsVersioningRestoreObjects.setNames(null);
		wsVersioningRestoreObjects.setTag("tag");
		try {
			WSBackgroundJobPK wsBackgroundJobPK = defaultPort
					.versioningRestoreObjects(wsVersioningRestoreObjects);
			assertNotNull(wsBackgroundJobPK);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningRestoreUniverse() {
		try {
			WSVersioningRestoreUniverse wsVersioningRestoreUniverse = new WSVersioningRestoreUniverse();
			wsVersioningRestoreUniverse.setTag("tag");
			wsVersioningRestoreUniverse.setVersioningSystemName(null);
			String[] encodedClusterNames = { new String("Order".getBytes(),
					"UTF-8") };
			wsVersioningRestoreUniverse
					.setEncodedClusterNames(encodedClusterNames);
			WSBackgroundJobPK wsBackgroundJobPK = defaultPort
					.versioningRestoreUniverse(wsVersioningRestoreUniverse);
			assertNotNull(wsBackgroundJobPK);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningTagItems() {
		WSVersioningTagItems wsVersioningTagItems = new WSVersioningTagItems();
		wsVersioningTagItems.setComment("comment");
		wsVersioningTagItems.setTag("tag");
		wsVersioningTagItems.setVersioningSystemName(null);
		WSItemPK[] wsItemPKs = new WSItemPK[1];
		WSItemPK wsItemPK = new WSItemPK();
		wsItemPK.setConceptName("Customer");
		WSDataClusterPK wsDataClusterPK = new WSDataClusterPK();
		wsDataClusterPK.setPk("Order");
		wsItemPK.setWsDataClusterPK(wsDataClusterPK);
		String[] ids = { "" };
		wsItemPK.setIds(ids);
		wsItemPKs[0] = wsItemPK;
		wsVersioningTagItems.setWsItemPKs(wsItemPKs);
		try {
			WSBackgroundJobPK wsBackgroundJobPK = defaultPort
					.versioningTagItems(wsVersioningTagItems);
			System.out.println(wsBackgroundJobPK.getPk());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningTagObjects() {
		WSVersioningTagObjects wsVersioningTagObjects = new WSVersioningTagObjects();
		wsVersioningTagObjects.setComment("comment");
		wsVersioningTagObjects.setTag("tag");
		wsVersioningTagObjects.setVersioningSystemName(null);
		wsVersioningTagObjects.setType("Data Model");
		wsVersioningTagObjects.setNames(null);
		try {
			WSBackgroundJobPK wsBackgroundJobPK = defaultPort
					.versioningTagObjects(wsVersioningTagObjects);
			assertNotNull(wsBackgroundJobPK);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testVersioningTagUniverse() {
		WSVersioningTagUniverse wsVersioningTagUniverse = new WSVersioningTagUniverse();
		wsVersioningTagUniverse.setComment("comment");
		wsVersioningTagUniverse.setTag("tag");
		WSLinkedHashMapTypedContentEntry[] typeInstances = new WSLinkedHashMapTypedContentEntry[1];
		WSLinkedHashMapTypedContentEntry wsLinkedHashMapTypedContentEntry = new WSLinkedHashMapTypedContentEntry();
		wsLinkedHashMapTypedContentEntry.setKey("Data Cluster");
		String[] value = { "DataClusterPOJO" };
		wsLinkedHashMapTypedContentEntry.setValue(value);
		wsVersioningTagUniverse.setTypeInstances(typeInstances);
		wsVersioningTagUniverse.setVersioningSystemName(null);
		try {
			WSBackgroundJobPK wsBackgroundJobPK = defaultPort
					.versioningTagUniverse(wsVersioningTagUniverse);
			assertNotNull(wsBackgroundJobPK);
		} catch (RemoteException e) {

			e.printStackTrace();
		}

	}

	public void testVersioningGetInfo() {
		WSVersioningGetInfo wsVersioningGetInfo = new WSVersioningGetInfo();
		wsVersioningGetInfo.setVersioningSystemName(null);
		try {
			WSVersioningInfo wsVersioningInfo = defaultPort
					.versioningGetInfo(wsVersioningGetInfo);
			assertNotNull(wsVersioningInfo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testGetVersioningSystemConfiguration() {
		WSGetVersioningSystemConfiguration wsGetVersioningSystemConfiguration = new WSGetVersioningSystemConfiguration();
		wsGetVersioningSystemConfiguration.setVersioningSystemName(null);
		try {
			WSVersioningSystemConfiguration wsVersioningSystemConfiguration = defaultPort
					.getVersioningSystemConfiguration(wsGetVersioningSystemConfiguration);
			assertNotNull(wsVersioningSystemConfiguration);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void testPutVersioningSystemConfiguration() {
		try {
			WSPutVersioningSystemConfiguration wsPutVersioningSystemConfiguration = new WSPutVersioningSystemConfiguration();
			WSGetVersioningSystemConfiguration wsGetVersioningSystemConfiguration = new WSGetVersioningSystemConfiguration();
			wsGetVersioningSystemConfiguration.setVersioningSystemName(null);
			WSVersioningSystemConfiguration wsVersioningSystemConfiguration = defaultPort
					.getVersioningSystemConfiguration(wsGetVersioningSystemConfiguration);

			wsPutVersioningSystemConfiguration
					.setVersioningSystemConfiguration(wsVersioningSystemConfiguration);
			WSString wsString = defaultPort
					.putVersioningSystemConfiguration(wsPutVersioningSystemConfiguration);
			assertNotNull(wsString);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
