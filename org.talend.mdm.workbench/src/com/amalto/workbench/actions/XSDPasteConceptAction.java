package com.amalto.workbench.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Status;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComplexTypeContent;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTypeDefinition;
import org.w3c.dom.Element;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.WorkbenchClipboard;
import com.amalto.workbench.utils.XSDAnnotationsStructure;
import com.amalto.workbench.utils.XtentisException;

public class XSDPasteConceptAction extends UndoAction {
	private DataModelMainPage page;
	ArrayList<XSDElementDeclaration> conceptList = new ArrayList<XSDElementDeclaration>();
	
	Set<XSDTypeDefinition> copyTypeSet = new HashSet<XSDTypeDefinition>();
	HashMap<String, XSDTypeDefinition> typeList = new HashMap<String, XSDTypeDefinition>();
	String displayName = "Paste Entity";
	public XSDPasteConceptAction(DataModelMainPage page,boolean multi) {
		super(page);
		this.page = page;
		if(multi)
			displayName = "Paste Entities";
		setImageDescriptor(ImageCache.getImage(EImage.PASTE.getPath()));
		setText(displayName);
		setToolTipText("Paste one or more Entities");
	}
	public IStatus doAction() {

		try {

			conceptList = WorkbenchClipboard.getWorkbenchClipboard().getConcepts();
			
			XSDFactory factory = XSDFactory.eINSTANCE;
			if (!conceptList.isEmpty()) {
				//List<String> concepts = new ArrayList<String>();
				int index = 0;
				for (Iterator it = conceptList.iterator(); it.hasNext();) {
					
					if(conceptList.get(index).getSchema()!=null){
						//concepts = Util.getConcepts(conceptList.get(index).getSchema());
						typeList = Util.getTypeDefinition(conceptList.get(index).getSchema());
					}
					index++;
					Object concept = it.next();

					if (concept instanceof XSDElementDeclaration) {
						//edit by ymli,fix the bug:0011523. let the element(simple or complex) can be pasted
						//if (concepts.contains(((XSDElementDeclaration) concept).getName())) {
							XSDElementDeclaration copy_concept = (XSDElementDeclaration) concept;

							XSDElementDeclaration new_copy_concept = factory.createXSDElementDeclaration();;

							new_copy_concept = (XSDElementDeclaration) copy_concept.cloneConcreteComponent(true, false);
							InputDialog id = new InputDialog(page.getSite().getShell(), 
									"Copy Element",
									"Enter a new Name for the Element",
									"Copy_of_" + copy_concept.getName(),
									new IInputValidator() {
										public String isValid(String newText) {
											if ((newText == null)|| "".equals(newText))
												return "The Entity Name cannot be empty";
											EList list = schema.getElementDeclarations();
											for (Iterator iter = list.iterator(); iter.hasNext();) {
												XSDElementDeclaration d = (XSDElementDeclaration) iter.next();
												if (d.getName().equals(newText))
													return "This Entity already exists";
											}
											return null;
										};
									});

							id.setBlockOnOpen(true);
							int ret = id.open();
							if (ret == Window.CANCEL) {
								return Status.CANCEL_STATUS;
							}

							new_copy_concept.setName(id.getValue());
							for (int i = 0; i < new_copy_concept.getIdentityConstraintDefinitions().size(); i++) {
								String name = new_copy_concept.getIdentityConstraintDefinitions().get(i).getName().replaceAll(copy_concept.getName(),new_copy_concept.getName());
								new_copy_concept.getIdentityConstraintDefinitions().get(i).setName(name);
							}
							new_copy_concept.updateElement();
							schema.getContents().add(new_copy_concept);
							addAnnotationForXSDElementDeclaration(copy_concept,new_copy_concept);

							// System.out.println("@@@  copy_concept:"+Util.
							// nodeToString(copy_concept.getElement()));

							//System.out.println("@@@:"+Util.nodeToString(schema
							// .getDocument()));
						//}
					}
				}
				HashMap<String, XSDTypeDefinition> typeDef = Util.getTypeDefinition(schema);
				for (XSDTypeDefinition type : copyTypeSet) {
					if (typeDef.containsKey(type.getName()))
						continue;
					XSDTypeDefinition typedefinitionClone = null;
					if (type instanceof XSDComplexTypeDefinition) {
						typedefinitionClone = factory.createXSDComplexTypeDefinition();
						typedefinitionClone = (XSDComplexTypeDefinition) type.cloneConcreteComponent(true, false);
						schema.getContents().add((XSDComplexTypeDefinition) typedefinitionClone);
						addAnnotationForComplexType((XSDComplexTypeDefinition) type,(XSDComplexTypeDefinition) typedefinitionClone);
					} else if (type instanceof XSDSimpleTypeDefinition) {
						schema.getContents().add((XSDSimpleTypeDefinition) type.cloneConcreteComponent(true, false));
					}
				}
				schema.getElement();
				// WSDataModel wsObject = (WSDataModel)
				// (page.getXObject().getWsObject());
				// wsObject.getXsdSchema();//.setXsdSchema(Util.nodeToString(
				// schema.getDocument()));

				/*
				 * String schema1 = ((XSDTreeContentProvider) page.getViewer()
				 * .getContentProvider()).getXSDSchemaAsString();
				 * wsObject.setXsdSchema(schema1); XMLEditor
				 * xmleditor=((XObjectEditor)page.getEditor()).getXmlEditor();
				 * xmleditor.refresh(page.getXObject());
				 */
				page.markDirty();
				page.refresh();
				// page.refreshData();

				getOperationHistory();
				WorkbenchClipboard.getWorkbenchClipboard().conceptsReset();
				typeList.clear();

				return Status.OK_STATUS;
			}
			return Status.CANCEL_STATUS;
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(page.getSite().getShell(), "Error",
					"An error occured trying to Paste Entity: "
							+ e.getLocalizedMessage());

		}
		return Status.OK_STATUS;
	}
	public boolean checkInPasteType(){
		/*if(WorkbenchClipboard.getWorkbenchClipboard().getConcepts().size()>1)
			this.displayName = "Paste Entities";*/
		if(WorkbenchClipboard.getWorkbenchClipboard().getConcepts().size()<=0)
			return false;
		//edit by ymli,fix the bug:0011523. let the element(simple or complex) can be pasted
		/*conceptList = WorkbenchClipboard.getWorkbenchClipboard().getConcepts();
		int t = 0;
		for(XSDElementDeclaration ele:conceptList){
			if(conceptList.get(t).getSchema()!=null){
				List<String> concepts = Util.getConcepts(conceptList.get(t).getSchema());
					if(concepts.contains(ele.getName()))
						return true;
				}
			t++;
						}*/
		else
			return true;
	}
	
