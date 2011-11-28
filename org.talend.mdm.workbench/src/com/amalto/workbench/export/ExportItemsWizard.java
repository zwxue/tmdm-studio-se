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
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.exolab.castor.xml.Marshaller;
import org.talend.mdm.commmon.util.workbench.ZipToFile;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.utils.LocalTreeObjectRepository;
import com.amalto.workbench.utils.ResourcesUtil;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.webservices.WSAutoIncrement;
import com.amalto.workbench.webservices.WSDataCluster;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDataModel;
import com.amalto.workbench.webservices.WSDataModelPK;
import com.amalto.workbench.webservices.WSGetDataCluster;
import com.amalto.workbench.webservices.WSGetDataModel;
import com.amalto.workbench.webservices.WSGetItem;
import com.amalto.workbench.webservices.WSGetItemPKsByCriteria;
import com.amalto.workbench.webservices.WSGetMenu;
import com.amalto.workbench.webservices.WSGetRole;
import com.amalto.workbench.webservices.WSGetRoutingRule;
import com.amalto.workbench.webservices.WSGetStoredProcedure;
import com.amalto.workbench.webservices.WSGetSynchronizationPlan;
import com.amalto.workbench.webservices.WSGetTransformerV2;
import com.amalto.workbench.webservices.WSGetUniverse;
import com.amalto.workbench.webservices.WSGetView;
import com.amalto.workbench.webservices.WSItem;
import com.amalto.workbench.webservices.WSItemPKsByCriteriaResponseResults;
import com.amalto.workbench.webservices.WSMenu;
import com.amalto.workbench.webservices.WSMenuPK;
import com.amalto.workbench.webservices.WSRole;
import com.amalto.workbench.webservices.WSRolePK;
import com.amalto.workbench.webservices.WSRoutingRule;
import com.amalto.workbench.webservices.WSRoutingRulePK;
import com.amalto.workbench.webservices.WSStoredProcedure;
import com.amalto.workbench.webservices.WSStoredProcedurePK;
import com.amalto.workbench.webservices.WSSynchronizationPlan;
import com.amalto.workbench.webservices.WSSynchronizationPlanPK;
import com.amalto.workbench.webservices.WSTransformerV2;
import com.amalto.workbench.webservices.WSTransformerV2PK;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.WSView;
import com.amalto.workbench.webservices.WSViewPK;
import com.amalto.workbench.webservices.XtentisPort;
import com.amalto.workbench.widgets.FileSelectWidget;
import com.amalto.workbench.widgets.RepositoryCheckTreeViewer;

public class ExportItemsWizard extends Wizard {

    private static Log log = LogFactory.getLog(ExportItemsWizard.class);

    protected IStructuredSelection sel;

    protected RepositoryCheckTreeViewer treeViewer;

    protected String exportFolder;

    protected FileSelectWidget folder;

    protected Button zipBtn;

    protected Button folderBtn;

    protected FileSelectWidget zip;

    protected String zipfile;

    public ExportItemsWizard(IStructuredSelection sel) {
        this.sel = sel;
    }

    protected Object[] getCheckedObjects() {
        return treeViewer.getCheckNodes();
    }
    @Override
    public boolean performFinish() {

        if (zipBtn.getSelection()) {
            // fix bug 0016873:clear the temp directory before zip the exported items.
            File tempFile = new File(System.getProperty("java.io.tmpdir") + "/temp/subfolder" + System.currentTimeMillis());//$NON-NLS-1$//$NON-NLS-2$
            if (tempFile.exists()) {
                File[] tempFiles = tempFile.listFiles();
                for (File file : tempFiles) {
                    file.delete();
                }
            }
            exportFolder = tempFile.getAbsolutePath();
            zipfile = zip.getText().getText();
        }
        if (folderBtn.getSelection()) {
            exportFolder = folder.getText().getText();
        }

        final Object[] objs = getCheckedObjects();
        Job job = new Job("Export ...") {

            @Override
            public IStatus run(IProgressMonitor monitor) {
                try {
                    doexport(objs, monitor);
                    return Status.OK_STATUS;
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    return Status.CANCEL_STATUS;
                } finally {
                    if (zipfile != null && new File(exportFolder).exists()) {
                        try {
                            ZipToFile.zipFile(exportFolder, zipfile);
                        } catch (Exception e) {
                            log.error(e.getMessage(), e);
                        }
                        ZipToFile.deleteDirectory(new File(exportFolder));
                    }
                }
            }
        };
        job.setPriority(Job.INTERACTIVE);
        job.schedule();
        return true;
    }

