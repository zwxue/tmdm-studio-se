// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.actions;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;

import com.amalto.workbench.dialogs.RoleAssignmentDialog;
import com.amalto.workbench.dialogs.ViewInputDialog;
import com.amalto.workbench.editors.AMainPage;
import com.amalto.workbench.editors.AMainPageV2;
import com.amalto.workbench.editors.XObjectEditor;
import com.amalto.workbench.editors.xsdeditor.XSDEditorUtil;
import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.image.EImage;
import com.amalto.workbench.image.ImageCache;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectEditorInput;
import com.amalto.workbench.utils.IConstants;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSBoolean;
import com.amalto.workbench.webservices.WSDataCluster;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSExistsDataCluster;
import com.amalto.workbench.webservices.WSExistsDataModel;
import com.amalto.workbench.webservices.WSExistsMenu;
import com.amalto.workbench.webservices.WSExistsRole;
import com.amalto.workbench.webservices.WSExistsRoutingRule;
import com.amalto.workbench.webservices.WSExistsStoredProcedure;
import com.amalto.workbench.webservices.WSExistsSynchronizationPlan;
import com.amalto.workbench.webservices.WSExistsTransformerV2;
import com.amalto.workbench.webservices.WSExistsUniverse;
import com.amalto.workbench.webservices.WSExistsView;
import com.amalto.workbench.webservices.WSGetObjectsForSynchronizationPlans;
import com.amalto.workbench.webservices.WSGetObjectsForUniverses;
import com.amalto.workbench.webservices.WSMenu;
import com.amalto.workbench.webservices.WSMenuEntry;
import com.amalto.workbench.webservices.WSMenuMenuEntriesDescriptions;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSPutDataModel;
import com.amalto.workbench.webservices.WSRegexDataModelPKs;
import com.amalto.workbench.webservices.WSRole;
import com.amalto.workbench.webservices.WSRolePK;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRuleExpression;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.WSStoredProcedure;
import com.amalto.workbench.webservices.WSStoredProcedurePK;
import com.amalto.workbench.webservices.WSSynchronizationPlan;
import com.amalto.workbench.webservices.WSSynchronizationPlanItemsSynchronizations;
import com.amalto.workbench.webservices.WSSynchronizationPlanPK;
import com.amalto.workbench.webservices.WSSynchronizationPlanXtentisObjectsSynchronizations;
import com.amalto.workbench.webservices.WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations;
import com.amalto.workbench.webservices.WSTransformerProcessStep;
import com.amalto.workbench.webservices.WSTransformerV2;
import com.amalto.workbench.webservices.WSTransformerV2PK;
import com.amalto.workbench.webservices.WSTransformerVariablesMapping;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSUniverseItemsRevisionIDs;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.WSUniverseXtentisObjectsRevisionIDs;
import com.amalto.workbench.webservices.WSView;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.WSWhereCondition;
import com.amalto.workbench.webservices.XtentisPort;

public class NewXObjectAction extends Action {

    private static Log log = LogFactory.getLog(NewXObjectAction.class);

    private ServerView view = null;

    private String title = "";//$NON-NLS-1$

    public NewXObjectAction(ServerView view) {
        super();
        this.view = view;
        setImageDescriptor(ImageCache.getImage(EImage.ADD_OBJ.getPath()));
        setText(Messages.New);
        setToolTipText(Messages.bind(Messages.NewXObjectAction_ActionTip, IConstants.TALEND));
    }

