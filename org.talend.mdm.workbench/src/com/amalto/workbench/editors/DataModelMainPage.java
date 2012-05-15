// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.editors;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.operations.UndoRedoActionGroup;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.MultiPageEditorSite;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDDiagnostic;
import org.eclipse.xsd.XSDDiagnosticSeverity;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDEnumerationFacet;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDFractionDigitsFacet;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDImport;
import org.eclipse.xsd.XSDInclude;
import org.eclipse.xsd.XSDLengthFacet;
import org.eclipse.xsd.XSDMaxExclusiveFacet;
import org.eclipse.xsd.XSDMaxInclusiveFacet;
import org.eclipse.xsd.XSDMaxLengthFacet;
import org.eclipse.xsd.XSDMinExclusiveFacet;
import org.eclipse.xsd.XSDMinInclusiveFacet;
import org.eclipse.xsd.XSDMinLengthFacet;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDPatternFacet;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSchemaContent;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTotalDigitsFacet;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.XSDWhiteSpaceFacet;
import org.eclipse.xsd.XSDWildcard;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;
import org.eclipse.xsd.impl.XSDComplexTypeDefinitionImpl;
import org.eclipse.xsd.impl.XSDElementDeclarationImpl;
import org.eclipse.xsd.impl.XSDIdentityConstraintDefinitionImpl;
import org.eclipse.xsd.impl.XSDImportImpl;
import org.eclipse.xsd.impl.XSDIncludeImpl;
import org.eclipse.xsd.impl.XSDParticleImpl;
import org.eclipse.xsd.impl.XSDSimpleTypeDefinitionImpl;
import org.eclipse.xsd.impl.XSDXPathDefinitionImpl;
import org.talend.mdm.commmon.util.core.CommonUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.amalto.workbench.actions.XSDAnnotationLookupFieldsAction;
import com.amalto.workbench.actions.XSDChangeBaseTypeAction;
import com.amalto.workbench.actions.XSDChangeToComplexTypeAction;
import com.amalto.workbench.actions.XSDChangeToSimpleTypeAction;
import com.amalto.workbench.actions.XSDCopyConceptAction;
import com.amalto.workbench.actions.XSDDefaultValueRuleAction;
import com.amalto.workbench.actions.XSDDeleteConceptAction;
import com.amalto.workbench.actions.XSDDeleteConceptWrapAction;
import com.amalto.workbench.actions.XSDDeleteElementAction;
import com.amalto.workbench.actions.XSDDeleteIdentityConstraintAction;
import com.amalto.workbench.actions.XSDDeleteParticleAction;
import com.amalto.workbench.actions.XSDDeleteTypeDefinition;
import com.amalto.workbench.actions.XSDDeleteXPathAction;
import com.amalto.workbench.actions.XSDEditComplexTypeAction;
import com.amalto.workbench.actions.XSDEditConceptAction;
import com.amalto.workbench.actions.XSDEditElementAction;
import com.amalto.workbench.actions.XSDEditFacetAction;
import com.amalto.workbench.actions.XSDEditIdentityConstraintAction;
import com.amalto.workbench.actions.XSDEditParticleAction;
import com.amalto.workbench.actions.XSDEditXPathAction;
import com.amalto.workbench.actions.XSDGetXPathAction;
import com.amalto.workbench.actions.XSDNewBrowseItemViewAction;
import com.amalto.workbench.actions.XSDNewComplexTypeDefinition;
import com.amalto.workbench.actions.XSDNewConceptAction;
import com.amalto.workbench.actions.XSDNewElementAction;
import com.amalto.workbench.actions.XSDNewGroupFromTypeAction;
import com.amalto.workbench.actions.XSDNewIdentityConstraintAction;
import com.amalto.workbench.actions.XSDNewParticleFromParticleAction;
import com.amalto.workbench.actions.XSDNewParticleFromTypeAction;
import com.amalto.workbench.actions.XSDNewSimpleTypeDefinition;
import com.amalto.workbench.actions.XSDNewXPathAction;
import com.amalto.workbench.actions.XSDPasteConceptAction;
import com.amalto.workbench.actions.XSDSetAnnotaionDisplayFormatAction;
import com.amalto.workbench.actions.XSDSetAnnotationDescriptionsAction;
import com.amalto.workbench.actions.XSDSetAnnotationFKFilterAction;
import com.amalto.workbench.actions.XSDSetAnnotationForeignKeyAction;
import com.amalto.workbench.actions.XSDSetAnnotationForeignKeyInfoAction;
import com.amalto.workbench.actions.XSDSetAnnotationLabelAction;
import com.amalto.workbench.actions.XSDSetAnnotationNoAction;
import com.amalto.workbench.actions.XSDSetAnnotationPrimaryKeyInfoAction;
import com.amalto.workbench.actions.XSDSetAnnotationWrapNoAction;
import com.amalto.workbench.actions.XSDSetAnnotationWrapWriteAction;
import com.amalto.workbench.actions.XSDSetAnnotationWriteAction;
import com.amalto.workbench.actions.XSDSetFacetMessageAction;
import com.amalto.workbench.actions.XSDVisibleRuleAction;
import com.amalto.workbench.availablemodel.AvailableModelUtil;
import com.amalto.workbench.availablemodel.IAvailableModel;
import com.amalto.workbench.dialogs.DataModelFilterDialog;
import com.amalto.workbench.dialogs.ErrorExceptionDialog;
import com.amalto.workbench.dialogs.RoleAssignmentDialog;
import com.amalto.workbench.dialogs.SelectImportedModulesDialog;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeObjectTransfer;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.ISchemaContentProvider;
import com.amalto.workbench.providers.TypesLabelProvider;
import com.amalto.workbench.providers.XSDTreeLabelProvider;
import com.amalto.workbench.providers.datamodel.SchemaElementSorter;
import com.amalto.workbench.providers.datamodel.SchemaNameFilter;
import com.amalto.workbench.providers.datamodel.SchemaRoleAccessFilter;
import com.amalto.workbench.providers.datamodel.SchemaTreeContentProvider;
import com.amalto.workbench.providers.datamodel.SchemaUniqueElementFilter;
import com.amalto.workbench.providers.datamodel.TypeElementSorter;
import com.amalto.workbench.providers.datamodel.TypeNameFilter;
import com.amalto.workbench.providers.datamodel.TypesTreeContentProvider;
import com.amalto.workbench.utils.CompositeViewersSelectionProvider;
import com.amalto.workbench.utils.DataModelFilter;
import com.amalto.workbench.utils.FontUtils;
import com.amalto.workbench.utils.ResourcesUtil;
import com.amalto.workbench.utils.SchemaElementNameFilterDes;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.WorkbenchClipboard;
import com.amalto.workbench.utils.XSDAnnotationsStructure;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSPutDataModel;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.WidgetFactory;

public class DataModelMainPage extends EditorPart implements ModifyListener {

    public static final String ADDITIONMENUID = "talend.menuadition.datamodel";//$NON-NLS-1$

    private static Log log = LogFactory.getLog(DataModelMainPage.class);

    protected Text descriptionText;

    protected TreeViewer viewer;

    protected DrillDownAdapter drillDownAdapter;

    private XSDNewConceptAction newConceptAction = null;

    private XSDDeleteConceptAction deleteConceptAction = null;

    private XSDDeleteConceptWrapAction deleteConceptWrapAction = null;

    protected XSDNewBrowseItemViewAction newBrowseItemAction = null;

    private XSDNewElementAction newElementAction = null;

    private XSDDeleteElementAction deleteElementAction = null;

    private XSDChangeToComplexTypeAction changeToComplexTypeAction = null;

    private XSDDeleteParticleAction deleteParticleAction = null;

    private XSDNewParticleFromTypeAction newParticleFromTypeAction = null;

    private XSDNewParticleFromParticleAction newParticleFromParticleAction = null;

    private XSDNewGroupFromTypeAction newGroupFromTypeAction = null;

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

    private XSDVisibleRuleAction visibleRuleAction;

    private XSDDefaultValueRuleAction defaultValueRuleAction;

    private XSDSetAnnotationFKFilterAction setAnnotationFKFilterAction = null;

    private XSDSetAnnotationWrapWriteAction setAnnotationWrapWriteAction = null;

    private XSDSetAnnotationForeignKeyInfoAction setAnnotationForeignKeyInfoAction = null;

    private XSDSetAnnotationForeignKeyInfoAction setAnnotationFKIntegrity = null;

    private XSDSetAnnotationForeignKeyInfoAction setAnnotationFKIntegrityOverride = null;

    private XSDSetAnnotationLabelAction setAnnotationLabelAction = null;

    private XSDSetAnnotationDescriptionsAction setAnnotationDescriptionsAction = null;

    private XSDSetAnnotationNoAction setAnnotationNoAction = null;

    private XSDSetAnnotationWrapNoAction setAnnotationWrapNoAction = null;

    private XSDSetAnnotationWriteAction setAnnotationWriteAction = null;

    private XSDAnnotationLookupFieldsAction setAnnotationLookupFieldsAction = null;

    private XSDSetAnnotationPrimaryKeyInfoAction setAnnotationPrimaryKeyInfoAction = null;

    private XSDSetAnnotaionDisplayFormatAction setAnnotationDisplayFomatAction = null;

    private XSDChangeToComplexTypeAction changeSubElementGroupAction = null;

    private XSDDeleteTypeDefinition deleteTypeDefinition = null;

    private XSDNewComplexTypeDefinition newComplexTypeAction = null;

    private XSDNewSimpleTypeDefinition newSimpleTypeAction = null;

    private XSDEditComplexTypeAction editComplexTypeAction = null;

    private XSDSetFacetMessageAction setFacetMsgAction = null;

    private ObjectUndoContext undoContext;

    private MenuManager menuMgr;

    protected String dataModelName;

    protected XSDSchema xsdSchema;

    private SchemaTreeContentProvider schemaTreeContentProvider;

    private Map<ObjectUndoContext, Map<Integer, String>> contextToUndoAction = new HashMap<ObjectUndoContext, Map<Integer, String>>();

    private Map<ObjectUndoContext, Map<Integer, String>> contextToRedoAction = new HashMap<ObjectUndoContext, Map<Integer, String>>();

    private int undoLimit = 20;

    protected DataModelFilter dataModelFilter;

    protected TreeViewer targetTreeViewer;


    private SashForm sash;

    private TreeViewer typesViewer;

    private TypesTreeContentProvider typesTreeContentProvider;

    private MenuManager typesMenuMgr;

    boolean isSchemaSelected = true;

    private String modelName = "";//$NON-NLS-1$

    private boolean isChange = false;



    protected String uriPre;

    private SchemaElementSorter schemaTreeSorter = new SchemaElementSorter();

    private SchemaElementSorter typeTreeSorter = new TypeElementSorter();

    private SchemaElementNameFilterDes schemaElementNameFilterDes = new SchemaElementNameFilterDes();

    private SchemaElementNameFilterDes typeElementNameFilterDes = new SchemaElementNameFilterDes();

    private CompositeViewersSelectionProvider selectionProvider;

    WSDataModel datamodel;

    protected TreeObject xobject;

    boolean dirty;

    Composite mainControl;

    public DataModelMainPage(TreeObject obj) {
        this.xobject = obj;
        this.datamodel = (WSDataModel) obj.getWsObject();
        modelName = datamodel.getName();
        dataModelName = modelName;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
        firePropertyChange(PROP_DIRTY);
    }

    public boolean isSchemaSelected() {
        return isSchemaSelected;
    }

    public void setSchemaSelected(boolean isSchemaSelected) {
        this.isSchemaSelected = isSchemaSelected;
    }

    protected void createCharacteristicsContent(FormToolkit toolkit, Composite mainComposite) {

        try {
            GridLayout layout = new GridLayout();
            layout.verticalSpacing = 0;
            mainComposite.getParent().setLayout(layout);
            GridData gdMainComposite = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
            gdMainComposite.widthHint = 1;
            gdMainComposite.heightHint = 1;
            mainComposite.setLayoutData(gdMainComposite);

            WSDataModel wsObject = (WSDataModel) (xobject.getWsObject());

            // description
            Label descriptionLabel = toolkit.createLabel(mainComposite, Messages.getString("DescriptionText"), SWT.NULL); //$NON-NLS-1$
            descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

            descriptionText = toolkit.createText(mainComposite, "", SWT.BORDER);//$NON-NLS-1$
            descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
            descriptionText.setText(wsObject.getDescription() == null ? "" : wsObject.getDescription());//$NON-NLS-1$
            ((GridData) descriptionText.getLayoutData()).minimumHeight = 30;
            descriptionText.addModifyListener(this);
            Composite btnCmp = toolkit.createComposite(mainComposite);
            btnCmp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
            GridLayout gLayout = new GridLayout();
            gLayout.numColumns = 4;
            gLayout.horizontalSpacing = 20;
            gLayout.verticalSpacing = 0;
            btnCmp.setLayout(gLayout);


            xsdSchema = getXSDSchema(wsObject.getXsdSchema());
            createSash(mainComposite);
            createCompDropTarget();
            hookContextMenu();

            hookDoubleClickAction();
            hookTypesContextMenu();

            // init undo history
            initializeOperationHistory();

        } catch (Exception e) {

            log.error(e.getMessage(), e);
        }

    }// createCharacteristicsContent

