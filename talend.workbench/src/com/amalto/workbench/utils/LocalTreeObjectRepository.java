package com.amalto.workbench.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Node;

import com.amalto.workbench.models.IXObjectModelListener;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.views.ServerView;

public class LocalTreeObjectRepository implements IXObjectModelListener{
	private Document doc;
	private ServerView view;
	private boolean internalCheck = false;
	
	private static String config = System.getProperty("user.home")+"/.treeObjectConfig.xml";
	private static String rootPath = "/root";
	private static String DEFAULT_CATALOG = "System";
	
	private Element catalogTreeObj = null;
	
	private static LocalTreeObjectRepository repository = null;
	
    synchronized public static LocalTreeObjectRepository getInstance()
    {
        if (repository == null)
        {
        	repository = new LocalTreeObjectRepository();
        }

        return repository;
    }
	
	public void startUp(ServerView vw, String ur)
	{
		 view = vw;
		  
		 try {
			  File configFile = new File(config);
			  if (!configFile.exists())
			  {
				  doc = DocumentHelper.createDocument();
				  doc.addElement("root");
		          XMLWriter writer = new XMLWriter(new FileWriter(configFile), OutputFormat.createPrettyPrint());
		          writer.write(doc);
		          writer.flush();
		          writer.close();
			  }
			  else
			  {				  
				  SAXReader saxReader = new SAXReader();
				  doc = saxReader.read(configFile);
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getXPathForElem(Element elem)
	{
		List<String> xpathList = new ArrayList<String>();
		recurseElementForXPath(elem, xpathList);
		
		String xpathVar = "";
		for (int idx = xpathList.size() - 1; idx >= 0; idx--) {
			xpathVar += "/" + xpathList.get(idx);
		}
		
		return xpathVar;
	}
	
	private void recurseElementForXPath(Element elem, List<String> xpathList)
	{
		if (elem != null) {
			xpathList.add(elem.getName());
		}
		recurseElementForXPath(elem.getParent(), xpathList);
	}
		
	
	public void handleEvent(int type, TreeObject parent, TreeObject child)
	{
		if (internalCheck) return;
		
		switch (type) {
		case IXObjectModelListener.ADD:
			addChild(parent, child);
			break;
		case IXObjectModelListener.DELETE:
			removeChild(parent, child);
			break;
		}
	}
	
	private Element getTopElementWithUser(String user)
	{
		List<Element> userRoots = doc.selectNodes(rootPath + "/" + user);
		Element elementUser;
		if (userRoots.isEmpty()) {
			elementUser = doc.getRootElement().addElement(user);
		} else {
			elementUser = userRoots.get(0);
		}
		
		return elementUser;
	}
	
	private void saveDocument(Document doc)
	{
        File configFile = new File(config);
        StringWriter w = new StringWriter();
        XMLWriter writer = new XMLWriter(w);
        
        try {
			writer.setOutputStream(new FileOutputStream(configFile));
	        writer.write(doc);
	        writer.flush();
	        writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private String filterOutBlank(String input)
	{
		Pattern BLANK = Pattern.compile("([\\s]+)");
		String res = BLANK.matcher(input).replaceAll("");
		res = res.replaceAll("\\[\\w+\\]", "");
		
		return 	res;	
	}
	
    private Element getParentElement(TreeObject treeObj)
    {
		if (!(treeObj instanceof TreeParent))return null;
		
		Element elemFolder = null;
		String xpath = getXPathForTreeObject(treeObj);
		if (doc.selectNodes(xpath).isEmpty()) {
			xpath = getXPathForTreeObject(treeObj.getParent() != null ? treeObj.getParent() : treeObj.getServerRoot());
			if (xpath != null)
			{
				Element elemTop = null;
				if (doc.selectNodes(xpath).isEmpty())
				{
					elemTop = getTopElementWithUser(treeObj.getServerRoot().getUser().getUsername());
				}
				else
				{
					elemTop = (Element)doc.selectNodes(xpath).get(0);
				}
				elemFolder = elemTop.addElement(filterOutBlank(treeObj.getDisplayName()));
				elemFolder.setText(treeObj.getType() + "");	
			}
		}
		else
		{
			elemFolder = (Element)doc.selectNodes(xpath).get(0);
		}
			
		
		return elemFolder;
    }
    
    private String dump()
    {
    	try {
			return Util.nodeToString((Node)doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
    }
    
    
	private void addChild(TreeObject parent, TreeObject child)
	{
		if (parent.getParent() == null && parent.getDisplayName().equals("INVISIBLE ROOT"))
			return;
		String catalog = synchronizeWithElem(child, (TreeParent)parent, true);
		Element elemFolder = getParentElement(parent);
		if (elemFolder != null)
		{
			String xpath = "child::*[name()='" + filterOutBlank(child.getDisplayName()) + "' and text()='" + child.getType() + "']";
			List<Element> list = elemFolder.selectNodes(xpath);
			if (list.isEmpty() && catalog.equals(""))
			{
				elemFolder.addElement(filterOutBlank(child.getDisplayName())).setText(child.getType() + "");
			}
		}
		saveDocument(doc);
	}
	
	private void removeChild(TreeObject parent, TreeObject child) 
	{
		if (parent.getParent() == null && parent.getDisplayName().equals("INVISIBLE ROOT"))
			return;
		synchronizeWithElem(child, (TreeParent)parent, true);
		Element elemFolder = getParentElement(parent);
		String xpath = "child::*[name()='" + filterOutBlank(child.getDisplayName()) + "' and text()='" + child.getType() + "']";
		List<Element> list = elemFolder.selectNodes(xpath);
		if (!list.isEmpty())
		  elemFolder.remove(list.get(0));
		
		saveDocument(doc);
	}
	
	
	public void synchronizeWithDoc(TreeParent root)
	{
		internalCheck = false;
        TreeObject[] targetChildren = root.getChildren();
        for (TreeObject treeObj: targetChildren)
		{
        	if (treeObj instanceof TreeParent && treeObj.getServerRoot() == treeObj)
        		synchronizeWithDoc((TreeParent)treeObj);
        	
        	synchronizeWithElem(treeObj, root, true);
		}
        
        view.getViewer().refresh(false);
		
	}
	
	private String getXPathForTreeObject(TreeObject theObj)
	{	
		List<String> xpathList = new ArrayList<String>();
		recurseTreeObjectForXPath(theObj, xpathList);
		
		String xpathVar = "";
		for (int idx = xpathList.size() - 1; idx >= 0; idx--) {
			xpathVar += "/" + xpathList.get(idx);
		}
		
		return xpathVar;
	}
	
	
	private void recurseTreeObjectForXPath(TreeObject theObj, List<String> list)
	{
		if (theObj.getParent() == null
				&& theObj.getDisplayName().equals("INVISIBLE ROOT")) {
			list.add(rootPath);
			return;
		} else if (theObj instanceof TreeParent
				&& theObj.getServerRoot() == theObj) {
			list.add(theObj.getUser().getUsername());
			list.add("root");
			return;
		} else {
			list.add(filterOutBlank(theObj.getDisplayName()));
		}
		
		recurseTreeObjectForXPath(theObj.getParent() != null ? theObj.getParent() : theObj.getServerRoot(), list);
	}
	
	private String synchronizeWithElem(TreeObject theObj, TreeParent folder, boolean fireEvent)
	{
		internalCheck = fireEvent;
		String catalogPath = checkUpCatalogRepositoryForTreeObject(theObj, folder);
		if (!catalogPath.equals("") && folder.getType() != TreeObject.CATEGORY_FOLDER)
		{
			// create a catalog folder and insert the theObj into it
			TreeParent category = null;
			for (TreeObject child: folder.getChildren())
			{
				if (child.getDisplayName().equals(catalogPath)
						&& child.getType() == TreeObject.CATEGORY_FOLDER
						&& child instanceof TreeParent)
				{
					category = (TreeParent)child;
					break;
				}
			}
			
			if (category == null) {
				category = new TreeParent(catalogPath.substring(
						catalogPath.lastIndexOf("/") + 1).trim(), folder
						.getServerRoot(), TreeObject.CATEGORY_FOLDER, null,
						null);				
		   		folder.addChild(category);
		   		category.setServerRoot(folder.getServerRoot());
			}


	   		boolean exist = false;
	   		for (TreeObject obj: category.getChildren())
	   		{
	   			if (obj.getDisplayName().equals(theObj.getDisplayName()) && obj.getType() == theObj.getType())
	   			{
	   				exist = true;
	   				break;
	   			}
	   		}
	   		
	   		if (!exist)
	   		{
		   		folder.removeChild(theObj);
	   		  category.addChild(theObj);
	   		}
		}
		else
		{
			// check up the system catalog, create it and all system tree objects
			// into it if these objects are not categorized
			if (ESystemDefaultObjects.isExist(theObj.getType(), theObj.getDisplayName()))
			{
				TreeParent systemCatalog = null;
				for (TreeObject xobj: folder.getChildren())
				{
					if (DEFAULT_CATALOG.equals(filterOutBlank(xobj.getDisplayName())) && xobj.getType() == TreeObject.CATEGORY_FOLDER)
					{
						systemCatalog = (TreeParent)xobj;
						break;
					}
				}
				
				if (folder.getDisplayName().equals("System") && folder.getType() == TreeObject.CATEGORY_FOLDER)
					return DEFAULT_CATALOG;
				
				if (theObj.getParent() == null) {
					internalCheck = !fireEvent;
					return DEFAULT_CATALOG;
				}
				
	        	String xpath = "//"
					+ theObj.getServerRoot().getUser().getUsername() + "/" + filterOutBlank(folder.getDisplayName()) 
					+ "//child::*[name() = 'System']";
	        	
				if (systemCatalog == null)
				{
	        	    List<Element> elems = doc.selectNodes(xpath);
	        	    if (elems.isEmpty())
	        	    {
						systemCatalog = new TreeParent(DEFAULT_CATALOG,
								folder.getServerRoot(), TreeObject.CATEGORY_FOLDER,
								null, null);
						folder.addChild(systemCatalog);	
						folder.removeChild(theObj);
						systemCatalog.addChild(theObj);
						systemCatalog.setServerRoot(folder.getServerRoot());
						
						Element elemFolder = getParentElement(folder);
						Element elemSystem = elemFolder.addElement(systemCatalog.getDisplayName());
						elemSystem.setText(TreeObject.CATEGORY_FOLDER + "");
						elemSystem.addElement(filterOutBlank(theObj.getDisplayName())).setText(theObj.getType() + "");
						saveDocument(doc);
						
						catalogPath = systemCatalog.getDisplayName();
	        	    }
				}
				else
				{
					boolean exist = false;
					
					for (TreeObject xbj: systemCatalog.getChildren())
					{
						if (xbj.getDisplayName().equals(filterOutBlank(theObj.getDisplayName())) && xbj.getType() == theObj.getType())
						{
							exist = true;
							break;
						}
							
					}
					if (!exist)
					{
						folder.removeChild(theObj);
					    systemCatalog.addChild(theObj);
					    List<Element> elems = doc.selectNodes(xpath);
					    if (!elems.isEmpty())
					    {
					    	elems.get(0).addElement(filterOutBlank(theObj.getDisplayName())).setText(theObj.getType() + "");
					    	saveDocument(doc);
					    }
					    
					}
				}
				catalogPath = DEFAULT_CATALOG;
			}
		}

		// check up the catalog with none children
		checkUpForCatalogWithNoChildren(theObj, folder);
		
        if (theObj instanceof TreeParent) {
			TreeParent subParent = (TreeParent) theObj;
			for (TreeObject obj : subParent.getChildren()) {
				synchronizeWithElem(obj, subParent, fireEvent);
			}
		}
		
        internalCheck = !fireEvent;
        
        return catalogPath;
	}
	
	
	private void checkUpForCatalogWithNoChildren(TreeObject theObj, TreeParent folder)
	{
		if (folder.getServerRoot() == folder) return;
		
		String xpath = "//" + theObj.getServerRoot().getUser().getUsername()
		+ "/" + filterOutBlank(folder.getDisplayName())
		+ "//child::*[text() = '" + TreeObject.CATEGORY_FOLDER
		+ "' and count(child::*) = 0]";
		List<Element> elems = doc.selectNodes(xpath);
		for (Element elem: elems)
		{
			boolean catalogExist = false;
			for (TreeObject child: folder.getChildren())
			{
				if (elem.getName().equals(
						filterOutBlank(child.getDisplayName()))
						&& child.getType() == TreeObject.CATEGORY_FOLDER)
				{
					catalogExist = true;
					break;
				}
			}
			
			if (catalogExist == false)
			{
				TreeParent catalog = new TreeParent(elem.getName(), folder
						.getServerRoot(), TreeObject.CATEGORY_FOLDER, null, null);
				folder.addChild(catalog);
			}
		}
	}
	
	private String checkUpCatalogRepositoryForTreeObject(TreeObject theObj, TreeObject folder)
	{
		try
		{
			String modelName = "";
			if (theObj.isXObject()) {
				if (theObj.getParent() != theObj.getServerRoot())
				{
					if (folder.getType() == TreeObject.CATEGORY_FOLDER)
						folder = folder.getParent();
				    modelName = filterOutBlank(folder.getDisplayName());
				}
				else
					modelName = filterOutBlank(theObj.getDisplayName());
			} else {
				if (theObj.getServerRoot() == theObj) return "";
				if (theObj.getType() == TreeObject.CATEGORY_FOLDER)
					modelName = filterOutBlank(folder.getDisplayName());
				else
					modelName = filterOutBlank(theObj.getDisplayName());
			}
			String xpath = "//" + theObj.getServerRoot().getUser().getUsername() + "//" + modelName
					+ "//child::*/.[text() = '" + TreeObject.CATEGORY_FOLDER
					+ "']/child::*";
			List<Element> elems = doc.selectNodes(xpath);
			for (Element elem : elems)
			{
				if (elem.getName().equals(filterOutBlank(theObj.getDisplayName()))
						&& elem.getData().toString().equals(theObj.getType() + ""))
				{
					return elem.getParent().getName();
				}
			}
		}
		catch(Exception ex)
		{
			return "";
		}	
		return "";
	}
	
	public void switchOnListening()
	{
		internalCheck = false;
	}
	
	public void switchOffListening()
	{
		internalCheck = true;
	}
	
	public TreeObject registerNewTreeObject(TreeObject treeObject)
	{
        if (treeObject.getType() == TreeObject.CATEGORY_FOLDER)
        {
        	String xpath = "//"
					+ treeObject.getServerRoot().getUser().getUsername() + "/"
					+ filterOutBlank(treeObject.getParent().getDisplayName())
					+ "//child::*[name() = '" + treeObject.getDisplayName() + "']";
        	List<Element> elems = doc.selectNodes(xpath);
        	if (!elems.isEmpty())
        	{
        		catalogTreeObj = elems.get(0);
        	}
        	
        	treeObject = treeObject.getParent();
        }
        else if (!(treeObject instanceof TreeParent) && treeObject.getParent().getType() == TreeObject.CATEGORY_FOLDER)
        {
        	registerNewTreeObject(treeObject.getParent());
        	treeObject = treeObject.getParent().getParent();
        }
        
        return treeObject;
	}
	
	public void merge(TreeObject newTreeObject)
	{
		if (catalogTreeObj != null)
		{
			catalogTreeObj.addElement(newTreeObject.getDisplayName()).setText(newTreeObject.getType() + "");
			saveDocument(doc);
		}
		
		catalogTreeObj = null;
	}
	
	public boolean isInSystemCatalog(TreeObject xobject)
	{
		if (xobject instanceof TreeParent)
		{
			if (xobject.getType() == TreeObject.CATEGORY_FOLDER && xobject.getDisplayName().equals("System"))
				return true;
			return false;
		}
		else
		{
			TreeParent parent = (TreeParent)xobject.getParent();
			return isInSystemCatalog(parent);
		}
	}
}
