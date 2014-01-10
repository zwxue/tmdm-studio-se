// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
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

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPartSite;
import org.talend.core.GlobalServiceRegister;

import com.amalto.workbench.i18n.Messages;
import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.service.ILegendServerDefService;
import com.amalto.workbench.utils.LineItem;
import com.amalto.workbench.utils.MDMServerDef;
import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.WidgetUtils;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSDataCluster;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSGetDataCluster;
import com.amalto.workbench.webservices.WSGetItem;
import com.amalto.workbench.webservices.WSItem;
import com.amalto.workbench.webservices.WSItemPK;
import com.amalto.workbench.webservices.WSRegexDataClusterPKs;
import com.amalto.workbench.webservices.XtentisPort;


/**
 * created by liusongbo on 2013-1-24
 *
 */
public class DataClusterDialog extends Dialog {

    private static final Log log = LogFactory.getLog(DataClusterDialog.class);

    private TreeObject model;

    private MDMServerDef oldServerDef = null;

    private Text textViewer;

    private ComboViewer serverComboViewer;

    private ComboViewer containerComboViewer;

    private DataClusterComposite clusterComposite;

    private String recordContent;

    private IWorkbenchPartSite site;

    private Color defaultColor;

    private Color greyColor = Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);

    private List<TreeObject> dataContainers;

    public DataClusterDialog(Shell parentShell, TreeObject treeObject, IWorkbenchPartSite site) {
        super(parentShell);
        this.model = treeObject;
        this.site = site;
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setSize(600, 550);
        newShell.setText(Messages.DataClusterDialog_0);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        //
        createFirstLine(parent);

        createLastPortion(parent);

        hookService();

        return parent;
    }

    private void createFirstLine(Composite parent) {
        Composite firstLine = new Composite(parent, SWT.NONE);
        firstLine.setLayout(new GridLayout(4, false));
        firstLine.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        Label serverLabel = new Label(firstLine, SWT.NONE);
        serverLabel.setText(Messages.DataClusterDialog_1);
        serverLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));

        serverComboViewer = new ComboViewer(firstLine, SWT.DROP_DOWN | SWT.READ_ONLY);
        Combo combo = serverComboViewer.getCombo();
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        data.widthHint = 200;
        combo.setLayoutData(data);
        serverComboViewer.setLabelProvider(new LabelProvider() {

            @Override
            public String getText(Object element) {
                MDMServerDef serverDef = (MDMServerDef) element;
                return serverDef.getName() + " (" + serverDef.getHost() + ")"; //$NON-NLS-1$ //$NON-NLS-2$;
            }
        });
        serverComboViewer.setContentProvider(new ArrayContentProvider());

        ILegendServerDefService serverDefService = (ILegendServerDefService) GlobalServiceRegister.getDefault().getService(
                ILegendServerDefService.class);
        List<MDMServerDef> allServerDefs = serverDefService.getLegendServerDefs();
        serverComboViewer.setInput(allServerDefs);

        Label containerLabel = new Label(firstLine, SWT.NONE);
        containerLabel.setText(Messages.DataClusterDialog_2);
        containerLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));

        containerComboViewer = new ComboViewer(firstLine, SWT.DROP_DOWN | SWT.READ_ONLY);
        Combo containerCombo = containerComboViewer.getCombo();
        GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        layoutData.widthHint = 200;
        containerCombo.setLayoutData(layoutData);
        containerComboViewer.setLabelProvider(new LabelProvider() {

            @Override
            public String getText(Object element) {
                TreeObject treeObj = (TreeObject) element;

                return treeObj.getName();
            }
        });

        containerComboViewer.setContentProvider(new ArrayContentProvider());
        containerComboViewer.setInput(new TreeObject[0]);
        containerComboViewer.getCombo().setEnabled(false);
    }

    private void createLastPortion(Composite parent) {
        Group group = new Group(parent, SWT.NONE);
        group.setText(Messages.DataClusterDialog_3);
        group.setLayout(new GridLayout());
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        clusterComposite = new DataClusterComposite(group, SWT.NONE, model, site);
        clusterComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        clusterComposite.setEnabled(false);

        new Label(group, SWT.NONE);
        Label recordContentLabel = new Label(group, SWT.NONE);
        recordContentLabel.setText(Messages.DataClusterDialog_4);

        textViewer = new Text(group, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
        textViewer.setEditable(false);
        textViewer.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
        textViewer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        defaultColor = clusterComposite.getBackground();

        changeWidgetColor(greyColor);
    }

    private void hookService() {
        serverComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                refreshDataContainerCombo();

                MDMServerDef serverDef = getSelectedMdmServerDef();
                if (serverDef != oldServerDef) {
                    oldServerDef = serverDef;
                    clusterComposite.changeToServer(serverDef);

                    changeWidgetColor(greyColor);
                }
            }
        });

        containerComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection ssel = (IStructuredSelection) containerComboViewer.getSelection();
                TreeObject dataContainer = (TreeObject) ssel.getFirstElement();
                boolean refreshed = clusterComposite.changeToDataContainer(dataContainer);

                if (refreshed)
                    changeWidgetColor(defaultColor);
                else {
                    changeWidgetColor(greyColor);
                    containerComboViewer.setInput(dataContainers);
                }

                model = clusterComposite.getDataContainer();
            }
        });

        TableViewer resultsViewer = clusterComposite.getResultsViewer();
        resultsViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection structedSelection = (IStructuredSelection) event.getSelection();
                LineItem lineItem = (LineItem) structedSelection.getFirstElement();

                showInTextWidget(lineItem);
            }
        });
    }

    private void changeWidgetColor(Color color) {
        WidgetUtils.changeWidgetColor(clusterComposite, color, new boolean[] { true, false });
        textViewer.setBackground(color);
    }

    private void showInTextWidget(LineItem lineItem) {
        if (lineItem == null) {
            textViewer.setText(""); //$NON-NLS-1$
            recordContent = ""; //$NON-NLS-1$
            return;
        }

        try {
            final XtentisPort port = Util.getPort(model);
            final WSItem wsItem = port.getItem(new WSGetItem(new WSItemPK((WSDataClusterPK) model.getWsKey(), lineItem
                    .getConcept().trim(), lineItem.getIds())));
            recordContent = Util.formatXsdSource(wsItem.getContent());
            textViewer.setText(recordContent);
        } catch (RemoteException e) {
            log.error(e.getMessage(), e);
        } catch (XtentisException e) {
            log.error(e.getMessage(), e);
            MessageDialog.openError(getShell(), Messages._Error,
                    Messages.bind(Messages.DataClusterBrowserMainPage_36, e.getLocalizedMessage()));
        }
    }

    private boolean refreshDataContainerCombo() {
        dataContainers = new ArrayList<TreeObject>();
        boolean sucessed = getAllDataContainers(dataContainers);
        containerComboViewer.setInput(dataContainers);
        containerComboViewer.getCombo().setEnabled(sucessed);

        return sucessed;
    }

    private boolean getAllDataContainers(List<TreeObject> dataContainers) {
        MDMServerDef serverDef = getSelectedMdmServerDef();

        String universe = serverDef.getUniverse();
        String username = serverDef.getUser();
        String password = serverDef.getPasswd();
        String serverName = serverDef.getName();
        String endpointaddress = serverDef.getUrl();


        boolean canConnect = checkConnection(endpointaddress, username, password, universe);
        if (!canConnect) {
            MessageDialog.openError(site.getShell(), Messages.DataClusterDialog_7,
                    Messages.DataClusterDialog_8);
            return false;
        }

        WSDataClusterPK[] xdcPKs = null;
        try {
            XtentisPort port = Util.getPort(new URL(endpointaddress), universe, username, password);
            TreeParent serverRoot = new TreeParent(serverName, null, TreeObject._SERVER_, endpointaddress,
                    ("".equals(universe) ? ""//$NON-NLS-1$//$NON-NLS-2$
                            : universe + "/") + username + ":" + (password == null ? "" : password));//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$

            xdcPKs = port.getDataClusterPKs(new WSRegexDataClusterPKs("")).getWsDataClusterPKs();//$NON-NLS-1$
            for (int i = 0; i < xdcPKs.length; i++) {
                String name = xdcPKs[i].getPk();
                if (!("CACHE".equals(name))) { //$NON-NLS-1$
                    WSDataCluster wsObject = null;
                    boolean retriveWSObject = false;
                    try {
                        if (retriveWSObject)
                            wsObject = port.getDataCluster(new WSGetDataCluster(xdcPKs[i]));
                        TreeObject obj = new TreeObject(name, serverRoot, TreeObject.DATA_CLUSTER, xdcPKs[i], wsObject);
                        dataContainers.add(obj);
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }

        return true;
    }

    private boolean checkConnection(String endpointaddress, String username, String password, String universe) {
        ILegendServerDefService serverDefService = (ILegendServerDefService) GlobalServiceRegister.getDefault().getService(
                ILegendServerDefService.class);
        return serverDefService.checkServerDefConnection(endpointaddress, username, password, universe);
    }

    private MDMServerDef getSelectedMdmServerDef() {
        IStructuredSelection structuredSelection = (IStructuredSelection) serverComboViewer.getSelection();
        return (MDMServerDef) structuredSelection.getFirstElement();
    }

    @Override
    protected void okPressed() {
        recordContent = textViewer.getText().trim();
        super.okPressed();
    }

    public Text getText() {
        return textViewer;
    }

    public String getRecordContent() {
        return recordContent;
    }
}
