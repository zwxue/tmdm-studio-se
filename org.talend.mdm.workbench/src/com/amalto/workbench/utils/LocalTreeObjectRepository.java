package com.amalto.workbench.utils;

import java.io.File;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.talend.mdm.commmon.util.core.ICoreConstants;
import org.talend.mdm.commmon.util.webapp.XSystemObjects;

import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.IXObjectModelListener;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSCategoryData;
import com.amalto.workbench.webservices.XtentisPort;

public class LocalTreeObjectRepository implements IXObjectModelListener, ITreeViewerListener{
	private ServerView view;
	private boolean internalCheck = false;
	private boolean synchronize = false;
	private ArrayList<String> accommodations = new ArrayList<String>();
	private HashMap<String, Element> outPutSchemas = new HashMap<String, Element>();
	
	private static String config = System.getProperty("user.dir")+"/.treeObjectConfig.xml";
	private static String rootPath = "/" + ICoreConstants.DEFAULT_CATEGORY_ROOT;
	private static String DEFAULT_CATALOG = "System";
	private static String EXPAND_NAME = "Expand";
	private static String EXPAND_VALUE = "true";
	private static String COLLAPSE_VALUE = "false";
	
	private static String UNIVERSE = "Universe";
	private static String URL = "Url";
	private static String REALNAME = "Name";
	
	private static int XTENTIS_LEVEL = 4;
	private static int MODEL_LEVEL = 3;
	
	private Element catalogTreeObj = null;
	private TreeItem itemFocus = null;
	
	private Document spareDoc = null;
	private TreeObject[] originalImportXobjects = null;
	private String[] importCategories = null;
    private boolean lazySave = true;
    private static HashMap<String, Credential> credentials = new HashMap<String, Credential>();
    
	private static LocalTreeObjectRepository repository = null;
	
    synchronized public static LocalTreeObjectRepository getInstance()
    {
        if (repository == null)
        {
        	repository = new LocalTreeObjectRepository();
        }

        return repository;
    }
	
    private class Credential
    {
    	public String user;
    	public String pwd;
    	public Document doc;
    	public XtentisPort port;
    	public boolean  state;
    	
    	public Credential(String user, String pwd, Document doc)
    	{
    		this.user = user;
    		this.pwd = pwd;
    		this.doc = doc;
    	}
    }
    
	public void startUp(ServerView vw, String ur, String user, String pwd)
	{
		 view = vw;
		 XtentisPort port = null;
		 Document doc = null;
		 SAXReader saxReader = new SAXReader();
		 try {
			port = Util.getPort(new URL(ur), "", user, pwd);
			WSCategoryData category = port.getMDMCategory(null);
			doc = saxReader.read(new StringReader(category.getCategorySchema()));
			saveCredential(ur, user, pwd, doc, port, true);
			doUpgrade(UnifyUrl(ur));
		} catch (Exception e) {
			e.printStackTrace();
			String empty = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			empty +="<" + ICoreConstants.DEFAULT_CATEGORY_ROOT + "/>";
			WSCategoryData newData = new WSCategoryData();
			newData.setCategorySchema(empty);
			try {
				newData = port.getMDMCategory(newData);
				doc =  saxReader.read(new StringReader(newData.getCategorySchema()));
				saveCredential(ur, user, pwd, doc, port, true);
			} catch (Exception e1) {
				saveCredential(ur, user, pwd, doc, port, false);
			}
			
		}
	}
	
	private void saveCredential(String ur, String user, String pwd, Document doc, XtentisPort port, boolean stat)
	{
		Credential credal = credentials.get(UnifyUrl(ur));
		if(credal == null)
		{
			credal	= new Credential(user, pwd, doc);
		}
		
		credal.port = port;
		if(credal.doc == null)
		  credal.doc = doc;
		credal.state = stat;
		credentials.put(UnifyUrl(ur), credal);
	}
	
	private void doUpgrade(String url)
	{
		Document doc = credentials.get(url).doc;
		String path = "//child::*[text() = '" + TreeObject.CATEGORY_FOLDER  + "' and count(@Universe) = 0 and count(@Url) = 0" + "]";
		List<Element> categorys = doc.selectNodes(path);

		for (Element elem: categorys)
		{
			Attribute attr = elem.attribute(UNIVERSE);
			if(attr == null)
			{
				elem.addAttribute(UNIVERSE, "HEAD");
			}
			attr = elem.attribute(URL);
			if(attr == null)
			{
				elem.addAttribute(URL, UnifyUrl(url));
			}
		}
		saveDocument(url);
	}
	