	public void addAnnotationForComplexType(XSDComplexTypeDefinition fromType,XSDComplexTypeDefinition toType) {
		XSDComplexTypeContent tocomplexType = toType.getContent();
		XSDComplexTypeContent fromcomplexType = fromType.getContent();
		if (fromcomplexType instanceof XSDParticle) {

			XSDParticle fromxsdParticle = (XSDParticle) fromcomplexType;
			XSDParticle toxsdParticle = (XSDParticle) tocomplexType;

			if (((XSDParticle) fromxsdParticle).getTerm() instanceof XSDModelGroup) {

				XSDModelGroup frommodelGroup = ((XSDModelGroup) fromxsdParticle.getTerm());
				XSDModelGroup tomodelGroup = ((XSDModelGroup) toxsdParticle.getTerm());

				EList fromlist = frommodelGroup.getContents();
				EList tolist = tomodelGroup.getContents();

				Iterator toIt = tolist.iterator();

				for (XSDParticle fromel : (XSDParticle[]) fromlist.toArray(new XSDParticle[fromlist.size()])) {
					XSDParticle toel = (XSDParticle) toIt.next();
					XSDTerm totm = toel.getTerm();
					XSDTerm fromtm = fromel.getTerm();
					if (fromtm instanceof XSDElementDeclaration) {
						XSDAnnotation fromannotation = ((XSDElementDeclaration) fromtm).getAnnotation();
						if (fromannotation != null) {
							XSDAnnotationsStructure struc = new XSDAnnotationsStructure(totm);
							addAnnotion(struc, fromannotation);
							if (this.typeList.containsKey(((XSDElementDeclaration) totm).getType().getName()))
								this.copyTypeSet.add(this.typeList.get(((XSDElementDeclaration) totm).getType().getName()));
							addAnnotationForXSDElementDeclaration((XSDElementDeclaration) fromtm,(XSDElementDeclaration) totm);

						}
					}
				}
			}

		}
	}
	