    protected void createViewer() {
        treeViewer = new RepositoryCheckTreeViewer(sel);
    }

    protected void doexport(Object[] selectedObjs, IProgressMonitor monitor) {
        TreeObject[] objs = null;
        if (selectedObjs.length > 0 && selectedObjs[0] instanceof TreeObject) {
            objs = Arrays.asList(selectedObjs).toArray(new TreeObject[0]);
        }
        if (objs == null || objs.length == 0)
            return;
        monitor.beginTask("Export ...", IProgressMonitor.UNKNOWN);
        Exports eps = new Exports();
        List<TreeObject> exports = new ArrayList<TreeObject>();
        XtentisPort port;
        try {
            port = Util.getPort(objs[0]);
            try {
                LocalTreeObjectRepository.getInstance().parseElementForOutput(objs);
            } catch (Exception e) {
            }
            for (TreeObject obj : objs) {

                StringWriter sw;
                ArrayList<String> items;
                switch (obj.getType()) {

                case TreeObject.DATA_CLUSTER:
                    monitor.subTask(" Data Container...");

                    items = new ArrayList<String>();
                    // dataclusters

                    WSDataClusterPK pk = (WSDataClusterPK) obj.getWsKey();
                    String encodedID = null;
                    try {
                        WSDataCluster cluster = port.getDataCluster(new WSGetDataCluster(pk));
                        // Marshal
                        sw = new StringWriter();
                        Marshaller.marshal(cluster, sw);
                        encodedID = URLEncoder.encode(cluster.getName(), "UTF-8");//$NON-NLS-1$
                        writeString(sw.toString(), TreeObject.DATACONTAINER + "/" + encodedID);//$NON-NLS-1$
                        items.add(TreeObject.DATACONTAINER + "/" + encodedID);//$NON-NLS-1$

                        obj.setItems(items.toArray(new String[items.size()]));
                        exports.add(obj);
                    } catch (Exception e) {
                    }
                    monitor.worked(1);
                    // datacluster contents

                    monitor.subTask(" Data Container " + pk.getPk() + " ...");

                    exportCluster(exports, pk, port);

                    monitor.worked(1);

                    break;

                case TreeObject.DATA_MODEL:
                    monitor.subTask(" Data Model...");

                    items = new ArrayList<String>();
                    // datamodels
                    try {
                        WSDataModel model = port.getDataModel(new WSGetDataModel((WSDataModelPK) obj.getWsKey()));
                        sw = new StringWriter();
                        Marshaller.marshal(model, sw);
                        encodedID = URLEncoder.encode(model.getName(), "UTF-8");//$NON-NLS-1$
                        writeString(sw.toString(), TreeObject.DATAMODEL_ + "/" + encodedID);//$NON-NLS-1$
                        items.add(TreeObject.DATAMODEL_ + "/" + encodedID);//$NON-NLS-1$
                        obj.setItems(items.toArray(new String[items.size()]));
                        exports.add(obj);
                    } catch (Exception e) {
                    }
                    monitor.worked(1);
                    break;
                case TreeObject.MENU:
                    monitor.subTask(" Menu...");
                    // ExportItem exportItem=new ExportItem();

                    items = new ArrayList<String>();
                    // menu
                    try {
                        WSMenu menu = port.getMenu(new WSGetMenu((WSMenuPK) obj.getWsKey()));
                        // Marshal
                        sw = new StringWriter();
                        Marshaller.marshal(menu, sw);
                        encodedID = URLEncoder.encode(menu.getName(), "UTF-8");//$NON-NLS-1$
                        writeString(sw.toString(), TreeObject.MENU_ + "/" + encodedID);//$NON-NLS-1$
                        items.add(TreeObject.MENU_ + "/" + encodedID);//$NON-NLS-1$

                        obj.setItems(items.toArray(new String[items.size()]));
                        exports.add(obj);
                    } catch (Exception e) {
                    }
                    monitor.worked(1);
                    break;
                case TreeObject.PICTURES_RESOURCE:
                    monitor.subTask(" Picture...");
                    // ExportItem exportItem=new ExportItem();

                    items = new ArrayList<String>();
                    // picture
                    try {
                        String picUrl = obj.getEndpointIpAddress()
                                + ResourcesUtil.getResourcesMapFromURI(obj.getEndpointIpAddress() + TreeObject.PICTURES_URI).get(
                                        obj.getDisplayName());
                        HttpClient client = new HttpClient();
                        GetMethod get = new GetMethod(picUrl);
                        client.executeMethod(get);
                        // Marshal
                        sw = new StringWriter();
                        Marshaller.marshal(get.getResponseBody(), sw);
                        encodedID = URLEncoder.encode(obj.getDisplayName(), "UTF-8");//$NON-NLS-1$
                        writeInputStream(get.getResponseBodyAsStream(), TreeObject.PICTURES_ + "/" + encodedID);
                        items.add(TreeObject.PICTURES_ + "/" + encodedID);//$NON-NLS-1$

                        obj.setItems(items.toArray(new String[items.size()]));
                        exports.add(obj);
                    } catch (Exception e) {
                    }
                    monitor.worked(1);
                    break;
                case TreeObject.ROLE:
                    if (Util.IsEnterPrise()) {
                        monitor.subTask(" Role...");
                        // ExportItem exportItem=new ExportItem();

                        items = new ArrayList<String>();

                        // role
                        try {
                            WSRole role = port.getRole(new WSGetRole((WSRolePK) obj.getWsKey()));
                            // Marshal
                            sw = new StringWriter();
                            Marshaller.marshal(role, sw);
                            encodedID = URLEncoder.encode(role.getName(), "UTF-8");//$NON-NLS-1$
                            writeString(sw.toString(), TreeObject.ROLE_ + "/" + encodedID);//$NON-NLS-1$
                            items.add(TreeObject.ROLE_ + "/" + encodedID);//$NON-NLS-1$

                            obj.setItems(items.toArray(new String[items.size()]));
                            exports.add(obj);
                        } catch (Exception e) {
                        }
                        monitor.worked(1);
                    }
                    break;
                case TreeObject.ROUTING_RULE:
                    monitor.subTask(" Trigger...");
                    // ExportItem exportItem=new ExportItem();

                    items = new ArrayList<String>();
                    // routing rule
                    try {
                        WSRoutingRule RoutingRule = port.getRoutingRule(new WSGetRoutingRule((WSRoutingRulePK) obj.getWsKey()));
                        // Marshal
                        sw = new StringWriter();
                        Marshaller.marshal(RoutingRule, sw);
                        encodedID = URLEncoder.encode(RoutingRule.getName(), "UTF-8");//$NON-NLS-1$
                        writeString(sw.toString(), TreeObject.ROUTINGRULE_ + "/" + encodedID);//$NON-NLS-1$
                        items.add(TreeObject.ROUTINGRULE_ + "/" + encodedID);//$NON-NLS-1$
                        obj.setItems(items.toArray(new String[items.size()]));
                        exports.add(obj);
                    } catch (Exception e) {
                    }
                    monitor.worked(1);
                    break;
                case TreeObject.STORED_PROCEDURE:
                    monitor.subTask(" Stored Procedure...");

                    items = new ArrayList<String>();
                    // stored procedure
                    try {
                        WSStoredProcedure StoredProcedure = port.getStoredProcedure(new WSGetStoredProcedure(
                                (WSStoredProcedurePK) obj.getWsKey()));
                        // Marshal
                        sw = new StringWriter();
                        Marshaller.marshal(StoredProcedure, sw);
                        encodedID = URLEncoder.encode(StoredProcedure.getName(), "UTF-8");//$NON-NLS-1$
                        writeString(sw.toString(), TreeObject.STOREDPROCEDURE_ + "/" + encodedID);//$NON-NLS-1$
                        items.add(TreeObject.STOREDPROCEDURE_ + "/" + encodedID);//$NON-NLS-1$

                        obj.setItems(items.toArray(new String[items.size()]));
                        exports.add(obj);
                    } catch (Exception e) {
                    }
                    monitor.worked(1);
                    break;
                case TreeObject.SYNCHRONIZATIONPLAN:
                    if (Util.IsEnterPrise()) {
                        monitor.subTask(" Synchronization Plan...");

                        items = new ArrayList<String>();
                        // Synchronizationplan
                        try {
                            WSSynchronizationPlan SynchronizationPlan = port.getSynchronizationPlan(new WSGetSynchronizationPlan(
                                    (WSSynchronizationPlanPK) obj.getWsKey()));
                            // Marshal
                            sw = new StringWriter();
                            Marshaller.marshal(SynchronizationPlan, sw);
                            encodedID = URLEncoder.encode(SynchronizationPlan.getName(), "UTF-8");//$NON-NLS-1$
                            writeString(sw.toString(), TreeObject.SYNCHRONIZATIONPLAN_ + "/" + encodedID);//$NON-NLS-1$
                            items.add(TreeObject.SYNCHRONIZATIONPLAN_ + "/" + encodedID);//$NON-NLS-1$

                            obj.setItems(items.toArray(new String[items.size()]));
                            exports.add(obj);
                        } catch (Exception e) {
                        }
                        monitor.worked(1);
                    }
                    break;
                case TreeObject.TRANSFORMER:
                    monitor.subTask(" Process...");

                    items = new ArrayList<String>();
                    // transformer
                    // TODO:check the pk
                    try {
                        WSTransformerV2 transformer = port.getTransformerV2(new WSGetTransformerV2(new WSTransformerV2PK(
                                ((WSTransformerV2PK) obj.getWsKey()).getPk())));
                        // Marshal
                        sw = new StringWriter();
                        Marshaller.marshal(transformer, sw);
                        encodedID = URLEncoder.encode(transformer.getName(), "UTF-8");//$NON-NLS-1$
                        writeString(sw.toString(), TreeObject.TRANSFORMER_ + "/" + encodedID);//$NON-NLS-1$
                        items.add(TreeObject.TRANSFORMER_ + "/" + encodedID);//$NON-NLS-1$

                        obj.setItems(items.toArray(new String[items.size()]));
                        exports.add(obj);
                    } catch (Exception e) {
                    }
                    monitor.worked(1);
                    break;
                case TreeObject.UNIVERSE:
                    if (Util.IsEnterPrise()) {
                        monitor.subTask(" Version...");

                        items = new ArrayList<String>();
                        // universe
                        try {
                            WSUniverse universe = port.getUniverse(new WSGetUniverse((WSUniversePK) obj.getWsKey()));
                            // Marshal
                            sw = new StringWriter();
                            Marshaller.marshal(universe, sw);
                            encodedID = URLEncoder.encode(universe.getName(), "UTF-8");//$NON-NLS-1$
                            writeString(sw.toString(), TreeObject.UNIVERSE_ + "/" + encodedID);//$NON-NLS-1$
                            items.add(TreeObject.UNIVERSE_ + "/" + encodedID);//$NON-NLS-1$

                            obj.setItems(items.toArray(new String[items.size()]));
                            exports.add(obj);
                        } catch (Exception e) {
                        }
                        monitor.worked(1);
                    }
                    break;
                case TreeObject.VIEW:
                    monitor.subTask(" View...");

                    items = new ArrayList<String>();
                    // view
                    try {
                        WSView View = port.getView(new WSGetView((WSViewPK) obj.getWsKey()));
                        // Marshal
                        sw = new StringWriter();
                        Marshaller.marshal(View, sw);
                        encodedID = URLEncoder.encode(View.getName(), "UTF-8");//$NON-NLS-1$
                        writeString(sw.toString(), TreeObject.VIEW_ + "/" + encodedID);//$NON-NLS-1$
                        items.add(TreeObject.VIEW_ + "/" + encodedID);//$NON-NLS-1$

                        obj.setItems(items.toArray(new String[items.size()]));
                        exports.add(obj);
                    } catch (Exception e) {
                    }
                    monitor.worked(1);
                    break;
                // add by ymli;fix the bug:0012771
                case TreeObject.WORKFLOW_PROCESS:
                    monitor.subTask("WORKFLOW_PROCESS...");
                    items = new ArrayList<String>();
                    String workflowURL = obj.getEndpointIpAddress() + TreeObject.BARFILE_URI + obj.getDisplayName();
                    try {
                        DefaultHttpClient httpclient = new DefaultHttpClient();
                        httpclient.getCredentialsProvider().setCredentials(
                                new AuthScope(obj.getEndpointHost(), Integer.valueOf(obj.getEndpointPort())),
                                new UsernamePasswordCredentials("admin", "talend"));//$NON-NLS-1$//$NON-NLS-2$
                        HttpGet httpget = new HttpGet(workflowURL);
                        // System.out.println("executing request" + httpget.getRequestLine());
                        HttpResponse response = httpclient.execute(httpget);
                        HttpEntity entity = response.getEntity();
                        // entity.getContent();
                        encodedID = URLEncoder.encode(obj.getDisplayName(), "UTF-8");//$NON-NLS-1$
                        String filename = TreeObject.BARFILE_PATH + encodedID + ".bar";//$NON-NLS-1$
                        writeInputStream(entity.getContent(), filename);
                        items.add(filename);
                        obj.setItems(items.toArray(new String[items.size()]));
                        exports.add(obj);
                    } catch (Exception e) {
                        monitor.worked(1);
                    }
                }
            }
            // store the content xml
            eps.setItems(exports.toArray(new TreeObject[exports.size()]));
            eps.setSchemas(LocalTreeObjectRepository.getInstance().outPutSchemas());
            // export autoincrement
            try {
                WSAutoIncrement auto = port.getAutoIncrement(null);
                if (auto != null && auto.getAutoincrement() != null) {
                    eps.setAutoIncrement(auto.getAutoincrement());
                }
            } catch (Exception e) {
            }
            StringWriter sw = new StringWriter();
            try {
                Marshaller.marshal(eps, sw);
                writeString(sw.toString(), "exportitems.xml");//$NON-NLS-1$
            } catch (Exception e) {
            }
            monitor.done();
        } catch (Exception e) {

        }
    }

