package com.amalto.webapp.v3.synchronization.dwr;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.amalto.webapp.core.bean.ListRange;
import com.amalto.webapp.core.util.Util;
import com.amalto.webapp.util.webservices.WSGetSynchronizationItem;
import com.amalto.webapp.util.webservices.WSGetSynchronizationItemPKs;
import com.amalto.webapp.util.webservices.WSPutSynchronizationItem;
import com.amalto.webapp.util.webservices.WSSynchronizationItem;
import com.amalto.webapp.util.webservices.WSSynchronizationItemPK;
import com.amalto.webapp.util.webservices.WSSynchronizationItemPKArray;
import com.amalto.webapp.v3.synchronization.bean.SynchronizationItem;
import com.amalto.webapp.v3.synchronization.bean.TreeNode;


public class SynchronizationPlanDWR {
	public SynchronizationPlanDWR() {
		super();
	}


	public void saveSynchronizationPlan(TreeNode root) throws Exception {
		
		String xml= root.serialize();
		System.out.println(xml);
		FileWriter fw=new FileWriter("c:\\abc.xml");
		
		fw.write(xml);
		fw.flush();
		fw.close();
	}
	public void saveSyncItem(SynchronizationItem item)throws Exception{
		try {
			WSSynchronizationItem wsitem=new WSSynchronizationItem();
			wsitem=item.POJO2WS(item);
			Util.getPort().putSynchronizationItem(new WSPutSynchronizationItem(wsitem));
			//Util.getPort().getSynchronizationItem(new WSGetSynchronizationItem(new WSSynchronizationItemPK()));
		} catch (Exception e) {
			e.printStackTrace();
			//Matcher m = Pattern.compile("(.*Exception:)(.+)",Pattern.DOTALL).matcher(e.getLocalizedMessage());
			//if (m.matches()) throw new Exception(m.group(2));
			throw new Exception(e.getClass().getName() + ": "
					+ e.getLocalizedMessage());
		}		
	}
	public ListRange getSyncItems()throws Exception{
		org.apache.log4j.Logger.getLogger(this.getClass()).info("getSyncItems() ");
		try {
			List<SynchronizationItem> list=new ArrayList<SynchronizationItem>();	
			
			WSSynchronizationItemPKArray pks=Util.getPort().getSynchronizationItemPKs(new WSGetSynchronizationItemPKs());
			org.apache.log4j.Logger.getLogger(this.getClass()).info("pks() " + pks.getWsSynchronizationItemPK().length);
			WSSynchronizationItemPK[] items= pks.getWsSynchronizationItemPK();
			for(WSSynchronizationItemPK pk: items){
				WSSynchronizationItem item=Util.getPort().getSynchronizationItem(new WSGetSynchronizationItem(pk));
				SynchronizationItem syncItem=new SynchronizationItem();
				syncItem=syncItem.WS2POJO(item);				
				list.add(syncItem);
			}	

			ListRange listRange = new ListRange();
			listRange.setData(list.toArray(new SynchronizationItem[list.size()]));
			listRange.setTotalSize(list.size());			
			return listRange;

		} catch (Exception e) {
			e.printStackTrace();
			//Matcher m = Pattern.compile("(.*Exception:)(.+)",Pattern.DOTALL).matcher(e.getLocalizedMessage());
			//if (m.matches()) throw new Exception(m.group(2));
			throw new Exception(e.getClass().getName() + ": "
					+ e.getLocalizedMessage());
		}

	}
}