    @Override
    public void run() {
        try {
            super.run();
            ISelection selection = view.getViewer().getSelection();
            TreeObject xobject = (TreeObject) ((IStructuredSelection) selection).getFirstElement();
            xobject = LocalTreeObjectRepository.getInstance().registerNewTreeObject(xobject);
            TreeParent xfolder = (xobject.isXObject()) ? xobject.getParent() : (TreeParent) xobject;

            // get New Key
            Object key = null;
            switch (xfolder.getType()) {
            case TreeObject.SOURCE:
                title = Messages.NewXObjectAction_Title1;
                break;
            case TreeObject.DESTINATION:
                title = Messages.NewXObjectAction_Title2;
                break;
            case TreeObject.DATA_MODEL:
                title = Messages.NewXObjectAction_NewDataModel;
                break;
            case TreeObject.RESOURCES:
                title = Messages.NewXObjectAction_NewResource;
                break;
            case TreeObject.CUSTOM_TYPE:
                title = Messages.NewXObjectAction_NewCustom;
                break;
            case TreeObject.INBOUND_ADAPTOR:
                title = Messages.NewXObjectAction_NewInboundAdapter;
                break;
            case TreeObject.INBOUND_PLUGIN:
                title = Messages.NewXObjectAction_NewInboundPlugin;
                break;
            case TreeObject.OUTBOUND_ADAPTOR:
                title = Messages.NewXObjectAction_NewOutboundAdapter;
                break;
            case TreeObject.OUTBOUND_PLUGIN:
                title = Messages.NewXObjectAction_NewOutboundPlugin;
                break;
            case TreeObject.DATA_CLUSTER:
                title = Messages.NewXObjectAction_NewDataContainer;
                break;
            case TreeObject.STORED_PROCEDURE:
                title = Messages.NewXObjectAction_NewStoredProc;
                break;
            // case TreeObject.ROLE:
            case TreeObject.ROUTING_RULE:
                title = Messages.NewXObjectAction_NewTrigger;
                break;
            case TreeObject.MENU:
                title = Messages.NewXObjectAction_NewMenu;
                break;
            case TreeObject.UNIVERSE:
                title = Messages.NewXObjectAction_NewVersion;
                break;
            case TreeObject.SYNCHRONIZATIONPLAN:
                title = Messages.NewXObjectAction_NewSynPlan;
                break;
            case TreeObject.TRANSFORMER:
                title = Messages.NewXObjectAction_NewProcess;
                break;
            case TreeObject.VIEW:
                title = Messages.NewXObjectAction_NewView;
                break;
            default:
                return;
            }

            // (Shell parentShell, String dialogTitle, String dialogMessage, String initialValue, IInputValidator
            // validator)
            switch (xfolder.getType()) {
            case TreeObject.TRANSFORMER:
                ViewInputDialog vid = new ViewInputDialog(
                        view.getSite(),
                        xfolder,
                        view.getSite().getShell(),
                        title,// "New "+IConstants.TALEND+" Object Instance",
                        Messages.NewXObjectAction_DialogTip,
                        "Smart_view_", new IInputValidator() {//$NON-NLS-1$

                            public String isValid(String newText) {
                                if ((newText == null) || "".equals(newText))//$NON-NLS-1$
                                    return Messages.NewXObjectAction_NameCannotBeEmpty;
                                // yyun: bug 16141: the empty charactors inside the string isn't permitted
                                // if (!Pattern.matches("\\w*(\\s*|#|\\w+)+\\w+", newText)) {
                                if (!Pattern.matches("\\w*(#|\\w*)+\\w+#*", newText)) {//$NON-NLS-1$
                                    return Messages.NewXObjectAction_NameCannotContainInvalid;
                                }
                                return null;
                            };
                        }, true);
                vid.setBtnShow(false);
                vid.create();
                // vid.getShell().setSize(new Point(500,270));
                vid.setBlockOnOpen(true);
                if (vid.open() == Window.CANCEL)
                    return;
                key = vid.getValue();
                break;

            case TreeObject.VIEW:

                ViewInputDialog tid = new ViewInputDialog(view.getSite(),
                        xfolder, view.getSite()
                                .getShell(), title,// "New "+IConstants.TALEND+" Object Instance",
                        Messages.NewXObjectAction_EnterNameForInstance, "Browse_items_", new IInputValidator() {//$NON-NLS-1$

                            public String isValid(String newText) {
                                if ((newText == null) || "".equals(newText))//$NON-NLS-1$
                                    return Messages.NewXObjectAction_NameCannotBeEmpty;
                                // yyun: bug 16141: the empty charactors inside the string isn't permitted
                                // if (!Pattern.matches("\\w*(\\s*|#|\\w+)+\\w+#*", newText)) {
                                if (!Pattern.matches("\\w*(#|\\w*)+\\w+#*", newText)) {//$NON-NLS-1$
                                    return Messages.NewXObjectAction_NameCannotContainInvalid;
                                }
                                return null;
                            };
                        }, false);

                tid.create();
                tid.getShell().setSize(new Point(600, 180));
                tid.setBlockOnOpen(true);
                if (tid.open() == Window.CANCEL)
                    return;
                key = tid.getValue();
                break;
            case TreeObject.DATA_CLUSTER:
                StringBuffer clsBuf = new StringBuffer();
                RoleAssignmentDialog dialog = new RoleAssignmentDialog(view.getSite().getShell(), xfolder, title, Messages.NewXObjectAction_DataCluster,
                        clsBuf);
                dialog.setBlockOnOpen(true);
                if (dialog.open() == Window.OK) {
                    key = clsBuf.toString();
                } else
                    return;
                break;
            case TreeObject.DATA_MODEL:
                StringBuffer mlBuf = new StringBuffer();
                RoleAssignmentDialog dlg = new RoleAssignmentDialog(view.getSite().getShell(), xfolder, title, Messages.NewXObjectAction_DataModel,
                        mlBuf);
                dlg.setBlockOnOpen(true);
                if (dlg.open() == Window.OK) {
                    key = mlBuf.toString();
                } else
                    return;
                break;
            case TreeObject.SOURCE:
            case TreeObject.CUSTOM_TYPE:
            case TreeObject.DESTINATION:
            case TreeObject.INBOUND_ADAPTOR:
            case TreeObject.INBOUND_PLUGIN:
            case TreeObject.OUTBOUND_ADAPTOR:
            case TreeObject.OUTBOUND_PLUGIN:

            case TreeObject.STORED_PROCEDURE:
                // case TreeObject.ROLE:
            case TreeObject.ROUTING_RULE:

            case TreeObject.MENU:
            case TreeObject.UNIVERSE:
            case TreeObject.SYNCHRONIZATIONPLAN:
                InputDialog id1 = new InputDialog(view.getSite().getShell(), title,// "New "+IConstants.TALEND+" Object Instance",
                        Messages.NewXObjectAction_EnterNameForInstance, null, new IInputValidator() {

                            public String isValid(String newText) {
                                if ((newText == null) || "".equals(newText))//$NON-NLS-1$
                                    return Messages.NewXObjectAction_NameCannotBeEmpty;
                                // yyun: bug 16141: the empty charactors inside the string isn't permitted
                                // if (!Pattern.matches("\\w*(\\s*|#|\\.|\\w+)+\\w+", newText)) {
                                if (!Pattern.matches("\\w*(#|\\.|\\w*)+\\w+", newText)) {//$NON-NLS-1$
                                    return Messages.NewXObjectAction_NameCannotContainInvalid;
                                }
                                return null;
                            };
                        });
                id1.setBlockOnOpen(true);
                if (id1.open() == Window.CANCEL)
                    return;
                key = id1.getValue();
                break;
            default:
                // server or not supported
                return;
            }// switch

            // Access to server and get port
            XtentisPort port = Util.getPort(new URL(xobject.getEndpointAddress()), xobject.getUniverse(), xobject.getUsername(),
                    xobject.getPassword());

            // create a new bare Instance
            TreeObject newInstance = null;
            switch (xobject.getType()) {

            case TreeObject.DATA_MODEL: {
                // check if already exists
                if (port.existsDataModel(new WSExistsDataModel(new WSDataModelPK((String) key))).is_true()) {
                    MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance,
                            Messages.bind(Messages.NewXObjectAction_ErrorMsg, (String) key));
                    return;
                }
                WSDataModelPK[] dataModelPKs = port.getDataModelPKs(new WSRegexDataModelPKs("*")).getWsDataModelPKs(); //$NON-NLS-1$
                for (WSDataModelPK dataModel : dataModelPKs) {
                    String pk = dataModel.getPk();
                    if (pk.equalsIgnoreCase((String) key)) {
                        MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance,
                                Messages.bind(Messages.NewXObjectAction_ErrorMsg, ""));
                        return;
                    }
                }

                // add
                WSDataModel wsDataModel = new WSDataModel((String) key, "", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"//$NON-NLS-1$//$NON-NLS-2$
                        + "<xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"/>");//$NON-NLS-1$
                port.putDataModel(new WSPutDataModel(wsDataModel));
                newInstance = new TreeObject((String) key, xfolder.getServerRoot(), TreeObject.DATA_MODEL, new WSDataModelPK(
                        (String) key), wsDataModel);
                newInstance.setWsObject(wsDataModel);
                xfolder.addChild(newInstance);
                XSDEditorUtil.openDataModel(newInstance, true);
                return;
            }

            case TreeObject.VIEW: {
                // check if already exists
                if (port.existsView(new WSExistsView(new WSViewPK((String) key))).is_true()) {
                    MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance,
                            Messages.bind(Messages.NewXObjectAction_ErrorMsg2, (String) key));
                    return;
                }
                // add
                WSDataModelPK[] dataModelPKs = Util.getAllDataModelPKs(new URL(xobject.getEndpointAddress()),
                        xobject.getUniverse(), xobject.getUsername(), xobject.getPassword());
                String firstDataModel = null;
                for (int i = 0; i < dataModelPKs.length; i++) {
                    if (dataModelPKs[i].getPk().indexOf("XMLSCHEMA--") == -1) {//$NON-NLS-1$
                        firstDataModel = dataModelPKs[i].getPk();
                        break;
                    }
                }
                if (firstDataModel == null) {
                    MessageDialog.openError(view.getSite().getShell(), Messages._Error,
                            Messages.NewXObjectAction_ErrorMsg3);
                    return;
                }
                WSDataClusterPK[] dataClusterPKs = Util.getAllDataClusterPKs(new URL(xobject.getEndpointAddress()),
                        xobject.getUniverse(), xobject.getUsername(), xobject.getPassword());
                String firstItemCluster = null;
                for (int i = 0; i < dataClusterPKs.length; i++) {
                    if (!dataClusterPKs[i].getPk().equals("CACHE")) { // FIXME: hardcoded CACHE//$NON-NLS-1$
                        firstItemCluster = dataClusterPKs[i].getPk();
                        break;
                    }
                }
                if (firstItemCluster == null) {
                    MessageDialog.openError(view.getSite().getShell(), Messages._Error,
                            Messages.NewXObjectAction_ErrorMsg4);
                    return;
                }
                WSView wsview = new WSView((String) key, "", new String[] {}, new WSWhereCondition[0], new String[] {}, null,//$NON-NLS-1$
                        new WSBoolean(false));
                // port.putView(new WSPutView(view));
                newInstance = new TreeObject((String) key, xfolder.getServerRoot(), TreeObject.VIEW, new WSViewPK((String) key),
                        wsview);
                break;
            }

            case TreeObject.DATA_CLUSTER: {
                // check if already exists
                if (port.existsDataCluster(new WSExistsDataCluster(new WSDataClusterPK((String) key))).is_true()) {
                    MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance,
                            Messages.bind(Messages.NewXObjectAction_ErrorMsg5, (String) key));
                    return;
                }
                // add
                WSDataCluster dc = new WSDataCluster((String) key, "", "" // vocabulary//$NON-NLS-1$//$NON-NLS-2$
                );
                newInstance = new TreeObject((String) key, xfolder.getServerRoot(), TreeObject.DATA_CLUSTER, new WSDataClusterPK(
                        (String) key), dc);
                break;
            }