    private boolean forceDelete()
    {
    	File configFile = new File(config);
        boolean result = false;
        int tryCount = 0;
        while(!result && tryCount++ <10)
        {
            System.gc();
            result = configFile.delete();
        }
        
        if (result)
        {
			MessageDialog.openWarning(
					null, 
					"parsing error",
					"An exception occured in parsing the configuration document, all category information will lost"       						
				);
        }
        
        return result;
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
			recurseElementForXPath(elem.getParent(), xpathList);
		}

	}
		
	
	public void handleEvent(int type, TreeObject parent, TreeObject child)
	{
		if (internalCheck) return;
		String url = UnifyUrl(child.getServerRoot().getWsKey().toString());
		Credential cre = credentials.get(url);
		if(cre!=null)
			if(cre.state == false)return;
		
		try
		{
			switch (type) {
			case IXObjectModelListener.ADD:
				addChild(parent, child);
				break;
			case IXObjectModelListener.DELETE:
				removeChild(parent, child);
				break;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private Element getTopElementWithUser(String user, String ip)
	{
		Document doc = credentials.get(ip).doc;
		List<Element> userRoots = doc.selectNodes(rootPath + "/" + user);
		Element elementUser;
		if (userRoots.isEmpty()) {
			elementUser = doc.getRootElement().addElement(user);
			elementUser.setText("0");	
		} else {
			elementUser = userRoots.get(0);
		}
		
		return elementUser;
	}
	
	private void saveDocument(TreeObject parent)
	{
		if (lazySave || parent == null)return;
		
		String url = UnifyUrl(parent.getServerRoot().getWsKey().toString());
		saveDocument(url);
	}
	
	private void saveDocument(String url)
	{
		if(credentials.get(url)!=null) {
		XtentisPort port = credentials.get(url).port;
		Document doc = credentials.get(url).doc;
        try {
			port.getMDMCategory(new WSCategoryData(doc.asXML()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		}
	}
	
	private String convertSpecCharToDigital(String res)
	{
		String cpy = "", trail = ".";
		Pattern mask = Pattern.compile("[\\W]+");
		for (int id = 0; id < res.length(); id++)
		{
			String slip = "" + res.charAt(id);
			Matcher matcher = mask.matcher(slip);
			if (matcher.find())
			{
				cpy += "" + (int)res.charAt(id);
				trail += (int)res.charAt(id);
			}
			else
				cpy +=slip;
		}
        
		mask = Pattern.compile("[\\d]+");
        String chead = "" + cpy.charAt(0);
        Matcher match = mask.matcher(chead);
        if(match.find())
        {
        	int var = (int)'a' + Integer.parseInt(chead);
        	chead = (char)var + "";
        	if(cpy.length() > 1)
        	   cpy = chead + cpy.substring(1, cpy.length());
        	else
        	   cpy = chead;
        	cpy += chead;
        }
        if(!res.equals(cpy))
        	cpy += "qwer1ty2ui4o";
		return cpy + (trail.length() > 1 ? trail : "");
	}
	
	private String filterOutBlank(String input)
	{
		Pattern mask = Pattern.compile("([\\s]+)");
		String res = mask.matcher(input).replaceAll("");
		res = res.replaceAll("\\[\\w+\\]", "");
		
		return 	convertSpecCharToDigital(res);	
	}
	
    public Element getParentElement(TreeObject treeObj)
    {
		if (!(treeObj instanceof TreeParent))return null;
		
		Element elemFolder = null;
		String xpath = getXPathForTreeObject(treeObj);
        Document doc = credentials.get(UnifyUrl(treeObj.getServerRoot().getWsKey().toString())).doc;
		if (doc.selectNodes(xpath).isEmpty()) {
			xpath = xpath.replaceAll("\\[.*\\]", "");
			if (doc.selectNodes(xpath).isEmpty())
			  xpath = getXPathForTreeObject(treeObj.getParent() != null ? treeObj.getParent() : treeObj.getServerRoot());
			if (xpath != null)
			{
				Element elemTop = null;
				if (doc.selectNodes(xpath).isEmpty())
				{
					elemTop = getTopElementWithUser(treeObj.getServerRoot().getUser().getUsername(), UnifyUrl(treeObj.getServerRoot().getWsKey().toString()));
				}
				else
				{
					//process and trigger is in special, as they are located in EventManagement which is in the same level as data container and data model 
					if(treeObj.getType() == TreeObject.TRANSFORMER && treeObj.getParent() == null)
					{
						xpath += "/EventManagement[text() = '33']";
					}
					elemTop = (Element)doc.selectNodes(xpath).get(0);
				}
				String selPath = "./" + filterOutBlank(treeObj.getDisplayName()) + "[text() = '" + treeObj.getType() + "']";
				if(elemTop.selectNodes(selPath).isEmpty())
				{
					elemFolder = elemTop.addElement(filterOutBlank(treeObj.getDisplayName()));
					elemFolder.setText(treeObj.getType() + "");	
				}
				else
				{
					elemFolder = (Element)elemTop.selectNodes(selPath).get(0);
				}
			}
		}
		else
		{
			elemFolder = (Element)doc.selectNodes(xpath).get(0);
		}
		
			
		
		return elemFolder;
    }
        
	private void addChild(TreeObject parent, TreeObject child)
	{
		if (parent.getParent() == null && parent.getDisplayName().equals("INVISIBLE ROOT"))
			return;
		
		String xpath = getXPathForTreeObject(child);
		Document doc =  credentials.get(UnifyUrl(parent.getServerRoot().getWsKey().toString())).doc;
		List<Element> models = doc.selectNodes(xpath);
		if (!models.isEmpty() && child instanceof TreeParent)
		{
			Element model = models.get(0);
			if (isAEXtentisObjects(model, child) == MODEL_LEVEL) {
				checkUpAllCategoryForModel((TreeParent) child);
			}
		}
		
		String catalog = synchronizeWithElem(child, (TreeParent)parent, true);
		Element elemFolder = getParentElement(parent);
		if (elemFolder != null)
		{
			String xpathTail = "";
			String xpathTailOther =  "']";
			xpath = "child::*[name()='"
					+ filterOutBlank(child.getDisplayName()) + "' and text()='"
					+ child.getType();
			if(child.getType() == TreeObject.CATEGORY_FOLDER)
			{
				xpathTail = "' and @Universe='"
					+ getUniverseFromTreeObject(child) + "' and @Url='"
					+ getURLFromTreeObject(child);
			}
			List<Element> list = elemFolder.selectNodes(xpath + xpathTail + xpathTailOther);
			if (list.isEmpty() && (catalog.equals("") || catalog == null))
			{
				Element childElem = elemFolder.addElement(filterOutBlank(child.getDisplayName()));
				childElem.setText(child.getType() + "");
				if (child.getType() == TreeObject.CATEGORY_FOLDER)
				{
					childElem.addAttribute(UNIVERSE, getUniverseFromTreeObject(child));
					childElem.addAttribute(URL, getURLFromTreeObject(child));
					childElem.addAttribute(REALNAME, child.getDisplayName());
				}
			}
		}
		saveDocument(parent);
	}
	
	private void removeChild(TreeObject parent, TreeObject child) 
	{
		if (parent.getParent() == null && parent.getDisplayName().equals("INVISIBLE ROOT"))
			return;
		
		if(synchronize){
			synchronizeWithElem(child, (TreeParent)parent, true);
		}
		
		Element elemFolder = getParentElement(parent);
		String xpath = "child::*[name()='" + filterOutBlank(child.getDisplayName()) + "' and text()='" + child.getType() + "']";
		List<Element> list = elemFolder.selectNodes(xpath);
		if (!list.isEmpty())
		  elemFolder.remove(list.get(0));
		
		saveDocument(parent);
	}
	
	
	public void correctDisplayNameForCategory(TreeObject category)
	{
		if(category.getType() != TreeObject.CATEGORY_FOLDER)
		{
			return;
		}
		
		String xpath = getXPathForTreeObject(category);
		Document doc = credentials.get(UnifyUrl(category.getServerRoot().getWsKey().toString())).doc;
		List<Element> elems = doc.selectNodes(xpath);
		if(elems.size() > 0)
		{
			Element elem = elems.get(0);
			String value = elem.attributeValue(REALNAME);
			if(value != null)
			{
				category.setDisplayName(value);
			}
		}
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
		
		String xpathTail = "[text() = '" + theObj.getType() + "']";
		
		if(theObj.getType() == TreeObject.CATEGORY_FOLDER)
		{
			xpathTail = "[text() = '" + theObj.getType() + "' and @Universe='"
			+ getUniverseFromTreeObject(theObj) + "' and @Url='"
			+ getURLFromTreeObject(theObj) + "']";
		}
		
		return xpathVar + xpathTail;
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
			list.add(ICoreConstants.DEFAULT_CATEGORY_ROOT );
			return;
		} else {
			list.add(filterOutBlank(theObj.getDisplayName()));
		}
		
		recurseTreeObjectForXPath(theObj.getParent() != null ? theObj.getParent() : theObj.getServerRoot(), list);
	}
	
	private String getUniverseFromTreeObject(TreeObject theObj)
	{
		String universe = "".equals(theObj.getUniverse())?"HEAD":theObj.getUniverse();
		return universe;
	}
	
	private String getURLFromTreeObject(TreeObject theObj)
	{
		String url = theObj.getServerRoot().getUser().getServerUrl();
		//http://localhost:8080/talend/TalendPort
		return UnifyUrl(url);
	}
	
	private String UnifyUrl(String url)
	{
		Pattern mask = Pattern.compile("http://(.*?):(.*)");
		Matcher matcher = mask.matcher(url); 
		if(matcher.find())
		{
			String ip = matcher.group(1);
			String ipAlias = "";
			String hostName = "";
			try {
				InetAddress addr = InetAddress.getLocalHost();
				ipAlias=addr.getHostAddress().toString();
				hostName = addr.getHostName().toString();
				if(ip.equals("127.0.0.1") || ip.equals(ipAlias) || ip.equals(hostName) || ip.equals("localhost"))
				{
					url = "http://" + ipAlias + ":" +  matcher.group(2);
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		return url;
	}
	
	private String synchronizeWithElem(TreeObject theObj, TreeParent folder, boolean fireEvent)
	{
		internalCheck = fireEvent;
		String catalogPath = "";
		ArrayList<String> catalogs = checkUpCatalogRepositoryForTreeObject(theObj, folder);
		if (catalogs != null && folder.getType() != TreeObject.CATEGORY_FOLDER)
		{
			// create a catalog folder and insert the theObj into it
			TreeParent subFolder = folder;
			TreeParent category = null;
			for (String catalogName: catalogs)
			{
//				if (catalogName.equals(filterOutBlank(folder.getDisplayName())))
//					continue;
				category = null;
				for (TreeObject child: subFolder.getChildren())
				{
					if (child.getDisplayName().equals(catalogName)
							&& child.getType() == TreeObject.CATEGORY_FOLDER
							&& child instanceof TreeParent)
					{
						category = (TreeParent)child;
						subFolder = category;
						break;
					}
				}
				
				if (category == null) {
					category = new TreeParent(catalogName, folder
							.getServerRoot(), TreeObject.CATEGORY_FOLDER, null,
							null);				
					subFolder.addChild(category);
			   		category.setServerRoot(folder.getServerRoot());
			   		addAttributeToCategoryElem(category, UNIVERSE, getUniverseFromTreeObject(folder));
			   		addAttributeToCategoryElem(category, URL, getURLFromTreeObject(folder));
			   		saveDocument(folder);
			   		subFolder = category;
				}
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
	   		
	   		catalogPath = catalogs.isEmpty() ? "" : catalogs.get(0);
		}
		else
		{
			// check up the system catalog, create it and all system tree objects
			// into it if these objects are not categorized
			if (XSystemObjects.isExist(theObj.getType(), theObj.getDisplayName()))
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
				if(theObj.getServerRoot()!=null){
	        	String xpath = "//"
					+ theObj.getServerRoot().getUser().getUsername() + "/" + filterOutBlank(folder.getDisplayName()) 
					+ "//child::*[name() = 'System' and @Universe='"
							+ getUniverseFromTreeObject(theObj)
							+ "' and @Url='" + getURLFromTreeObject(theObj)
							+ "']";
	        	
				Document doc = credentials.get(UnifyUrl(folder.getServerRoot().getWsKey().toString())).doc;
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
						elemSystem.addAttribute(UNIVERSE, getUniverseFromTreeObject(folder));
						elemSystem.addAttribute(URL, getURLFromTreeObject(folder));
						Element childElem = elemSystem.addElement(filterOutBlank(theObj.getDisplayName()));
						childElem.setText(theObj.getType() + "");
						
						saveDocument(folder);
	        	    }
				}
				else
				{
					boolean exist = false;
					
					for (TreeObject xbj: systemCatalog.getChildren())
					{
						if (xbj.getDisplayName().equals(theObj.getDisplayName()) && xbj.getType() == theObj.getType())
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
					    	saveDocument(folder);
					    }
					    
					}
				}
				}
				catalogPath = DEFAULT_CATALOG;
			}
		}

		// check up the catalog with none children
		checkUpCatalogHavingNoChildren(theObj, folder);
		
        if (theObj instanceof TreeParent) {
			TreeParent subParent = (TreeParent) theObj;
			for (TreeObject obj : subParent.getChildren()) {
				synchronizeWithElem(obj, subParent, fireEvent);
			}
		}
		
        internalCheck = !fireEvent;
        
        return catalogPath;
	}
	
	private void checkUpAllCategoryForModel(TreeParent model)
	{
		String xpath = "//" + model.getServerRoot().getUser().getUsername()
				+ "/" + filterOutBlank(model.getDisplayName())
				+ "//child::*[text() = '" + TreeObject.CATEGORY_FOLDER + "' and @Universe='"
				+ getUniverseFromTreeObject(model) + "' and @Url='"
				+ getURLFromTreeObject(model) + "']";
		Document doc = credentials.get(UnifyUrl(model.getServerRoot().getWsKey().toString())).doc;
		String xpathForModel = getXPathForTreeObject(model);
		List<Element> elems = doc.selectNodes(xpathForModel);
		Element modelElem = elems.get(0);
		elems = doc.selectNodes(xpath);
		for (Element elem: elems)
		{
			String universe = "".equals(model.getUniverse())?"HEAD":model.getUniverse();
			Element spec = elem;
			ArrayList<Element> hierarchicalList = new ArrayList<Element>();
			while(spec != modelElem)
			{
				hierarchicalList.add(spec);
				spec = spec.getParent();
			}
			Collections.reverse(hierarchicalList);
			TreeParent modelCpy = model;
            while(!hierarchicalList.isEmpty())
            {
            	spec = hierarchicalList.remove(0);
            	String elemName = spec.getName();
            	if(spec.attributeValue(REALNAME) != null)
            	{
            		elemName = spec.attributeValue(REALNAME);
            	}
            	TreeObject to =  findObject(modelCpy, Integer.parseInt(spec.getText().trim()), elemName);
            	if (to == null)
            	{
					TreeParent catalog = new TreeParent(elemName, modelCpy
							.getServerRoot(), TreeObject.CATEGORY_FOLDER, null,
							null);
					boolean cpyInternalCheck = internalCheck;
					internalCheck = true;
					modelCpy.addChild(catalog);
					internalCheck = cpyInternalCheck;
					modelCpy = catalog;
            	}
            	else
            	{
            		modelCpy = (TreeParent) to;
            	}
            }
	}
	}
	
	private TreeObject findObject(TreeObject xobj, int type, String name)
	{
		if(!(xobj instanceof TreeParent))
		{
			return null;
		}
		
		TreeParent parent = (TreeParent)xobj;
		for(TreeObject child :parent.getChildren())
		{
		  if(child.getType() == type && filterOutBlank(child.getDisplayName()).equals(filterOutBlank(name)))
		  {
			  return child;
		  }
		}
		return null;
	}
	
	private void checkUpCatalogHavingNoChildren(TreeObject theObj, TreeParent folder)
	{
		if (folder.getServerRoot() == folder || theObj.getServerRoot()==null) return;
		
		Document doc = credentials.get(UnifyUrl(folder.getServerRoot().getWsKey().toString())).doc;
		String path = this.getXPathForTreeObject(folder);
		List<Element> topElems = doc.selectNodes(path);
		if(topElems.size() > 0 && folder.getParent() != null)
		{
		    if(isAEXtentisObjects(topElems.get(0), folder) == XTENTIS_LEVEL && folder.getParent().getType() == 23)
		    {
		    	if(topElems.get(0).getParent() != null)
		    	{
		    		if(isAEXtentisObjects(topElems.get(0).getParent(), folder) == MODEL_LEVEL && folder.getType() == 24)
		    		{
				    	accommodations.add("Resources");
		    		}
		    	}

		    }
		}
		
		String accmds = "";
		for (String accmd: accommodations)
		{
			if(accmd == accommodations.get(0))
			{
				accmds = "/";
			}
			accmds += accmd;
			if(accmd != accommodations.get(accommodations.size() -1))
			{
				accmds +=  "//";
			}
		}
		String xpath = "//" + theObj.getServerRoot().getUser().getUsername() + accmds 
		+ "/" + filterOutBlank(folder.getDisplayName())
		+ "//child::*[text() = '" + TreeObject.CATEGORY_FOLDER + "' and @Universe='"
		+ getUniverseFromTreeObject(theObj) + "' and @Url='"
		+ getURLFromTreeObject(theObj) 
		+ "' and count(child::*) = 0]";
		

		TreeParent subFolder = folder;
		List<Element> elems = doc.selectNodes(xpath);
		for (Element elem: elems)
		{
			String universe = "".equals(folder.getUniverse())?"HEAD":folder.getUniverse();
			String xpaths = getXPathForElem(elem);
			int modelPos = xpaths.indexOf(filterOutBlank(folder.getDisplayName()));
			if (modelPos == -1)
			{
				System.err.println("elem.getName() is in wrong position !!!");
				return;
			}
			xpaths = xpaths.substring(modelPos + filterOutBlank(folder.getDisplayName()).length() + 1);
			modelPos = xpaths.indexOf("/");
			String xpathTrack = getXPathForElem(elem).substring(0, getXPathForElem(elem).indexOf(xpaths) -1);
			while(modelPos != -1 || (!xpaths.equals("") && modelPos == -1))
			{
				String nodeName = modelPos != -1 ? xpaths.substring(0, modelPos) : xpaths;
				xpathTrack += "/" + nodeName;
				List<Element> parnts = doc.selectNodes(xpathTrack);
				if(parnts.size() > 0 && parnts.get(0).attributeValue(REALNAME) != null)
				{
					nodeName = parnts.get(0).attributeValue(REALNAME);
				}
				boolean catalogExist = false;
				for (TreeObject child: subFolder.getChildren())
				{
					if (nodeName.equals(child.getDisplayName())
							&& child.getType() == TreeObject.CATEGORY_FOLDER)
					{
						catalogExist = true;
						subFolder = (TreeParent)child;
						break;
					}
				}
				
				if (!catalogExist)
				{
					if(parnts.size() > 0 &&  parnts.get(0).getText().equals(TreeObject.CATEGORY_FOLDER))
					{
						TreeParent catalog = new TreeParent(nodeName, folder
								.getServerRoot(), TreeObject.CATEGORY_FOLDER, null, null);
						subFolder.addChild(catalog);
						subFolder = catalog;
					}
				}
				
				if (xpaths.indexOf("/") != -1)
				{
					xpaths = xpaths.substring(modelPos + 1);
					modelPos = xpaths.indexOf("/");
				}
				else
					xpaths = "";

			}
			subFolder = folder;
	   }
	
		accommodations.clear();
	}
	private ArrayList<String> checkUpCatalogRepositoryForTreeObject(TreeObject theObj, TreeObject folder)
	{
		if (theObj.getType() == 0 || theObj.getType() == TreeObject.CATEGORY_FOLDER) return null;
		try
		{
			String modelName = getXPathForTreeObject(folder);
			String universe = getUniverseFromTreeObject(theObj);
			String url = getURLFromTreeObject(theObj);

			String xpath = modelName + "//child::*[text() = '"
					+ TreeObject.CATEGORY_FOLDER + "' and @Universe='"
					+ universe + "' and @Url='" + url + "']//child::*";
           
			Document doc = credentials.get(getURLFromTreeObject(folder)).doc;
			List<Element> elems = doc.selectNodes(xpath);
			for (Element elem : elems)
			{
				String xpathElem = getXPathForElem(elem);
				String xpathObj = getXPathForTreeObject(theObj);
				int squarebk = xpathObj.indexOf("[");
				if(squarebk != -1)
				{
					xpathObj = xpathObj.substring(0, squarebk);
				}
				if (elem.getName().equals(filterOutBlank(theObj.getDisplayName()))
						&& elem.getData().toString().equals(theObj.getType() + ""))
				{
					ArrayList<String> path = new ArrayList<String>();
					HashMap<Integer, String> slice = new HashMap<Integer, String>();
					while (isAEXtentisObjects(elem, theObj) > XTENTIS_LEVEL)
					{
						String elemName = elem.getParent().getName();
						if(elem.getParent().attributeValue(REALNAME) != null)
						{
							elemName = elem.getParent().attributeValue(REALNAME);
						}
						if(elem.getText() != null && StringUtils.trim(elem.getParent().getText()).equals(TreeObject.CATEGORY_FOLDER + ""))
						{
							 path.add(elem.getParent().getName());
							 if(elem.getParent().attributeValue(REALNAME) != null)
							 {
								 slice.put(path.size()-1, elem.getParent().attributeValue(REALNAME));
							 }
						}

						elem = elem.getParent();
					}
					
					ArrayList<String> pathCpy = new ArrayList<String>(path);
                    Collections.reverse(path);
                    if(!isEqualString(xpathElem, xpathObj, path))
                    {
                    	path = null;
                    }
                    if(path != null)
                    {
                    	for (int i = 0; i < pathCpy.size(); i++)
                    	{
                    		if(slice.get(i) != null)
                    		{
                    			pathCpy.set(i, slice.get(i));
                    		}
                    	}
                    	Collections.reverse(pathCpy);
                    	path = pathCpy;
                    }
					return path;
				}
			}
		}
		catch(Exception ex)
		{
			return null;
		}
		
		return null;
	}
	
	private boolean isEqualString(String xpathElem, String xpathObj, ArrayList<String> catalogs)
	{
		ArrayList<String> elems = new ArrayList<String>(Arrays.asList(xpathElem.split("/")));
		ArrayList<String> objs  = new ArrayList<String>(Arrays.asList(xpathObj.split("/")));
        int orgSize = objs.size();
		for (int i = 0; i < objs.size(); i++)
		{
			if(!objs.get(i).equals(elems.get(i)))
			{
				objs.addAll(i, catalogs);
				break;
			}
		}
		
		if(orgSize == objs.size() && orgSize != elems.size())
		{
			objs.addAll(objs.size(), catalogs);
		}
		
       return CollectionUtils.isEqualCollection(elems, objs);
	}
	
	private int isAEXtentisObjects(Element elemXobj, TreeObject treeObj)
	{
		if (elemXobj == null)
			return 0;
		Document doc = credentials.get(UnifyUrl(treeObj.getServerRoot().getWsKey().toString())).doc;
		if (elemXobj == doc.getRootElement())
		     return 1;

		return 1 + isAEXtentisObjects(elemXobj.getParent(), treeObj);
	}
	
	public int receiveUnCertainTreeObjectType(TreeObject xobj)
	{
		String path = this.getXPathForTreeObject(xobj);
		int level = XTENTIS_LEVEL;
		if(path.startsWith("/category/admin/EventManagement"))
		{
			level = XTENTIS_LEVEL + 1;
		}
		Document doc = credentials.get(UnifyUrl(xobj.getServerRoot().getWsKey().toString())).doc;
		List<Element> elems = doc.selectNodes(path);
		if (!elems.isEmpty())
		{
			Element elem = elems.get(0);
			while (isAEXtentisObjects(elem, xobj) >= level)
			{
				elem = elem.getParent();
			}
			return Integer.parseInt(elem.getText().trim());
		}
		else
			return -1;
	}
	
	public void switchOnListening()
	{
		internalCheck = false;
	}
	
	public void switchOffListening()
	{
		internalCheck = true;
	}
	
	public void swithOnSynchronize()
	{
		synchronize = true;
	}
	
	public void switchOffSynchronize()
	{
		synchronize = false;
	}
	
	public TreeObject registerNewTreeObject(TreeObject treeObject)
	{
        if (treeObject.getType() == TreeObject.CATEGORY_FOLDER)
        {
        	String xpath = getXPathForTreeObject(treeObject);
    		Document doc = credentials.get(UnifyUrl(treeObject.getServerRoot().getWsKey().toString())).doc;
        	List<Element> elems = doc.selectNodes(xpath);
        	if (!elems.isEmpty())
        	{
        		if (catalogTreeObj == null)
        			catalogTreeObj = elems.get(0);
        	}
        	
        	treeObject = treeObject.getParent();
        	treeObject = registerNewTreeObject(treeObject);
        }
        else if (!(treeObject instanceof TreeParent) && treeObject.getParent().getType() == TreeObject.CATEGORY_FOLDER)
        {
        	registerNewTreeObject(treeObject.getParent());
        	treeObject = treeObject.getParent().getParent();
        }
        
        return treeObject;
	}
	
	public void mergeNewTreeObject(TreeObject newTreeObject)
	{
		if (catalogTreeObj != null)
		{
			catalogTreeObj.addElement(filterOutBlank(newTreeObject.getDisplayName())).setText(newTreeObject.getType() + "");
			saveDocument(newTreeObject);
		}
		
		catalogTreeObj = null;
	}
	
	public boolean isInSystemCatalog(TreeObject xobject)
	{
		if (xobject instanceof TreeParent)
		{
			if (xobject.getType() == TreeObject.CATEGORY_FOLDER && xobject.getDisplayName().equals("System"))
			{
				Document doc = credentials.get(UnifyUrl(xobject.getServerRoot().getWsKey().toString())).doc;
				String path = this.getXPathForTreeObject(xobject);
				List<Element> elems = doc.selectNodes(path);
				if (!elems.isEmpty())
				{
					Element elem = elems.get(0);
					if (isAEXtentisObjects(elem, xobject) == XTENTIS_LEVEL) {
						return true;
					}
				}
			}
			return false;
		}
		else
		{
			TreeParent parent = (TreeParent)xobject.getParent();
			return isInSystemCatalog(parent);
		}
	}
	
    public void treeCollapsed(TreeExpansionEvent event) {
    	setTreeNodeImage(event, false);
    }

    public void treeExpanded(TreeExpansionEvent event) {
    	setTreeNodeImage(event, true);
    }
    
    private void addAttributeToCategoryElem(TreeParent category, String attrName, String defaultAttrValue)
    {
   		Element elem = locateCategoryElement(category);
   		Attribute attr = elem.attribute(attrName);
   		if (attr != null)
   		{
   			elem.remove(attr);
   		}
		elem.addAttribute(attrName, defaultAttrValue);
    }
    
    private Element locateCategoryElement(TreeParent category) {
    	if (category.getParent() == category.getServerRoot())
    		return null;
    	
		String xpath = "//" + category.getServerRoot().getUser().getUsername()
				+ "//" + filterOutBlank(category.getParent().getDisplayName())
				+ "//child::*/.[text() = '" + TreeObject.CATEGORY_FOLDER
				+ "' and name()='" + filterOutBlank(category.getDisplayName())
				+ "' and @Universe ='" + getUniverseFromTreeObject(category)
				+ "' and @Url = '" + getURLFromTreeObject(category) + "']";

		Document doc = credentials.get(UnifyUrl(category.getServerRoot().getWsKey().toString())).doc;
		List<Element> elms = doc.selectNodes(xpath);

		return !elms.isEmpty() ? elms.get(0) : null;
	}
    
    private void setTreeNodeImage(TreeExpansionEvent event, boolean expand) {
		Object elem = event.getElement();
		Widget item = view.getViewer().testFindItem(event.getElement());
		if (item == null || (item != itemFocus && itemFocus != null))
			item = itemFocus;
		if (elem instanceof TreeParent && item != null) {
			TreeParent parent = (TreeParent) elem;
			if (parent.getType() == TreeObject.CATEGORY_FOLDER) {
				((TreeItem) item).setImage(expand ? ImageCache
						.getCreatedImage("icons/folder_open.gif") : ImageCache
						.getCreatedImage("icons/folder.gif"));
				
				Element elemCategory = locateCategoryElement(parent);
		        if (elemCategory != null)
		        {
		        	elemCategory.attribute(EXPAND_NAME).setValue(expand ? EXPAND_VALUE : COLLAPSE_VALUE);
		        	saveDocument(parent);
		        }

			}
		}
	}
    
    public boolean getCategoryExpandState(TreeParent category)
    {
    	Element elem = locateCategoryElement(category);
    	if (elem != null)
    	{
    		return Boolean.valueOf(elem.attribute(EXPAND_NAME).getValue());
    	}
    	
    	return false;
    }
    
    private void getTreeItemFromTreeObject(TreeItem[] items,TreeObject xobj, ArrayList<TreeItem> ret)
    {
    	for (TreeItem o: items)
    	{
    		TreeObject treeObj = (TreeObject)o.getData();
    		if (equalTermsWithTreeObject(treeObj, xobj))
    		{
    			ret.add(o);
    			return;
    		}
    	   getTreeItemFromTreeObject(o.getItems(), xobj, ret);
    	}
    }
    
    private boolean equalTermsWithTreeObject(TreeObject theObj, TreeObject otherObj)
    {
    	if (theObj == null || otherObj == null)return false;
       	if (theObj == otherObj) return true;
       	
    	if (theObj.getParent() == theObj.getServerRoot() && otherObj.getParent() == otherObj.getServerRoot())
    	{
    		if (theObj.getDisplayName().equals(otherObj.getDisplayName()))
    			return true;
    		else
    			return false;
    	}

    	
    	if (theObj.getType() != otherObj.getType()
				|| !filterOutBlank(theObj.getDisplayName()).equals(
						filterOutBlank(otherObj.getDisplayName())))
    	{
    		return false;
    	}
    	
    	return equalTermsWithTreeObject(theObj.getParent(), otherObj.getParent());
    }
    
    public void refreshCategoryStateWithinModel(TreeParent model)
    {
    	Element elemCategory = null;
		for (TreeObject xobj : model.getChildren())
		{
			if(xobj instanceof TreeParent)
			{
				refreshCategoryStateWithinModel((TreeParent)xobj);
			}
			else 
				continue;
			
			elemCategory = locateCategoryElement((TreeParent)xobj);
			if (elemCategory == null) continue;
			Attribute attr = elemCategory.attribute(EXPAND_NAME);
			if (attr != null)
			{
				String value = attr.getValue();
				Tree tree = (Tree)view.getViewer().getControl();
				ArrayList<TreeItem> list = new ArrayList<TreeItem>();
				getTreeItemFromTreeObject(tree.getItems(), xobj, list);
				itemFocus = list.isEmpty() ? null : list.get(0);
				if (itemFocus == null)return;
				TreeExpansionEvent event = new TreeExpansionEvent(view.getViewer(), xobj);
				if (value.equals(EXPAND_VALUE))
				{
					//set the category to be closed if it is empty
					if (elemCategory.elements().isEmpty())
					{
						itemFocus.setExpanded(false);
						treeCollapsed(event);
					}
					else
					{
						itemFocus.setExpanded(true);
						treeExpanded(event);
					}
				}
				else
				{
					itemFocus.setExpanded(false);
					treeCollapsed(event);
				}
				itemFocus = null;	
			}
		}
    }
    
    public void resetAllCategoryState(TreeParent root)
    {
    	for (TreeObject xobj : root.getChildren()) {
			if (xobj.getType() == TreeObject.CATEGORY_FOLDER) {
				locateCategoryElement((TreeParent) xobj).attribute(EXPAND_NAME)
						.setValue(COLLAPSE_VALUE);
			}

			if (xobj instanceof TreeParent
					&& xobj.getType() != TreeObject.CATEGORY_FOLDER) {
				resetAllCategoryState((TreeParent) xobj);
			}
		}
    	
    	saveDocument(root);
    }
    
	public void receiveAllOffsprings(TreeParent parent, ArrayList<TreeObject>list)
	{
		list.addAll(Arrays.asList(parent.getChildren()));
		for(TreeObject obj: parent.getChildren())
		{
			if (obj instanceof TreeParent)
			{
				receiveAllOffsprings((TreeParent)obj, list);
			}
		}
	}
	
	public void setLazySaveStrategy(boolean lazy, TreeParent parent)
	{
		lazySave = lazy;
		saveDocument(parent);
	}
	
	public void addAccommodation(String name)
	{
		accommodations.add(name);
	}
	
	public void clearAccommodation()
	{
		accommodations.clear();
	}
	
	private Element parseElements(String schema)
	{
		 SAXReader saxReader = new SAXReader();
		 try {
			Document doc = saxReader.read(new StringReader(schema));
			return doc.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void makeUpDocWithImportCategory(String[] schemas, TreeParent serverRoot)
	{
		Document orgDoc =  credentials.get(UnifyUrl(serverRoot.getServerRoot().getWsKey().toString())).doc;
		//spareDoc is meant to show the category when import digloag is launched
		spareDoc = (Document)orgDoc.clone();
		if(schemas != null)
		{
			for (String schema : schemas)
			{
				Element subRoot = parseElements(schema);
				String subRootXquery = "descendant::" + subRoot.getName() + "[text()='" + subRoot.getTextTrim() + "']";
				Element division = pingElement(subRootXquery, spareDoc.getRootElement());
				if(division == null || division.getParent() == null)return;
				Element divisionParent = division.getParent();
				divisionParent.remove(division);
				divisionParent.add((Element)subRoot.clone());
			}
			
			String url = getURLFromTreeObject(serverRoot);
			String Universe = getUniverseFromTreeObject(serverRoot);
			String urlXquery = "descendant::*[@Url != '" + url + "']";
			List<Element> elems = spareDoc.selectNodes(urlXquery);
			for (Element elem : elems)
			{
				elem.attributeValue("Url", url);
				elem.attributeValue("Universe", Universe);
			}
		}
		

		credentials.get(UnifyUrl(serverRoot.getServerRoot().getWsKey().toString())).doc = spareDoc;
		spareDoc = orgDoc;
		importCategories = schemas;
	}
	
	public void setOriginalXobjectsToImport(TreeObject[] originalXobjects)
	{
		originalImportXobjects = originalXobjects;
	}
	
	public void mergeImportCategory(TreeObject[] xobjectsToImport, TreeParent serverRoot)
	{
		if(xobjectsToImport.length == 0)return;
		
		Collection dels = CollectionUtils.subtract(Arrays.asList(originalImportXobjects), Arrays.asList(xobjectsToImport));
		ArrayList<TreeObject> delList = new ArrayList<TreeObject>(dels);
	    ArrayList<String> xpaths = new ArrayList<String>();
	    
		for (TreeObject del : delList)
		{
			String xpath = this.getXPathForTreeObject(del);
			xpath.replaceFirst("/"
					+ del.getServerRoot().getUser().getUsername(), "/"
					+ serverRoot.getUser().getUsername());
			xpaths.add(xpath);
		}
		
		mergeImportCategory(importCategories, serverRoot, xpaths);
	}
	
	
	public void cancelMergeImportCategory(TreeParent serverRoot)
	{
		if(spareDoc != null)
		{
			credentials.get(UnifyUrl(serverRoot.getServerRoot().getWsKey().toString())).doc = spareDoc;
			originalImportXobjects = null;
			importCategories = null;
			spareDoc = null;
		}
	}
	
	private void mergeImportCategory(String[] schemas, TreeParent serverRoot, ArrayList<String> xpathsToDel)
	{
		Document orgDoc = spareDoc;
		String user =  serverRoot.getServerRoot().getUser().getUsername();
		String xpathPrefix = "/category/" + user;
		String xmlPrefix = "<category><" + user + ">*</"+ user + "></category>";
		if(schemas == null) // old version, skip the import
		{
			credentials.get(UnifyUrl(serverRoot.getServerRoot().getWsKey().toString())).doc = orgDoc;
			return;
		}
		for(String schema : schemas)
		{
			Element root = parseElements(xmlPrefix.replace("*", schema));
			Element subRoot = parseElements(schema);
			
			//delete all unselected xobjects from orgDoc
			for (String xpathToDel : xpathsToDel)
			{
				Element elemToDel = pingElement(xpathToDel, root);
				if(elemToDel != null)
				{
					Element parent = elemToDel.getParent();
					if(parent != null)
					{
						parent.remove(elemToDel);
					}
				}
			}
			String universe = this.getUniverseFromTreeObject(serverRoot);
			//check out all categories having none child, and delete them if available
			String xpathForCategoriesWithNoneChild = "//child::*[count(child::*) = 0 and text()='" + TreeObject.CATEGORY_FOLDER + "' and @Universe = '" + universe + "']";
			Element categoryToDel = pingElement(xpathForCategoriesWithNoneChild, root);
			while(categoryToDel != null)
			{
				Element categoryParent = categoryToDel.getParent();
				if(categoryParent != null)
				{
					categoryParent.remove(categoryToDel);
				}
				categoryToDel = pingElement(xpathForCategoriesWithNoneChild, root);
			}
			
			subRoot = this.pingElement(xpathPrefix + "/" + subRoot.getName(), root);
			String xpathForCategory = "//descendant::*[text()='" + TreeObject.CATEGORY_FOLDER + "']";
			List<Element> elementList = subRoot.selectNodes(xpathForCategory);
			List<String> categoryXpathForCurDoc = new ArrayList<String>(); 
			List<String> categoryXpathForOrgDoc = new ArrayList<String>();
			
			for (Element element : elementList)
			{
				List<String> categoryHierarchicals = parseXpathForElement(element, subRoot);
				String xpathForOrgCategory = xpathPrefix + "/" + subRoot.getName();
				for (String categoryHierarchical : categoryHierarchicals)
				{
					xpathForOrgCategory += "/" + categoryHierarchical;
				}
				if(!categoryXpathForOrgDoc.contains(xpathForOrgCategory))
				   categoryXpathForOrgDoc.add(xpathForOrgCategory);
			}
			xpathForCategory = xpathPrefix + "/" + subRoot.getName() + "//descendant::*[text()='" + TreeObject.CATEGORY_FOLDER + "']";
			//	String xpathForOrgCategory = xpathPrefix + "/" + subRoot.getName() + "//descendant::" + element.getName() + "[text()='" + element.getTextTrim() + "']";
			String topElemXpath = xpathPrefix + "/" + subRoot.getName();
			Element topElem = pingElement(topElemXpath, orgDoc.getRootElement());
			elementList = orgDoc.getRootElement().selectNodes(xpathForCategory);
			for (Element elem : elementList)
			{
				List<String> categoryHierarchicals = parseXpathForElement(elem, topElem);
				String xpathForOrgCategory = xpathPrefix  +  "/" + subRoot.getName();
				for (String categoryHierarchical : categoryHierarchicals)
				{
					xpathForOrgCategory += "/" + categoryHierarchical;
				}
				if(!categoryXpathForCurDoc.contains(xpathForOrgCategory))
				 categoryXpathForCurDoc.add(xpathForOrgCategory);
			}
			
			for (String categoryHierarchical : categoryXpathForOrgDoc)
			{
				createOrReplaceCategory(categoryHierarchical, categoryXpathForCurDoc, root, orgDoc.getRootElement(), serverRoot);
			}
		}
		// success
		credentials.get(UnifyUrl(serverRoot.getServerRoot().getWsKey().toString())).doc = orgDoc;
	}
	
	private void createOrReplaceCategory(String categoryHierarchical, List<String> categoryXpathForCurDoc, Element srcElem, Element tgtElem, TreeParent serverRoot)
	{
		if(categoryXpathForCurDoc.contains(categoryHierarchical))
		{
			//transfer all elements under the imported category to corresponding pos of org doc
			transferElementsWithCategoryPath(categoryHierarchical, srcElem, tgtElem);
		}
		else
		{
			String match = "";
			for (String categoryXpath : categoryXpathForCurDoc)
			{
				if(categoryXpath.startsWith(categoryHierarchical))
				{
					//transfer all elements under the imported category to corresponding pos of org doc
					transferElementsWithCategoryPath(categoryHierarchical, srcElem, tgtElem);
				}
				else if(categoryHierarchical.startsWith(categoryXpath))
				{
					match = categoryXpath;
				}
			}
			
			if(match.length() >= 0)
			{
				//create category according to the given xpath
				createCategoryForOrgDoc(categoryHierarchical, srcElem, tgtElem, serverRoot);
			}
		}
	}
	
	private void createCategoryForOrgDoc(String categoryToCreate, Element srcElem, Element tgtElem, TreeParent serverRoot)
	{
		String[] xpathSnippetsToCreate = categoryToCreate.split("/");
		int categoryBeginPos = 3;
		if(xpathSnippetsToCreate[3].equals("EventManagement"))
		{
			categoryBeginPos = 4;
		}
		
		int pos = categoryToCreate.indexOf("/" + xpathSnippetsToCreate[categoryBeginPos]);
		String categoryXpath = categoryToCreate.substring(0, pos + xpathSnippetsToCreate[categoryBeginPos].length() + 1);
		Element subParentElem = pingElement(categoryXpath, tgtElem);
		for (int i = categoryBeginPos + 1; i < xpathSnippetsToCreate.length ; i++)
		{
			String categoryXpathSnippet = "child::" + xpathSnippetsToCreate[i] + "[text()='" + TreeObject.CATEGORY_FOLDER + "']";
			Element newCategory = pingElement(categoryXpathSnippet, subParentElem);
			if(newCategory == null)
			{
				Element existedCategory = pingElement(categoryXpath + "/" + categoryXpathSnippet , srcElem);
				newCategory = subParentElem.addElement(xpathSnippetsToCreate[i]);
				newCategory.setText(TreeObject.CATEGORY_FOLDER + "");
				newCategory.addAttribute(UNIVERSE, getUniverseFromTreeObject(serverRoot));
				newCategory.addAttribute(URL, getURLFromTreeObject(serverRoot));
				newCategory.addAttribute(REALNAME, existedCategory.attributeValue(REALNAME));
			}
			categoryXpath += "/" + xpathSnippetsToCreate[i];
			subParentElem = newCategory;
		}

		transferElementsWithCategoryPath(categoryToCreate, srcElem, tgtElem);
	}
	
	private Element drillUpForDevisionElement(Element elem)
	{
		Element parent = elem.getParent();
		while(parent != null && !parent.getTextTrim().equals(elem.getTextTrim()) && !(parent.getTextTrim().equals("0")))
		{
			parent = parent.getParent();
		}
		
		return parent;
	}
	
	private void transferElementsWithCategoryPath(String categoryXpath, Element srcElemRoot, Element targtElemRoot)
	{
		categoryXpath += "[text()='" + TreeObject.CATEGORY_FOLDER + "']";
		//clear up the context of targtElemRoot firstly
		Element elemCategoryInTagt = pingElement(categoryXpath, targtElemRoot);
		List elems = elemCategoryInTagt.content();
		List xobjects = new ArrayList();
		for (Object obj : elems)
		{
			if(obj instanceof Element)
			{
				Element elem = (Element)obj;
				if(!elem.getTextTrim().equals(TreeObject.CATEGORY_FOLDER + ""))
				{
					Element division = drillUpForDevisionElement(elem);
					division.addElement(elem.getName()).setText(elem.getTextTrim());
					xobjects.add(elem);
				}
			}
		}
		
		elemCategoryInTagt.content().removeAll(xobjects);
		
		Element elemCategoryInSrc = pingElement(categoryXpath, srcElemRoot);
		elems = elemCategoryInSrc.content();
		for (Object obj : elems)
		{
			if(obj instanceof Element)
			{
				Element elem = (Element)obj;
				if(!elem.getTextTrim().equals(TreeObject.CATEGORY_FOLDER + ""))
				{
					String xpath = ".//descendant::" + elem.getName() + "[text()='" + elem.getTextTrim() + "']";
					List<Element> es = targtElemRoot.selectNodes(xpath);
					Element newElem = null;
					for (Element elemExist : es)
					{
						if (elemExist.getParent() != null
								&& elemExist.getParent().getTextTrim().equals(
										TreeObject.EVENT_MANAGEMENT + ""))
							continue;
						if(elemExist != null)
						{
							Element parentExist = elemExist.getParent();
							parentExist.remove(elemExist);
						}
						elemExist = pingElement(categoryXpath, targtElemRoot);
						newElem = elemExist.addElement(elem.getName());
						newElem.setText(elem.getTextTrim());
					}
					if(es.size() == 0 || (es.size() > 0 && newElem == null))
					{
						Element elemExist = pingElement(categoryXpath, targtElemRoot);
						newElem = elemExist.addElement(elem.getName());
						newElem.setText(elem.getTextTrim());
					}
				}
			}

		}
	}
	
	private Element pingElement(String xpath, Element root)
	{
		List<Element> elems = root.selectNodes(xpath);
		if(elems.size() > 0)
		{
			return elems.get(0);
		}
		return null;
	}
	
	private List<String> parseXpathForElement(Element elem, Element subRoot)
	{
		List<String> list = new ArrayList<String>();
		while(elem != subRoot)
		{
			if(elem.attributeValue("name") != null)
				list.add(elem.attributeValue("name"));
			else
				list.add(elem.getName());
			
			elem = elem.getParent();
		}
		
		Collections.reverse(list);
		return list;
	}
	
	public void parseElementForOutput(TreeObject[] xobjs)
	{
		for (TreeObject xobj : xobjs)
		{
			TreeObject subParent = xobj;
			while(subParent.getParent().getType() != 0)
			{
				subParent = subParent.getParent();
			}
			Element modelElem = getParentElement(subParent);
			
			if(!outPutSchemas.containsKey(modelElem.getName()))
			{
				Element copyElem = (Element)modelElem.clone();
				copyElem.clearContent();
				copyElem.setText(modelElem.getTextTrim());
				outPutSchemas.put(modelElem.getName(), copyElem);
			}
			
			
			subParent = xobj;
			TreeObject categorySubRoot = null;
			while(subParent.getParent().getType() == TreeObject.CATEGORY_FOLDER)
			{
				categorySubRoot = subParent.getParent();
				subParent = subParent.getParent();
			}
			
			Element divisionElem = null;
			Element copyModelElem = outPutSchemas.get(modelElem.getName());
			Document doc =  credentials.get(UnifyUrl(xobj.getServerRoot().getWsKey().toString())).doc;
			String division = xobj.getType() == TreeObject.TRANSFORMER ? "Process" : "Trigger";
			String xpathForDivision = ".//child::" + division + "[text()='" + xobj.getType() + "']";
			
			if(categorySubRoot != null)
			{
				Element categoryElem = getParentElement(categorySubRoot);
				if(categoryElem.getParent() != modelElem)
				{
					divisionElem = pingElement(xpathForDivision, (Element)copyModelElem);
					if(divisionElem == null)
					{
						divisionElem = copyModelElem.addElement(categoryElem.getParent().getName());
						divisionElem.setText(categoryElem.getParent().getTextTrim());
					}
				}
				else
					divisionElem = copyModelElem;

				Element categoryElementClone = (Element)categoryElem.clone();
				String xpath = "./child::" + categoryElem.getName() + "[text()='" + TreeObject.CATEGORY_FOLDER + "']";
				if(divisionElem.selectNodes(xpath).size() == 0)
					divisionElem.add(categoryElementClone);
			}
			else
			{
				// individual xobject
				Element xobjElem = pingElement(getXPathForTreeObject(xobj), doc.getRootElement()) ;
				Element parentElem = xobjElem.getParent();
				if(parentElem == modelElem)
				{
					parentElem = copyModelElem;
				}
				else
				{
					divisionElem = pingElement(xpathForDivision, (Element)copyModelElem);
					if(divisionElem == null)
					{
						divisionElem = copyModelElem.addElement(parentElem.getName());
						divisionElem.setText(parentElem.getTextTrim());
					}
				}

				String xpath = ".//child::" + xobjElem.getName() + "[text()='" + xobjElem.getTextTrim() + "']";
				if(divisionElem != null && pingElement(xpath, divisionElem) == null)
					divisionElem.add((Element)xobjElem.clone());
			}
		}

		// filter those excluded from xobjects out of categorys
		String xpath = ".//descendant::*[text() ='" + TreeObject.CATEGORY_FOLDER + "']";
		Iterator<Element> iter = outPutSchemas.values().iterator();
		while(iter.hasNext())
		{
			Element divisionElement = iter.next();
			List<Element> categorys = divisionElement.selectNodes(xpath);
			
			if(categorys != null)
			{
				for (Element categoryElems : categorys)
				{
					List objs = categoryElems.content();
					List<Element> elemToDel = new ArrayList<Element>();
					for (Object obj : objs)
					{
						if(obj instanceof Element)
						{
							Element categoryElement = (Element)obj;
							if(categoryElement.getTextTrim().equals(TreeObject.CATEGORY_FOLDER + ""))
								continue;
		                    boolean match = false;
							for (TreeObject xobj : xobjs)
							{
								if (filterOutBlank(xobj.getDisplayName()).equals(
										categoryElement.getName())
										&& categoryElement.getTextTrim().equals(
												xobj.getType() + ""))
								{
									match = true;
									break;
								}
							}
							if(!match)
							{
								elemToDel.add(categoryElement);
							}
						}
					}
					
					for (Element del : elemToDel)
					{
						categoryElems.remove(del);
					}
				}
			}
		}
		
		ArrayList<String> schemas = new ArrayList<String>();
		Iterator<Element> iterd = outPutSchemas.values().iterator();
		while(iterd.hasNext())
		{
			schemas.add(iterd.next().asXML());
		}
		System.out.println();
	}
	
	public String[] outPutSchemas()
	{
		ArrayList<String> schemas = new ArrayList<String>();
		Iterator<Element> iter = outPutSchemas.values().iterator();
		while(iter.hasNext())
		{
			schemas.add(iter.next().asXML());
		}
		outPutSchemas.clear();
		return schemas.toArray(new String[schemas.size()]);
	}
}
