package com.amalto.workbench.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;
import org.talend.mdm.commmon.util.core.EUUIDCustomType;
import org.talend.mdm.commmon.util.core.ICoreConstants;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XSDAnnotationsStructure {
	
	boolean hasChanged = false;
	XSDAnnotation annotation;
	XSDElementDeclaration declaration;
	XSDSchema schema;
	/**
	 * "Clever" Constructor that finds or creates annotations of an XSDComponent object
	 * @param component
	 */
	public XSDAnnotationsStructure(XSDComponent component) {
		inputChanged(component);
	}
	
	protected void inputChanged(Object component)
	{
        if (component instanceof XSDAnnotation) {
        	annotation = (XSDAnnotation) component;
        	declaration = (XSDElementDeclaration)annotation.getContainer();
        }
        
        if (component instanceof XSDElementDeclaration){
        	declaration = (XSDElementDeclaration) component;
        	if (declaration.getAnnotation() == null) {
        		XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
           		annotation = factory.createXSDAnnotation();
        	} else {
        		 annotation = declaration.getAnnotation();
        	}
        }
        
        if (component instanceof XSDParticle){
        	XSDTerm term = ((XSDParticle)component).getTerm();
        	if (term instanceof XSDElementDeclaration){
            	declaration = (XSDElementDeclaration) term;
            	if (declaration.getAnnotation() == null) {
            		XSDFactory factory = XSDSchemaBuildingTools.getXSDFactory();
               		annotation = factory.createXSDAnnotation();
            	} else {
           		 annotation = declaration.getAnnotation();
            	}
           	}
        }
	}
	/****************************************************************************
	 *           DOCUMENTATION
	 ****************************************************************************/

	private Element getDocumentationElement() {
		Element documentation = null;
		ArrayList<Element> list = new ArrayList<Element>();
		//list.addAll(annotation.getUserInformation());
		list.addAll(annotation.getUserInformation());
		for (Iterator iter = list.iterator(); iter.hasNext(); ) {
			Element ann = (Element)iter.next();
			String name = ann.getLocalName();
			if ("documentation".equals(name.toLowerCase())) {
				documentation=ann;
				break;
			}
		}
		return documentation;
	}
	
	public String getDocumentation() {
		Element appInfo = getDocumentationElement();
		if (appInfo == null) return null;
		return appInfo.getFirstChild().getNodeValue();
	}
	
	private boolean removeDocumentation() {
		boolean somethingRemoved = false;
		Element documentation = null;
		do {
			 documentation = getDocumentationElement();
			if (documentation!=null) {
				annotation.getElement().removeChild(documentation);
				annotation.getApplicationInformation().remove(documentation); //yes we need to do that too....
				somethingRemoved = true;
			}
		} while (documentation!=null);
		return somethingRemoved;
	}


	public boolean setDocumentation(String value) {
		if (value == null) {
			boolean wasRemoved = removeDocumentation();
			hasChanged = hasChanged | wasRemoved;
			return wasRemoved;
		}
			
		Element documentation = getDocumentationElement();
		if (documentation==null) return addDocumentation(value);

		//change existing one if
		//first make sure the annotation is not brain new and is attached
		if (declaration.getAnnotation()==null) {
			declaration.setAnnotation(annotation);
		}
		//then update the documentation
		String existingText = documentation.getFirstChild().getNodeValue();
		if (!value.equals(existingText)) {
			documentation.getFirstChild().setNodeValue(value);
			hasChanged = true;
			return true;
		}
		return false;
	}
		
	private boolean addDocumentation(String value) {
		if (declaration.getAnnotation()==null) {
			declaration.setAnnotation(annotation);
		}
		Element appinfo = annotation.createUserInformation("documentation");
   		Node text = appinfo.getOwnerDocument().createTextNode(value);
   		appinfo.appendChild(text);
   		annotation.getElement().appendChild(appinfo);
   		hasChanged = true;
		return true;
	}
	
	/****************************************************************************
	 *           LABELS
	 ****************************************************************************/
	
	public boolean removeLabel(String countryCode) {
		boolean somethingChanged = removeAppInfos("X_Label_"+countryCode.toUpperCase()); 
		hasChanged = hasChanged | somethingChanged;
		return somethingChanged;
	}
	
	public boolean removeAllLabels() {
		boolean somethingChanged = removeAppInfos("X_Label_.*");
		hasChanged = hasChanged |  somethingChanged;
		return somethingChanged;
	}
	
	public boolean setLabel(String countryCode, String label) {
		if (countryCode == null) return false;
		boolean somethingChanged = setAppInfo("X_Label_"+countryCode.toUpperCase(),label, true);
		hasChanged = hasChanged |  somethingChanged;
		return somethingChanged;
	}

	public boolean setLabels(LinkedHashMap<String, String> labels) {
		boolean somethingChanged = false;
		Set<String> isoCodes = labels.keySet();
		for (Iterator iter = isoCodes.iterator(); iter.hasNext(); ) {
			String code = (String) iter.next();
			String label = labels.get(code);
			somethingChanged = somethingChanged | setLabel(code, label);
		}
		hasChanged = hasChanged |  somethingChanged;
		return somethingChanged;
	}
	
	public LinkedHashMap<String, String> getLabels() {
		LinkedHashMap<String, String> labels = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> appInfos = getAppInfos("X_Label_.*");
		Set<String> keys = appInfos.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			String key = (String) iter.next();
			labels.put(key.substring(8).toLowerCase(), appInfos.get(key));
		}
		return labels;
	}
	
	/****************************************************************************
	 *           DESCRIPTIONS
	 ****************************************************************************/
	
	public boolean removeDescription(String countryCode) {
		boolean somethingChanged = removeAppInfos("X_Description_"+countryCode.toUpperCase()); 
		hasChanged = hasChanged | somethingChanged;
		return somethingChanged;
	}
	
	public boolean removeAllDescriptions() {
		boolean somethingChanged = removeAppInfos("X_Description_.*");
		hasChanged = hasChanged |  somethingChanged;
		return somethingChanged;
	}
	
	public boolean setDescription(String countryCode, String description) {
		if (countryCode == null) return false;
		boolean somethingChanged = setAppInfo("X_Description_"+countryCode.toUpperCase(),description, true);
		hasChanged = hasChanged |  somethingChanged;
		return somethingChanged;
	}

	public boolean setDescriptions(LinkedHashMap<String, String> descriptions) {
		boolean somethingChanged = false;
		Set<String> isoCodes = descriptions.keySet();
		for (Iterator iter = isoCodes.iterator(); iter.hasNext(); ) {
			String code = (String) iter.next();
			String description = descriptions.get(code);
			somethingChanged = somethingChanged | setDescription(code, description);
		}
		hasChanged = hasChanged |  somethingChanged;
		return somethingChanged;
	}
	
	public LinkedHashMap<String, String> getDescriptions() {
		LinkedHashMap<String, String> descriptions = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> appInfos = getAppInfos("X_Description_.*");
		Set<String> keys = appInfos.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			String key = (String) iter.next();
			descriptions.put(key.substring(14).toLowerCase(), appInfos.get(key));
		}
		return descriptions;
	}
	/****************************************************************************
	 *           FK Filter
	 ****************************************************************************/

	public boolean setFKFilter(String xPath) {
		boolean somethingChanged = setAppInfo("X_ForeignKey_Filter",xPath, true);
		hasChanged = hasChanged |  somethingChanged;
		return somethingChanged;
	}

	public String getFKFilter() {
		return getAppInfoValue("X_ForeignKey_Filter");
	}
	
	/****************************************************************************
	 *           FOREIGN KEY
	 ****************************************************************************/

	public boolean setForeignKey(String xPath) {
		boolean somethingChanged = setAppInfo("X_ForeignKey",xPath, true);
		hasChanged = hasChanged |  somethingChanged;
		return somethingChanged;
	}

	public String getForeignKey() {
		return getAppInfoValue("X_ForeignKey");
	}
	
	/****************************************************************************
	 *           FOREIGN KEY INFOS
	 ****************************************************************************/
	public boolean setForeignKeyInfos(ArrayList<String> xPaths) {
		removeAppInfos("X_ForeignKeyInfo");
		for (Iterator iter = xPaths.iterator(); iter.hasNext(); ) {
			String xPath = (String) iter.next();
			addAppInfo("X_ForeignKeyInfo", xPath);
		}
		hasChanged = true;
		return true;
	}
	
	public boolean setRetrieveFKinfos(boolean retrieveFKinfos) {
	   removeAppInfos("X_Retrieve_FKinfos");
      addAppInfo("X_Retrieve_FKinfos", retrieveFKinfos + "");
      hasChanged = true;
      return true;
   }
	
	public boolean getRetrieveFKinfos() {
      LinkedHashMap<String, String> appInfos = getAppInfos("X_Retrieve_FKinfos");
      Set<String> keys = appInfos.keySet();
      for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
         String key = (String) iter.next();
         return "true".equals(appInfos.get(key));
      }
      
      return false;
   }
	
	public boolean setForeignKeyInfo(int num, String xPath) {
		TreeMap< String, String> infos = getForeignKeyInfos();
		infos.put("X_ForeignKeyInfo_"+num, xPath);
		return setForeignKeyInfos(new ArrayList(infos.values()));
	}

	public TreeMap<String, String> getForeignKeyInfos() {
		TreeMap<String, String> foreignKeyInfos = new TreeMap<String, String>();
		LinkedHashMap<String, String> appInfos = getAppInfos("X_ForeignKeyInfo");
		Set<String> keys = appInfos.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			String key = (String) iter.next();
			foreignKeyInfos.put(key, appInfos.get(key));
		}
		return foreignKeyInfos;
	}
	
	/****************************************************************************
	 *           WRITE ACCESS
	 * @throws XtentisException 
	 ****************************************************************************/
	public boolean setAccessRole(Collection<String> roles, boolean recursive, IStructuredContentProvider provider, String access) throws XtentisException
	{
		if (recursive) {
			ArrayList<Object> objList = new ArrayList<Object>();
			Object[] objs = Util.getAllObject(declaration, objList, provider);
			
			while (objs.length > 0)
			{
				Object[] objCpys = objs;
				for (Object obj : objCpys) {
//					if (obj instanceof XSDModelGroup)
//					{
//						XSDModelGroup modelGp = (XSDModelGroup)obj;
//						if (modelGp.getContainer() instanceof XSDParticle)
//						{
//							XSDParticle partle = (XSDParticle)modelGp.getContainer();
//							if (partle.getContainer() instanceof XSDComplexTypeDefinition)
//							{
//								XSDComplexTypeDefinition typeElem = (XSDComplexTypeDefinition)partle.getContainer();
//								if (typeElem != null && typeElem.getName() != null && !typeElem.getName().equals(""))
//								{
//									ArrayList<Object> subObjList = new ArrayList<Object>();
//									Util.getAllObject(obj, subObjList, provider);
//									objList.removeAll(subObjList);
//									objList.remove(obj);
//				                    objs = objList.toArray();
//				                    break;
//								}
//							}
//						}
//					}
					
					if (obj instanceof XSDAnnotation
							|| obj instanceof XSDElementDeclaration
							|| obj instanceof XSDParticle) {
						boolean isImported = false;

						if(obj instanceof XSDParticle)
						{
							XSDParticle particle = (XSDParticle)obj;
							if(particle.getTerm() instanceof XSDElementDeclaration)
							{
								XSDElementDeclaration decl = (XSDElementDeclaration)particle.getTerm();
								if(Util.IsAImporedElement(decl, schema != null ? schema : ((XSDConcreteComponent)obj).getSchema()))
								{
									XSDTypeDefinition typeDef = decl.getTypeDefinition();
									if(Util.IsAImporedElement(typeDef, schema != null ? schema : ((XSDConcreteComponent)obj).getSchema()))
									   isImported = true;
								}
							}
						}
						else if(obj instanceof XSDElementDeclaration)
						{
							XSDElementDeclaration decl = (XSDElementDeclaration)obj;
							if(Util.IsAImporedElement(decl, schema != null ? schema : ((XSDConcreteComponent)obj).getSchema()))
								isImported = true;
						}
						else if(obj instanceof XSDAnnotation)
						{
							XSDAnnotation anno = (XSDAnnotation)obj;
							if(Util.IsAImporedElement(anno.getContainer(), schema != null ? schema : ((XSDConcreteComponent)obj).getSchema()))
								isImported = true;
						}
						
						if(!isImported)
						{
							XSDAnnotationsStructure annotion = new XSDAnnotationsStructure(
									(XSDComponent) obj);
							//see 7993, if UUID/AUTO_INCREMENT ,should not add write access 
							if(obj instanceof XSDParticle){
								XSDParticle o=(XSDParticle)obj;
								//String name=Util.getFirstTextNode(o.getElement(), "@name");
								String type=Util.getFirstTextNode(o.getElement(), "@type");
								if(EUUIDCustomType.AUTO_INCREMENT.equals(type) || EUUIDCustomType.UUID.equals(type))
								{
									objList.remove(obj);
									objs = objList.toArray();
									continue;
								}
							}
							annotion.removeAppInfos(access);  //X_Write
							for (Iterator iter = roles.iterator(); iter.hasNext();) {
								String role = (String) iter.next();
								annotion.addAppInfo(access, role);
							}
						}
					}
					objList.remove(obj);
					objs = objList.toArray();
				}
			}
			
			return setAccessRole(roles, access);
		}
		else {
			if(Util.IsAImporedElement(declaration, declaration.getSchema()))
				return false;
			return setAccessRole(roles, access);
		}
	}

	
	private boolean setAccessRole(Collection<String> roles, String access)
	{
		removeAppInfos(access);  //X_Write   X_Hide
		for (Iterator iter = roles.iterator(); iter.hasNext();) {
			String role = (String) iter.next();
			addAppInfo(access, role);
		}
		
		hasChanged = true;
		return true;
	}
	
	public boolean setWriteAccess(int num, String role) {
		TreeMap< String, String> infos = getWriteAccesses();
		infos.put("X_Write_"+num, role);
		return setForeignKeyInfos(new ArrayList(infos.values()));
	}

	public TreeMap<String, String> getWriteAccesses() {
		TreeMap<String, String> writeAccesses = new TreeMap<String, String>();
		LinkedHashMap<String, String> appInfos = getAppInfos("X_Write");
		Set<String> keys = appInfos.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			String key = (String) iter.next();
			writeAccesses.put(key, appInfos.get(key));
		}
		return writeAccesses;
	}
	
	/****************************************************************************
	 *           HIDDEN ACCESSES
	 ****************************************************************************/
	
	
	public boolean setHiddenAccess(int num, String role) {
		TreeMap< String, String> infos = getHiddenAccesses();
		infos.put("X_Hide_"+num, role);
		return setForeignKeyInfos(new ArrayList(infos.values()));
	}

	public TreeMap<String, String> getHiddenAccesses() {
		TreeMap<String, String> hiddenAccesses = new TreeMap<String, String>();
		LinkedHashMap<String, String> appInfos = getAppInfos("X_Hide");
		Set<String> keys = appInfos.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			String key = (String) iter.next();
			hiddenAccesses.put(key, appInfos.get(key));
		}
		return hiddenAccesses;
	}
	
	/****************************************************************************
	 *           SOURCE SYSTEM
	 ****************************************************************************/

	public boolean setSourceSystem(String sourceSystem) {
		boolean somethingChanged = setAppInfo("X_SourceSystem",sourceSystem, true);
		hasChanged = hasChanged |  somethingChanged;
		return somethingChanged;
	}

	public String getSourceSystem() {
		return getAppInfoValue("X_SourceSystem");
	}
	
	/****************************************************************************
	 *           TARGET SYSTEMS
	 ****************************************************************************/
	public boolean setTargetSystems(ArrayList<String> systems) {
		removeAppInfos("X_TargetSystem");
		for (Iterator iter = systems.iterator(); iter.hasNext(); ) {
			String role = (String) iter.next();
			addAppInfo("X_TargetSystem", role);
		}
		hasChanged = true;
		return true;
	}
	
	public boolean setTargetSystem(int num, String system) {
		TreeMap< String, String> infos = getTargetSystems();
		infos.put("X_TargetSystem_"+num, system);
		return setForeignKeyInfos(new ArrayList(infos.values()));
	}

	public TreeMap<String, String> getTargetSystems() {
		TreeMap<String, String> targetSystems = new TreeMap<String, String>();
		LinkedHashMap<String, String> appInfos = getAppInfos("X_TargetSystem");
		Set<String> keys = appInfos.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			String key = (String) iter.next();
			targetSystems.put(key, appInfos.get(key));
		}
		return targetSystems;
	}
	/*************************************************************
	 * Schematron Rule
	 *************************************************************/
	public boolean setSchematrons(Collection<String> systems) {
		removeAppInfos(ICoreConstants.X_Schematron);
		for (Iterator iter = systems.iterator(); iter.hasNext(); ) {
			String role = (String) iter.next();
			
			addAppInfo(ICoreConstants.X_Schematron, role);
		}
		hasChanged = true;
		return true;
	}
	
	public boolean setSchematron(int num, String system) {
		TreeMap< String, String> infos = getSchematrons();
		infos.put(ICoreConstants.X_Schematron+"_"+num, system);
		setSchematrons(infos.values());
		//return setForeignKeyInfos(new ArrayList(infos.values()));
		return true;
	}
	public void addSchematron(String pattern){
		TreeMap< String, String> infos = getSchematrons();
		infos.put(ICoreConstants.X_Schematron+"_"+(infos.size()+1), pattern);
		setSchematrons(infos.values());
	}
	public void removeSchematron(String pattern){
		TreeMap< String, String> infos = getSchematrons();
		for(Entry<String, String>entry: infos.entrySet()){
			if(pattern.equals(entry.getValue())){
				infos.remove(entry.getKey());
				break;
			}
		}
		setSchematrons(infos.values());
	}
	public TreeMap<String, String> getSchematrons() {
		TreeMap<String, String> targetSystems = new TreeMap<String, String>();
		LinkedHashMap<String, String> appInfos = getAppInfos(ICoreConstants.X_Schematron);
		Set<String> keys = appInfos.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			String key = (String) iter.next();
			String v=appInfos.get(key);
			if(v ==null || v.trim().length()==0) continue;
			targetSystems.put(key, appInfos.get(key));
		}
		return targetSystems;
	}
	
	/*************************************************************
	 * Workflow
	 *************************************************************/
	public boolean setWorkflows(Collection<String> systems) {
		removeAppInfos(ICoreConstants.X_Workflow);
		for (Iterator iter = systems.iterator(); iter.hasNext(); ) {
			String role = (String) iter.next();
			
			addAppInfo(ICoreConstants.X_Workflow, role);
		}
		hasChanged = true;
		return true;
	}
	
	public boolean setWorkflow(int num, String system) {
		TreeMap< String, String> infos = getSchematrons();
		infos.put(ICoreConstants.X_Workflow+"_"+num, system);
		setSchematrons(infos.values());
		//return setForeignKeyInfos(new ArrayList(infos.values()));
		return true;
	}
	public void addWorkflow(String pattern){
		TreeMap< String, String> infos = getSchematrons();
		infos.put(ICoreConstants.X_Workflow+"_"+(infos.size()+1), pattern);
		setSchematrons(infos.values());
	}
	public void removeWorkflow(String pattern){
		TreeMap< String, String> infos = getSchematrons();
		for(Entry<String, String>entry: infos.entrySet()){
			if(pattern.equals(entry.getValue())){
				infos.remove(entry.getKey());
				break;
			}
		}
		setSchematrons(infos.values());
	}
	public TreeMap<String, String> getWorkflows() {
		TreeMap<String, String> targetSystems = new TreeMap<String, String>();
		LinkedHashMap<String, String> appInfos = getAppInfos(ICoreConstants.X_Workflow);
		Set<String> keys = appInfos.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			String key = (String) iter.next();
			String v=appInfos.get(key);
			if(v ==null || v.trim().length()==0) continue;
			targetSystems.put(key, appInfos.get(key));
		}
		return targetSystems;
	}
	
	/*************************************************************
	 * Multilingual facet error messages 
	 *************************************************************/
	/**
	 * author: fliu, 
	 * set Multilingual facet error messages attached to facets in the schema 
	 * please refer to bug 0009157
	 */
	public boolean setFactMessage(LinkedHashMap<String, String> facts) {
		Iterator<String> isos = Util.iso2lang.keySet().iterator();
		while(isos.hasNext())
		{
			String lang = isos.next();
			removeAppInfos("X_Facet_" + lang.toUpperCase());
		}
		
		Iterator<String> isoIter = facts.keySet().iterator();
		while(isoIter.hasNext())
		{
			String iso = isoIter.next();
			removeAppInfos("X_Facet_" + iso.toUpperCase());
			addAppInfo("X_Facet_" + iso.toUpperCase(), facts.get(iso));
		}
		
		hasChanged = true;
		return true;
	}
	
	/**
	 * author: fliu, 
	 * get Multilingual facet error messages attached to facets in the schema 
	 * please refer to bug 0009157
	 */
	public LinkedHashMap<String, String>  getFactMessage()
	{
		LinkedHashMap<String, String> descriptionsMap = new LinkedHashMap<String, String>();
		Iterator<String> isoIter = Util.iso2lang.keySet().iterator();
		while(isoIter.hasNext())
		{
			String iso = isoIter.next().toUpperCase();
			String prefix = "X_Facet_" + iso;
			String infoValue = getAppInfoValue(prefix);
			if (infoValue != null)
				descriptionsMap.put(iso.toLowerCase(), infoValue);
		}
		
		return descriptionsMap;
	}
	/****************************************************************************
	 *           APPINFO UTILITIES
	 ****************************************************************************/

	private Element getAppInfo(String regex) {
		Element appInfo = null;
		ArrayList<Element> list = new ArrayList<Element>();
		//list.addAll(annotation.getUserInformation());
		list.addAll(annotation.getApplicationInformation());
		for (Iterator iter = list.iterator(); iter.hasNext(); ) {
			Element ann = (Element)iter.next();
			String name = ann.getLocalName();
			if ("appinfo".equals(name.toLowerCase())) {
				name= ann.getAttribute("source");
				if (name.matches(regex)) {
					appInfo=ann;
					break;
				}
			}
		}
		return appInfo;
	}
	
	private String getAppInfoValue(String regex) {
		Element appInfo = getAppInfo(regex);
		if (appInfo == null) return null;
		return appInfo.getFirstChild().getNodeValue();
	}
	
	private LinkedHashMap<String, String> getAppInfos(String regex) {
		LinkedHashMap<String, String> appInfos = new LinkedHashMap<String, String>();
		ArrayList<Element> list = new ArrayList<Element>();
		//list.addAll(annotation.getUserInformation());
		list.addAll(annotation.getApplicationInformation());
		int i=0;
		for (Iterator iter = list.iterator(); iter.hasNext(); ) {
			Element ann = (Element)iter.next();
			String name = ann.getLocalName();
			if ("appinfo".equals(name.toLowerCase())) {
				name= ann.getAttribute("source");
				if (name.equals(regex)) {
					appInfos.put(name+"_"+i, ann.getFirstChild().getNodeValue());
					i++;
				} else if (name.matches(regex)) {
					appInfos.put(name, ann.getFirstChild().getNodeValue());
				}
			}
		}
		return appInfos;
	}
	
	private boolean removeAppInfos(String regex) {
		boolean somethingRemoved = false;
		Element appInfo = null;
		do {
			 appInfo = getAppInfo(regex);
			if (appInfo!=null) {
				annotation.getElement().removeChild(appInfo);
				annotation.getApplicationInformation().remove(appInfo); //yes we need to do that too....
				somethingRemoved = true;
			}
		} while (appInfo!=null);
		return somethingRemoved;
	}


	private boolean setAppInfo(String type, String value, boolean overwrite) {
		if (value == null || value.length()==0) {
			boolean wasRemoved = removeAppInfos(type);
			hasChanged = hasChanged | wasRemoved;
			return wasRemoved;
		}
	
		if (!overwrite) return addAppInfo(type, value);
		
		Element ann = getAppInfo(type);
		if (ann==null) return addAppInfo(type, value);

		//change existing one if
		//first make sure the annotation is not brain new and is attached
		if (declaration.getAnnotation()==null) {
			declaration.setAnnotation(annotation);
		}
		//then create the appinfo
		String existingText = ann.getFirstChild().getNodeValue();
		if (!value.equals(existingText)) {
			ann.getFirstChild().setNodeValue(value);
			hasChanged = true;
			return true;
		}
		return false;
	}
	
	private boolean addAppInfo(String type, String value) {
		if (declaration.getAnnotation()==null) {
			declaration.setAnnotation(annotation);
		}
		Element appinfo = annotation.createApplicationInformation(type);
   		Node text = appinfo.getOwnerDocument().createTextNode(value);
   		appinfo.appendChild(text);
   		annotation.getElement().appendChild(appinfo);
   		hasChanged = true;
		return true;
	}
	
	
	public boolean hasChanged() {
		ArrayList<Element> list = new ArrayList<Element>();
		list.addAll(annotation.getApplicationInformation());
		list.addAll(annotation.getUserInformation());

		if (list.size() == 0) {
			//remove the annotation from the declaration
			if (declaration.getAnnotation()!=null) {
				declaration.getElement().removeChild(annotation.getElement());
				declaration.setAnnotation(null);
				hasChanged = true;
			}
		} else {
			//attach the annotation to the declaration
			if (declaration.getAnnotation()==null) {
				declaration.setAnnotation(annotation);
				hasChanged = true;
			}
		}		
		return hasChanged;
	}
	
	/****************************************************************************
	 *           BEAN
	 ****************************************************************************/

	public XSDAnnotation getAnnotation() {
		return annotation;
	}


	public void setAnnotation(XSDAnnotation annotation) {
		this.annotation = annotation;
	}


	public XSDElementDeclaration getDeclaration() {
		return declaration;
	}


	public void setDeclaration(XSDElementDeclaration declaration) {
		this.declaration = declaration;
	}

	
	public void setXSDSchema(XSDSchema schma)
	{
		schema = schma;
	}
	
	
}
