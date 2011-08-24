// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.export;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.progress.UIJob;
import org.exolab.castor.xml.Unmarshaller;
import org.talend.mdm.bulkload.client.BulkloadClient;
import org.talend.mdm.bulkload.client.BulkloadOptions;
import org.talend.mdm.commmon.util.core.ICoreConstants;
import org.talend.mdm.commmon.util.workbench.ZipToFile;

import com.amalto.workbench.actions.ServerRefreshAction;
import com.amalto.workbench.availablemodel.AvailableModelUtil;
import com.amalto.workbench.availablemodel.IAvailableModel;
import com.amalto.workbench.dialogs.ImportExchangeOptionsDialog;
import com.amalto.workbench.editors.XObjectBrowser;
import com.amalto.workbench.editors.XObjectEditor;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.providers.XObjectBrowserInput;
import com.amalto.workbench.utils.EXtentisObjects;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XmlUtil;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.views.ServerView;
import com.amalto.workbench.webservices.WSAutoIncrement;
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
import com.amalto.workbench.webservices.WSExistsTransformer;
import com.amalto.workbench.webservices.WSExistsTransformerV2;
import com.amalto.workbench.webservices.WSExistsUniverse;
import com.amalto.workbench.webservices.WSExistsView;
import com.amalto.workbench.webservices.WSItem;
import com.amalto.workbench.webservices.WSMenu;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSPutDataCluster;
import com.amalto.workbench.webservices.WSPutDataModel;
import com.amalto.workbench.webservices.WSPutMenu;
import com.amalto.workbench.webservices.WSPutRole;
import com.amalto.workbench.webservices.WSPutRoutingRule;
import com.amalto.workbench.webservices.WSPutStoredProcedure;
import com.amalto.workbench.webservices.WSPutSynchronizationPlan;
import com.amalto.workbench.webservices.WSPutTransformer;
import com.amalto.workbench.webservices.WSPutTransformerV2;
import com.amalto.workbench.webservices.WSPutUniverse;
import com.amalto.workbench.webservices.WSPutView;
import com.amalto.workbench.webservices.WSRole;
import com.amalto.workbench.webservices.WSRolePK;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRuleExpression;
import com.amalto.workbench.webservices.WSRoutingRuleOperator;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.WSStoredProcedure;
import com.amalto.workbench.webservices.WSStoredProcedurePK;
import com.amalto.workbench.webservices.WSStringPredicate;
import com.amalto.workbench.webservices.WSSynchronizationPlan;
import com.amalto.workbench.webservices.WSSynchronizationPlanPK;
import com.amalto.workbench.webservices.WSTransformer;
import com.amalto.workbench.webservices.WSTransformerPK;
import com.amalto.workbench.webservices.WSTransformerV2;
import com.amalto.workbench.webservices.WSTransformerV2PK;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.WSView;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.WSWhereCondition;
import com.amalto.workbench.webservices.WSWhereOperator;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.FileSelectWidget;
import com.amalto.workbench.widgets.RepositoryCheckTreeViewer;
import com.amalto.workbench.widgets.WidgetFactory;

public class ImportItemsWizard extends Wizard {

    private static Log log = LogFactory.getLog(ImportItemsWizard.class);

    protected IStructuredSelection sel;

    protected RepositoryCheckTreeViewer treeViewer;

    protected String importFolder;

    private StringBuffer zipFileRepository = new StringBuffer();;

    protected FileSelectWidget folder;

    private Button zipBtn;

    protected Button folderBtn;

    protected FileSelectWidget zip;

    private ServerView view;

    // private List<TreeObject> objList =new ArrayList<TreeObject>();
    private Hashtable<String, String[]> dataClusterContent = new Hashtable<String, String[]>();

    private TreeParent serverRoot;

    private XtentisPort port = null;

    protected Button btnOverwrite = null;

    protected boolean isOverride = false;

    public ImportItemsWizard(IStructuredSelection sel, ServerView view) {
        setNeedsProgressMonitor(true);
        this.sel = sel;
        this.view = view;
        serverRoot = ((TreeObject) sel.getFirstElement()).getServerRoot();
        try {
            port = Util.getPort((TreeObject) sel.getFirstElement());
        } catch (XtentisException e3) {
            log.error(e3.getMessage(), e3);
        }
    }

    public ImportItemsWizard(IStructuredSelection sel) {
        setNeedsProgressMonitor(true);
        this.sel = sel;
    }

    protected void refreshViewJob() {
        new UIJob("Refreshing server") {

            @Override
            public IStatus runInUIThread(IProgressMonitor monitor) {
                new ServerRefreshAction(view, serverRoot).run();
                return Status.OK_STATUS;
            }

        }.schedule();
    }