    protected void doImportSchema(final List<String> addList, final List<String> delList) {
        TimerTask task = new TimerTask() {

            public void run() {
                getSite().getShell().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        XSDSchema schemaCpy = null;
                        try {
                            schemaCpy = Util.createXsdSchema(Util.nodeToString(xsdSchema.getDocument()), xobject);
                            xsdSchema.clearDiagnostics();
                            performImport(addList);
                            performDeletion(delList);
                            validateSchema();

                            markDirtyWithoutCommit();
                            // refreshData();
                            // below code is to refill the tree view with xsdScham including one xsd schma which
                            // contains the other xsd ,
                            // and in the case of deleting the included xsd
                            setXsdSchema(xsdSchema);
                            commit();
                            refreshData();
                            XSDSchema mc = xsdSchema;
                            MessageDialog.openInformation(getSite().getShell(), Messages.getString("ImportXSDSche"), Messages //$NON-NLS-1$
                                    .getString("ImportingXSDSchemaCompleted")); //$NON-NLS-1$
                        } catch (Exception ex) {
                            log.error(ex.getMessage(), ex);
                            String detail = "";//$NON-NLS-1$
                            if (ex.getMessage() != null && !ex.getMessage().equals("")) {//$NON-NLS-1$
                                detail += " , " + Messages.getString("Dueto") + "\n" + ex.getMessage(); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
                            }
                            setXsdSchema(schemaCpy);
                            commit();
                            refresh();
                            MessageDialog.openError(getSite().getShell(), Messages.getString("Error.title"), Messages //$NON-NLS-1$
                                    .getString("ImportingXSDSchemaFailed") //$NON-NLS-1$
                                    + detail);
                        }
                    }
                });
            }
        };
        Timer timer = new Timer(true);
        timer.schedule(task, 0);

    }

    public void validateSchema() throws IllegalAccessException {
        final String msg_omit[] = { Messages.getString("XsdOmit1"), Messages.getString("XsdOmit2"), //$NON-NLS-1$//$NON-NLS-2$
                Messages.getString("XsdOmit3"), Messages.getString("XsdOmit4"), Messages.getString("XsdOmit5") }; //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$

        final String msg_shouldRefresh[] = { Messages.getString("XsdRefresh"), }; //$NON-NLS-1$

        // do not force to refresh every time just when an error throws.
        String error = validateDiagnoses(msg_omit);
        for (String msg : msg_shouldRefresh) {
            if (error.indexOf(msg) != -1) {
                refreshModelPageSchema();
            }
        }
        // refreshModelPageSchema and validate again
        error = validateDiagnoses(msg_omit);

        if (!error.equals("")) {//$NON-NLS-1$
            throw new IllegalAccessException(error);
        }

        validateType();
        validateElementation();
    }

    private String validateDiagnoses(String msg_omit[]) {

        xsdSchema.clearDiagnostics();
        xsdSchema.getAllDiagnostics().clear();
        xsdSchema.validate();
        EList<XSDDiagnostic> diagnoses = xsdSchema.getAllDiagnostics();
        String error = "";//$NON-NLS-1$
        Set<String> errors = new HashSet<String>();
        for (int i = 0; i < diagnoses.size(); i++) {
            XSDDiagnostic dia = diagnoses.get(i);
            XSDDiagnosticSeverity servity = dia.getSeverity();
            if (servity == XSDDiagnosticSeverity.ERROR_LITERAL || servity == XSDDiagnosticSeverity.FATAL_LITERAL) {
                boolean omit = false;
                for (String msg : msg_omit) {
                    if (dia.getMessage().indexOf(msg) != -1) {
                        omit = true;
                        break;
                    }
                }
                if (!omit && !errors.contains(dia.getMessage())) {
                    error += dia.getMessage() + "\n";//$NON-NLS-1$
                    errors.add(dia.getMessage());
                }
            }
        }

        return error;

    }

    private void refreshModelPageSchema() {

        String content = null;

        try {
            content = Util.nodeToString(xsdSchema.getDocument());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        XSDSchema schema = null;
        try {
            schema = Util.createXsdSchema(content, xobject);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        setXsdSchema(schema);
        getTypeContentProvider().setXsdSchema(schema);
        getSchemaContentProvider().setXsdSchema(schema);
        refresh();

    }

    protected void addOrDelLanguage(boolean isAdd) {
        TreeItem[] items = viewer.getTree().getItems();

        addLabelForTheItem(items, isAdd);
        if (isChange) {
            this.markDirtyWithoutCommit();
            this.refresh();
            // this.getTreeViewer().expandToLevel(xSDCom, 2);
        }

    }

    private void addLabelForTheItem(TreeItem[] items, boolean isAdd) {
        XSDComponent xSDCom = null;
        for (int i = 0; i < items.length; i++) {
            TreeItem item = items[i];
            XSDAnnotationsStructure struc = null;
            String labelValue = null;
            if (item.getData() instanceof XSDElementDeclaration) {
                xSDCom = (XSDElementDeclaration) item.getData();
                struc = new XSDAnnotationsStructure(xSDCom);
                labelValue = ((XSDElementDeclaration) xSDCom).getName();
                setLabel(struc, labelValue, isAdd);
                setLabelForElement((XSDElementDeclaration) xSDCom, isAdd);

            }
        }
    }

    private void setLabelForElement(XSDElementDeclaration xSDEle, boolean isAdd) {
        if (((XSDElementDeclaration) xSDEle).getTypeDefinition() instanceof XSDComplexTypeDefinition) {
            XSDAnnotationsStructure struc = null;
            String labelValue = null;
            List childrenList = Util.getComplexTypeDefinitionChildren((XSDComplexTypeDefinition) ((XSDElementDeclaration) xSDEle)
                    .getTypeDefinition());
            for (int j = 0; j < childrenList.size(); j++) {
                List<XSDParticle> particles = new ArrayList<XSDParticle>();
                if (childrenList.get(j) instanceof XSDModelGroup)
                    particles = ((XSDModelGroup) childrenList.get(j)).getParticles();
                for (int k = 0; k < particles.size(); k++) {
                    XSDParticle xSDCom = particles.get(k);
                    struc = new XSDAnnotationsStructure(xSDCom);
                    if (((XSDParticle) xSDCom).getContent() instanceof XSDElementDeclaration) {
                        labelValue = ((XSDElementDeclaration) ((XSDParticle) xSDCom).getContent()).getName();
                        setLabel(struc, labelValue, isAdd);
                        setLabelForElement((XSDElementDeclaration) ((XSDParticle) xSDCom).getContent(), isAdd);
                    }
                }
            }
        }
    }

    private void setLabel(XSDAnnotationsStructure struc, String labelValue, boolean isAdd) {


    }

    private void createSchemaTreeComp(Composite parent) {

        Composite schemaSash = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.verticalSpacing = 0;
        schemaSash.setLayout(layout);
        schemaSash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        schemaSash.setBackground(sash.getDisplay().getSystemColor(SWT.COLOR_WHITE));

        Composite compInfo = new Composite(schemaSash, SWT.NONE);
        layout = new GridLayout();
        layout.verticalSpacing = 0;
        compInfo.setLayout(layout);
        compInfo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        compInfo.setBackground(sash.getDisplay().getSystemColor(SWT.COLOR_WHITE));

        Composite compSchemaTree = new Composite(schemaSash, SWT.NONE);
        GridLayout glCompSchemaTree = new GridLayout();
        glCompSchemaTree.verticalSpacing = 0;
        glCompSchemaTree.marginWidth = 0;
        glCompSchemaTree.marginHeight = 0;
        glCompSchemaTree.horizontalSpacing = 0;
        compSchemaTree.setLayout(glCompSchemaTree);
        compSchemaTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        compSchemaTree.setBackground(sash.getDisplay().getSystemColor(SWT.COLOR_WHITE));

        Label title = new Label(compInfo, SWT.VERTICAL);
        title.setText(Messages.getString("DataModelEntities")); //$NON-NLS-1$
        title.setFont(FontUtils.getBoldFont(title.getFont()));
        Color blue = new Color(compInfo.getDisplay(), 0, 0, 255);
        title.setForeground(blue);
        title.setBackground(sash.getDisplay().getSystemColor(SWT.COLOR_WHITE));

        ToolBar toolBarSchemaTree = createToolbarOnComposite(compSchemaTree);

        viewer = new TreeViewer(compSchemaTree, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));


        addToolItems2SchemaTreeToolBar(toolBarSchemaTree);
        toolBarSchemaTree.pack();

        drillDownAdapter = new DrillDownAdapter(viewer);
        schemaTreeContentProvider = new SchemaTreeContentProvider(this.getSite(), xsdSchema);
        viewer.setContentProvider(schemaTreeContentProvider);

        viewer.setFilters(new ViewerFilter[] { new SchemaRoleAccessFilter(null), new SchemaNameFilter(),
                new SchemaUniqueElementFilter() });

        viewer.getTree().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent e) {
                isSchemaSelected = true;
            }
        });
        viewer.setLabelProvider(new XSDTreeLabelProvider());
        viewer.setSorter(schemaTreeSorter);
        viewer.setInput(this.getSite());// getViewSite());
        viewer.getTree().addKeyListener(new KeyListener() {

            public void keyPressed(KeyEvent e) {

                IStructuredSelection selection = ((IStructuredSelection) viewer.getSelection());

                // delete
                if ((e.stateMask == 0) && (e.keyCode == SWT.DEL)) {
                    if (deleteConceptWrapAction.checkInDeletableType(selection.toArray())) {
                        deleteConceptWrapAction.prepareToDelSelectedItems(selection, viewer);
                        deleteConceptWrapAction.run();
                    } else {
                        MessageDialog.openWarning(getSite().getShell(), Messages.getString("WarnningText"), Messages //$NON-NLS-1$
                                .getString("SelectDeletableTry")); //$NON-NLS-1$
                    }
                }
            }

            public void keyReleased(KeyEvent e) {

            }

        });

    }

    private EList getXSDComponentContainer(Object data) {
        if (data instanceof XSDConcreteComponent) {
            if (data instanceof XSDParticle) {
                XSDParticle particle = (XSDParticle) data;
                if (particle.getContainer() instanceof XSDModelGroup) {
                    XSDModelGroup mp = (XSDModelGroup) particle.getContainer();
                    return mp.getContents();
                }
            }
            if (data instanceof XSDXPathDefinition) {
                XSDXPathDefinition path = (XSDXPathDefinition) data;
                if (path.getContainer() instanceof XSDIdentityConstraintDefinition) {
                    XSDIdentityConstraintDefinition idDef = (XSDIdentityConstraintDefinition) path.getContainer();
                    return idDef.getFields();
                }
            }
        }
        return null;
    }

    public void stepUp(TreeViewer targetTreeViewer) {
        TreeItem item;
        TreeItem[] items = targetTreeViewer.getTree().getSelection();
        boolean isDirty = false;
        for (int i = 0; i < items.length; i++) {
            item = items[i];
            Object data = item.getData();
            EList content = getXSDComponentContainer(data);
            if (content != null) {
                int index = content.indexOf(data);
                if (index > 0) {
                    content.move(index - 1, index);
                    isDirty = true;
                    this.refresh();
                }
            }
        }
        if (isDirty)
            this.markDirtyWithoutCommit();
    }

    public void stepDown(TreeViewer targetTreeViewer) {
        TreeItem item;
        TreeItem[] items = targetTreeViewer.getTree().getSelection();
        boolean isDirty = false;
        for (int i = items.length - 1; i >= 0; i--) {
            item = items[i];
            Object data = item.getData();
            EList content = getXSDComponentContainer(data);
            if (content != null) {
                int index = content.indexOf(data);
                if (index < content.size() - 1) {
                    content.move(index, index + 1);
                    this.refresh();
                }
            }
        }
        if (isDirty)
            this.markDirtyWithoutCommit();
    }

    public SashForm createSash(Composite parent) {
        // Splitter
        sash = new SashForm(parent, SWT.HORIZONTAL);
        sash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        GridLayout layout = new GridLayout();
        sash.setLayout(layout);
        // create schema tree
        createSchemaTreeComp(sash);
        // create type tree
        createTypeTreeComp(sash);
        // init

        selectionProvider = new CompositeViewersSelectionProvider(new Viewer[] { viewer, typesViewer });

        sash.setWeights(new int[] { 50, 50 });
        return sash;
    }

    public ISelectionProvider getSiteSelectionProvider() {
        return selectionProvider;
    }

    private void createTypeTreeComp(Composite parent) {

        Composite TypeSash = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.verticalSpacing = 0;
        TypeSash.setLayout(layout);
        TypeSash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        TypeSash.setBackground(sash.getDisplay().getSystemColor(SWT.COLOR_WHITE));

        Composite compInfo = new Composite(TypeSash, SWT.NONE);
        layout = new GridLayout();
        layout.verticalSpacing = 0;
        compInfo.setLayout(layout);
        compInfo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        compInfo.setBackground(sash.getDisplay().getSystemColor(SWT.COLOR_WHITE));

        Composite compTypeTree = new Composite(TypeSash, SWT.NONE);
        GridLayout glCompTypeTree = new GridLayout();
        glCompTypeTree.verticalSpacing = 0;
        glCompTypeTree.marginWidth = 0;
        glCompTypeTree.marginHeight = 0;
        glCompTypeTree.horizontalSpacing = 0;
        compTypeTree.setLayout(glCompTypeTree);
        compTypeTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        compTypeTree.setBackground(sash.getDisplay().getSystemColor(SWT.COLOR_WHITE));

        Label title = new Label(compInfo, SWT.VERTICAL);
        title.setText(Messages.getString("DataModelTypes")); //$NON-NLS-1$
        title.setFont(FontUtils.getBoldFont(title.getFont()));
        Color blue = new Color(compInfo.getDisplay(), 0, 0, 255);
        title.setForeground(blue);
        title.setBackground(sash.getDisplay().getSystemColor(SWT.COLOR_WHITE));

        ToolBar toolBarTypeTree = createToolbarOnComposite(compTypeTree);

        typesViewer = new TreeViewer(compTypeTree, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        typesViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        addToolItems2TypeTreeToolBar(toolBarTypeTree);
        toolBarTypeTree.pack();

        typesTreeContentProvider = new TypesTreeContentProvider(this.getSite(), xsdSchema);
        typesViewer.setContentProvider(typesTreeContentProvider);

        typesViewer.setFilters(new ViewerFilter[] { new SchemaRoleAccessFilter(null), new TypeNameFilter() });

        typesViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent e) {

            }
        });
        typesViewer.getTree().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent e) {
                isSchemaSelected = false;
            }
        });
        typesViewer.setLabelProvider(new TypesLabelProvider());
        typesViewer.setSorter(typeTreeSorter);

        typesViewer.setInput(this.getSite());// getViewSite());
        typesViewer.getTree().addKeyListener(new KeyListener() {

            public void keyPressed(KeyEvent e) {

                IStructuredSelection selection = ((IStructuredSelection) typesViewer.getSelection());

                // delete
                if ((e.stateMask == 0) && (e.keyCode == SWT.DEL)) {

                    deleteConceptWrapAction.regisExtraClassToDel(XSDComplexTypeDefinitionImpl.class);
                    if (deleteConceptWrapAction.checkInDeletableType(selection.toArray())) {
                        deleteConceptWrapAction.prepareToDelSelectedItems(selection, viewer);
                        deleteConceptWrapAction.run();
                    } else {
                        deleteConceptWrapAction.clearExtraClassToDel();
                        deleteConceptWrapAction.regisExtraClassToDel(XSDSimpleTypeDefinitionImpl.class);
                        if (deleteConceptWrapAction.checkInDeletableType(selection.toArray())) {
                            deleteConceptWrapAction.prepareToDelSelectedItems(selection, viewer);
                            deleteConceptWrapAction.run();
                        } else {
                            MessageDialog.openWarning(getSite().getShell(), Messages.getString("WarnningText"), Messages //$NON-NLS-1$
                                    .getString("SelectDeletableTry")); //$NON-NLS-1$
                        }
                    }
                }
            }

            public void keyReleased(KeyEvent e) {

            }

        });

    }

    public void refreshData() {
        try {

            WSDataModel wsObject = (WSDataModel) (xobject.getWsObject());
            String s;
            s = wsObject.getDescription() == null ? "" : wsObject.getDescription();//$NON-NLS-1$
            if (!s.equals(descriptionText.getText()))
                descriptionText.setText(s);
            String schema = Util.formatXsdSource(wsObject.getXsdSchema());

            XSDSchema xsd = Util.createXsdSchema(schema, xobject);
            schemaTreeContentProvider.setXsdSchema(xsd);
            getSchemaRoleFilterFromSchemaTree().setDataModelFilter(dataModelFilter);
            viewer.setInput(getSite());
            // refresh types

            typesTreeContentProvider.setXsdSchema(xsd);
            typesViewer.setInput(getSite());
            reConfigureXSDSchema(true);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            ErrorExceptionDialog.openError(this.getSite().getShell(), "Error refreshing the page", "Error refreshing the page: " //$NON-NLS-1$//$NON-NLS-2$
                    + e.getLocalizedMessage());
        }
    }

    public void SaveWithForce(IProgressMonitor monitor) {
        doSave(monitor);
    }

    public int save(String xsd) {
        try {
            WSDataModel wsObject = (WSDataModel) (xobject.getWsObject());
            wsObject.setDescription(descriptionText.getText() == null ? "" : descriptionText.getText());//$NON-NLS-1$
            String schema = xsd;
            if (xsd == null) {
                schema = ((SchemaTreeContentProvider) viewer.getContentProvider()).getXSDSchemaAsString();
                xsdSchema = ((SchemaTreeContentProvider) viewer.getContentProvider()).getXsdSchema();
            }
            XSDImport xsdImport = XSDFactory.eINSTANCE.createXSDImport();
            xsdImport.setNamespace("http://www.w3.org/2001/XMLSchema");//$NON-NLS-1$
            if (xsdSchema == null) {
                xsdSchema = ((SchemaTreeContentProvider) viewer.getContentProvider()).getXsdSchema();

            }
            if (xsdSchema == null || (xsd != null && !xsd.equals(wsObject.getXsdSchema())))
                xsdSchema = Util.createXsdSchema(schema, xobject);
            wsObject.setXsdSchema(schema);

            EList<XSDSchemaContent> elist = xsdSchema.getContents();
            for (XSDSchemaContent cnt : elist) {
                if (cnt instanceof XSDImport) {
                    XSDImport imp = (XSDImport) cnt;
                    if (imp.getNamespace().equals("http://www.w3.org/2001/XMLSchema")) {//$NON-NLS-1$
                        xsdImport = null;
                        break;
                    }
                }
            }
            if (xsdImport != null) {
                xsdSchema.getContents().add(0, xsdImport);
                wsObject.setXsdSchema(schema);
            }
            validateSchema();

            // save to db
            doSave(wsObject);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            ErrorExceptionDialog.openError(this.getSite().getShell(), Messages.getString("ErrorCommittingPage"), //$NON-NLS-1$
                    CommonUtil.getErrMsgFromException(e));
            return 1;
        }
        dirty = false;
        firePropertyChange(PROP_DIRTY);
        return 0;
    }

    protected void doSave(WSDataModel wsObject) throws Exception {
        XtentisPort port = Util.getPort(new URL(xobject.getEndpointAddress()), xobject.getUniverse(), xobject.getUsername(),
                xobject.getPassword());
        port.putDataModel(new WSPutDataModel((WSDataModel) wsObject));
        RoleAssignmentDialog.doSave(port, ((WSDataModel) wsObject).getName(), Messages.getString("DataModelText")); //$NON-NLS-1$
    }

    protected void commit() {
        save(null);
    }

    protected void createActions() {
        this.newConceptAction = new XSDNewConceptAction(this);
        this.deleteConceptAction = (XSDDeleteConceptAction) getAdapter(XSDDeleteConceptAction.class);
        createNewBrowseItemViewAction();
        this.deleteConceptWrapAction = new XSDDeleteConceptWrapAction(this);
        this.newElementAction = new XSDNewElementAction(this);
        this.deleteElementAction = new XSDDeleteElementAction(this);
        this.changeToComplexTypeAction = new XSDChangeToComplexTypeAction(this, false);
        this.changeSubElementGroupAction = new XSDChangeToComplexTypeAction(this, true);
        this.deleteParticleAction = new XSDDeleteParticleAction(this);
        this.newParticleFromTypeAction = new XSDNewParticleFromTypeAction(this);
        this.newParticleFromParticleAction = new XSDNewParticleFromParticleAction(this);
        this.newGroupFromTypeAction = new XSDNewGroupFromTypeAction(this);

        this.editParticleAction = new XSDEditParticleAction(this);
        this.editConceptAction = new XSDEditConceptAction(this);
        this.editElementAction = new XSDEditElementAction(this);
        this.deleteIdentityConstraintAction = new XSDDeleteIdentityConstraintAction(this);
        this.editIdentityConstraintAction = new XSDEditIdentityConstraintAction(this);
        this.newIdentityConstraintAction = new XSDNewIdentityConstraintAction(this);
        this.deleteXPathAction = new XSDDeleteXPathAction(this);
        this.newXPathAction = new XSDNewXPathAction(this);
        this.editXPathAction = new XSDEditXPathAction(this);
        this.changeToSimpleTypeAction = new XSDChangeToSimpleTypeAction(this);
        this.changeBaseTypeAction = new XSDChangeBaseTypeAction(this);
        this.getXPathAction = new XSDGetXPathAction(this);
        this.setAnnotationLabelAction = new XSDSetAnnotationLabelAction(this);
        this.setAnnotationDescriptionsAction = new XSDSetAnnotationDescriptionsAction(this);
        this.setAnnotationForeignKeyAction = (XSDSetAnnotationForeignKeyAction) getAdapter(XSDSetAnnotationForeignKeyAction.class);
        visibleRuleAction = (XSDVisibleRuleAction) getAdapter(XSDVisibleRuleAction.class);
        defaultValueRuleAction = (XSDDefaultValueRuleAction) getAdapter(XSDDefaultValueRuleAction.class);
        this.setAnnotationFKFilterAction = (XSDSetAnnotationFKFilterAction) getAdapter(XSDSetAnnotationFKFilterAction.class);
        this.setAnnotationForeignKeyInfoAction = (XSDSetAnnotationForeignKeyInfoAction) getAdapter(XSDSetAnnotationForeignKeyInfoAction.class);
        this.setAnnotationWriteAction = (XSDSetAnnotationWriteAction) getAdapter(XSDSetAnnotationWriteAction.class);
        this.setAnnotationWrapWriteAction = (XSDSetAnnotationWrapWriteAction) getAdapter(XSDSetAnnotationWrapWriteAction.class);
        this.setAnnotationNoAction = (XSDSetAnnotationNoAction) getAdapter(XSDSetAnnotationNoAction.class);
        this.setAnnotationWrapNoAction = (XSDSetAnnotationWrapNoAction) getAdapter(XSDSetAnnotationWrapNoAction.class);

        this.setAnnotationDisplayFomatAction = new XSDSetAnnotaionDisplayFormatAction(this);
        this.setAnnotationLookupFieldsAction = new XSDAnnotationLookupFieldsAction(this);
        this.setAnnotationPrimaryKeyInfoAction = new XSDSetAnnotationPrimaryKeyInfoAction(this);

        this.deleteTypeDefinition = new XSDDeleteTypeDefinition(this);
        this.newComplexTypeAction = new XSDNewComplexTypeDefinition(this);
        this.newSimpleTypeAction = new XSDNewSimpleTypeDefinition(this);

        this.editComplexTypeAction = new XSDEditComplexTypeAction(this);
        this.setFacetMsgAction = new XSDSetFacetMessageAction(this);
        deleteConceptWrapAction.regisDelAction(XSDElementDeclarationImpl.class, deleteConceptAction);
        deleteConceptWrapAction.regisDelAction(XSDParticleImpl.class, deleteParticleAction);
        deleteConceptWrapAction.regisDelAction(XSDIdentityConstraintDefinitionImpl.class, deleteIdentityConstraintAction);
        deleteConceptWrapAction.regisDelAction(XSDXPathDefinitionImpl.class, deleteXPathAction);
        deleteConceptWrapAction.regisDelAction(null, deleteElementAction);
        deleteConceptWrapAction.regisDelAction(XSDComplexTypeDefinitionImpl.class, deleteTypeDefinition);
        deleteConceptWrapAction.regisDelAction(XSDSimpleTypeDefinitionImpl.class, deleteTypeDefinition);
    }

    protected void createNewBrowseItemViewAction() {
        this.newBrowseItemAction = new XSDNewBrowseItemViewAction(this);
    }

    private int getElementType(Object decl) {

        if (Util.getParent(decl) == decl) {
            if (Util.checkConcept((XSDElementDeclaration) decl)) {
                return 0;
            }
            return 1;
        }
        if (decl instanceof XSDComplexTypeDefinition)
            return 2;
        if (decl instanceof XSDIdentityConstraintDefinition)
            return 3;
        if (decl instanceof XSDXPathDefinition)
            return 4;
        if (decl instanceof XSDSimpleTypeDefinition)
            return 5;
        if (decl instanceof XSDAnnotation)
            return 6;
        if (decl instanceof XSDParticle)
            return 7;
        if (decl instanceof XSDModelGroup)
            return 8;
        if (decl instanceof XSDWhiteSpaceFacet)
            return 201;
        if (decl instanceof XSDLengthFacet)
            return 202;
        if (decl instanceof XSDMinLengthFacet)
            return 203;
        if (decl instanceof XSDMaxLengthFacet)
            return 204;
        if (decl instanceof XSDTotalDigitsFacet)
            return 205;
        if (decl instanceof XSDFractionDigitsFacet)
            return 206;
        if (decl instanceof XSDMaxInclusiveFacet)
            return 207;
        if (decl instanceof XSDMaxExclusiveFacet)
            return 208;
        if (decl instanceof XSDMinInclusiveFacet)
            return 209;
        if (decl instanceof XSDMinExclusiveFacet)
            return 210;
        if (decl instanceof XSDPatternFacet)
            return 211;
        if (decl instanceof XSDEnumerationFacet)
            return 212;
        if (decl instanceof Element) {
            Element e = (Element) decl;
            if (e.getLocalName().equals("appinfo")) {//$NON-NLS-1$
            }
            String source = e.getAttribute("source");//$NON-NLS-1$
            if (source != null) {
                if (source.startsWith("X_Label_")) {//$NON-NLS-1$
                    return 101;
                } else if (source.equals("X_ForeignKey")) {//$NON-NLS-1$
                    return 102;
                } else if (source.equals("X_ForeignKeyInfo")) {//$NON-NLS-1$
                    return 103;
                } else if (source.equals("X_SourceSystem")) {//$NON-NLS-1$
                    return 104;
                } else if (source.equals("X_TargetSystem")) {//$NON-NLS-1$
                    return 105;
                } else if (source.startsWith("X_Description_")) {//$NON-NLS-1$
                    return 106;
                } else if (source.equals("X_Write")) {//$NON-NLS-1$
                    return 107;
                } else if (source.equals("X_Hide")) {//$NON-NLS-1$
                    return 108;
                } else if (source.equals("X_Schematron")) {//$NON-NLS-1$
                    return 109;
                } else if (source.startsWith("X_Facet_")) {//$NON-NLS-1$
                    return 110;
                } else if (source.startsWith("X_Workflow")) {//$NON-NLS-1$
                    return 111;
                } else if (source.startsWith("X_ForeignKey_Filter")) {//$NON-NLS-1$
                    return 112;
                } else if (source.startsWith("X_Display_Format_")) {//$NON-NLS-1$
                    return 113;
                } else if (source.equals("X_Lookup_Field")) {//$NON-NLS-1$
                    return 114;
                } else if (source.equals("X_PrimaryKeyInfo")) {//$NON-NLS-1$
                    return 115;
                } else if (source.equals("X_Visible_Rule")) {//$NON-NLS-1$
                    return 116;
                } else if (source.equals("X_Default_Value_Rule")) {//$NON-NLS-1$
                    return 117;
                } else if (source.equals("X_Deny_Create")) {//$NON-NLS-1$
                    return 118;
                } else if (source.equals("X_Deny_PhysicalDelete")) {//$NON-NLS-1$
                    return 119;
                } else if (source.equals("X_Deny_LogicalDelete")) {//$NON-NLS-1$
                    return 120;
                } else if (source.equals("X_FKIntegrity")) {//$NON-NLS-1$
                    return 121;
                } else if (source.equals("X_FKIntegrity_Override")) {//$NON-NLS-1$
                    return 122;
                }
            }

        }
        return -1;
    }

    private void hookDoubleClickAction() {
        viewer.addDoubleClickListener(new DoubleClickListener(viewer) {
        });
        typesViewer.addDoubleClickListener(new DoubleClickListener(typesViewer) {
        });
    }

    protected void initxsdEditFacetAction(String element) {
        new XSDEditFacetAction(this, element).run();

    }

    private void hookContextMenu() {
        menuMgr = new MenuManager();
        menuMgr.setRemoveAllWhenShown(true);
        menuMgr.addMenuListener(new IMenuListener() {

            public void menuAboutToShow(IMenuManager manager) {
                DataModelMainPage.this.fillContextMenu(manager, false);
            }
        });
        Menu menu = menuMgr.createContextMenu(viewer.getControl());
        viewer.getControl().setMenu(menu);
    }

    private void hookTypesContextMenu() {
        typesMenuMgr = new MenuManager();
        typesMenuMgr.setRemoveAllWhenShown(true);
        typesMenuMgr.addMenuListener(new IMenuListener() {

            public void menuAboutToShow(IMenuManager manager) {
                DataModelMainPage.this.fillContextMenu(manager, true);
            }
        });
        Menu menu = typesMenuMgr.createContextMenu(typesViewer.getControl());
        typesViewer.getControl().setMenu(menu);
    }

    protected void fillContextMenu(IMenuManager manager, boolean isType) {

        IStructuredSelection selection;
        if (!isType)
            selection = ((IStructuredSelection) viewer.getSelection());
        else
            selection = ((IStructuredSelection) typesViewer.getSelection());

        Object[] selectedObjs = selection.toArray();
        Object obj = selection.getFirstElement();

        if (!isType)
            manager.add(newConceptAction);
        else {
            manager.add(newComplexTypeAction);
            manager.add(newSimpleTypeAction);
            // add by ymli; fix the bug:0012228. Made the multiple types can be deleted.
            XSDDeleteTypeDefinition deleteTypeDefinition1;
            if (selectedObjs.length > 1)
                deleteTypeDefinition1 = new XSDDeleteTypeDefinition(this, true);
            else
                deleteTypeDefinition1 = new XSDDeleteTypeDefinition(this, false);
            if (selectedObjs.length >= 1 && deleteTypeDefinition1.isTypeDefinition(selectedObjs))
                manager.add(deleteTypeDefinition1);

            deleteConceptWrapAction.regisExtraClassToDel(XSDComplexTypeDefinitionImpl.class);

            if (selectedObjs.length > 1 && deleteConceptWrapAction.checkInDeletableType(selectedObjs)) {
                deleteConceptWrapAction.prepareToDelSelectedItems(selection, viewer);
            }

            if (selectedObjs.length > 1 && deleteConceptWrapAction.outPutDeleteActions() != null) {
                manager.add(deleteConceptWrapAction.outPutDeleteActions());

                if (deleteConceptWrapAction.checkOutAllConcept(selectedObjs))
                    manager.add(newBrowseItemAction);
            }
            if (Util.IsEnterPrise() && obj instanceof XSDComplexTypeDefinition && selectedObjs.length == 1) {
                manager.add(new Separator());
                manager.add(setAnnotationWriteAction);
                manager.add(setAnnotationNoAction);
            }
        }
        manager.add(new Separator());
        if ((selection == null) || (selection.getFirstElement() == null)) {
            manager.add(new Separator(ADDITIONMENUID));
            // add by ymli, fix bug 0009770
            String title = "";//$NON-NLS-1$
            if (WorkbenchClipboard.getWorkbenchClipboard().getConcepts().size() == 1)
                title = Messages.getString("PasteEntityText"); //$NON-NLS-1$
            else if (WorkbenchClipboard.getWorkbenchClipboard().getConcepts().size() > 1)
                title = Messages.getString("PasteEntitiesText"); //$NON-NLS-1$

            XSDPasteConceptAction pasteConceptAction = new XSDPasteConceptAction(this, title);
            if (pasteConceptAction.checkInPasteType()) {
                manager.add(new Separator());
                manager.add(pasteConceptAction);
            }
            return;
        }

        // Element Declaration
        if (obj instanceof XSDElementDeclaration && selectedObjs.length == 1) {
            // check if concept or "just" element

            XSDElementDeclaration decl = (XSDElementDeclaration) obj;
            boolean isConcept = Util.checkConcept(decl);
            if (!Util.IsAImporedElement(decl, xsdSchema)) {
                if (isConcept) {
                    manager.add(editConceptAction);
                    manager.add(deleteConceptAction);
                    manager.add(newBrowseItemAction);
                } else {
                    manager.add(editElementAction);
                    manager.add(deleteElementAction);
                }

                // add by ymli. fix bug 0009770 add the copy of concepts
                XSDCopyConceptAction copyConceptAction = new XSDCopyConceptAction(this, Messages.getString("CopyEntityText")); //$NON-NLS-1$
                if (Util.checkInCopy(selectedObjs)) {
                    manager.add(new Separator());
                    manager.add(copyConceptAction);

                }
                /*
                 * boolean isMulti = false; if(WorkbenchClipboard.getWorkbenchClipboard().getConcepts().size()>1)
                 * isMulti = true;
                 */
                String title = "";//$NON-NLS-1$
                if (WorkbenchClipboard.getWorkbenchClipboard().getConcepts().size() > 1)
                    title = Messages.getString("PasteEntitiesText"); //$NON-NLS-1$
                else if (WorkbenchClipboard.getWorkbenchClipboard().getConcepts().size() == 1)
                    title = Messages.getString("PasteEntityText"); //$NON-NLS-1$
                else if (WorkbenchClipboard.getWorkbenchClipboard().getParticles().size() > 1)
                    title = Messages.getString("PasteElementsText"); //$NON-NLS-1$
                else if (WorkbenchClipboard.getWorkbenchClipboard().getParticles().size() == 1)
                    title = Messages.getString("PasteElement"); //$NON-NLS-1$

                XSDPasteConceptAction pasteConceptAction = new XSDPasteConceptAction(this, title);
                if (pasteConceptAction.checkInPasteType())
                    manager.add(pasteConceptAction);

                manager.add(new Separator());
                manager.add(newElementAction);
                manager.add(new Separator());
                manager.add(changeToComplexTypeAction);
                manager.add(changeToSimpleTypeAction);
                // add by fliu, see bugID:0009157
                if (((XSDElementDeclaration) obj).getTypeDefinition() instanceof XSDSimpleTypeDefinition) {
                    manager.add(setFacetMsgAction);
                    manager.add(setAnnotationDisplayFomatAction);
                }
                manager.add(new Separator());
                manager.add(newIdentityConstraintAction);
            } else {
                if (isConcept) {
                    manager.add(newBrowseItemAction);
                }
                manager.add(newElementAction);
            }

            // Annotations
            if (!Util.IsAImporedElement(decl, xsdSchema) || !Util.IsAImporedElement(decl.getTypeDefinition(), xsdSchema))
                setAnnotationActions2(obj, manager);
        }
        // add by rhou.fix bug 0012073: Enable to create element from sub element group
        if (obj instanceof XSDModelGroup) {
            manager.add(new Separator());
            manager.add(newParticleFromTypeAction);
            manager.add(new Separator());
            manager.add(changeSubElementGroupAction);
        }

        if (obj instanceof XSDParticle && selectedObjs.length == 1) {
            XSDTerm term = ((XSDParticle) obj).getTerm();
            if (!(term instanceof XSDWildcard)) {
                if (term instanceof XSDElementDeclaration) {
                    manager.add(editParticleAction);
                    if (!Util.IsAImporedElement(term, xsdSchema) || term.getContainer() instanceof XSDSchema) {
                        manager.add(newParticleFromParticleAction);
                        if (term instanceof XSDModelGroup) {
                            manager.add(newParticleFromTypeAction);
                            manager.add(newGroupFromTypeAction);
                        }
                        manager.add(deleteParticleAction);
                        // edit by ymli. fix the bug:0011523
                        XSDCopyConceptAction copyConceptAction = new XSDCopyConceptAction(this, Messages
                                .getString("CopyElementText")); //$NON-NLS-1$
                        manager.add(copyConceptAction);

                        manager.add(new Separator());
                        manager.add(changeToComplexTypeAction);
                        manager.add(changeToSimpleTypeAction);
                        // add by fliu, see bugID:0009157

                        manager.add(new Separator());
                        if (term instanceof XSDElementDeclaration) {
                            // Annotations
                            XSDTypeDefinition type = ((XSDElementDeclaration) term).getTypeDefinition();
                            setAnnotationActions(obj, manager);
                            // }
                            if (((XSDElementDeclaration) term).getTypeDefinition() instanceof XSDSimpleTypeDefinition) {
                                manager.add(setFacetMsgAction);
                                manager.add(setAnnotationDisplayFomatAction);
                            }
                            // Xpath
                            manager.add(new Separator());
                            manager.add(getXPathAction);

                        }
                    }
                }
            }
        }

        if (obj instanceof XSDComplexTypeDefinition && selectedObjs.length == 1
                && ((XSDComplexTypeDefinition) obj).getTargetNamespace() == null) {
            if (!isType && !Util.IsAImporedElement((XSDParticle) obj, xsdSchema)) {
                manager.add(newParticleFromTypeAction);
                manager.add(newGroupFromTypeAction);
            }
            String ns = ((XSDComplexTypeDefinition) obj).getTargetNamespace();
            if (ns == null && !Util.IsAImporedElement((XSDComplexTypeDefinition) obj, xsdSchema)) {
                // add by rhou.fix bug 0012073: Enable to create element from sub element group
                manager.add(new Separator());
                manager.add(newParticleFromTypeAction);
                manager.add(new Separator());
                manager.add(editComplexTypeAction);
            }
            XSDPasteConceptAction pasteConceptAction = new XSDPasteConceptAction(this, "Paste Element"); //$NON-NLS-1$
            manager.add(pasteConceptAction);
        }

        if (obj instanceof XSDIdentityConstraintDefinition && selectedObjs.length == 1
                && ((XSDIdentityConstraintDefinition) obj).getTargetNamespace() == null
                && !Util.IsAImporedElement((XSDIdentityConstraintDefinition) obj, xsdSchema)) {
            manager.add(editIdentityConstraintAction);
            manager.add(deleteIdentityConstraintAction);
            manager.add(newIdentityConstraintAction);
            manager.add(new Separator());
            manager.add(newXPathAction);
        }

        if (obj instanceof XSDXPathDefinition && selectedObjs.length == 1
                && ((XSDXPathDefinition) obj).getSchema().getTargetNamespace() == null
                && !Util.IsAImporedElement((XSDXPathDefinition) obj, xsdSchema)) {
            manager.add(editXPathAction);
            manager.add(newXPathAction);
            XSDXPathDefinition xpath = (XSDXPathDefinition) obj;
            if (xpath.getVariety().equals(XSDXPathVariety.FIELD_LITERAL))
                manager.add(deleteXPathAction);
        }
        // for the anonymous simpleType
        if (obj instanceof XSDSimpleTypeDefinition
                && selectedObjs.length == 1
                && (!Util.IsAImporedElement((XSDSimpleTypeDefinition) obj, xsdSchema) || ((XSDSimpleTypeDefinition) obj)
                        .getName() == null)) {
            XSDSimpleTypeDefinition typedef = (XSDSimpleTypeDefinition) obj;


            manager.add(changeBaseTypeAction);
            manager.add(new Separator());
            if (typedef.getBaseTypeDefinition() != null) {
                EList list = typedef.getBaseTypeDefinition().getValidFacets();
                for (Iterator iter = list.iterator(); iter.hasNext();) {
                    String element = (String) iter.next();
                    manager.add(new XSDEditFacetAction(this, element));
                }
            }

        }


        if (selectedObjs.length > 1 && deleteConceptWrapAction.checkInDeletableType(selectedObjs)) {
            deleteConceptWrapAction.prepareToDelSelectedItems(selection, viewer);
        }

        if (selectedObjs.length > 1 && deleteConceptWrapAction.checkInAllElementType(selectedObjs)) {
            manager.add(newBrowseItemAction);
        }

        if (selectedObjs.length > 1 && deleteConceptWrapAction.outPutDeleteActions() != null) {

            if (!isType)
                manager.add(deleteConceptWrapAction.outPutDeleteActions());

            String title = "";//$NON-NLS-1$
            if (Util.checkInCopyTypeElement(selectedObjs))
                title = Messages.getString("CopyEntitiesText"); //$NON-NLS-1$
            else if (Util.checkInCOpyTypeParticle(selectedObjs))
                title = Messages.getString("CopyElements"); //$NON-NLS-1$
            XSDCopyConceptAction copyConceptAction = new XSDCopyConceptAction(this, title);

            if (Util.checkInCopy(selectedObjs)) {
                manager.add(copyConceptAction);

            }
            // add by ymli; fix bug:0016645
            if (selectedObjs.length > 1 && isXSDParticles(selectedObjs)) {
                manager.add(newParticleFromParticleAction);
            }


        }

        // add by ymli. fix bug 0009771
        if (Util.IsEnterPrise()) {
            if (selectedObjs.length > 1 && setAnnotationWrapWriteAction.checkInWriteType(selectedObjs)) {
                manager.add(new Separator());
                manager.add(setAnnotationWrapWriteAction);
                // fix bug 0016982: Set role with no access, and Set the workflow access menu actions action are gone
                manager.add(setAnnotationWrapNoAction);
            }
        }
        // available models
        java.util.List<IAvailableModel> availablemodels = AvailableModelUtil.getAvailableModels(isLocalInput());
        for (int i = 0; i < availablemodels.size(); i++) {
            IAvailableModel model = availablemodels.get(i);
            model.fillContextMenu(obj, manager, this, dataModelName);
            if (i == 1) {
                manager.add(new Separator());
            }
        }

        manager.add(new Separator());

        drillDownAdapter.addNavigationActions(manager);
        // Other plug-ins can contribute there actions here
        manager.add(new Separator(ADDITIONMENUID));
        deleteConceptWrapAction.clearExtraClassToDel();
    }

    private void setAnnotationActions(Object obj, IMenuManager manager) {

        if (obj instanceof XSDElementDeclaration) {
            manager.add(setAnnotationDescriptionsAction);
            manager.add(setAnnotationLookupFieldsAction);
            manager.add(setAnnotationPrimaryKeyInfoAction);
        }
        if (obj instanceof XSDParticle) {
            manager.add(setAnnotationDescriptionsAction);
            manager.add(setAnnotationLabelAction);
            manager.add(setAnnotationForeignKeyAction);
            manager.add(setAnnotationFKFilterAction);
            manager.add(setAnnotationForeignKeyInfoAction);
        }
        if (Util.IsEnterPrise()) {
            manager.add(new Separator());
            manager.add(setAnnotationWriteAction);
            // fix bug 0016982: Set role with no access, and Set the workflow access menu actions action are gone
            manager.add(setAnnotationNoAction);

            if (obj instanceof XSDParticle) {
                XSDAnnotationsStructure struc = getStructureByActiveItem();
                manager.add(visibleRuleAction);
                if (struc != null){

                    if (struc.getVisibleRule() != null) {
                        XSDVisibleRuleAction deleteVisibleRuleAction = new XSDVisibleRuleAction(this, dataModelName, true);
                        manager.add(deleteVisibleRuleAction);
                    }
                }
                // fix bug TMDM-3141: the defaultValueRule entry of UUID/AUTO_INCREMENT field should be readOnly
                boolean enabled = !isAutoGeneratedType((XSDParticle) obj);
                manager.add(defaultValueRuleAction);
                defaultValueRuleAction.setEnabled(enabled);
                if (struc != null) {
                    if (struc.getDefaultValueRule() != null) {
                        XSDDefaultValueRuleAction deleteDefaultRuleAction = new XSDDefaultValueRuleAction(this, dataModelName,
                                true);
                        manager.add(deleteDefaultRuleAction);
                        deleteDefaultRuleAction.setEnabled(enabled);
                    }
                }
            }
        }
        // available models
        java.util.List<IAvailableModel> availablemodels = AvailableModelUtil.getAvailableModels(isLocalInput());
        for (int i = 0; i < availablemodels.size(); i++) {
            IAvailableModel model = availablemodels.get(i);
            model.fillContextMenu(obj, manager, this, dataModelName);
            if (i == 1) {
                manager.add(new Separator());
            }
        }

    }

    /**
     * check whether the model field is UUID or AUTO_INCREMENT type.
     * 
     * @param obj
     * @return
     */
    private boolean isAutoGeneratedType(XSDParticle obj) {
        XSDTerm xsdTerm = obj.getTerm();
        if (xsdTerm != null && xsdTerm instanceof XSDElementDeclaration) {
            XSDElementDeclaration element = (XSDElementDeclaration) xsdTerm;
            if (Util.isUUID(element))
                return true;
        }
        return false;
    }

    private void setAnnotationActions2(Object obj, IMenuManager manager) {

        if (obj instanceof XSDElementDeclaration) {
            manager.add(setAnnotationLabelAction);
            manager.add(setAnnotationDescriptionsAction);
            manager.add(setAnnotationLookupFieldsAction);
            manager.add(setAnnotationPrimaryKeyInfoAction);
        }

        if (obj instanceof XSDParticle) {
            manager.add(setAnnotationDescriptionsAction);
            manager.add(setAnnotationLabelAction);
        }
        if (Util.IsEnterPrise()) {
            manager.add(new Separator());
            manager.add(setAnnotationWriteAction);
            // fix bug 0016982: Set role with no access, and Set the workflow access menu actions action are gone
            manager.add(setAnnotationNoAction);
            if (obj instanceof XSDParticle) {
                manager.add(visibleRuleAction);
                manager.add(defaultValueRuleAction);
                // fix bug TMDM-3141: the defaultValueRule entry of UUID/AUTO_INCREMENT field should be readOnly
                defaultValueRuleAction.setEnabled(!isAutoGeneratedType((XSDParticle) obj));
            }
        }
        // available models
        java.util.List<IAvailableModel> availablemodels = AvailableModelUtil.getAvailableModels(isLocalInput());
        for (int i = 0; i < availablemodels.size(); i++) {
            IAvailableModel model = availablemodels.get(i);
            model.fillContextMenu(obj, manager, this, dataModelName);
            if (i == 1) {
                manager.add(new Separator());
            }
        }

    }

    private boolean checkMandatoryElement(Object obj) {
        if (obj instanceof XSDParticle)
            if (((XSDParticle) obj).getMinOccurs() > 0)
                return false;
        return true;

    }

    private boolean checkMandatoryElement(Object[] objArray) {
        for (Object obj : objArray) {
            if (obj instanceof XSDParticle)
                if (((XSDParticle) obj).getMinOccurs() > 0)
                    return false;
                else
                    continue;

        }
        return true;

    }

    /**
     * @author ymli
     * @param objArray check if all the elements of objArray are XSDParticle
     * @return
     */
    private boolean isXSDParticles(Object[] objArray) {
        for (Object obj : objArray) {
            if (!(obj instanceof XSDParticle)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns and XSDSchema Object from an xsd
     * 
     * @param schema
     * @return
     * @throws Exception
     */
    public XSDSchema getXSDSchema(String schema) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setValidating(false);
        InputSource source = new InputSource(new StringReader(schema));
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(source);

        if (xsdSchema == null) {
            xsdSchema = Util.createXsdSchema(schema, xobject);
        } else {
            xsdSchema.setDocument(document);
        }

        return xsdSchema;
    }

    public XSDSchema getXSDSchema() {
        return xsdSchema;
    }

    public String getXSDSchemaString() throws Exception {
        return ((SchemaTreeContentProvider) viewer.getContentProvider()).getXSDSchemaAsString();
    }

    public TreeViewer getTreeViewer() {
        if (isSchemaSelected) {
            return viewer;
        } else {
            return typesViewer;
        }
    }

    public TreeViewer getElementsViewer() {
        return viewer;
    }

    public TreeViewer getTypesViewer() {
        return typesViewer;
    }

    public void setXsdSchema(XSDSchema xsd) {
        ((ISchemaContentProvider) viewer.getContentProvider()).setXsdSchema(xsd);
        ((ISchemaContentProvider) typesViewer.getContentProvider()).setXsdSchema(xsd);
        xsdSchema = xsd;
    }

    public ISchemaContentProvider getSchemaContentProvider() {
        return (ISchemaContentProvider) viewer.getContentProvider();
    }

    public ISchemaContentProvider getTypeContentProvider() {
        return (ISchemaContentProvider) typesViewer.getContentProvider();
    }

    public void refresh() {

        viewer.refresh(true);
        typesViewer.refresh(true);

        if (viewer.getTree().isFocusControl()) {
            ISelection oldSelection = viewer.getSelection();
            viewer.setSelection(null);
            viewer.setSelection(oldSelection);
        }

        if (typesViewer.getTree().isFocusControl()) {
            ISelection oldSelection = typesViewer.getSelection();
            typesViewer.setSelection(null);
            typesViewer.setSelection(oldSelection);
        }
    }

    public void markDirtyWithoutCommit() {
        dirty = true;
        firePropertyChange(PROP_DIRTY);
    }

    public void markDirty() {
        markDirtyWithoutCommit();
    }

    public boolean isDirty() {
        return dirty;
    }

    public XSDSchema reConfigureXSDSchema(boolean force) {

        return xsdSchema;
    }

    /**
     * @author achen
     */
    private void initializeOperationHistory() {

        if (undoContext == null) {
            undoContext = new ObjectUndoContext(this.toString(), xobject.getDisplayName());
        }

        PlatformUI.getWorkbench().getOperationSupport().getOperationHistory().setLimit(undoContext, undoLimit);

        UndoRedoActionGroup undoRedoGroup = new UndoRedoActionGroup(getSite(), undoContext, true);

        undoRedoGroup.fillActionBars(getEditorSite().getActionBars());

    }

    public ObjectUndoContext getUndoContext() {
        return undoContext;
    }

    public Map<Integer, String> getUndoActionTrack() {
        Map<Integer, String> map = contextToUndoAction.get(undoContext);
        if (map == null) {
            map = new HashMap<Integer, String>();
            contextToUndoAction.put(undoContext, map);
        }

        return map;
    }

    public Map<Integer, String> getRedoActionTrack() {
        Map<Integer, String> map = contextToRedoAction.get(undoContext);
        if (map == null) {
            map = new HashMap<Integer, String>();
            contextToRedoAction.put(undoContext, map);
        }

        return map;
    }

    public int getValue(String name) {
        int value = 0;
        for (int i = 0; i < name.length(); i++)
            value = value * 10 + name.charAt(i);
        return value;
    }

    private void openXSDParticle(TreeViewer targetViewer) {
        if (targetViewer == null)
            return;

        if (targetViewer.equals(viewer))
            openXSDParticleInSchemaTree();
        else if (targetViewer.equals(typesViewer))
            openXSDParticleInTypeTree();
    }

    private void openXSDParticleInTypeTree() {
        for (Object eachSelectedObj : getSelectionInTypeTree()) {
            typesViewer.collapseToLevel(eachSelectedObj, 3);
            if (eachSelectedObj instanceof XSDModelGroup)
                typesViewer.expandToLevel(eachSelectedObj, 1);
            else if (eachSelectedObj instanceof XSDComplexTypeDefinition)
                typesViewer.expandToLevel(eachSelectedObj, 1);
        }
    }

    private void openXSDParticleInSchemaTree() {

        for (Object eachSelectedObj : getSelectionInSchemaTree()) {
            viewer.collapseToLevel(eachSelectedObj, 3);
            if (eachSelectedObj instanceof XSDModelGroup) {
                viewer.expandToLevel(eachSelectedObj, 1);
            }
            if (eachSelectedObj instanceof XSDElementDeclaration) {
                viewer.expandToLevel(eachSelectedObj, 1);
                XSDTypeDefinition type = ((XSDElementDeclaration) eachSelectedObj).getTypeDefinition();
                if (type instanceof XSDComplexTypeDefinition) {
                    XSDModelGroup mg = (XSDModelGroup) ((XSDParticle) ((XSDComplexTypeDefinition) type).getContent()).getTerm();
                    viewer.expandToLevel(mg, 1);
                }
            }
        }
    }

    private void createCompDropTarget() {
        DropTarget dropTarget = new DropTarget(sash, DND.DROP_MOVE | DND.DROP_LINK);
        dropTarget.setTransfer(new TreeObjectTransfer[] { TreeObjectTransfer.getInstance() });
        dropTarget.addDropListener(new DropTargetAdapter() {

            public void dragEnter(DropTargetEvent event) {
            }

            public void dragLeave(DropTargetEvent event) {
            }

            public void dragOver(DropTargetEvent event) {
                event.feedback |= DND.FEEDBACK_EXPAND | DND.FEEDBACK_SCROLL;
            }

            public void drop(DropTargetEvent event) {
                List<String> nameList = new ArrayList<String>();
                if (dropTargetValidate(event, nameList)) {
                    if (MessageDialog.openConfirm(sash.getShell(), Messages.getString("ConfirmText"), Messages //$NON-NLS-1$
                            .getString("DoIncludeImportSchema"))) { //$NON-NLS-1$
                        HashMap<String, String> customTypesMap = ResourcesUtil.getResourcesMapFromURI(uriPre
                                + TreeObject.CUSTOM_TYPES_URI, xobject);
                        List<String> customTypeList = new ArrayList<String>();
                        for (String key : nameList) {
                            customTypeList.add(customTypesMap.get(key));
                        }
                        doImportSchema(customTypeList, new ArrayList<String>());
                    }
                }
            }
        });

    }

    private boolean dropTargetValidate(DropTargetEvent event, List<String> customTypeNamelist) {
        if (event.data == null)
            return false;
        Object obj = event.data;
        if (obj instanceof TreeObject[]) {
            uriPre = ((TreeObject[]) obj)[0].getServerRoot().getEndpointIpAddress();
            for (TreeObject ob : (TreeObject[]) obj) {
                if (ob.getType() == TreeObject.CUSTOM_TYPES_RESOURCE)
                    customTypeNamelist.add(ob.getDisplayName());
                else
                    return false;
            }
            return true;
        }
        return false;
    }

    private void validateElementation() throws IllegalAccessException {
        HashMap<String, Boolean> elemCntMap = new HashMap<String, Boolean>();
        EList<XSDElementDeclaration> elems = xsdSchema.getElementDeclarations();
        for (XSDElementDeclaration elem : elems) {
            if (elemCntMap.get(elem.getName()) == Boolean.TRUE) {
                throw new IllegalAccessException(Messages.getString("XSDDuplicateName") + elem.getName()); //$NON-NLS-1$
            }
            elemCntMap.put(elem.getName(), Boolean.TRUE);
        }
    }

    private void validateType() throws IllegalAccessException {
        HashMap<String, Boolean> typeCntMap = new HashMap<String, Boolean>();
        EList<XSDTypeDefinition> types = xsdSchema.getTypeDefinitions();
        String tail = "";//$NON-NLS-1$
        for (XSDTypeDefinition type : types) {
            if (type instanceof XSDComplexTypeDefinition) {
                tail = Messages.getString("ComplexText"); //$NON-NLS-1$
            } else {
                tail = Messages.getString("SimpleText"); //$NON-NLS-1$
            }
            if (typeCntMap.get(type.getName() + tail + type.getTargetNamespace()) == Boolean.TRUE) {
                
            }
            typeCntMap.put(type.getName() + tail + type.getTargetNamespace(), Boolean.TRUE);
        }
    }

    private void performDeletion(List<String> toDels) {
        List<XSDSchemaContent> impToDels = new ArrayList<XSDSchemaContent>();
        List<String> nsToDels = new ArrayList<String>();
        for (String delName : toDels) {
            EList<XSDSchemaContent> list = xsdSchema.getContents();
            for (XSDSchemaContent cnt : list) {
                if (cnt instanceof XSDImportImpl) {
                    XSDImportImpl imp = (XSDImportImpl) cnt;
                    String ns = imp.getNamespace();
                    String loct = imp.getSchemaLocation();
                    if (ns == null || loct == null) {
                        continue;
                    }
                    if (loct.equals(delName)) {
                        Iterator<Map.Entry<String, String>> iter = xsdSchema.getQNamePrefixToNamespaceMap().entrySet().iterator();
                        while (iter.hasNext()) {
                            Map.Entry<String, String> entry = iter.next();
                            if (entry.getValue().equalsIgnoreCase(ns)) {
                                nsToDels.add(entry.getKey());
                                impToDels.add(cnt);
                                break;
                            }
                        }
                    }
                } else if (cnt instanceof XSDIncludeImpl) {
                    XSDIncludeImpl inude = (XSDIncludeImpl) cnt;
                    if (inude.getSchemaLocation().equals(delName)) {
                        impToDels.add(cnt);
                        break;
                    }
                }
            }
        }
        if (!impToDels.isEmpty() && xsdSchema.getContents().containsAll(impToDels)) {
            xsdSchema.updateElement();
            xsdSchema.getReferencingDirectives().clear();
            Map<String, String> map = xsdSchema.getQNamePrefixToNamespaceMap();
            for (String ns : nsToDels) {
                map.remove(ns);
            }
            for (XSDSchemaContent cnt : impToDels) {
                xsdSchema.getContents().remove(cnt);
            }

            xsdSchema.updateElement();
            setXsdSchema(xsdSchema);
        }

    }

    private void performImport(List<String> list) throws Exception {
        Pattern httpUrl = Pattern.compile("(http|https|ftp):(\\//|\\\\)(.*)(\\:)+(.*)");//$NON-NLS-1$

        for (String fileName : list) {
            Matcher match = httpUrl.matcher(fileName);
            if (match.matches()) {
                importSchemaWithURL(fileName);
            } else {
                importSchemaFromFile(fileName);
            }
        }
    }

    private void importSchemaWithURL(String url) throws Exception {
        String response = Util.getResponseFromURL(url, xobject);
        InputSource source = new InputSource(new StringReader(response));
        importSchema(source, url);
    }

    private void importSchemaFromFile(String fileName) throws Exception {
        InputSource source = null;
        Pattern httpUrl = Pattern.compile("^(http|https|ftp):(\\//|\\\\)(.*)(\\.)+(xsd)$");//$NON-NLS-1$
        Matcher match = httpUrl.matcher(fileName);
        if (match.matches()) {
            URL url = new URL(fileName);
            String urlContent = IOUtils.toString(url.openConnection().getInputStream());
            urlContent = urlContent.replaceAll("<!DOCTYPE(.*?)>", "");//$NON-NLS-1$//$NON-NLS-2$
            source = new InputSource(IOUtils.toInputStream(urlContent));
            importSchema(source, fileName);
        } else {
            importFromFile(source, fileName);

        }

    }

    protected void importFromFile(InputSource source, String fileName) {
        String inputType = ""; //$NON-NLS-1$
        if (fileName.lastIndexOf(".") != -1) { //$NON-NLS-1$
            inputType = fileName.substring(fileName.lastIndexOf("."));//$NON-NLS-1$
        }
        if (!inputType.equals(".xsd"))//$NON-NLS-1$
            return;
        File file = new File(fileName);

        try {
            source = new InputSource(new FileInputStream(file));
            importSchema(source, file.getAbsolutePath());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

    protected void importSchema(InputSource source, String uri) throws Exception {
        String ns = "";//$NON-NLS-1$
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setValidating(false);

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(source);
        ns = document.getDocumentElement().getAttribute("targetNamespace");//$NON-NLS-1$
        if (xsdSchema == null)
            xsdSchema = getXSDSchema(Util.nodeToString(document));
        else {
            WSDataModel wsObject = (WSDataModel) (xobject.getWsObject());
            xsdSchema = Util.createXsdSchema(wsObject.getXsdSchema(), xobject);
        }
        boolean exist = false;
        for (int i = 0; i < xsdSchema.getContents().size(); i++) {
            XSDSchemaContent xsdComp = xsdSchema.getContents().get(i);
            if (ns != null && !ns.equals("")) {//$NON-NLS-1$
                // import xsdschema
                if (xsdComp instanceof XSDImport && ((XSDImport) xsdComp).getNamespace().equals(ns)) {
                    for (Map.Entry entry : xsdSchema.getQNamePrefixToNamespaceMap().entrySet()) {
                        if (entry.getValue().equals(((XSDImport) xsdComp).getNamespace())) {
                            exist = true;
                            break;
                        }
                    }
                    break;
                }
            } else {
                // include xsdschema
                if (xsdComp instanceof XSDInclude) {
                    String xsdLocation = ((XSDInclude) xsdComp).getSchemaLocation();
                    if (xsdLocation.equals(uri)) {
                        exist = true;
                        break;
                    }
                }
            }
        }

        if (!exist) {
            if (ns != null && !ns.equals("")) {//$NON-NLS-1$
                int last = ns.lastIndexOf("/");//$NON-NLS-1$
                xsdSchema.getQNamePrefixToNamespaceMap().put(ns.substring(last + 1).replaceAll("[\\W]", ""), ns);//$NON-NLS-1$//$NON-NLS-2$
                XSDImport xsdImport = XSDFactory.eINSTANCE.createXSDImport();
                xsdImport.setNamespace(ns);
                xsdImport.setSchemaLocation(uri);
                xsdSchema.getContents().add(0, xsdImport);
            } else {
                XSDInclude xsdInclude = XSDFactory.eINSTANCE.createXSDInclude();
                xsdInclude.setSchemaLocation(uri);
                xsdSchema.getContents().add(0, xsdInclude);
            }
            String xsd = Util.nodeToString(xsdSchema.getDocument());
            setXsdSchema(xsdSchema);
            WSDataModel wsObject = (WSDataModel) (xobject.getWsObject());
            wsObject.setXsdSchema(xsd);
        }
    }

    private ToolBar createToolbarOnComposite(Composite parentComp) {

        Color backColor = sash.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);

        Composite compToolBarBackground = new Composite(parentComp, SWT.BORDER);
        final GridLayout glToolBarBackground = new GridLayout();
        glToolBarBackground.verticalSpacing = 0;
        glToolBarBackground.marginWidth = 0;
        glToolBarBackground.marginHeight = 0;
        glToolBarBackground.horizontalSpacing = 0;
        compToolBarBackground.setLayout(glToolBarBackground);
        final GridData gdToolBarBackground = new GridData(SWT.FILL, SWT.CENTER, true, false);
        compToolBarBackground.setLayoutData(gdToolBarBackground);
        compToolBarBackground.setBackground(backColor);

        Composite compToolBar = new Composite(compToolBarBackground, SWT.NONE);
        compToolBar.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true));
        final GridLayout glToolBar = new GridLayout();
        glToolBar.verticalSpacing = 0;
        glToolBar.marginWidth = 0;
        glToolBar.marginHeight = 0;
        glToolBar.horizontalSpacing = 0;
        compToolBar.setLayout(glToolBar);
        compToolBar.setBackground(backColor);

        ToolBar resultToolBar = new ToolBar(compToolBar, SWT.FLAT | SWT.HORIZONTAL);
        resultToolBar.setBackground(backColor);

        return resultToolBar;
    }

    private void addToolItems2SchemaTreeToolBar(ToolBar parentToolBar) {

        createExpandToolItem(parentToolBar, viewer);
        createCollapseToolItem(parentToolBar, viewer);
        createExpandGroupToolItem(parentToolBar, viewer);
        createMoveUpToolItem(parentToolBar, viewer);
        createMoveDownToolItem(parentToolBar, viewer);

        createSortByLabelToolItem(parentToolBar, viewer);
        createFiltUniqueElementToolItem(parentToolBar, viewer);

        if (Util.IsEnterPrise())
            createFilterToolItem(parentToolBar, viewer);

    }

    private void addToolItems2TypeTreeToolBar(ToolBar parentToolBar) {

        createExpandToolItem(parentToolBar, typesViewer);
        createCollapseToolItem(parentToolBar, typesViewer);
        createExpandGroupToolItem(parentToolBar, typesViewer);
        createMoveUpToolItem(parentToolBar, typesViewer);
        createMoveDownToolItem(parentToolBar, typesViewer);

        createSortByLabelToolItem(parentToolBar, typesViewer);

        if (Util.IsEnterPrise())
            createFilterToolItem(parentToolBar, typesViewer);
    }

    private ToolItem createFilterToolItem(ToolBar parentToolBar, final TreeViewer tTreeViewer) {

        ToolItem filterToolItem = new ToolItem(parentToolBar, SWT.PUSH);
        filterToolItem.setImage(ImageCache.getCreatedImage(EImage.FILTER_PS.getPath()));
        filterToolItem.setToolTipText(Messages.getString("FilterText")); //$NON-NLS-1$

        filterToolItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                targetTreeViewer = tTreeViewer;
                dataModelFilter = new DataModelFilter("", false, false, false, true);//$NON-NLS-1$
                DataModelFilterDialog dataModelFilterDialog = (DataModelFilterDialog) getAdapter(DataModelFilterDialog.class);

                if (dataModelFilterDialog.open() == Dialog.OK) {
                    getSchemaRoleFilterFromTreeViewer(targetTreeViewer).setDataModelFilter(dataModelFilter);
                    getSchemaTopElementNameFilterFromTreeViewer(targetTreeViewer).setNameFilterDes(
                            getSchemaElementNameFilterDesByTreeViewer(targetTreeViewer));
                    targetTreeViewer.refresh();
                }
            }
        });

        return null;
    }

    private ToolItem createExpandToolItem(ToolBar parentToolBar, final TreeViewer targetTreeViewer) {

        ToolItem expanedToolItem = new ToolItem(parentToolBar, SWT.PUSH);
        expanedToolItem.setImage(ImageCache.getCreatedImage(EImage.EXPAND.getPath()));
        expanedToolItem.setToolTipText(Messages.getString("ExpandText")); //$NON-NLS-1$
        expanedToolItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection selection = (IStructuredSelection) targetTreeViewer.getSelection();
                for (Object eachSelectedObj : selection.toArray())
                    targetTreeViewer.expandToLevel(eachSelectedObj, 3);
            }
        });

        return expanedToolItem;
    }

    private ToolItem createCollapseToolItem(ToolBar parentToolBar, final TreeViewer targetTreeViewer) {

        ToolItem collapseToolItem = new ToolItem(parentToolBar, SWT.PUSH);
        collapseToolItem.setImage(ImageCache.getCreatedImage(EImage.COLLAPSE.getPath()));
        collapseToolItem.setToolTipText(Messages.getString("CollapseText")); //$NON-NLS-1$
        collapseToolItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection selection = (IStructuredSelection) targetTreeViewer.getSelection();
                for (Object eachSelectedObj : selection.toArray())
                    targetTreeViewer.collapseToLevel(eachSelectedObj, 3);
            }
        });

        return collapseToolItem;
    }

    private ToolItem createExpandGroupToolItem(ToolBar parentToolBar, final TreeViewer targetTreeViewer) {

        ToolItem expandGroupToolItem = new ToolItem(parentToolBar, SWT.PUSH);
        expandGroupToolItem.setImage(ImageCache.getCreatedImage(EImage.ACTIVITY_CATEGORY.getPath()));
        expandGroupToolItem.setToolTipText(Messages.getString("ExpandModelGroup")); //$NON-NLS-1$
        expandGroupToolItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                openXSDParticle(targetTreeViewer);
            }
        });

        return expandGroupToolItem;
    }

    private ToolItem createMoveUpToolItem(ToolBar parentToolBar, final TreeViewer targetTreeViewer) {

        ToolItem moveUpToolItem = new ToolItem(parentToolBar, SWT.PUSH);
        moveUpToolItem.setImage(ImageCache.getCreatedImage(EImage.PREV_NAV.getPath()));
        moveUpToolItem.setToolTipText(Messages.getString("UPText")); //$NON-NLS-1$
        moveUpToolItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                stepUp(targetTreeViewer);
            }
        });

        return moveUpToolItem;
    }

    private ToolItem createMoveDownToolItem(ToolBar parentToolBar, final TreeViewer targetTreeViewer) {

        ToolItem moveDownToolItem = new ToolItem(parentToolBar, SWT.PUSH);
        moveDownToolItem.setImage(ImageCache.getCreatedImage(EImage.NEXT_NAV.getPath()));
        moveDownToolItem.setToolTipText(Messages.getString("DownText")); //$NON-NLS-1$
        moveDownToolItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                stepDown(targetTreeViewer);
            }
        });

        return moveDownToolItem;
    }

    private ToolItem createSortByLabelToolItem(ToolBar parentToolBar, final TreeViewer targetTreeViewer) {

        final ToolItem sortByLabelToolItem = new ToolItem(parentToolBar, SWT.PUSH);
        sortByLabelToolItem.setImage(ImageCache.getCreatedImage(EImage.SORT_DESC.getPath()));
        sortByLabelToolItem.setToolTipText(Messages.getString("SortDescText")); //$NON-NLS-1$
        sortByLabelToolItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                sortByLabel(sortByLabelToolItem, targetTreeViewer);
            }
        });

        return sortByLabelToolItem;
    }

    private ToolItem createFiltUniqueElementToolItem(ToolBar parentToolBar, final TreeViewer targetTreeViewer) {

        final ToolItem filtUniqueElementToolItem = new ToolItem(parentToolBar, SWT.CHECK);
        filtUniqueElementToolItem.setImage(ImageCache.getCreatedImage(EImage.ELEMENT_ONLY_SKIP.getPath()));
        filtUniqueElementToolItem.setToolTipText(Messages.getString("HideElementsText")); //$NON-NLS-1$
        filtUniqueElementToolItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                filtUniqueElement(filtUniqueElementToolItem, targetTreeViewer);
            }
        });

        return filtUniqueElementToolItem;

    }

    private Object[] getSelectionInSchemaTree() {
        return getSelectionInViewer(viewer);
    }

    private Object[] getSelectionInTypeTree() {
        return getSelectionInViewer(typesViewer);
    }

    private Object[] getSelectionInViewer(Viewer viewer) {

        if (viewer.getSelection() == null || !(viewer.getSelection() instanceof IStructuredSelection))
            return new Object[0];

        return ((IStructuredSelection) viewer.getSelection()).toArray();

    }

    private SchemaRoleAccessFilter getSchemaRoleFilterFromSchemaTree() {
        return (SchemaRoleAccessFilter) getTreeViewerFilter(viewer, SchemaRoleAccessFilter.class);
    }

    private SchemaRoleAccessFilter getSchemaRoleFilterFromTreeViewer(TreeViewer targetViewer) {
        return (SchemaRoleAccessFilter) getTreeViewerFilter(targetViewer, SchemaRoleAccessFilter.class);
    }

    private SchemaNameFilter getSchemaTopElementNameFilterFromTreeViewer(TreeViewer targetViewer) {
        return (SchemaNameFilter) getTreeViewerFilter(targetViewer, SchemaNameFilter.class);
    }

    private SchemaUniqueElementFilter getSchemaUniqueElementFilterFromSchemaTree() {
        return (SchemaUniqueElementFilter) getTreeViewerFilter(viewer, SchemaUniqueElementFilter.class);
    }

    private ViewerFilter getTreeViewerFilter(TreeViewer viewer, Class<? extends ViewerFilter> filterType) {

        if (viewer == null || filterType == null)
            return null;

        for (ViewerFilter eachFilter : viewer.getFilters()) {
            if (filterType.isAssignableFrom(eachFilter.getClass()))
                return eachFilter;
        }

        return null;
    }

    protected SchemaElementNameFilterDes getSchemaElementNameFilterDesByTreeViewer(TreeViewer targetViewer) {

        if (typesViewer.equals(targetViewer))
            return typeElementNameFilterDes;

        return schemaElementNameFilterDes;
    }

    private void sortByLabel(ToolItem sortByLabelToolItem, TreeViewer targetTreeViewer) {

        SchemaElementSorter sorter = getTreeViewerSchemaElementSorter(targetTreeViewer);

        if (sorter == null)
            return;

        sortByLabelToolItem.setImage(getToolImageAfterClickSortByLabel(sorter.isSortedASC()));
        sortByLabelToolItem.setToolTipText(getTooltipAfterClickSortByLabel(sorter.isSortedASC()));

        sorter.setSortedType(!sorter.isSortedASC());

        targetTreeViewer.refresh();
    }

    private void filtUniqueElement(ToolItem filtUniqueElementToolItem, TreeViewer targetTreeViewer) {

        SchemaUniqueElementFilter filter = getSchemaUniqueElementFilterFromSchemaTree();

        filter.setSelector(filtUniqueElementToolItem.getSelection());
        if (filtUniqueElementToolItem.getSelection())
            filtUniqueElementToolItem.setToolTipText(Messages.getString("ShowElementsText")); //$NON-NLS-1$
        else
            filtUniqueElementToolItem.setToolTipText(Messages.getString("HideElementsText")); //$NON-NLS-1$

        targetTreeViewer.refresh();
    }

    private SchemaElementSorter getTreeViewerSchemaElementSorter(TreeViewer targetTreeViewer) {

        if (targetTreeViewer.getSorter() instanceof SchemaElementSorter)
            return (SchemaElementSorter) targetTreeViewer.getSorter();

        return null;
    }

    private Image getToolImageAfterClickSortByLabel(boolean isCurrentASC) {

        if (isCurrentASC)
            return ImageCache.getCreatedImage(EImage.SORT_ASC.getPath());

        return ImageCache.getCreatedImage(EImage.SORT_DESC.getPath());
    }

    private String getTooltipAfterClickSortByLabel(boolean isCurrentASC) {

        if (isCurrentASC)
            return Messages.getString("SortAscText"); //$NON-NLS-1$

        return Messages.getString("SortDescText"); //$NON-NLS-1$
    }

    private class DoubleClickListener implements IDoubleClickListener {

        private TreeViewer viewer;

        public DoubleClickListener(TreeViewer viewer) {
            this.viewer = viewer;
        }

        public void doubleClick(DoubleClickEvent event) {
            IStructuredSelection selection = ((IStructuredSelection) viewer.getSelection());
            if (selection.isEmpty())
                return;
            int elem = getElementType(selection.getFirstElement());
            // available models
            java.util.List<IAvailableModel> availablemodels = AvailableModelUtil.getAvailableModels(isLocalInput());
            for (IAvailableModel model : availablemodels) {
                model.doubleClickOnElement(elem, DataModelMainPage.this, dataModelName);
            }
            switch (elem) {
            case 0:
                editConceptAction.run();
                break;
            case 1:
                editElementAction.run();
                break;
            case 2:
                editComplexTypeAction.run();
                break;
            case 3:
                editIdentityConstraintAction.run();
                break;
            case 4:
                editXPathAction.run();
                break;
            case 5:
                changeBaseTypeAction.run();
                break;
            case 6:
                setAnnotationDescriptionsAction.run();
                break;
            case 7:
                editParticleAction.run();
                break;
            case 8:
                changeSubElementGroupAction.run();
                break;
            case 201:
                initxsdEditFacetAction("whiteSpace");//$NON-NLS-1$
                break;
            case 202:
                initxsdEditFacetAction("length");//$NON-NLS-1$
                break;
            case 203:
                initxsdEditFacetAction("minLength");//$NON-NLS-1$
                break;
            case 204:
                initxsdEditFacetAction("maxLength");//$NON-NLS-1$
                break;
            case 205:
                initxsdEditFacetAction("totalDigits");//$NON-NLS-1$
                break;
            case 206:
                initxsdEditFacetAction("fractionDigits");//$NON-NLS-1$
                break;
            case 207:
                initxsdEditFacetAction("maxInclusive");//$NON-NLS-1$
                break;
            case 208:
                initxsdEditFacetAction("maxExclusive");//$NON-NLS-1$
                break;
            case 209:
                initxsdEditFacetAction("minInclusive");//$NON-NLS-1$
                break;
            case 210:
                initxsdEditFacetAction("minExclusive");//$NON-NLS-1$
                break;
            case 211:
                initxsdEditFacetAction("pattern");//$NON-NLS-1$
                break;
            case 212:
                initxsdEditFacetAction("enumeration");//$NON-NLS-1$
                break;
            case 101:
                setAnnotationLabelAction.run();
                break;
            case 102:
                setAnnotationForeignKeyAction.run();
                break;
            case 103:
                setAnnotationForeignKeyInfoAction.run();
                break;
            case 112:
                setAnnotationFKFilterAction.run();
                break;
            case 104:
                break;
            case 105:
                break;
            case 106:
                setAnnotationDescriptionsAction.run();
                break;
            case 107:
                setAnnotationWriteAction.run();
                break;
            case 108:
                if (Util.IsEnterPrise()) {
                    setAnnotationNoAction.run();
                }
                break;
            case 110:
                setFacetMsgAction.run();
                break;
            case 113:
                setAnnotationDisplayFomatAction.run();
                break;
            case 114:
                setAnnotationLookupFieldsAction.run();
                break;
            case 115:
                setAnnotationPrimaryKeyInfoAction.run();
                break;
            case 116:
                visibleRuleAction.run();
                break;
            case 117:
                defaultValueRuleAction.run();
                break;
            case 121:
                setAnnotationFKIntegrity.run();
                break;
            case 122:
                setAnnotationFKIntegrityOverride.run();
                break;
            case -1:
                if (drillDownAdapter.canGoInto() == true)
                    drillDownAdapter.goInto();
            }
        }
    }

    public TreeObject getXObject() {
        return this.xobject;
    }

    public Control getMainControl() {
        return mainControl;
    }

    @Override
    public void dispose() {
        // clear operationhistory
        IOperationHistory history = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
        for (IUndoableOperation op : history.getRedoHistory(undoContext)) {
            op.dispose();
            op = null;
        }
        for (IUndoableOperation op : history.getUndoHistory(undoContext)) {
            op.dispose();
            op = null;
        }
        history.dispose(undoContext, true, true, true);
        // clear the big objects,
        schemaTreeContentProvider = null;
        typesTreeContentProvider = null;
        schemaTreeSorter = null;
        typeTreeSorter = null;
        undoContext = null;
        xsdSchema = null;
        contextToUndoAction.clear();
        contextToRedoAction.clear();
        super.dispose();
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        monitor.beginTask(Messages.getString("SavingText"), 1); //$NON-NLS-1$
        commit();
        monitor.done();
    }

    @Override
    public void doSaveAs() {
        commit();
    }

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        setSite(site);
        setInput(input);
    }

    @Override
    public boolean isSaveAsAllowed() {
        return true;
    }

    @Override
    public void createPartControl(Composite parent) {

        mainControl = parent;
        parent.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        GridLayout layout = new GridLayout();
        layout.verticalSpacing = 2;
        layout.numColumns = 2;
        parent.setLayout(layout);
        // create toolbar
        createToolBar(parent);
        createCharacteristicsContent(WidgetFactory.getWidgetFactory(), parent);
        createActions();
    }

    private void createToolBar(Composite parent) {
        Composite toolBarComp = new Composite(parent, SWT.BORDER);
        GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);
        gd.heightHint = 25;
        toolBarComp.setLayoutData(gd);
        final GridLayout glToolBarBackground = new GridLayout();
        glToolBarBackground.verticalSpacing = 0;
        glToolBarBackground.marginWidth = 0;
        glToolBarBackground.marginHeight = 0;
        glToolBarBackground.horizontalSpacing = 0;
        toolBarComp.setLayout(glToolBarBackground);
        ToolBar resultToolBar = new ToolBar(toolBarComp, SWT.FLAT | SWT.HORIZONTAL);
        gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
        resultToolBar.setLayoutData(gd);
        ToolItem importToolItem = new ToolItem(resultToolBar, SWT.PUSH);
        importToolItem.setImage(ImageCache.getCreatedImage(EImage.IMPORT.getPath()));
        importToolItem.setToolTipText(Messages.getString("ImportText")); //$NON-NLS-1$

        ToolItem exportToolItem = new ToolItem(resultToolBar, SWT.PUSH);
        exportToolItem.setImage(ImageCache.getCreatedImage(EImage.EXPORT.getPath()));
        exportToolItem.setToolTipText(Messages.getString("ExportText")); //$NON-NLS-1$

        ToolItem importSchemalItem = new ToolItem(resultToolBar, SWT.PUSH);
        importSchemalItem.setImage(ImageCache.getCreatedImage(EImage.CHECKIN_ACTION.getPath()));
        importSchemalItem.setToolTipText(Messages.getString("ImportIncludeSchema")); //$NON-NLS-1$

        importToolItem.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog fd = new FileDialog(getSite().getShell(), SWT.OPEN);
                fd.setFilterExtensions(new String[] { "*.xsd", "*.dtd", "*.xml" });//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
                // set the default path to the workspace.
                fd.setFilterPath(Platform.getInstanceLocation().getURL().getPath().substring(1));
                fd.setText(Messages.getString("SelectXMLDefinition")); //$NON-NLS-1$
                String filename = fd.open();
                if (filename == null)
                    return;
                xsdSchema = null;
                inferXsdFromXml(filename);
            }

            private void inferXsdFromXml(String xmlFile) {
                int infer = 0;
                String xsd = "";//$NON-NLS-1$
                try {
                    String inputType = xmlFile.substring(xmlFile.lastIndexOf("."));//$NON-NLS-1$
                    if (inputType.equals(".xsd")) {//$NON-NLS-1$
                        xsd = Util.getXML(xmlFile);
                        xsdSchema = Util.createXsdSchema(xsd, xobject);
                        xsd = Util.nodeToString(xsdSchema.getDocument());
                    } else {
                        XSDDriver d = new XSDDriver();
                        infer = d.doMain(new String[] { xmlFile, "out.xsd" });//$NON-NLS-1$
                        if (infer == 0) {
                            xsd = d.outputXSD();
                        }
                    }

                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    infer = 2;
                } finally {
                    if (infer == 0 && !xsd.equals("")) {//$NON-NLS-1$
                        WSDataModel wsObj = (WSDataModel) (xobject.getWsObject());
                        wsObj.setXsdSchema(xsd);
                        validateSchema(xsd);
                        refreshData();
                        markDirtyWithoutCommit();
                    } else if (infer != 0) {
                        MessageDialog.openError(getSite().getShell(), Messages.getString("Error.title"), Messages //$NON-NLS-1$
                                .getString("XsdSchemaInferred")); //$NON-NLS-1$
                    }
                }
            }

            void validateSchema(String xsd) {
                try {
                    boolean elem = false;
                    XSDSchema schema = getXSDSchema(xsd);
                    NodeList nodeList = schema.getDocument().getDocumentElement().getChildNodes();
                    for (int idx = 0; idx < nodeList.getLength(); idx++) {
                        Node node = nodeList.item(idx);
                        if (node instanceof Element && node.getLocalName().indexOf("element") >= 0) {//$NON-NLS-1$
                            elem = true;
                            break;
                        }
                    }
                    if (!elem) {
                        MessageDialog.openWarning(getSite().getShell(), Messages.getString("WarnningText"), Messages //$NON-NLS-1$
                                .getString("NoElementNode")); //$NON-NLS-1$
                    }
                } catch (Exception e) {

                    log.error(e.getMessage(), e);
                }
            }
        });

        exportToolItem.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog fd = new FileDialog(getSite().getShell(), SWT.SAVE);
                fd.setFilterExtensions(new String[] { "*.xsd" });//$NON-NLS-1$
                fd.setFilterPath(Platform.getInstanceLocation().getURL().getPath().substring(1));
                fd.setText(Messages.getString("SaveDataModuleXSDSchema")); //$NON-NLS-1$
                String filename = fd.open();
                if (filename == null)
                    return;
                inferXsdFromDataModule(filename);
            }

            private void inferXsdFromDataModule(String xmlFile) {
                WSDataModel wsObject = (WSDataModel) (xobject.getWsObject());
                XSDDriver d = new XSDDriver();
                if (d.outputXSD_UTF_8(wsObject.getXsdSchema(), xmlFile) != null) {
                    MessageDialog.openInformation(getSite().getShell(), Messages.getString("ExportXSD"), Messages //$NON-NLS-1$
                            .getString("OperationExportingXsd")); //$NON-NLS-1$
                } else {
                    MessageDialog.openError(getSite().getShell(), Messages.getString("Error.title"), Messages //$NON-NLS-1$
                            .getString("FailedExportXSD")); //$NON-NLS-1$
                }
            }
        });

        importSchemalItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                SelectImportedModulesDialog dlg = createSelectImportedModulesDialog();
                dlg.create();
                dlg.setBlockOnOpen(true);
                dlg.open();
                if (dlg.getReturnCode() == Window.OK) {
                    doImportSchema(dlg.getImportedXSDList(), dlg.getToDelXSDList());
                }
            }

        });

    }

    protected SelectImportedModulesDialog createSelectImportedModulesDialog() {
        return new SelectImportedModulesDialog(getSite().getShell(), xsdSchema, xobject, Messages.getString("ImportXSDSchema")); //$NON-NLS-1$
    }

    @Override
    public void setFocus() {

    }

    public void modifyText(ModifyEvent arg0) {
        markDirty();
    }

    public ISelectionProvider getSelectionProvider() {
        return selectionProvider;
    }

    public WSDataModel getDataModel() {
        return datamodel;
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (adapter == TreeParent.class) {
            return Util.getServerTreeParent(getXObject());
        }
        if (adapter == XSDSetAnnotationWriteAction.class) {
            return new XSDSetAnnotationWriteAction(this);
        }
        if (adapter == XSDSetAnnotationNoAction.class) {
            return new XSDSetAnnotationNoAction(this, dataModelName);
        }
        if (adapter == XSDSetAnnotationWrapWriteAction.class) {
            return new XSDSetAnnotationWrapWriteAction(this);
        }
        if (adapter == XSDSetAnnotationWrapNoAction.class) {
            return new XSDSetAnnotationWrapNoAction(this, dataModelName);
        }
        if (adapter == XSDSetAnnotationForeignKeyAction.class) {
            return new XSDSetAnnotationForeignKeyAction(this, dataModelName);
        }
        if (adapter == XSDSetAnnotationForeignKeyInfoAction.class) {
            return new XSDSetAnnotationForeignKeyInfoAction(this, dataModelName);
        }
        if (adapter == XSDSetAnnotationFKFilterAction.class) {
            return new XSDSetAnnotationFKFilterAction(this, dataModelName);
        }
        if (adapter == XSDDeleteConceptAction.class) {
            return new XSDDeleteConceptAction(this);
        }
        if (adapter == DataModelFilterDialog.class) {
            return new DataModelFilterDialog(getSite().getShell(), xobject, dataModelFilter,
                    getSchemaElementNameFilterDesByTreeViewer(targetTreeViewer));
        }
        if (adapter == XSDDefaultValueRuleAction.class) {
            return new XSDDefaultValueRuleAction(this, dataModelName);
        }
        if (adapter == XSDVisibleRuleAction.class) {
            return new XSDVisibleRuleAction(this, dataModelName);
        }
        return super.getAdapter(adapter);
    }

    public XSDAnnotationsStructure getStructureByActiveItem() {
        XSDComponent xSDCom = null;
        XSDAnnotationsStructure struc = null;
        IStructuredSelection selection = (TreeSelection) getTreeViewer().getSelection();
        if (selection.getFirstElement() instanceof Element) {
            TreePath tPath = ((TreeSelection) selection).getPaths()[0];
            for (int i = 0; i < tPath.getSegmentCount(); i++) {
                if (tPath.getSegment(i) instanceof XSDAnnotation)
                    xSDCom = (XSDAnnotation) (tPath.getSegment(i));
            }
        } else
            xSDCom = (XSDComponent) selection.getFirstElement();

        if (xSDCom != null)
            struc = new XSDAnnotationsStructure(xSDCom);

        return struc;
    }

    public boolean hasVisibleRule(XSDElementDeclaration xsdEl) {
        XSDAnnotation annotation = xsdEl.getAnnotation();
        List<Element> informations = annotation.getApplicationInformation();
        for (Element el : informations) {
            String name = el.getLocalName();
            if ("appinfo".equals(name.toLowerCase())) {//$NON-NLS-1$
                name = el.getAttribute("source");//$NON-NLS-1$
                if (name.matches("X_Visible_Rule")) { //$NON-NLS-1$
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isLocalInput() {
        MultiPageEditorSite site = (MultiPageEditorSite) getEditorSite();
        if (site.getMultiPageEditor() instanceof IServerObjectEditorState) {
            return ((IServerObjectEditorState) site.getMultiPageEditor()).isLocalInput();
        }
        return false;
    }
}
