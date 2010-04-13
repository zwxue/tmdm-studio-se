package com.amalto.workbench.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDParticle;

import com.amalto.workbench.models.Line;
import com.amalto.workbench.models.TreeObject;

public class WorkbenchClipboard {
	
	
	//singleton
	private static WorkbenchClipboard instance;
	
	protected WorkbenchClipboard() {}
	
	public static WorkbenchClipboard getWorkbenchClipboard() {
		if (instance==null) instance = new WorkbenchClipboard();
		return instance;
	}
	
	
	//holds a vector of copied TreeObject
	ArrayList<TreeObject> list = new ArrayList<TreeObject>();
	
	
	
	public void put(ArrayList<TreeObject> list) {
		this.list = list;
	}

	public ArrayList<TreeObject>  get() {
		return this.list;
	}
	
	public void reset() {
		this.list = new ArrayList<TreeObject>();
	}
	
	public void add(TreeObject obj) {
		this.list.add(obj);
	}
	
	public void remove(TreeObject obj) {
		this.list.remove(obj);
	}
	
	public boolean isEmpty() {
		return (this.list == null) || (this.list.size() == 0);
	}
	//add by ymli, fix bug 0009770, add the clip for concept
	ArrayList<XSDElementDeclaration> conceptList = new ArrayList<XSDElementDeclaration>();
	
	ArrayList<XSDParticle> particleList = new ArrayList<XSDParticle>();
	
	public ArrayList<XSDParticle> getParticles() {
		return particleList;
	}

	public void setParticles(ArrayList<XSDParticle> particleList) {
		this.particleList = particleList;
	}
	
	public void add(XSDParticle particle){
		this.particleList.add(particle);
	}
	
	public void particlesReset(){
		this.particleList = new ArrayList<XSDParticle>();
	}
	

	public void add(XSDElementDeclaration concept){
		this.conceptList.add(concept);
	}
	public void conceptsReset(){
		this.conceptList = new ArrayList<XSDElementDeclaration>();
	}
	public  ArrayList<XSDElementDeclaration> getConcepts(){
		return this.conceptList;
	}
	
	public void putConcepts(ArrayList<XSDElementDeclaration> conceptList){
		this.conceptList = conceptList;
	}
	
	//Line
	List<Line> lineList=new ArrayList<Line>();
	public void setLines(List<Line> lineList) {
		resetLines();
		this.lineList.addAll(lineList);
	}
	public List<Line> getLines(){
		return this.lineList;
	}
	public void resetLines() {
		lineList.clear();
	}
}