    @Override
    public boolean performFinish() {
        closeOpenEditors();
        final String zipFilePath = getZipFilePath();
        final boolean selectZip = zipBtn.getSelection();
        if (selectZip) {

            // importFolder= System.getProperty("user.dir")+"/temp";
            try {

                ZipToFile.unZipFile(zipFilePath, importFolder);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        if (folderBtn.getSelection()) {
            importFolder = folder.getText().getText();
        }

        final Object[] objs = treeViewer.getCheckNodes();
        UIJob job = new UIJob("Import Objects ...") {

            @Override
            public IStatus runInUIThread(IProgressMonitor monitor) {
                try {

                    doImport(objs, monitor);
                    // run initMDM to call backend migration task
                    if (port != null) {
                        port.initMDM(null);
                    }
                    return Status.OK_STATUS;
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    return Status.CANCEL_STATUS;
                } finally {
                    refreshViewJob();
                    // modified by honghb ,fix bug 21552
                    if (selectZip && zipFilePath != null) {
                        importFolder = System.getProperty("user.dir") + "/temp";//$NON-NLS-1$//$NON-NLS-2$
                        ZipToFile.deleteDirectory(new File(importFolder));
                    }
                }
            }

        };
        job.setPriority(Job.INTERACTIVE);
        job.schedule();

        return true;
    }

    private String getZipFilePath() {
        return zip.getText().getText();
    }

    private void closeOpenEditors() {
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        int length = page.getEditors().length;
        String version = "";
        String tabEndpointAddress = "";
        String unserName = null;
        int j = 0;
        for (int i = 0; i < length; i++) {
            IEditorPart part = page.getEditors()[i - j];
            if (part instanceof XObjectBrowser) {
                version = ((TreeObject) ((XObjectBrowserInput) part.getEditorInput()).getModel()).getUniverse();
                tabEndpointAddress = ((TreeObject) ((XObjectBrowserInput) part.getEditorInput()).getModel()).getEndpointAddress();
                unserName = ((TreeObject) ((XObjectBrowserInput) part.getEditorInput()).getModel()).getUsername();
            } else if (part instanceof XObjectEditor) {
                version = ((XObjectEditor) part).getInitialXObject().getServerRoot().getUniverse();
                tabEndpointAddress = ((XObjectEditor) part).getInitialXObject().getServerRoot().getEndpointAddress();
                unserName = ((XObjectEditor) part).getInitialXObject().getServerRoot().getUsername();
            }
            if (serverRoot.getUniverse().equals(version) && serverRoot.getEndpointAddress().equals(tabEndpointAddress)
                    && serverRoot.getUsername().equals(unserName)) {
                if (part.isDirty() && isSaveModifiedEditor(part.getTitle()))
                    part.doSave(new NullProgressMonitor());
                page.closeEditor(part, false);
                j++;
            }
        }

    }

    private boolean isSaveModifiedEditor(String editorName) {
        final MessageDialog dialog = new MessageDialog(view.getSite().getShell(), "Save Resource", null, "'" + editorName
                + "' has been modified. Save changes?", MessageDialog.QUESTION, new String[] { IDialogConstants.YES_LABEL,
                IDialogConstants.NO_LABEL }, 0);
        dialog.open();
        if (dialog.getReturnCode() == 0)
            return true;
        return false;
    }

    public boolean performCancel() {
        LocalTreeObjectRepository.getInstance().cancelMergeImportCategory(serverRoot);
        return super.performCancel();
    }

    private void checkUpExchangeImport(boolean check) {
        if (check) {
            if (!zipFileRepository.toString().equals("")) {//$NON-NLS-1$
                int pos = zipFileRepository.toString().lastIndexOf(File.separator);
                importFolder = zipFileRepository.toString().substring(0, pos);
            }
        } else {
            if (zipFileRepository.length() > 0)
                zipFileRepository.delete(0, zipFileRepository.length());
        }

    }

    protected void parse() {
        try {
            boolean importFromArchieve = zipBtn.getSelection();
            if (importFromArchieve) {
                importFolder = System.getProperty("user.dir") + File.separator + "temp" + File.separator + "tmp"//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
                        + System.currentTimeMillis();
            }
            if (folderBtn.getSelection()) {
                importFolder = folder.getText().getText();
            }
            getContainer().run(true, false, new ImportProcess(importFromArchieve, getZipFilePath()));
        } catch (InvocationTargetException e) {
            log.error(e.getMessage(), e);
        } catch (InterruptedException e) {
            log.debug(e.getMessage(), e);
        }
    }

    class ImportProcess implements IRunnableWithProgress {

        private final boolean importFromArchieve;

        private final String zipFilePath;

        public ImportProcess(boolean importFromArchieve, String zipFilePath) {
            this.importFromArchieve = importFromArchieve;
            this.zipFilePath = zipFilePath;

        }

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            parses(importFromArchieve, zipFilePath, monitor);
        }
    };

    protected void parses(boolean importFromArchieve, String zipFilePath, IProgressMonitor monitor) {
        // init var for progressMonitor
        int total = 500, zipCount = 200, readCount = 100;
        int step = 1, interval = 1;
        //
        monitor.beginTask("ImportItem", total);

        if (importFromArchieve) {
            checkUpExchangeImport(true);
            try {
                Util.unZipFile(zipFilePath, importFolder, zipCount, monitor);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        monitor.worked(zipCount);
        monitor.setTaskName("Reading items...");
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(importFolder + "/exportitems.xml"), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$
            final Exports exports = (Exports) Unmarshaller.unmarshal(Exports.class, reader);
            String[] orgSchemas = exports.getSchemas();
            int idx = 0;

            if (orgSchemas != null) {
                for (String orgSchema : orgSchemas) {
                    String orgSchemaCpy = new String(orgSchema);
                    for (Map.Entry<String, String> pair : ICoreConstants.rolesConvert.oldRoleToNewRoleMap.entrySet()) {
                        orgSchemaCpy = orgSchemaCpy.replaceAll(pair.getKey().toString(), pair.getValue().toString());
                    }
                    if (!orgSchemaCpy.equals(orgSchema)) {
                        orgSchemas[idx] = orgSchemaCpy;
                    }
                    idx++;
                }
            }

            try {
                LocalTreeObjectRepository.getInstance().makeUpDocWithImportCategory(orgSchemas, serverRoot);
            } catch (Exception e) {
            }

            // import autoincrement
            if (exports.getAutoIncrement() != null) {
                try {
                    port.getAutoIncrement(new WSAutoIncrement(exports.getAutoIncrement()));
                } catch (Exception e) {
                }
            }
            // new server root
            final TreeParent reserverRoot = new TreeParent(serverRoot.getDisplayName(), null, TreeObject._SERVER_,
                    serverRoot.getWsKey(), serverRoot.getWsObject());
            reserverRoot.setUser(serverRoot.getUser());
            // serverRoot=reserverRoot;
            TreeParent clusters = new TreeParent(EXtentisObjects.DataCluster.getDisplayName(), reserverRoot,
                    TreeObject.DATA_CLUSTER, null, null);
            TreeParent models = new TreeParent(EXtentisObjects.DataMODEL.getDisplayName(), reserverRoot, TreeObject.DATA_MODEL,
                    null, null);
            TreeParent menus = new TreeParent(EXtentisObjects.Menu.getDisplayName(), reserverRoot, TreeObject.MENU, null, null);
            TreeParent roles = new TreeParent(EXtentisObjects.Role.getDisplayName(), reserverRoot, TreeObject.ROLE, null, null);
            TreeParent eventManager = new TreeParent(EXtentisObjects.EventManagement.getDisplayName(), reserverRoot,
                    TreeObject.EVENT_MANAGEMENT, null, null);
            TreeParent routingrules = new TreeParent(EXtentisObjects.RoutingRule.getDisplayName(), reserverRoot,
                    TreeObject.ROUTING_RULE, null, null);
            TreeParent storeprocedures = new TreeParent(EXtentisObjects.StoredProcedure.getDisplayName(), reserverRoot,
                    TreeObject.STORED_PROCEDURE, null, null);
            TreeParent syncplans = new TreeParent(EXtentisObjects.SynchronizationPlan.getDisplayName(), reserverRoot,
                    TreeObject.SYNCHRONIZATIONPLAN, null, null);
            TreeParent transformers = new TreeParent(EXtentisObjects.Transformer.getDisplayName(), reserverRoot,
                    TreeObject.TRANSFORMER, null, null);
            TreeParent pictures = new TreeParent(EXtentisObjects.PICTURESRESOURCE.getDisplayName(), reserverRoot,
                    TreeObject.PICTURES_RESOURCE, null, null);
            // add by ymli
            TreeParent workflow = new TreeParent(EXtentisObjects.Workflow.getDisplayName(), reserverRoot, TreeObject.WORKFLOW,
                    null, null);
            TreeParent universes = new TreeParent(EXtentisObjects.Universe.getDisplayName(), reserverRoot, TreeObject.UNIVERSE,
                    null, null);
            TreeParent views = new TreeParent(EXtentisObjects.View.getDisplayName(), reserverRoot, TreeObject.VIEW, null, null);
            reserverRoot.addChild(clusters);
            reserverRoot.addChild(models);
            reserverRoot.addChild(menus);
            reserverRoot.addChild(roles);

            reserverRoot.addChild(storeprocedures);
            reserverRoot.addChild(syncplans);
            eventManager.addChild(transformers);
            eventManager.addChild(routingrules);
            reserverRoot.addChild(eventManager);
            reserverRoot.addChild(pictures);
            reserverRoot.addChild(workflow);
            reserverRoot.addChild(universes);
            reserverRoot.addChild(views);
            monitor.worked(readCount);
            // caculate step and interval
            float val = (total - zipCount - readCount) / exports.getItems().length;
            if (val > 0) {
                interval = 1;
                step = Math.round(val);
            } else {
                step = 1;
                interval = Math.round(exports.getItems().length / (total - zipCount - readCount) + 0.5f);
            }
            // System.out.println("count:" + exports.getItems().length + "\tinterval:" + interval + "\tstep:" + step);
            monitor.setTaskName("Importing item...");
            //
            int tmp = 1;
            for (TreeObject obj : exports.getItems()) {
                obj.setServerRoot(reserverRoot);
                switch (obj.getType()) {
                case TreeObject.DATA_CLUSTER:
                    clusters.addChild(obj);
                    break;
                case TreeObject.DATA_MODEL:
                    models.addChild(obj);
                    break;
                case TreeObject.MENU:
                    menus.addChild(obj);
                    break;
                case TreeObject.ROLE:
                    roles.addChild(obj);
                    break;
                case TreeObject.ROUTING_RULE:
                    routingrules.addChild(obj);
                    break;
                case TreeObject.STORED_PROCEDURE:
                    storeprocedures.addChild(obj);
                    break;
                case TreeObject.SYNCHRONIZATIONPLAN:
                    syncplans.addChild(obj);
                    break;
                case TreeObject.TRANSFORMER:
                    transformers.addChild(obj);
                    break;
                case TreeObject.PICTURES_RESOURCE:
                    pictures.addChild(obj);
                    break;
                case TreeObject.WORKFLOW_PROCESS:
                    workflow.addChild(obj);
                    break;
                case TreeObject.UNIVERSE:
                    universes.addChild(obj);
                    break;
                case TreeObject.VIEW:
                    views.addChild(obj);
                    break;
                default:
                    if (obj.getItems() != null && obj.getItems().length > 0) {
                        for (int i = 0; i < obj.getItems().length; i++) {
                            if (obj.getItems()[i].split("/")[1] != null)
                                dataClusterContent.put(obj.getItems()[i].split("/")[1], obj.getItems());
                        }
                    }
                }
                // update monitor
                if (interval == 1) {
                    monitor.worked(step);
                } else {
                    if (tmp >= interval) {
                        monitor.worked(step);
                        tmp = 1;
                    } else {
                        tmp++;
                    }
                }
            }
            Display.getDefault().syncExec(new Runnable() {

                public void run() {
                    treeViewer.setRoot(reserverRoot);
                    treeViewer.getViewer().setInput(view.getSite());
                    treeViewer.setCheckItems(Arrays.asList(exports.getItems()));
                    GridData gd = (GridData) treeViewer.getViewer().getControl().getLayoutData();
                    gd.heightHint = 300;
                    treeViewer.getViewer().getControl().getParent().layout(true);
                    treeViewer.getViewer().getControl().getShell().layout(true);
                    try {
                        Object[] checkNodes = treeViewer.getCheckNodes();
                        if (checkNodes != null) {
                            LocalTreeObjectRepository.getInstance().setOriginalXobjectsToImport((TreeObject[]) checkNodes);
                        }
                    } catch (Exception e) {
                    }
                }
            });

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (Exception e) {
            }
            monitor.done();
        }

    }

    private int isOveride(String name, String obTypeName) {

        final MessageDialog dialog = new MessageDialog(view.getSite().getShell(), "Confirm Overwrite", null,
                "There is already a " + obTypeName + " named " + name
                        + ". Do you really want to overwrite it with the new one when the export runs?", MessageDialog.QUESTION,
                new String[] { IDialogConstants.YES_LABEL, IDialogConstants.YES_TO_ALL_LABEL, IDialogConstants.NO_LABEL,
                        IDialogConstants.CANCEL_LABEL }, 0);
        dialog.open();
        int result = dialog.getReturnCode();
        if (result == 0) {
            return IDialogConstants.YES_ID;
        }
        if (result == 1) {
            return IDialogConstants.YES_TO_ALL_ID;
        }
        if (result == 2) {
            return IDialogConstants.NO_ID;
        }
        return IDialogConstants.CANCEL_ID;

    }

    public void doImport(Object[] selectedObjs, IProgressMonitor monitor) {
        TreeObject[] objs = null;
        if (selectedObjs.length > 0 && selectedObjs[0] instanceof TreeObject) {
            objs = Arrays.asList(selectedObjs).toArray(new TreeObject[0]);
        }
        if (objs == null || objs.length == 0)
            return;
        monitor.beginTask("Import ...", IProgressMonitor.UNKNOWN);
        Reader reader = null;
        // sort the objs for first import data_model.
        Arrays.sort(objs, new Comparator<Object>() {

            public int compare(Object o1, Object o2) {
                return ((TreeObject) o1).getType() - ((TreeObject) o2).getType();
            }
        });
        LocalTreeObjectRepository.getInstance().mergeImportCategory(objs, serverRoot);
        boolean isOverrideAll = false;
        HashMap<String, String> picturePathMap = new HashMap<String, String>();
        String[] subItems;
        for (TreeObject item : objs) {

            if (item.getType() == TreeObject.PICTURES_RESOURCE) {

                subItems = item.getItems();

                for (String subItem : subItems) {
                    try {
                        Util.uploadImageFile(serverRoot.getEndpointIpAddress() + "/imageserver/secure/ImageUploadServlet",//$NON-NLS-1$
                                importFolder + "/" + subItem, serverRoot.getUsername(), serverRoot.getPassword(), picturePathMap);//$NON-NLS-1$
                    } catch (Exception e2) {
                        log.error(e2.getMessage(), e2);
                    }
                }
            }
        }

        for (TreeObject item : objs) {
            switch (item.getType()) {

            case TreeObject.DATA_CLUSTER:
                // datacluster
                monitor.subTask(" Data Container...");
                subItems = item.getItems();

                for (String subItem : subItems) {
                    try {
                        reader = new InputStreamReader(new FileInputStream(importFolder + "/" + subItem), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$
                        WSDataCluster model = new WSDataCluster();
                        model = (WSDataCluster) Unmarshaller.unmarshal(WSDataCluster.class, reader);
                        if (port.existsDataCluster(new WSExistsDataCluster(new WSDataClusterPK(model.getName()))).is_true()) {
                            if (!isOverrideAll) {
                                int result = isOveride(model.getName(), TreeObject.DATACONTAINER);
                                if (result == IDialogConstants.CANCEL_ID) {
                                    return;
                                }
                                if (result == IDialogConstants.YES_TO_ALL_ID) {
                                    isOverrideAll = true;
                                }
                                if (result == IDialogConstants.NO_ID) {
                                    break;
                                }

                            }
                        }
                        port.putDataCluster(new WSPutDataCluster(model));
                    } catch (Exception e1) {
                        log.error(e1.getMessage(), e1);
                    } finally {
                        try {
                            if (reader != null)
                                reader.close();
                        } catch (Exception e) {
                        }
                    }

                    try {
                        importClusterContents(item, port, picturePathMap);
                    } catch (Exception e) {
                        MessageDialog.openWarning(null, "Warning", e.getLocalizedMessage());
                    }
                }
                monitor.worked(1);
                break;
            case TreeObject.DATA_MODEL:
                monitor.subTask(" Data Model...");
                subItems = item.getItems();

                for (String subItem : subItems) {
                    try {
                        reader = new InputStreamReader(new FileInputStream(importFolder + "/" + subItem), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$
                        WSDataModel model = new WSDataModel();
                        model = (WSDataModel) Unmarshaller.unmarshal(WSDataModel.class, reader);
                        if (port.existsDataModel(new WSExistsDataModel(new WSDataModelPK(model.getName()))).is_true()) {
                            if (!isOverrideAll) {
                                int result = isOveride(model.getName(), TreeObject.DATAMODEL_);
                                if (result == IDialogConstants.CANCEL_ID) {
                                    return;
                                }
                                if (result == IDialogConstants.YES_TO_ALL_ID) {
                                    isOverrideAll = true;
                                }
                                if (result == IDialogConstants.NO_ID) {
                                    break;
                                }

                            }
                        }
                        port.putDataModel(new WSPutDataModel(model));
                    } catch (Exception e2) {
                        log.error(e2.getMessage(), e2);
                    } finally {
                        try {
                            if (reader != null)
                                reader.close();
                        } catch (Exception e) {
                        }
                    }
                }

                monitor.worked(1);
                break;
            case TreeObject.MENU:
                monitor.subTask(" Menu...");
                subItems = item.getItems();

                for (String subItem : subItems) {
                    try {
                        reader = new InputStreamReader(new FileInputStream(importFolder + "/" + subItem), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$
                        WSMenu memu = new WSMenu();
                        memu = (WSMenu) Unmarshaller.unmarshal(WSMenu.class, reader);
                        if (port.existsMenu(new WSExistsMenu(new WSMenuPK(memu.getName()))).is_true()) {
                            if (!isOverrideAll) {
                                int result = isOveride(memu.getName(), TreeObject.MENU_);
                                if (result == IDialogConstants.CANCEL_ID) {
                                    return;
                                }
                                if (result == IDialogConstants.YES_TO_ALL_ID) {
                                    isOverrideAll = true;
                                }
                                if (result == IDialogConstants.NO_ID) {
                                    break;
                                }

                            }
                        }
                        port.putMenu(new WSPutMenu(memu));
                    } catch (Exception e2) {
                        log.error(e2.getMessage(), e2);
                    } finally {
                        try {
                            if (reader != null)
                                reader.close();
                        } catch (Exception e) {
                        }
                    }
                }

                monitor.worked(1);
                break;
            case TreeObject.ROLE:
                if (Util.IsEnterPrise()) {
                    monitor.subTask(" Role...");
                    subItems = item.getItems();

                    for (String subItem : subItems) {
                        try {
                            reader = new InputStreamReader(new FileInputStream(importFolder + "/" + subItem), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$
                            WSRole role = new WSRole();
                            role = (WSRole) Unmarshaller.unmarshal(WSRole.class, reader);
                            if (port.existsRole(new WSExistsRole(new WSRolePK(role.getName()))).is_true()) {
                                if (!isOverrideAll) {
                                    int result = isOveride(role.getName(), TreeObject.ROLE_);
                                    if (result == IDialogConstants.CANCEL_ID) {
                                        return;
                                    }
                                    if (result == IDialogConstants.YES_TO_ALL_ID) {
                                        isOverrideAll = true;
                                    }
                                    if (result == IDialogConstants.NO_ID) {
                                        break;
                                    }

                                }
                            }
                            port.putRole(new WSPutRole(role));
                        } catch (Exception e2) {
                            log.error(e2.getMessage(), e2);
                        } finally {
                            try {
                                if (reader != null)
                                    reader.close();
                            } catch (Exception e) {
                            }
                        }
                    }

                    monitor.worked(1);
                }
                break;
            case TreeObject.ROUTING_RULE:
                monitor.subTask(" Trigger...");
                subItems = item.getItems();

                for (String subItem : subItems) {
                    try {
                        reader = new InputStreamReader(new FileInputStream(importFolder + "/" + subItem), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$
                        WSRoutingRule routingRule = new WSRoutingRule();
                        routingRule = (WSRoutingRule) Unmarshaller.unmarshal(WSRoutingRule.class, reader);

                        if (routingRule.getWsRoutingRuleExpressions() != null) {
                            for (WSRoutingRuleExpression rule : routingRule.getWsRoutingRuleExpressions()) {
                                if (rule.getWsOperator() == null)
                                    rule.setWsOperator(WSRoutingRuleOperator.CONTAINS);
                            }
                        }
                        if (port.existsRoutingRule(new WSExistsRoutingRule(new WSRoutingRulePK(routingRule.getName()))).is_true()) {
                            if (!isOverrideAll) {
                                int result = isOveride(routingRule.getName(), TreeObject.ROUTINGRULE_);
                                if (result == IDialogConstants.CANCEL_ID) {
                                    return;
                                }
                                if (result == IDialogConstants.YES_TO_ALL_ID) {
                                    isOverrideAll = true;
                                }
                                if (result == IDialogConstants.NO_ID) {
                                    break;
                                }

                            }
                        }
                        port.putRoutingRule(new WSPutRoutingRule(routingRule));
                    } catch (Exception e2) {
                        log.error(e2.getMessage(), e2);
                    } finally {
                        try {
                            if (reader != null)
                                reader.close();
                        } catch (Exception e) {
                        }
                    }
                }

                monitor.worked(1);
                break;
            case TreeObject.STORED_PROCEDURE:
                monitor.subTask(" Stored Procedure...");
                subItems = item.getItems();

                for (String subItem : subItems) {
                    try {
                        reader = new InputStreamReader(new FileInputStream(importFolder + "/" + subItem), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$
                        WSStoredProcedure model = new WSStoredProcedure();
                        model = (WSStoredProcedure) Unmarshaller.unmarshal(WSStoredProcedure.class, reader);
                        if (model.getRefreshCache() == null)
                            model.setRefreshCache(false);
                        if (port.existsStoredProcedure(new WSExistsStoredProcedure(new WSStoredProcedurePK(model.getName())))
                                .is_true()) {
                            if (!isOverrideAll) {
                                int result = isOveride(model.getName(), TreeObject.STOREDPROCEDURE_);
                                if (result == IDialogConstants.CANCEL_ID) {
                                    return;
                                }
                                if (result == IDialogConstants.YES_TO_ALL_ID) {
                                    isOverrideAll = true;
                                }
                                if (result == IDialogConstants.NO_ID) {
                                    break;
                                }

                            }
                        }
                        port.putStoredProcedure(new WSPutStoredProcedure(model));

                    } catch (Exception e2) {
                        log.error(e2.getMessage(), e2);
                    } finally {
                        try {
                            if (reader != null)
                                reader.close();
                        } catch (Exception e) {
                        }
                    }
                }

                monitor.worked(1);
                break;
            case TreeObject.SYNCHRONIZATIONPLAN:
                if (Util.IsEnterPrise()) {
                    monitor.subTask(" Synchronization Plan...");
                    subItems = item.getItems();

                    for (String subItem : subItems) {
                        try {
                            reader = new InputStreamReader(new FileInputStream(importFolder + "/" + subItem), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$
                            WSSynchronizationPlan model = new WSSynchronizationPlan();
                            model = (WSSynchronizationPlan) Unmarshaller.unmarshal(WSSynchronizationPlan.class, reader);
                            if (port.existsSynchronizationPlan(
                                    new WSExistsSynchronizationPlan(new WSSynchronizationPlanPK(model.getName()))).is_true()) {
                                if (!isOverrideAll) {
                                    int result = isOveride(model.getName(), TreeObject.SYNCHRONIZATIONPLAN_);
                                    if (result == IDialogConstants.CANCEL_ID) {
                                        return;
                                    }
                                    if (result == IDialogConstants.YES_TO_ALL_ID) {
                                        isOverrideAll = true;
                                    }
                                    if (result == IDialogConstants.NO_ID) {
                                        break;
                                    }

                                }
                            }
                            port.putSynchronizationPlan(new WSPutSynchronizationPlan(model));
                        } catch (Exception e2) {
                            log.error(e2.getMessage(), e2);
                        } finally {
                            try {
                                if (reader != null)
                                    reader.close();
                            } catch (Exception e) {
                            }
                        }
                    }

                    monitor.worked(1);
                }
                break;

            // add by ymli. fix the bug:0012882: Allow workflow bars to be imported
            case TreeObject.WORKFLOW_PROCESS:
                monitor.subTask("Workflow...");
                // available models
                java.util.List<IAvailableModel> availablemodels = AvailableModelUtil.getAvailableModels();
                for (IAvailableModel model : availablemodels) {
                    if (model.toString().indexOf("WorkflowAvailableModel") != -1) {//$NON-NLS-1$
                        model.doImport(item, importFolder);
                    }
                }
                monitor.worked(1);
                break;
            case TreeObject.TRANSFORMER:
                monitor.subTask(" Process...");
                subItems = item.getItems();

                for (String subItem : subItems) {
                    try {
                        reader = new InputStreamReader(new FileInputStream(importFolder + "/" + subItem), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$

                        if (isV2Transformer(importFolder + "/" + subItem)) {//$NON-NLS-1$

                            WSTransformerV2 model = new WSTransformerV2();
                            model = (WSTransformerV2) Unmarshaller.unmarshal(WSTransformerV2.class, reader);
                            if (port.existsTransformerV2(new WSExistsTransformerV2(new WSTransformerV2PK(model.getName())))
                                    .is_true()) {
                                if (!isOverrideAll) {
                                    int result = isOveride(model.getName(), TreeObject.TRANSFORMER_);
                                    if (result == IDialogConstants.CANCEL_ID) {
                                        return;
                                    }
                                    if (result == IDialogConstants.YES_TO_ALL_ID) {
                                        isOverrideAll = true;
                                    }
                                    if (result == IDialogConstants.NO_ID) {
                                        break;
                                    }

                                }
                            }
                            port.putTransformerV2(new WSPutTransformerV2(model));

                        } else {

                            WSTransformer model = new WSTransformer();
                            model = (WSTransformer) Unmarshaller.unmarshal(WSTransformer.class, reader);
                            if (port.existsTransformer(new WSExistsTransformer(new WSTransformerPK(model.getName()))).is_true()) {
                                if (!isOverrideAll) {
                                    int result = isOveride(model.getName(), TreeObject.TRANSFORMER_);
                                    if (result == IDialogConstants.CANCEL_ID) {
                                        return;
                                    }
                                    if (result == IDialogConstants.YES_TO_ALL_ID) {
                                        isOverrideAll = true;
                                    }
                                    if (result == IDialogConstants.NO_ID) {
                                        break;
                                    }

                                }
                            }
                            port.putTransformer(new WSPutTransformer(model));

                        }

                    } catch (Exception e2) {
                        log.error(e2.getMessage(), e2);
                    } finally {
                        try {
                            if (reader != null)
                                reader.close();
                        } catch (Exception e) {
                        }
                    }
                }

                monitor.worked(1);
                break;
            case TreeObject.UNIVERSE:
                if (Util.IsEnterPrise()) {
                    monitor.subTask(" Version...");
                    subItems = item.getItems();

                    for (String subItem : subItems) {
                        try {
                            reader = new InputStreamReader(new FileInputStream(importFolder + "/" + subItem), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$
                            WSUniverse model = new WSUniverse();
                            model = (WSUniverse) Unmarshaller.unmarshal(WSUniverse.class, reader);
                            if (port.existsUniverse(new WSExistsUniverse(new WSUniversePK(model.getName()))).is_true()) {
                                if (!isOverrideAll) {
                                    int result = isOveride(model.getName(), TreeObject.UNIVERSE_);
                                    if (result == IDialogConstants.CANCEL_ID) {
                                        return;
                                    }
                                    if (result == IDialogConstants.YES_TO_ALL_ID) {
                                        isOverrideAll = true;
                                    }
                                    if (result == IDialogConstants.NO_ID) {
                                        break;
                                    }

                                }
                            }
                            port.putUniverse(new WSPutUniverse(model));
                        } catch (Exception e2) {
                            log.error(e2.getMessage(), e2);
                        } finally {
                            try {
                                if (reader != null)
                                    reader.close();
                            } catch (Exception e) {
                            }
                        }
                    }

                    monitor.worked(1);
                }
                break;
            case TreeObject.VIEW:
                monitor.subTask(" View...");
                subItems = item.getItems();

                for (String subItem : subItems) {
                    try {
                        reader = new InputStreamReader(new FileInputStream(importFolder + "/" + subItem), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$
                        WSView model = new WSView();
                        model = (WSView) Unmarshaller.unmarshal(WSView.class, reader);
                        if (model.getIsTransformerActive() == null)
                            model.setIsTransformerActive(new WSBoolean(false));
                        if (model.getTransformerPK() == null)
                            model.setTransformerPK("");//$NON-NLS-1$
                        // TODO: because the operator and stringPredicate can not be export,so if there is any where
                        // condition
                        // now it will add the default operator and string predicate for all the where conditions
                        // automatically.
                        // maybe it needs to be modified later.
                        if (model.getWhereConditions() != null) {
                            for (WSWhereCondition ws : model.getWhereConditions()) {
                                if (ws.getOperator() == null) {
                                    ws.setOperator(WSWhereOperator.CONTAINS);
                                }

                                if (ws.getStringPredicate() == null) {
                                    ws.setStringPredicate(WSStringPredicate.NONE);
                                }
                            }
                        }
                        if (port.existsView(new WSExistsView(new WSViewPK(model.getName()))).is_true()) {
                            if (!isOverrideAll) {
                                int result = isOveride(model.getName(), TreeObject.VIEW_);
                                if (result == IDialogConstants.CANCEL_ID) {
                                    return;
                                }
                                if (result == IDialogConstants.YES_TO_ALL_ID) {
                                    isOverrideAll = true;
                                }
                                if (result == IDialogConstants.NO_ID) {
                                    break;
                                }

                            }
                        }

                        port.putView(new WSPutView(model));
                    } catch (Exception e2) {
                        log.error(e2.getMessage(), e2);
                    } finally {
                        try {
                            if (reader != null)
                                reader.close();
                        } catch (Exception e) {
                        }
                    }
                }

                monitor.worked(1);
                break;
            }
        }

        monitor.done();
    }

    private boolean isV2Transformer(String inputPath) throws DocumentException, FileNotFoundException {

        boolean isV2Transformer = false;
        Document document = XmlUtil.parse(new FileInputStream(inputPath));
        if (document != null && document.getRootElement() != null) {
            String rootElementName = document.getRootElement().getName();
            if (rootElementName.equals(WSTransformerV2.class.getSimpleName())) {
                isV2Transformer = true;
            }
        }
        return isV2Transformer;
    }

    private void importClusterContents(TreeObject item, XtentisPort port, HashMap<String, String> picturePathMap)
            throws Exception {
        if (dataClusterContent.containsKey(item.getDisplayName())) {
            Reader reader = null;
            String[] paths = dataClusterContent.get(item.getDisplayName());
            Map<String, List<String>> conceptMap = new HashMap<String, List<String>>();
            for (int i = 0; i < paths.length; i++) {
                try {
                    String path = paths[i];
                    reader = new InputStreamReader(new FileInputStream(importFolder + "/" + path), "UTF-8");//$NON-NLS-1$//$NON-NLS-2$
                    WSItem wsItem = (WSItem) Unmarshaller.unmarshal(WSItem.class, reader);
                    String key = wsItem.getWsDataClusterPK().getPk() + "##" + wsItem.getConceptName() + "##"//$NON-NLS-1$//$NON-NLS-2$
                            + wsItem.getDataModelName();
                    List<String> list = null;
                    list = conceptMap.get(key);
                    if (list == null) {
                        list = new ArrayList<String>();
                        conceptMap.put(key, list);
                    }
                    // ymli; fix 0016875: set the right path of picture when import pictures
                    String content = wsItem.getContent();
                    boolean isUpdate = false;
                    for (String picturekey : picturePathMap.keySet()) {
                        String fileName = picturekey.substring(picturekey.indexOf("-") + 1);//$NON-NLS-1$
                        if (content.contains(fileName)) {
                            String targetPicturePath = picturePathMap.get(picturekey);
                            content = updatePicturePath(content, picturekey, targetPicturePath);
                            isUpdate = true;
                            list.add(content);
                            conceptMap.put(key, list);
                        }

                    }
                    if (!isUpdate) {
                        list.add(content);
                    }

                } catch (Exception e1) {
                    log.error(e1.getMessage(), e1);
                } finally {
                    try {
                        if (reader != null)
                            reader.close();
                    } catch (Exception e) {
                    }
                }
            }
            // store the items to db using bulkloadclient
            String url = item.getEndpointIpAddress() + "/datamanager/loadServlet";//$NON-NLS-1$
            for (Entry<String, List<String>> entry : conceptMap.entrySet()) {
                String[] keys = entry.getKey().split("##");//$NON-NLS-1$
                String cluster = keys[0];
                String concept = keys[1];
                String datamodel = keys[2];
                BulkloadClient bulkloadClient = new BulkloadClient(url, item.getUsername(), item.getPassword(), null, cluster,
                        concept, datamodel);
                bulkloadClient.setOptions(new BulkloadOptions(false, false, 500));
                StringBuffer sb = new StringBuffer();
                for (String xml : entry.getValue()) {
                    sb.append(xml).append("\n"); //$NON-NLS-1$
                }
                try {
                    bulkloadClient.load(sb.toString());
                } catch (Exception e) {
                    // MessageDialog.openWarning(null, "Warning", "Importing  Entity: "+ concept+
                    // " in Data Container: "+cluster + " Error --> "+e.getLocalizedMessage());
                    throw new Exception("Importing  Entity: " + concept + " in Data Container: " + cluster + " occurs error --> "
                            + e.getLocalizedMessage());
                }
            }
        }
    }

    @Override
    public void addPages() {
        addPage(new SelectItemsPage());
    }

    protected void createOverwriteBtn(Composite composite) {
    }

    class PageListener implements Listener {

        SelectItemsPage page;

        PageListener(SelectItemsPage page) {
            this.page = page;
        }

        public void handleEvent(Event event) {
            page.checkCompleted();
            parse();
        }
    };

    public void checkCompleted() {

    }

    class SelectItemsPage extends WizardPage {

        protected SelectItemsPage() {
            super("SelectFileOrFolderPage");
            setTitle("Select folder or file to import");

            // Page isn't complete until an e-mail address has been added
            setPageComplete(false);

        }

        public void checkCompleted() {
            if (folderBtn.getSelection() && folder.getText().getText().length() > 0
                    && new File(folder.getText().getText()).exists()) {
                setPageComplete(true);
            }
            if (zipBtn.getSelection() && zip.getText().getText().length() > 0
                    && new File(zip.getText().getText()).getParentFile().exists()) {
                setPageComplete(true);
            }
        }

        public void createControl(Composite parent) {
            Composite composite = new Composite(parent, SWT.BORDER);
            composite.setLayout(new GridLayout(4, false));
            composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
            setControl(composite);

            folderBtn = new Button(composite, SWT.RADIO);
            folderBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
            folderBtn.setText("Select root directory:");
            folder = new FileSelectWidget(composite, "", new String[] { "*.*" }, "", false);//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
            // folder.getCmp().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
            // false, 1, 1));
            folderBtn.addSelectionListener(new SelectionListener() {

                public void widgetDefaultSelected(SelectionEvent e) {

                }

                public void widgetSelected(SelectionEvent e) {
                    folder.setEnabled(folderBtn.getSelection());
                    checkCompleted();
                }
            });

            Composite padding = new Composite(composite, SWT.NONE);
            padding.setLayout(new GridLayout(1, false));
            padding.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

            zipBtn = new Button(composite, SWT.RADIO);
            zipBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
            zipBtn.setText("Select archive file:");
            zip = new FileSelectWidget(composite, "", new String[] { "*.zip" }, "", true);//$NON-NLS-1$//$NON-NLS-2$
            // zip.getCmp().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
            // false, 1, 1));
            ((GridData) zip.getText().getLayoutData()).widthHint = 200;

            zip.getText().addListener(SWT.Modify, new PageListener(this));

            final Button exchangeBtn = new Button(composite, SWT.PUSH);
            exchangeBtn.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false, 1, 1));
            exchangeBtn.setText("Import from Talend Exchange");
            exchangeBtn.setEnabled(false);
            exchangeBtn.addSelectionListener(new SelectionListener() {

                public void widgetDefaultSelected(SelectionEvent e) {
                }

                public void widgetSelected(SelectionEvent e) {

                    FormToolkit toolkit = WidgetFactory.getWidgetFactory();
                    ImportExchangeOptionsDialog dlg = new ImportExchangeOptionsDialog(view.getSite().getShell(), toolkit, true,
                            zipFileRepository);
                    dlg.setBlockOnOpen(true);
                    if (dlg.open() == Window.OK) {
                        zip.getText().setText(zipFileRepository.toString());
                        parse();
                        checkUpExchangeImport(false);
                    }
                }

            });

            zipBtn.addSelectionListener(new SelectionListener() {

                public void widgetDefaultSelected(SelectionEvent e) {

                }

                public void widgetSelected(SelectionEvent e) {
                    zip.setEnabled(zipBtn.getSelection());
                    exchangeBtn.setEnabled(zipBtn.getSelection());
                    checkUpExchangeImport(false);
                    checkCompleted();
                }
            });
            // zip.getButton().addListener(SWT.Selection, new PageListener(this));
            folder.getText().addListener(SWT.Modify, new PageListener(this));
            // folder.getButton().addListener(SWT.Selection, new PageListener(this));
            // create viewer
            createViewer();
            Composite itemcom = treeViewer.createItemList(composite);
            treeViewer.getViewer().setInput(null);
            itemcom.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 5));
            treeViewer.setItemText("Select items to import:");

            folder.setEnabled(folderBtn.getSelection());
            zip.setEnabled(zipBtn.getSelection());

            createOverwriteBtn(composite);

            GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(920, 600).applyTo(composite);
        }

        protected void refreshTree() {

        }

    }

    /**
     * @author ymli edit the path of picture fix 0016875
     * @param orignalPicturepath
     * @param targetPicturePath
     * @return
     */
    private static String updatePicturePath(String orignalPicturepath, String pictureName, String targetPicturePath) {
        String pictureName1 = pictureName.replace("-", "/");//$NON-NLS-1$//$NON-NLS-2$
        return orignalPicturepath.replaceAll(pictureName1, targetPicturePath.substring(targetPicturePath.indexOf("/") + 1));//$NON-NLS-1$
    }

    protected void createViewer() {
        treeViewer = new RepositoryCheckTreeViewer(sel);
    }
}
