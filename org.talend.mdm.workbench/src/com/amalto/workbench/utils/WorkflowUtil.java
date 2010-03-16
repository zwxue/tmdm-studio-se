package com.amalto.workbench.utils;

import java.io.File;
import java.util.Hashtable;

import com.amalto.workbench.MDMWorbenchPlugin;

public class WorkflowUtil {
	private static Hashtable<String ,String> workflowCache=new Hashtable<String, String>();// to record workflow file in local workspace
	
	public static void addWorkflowFile(String workflowUUID,String file) {
		try {
			String home=Util.getRealPath(MDMWorbenchPlugin.ID, "/");
			if(file!=null) {
				String dest =new File(home+ File.separator + new File(file).getName()).getAbsolutePath();
				Util.copyFile(file, dest);			
				workflowCache.put(workflowUUID, dest);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void removeWorkflowFile(String workflowUUID) {
		try {
//			String home=Util.getRealPath(MDMWorbenchPlugin.ID, "/");
//			String file=workflowCache.get(workflowUUID);
//			if(file!=null) {
//				String dest =new File(home+ File.separator + new File(file).getName()).getAbsolutePath();
//				new File(dest).delete();
//			}
			workflowCache.remove(workflowUUID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static File getWorkflowFile(String workflowUUID) {
		try {
			String file=workflowCache.get(workflowUUID);
			if(file!=null) {
				String home=Util.getRealPath(MDMWorbenchPlugin.ID, "/");
				String dest =new File(home+ File.separator + new File(file).getName()).getAbsolutePath();
				return new File(dest);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
