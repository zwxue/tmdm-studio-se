package com.amalto.workbench;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSGetItemsPivotIndex;
import com.amalto.workbench.webservices.WSGetItemsPivotIndexPivotWithKeysTypedContentEntry;
import com.amalto.workbench.webservices.WSLinkedHashMap;
import com.amalto.workbench.webservices.WSStringArray;
import com.amalto.workbench.webservices.WSStringPredicate;
import com.amalto.workbench.webservices.WSWhereAnd;
import com.amalto.workbench.webservices.WSWhereCondition;
import com.amalto.workbench.webservices.WSWhereItem;
import com.amalto.workbench.webservices.WSWhereOperator;
import com.amalto.workbench.webservices.XtentisPort;

public class MyPortTest {
	
	public static void main(String[] args) {
		try {
			XtentisPort port = Util.getPort(null,"admin","talend");
			
//			//findAllDroppedItemsPKs
//			WSDroppedItemPKArray wsDroppedItemPKArray=port.findAllDroppedItemsPKs(new WSFindAllDroppedItemsPKs("*"));
//			WSDroppedItemPK[] wsDroppedItemPKs=wsDroppedItemPKArray.getWsDroppedItemPK();
//			for (int i = 0; i < wsDroppedItemPKs.length; i++) {
//				System.out.println(wsDroppedItemPKs[i]);
//			}
			
			//Create an item with report
//			String toCreateXmlString="<Customer><CustomerId>TEST008</CustomerId><Name>TEST008</Name><Address>United States</Address></Customer>";
//			WSPutItem wsPutItem1=new WSPutItem(new WSDataClusterPK("Order"),toCreateXmlString,new WSDataModelPK("Order"));
//			WSPutItemWithReport wsPutItemWithReport1=new WSPutItemWithReport(wsPutItem1,IConstants.SOURCE_ADMINWORKBENCH,IConstants.OPERATIONTYPE_CREATE,null);
//			port.putItemWithReport(wsPutItemWithReport1);
			
//			//Update an item with report
//			String toUpdateXmlString="<Pet><PetId>5</PetId><PetName>Jerry</PetName></Pet>";
//			WSPutItem wsPutItem2=new WSPutItem(new WSDataClusterPK("BOLLORE"),toUpdateXmlString,new WSDataModelPK("BOLLORE"));
//			WSUpdateReportItemPOJO wsUpdateReportItemPOJO=new WSUpdateReportItemPOJO("/Pet/PetName","Jerry","Tom");
//			WSUpdateReportItemPOJO[] wsUpdateReportItemPOJOs={wsUpdateReportItemPOJO};
//			WSUpdateReportItemArray wsUpdateReportItemArray=new WSUpdateReportItemArray(wsUpdateReportItemPOJOs);
//			WSPutItemWithReport wsPutItemWithReport2=new WSPutItemWithReport(wsPutItem2,IConstants.SOURCE_ADMINWORKBENCH,IConstants.OPERATIONTYPE_UPDATEE,wsUpdateReportItemArray);
//			port.putItemWithReport(wsPutItemWithReport2);
			
			WSGetItemsPivotIndex wsGetItemsPivotIndex=new WSGetItemsPivotIndex();
			wsGetItemsPivotIndex.setClusterName("Order");
			wsGetItemsPivotIndex.setMainPivotName("PurchaseOrder");
			
			WSGetItemsPivotIndexPivotWithKeysTypedContentEntry typedContentEntry1 =new WSGetItemsPivotIndexPivotWithKeysTypedContentEntry("PurchaseOrder/Customer",new WSStringArray(new String[]{"PurchaseOrder/PurchaseOrderId"}));
			WSGetItemsPivotIndexPivotWithKeysTypedContentEntry typedContentEntry2 =new WSGetItemsPivotIndexPivotWithKeysTypedContentEntry("Customer/Address",new WSStringArray(new String[]{"Customer/CustomerId"}));
			WSLinkedHashMap pivotWithKeys=new WSLinkedHashMap(new WSGetItemsPivotIndexPivotWithKeysTypedContentEntry[]{typedContentEntry1,typedContentEntry2});
			//WSLinkedHashMap pivotWithKeys=new WSLinkedHashMap(new WSGetItemsPivotIndexPivotWithKeysTypedContentEntry[]{typedContentEntry1});
			wsGetItemsPivotIndex.setPivotWithKeys(pivotWithKeys);
			
			wsGetItemsPivotIndex.setIndexPaths(new WSStringArray(new String[]{"PurchaseOrder/Shipper"}));
			
			ArrayList<WSWhereItem> conditions=new ArrayList<WSWhereItem>();
			WSWhereCondition wc=new WSWhereCondition(
					"PurchaseOrder/Customer",
					WSWhereOperator.EQUALS,
					"a",
					WSStringPredicate.NONE,
					false
			);
			WSWhereItem item=new WSWhereItem(wc,null,null);
			conditions.add(item);
			
			WSWhereAnd and=new WSWhereAnd(conditions.toArray(new WSWhereItem[conditions.size()]));
			WSWhereItem wi=new WSWhereItem(null,and,null);
			//wsGetItemsPivotIndex.setWhereItem(wi);
			wsGetItemsPivotIndex.setWhereItem(null);
			
			wsGetItemsPivotIndex.setPivotDirections(null);
			//wsGetItemsPivotIndex.setPivotDirections(new WSStringArray(new String[]{"ascending","descending"}));
			wsGetItemsPivotIndex.setIndexDirections(null);
			//wsGetItemsPivotIndex.setIndexDirections(new WSStringArray(new String[]{"descending"}));
			
			wsGetItemsPivotIndex.setStart(0);
			wsGetItemsPivotIndex.setLimit(0);
			//wsGetItemsPivotIndex.setLimit(2);
			
			String[] result=port.getItemsPivotIndex(wsGetItemsPivotIndex).getStrings();
			
			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}
			
		} catch (XtentisException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
