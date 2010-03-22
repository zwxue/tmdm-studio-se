package com.amalto.webapp.v3.hierarchical.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.amalto.webapp.core.bean.Configuration;
import com.amalto.webapp.core.json.JSONObject;
import com.amalto.webapp.core.util.Util;
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
		
		String inverseDirection=req.getParameter("inverseDirection");
		boolean isInverseDirection=(inverseDirection!=null&&inverseDirection.equals("true"))?true:false;
		
		String belongRelation=req.getParameter("belongRelation");
		boolean isBelongRelation=(belongRelation!=null&&belongRelation.equals("true"))?true:false;
		
		String recursion=req.getParameter("recursion");
        boolean isRecursion=false;
		if(recursion!=null&&recursion.equals("1")) {
			isRecursion=true;
		}
		
		int	fatherLevel=Integer.parseInt(req.getParameter("level"));
		String concept=req.getParameter("nextPivot");
		if(req.getParameter("nextPivot")!=null&&(req.getParameter("nextPivot").equals("")||req.getParameter("nextPivot").equals("undefined")))concept=null;
		String concept0=req.getParameter("prePivot");
		if(req.getParameter("prePivot")!=null&&(req.getParameter("prePivot").equals("")||req.getParameter("prePivot").equals("undefined")))concept0=null;
		String labelXpath=req.getParameter("nextDisplay");
		String fkXpath=req.getParameter("nextFkPath");
		if(req.getParameter("nextFkPath")!=null&&(req.getParameter("nextFkPath").equals("")||req.getParameter("nextFkPath").equals("undefined")))fkXpath=null;
		String fkXpath0=req.getParameter("preFkPath");
		if(req.getParameter("preFkPath")!=null&&(req.getParameter("preFkPath").equals("")||req.getParameter("preFkPath").equals("undefined")))fkXpath0=null;
		String beforeEndingFlag=req.getParameter("beforeEndingFlag");
		String endingFlag=req.getParameter("endingFlag");
		
		FilterItem[] filters = {};
		if(req.getSession().getAttribute(HierarchicalUtil.DERIVED_HIERARCHY_EXT_CRITERION)!=null){
			filters=(FilterItem[]) req.getSession().getAttribute(HierarchicalUtil.DERIVED_HIERARCHY_EXT_CRITERION);
		}
		String[] results= {};
		if((!isInverseDirection&&!isBelongRelation)||(isInverseDirection&&isBelongRelation)){
			results=HierarchicalUtil.getResults(concept,fatherPK, labelXpath, fkXpath,filters);
		}else {
			Configuration configuration = null;
			try {
				configuration = Configuration.loadConfigurationFromDBDirectly();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String cluster=configuration.getCluster();
			String datamodel=configuration.getModel();
			results=HierarchicalUtil.getFatherItem(cluster, datamodel, concept0, fatherPK, fkXpath0, concept, labelXpath, filters);
		}
		
		try {
			String jsonTree = "";
			ArrayList<JSONObject> rootGroup = new ArrayList<JSONObject>();
			
			for (int i = 0; i < results.length; i++) {
				JSONObject treenode = data2node(results[i],fatherLevel+1,beforeEndingFlag,endingFlag,isRecursion,isInverseDirection,isBelongRelation);
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

	private JSONObject data2node(String result,int level,String beforeEndingFlag,String endingFlag,boolean isRecursion,boolean isInverseDirection,boolean isBelongRelation) throws Exception {
		
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
		
		boolean isLeaf=false;
		if(isRecursion||(!isInverseDirection&&isBelongRelation)||(isInverseDirection&&isBelongRelation)) {
			isLeaf=false;
		}else {
			isLeaf=endingFlag.equals("1");
		}
		treenode.put("leaf", isLeaf);
		if(isLeaf){
			treenode.put("draggable", true);
			treenode.put("allowDrop", false);
		}else if(beforeEndingFlag.equals("1")){
			treenode.put("draggable", false);
			treenode.put("allowDrop", true);
		}else {
			treenode.put("draggable", false);
			treenode.put("allowDrop", false);
		}
		

		return treenode;
	}

	

}
