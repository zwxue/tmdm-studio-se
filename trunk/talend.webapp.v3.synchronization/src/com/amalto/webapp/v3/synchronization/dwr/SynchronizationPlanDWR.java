package com.amalto.webapp.v3.synchronization.dwr;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

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
	
	private Logger logger=org.apache.log4j.Logger.getLogger(this.getClass());
	
	public SynchronizationPlanDWR() {
		super();
	}

	public boolean saveSyncItem(SynchronizationItem item)throws Exception{
		logger.debug("saveSyncItem() ");
		boolean ret=true;
		try {			
			//set item'node resolvedXml 
			String resolvedXml= item.getNode().serialize();
			item.setStatus(SynchronizationItem.STATUS_RESOLVED);
			logger.debug("resolvedXml-- " +resolvedXml + " status-"+ item.getStatus());
			item.setResolvedProjection(resolvedXml);
			WSSynchronizationItem wsitem=new WSSynchronizationItem();			
			wsitem=item.POJO2WS(item);
			logger.debug(" wsitem.status-"+ wsitem.getStatus().getValue());
			Util.getPort().putSynchronizationItem(new WSPutSynchronizationItem(wsitem));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ret=false;
			//Matcher m = Pattern.compile("(.*Exception:)(.+)",Pattern.DOTALL).matcher(e.getLocalizedMessage());
			//if (m.matches()) throw new Exception(m.group(2));
			throw new Exception(e.getClass().getName() + ": "
					+ e.getLocalizedMessage());			
		}finally{
			return ret;
		}		
	}
	public ListRange getSyncItems()throws Exception{
		logger.debug("getSyncItems() ");
		try {
			List<SynchronizationItem> list=new ArrayList<SynchronizationItem>();	
			
			WSSynchronizationItemPKArray pks=Util.getPort().getSynchronizationItemPKs(new WSGetSynchronizationItemPKs());
			logger.debug("pks() " + pks.getWsSynchronizationItemPK().length);
			WSSynchronizationItemPK[] items= pks.getWsSynchronizationItemPK();
			for(WSSynchronizationItemPK pk: items){
				WSSynchronizationItem item=Util.getPort().getSynchronizationItem(new WSGetSynchronizationItem(pk));
				if(item.getResolvedProjection() ==null ){
					continue;
				}
				SynchronizationItem syncItem=new SynchronizationItem();
				syncItem=syncItem.WS2POJO(item);
				TreeNode node=new TreeNode();
				node=node.deserialize(item.getResolvedProjection());
				logger.debug("item.getResolvedProjection()-- " +item.getResolvedProjection());
				syncItem.setNode(node);
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
