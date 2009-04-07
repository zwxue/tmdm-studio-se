package com.amalto.webapp.v3.synchronization.dwr;

import java.io.FileReader;
import java.io.FileWriter;

import com.amalto.webapp.v3.synchronization.bean.TreeNode;

public class SynchronizationPlanDWR {
	public SynchronizationPlanDWR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TreeNode loadSynchronizationPlan()throws Exception{
		char[] buf=new char[1024];
		StringBuffer sb=new StringBuffer();
		FileReader fr =new FileReader("c:\\abc.xml");
		while(fr.read(buf)>0){
			sb.append(buf);
		}
		TreeNode root=TreeNode.deserialize(sb.toString());		
		return root;
	}

	public void saveSynchronizationPlan(TreeNode root) throws Exception {
		
		String xml=root.serialize();
		System.out.println(xml);
		FileWriter fw=new FileWriter("c:\\abc.xml");
		
		fw.write(xml);
		fw.flush();
		fw.close();
//		try {
//			
//			return Util.getPort().putItem(
//					new WSPutItem(
//							new WSDataClusterPK(dataclusterPK), synchronizationPlan.serialize(), 
//							new WSDataModelPK("PROVISIONING"))
//						).getIds()[0];
//
//
//		} catch (Exception e) {
//			Matcher m = Pattern.compile("(.*Exception:)(.+)", Pattern.DOTALL)
//					.matcher(e.getLocalizedMessage());
//			if (m.matches())
//				throw new Exception(m.group(2));
//			throw new Exception(e.getClass().getName() + ": "
//					+ e.getLocalizedMessage());
//		}
	}
}
