package com.amalto.webapp.v3.synchronization.bean;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.webapp.core.util.Util;


public class TreeNode{

	  private String text;
	  private boolean leaf;
	  
	  public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	private TreeNode[]childNodes;
	  
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public TreeNode[] getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(TreeNode[] childNodes) {
		this.childNodes = childNodes;
	}

	public String serialize(){
		StringBuffer sb=new StringBuffer();
		getStr(sb,this);
		return sb.toString();
	}
	
	public static TreeNode deserialize(String xml)throws Exception{
		Element result = Util.parse(xml).getDocumentElement();
		TreeNode root=new TreeNode();
		root.text=result.getTagName();
		root.leaf=false;
		List<TreeNode> childNodes=new ArrayList<TreeNode>();
		getChildNodes(childNodes,result);
		return root;
	}
	
	private static void getChildNodes( List<TreeNode> childNodes ,Element element){
		NodeList nodelist=element.getChildNodes();
		for(int i=0; i<nodelist.getLength(); i++){
			Node n=nodelist.item(i);
			if(n.getChildNodes().getLength()==0){
				TreeNode treeNode=new TreeNode();
				treeNode.text=n.getTextContent();
				treeNode.leaf=true;
				treeNode.childNodes=new TreeNode[0];
				childNodes.add(treeNode);
			}else{
				TreeNode treeNode=new TreeNode();
				treeNode.text=n.getNodeName();
				treeNode.leaf=false;
				List<TreeNode> children=new ArrayList<TreeNode>();
				getChildNodes(children,element);
			}
		}
	}
	
	private void getStr(StringBuffer sb,TreeNode node){		
		if(!node.isLeaf()){
			sb.append("<" + node.getText() + ">");
			
			for(TreeNode n:node.childNodes){
				getStr(sb,n);
			}
			sb.append("</" + node.getText() + ">");
		}else{
			sb.append(node.getText());
		}
	}

} 

