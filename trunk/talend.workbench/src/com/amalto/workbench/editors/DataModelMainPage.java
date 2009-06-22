/*
 * Created on 27 oct. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.amalto.workbench.editors;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.operations.UndoRedoActionGroup;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDWildcard;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;
import org.eclipse.xsd.impl.XSDSchemaImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.amalto.workbench.actions.XSDChangeBaseTypeAction;
import com.amalto.workbench.actions.XSDChangeToComplexTypeAction;
import com.amalto.workbench.actions.XSDChangeToSimpleTypeAction;
import com.amalto.workbench.actions.XSDDeleteConceptAction;
import com.amalto.workbench.actions.XSDDeleteConceptWrapAction;
import com.amalto.workbench.actions.XSDDeleteElementAction;
import com.amalto.workbench.actions.XSDDeleteIdentityConstraintAction;
import com.amalto.workbench.actions.XSDDeleteParticleAction;
import com.amalto.workbench.actions.XSDDeleteXPathAction;
import com.amalto.workbench.actions.XSDEditConceptAction;
import com.amalto.workbench.actions.XSDEditElementAction;
import com.amalto.workbench.actions.XSDEditFacetAction;
import com.amalto.workbench.actions.XSDEditIdentityConstraintAction;
import com.amalto.workbench.actions.XSDEditParticleAction;
import com.amalto.workbench.actions.XSDEditXPathAction;
import com.amalto.workbench.actions.XSDGetXPathAction;
import com.amalto.workbench.actions.XSDNewConceptAction;
import com.amalto.workbench.actions.XSDNewElementAction;
import com.amalto.workbench.actions.XSDNewGroupFromParticleAction;
import com.amalto.workbench.actions.XSDNewGroupFromTypeAction;
import com.amalto.workbench.actions.XSDNewIdentityConstraintAction;
import com.amalto.workbench.actions.XSDNewParticleFromParticleAction;
import com.amalto.workbench.actions.XSDNewParticleFromTypeAction;
import com.amalto.workbench.actions.XSDNewXPathAction;
import com.amalto.workbench.actions.XSDSetAnnotationDescriptionsAction;
import com.amalto.workbench.actions.XSDSetAnnotationDocumentationAction;
import com.amalto.workbench.actions.XSDSetAnnotationForeignKeyAction;
import com.amalto.workbench.actions.XSDSetAnnotationForeignKeyInfoAction;
import com.amalto.workbench.actions.XSDSetAnnotationHiddenAction;
import com.amalto.workbench.actions.XSDSetAnnotationLabelAction;
import com.amalto.workbench.actions.XSDSetAnnotationSourceSystemAction;
import com.amalto.workbench.actions.XSDSetAnnotationTargetSystemsAction;
import com.amalto.workbench.actions.XSDSetAnnotationWriteAction;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.providers.XSDTreeContentProvider;
import com.amalto.workbench.providers.XSDTreeLabelProvider;
import com.amalto.workbench.utils.EImage;
import com.amalto.workbench.utils.ImageCache;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSDataModel;

public class DataModelMainPage extends AMainPageV2 {

	protected Text descriptionText;
	protected Button importXSDBtn, exportBtn;
	protected TreeViewer viewer;
	protected DrillDownAdapter drillDownAdapter;

	private XSDNewConceptAction newConceptAction = null;
	private XSDDeleteConceptAction deleteConceptAction = null;
	private XSDDeleteConceptWrapAction deleteConceptWrapAction = null;
	private XSDNewElementAction newElementAction = null;
	private XSDDeleteElementAction deleteElementAction = null;
	private XSDChangeToComplexTypeAction changeToComplexTypeAction = null;
	private XSDDeleteParticleAction deleteParticleAction = null;
	private XSDNewParticleFromTypeAction newParticleFromTypeAction = null;
	private XSDNewParticleFromParticleAction newParticleFromParticleAction = null;
	private XSDNewGroupFromTypeAction newGroupFromTypeAction = null;
	private XSDNewGroupFromParticleAction newGroupFromParticleAction = null;
	private XSDEditParticleAction editParticleAction = null;
	private XSDEditConceptAction editConceptAction = null;
	private XSDEditElementAction editElementAction = null;
	private XSDDeleteIdentityConstraintAction deleteIdentityConstraintAction = null;
	private XSDEditIdentityConstraintAction editIdentityConstraintAction = null;
	private XSDNewIdentityConstraintAction newIdentityConstraintAction = null;
	private XSDDeleteXPathAction deleteXPathAction = null;
	private XSDNewXPathAction newXPathAction = null;
	private XSDEditXPathAction editXPathAction = null;
	private XSDChangeToSimpleTypeAction changeToSimpleTypeAction = null;
	private XSDChangeBaseTypeAction changeBaseTypeAction = null;
	private XSDGetXPathAction getXPathAction = null;
	private XSDSetAnnotationForeignKeyAction setAnnotationForeignKeyAction = null;
	private XSDSetAnnotationForeignKeyInfoAction setAnnotationForeignKeyInfoAction = null;
	private XSDSetAnnotationLabelAction setAnnotationLabelAction = null;
	private XSDSetAnnotationDescriptionsAction setAnnotationDescriptionsAction = null;
	private XSDSetAnnotationHiddenAction setAnnotationHiddenAction = null;
	private XSDSetAnnotationWriteAction setAnnotationWriteAction = null;
	private XSDSetAnnotationTargetSystemsAction setAnnotationTargetSystemsAction = null;
	private XSDSetAnnotationSourceSystemAction setAnnotationSourceSystemAction = null;
	private XSDSetAnnotationDocumentationAction setAnnotationDocumentationAction = null;
	private ObjectUndoContext undoContext;
	private MenuManager menuMgr;

	public DataModelMainPage(FormEditor editor) {
		super(editor, DataModelMainPage.class.getName(), "Data Model "
				+ ((XObjectEditorInput) editor.getEditorInput()).getName());
	}

	protected void createCharacteristicsContent(FormToolkit toolkit,
			Composite mainComposite) {

		try {

			WSDataModel wsObject = (WSDataModel) (getXObject().getWsObject());

			// description
			Label descriptionLabel = toolkit.createLabel(mainComposite,
					"Description", SWT.NULL);
			descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
					false, true, 1, 1));

			descriptionText = toolkit.createText(mainComposite, "", SWT.BORDER
					| SWT.MULTI);
			descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
					true, true, 1, 1));
			descriptionText.setText(wsObject.getDescription() == null ? ""
					: wsObject.getDescription());
			((GridData) descriptionText.getLayoutData()).minimumHeight = 30;
			descriptionText.addModifyListener(this);
			
			importXSDBtn = toolkit.createButton(mainComposite, "", SWT.PUSH);
			importXSDBtn.setImage(ImageCache.getCreatedImage(EImage.WRITABLE.getPath()));
			importXSDBtn.setToolTipText("Import...");
			exportBtn = toolkit.createButton(mainComposite, "", SWT.PUSH);
			exportBtn.setImage(ImageCache.getCreatedImage(EImage.PREV_NAV.getPath()));
			exportBtn.setToolTipText("Export...");
			importXSDBtn.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false,
					true, 1, 1));
			exportBtn.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false,
					true, 1, 1));
			importXSDBtn.addSelectionListener(new SelectionAdapter(){
	        	@Override
	        	public void widgetSelected(SelectionEvent e) {
	    			FileDialog fd = new FileDialog(getSite().getShell(),SWT.OPEN);
	    			fd.setFilterExtensions(new String[]{"*.xml","*.dtd", "*.xsd"});
	    			fd.setText("Select the XML definition for XML Schema");
	    			String filename = fd.open();
	    			if (filename == null) return;
	    			inferXsdFromXml(filename);
	        	}
	        	
	        	private void inferXsdFromXml(String xmlFile) {
					int infer = 0;
					String xsd = "";
					try {
						String inputType = xmlFile.substring(xmlFile
								.lastIndexOf("."));
						if (inputType.equals(".xsd")) {
							xsd = Util.getXML(xmlFile);
						} else {
							XSDDriver d = new XSDDriver();
							infer = d
									.doMain(new String[] { xmlFile, "out.xsd" });
							if (infer == 0) {
								xsd = d.outputXSD();
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
						infer = 2;
					}
					finally {
						if (infer == 0 && !xsd.equals("")) {
							WSDataModel wsObj = (WSDataModel) (getXObject()
									.getWsObject());
							wsObj.setXsdSchema(xsd);
							validateSchema(xsd);
							refreshData();
							markDirty();
						}
						else if (infer != 0) {
							MessageDialog
							.openError(getSite().getShell(), "Error",
									"XSD schema can not be inferred from the given xml");
							}
					}
				}
	        	
	        	void validateSchema(String xsd)
	        	{
	        		try {
						boolean elem = false;
						XSDSchema schema = getXSDSchema(xsd);
						NodeList nodeList = schema.getDocument()
								.getDocumentElement().getChildNodes();
						for (int idx = 0; idx < nodeList.getLength(); idx++) {
							Node node = nodeList.item(idx);
							if (node instanceof Element
									&& node.getLocalName().indexOf("element") >= 0) {
								elem = true;
								break;
							}
						}
						if (!elem) {
							MessageDialog
									.openWarning(getSite().getShell(),
											"Warnning",
											"There is no element node in the imported xsd schema");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        });
			
			exportBtn.addSelectionListener(new SelectionAdapter(){
	        	@Override
	        	public void widgetSelected(SelectionEvent e) {
	    			FileDialog fd = new FileDialog(getSite().getShell(),SWT.SAVE);
	    			fd.setFilterExtensions(new String[]{"*.xsd"});
	    			fd.setText("Save the Data Module as XSD Schema");
	    			String filename = fd.open();
	    			if (filename == null) return;
	    			inferXsdFromDataModule(filename);
	        	}
	        	
	        	private void inferXsdFromDataModule(String xmlFile) {
					WSDataModel wsObject = (WSDataModel) (getXObject().getWsObject());  
                    XSDDriver d = new XSDDriver();
                    if (d.outputXSD(wsObject.getXsdSchema(), xmlFile) != null) {
						MessageDialog.openInformation(getSite().getShell(),
								"Export XSD", "The operation for Exporting XSD completed successfully!");
					} else {
						MessageDialog.openError(getSite().getShell(), "Error",
								"failed to export XSD file!");
					}
				}
	        });
			Label xsdLabel = toolkit.createLabel(mainComposite, "Schema",
					SWT.NULL);
			xsdLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
					true, 2, 1));
			// get the XSDSchema
			XSDSchema xsdSchema = getXSDSchema(wsObject.getXsdSchema());

			viewer = new TreeViewer(mainComposite, SWT.MULTI | SWT.H_SCROLL
					| SWT.V_SCROLL);
			viewer.getControl().setLayoutData(
					new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
			((GridData) viewer.getControl().getLayoutData()).heightHint = 1000;
			drillDownAdapter = new DrillDownAdapter(viewer);
			viewer.setContentProvider(new XSDTreeContentProvider(
					this.getSite(), xsdSchema));
			viewer.setLabelProvider(new XSDTreeLabelProvider());
			viewer.setSorter(new ViewerSorter() {
				public int category(Object element) {
					// we want facets before Base TypeDefinitions in
					// SimpleTypeDefinition
					if (element instanceof XSDFacet)
						return 100;
					// unique keys after element declarations and before other
					// keys
					if (element instanceof XSDIdentityConstraintDefinition) {
						XSDIdentityConstraintDefinition icd = (XSDIdentityConstraintDefinition) element;
						if (icd.getIdentityConstraintCategory().equals(
								XSDIdentityConstraintCategory.UNIQUE_LITERAL))
							return 300;
						else if (icd.getIdentityConstraintCategory().equals(
								XSDIdentityConstraintCategory.KEY_LITERAL))
							return 301;
						else
							return 302;
					}
					return 200;
				}

				public int compare(Viewer theViewer, Object e1, Object e2) {
					int cat1 = category(e1);
					int cat2 = category(e2);
					return cat1 - cat2;
				}
			});
			viewer.setInput(this.getSite());// getViewSite());
			viewer.getTree().addKeyListener(new KeyListener() {

				public void keyPressed(KeyEvent e) {

					IStructuredSelection selection = ((IStructuredSelection) viewer
							.getSelection());

					// delete
					if ((e.stateMask == 0) && (e.keyCode == SWT.DEL)) {
						deleteSelectedItems(selection);
					}
				}

				public void keyReleased(KeyEvent e) {

				}

			});

			hookContextMenu();

			// if this created after the editorPage and it is dirty , mark this
			// one as dirty too
			DataModelEditorPage editorPage = ((DataModelEditorPage) getEditor()
					.findPage(DataModelEditorPage.class.getName()));
			if (editorPage.isDirty())
				this.markDirty();
			//init undo history
			initializeOperationHistory();
			// FIXME: does the reflow before the tree is actually expanded
			/*
			 * viewer.addTreeListener(new ITreeViewerListener() { public void
			 * treeExpanded(TreeExpansionEvent event) {
			 * DataModelMainPage.this.getManagedForm().getForm().reflow(true); }
			 * public void treeCollapsed(TreeExpansionEvent event) {
			 * DataModelMainPage.this.getManagedForm().getForm().reflow(true); }
			 * });
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// createCharacteristicsContent

	/**
	 * Author: Fliu
	 * this fun is to filter out all the children listed in the selections, 
	 * all left is the top parent level ones in the selections
	 * @param selections
	 * @return all parent array with no corresponding children in the selection list
	 */
	private Object[] filterSelectedItemsToDel(IStructuredSelection selections) {
		Object[] objs = selections.toArray();
		List lst = new ArrayList();

		for (Object obj : objs) {
			for (Object objOther : objs) {
				if (obj == objOther) {
					continue;
				}
				Object[] offsprings = populateAllOffspring(objOther,
						new ArrayList());
				for (Object offspring : offsprings) {
					if (offspring == obj) {
						lst.add(obj);
					}
				}
			}
		}

		for (Object ca : objs) {
			if (lst.indexOf(ca) >= 0) {
				lst.remove(ca);
			} else {
				lst.add(ca);
			}
		}
		return lst.toArray();
	}

	/**
	 * Author: Fliu
	 * this fun is to populate all offsprings for a specific object
	 */
	private Object[] populateAllOffspring(Object obj, ArrayList offspringList) {
		XSDTreeContentProvider provider = (XSDTreeContentProvider) viewer
				.getContentProvider();
		Object[] offersprings = provider.getChildren(obj);

		for (Object subObj : offersprings) {
			if (!offspringList.contains(subObj))
			{
				offspringList.add(subObj);
				if (provider.hasChildren(subObj)) {
					populateAllOffspring(subObj, offspringList);
				}
			}
			else
			{
				continue;
			}

		}
		return offspringList.toArray();
	}

    /**
     * author: Fliu
	 * it is meant to support multiple deletions on data modules on key press
     * @param selections: tree node picking up in the data module view
     */
	private void deleteSelectedItems(IStructuredSelection selections) {

		Object[] objs = selections.toArray();
		String instance = objs.length > 1 ? " instances ?" : " instance";
		if (!MessageDialog
				.openConfirm(getSite().getShell(), "Delete Model",
						"Are you sure you want to delete the " + objs.length
								+ instance))
			return;

		objs = filterSelectedItemsToDel(selections);
		for (Object obj : objs) {
			if (obj instanceof XSDElementDeclaration) {
				XSDElementDeclaration decl = (XSDElementDeclaration) obj;

				boolean isConcept = false;
				EList l = decl.getIdentityConstraintDefinitions();
				for (Iterator iter = l.iterator(); iter.hasNext();) {
					XSDIdentityConstraintDefinition icd = (XSDIdentityConstraintDefinition) iter
							.next();
					if (icd.getIdentityConstraintCategory().equals(
							XSDIdentityConstraintCategory.UNIQUE_LITERAL)) {
						isConcept = true;
						break;
					}
				}
				if (isConcept) {
					deleteConceptAction.run(obj);
				} else {
					deleteElementAction.run(obj);
				}
			} else if (obj instanceof XSDParticle) {
				deleteParticleAction.run(obj);
			} else if (obj instanceof XSDIdentityConstraintDefinition) {
				deleteIdentityConstraintAction.run(obj);
			} else if (obj instanceof XSDXPathDefinition) {
				deleteXPathAction.run(obj);

			} else {
			}
		}
	}

	protected void refreshData() {
		try {

			if (!this.equals(getEditor().getActivePageInstance()))
				return;

			WSDataModel wsObject = (WSDataModel) (getXObject().getWsObject());
			String s;

			s = wsObject.getDescription() == null ? "" : wsObject
					.getDescription();
			if (!s.equals(descriptionText.getText()))
				descriptionText.setText(s);

			viewer.setContentProvider(new XSDTreeContentProvider(
					this.getSite(), getXSDSchema(wsObject.getXsdSchema())));
			viewer.refresh(true);
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(),
					"Error refreshing the page", "Error refreshing the page: "
							+ e.getLocalizedMessage());
		}
	}

	protected void commit() {
		try {
			WSDataModel wsObject = (WSDataModel) (getXObject().getWsObject());
			wsObject.setDescription(descriptionText.getText() == null ? ""
					: descriptionText.getText());
			String schema = ((XSDTreeContentProvider) viewer
					.getContentProvider()).getXSDSchemaAsString();
			wsObject.setXsdSchema(schema);
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(this.getSite().getShell(),
					"Error committing the page", "Error committing the page: "
							+ e.getLocalizedMessage());
		}
	}

	protected void createActions() {
		this.newConceptAction = new XSDNewConceptAction(this);
		this.deleteConceptAction = new XSDDeleteConceptAction(this);
		this.deleteConceptWrapAction = new XSDDeleteConceptWrapAction(this,deleteConceptAction);
		this.newElementAction = new XSDNewElementAction(this);
		this.deleteElementAction = new XSDDeleteElementAction(this);
		this.changeToComplexTypeAction = new XSDChangeToComplexTypeAction(this);
		this.deleteParticleAction = new XSDDeleteParticleAction(this);
		this.newParticleFromTypeAction = new XSDNewParticleFromTypeAction(this);
		this.newParticleFromParticleAction = new XSDNewParticleFromParticleAction(
				this);
		this.newGroupFromTypeAction = new XSDNewGroupFromTypeAction(this);
		this.newGroupFromParticleAction = new XSDNewGroupFromParticleAction(
				this);
		this.editParticleAction = new XSDEditParticleAction(this);
		this.editConceptAction = new XSDEditConceptAction(this);
		this.editElementAction = new XSDEditElementAction(this);
		this.deleteIdentityConstraintAction = new XSDDeleteIdentityConstraintAction(
				this);
		this.editIdentityConstraintAction = new XSDEditIdentityConstraintAction(
				this);
		this.newIdentityConstraintAction = new XSDNewIdentityConstraintAction(
				this);
		this.deleteXPathAction = new XSDDeleteXPathAction(this);
		this.newXPathAction = new XSDNewXPathAction(this);
		this.editXPathAction = new XSDEditXPathAction(this);
		this.changeToSimpleTypeAction = new XSDChangeToSimpleTypeAction(this);
		this.changeBaseTypeAction = new XSDChangeBaseTypeAction(this);
		this.getXPathAction = new XSDGetXPathAction(this);
		this.setAnnotationLabelAction = new XSDSetAnnotationLabelAction(this);
		this.setAnnotationDescriptionsAction = new XSDSetAnnotationDescriptionsAction(
				this);
		this.setAnnotationForeignKeyAction = new XSDSetAnnotationForeignKeyAction(
				this);
		this.setAnnotationForeignKeyInfoAction = new XSDSetAnnotationForeignKeyInfoAction(
				this);
		this.setAnnotationWriteAction = new XSDSetAnnotationWriteAction(this);
		this.setAnnotationHiddenAction = new XSDSetAnnotationHiddenAction(this);
		this.setAnnotationTargetSystemsAction = new XSDSetAnnotationTargetSystemsAction(
				this);
		this.setAnnotationSourceSystemAction = new XSDSetAnnotationSourceSystemAction(
				this);
		this.setAnnotationDocumentationAction = new XSDSetAnnotationDocumentationAction(
				this);
	}

	private void hookContextMenu() {
		menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				DataModelMainPage.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	protected void fillContextMenu(IMenuManager manager) {
		IStructuredSelection selection = ((IStructuredSelection) viewer
				.getSelection());

		if ((selection == null) || (selection.getFirstElement() == null)) {
			manager.add(newConceptAction);
			manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
			return;
		}

		Object obj = selection.getFirstElement();

		// Element Declaration
		if (obj instanceof XSDElementDeclaration) {
			// check if concept or "just" element
			XSDElementDeclaration decl = (XSDElementDeclaration) obj;
			boolean isConcept = false;
			EList l = decl.getIdentityConstraintDefinitions();
			for (Iterator iter = l.iterator(); iter.hasNext();) {
				XSDIdentityConstraintDefinition icd = (XSDIdentityConstraintDefinition) iter
						.next();
				if (icd.getIdentityConstraintCategory().equals(
						XSDIdentityConstraintCategory.UNIQUE_LITERAL)) {
					isConcept = true;
					break;
				}
			}
			if (isConcept) {
				manager.add(editConceptAction);
				manager.add(deleteConceptWrapAction);
			} else {
				manager.add(editElementAction);
				manager.add(deleteElementAction);
			}
			manager.add(new Separator());
			manager.add(newConceptAction);
			manager.add(newElementAction);
			manager.add(new Separator());
			manager.add(changeToComplexTypeAction);
			manager.add(changeToSimpleTypeAction);
			manager.add(new Separator());
			manager.add(newIdentityConstraintAction);
			// Annotations
			setAnnotationActions2(manager);
		}

		if (obj instanceof XSDParticle) {
			XSDTerm term = ((XSDParticle) obj).getTerm();
			if (!(term instanceof XSDWildcard)) {
				manager.add(editParticleAction);
				manager.add(newGroupFromParticleAction);
				manager.add(newParticleFromParticleAction);
				if (term instanceof XSDModelGroup) {
					manager.add(newParticleFromTypeAction);
					manager.add(newGroupFromTypeAction);
				}
				manager.add(deleteParticleAction);
				manager.add(new Separator());
				manager.add(changeToComplexTypeAction);
				manager.add(changeToSimpleTypeAction);
				manager.add(new Separator());
				//manager.add(newIdentityConstraintAction);
				if (term instanceof XSDElementDeclaration) {
					// Annotations
					setAnnotationActions(manager);
					// Xpath
					manager.add(new Separator());
					manager.add(getXPathAction);
				}
			}
		}

		if (obj instanceof XSDComplexTypeDefinition) {
			manager.add(newParticleFromTypeAction);
			manager.add(newGroupFromTypeAction);
		}

		if (obj instanceof XSDIdentityConstraintDefinition) {
			manager.add(editIdentityConstraintAction);
			manager.add(deleteIdentityConstraintAction);
			manager.add(newIdentityConstraintAction);
			manager.add(new Separator());
			manager.add(newXPathAction);
		}

		if (obj instanceof XSDXPathDefinition) {
			manager.add(editXPathAction);
			manager.add(newXPathAction);
			XSDXPathDefinition xpath = (XSDXPathDefinition) obj;
			if (xpath.getVariety().equals(XSDXPathVariety.FIELD_LITERAL))
				manager.add(deleteXPathAction);
		}

		if (obj instanceof XSDSimpleTypeDefinition) {
			XSDSimpleTypeDefinition typedef = (XSDSimpleTypeDefinition) obj;

			if (!typedef.getSchema().getSchemaForSchemaNamespace().equals(
					typedef.getTargetNamespace())) {
				manager.add(changeBaseTypeAction);
				manager.add(new Separator());
				EList list = typedef.getBaseTypeDefinition().getValidFacets();
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					String element = (String) iter.next();
					manager.add(new XSDEditFacetAction(this, element));
				}

			}
		}

		if (obj instanceof XSDAnnotation) {
			setAnnotationActions(manager);
		}

		manager.add(new Separator());

		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void setAnnotationActions(IMenuManager manager) {
		manager.add(setAnnotationLabelAction);
		manager.add(setAnnotationDescriptionsAction);
		manager.add(setAnnotationForeignKeyAction);
		manager.add(setAnnotationForeignKeyInfoAction);
		manager.add(setAnnotationWriteAction);
		manager.add(setAnnotationHiddenAction);
		manager.add(setAnnotationTargetSystemsAction);
		manager.add(setAnnotationSourceSystemAction);
		manager.add(setAnnotationDocumentationAction);
	}
	
	private void setAnnotationActions2(IMenuManager manager) {
		manager.add(setAnnotationLabelAction);
		manager.add(setAnnotationDescriptionsAction);
		manager.add(setAnnotationWriteAction);
		manager.add(setAnnotationHiddenAction);
		manager.add(setAnnotationTargetSystemsAction);
		manager.add(setAnnotationSourceSystemAction);
		manager.add(setAnnotationDocumentationAction);
	}

	/**
	 * Returns and XSDSchema Object from an xsd
	 * 
	 * @param schema
	 * @return
	 * @throws Exception
	 */
	public XSDSchema getXSDSchema(String schema) throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		documentBuilderFactory.setValidating(false);
		InputSource source = new InputSource(new StringReader(schema));
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document document = documentBuilder.parse(source);
		return XSDSchemaImpl.createSchema(document.getDocumentElement());
	}

	public TreeViewer getTreeViewer() {
		return viewer;
	}

	/**
	 * We need to override the method so that the schema object is serialized
	 * into xsd an stored in the wsObject via the commit method We also need to
	 * marDirty both Pages The super.markDirty() method will trigger the
	 * appropriate events to the registered listeners
	 */
	@Override
	public void markDirty() {
		//commit();
		super.markDirty();
		DataModelEditorPage editorPage = ((DataModelEditorPage) getEditor()
				.findPage(DataModelEditorPage.class.getName()));
		if (!editorPage.isDirty())
			editorPage.markDirty();
		/*
		 * try { String schema =
		 * ((XSDTreeContentProvider)viewer.getContentProvider
		 * ()).getXSDSchemaAsString(); System.out.println("SCHEMA\n"+schema); }
		 * catch (Exception e) {e.printStackTrace();}
		 */

	}
	
	/**
	 * @author achen
	 */
	private void initializeOperationHistory() {		
		undoContext = new ObjectUndoContext(this);

		int limit = 10;		
		PlatformUI.getWorkbench().getOperationSupport().getOperationHistory().setLimit(undoContext, limit);

		UndoRedoActionGroup undoRedoGroup = new UndoRedoActionGroup(getSite(), undoContext, true);

		
		undoRedoGroup.fillActionBars(getEditorSite().getActionBars());
		
		/*// Install an operation approver for this undo context that prompts
		// according to a user preference.
		operationApprover = new PromptingUserApprover(undoContext);
		getOperationHistory().addOperationApprover(operationApprover);*/
	}

	public ObjectUndoContext getUndoContext() {
		return undoContext;
	}
	
	
}