	public void addAnnotationForXSDElementDeclaration(XSDElementDeclaration fromElem, XSDElementDeclaration toElem) {
		if (fromElem.getAnnotation() != null) {
			//toElem.setAnnotation(cloneXSDAnnotation(toElem.getAnnotation(),fromElem.getAnnotation()));
			XSDAnnotationsStructure struc =new XSDAnnotationsStructure(toElem);
			addAnnotion(struc, fromElem.getAnnotation());
			
		}
		if (fromElem.getTypeDefinition() instanceof XSDComplexTypeDefinition) {
			XSDComplexTypeContent fromcomplexType = ((XSDComplexTypeDefinition) fromElem.getTypeDefinition()).getContent();
			//if the concept is a complex type itself. copy the complex type also,
			//in this situation,if not copy the complex type, the type change to simple type
			if( this.typeList.containsKey(toElem.getTypeDefinition().getName()))
				this.copyTypeSet.add(this.typeList.get(toElem.getTypeDefinition().getName()));

			if(toElem.getTypeDefinition() instanceof XSDComplexTypeDefinition){
			XSDComplexTypeContent tocomplexType = ((XSDComplexTypeDefinition) toElem.getTypeDefinition()).getContent();
			if (fromcomplexType instanceof XSDParticle) {

				XSDParticle fromxsdParticle = (XSDParticle) fromcomplexType;
				XSDParticle toxsdParticle = (XSDParticle) tocomplexType;
				

				if (((XSDParticle) fromxsdParticle).getTerm() instanceof XSDModelGroup) {

					XSDModelGroup frommodelGroup = ((XSDModelGroup) fromxsdParticle.getTerm());
					XSDModelGroup tomodelGroup = ((XSDModelGroup) toxsdParticle.getTerm());

					EList fromlist = frommodelGroup.getContents();
					EList tolist = tomodelGroup.getContents();

					Iterator toIt = tolist.iterator();

					for (XSDParticle fromel : (XSDParticle[]) fromlist.toArray(new XSDParticle[fromlist.size()])) {
						XSDParticle toel = (XSDParticle) toIt.next();
						XSDTerm totm = toel.getTerm();
						XSDTerm fromtm = fromel.getTerm();
						if (fromtm instanceof XSDElementDeclaration) {
							XSDAnnotation fromannotation = ((XSDElementDeclaration) fromtm).getAnnotation();
							if(fromannotation!=null){
								//((XSDElementDeclaration) totm).setAnnotation(cloneXSDAnnotation(((XSDElementDeclaration) totm).getAnnotation(),fromannotation));
								XSDAnnotationsStructure struc =new XSDAnnotationsStructure(totm);
								if(((XSDElementDeclaration)totm).getType()!=null){
									addAnnotion(struc, fromannotation);
								}
								else{
									MessageDialog.openInformation(page.getSite().getShell(), "Warning", "The Entity: "+fromElem.getName()+" is pointed to by a foreign key.");
									return;
								}
									
							}
							if(((XSDElementDeclaration)totm).getType()!=null && this.typeList.containsKey(((XSDElementDeclaration)totm).getType().getName()))
								this.copyTypeSet.add(this.typeList.get(((XSDElementDeclaration)totm).getType().getName()));
							addAnnotationForXSDElementDeclaration((XSDElementDeclaration) fromtm,(XSDElementDeclaration) totm);
						}
					}
				}
			}
		}
		}
		else{
			String simpleType = fromElem.getTypeDefinition().getName();
			if(this.typeList.containsKey(simpleType))
				this.copyTypeSet.add(fromElem.getTypeDefinition());
		}
	}
	
	public void addAnnotion(XSDAnnotationsStructure struc,XSDAnnotation xsdannotationparent){
		Map infor = new HashMap<String, ArrayList<String>>();
		infor = cloneXSDAnnotation(xsdannotationparent);
		Set keys = infor.keySet();
		for(int i = 0;i<infor.size();i++){
			ArrayList<String> lists = (ArrayList<String>) infor.get(keys.toArray()[i]);
		try {
			struc.setAccessRole(lists, false, (IStructuredContentProvider) page.getTreeViewer()
						.getContentProvider(), (String) keys.toArray()[i]);
		} catch (XtentisException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public Map cloneXSDAnnotation(XSDAnnotation oldAnn) {
		XSDAnnotation xsdannotation = XSDFactory.eINSTANCE
				.createXSDAnnotation();
		Map infor = new HashMap<String, List>();
		try {
			/*
			 * Element oldAnnElem =oldAnn.getElement(); Element newAnnElem =
			 * (Element)oldAnnElem.cloneNode(true);
			 * xsdannotation.setElement(newAnnElem);
			 */

			/*List<Element> listAppInfo = new ArrayList<Element>();
			List<Element> listUserInfo = new ArrayList<Element>();
			List<Attr> listAttri = new ArrayList<Attr>();*/
			if (oldAnn != null) {
				for (int i = 0; i < oldAnn.getApplicationInformation().size(); i++) {
					Element oldElem = oldAnn.getApplicationInformation().get(i);
					// System.out.println(oldElem.getAttributes().getNamedItem(
					// "source").getNodeValue());
					String type = oldElem.getAttributes().getNamedItem("source").getNodeValue();
					/*Element newElem = (Element) oldElem.cloneNode(true);
					listAppInfo.add(oldAnn.getApplicationInformation().get(i));*/
					if (!infor.containsKey(type)) {
						List typeList = new ArrayList<String>();
						typeList.add(oldElem.getFirstChild().getNodeValue());
						infor.put(type, typeList);
					} else {
						((List) infor.get(type)).add(oldElem.getFirstChild()
								.getNodeValue());
					}
				}
				/*xsdannotation.getApplicationInformation().addAll(listAppInfo);

				for (int i = 0; i < oldAnn.getUserInformation().size(); i++) {
					Element oldElemUserInfo = oldAnn.getUserInformation()
							.get(i);
					Element newElemUserInfo = (Element) oldElemUserInfo
							.cloneNode(true);
					listUserInfo.add(newElemUserInfo);

				}
				xsdannotation.getUserInformation().addAll(listUserInfo);

				for (int i = 0; i < oldAnn.getAttributes().size(); i++) {
					Attr oldAttri = oldAnn.getAttributes().get(i);
					Attr newAtri = (Attr) oldAttri.cloneNode(true);
					listAttri.add(newAtri);
				}
				xsdannotation.getAttributes().addAll(listAttri);*/
			}

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.page.getSite().getShell(), "Error",
					"An error occured trying to paste Entities: "
							+ e.getLocalizedMessage());
		}
		return infor;
	}
	
	
}