            case TreeObject.STORED_PROCEDURE: {
                // check if already exists
                if (port.existsStoredProcedure(new WSExistsStoredProcedure(new WSStoredProcedurePK((String) key))).is_true()) {
                    MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance,
                            Messages.bind(Messages.NewXObjectAction_ErrorMsg6, (String) key));
                    return;
                }
                // add
                WSStoredProcedure storedProcedure = new WSStoredProcedure((String) key, "", "", false);//$NON-NLS-1$//$NON-NLS-2$
                newInstance = new TreeObject((String) key, xfolder.getServerRoot(), TreeObject.STORED_PROCEDURE,
                        new WSStoredProcedurePK((String) key), storedProcedure);
                break;
            }

            case TreeObject.ROLE: {
                // check if already exists
                if (port.existsRole(new WSExistsRole(new WSRolePK((String) key))).is_true()) {
                    MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance,
                            Messages.bind(Messages.NewXObjectAction_ErrorMsg7, (String) key));
                    return;
                }
                // add
                WSRole role = new WSRole((String) key, "", null);//$NON-NLS-1$

                newInstance = new TreeObject((String) key, xfolder.getServerRoot(), TreeObject.ROLE, new WSRolePK((String) key),
                        role);
                break;
            }

            case TreeObject.ROUTING_RULE: {
                // check if already exists
                if (port.existsRoutingRule(new WSExistsRoutingRule(new WSRoutingRulePK((String) key))).is_true()) {
                    MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance,
                            Messages.bind(Messages.NewXObjectAction_ErrorMsg8, (String) key));
                    return;
                }
                // add
                WSRoutingRule routingRule = new WSRoutingRule((String) key, "", false, "*", "", "",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
                        new WSRoutingRuleExpression[0], null, false);
                newInstance = new TreeObject((String) key, xfolder.getServerRoot(), TreeObject.ROUTING_RULE, new WSRoutingRulePK(
                        (String) key), routingRule);
                break;
            }

            case TreeObject.TRANSFORMER: {
                // check if already exists
                if (port.existsTransformerV2(new WSExistsTransformerV2(new WSTransformerV2PK((String) key))).is_true()) {
                    MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance,
                            Messages.bind(Messages.NewXObjectAction_ErrorMsg9, (String) key));
                    return;
                }
                // add
                WSTransformerV2 transformer = new WSTransformerV2((String) key, "", null);//$NON-NLS-1$
                if (key.toString().startsWith("Smart_view_")) {//$NON-NLS-1$
                    final String parameters = "<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version='1.0'>\n"//$NON-NLS-1$
                            + "   <xsl:output method='html' indent='yes' omit-xml-declaration='yes'/>\n"//$NON-NLS-1$
                            + "   <xsl:template match='/'>\n" + "       <html>\n"//$NON-NLS-1$//$NON-NLS-2$
                            + "          <head><title>Smart View</title></head>\n" + "          <body>\n"//$NON-NLS-1$//$NON-NLS-2$ 
                            + "            <h1>This is the default Smart View for: <xsl:value-of select='./text()'/></h1>\n"//$NON-NLS-1$
                            + "            <xsl:copy-of select='.'/>\n" + "            <!-- Customize the stylesheet -->\n"//$NON-NLS-1$//$NON-NLS-2$
                            + "          </body>\n" + "       </html>\n" + "    </xsl:template>" + "</xsl:stylesheet>";//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$

                    final String TRANSFORMER_PLUGIN = "amalto/local/transformer/plugin/xslt";//$NON-NLS-1$

                    List<WSTransformerVariablesMapping> inItems = new ArrayList<WSTransformerVariablesMapping>();
                    WSTransformerVariablesMapping inputLine = new WSTransformerVariablesMapping();
                    inputLine.setPipelineVariable("_DEFAULT_");//$NON-NLS-1$
                    inputLine.setPluginVariable("xml");//$NON-NLS-1$
                    inItems.add(inputLine);

                    List<WSTransformerVariablesMapping> outItems = new ArrayList<WSTransformerVariablesMapping>();
                    WSTransformerVariablesMapping outputLine = new WSTransformerVariablesMapping();
                    outputLine.setPipelineVariable("html");//$NON-NLS-1$
                    outputLine.setPluginVariable("text");//$NON-NLS-1$
                    outItems.add(outputLine);

                    ArrayList<WSTransformerProcessStep> list = new ArrayList<WSTransformerProcessStep>();
                    WSTransformerProcessStep step = new WSTransformerProcessStep(TRANSFORMER_PLUGIN, "Stylesheet", parameters,//$NON-NLS-1$
                            inItems.toArray(new WSTransformerVariablesMapping[inItems.size()]),
                            outItems.toArray(new WSTransformerVariablesMapping[outItems.size()]), false);
                    list.add(step);
                    transformer.setProcessSteps(list.toArray(new WSTransformerProcessStep[list.size()]));
                }
                newInstance = new TreeObject((String) key, xfolder.getServerRoot(), TreeObject.TRANSFORMER,
                        new WSTransformerV2PK((String) key), transformer);
                break;
            }

            case TreeObject.MENU: {
                // check if already exists
                if (port.existsMenu(new WSExistsMenu(new WSMenuPK((String) key))).is_true()) {
                    MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance,
                            Messages.bind(Messages.NewXObjectAction_ErrorMsg10, (String) key));
                    return;
                }
                // add
                WSMenu menu = new WSMenu((String) key, "", new WSMenuEntry[] { new WSMenuEntry((String) key,//$NON-NLS-1$
                        new WSMenuMenuEntriesDescriptions[] { new WSMenuMenuEntriesDescriptions("en", (String) key) }, null,//$NON-NLS-1$
                        null, null, null) });
                newInstance = new TreeObject((String) key, xfolder.getServerRoot(), TreeObject.MENU, new WSMenuPK((String) key),
                        menu);
                break;
            }
            case TreeObject.UNIVERSE: {
                // check if already exists
                if (port.existsUniverse(new WSExistsUniverse(new WSUniversePK((String) key))).is_true()) {
                    MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance, Messages.bind(Messages.NewXObjectAction_ErrorMsg11, (String) key
                            ));
                    return;
                }
                // add
                List<WSUniverseXtentisObjectsRevisionIDs> objectsId = new ArrayList<WSUniverseXtentisObjectsRevisionIDs>();
                for (String object : port.getObjectsForUniverses(new WSGetObjectsForUniverses(new String[] { ".*" }))//$NON-NLS-1$
                        .getStrings()) {// IConstants.XTENTISOBJECTS){
                    objectsId.add(new WSUniverseXtentisObjectsRevisionIDs(object, ""));//$NON-NLS-1$
                }
                WSUniverse universe = new WSUniverse((String) key, "",//$NON-NLS-1$
                        objectsId.toArray(new WSUniverseXtentisObjectsRevisionIDs[objectsId.size()]), "",//$NON-NLS-1$
                        new WSUniverseItemsRevisionIDs[] {});
                newInstance = new TreeObject((String) key, xfolder.getServerRoot(), TreeObject.UNIVERSE, new WSUniversePK(
                        (String) key), universe);
                break;
            }
            case TreeObject.SYNCHRONIZATIONPLAN: {
                // check if already exists
                if (port.existsSynchronizationPlan(new WSExistsSynchronizationPlan(new WSSynchronizationPlanPK((String) key)))
                        .is_true()) {
                    MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance,
                            Messages.bind(Messages.NewXObjectAction_ErrorMsg12, (String) key));
                    return;
                }
                // add
                List<WSSynchronizationPlanXtentisObjectsSynchronizations> objectsId = new ArrayList<WSSynchronizationPlanXtentisObjectsSynchronizations>();
                for (String object : port.getObjectsForSynchronizationPlans(
                        new WSGetObjectsForSynchronizationPlans(new String[] { ".*" })).getStrings()) {// IConstants.XTENTISOBJECTS){//$NON-NLS-1$
                    objectsId.add(new WSSynchronizationPlanXtentisObjectsSynchronizations(object,
                            new WSSynchronizationPlanXtentisObjectsSynchronizationsSynchronizations[0]));
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(0);
                WSSynchronizationPlan synchronizationPlan = new WSSynchronizationPlan((String) key, "", "", "", "", "", "", "",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$
                        "", "", objectsId.toArray(new WSSynchronizationPlanXtentisObjectsSynchronizations[objectsId.size()]),//$NON-NLS-1$//$NON-NLS-2$
                        new WSSynchronizationPlanItemsSynchronizations[] {});
                newInstance = new TreeObject((String) key, xfolder.getServerRoot(), TreeObject.SYNCHRONIZATIONPLAN,
                        new WSSynchronizationPlanPK((String) key), synchronizationPlan);
                break;
            }
            case TreeObject.CUSTOM_TYPE: {
                // check if already exists
                if (port.existsUniverse(new WSExistsUniverse(new WSUniversePK((String) key))).is_true()) {
                    MessageDialog.openError(this.view.getSite().getShell(), Messages.NewXObjectAction_ErrorCreatingInstance,
                            Messages.bind(Messages.NewXObjectAction_ErrorMsg13, (String) key));
                    return;
                }
                // add
                newInstance = new TreeObject((String) key, xfolder.getServerRoot(), TreeObject.CUSTOM_TYPE, null, null);
                break;
            }
            default:
                // server
                return;
            }// switch
            {
                LocalTreeObjectRepository.getInstance().mergeNewTreeObject(newInstance);

                XObjectEditor editpart = (XObjectEditor) view
                        .getSite()
                        .getWorkbenchWindow()
                        .getActivePage()
                        .openEditor(new XObjectEditorInput(newInstance, newInstance.getDisplayName()),
                                "com.amalto.workbench.editors.XObjectEditor"); //$NON-NLS-1$

                /*
                 * make the new page dirty
                 */
                if (editpart.getSelectedPage() instanceof AMainPage)
                    ((AMainPage) editpart.getSelectedPage()).markDirty();
                if (editpart.getSelectedPage() instanceof AMainPageV2)
                    ((AMainPageV2) editpart.getSelectedPage()).markDirty();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            if(!Util.handleConnectionException(view, e, null)){
                MessageDialog.openError(view.getSite().getShell(), Messages._Error,
                    Messages.bind(Messages.NewXObjectAction_ErrorMsg14, IConstants.TALEND, e.getLocalizedMessage()));
            }
        }
    }

    @Override
    public void runWithEvent(Event event) {
        super.runWithEvent(event);
    }

}