    // add by ymli;fix the bug:0012771
    private void writeInputStream(InputStream inputSteam, String filename) {
        try {
            File f = new File(exportFolder + "/" + filename);//$NON-NLS-1$
            if (!f.getParentFile().getParentFile().exists()) {
                f.getParentFile().getParentFile().mkdir();
            }
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdir();
            }

            FileOutputStream output = new FileOutputStream(f);

            IOUtils.copy(inputSteam, output);
            output.close();
            inputSteam.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    protected void writeString(String outputStr, String filename) {
        try {
            File f = new File(exportFolder + "/" + filename);//$NON-NLS-1$
            if (!f.getParentFile().getParentFile().exists()) {
                f.getParentFile().getParentFile().mkdir();
            }
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdir();
            }
            FileOutputStream fo = new FileOutputStream(f);
            IOUtils.write(outputStr, fo, "UTF-8");//$NON-NLS-1$
            fo.flush();
            fo.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void addPages() {

        addPage(new SelectItemsPage());
    }

    class PageListener implements Listener {

        SelectItemsPage page;

        PageListener(SelectItemsPage page) {
            this.page = page;
        }

        public void handleEvent(Event event) {
            page.checkCompleted();
        }
    };

    public void checkCompleted() {

    }

    class SelectItemsPage extends WizardPage {

        protected SelectItemsPage() {
            super("SelectItemsPage");
            setTitle("Select items to export");
            // setDescription("Please select items to export");

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
            composite.setLayout(new GridLayout(3, false));
            folderBtn = new Button(composite, SWT.RADIO);
            folderBtn.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 1, 1));
            folderBtn.setText("Select root directory:");
            folder = new FileSelectWidget(composite, "", new String[] { "*.*" }, "", false, SWT.SAVE);//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
            folder.getCmp().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

            folderBtn.addSelectionListener(new SelectionListener() {

                public void widgetDefaultSelected(SelectionEvent e) {

                }

                public void widgetSelected(SelectionEvent e) {
                    folder.setEnabled(folderBtn.getSelection());
                    checkCompleted();
                }
            });

            zipBtn = new Button(composite, SWT.RADIO);
            zipBtn.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 1, 1));
            zipBtn.setText("Select archive file:");
            zip = new FileSelectWidget(composite, "", new String[] { "*.zip" }, "", true, SWT.SAVE);//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
            zip.getCmp().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
            zipBtn.addSelectionListener(new SelectionListener() {

                public void widgetDefaultSelected(SelectionEvent e) {

                }

                public void widgetSelected(SelectionEvent e) {
                    zip.setEnabled(zipBtn.getSelection());
                    checkCompleted();
                }
            });
            zip.getText().addListener(SWT.Modify, new PageListener(this));
            zip.getButton().addListener(SWT.Selection, new PageListener(this));
            folder.getText().addListener(SWT.Modify, new PageListener(this));
            folder.getButton().addListener(SWT.Selection, new PageListener(this));
            // create viewer
            createViewer();
            Composite itemcom = initItemTreeViewer(composite);
            itemcom.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 5));

            folder.setEnabled(folderBtn.getSelection());
            zip.setEnabled(zipBtn.getSelection());
            setControl(composite);
        }

    }

    protected Composite initItemTreeViewer(Composite composite) {
        Composite returnComposite = treeViewer.createItemList(composite);
        treeViewer.setItemText("Select items to export:");
        return returnComposite;
    }

    protected TreeObject exportCluster(List<TreeObject> exports, WSDataClusterPK pk, XtentisPort port) {
        String encodedID = null;
        try {
            List<String> items1 = new ArrayList<String>();
            WSItemPKsByCriteriaResponseResults[] results = port.getItemPKsByCriteria(
                    new WSGetItemPKsByCriteria(pk, null, null, null, (long) -1, (long) -1, 0, Integer.MAX_VALUE)).getResults();
            if (results == null)
                return null;
            for (WSItemPKsByCriteriaResponseResults item : results) {
                if (item.getWsItemPK().getIds() == null)
                    continue;
                WSItem wsitem = port.getItem(new WSGetItem(item.getWsItemPK()));

                // Marshal
                StringWriter sw1 = new StringWriter();
                Marshaller.marshal(wsitem, sw1);

                String uniqueId = pk.getPk() + "." + wsitem.getConceptName();//$NON-NLS-1$
                for (String id : wsitem.getIds()) {
                    uniqueId = uniqueId + "." + id;//$NON-NLS-1$
                }
                encodedID = URLEncoder.encode(uniqueId, "UTF-8");//$NON-NLS-1$
                writeString(sw1.toString(), TreeObject.DATACONTAINER_COTENTS + "/" + pk.getPk() + "/" + encodedID);//$NON-NLS-1$//$NON-NLS-2$
                items1.add(TreeObject.DATACONTAINER_COTENTS + "/" + pk.getPk() + "/" + encodedID);//$NON-NLS-1$//$NON-NLS-2$
            }
            TreeObject obj1 = new TreeObject(pk.getPk(), null, TreeObject.DATA_CLUSTER_CONTENTS, null, null);//$NON-NLS-1$
            obj1.setItems(items1.toArray(new String[items1.size()]));
            exports.add(obj1);
            return obj1;
        } catch (Exception e) {
        }
        return null;
    }

    private Matcher filter(String name) {
        Pattern bracket = Pattern.compile("(.*?)(\\s*)\\[(\\w+)\\]");//$NON-NLS-1$
        Matcher matcher = bracket.matcher(name);
        return matcher;
    }

}
