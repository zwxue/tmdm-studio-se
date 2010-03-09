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
		int fatherLevel=Integer.parseInt(req.getParameter("level"));
		
		String concept=req.getParameter("nextPivot");
		String labelXpath=req.getParameter("nextDisplay");
		String fkXpath=req.getParameter("nextFkPath");
		
		String endingFlag=req.getParameter("endingFlag");
		
		String[] results=getResults(concept,fatherPK, labelXpath, fkXpath);
		try {
			String jsonTree = "";
			ArrayList<JSONObject> rootGroup = new ArrayList<JSONObject>();
			
			for (int i = 0; i < results.length; i++) {
				JSONObject treenode = data2node(results[i],fatherLevel+1,endingFlag);
				rootGroup.add(treenode);
			}
			
			jsonTree=rootGroup.toString();
			
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			out.println(jsonTree);
			out.close();

		} catch (Exception e) {
			e.printStackTrace();

			PrintWriter out = resp.getWriter();
			out.println("[Exception]:" + e.getLocalizedMessage());
			out.close();
		}

	}

	private JSONObject data2node(String result,int level,String endingFlag) throws Exception {
		
		Document doc=Util.parse(result);
		String key=Util.getFirstTextNode(doc, "/result/result-key/");
		String label=Util.getFirstTextNode(doc, "/result/result-label/");
		
		JSONObject treenode = new JSONObject();
		//treenode.put("id", level+"_"+key);
		treenode.put("pk", key);
		treenode.put("text", label);
		treenode.put("level", level);
		treenode.put("leaf", endingFlag.equals("1"));
		//treenode.put("leaf", false);
		treenode.put("draggable", false);
		treenode.put("allowDrop", false);

		return treenode;
	}

	private String[] getResults(String concept,String fatherId,String labelXpath,String fkXpath) {
		
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
					   fatherId
					);
			
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
