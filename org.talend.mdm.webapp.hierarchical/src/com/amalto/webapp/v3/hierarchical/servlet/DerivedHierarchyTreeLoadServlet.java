package com.amalto.webapp.v3.hierarchical.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.amalto.webapp.core.bean.Configuration;
import com.amalto.webapp.core.dwr.CommonDWR;
import com.amalto.webapp.core.json.JSONObject;
import com.amalto.webapp.core.util.Util;
import com.amalto.webapp.core.util.XtentisWebappException;
import com.amalto.webapp.util.webservices.WSGetChildrenItems;
import com.amalto.webapp.util.webservices.WSStringArray;
import com.amalto.webapp.util.webservices.WSStringPredicate;
import com.amalto.webapp.util.webservices.WSWhereAnd;
import com.amalto.webapp.util.webservices.WSWhereCondition;
import com.amalto.webapp.util.webservices.WSWhereItem;
import com.amalto.webapp.v3.hierarchical.bean.FilterItem;
import com.amalto.webapp.v3.hierarchical.util.HierarchicalUtil;

public class DerivedHierarchyTreeLoadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String fatherPK=req.getParameter("pk");
		
		if(fatherPK==null) {
			outputString(resp, "");
			return;
		}
		
		String recursion=req.getParameter("recursion");
		
        boolean isRecursion=false;
		if(recursion!=null&&recursion.equals("1")) {
			isRecursion=true;
		}
		
		int	fatherLevel=Integer.parseInt(req.getParameter("level"));
		String concept=req.getParameter("nextPivot");
		String labelXpath=req.getParameter("nextDisplay");
		String fkXpath=req.getParameter("nextFkPath");
		String endingFlag=req.getParameter("endingFlag");
		
		FilterItem[] filters = {};
		if(req.getSession().getAttribute(HierarchicalUtil.DERIVED_HIERARCHY_EXT_CRITERION)!=null){
			filters=(FilterItem[]) req.getSession().getAttribute(HierarchicalUtil.DERIVED_HIERARCHY_EXT_CRITERION);
		}
		
		String[] results=getResults(concept,fatherPK, labelXpath, fkXpath,filters);
		try {
			String jsonTree = "";
			ArrayList<JSONObject> rootGroup = new ArrayList<JSONObject>();
			
			for (int i = 0; i < results.length; i++) {
				JSONObject treenode = data2node(results[i],fatherLevel+1,endingFlag,isRecursion);
				rootGroup.add(treenode);
			}
			
			jsonTree=rootGroup.toString();
			
			outputString(resp, jsonTree);

		} catch (Exception e) {
			e.printStackTrace();

			PrintWriter out = resp.getWriter();
			out.println("[Exception]:" + e.getLocalizedMessage());
			out.close();
		}

	}

	private void outputString(HttpServletResponse resp, String jsonTree)throws IOException {
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.println(jsonTree);
		out.close();
	}

	private JSONObject data2node(String result,int level,String endingFlag,boolean isRecursion) throws Exception {
		
		Document doc=Util.parse(result);
		String key=Util.getFirstTextNode(doc, "/result/result-key/");
		String label=Util.getFirstTextNode(doc, "/result/result-label/");
		
		JSONObject treenode = new JSONObject();
		//treenode.put("id", level+"_"+key);
		treenode.put("pk", key);
		treenode.put("text", label);
		if(!isRecursion) {
			treenode.put("level", level);
		}else {
			treenode.put("level", 1);
		}
		if(!isRecursion) {
			treenode.put("leaf", endingFlag.equals("1"));
		}else {
			treenode.put("leaf", false);
		}
		treenode.put("draggable", false);
		treenode.put("allowDrop", false);

		return treenode;
	}

	private String[] getResults(String concept,String fatherId,String labelXpath,String fkXpath,FilterItem[] filters) {
		
        String[] results= {};
		
		try {
			
			Configuration configuration=Configuration.loadConfigurationFromDBDirectly();
			String cluster=configuration.getCluster();
			String datamodel=configuration.getModel();
			String[] PkXpaths=CommonDWR.getBusinessConceptKeyPaths(datamodel, concept);
			if(fkXpath.length()==0)fkXpath=null;
			
//			System.out.println(cluster);
//			System.out.println(concept);
//			System.out.println(PkXpaths[0]);
//			System.out.println(fkXpath);
//			System.out.println(labelXpath);
//			System.out.println(fatherId);
			
			WSGetChildrenItems wsGetChildrenItems=new WSGetChildrenItems(
					   cluster,
					   concept,
					   new WSStringArray(PkXpaths),
					   fkXpath,
					   labelXpath,
					   fatherId,
					   null
					);
			
			// filters
			if (filters == null || filters.length == 0) {
				wsGetChildrenItems.setWhereItem(null);
			} else {
				ArrayList<WSWhereItem> conditions = new ArrayList<WSWhereItem>();
				for (int i = 0; i < filters.length; i++) {
					FilterItem filterItem = filters[i];
					
					//parse related filter item
					if(filterItem.getFieldPath()!=null&&filterItem.getFieldPath().length()>0) {
						if(concept.equals(filterItem.getFieldPath().split("/")[0])) {
							WSWhereCondition wc = new WSWhereCondition(filterItem
									.getFieldPath(), HierarchicalUtil.getOperator(filterItem
									.getOperator()), filterItem.getValue(),
									WSStringPredicate.NONE, false);
							WSWhereItem item = new WSWhereItem(wc, null, null);
							conditions.add(item);
						}
					}
					
				}
				
				if(conditions.size()>0) {
					WSWhereAnd and = new WSWhereAnd(conditions
							.toArray(new WSWhereItem[conditions.size()]));
					WSWhereItem wi = new WSWhereItem(null, and, null);
					wsGetChildrenItems.setWhereItem(wi);
				}else {
					wsGetChildrenItems.setWhereItem(null);
				}
				
			}
			
			
			
			WSStringArray wsStringArray=Util.getPort().getChildrenItems(wsGetChildrenItems);
			results=wsStringArray.getStrings();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (XtentisWebappException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return results;
		
	}

}
