package com.amalto.webapp.v3.hierarchical.dwr;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.webapp.core.bean.ComboItemBean;
import com.amalto.webapp.core.bean.Configuration;
import com.amalto.webapp.core.bean.ListRange;
import com.amalto.webapp.core.dwr.CommonDWR;
import com.amalto.webapp.core.util.Util;
import com.amalto.webapp.util.webservices.WSDataClusterPK;
import com.amalto.webapp.util.webservices.WSDataModelPK;
import com.amalto.webapp.util.webservices.WSGetItem;
import com.amalto.webapp.util.webservices.WSItem;
import com.amalto.webapp.util.webservices.WSItemPK;
import com.amalto.webapp.util.webservices.WSPutItem;
import com.amalto.webapp.util.webservices.WSPutItemWithReport;
import com.amalto.webapp.v3.hierarchical.bean.DataObjectContext;
import com.amalto.webapp.v3.hierarchical.bean.FilterItem;
import com.amalto.webapp.v3.hierarchical.bean.UpdateHistory;
import com.amalto.webapp.v3.hierarchical.bean.UpdateRecordItem;
import com.amalto.webapp.v3.hierarchical.util.HierarchicalUtil;

public class DerivedHierarchyDWR {
	
	public ListRange getPivotList(String language) throws Exception {
		try {

			if (language == null || language.length() == 0 || language.equals("null")) {
				language = "en";
			} 

			ListRange listRange = new ListRange();

			List<ComboItemBean> comboItem = new ArrayList<ComboItemBean>();
			Map<String, String> businessConcepts = HierarchicalUtil.getBusinessConcepts(language);
			for (Iterator<String> iterator = businessConcepts.keySet().iterator(); iterator.hasNext();) {
				String xpath = iterator.next();
				String label = businessConcepts.get(xpath);
				comboItem.add(new ComboItemBean(xpath, label));
			}
			listRange.setData(comboItem.toArray());
			listRange.setTotalSize(comboItem.size());
			
			//security
			Map<String, String> map = HierarchicalUtil.getViewsList(language);
			HierarchicalUtil.synchronizeConecptList(listRange, map);
			
			return listRange;
		} catch (Exception e) {
			String err = "Unable to get Data Objects List! ";
			org.apache.log4j.Logger.getLogger(HierarchicalDWR.class).error(err,e);
			throw new Exception(e.getLocalizedMessage());
		}
	}
	
	public List getPivotFilterList(String language,String[] filterArray) throws Exception {
		
		List<ComboItemBean> rtnList = new ArrayList<ComboItemBean>();
		
        List<String> filterConcepts=Arrays.asList(filterArray);
		//FIXME:Cache this 	
		ListRange listRange =getPivotList(language);
		
		Object[] comboItems =listRange.getData();
		for (int i = 0; i < comboItems.length; i++) {
			ComboItemBean comboItem=(ComboItemBean) comboItems[i];
			if(filterConcepts.contains(comboItem.getValue())) {
				rtnList.add(comboItem);
			}
		}
		
		return rtnList;
		
	}
	
	public ListRange getTitleList(String businessConcept,String language) throws Exception {
        ListRange listRange = new ListRange();
        if(businessConcept.equals("-1"))return listRange;
		
		List<ComboItemBean> comboItem=new ArrayList<ComboItemBean>();
		Map<String, String> titleList=HierarchicalUtil.getTitleList(businessConcept, language);
		for (Iterator<String> iterator = titleList.keySet().iterator(); iterator.hasNext();) {
			String xpath = iterator.next();
			String label = titleList.get(xpath);
			comboItem.add(new ComboItemBean(xpath,label));
		}
		
		listRange.setData(comboItem.toArray());
		listRange.setTotalSize(comboItem.size());

		return listRange;
	}
	
