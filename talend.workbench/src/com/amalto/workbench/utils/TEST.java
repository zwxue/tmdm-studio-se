package com.amalto.workbench.utils;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class TEST {
	public static void main(String[] args){
	File file = new File("icons/");	
	File[] files = file.listFiles();
	
//	Map m=	ESystemDefaultObjects.getSystemDefaultObjexts(TreeObject.DATA_MODEL);	
//	System.out.print(ESystemDefaultObjects.isExist(TreeObject.DATA_MODEL, "BugTracking"));
	Map p = EImage.getAlllEimages();
	
	Iterator it = p.keySet().iterator();
	
	int endIndex;
	int beginIndex;
	String key;
	String path;
	int i=0;
	for(;i<p.size();i++){
		
		files[i].getName();
		
		key =  it.next().toString();
		path =((EImage)p.get(key)).getPath();
		endIndex = path.indexOf(".");
		beginIndex = path.indexOf("/");
		File file1 = new File(path);
		if(!file1.exists())
//			System.out.println(i+" "+files[i].getName());
//		else
			System.out.println(i+" "+file1.getName() +" error");
//		if(!path.subSequence(beginIndex+1, endIndex).toString().equalsIgnoreCase(key))
////			System.out.println(i+" "+"true  "+key+" "+path.substring(beginIndex+1, endIndex));
////		else
//			System.out.println(i+" "+"false "+key+" "+path.substring(beginIndex+1, endIndex));
		
	}
	System.out.println(i);
//	System.out.println(path.substring(beginIndex+1, endIndex));
//	
	
	
	}

}