	//FIXME:We should think about more than 2 fk-->1 concept case
	public Map<String,String> getFKMap(String businessConcept,String language) {
		Map<String,String> conceptToFXpath=new HashMap<String,String>();
		
		try {
			Configuration config = Configuration.getInstance();
			String dataModelPK = config.getModel();
			Map xpathToLabel = CommonDWR.getFieldsByDataModel(dataModelPK,businessConcept, language, false, true);
			
			for (Iterator iterator = xpathToLabel.keySet().iterator(); iterator.hasNext();) {
				String cxpath = (String) iterator.next();
				int pos=cxpath.indexOf("@FK_");
				if(pos!=-1) {
					String concept=cxpath.substring(pos+4);
					if(concept.indexOf("/")!=-1)concept=concept.substring(0,concept.indexOf("/"));
					String fXpath=cxpath.substring(0,pos);
					conceptToFXpath.put(concept,fXpath);
				}
					
			}
			
           
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conceptToFXpath;

	}
	
	public boolean updateExCriterionForDerivedHerarchy(FilterItem[] filters) {
		
    	try {
			WebContext ctx = WebContextFactory.get();
			
			ctx.getSession().setAttribute(
					HierarchicalUtil.DERIVED_HIERARCHY_EXT_CRITERION,filters
					);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
    public boolean recordChanges(String[] keysArray,String[] xpathArray,String[] newValueArray) {
    	
    	try {
			WebContext ctx = WebContextFactory.get();
			UpdateHistory updateHistory = null; 
			if(ctx.getSession().getAttribute(HierarchicalUtil.DERIVED_HIERARCHY_TREE_UPDATEHISTORY)!=null) {
				updateHistory=(UpdateHistory)ctx.getSession().getAttribute(HierarchicalUtil.DERIVED_HIERARCHY_TREE_UPDATEHISTORY);
			}else{
				updateHistory=new UpdateHistory();
			}
			
			for (int i = 0; i < keysArray.length; i++) {
				updateHistory.logChange(keysArray[i], xpathArray[i], newValueArray[i]);
			}
			ctx.getSession().setAttribute(HierarchicalUtil.DERIVED_HIERARCHY_TREE_UPDATEHISTORY, updateHistory);
			org.apache.log4j.Logger.getLogger(DerivedHierarchyDWR.class).debug("The size of Update History is: "+updateHistory.size());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    	return true;

	}
    
    public String saveChanges(String concept) throws Exception {
    	
    	try {
			WebContext ctx = WebContextFactory.get();
			Configuration configuration = Configuration.getInstance();
			if(ctx.getSession().getAttribute(HierarchicalUtil.DERIVED_HIERARCHY_TREE_UPDATEHISTORY)==null)return "No Changes! ";
			UpdateHistory updateHistory = (UpdateHistory) ctx.getSession().getAttribute(HierarchicalUtil.DERIVED_HIERARCHY_TREE_UPDATEHISTORY);
			if(updateHistory.isEmpty())return "No Changes! ";
			
			for (Iterator<UpdateRecordItem> iterator = updateHistory.iterator(); iterator.hasNext();) {
				UpdateRecordItem updateRecordItem =  iterator.next();
				
				//combine to update data
				String[] keys={updateRecordItem.getKeys()};
				WSItem wsItem=Util.getPort().getItem(new WSGetItem(new WSItemPK(new WSDataClusterPK(configuration.getCluster()),concept,keys)));
				Document document = Util.parse(wsItem.getContent());
				NodeList nlist=Util.getNodeList(document, "/"+updateRecordItem.getXpath());
				if(nlist!=null&&nlist.getLength()>0){
					Node targetNode=nlist.item(0);
					targetNode.setTextContent(updateRecordItem.getNewValue());
				}
				String updatedContent=Util.nodeToString(document);
				//do put
				WSPutItem wsPutItem=new WSPutItem(new WSDataClusterPK(configuration.getCluster()),updatedContent,new WSDataModelPK(configuration.getModel()),false);
				WSPutItemWithReport wsPutItemWithReport=new WSPutItemWithReport(wsPutItem,"genericUI",new Boolean(true));
				Util.getPort().putItemWithReport(wsPutItemWithReport);
			}
			
			ctx.getSession().setAttribute(
					HierarchicalUtil.DERIVED_HIERARCHY_TREE_UPDATEHISTORY,
					new UpdateHistory());
			
			return "OK";
		}catch(Exception e){
			String err= "Unable to update items completely! ";
			org.apache.log4j.Logger.getLogger(DerivedHierarchyDWR.class).error(err,e);
			throw new Exception(e.getLocalizedMessage());
		}
	}

}
